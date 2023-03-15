import java.util.ArrayList;

public class BinaryHeap extends HeapClass
{
	public BinaryHeap()
	{
		array = new ArrayList<Node>();
	}

	public Node removeNode() throws Exception 
	{
		// If size of array = 0; throw exception.
		// Create a pointer to the root node (index 0)
		// Copy the data from the "last" node into the rootnode
		// Remove the last node
		// Print out level order traversal
		// Write while loop for the percolate down operation
		// Print out level order traversal
		
		return null;
	}

	public void insertNode(Integer newValue) 
	{
		// Create a Node using newValue
		Node newNode = new Node(newValue);
		// If first node, add to ArrayList and we're done
		if (array.size() == 0)
		{
			array.add(newNode);
		}
		else // Not the first node, might have to percolate up
		{
			int index = array.size();
			array.add(newNode);
			Node parent = array.get((index - 1)/2);
			// if index is even: right child, otherwise left child
			if (index % 2 == 0)
			{
				parent.setRightChild(newNode);
			}
			else
			{
				parent.setLeftChild(newNode);
			}
			System.out.println("Before percolate up");
			levelOrderTraversal();
			// Now, percolate data to the right spot
			Node currentNode = newNode;
			while (currentNode.getParent() != null &&
					currentNode.getData() > currentNode.getParent().getData())
			{
				int temp = currentNode.getData();
				currentNode.setData(currentNode.getParent().getData());
				currentNode.getParent().setData(temp);
				// Node, current node should be the parent
				currentNode = currentNode.getParent();
			}
			System.out.println("After percolate up");
			levelOrderTraversal();
		}
	}

}
