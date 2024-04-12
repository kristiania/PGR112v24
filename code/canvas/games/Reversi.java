package canvas.games;

import canvas.API;
import canvas.Launcher;
import canvas.Plugin;
import canvas.library.math.geometry.Anchor;
import canvas.library.math.geometry.Dimension;
import canvas.library.math.geometry.Point;
import canvas.library.math.geometry.Rectangle;
import canvas.library.resource.Color;

import java.util.ArrayList;
import java.util.HashMap;

/*
       Reversi, rules:

       1) Player with black pieces starts
       2) A piece can only be placed if it results in pieces being flipped
       3) If a player can not place down a piece that can cause other pieces to flip,
          instead the turn goes back other player
       4) The game is finished if there are no more empty squares,
          or, neither player can place a piece that can cause other pieces to flip
       5) After the game is finished, the winner is the player with the most pieces

*/


public class Reversi extends Plugin
{
    //# Main-method
    public static void main(String[] args) {
        Launcher.createWindow(800, 800, new Reversi());
    }

    //# Fields
    private Point center;
    private Point upperLeftCorner;
    private Piece player = Piece.BLACK;
    private final int[] pieces = { 0, 0 };
    private final Piece[][] board = new Piece[8][8];
    private final boolean[][] possibleMoves = new boolean[8][8];
    private Dimension boardSize;
    private Rectangle boardArea;
    private int boardDelta;
    private boolean cursorDown = false;
    private int turn = 1;
    private int emptyTurns = 0;
    private boolean gameFinished = false;


    private final HashMap<String, Color> colors = new HashMap<>();
    {
        this.colors.put("dark green", new Color(0x2B580C));
        this.colors.put("black", new Color(0, 0, 0));
        this.colors.put("white", new Color(255, 255, 255));
        this.colors.put("gray", new Color(127, 127, 127));
    }


    public void setup(API.Setup window) {
        this.center = window.getCenterPoint();

        this.upperLeftCorner = new Point(
                (int)(window.getHalfWidth()/2.0),
                (int)(window.getHalfHeight()/2.0)
        );

        this.boardSize = new Dimension(window.getHalfWidth(), window.getHalfHeight());
        this.boardDelta = (int)(((int)(this.boardSize.width / 8.0) + (int)(this.boardSize.height / 8.0))/2.0);
        this.boardArea = new Rectangle(this.upperLeftCorner, this.boardSize);

        for (int x = 0; x < 8; x ++) {
            for (int y = 0; y < 8; y ++) {
                this.board[x][y] = null;
            }
        }

        this.board[3][3] = Piece.WHITE;
        this.board[4][4] = Piece.WHITE;

        this.board[3][4] = Piece.BLACK;
        this.board[4][3] = Piece.BLACK;

        this.checkMoves();

        window.setBackgroundColor(this.colors.get("dark green"));

        window.onMousePress((_) -> {
            this.cursorDown = true;
        });

        window.onMouseRelease((point) -> {
            this.cursorDown = false;

            if (this.boardArea.contains(point) && !this.gameFinished) {
                this.placePiece(point);
            }
        });
    }

    private void checkMoves() {
        if (this.gameFinished) {
            return;
        }

        this.pieces[0] = this.pieces[1] = 0;

        for (int x = 0; x < 8; x ++) {
            for (int y = 0; y < 8; y ++) {
                if (this.board[x][y] != null) {
                    if (this.board[x][y].equals(Piece.BLACK)) {
                        this.pieces[0]++;
                    } else if (this.board[x][y].equals(Piece.WHITE)) {
                        this.pieces[1]++;
                    }
                }

                this.possibleMoves[x][y] = false;
            }
        }

        Piece opponent = this.getOpponentPiece();

        for (int x = 0; x < 8; x ++) {
            for (int y = 0; y < 8; y++) {
                if (this.board[x][y] != null && this.board[x][y] == this.player) {
                    for (int vx = -1; vx <= 1; vx ++) {
                        for (int vy = -1; vy <= 1; vy ++) {

                            this.checkLine(opponent, false, x, y, vx, vy);
                        }
                    }
                }
            }
        }

        int moves = 0;

        for (int x = 0; x < 8; x ++) {
            for (int y = 0; y < 8; y++) {
                if (this.possibleMoves[x][y]) {
                    moves ++;
                    break;
                }
            }
        }

        if (moves > 0) {
            this.emptyTurns = 0;
        }
        else {
            if (moves == 0) {
                this.player = this.getOpponentPiece();
                this.emptyTurns++;
                this.turn++;

                if (this.emptyTurns == 2) {
                    this.gameFinished = true;
                } else {
                    this.checkMoves();
                }
            }
        }
    }

