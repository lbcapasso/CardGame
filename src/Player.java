import java.util.ArrayList;

public class Player
{
    private ArrayList<Card> hand = new ArrayList<Card>();
    private boolean lives;
    private int points;
    private String name;

    public Player (String newName)
    {
        name = newName;
        points = 0;
        hand = null;
    }
    public Player (String nName, ArrayList<Card> newHand)
    {
        name = nName;
        points = 0;
        hand = newHand;
    }
    public void addPoints(int newPoints )
    {
        points = points + newPoints;
    }

    public void addCards(Card newCard)
    {
        hand.add(newCard);
    }

    @Override
    public String toString() {
        return name + " has " + points + " points " + "\n" + name + "'s cards:" + hand;
    }
}
