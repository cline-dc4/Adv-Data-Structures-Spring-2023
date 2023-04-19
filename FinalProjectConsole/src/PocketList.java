//most javadocs are in the interface.
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
		//create player 2 home
		player2Home = new Pocket(player2, 0, true);
		currentPocket = player2Home;
		
		//create player 1 pockets
		for(int i = 0; i < 6; i++)
		{
			nextPocket = new Pocket(player1, 4, false);
			currentPocket.setNext(nextPocket);
			currentPocket = nextPocket;
		}
		
		//create player 1 home
		player1Home = new Pocket(player1, 0, true);
		currentPocket.setNext(player1Home);
		currentPocket = player1Home;
		for(int i = 0; i < 6; i++)
			
		//create player 2 pockets
		{
			nextPocket = new Pocket(player2, 4, false);
			currentPocket.setNext(nextPocket);
			currentPocket = nextPocket;
		}
		//make it a circular list
		currentPocket.setNext(player2Home);
		
		
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
			for(int j = 0; j <= (5 - i); j++)
			{
				nextPocket = nextPocket.getNext();
			}
			currentPocket.setCapturePocket(nextPocket);
			nextPocket.setCapturePocket(currentPocket);
		}
	}

	public Pocket getPlayer1Home()
	{
		return player1Home;
	}
	
	public Pocket getPlayer2Home()
	{
		return player2Home;
	}
	
	public String toString()
	{
		Pocket current;
		String s = "";
		
		//print out player 2 pockets, this is inefficient since its not a doubly linked list.
		s += "  ";
			for(int i = 0; i < 6; i++)
			{
				current = player1Home;
				for(int j = 0; j < (6-i); j++)
				{
					current = current.getNext();
				}
				s += current + " ";
				
			}
		s += "\n";
		
		//print out player homes
		s += player2Home + "             " + player1Home + "\n";
		
		//print out player 1 pockets
		current = player2Home.getNext();
		s += "  ";
		while(current != player1Home)
		{
			s += current + " ";
			current = current.getNext();
		}
		s += "\n";
		
		return s;
	}
}
