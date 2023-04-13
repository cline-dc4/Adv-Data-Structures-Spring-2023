/**
 * This class is essentially a modified node class for a linked list.
 * It will act as the pockets in the mancala board and also store pointers
 * to the next pocket.
 * @author DC
 * @version 4/13/23
 */
public interface Pocket 
{
	/** the pointer to the next pocket */
	//private Pocket next;
	
	/** the int that refers to the owner of the pocket */
	//private int owner;
	
	/** the number of stones the pocket holds */
	//private int numStones;
	
	/** true if home pocket, else false. */
	//private Boolean homePocket;
	
	/** the pointer to the pocket this one can capture from, is null if homePocket is true */
	//private Pocket capturePocket;
	
	
	/**
	 * creates a pocket with given owner and number of stones.
	 * @param player
	 * @param numStones
	 */
	//public Pocket(int player, int numStones);
	
	
	/**
	 * gives the pointer to the next Pocket in the list.
	 * @return a pointer to the next Pocket.
	 */
	public Pocket getNext();
	
	
	/**
	 * The getter for numStones.
	 * @return the number of stones in the pocket.
	 */
	public int getNumStones();
	
	
	/**
	 * the getter for owner.
	 * @return the int of the owner of the pocket.
	 */
	public int getOwner();
	
	
	/**
	 * shows whether or not the pocket is a home pocket
	 * @return true if home pocket, else false
	 */
	public Boolean isHomePocket();
	

	/**
	 * gives a pointer to the pocket this one can capture from.
	 * @return a pointer to a Pocket.
	 */
	public Pocket getCapturePocket();
	
	
	/**
	 * the setter for the capturePocket.
	 * @param the pocket to be pointed to.
	 */
	public void setCapturePocket(Pocket capturePocket);
	
	
	/**
	 * sets the numStones to 0, as if a player picked them up and is using them.
	 */
	public void removeStones();
	
	
	/**
	 * increments numStones by 1, as if a player set one stone down in the pocket.
	 */
	public void incrementStones();
	
	
	/**
	 * just prints out the numStones variable, makes the other toString in PocketList simpler.
	 * @return the string being printed.
	 */
	public String toString();
}
