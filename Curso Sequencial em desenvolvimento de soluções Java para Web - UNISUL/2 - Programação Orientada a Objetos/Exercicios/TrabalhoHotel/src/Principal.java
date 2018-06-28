import hotel.Hotel;

import java.util.GregorianCalendar;

import entidades.Cliente;
import entidades.ClienteEspecial;
import entidades.ClienteNormal;
import entidades.Endereco;
import entidades.Estadia;
import entidades.Quarto;
import entidades.QuartoComum;
import entidades.QuartoEspecial;
import entidades.QuartoPresidencial;
import entidades.Reserva;


/**
 * Classe principal para demonstrar o funcionamento do sistema.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public class Principal {


	public static void main(String[] args) {
		
		//criando endereços
		Endereco end1 = new Endereco(1001, "Avenida das Flores", "Dehon", "Tubarão", "Santa Catarina");
		Endereco end2 = new Endereco(730, "Rua Pio VI", "Morrotes", "Tubarão", "Santa Catarina"); 
		Endereco end3 = new Endereco(399, "Rua das Velhinhas", "Bairro Fofoqueiras", "Desconhecida", "Algum Lugar");
		Endereco end4 = new Endereco(2003, "Estrada Geral Azambuja", "Azambuja", "Pedras Grandes", "Santa Catarina");
		
		
		//cadastrando os dados do Hotel
		Hotel hotel = new Hotel("Hotel Caindo aos Pedaços", end1, "www.caindoaospedacos.com.br", "(48) 3626-0666");
		
		
		//cadastrando quartos
		QuartoComum qc = new QuartoComum(5, 50.00);
		hotel.cadastraQuarto(qc);
		
		QuartoEspecial qe = new QuartoEspecial(3, 125.00);
		hotel.cadastraQuarto(qe);
		
		QuartoPresidencial qp = new QuartoPresidencial(2, 200.00);
		hotel.cadastraQuarto(qp);
		
		
		//mostra quartos cadastrados
		System.out.println("==========QUARTOS==========\n");
		for (Quarto q : hotel.mostraQuartos()) {
			System.out.println(q.toString());
		}
		System.out.println("===========================\n");

		
		
		//CRIANDO AS DATAS
		
		GregorianCalendar gc0 = new GregorianCalendar(1989, 4, 23);
		GregorianCalendar gc1 = new GregorianCalendar(2008, 6, 20);
		GregorianCalendar gc2 = new GregorianCalendar(2008, 6, 30);
		GregorianCalendar gc3 = new GregorianCalendar(2008, 7, 10);
		GregorianCalendar gc4 = new GregorianCalendar(2008, 7, 20);
		
		
		
		
		//cadastrando clientes	
		
		ClienteNormal c1 = new ClienteNormal();
		c1.setNome("Fabio");
		c1.setSobrenome("Dela Bruna");
		c1.setCpf("070.071.939-35");
		c1.setEndereco(end2);
		c1.setDataNascimento(gc0);
		c1.setFone1("(48) 3659-0274");
		hotel.cadastraCliente(c1);
		
		ClienteEspecial c2 = new ClienteEspecial();
		c2.setNome("Carlos");
		c2.setSobrenome("Henrique Sá");
		c2.setCpf("070.071.939-35");
		c2.setEndereco(end3);
		c2.setDataNascimento(gc0);
		c2.setFone1("(48) 2345-2423");
		hotel.cadastraCliente(c2);
		
		
		
//		//mostrando clientes cadastrados
//		
//		System.out.println("==========CLIENTES=========\n");
//		for (Cliente c : hotel.buscaCliente()) {
//			System.out.println(c.toString());
//		}
//		System.out.println("===========================\n");
		
		

		
		//CRIANDO RESERVAS
		
		Reserva res1 = new Reserva(c1, qc, gc1, gc2);
		hotel.cadastraReserva(res1);
		
		Reserva res2 = new Reserva(c2, qe, gc1, gc2);
		hotel.cadastraReserva(res2);
	
		Reserva res3 = new Reserva(c2, qp, gc3, gc4);
		hotel.cadastraReserva(res3);
		
		
		//MOSTRANDO RESERVAS FEITAS
		
		
		System.out.println("=========RESERVAS FEITAS=========\n");
		for (Reserva r : hotel.buscaReserva()) {
			System.out.println(r.toString());
		}
		
		System.out.println("===========================\n");
		
		
		
		//GERANDO ESTADIAS ATRAVÉS DAS RESERVAS
		
		hotel.geraEstadia(res1);
		hotel.geraEstadia(res2);
		hotel.geraEstadia(res3);
		

	
		
		//mostrando clientes cadastrados COM SUAS RESPECTIVAS ESTADIAS
		
		System.out.println("==========CLIENTES=========\n");
		for (Cliente c : hotel.buscaCliente()) {
			System.out.println(c.toString());
		}
		System.out.println("===========================\n");
		
	}
	
	
}
