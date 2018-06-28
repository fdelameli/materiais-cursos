package com.br.olaria.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import com.br.olaria.serial.PortaSerial;
import com.br.olaria.util.SwtUtils;
import com.br.olaria.view.constants.Constants;


public class MainGUI {

	private Shell shell = null;
	private Composite composite  = null;
	private Group groupSensorTemp = null;
	private Group groupSensorUmidade1 = null;
	private static CLabel labelSensorTemp1 = null;
	private static CLabel labelSensorTemp2 = null;
	private static CLabel labelSensorTemp3 = null;
	private static CLabel labelSensorTemp4 = null;
	private static CLabel labelSensorUmidade1 = null;
	private static CLabel labelSensorUmidade2 = null;
	private static CLabel labelSensorUmidade3 = null;
	private static CLabel labelSensorUmidade4 = null;
	private CLabel labelExaustor1 = null;
	private CLabel labelExaustor2 = null;
	private CLabel labelExaustor3 = null;
	private Button btExaustor1Liga = null;
	private Button btExaustor1Desliga = null;
	private Button btExaustor2Liga = null;
	private Button btExaustor2Desliga = null;
	private Button btExaustor3Desliga = null;
	private Button btExaustor3Liga = null;

	private static PortaSerial porta;


	/**
	 * This method initializes sShell
	 */
	public Shell createSShell() {
		shell = new Shell( SWT.CLOSE );
		shell.setText( "Sistema OLARIA" );
		shell.setLayout( null );
		shell.setBounds( new Rectangle( 175, 175, 881, 385 ) );
		createComposite();
		Menu menuBar = new Menu( shell, SWT.BAR );
		MenuItem submenuItem = new MenuItem( menuBar, SWT.CASCADE );
		submenuItem.setText( "&Arquivo" );
		Menu submenu = new Menu( submenuItem );
		MenuItem menuItemSair = new MenuItem( submenu, SWT.PUSH );
		menuItemSair.setText( "&Sair" );
		menuItemSair.addSelectionListener( new SelectionListener() {
			public void widgetSelected( SelectionEvent arg0 ) {
				exitProgram();
			}
			public void widgetDefaultSelected( SelectionEvent arg0 ) {
			}
		} );
		submenuItem.setMenu( submenu );
		shell.setMenuBar( menuBar );
		return shell;
	}

	/**
	 * This method initializes composite
	 * 
	 */
	private void createComposite() {
		composite = new Composite( shell, SWT.NONE );
		composite.setBounds( new Rectangle( 0, 0, 864, 326 ) );
		composite.setLayout( null );
		createGroupSensorTemp();
		createGroupSensorUmidade1();
		createGroupExaustores();
	}

	/**
	 * This method initializes groupSensorTemp
	 * 
	 */
	private void createGroupSensorTemp() {
		groupSensorTemp = new Group( composite, SWT.NONE );
		groupSensorTemp.setLayout( null );
		groupSensorTemp.setText( "Sensores de temperatura" );
		groupSensorTemp.setFont( new Font( Display.getDefault(), "Segoe UI", 12, SWT.BOLD | SWT.ITALIC ) );
		createCompositeSensorTemp1();
		groupSensorTemp.setBounds( new Rectangle( 15, 15, 544, 135 ) );
		CLabel labelst1 = new CLabel( groupSensorTemp, SWT.CENTER );
		labelst1.setText( "SENSOR 1" );
		labelst1.setFont( new Font( Display.getDefault(), "Segoe UI", 14, SWT.BOLD ) );
		labelst1.setBounds( new Rectangle( 15, 90, 109, 30 ) );
		createCompositeSensorTemp2();
		createCompositeSensorTemp3();
		createCompositeSensorTemp4();
		CLabel labelst2 = new CLabel( groupSensorTemp, SWT.CENTER );
		labelst2.setFont( new Font( Display.getDefault(), "Segoe UI", 14, SWT.BOLD ) );
		labelst2.setText( "SENSOR 2" );
		labelst2.setBounds( new Rectangle( 150, 90, 109, 30 ) );
		CLabel labelst3 = new CLabel( groupSensorTemp, SWT.CENTER );
		labelst3.setFont( new Font( Display.getDefault(), "Segoe UI", 14, SWT.BOLD ) );
		labelst3.setText( "SENSOR 3" );
		labelst3.setBounds( new Rectangle( 285, 90, 109, 30 ) );
		CLabel labelst4 = new CLabel( groupSensorTemp, SWT.CENTER );
		labelst4.setFont( new Font( Display.getDefault(), "Segoe UI", 14, SWT.BOLD ) );
		labelst4.setText( "SENSOR 4" );
		labelst4.setBounds( new Rectangle( 420, 90, 109, 30 ) );
	}

