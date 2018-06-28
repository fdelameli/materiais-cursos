import java.text.SimpleDateFormat;
import java.util.Date;

import br.unisul.aula.trabalho.controller.Hotel;
import br.unisul.aula.trabalho.dto.*;


/**
 * Classe principal para demonstrar o funcionamento do sistema.
 * @author Fabio Dela Bruna / Marcio Teixeira Ozório
 * @since
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

		
		
		//criando datas
		Date d1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d1 = sdf.parse("23/04/1989");
		} catch (java.text.ParseException e){
			e.printStackTrace();
		}
		sdf.format(d1);
		
		Date d2 = new Date();
		try {
			d2 = sdf.parse("27/08/1985");
		} catch (java.text.ParseException e){
			e.printStackTrace();
		}
		sdf.format(d2);
		
		Date d3 = new Date();
		try {
			d3 = sdf.parse("04/12/1988");
		} catch (java.text.ParseException e){
			e.printStackTrace();
		}
		sdf.format(d3);
		
		Date dataReserva = new Date();
		try {
			dataReserva = sdf.parse("23/04/2008");
		} catch (java.text.ParseException e){
			e.printStackTrace();
		}
		sdf.format(dataReserva);
		
		
		//criando estadias
		Estadia e = new Estadia();
		e.setQuarto(qp);
		e.setDataReserva(dataReserva);
		e.setQtdDias(3);
		hotel.cadastraEstadia(e);
		
		Estadia e2 = new Estadia();
		e2.setQuarto(qc);
		e2.setDataReserva(dataReserva);
		e2.setQtdDias(2);
		hotel.cadastraEstadia(e2);
			
		
		
		//cadastrando clientes		
		ClienteNormal c1 = new ClienteNormal();
		c1.setNome("Fabio");
		c1.setSobrenome("Dela Bruna");
		c1.setCpf("070.071.939-35");
		c1.setEndereco(end2);
		c1.setDataNascimento(d1);
		c1.setFone1("(48) 3659-0274");
		c1.cadastraEstadia(e);
		hotel.cadastraCliente(c1);
		
		ClienteEspecial c2 = new ClienteEspecial();
		c2.setNome("Márcio");
		c2.setSobrenome("Ozório Teixeira");
		c2.setCpf("070.071.939-35");
		c2.setEndereco(end3);
		c2.setDataNascimento(d2);
		c2.setFone1("(48) 2345-2423");
		c2.cadastraEstadia(e2);
		hotel.cadastraCliente(c2);
		
		
		
		//mostrando clientes cadastrados
		System.out.println("==========CLIENTES=========\n");
		for (Cliente c : hotel.mostraClientes()) {
			System.out.println(c.toString());
		}
		System.out.println("===========================\n");
		
		
		
		//buscando um cliente específico
		System.out.println(hotel.buscaCliente("Fabio", "Dela Bruna"));
		

		
	
		
	}
}
