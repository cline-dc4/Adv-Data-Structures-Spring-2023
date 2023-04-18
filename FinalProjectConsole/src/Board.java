
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
			turnPocket = gameBoard.getPlayer2Home();
		}
		else
		{
			turnPocket = gameBoard.getPlayer1Home();
		}
		
		//move turnPocket to the chosen pocket.
		for(int i = 0; i < pocketNum; i++)
		{
			turnPocket = turnPocket.getNext();
		}
		
		//pick up stones
		int heldStones = turnPocket.getNumStones();
		turnPocket.removeStones();
		
		//move stones to the next pockets unless it is the other player's home
		while(heldStones != 0)
		{
			turnPocket = turnPocket.getNext();
			//if the pocket is not the other player's home pocket, place a stone
			if(!(turnPocket.isHomePocket() && turnPocket.getOwner() != currentPlayer ))
			{
				turnPocket.incrementStones();
				heldStones--;
			}
		}
		
		//check if the move triggers any special rules.
		checkState();
	}

	public void checkState() 
	{
		//capture if turn ends on current player's side in an empty pocket.
		if(turnPocket.getNumStones() == 1 && turnPocket.getOwner() == currentPlayer 
				&& !turnPocket.isHomePocket())
		{
			capture();
		}
		
		//advance turn if turn doesn't end in current player's home pocket
		if(turnPocket.isHomePocket())
		{
			if(turnPocket.getOwner() != currentPlayer)
			{
				nextTurn();
			}
		}
		else
		{
			nextTurn();
		}
		
		
	}
	
	public void capture() 
	{
		//#TODO
	}

	public void nextTurn() 
	{
		if(currentPlayer == PLAYER1)
		{
			currentPlayer = PLAYER2;
		}
		else
		{
			currentPlayer = PLAYER1;
		}
	}

	public void gameEnd() 
	{
		//#TODO
	}
	
	public String toString()
	{
		return "" + gameBoard;
	}
}
