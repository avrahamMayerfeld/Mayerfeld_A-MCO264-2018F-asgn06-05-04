package redo;

import java.util.Comparator;

public class DiskComparator implements Comparator<DiskObject> {

	@Override
	public int compare(DiskObject arg1, DiskObject arg2) {
	int c = 0;
	
		if(arg1.size() < arg2.size())
			c = -1;
		else if(arg1.size() > arg2.size())
			c = 1;
		
		return c;
	}

}
