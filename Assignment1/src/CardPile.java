
public class CardPile {

	public Card[] deck;
	private int deckAmount = 52;
	
	public CardPile()
	{
		
	}
	
	public Card[] buildDeck()
	{
		Card[] newDeck = new Card[deckAmount];
		String inputSuit = "C";
		
		for(int i = 0; i < 13; i++)
		{
			if(i == 0)
			{
				newDeck[i] = new Card("A", inputSuit);
			}
			if(i == 10)
			{
				newDeck[i] = new Card("J", inputSuit);
			}
			if(i == 11)
			{
				newDeck[i] = new Card("Q", inputSuit);
			}
			if(i == 12)
			{
				newDeck[i] = new Card("K", inputSuit);
			}
			else
			{
				String inputRank = Integer.toString(i);
				newDeck[i] = new Card(inputRank, inputSuit);
			}
		}
		   
		return newDeck;
		
		//newDeck[0] = new Card("A", "C");
		//newDeck[1] = new Card("2", "C");
	}
}
