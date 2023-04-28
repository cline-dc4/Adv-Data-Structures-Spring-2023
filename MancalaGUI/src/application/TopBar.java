package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

/**
 * The class that creates the menu bar at the top of the GUI
 * @author DC
 * @version 4/28/23
 */
public class TopBar extends GridPane implements EventHandler<ActionEvent>
{
	/** will reset the game */
	private MenuItem resetGame;

	/** will exit the GUI */
	private MenuItem quit;

	/** a pointer to the Board object in Main. */
	private Board backend;

	/** a pointer to the BottomMessage object in Main. */
	private BottomMessage bottomMessage;

	/** a pointer to the pocketButtons object in Main. */
	private PocketButtons pocketButtons;

	/** a pointer to the PlayerOneHomeButton object in Main. */
	private PlayerHomeButton player1Home;

	/** a pointer to the PlayerTwoHomeButton object in Main. */
	private PlayerHomeButton player2Home;


	/**
	 * creates the TopBar and pointers it needs to use.
	 * @param backend a pointer to the Board object in Main
	 * @param bottomMessage a pointer to the BottomMessage object in Main.
	 * @param pocketButtons a pointer to the pocketButtons object in Main.
	 * @param Player1Home a pointer to the PlayerOneHomeButton object in Main.
	 * @param player2Home a pointer to the PlayerTwoHomeButton object in Main.
	 */
	public TopBar(Board backend, BottomMessage bottomMessage, PocketButtons pocketButtons,
			PlayerHomeButton player1Home, PlayerHomeButton player2Home)
	{
		//set all pointers to point to the correct places.
		this.backend = backend;
		this.bottomMessage = bottomMessage;
		this.pocketButtons = pocketButtons;
		this.player1Home = player1Home;
		this.player2Home = player2Home;

		//create the menu bar and menu
		MenuBar mb = new MenuBar();
		Menu optionsMenu = new Menu("Options");

		//create the menu items
		resetGame = new MenuItem("Reset Game");
		quit = new MenuItem("Quit");

		//add all of them together.
		optionsMenu.getItems().add(resetGame);
		optionsMenu.getItems().add(quit);
		resetGame.setOnAction(this);
		quit.setOnAction(this);
		mb.getMenus().add(optionsMenu);
		this.add(mb, 0, 0);
	}

	/**
	 * the handle method for TopBar, allows the game to be reset and 
	 * the GUI to be exited.
	 */
	public void handle(ActionEvent event) 
	{
		if(event.getSource() == resetGame)
		{
			try
			{
				//reset the backend to its default values then update all GUI elements.
				backend.resetBoard();
				bottomMessage.updateText();
				pocketButtons.updateValues();
				player1Home.updateValue();
				player2Home.updateValue();
			}
			catch(Exception e)
			{
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error resetting game board.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		}
		if(event.getSource() == quit)
		{
			System.exit(0);
		}
	}

}
