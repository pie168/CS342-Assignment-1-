
public class Computer {

	public Card[] computerHand;
	private int handSize = 7; 
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
		for(int i = 0; i < computerHand.length; i++)
		{
			if(handCounter >= handSize-1)
			{
				growPileSize();
			}
			if(computerHand[i] == null)
			{
				computerHand[i] = inputCard;
				break;
			}
			handCounter++;
		}
	}
	
	public void displayHand()
	{
		int length = computerHand.length;
		for(int i = 0; i < length; i++)
		{
			if(computerHand[i] == null)
			{
				break;
			}
			System.out.print(computerHand[i].toString() + " ");
		}
		
	}
	
}
