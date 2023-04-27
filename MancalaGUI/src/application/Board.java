package application;

//most javadocs are in interface.
public class Board implements BoardInterface
{
	/** the Boolean that shows if the game has ended or not. */
	private boolean gameEnd;

	/** the player who is currently taking their turn */
	private int currentPlayer;

	/** the PocketList object that represents the game board */
	private PocketList gameBoard;

	/** the pointer to the pockets being used during the turn */
	private Pocket turnPocket;


	/**
	 * a constructor that calls the PocketList constructor to create it.
	 * @param player1 a constant used for PocketList's constructor
	 * @param player2 a constant used for PocketList's constructor
	 */
	public Board()
	{
		gameEnd = false;
		currentPlayer = 1;
		gameBoard = new PocketList(PLAYER1, PLAYER2);
	}

	public boolean getGameEnd()
	{
		return gameEnd;
	}

	public int getCurrentPlayer()
	{
		return currentPlayer;
	}

	public int getNumStones(int player, int pocketNum) throws Exception
	{

		//throw exceptions for invalid input.
		if(player != PLAYER1 && player != PLAYER2)
		{
			throw new Exception("Invalid number for player.");
		}
		if(pocketNum < -1 || pocketNum > NUM_POCKETS)
		{
			throw new Exception("Invalid pocket number");
		}

		//if pocketNum == -1, return that player's home pocket's numStones.
		if(pocketNum == -1 && player == PLAYER1)
		{
			return gameBoard.getPlayer1Home().getNumStones();
		}
		else if(pocketNum == -1 && player == PLAYER2)
		{
			return gameBoard.getPlayer2Home().getNumStones();
		}
		//pointer for traversing PocketList
		Pocket currentPocket;

		//access a pocket owned by player 1
		if(player == PLAYER1)
		{
			currentPocket = gameBoard.getPlayer2Home();
			//navigate to correct pocket
			for(int i = 0; i <= pocketNum; i++)
			{
				currentPocket = currentPocket.getNext();
			}
			return currentPocket.getNumStones();
		}
		//access a pocket owned by player 2
		else
		{
			currentPocket = gameBoard.getPlayer1Home();
			//navigate to correct pocket
			for(int i = 0; i <= ((NUM_POCKETS - 1) - pocketNum); i++)
			{
				currentPocket = currentPocket.getNext();
			}
			return currentPocket.getNumStones();
		}
	}

	public void moveStones(int pocketNum) throws Exception
	{
		//check if pocket number is valid
		if(pocketNum < 1 || pocketNum > NUM_POCKETS)
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
			for(int i = 0; i < ((NUM_POCKETS + 1) - pocketNum); i++)
			{
				turnPocket = turnPocket.getNext();
			}
		}

		//throw exception if pocket is empty
		//this has to be here because turnPocket has to be given a Pocket to point to.
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

		//capture if turn ends on current player's side in an empty pocket.
		if(turnPocket.getNumStones() == 1 && !turnPocket.isHomePocket() && 
				turnPocket.getCapturePocket().getNumStones() > 0 && turnPocket.getOwner() == currentPlayer)
		{
			//call capture
			capture();
		}

		//advance turn if turn doesn't end in current player's home pocket
		if(turnPocket.isHomePocket())
		{
			if(turnPocket.getOwner() != currentPlayer)
			{
				//call nextTurn
				nextTurn();
			}
		}
		else
		{
			//call nextTurn
			nextTurn();
		}

		//end game if any row is empty
		Pocket currentPocket = gameBoard.getPlayer1Home().getNext();
		while(currentPocket.getNumStones() == 0)
		{
			currentPocket = currentPocket.getNext();
			if(currentPocket.isHomePocket())
			{
				//call gameEnd
				gameEnd();
			}
		}
		currentPocket = gameBoard.getPlayer2Home().getNext();
		while(currentPocket.getNumStones() == 0)
		{
			currentPocket = currentPocket.getNext();
			if(currentPocket.isHomePocket())
			{
				//call gameEnd
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
		currentPlayer = 3 - currentPlayer;
	}

	public void gameEnd() 
	{
		//when game ends take remaining stones and place them into the player's pocket.

		//figure out which section of the list is empty
		Pocket currentPocket = gameBoard.getPlayer1Home().getNext();
		int player = 0;

		while(currentPocket.getNumStones() == 0)
		{
			currentPocket = currentPocket.getNext();
			if(currentPocket.isHomePocket())
			{
				player = PLAYER1;
			}
			else
			{
				player = PLAYER2;
			}
		}

		//set pointer to correct home to start retrieving stones
		if(player == PLAYER1)
		{
			currentPocket = gameBoard.getPlayer2Home().getNext();
		}
		else
		{
			currentPocket = gameBoard.getPlayer1Home().getNext();
		}

		//give stones to player
		while(!currentPocket.isHomePocket())
		{
			if(player == PLAYER1)
			{
				for(int i = 0; i < currentPocket.getNumStones(); i++)
				{
					gameBoard.getPlayer1Home().incrementStones();
				}
			}
			else
			{
				for(int i = 0; i < currentPocket.getNumStones(); i++)
				{
					gameBoard.getPlayer2Home().incrementStones();
				}
			}
			currentPocket.removeStones();
			currentPocket = currentPocket.getNext();
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
