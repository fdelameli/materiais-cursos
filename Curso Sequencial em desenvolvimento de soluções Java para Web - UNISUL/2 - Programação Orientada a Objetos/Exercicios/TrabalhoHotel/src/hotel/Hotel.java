package hotel;

import interfaces.ICliente;
import interfaces.IEstadia;
import interfaces.IQuarto;
import interfaces.IReserva;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidades.Cliente;
import entidades.Endereco;
import entidades.Estadia;
import entidades.Quarto;
import entidades.Reserva;

/**
 * Classe que controla todos os métodos do sistema.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public class Hotel implements ICliente, IEstadia, IReserva, IQuarto {

	//atributos

	private String nome;
	private Endereco endereco;
	private String fone;
	private String site;

	private ArrayList<Cliente> clientes;
	private ArrayList<Quarto> quartos;
	private ArrayList<Estadia> estadias;
	private ArrayList<Reserva> reservas;
	
	
	//construtores
	
	public Hotel() {
		this("", new Endereco(), "", "");
		this.clientes = new ArrayList<Cliente>();
		this.quartos = new ArrayList<Quarto>();
		this.estadias = new ArrayList<Estadia>();
		this.reservas = new ArrayList<Reserva>();
	}
	
	public Hotel(String nome, Endereco endereco, String fone, String site){
		this.nome = nome;
		this.endereco = endereco;
		this.fone = fone;
		this.site = site;
		this.clientes = new ArrayList<Cliente>();
		this.quartos = new ArrayList<Quarto>();
		this.estadias = new ArrayList<Estadia>();
		this.reservas = new ArrayList<Reserva>();
	}
	
	
	
	
	//MÉTODOS REFERENTES À CLIENTES
	
	
	@Override
	public void atualizaDadosCliente(Cliente antigo, Cliente novo) {
		if (validaCliente(novo)) {
			novo.setCodigo(antigo.getCodigo());
			this.clientes.remove(antigo);
			this.clientes.add(novo);
		} else {
			msgErro();
		}
	}

	
	@Override
	public ArrayList<Cliente> buscaCliente(String nome) {
		ArrayList<Cliente> c = new ArrayList<Cliente>();
		
		for (int i = 0; i < this.clientes.size(); i++) {
			if(this.clientes.get(i).getNome().contains(nome))
				c.add(this.clientes.get(i));
		}
		return c;
	}
	
	
	@Override
	public void cadastraCliente(Cliente c) {
		if(validaCliente(c)) {
			this.clientes.add(c);
		} else { 
			msgErro();
		}
	}
	

	@Override
	public ArrayList<Cliente> buscaCliente() {
		return this.clientes;
	}

	
	@Override
	public void removeCliente(Cliente c) {
		this.clientes.remove(c);
	}

	
	
	//MÉTODOS REFERENTES À ESTADIAS

	
	@Override
	public void geraEstadia(Reserva r){
		Estadia e = new Estadia(/*r.getQuarto(), r.getDataInicialReserva(), r.getDataFinalReserva()*/);
		
		e.setQuarto(r.getQuarto());
		e.setDataInicialReserva(r.getDataInicialReserva());
		e.setDataFinalReserva(r.getDataFinalReserva());
		e.setQtdDias(r.getQtdDias());
		
		r.getCliente().getEstadias().add(e);
		
	//	this.reservas.remove(r);
	}
	
	
	@Override
	public ArrayList<Estadia> buscaEstadia() {
		return this.estadias;
	}
	
	
	@Override
	public ArrayList<Estadia> buscaEstadia(Quarto q) {
		ArrayList<Estadia> e = new ArrayList<Estadia>();
		for (int i = 0; i < this.estadias.size(); i++) {
			if (this.estadias.get(i).getQuarto().equals(q))
				e.add(this.estadias.get(i));
		}
		return e;
	}
	
	
	@Override
	public ArrayList<Estadia> buscaEstadia(Cliente c) {
		return c.getEstadias();
	}

	
	@Override
	public void cadastraEstadia(Estadia e) {
		this.estadias.add(e);
	}
	
	
	
	//MÉTODOS REFERENTES À RESERVAS
	
	
	
	@Override
	public void atualizaDadosReserva(Reserva nova, Reserva antiga) {
		this.reservas.remove(antiga);
		this.reservas.add(nova);
	}

	
	@Override
	public ArrayList<Reserva> buscaReserva() {
		return this.reservas;
	}

	
	@Override
	public ArrayList<Reserva> buscaReserva(Cliente c) {
		ArrayList<Reserva> r = new ArrayList<Reserva>();
		for (int i = 0; i < this.reservas.size(); i++) {
			if(this.reservas.get(i).getCliente().equals(c))
				r.add(this.reservas.get(i));
		}
		return r;
	}

	
	@Override
	public ArrayList<Reserva> buscaReserva(Quarto q) {
		ArrayList<Reserva> r = new ArrayList<Reserva>();
		for (int i = 0; i < this.reservas.size(); i++) {
			if(this.reservas.get(i).getQuarto().equals(q))
				r.add(this.reservas.get(i));
		}
		return r;
	}

	
	@Override
	public void cadastraReserva(Reserva r) {
		this.reservas.add(r);
	}

	
	@Override
	public void removeReserva(Reserva r) {
		this.reservas.remove(r);
	}

	
	
	
	//MÉTODOS REFERENTES À QUARTOS
	
	
	
	@Override
	public void cadastraQuarto(Quarto q) {
		if(validaQuarto(q)) {
			this.quartos.add(q);
		} else {
			msgErro();
		}
	}

	
	@Override
	public ArrayList<Quarto> mostraQuartos() {
		return this.quartos;
	}

	
	@Override
	public void removeQuarto(Quarto q) {
		this.quartos.remove(q);
	}
	
	
	
	//GETTERS E SETTERS

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(ArrayList<Quarto> quartos) {
		this.quartos = quartos;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	public ArrayList<Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(ArrayList<Estadia> estadias) {
		this.estadias = estadias;
	}
	
	
	
	
	
	//métodos auxiliares

	/**
	 * Método que verifica se os atributos obrigatórios de um ciente são válidos.
	 * @param c - Cliente.
	 * @return true se os atributos são válidos ou false se não forem válidos.
	 */
	private boolean validaCliente(Cliente c){
		if(c == null)
			return false;
		if(c.getNome() == null)
			return false;
		if(c.getSobrenome() == null)
			return false;
		if(c.getCpf() == null)
			return false;
		if(c.getFone1() == null)
			return false;

		return true;
	}
	
	
//	/**
//	 * Método que verifica se os atributos obrigatórios de uma estadia são válidos.
//	 * @param e - Estadia.
//	 * @return true se os atributos são válidos ou false se não forem.
//	 */
//	private boolean validaEstadia(Estadia e){
//		if(e == null)
//			return false;
//		if(e.getQuarto() == null)
//			return false;
//		if(e.getDataInicialReserva() == null)
//			return false;
//		
//		return true;
//	}
//	
//	
//	/**
//	 * Método que verifica se os atributos obrigatórios de uma reserva são válidos.
//	 * @param r - Reserva.
//	 * @return true se os atributos são válidos ou false se não forem.
//	 */
//	private boolean validaReserva(Reserva r){
//		if(r == null)
//			return false;
//		if(r.getQuarto() == null)
//			return false;
//		if(r.getCliente() == null)
//			return false;
//		if(r.getDataInicialReserva() == null)
//			return false;
//		
//		return true;
//	}
	
	
	/**
	 * Método que verifica se os atributos obrigatórios de um quarto são validos.
	 * @param q - Quarto.
	 * @return true se os atributos são válidos ou false se não forem.
	 */
	private boolean validaQuarto(Quarto q) {
		if(q == null)
			return false;
		if(q.getValorDiaria() == 0)
			return false;
		if(q.getQtdPessoas() == 0)
			return false;
		
		return true;
	}
	
	
	
	/**
	 * Mostra uma menssagem de erro sempre que algum
	 * dos dados obrigatórios estiver incorreto.
	 */
	private void msgErro(){
		JOptionPane.showMessageDialog(null, "DADOS DE CADASTRO INVÁLIDOS!", "Por favor, verifique novamente os dados cadastrais!", JOptionPane.ERROR_MESSAGE);
	}

}
