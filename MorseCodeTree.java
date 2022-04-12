import java.util.ArrayList;

/**
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to English. 
 * 
 * @author Equara Khan
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<java.lang.String>
{
	private TreeNode<String> root = null;  
	
	private String fetchedLetter; 

		
	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree()
	{
		buildTree(); 
	}
	
	
	/**
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */

	@Override
	public void addNode(TreeNode<String> root, String code, String letter)
	{	
		
		if(code.length() == 1)
	    {
			
			if (code.equals("."))
			{
				root.lc = new TreeNode<String>(letter);
			}
			
			else
			{
				root.rc = new TreeNode<String>(letter);
			}
			
			return;
	    }
	    else
	    {	
	    	
			if(code.substring(0, 1).equals("."))
			{
				
				addNode(root.lc, code.substring(1), letter);
			}
			
			
			else
			{
				
				addNode(root.rc, code.substring(1), letter);		
			}		
		}	    	
	}
	
	/**
	 * 
	 * @param code the code for the new node to be added
	 * @param letter the letter for the new node to be added, example "r"
	 * @return
	 */
	@Override
	public MorseCodeTree insert(java.lang.String code, java.lang.String letter)
	{
		
		addNode(root, code, letter);
		
		return this;		
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code.
	 
	 */
	@Override
	public void buildTree()
	{
		
		root = new TreeNode<String>("");
		
		
		insert(".", "e");
		insert("-", "t");
		
		
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");					
	}
	
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot()
	{
		return this.root;
	}

	
	/**
	 * sets the root of the of the MorseCodeTree
	 * 
	 * @param newNode a copy of newNode will be the new root
	 */

	@Override
	public void setRoot(TreeNode<String> newNode) {
		
		root = newNode;	
	}

	
	/**
	 
	 * @param code the code that describes the traversals within the tree
	 * @return the string (letter) that corresponds to the code
	 */
	@Override
	public java.lang.String fetch(java.lang.String code)
	{
		
		String letter = fetchNode(root, code);
		
		return letter;
	}


	/**
	 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the string (letter) corresponding to the code
	 */
	@Override
	public java.lang.String fetchNode(TreeNode<java.lang.String> root, java.lang.String code)
	{	
		
		if(code.length() == 1)
	    {
			
			if (code.equals("."))
			{
				fetchedLetter = root.lc.getData(); 
			}
			
			
			else
			{
				fetchedLetter =  root.rc.getData(); 
			}
		}
	    else
	    {	
			
			if(code.substring(0, 1).equals("."))
			{
				
				fetchNode(root.lc, code.substring(1));
			}
			
			else
			{
				
				fetchNode(root.rc, code.substring(1));		
			}		
		}
		
		
		return fetchedLetter;	
	}

	
	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order. Used for testing to make sure tree is built correctly
	 * 
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public java.util.ArrayList<java.lang.String> toArrayList()
	{
		ArrayList<String> printTree = new ArrayList<String>();

		LNRoutputTraversal(root, printTree);		

		return printTree;
	}

	
	/**
	
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<java.lang.String> root, java.util.ArrayList<java.lang.String> list)
	{
		if(root != null)
		{
			
			LNRoutputTraversal(root.lc, list);
			list.add(root.getData());
			LNRoutputTraversal(root.rc, list);
		}
	}
	
	/**
	 
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		return null;
	}

	
	/**
	 
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		return null;
	}

}