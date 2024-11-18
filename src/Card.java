public class Card
{
    private int value;
    private String suit;
    private String rank;
    public Card(int v, String s, String r)
    {
        value = v;
        suit = s;
        rank = r;
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
}
