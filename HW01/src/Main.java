
public class Main {

	public static void main(String[] args)
	{
		ItemList list = new ItemList();
		
		try 
		{
			list.addItem(8, 17);
			list.addItem(4,  2);
			list.addItem(17.443, 91.283);
			list.addItem(52.84, 0.23);
			
			System.out.println(list);
			System.out.println(list.findBestValue());
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

}
