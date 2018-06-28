package com.br.lhmanager.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DataCalendar {

	public static void calendarioData( Shell shell, final Text txt ) {

		final Shell dialog = new Shell( shell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL );
		dialog.setLayout( new GridLayout( 3, false ) );

		final DateTime calendar = new DateTime( dialog, SWT.CALENDAR | SWT.BORDER );
		calendar.addMouseListener( new org.eclipse.swt.events.MouseAdapter() {

			public void mouseDoubleClick( org.eclipse.swt.events.MouseEvent e ) {
				selecionaData( calendar, txt, dialog );
			}
		} );

		new Label( dialog, SWT.NONE );
		new Label( dialog, SWT.NONE );
		Button ok = new Button( dialog, SWT.PUSH );
		ok.setText( "OK" );
		ok.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, false, false ) );
		ok.addSelectionListener( new SelectionAdapter() {

			public void widgetSelected( SelectionEvent e ) {
				selecionaData( calendar, txt, dialog );
			}
		} );
		dialog.setDefaultButton( ok );
		dialog.pack();
		dialog.open();
	}

	public static void selecionaData( DateTime calendar, final Text txt, Shell dialog ) {
		try {
			SimpleDateFormat df = new SimpleDateFormat( "dd/MM/yyyy" );
			Date data = df.parse( calendar.getDay() + "/" + ( calendar.getMonth() + 1 ) + "/" + calendar.getYear() );
			txt.setText( df.format( data ) );
		} catch ( ParseException e1 ) {
			MessageBox alert = new MessageBox( dialog.getShell(), SWT.ICON_ERROR );
			alert.setText( "Calendário" );
			alert.setMessage( "Erro ao formatar data!!!" );
			alert.open();
		}
		dialog.close();
	}

	public static String retornaData() {
		String dataDoSistema = "";
		DateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy " );
		Date data = new Date();
		dataDoSistema = dateFormat.format( data );
		return dataDoSistema;
	}

	public static void calculoIdade( Text cDataNasc, Text cIdade ) {
		String variavelCalendario = "";
		String variavelSistema = "";

		String anoCalendario = "";
		String anoSistema = "";
		int total = 0, anoSi = 0, anoCa = 0, diaSi = 0, diaCa = 0, mesSi = 0, mesCa = 0, dia = 0, mes = 0;

		variavelSistema = retornaData();
		variavelCalendario = cDataNasc.getText();

		StringTokenizer st = new StringTokenizer( variavelCalendario, "/" );
		StringTokenizer st1 = new StringTokenizer( variavelSistema, "/" + " " );

		int tamanho = st.countTokens();

		for ( int i = 0; i < tamanho; i++ ) {

			anoCalendario = st.nextToken();
			anoSistema = st1.nextToken();

			if ( i == 0 ) {
				diaCa = Integer.parseInt( anoCalendario );
				diaSi = Integer.parseInt( anoSistema );
				dia = diaCa - diaSi;
			}
			if ( i == 1 ) {
				mesCa = Integer.parseInt( anoCalendario );
				mesSi = Integer.parseInt( anoSistema );
				mes = mesCa - mesSi;
			}
			if ( i == 2 ) {
				anoCa = Integer.parseInt( anoCalendario );
				anoSi = Integer.parseInt( anoSistema );
				total = anoSi - anoCa;
			}

		}

		if ( dia < 0 || mes > 0 ) {
			total = total - 1;
			cIdade.setText( "" + total );
			cIdade.setForeground( Display.getCurrent().getSystemColor( SWT.COLOR_BLACK ) );
		} else {
			cIdade.setText( "" + total );
			cIdade.setForeground( Display.getCurrent().getSystemColor( SWT.COLOR_BLACK ) );
		}

		try {
			int erro = Integer.parseInt( cIdade.getText() );
			if ( erro == 0 || erro < 0 ) {
				cIdade.setText( "0" );
				cIdade.setForeground( Display.getCurrent().getSystemColor( SWT.COLOR_RED ) );
			}
		} catch ( NumberFormatException e ) {


		}

	}
}
