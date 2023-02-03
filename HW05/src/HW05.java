/**
 * HW 3 shell
 * @author dthomas
 * Output: 
 * Inorder traversal: 
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
Preorder traversal: 
7 3 1 0 2 5 4 6 11 9 8 10 13 12 14 
Postorder traversal: 
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
The height of the tree is: 3
The number of nodes in the tree is: 15
DFS: Searching for 0
Search: 7 11 13 14 12 9 10 8 3 5 6 4 1 2 0 Found
DFS: Searching for 24
Search: 7 11 13 14 12 9 10 8 3 5 6 4 1 2 0 Not found
BFS: Searching for 0
Search: 7 3 11 1 5 9 13 0 Found
BFS: Searching for 24
Search: 7 3 11 1 5 9 13 0 2 4 6 8 10 12 14 Not found

 */
public class HW05 {

	/**
	 * Populating the tree with a set of nodes in order
	 * @return The root node
	 */
	public static Node<Integer> populateTree()
	{
		int [] arrayOfNum = {7, 3, 11, 1, 5, 9, 13, 0, 2, 4, 6, 8, 10, 12, 14};

		Node<Integer> [] arrayOfNodes = new Node[15];
		for (int i = 0; i < 15; i++)
		{
			arrayOfNodes[i] = new Node<Integer>(arrayOfNum[i]);
		}
		for (int i = 0; i < 7; i++)
		{
			arrayOfNodes[i].setLeftChild(arrayOfNodes[2*i+1]);
			arrayOfNodes[i].setRightChild(arrayOfNodes[2*i+2]);
		}
		return arrayOfNodes[0];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.setRootNode(populateTree());
		System.out.println("Inorder traversal: ");
		tree.inorderTraversal(tree.getRootNode());
		System.out.println("\nPreorder traversal: ");
		tree.preorderTraversal(tree.getRootNode());
		System.out.println("\nPostorder traversal: ");
		tree.postorderTraversal(tree.getRootNode());
		System.out.println("\nThe height of the tree is: " + tree.getHeightOfTree(tree.getRootNode()));
		System.out.println("The number of nodes in the tree is: " + tree.countNumberOfNodes(tree.getRootNode()));
		System.out.println(tree.dfs(tree.getRootNode(), 0));
		System.out.println(tree.dfs(tree.getRootNode(), 24));
		System.out.println(tree.bfs(tree.getRootNode(), 0));
		System.out.println(tree.bfs(tree.getRootNode(), 24));
			
	}

}
