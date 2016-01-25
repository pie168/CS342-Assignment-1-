
public class Player {
	
	public Card[] playerHand;
	private int handSize = 7;
	private int handCounter = 0;
	private String name;
	
	public Player()
	{
		this.playerHand = new Card[handSize];
		this.name = "Default";
	}
	
	public Player(String inputName)
	{
		this.playerHand = new Card[handSize];
		this.name = inputName;
	}
	
	public void growPileSize()
	{
		handSize = handSize * 2;
		
		Card[] temp = new Card[handSize];
		for(int i = 0; i < playerHand.length; i++)
		{
			temp[i] = playerHand[i];
		}
		playerHand = temp;
	}
	
	public void addCard(Card inputCard)
	{
		for(int i = 0; i < playerHand.length; i++)
		{
			if(handCounter >= handSize-1)
			{
				growPileSize();
			}
			if(playerHand[i] == null)
			{
				playerHand[i] = inputCard;
				break;
			}
			handCounter++;
		}
	}
	
	public int searchCard(String targetCard)
	{
		int targetIndex = 999;
		
		for(int i = 0; i < playerHand.length; i++)
		{
			if(playerHand[i].toString() == targetCard)
			{
				targetIndex = i;
			}
		}
		if(targetIndex == 999)
		{
			System.out.println("The card | " + targetCard  + " | does not exist.");
		}
		return targetIndex;
	}
	
	public Card returnTargetCard(int inputIndex)
	{
		return playerHand[inputIndex];
	}
	
	public void displayHand()
	{
		int length = playerHand.length;
	
		System.out.print("Player Hand: ");
		
		for(int i = 0; i < length; i++)
		{
			if(playerHand[i] == null)
			{
				break;
			}
			System.out.print(playerHand[i].toString() + " ");
		}
		
	}

}
