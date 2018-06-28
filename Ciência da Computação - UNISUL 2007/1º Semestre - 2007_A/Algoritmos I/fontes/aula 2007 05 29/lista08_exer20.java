import javax.swing.JOptionPane;
class lista08_exer20 {

	static int i, n;
	static double m, m_maior;
	static String nome, n_maior;

	public static void main(String[] args) {

		n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de alunos a serem cadastrados"));
		m_maior = -1.0;
		
		for (i=1; i<=n; i+= 1){
			nome = JOptionPane.showInputDialog("Digite o nome do aluno");
			m = Double.parseDouble(JOptionPane.showInputDialog("Digite a média do aluno"));
			if (m >m_maior){
				m_maior = m;
				n_maior = nome;
			}
		}
		JOptionPane.showMessageDialog(null, n_maior + " obteve a maior média que é de " + m_maior);
	}

}
