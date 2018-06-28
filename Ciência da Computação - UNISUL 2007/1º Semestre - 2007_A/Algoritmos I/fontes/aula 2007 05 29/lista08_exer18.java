import javax.swing.JOptionPane;
class lista08_exer18 {

static int i, Id, s1, s2, s3,n;
static String nome, cidade;

	public static void main(String[] args) {

		n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de cadastro de alunos a ser feita"));
		s1 = 0;
		s2 = 0;
		s3 = 0;
		for (i=1; i<=n; i+=1){
			nome = JOptionPane.showInputDialog("Digite o nome do aluno");
			cidade = JOptionPane.showInputDialog("Digite o nome da cidade do aluno");
			Id = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno"));
			if (cidade.equals("Tubarão")){
				s1 = s1+1;
			}
			else{
				if (cidade.equals ("Jaguaruna")){
				s2=s2+1;
				}
			}
		if (Id < 17){
			s3=s3+1;
		}
		}
JOptionPane.showMessageDialog(null, s1 + " aluno(s) moram em Tubarão");
JOptionPane.showMessageDialog(null, s2 + " aluno(s) moram em Jaguaruna");
JOptionPane.showMessageDialog(null, s3 + " aluno(s) tem idade inferior à 17 anos");
	}

}
