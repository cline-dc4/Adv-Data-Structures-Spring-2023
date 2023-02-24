
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
		//rootNode = populateTree();
		rootNode = null;
	}
	
	public void addData(int data) throws Exception
	{
		// Check if it already exists in the tree
		if(recursiveSearch(rootNode, data) != null)
			throw new Exception("Data already exists in the tree.");
		Node newNode = new Node(data);
		// Special case: rootNode is null
		if(rootNode == null)
			rootNode = newNode;
		else
		{
			Node current = rootNode;
			Node parent = rootNode;
			while (current != null)
			{
				if (current.getData() < data)
				{
					parent = current;
					current = current.getRightChild();
				}
				else
				{
					parent = current;
					current = current.getLeftChild();
				}
			}
			// when we get here, parent is the parent of the new node
			// TODO: Insert new node as left child/right child depending on how it compares to parent
		}
	}
	
	public void deleteNode(int dataToDelete) throws Exception
	{
		Node nodeToDelete = recursiveSearch(rootNode, dataToDelete);
		if (nodeToDelete == null)
			throw new Exception("node to delete does not exist.");
		// Case 3:
		if (nodeToDelete.getLeftChild() != null && nodeToDelete.getRightChild() != null)
		{
			// find the replacement node
			Node replacementNode = nodeToDelete.getRightChild();
			while(replacementNode.getLeftChild() != null)
			{
				replacementNode = replacementNode.getLeftChild();
			}
			// TODO: copy the data from replacement node to nodeToDelete
			// Now change it: so replacementNode is the new nodeToDelete
			nodeToDelete = replacementNode;
		}
		// When we get here, we are guaranteed that nodeToDelete is case 1 or case 2.
		// case 1:
		if (nodeToDelete.getLeftChild() == null && nodeToDelete.getRightChild() == null)
		{
			// TODO: implement case 1
		}
		else //case 2:
		{
			// TODO: implement case 2
		}
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
	
	public Node iterativeSearch(int key)
	{
		return new Node();
	}
}