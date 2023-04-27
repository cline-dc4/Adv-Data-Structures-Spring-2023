package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * creates the gameBoard of buttons for the GUI.
 * @author DC
 * @version 4/27/23
 */
public class PocketButtons extends GridPane implements EventHandler<ActionEvent>, ButtonCodes
{
	/** the pointer to the Board object. */
	private Board backend;

	/** a pointer to the Player1HomeButton. */
	private PlayerOneHomeButton player1HomeButton;

	/** a pointer to the Player2HomeButton. */
	private PlayerTwoHomeButton player2HomeButton;

	/** a pointer to the label BottomMessage. */
	private BottomMessage currentPlayer;

	/** array of Buttons that corresponds to the player 1 standard pockets. */
	private Button[] player1Pockets;

	/** array of Buttons that corresponds to the player 2 standard pockets. */
	private Button[] player2Pockets;



	/**
	 * creates all the pockets that aren't the player home pockets.
	 * @param backend a pointer to the Board object in the main.
	 * @param player1HomeButton a pointer to the player 1 home button.
	 * @param player2HomeButton a pointer to the player 2 home button.
	 * @param currentPlayer a pointer to the label at the bottom of the GUI.
	 * @throws Exception from the Board class method getNumStones.
	 */

	public PocketButtons(Board backend, PlayerOneHomeButton player1HomeButton,
			PlayerTwoHomeButton player2HomeButton, BottomMessage currentPlayer) throws Exception
	{
		//set instance variables
		this.backend = backend;
		this.player1HomeButton = player1HomeButton;
		this.player2HomeButton = player2HomeButton;
		this.currentPlayer = currentPlayer;

		player1Pockets = new Button[Board.NUM_POCKETS];
		player2Pockets = new Button[Board.NUM_POCKETS];

		//initialize each button in both arrays.
		for(int i = 0; i < Board.NUM_POCKETS; i++)
		{
			player1Pockets[i] = new Button(String.valueOf(backend.getNumStones(Board.PLAYER1, i)));
			player2Pockets[i] = new Button(String.valueOf(backend.getNumStones(Board.PLAYER2, i)));

			//player 1 pockets
			player1Pockets[i].setShape(new Circle(RADIUS));
			player1Pockets[i].setMaxWidth(WIDTH);
			player1Pockets[i].setMinWidth(WIDTH);
			player1Pockets[i].setMaxHeight(HEIGHT);
			player1Pockets[i].setMinHeight(HEIGHT);
			player1Pockets[i].setStyle(BROWN);
			player1Pockets[i].setOnAction(this);

			//player 2 pockets
			player2Pockets[i].setShape(new Circle(RADIUS));
			player2Pockets[i].setMaxWidth(WIDTH);
			player2Pockets[i].setMinWidth(WIDTH);
			player2Pockets[i].setMaxHeight(HEIGHT);
			player2Pockets[i].setMinHeight(HEIGHT);
			player2Pockets[i].setStyle(BROWN);
			player2Pockets[i].setOnAction(this);
		}

		//add all pockets to the GUI.
		for(int i = 1; i < Board.NUM_POCKETS + 1; i++)
		{
			this.add(player2Pockets[i - 1], i, 0);
			this.add(player1Pockets[i - 1], i, 1);
		}
	}

	/**
	 * updates the values on the buttons so they are consistent with the backend.
	 * @throws Exception from the getNumStones method in Board.
	 */
	public void updateValues() throws Exception
	{
		for(int i = 0; i < Board.NUM_POCKETS; i++)
		{
			player1Pockets[i].setText(String.valueOf(backend.getNumStones(Board.PLAYER1, i)));
			player2Pockets[i].setText(String.valueOf(backend.getNumStones(Board.PLAYER2, i)));
		}
	}

	/**
	 * creates an alert that shows the winner of the game and disables the buttons.
	 * @throws Exception an exception from Board's method getNumStones.
	 */
	public void gameEndAlert() throws Exception
	{
		Alert gameEnd = new Alert(Alert.AlertType.INFORMATION);
		gameEnd.setTitle("End of the Game");
		gameEnd.setContentText("Player " + backend.showWinner() + " won!\n" +
				"The score is " + backend.getNumStones(1, -1) + " - " + backend.getNumStones(2, -1));
		gameEnd.showAndWait();
	}

	/**
	 * The handle method for PocketButtons, allows movements to happen
	 * when buttons are clicked on.
	 */
	public void handle(ActionEvent event)
	{
		//logic to pass in correct value to moveStones
		//while not allowing players to click pockets when
		//it isn't their turn.

		for(int i = 0; i < Board.NUM_POCKETS; i++)
		{
			//player 1's turn, only allow player 1 buttons to function
			if(backend.getCurrentPlayer() == Board.PLAYER1 && !backend.getGameEnd())
			{
				//looping through 0 - 5, find which button was activated
				if(event.getSource() == player1Pockets[i])
				{
					try
					{
						//moveStones is based on 1-6, so add 1 to i when button is located.
						backend.moveStones(i + 1);
						//call functions that update the buttons' values.
						updateValues();
						player1HomeButton.updateValue();
						player2HomeButton.updateValue();
						currentPlayer.updateText();
						//check if the game ended after the move is complete.
						if(backend.getGameEnd())
						{
							gameEndAlert();
						}
					}
					catch(Exception e)
					{
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Error moving");
						alert.setContentText(e.getMessage());
						alert.showAndWait();
					}
				}
			}
			//player 2's turn, only allow player 2 buttons to function
			else if(backend.getCurrentPlayer() == Board.PLAYER2 && !backend.getGameEnd())
			{
				if(event.getSource() == player2Pockets[i])
				{
					try
					{
						//moveStones is based on 1-6, so add 1 to i when button is located.
						backend.moveStones(i + 1);
						//call functions that update the buttons' values.
						updateValues();
						player1HomeButton.updateValue();
						player2HomeButton.updateValue();
						currentPlayer.updateText();
						//check if the game ended after the move is complete.
						if(backend.getGameEnd())
						{
							gameEndAlert();
						}
					}
					catch(Exception e)
					{
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Error moving");
						alert.setContentText(e.getMessage());
						alert.showAndWait();
					}
				}
			}
		}
	}
}
