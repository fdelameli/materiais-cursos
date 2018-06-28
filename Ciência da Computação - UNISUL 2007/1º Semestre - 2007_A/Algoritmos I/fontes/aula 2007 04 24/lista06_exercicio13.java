import javax.swing.JOptionPane;
class lista06_exercicio13 {

	static String nome;
	static char sexo;
	static int idade;

	public static void main(String[] args) {

		nome = JOptionPane.showInputDialog("Digite seu Nome");
		sexo = JOptionPane.showInputDialog("Digite o sexo da pessoa de seu interesse").charAt(0);
		idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade da pessoa de seu interesse"));
		if (sexo == 'M'){
			if ((idade >= 18)&& (idade <= 21)){
				JOptionPane.showMessageDialog(null, "Você deve pagar R$ 300,00 para sair com essa pessoa");
			}
			else{
				if ((idade >= 22)&& (idade <= 25)){
					JOptionPane.showMessageDialog(null, "Você deve pagar R$ 700,00 para sair com essa pessoa");
				}
				else{
					if ((idade >= 26)&&(idade <= 30)){
						JOptionPane.showMessageDialog(null, "Você deve pagar R$ 1000,00 para sair com essa pessoa");
					}
					else{
						if ((idade >= 31)&& (idade <= 40)){
							JOptionPane.showMessageDialog(null, "Você deve pagar R$ 3500,00 para sair com essa pessoa");
						}
						else{
							JOptionPane.showMessageDialog(null, "Você deve pagar R$ 500,00 para sair com essa pessoa");
						}
					}
				}
			}
		}
		else{
			if ((idade >= 18)&& (idade <= 21)){
				JOptionPane.showMessageDialog(null, "Você deve pagar R$ 3500,00 para sair com essa pessoa");
			}
			else{
				if ((idade >= 22 )&& (idade <= 25)){
					JOptionPane.showMessageDialog(null, "Você deve pagar R$ 2500,00 para sair com essa pessoa");
				}
				else{
					if ((idade >=26)&&(idade <= 30)){
						JOptionPane.showMessageDialog(null, "Você deve pagar R$ 1000,00 para sair com essa pessoa");
					}
					else{
						if ((idade >= 31)&& (idade <= 40)){
							JOptionPane.showMessageDialog(null, "Você deve pagar R$ 100,00 para sair com essa pessoa");
						}
						else{
							JOptionPane.showMessageDialog(null, "Você deve pagar R$ 50,00 para sair com essa pessoa");
						}
					}
				}
			}
		}
	}
}
