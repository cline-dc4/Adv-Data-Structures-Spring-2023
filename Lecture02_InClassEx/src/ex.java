
public class ex 
{
	public static void main(String[] args)
	{
		int [] arrayOfInts = {3, 5, 2, 8, 0};
		int [] greaterElements = findGreaterOnRight(arrayOfInts);
		for (int i = 0; i < greaterElements.length; i++)
		{
			System.out.println(greaterElements[i]);
		}
	}

	public static int [] findGreaterOnRight(int [] arrayOfInts)
	{
		int [] greaterElements = new int[arrayOfInts.length - 1];

		// Outer Loop: Iterate through all but the last element
		for (int i = 0; i < arrayOfInts.length - 1; i++)
		{
			int rightCounter = i + 1;
			while(rightCounter < arrayOfInts.length && 
					arrayOfInts[rightCounter] <= arrayOfInts[i])
			{
				rightCounter++;
			}
			// When we get here, the rightCounter is either too big
			// or we have found the first largest number
			if (rightCounter == arrayOfInts.length)
			{
				greaterElements[i] = -1;
			}
			else
			{
				greaterElements[i] = rightCounter;
			}
		}
		return greaterElements;
	}
	
}