	/**
	 * This method initializes compositeSensorTemp1
	 * 
	 */
	private void createCompositeSensorTemp1() {
		Composite compositeSensorTemp1 = new Composite( groupSensorTemp, SWT.BORDER );
		compositeSensorTemp1.setLayout( null );
		compositeSensorTemp1.setBounds( new Rectangle( 15, 30, 109, 59 ) );
		labelSensorTemp1 = new CLabel( compositeSensorTemp1, SWT.CENTER );
		labelSensorTemp1.setText( "" );
		labelSensorTemp1.setFont( new Font( Display.getDefault(), "Arial", 24, SWT.NORMAL ) );
		labelSensorTemp1.setBounds( new Rectangle( 0, 0, 105, 55 ) );
	}

	/**
	 * This method initializes compositeSensorTemp2
	 * 
	 */
	private void createCompositeSensorTemp2() {
		Composite compositeSensorTemp2 = new Composite( groupSensorTemp, SWT.BORDER );
		compositeSensorTemp2.setLayout( null );
		compositeSensorTemp2.setBounds( new Rectangle( 150, 30, 109, 59 ) );
		labelSensorTemp2 = new CLabel( compositeSensorTemp2, SWT.CENTER );
		labelSensorTemp2.setFont( new Font( Display.getDefault(), "Arial", 24, SWT.NORMAL ) );
		labelSensorTemp2.setText( "" );
		labelSensorTemp2.setBounds( new Rectangle( 0, 0, 105, 55 ) );
	}

	/**
	 * This method initializes compositeSensorTemp3
	 * 
	 */
	private void createCompositeSensorTemp3() {
		Composite compositeSensorTemp3 = new Composite( groupSensorTemp, SWT.BORDER );
		compositeSensorTemp3.setLayout( null );
		compositeSensorTemp3.setBounds( new Rectangle( 285, 30, 109, 59 ) );
		labelSensorTemp3 = new CLabel( compositeSensorTemp3, SWT.CENTER );
		labelSensorTemp3.setFont( new Font( Display.getDefault(), "Arial", 24, SWT.NORMAL ) );
		labelSensorTemp3.setText( "" );
		labelSensorTemp3.setBounds( new Rectangle( 0, 0, 105, 55 ) );
	}

	/**
	 * This method initializes compositeSensorTemp4
	 * 
	 */
	private void createCompositeSensorTemp4() {
		Composite compositeSensorTemp4 = new Composite( groupSensorTemp, SWT.BORDER );
		compositeSensorTemp4.setLayout( null );
		compositeSensorTemp4.setBounds( new Rectangle( 420, 30, 109, 59 ) );
		labelSensorTemp4 = new CLabel( compositeSensorTemp4, SWT.CENTER );
		labelSensorTemp4.setFont( new Font( Display.getDefault(), "Arial", 24, SWT.NORMAL ) );
		labelSensorTemp4.setText( "" );
		labelSensorTemp4.setBounds( new Rectangle( 0, 0, 105, 55 ) );
	}

