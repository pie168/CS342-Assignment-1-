
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
	public void moveOne(Pile[] pileArray)
	{
		System.out.println("CHECKING FOR KINGS IN HAND...");
		for(int i = 0; i < handSize; i++)
		{
			if(computerHand[i] == null)
			{
				System.out.println("FINISHED CHECKING FOR KINGS..");
				break;
			}
			if(computerHand[i].getRank().equals("K"))
			{
				System.out.println("FOUND A KING IN HAND.. ATTEMPTING TO INSERT IN PILE");
				for(int w = 4; w < 8; w++)
				{
					System.out.println("CHECKING PILE " + w);
					if(pileArray[w].getPileCounter() == 0)
					{
						boolean doResize = pileArray[w].addCard(computerHand[i]);
						if(doResize)
						{
							System.out.println("ADDED " + computerHand[i].toString() + " TO PILE " + w);
							resizeHand(i, doResize);
							break;
						}
					}
				}
			}
		}
		
		System.out.println("LOOKING FOR PILES W/ KINGS IN FRONT TO MOVE");
		for(int i = 0; i < 4; i++)
		{
			if(pileArray[i].pileDeck[0] == null)
			{
				break;
			}
			else if(pileArray[i].pileDeck[0].getRank().equals("K"))
			{
				System.out.println("FOUND A PILE. SEARCHING FOR EMPTY PILE 5-8");
				for(int w = 4; w < 8; w++)
				{
					if(pileArray[w].pileDeck[0] == null)
					{
						System.out.println("ATTEMPTING TO MERGE PILE " + i + " W/ PILE " + w);
						mergePiles(pileArray[i], pileArray[w]);
						break;
					}
				}
			}
		}
	}
	
	public void moveTwo(Pile[] pileArray)
	{
		for(int i = 0; i < 8; i++)
		{
			if()
		}
	}
	
	public void moveFive()
	{
		System.out.println("DRAWING CARD.");
		
	}
	
	public void mergePiles(Pile fromPile, Pile toPile)  //Move to the top of the next pile!!
	{
		if(fromPile.pileDeck[0] == null)
		{
			System.out.println("Pile: " + fromPile.getPileNum() + " is empty");
		}
		else if(toPile.pileDeck[0] == null)
		{
			toPile.pileDeck = fromPile.pileDeck;
			fromPile.resetPile();
		}
		else
		{
			int fromPileCounter = fromPile.getPileCounter();
			int value = fromPile.pileDeck[fromPileCounter].getValue() - toPile.pileDeck[0].getValue();
			
			String fromCard = fromPile.pileDeck[fromPileCounter].getColor();
			String toCard = toPile.pileDeck[0].getColor();
			
			if(value == 1 && !(fromCard.equals(toCard)))
			{
				int counter = 0;
				Card[] newPileHolder = new Card[52];
				
				System.out.println("Moving pile " + fromPile.getPileNum() + " to pile " + toPile.getPileNum());
				
				for(int i = 0; i < fromPile.pileDeck.length; i++)
				{
					if(fromPile.pileDeck[i] == null)
					{
						break;
					}
					else
					{
						newPileHolder[i] = fromPile.pileDeck[i];
						counter++;
					}
				}
				
				for(int i = 0; i < toPile.pileDeck.length; i++)
				{
					if(toPile.pileDeck[i] == null)
					{
						break;
					}
					else
					{
						newPileHolder[counter] = toPile.pileDeck[i];
						counter++;
					}
				}
				
				toPile.pileDeck = newPileHolder;
				fromPile.resetPile();
				fromPile.resetPileCounter();
				
			}
			else
			{
				System.out.println("ERROR: " + fromPile.pileDeck[fromPileCounter].toString() + " cant be moved to " + toPile.pileDeck[0].toString());
			}
			
		}
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
	
	public void resizeHand(int emptyIndex, boolean doResize)
	{
		Card[] temp = new Card[handSize];
		
		if(!doResize)
		{
			return;
		}
		else
		{
			computerHand[emptyIndex] = null;
			
			for(int i = 0; i < emptyIndex; i++)
			{
				temp[i] = computerHand[i];
			}
			for(int i = emptyIndex+1; i < handSize; i++)
			{
				if(computerHand[i] == null)
				{
					break;
				}
				else
				{
					temp[i-1] = computerHand[i];
				}
			}
			computerHand = temp;	
		}
		
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
		System.out.println();
		
	}
	
}
