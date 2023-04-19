
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
	
	public int getCurrentPlayer()
	{
		return currentPlayer;
	}

	public void moveStones(int pocketNum) throws Exception
	{
		//check if pocket number is valid
		if(pocketNum < 1 || pocketNum > 6)
		{
			throw new Exception("invalid pocket number.");
		}
		//use the correct player's pockets.
		if(currentPlayer == PLAYER1)
		{
			turnPocket = gameBoard.getPlayer2Home();
			//move turnPocket to the chosen pocket.
			for(int i = 0; i < pocketNum; i++)
			{
				turnPocket = turnPocket.getNext();
			}
		}
		else
		{
			turnPocket = gameBoard.getPlayer1Home();
			//move turnPocket to the chosen pocket.
			//uses i < 7 - pocketNum so player can enter 1 - 6
			//counting from left to right to pick their pocket.
			for(int i = 0; i < (7 - pocketNum); i++)
			{
				turnPocket = turnPocket.getNext();
			}
		}
		
		//throw exception if pocket is empty
		if(turnPocket.getNumStones() == 0)
		{
			throw new Exception("You cannot move stones from an empty pocket.");
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
		
		//end game if current player (after advancing turn) cannot make a move
		Pocket currentPocket = null;
		if(currentPlayer == PLAYER1)
		{
			currentPocket = gameBoard.getPlayer2Home().getNext();
		}
		else
		{
			currentPocket = gameBoard.getPlayer1Home().getNext();
		}
		while(currentPocket.getNumStones() == 0)
		{
			currentPocket = currentPocket.getNext();
			if(currentPocket.isHomePocket())
			{
				gameEnd();
			}
		}
		
	}
	
	public void capture() 
	{
		//pick up stones from both pockets involved.
		int capturedStones = turnPocket.getCapturePocket().getNumStones() +
				turnPocket.getNumStones(); 
		//place stones into the correct player's pocket.

		for(int i = 0; i < capturedStones; i++)
		{
			if(currentPlayer == PLAYER1)
			{
				gameBoard.getPlayer1Home().incrementStones();	
			}
			else
			{
				gameBoard.getPlayer2Home().incrementStones();
			}
		}
		turnPocket.removeStones();
		turnPocket.getCapturePocket().removeStones();
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
		//when game ends take remaining stones and place them into the player's pocket.
		Pocket currentPocket = null;
		//Player 1 cannot move, so place remaining stones into player 2 home.
		if(currentPlayer == PLAYER1)
		{
			currentPocket = gameBoard.getPlayer1Home().getNext();
			while(!currentPocket.isHomePocket())
			{
				for(int i = 0; i < currentPocket.getNumStones(); i++)
				{
					gameBoard.getPlayer2Home().incrementStones();
				}
				currentPocket.removeStones();
				currentPocket = currentPocket.getNext();
			}
		}
		//Player 2 cannot move, so place remaining stones into player 1 home.
		else
		{
			currentPocket = gameBoard.getPlayer2Home().getNext();
			while(!currentPocket.isHomePocket())
			{
				for(int i = 0; i < currentPocket.getNumStones(); i++)
				{
					gameBoard.getPlayer1Home().incrementStones();
				}
				currentPocket.removeStones();
				currentPocket = currentPocket.getNext();
			}
		}
		//signal main that the game has ended.
		gameEnd = true;
	}
	
	public int showWinner()
	{
		if(gameBoard.getPlayer1Home().getNumStones() > gameBoard.getPlayer2Home().getNumStones())
		{
			return PLAYER1;
		}
		else if(gameBoard.getPlayer1Home().getNumStones() < gameBoard.getPlayer2Home().getNumStones())
		{
			return PLAYER2;
		}
		else
		{
			return 0;
		}
	}
	
	public String toString()
	{
		return "" + gameBoard;
	}
}
