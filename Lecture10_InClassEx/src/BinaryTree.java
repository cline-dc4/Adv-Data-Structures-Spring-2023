import java.util.Stack;

public class BinaryTree 
{
	private Node rootNode;

	public Node getRootNode() 
	{
		return rootNode;
	}

	public void setRootNode(Node rootNode)
	{
		this.rootNode = rootNode;
	}

	public BinaryTree()
	{
		setRootNode(null);
	}
	
	public void inorderTraversal(Node currentNode)
	{
		// Base case
		if (currentNode == null)
			return;
		// process left child
		inorderTraversal(currentNode.getLeftChild());
		System.out.println(currentNode.getData() + " ");
		inorderTraversal(currentNode.getRightChild());
	}
	
	public void postorderTraversal(Node currentNode)
	{
		// Base case
		if (currentNode == null)
			return;
		// process left child
		postorderTraversal(currentNode.getLeftChild());
		postorderTraversal(currentNode.getRightChild());
		System.out.println(currentNode.getData() + " ");
	}
	
	public void preorderTraversal(Node currentNode)
	{
		// Base case
		if (currentNode == null)
			return;
		// process left child
		System.out.println(currentNode.getData() + " ");
		preorderTraversal(currentNode.getLeftChild());
		preorderTraversal(currentNode.getRightChild());
	}
	
	public int countNodes(Node currentNode)
	{
		// base case
		if (currentNode == null)
		{
			return 0;
		}
		// Recursive step
		return 1 + countNodes(currentNode.getLeftChild()) +
				countNodes(currentNode.getRightChild());
	}
	
	public String dfs(int key)
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
				s += "Found\n";
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
		s += "Not found\n";
		return s;
	}
	
	public String bfs(int key)
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
				s += "Found\n";
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
		s += "Not found\n";
		return s;
	}
}
