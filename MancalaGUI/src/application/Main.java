package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

/**
 * The main class for the Mancala GUI
 * @author DC
 * @version 4/26/23
 */
public class Main extends Application
{
	// TODO menubar for newGame and close game.
	// TODO label that describes instructions
	// TODO alert for end of game and winner
	// TODO maybe add a delay showing the motion of the stones?(just to annoy Crissy and Jordan lol)
	
	/** the backend/logic for the mancala game */
	private Board backend;
	
	/** the normal pockets that make up the game board */
	private PocketButtons pocketButtons;
	
	/** player 1's home pocket */
	private PlayerOneHomeButton player1Home;
	
	/** player 2's home pocket */
	private PlayerTwoHomeButton player2Home;
	public Main()
	{
		try
		{
		backend = new Board();
		player1Home = new PlayerOneHomeButton(backend);
		player2Home = new PlayerTwoHomeButton(backend);
		pocketButtons = new PocketButtons(backend, player1Home, player2Home);

		}
		catch(Exception e)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error creating game board.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	public void start(Stage primaryStage) 
	{
		try 
		{
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,200);
			
			primaryStage.setTitle("Mancala - DC Cline");
			root.setCenter(pocketButtons);
			root.setRight(player1Home);
			root.setLeft(player2Home);
			root.setStyle(ButtonCodes.LIGHT_BROWN);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error!");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
