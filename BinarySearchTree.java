import java.util.Comparator;

public class BinarySearchTree
{

	public static void main(String[] args)
	{

		BSTRecursive<Integer> n = new BSTRecursive<Integer>();
		n.insert(5);
		n.insert(3);
		n.insert(6);
		n.insert(6);
	
		n.insert(3);
		n.insert(7);
		n.printInOrder();;
		
		
	}

}

/*
 * Jose Retamal ,returning
 */




class TreeNode<E extends Comparable<E>>
{
	E data;
	TreeNode<E> left;// = new TreeNode<E>();
	TreeNode<E> right;// = new TreeNode<E>();
	
	public TreeNode(E e)
	{
		data = e;
	}
}

class BSTRecursive<E extends Comparable<E>>
{
	TreeNode<E> root;

	public void insert(E e)
	{


		root = insert(e, root);

	}

	private TreeNode insert(E e, TreeNode<E> n)
	{

		if (n == null)
		{

			return new TreeNode(e);

		}
		
		if (e.compareTo(n.data) < 0)// left
		{
			n.left = insert(e, n.left);;
			
		} else if (e.compareTo(n.data) > 0)// right
		{
			n.right =insert(e, n.right);;
			
		}
		return n;

	}// insert(E e, TreeNode<E> n)




	
	public void printInOrder()
	{
		printInOrderP(root);
	}
	
	private void printInOrderP(TreeNode<E> root)
	{
		if(root==null) return;
		
		printInOrderP(root.left);
		System.out.println(root.data);
		printInOrderP(root.right);
	}
	


	public TreeNode<E> searchNode(E e)
	{
		TreeNode<E> n = searchNode(e, root);
		
		return searchNode(e, root);
	}

	private TreeNode<E> searchNode(E e, TreeNode<E> n)
	{
		if (n.data == null)
		{
			
			return null;
		}
		if (n.data == e)
		{
		
			return n;
		}
		if (e.compareTo(n.data) < 0)
		{
			searchNode(e, n.left);

		} else if (e.compareTo(n.data) > 0)// right
		{
			searchNode(e, n.right);

		}

		return null;
	}

	

}// BSTRecursive

// first version not working because java is pass by copy :)
class BSTRecursive1<E extends Comparable<E>>
{
	TreeNode<E> root;// = new TreeNode<E>();

	public boolean insert(E e)
	{
		return insert(e, root);
	}

	private boolean insert(E e, TreeNode<E> n)
	{
		if (n == null)
		{
			System.out.println("inser new node:" + e);
			n = new TreeNode<E>(e);

			n.data = e;
			return true;
		}

		if (e.compareTo(n.data) < 0)// left
		{
			n.left = new TreeNode<E>(e);
			insert(e, n.left);
			return true;
		} else if (e.compareTo(n.data) > 0)// right
		{
			n.right = new TreeNode<E>(e);
			insert(e, n.right);
			return true;
		}

		return false;
	}
}
