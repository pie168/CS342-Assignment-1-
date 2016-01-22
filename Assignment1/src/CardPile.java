import java.util.Random;

public class CardPile extends Card{

	public Card[] newDeck;
	private int deckAmount = 52;
	
	public CardPile()
	{
		newDeck = new Card[deckAmount];
	}
	
	public Card[] buildDeck()
	{
		String[] suitArray = {"C", "D", "H", "S"};
		int cardCounter = 0;
		int suitCounter = 0;
		
		for(int i = 0; i < 52; i++)
		{
			if(cardCounter == 0)
			{
				newDeck[i] = new Card("A", suitArray[suitCounter]);
				cardCounter++;
				
			}
			else if(cardCounter == 10)
			{
				newDeck[i] = new Card("J", suitArray[suitCounter]);
				cardCounter++;
			}
			else if(cardCounter == 11)
			{
				newDeck[i] = new Card("Q", suitArray[suitCounter]);
				cardCounter++;
			}
			else if(cardCounter == 12)
			{
				newDeck[i] = new Card("K", suitArray[suitCounter]);
				cardCounter = 0;
				suitCounter++;
				
			}
			else
			{
				String number = Integer.toString(cardCounter+1);
				newDeck[i] = new Card(number, suitArray[suitCounter]);
				cardCounter++;
			}
		}
				   
		return newDeck;

	}

	public Card[] shuffleDeck()
	{
		Random ranGen = new Random();
		Card tempHolder;
		int randomNum1, randomNum2;
		
		for(int i = 0; i < 100; i++)
		{
			randomNum1 = ranGen.nextInt(52);
			randomNum2 = ranGen.nextInt(52);
			
			if(randomNum1 == randomNum2)
			{
				randomNum1 = ranGen.nextInt(52);
				randomNum2 = ranGen.nextInt(52);
			}
			
			tempHolder = newDeck[randomNum1];
			newDeck[randomNum1] = newDeck[randomNum2];
			newDeck[randomNum2] = tempHolder;
			
		}
		
		return newDeck;
	}
	
	public String toString()
	{
		for(int i = 0; i < deckAmount; i++)
		{
			newDeck[i].getCardInfo();
		}
		
		System.out.println();
		return "FINISHED TEST";
	}
	
}
