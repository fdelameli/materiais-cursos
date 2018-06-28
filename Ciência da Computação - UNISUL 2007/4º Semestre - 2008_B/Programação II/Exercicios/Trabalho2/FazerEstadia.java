import java.util.ArrayList;

import javax.swing.JOptionPane;


public class FazerEstadia{

	Estadia estadia = new Estadia();

	//método que chama os métodos principais
	public void fazerEstadia(ArrayList<Estadia> listEstadia, ArrayList<Cliente> listCliente, ArrayList<Quarto> listQuarto, ArrayList<Reserva> listReserva) {
		int opcao = menus();
		while(opcao != 5) {
			switch (opcao) {
			case 1:
				this.estadia = new Estadia();
				Cliente cliente = confereNome(listCliente);
				Quarto quarto = confereNuQuarto(listQuarto);
				if(cliente != null && quarto != null) {
					incluirEstadia(listEstadia, cliente, quarto, estadia);
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a Estadia" + "\n" + 
					"Confira se o quarto existe ou se o cliente está cadastrado.");
				}
				break;
			case 2:
				JOptionPane.showMessageDialog(null, calculaDiaria(listEstadia));
				break;
			case 3:
				JOptionPane.showMessageDialog(null, listar(listEstadia));
				break;
			case 4:
				JOptionPane.showMessageDialog(null, estadiaReserva(listEstadia, listReserva));
				break;
			default:
				JOptionPane.showMessageDialog(null, "Operação Inválida");
			break;
			}
			opcao = menus();
		}
	}

	//-------------------------------------------
	//METODOS PRINCIPAIS
	//------------------------------------------

	public void incluirEstadia(ArrayList<Estadia> lisEstadia, Cliente cliente, Quarto quarto, Estadia estadia) {
		if(quarto.isVerificaEstadia()== false) {
			quarto.fazerEstadia();
			estadia.setCliente(cliente);
			estadia.setQuarto(quarto);
			estadia.setQtdDias(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de dias da Estadia")));
			lisEstadia.add(estadia);
			JOptionPane.showMessageDialog(null, "Estadia Cadastrada com Sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "O Quarto esta Reservado ou ja está em Estadia");
		}
	}

	public String calculaDiaria(ArrayList<Estadia> listEstadia){
		String resultado = "Estadia não existente";
		String nome = JOptionPane.showInputDialog("Nome do Cliente");
		int nuQuarto = Integer.parseInt(JOptionPane.showInputDialog("Numero do Quarto"));
		for(int i=0; i<listEstadia.size(); i++) {
			if(listEstadia.get(i).getCliente().getNome().equals(nome) &&
					listEstadia.get(i).getQuarto().getNumQuarto() == nuQuarto) {
				resultado = "Total Estadia: " + listEstadia.get(i).getCliente().calculaDiariaPorCliente(listEstadia.get(i).getQuarto(), listEstadia.get(i).getQtdDias());
				listEstadia.remove(listEstadia.get(i));
				break;
			}
		}
		return resultado;
	}

	public String listar(ArrayList<Estadia> listEstadia) {
		String lista = "Lista: " + "\n";
		for (int i=0; i<listEstadia.size(); i++) {
			lista += "Cliente: " + listEstadia.get(i).getCliente().getNome() + 
			" - Numero Quarto: " + listEstadia.get(i).getQuarto().getNumQuarto() + "\n";
		}
		return lista;
	}

	public String estadiaReserva(ArrayList<Estadia> listEstadia, ArrayList<Reserva> listReserva) {
		String resultado = "Reserva não existente";
		String nome = JOptionPane.showInputDialog("Nome do Cliente");
		int nuQuarto = Integer.parseInt(JOptionPane.showInputDialog("Numero do Quarto"));
		for(int i=0; i<listReserva.size(); i++) {
			if(listReserva.get(i).getCliente().getNome().equals(nome) && 
					listReserva.get(i).getQuarto().getNumQuarto() == nuQuarto) {
				estadia = new Estadia();
				estadia.setCliente(listReserva.get(i).getCliente());
				estadia.setQuarto(listReserva.get(i).getQuarto());
				estadia.setQtdDias(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de dias da Estadia")));
				listEstadia.add(estadia);
				listReserva.remove(listReserva.get(i));
				resultado = "Estadia Cadastrada com Sucesso";
				break;
			}
		}
		return resultado;
	}

	//-----------------------------------------------
	//Funcões
	//-----------------------------------------------

	public int menus() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite: " + "\n" +
				"1 - Para Cadastrar uma Estadia:" + "\n" +
				"2 - Para Calcular o valor da Estadia: " + "\n" +
				"3 - Para Listar as Estadia: " + "\n" +
				"4 - Para Cadastrar uma Estadia a partir de uma reserva: " + "\n" +
		"5 - Para Sair"));
		return opcao;
	}

	public Cliente confereNome(ArrayList<Cliente> listCliente) {
		String nome = JOptionPane.showInputDialog("Nome do Cliente da Reserva");
		Cliente confere = null;
		for(int i=0; i<listCliente.size(); i++) {
			if(listCliente.get(i).getNome().equals(nome)) {
				confere = listCliente.get(i);
			}
		}
		return confere;
	}

	public Quarto confereNuQuarto(ArrayList<Quarto> listQuarto) {
		int nuQuarto = Integer.parseInt(JOptionPane.showInputDialog("Numero do quarto"));
		Quarto confere = null;
		for(int i=0; i<listQuarto.size(); i++) {
			if(listQuarto.get(i).getNumQuarto() == nuQuarto) {
				confere = listQuarto.get(i);
			}
		}
		return confere;
	}

}