    private void checkLine(Piece opponent, boolean flag, int px, int py, int vx, int vy) {
        int x = px + vx;
        int y = py + vy;

        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            if (this.board[x][y] == opponent) {
                this.checkLine(opponent, true, x, y, vx, vy);
            }
            else if (this.board[x][y] == null && flag) {
                this.possibleMoves[x][y] = true;
            }
        }
    }


    private void placePiece(Point point) {
        int x = this.getXFromMouseX(point.x);
        int y = this.getYFromMouseY(point.y);

        if (this.board[x][y] == null && this.possibleMoves[x][y]) {
            this.board[x][y] = this.player;

            boolean[][] piecesToFlip = new boolean[8][8];
            ArrayList<Point> flipPath = new ArrayList<>();

            for (int vx = -1; vx <= 1; vx ++) {
                for (int vy = -1; vy <= 1; vy ++) {
                    if (vx == 0 && vy == 0) {
                        continue;
                    }

                    this.flipPieces(x, y, vx, vy, false, flipPath, piecesToFlip);
                }
            }

            for (int px = 0; px < 8; px ++) {
                for (int py = 0; py < 8; py ++) {
                    if (piecesToFlip[px][py]) {
                        this.board[px][py] = this.board[px][py] == Piece.BLACK
                                ? Piece.WHITE
                                : Piece.BLACK
                        ;
                    }
                }
            }

            nextTurn();
            checkMoves();
        }
    }

    private void flipPieces(int x, int y, int vx, int vy, boolean flipping, ArrayList<Point> flipPath, boolean[][] piecesToFlip) {
        int px = x + vx;
        int py = y + vy;

        if (px >= 0 && px < 8 && py >= 0 && py < 8) {
            if (this.board[px][py] == this.getOpponentPiece()) {
                if (!flipping) {
                    flipPath.clear();
                }

                flipPath.add(new Point(px, py));

                this.flipPieces(px, py, vx, vy, true, flipPath, piecesToFlip);
            }
            else if (this.board[px][py] == this.player && flipping) {
                for (Point point : flipPath) {
                    piecesToFlip[point.x][point.y] = true;
                }
            }
        }
    }

    private Piece getOpponentPiece() {
        return this.player == Piece.BLACK
                ? Piece.WHITE
                : Piece.BLACK
        ;
    }

    private void nextTurn() {
        this.turn ++;
        this.player = this.player == Piece.BLACK ? Piece.WHITE : Piece.BLACK;
    }

    private int getXFromMouseX(int x) {
        return (x - this.upperLeftCorner.x)/this.boardDelta;
    }

    private int getYFromMouseY(int y) {
        return (y - this.upperLeftCorner.y)/this.boardDelta;
    }


    public void draw(API window) {
        window.drawTextCentered(
                this.center.x, 50,
                STR."\{this.player.equals(Piece.BLACK)
                    ? "Player 1 (BLACK)"
                    : "Player 2 (WHITE)"
                }"
        );

        window.drawTextCentered(
                this.center.x, 100,
                STR."Turn \{this.turn}"
        );

        window.drawTextCentered(
                this.center.x, window.getHeight() - 125,
                STR."BLACK: \{this.pieces[0]}"
        );

        window.drawTextCentered(
                this.center.x, window.getHeight() - 100,
                STR."WHITE: \{this.pieces[1]}"
        );

        if (this.gameFinished) {
            window.drawTextCentered(
                    this.center.x, window.getHeight() - 100,
                    STR."\{this.pieces[0] == this.pieces[1]
                            ? "TIE"
                            : STR."Game winner: \{this.pieces[0] > this.pieces[1]
                            ? "BLACK" : "WHITE"}"
                        }"
            );
        }

        this.drawBoard(window);

        if (this.cursorDown && this.boardArea.contains(window.getCursor())) {
            window.fill(this.colors.get("gray"));

            window.drawCircle(
                    this.upperLeftCorner.x + this.boardDelta*this.getXFromMouseX(window.getMouseX()),
                    this.upperLeftCorner.y + this.boardDelta*this.getYFromMouseY(window.getMouseY()),
                    25,
                    Anchor.TOP_LEFT
            );

            window.noFill();
        }
    }

    private void drawBoard(API window) {
        int x, y;

        for (int i = 0; i <= 8; i ++) {
            x = this.boardDelta*i;
            y = this.boardDelta*i;

            window.drawLine(
                    this.upperLeftCorner.x + x,
                    this.upperLeftCorner.y,
                    this.upperLeftCorner.x + x,
                    this.upperLeftCorner.y + this.boardSize.height
            );

            window.drawLine(
                    this.upperLeftCorner.x,
                    this.upperLeftCorner.y + y,
                    this.upperLeftCorner.x + this.boardSize.width,
                    this.upperLeftCorner.y + y
            );
        }

        int pDelta = (int)(this.boardDelta/2.0);

        for (int px = 0; px < 8; px ++) {
            for (int py = 0; py < 8; py ++) {
                if (this.board[px][py] != null) {
                    x = this.boardDelta*px;
                    y = this.boardDelta*py;

                    switch (this.board[px][py]) {
                        case Piece.BLACK -> {
                            window.fill(this.colors.get("black"));

                            window.drawCircle(
                                    this.upperLeftCorner.x + x + 4,
                                    this.upperLeftCorner.y + y + 4,
                                    pDelta - 4,
                                    Anchor.TOP_LEFT
                            );
                        }

                        case Piece.WHITE -> {
                            window.fill(this.colors.get("white"));

                            window.drawCircle(
                                    this.upperLeftCorner.x + x + 4,
                                    this.upperLeftCorner.y + y + 4,
                                    pDelta - 4,
                                    Anchor.TOP_LEFT
                            );
                        }
                    }
                }
                else {
                    if (this.possibleMoves[px][py]) {
                        window.noFill();

                        x = this.boardDelta*px;
                        y = this.boardDelta*py;

                        window.drawCircle(
                                this.upperLeftCorner.x + x + 4,
                                this.upperLeftCorner.y + y + 4,
                                pDelta - 4,
                                Anchor.TOP_LEFT
                        );
                    }
                }
            }
        }
    }

    enum Piece { BLACK, WHITE }
}
