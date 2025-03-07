import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameViewer extends JFrame
{
    private Image ace = new ImageIcon("Resources/Cards/3.png").getImage();
    private Image jack = new ImageIcon("Resources/Cards/43.png").getImage();
    private Image queen = new ImageIcon("Resources/Cards/47.png").getImage();
    private Image king = new ImageIcon("Resources/Cards/51.png").getImage();
    private Image background = new ImageIcon("Resources/blackjack_table.jpg").getImage();
    private Player thisPlayer;

    private ActualGame trueGame;
    public GameViewer(ActualGame aG)
    {
        trueGame = aG;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Card Game");
        this.setSize(1000, 800);
        this.setVisible(true);
    }


    public void paint(Graphics g)
    {
        ArrayList<Card> thisHand = new ArrayList<Card>();
        g.drawImage(background, 0,0, 2000,800, this);
        thisPlayer = trueGame.getCurrentPlayer();
        thisHand = thisPlayer.getHand();
        for(int i = 0; i < thisHand.size(); i++)
        {
            thisHand.get(i).draw(g, i);
        }


    }

    public void paintBack(Graphics g)
    {
        ArrayList<Card> thisHand = new ArrayList<Card>();
        thisPlayer = trueGame.getCurrentPlayer();
        thisHand = thisPlayer.getHand();
        for(int i = 0; i < thisHand.size(); i++)
        {
            thisHand.get(i).drawBack(g, i);
        }


    }

    public Image getFront(Card draw)
    {
        if (draw.getRank().equals("Jack"))
        {
            return jack;
        }
        if (draw.getRank().equals("Queen"))
        {
            return queen;
        }
        if (draw.getRank().equals("King"))
        {
            return king;
        }
        if (draw.getRank().equals("Ace"))
        {
            return ace;
        }
        return null;
    }

}
