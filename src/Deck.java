import java.util.ArrayList;

public class Deck {
    private int cardsLeft;
    private ArrayList<Card> cards;

    public Deck(String[] rank, String[] suits, int[] values, GameViewer w)
    {
        this.cards = new ArrayList<Card>();
        this.cardsLeft = rank.length * suits.length;

        for (int j = 0; j < rank.length; j++)
        {
            for (int i = 0; i < suits.length; i++)
            {
                Card newCard = new Card(rank[j], suits[i], values[j], w );
                cards.add(newCard);
            }
        }
    }


    public boolean isEmpty()
    {
        return cardsLeft == 0;
    }


    public int getCardsLeft()
    {
        return cardsLeft;
    }


    public Card deal()
    {
        if (isEmpty())
        {
            return null;
        }

        cardsLeft--;
        return cards.get(cardsLeft);
    }


    public void shuffle()
    {
        for (int i = cards.size() - 1; i > 0; i--)
        {
            int locator = (int) (Math.random() * (i + 1));

            Card temp = cards.get(i);
            cards.set(i, cards.get(locator));
            cards.set(locator, temp);
        }
    }
}
