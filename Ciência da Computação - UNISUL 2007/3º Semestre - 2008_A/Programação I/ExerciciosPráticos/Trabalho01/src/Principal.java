
import br.unisul.trabalho01.entidades.Aeroporto;
import br.unisul.trabalho01.entidades.Atendente;
import br.unisul.trabalho01.entidades.Aviao;
import br.unisul.trabalho01.entidades.Cliente;
import br.unisul.trabalho01.entidades.CompanhiaAerea;
import br.unisul.trabalho01.entidades.Endereco;
import br.unisul.trabalho01.entidades.Reserva;
import br.unisul.trabalho01.entidades.Voo;

/**
 * Classe principal do Sistema de Reservas.
 * @author Fabio Dela Bruna, Marcio Dela Bruna.
 * @since 10/04/2008.
 */
public class Principal {
	
	public static void main(String[] args) {
		
		Endereco endereco1 = new Endereco("Santa Catarina", "Tubarão", "Centro", "Getulho Vargas", 123, 88704300);
		Endereco endereco2 = new Endereco("Santa Catarina", "Jaguaruna", "Beira-Mar", "não tem", 456, 27831782);
		Endereco endereco3 = new Endereco("São Paulo", "São Paulo", "Centro", "Avenida das Flores", 789, 98256314);
		
		Aeroporto aeroporto1 = new Aeroporto("AeroTub", "Tubarão");
		Aeroporto aeroporto2 = new Aeroporto("AeroZamba", "Azambuja");
		
		Aviao aviao1 = new Aviao(1, "Intel", "K6", 2000, 100);
		Aviao aviao2 = new Aviao(2, "AMD", "AthlonXP", 2005, 200);
		
		Cliente cliente1 = new Cliente("31/3/78", "João", "1234567890", "1357902", endereco1, 1);
		Cliente cliente2 = new Cliente("28/8/60", "Maria", "0987654321", "9753104", endereco2, 2);
		
		Atendente atendente1 = new Atendente("23/6/90", "John", "1230985674", "5933754", endereco3, 121, 123);
		
		Voo voo1 = new Voo(1, "15/4/2008", aeroporto1, aeroporto2, aviao1);
		Voo voo2 = new Voo(2, "20/4/2008", aeroporto2, aeroporto1, aviao2);
		
		CompanhiaAerea companhia = new CompanhiaAerea("Jaguaruna Aerolines Corporation.", "JAC");
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
