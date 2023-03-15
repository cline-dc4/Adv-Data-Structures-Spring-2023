import java.util.Random;
/*
Step: 0 Inserting: 0
Size: 1
0 
Step: 1 Inserting: 1
Before percolate up
Size: 2
0 1 
After percolate up
Size: 2
1 0 
Size: 2
1 0 
Step: 2 Inserting: 2
Before percolate up
Size: 3
1 0 2 
After percolate up
Size: 3
2 0 1 
Size: 3
2 0 1 
Step: 3 Inserting: 3
Before percolate up
Size: 4
2 0 1 3 
After percolate up
Size: 4
3 2 1 0 
Size: 4
3 2 1 0 
Step: 4 Inserting: 4
Before percolate up
Size: 5
3 2 1 0 4 
After percolate up
Size: 5
4 3 1 0 2 
Size: 5
4 3 1 0 2 
Step: 5 Inserting: 5
Before percolate up
Size: 6
4 3 1 0 2 5 
After percolate up
Size: 6
5 3 4 0 2 1 
Size: 6
5 3 4 0 2 1 
Step: 6 Inserting: 6
Before percolate up
Size: 7
5 3 4 0 2 1 6 
After percolate up
Size: 7
6 3 5 0 2 1 4 
Size: 7
6 3 5 0 2 1 4 
Step: 7 Inserting: 7
Before percolate up
Size: 8
6 3 5 0 2 1 4 7 
After percolate up
Size: 8
7 6 5 3 2 1 4 0 
Size: 8
7 6 5 3 2 1 4 0 
Step: 8 Inserting: 8
Before percolate up
Size: 9
7 6 5 3 2 1 4 0 8 
After percolate up
Size: 9
8 7 5 6 2 1 4 0 3 
Size: 9
8 7 5 6 2 1 4 0 3 
Step: 9 Inserting: 9
Before percolate up
Size: 10
8 7 5 6 2 1 4 0 3 9 
After percolate up
Size: 10
9 8 5 6 7 1 4 0 3 2 
Size: 10
9 8 5 6 7 1 4 0 3 2 
Before to percolate down
Size: 9
2 8 5 6 7 1 4 0 3 
After percolate down
Size: 9
8 7 5 6 2 1 4 0 3 
Data removed: 9
Before to percolate down
Size: 8
3 7 5 6 2 1 4 0 
After percolate down
Size: 8
7 6 5 3 2 1 4 0 
Data removed: 8
Step: 0 Inserting: 3
Size: 1
3 
Step: 1 Inserting: 36
Before percolate up
Size: 2
3 36 
After percolate up
Size: 2
36 3 
Size: 2
36 3 
Step: 2 Inserting: 1
Before percolate up
Size: 3
36 3 1 
After percolate up
Size: 3
36 3 1 
Size: 3
36 3 1 
Step: 3 Inserting: 11
Before percolate up
Size: 4
36 3 1 11 
After percolate up
Size: 4
36 11 1 3 
Size: 4
36 11 1 3 
Step: 4 Inserting: 5
Before percolate up
Size: 5
36 11 1 3 5 
After percolate up
Size: 5
36 11 1 3 5 
Size: 5
36 11 1 3 5 
Step: 5 Inserting: 45
Before percolate up
Size: 6
36 11 1 3 5 45 
After percolate up
Size: 6
45 11 36 3 5 1 
Size: 6
45 11 36 3 5 1 
Step: 6 Inserting: 33
Before percolate up
Size: 7
45 11 36 3 5 1 33 
After percolate up
Size: 7
45 11 36 3 5 1 33 
Size: 7
45 11 36 3 5 1 33 
Step: 7 Inserting: 5
Before percolate up
Size: 8
45 11 36 3 5 1 33 5 
After percolate up
Size: 8
45 11 36 5 5 1 33 3 
Size: 8
45 11 36 5 5 1 33 3 
Step: 8 Inserting: 43
Before percolate up
Size: 9
45 11 36 5 5 1 33 3 43 
After percolate up
Size: 9
45 43 36 11 5 1 33 3 5 
Size: 9
45 43 36 11 5 1 33 3 5 
Step: 9 Inserting: 38
Before percolate up
Size: 10
45 43 36 11 5 1 33 3 5 38 
After percolate up
Size: 10
45 43 36 11 38 1 33 3 5 5 
Size: 10
45 43 36 11 38 1 33 3 5 5 
Before to percolate down
Size: 9
5 43 36 11 38 1 33 3 5 
After percolate down
Size: 9
43 38 36 11 5 1 33 3 5 
Data removed: 45

 */
public class HW13Test {

	public static void main(String[] args) {
		HeapClass heap = new BinaryHeap();
		for (int i = 0; i < 10; i++)
		{
			System.out.println("Step: " + i + " Inserting: " + i);
			heap.insertNode(i);
			heap.levelOrderTraversal();
		}
		for (int i = 0; i < 2; i++)
		{

			try {
				Integer dataRemoved = heap.removeNode().getData();
				System.out.println("Data removed: " + dataRemoved);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
		heap = new BinaryHeap();
		Random r = new Random(20);
		for (int i = 0; i < 10; i++)
		{
			Integer x = r.nextInt(50);
			System.out.println("Step: " + i + " Inserting: " + x);
			heap.insertNode(x);
			heap.levelOrderTraversal();
		}
		try {
			Integer dataRemoved = heap.removeNode().getData();
			System.out.println("Data removed: " + dataRemoved);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
