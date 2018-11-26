package redo;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayLStack<T> {
	 private ArrayList<T> al;  
	  
     
	 public ArrayLStack() {
		 al = new ArrayList<T>();
	 }
	
	 public void push(T item) {
	 		al.add(item);
	 }
	 
	 public void pop() {
	 		if (!isEmpty())
	 			 al.remove(size()-1);
	 		else
	 			throw new EmptyStackException();
	 }
	 
	 public int size() {
		
		return al.size();
	}

	public T top() {
	 		if (!isEmpty())
	 			return al.get(size()-1);
	 		else
	 			throw new EmptyStackException();
	 }
	 
	 public boolean isEmpty() {
	 		return (al.size() == 0);
   	 }
		
}
