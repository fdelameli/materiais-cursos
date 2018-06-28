package main;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import jdbc.Conexao;
import dao.CandidatoDao;
import dao.CurriculoDao;
import entitys.Candidato;
import entitys.Curriculo;

/**
 * Classe principal do sistema.
 * @author Allan
 */
public class Principal {

	//o correto seria ter um pacote BO onde haveriam classes que fariam as verificacoes e depois chamava a classe dao para inserir.
	public static Connection conn = Conexao.getConexao();
	public static CurriculoDao curriculoDao = new CurriculoDao();
	public static CandidatoDao candidatoDao = new CandidatoDao();
	
	public static void main(String[] args){

		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		} catch (Exception e) {
			
		}
		
		menu();
	}
	
	/**
	 * Menu principal do programa mostrando as opções cadastrar e pesquisar
	 */
	public static void menu() {
	
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n 1 - Cadastrar \n 2 - Buscar \n 3 - Sair"));
		
		if(opcao == 1){
			cadastro();
		}else if(opcao == 2){
			pesquisar();
		}else if(opcao == 3){
			JOptionPane.showMessageDialog( null, "Obrigado por utiliza nosso sistema!", "Finalizando...", JOptionPane.INFORMATION_MESSAGE );
			System.exit( 0 );
		}else{
			menu();
		}
		
		
	}
	
	/**
	 * Método cadastro: Oferece o formulário ao usuário, caso ele escolha no menu principal por cadastrar um novo currículo.
	 */
	public static void cadastro(){
		Candidato candidato = new Candidato();
		Curriculo curriculo = new Curriculo();
		candidato.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o código do candidato: ")));
		curriculo.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o código do currículo: ")));
		curriculo.setNome(JOptionPane.showInputDialog("Digite o nome do candidato: "));
		curriculo.setEndereco(JOptionPane.showInputDialog("Digite o endereço do candidato: "));
		curriculo.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone do candidato: ")));
		curriculo.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do candidato: ")));
		curriculo.setQuantidadeFilhos(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de filhos do candidato: ")));
		curriculo.setSexo(JOptionPane.showInputDialog("Digite o sexo do candidato:\n M - mascuino \n F - feminino ").toUpperCase().charAt(0));
		curriculo.setEnsinoMedio(JOptionPane.showInputDialog("Informe se o candidato possui ensino médio: \n S - sim \n N - não").toUpperCase().charAt(0));
		curriculo.setCursoSuperior(JOptionPane.showInputDialog("Informe se o candidato possui curso superior:\n Exemplo: Ciência da Computação, Engenheiro Civil, ..."));
		curriculo.setCursos(JOptionPane.showInputDialog("Informe se o candidato possui curso de qualificação:\n Exemplo: Informática basica, Segurança no trabalho, ..."));
		int area = 0;
		do {
			area = Integer.parseInt(JOptionPane.showInputDialog("Digite área de atuação do candidato:\n 1 - Administrativo \n 2 - Contabilidade \n 3 - Programação \n 4 - Banco de dados \n 5 - Suporte "));
		} while (area != 1 && area != 2 && area != 3 && area != 4 && area != 5 );
		curriculo.setAreaPretendida( area );
		curriculo.setEmpresa(JOptionPane.showInputDialog("Digite a empresa anterior em qual o candidato trabalhava:"));
		curriculo.setCargo(JOptionPane.showInputDialog("Digite o cargo ocupado no emprego anterior:"));
		curriculo.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do candidato no emprego anterior:")));
		curriculo.setMotivoSaida(JOptionPane.showInputDialog("Digite o que motivou o candidato a sair do emprego anterior:"));
		curriculo.setSalarioPretendido( Double.parseDouble( JOptionPane.showInputDialog( "Digite o salário pretendido:" ) ) );
		candidato.setCurriculo(curriculo);
		curriculoDao.inserir(curriculo);
		candidatoDao.inserir(candidato);
		JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso!");
		menu();
	}
	
	/**
	 * Método pesquisar: Oferece o formulário ao usuário, caso ele escolha no menu principal por pesquisar currículos.
	 */
	public static void pesquisar(){
		ArrayList<Curriculo> listaCurriculos = new ArrayList<Curriculo>();
		char sexo = JOptionPane.showInputDialog("Digite o sexo:").charAt(0);
		int areaPretendida = Integer.parseInt(JOptionPane.showInputDialog("Digite área de atuação do candidato:\n 1 - Administrativo \n 2 - Contabilidade \n 3 - Programação \n 4 - Banco de dados \n 5 - Suporte "));
		String cursoSuperior = JOptionPane.showInputDialog("Digite o curso que o candidato deve possuir:");
		
		listaCurriculos = curriculoDao.pesquisar(sexo, areaPretendida, cursoSuperior);
		
		if (listaCurriculos.size() == 0) {
			JOptionPane.showMessageDialog( null, "Nenhum currículo encontrado!", "Vazio!", JOptionPane.WARNING_MESSAGE );
		} else {
			for ( Curriculo curriculo : listaCurriculos ) {
				JOptionPane.showMessageDialog( null, curriculo.toString(), "Resultado", JOptionPane.PLAIN_MESSAGE);
			}
		}
		menu();
	}
	

}
