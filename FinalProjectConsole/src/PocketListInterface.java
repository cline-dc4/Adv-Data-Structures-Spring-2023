/**
 * This is basically a circular linked list that uses Pocket objects
 * as the nodes. It also essentially has two different head pointers,
 * the respective player#Home pointer will be used when it is a given
 * players turn to navigate the list.
 * @author DC
 * @version 4/13/23
 */
public interface PocketListInterface 
{
	/** This is a pointer to player 1's home pocket. */
	//private Pocket player1Home;
	
	/** This is a pointer to player 2's home pocket. */
	//private Pocket player2Home;
	
	
	/**
	 * This is the constructor for PocketList that creates a circular linked list of pockets
	 * and sets instance variables player1Home and player2Home to point to their respective
	 * home pockets.
	 * @param player1 the integer that represents player 1
	 * @param player2 the integer that represents player 2
	 */
	//public PocketList(int player1, int player2);
	
	/**
	 * the getter for the player1Home pointer.
	 * @return player1Home
	 */
	public Pocket getPlayer1Home();
	
	/**
	 * the getter for the player2Home pointer.
	 * @return player2Home
	 */
	public Pocket getPlayer2Home();
	
	/**
	 * This will return a string version of the list that visually represents the game board
	 * in the console.
	 * @return s the string that will show the game board.
	 */
	public String toString();
	
}
