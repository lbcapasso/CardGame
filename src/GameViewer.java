import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame
{
    private Image ace = new ImageIcon("Resources/Cards/3.png").getImage();
    private Image jack = new ImageIcon("Resources/Cards/43.png").getImage();
    private Image queen = new ImageIcon("Resources/Cards/47.png").getImage();
    private Image king = new ImageIcon("Resources/Cards/51.png").getImage();

    private ActualGame trueGame;
    public GameViewer(ActualGame aG)
    {
        trueGame = aG;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Card Game");
        this.setSize(1000, 800);
        this.setVisible(true);
    }
}
