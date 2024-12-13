import java.util.ArrayList;
import java.util.Scanner;

public class ActualGame
{


        Scanner input = new Scanner(System.in);
        Scanner bluff = new Scanner(System.in);
        ArrayList<Card> pile = new ArrayList<>();
        private String bluffing;
        private boolean guessedBluff;
        private boolean won = false;
        private boolean lying = false;
        int playCard;
        private String gameTable;
        private String[] tableTypes = {"Jack", "Queen", "King", "Ace"};

        Player one = new Player("Player One");
        Player two = new Player("Player Two");
        Player three = new Player("Player Three");
        Player four = new Player("Player Four");

        public Player playGame()
        {
            Deck mainDeck = new Deck(new String[]{"Jack", "Jack", "Jack", "Jack", "Jack", "Jack", "Queen", "Queen", "Queen", "Queen", "Queen", "Queen","King", "King", "King", "King", "King", "King","Ace", "Ace", "Ace", "Ace", "Ace", "Ace"}, new String[]{"Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds"}, new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, });

            // Deal initial cards
            for (int i = 0; i < 5; i++)
            {
                if (one.isAlive()) one.addCards(mainDeck.deal());
                if (two.isAlive()) two.addCards(mainDeck.deal());
                if (three.isAlive()) three.addCards(mainDeck.deal());
                if (four.isAlive()) four.addCards(mainDeck.deal());
            }

            // Game loop
            while (!won)
            {
                gameTable = tableTypes[(int) (Math.random() * 4)];
                System.out.println("This is a " + gameTable + " table.");

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
            playCard = input.nextInt();

            Card playedCard = player.getCard(playCard);
            pile.add(playedCard);

            guessedBluff = false;

            // Check bluff from all other players
            for (Player opponent : new Player[]{one, two, three, four})
            {
                if (opponent == player || !opponent.isAlive()) continue;

                System.out.println("Does " + opponent.getName() + " think " + player.getName() + " is lying? (yes/no)");
                bluffing = bluff.nextLine();

                if (bluffing.equalsIgnoreCase("yes"))
                {
                    if (!playedCard.getRank().equals(gameTable))
                    {
                        System.out.println(player.getName() + " was lying! " + player.getName() + " loses one life.");
                        player.removeLives();
                    } else
                    {
                        System.out.println(opponent.getName() + " was wrong! " + opponent.getName() + " loses one life.");
                        opponent.removeLives();
                    }

                    // Check if any player died
                    if (player.getLives() == 0)
                    {
                        System.out.println(player.getName() + " has died.");
                        player.kill();
                    }
                    if (opponent.getLives() == 0)
                    {
                        System.out.println(opponent.getName() + " has died.");
                        opponent.kill();
                    }
                    break; // Exit bluff loop after first response
                }
            }

            // Remove the played card from the player's hand
            player.removeCard(playCard);

            // Check for win condition
            if (player.getHandSize() == 0)
            {
                System.out.println(player.getName() + " wins!");
                won = true;
            }
        }
}
