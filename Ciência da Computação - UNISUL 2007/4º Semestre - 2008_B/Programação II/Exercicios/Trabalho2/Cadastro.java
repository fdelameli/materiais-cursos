import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;


public class Cadastro{

	private Cliente cliente;
	private Endereco endereco = new Endereco();

	//construtor

	public Cadastro(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cadastro() {
		this(null);
	}

	//método que chama os métodos principais
	public void fazerCadastro(ArrayList<Cliente> listCliente) { 
		int opcao = menus();
		while (opcao != 6) {
			switch (opcao) {
			case 1:
				int tipoCliente = Integer.parseInt(JOptionPane.showInputDialog("Digite: "+"\n"+"1 - Cliente Comum"+"\n"+"2 - Cliente Especial"+"\n"+"3 - ClientePreferencial" ));
				if(tipoCliente == 1) {
					cadastroClienteComum();
					incluir(listCliente, this.cliente);
				} else if(tipoCliente == 2) {
					cadastroClienteEspecial();
					incluir(listCliente, this.cliente);
				} else if(tipoCliente == 3) {
					cadastroClientePreferencial();
					incluir(listCliente, this.cliente);
				} else {
					JOptionPane.showMessageDialog(null, "Opção Inválida");
				}
				break;
			case 2:
				excluir(listCliente, JOptionPane.showInputDialog("Nome que se deseja excluir"));
				break;
			case 3: 
				JOptionPane.showMessageDialog(null, consultar(listCliente, JOptionPane.showInputDialog("Nome que se deseja consultar")));
				break;
			case 4:
				JOptionPane.showMessageDialog(null, listar(listCliente));
				break;
			case 5:
				alterarCadastro(endereco, listCliente, JOptionPane.showInputDialog("Digite o nome a ser Alterado"));
				break;
			default:
				JOptionPane.showMessageDialog(null,"Operação Inválida");
			break;
			}
			opcao = menus();
		}
	}

	//-----------------------------------------------
	//Métodos Principais
	//-----------------------------------------------

	private void incluir(ArrayList<Cliente> listCliente, Cliente cliente) {
		listCliente.add(cliente);
		JOptionPane.showMessageDialog(null,"Cadastro inserido com sucesso");
	}

	public void excluir(ArrayList<Cliente> listCliente, String nomeConsulta){
		String retorno = "Cliente não encontrado";
		for(int i=0; i<listCliente.size(); i++) {
			if(listCliente.get(i).getNome().equals(nomeConsulta)) {
				listCliente.remove(listCliente.get(i));
				retorno = "Cadastro excluido com sucesso";
				break;
			}
		}
		JOptionPane.showMessageDialog(null, retorno);
	}


	public String consultar(ArrayList<Cliente> listCliente, String nomeConsulta){
		String dados = "Cliente não encontrado";
		for(int i=0; i<listCliente.size(); i++) {
			if(listCliente.get(i).getNome().equals(nomeConsulta)) {
				dados = listCliente.get(i).getNome() + " já está cadastrado";
				break;
			}
		}
		return dados;
	}

	public String listar(ArrayList<Cliente> listCliente) {
		String lista = "Lista: " + "\n";
		Iterator<Cliente> it = listCliente.iterator();
		while(it.hasNext()) {
			Cliente cliente = it.next();
			lista += cliente.getNome() + " - " + cliente.getClass()+ "\n";
		}
		return lista;
	}

	public void alterarCadastro(Endereco endereco, ArrayList<Cliente> listCliente, String nomeConsulta) {
		boolean consulta = false;
		for(int i=0; i<listCliente.size(); i++) {
			if(listCliente.get(i).getNome().equals(nomeConsulta)) {
				listCliente.get(i).setNome(JOptionPane.showInputDialog("Nome do Cliente:"));
				listCliente.get(i).setIdentidade(JOptionPane.showInputDialog("Identidade do Cliente:"));
				listCliente.get(i).setCpf(JOptionPane.showInputDialog("Cpf do Cliente:"));
				listCliente.get(i).setDtNascimento(JOptionPane.showInputDialog("Data de Nascimento do Cliente:"));
				endereco.setRua(JOptionPane.showInputDialog("Rua:"));
				endereco.setBairro(JOptionPane.showInputDialog("Bairro:"));
				endereco.setCidade(JOptionPane.showInputDialog("Cidade:"));
				endereco.setCep(JOptionPane.showInputDialog("Cep:"));
				endereco.setNuTelefone(JOptionPane.showInputDialog("Número do Telefone:"));
				listCliente.get(i).setEndereco(endereco);
				consulta = true;
				JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso");
			} 
		}
		if(consulta == false) {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado");
		}
	}

	//-----------------------------------------------
	//Funcões
	//-----------------------------------------------

	public int menus() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite: " + "\n" +
				"1 - Para Incluir um Cliente" + "\n" +
				"2 - Para Excluir um Cliente" + "\n" +
				"3 - Para Consultar Cliente" + "\n" +
				"4 - Para Listar os Clientes" + "\n" +
				"5 - Para Alterar um Cliente" + "\n" +
		"6 - Para Sair"));
		return opcao;
	}

	private void cadastroClienteComum() {
		ClienteComum cc = new ClienteComum();
		cc.setTaxa(2);
		cc = new ClienteComum();
		endereco = new Endereco();
		cc.setNome(JOptionPane.showInputDialog("Nome do Cliente:"));
		cc.setIdentidade(JOptionPane.showInputDialog("Identidade do Cliente:"));
		cc.setCpf(JOptionPane.showInputDialog("Cpf do Cliente:"));
		cc.setDtNascimento(JOptionPane.showInputDialog("Data de Nascimento do Cliente:"));
		endereco.setRua(JOptionPane.showInputDialog("Rua:"));
		endereco.setBairro(JOptionPane.showInputDialog("Bairro:"));
		endereco.setCidade(JOptionPane.showInputDialog("Cidade:"));
		endereco.setCep(JOptionPane.showInputDialog("Cep:"));
		endereco.setNuTelefone(JOptionPane.showInputDialog("Número do Telefone:"));
		cc.setEndereco(endereco);
		cliente = cc;
	}

	private void cadastroClienteEspecial() {
		ClienteEspecial ce = new ClienteEspecial();
		endereco = new Endereco();
		ce.setNome(JOptionPane.showInputDialog("Nome do Cliente:"));
		ce.setIdentidade(JOptionPane.showInputDialog("Identidade do Cliente:"));
		ce.setCpf(JOptionPane.showInputDialog("Cpf do Cliente:"));
		ce.setDtNascimento(JOptionPane.showInputDialog("Data de Nascimento do Cliente:"));
		endereco.setRua(JOptionPane.showInputDialog("Rua:"));
		endereco.setBairro(JOptionPane.showInputDialog("Bairro:"));
		endereco.setCidade(JOptionPane.showInputDialog("Cidade:"));
		endereco.setCep(JOptionPane.showInputDialog("Cep:"));
		endereco.setNuTelefone(JOptionPane.showInputDialog("Número do Telefone:"));
		ce.setEndereco(endereco);
		cliente = ce;
	}

	private void cadastroClientePreferencial() {
		ClientePreferencial cp = new ClientePreferencial();
		endereco = new Endereco();
		cp.setNome(JOptionPane.showInputDialog("Nome do Cliente:"));
		cp.setIdentidade(JOptionPane.showInputDialog("Identidade do Cliente:"));
		cp.setCpf(JOptionPane.showInputDialog("Cpf do Cliente:"));
		cp.setDtNascimento(JOptionPane.showInputDialog("Data de Nascimento do Cliente:"));
		endereco.setRua(JOptionPane.showInputDialog("Rua:"));
		endereco.setBairro(JOptionPane.showInputDialog("Bairro:"));
		endereco.setCidade(JOptionPane.showInputDialog("Cidade:"));
		endereco.setCep(JOptionPane.showInputDialog("Cep:"));
		endereco.setNuTelefone(JOptionPane.showInputDialog("Número do Telefone:"));
		cp.setEndereco(endereco);
		cliente = cp;
	}
}

