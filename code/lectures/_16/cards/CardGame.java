package lectures._16.cards;

public class CardGame
{
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();

        System.out.print("Antall kort i kortstokken: ");
        System.out.println(deck.cards.size());


        for (Card card : deck.cards) {
            System.out.println(STR."Color: \{card.color}, Type: \{card.type}, Value: \{card.value}");
        }
    }
}
