package application;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * creates a button to display player 1's home pocket
 * @author DC
 * @version 4/28/23
 */
public class PlayerHomeButton extends GridPane implements ButtonCodes
{
	/** the player number of the home pocket. */
	private int player;
	/** the home pocket for Player 1 */
	private Button homePocket;
	
	/** the pointer to the Board object. */
	private Board backend;
	
	/**
	 * creates the button and adds it to the GUI.
	 * @param backend a pointer to the Board object in the main
	 * @throws Exception from the Board class method getNumStones.
	 */
	public PlayerHomeButton(Board backend, int player) throws Exception
	{
		this.backend = backend;
		this.player = player;
		//give the pocket the correct value.
		homePocket = new Button(String.valueOf(backend.getNumStones(player,  -1)));
		homePocket.setShape(new Circle(RADIUS));
		homePocket.setMaxWidth(WIDTH);
		homePocket.setMinWidth(WIDTH);
		homePocket.setMaxHeight(HOME_HEIGHT);
		homePocket.setMinHeight(HOME_HEIGHT);
		homePocket.setStyle(BROWN);
		this.add(homePocket, 0, 0);
	}
	
	/**
	 * will change the number on the button to be consistent
	 * with the backend.
	 * @throws Exception from the Board class method getNumStones.
	 */
	public void updateValue() throws Exception
	{
		homePocket.setText(String.valueOf(backend.getNumStones(player,  -1)));
	}
}
