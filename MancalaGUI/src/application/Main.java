package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * The main class for the Mancala GUI
 * @author DC
 * @version 4/26/23
 */
public class Main extends Application 
{
	// TODO create classes for each part of the GUI,
	// TODO buttons for the game board
	// TODO menubar for newGame and close game.
	// TODO label that describes instructions
	// TODO alert for end of game and winner
	// TODO maybe add a delay showing the motion of the stones?(just to annoy Crissy and Jordan lol)
	
	private PocketButtons pocketButtons;
	
	public Main()
	{
		pocketButtons = new PocketButtons();
	}
	
	public void start(Stage primaryStage) 
	{
		try 
		{
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,420,200);
			
			root.setCenter(pocketButtons);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
