package redo;

import java.util.ArrayList;

public class Program {
	public static void main(String[] args) {
		DirectoryObject root = new DirectoryObject("root");
		root.addDirectory(new DirectoryObject("Dir A"));
		root.addFile(new FileObject("File 1", "conceived in liberty "));
		root.addFile(new FileObject("File 2", "and dedicated to the proposition "));
		root.addDirectory(new DirectoryObject("Dir B"));
		
		((DirectoryObject)(root.getChildren().get(0))).addFile(new FileObject("File 3", "Four score and seven years ago "));
		((DirectoryObject)(root.getChildren().get(0))).addFile(new FileObject("File 4", "our fathers brought forth on this continent "));
		((DirectoryObject)(root.getChildren().get(0))).addDirectory(new DirectoryObject("Dir C"));
		((DirectoryObject)(root.getChildren().get(3))).addFile(new FileObject("File 5", "that all men are created equal."));
		((DirectoryObject)
		((DirectoryObject)
		((DirectoryObject)(root.getChildren().get(0))).getChildren().get(2))).addFile(new FileObject("File 6", "a new nation "));
				
		
	    displayInfoStack(root);
		System.out.println("Total size: " + root.size() + "\n");
		updateFilesStack(root);
		displayInfoStack(root);
		System.out.println("Total size: " + root.size() + "\n");
	}

	public static void displayInfoRecursive(DirectoryObject dO) 
	{
		System.out.println(dO.toString());
		for (DiskObject child : dO.getChildren()) 
		{
			if(child instanceof FileObject)
			{
				System.out.println(child.toString());
			}
			else
			displayInfoRecursive((DirectoryObject) child);
		}
	}
	
	public static void updateFilesRecursive(DirectoryObject dO) 
	{
		
		for (DiskObject child : dO.getChildren()) 
		{
			if(child instanceof FileObject)
			{
				((FileObject) child).setData(
						((FileObject) child).getData().substring(0, Math.min(((FileObject) child).getData().length(), 25)) );
				
				StringBuilder fixed = new StringBuilder(dO.getName());
				fixed.insert(0, "Fixed- ");
				if(!dO.getName().startsWith("Fixed- "))
					dO.setName(fixed.toString());
			}
			else
			updateFilesRecursive((DirectoryObject) child);
		}
	}
	
	public static void displayInfoStack(DirectoryObject dO) {
		
		ArrayLStack<DiskObject> stack = new ArrayLStack<DiskObject>();	
	    stack.push(dO);
	    while (!stack.isEmpty())
	    {
	    	DiskObject current = stack.top();
	    	stack.pop();
	    	System.out.println(current.toString()); 
	    	if(current instanceof DirectoryObject)
	    	{
		    	for (int a =  ((DirectoryObject) current).getChildren().size()-1; a >= 0; a--)
	            {
		    		 stack.push(((DirectoryObject) current).getChildren().get(a));
		    	}
	    	}
	    }
	}               
	
	public static void updateFilesStack(DirectoryObject dO) {
		
		ArrayLStack<DiskObject> stack = new ArrayLStack<DiskObject>();	
	    stack.push(dO);
	    while (!stack.isEmpty())
	    {
	    	DiskObject current = stack.top();
	    	stack.pop();
	    	
	    	if(current instanceof DirectoryObject)
	    	{   
	    		StringBuilder fixed = new StringBuilder(current.getName());
				fixed.insert(0, "Fixed- ");
				current.setName(fixed.toString());
	    		ArrayList<DiskObject> aldo  = ((DirectoryObject) current).getChildren();
		    	for (int a = aldo.size()-1; a >= 0; a--)
	            {
		    		 stack.push(aldo.get(a));
		    		 
		    	}
		    }
	    	else if (current instanceof FileObject)
	    	{
	    		((FileObject) current).setData(
						((FileObject) current).getData().substring(0, Math.min(((FileObject) current).getData().length(), 25)));
	    	}
	    }
		
	}
	//see if good
	public static void displayInfoQueue(DirectoryObject dO) {
		ArrayLQueue<DiskObject> queue = new ArrayLQueue<DiskObject>();
		queue.enqueue(dO);
		while(!queue.isEmpty())
		{
			try 
			{
				DiskObject current = queue.dequeue();
			    System.out.println(current.toString()); 
				if(current instanceof DirectoryObject)
		    	{
		    		 ArrayList<DiskObject> aldo  = ((DirectoryObject) current).getChildren();
			    	 for (int a =  0; a < aldo.size(); a++)
		             {
			    		 queue.enqueue(aldo.get(a));
			    	 }
		    	}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void updateFilesQueue(DirectoryObject dO) {
		
		
	}
}
