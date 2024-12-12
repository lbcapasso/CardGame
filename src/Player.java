import java.util.ArrayList;

public class Player
{
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int lives;
    private int points;
    private String name;

    public Player (String newName)
    {
        name = newName;
        points = 0;
        lives = 3;
        hand = null;
    }
    public Player (String nName, ArrayList<Card> newHand)
    {
        name = nName;
        points = 0;
        lives = 3;
        hand = newHand;
    }

    public Card getCard(int location)
    {
        return hand.get(location);
    }

    public int getHandSize()
    {
        return hand.size();
    }
    public void addPoints(int newPoints )
    {
        points = points + newPoints;
    }

    public void removeCard(int location)
    {
        hand.remove(location);
    }
    public void addCards(Card newCard)
    {
        hand.add(newCard);
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getLives() {
        return lives;
    }


    public ArrayList<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return name + " has " + points + " points " + "\n" + name + "'s cards:" + hand;
    }
}
