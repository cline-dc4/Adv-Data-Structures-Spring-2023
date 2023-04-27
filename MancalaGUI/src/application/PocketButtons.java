package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * creates the gameBoard of buttons for the GUI.
 * @author DC
 * @version 4/26/23
 */
public class PocketButtons extends GridPane implements EventHandler<ActionEvent>, ButtonCodes
{
	/** the pointer to the Board object. */
	private Board backend;
	
	/** a pointer to the Player1HomeButton. */
	private PlayerOneHomeButton player1HomeButton;
	
	/** a pointer to the Player2HomeButton. */
	private PlayerTwoHomeButton player2HomeButton;
	
	/** array of Buttons that corresponds to the player 1 standard pockets. */
	private Button[] player1Pockets;
	
	/** array of Buttons that corresponds to the player 2 standard pockets. */
	private Button[] player2Pockets;
	
	
	
	/**
	 * creates all the pockets that aren't the player home pockets.
	 * @param backend a pointer to the Board object in the main.
	 * @param player1HomeButton a pointer to the player 1 home button.
	 * @param player2HomeButton a pointer to the player 2 home button.
	 * @throws Exception from the Board class method getNumStones.
	 */

	public PocketButtons(Board backend, PlayerOneHomeButton player1HomeButton,
			PlayerTwoHomeButton player2HomeButton) throws Exception
	{
		this.backend = backend;
		this.player1HomeButton = player1HomeButton;
		this.player2HomeButton = player2HomeButton;
		
		player1Pockets = new Button[Board.NUM_POCKETS];
		player2Pockets = new Button[Board.NUM_POCKETS];
		
		for(int i = 0; i < Board.NUM_POCKETS; i++)
		{
			player1Pockets[i] = new Button(String.valueOf(backend.getNumStones(Board.PLAYER1, i)));
			player2Pockets[i] = new Button(String.valueOf(backend.getNumStones(Board.PLAYER2, i)));
			
			player1Pockets[i].setShape(new Circle(RADIUS));
			player1Pockets[i].setMaxWidth(WIDTH);
			player1Pockets[i].setMinWidth(WIDTH);
			player1Pockets[i].setMaxHeight(HEIGHT);
			player1Pockets[i].setMinHeight(HEIGHT);
			player1Pockets[i].setStyle(BROWN);
			player1Pockets[i].setOnAction(this);

			player2Pockets[i].setShape(new Circle(RADIUS));
			player2Pockets[i].setMaxWidth(WIDTH);
			player2Pockets[i].setMinWidth(WIDTH);
			player2Pockets[i].setMaxHeight(HEIGHT);
			player2Pockets[i].setMinHeight(HEIGHT);
			player2Pockets[i].setStyle(BROWN);
			player2Pockets[i].setOnAction(this);
		}
		
		for(int i = 1; i < Board.NUM_POCKETS + 1; i++)
		{
			this.add(player1Pockets[i - 1], i, 0);
			this.add(player2Pockets[i - 1], i, 1);
		}
	}
	
	public void updateValues() throws Exception
	{
		for(int i = 0; i < Board.NUM_POCKETS; i++)
		{
			player1Pockets[i].setText(String.valueOf(backend.getNumStones(Board.PLAYER1, i)));
			player2Pockets[i].setText(String.valueOf(backend.getNumStones(Board.PLAYER1, i)));
		}
	}
	
	public void handle(ActionEvent event) 
	{
		
	}

}
