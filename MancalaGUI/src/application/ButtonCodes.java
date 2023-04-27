package application;

/**
 * An interface containing strings to format the buttons using CSS.
 * @author DC
 * @version 4/26/23
 */
public interface ButtonCodes 
{
	/** radius used for calling the constructor of Circle for normal pockets */
	public static int RADIUS = 50;
	
	/** radius used for calling the constructor of Circle for home pockets */
	public static int HOME_RADIUS = 100;
	
	/** the width used for setting maxWidth and minWidth of all pockets */
	public static int WIDTH = 50;
	
	/** the height used for setting maxWidth and minWidth of normal pockets */
	public static int HEIGHT = 50;
	
	/** the height used for setting maxWidth and minWidth of home pockets */
	public static int HOME_HEIGHT = 100;
	
	public static String BROWN = 
			"-fx-background-color: #964B00; " +
			"-fx-font: 20 px; " +
			"-fx-text-fill: #FFFFFF; ";
			
	public static String LIGHT_BROWN = 			
			"-fx-background-color: #C19A6B; " +
			"-fx-font: 16 px; ";
}
