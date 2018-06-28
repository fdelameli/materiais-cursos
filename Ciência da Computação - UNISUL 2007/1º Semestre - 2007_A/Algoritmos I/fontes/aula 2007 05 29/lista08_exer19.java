import javax.swing.JOptionPane;
class lista08_exer19 {

	static int i, id, id_menor, id_maior,n;
	static String nome, n_maior, n_menor;

	public static void main(String[] args) {

		n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de funcionários a serem cadastrados"));
		id_menor =	150;
		id_maior = -1;
		n_maior = " ";
		n_menor = " ";
		for (i=1; i<=n; i+=1){
			nome = JOptionPane.showInputDialog("Digite o nome do funcionário");
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do funcionário"));
			if (id > id_maior){
				id_maior = id;
				n_maior = nome;
			}
			if (id < id_menor){
				id_menor = id;
				n_menor = nome;
			}
		}
		JOptionPane.showMessageDialog(null, n_maior + " tem a idade de " + id_maior + " e é o mais velho");
		JOptionPane.showMessageDialog(null, n_menor + " tem a idade de " + id_menor + " e é o mais novo");
	}
}
