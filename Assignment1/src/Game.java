import java.util.Scanner;

public class Game extends CardPile{
	
	public static void main(String[] args) {
		Scanner scan = new Scanner( System.in );
		
		boolean isGame = true;
		
		String userInput;
		int inputPile;
		
		CardPile deck = new CardPile();
	
		Pile pile1 = new Pile(1);
		Pile pile2 = new Pile(2);
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
		
		player1.displayHand();
		System.out.println();
		
		
		while(isGame)
		{
			System.out.println(">>");
			userInput = scan.next();
			
		
		}
		
		
		//System.out.println(deck.checkDeckCounter());
		
	/*	deck.drawCard(player1);
		deck.drawCard(player1);
		deck.drawCard(player1);
		deck.drawCard(player1);
		//System.out.println(deck.checkDeckCounter());
		
		player1.displayHand();
		System.out.print(">> ");
		String input = userInput.next();
		
		player1.findCard(input, pile1);
		player1.displayHand();
		
		pile1.displayPile();
		System.out.print(">>");
		input = userInput.next();
		player1.findCard(input, pile1);
		pile1.displayPile();
	*/
		
		
		
	//	pile1.addCard(player1.playerHand[1]);
	//	player1.displayHand();
	//	pile1.displayPile();
	/*	System.out.println();
		pile1.addCard(player1.playerHand[0]);
		pile1.displayPile();
		
		System.out.println();
		pile1.addCard(player1.playerHand[1]);
		pile1.displayPile();
		
		System.out.println();
		pile1.addCard(player1.playerHand[2]);
		pile1.displayPile();
		
		player1.displayHand();
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
