import java.util.ArrayList;

public class ItemList implements ALInterface
{

	/** an ArrayList that holds Item objects */
	private ArrayList<Item> itemArray;
	
	/** 
	 * the constructor for the ItemList class.
	 */
	public ItemList()
	{
		itemArray = new ArrayList<Item>(10);
	}
	
	/**************************************************
	 *         adds an item to the ArrayList                     
	 * @param  weight the weight of the item              
     * @param  value the value of the item                
	 * @throws Exception when weight <= 0, value < 0.    
	 **************************************************/
	public void addItem(double weight, double value) throws Exception 
	{
		if(weight <= 0)
		{
			throw new Exception("The weight cannot be less than or equal to 0.");
		}
		
		if (value < 0)
		{
			throw new Exception("The value cannot be less than 0.");
		}

		itemArray.add(new Item(weight, value));
	}

	/**
	 * finds the item with the best ratio.
	 * @return the index of the item in the list.
	 */
	public int findBestValue()
	{
		int bestIndex = -1;
		double bestRatio = 0;
		
		for(int i = 0; i < itemArray.size(); i++)
		{
			if(itemArray.get(i).getValue()/itemArray.get(i).getWeight() > bestRatio)
			{
				bestIndex = i;
				bestRatio = itemArray.get(i).getValue()/itemArray.get(i).getWeight();
			}
		}
		return bestIndex;
	}
	
	/**
	 * converts the ArrayList of items into a string.
	 * @return String the string of items.
	 */
	public String toString()
	{
		String s = "";
		
		s += "Size of list: " + itemArray.size() + "\n";
		for(int i = 0; i < itemArray.size(); i++)
		{
			s += "Item " + i + ": " + itemArray.get(i) + "\n";
		}
		
		return s;
	}

}
