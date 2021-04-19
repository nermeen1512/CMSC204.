import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>
{
	private TreeNode<String> root;

	
	//----------------------------------------------------------------------A constructor that calls the buildTree method
	public MorseCodeTree()
	{
		root = null;
		buildTree();
	}
	
	//---------------------------------------------------------------------
	@Override
	public TreeNode<String> getRoot()
	{
		return root;
	}

	//---------------------------------------------------------------------
	@Override
	public void setRoot(TreeNode<String> newNode) 
	{
		root = new TreeNode<String> (newNode);
		
	}

	//---------------------------------------------------------------------
	@Override
	public MorseCodeTree insert(String code, String letter)
	{
		TreeNode<String> root = getRoot();
		if(root == null)
		{
			setRoot(new TreeNode<String> (letter));
		}
		else
		{
			addNode(root, code, letter);
		}
		return this;
	}

	//---------------------------------------------------------------------
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) 
	{
		if(code.length()==1)
		{
			if(code.equals("."))
			{
				root.Lc = new TreeNode<String>(letter);
			}
			else
			{
				root.Rc = new TreeNode<String>(letter);
			}
		}
		else
		{
			if(code.charAt(0) == '.') //left child
			{
				addNode(root.Lc, code.substring(1), letter);
			}
			else //right child
			{
				addNode(root.Rc,code.substring(1),letter);
			}
		}
			
	}

	//---------------------------------------------------------------------
	@Override
	public String fetch(String code)
	{
		TreeNode<String> root = getRoot();
		String returned = fetchNode(root, code);
		return returned;
		
	}

	//---------------------------------------------------------------------
	@Override
	public String fetchNode(TreeNode<String> root, String code)
	{
		if(code.length()==1) //one charachter only
		{
			if(code.equals(".")) //left child
			{
				return root.Lc.getData();
			}
			else  // right child
			{
				return root.Rc.getData();
			}
		}
		else
		{
			if(code.charAt(0) == '.') //check first letter
			{
				return fetchNode(root.Lc, code.substring(1)); //call the method again without the first character of the code
			}
			else
			{
				return fetchNode(root.Rc, code.substring(1));
			}
		}
	}

	//---------------------------------------------------------------------
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException
	{
		// TODO Auto-generated method stub
		return null;
	}

	//---------------------------------------------------------------------
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException
	{
		// TODO Auto-generated method stub
		return null;
	}

	//---------------------------------------------------------------------
	@Override
	public void buildTree() 
	{
		root = new TreeNode<String>(""); //first node will be empty String
		insert(".","e");
		insert("-","t");
		//-----------------------
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		//-----------------------
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		//-----------------------
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		
		insert("--..","z");
		insert("--.-","q");
	}

	//---------------------------------------------------------------------A method that return an arraylist of the items in the tree in the LNR order
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> returned = new ArrayList<String>();
		
		LNRoutputTraversal(root, returned);
		return returned;
	}

	//---------------------------------------------------------------------
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) 
	{
		 if(root != null) //check if tree isn't empty 
		 {
			 LNRoutputTraversal(root.Lc, list); //reach most left item first
             list.add(root.getData());
             LNRoutputTraversal(root.Rc, list);
	     }
		
	}

}
