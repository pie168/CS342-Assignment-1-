public class Game extends CardPile{
	
	public static void main(String[] args) {
		CardPile deck = new CardPile();
	
		Pile pile1 = new Pile();
		
		//Card[] playerHand = new Card[7];
		//Card[] computerHand = new Card[7];
		
		Player player1 = new Player("Test");
		Computer comp1 = new Computer();
		
		deck.buildDeck();
		deck.shuffleDeck();
		
		deck.firstDeal(player1, comp1);
		
		player1.displayHand();
		
		
		
		pile1.addCard(player1.playerHand[0]);
		pile1.displayPile();
		
	/*	player1.displayHand();
		System.out.println();
		comp1.displayHand();
		System.out.println();
		System.out.println(deck.checkDeckCounter());
	*/
		
		
	/*  deck.buildDeck();
		deck.toString();
		System.out.println("======");
		deck.shuffleDeck();
		deck.toString(); 
	*/
	
	}

}
