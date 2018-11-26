package redo;


	import java.util.Date;
	import java.util.Random;

	public class FileObject extends DiskObject{

		String data;
		Random rand =new Random();
		Date currDate = new Date();
		
		public FileObject(String name,String data) {
			this.data = data;
		    this.creator = System.getProperty("user.name");
			this.created = currDate;
			this.lastModified = currDate;
			this.lastAccessed = currDate;
			this.diskLocation = rand.nextInt();
			this.name = name;
		}
		
		public void setData(String d){
			data = d;
			this.lastModified = currDate;
			this.lastAccessed = currDate;
		}
		
		public String getData() {
			this.lastAccessed = currDate;
			return data;
		}
		
		public String toString() {
			return "File name: "+ name + " Data: "+ data+ "  "+ size();
		}
		
		@Override
		public int size() {
			return data.length();
		}

	

}
