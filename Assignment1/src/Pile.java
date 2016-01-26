
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
	
	public void addCard(Card inputCard)
	{
		for(int i = 0; i < pileDeck.length; i++)
		{
			if(pileCounter >= pileSize-1)
			{
				growPileSize();
			}
			if(pileDeck[0] == null)
			{
				pileDeck[0] = inputCard;
				break;
			}
			else if(pileDeck[i] == null && pileDeck[i-1] != null)
			{
				int value = inputCard.getValue() - pileDeck[i-1].getValue();
				String prevColor = pileDeck[i-1].getColor();
				String currColor = inputCard.getColor();
				
				if(value == 1 && !(prevColor.equals(currColor)))
				{
					pileDeck[i] = inputCard;
					break;
				}
				else if(prevColor.equals(currColor))
				{
					System.out.println("ERROR: Color must be alternating R/B.");
					break;
				}
				else
				{
					System.out.println("ERROR: The card: " + inputCard.toString() + " cannot be after " + pileDeck[i-1].toString());
					break; 
				}
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
