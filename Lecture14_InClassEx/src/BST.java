
public class BST {
	private Node rootNode;
	public Node populateTree()
	{
		int [] arrayOfNum = {7, 3, 11, 1, 5, 9, 13, 0, 2, 4, 6, 8, 10, 12, 14};

		Node [] arrayOfNodes = new Node[15];
		for (int i = 0; i < 15; i++)
		{
			arrayOfNodes[i] = new Node(arrayOfNum[i]);
		}
		for (int i = 0; i < 7; i++)
		{
			arrayOfNodes[i].setLeftChild(arrayOfNodes[2*i+1]);
			arrayOfNodes[i].setRightChild(arrayOfNodes[2*i+2]);
		}
		return arrayOfNodes[0];
	}
	
	public BST()
	{
		rootNode = populateTree();
	}

	public Node getRootNode()
	{
		return rootNode;
	}
	public void inorderTraversal(Node currentNode)
	{
		// Base case
		if (currentNode == null)
			return;
		// Otherwise, process left child
		inorderTraversal(currentNode.getLeftChild());
		System.out.print(currentNode.getData() + " ");
		inorderTraversal(currentNode.getRightChild());
	}
	
	public Node recursiveSearch(Node currentNode, int key)
	{
		// not found
		if (currentNode == null)
			return null;
		// base case: found at currentNode
		if (currentNode.getData() == key)
			return currentNode;
		if (currentNode.getData() < key) // move right
			return recursiveSearch(currentNode.getRightChild(), key);
		else // move left
			return recursiveSearch(currentNode.getLeftChild(), key);
	}
}