	/**
	 * This method initializes groupSensorUmidade1
	 * 
	 */
	private void createGroupSensorUmidade1() {
		groupSensorUmidade1 = new Group( composite, SWT.NONE );
		groupSensorUmidade1.setLayout( null );
		groupSensorUmidade1.setText( "Sensores de umidade" );
		groupSensorUmidade1.setFont( new Font( Display.getDefault(), "Segoe UI", 12, SWT.BOLD | SWT.ITALIC ) );
		createCompositeSensorUmidade1();
		groupSensorUmidade1.setBounds( new Rectangle( 15, 170, 544, 135 ) );
		CLabel labelsu1 = new CLabel( groupSensorUmidade1, SWT.CENTER );
		labelsu1.setFont( new Font( Display.getDefault(), "Segoe UI", 14, SWT.BOLD ) );
		labelsu1.setText( "SENSOR 1" );
		labelsu1.setBounds( new Rectangle( 15, 90, 109, 30 ) );
		createCompositeSensorUmidade2();
		createCompositeSensorUmidade3();
		createCompositeSensorUmidade4();
		CLabel labelsu2 = new CLabel( groupSensorUmidade1, SWT.CENTER );
		labelsu2.setFont( new Font( Display.getDefault(), "Segoe UI", 14, SWT.BOLD ) );
		labelsu2.setText( "SENSOR 2" );
		labelsu2.setBounds( new Rectangle( 150, 90, 109, 30 ) );
		CLabel labelsu3 = new CLabel( groupSensorUmidade1, SWT.CENTER );
		labelsu3.setFont( new Font( Display.getDefault(), "Segoe UI", 14, SWT.BOLD ) );
		labelsu3.setText( "SENSOR 3" );
		labelsu3.setBounds( new Rectangle( 285, 90, 109, 30 ) );
		CLabel labelsu4 = new CLabel( groupSensorUmidade1, SWT.CENTER );
		labelsu4.setFont( new Font( Display.getDefault(), "Segoe UI", 14, SWT.BOLD ) );
		labelsu4.setText( "SENSOR 4" );
		labelsu4.setBounds( new Rectangle( 420, 90, 109, 30 ) );
	}

	/**
	 * This method initializes compositeSensorUmidade1
	 * 
	 */
	private void createCompositeSensorUmidade1() {
		Composite compositeSensorUmidade1 = new Composite( groupSensorUmidade1, SWT.BORDER );
		compositeSensorUmidade1.setLayout( null );
		compositeSensorUmidade1.setBounds( new Rectangle( 15, 30, 109, 59 ) );
		labelSensorUmidade1 = new CLabel( compositeSensorUmidade1, SWT.CENTER );
		labelSensorUmidade1.setFont( new Font( Display.getDefault(), "Arial", 24, SWT.NORMAL ) );
		labelSensorUmidade1.setText( "" );
		labelSensorUmidade1.setBounds( new Rectangle( 0, 0, 105, 55 ) );
	}

	/**
	 * This method initializes compositeSensorUmidade2
	 * 
	 */
	private void createCompositeSensorUmidade2() {
		Composite compositeSensorUmidade2 = new Composite( groupSensorUmidade1, SWT.BORDER );
		compositeSensorUmidade2.setLayout( null );
		compositeSensorUmidade2.setBounds( new Rectangle( 150, 30, 109, 59 ) );
		labelSensorUmidade2 = new CLabel( compositeSensorUmidade2, SWT.CENTER );
		labelSensorUmidade2.setFont( new Font( Display.getDefault(), "Arial", 24, SWT.NORMAL ) );
		labelSensorUmidade2.setText( "" );
		labelSensorUmidade2.setBounds( new Rectangle( 0, 0, 105, 55 ) );
	}

	/**
	 * This method initializes compositeSensorUmidade3
	 * 
	 */
	private void createCompositeSensorUmidade3() {
		Composite compositeSensorUmidade3 = new Composite( groupSensorUmidade1, SWT.BORDER );
		compositeSensorUmidade3.setLayout( null );
		compositeSensorUmidade3.setBounds( new Rectangle( 285, 30, 109, 59 ) );
		labelSensorUmidade3 = new CLabel( compositeSensorUmidade3, SWT.CENTER );
		labelSensorUmidade3.setFont( new Font( Display.getDefault(), "Arial", 24, SWT.NORMAL ) );
		labelSensorUmidade3.setText( "" );
		labelSensorUmidade3.setBounds( new Rectangle( 0, 0, 105, 55 ) );
	}

