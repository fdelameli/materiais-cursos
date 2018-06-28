import br.unisul.aula.classes.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 * Classe principal do Programa.
 * @author Fabio Dela Bruna
 * @since 18/04/2008
 */
public class Principal {

	static DecimalFormat df = new DecimalFormat("###,###,##0.##");
	
	public static void main(String[] args) {
		
		ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
		byte op = 0;
		
		op = showMenu();
		
		do{
		
			if(op == 0){
				JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema!", "Bye!", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}

			switch(op){

			case 1:
				cadastrarAcidente(acidentes);
				break;


			case 2:
				if(acidentes.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve cadastrar um acidente primeiramente", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Percentual de acidentes com vítimas fatais: " + df.format(Metodos.percentualAcidentesVitimasFatais(acidentes)) + "%");
				}
				break;

			case 3:
				if(acidentes.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve cadastrar um acidente primeiramente", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Percentual de acidentes com menores de idade: " + df.format(Metodos.percentualAcidentesMenoresIdade(acidentes)) + "%");
				}
				break;

			case 4:
			
			if(acidentes.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve cadastrar um acidente primeiramente", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Percentual de pessoas embriagadas: " + df.format(Metodos.percentualEmbriagados(acidentes)) + "%");
				}
				break;

			case 5:
				if(acidentes.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve cadastrar um acidente primeiramente", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Quantidade de acidentes ocorridos no carnaval: " + Metodos.qtdAcidentesCarnaval(acidentes));
				}
				break;

