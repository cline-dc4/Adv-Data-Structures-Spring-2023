
public class BST 
{
	/** the root node of the tree. */
	private Node rootNode;
	/**
	 * a function that populates the tree with set values for testing.
	 * @return the root node.
	 */
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
	/**
	 * Adds a node to the tree based on data given.
	 * @param data the data to be added to the tree
	 * @throws Exception when data already is in the tree
	 */
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
			// add to the left if new < parent
			if(newNode.getData() < parent.getData())
			{
				parent.setLeftChild(newNode);
			}
			// add to the right if new > parents
			else
			{
				parent.setRightChild(newNode);
			}
		}
	}

	/**
	 * deletes a Node in the BST while keeping the tree in
	 * the BST format.
	 * @param dataToDelete an int that is the data being deleted.
	 * @throws Exception when dataToDelete is not in tree.
	 */
	public void deleteNode(int dataToDelete) throws Exception
	{	// TODO: issue with case 3 deleting incorrect node or throwing NPE
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
			nodeToDelete.setData(replacementNode.getData());
			// Now change it: so replacementNode is the new nodeToDelete
			nodeToDelete = replacementNode;
		}
		// When we get here, we are guaranteed that nodeToDelete is case 1 or case 2.
		// case 1:
		if (nodeToDelete.getLeftChild() == null && nodeToDelete.getRightChild() == null)
		{
			// root node:
			if (nodeToDelete.getParent() == null)
			{
				rootNode = null;
			}
			else
			{
				// left leaf:
				if (nodeToDelete.getParent().getLeftChild() == nodeToDelete)
				{
					nodeToDelete.getParent().setLeftChild(null);
					nodeToDelete.setParent(null);
				}
				// right leaf:
				else
				{
					nodeToDelete.getParent().setRightChild(null);
					nodeToDelete.setParent(null);
				}
			}

		}
		else // case 2:
		{
			//nodeToDelete is a rootNode with one child:
			if(nodeToDelete.getParent() == null)
			{
				if(nodeToDelete.getLeftChild() != null)
				{
					rootNode = nodeToDelete.getLeftChild();
					nodeToDelete.getLeftChild().setParent(null);
					nodeToDelete = null;
				}
				else
				{
					rootNode = nodeToDelete.getRightChild();
					nodeToDelete.getRightChild().setParent(null);
					nodeToDelete = null;
				}
			}
			// nodeToDelete is parent's right child:
			else if(nodeToDelete.getParent().getRightChild() == nodeToDelete)
			{
				// nodeToDelete only has a right child:
				if(nodeToDelete.getRightChild() != null)
				{
					nodeToDelete.getParent().setRightChild(nodeToDelete.getRightChild());
					nodeToDelete.getRightChild().setParent(nodeToDelete.getParent());
					nodeToDelete.setParent(null);
					nodeToDelete.setRightChild(null);
				}
				// nodeToDelete only has a left child:
				else
				{
					nodeToDelete.getParent().setRightChild(nodeToDelete.getLeftChild());
					nodeToDelete.getLeftChild().setParent(nodeToDelete.getParent());
					nodeToDelete.setParent(null);
					nodeToDelete.setLeftChild(null);
				}
			}
			// nodeToDelete is parent's left child:
			else
			{
				// nodeToDelete only has a right child:
				if(nodeToDelete.getRightChild() != null)
				{
					nodeToDelete.getParent().setLeftChild(nodeToDelete.getRightChild());
					nodeToDelete.getRightChild().setParent(nodeToDelete.getParent());
					nodeToDelete.setParent(null);
					nodeToDelete.setLeftChild(null);
				}
				// nodeToDelete only has a left child:
				else
				{
					nodeToDelete.getParent().setLeftChild(nodeToDelete.getLeftChild());
					nodeToDelete.getLeftChild().setParent(nodeToDelete.getParent());
					nodeToDelete.setParent(null);
					nodeToDelete.setLeftChild(null);
				}
			}
		}
	}

	/**
	 * the getter for the root node
	 * @return the root node.
	 */
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