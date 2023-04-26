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
	/** array of Buttons that corresponds to the player 1 standard pockets. */
	private Button[] player1Pockets;
	
	/** array of Buttons that corresponds to the player 2 standard pockets. */
	private Button[] player2Pockets;
	
	/** Button that corresponds to the player 1 home pocket. */
	private Button player1HomePocket;
	
	/** Button that corresponds to the player 2 home pocket. */
	private Button player2HomePocket;
	
	/**
	 * the constructor that initializes the game board on the GUI.
	 */
	public PocketButtons()
	{
		player1Pockets = new Button[Board.NUM_POCKETS];
		player2Pockets = new Button[Board.NUM_POCKETS];
		
		for(int i = 0; i < Board.NUM_POCKETS; i++)
		{
			player1Pockets[i] = new Button();
			player1Pockets[i].setShape(new Circle(RADIUS));
			player1Pockets[i].setMaxWidth(WIDTH);
			player1Pockets[i].setMinWidth(WIDTH);
			player1Pockets[i].setMaxHeight(HEIGHT);
			player1Pockets[i].setMinHeight(HEIGHT);
			
			player2Pockets[i] = new Button();
			player2Pockets[i].setShape(new Circle(RADIUS));
			player2Pockets[i].setMaxWidth(WIDTH);
			player2Pockets[i].setMinWidth(WIDTH);
			player2Pockets[i].setMaxHeight(HEIGHT);
			player2Pockets[i].setMinHeight(HEIGHT);
		}
		
		player1HomePocket = new Button();
		player1HomePocket.setShape(new Circle(HOME_RADIUS));
		player1HomePocket.setMaxWidth(WIDTH);
		player1HomePocket.setMinWidth(WIDTH);
		player1HomePocket.setMaxHeight(HOME_HEIGHT);
		player1HomePocket.setMinHeight(HOME_HEIGHT);
		
		
		player2HomePocket = new Button();
		player2HomePocket.setShape(new Circle(HOME_RADIUS));
		player2HomePocket.setMaxWidth(WIDTH);
		player2HomePocket.setMinWidth(WIDTH);
		player2HomePocket.setMaxHeight(HOME_HEIGHT);
		player2HomePocket.setMinHeight(HOME_HEIGHT);
		
		this.add(player1HomePocket, 0, 0);
		this.add(player2HomePocket, (Board.NUM_POCKETS + 1), 0);
		
		for(int i = 1; i < Board.NUM_POCKETS + 1; i++)
		{
			this.add(player1Pockets[i - 1], i, 0);
			this.add(player2Pockets[i - 1], i, 1);
		}
	}
	
	
	public void handle(ActionEvent event) 
	{
		
	}

}
