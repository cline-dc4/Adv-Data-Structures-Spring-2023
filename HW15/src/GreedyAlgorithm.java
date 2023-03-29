import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * Greedy Algorithm interface
 * @author dthomas
 *
 */
public interface GreedyAlgorithm {
	
	/**
	 * This function reads in the file and populates the priority queue
	 * File format: 
	 * n
	 * ID weight value (n rows)
	 * @param fileName The name of the input file
	 * @throws FileNotFoundException If file is not found
	 */
	public void populate(String fileName) throws Exception;
	
	/**
	 * This method fills the knapsack to maximize the value
	 * @param capacity The input capacity
	 */
	public void fillKnapsack(int capacity);
	
	/**
	 * This method returns the maximum value possible
	 * @return The maximum value
	 */
	public double getKnapsackValue();
}
