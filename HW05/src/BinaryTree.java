import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree implements BinaryTreeInterface
{
	/**	a pointer to the root node of the tree. */
	private Node rootNode;

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
	public Node getRootNode() 
	{
		return rootNode;
	}

	/**
	 * setter for the rootNode pointer.
	 * @param rootNode a pointer to the rootNode.
	 */
	public void setRootNode(Node rootNode)
	{
		this.rootNode = rootNode;
	}

	/**
	 * will count the number of nodes in the tree.
	 * @param currentNode used recursivly, keep track of what node it is on.
	 * @return the number of nodes in the tree.
	 */
	public int countNumberOfNodes(Node currentNode)
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
	public int getHeightOfTree(Node currentNode)
	{
		// base case
		if(currentNode == null)
		{
			return -1; 
		}
		// recursive step
		if(getHeightOfTree(currentNode.getLeftChild()) > getHeightOfTree(currentNode.getRightChild()))
		{
			return(1 + getHeightOfTree(currentNode.getLeftChild()));
		}
		else
		{
			return(1 + getHeightOfTree(currentNode.getRightChild()));
		}
	}

	/**
	 * @param rootNode the rootNode of the tree being searched
	 * @param key the number being searched for.
	 * @return a string with the data from every checked node and a statement of if the key was found or not.
	 */
	public String bfs(Node rootNode, int key) 
	{
		String s = "BFS: Searching for " + key + "\n";
		Node currentNode = rootNode;
		LinkedList<Node> queueOfNodes = new LinkedList<Node>();
		// push the root node onto the stack
		queueOfNodes.push(rootNode);
		while(!queueOfNodes.isEmpty())
		{
			currentNode = queueOfNodes.pop();
			s += (currentNode.getData() + " ");
			if(currentNode.getData() == key)
			{
				s += "Found!";
				return s;
			}
			else
			{
				if(currentNode.getLeftChild() != null)
				{
					queueOfNodes.add(currentNode.getLeftChild());
				}
				if(currentNode.getRightChild() != null)
				{
					queueOfNodes.add(currentNode.getRightChild());
				}
			}
		}		
		s += "Not found.";
		return s;
	}

	/**
	 * @param rootNode the rootNode of the tree being searched
	 * @param key the number being searched for.
	 * @return a string with the data from every checked node and a statement of if the key was found or not.
	 */
	public String dfs(Node rootNode, int key) 
	{
		String s = "DFS: Searching for " + key + "\n";
		Node currentNode = rootNode;
		Stack<Node> stackOfNodes = new Stack<Node>();
		// push the root node onto the stack
		stackOfNodes.push(rootNode);
		while(!stackOfNodes.isEmpty())
		{
			currentNode = stackOfNodes.pop();
			s += (currentNode.getData() + " ");
			if(currentNode.getData() == key)
			{
				s += "Found!";
				return s;
			}
			else
			{
				if(currentNode.getLeftChild() != null)
				{
					stackOfNodes.add(currentNode.getLeftChild());
				}
				if(currentNode.getRightChild() != null)
				{
					stackOfNodes.add(currentNode.getRightChild());
				}
			}		
		}
		s += "Not found.";
		return s;
	}

	/**
	 * Will traverse a tree using postorder traversal.
	 * @param currentNode used recursively, the node the function is currently on.
	 */
	public void postorderTraversal(Node currentNode)
	{
		// Base case
		if (currentNode == null)
			return;
		// process left child
		postorderTraversal(currentNode.getLeftChild());
		postorderTraversal(currentNode.getRightChild());
		System.out.print(currentNode.getData() + " ");
	}

	/**
	 * will traverse a tree using preorder traversal.
	 * @param currentNode used recursively, the nod the function is currently checking.
	 */
	public void preorderTraversal(Node currentNode) 
	{
		// Base case
		if (currentNode == null)
			return;
		// process left child
		System.out.print(currentNode.getData() + " ");
		preorderTraversal(currentNode.getLeftChild());
		preorderTraversal(currentNode.getRightChild());
	}

	/**
	 * will traverse a tree using inorder traversal.
	 * @param currentNode used recursively, the node the function is currently checking.
	 */
	public void inorderTraversal(Node currentNode)
	{
		// Base case
		if (currentNode == null)
			return;
		// process left child
		inorderTraversal(currentNode.getLeftChild());
		System.out.print(currentNode.getData() + " ");
		inorderTraversal(currentNode.getRightChild());
	}
}

