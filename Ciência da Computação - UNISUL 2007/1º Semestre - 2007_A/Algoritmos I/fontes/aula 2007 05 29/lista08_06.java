import javax.swing.JOptionPane;
class lista08_06 {

	static int i, y;

	public static void main(String[] args) {
		
		y = 1;
		for (i=1; i<=10; i+=1){
			y= y*i;
		}
JOptionPane.showMessageDialog(null, "" + y);
	}

}
