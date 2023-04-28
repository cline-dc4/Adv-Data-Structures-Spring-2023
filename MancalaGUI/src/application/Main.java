package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

/**
 * The main class for the Mancala GUI
 * @author DC
 * @version 4/28/23
 */
public class Main extends Application 
{
	// TODO steal Crissy's idea of color themes?
	// TODO maybe add a delay showing the motion of the stones?

	/** the backend/logic for the mancala game */
	private Board backend;

	private BottomMessage bottomMessage;
	/** the normal pockets that make up the game board */
	private PocketButtons pocketButtons;

	/** player 1's home pocket */
	private PlayerHomeButton player1Home;

	/** player 2's home pocket */
	private PlayerHomeButton player2Home;

	/** the menuBar at the top of the GUI */
	private TopBar topBar;

	/**
	 * the constructor that is initializing all the pieces of the GUI
	 */
	public Main()
	{
		try 
		{
			backend = new Board();
			bottomMessage = new BottomMessage(backend);
			player1Home = new PlayerHomeButton(backend, Board.PLAYER1); // combine into one class
			player2Home = new PlayerHomeButton(backend, Board.PLAYER2);
			pocketButtons = new PocketButtons(backend, player1Home, player2Home, bottomMessage);
			topBar = new TopBar(backend, bottomMessage, pocketButtons, player1Home, player2Home);
		} 
		catch (Exception e) 
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
			Scene scene = new Scene(root, 600, 250);

			//add all the GUI elements to the border pane.
			primaryStage.setTitle("Mancala - DC Cline");
			root.setCenter(pocketButtons);
			root.setRight(player1Home);
			root.setLeft(player2Home);
			root.setTop(topBar);
			root.setBottom(bottomMessage);
			root.setStyle(ButtonCodes.LIGHT_BROWN);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch (Exception e)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error!");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
