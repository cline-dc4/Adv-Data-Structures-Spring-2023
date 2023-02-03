
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
}
