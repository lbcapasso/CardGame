import javax.swing.*;
import java.awt.*;

public class Card
{
    private int value;
    private Image image;
    private GameViewer window;
    private String suit;
    private String rank;
    private boolean inUse;

    public Card( String r, String s, int v, GameViewer w)
    {
        value = v;
        suit = s;
        rank = r;
        window = w;
    }


    public int getValue()
    {
        return value;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    public void setSuit(String suit)
    {
        this.suit = suit;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    @Override
    public String toString() {
        return (rank + " of " + suit);
    }


    public void draw (Graphics g)
    {

    }
}
