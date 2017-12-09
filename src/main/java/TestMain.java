
public class TestMain {

    public static void main(String[] args) {
        //Demonstrate the Deck class
        Deck deck = new Deck();
        demonstrate(deck);

        //Demonstrate the DeckList class
        DeckList deckList = new DeckList();
        demonstrate(deckList);
        
        long t1=averageShuffleTime(deck);
        long t2=averageShuffleTime(deckList);
        
        if(t1<t2){
            System.out.println("class Deck is faster than class DeckList in shuffle");}
        else
            System.out.println("class Deck is slower than class DeckList in shuffle");
        
            
    }

    public static void demonstrate(DemoDeck deck) {

        System.out.println("\n Demonstrating " + deck.getClass() + '\n');
        //53 calls to unshuffled deck gives all the cards in order then catches an exception
        System.out.println("Ordered deck: \n");
        for (int i = 0; i < 53; i++) {
            try {
                System.out.println(deck.dealOneCard());
            } catch (NoCardException e) {
                System.out.println(e);
            }
        }
        System.out.println();

        //53 calls to shuffled deck gives all the cards in random order then catches an exception
        deck.shuffle();
        System.out.println("Unordered deck: \n");
        for (int i = 0; i < 53; i++) {
            try {
                System.out.println(deck.dealOneCard());
            } catch (NoCardException e) {
                System.out.println(e);
            }
        }
    }

    public static long averageShuffleTime(DemoDeck deck) {
        long s, f;
        long reps = 50;
        long time = 0;
        for (int i = 0; i < reps; i++) {

            s = System.nanoTime();
            deck.shuffle();
            f = System.nanoTime();
            //System.out.println("Collection Suffle finished in: " + (f - s) + "ns");
            time += f - s;

        }
        System.out.println("Average shuffle time for "+deck.getClass()+" = " + (time / reps));
        return time;

    }
}

//interface just to help demonstrating two versions of the Deck
interface DemoDeck {

    public void shuffle();

    public Card dealOneCard() throws NoCardException;
}
