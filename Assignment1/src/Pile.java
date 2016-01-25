
public class Pile {
	
	private Card[] pileDeck;
	private int pileNumber;
	private int pileSize = 2;
	private int pileCounter = 0;
	
	public Pile(int inputNumber)
	{
		pileDeck = new Card[pileSize];
		this.pileNumber = inputNumber;
	}
	
	public void growPileSize()
	{
		pileSize = pileSize*2;
		
		Card[] temp = new Card[pileSize];
		for(int i = 0; i < pileDeck.length; i++)
		{
			temp[i] = pileDeck[i];
		}
		pileDeck = temp;
	}
	
	public void placeCard(Card inputCard)
	{
		for(int i = 0; i < pileCounter; i++)
		{
			if(pileDeck[0] == null)
			{
				System.out.println("ERROR: FIRST INDEX IS NULL");
				break;
			}
			else if(pileDeck[i] == null)
			{
				int check = inputCard.getValue() - pileDeck[i-1].getValue();
				
				if(check == 1)
				{
					addCard(inputCard);
				}
				else
				{
					System.out.println("ERROR: The card: " + inputCard.toString() + " cannot be after " + pileDeck[i-1].toString());
				}
				
			}
		}
	}
	
	public void addCard(Card inputCard)
	{
		for(int i = 0; i < pileDeck.length; i++)
		{
			if(pileCounter >= pileSize-1)
			{
				growPileSize();
			}
			if(pileDeck[i] == null)
			{
				pileDeck[i] = inputCard;
				pileCounter++;
				break;
			}
			pileCounter++;
		}
	}
	
	public void displayPile()
	{
		System.out.print("Pile " + Integer.toString(pileNumber) + ": ");
		for(int i = 0; i < pileDeck.length; i++)
		{
			if(pileDeck[i] == null)
			{
				//System.out.println("NULL");
				break;
			}
			else
			{
				System.out.print(pileDeck[i].toString() + " ");
			}
			
		}
		System.out.println();
	}

}