			case 6:
				if(acidentes.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve cadastrar um acidente primeiramente", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Quantidade de acidentes envolvendo condutores de outro estado: " + Metodos.qtdAcidentesOutroEstado(acidentes));
				}
				break;

			case 7:
				if(acidentes.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve cadastrar um acidente primeiramente", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Percentual de mulheres envolvidas em acidentes: " + df.format(Metodos.pencetualMulheresAcidentes(acidentes)) + "%");
				}
				break;

			case 8:
				if(acidentes.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve cadastrar um acidente primeiramente", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Percentual de homens envolvidos em acidentes: " + df.format(Metodos.pencetualHomensAcidentes(acidentes)) + "%");
				}
				break;
				
			case 9:
				if(acidentes.isEmpty()){
					JOptionPane.showMessageDialog(null, "Você deve cadastrar um acidente primeiramente", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Quantidade de acidentes envolvendo motos com vítimas fatais: " + Metodos.qtdAcidenteMotocicletasVitimasFatais(acidentes));
				}
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Operação inválida!", "Error", JOptionPane.ERROR_MESSAGE);
			break;	

			}
			op = showMenu();
		}
		while(op != 0);
		
		JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema!", "Bye", JOptionPane.PLAIN_MESSAGE);
	}
	
	
	// Outros métodos...
	
	
	/**
	 * Método para mostrar o menu do sistema.
	 */
	private static byte showMenu() {
		return Byte.parseByte(
				JOptionPane.showInputDialog(".:: MENU DO SISTEMA ::.\n\n".concat(
						"|1|  -  CADASTRAR ACIDENTE\n\n").concat(
						"|2|  -  PERCENTUAL DE ACIDENTES COM VÍTIMAS FATAIS\n").concat(
						"|3|  -  PERCENTUAL DE ACIDENTES COM MENORES DE 18 ANOS ENVOLVIDOS\n").concat(
						"|4|  -  PERCENTUAL DE EMBRIAGADOS\n").concat(
						"|5|  -  QUANTIDADE DE ACIDENTES OCORRIDOS NO CARNAVAL\n").concat(
						"|6|  -  QUANTIDADE DE ACIDENTES COM CONDUTORES DE OUTRO ESTADO ENVOLVIDOS\n").concat(
						"|7|  -  PERCENTUAL EM QUE AS VÍTIMAS SÃO MULHERES\n").concat(
						"|8|  -  PERCENTUAL EM QUE AS VÍTIMAS SÃO HOMENS\n").concat(
						"|9|  -  QUANTIDADE DE ACIDENTES COM MOTOCICLETAS COM VÍTIMAS FATAIS\n\n".concat(
				"|0|  -  SAIR"))));
	}

	// Outros métodos
	
	/**
	 * Método que cadastra um acidente.
	 * @param acidentes - ArrayList de Acidente
	 */
	private static void cadastrarAcidente(ArrayList<Acidente> acidentes){
		Acidente a = new Acidente();
	
			Pessoa p = cadastraPessoa();
			a.setPessoa(p);
			
			a.setData(verificaData());
			
			a.setTipoVeiculo(verificaVeiculo());
			
			a.setVitimasFatais(verificaAcidentesFatais());
			
			acidentes.add(a);
	}
	
	/**
	 * Método que cadastra uma pessoa.
	 * @return p.
	 */
	private static Pessoa cadastraPessoa(){
		Pessoa p = new Pessoa();
		
		String nome = JOptionPane.showInputDialog("Nome:").toUpperCase();
		p.setNome(nome);
		
		byte idade = Byte.parseByte(JOptionPane.showInputDialog("Idade:"));
		p.setIdade(idade);
		
		char sexo = verificaSexo();
		p.setSexo(sexo);
		
		String estado = JOptionPane.showInputDialog("Estado onde reside:").toUpperCase();
		p.setEstado(estado);
		
		p.setEmbriagado(verificaEmbriagues());
		
		return p;
	}
	
	/**
	 * Método que lê e retorna o tipo do veículo.
	 * @return aux.
	 */
	private static byte verificaVeiculo(){
		byte aux = 0;
		do{
			aux = Byte.parseByte(JOptionPane.showInputDialog("Tipo do veículo: // 1-Automóvel, 2-Motocicleta, 3-Bicicleta"));
			if((aux < 1) || (aux > 3)){
				JOptionPane.showMessageDialog(null, "Opção inválida!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}while((aux < 1) || (aux > 3));
		return aux;
	}
	
	/**
	 * Método que lê e retorna o grau de embriaguês.
	 * @return aux.
	 */
	private static boolean verificaEmbriagues(){
		byte aux;
		do{
			aux = Byte.parseByte(JOptionPane.showInputDialog("Grau de embriaguês: 1-SIM  /  2-NÃO"));
			if((aux < 1) || (aux > 2)){
				JOptionPane.showMessageDialog(null, "Opção inválida!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}while((aux < 1) || (aux > 2));
		if(aux == 2)
			return false;
		else
			return true;
	}
	
	/**
	 * Método que lê e retorna se houve vítima fatal.
	 * @return aux.
	 */
	private static boolean verificaAcidentesFatais(){
		byte aux;
		do{
			aux = Byte.parseByte(JOptionPane.showInputDialog("Houve vítima fatal? 1-SIM  /  2-NÃO"));
			if((aux < 1) || (aux > 2)){
				JOptionPane.showMessageDialog(null, "Opção inválida!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}while((aux < 1) || (aux > 2));
		if(aux == 2)
			return false;
		else
			return true;
	}
	
	/**
	 * Método que lê e retorna o sexo caso ele seja válido.
	 * @return sexo.
	 */
	private static char verificaSexo(){
		char sexo = ' ';
		do{
			sexo = JOptionPane.showInputDialog("Sexo:").toUpperCase().charAt(0);
			if((sexo != 'M') && (sexo != 'F')){
				JOptionPane.showMessageDialog(null, "Sexo inválido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}while(sexo != 'M' && sexo != 'F');
		return sexo;
	}
	
	/**
	 * Metodo que lê a data, verifica se é válida e retorna
	 * @return data.
	 */
	private static String verificaData(){
		String data = "";
		boolean aux = false;
		do{
			data = JOptionPane.showInputDialog("Data do acidente: dd/mm/aaaa");
			String a = data.substring(2, 3);
			String b = data.substring(5, 6);
			if((a.equals("/")) && (b.equals("/")) && (data.length() == 10)){
				aux = true;
			}else{
				JOptionPane.showMessageDialog(null, "Por favor, digite a data no seguinte formato: dd/mm/aaaa", "Formato de DATA inválido!", JOptionPane.ERROR_MESSAGE);
				aux = false;
			}
		}while(aux != true);
		return data;
	}
	
}
