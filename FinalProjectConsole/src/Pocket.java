//most javadocs are in the interface PocketInterface.
public class Pocket implements PocketInterface
{
	/** the pointer to the next pocket */
	private Pocket next;
	
	/** the int that refers to the owner of the pocket */
	private int owner;
	
	/** the number of stones the pocket holds */
	private int numStones;
	
	/** true if home pocket, else false. */
	private Boolean homePocket;
	
	/** the pointer to the pocket this one can capture from, is null if homePocket is true */
	private Pocket capturePocket;
	
	

	public Pocket(int player, int numStones, Boolean homePocket)
	{
		next = null;
		owner = player;
		this.numStones = numStones;
		this.homePocket = homePocket;
		//set later through the setter.
		capturePocket = null;
	}
	
	public void setNext(Pocket next)
	{
		this.next = next;
	}
	
	public Pocket getNext() 
	{
		return next;
	}

	public int getNumStones() 
	{
		return numStones;
	}

	public int getOwner() 
	{
		return owner;
	}

	public Boolean isHomePocket() 
	{
		return homePocket;
	}

	public void setCapturePocket(Pocket capturePocket) 
	{
		this.capturePocket = capturePocket;
	}
	
	public Pocket getCapturePocket() 
	{
		return capturePocket;
	}

	public void removeStones() 
	{
		numStones = 0;
	}

	public void incrementStones() 
	{
		numStones++;
	}

	public String toString()
	{
		return "" + numStones;
	}
}
