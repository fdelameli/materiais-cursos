import java.text.SimpleDateFormat;
import java.util.Date;

import br.unisul.aula.trabalho.entidades.Aeroporto;
import br.unisul.aula.trabalho.entidades.Atendente;
import br.unisul.aula.trabalho.entidades.Aviao;
import br.unisul.aula.trabalho.entidades.Cliente;
import br.unisul.aula.trabalho.entidades.CompanhiaAerea;
import br.unisul.aula.trabalho.entidades.Endereco;
import br.unisul.aula.trabalho.entidades.Reserva;
import br.unisul.aula.trabalho.entidades.Voo;


public class Principal {
	
	public static void main(String[] args) {
		
		
		//CRIANDO ENDEREÇOS
		
		Endereco endereco1 = new Endereco("Santa Catarina", "Tubarão", "Centro", "Getulho Vargas", 123, 88704300);
		Endereco endereco2 = new Endereco("Santa Catarina", "Jaguaruna", "Beira-Mar", "não tem", 456, 27831782);
		Endereco endereco3 = new Endereco("São Paulo", "São Paulo", "Centro", "Avenida das Flores", 789, 98256314);
		
		
		//CRIANDO DATAS
		
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
			d2 = sdf.parse("27/08/2008");
		} catch (java.text.ParseException e){
			e.printStackTrace();
		}
		sdf.format(d2);
		
		
		Date d3 = new Date();
		try {
			d3 = sdf.parse("04/12/2008");
		} catch (java.text.ParseException e){
			e.printStackTrace();
		}
		sdf.format(d3);
		
		
		
		//CRIANDO AEROPORTOS
		
		Aeroporto aeroporto1 = new Aeroporto("AeroTub", "Tubarão");
		Aeroporto aeroporto2 = new Aeroporto("AeroZamba", "Azambuja");
		
		
		
		//CRIANDO AVIOES
		
		Aviao aviao1 = new Aviao(1, "Intel", "K6", 2000, 100);
		Aviao aviao2 = new Aviao(2, "AMD", "AthlonXP", 2005, 200);
		
		
		
		//CRIANDO CLIENTES
		
		Cliente cliente1 = new Cliente(d1, "João", "1234567890", "1357902", endereco1, 565436);
		Cliente cliente2 = new Cliente(d1, "Maria", "0987654321", "9753104", endereco2, 23425);
		
		
		
		//CRIANDO UM ATENDENTE
		
		Atendente atendente1 = new Atendente(d1, "John", "1230985674", "5933754", endereco3, 121, 123);
		
		
		
		//CRIANDO VÔOS
		
		Voo voo1 = new Voo(1, d2, aeroporto1, aeroporto2, aviao1);
		Voo voo2 = new Voo(2, d3, aeroporto2, aeroporto1, aviao2);
		
		
		
		//CRIANDO A COMPANHIA AÉREA E TESTANDO OS MÉTODOS
		
		CompanhiaAerea companhia = new CompanhiaAerea("Lata-Velha Aerolines Corporation.", "LVAC");
		companhia.addAviao(aviao1);
		companhia.addAviao(aviao2);
		companhia.addVoo(voo1);
		companhia.addVoo(voo2);
		
		companhia.imprimirAvioes();
		
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		
		companhia.imprimirVoos();
		
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("--ANTES DA RESERVA--");
		System.out.println();
		
		System.out.println(voo1);
		
		System.out.println();
		
		Reserva reserva = atendente1.geraReserva(cliente1, voo1);
		
		System.out.println(reserva);
		
		System.out.println();
		System.out.println("--DEPOIS DA RESERVA--");
		System.out.println();
		
		System.out.println(voo1);
		
		
		System.out.println("-----------------------------");
		
		Reserva reserva2 = atendente1.geraReserva(cliente2, voo1);
		
		System.out.println(reserva2);
		
		System.out.println();
		System.out.println("--DEPOIS DA RESERVA--");
		System.out.println();
		
		System.out.println(voo1);
	
		
		
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("--ANTES DA RESERVA--");
		System.out.println();
		
		System.out.println(voo2);
		
		System.out.println();
		
		Reserva reserva3 = atendente1.geraReserva(cliente1, voo2);
		
		System.out.println(reserva3);
		
		System.out.println();
		System.out.println("--DEPOIS DA RESERVA--");
		System.out.println();
		
		System.out.println(voo2);
		
	}
}
