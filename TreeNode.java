/**
 * The external Tree Node for Linked Trees
 * 
 * @author Equara Khan
 * @param <T>
 */
public class TreeNode<T>
{
	protected T data;
	protected TreeNode<T> lc;	
	protected TreeNode<T> rc;
	
	public TreeNode (T dataNode)
	{	
		this.data = dataNode;
		this.lc = null;
		this.rc = null;
	}
	
	public TreeNode (TreeNode<T> node)
	{
		new TreeNode<T>(node);
	}
	
	public T getData()
	{
		return data;
	}
	
}