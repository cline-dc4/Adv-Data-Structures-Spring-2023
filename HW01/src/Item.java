
public class Item 
{
	/** the weight of the item */
	private double weight;
	/** the value of the item */
	private double value;
	
	/**
	 * the constructor for Item.
	 * @param weight the weight of the item
	 * @param value the value of the item
	 */
	public Item(double weight, double value) 
	{
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
	
	public String toString()
	{
		String s = "";
		s += "Weight: " + weight + " ";
		s += "Value: " + value + " ";
		s += "Ratio: " + (value / weight) + " ";
		return s;
	}
}
