import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
		ArrayList<Reserva> listReserva = new ArrayList<Reserva>();
		ArrayList<Quarto> listQuarto = new ArrayList<Quarto>();
		ArrayList<Estadia> listEstadia = new ArrayList<Estadia>();

		Cadastro cadastro = new Cadastro();
		FazerReserva fazerReserva = new  FazerReserva();
		FazerEstadia fazerEstadia = new FazerEstadia();

		//Quartos
		QuartoComum qc1 = new QuartoComum();
		qc1.setNumQuarto(1);
		qc1.setQtdPessoas(2);
		qc1.setValorDiaria(20);
		listQuarto.add(qc1);
		
		QuartoComum qc2 = new QuartoComum();
		qc2.setNumQuarto(2);
		qc2.setQtdPessoas(2);
		qc2.setValorDiaria(20);
		listQuarto.add(qc2);
		
		QuartoEspecial qe = new QuartoEspecial();
		qe.setNumQuarto(3);
		qe.setQtdPessoas(2);
		qe.setValorDiaria(40);
		listQuarto.add(qe);
		
		QuartoPresidencial qp = new QuartoPresidencial();
		qp.setNumQuarto(4);
		qp.setQtdPessoas(2);
		qp.setValorDiaria(50);
		listQuarto.add(qp);

		int opcao = menu();
		while(opcao !=4) {
			switch (opcao) {
			case 1:
				cadastro.fazerCadastro(listCliente);
				break;
			case 2:
				fazerReserva.fazerReserva(listReserva, listCliente, listQuarto);
				break;
			case 3:
				fazerEstadia.fazerEstadia(listEstadia, listCliente, listQuarto, listReserva);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Operação Inválida");
			break;
			}
			opcao = menu();
		}

	}

	static int menu() {
		int opcao  = Integer.parseInt(JOptionPane.showInputDialog("Digite: " + "\n" +
				"1 - Para Cadastro" + "\n" +
				"2 - Para Reservas" + "\n" +
				"3 - Para Estadias" + "\n" +
		"4 - Para Sair"));
		return opcao;
	}
}
