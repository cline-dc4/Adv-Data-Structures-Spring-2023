import java.util.ArrayList;

public class Knapsack implements GreedyAlgorithm
{
	/** an arrayList that holds Item objects. */
	private ArrayList<Item> itemArray;
	/** an array that holds doubles. */
	private double[] doubleArray;
	
	/**
	 * the getter for itemArray
	 * @return the itemArray
	 */
	public ArrayList<Item> getItemArray() 
	{
		return itemArray;
	}
	/**
	 * the setter for itemArray
	 * @param itemArray the arrayList being set
	 */
	public void setItemArray(ArrayList<Item> itemArray) 
	{
		this.itemArray = itemArray;
	}
	
	/**
	 * the getter for doubleArray
	 * @return the doubleArray
	 */
	public double[] getDoubleArray() 
	{
		return doubleArray;
	}
	
	/**
	 * the setter for doubleArray
	 * @param doubleArray the array being set
	 */
	public void setDoubleArray(double[] doubleArray)
	{
		this.doubleArray = doubleArray;
	}
	@Override
	public void populate(String fileName) throws Exception 
	{
		
	}
	@Override
	public void fillKnapsack(int capacity) 
	{
		
	}
	@Override
	public double getKnapsackValue()
	{
		return 0;
	}
	
	
}
