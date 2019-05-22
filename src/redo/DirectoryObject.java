package redo;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.print.attribute.standard.DateTimeAtCompleted;

public class DirectoryObject extends DiskObject {

	ArrayList<DiskObject> children = new ArrayList<DiskObject>();
	Random rand =new Random();
	Date currDate = new Date();

	public DirectoryObject(String name) {
		this.creator = System.getProperty("user.name");
		this.created = currDate;
		this.lastModified = currDate;
		this.lastAccessed = currDate;
		this.diskLocation = rand.nextInt();
		this.name = name;
	
	}
	
	public void addDirectory(DirectoryObject dirObj){
		
		children.add(dirObj);
		lastAccessed = currDate;
		lastModified = currDate;
		
	}
	
	public void addFile(FileObject file) {
		children.add(file);
		this.lastAccessed = currDate;
		this.lastModified = currDate;
		
	}
	
	public ArrayList<DiskObject> getChildren() {
		
		lastAccessed = currDate;
	    	return children;
	}
	
			
	public String toString() {
		
		return ("Directory name: "+ name+"  "+ size());
	}
	
	@Override
	int size() 
	{
		int s = 0;
		for (DiskObject child:children)
		{
			if (child instanceof FileObject)
				s += child.size();
			else if (child instanceof DirectoryObject)
			{
				child.size();
			}
		}
		return s;
	}
}
