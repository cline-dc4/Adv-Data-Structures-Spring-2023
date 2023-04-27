package application;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class BottomMessage extends GridPane implements ButtonCodes
{
	/** the message at the top that shows current player */
	private Label currentPlayer;
	
	/** the pointer to the backend */
	private Board backend;
	
	/**
	 * creates the label to be added at the bottom of the GUI
	 * @param backend the Board object passed in from the main
	 */
	public BottomMessage(Board backend)
	{
		this.backend = backend;
		currentPlayer = new Label();
		
		currentPlayer.setStyle(LIGHT_BROWN);
		currentPlayer.setText("  It's player " + backend.getCurrentPlayer()
		+ "'s turn!");
		this.add(currentPlayer, 0, 1);
	}
	
	/**
	 * will change the player number to be consistent with the backend.
	 */
	public void updateText()
	{
		currentPlayer.setText("  It's player " + backend.getCurrentPlayer()
		+ "'s turn!");
	}
}
