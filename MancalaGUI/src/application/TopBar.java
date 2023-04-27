package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

	public TopBar()
	{
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
			
		}
		if(event.getSource() == quit)
		{
			System.exit(0);
		}
	}

}
