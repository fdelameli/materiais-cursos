import java.util.GregorianCalendar;

import br.unisul.aula.trabalho.controller.Concessionaria;
import br.unisul.aula.trabalho.entidades.AluguelDiaria;
import br.unisul.aula.trabalho.entidades.AluguelKm;
import br.unisul.aula.trabalho.entidades.AluguelKmDiaria;
import br.unisul.aula.trabalho.entidades.Caminhao;
import br.unisul.aula.trabalho.entidades.CarroEspecial;
import br.unisul.aula.trabalho.entidades.Cliente;
import br.unisul.aula.trabalho.entidades.Endereco;
import br.unisul.aula.trabalho.entidades.FuncionarioComum;
import br.unisul.aula.trabalho.entidades.FuncionarioExtra;
import br.unisul.aula.trabalho.entidades.Moto;


public class Principal {

	
	public static void main(String[] args) {
		
		//CRIANDO ENDEREÇOS
		
		Endereco end1 = new Endereco("Santa Catarina", "Pedras Grandes", "Azambuja", "Estrada Geral", 1000, "88725-000");
		Endereco end2 = new Endereco("Santa Catarina", "Jaguaruna", "Jagua", "Estrada Geral", 2000, "00000-000");
		Endereco end3 = new Endereco("Santa Catarina", "Tubarão", "Dehon", "Sei lá", 3000, "00000-000");

		
		//CRIANDO A CONCESSIONÁRIA
		Concessionaria conc = new Concessionaria("Aluga Veículos", "(48) 3666-6666", end3, "www.alugaveiculos.com.br");
		
		//CADASTRANDO OS ENDEREÇOS
		conc.cadastraEndereco(end1);
		conc.cadastraEndereco(end2);
		conc.cadastraEndereco(end3);
		
		
		//MOSTRANDO OS ENDEREÇOS CADASTRADOS
		
		System.out.println("<<< ENDEREÇOS CADASTRADOS >>>\n");
		for (int i = 0; i < conc.getEnderecos().size(); i++) {
			System.out.println(conc.getEnderecos().get(i).toString());
		}
		
		
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println();
		
		//CRIANDO AS DATAS
		
		GregorianCalendar gc0 = new GregorianCalendar(1989, 4, 23);
		GregorianCalendar gc1 = new GregorianCalendar(2008, 6, 20);
		GregorianCalendar gc2 = new GregorianCalendar(2008, 6, 30);
		GregorianCalendar gc3 = new GregorianCalendar(2008, 7, 10);
		GregorianCalendar gc4 = new GregorianCalendar(2008, 7, 20);
		
		
		//CRIANDO CLIENTES
		
		
		Cliente c1 = new Cliente((conc.getClientes().size() + 1000), "Fabio", "Dela Bruna", "070.071.939-35", "5.187.508", 'M', end2, gc0, "(48) 3659-0274", "(48) 3659-0274", "123456789-0");
		conc.cadastraCliente(c1);
		
		
		Cliente c2 = new Cliente((conc.getClientes().size() + 1000), "Fabio", "Ozório", "070.071.939-35", "5.187.508", 'M', end2, gc0, "(48) 3659-0274", "(48) 3659-0274", "123456789-0");
		conc.cadastraCliente(c2);
		
		Cliente c3 = new Cliente((conc.getClientes().size() + 1000), "Marcio", "Ozório Teixeira", "070.071.939-35", "5.187.508", 'M', end1, gc0, "(48) 3659-0274", "(48) 3659-0274", "123456789-0");
		conc.cadastraCliente(c3);
		
		System.out.println("<<< CLIENTES CADASTRADOS >>>\n");
		for (int i = 0; i < conc.getClientes().size(); i++) {
			System.out.println(conc.buscaCliente().get(i).toString());
		}
		
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println();
	
		
		
		System.out.println("<<< BUSCA CLIENTE - FABIO - >>>\n");
		for (int i = 0; i < conc.buscaCliente("Fabio").size(); i++) {
			System.out.println(conc.buscaCliente("Fabio").get(i));
		}
		
	
		//ATUALIZANDO OS DADOS DE UM CLIENTE
	
		Cliente c4 = new Cliente(conc.getClientes().size(), "Fabio", "Teixera", "070.071.939-35", "5.187.508", 'M', end1, gc0, "(48) 3659-0274", "(48) 3659-0274", "123456789-0");
		conc.atualizaDadosCliente(c1, c4);
		
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println();
		
		//MOSTRANDO OS CLIENTES NOVAMENTE - AGORA ATUALIZADOS
		
		System.out.println("<<< CLIENTES ATUALIZADOS >>>\n");
		for (int i = 0; i < conc.getClientes().size(); i++) {
			System.out.println(conc.buscaCliente().get(i).toString());
			
		}
		
		
		//CRIANDO FUNCIONARIOS
		
		FuncionarioComum fc = new FuncionarioComum((conc.getFuncionarios().size()+100), "Rogério", "Cortina", "070.071.939-35", "837832-2", 'M', end1, gc0, "4323-2342", "6343-4363", gc1, 2000.00);
		conc.cadastraFuncionario(fc);
		
		FuncionarioExtra fe = new FuncionarioExtra((conc.getFuncionarios().size()+1000), "Alguém", "De Alguma Coisa", "070.071.939-35", "3563445-3", 'F', end1, gc0, "4323-2342", "6343-4363", gc1, 50, 10.00);
		conc.cadastraFuncionario(fe);
		
		
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println();
		
		//MOSTRANDO OS FUNCIONARIOS CADASTRADOS
		
		System.out.println("<<< FUNCIONARIOS CADASTRADOS >>>\n");
		for (int i = 0; i < conc.getFuncionarios().size(); i++) {
			System.out.println(conc.buscaFuncionario().get(i).toString());
			
		}
		
		
		//CRIANDO VEÍCULOS

		Caminhao cam = new Caminhao((conc.getVeiculos().size()+10000),100000.00, 50.00, "A", "B", "Branco", "ASS-1234", "123456789");
		conc.cadastraVeiculo(cam);
		
		CarroEspecial carEsp = new CarroEspecial((conc.getVeiculos().size()+10000), 50000.00, 100.00, "Wolks", "Limosine", "Preto", "FDB-2008", "4736278482");
		conc.cadastraVeiculo(carEsp);
		
		Moto moto = new Moto((conc.getVeiculos().size()+10000), 5000.00, 10.00, "YAMAHA", "XTZ 125ED", "Azul", "YOU-1234", "391839849", true, true);
		conc.cadastraVeiculo(moto);
		
		
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println();
		
		//MOSTRANDO OS VEÍCULOS CADASTRADOS
		
		System.out.println("<< VEÍCULOS CADASTRADOS >>>");
		for (int i = 0; i < conc.getVeiculos().size(); i++) {
			System.out.println(conc.mostraVeiculos().get(i).toString());
		}

	
		//CRIANDO ALUGUEIS
		
		AluguelDiaria ad = new AluguelDiaria(moto, gc1, gc2, 100.00, 200.00);
		conc.cadastraAluguel(ad);
		
		AluguelKm ak = new AluguelKm(cam, gc1, gc2, 100.00, 200.00);
		conc.cadastraAluguel(ak);
		
		AluguelKmDiaria akd = new AluguelKmDiaria(carEsp, gc3, gc4, 100.00, 200.00);
		conc.cadastraAluguel(akd);
	
		
		//CADASTRANDO ALUGUEIS PARA UM CLIENTE
		
		conc.cadastraAluguel(c1, ad);
		conc.cadastraAluguel(c1, ak);
		conc.cadastraAluguel(c2, akd);
		
		//MOSTRANDO OS ALUGUEIS DOS CLIENTES
		
		System.out.println();
		System.out.println();
		System.out.println("<<< ALUGUEIS DO CLIENTE C1(FABIO DELA BRUNA) >>>");
		for (int i = 0; i < conc.buscaAluguel(c1).size(); i++) {
			System.out.println(conc.buscaAluguel(c1).get(i).toString()+"\n\n");
		}
	
		
		//CALCULANDO A RECEITA ATÉ O EXATO MOMENTO
		
		System.out.println();
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println();
		System.out.println("<<< FINANCEIRO >>>");
		System.out.println();
		
		
		System.out.println("TOTAL BRUTO: " + conc.getTotalBruto() + "R$");
		System.out.println("TOTAL DISPESAS: " + conc.getTotalDispesa() + " R$");
		System.out.println("TOTAL LÍQUIDO: " + conc.getTotalLiquido() + " R$");
		
	}
	
}
