
public class Computer {

	public Card[] computerHand;
	
	public Computer()
	{
		this.computerHand = new Card[7];
	}
	
	public void displayHand()
	{
		int length = computerHand.length;
		for(int i = 0; i < length; i++)
		{
			System.out.print(computerHand[i].toString() + " ");
		}
		
	}
	
}
