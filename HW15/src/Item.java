
public class Item implements Comparable<Item>
{
	/** the weight of the item */
	private double weight;
	/** the value of the item */
	private double value;
	/** the ID of the item */
	private String ID;
	
	/**
	 * the constructor for Item.
	 * @param weight the weight of the item
	 * @param value the value of the item
	 */
	public Item(String ID, double weight, double value) 
	{
		this.setID(ID);
		this.setValue(value);
		this.setWeight(weight);
	}

	/**
	 * the setter for weight
	 * @param weight the weight of the item
	 */
	public void setWeight(double weight)
	{
		this.weight = weight;
	}
	
	/**
	 * the getter for weight
	 * @return weight
	 */
	public double getWeight()
	{
		return weight;
	}
	
	/**
	 * the setter for value
	 * @param value the value of the item
	 */
	public void setValue(double value)
	{
		this.value = value;
	}
	
	/**
	 * the getter for value
	 * @return value
	 */
	public double getValue()
	{
		return value;
	}
	
	public void setID(String ID)
	{
		this.ID = ID;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public String toString()
	{
		String s = "";
		s += "ID: " + ID + " ";
		s += "Weight: " + weight + " ";
		s += "Value: " + value + " ";
		s += "Ratio: " + (value / weight) + " ";
		return s;
	}

	public int compareTo(Item compareItem) 
	{
		double thisRatio = (this.getValue() / this.getWeight());
		double compareRatio = (compareItem.getValue() / compareItem.getWeight());
		if(thisRatio > compareRatio)
		{
			return -1;
		}
		else if(thisRatio < compareRatio)
		{
			
		}
		return 0;
	}
}
