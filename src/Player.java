import java.util.ArrayList;

public class Player
{
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int lives;
    private int points;
    private String name;
    private boolean alive = true;

    public Player (String newName)
    {
        name = newName;
        points = 0;
        lives = 3;
        alive = true;
    }

    public void kill()
    {
        alive = false;
    }

    public void resetHand()
    {
        for (int i = 0; i < hand.size(); i++)
        {
            hand.remove(0);
        }
    }

    public boolean isAlive()
    {
        return alive;
    }

    public Player (String nName, ArrayList<Card> newHand)
    {
        name = nName;
        points = 0;
        lives = 3;
        hand = newHand;
        alive = true;
    }

    public Card getCard(int location)
    {
        return hand.get(location);
    }

    public void removeLives()
    {
        lives = lives - 1;
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
