import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    Scanner input = new Scanner(System.in);
    Scanner bluff = new Scanner(System.in);
    ArrayList<Card> pile = new ArrayList<Card>();
    private String bluffing;
    private boolean won = false;
    private boolean lying = false;
    private String gameTable;
    private String[] tableTypes = {"Jack's", "Queen's", "King's", "Ace's"};
    Player one = new Player("Player One");
    Player two = new Player("Player Two");
    Player three = new Player("Player Three");
    Player four = new Player("Player Four");
    Deck mainDeck = new Deck(new String[]{"Jack", "Jack", "Jack","Jack", "Jack", "Jack", "Queen", "Queen", "Queen", "Queen", "Queen", "Queen", "King", "King", "King", "King", "King", "King", "Ace", "Ace", "Ace", "Ace", "Ace", "Ace", "Joker", "Joker"}, new String[] {"Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds"}, new int[]{1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,4,4,4,4,4,4,5,5,5,5,5,5,6,6});

    for (int i = 0; i < 5; i++)
    {
        one.addCards(mainDeck.deal());
        two.addCards(mainDeck.deal());
        three.addCards(mainDeck.deal());
        four.addCards(mainDeck.deal());
    }

    while(won == false)
    {
        gameTable = tableTypes[(int)((Math.random() * 4) + 1)];
        System.out.println("This is a " + gameTable + " table");
        System.out.println(one.getName() + "'s turn." + "\n" + "These are your Cards:" + "\n" );
        System.out.println(one.getHand());
        System.out.println("Which card will you play?");
        int playCard = input.nextInt();
        pile.add(one.getCard(playCard));
        System.out.println("Does anyone think " + one.getName() + " is lying");
        bluffing = bluff.nextLine();
        if(one.)
    }





}




