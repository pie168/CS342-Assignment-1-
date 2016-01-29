
public class Card{
	
	private int cardValue = 0;
	private boolean isUsed = false;
	private String rank;
	private String suit;
	private String color;
	
	public Card()
	{
		rank = "deafult";
		suit = "default";
	}
	public Card(String inputRank, String inputSuit)
	{
		this.rank = inputRank;
		this.suit = inputSuit;
		
		if(inputSuit.equals("C") || inputSuit.equals("S"))
		{
			this.color = "Black";
		}
		else 
		{
			this.color = "Red";
		}
		
		if(inputRank.equals("A"))
		{
			cardValue = 1;
		}
		else if(inputRank.equals("J"))
		{
			cardValue = 11;
		}
		else if(inputRank.equals("Q"))
		{
			cardValue = 12;
		}
		else if(inputRank.equals("K"))
		{
			cardValue = 13;
		}
		else 
		{
			int value = Integer.parseInt(inputRank);
			
			cardValue = value;
		}
	}
	
	public int getValue()
	{
		return cardValue;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void changedUse()
	{
		isUsed = true;
	}
	
	public boolean checkUsed()
	{
		return isUsed;
	}
	
	public void getCardInfo()
	{
		System.out.println("Card: " + rank + suit + " Value: " + cardValue + " Color: " + color);
	}
	
	public String toString()
	{
		return rank+suit;
	}
	

}
