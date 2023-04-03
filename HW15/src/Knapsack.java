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
	/** the max value the knapsack can have */
	private double maxValue;
	
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
	
	/**
	 * the setter for maxValue
	 * @param maxValue the maxValue of the knapsack
	 */
	public void setMaxValue(double maxValue) 
	{
		this.maxValue = maxValue;
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
		Scanner input = new Scanner(new File(fileName));

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
//		for (int i = 0; i < rows; i++)
//			System.out.println(itemArray.get(i)); 
	}
	
	/**
	 * This method fills the knapsack to maximize the value
	 * @param capacity The input capacity
	 */
	public void fillKnapsack(int capacity) 
	{
		for (int i = 0; i < itemArray.size(); i++)
		{
			//capacity is larger than weight, so use all of an item.
			if (capacity > itemArray.get(i).getWeight())
			{
				capacity -= itemArray.get(i).getWeight();
				doubleArray[i] = 1;
				maxValue += itemArray.get(i).getValue();
			}
			//capacity is smaller than weight but not 0, so use part of an item.
			else if (capacity < itemArray.get(i).getWeight() && capacity != 0)
			{
				doubleArray[i] = capacity/itemArray.get(i).getWeight();
				maxValue += itemArray.get(i).getValue()*
						(capacity / itemArray.get(i).getWeight());
				capacity = 0;
			}
		}
	}
	
	/**
	 * This method returns the maximum value possible
	 * @return The maximum value
	 */
	public double getKnapsackValue()
	{
		return maxValue;
	}

	/**
	 * creates a string based on the data inside the Knapsack object.
	 */
	public String toString()
	{
		String s = "";
		//printing out list of items
		for (int i = 0; i < itemArray.size(); i++)
		{
			s += (i + 1 + ": ");
			s += (itemArray.get(i));
			s += "\n";		
		}
		//printing out items inside knapsack
		s += "Knapsack:\n";
		for (int i = 0; i < itemArray.size(); i++)
		{
			if(doubleArray[i] != 0)
			{
				s += (itemArray.get(i));
				s += ("Percentage added: " + (doubleArray[i] * 100) + "%");
				s += "\n";
			}
		}
		s += "\n" + "Value: " + maxValue;
		return s;
	}
}
