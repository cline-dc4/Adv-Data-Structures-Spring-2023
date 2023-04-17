
public class PocketList implements PocketListInterface
{
	/** This is a pointer to player 1's home pocket. */
	private Pocket player1Home;
	
	/** This is a pointer to player 2's home pocket. */
	private Pocket player2Home;
	
	
	/**
	 * This is the constructor for PocketList that creates a circular linked list of pockets
	 * and sets instance variables player1Home and player2Home to point to their respective
	 * home pockets.
	 * @param player1 the integer that represents player 1
	 * @param player2 the integer that represents player 2
	 */
	public PocketList(int player1, int player2)
	{
		Pocket currentPocket = null;
		Pocket nextPocket = null;
		//create player 1 pockets
		player1Home = new Pocket(player1, 0, true);
		currentPocket = player1Home;
		
		for(int i = 0; i < 6; i++)
		{
			nextPocket = new Pocket(player1, 4, false);
			currentPocket.setNext(nextPocket);
			currentPocket = nextPocket;
		}
		
		//create player 2 pockets
		player2Home = new Pocket(player2, 0, true);
		currentPocket.setNext(player2Home);
		currentPocket = player2Home;
		for(int i = 0; i < 6; i++)
		{
			nextPocket = new Pocket(player2, 4, false);
			currentPocket.setNext(nextPocket);
			currentPocket = nextPocket;
		}
		//make it a circular list
		currentPocket.setNext(player1Home);
		
		
		//set up capture pointers
		
		
		for(int i = 0; i < 6; i++)
		{
			//currentPocket refers to player 1 pockets.
			currentPocket = player1Home;
			for(int j = 0; j <= i; j++)
			{
				currentPocket = currentPocket.getNext();
			}
			//nextPocket refers to player 2 pockets.
			nextPocket = player2Home;
			for(int j = 0; j <= (6 - i); j++)
			{
				nextPocket = nextPocket.getNext();
			}
			currentPocket.setCapturePocket(nextPocket);
			nextPocket.setCapturePocket(currentPocket);
		}
	}
	
	/**
	 * the getter for the player1Home pointer.
	 * @return player1Home
	 */
	public Pocket getPlayer1Home()
	{
		return player1Home;
	}
	
	/**
	 * the getter for the player2Home pointer.
	 * @return player2Home
	 */
	public Pocket getPlayer2Home()
	{
		return player2Home;
	}
	
	/**
	 * This will return a string version of the list that visually represents the game board
	 * in the console.
	 * @return s the string that will show the game board.
	 */
	public String toString()
	{
		Pocket current;
		String s = "";
		
		//print out player 2 pockets
		current = player2Home.getNext();
		s += "  ";
		while(current != player1Home)
		{
			s += current + " ";
			current = current.getNext();
		}
		s += "\n";
		
		//print out player homes
		s += player2Home + "              " + player1Home + "\n";
		
		//print out player 1 pockets
		current = player1Home.getNext();
		s += "  ";
		while(current != player2Home)
		{
			s += current + " ";
			current = current.getNext();
		}
		s += "\n";
		
		return s;
	}
}
