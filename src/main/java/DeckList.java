
import java.util.ArrayList;
import java.util.Collections;

//Deck class implemented using the Java ArrayList
//and using the Collections.shuffle() to shuffle the deck 
class DeckList implements DemoDeck {

    private ArrayList<Card> cards;
    private int cardsDealt;
    private static String[] suits = {"Clubs", " Diamonds", " Hearts ", "Spades"};

    public DeckList() {

        cards = new ArrayList<Card>();
        cardsDealt = 0;

        for (int k = 0; k < suits.length; k++) {

            for (int i = 1; i < 14; i++) {
                Card c = new Card(i + 1, suits[k]);
                cards.add(c);

            }
        }

    }

    public Card dealOneCard() throws NoCardException {
        if (cardsDealt >= cards.size()) {
            throw new NoCardException();
        } else {
            return cards.get(cardsDealt++);
        }
    }

    public void shuffle() {
        cardsDealt = 0;
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < cards.size(); i++) {
            s += cards.get(i) + "\n";
        }
        return s;
    }

}
