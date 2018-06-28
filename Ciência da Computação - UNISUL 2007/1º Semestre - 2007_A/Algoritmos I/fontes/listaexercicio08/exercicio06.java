import javax.swing.JOptionPane;
class exercicio06 {

	static int i, n, j, q, i_ret, i_dep;
	static String nome;
	static double v_oper, saldo, t_dep, t_ret, v_dep, v_ret;
	static char oper;

	public static void main(String[] args) {

		n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de filas existentes no banco: "));
		v_dep = 0.0;
		v_ret = 0.0;
		for (i=1; i<=n; i+=1){
			q = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de clientes atendidos pela fila " + i));
			t_dep = 0.0;
			t_ret = 0.0;
			for (j=1; j<=q; j+=1){
				nome = JOptionPane.showInputDialog("Digite o nome do cliente");
				saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo do cliente"));
				oper = JOptionPane.showInputDialog("Digite a operação desejada").charAt(0);
				v_oper = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da operação"));
				switch (oper){
				case 'D':{
					saldo = saldo + v_oper;
					t_dep = t_dep + v_oper;
					break;}
				case 'R':{
					saldo = saldo - v_oper;
					t_ret = t_ret + v_oper;
					break;}
				default: {
					JOptionPane.showMessageDialog(null, "Operação Inválida");
				}
				}
				JOptionPane.showMessageDialog(null, "O cliente " + nome + " está como um saldo de " + saldo + " reais.");
			}
			if (t_dep > v_dep){
				v_dep = t_dep;
				i_dep = i;
			}
			if (v_ret == 0.0){
				v_ret = t_ret;
				i_ret = i;
			}
			else{
				if (t_ret < v_ret){
					v_ret = t_ret;
					i_ret = i;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "A fila " + i_dep + " foi a que teve mais depositos: " + v_dep);
		JOptionPane.showMessageDialog(null, "A fila " + i_ret + " foi a que teve mais retiradas: " + v_ret);
	}
}





