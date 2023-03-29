/**
 * ALInterface
 * @author DThomas
 *
 */
public interface ALInterface {
	
	/**
	 * This method adds an item to the ArrayList
	 * @param weight The weight
	 * @param value The value
	 * @throws Exception If weight is less than or equal to 0, or if the value is negative
	 */
	public void addItem(double weight, double value) throws Exception;
	
	/**
	 * This method returns the index of the Item with the largest value to weight ratio
	 * @return The index of the Item
	 */
	public int findBestValue();
	
}