	/**
	 * This method initializes compositeSensorUmidade4
	 * 
	 */
	private void createCompositeSensorUmidade4() {
		Composite compositeSensorUmidade4 = new Composite( groupSensorUmidade1, SWT.BORDER );
		compositeSensorUmidade4.setLayout( null );
		compositeSensorUmidade4.setBounds( new Rectangle( 420, 30, 109, 59 ) );
		labelSensorUmidade4 = new CLabel( compositeSensorUmidade4, SWT.CENTER );
		labelSensorUmidade4.setFont( new Font( Display.getDefault(), "Arial", 24, SWT.NORMAL ) );
		labelSensorUmidade4.setText( "" );
		labelSensorUmidade4.setBounds( new Rectangle( 0, 0, 105, 55 ) );
	}

	/**
	 * This method initializes groupExaustores
	 * 
	 */
	private void createGroupExaustores() {
		Group groupExaustores = new Group( composite, SWT.NONE );
		groupExaustores.setLayout( null );
		groupExaustores.setText( "Exaustores" );
		groupExaustores.setFont( new Font( Display.getDefault(), "Segoe UI", 12, SWT.BOLD | SWT.ITALIC ) );
		groupExaustores.setBounds( new Rectangle( 580, 15, 270, 290 ) );
		labelExaustor1 = new CLabel( groupExaustores, SWT.CENTER | SWT.SHADOW_IN );
		labelExaustor1.setText( "Desligado" );
		labelExaustor1.setFont( new Font( Display.getDefault(), "Segoe UI", 14, SWT.BOLD ) );
		labelExaustor1.setBackground( new Color( Display.getCurrent(), 220, 0, 0 ) );
		labelExaustor1.setBounds( new Rectangle( 40, 30, 130, 77 ) );
		labelExaustor2 = new CLabel( groupExaustores, SWT.CENTER | SWT.SHADOW_IN );
		labelExaustor2.setFont( new Font( Display.getDefault(), "Segoe UI", 14, SWT.BOLD ) );
		labelExaustor2.setText( "Desligado" );
		labelExaustor2.setBackground( new Color( Display.getCurrent(), 220, 0, 0 ) );
		labelExaustor2.setBounds( new Rectangle( 40, 115, 130, 77 ) );
		labelExaustor3 = new CLabel( groupExaustores, SWT.CENTER | SWT.SHADOW_IN );
		labelExaustor3.setFont( new Font( Display.getDefault(), "Segoe UI", 14, SWT.BOLD ) );
		labelExaustor3.setText( "Desligado" );
		labelExaustor3.setBackground( new Color( Display.getCurrent(), 220, 0, 0 ) );
		labelExaustor3.setBounds( new Rectangle( 40, 200, 130, 77 ) );
		CLabel cLabel = new CLabel( groupExaustores, SWT.CENTER );
		cLabel.setText( "1" );
		cLabel.setFont( new Font( Display.getDefault(), "Segoe UI", 10, SWT.BOLD ) );
		cLabel.setBounds( new Rectangle( 8, 30, 27, 77 ) );
		CLabel cLabel1 = new CLabel( groupExaustores, SWT.CENTER );
		cLabel1.setText( "2" );
		cLabel1.setFont( new Font( Display.getDefault(), "Segoe UI", 10, SWT.BOLD ) );
		cLabel1.setBounds( new Rectangle( 8, 115, 27, 77 ) );
		CLabel cLabel11 = new CLabel( groupExaustores, SWT.CENTER );
		cLabel11.setFont( new Font( Display.getDefault(), "Segoe UI", 10, SWT.BOLD ) );
		cLabel11.setText( "3" );
		cLabel11.setBounds( new Rectangle( 8, 200, 27, 77 ) );

		btExaustor1Liga = new Button( groupExaustores, SWT.NONE );
		btExaustor1Liga.setBounds( new Rectangle( 180, 32, 80, 35 ) );
		btExaustor1Liga.setBackground( new Color( Display.getCurrent(), 0, 150, 0 ) );
		btExaustor1Liga.setText( "Ligar" );
		btExaustor1Liga.addSelectionListener( new SelectionListener() {
			public void widgetSelected( SelectionEvent arg0 ) {
				ligaExaustor( Constants.EXAUSTOR_1 );
			}
			public void widgetDefaultSelected( SelectionEvent arg0 ) {
			}
		} );

		btExaustor1Desliga = new Button( groupExaustores, SWT.NONE );
		btExaustor1Desliga.setBounds( new Rectangle( 180, 69, 80, 35 ) );
		btExaustor1Desliga.setBackground( new Color( Display.getCurrent(), 220, 0, 0 ) );
		btExaustor1Desliga.setText( "Desligar" );
		btExaustor1Desliga.setEnabled( false );
		btExaustor1Desliga.addSelectionListener( new SelectionListener() {
			public void widgetSelected( SelectionEvent arg0 ) {
				desligaExaustor( Constants.EXAUSTOR_1 );
			}
			public void widgetDefaultSelected( SelectionEvent arg0 ) {
			}
		} );

		btExaustor2Liga = new Button( groupExaustores, SWT.NONE );
		btExaustor2Liga.setBounds( new Rectangle( 180, 117, 80, 35 ) );
		btExaustor2Liga.setBackground( new Color( Display.getCurrent(), 0, 150, 0 ) );
		btExaustor2Liga.setText( "Ligar" );
		btExaustor2Liga.addSelectionListener( new SelectionListener() {
			public void widgetSelected( SelectionEvent arg0 ) {
				ligaExaustor( Constants.EXAUSTOR_2 );
			}
			public void widgetDefaultSelected( SelectionEvent arg0 ) {
			}
		} );

		btExaustor2Desliga = new Button( groupExaustores, SWT.NONE );
		btExaustor2Desliga.setBounds( new Rectangle( 180, 154, 80, 35 ) );
		btExaustor2Desliga.setBackground( new Color( Display.getCurrent(), 220, 0, 0 ) );
		btExaustor2Desliga.setText( "Desligar" );
		btExaustor2Desliga.setEnabled( false );
		btExaustor2Desliga.addSelectionListener( new SelectionListener() {
			public void widgetSelected( SelectionEvent arg0 ) {
				desligaExaustor( Constants.EXAUSTOR_2 );
			}
			public void widgetDefaultSelected( SelectionEvent arg0 ) {
			}
		} );

		btExaustor3Desliga = new Button( groupExaustores, SWT.NONE );
		btExaustor3Desliga.setBounds( new Rectangle( 180, 239, 80, 35 ) );
		btExaustor3Desliga.setBackground( new Color( Display.getCurrent(), 220, 0, 0 ) );
		btExaustor3Desliga.setText( "Desligar" );
		btExaustor3Desliga.setEnabled( false );
		btExaustor3Desliga.addSelectionListener( new SelectionListener() {
			public void widgetSelected( SelectionEvent arg0 ) {
				desligaExaustor( Constants.EXAUSTOR_3 );
			}
			public void widgetDefaultSelected( SelectionEvent arg0 ) {
			}
		} );

		btExaustor3Liga = new Button( groupExaustores, SWT.NONE );
		btExaustor3Liga.setBounds( new Rectangle( 180, 202, 80, 35 ) );
		btExaustor3Liga.setBackground( new Color( Display.getCurrent(), 0, 150, 0 ) );
		btExaustor3Liga.setText( "Ligar" );
		btExaustor3Liga.addSelectionListener( new SelectionListener() {
			public void widgetSelected( SelectionEvent arg0 ) {
				ligaExaustor( Constants.EXAUSTOR_3 );
			}
			public void widgetDefaultSelected( SelectionEvent arg0 ) {
			}
		} );
	}


