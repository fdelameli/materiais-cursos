public class TestDiv {

	public static void main( String[] args ) {

		// int i = 500;

		for ( int i = 0; i <= 500; i++ ) {
			System.out.printf ( "\t%d\t%d\t%d\n", i / 100,
												(i / 10 < 10) ? (i / 10) : (i / 10 - 10 * ( i / 100 ) ),
												i % 10 );
		}


	}

}
