
public class Computer {

	public Card[] computerHand;
	private int handSize = 52; 
	private int handCounter = 0;
	
	public Computer()
	{
		this.computerHand = new Card[handSize];
	}
	
	public void growPileSize()
	{
		handSize = handSize * 2;
		
		Card[] temp = new Card[handSize];
		for(int i = 0; i < computerHand.length; i++)
		{
			temp[i] = computerHand[i];
		}
		computerHand = temp;
	}
	
	public void addCard(Card inputCard)
	{
		
		if(handCounter == handSize)
		{
			growPileSize();
		}
		
		for(int i = 0; i < handSize; i++)
		{
			if(computerHand[i] == null)
			{
				computerHand[i] = inputCard;
				handCounter++;
				break;
			}
		}
	}
	
	public void displayHandAmount()
	{
		int cardAmount = 0;
		for(int i = 0; i < handSize; i++)
		{
			if(computerHand[i] == null)
			{
				break;
			}
			else
			{
				cardAmount++;
			}
		}
		System.out.println("The computer has " + cardAmount + " cards");
	}
	
	public void displayHand()
	{
		for(int i = 0; i < handSize; i++)
		{
			if(computerHand[i] == null)
			{
				break;
			}
			System.out.print(computerHand[i].toString() + " ");
		}
		
	}
	
}