	/**
	 * Este m�todo finaliza a aplica��o.
	 */
	private void exitProgram() {
		System.exit( 0 );
	}


	/**
	 * Liga determinado exaustor de acordo com a escolha do usu�rio.
	 * @param op Op��o que determina qual exaustor ser� ligado.
	 */
	private void ligaExaustor( int op ) {
		if ( op == Constants.EXAUSTOR_1 ) {
			escreveSerial( "1" );
			labelExaustor1.setBackground( new Color( Display.getCurrent(), 0, 150, 0 ) );
			labelExaustor1.setText( "Ligado" );
			btExaustor1Liga.setEnabled( false );
			btExaustor1Desliga.setEnabled( true );
		} else if ( op == Constants.EXAUSTOR_2 ) {
			escreveSerial( "2" );
			labelExaustor2.setBackground( new Color( Display.getCurrent(), 0, 150, 0 ) );
			labelExaustor2.setText( "Ligado" );
			btExaustor2Liga.setEnabled( false );
			btExaustor2Desliga.setEnabled( true );
		} else if ( op == Constants.EXAUSTOR_3 ) {
			escreveSerial( "3" );
			labelExaustor3.setBackground( new Color( Display.getCurrent(), 0, 150, 0 ) );
			labelExaustor3.setText( "Ligado" );
			btExaustor3Liga.setEnabled( false );
			btExaustor3Desliga.setEnabled( true );
		}
	}


