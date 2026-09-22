class Driver {
    public static void main(String[] args) {

        // Array to store cards
        Card[] cards = new Card[5];

        int count = 0;

        // First card
        Card c = new Card("Ace", "Spades");

        boolean duplicate = false;

        // Check against earlier cards
        for (int i = 0; i < count; i++) {
            if (c.equals(cards[i])) {
                duplicate = true;
                break;
            }
        }

        if (duplicate) {
            System.out.println("Duplicate found: " + c);
        } else {
            cards[count] = c;
            count++;
        }

        // Second card
        c = new Card("King", "Hearts");

        duplicate = false;

        for (int i = 0; i < count; i++) {
            if (c.equals(cards[i])) {
                duplicate = true;
                break;
            }
        }

        if (duplicate) {
            System.out.println("Duplicate found: " + c);
        } else {
            cards[count] = c;
            count++;
        }

        // Third card - duplicate
        c = new Card("Ace", "Spades");

        duplicate = false;

        for (int i = 0; i < count; i++) {
            if (c.equals(cards[i])) {
                duplicate = true;
                break;
            }
        }

        if (duplicate) {
            System.out.println("Duplicate found: " + c);
        } else {
            cards[count] = c;
            count++;
        }
    }
}