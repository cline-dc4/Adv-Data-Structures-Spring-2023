import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
	
	public Knapsack()
	{
		itemArray = new ArrayList<Item>();
		doubleArray = new double [0];
	}
	
	/**
	 * This function reads in the file and populates the priority queue
	 * File format: 
	 * n
	 * ID weight value (n rows)
	 * @param fileName The name of the input file
	 * @throws FileNotFoundException If file is not found
	 */
	public void populate(String fileName) throws Exception 
	{

		Scanner input = new Scanner(new File("HW15File.txt"));
		int rows = input.nextInt();
		//create doubleArray and fill with 0's
		double [] doubleArray = new double[rows];
		for (int i = 0; i < rows; i++)
		{
			doubleArray[i] = 0;
		}
		setDoubleArray(doubleArray);
		
		//input items in file into itemArray
		String ID;
		double weight;
		double value;
		for (int i = 0; i < rows; i++)
		{
			ID = input.next();
			weight = input.nextDouble();
			value = input.nextDouble();
			Item newItem = new Item(ID, weight, value);
			itemArray.add(newItem);
		}
		Collections.sort(itemArray);
	}
	
	/**
	 * This method fills the knapsack to maximize the value
	 * @param capacity The input capacity
	 */
	public void fillKnapsack(int capacity) 
	{
		
	}
	
	/**
	 * This method returns the maximum value possible
	 * @return The maximum value
	 */
	public double getKnapsackValue()
	{
		return 0;
	}
	
	
}
