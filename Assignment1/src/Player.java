
//Player class
//This class contains methods to modify the player hand (Which consist of an array of Card objects).
public class Player {
	
	public Card[] playerHand;    //Cards in players hands
	private int handSize = 52;   //Default handsize 52.
	private int handCounter = 0; //Counter to keep track the amount of cards in hand
	
	//Default constructer. Creates a new array of Cards with handSize being the size
	public Player()
	{
		this.playerHand = new Card[handSize];
	}
	
	public void sortArray()
	{

	}
	
	//Dynamicly grows the playerHand array.
	//This is incase if dealing with more than 52 cards
	public void growPileSize()
	{
		handSize = handSize * 2;            //Double size of the array
		
		Card[] temp = new Card[handSize];	//Create a new Card array with new size
		
		//Loops through the entire array, copying its object into the temp array.
		for(int i = 0; i < playerHand.length; i++) 
		{
			temp[i] = playerHand[i];
		}
		playerHand = temp;  //Makes the new temp array, the new playerHand array
	}//End of method
	
	//This method is to add a Card object into the playerHand array.
	//This takes in an inputCard Object to be added in
	public void addCard(Card inputCard)
	{
		//Loops through the playerHand. Looking for the first NULL value in the array
		for(int i = 0; i < playerHand.length; i++)
		{
			//Checks if the array is not big enough
			if(handCounter >= handSize-1)
			{
				growPileSize();           //Grows the array
			}
			if(playerHand[i] == null)     //Checks if the current element is NULL
			{
				playerHand[i] = inputCard;//If so, that element is now the inputCard Object
				break;
			}
			handCounter++;                //Increase handCounter by 1. Keeps track
		}								  //of the amount of REAL Card Objects in the hand.
	}//End of method
	
	//This method is to go through the playerHand array, looking for a specific Card object
	//and adds it into the specific pile.
	public void findCard(String targetCard, Pile pileNumber)
	{
		boolean isTargetFound = false;  //Boolean if the targetCard is found in the playerHand
		int targetIndex = 999;			//Random number for the default value of targetIndex
		
		//Loops through the playerHand array
		for(int i = 0; i < playerHand.length; i++)
		{
			//Checks if current element is null. If so,break from the loop.
			//The targetCard object is NOT in the hand
			if(playerHand[i] == null)
			{
				break;
			}
			//Checks if the targetCard matches to the current element in the playerHand
			if(playerHand[i].toString().equals(targetCard))
			{
				isTargetFound = true; //Found the target
				targetIndex = i;	  //Saves location in playerHand array
				break;
			}
		}
		
		//If the targetCard is found in the playerHand
		if(isTargetFound && targetIndex < playerHand.length)
		{
			//Checks if you can add said card into the speific pile.
			boolean doResize = pileNumber.addCard(playerHand[targetIndex]); 
			
			//Resize the player hand.
			resizeHand(targetIndex, doResize);	
		}
		else
		{
			//Error message if the targetCard DNE in the playerHand
			System.out.println("The card | " + targetCard  + " | does not exist.");
		}
		
	}//End of method
	
	//This method is to resize the player hand when you remove a card anywhere in playerHand
	//Takes in the index of where in the array it'll be empty.
	//Takes in a boolean variable to show if the hand needs to be resized.
	public void resizeHand(int emptyIndex, boolean doResize)
	{
		//Temp holder for Card[]
		Card[] temp = new Card[handSize];
		
		//Checks if resize needs being done
		if(!doResize)
		{
			return; //Exit the method.
		}
		//Needs to be resized...
		else
		{
			playerHand[emptyIndex] = null;   //Sets the marked emptyIndex to null
			
			//Loops through beginning half to copy the objects in playerHand into the temp holder
			for(int i = 0; i < emptyIndex; i++)
			{
				temp[i] = playerHand[i];
			}
			//Loops through second half to fill the rest of the temp holder
			for(int i = emptyIndex+1; i < handSize; i++)
			{
				//Checks if current element is NULL. Meaning the end of the handArray
				if(playerHand[i] == null)
				{
					break;
				}
				else
				{
					temp[i-1] = playerHand[i];
				}
			}
			//playerHand is now the newly modified temp holder.
			playerHand = temp;	
		}
		
	}//End of method
	
	//This method is to display the current elements in the playerHand array
	public void displayHand()
	{
		System.out.print("Player Hand: ");
		
		//Loops through the playerHand array
		for(int i = 0; i < handSize; i++)
		{
			//If null, end the loop. Meaning reached the end of all current elements
			if(playerHand[i] == null)
			{
				break;
			}
			System.out.print(playerHand[i].toString() + " ");
		}
		System.out.println();
		
	}//End of Method

}//End of Class
