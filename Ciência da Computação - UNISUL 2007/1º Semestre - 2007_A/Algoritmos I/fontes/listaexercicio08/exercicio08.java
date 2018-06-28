import javax.swing.JOptionPane;
class exercicio08 {

	static int i, j, l, n, x, y, quant;
	static double t_empresa, t_fun, t_ser, mobra_mais, mobra_menos, valor, v_final, soma_serviço;
	static String nome, nome_mais, nome_menos;

	public static void main(String[] args) {

		n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de funcionários que a oficina possui"));
		t_empresa = 0.0;
		t_fun = 0.0;
		mobra_mais = 0.0;
		mobra_menos = 0.0;
		for (i=1; i<=n; i+=1){
			nome = JOptionPane.showInputDialog("Digite o nome do funcionário");
			x = Integer.parseInt(JOptionPane.showInputDialog(" Escreva a quantidade de serviços feitas pelo funcionário"));
			soma_serviço = 0.0;
			for (j=1; j<=x; j+=1){
				y = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de variedades de peças colocadas pelo funcionário"));
				t_ser = 0.0;
				for (l=1; l<=y; l+=1){
					quant = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de peças do tipo" + l));
					valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de cada peça"));
					v_final = quant*valor;
					t_ser = t_ser + v_final;
				}
				JOptionPane.showMessageDialog(null, "O total do serviço foi de " + t_ser + " reais");
				soma_serviço = soma_serviço+t_ser;
			}
			t_fun = t_fun + soma_serviço;
			t_empresa = t_empresa + t_fun;
			JOptionPane.showMessageDialog(null, "O funcionário " + nome + " arregadou " + t_fun + " reais.");
			if (t_fun > mobra_mais){
				mobra_mais = t_fun;
				nome_mais = nome;
			}
			if (mobra_menos == 0.0){
				mobra_menos = t_fun;
				nome_menos = nome;
			}
			else {
				if (t_fun<mobra_menos){
					mobra_menos = t_fun;
					nome_menos = nome;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "A empresa arregadou " + t_empresa + " reais.");
		JOptionPane.showMessageDialog(null, "O funcionario que arregadou mais foi: " + nome_mais + " , " + mobra_mais + " reais.");
		JOptionPane.showMessageDialog(null, "O funcionario que arregadou menos foi: " + nome_menos + " , " + mobra_menos + " reais.");
	}

}
