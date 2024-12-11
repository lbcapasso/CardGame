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
        if(getCardsLeft() == 0)
        {
            return null;
        }
        else
        {
            return cards.get(cardsLeft);
        }
    }

    public void shuffle()
    {
        for(int i = cards.size() - 1; i > 0; i--)
        {
            int locator = (int)(Math.random() * i);
            Card endCard = cards.get(i);
            Card randomCard = cards.get(locator);
            cards.set(i, randomCard);
            cards.set(locator, endCard);
        }
    }
}
