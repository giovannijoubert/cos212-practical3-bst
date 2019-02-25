//Giovanni Joubert
//u18009035
@SuppressWarnings("unchecked")
public class BST<T extends Comparable<? super T>> {
    
	protected BSTNode<T> root = null;
	protected static int count = 0;
	public boolean dSuccess = false;

	public BST() 
	{
    	}
    
	public void clear() 
	{
		root = null;
	}

	public String inorder(BSTNode<T> node) 
	{
		Boolean verbose = true;
		if (node != null) {
			String result = "";
			result += inorder(node.left);
			if (verbose) {
				result += node.toString()+"\n";
			} else {
				result += node.element.toString() + " ";
			}
			result += inorder(node.right);
			return result;
		}
		return "";
	}

	////// You may not change any code above this line //////

	////// Implement the functions below this line //////

	public boolean isEmpty() 
	{
		//Your code goes here
			if(root == null){
				return true;
			} else {
				return false;
			}
	}

	public T minValue() 
	{
		//Your code goes here
		if(isEmpty()){
			return null;
		} else {
			BSTNode<T> traverse = root; 
			while(traverse.left != null){
				traverse = traverse.left;
			}
			return traverse.element;
		}
	}

	public T maxValue() 
	{
		//Your code goes here
		if(isEmpty()){
			return null;
		} else {
			BSTNode<T> traverse = root; 
			while(traverse.right != null){
				traverse = traverse.right;
			}
			return traverse.element;
		}
	}

	public void printPostorder()  //Their definition 
	{
		//Your code goes here
		if(isEmpty()){
			return;
		}

		   printPostorder(root.left); 
  
		   printPostorder(root.right); 
	 
		   System.out.print(root.element + " "); 

		   System.out.print("\n");
	}

	public void printPostorder(BSTNode<T> node)  //my overload 
	{
		//Your code goes here
		if(node == null){
			return;
		}

		   printPostorder(node.left); 
  
		   printPostorder(node.right); 
	 
		   System.out.print(node.element + " "); 
	}





	public void insert(T element) 
	{
		//Your code goes here
		root = insertR(root, element); 
	}

	BSTNode<T>  insertR(BSTNode<T>  root, T element) { /*recursive insert of node element*/
  
        if (root == null){
            root = new 	BSTNode<T>(element); 
            return root; 
        } 
  
        if (element.compareTo(root.element) < 0) 
            root.left = insertR(root.left, element); 
        else if (element.compareTo(root.element) == 1) 
            root.right = insertR(root.right, element); 
  
        return root;  // unchanged
    } 




	public boolean deleteByCopy(T element) 
	{
		//Your code goes here
		BSTNode<T> node, p = root, prev = null;
		while (p != null && !p.element.equals(element)){
			prev = p;
			if(element.compareTo(p.element) < 0) //compare to <0 means LHS < RHS
				p = p.left;
			else p = p.right;
		}
		node = p;
		if( p != null && p.element == element){
			if (node.right == null)
				node = node.left;
			else if (node.left == null)
				node = node.right;
			else {
				BSTNode<T> temp = node.left;
				BSTNode<T>  previous = node;
				while(temp.right != null){
					previous = temp;
					temp = temp.right;
				}
				node.element = temp.element;

				if (previous == node){
					previous.left = temp.left;
				} else {previous.right = temp.left; }

			}


			if (p == root) {
				root = node;
		}
			else if(prev.left == p) {

				prev.left = node;
			
		}
			else {prev.right = node;
			

			
		}
		return true;

	}
			else if(root != null){
				return false;
			} else {
				return false;
			}
		
	}

	
	



	public T search(T element) 
	{
		//Your code goes here
		BSTNode<T> output = search(root, element);

		if (output != null){
			return output.element;
		} else {
			return null;
		}
	}

	public BSTNode<T> search(BSTNode<T> root, T element) 
{ 

    if (root==null || root.element==element) {
		return root;
	}
         
    if (root.element.compareTo(element) == 1) 
        return search(root.left, element); 
  
    return search(root.right, element); 
} 

}