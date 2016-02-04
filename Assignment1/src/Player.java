
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
	
	public void findCard(String targetCard, Pile pileNumber)
	{
		int isTargetFound = 0;
		int targetIndex = 999;
		
		for(int i = 0; i < playerHand.length; i++)
		{
			if(playerHand[i] == null)
			{
				break;
			}
			if(playerHand[i].toString().equals(targetCard))
			{
				isTargetFound = 1;
				targetIndex = i;
				break;
			}
		}
		
		if(isTargetFound == 1 && targetIndex < playerHand.length)
		{
			boolean doResize = pileNumber.addCard(playerHand[targetIndex]);
			resizeHand(targetIndex, doResize);	
		}
		else
		{
			System.out.println("The card | " + targetCard  + " | does not exist.");
		}
		
	}
	
	public void sortHand()
	{
		
	}
	
	public void resizeHand(int emptyIndex, boolean doResize)
	{
		Card[] temp = new Card[handSize];
		
		if(!doResize)
		{
			return;
		}
		else
		{
			playerHand[emptyIndex] = null;
			
			for(int i = 0; i < emptyIndex; i++)
			{
				temp[i] = playerHand[i];
			}
			for(int i = emptyIndex+1; i < handSize; i++)
			{
				if(playerHand[i] == null)
				{
					break;
				}
				else
				{
					temp[i-1] = playerHand[i];
				}
			}
			playerHand = temp;	
		}
		
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
		System.out.println();
		
	}

}
