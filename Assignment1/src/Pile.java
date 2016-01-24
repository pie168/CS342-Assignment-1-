
public class Pile {
	
	private Card[] pileDeck;
	private int pileSize = 1;
	private int pileCounter = 0;
	
	public Pile()
	{
		pileDeck = new Card[pileSize];
	}
	
	public void growPileSize()
	{
		pileSize = pileSize * 2;
		
		Card[] temp = new Card[pileSize];
		for(int i = 0; i < pileDeck.length; i++)
		{
			temp[i] = pileDeck[i];
		}
		pileDeck = temp;
	}
	
	public void addCard(Card inputCard)
	{
		for(int i = 0; i < pileDeck.length; i++)
		{
			if(pileCounter >= pileSize)
			{
				growPileSize();
			}
			else
			{
				if(pileDeck[i].equals(null))
				{
					pileDeck[i] = inputCard;
				}
				pileCounter++;
			}
		}
	}
	
	public void displayPile()
	{
		for(int i = 0; i < pileDeck.length; i++)
		{
			if(pileDeck[i].equals(null))
			{
				System.out.println("NULL");
				break;
			}
			else
			{
				System.out.println(pileDeck[i].toString() + " ");
			}
			
		}
	}

}
