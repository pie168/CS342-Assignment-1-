import java.util.Scanner;

public class Game {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner( System.in );
		
		boolean isGame = true;
		int turn = 0;  //Player is 0. Comp is 1
		
		String userInput;
		int inputPile;
		
		CardPile deck = new CardPile();
	
		Pile[] pileArray = new Pile[8];
		
	/*	Pile pile3 = new Pile(3);
		Pile pile4 = new Pile(4);
		Pile pile5 = new Pile(5);
		Pile pile6 = new Pile(6);
		Pile pile7 = new Pile(7);
		Pile pile8 = new Pile(8);
	*/
		
		Player player1 = new Player("Test");
		Computer comp1 = new Computer();
		
		deck.buildDeck();
		deck.shuffleDeck();
		
		deck.firstDeal(player1, comp1);
		
		for(int i = 0; i < 8; i++)
		{
			pileArray[i] = new Pile(i+1);
		}
		
		
		while(isGame)
		{
			for(int i = 0; i < 8; i++)
			{
				pileArray[i].displayPile();
			}
			
			player1.displayHand();
			System.out.println(">>");
			userInput = scan.next();
		
			if(userInput.equals("Q") || userInput.equals("q"))
			{
				System.out.println("EXITING...");
				break;
			}
			
			if(userInput.equals("D") || userInput.equals("d"))
			{
				deck.drawCard(player1);
			}
			
			if(userInput.equals("L") || userInput.equals("l"))
			{
				String inputCard = scan.next();
				int pileInput = scan.nextInt();
				
				System.out.print("Searching");
				for(int i = 0; i < 8; i++)
				{
					System.out.print(".");
					if(pileArray[i].getPileNum() == pileInput)
					{
						System.out.println(" |Found Card|");
						player1.findCard(inputCard, pileArray[i]);
						break;
					}
				}
			}
			
			if(userInput.equals("M") || userInput.equals("m"))
			{
				int fromPile = scan.nextInt();
				int toPile = scan.nextInt();

				for(int i = 0; i < 8; i++)
				{
					if(pileArray[i].getPileNum() == fromPile)
					{
						for(int w = 0; w < 8; w++)
						{
							if(pileArray[w].getPileNum() == toPile)
							{
								mergePiles(pileArray[i], pileArray[w]);
								break;
							}
						}
					}
				}
				
			}
		
			
		
		
		}

	}
	
	public static void mergePiles(Pile fromPile, Pile toPile)
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
			int toPileSize = toPile.getPileCounter();
			int value = toPile.pileDeck[toPile.getPileCounter()].getValue() - fromPile.pileDeck[0].getValue();
			
			System.out.println("Moving pile w/ " + toPile.pileDeck[toPile.getPileCounter()].toString() + " to: " + fromPile.pileDeck[0].toString());
			
			String fromCard = fromPile.pileDeck[0].getColor();
			String toCard = toPile.pileDeck[toPileSize].getColor();
			
			if(value == 1 && !(fromCard.equals(toCard)))
			{
				int counter = 0;
				for(int i = toPileSize+1; i < fromPile.pileDeck.length; i++)
				{
					if(fromPile.pileDeck[counter] == null)
					{
						System.out.println("NULL: FROM PILE SIZE");
						fromPile.resetPile();
						break;
					}
					toPile.pileDeck[i] = fromPile.pileDeck[counter];
					counter++;
				}
				
			}
			
		}
		
	}
}
