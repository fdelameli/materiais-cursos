import javax.swing.JOptionPane;
class tbmate {

	static int x, y, r, n, i;

	public static void main(String[] args) {
		n = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de tentativas"));
		for (i=1; i<=n; i+=1){
			x = Integer.parseInt(JOptionPane.showInputDialog("Número x"));
			y = Integer.parseInt(JOptionPane.showInputDialog("Número y"));
			r = (x+y)+ (x-y)+(x*y);
			if (r == 100){
				JOptionPane.showMessageDialog(null, x + " e " + y + " é verdadeiro");
			}
			else {
				JOptionPane.showMessageDialog(null, x + " e " + y + " é falso");
			}
		}

	}
}
