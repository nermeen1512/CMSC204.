
public class TreeNode<T> {

	private T data;
	public TreeNode<T> Lc;
	public TreeNode<T> Rc;
	
	//-----------------------------------------------constructors
	
    /**
    *  A constructor that creates a new TreeNode that have
    *  the data set to the dataNode.
    *  and the left and the right child set to null 
    * @param dataNode: The data to be set in the TreeNode
    */
	public TreeNode(T dataNode)
	{
		data = dataNode;
		Lc = null;
		Rc = null;
	}
	
	/**
    * A constructor that makes a deep copy of a given Tree node
    * @param node: The node which is used to make a copy of
    */
	public TreeNode(TreeNode<T> node)
	{
		//this.data = node.data;
		//this.Rc = node.Rc;
		//this.Lc = node.Lc;
		new TreeNode<T> (node);
	}
	
	//----------------------------------------------------Method to return the data
    /**
     * A method to return the data within this Tree Node
     * @return data within the Tree Node
     */
	public T getData()
	{
		return data;
	}
	
}
