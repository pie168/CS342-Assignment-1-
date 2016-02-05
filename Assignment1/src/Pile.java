
public class Pile {
	
	public Card[] pileDeck;
	private int pileNumber;
	private int pileSize = 52;
	private int pileCounter = 0;
	
	public Pile(int inputNumber)
	{
		pileDeck = new Card[pileSize];
		this.pileNumber = inputNumber;
	}
	
	public void initPile(Card inputCard)
	{
		addCard(inputCard);
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
	
	public boolean addCard(Card inputCard)
	{
		boolean temp = false;
		
		if(pileCounter == pileSize)
		{
			growPileSize();
		}
		
		for(int i = 0; i < pileDeck.length; i++)
		{
			if(pileDeck[0] == null)
			{
				if(pileNumber > 4 && inputCard.getRank().equals("K"))
				{
					pileDeck[0] = inputCard;
					temp = true;
					break;
				}
				else if(pileNumber < 5)
				{
					pileDeck[0] = inputCard;
					temp = true;
					break;
				}
				else
				{
					System.out.println("ERROR: You can only place a K at the start in this pile");
					break;
				}
				
			}
			else if(pileDeck[i] == null && pileDeck[i-1] != null)
			{
				int value = pileDeck[i-1].getValue() - inputCard.getValue();
				
				String prevColor = pileDeck[i-1].getColor();
				String currColor = inputCard.getColor();
				
				if(value == 1 && !(prevColor.equals(currColor)) )
				{
					pileDeck[i] = inputCard;
					pileCounter++;
					temp = true;
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
		}
		return temp;
	}
	
	public int getPileNum()
	{
		return pileNumber;
	}
	
	public void resetPileCounter()
	{
		pileCounter = 0;
	}
	
	public int getPileCounter()
	{
		return pileCounter;
	}
	
	public void resetPile()
	{
		pileDeck = new Card[pileSize];
	}
	
	public void displayPile()
	{
		System.out.print("Pile " + Integer.toString(pileNumber) + ": ");
		for(int i = 0; i < pileSize; i++)
		{
			
			if(pileDeck[i] == null || pileDeck == null)
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
