
public class Board implements BoardInterface
{
	/** the Boolean that shows if the game has ended or not. */
	private Boolean gameEnd;
	
	/** the player who is currently taking their turn */
	private int currentPlayer;
	
	/** the PocketList object that represents the game board */
	private PocketList gameBoard;
	
	
	public Board()
	{
		gameEnd = false;
		currentPlayer = 1;
		gameBoard = new PocketList(PLAYER1, PLAYER2);
	}
	
	public Boolean getGameEnd()
	{
		return gameEnd;
	}

	public void moveStones(int pocketNum) 
	{
		
	}

	public void checkState() 
	{
		
	}
	
	public void capture() 
	{
		
	}

	public void nextTurn() 
	{
		
	}
	
	public void takeTurn(int player)
	{
		
	}

	public void gameEnd() 
	{
		
	}
	
}
