
public class BinaryTree implements BinaryTreeInterface
{
	/**	a pointer to the root node of the tree. */
	private Node<Integer> rootNode;

	/**
	 * default constructor for a tree, sets rootNode to null.
	 */
	public BinaryTree()
	{
		setRootNode(null);
	}
	
	/**
	 * getter for the root node of the tree.
	 * @return a pointer to rootNode.
	 */
	public Node<Integer> getRootNode() 
	{
		return rootNode;
	}

	/**
	 * setter for the rootNode pointer.
	 * @param rootNode a pointer to the rootNode.
	 */
	public void setRootNode(Node<Integer> rootNode)
	{
		this.rootNode = rootNode;
	}

	/**
	 * will count the number of nodes in the tree.
	 * @param currentNode used recursivly, keep track of what node it is on.
	 * @return the number of nodes in the tree.
	 */
	public int countNumberOfNodes(Node<Integer> currentNode)
	{
		// base case
		if (currentNode == null)
		{
			return 0;
		}
		// recursive step
		return (1 + countNumberOfNodes(currentNode.getLeftChild()) +
				countNumberOfNodes(currentNode.getRightChild()));
	}
	
	/**
	 * will return the maximum height of the tree.
	 * @param currentNode used recursively, keeps track of the current node.
	 * @return the maximum height of the tree.
	 */
	public int getHeightOfTree(Node<Integer> currentNode)
	{
		// base case
		if(currentNode == null)
		{
			return -1; 
		}
		// recursive step
		return (1 + 7);
	}

	/**
	 * @param rootNode the rootNode of the tree being searched
	 * @param key the number being searched for.
	 * @return a string with the data from every checked node and a statement of if the key was found or not.
	 */
	public String bfs(Node<Integer> rootNode, int key) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param rootNode the rootNode of the tree being searched
	 * @param key the number being searched for.
	 * @return a string with the data from every checked node and a statement of if the key was found or not.
	 */
	public String dfs(Node<Integer> rootNode, int key) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Will traverse a tree using postorder traversal.
	 * @param currentNode used recursively, the node the function is currently on.
	 */
	public void postorderTraversal(Node<Integer> currentNode)
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * will traverse a tree using preorder traversal.
	 * @param currentNode used recursively, the nod the function is currently checking.
	 */
	public void preorderTraversal(Node<Integer> currentNode) 
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * will traverse a tree using inorder traversal.
	 * @param currentNode used recursively, the node the function is currently checking.
	 */
	public void inorderTraversal(Node<Integer> currentNode)
	{
		// TODO Auto-generated method stub
		
	}
}

