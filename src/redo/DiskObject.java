package redo;

import java.util.Date;

public abstract class DiskObject {
	
	// properties:
		protected String creator;
		protected Date created;
		protected Date lastModified;
		protected Date lastAccessed;
		protected int diskLocation;
		protected String name;
		
		protected String getCreator()
		{
			return creator;
		}
		
		protected Date getCreated()
		{
			return created;
		}
		
		protected Date getLastModified()
		{
			return lastModified;
		}
		
		protected Date getLastAccessed()
		{
			return lastAccessed;
		}
		
		protected String getName()
		{
			return name;
		}
		
		protected int getDiskLocation()
		{
			return diskLocation;
		}
		
		protected void setName(String name)
		{
			this.name = name;
		}
		
		abstract int size();
}
