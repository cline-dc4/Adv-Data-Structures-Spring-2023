public interface BinaryTreeInterface
{
		/**
	 * Breadth first search of the tree
	 * @param rootNode The root node
	 * @param key What data is being searched for
	 * @return A string with the data from every checked node and a statement of if the key was found or not
	 */
	public String bfs(Node<Integer> rootNode, int key);
	
	/**
	 * Depth first search of the tree
	 * @param rootNode The root node
	 * @param key What data is being searched for
	 * @return A string with the data from every checked node and a statement of if the key was found or not
	 */
	public String dfs(Node<Integer> rootNode, int key);
	
	/**
	 * Recursive function printing the data in the nodes based on a postorder traversal
	 * @param currentNode The node that is currently being looked at by the function.
	 * Should be the root node when first calling the function
	 */
	public void postorderTraversal(Node<Integer> currentNode);
	
	/**
	 * Recursive function printing the data in the nodes based on a preorder traversal
	 * @param currentNode The node that is currently being looked at by the function.
	 * Should be the root node when first calling the function
	 */
	 
	public void preorderTraversal(Node<Integer> currentNode);
	
	/**
	 * Recursive function printing the data in the nodes based on a inorder traversal
	 * @param currentNode The node that is currently being looked at by the function.
	 * Should be the root node when first calling the function
	 */
	public void inorderTraversal(Node<Integer> currentNode);
	
}