	/**
	 * Desliga determinado exaustor de acordo com a escolha do usu�rio.
	 * @param op Op��o que determina qual exaustor ser� desligado.
	 */
	private void desligaExaustor( int op ) {
		if ( op == Constants.EXAUSTOR_1 ) {
			escreveSerial( "1" );
			labelExaustor1.setBackground( new Color( Display.getCurrent(), 220, 0, 0 ) );
			labelExaustor1.setText( "Desligado" );
			btExaustor1Liga.setEnabled( true );
			btExaustor1Desliga.setEnabled( false );
		} else if ( op == Constants.EXAUSTOR_2 ) {
			escreveSerial( "2" );
			labelExaustor2.setBackground( new Color( Display.getCurrent(), 220, 0, 0 ) );
			labelExaustor2.setText( "Desligado" );
			btExaustor2Liga.setEnabled( true );
			btExaustor2Desliga.setEnabled( false );
		} else if ( op == Constants.EXAUSTOR_3 ) {
			escreveSerial( "3" );
			labelExaustor3.setBackground( new Color( Display.getCurrent(), 220, 0, 0 ) );
			labelExaustor3.setText( "Desligado" );
			btExaustor3Liga.setEnabled( true );
			btExaustor3Desliga.setEnabled( false );
		}
	}


	/**
	 * Este m�todo envia uma string para a porta serial.
	 */
	private void escreveSerial( String str ) {
		try {
			porta.envia( str );
		} catch ( Exception e ) {

		}


	}


	/**
	 * Este m�todo l� uma string da porta serial.
	 */
	private static String leSerial() {
		try {
			String str = porta.recebe();
			return str;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return "-1";
	}


	/**
	 * M�todo que inicia a aplica��o.
	 */
	public static void main( String[] args ) {
		porta = new PortaSerial();
		porta.abre( "COM4", 1000 );

		Display display = Display.getDefault();
		final Shell sShell = new MainGUI().createSShell();
		sShell.open();
		SwtUtils.centralize( sShell );

		new Thread( new Runnable() {
			public void run() {
				
//				int count = 0;
				while ( true ) {
					
					if ( !sShell.isDisposed() && !sShell.getDisplay().isDisposed() ) {
						sShell.getDisplay().asyncExec( new Runnable() {

							public void run() {
								String str = leSerial();
								String[] v = str.split( ";" );

								if (v.length == 8) {
									labelSensorTemp1.setText( String.format( "%s �C", v[ 0 ] ) );
									labelSensorTemp2.setText( String.format( "%s �C", v[ 1 ] ) );
									labelSensorTemp3.setText( String.format( "%s �C", v[ 2 ] ) );
									labelSensorTemp4.setText( String.format( "%s �C", v[ 3 ] ) );
									labelSensorUmidade1.setText( String.format( "%s %s", v[4], "%" ) );
									labelSensorUmidade2.setText( String.format( "%s %s", v[5], "%" ) );
									labelSensorUmidade3.setText( String.format( "%s %s", v[6], "%" ) );
									labelSensorUmidade4.setText( String.format( "%s %s", v[7], "%" ) );
								}
							}

						} );
						delay( 1000 );
					} else {
						break;
					}
				}
			}
		} ).start(); // inicializa a thread

		while ( !sShell.isDisposed() ) {
			if ( !display.readAndDispatch() )
				display.sleep();
		}
		display.dispose();

		try {
			porta.finalize();
		} catch ( Throwable e ) {
			e.printStackTrace();
		}
	}

	
	
	private static void delay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
}


// Thread t = new Thread() {
// public void run() {
// while ( true ) {
// try {
// int i = 0;
// labelSensorTemp1.setText( i+"" );
// Thread.sleep( 1000 );
// i++;
// } catch ( InterruptedException e ) {
// throw new RuntimeException( e );
// }
// }
// };
// };
// t.start();