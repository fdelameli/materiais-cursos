package mlp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.Timer;

import mlp.util.FileIO;

/**
 * Classe que representa uma rede MLP que utiliza o algoritmo Backpropagation.
 * @author Fabio Dela Bruna
 */
public class Backpropagation {

	/**
	 * Vetor de dados de entrada.
	 */
	private double[] x;

	/**
	 * Vetor de dados da camada intermediária.
	 */
	private double[] z;

	/**
	 * Vetor de sáida de dados da rede.
	 */
	private double[] y;

	/**
	 * Matriz de pesos entre as camadas de entrada e intermediária.
	 */
	private double[][] v;

	/**
	 * Matriz de pesos entre as camadas intermediária e saída.
	 */
	private double[][] w;

	/**
	 * Recebe os valores da camada de entrada multiplicados pelos respectivos pesos.
	 */
	private double z_in[];

	/**
	 * Recebe os valores da camada oculta multiplicados pelos respectivos pesos.
	 */
	private double y_in[];

	/**
	 * Função de ativação de Delta Z.
	 */
	private double deltaJ_in[];

	/**
	 * Termo de correção do erro para Z.
	 */
	private double deltaJ[];

	/**
	 * Termo de correção do erro para Y.
	 */
	private double deltaK[];

	/**
	 * Erro propagado para V.
	 * */
	private double erroV[][];

	/**
	 * Erro propagado para W.
	 */
	private double erroW[][];

	/**
	 * Saída desejada (target).
	 */
	private double t[];

	/**
	 * Taxa de aprendizado.
	 */
	private double ALPHA;

	/**
	 * Número de neurônios da camada de entrada.
	 */
	private int I;

	/**
	 * Número de neurônios da camada oculta.
	 */
	private int J;

	/**
	 * Número de neurônios da camada de saída.
	 */
	private int K;

	/**
	 * Quantidade de épocas que a rede irá executar.
	 */
	private int epocas;

	/**
	 * Vetor de arquivos de treinamento.
	 */
	private File[] arquivos;

	/**
	 * Matriz de valores alvo.
	 * Cada linha da matriz corresponde a uma letra.
	 */
	private double[][] targets;

	/**
	 * Arquivo de pesos da matriz V.
	 */
	private String fileV;

	/**
	 * Arquivo de pesos da matriz W.
	 */
	private String fileW;

	/**
	 * Vai armazenar o log da aplicação.
	 */
	private String LOG = "";

	/**
	 * Objeto da classe javax.swing.Timer, que realiza a contagem
	 * do tempo gasto para o treinamento da rede.
	 */
	private Timer timer;

	/**
	 * Inteiro que armazena a contagem do tempo gasto para o treinamento.
	 */
	private int tempo;


	/**
	 * Construtor padrão da classe.
	 * Inicializa os atributos necessários.
	 * 
	 * @param fileV Arquivo onde será gravado os pesos da matriz V.
	 * @param fileW Arquivo onde será gravado os pesos da matriz W.
	 * @param alpha Define o valor do ALPHA.
	 * @param qtdNeurEntrada Quantidade de neurônios de entrada.
	 * @param qtdNeurOculta Quantidade de neurônios da camada oculta.
	 * @param qtdNeurSaida Quantidade de neurônios da camada de saída.
	 * @param iter Número de epocas que a rede irá executar o treinamento.
	 * @param t Matriz contendo os targets.
	 * @param path Pasta contendo os arquivos para treinamento.
	 */
	public Backpropagation( String fileV, String fileW, double alpha, int qtdNeurEntrada, int qtdNeurOculta, int qtdNeurSaida, double[][] targets, int iter, String path ) {
		disparaRelogio();
		LOG += String.format( "[%s]\t\tAlgoritmo iniciado!\n", getHour() );
		this.ALPHA = alpha;
		this.I = qtdNeurEntrada;
		this.J = qtdNeurOculta;
		this.K = qtdNeurSaida;

		this.x = new double[ I ];
		this.z = new double[ J ];
		this.y = new double[ K ];
		this.v = new double[ I ][ J ];
		this.w = new double[ J ][ K ];
		this.z_in = new double[ J ];
		this.y_in = new double[ K ];
		this.deltaJ_in = new double[ J ];
		this.deltaJ = new double[ J ];
		this.deltaK = new double[ K ];
		this.erroV = new double[ I ][ J ];
		this.erroW = new double[ J ][ K ];
		this.t = new double[ K ];
		this.targets = targets;
		this.epocas = iter;
		this.fileV = fileV;
		this.fileW = fileW;

		this.arquivos = new File( path ).listFiles();
	}


