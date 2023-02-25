import java.util.Arrays;
/* Output
Test 1: 
Now you should see an empty string
=====================================
Test 2: Now you should see 5
5 
=====================================
Test 3: Now you should see 5 again
5 
=====================================
Test number: 4
Adding: 1 2 3
Root node (should be 1): 1
Deleting: 1
Should see: 2 3 
Root node (should be 2): 2
In order traversal: 2 3 
=======================================
Test number: 5
Adding: 1 2 3
Root node (should be 1): 1
Deleting: 2
Should see: 1 3 
Root node (should be 1): 1
In order traversal: 1 3 
=======================================
Test number: 6
Adding: 1 2 3
Root node (should be 1): 1
Deleting: 3
Should see: 1 2 
Root node (should be 1): 1
In order traversal: 1 2 
=======================================
Test number: 7
Adding: 1 3 2
Root node (should be 1): 1
Deleting: 1
Should see: 2 3 
Root node (should be 3): 3
In order traversal: 2 3 
=======================================
Test number: 8
Adding: 1 3 2
Root node (should be 1): 1
Deleting: 3
Should see: 1 2 
Root node (should be 1): 1
In order traversal: 1 2 
=======================================
Test number: 9
Adding: 1 3 2
Root node (should be 1): 1
Deleting: 2
Should see: 1 3 
Root node (should be 1): 1
In order traversal: 1 3 
=======================================
Test number: 10
Adding: 2 1 3
Root node (should be 2): 2
Deleting: 2
Should see: 1 3 
Root node (should be 3): 3
In order traversal: 1 3 
=======================================
Test number: 11
Adding: 2 1 3
Root node (should be 2): 2
Deleting: 1
Should see: 2 3 
Root node (should be 2): 2
In order traversal: 2 3 
=======================================
Test number: 12
Adding: 2 1 3
Root node (should be 2): 2
Deleting: 3
Should see: 1 2 
Root node (should be 2): 2
In order traversal: 1 2 
=======================================
Test number: 13
Adding: 3 1 2
Root node (should be 3): 3
Deleting: 3
Should see: 1 2 
Root node (should be 1): 1
In order traversal: 1 2 
=======================================
Test number: 14
Adding: 3 1 2
Root node (should be 3): 3
Deleting: 1
Should see: 2 3 
Root node (should be 3): 3
In order traversal: 2 3 
=======================================
Test number: 15
Adding: 3 1 2
Root node (should be 3): 3
Deleting: 2
Should see: 1 3 
Root node (should be 3): 3
In order traversal: 1 3 
=======================================
Test number: 16
Adding: 3 2 1
Root node (should be 3): 3
Deleting: 3
Should see: 1 2 
Root node (should be 2): 2
In order traversal: 1 2 
=======================================
Test number: 17
Adding: 3 2 1
Root node (should be 3): 3
Deleting: 2
Should see: 1 3 
Root node (should be 3): 3
In order traversal: 1 3 
=======================================
Test number: 18
Adding: 3 2 1
Root node (should be 3): 3
Deleting: 1
Should see: 2 3 
Root node (should be 3): 3
In order traversal: 2 3 
=======================================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 7
Inorder traversal after deletion
0 1 2 3 4 5 6 8 9 10 11 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 3
Inorder traversal after deletion
0 1 2 4 5 6 7 8 9 10 11 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 11
Inorder traversal after deletion
0 1 2 3 4 5 6 7 8 9 10 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 1
Inorder traversal after deletion
2 2 3 4 5 6 7 8 9 10 11 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 5
Inorder traversal after deletion
0 1 2 3 6 6 7 8 9 10 11 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 9
Inorder traversal after deletion
0 1 2 3 4 5 6 7 10 10 11 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 13
Inorder traversal after deletion
0 1 2 3 4 5 6 7 8 9 10 11 14 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 0
Inorder traversal after deletion
1 2 3 4 5 6 7 8 9 10 11 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 2
Inorder traversal after deletion
0 1 3 4 5 6 7 8 9 10 11 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 4
Inorder traversal after deletion
0 1 2 3 5 6 7 8 9 10 11 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 6
Inorder traversal after deletion
0 1 2 3 4 5 7 8 9 10 11 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 8
Inorder traversal after deletion
0 1 2 3 4 5 6 7 9 10 11 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 10
Inorder traversal after deletion
0 1 2 3 4 5 6 7 8 9 11 12 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 12
Inorder traversal after deletion
0 1 2 3 4 5 6 7 8 9 10 11 13 14 
===============================
Inorder traversal after inserting nodes
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Deleting: 14
Inorder traversal after deletion
0 1 2 3 4 5 6 7 8 9 10 11 12 13 
===============================
 */
