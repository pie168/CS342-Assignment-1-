
public class Card{
	
	private String rank;
	private String suit;
	
	public Card()
	{
		rank = "deafult";
		suit = "default";
	}
	public Card(String inputRank, String inputSuit)
	{
		this.rank = inputRank;
		this.suit = inputSuit;
	}
	
	public void getCardInfo()
	{
		System.out.println("Card: " + rank + suit);
	}
	

}
