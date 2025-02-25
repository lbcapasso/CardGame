import java.util.ArrayList;
import java.util.Scanner;

public class ActualGame
{


        private Scanner input = new Scanner(System.in);
        private Scanner bluff = new Scanner(System.in);
        private ArrayList<Card> pile = new ArrayList<>();
        private String bluffing;
        private boolean guessedBluff;
        private boolean won = false;
        private boolean lying = false;
        int playCard;
        private String gameTable;
        private String[] tableTypes = {"Jack", "Queen", "King", "Ace"};
        private GameViewer window;

        private Player one = new Player("Player One");
        private Player two = new Player("Player Two");
        private Player three = new Player("Player Three");
        private Player four = new Player("Player Four");

        public Player playGame()
        {
            window = new GameViewer(this);
            Deck mainDeck = new Deck(new String[]{"Jack", "Jack", "Jack", "Jack", "Jack", "Jack", "Queen", "Queen", "Queen", "Queen", "Queen", "Queen","King", "King", "King", "King", "King", "King","Ace", "Ace", "Ace", "Ace", "Ace", "Ace"}, new String[]{"Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds"}, new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4}, window);

            for (int i = 0; i < 5; i++)
            {
                if (one.isAlive()) one.addCards(mainDeck.deal());
                if (two.isAlive()) two.addCards(mainDeck.deal());
                if (three.isAlive()) three.addCards(mainDeck.deal());
                if (four.isAlive()) four.addCards(mainDeck.deal());
            }

            System.out.println("Welcome To Liar's Deck. At the start of each round, every person will be dealt 5 cards and will start with 3 lives");
            System.out.println("Every round the table will be selected. if you place a card that matches the table, then you are safe, but if you don't and someone calls it, you lose a life");
            System.out.println("Be last to die or first to get rid of all cards to win");
            window.repaint();
            while (!won)
            {


                gameTable = tableTypes[(int) (Math.random() * 4)];
                System.out.println("This is a " + gameTable + " table.");
                window.repaint();

                processTurn(one, mainDeck);
                if (won) return one;

                processTurn(two, mainDeck);
                if (won) return two;

                processTurn(three, mainDeck);
                if (won) return three;

                processTurn(four, mainDeck);
                if (won) return four;
            }
            return null;
        }

        private void processTurn(Player player, Deck deck) {
            if (!player.isAlive()) return;

            System.out.println(player.getName() + "'s turn.");
            System.out.println("These are your cards:\n" + player.getHand());
            System.out.println("Which card will you play?");
            window.repaint();
            playCard = input.nextInt();
            while (playCard > player.getHandSize() - 1)
            {
                System.out.println("Which card will you play?");
                window.repaint();
                playCard = input.nextInt();
            }


            Card playedCard = player.getCard(playCard);
            pile.add(playedCard);

            guessedBluff = false;


            for (Player opponent : new Player[]{one, two, three, four})
            {
                if (opponent == player || !opponent.isAlive()) continue;

                System.out.println("Does " + opponent.getName() + " think " + player.getName() + " is lying? (yes/no)");
                window.repaint();
                bluffing = bluff.nextLine();

                if (bluffing.equalsIgnoreCase("yes"))
                {
                    if (!playedCard.getRank().equals(gameTable))
                    {
                        System.out.println(player.getName() + " was lying! " + player.getName() + " loses one life.");
                        window.repaint();
                        player.removeLives();
                    } else
                    {
                        System.out.println(opponent.getName() + " was wrong! " + opponent.getName() + " loses one life.");
                        window.repaint();
                        opponent.removeLives();
                    }


                    if (player.getLives() == 0)
                    {
                        System.out.println(player.getName() + " has died.");
                        window.repaint();
                        player.kill();
                    }
                    if (opponent.getLives() == 0)
                    {
                        System.out.println(opponent.getName() + " has died.");
                        window.repaint();
                        opponent.kill();
                    }
                    break;
                }
            }


            player.removeCard(playCard);


            if (player.getHandSize() == 0)
            {
                System.out.println(player.getName() + " wins!");
                window.repaint();
                won = true;
            }
        }

    public static void main(String[] args)
    {
        ActualGame game = new ActualGame();
        Player winner = game.playGame();
    }
}