public class TestBSTInsertionAndDeletion {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int testCount = 0;
		BST tree = new BST();
		try
		{
			// Checking deleting rootnode and leaf node
			tree.addData(5);
			tree.deleteNode(5);
			testCount = 1;
			System.out.println("Test 1: \nNow you should see an empty string");
			tree.inorderTraversal(tree.getRootNode());

			// Checking deleting a leaf node which is a left child
			tree = new BST();
			tree.addData(5);
			tree.addData(3);
			tree.deleteNode(3);
			testCount = 2;
			System.out.println("=====================================");
			System.out.println("Test 2: Now you should see 5");
			tree.inorderTraversal(tree.getRootNode());

			// Checking deleting a leaf node which is a right child
			tree = new BST();
			tree.addData(5);
			tree.addData(8);
			tree.deleteNode(8);
			testCount = 3;
			System.out.println("\n=====================================");
			System.out.println("Test 3: Now you should see 5 again");
			tree.inorderTraversal(tree.getRootNode());
			System.out.println("\n=====================================");
			
			testCount++;
			int [][] numbers = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {3, 1, 2}, {3, 2, 1}};
			for (int i = 0; i < 5; i++)
			{
				
				for (int j = 0; j < 3; j++)
				{
					tree = new BST();
					System.out.println("Test number: " + testCount);
					
					System.out.println("Adding: " + numbers[i][0] + " " + numbers[i][1] + " " + numbers[i][2]);

					for (int k = 0; k < 3; k++)
					{
						try
						{

							tree.addData(numbers[i][k]);
						}
						catch(Exception e)
						{
							System.out.println("Insertion error when trying to insert " + numbers[i][k] + " " + e.getMessage());
						}
					}	
					System.out.println("Root node (should be " + numbers[i][0] + "): " + tree.getRootNode().getData());
					System.out.println("Deleting: " + numbers[i][j]);
					int numberToDelete = numbers[i][j];
					try
					{
						tree.deleteNode(numbers[i][j]);
					}
					catch(Exception e)
					{
						System.out.println("Deletion error when trying to delete " + numbers[i][j] + " " + e.getMessage());
					}
					System.out.print("Should see: " );
					for (int m = 1; m < 4; m++)
					{
						if (numberToDelete != m)

							System.out.print(m + " ");
					}
					System.out.println();
					if (j == 0)
					{
						if (i == 2)

							System.out.println("Root node (should be " + numbers[i][2] + "): " + tree.getRootNode().getData());
						else
							System.out.println("Root node (should be " + numbers[i][1] + "): " + tree.getRootNode().getData());
					}
					else
						System.out.println("Root node (should be " + numbers[i][0] + "): " + tree.getRootNode().getData());
					System.out.print("In order traversal: ");
					tree.inorderTraversal(tree.getRootNode());

					System.out.println("\n=======================================");
					testCount++;
				}

			}

		}
		catch(Exception e)
		{
			System.out.println("Error at test number: " + testCount + " " + e.getMessage());
		}
		int [] array = {7, 3, 11, 1, 5, 9, 13, 0, 2, 4, 6, 8, 10, 12, 14};
		for (int i= 0; i < 15; i++)
		{
			BST b = new BST();
			try
			{
				for (int j = 0; j < 15; j++)
					b.addData(array[j]);
				System.out.println("Inorder traversal after inserting nodes");
				b.inorderTraversal(b.getRootNode());
				System.out.println("\nDeleting: " + array[i]);
				b.deleteNode(array[i]);
				System.out.println("Inorder traversal after deletion");
				b.inorderTraversal(b.getRootNode());
				System.out.println("\n===============================");
			}
			catch(Exception e)
			{
				System.out.println("Error at test number: " + testCount + e);
			}

		}
	}
}
