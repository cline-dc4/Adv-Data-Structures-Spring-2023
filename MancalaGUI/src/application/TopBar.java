package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

public class TopBar extends GridPane implements EventHandler<ActionEvent>
{
	/** will reset the game */
	private MenuItem resetGame;

	/** will exit the GUI */
	private MenuItem quit;

	/** a pointer to the Board object in Main. */
	Board backend;

	/** a pointer to the BottomMessage object in Main. */
	BottomMessage bottomMessage;

	/** a pointer to the pocketButtons object in Main. */
	PocketButtons pocketButtons;

	/** a pointer to the PlayerOneHomeButton object in Main. */
	PlayerOneHomeButton player1Home;

	/** a pointer to the PlayerTwoHomeButton object in Main. */
	PlayerTwoHomeButton player2Home;


	/**
	 * creates the TopBar and pointers it needs to use.
	 * @param backend a pointer to the Board object in Main
	 * @param bottomMessage a pointer to the BottomMessage object in Main.
	 * @param pocketButtons a pointer to the pocketButtons object in Main.
	 * @param Player1Home a pointer to the PlayerOneHomeButton object in Main.
	 * @param player2Home a pointer to the PlayerTwoHomeButton object in Main.
	 */
	public TopBar(Board backend, BottomMessage bottomMessage, PocketButtons pocketButtons,
			PlayerOneHomeButton player1Home, PlayerTwoHomeButton player2Home)
	{
		this.backend = backend;
		this.bottomMessage = bottomMessage;
		this.pocketButtons = pocketButtons;
		this.player1Home = player1Home;
		this.player2Home = player2Home;

		MenuBar mb = new MenuBar();
		Menu optionsMenu = new Menu("Options");

		resetGame = new MenuItem("Reset Game");
		quit = new MenuItem("Quit");

		optionsMenu.getItems().add(resetGame);
		optionsMenu.getItems().add(quit);

		resetGame.setOnAction(this);
		quit.setOnAction(this);

		mb.getMenus().add(optionsMenu);
		this.add(mb, 0, 0);
	}

	public void handle(ActionEvent event) 
	{
		if(event.getSource() == resetGame)
		{
			try
			{
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
