package redo;

import java.util.ArrayList;

public class ArrayLQueue<T> 
{
	ArrayList<T> al = new ArrayList<T>();
	
	
	
	public T dequeue() throws Exception 
	{
		T val;
		if (isEmpty())
			throw new Exception();
		val = al.get(0);
		al.remove(0);
		return val;
	}

	
	public boolean isEmpty()
	{
		return al.size() == 0;
	}
	
	public void enqueue(T data) 
	{
			al.add(data);
	}
}
