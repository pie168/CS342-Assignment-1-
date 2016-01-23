
public class Player {
	
	public Card[] playerHand;
	private String name;
	
	public Player()
	{
		this.playerHand = new Card[7];
		this.name = "Default";
	}
	
	public Player(String inputName)
	{
		this.playerHand = new Card[7];
		this.name = inputName;
	}

}
