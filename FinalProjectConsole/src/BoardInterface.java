/**
 * This class handles all the logic of the game, and will contain
 * methods for all the rules and moves the player follows and can make.
 * @author DC
 * @version 4/26/23
 */
public interface BoardInterface 
{
	/** the int referring to player1*/
	public static final int PLAYER1 = 1;
	
	/** the int referring to player2 */
	public static final int PLAYER2 = 2;
	
	/** the number of pockets, used in for loops */
	public static final int NUM_POCKETS = 6;
	
	/** the Boolean that shows if the game has ended or not. */
	//private Boolean gameEnd;
	
	/** the player who is currently taking their turn */
	//private int currentPlayer;
	
	/** the PocketList object that represents the game board */
	//private PocketList gameBoard;
	
	/** the pointer to the pockets being used during the turn */
	//private Pocket turnPocket;
	
	/**
	 * a constructor that calls the PocketList constructor to create it.
	 * @param player1 a constant used for PocketList's constructor
	 * @param player2 a constant used for PocketList's constructor
	 */
	//public Board();
	
	
	/**
	 * shows whether or not the game has ended.
	 * @return true if ended, false otherwise.
	 */
	public boolean getGameEnd();
	
	/**
	 * the getter for the current player.
	 * @return an int referring to the player number.
	 */
	public int getCurrentPlayer();
	
	/**
	 * will take in an integer that refers to a pocket n spaces away from the
	 * player's home pocket and perform a movement by that player.
	 * @param pocketNum number of spaces away the chosen pocket is from the home.
	 * @exception thrown whenever an invalid pocket number is passed in.
	 */
	public void moveStones(int pocketNum) throws Exception;
	
	
	/* * * * Rules * * * */ 
	
	/**
	 * will capture all stones from the pocket turnPointer and the pocket's capturePocket 
	 * and place them in the current player's home.
	 */
	public void capture();
	
	
	/**
	 * will pass the turn if turnPointer != the currentPlayer's home pocket.
	 */
	public void nextTurn();
	
	/**
	 * if all of the currentPlayer's pockets are empty, the remaining stones are given
	 * to the opposite player and the game is ended.
	 */
	public void gameEnd();
	
	/**
	 * shows who won the game, returns 1 for player 1, 2 for player 2, or 0 for a tie.
	 * @return 0, 1, or 2 depending on who won or if there is a tie.
	 */
	public int showWinner();
	
	/**
	 * just calls the toString from pocketList.
	 * @return the game board as a string.
	 */
	public String toString();
	
}