	/**
	 * Construtor usado apenas para efetuar testes da rede.
	 * É preciso que os pesos já estejam calculados e gravados em arquivos.
	 * 
	 * @param fileV Arquivo que contém os pesos gravados da matriz V.
	 * @param fileW Arquivo que contém os pesos gravados da matriz W.
	 * @param qtdNeurEntrada Quantidade de neurônios de entrada.
	 * @param qtdNeurOculta Quantidade de neurônios da camada oculta.
	 * @param qtdNeurSaida Quantidade de neurônios da camada de saída.
	 */
	public Backpropagation( String fileV, String fileW, int qtdNeurEntrada, int qtdNeurOculta, int qtdNeurSaida ) {
		System.out.printf( String.format( "[%s]\t\tAlgoritmo iniciado!\n", getHour() ) );
		this.I = qtdNeurEntrada;
		this.J = qtdNeurOculta;
		this.K = qtdNeurSaida;

		this.x = new double[ I ];
		this.z = new double[ J ];
		this.y = new double[ K ];
		this.v = new double[ I ][ J ];
		this.w = new double[ J ][ K ];
		this.z_in = new double[ J ];
		this.y_in = new double[ K ];
		this.t = new double[ K ];
		this.fileV = fileV;
		this.fileW = fileW;

		System.out.printf( String.format( "[%s]\t\tCarregando pesos...\n", getHour() ) );
		FileIO.readWeights( fileV, fileW, v, w, I, J, K );
		System.out.printf( String.format( "[%s]\t\tPesos carregados com sucesso!\n", getHour() ) );
	}


	/**
	 * Efetua o treinamento da rede.
	 */
	public void treinar() throws IOException {
		LOG += String.format( "[%s]\t\tTreinamento da rede iniciado!\n", getHour() );

		// passo 0 : inicializar pesos.
		LOG += String.format( "[%s]\t\tIniciando pesos...\n", getHour() );
		inicializaPesos();
		LOG += String.format( "[%s]\t\tPesos inicializados!\n", getHour() );

		// passo 1 : enquanto condição de parada for falsa... executa passos 2-9.
		for ( int epcs = 0; epcs < epocas; epcs++ ) {

			// passo 2 : para cada par de treinamento... executa passos 3-8.
			for ( int arquv = 0; arquv < arquivos.length; arquv++ ) {

				// passo 3 :
				x = FileIO.getPixels( arquivos[ arquv ] );
				for ( int i = 0; i < targets[ arquv ].length; i++ )
					t[ i ] = targets[ arquv ][ i ];

				// passo 4 :
				for ( int j = 0; j < J; j++ ) {
					z_in[ j ] = 0.0;
					for ( int i = 0; i < I; i++ ) {
						z_in[ j ] += x[ i ] * v[ i ][ j ];
					}
					z[ j ] = funcaoAtivacao( z_in[ j ] ); // utiliza função de ativação.
				}

				// passo 5 :
				for ( int k = 0; k < K; k++ ) {
					y_in[ k ] = 0.0;
					for ( int j = 0; j < J; j++ ) {
						y_in[ k ] += ( z[ j ] * w[ j ][ k ] );
					}
					y[ k ] = funcaoAtivacao( y_in[ k ] );
				}

				// passo 6 :
				for ( int k = 0; k < K; k++ ) {
					deltaK[ k ] = ( t[ k ] - y[ k ] ) * funcaoAtivacaoLinha( y[ k ] );
				}

				for ( int j = 0; j < J; j++ ) {
					for ( int k = 0; k < K; k++ ) {
						erroW[ j ][ k ] = ALPHA * deltaK[ k ] * z[ j ];
					}
				}

				// passo 7 :
				for ( int j = 0; j < J; j++ ) {
					deltaJ_in[ j ] = 0.0;
					for ( int k = 0; k < K; k++ ) {
						deltaJ_in[ j ] += ( deltaK[ k ] * w[ j ][ k ] );
					}
					deltaJ[ j ] = ( deltaJ_in[ j ] * funcaoAtivacaoLinha( z[ j ] ) );
				}

				for ( int i = 0; i < I; i++ ) {
					for ( int j = 0; j < J; j++ ) {
						erroV[ i ][ j ] = ALPHA * deltaJ[ j ] * x[ i ];
					}
				}

				// passo 8 :
				for ( int j = 0; j < J; j++ ) {
					for ( int k = 0; k < K; k++ ) {
						w[ j ][ k ] += erroW[ j ][ k ];
					}
				}

				for ( int i = 0; i < I; i++ ) {
					for ( int j = 0; j < J; j++ ) {
						v[ i ][ j ] += erroV[ i ][ j ];
					}
				}
			}

			LOG += String.format( String.format( "[%s]\t\tTérmino do período %d de treinamento.\n", getHour(), epcs ) );

		}
		LOG += String.format( "[%s]\t\tTREINAMENTO DA REDE CONCLUÍDO!\n", getHour() );

		LOG += String.format( "[%s]\t\tGravando pesos...\n", getHour() );
		FileIO.gravaPesos( fileV, fileW, v, w, I, J, K );
		LOG += String.format( "[%s]\t\tPesos gravados com sucesso!\n", getHour() );

		LOG += String.format( "[%s]\t\tAlgoritmo finalizado!\n", getHour() );
		LOG += String.format( "Tempo gasto: [%s]\n", getTotalTime( tempo ) );
		FileIO.writeLog( LOG );
	}


