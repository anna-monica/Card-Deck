

class Card {

    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {

        switch (value) {
            case 14:
                return "Ace of " + suit;
            case 13:
                return "King of " + suit;
            case 12:
                return "Queen of " + suit;
            case 11:
                return "Jack of " + suit;
            default:
                return value + " of " + suit;
        }
    }

}