package com.br.lhmanager.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.br.lhmanager.view.principal.FrmPrincipal;

public class LHManager {

	public static EntityManager em;

	public static void main( String[] args ) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "lhmanager" );
		em = emf.createEntityManager();

		Display display = Display.getDefault();
		FrmPrincipal tela = new FrmPrincipal();
		Shell sShell = tela.createSShell();
		sShell.open();
		while ( !sShell.isDisposed() ) {
			if ( !display.readAndDispatch() )
				display.sleep();

		}
		display.dispose();
		em.close();
	}

}
