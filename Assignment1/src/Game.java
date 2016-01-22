public class Game extends CardPile{
	
	public static void main(String[] args) {
		CardPile deck = new CardPile();
		
		deck.buildDeck();
		deck.toString();
		System.out.println("======");
		deck.shuffleDeck();
		deck.toString();
	}

}
