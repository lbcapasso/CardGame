import java.util.ArrayList;

public class Deck {
    private int cardsLeft; // Number of remaining cards
    private ArrayList<Card> cards; // List of cards

    public Deck(String[] rank, String[] suits, int[] values)
    {
        this.cards = new ArrayList<Card>(); // Initialize the card list
        this.cardsLeft = rank.length * suits.length; // Initialize number of cards based on ranks and suits

        // Create cards for each rank, suit, and value
        for (int i = 0; i < suits.length; i++)
        {
            for (int j = 0; j < rank.length; j++)
            {
                Card newCard = new Card(rank[j], suits[i], values[j]);
                cards.add(newCard);
            }
        }
    }

    // Check if the deck is empty
    public boolean isEmpty()
    {
        return cardsLeft == 0;
    }

    // Get the number of remaining cards in the deck
    public int getCardsLeft()
    {
        return cardsLeft;
    }

    // Deal one card from the deck
    public Card deal()
    {
        if (isEmpty())
        {
            return null; // Return null if there are no cards left
        }

        cardsLeft--; // Decrease the number of cards left
        return cards.get(cardsLeft); // Return the last card in the deck
    }

    // Shuffle the deck using the Fisher-Yates algorithm
    public void shuffle()
    {
        for (int i = cards.size() - 1; i > 0; i--)
        {
            int locator = (int) (Math.random() * (i + 1)); // Random index from 0 to i
            // Swap cards at indices i and locator
            Card temp = cards.get(i);
            cards.set(i, cards.get(locator));
            cards.set(locator, temp);
        }
    }
}
