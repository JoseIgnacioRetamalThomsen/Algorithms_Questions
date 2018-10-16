import java.util.LinkedList;
import java.util.List;

public class StackWithMin
{
/*
 * Question : Find the minimum element in a stack in O(1) time
 */
	
	public static void main(String[] args)
	{
		StackWithMinA2 s = new StackWithMinA2();
		s.push(3);
		s.push(7);
		s.push(2);
		s.push(9);
		s.push(1);
		s.push(12);
		
		System.out.println("min "+ s.getMin());
		System.out.println("pop "+ s.pop());
		System.out.println("pop "+ s.pop());
		System.out.println("min "+ s.getMin());
		System.out.println("pop "+ s.pop());
		System.out.println("pop "+ s.pop());
		System.out.println("min "+ s.getMin());
		System.out.println("pop "+ s.pop());
		System.out.println("min "+ s.getMin());
		System.out.println("pop "+ s.pop());
		//System.out.println("min "+ s.getMin());
	
	}
	

}

/*
 * My solution no the best getMin O(1) but pop O(n)
 */
class StackWithMinA1
{  
	private LinkedList<Integer> stack = new LinkedList<Integer>();
	private int min;
	
	public void push(int n)
	{
		if(stack.size()==0)
		{
			min =n;
			
		}else
		{
			if(n<min)
			{
				min = n;
			}
			
			
		}
		stack.push(n);
	}
	
	public int pop()
	{
		int poped = stack.pop();
		if(stack.size()==0)
		{
			return poped;
		}
		
	
		if(poped == min)
		{
			min = stack.get(0);
			for(int i:stack)
			{
				if(i<min)
				{
					min =i;
				}
			}
		}
		return poped;
	}
	
	public int getMin()
	{
		return this.min;
	}
	
}

/*
 *  Better solotion using 2 stack all O(1) but double space used
 *
 * */

class StackWithMinA2
{
	private LinkedList<Integer> stack = new LinkedList<Integer>();
	private LinkedList<Integer> minStack = new LinkedList<Integer>();

	
	public void push(int n)
	{
		if(stack.size()==0)
		{
		
			minStack.push(n);
		}else
		{
			if(n< minStack.peek())
			{
				minStack.push(n);
			}
		}
		stack.push(n);
	}
	public int pop()
	{
		int poped = stack.pop();
		if(stack.size()==0)
		{
			minStack.clear();
			return poped;
		}
		
	
		if(poped == minStack.peek())
		{
			minStack.pop();
		}
		return poped;
	}
	
	public int getMin()
	{
		
		return minStack.peek();
	}
	
}
