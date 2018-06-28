package aula02.array.exemplo04;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Aluno arrayAlunos[] = new Aluno[5];
		byte qtd = 0;
		
		while(qtd < 5){
			String nome = JOptionPane.showInputDialog("Nome:");
			double n1 = Double.parseDouble(JOptionPane.showInputDialog("1ª nota:"));
			double n2 = Double.parseDouble(JOptionPane.showInputDialog("2ª nota:"));
			double n3 = Double.parseDouble(JOptionPane.showInputDialog("3ª nota:"));
			
			arrayAlunos[qtd] = new Aluno(nome, n1, n2, n3);
			qtd++;
		}
		
		double maiorMedia = 0;
		String nomeMaiorMedia = "";
		qtd = 0;
		
		while(qtd < 5){
			if(arrayAlunos[qtd].getMedia() > maiorMedia){
				maiorMedia = arrayAlunos[qtd].getMedia();
				nomeMaiorMedia = arrayAlunos[qtd].nome;
			}
			qtd++;
		}
		
		JOptionPane.showMessageDialog(null, "Nome: " + nomeMaiorMedia + "\nMédia: " + maiorMedia);
	}
}
