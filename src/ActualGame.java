import java.util.ArrayList;
import java.util.Scanner;

public class ActualGame
{
    Scanner input = new Scanner(System.in);
    Scanner bluff = new Scanner(System.in);
    ArrayList<Card> pile = new ArrayList<Card>();
    private String bluffing;
    private boolean guessedBluff;
    private boolean won = false;
    private boolean lying = false;
    int playCard;
    private String gameTable;
    private String[] tableTypes = {"Jack's", "Queen's", "King's", "Ace's"};
    Player one = new Player("Player One");
    Player two = new Player("Player Two");
    Player three = new Player("Player Three");
    Player four = new Player("Player Four");

    public Player playGame()
    {
        while(won == false)
        {
            Deck mainDeck = new Deck(new String[]{"Jack", "Jack", "Jack","Jack", "Jack", "Jack", "Queen", "Queen", "Queen", "Queen", "Queen", "Queen", "King", "King", "King", "King", "King", "King", "Ace", "Ace", "Ace", "Ace", "Ace", "Ace", "Joker", "Joker"}, new String[] {"Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds"}, new int[]{1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,4,4,4,4,4,4,5,5,5,5,5,5,6,6});
            for (int i = 0; i < 5; i++)
            {
                one.addCards(mainDeck.deal());
                two.addCards(mainDeck.deal());
                three.addCards(mainDeck.deal());
                four.addCards(mainDeck.deal());
            }

            gameTable = tableTypes[(int)((Math.random() * 4) + 1)];
            System.out.println("This is a " + gameTable + " table");

            if (one .getLives() == 0 && one.isAlive() == true)
            {
                System.out.println(one.getName() + "has died");
                one.kill();
            }

            if (one.isAlive() == true)
            {
                System.out.println(one.getName() + "'s turn." + "\n" + "These are your Cards:" + "\n" );
                System.out.println(one.getHand());
                System.out.println("Which card will you play?");
                playCard = input.nextInt();
                pile.add(one.getCard(playCard));
                while(guessedBluff = false)
                {
                    if (two.getLives() != 0)
                    {
                        System.out.println("Does " + two.getName() + one.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& one.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(one.getName() + " was lying! " + one.getName() + " loses one life");
                            one.removeLives();
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && one.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(two.getName() + " was wrong! " + two.getName() + " loses one life");
                            two.removeLives();
                        }
                        if (two.getLives() == 0)
                        {
                            System.out.println(two.getName() + "has died");
                            two.kill();
                        }
                    }
                    if (three.getLives() != 0)
                    {
                        System.out.println("Does " + three.getName() + one.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& one.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(one.getName() + " was lying! " + one.getName() + " loses one life");
                            one.removeLives();
                            guessedBluff = true;
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && one.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(three.getName() + " was wrong! " + three.getName() + " loses one life");
                            three.removeLives();
                        }
                        if (three.getLives() == 0)
                        {
                            System.out.println(three.getName() + "has died");
                            three.kill();
                        }
                    }

                    if ( four.getLives() != 0)
                    {
                        System.out.println("Does " + four.getName() + one.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& one.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(one.getName() + " was lying! " + one.getName() + " loses one life");
                            one.removeLives();
                            guessedBluff = true;
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && one.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(four.getName() + " was wrong! " + four.getName() + " loses one life");
                            four.removeLives();
                            guessedBluff = true;
                        }
                        if (four.getLives() == 0)
                        {
                            System.out.println(four.getName() + "has died");
                            four.kill();
                        }
                    }

                    guessedBluff = true;
                }
                guessedBluff = false;
                if (one.getHandSize() == 0)
                {
                    System.out.println( one.getName() + " wins!");
                    won = true;
                    return one;
                }
            }





            if (two.getLives() == 0 && two.isAlive() == true)
            {
                System.out.println(two.getName() + "has died");
                two.kill();
            }

            if (two.isAlive() == true)
            {
                System.out.println(two.getName() + "'s turn." + "\n" + "These are your Cards:" + "\n" );
                System.out.println(two.getHand());
                System.out.println("Which card will you play?");
                playCard = input.nextInt();
                pile.add(two.getCard(playCard));
                while(guessedBluff = false)
                {
                    if (one.getLives() != 0)
                    {
                        System.out.println("Does " + one.getName() + two.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& one.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(two.getName() + " was lying! " + two.getName() + " loses one life");
                            two.removeLives();
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && two.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(one.getName() + " was wrong! " + one.getName() + " loses one life");
                            one.removeLives();
                        }
                        if (one.getLives() == 0)
                        {
                            System.out.println(one.getName() + "has died");
                            one.kill();
                        }
                    }
                    if (three.getLives() != 0)
                    {
                        System.out.println("Does " + three.getName() + two.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& two.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(two.getName() + " was lying! " + two.getName() + " loses one life");
                            two.removeLives();
                            guessedBluff = true;
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && two.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(three.getName() + " was wrong! " + three.getName() + " loses one life");
                            three.removeLives();
                        }
                        if (three.getLives() == 0)
                        {
                            System.out.println(three.getName() + "has died");
                            three.kill();
                        }
                    }

                    if ( four.getLives() != 0)
                    {
                        System.out.println("Does " + four.getName() + two.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& two.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(two.getName() + " was lying! " + two.getName() + " loses one life");
                            two.removeLives();
                            guessedBluff = true;
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && two.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(four.getName() + " was wrong! " + four.getName() + " loses one life");
                            four.removeLives();
                            guessedBluff = true;
                        }
                        if (four.getLives() == 0)
                        {
                            System.out.println(four.getName() + "has died");
                            four.kill();
                        }
                    }

                    guessedBluff = true;
                }
                guessedBluff = false;
                if (two.getHandSize() == 0)
                {
                    System.out.println( two.getName() + " wins!");
                    won = true;
                    return two;
                }
            }





            if (three .getLives() == 0 && three.isAlive() == true)
            {
                System.out.println(three.getName() + "has died");
                three.kill();
            }

            if (three.isAlive() == true)
            {
                System.out.println(three.getName() + "'s turn." + "\n" + "These are your Cards:" + "\n" );
                System.out.println(three.getHand());
                System.out.println("Which card will you play?");
                playCard = input.nextInt();
                pile.add(three.getCard(playCard));
                while(guessedBluff = false)
                {
                    if (one.getLives() != 0)
                    {
                        System.out.println("Does " + one.getName() + three.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& one.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(three.getName() + " was lying! " + three.getName() + " loses one life");
                            one.removeLives();
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && three.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(one.getName() + " was wrong! " + one.getName() + " loses one life");
                            one.removeLives();
                        }
                        if (one.getLives() == 0)
                        {
                            System.out.println(one.getName() + "has died");
                            one.kill();
                        }
                    }
                    if (two.getLives() != 0)
                    {
                        System.out.println("Does " + two.getName() + three.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& three.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(three.getName() + " was lying! " + three.getName() + " loses one life");
                            three.removeLives();
                            guessedBluff = true;
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && three.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(two.getName() + " was wrong! " + two.getName() + " loses one life");
                            two.removeLives();
                        }
                        if (two.getLives() == 0)
                        {
                            System.out.println(two.getName() + "has died");
                            two.kill();
                        }
                    }

                    if ( four.getLives() != 0)
                    {
                        System.out.println("Does " + four.getName() + three.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& three.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(three.getName() + " was lying! " + three.getName() + " loses one life");
                            three.removeLives();
                            guessedBluff = true;
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && three.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(four.getName() + " was wrong! " + four.getName() + " loses one life");
                            four.removeLives();
                            guessedBluff = true;
                        }
                        if (four.getLives() == 0)
                        {
                            System.out.println(four.getName() + "has died");
                            four.kill();
                        }
                    }

                    guessedBluff = true;
                }
                guessedBluff = false;
                if (three.getHandSize() == 0)
                {
                    System.out.println( three.getName() + " wins!");
                    won = true;
                    return three;
                }
            }





            if (four.getLives() == 0 && four.isAlive() == true)
            {
                System.out.println(four.getName() + "has died");
                four.kill();
            }

            if (four.isAlive() == true)
            {
                System.out.println(four.getName() + "'s turn." + "\n" + "These are your Cards:" + "\n" );
                System.out.println(four.getHand());
                System.out.println("Which card will you play?");
                playCard = input.nextInt();
                pile.add(four.getCard(playCard));
                while(guessedBluff = false)
                {
                    if (two.getLives() != 0)
                    {
                        System.out.println("Does " + one.getName() + four.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& four.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(four.getName() + " was lying! " + four.getName() + " loses one life");
                            four.removeLives();
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && four.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(one.getName() + " was wrong! " + one.getName() + " loses one life");
                            one.removeLives();
                        }
                        if (one.getLives() == 0)
                        {
                            System.out.println(one.getName() + "has died");
                            one.kill();
                        }
                    }
                    if (two.getLives() != 0)
                    {
                        System.out.println("Does " + two.getName() + four.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& four.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(four.getName() + " was lying! " + four.getName() + " loses one life");
                            four.removeLives();
                            guessedBluff = true;
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && four.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(two.getName() + " was wrong! " + two.getName() + " loses one life");
                            two.removeLives();
                        }
                        if (two.getLives() == 0)
                        {
                            System.out.println(two.getName() + "has died");
                            two.kill();
                        }
                    }

                    if ( three.getLives() != 0)
                    {
                        System.out.println("Does " + three.getName() + four.getName() + " is lying");
                        bluffing = bluff.nextLine();
                        if((bluffing.equals("yes") || bluffing.equals("Yes") )&& four.getCard(playCard).getRank() != gameTable)
                        {
                            System.out.println(four.getName() + " was lying! " + four.getName() + " loses one life");
                            four.removeLives();
                            guessedBluff = true;
                        }
                        else if ((bluffing.equals("yes") || bluffing.equals("Yes")) && four.getCard(playCard).getRank() == gameTable)
                        {
                            System.out.println(three.getName() + " was wrong! " + three.getName() + " loses one life");
                            three.removeLives();
                            guessedBluff = true;
                        }
                        if (three.getLives() == 0)
                        {
                            System.out.println(three.getName() + "has died");
                            three.kill();
                        }
                    }

                    guessedBluff = true;
                }
                guessedBluff = false;
                if (four.getHandSize() == 0)
                {
                    System.out.println( four.getName() + " wins!");
                    won = true;
                    return four;
                }
            }
        }
        return one;
    }

}
