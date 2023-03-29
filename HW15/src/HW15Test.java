
public class HW15Test {

	public static void main(String[] args) {
		// TEST 1
		try {
			Item i1 = new Item("I1", 3, 5);
			System.out.println(i1);
			Item i2 = new Item("I2", 30, 5);
			System.out.println(i2);
			if (i1.compareTo(i2) > 0)
				System.out.println("I1 has lower value/weight ratio than I2");
			else
				System.out.println("I1 has higher value/weight ratio than I2");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		GreedyAlgorithm ga = new Knapsack();
//		try {
//			ga.populate("HW15File.txt");
//			ga.fillKnapsack(8);
//			System.out.println(ga);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
}
