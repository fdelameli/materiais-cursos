import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-jun-2008 09:39:23
 */
public class SetorPessoal {

	//attributes
	
	private ArrayList<Funcionario> funcionarios;

	
	//constructor
	
	public SetorPessoal(){
		this.funcionarios = new ArrayList<Funcionario>();
	}


	//main methods
	
	public void geraFolhaPagamento(){
		System.out.println("FOLHA DE PAGAMENTO");
		double total = 0.0;
		
		Iterator<Funcionario> it = this.funcionarios.iterator();
		while (it.hasNext()) {
			Funcionario f = it.next();
			double pagamento = f.calculaPagamento();
			System.out.println("- " + f.getNome() + ": " + pagamento);
			total += pagamento;
		}
		System.out.println("TOTAL DA FOLHA: " + total);
	}


	public boolean incluiFuncionario(Funcionario funcionario){
		return this.funcionarios.add(funcionario);
//		Iterator<Funcionario> it = this.funcionarios.iterator();
//		while (it.hasNext()) {
//			Funcionario f = it.next();
//			if (!f.equals(funcionario)) {
//				return this.funcionarios.add(funcionario);
//			}
//		}
//		JOptionPane.showMessageDialog(null, "Cadastro duplicado!", "Erro de cadastro..", JOptionPane.ERROR_MESSAGE);
//		return false;
	}
	

	public boolean excluiFuncionario(Funcionario funcionario){	
		return this.funcionarios.remove(funcionario);
	}

	public Funcionario consultaFuncionario(int matricula){
		Iterator<Funcionario> it = this.funcionarios.iterator();
		while (it.hasNext()) {
			Funcionario f = it.next();
			if (f.getMatricula() == matricula)
				return f;
		}
		return null;
	}

}