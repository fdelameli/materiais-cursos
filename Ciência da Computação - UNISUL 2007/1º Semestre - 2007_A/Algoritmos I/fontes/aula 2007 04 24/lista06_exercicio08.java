import javax.swing.JOptionPane;
class lista06_exercicio08 {

	static int x, y, z;

	public static void main(String[] args) {

		x = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do lado X do triangulo"));
		y = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do lado Y do triangulo"));
		z = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do lado Z do triangulo"));
		if ((x < y + z)&& (y < x + z)&& (z < x + y)){
			if ((x == y) && (y == z)){
				JOptionPane.showMessageDialog(null, "Triangulo eqüálatero");
			}
			else{
				if ((x == y)||(y == z)||(x == z)){
					JOptionPane.showMessageDialog(null, "Triangulo esósceles");	
				}
				else{
					JOptionPane.showMessageDialog(null, "Triangulo escaleno");
				}
			}
		} 
		else {
			JOptionPane.showMessageDialog(null, "Não é triangulo");
		}
	}

}
