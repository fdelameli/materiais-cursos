
public class DateBinaryTree implements Comparable{

	private int year;
	private int mounth;
	private int day;



	public DateBinaryTree() {
		this(1,1,2001);
	}

	public DateBinaryTree(int day, int mounth, int year) {
		this.year = year;
		this.mounth = mounth;
		this.day = day;
//		this.mounth = (mounth < 1 || mounth > 12) ? 1 : mounth;
//		this.day = (day < 1 || day > 31) ? 1 : day;
	}



	public int compareTo(Comparable obj) {
		DateBinaryTree date = (DateBinaryTree) obj;

		if(date.year < this.year)
			return 1;
		else 
			if(date.year > this.year)
				return -1;
			else 
				if(date.mounth < this.mounth)
					return 1;
				else 
					if(date.mounth > this.mounth)
						return -1;
					else 
						if(date.day < this.day)
							return 1;
						else 
							if(date.day > this.day)
								return -1;

		return 0;
	}



	public String toString(){
		return String.format("%s/%s/%s", day, mounth, year);
	}

}