	/**
	 * Faz o teste da rede de acordo com um arquivo passado por parâmetro.
	 * @param arquv Arquivo gerado automaticamente quando o usuário clicar
	 * no botão "RECONHECER" na janela da aplicação.
	 */
	public double[] testar( File arquv ) throws IOException {
		System.out.printf( "\nIniciando teste da rede com a letra %s\n", arquv.getName() );

		x = FileIO.getPixels( arquv );

		for ( int j = 0; j < J; j++ ) {
			z_in[ j ] = 0.0;
			for ( int i = 0; i < I; i++ ) {
				z_in[ j ] += ( x[ i ] * v[ i ][ j ] );
			}
			z[ j ] = funcaoAtivacao( z_in[ j ] );
		}

		for ( int k = 0; k < K; k++ ) {
			y_in[ k ] = 0.0;
			for ( int j = 0; j < J; j++ ) {
				y_in[ k ] += ( z[ j ] * w[ j ][ k ] );
			}
			y[ k ] = funcaoAtivacao( y_in[ k ] );
		}

		System.out.println( "Teste concluído!" );
		System.out.println( "Resultado:" );
		for ( int i = 0; i < y.length; i++ ) {
			System.out.printf( "%f\t", y[ i ] );
		}
		System.out.println();
		return y;
	}


	/**
	 * Função de ativação.
	 */
	private double funcaoAtivacao( double x ) {
		return 1 / ( 1 + Math.exp( -1 * x ) );
		// return ( 2.0 / ( 1.0 + Math.exp( -1 * x ) ) ) - 1;
	}

	/**
	 * Função inversa de ativação.
	 */
	private double funcaoAtivacaoLinha( double fx ) {
		return fx * ( 1 - fx );
		// return ( ( 1 + fx ) * ( 1 - fx ) ) * 0.5;
	}

	/**
	 * Inicializa aleatoriamente os pesos das matrizes v e w.
	 * Os pesos são gerados em um intervalo entre -0,5 e 0,5.
	 */
	private void inicializaPesos() {
		Random r = new Random( 1 );

		// gera pesos para matriz v
		for ( int i = 0; i < I; i++ )
			for ( int j = 0; j < J; j++ )
				v[ i ][ j ] = r.nextDouble() - 0.5;

		// gera pesos para matriz w
		for ( int j = 0; j < w.length; j++ )
			for ( int k = 0; k < w[ j ].length; k++ )
				w[ j ][ k ] = r.nextDouble() - 0.5;

	}

	/**
	 * Método que retorna a hora atual.
	 */
	private String getHour() {
		GregorianCalendar calendario = new GregorianCalendar();
		int h = calendario.get( GregorianCalendar.HOUR_OF_DAY );
		int m = calendario.get( GregorianCalendar.MINUTE );
		int s = calendario.get( GregorianCalendar.SECOND );
		String hora = ( ( h < 10 ) ? "0" : "" ) + h + ":"
						+ ( ( m < 10 ) ? "0" : "" ) + m + ":"
						+ ( ( s < 10 ) ? "0" : "" ) + s;
		return hora;
	}

	/**
	 * Retorna o tempo total gasto com o treinamento.
	 */
	private String getTotalTime( int tempo ) {
		int h = 0;
		int m = 0;
		int s = 0;
		h = tempo / 60 / 60;
		m = ( tempo / 60 ) % 60;
		s = tempo % 60;
		return String.format( "%02d:%02d:%02d", h, m, s );
	}

	/**
	 * Inicializa o timer (contador), que é utilizado para contabilizar
	 * o tempo total gasto para que a rede seja treinada.
	 */
	private void disparaRelogio() {
		if ( timer == null ) {
			timer = new Timer( 1000, new ActionListener() {

				public void actionPerformed( ActionEvent arg0 ) {
					tempo++;
				}
			} );
			timer.setInitialDelay( 0 );
			timer.start();
		} else if ( !timer.isRunning() ) {
			timer.restart();
		}
	}


}
