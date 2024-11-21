import java.util.ArrayList;

public class Deck
{
    private int cardsLeft = 0;
    private ArrayList<Card> cards = new ArrayList<Card>();

    private boolean inDeck = true;

    public Deck(String[] rank, String suits[], int[] value)
    {
        if (rank.length == suits.length)
        {
            for (int i = 0; i < rank.length; i++)
            {
                Card newCard = new Card(rank[i], suits[i], value[i]);
                cards.add(newCard);
                cardsLeft++;
            }
        }
    }

    public boolean isEmpty()
    {
        if (cardsLeft == 0)
        {
            return true;
        }
        return false;
    }

    public int getCardsLeft()
    {
        return cardsLeft;
    }

    public Card deal()
    {
        if ()
    }
}
