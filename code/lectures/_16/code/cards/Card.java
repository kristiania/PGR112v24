package lectures._16.code.cards;

public class Card
{
    Card.Color color;
    Card.Type type;

    public Card(Card.Color color, Card.Type type) {
        this.color = color;
        this.type = type;
    }

    public enum Color {
        BLACK, RED
    }

    public enum Type {
        SPADE,
        HEART,
        CLUB,
        DIAMOND
    }
}
