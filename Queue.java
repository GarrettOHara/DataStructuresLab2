package cs310Lab2;
import java.util.ArrayList;
public class Queue 
{
	private ArrayList<Integer> Queue;
	public Queue()
	{
		Queue = new ArrayList<Integer>();
	}
	public boolean isEmpty()
	{
		if(Queue.size() != 0)
			return false;
		else
			return true;
	}
	public void loadValue(int val)
	{
		Queue.add(val);
	}
	public int nextValue()
	{
		if(Queue.size() > 0)
		{
			return Queue.remove(0);
		}
		return -1;
	}
	public void normalize()
	{
		int valToSubtract = Queue.get(0);
		int subtractedVal = 0;
		for(int i = 0; i < Queue.size(); i++)
		{
			subtractedVal = Queue.get(i) - valToSubtract;
			Queue.set(i, subtractedVal);
		}
	}
	public int[] peek(int num)
	{
		int list[] = new int [num];
		for(int i = 0; i < num; i++)
		{
			list[i] = Queue.get(i);
		}
		return list;	
	}
	public int size()
	{
		return Queue.size();
	}
	public void print()
	{
		for (int i = 0; i < Queue.size(); i++)
		{
			System.out.print(Queue.get(i) + " ");
		}
		System.out.println();
	}
}