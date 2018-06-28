package br.unisul.aula.exemplorevenda.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unisul.aula.exemplorevenda.entidade.Funcionario;

/**
 * Classe de negócios
 * @author Fabio Dela Bruna
 * @since 05/05/2008
 */
public class FuncionarioModel implements IFuncionarioModel {
	
	// atributos
	
	private ArrayList<Funcionario> funcionarios;
	
	
	// construtores
	
	/**
	 * Construtor default.
	 */
	public FuncionarioModel(){
		super();
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param funcionarios - Funcionários.
	 */
	public FuncionarioModel(ArrayList<Funcionario> funcionarios){
		super();
		this.funcionarios = funcionarios;
	}

	
	// métodos principais
	
	@Override
	public void atualizaFuncionario(Funcionario antigo, Funcionario novo) {
		if(validaFuncionario(novo))
			antigo = novo;
		else
			JOptionPane.showMessageDialog(null, "Verifique os dados do Funcionário",
					"Erro de cadastro", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public Funcionario buscaFuncionario(String nome, String cpf) {
		if((nome != null && nome.length() > 1) && cpf == null){
			for(Funcionario f : this.funcionarios){
				if(f.getNome().equals(nome)){
					return f;
				}
			}
		}else if(cpf != null && cpf.length() > 0){
			for(Funcionario f : this.funcionarios){
				if(f.getCpf().equals(cpf)){
					return f;
				}
			}
		}else if((cpf != null && cpf.length() > 0) && (nome != null && nome.length() > 1)){
			for(Funcionario f : this.funcionarios){
				if(f.getCpf().equals(cpf) && f.getNome().equals(nome)){
					return f;
				}
			}
		}
		return null;
	}

	@Override
	public void cadastraFuncionario(Funcionario f) {
		if(validaFuncionario(f))
			this.funcionarios.add(f);
		else
			JOptionPane.showMessageDialog(null, "Verifique os dados do Funcionário",
					"Erro de cadastro", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public ArrayList<Funcionario> mostraFuncionarios() {
		return this.funcionarios;
	}

	@Override
	public void removeFuncionario(Funcionario f) {
		this.funcionarios.remove(f);		
	}
	
	
	/**
	 * Verifica se todos os atributos obrigatórios estão devidamente preenchidos.
	 * @param f - funcion[ario
	 * @return - false or true.
	 */
	private boolean validaFuncionario(Funcionario f){
		if(f == null)
			return false;
		if(f.getNome() == null || f.getNome().length() <= 1)
			return false;
		if(f.getCpf() == null || f.getCpf().length() < 0)
			return false;
		if(f.getFone1() == null || f.getFone1().length() < 8)
			return false;
		
		return true;
	}
	

}
