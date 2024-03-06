package lectures._16;

public class Card
{
    final Card.Color color;
    final Card.Type type;
    int value;

    Card(Card.Color color, Card.Type type, int value) {
        this.color = color;
        this.type = type;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public enum Color {
        BLACK, RED
    }

    public enum Type {
        SPADE,
        HEART,
        CLUB,
        DIAMOND,
        JOKER
    }
}
