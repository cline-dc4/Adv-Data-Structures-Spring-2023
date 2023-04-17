
public class Board implements BoardInterface
{
	/** the Boolean that shows if the game has ended or not. */
	private Boolean gameEnd;
	
	/** the player who is currently taking their turn */
	private int currentPlayer;
	
	/** the PocketList object that represents the game board */
	private PocketList gameBoard;
	
	/** the pointer to the pockets being used during the turn */
	private Pocket turnPocket;

	
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
		//use the correct player's pockets.
		if(currentPlayer == PLAYER1)
		{
			turnPocket = gameBoard.getPlayer1Home();
		}
		else
		{
			turnPocket = gameBoard.getPlayer2Home();
		}
		//move turnPocket to the chosen pocket.
		for(int i = 0; i <= pocketNum; i++)
		{
			
		}
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
