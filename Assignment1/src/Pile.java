
public class Pile {
	
	private Card[] pileDeck;
	private int deckLimit = 13;
	public Pile()
	{
		pileDeck = new Card[deckLimit];
	}
	
	public void addCard(Card inputCard)
	{
		for(int i = 0; i < deckLimit; i++)
		{
			if(pileDeck[i] == null)
			{
				pileDeck[i] = inputCard;
			}
		}
	}
	
	public void displayPile()
	{
		for(int i = 0; i < pileDeck.length; i++)
		{
			if(pileDeck[i]==null)
			{
				break;
			}
			else
			{
				System.out.println(pileDeck[i].toString() + " ");
			}
			
		}
	}

}
