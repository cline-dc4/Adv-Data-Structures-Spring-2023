
public class Node 
{
	private Node parent;
	
	private Node rightChild;
	
	private Node leftChild;
	
	private int data;

	public Node()
	{
		setData(1000);
		setRightChild(null);
		setLeftChild(null);
		setParent(null);
	}
	
	public Node(int data)
	{
		setData(data);
		setRightChild(null);
		setLeftChild(null);
		setParent(null);
	}
	
	public Node getParent() 
	{
		return parent;
	}

	public void setParent(Node parent) 
	{
		this.parent = parent;
	}

	public Node getLeftChild() 
	{
		return leftChild;
	}

	public void setLeftChild(Node leftChild) 
	{
		this.leftChild = leftChild;
		if(leftChild != null)
		{
			leftChild.setParent(this);
		}
	}
	
	public Node getRightChild() 
	{
		return rightChild;
	}

	public void setRightChild(Node rightChild) 
	{
		this.rightChild = rightChild;
		if(rightChild != null)
		{
			rightChild.setParent(this);
		}
	}

	
	public int getData()
	{
		return data;
	}

	public void setData(int data)
	{
		this.data = data;
	}


}
