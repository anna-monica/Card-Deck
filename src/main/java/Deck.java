
import java.util.Random;

class Deck implements DemoDeck{

    private Card[] cards;
    private int cardsDealt;
    private static String[] suits = {"Clubs", " Diamonds", " Hearts ", "Spades"};

    public Deck() {

        cards = new Card[52];
        cardsDealt = 0;

        int index = 0;
        for (int k = 0; k < suits.length; k++) {

            for (int i = 1; i < 14; i++) {
                Card c = new Card(i + 1, suits[k]);
                cards[index++] = c;
            }
        }

    }

    public Card dealOneCard() throws NoCardException {
        if (cardsDealt >= cards.length) {
            throw new NoCardException();
        } else {
            return cards[cardsDealt++];
        }
    }

    // the Fisher-Yates shuffle
    public void shuffle() {
        cardsDealt = 0;
        //set the seed to the current value of the running Java Virtual 
        //Machine's high-resolution time source, in nanoseconds.
        Random r = new Random(System.nanoTime());

        for (int i = cards.length - 1; i > 1; i--) {
            //random number between 0 and i
            int index = r.nextInt(i + 1);

            //exchange the cards
            Card temp = cards[i];
            cards[i] = cards[index];
            cards[index] = temp;

        }

    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < cards.length; i++) {
            s += cards[i] + "\n";
        }
        return s;
    }
}
