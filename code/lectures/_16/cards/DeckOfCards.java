package lectures._16.cards;

import java.util.ArrayList;

public class DeckOfCards
{
    ArrayList<Card> cards = new ArrayList<>();

    public DeckOfCards() {

        for (int i = 0; 13 > i; i ++) {
            this.cards.add(new Card(Card.Color.BLACK, Card.Type.SPADE, i + 1));
        }

        for (int i = 0; i < 13; i ++) {
            this.cards.add(new Card(Card.Color.RED, Card.Type.HEART, i + 1));
        }

        for (int i = 0; i < 13; i ++) {
            this.cards.add(new Card(Card.Color.BLACK, Card.Type.CLUB, i + 1));
        }

        for (int i = 0; i < 13; i ++) {
            this.cards.add(new Card(Card.Color.RED, Card.Type.DIAMOND, i + 1));
        }

        // ---------------------------

        /*
        Card.Color[] colors = {
                Card.Color.BLACK,
                Card.Color.RED,
        };

        Card.Type[] types = {
                Card.Type.SPADE,
                Card.Type.HEART,
                Card.Type.CLUB,
                Card.Type.DIAMOND,
        };

        for (int i = 0; i < 52; i ++) {
            cards.add(new Card(
                    colors[Integer.valueOf((int) (i/26.0))],
                    types[Integer.valueOf((int) (i/13.0))],
                    i%13
            ));
        }
        */

    }
}
