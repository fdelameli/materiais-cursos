import javax.swing.JOptionPane;
class lista2_exercicio2 {
static double base, altura, area;
	
	public static void main(String[] args) {
		base = Double.parseDouble(JOptionPane.showInputDialog("digite base"));
		altura = Double.parseDouble(JOptionPane.showInputDialog("digite altura"));
		
		area = (base*altura)/2;
		
		JOptionPane.showMessageDialog(null,area + " m²");
	}

}
