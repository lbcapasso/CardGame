import javax.swing.*;

public class GameViewer extends JFrame
{
    private ActualGame trueGame;
    public GameViewer(ActualGame aG)
    {
        trueGame = aG;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Card Game");
        this.setSize(1400, 810);
        this.setVisible(true);
    }
}
