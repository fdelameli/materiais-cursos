//
// Realiza análise para verificar se dois grafos são isommorfos
//
public class IsomorphAnalysis {

	private int aAdjGraph1[][];
	private int aAdjGraph2[][];
	private int aVertexRelationshipMap[];
	private boolean bIsIsormorph;
	private boolean bIsAnalysisComplete;

	public IsomorphAnalysis( int aAdjGraph1[][], int aAdjGraph2[][] ) {	

	this.aAdjGraph1 = aAdjGraph1;
		this.aAdjGraph2 = aAdjGraph2;
		this.aVertexRelationshipMap = new int[ aAdjGraph1.length ];
		this.bIsIsormorph = false;
		this.bIsAnalysisComplete = false;

		// Relecionamento padrão de vertices para grafos isomorfos....
		for ( int i = 0; i < aAdjGraph1.length; i++ )
			this.aVertexRelationshipMap[i] = i;

	}

	public boolean getResult() {

		// Não realizou analise?
		if ( !this.bIsAnalysisComplete ) {

			// Matrizes de ajacência não são quadradas?
			if (( this.aAdjGraph1.length != this.aAdjGraph1[0].length ) || ( this.aAdjGraph2.length != this.aAdjGraph2[0].length ))
				this.bIsIsormorph = false;

			// Grafos possui número diferente de vertices?
			else if ( this.aAdjGraph1.length != this.aAdjGraph2.length )
				this.bIsIsormorph = false;

			// Grafos são identicos?
			else if ( this.CompareMatrix( this.aAdjGraph1, this.aAdjGraph2 ))
				this.bIsIsormorph = true;

			// Reliza analise através de permutações...
			else
				this.bIsIsormorph = this.PermutationAnalysis();

			this.bIsAnalysisComplete = true;

		}

		return this.bIsIsormorph;

	}

	//
	// getVertexRelationshipMap - Obtém vetor com a relação de vertices ( v1 --> f(x)); 
	public int[] getVertexRelationshipMap() {

		// Ainda não realizou análise?
		if ( !this.bIsAnalysisComplete )
			this.getResult();

		return this.aVertexRelationshipMap;

	}

	//
	// PermutationAnalysis - Realiza permutações na aAdjGraph2 para tentar obter relação entre vertices.
	private boolean PermutationAnalysis() {

		// Obtém Gerador de permutações
		PermutationGenerator aPermut = new PermutationGenerator( this.aAdjGraph2.length );

		// Enquanto houver permutações...
		while ( aPermut.hasMore()) {

			// Obtém proxima permutação
			int aIndexes[] = aPermut.getNext();

			// Obtém uma cópia temporaria da matrix que será modificada
			int aTempAnalisysMatrix[][] = this.cloneMatrix( this.aAdjGraph2 );

			// Troca as linhas reais pelas linhas da  permutação atual.
			this.ChangeMatrixRows( aTempAnalisysMatrix, aIndexes );

			// Troca as Colunas reais pelas colunas da permutação atual.
			this.ChangeMatrixCols( aTempAnalisysMatrix, aIndexes );

			// Compara as matrizes
			if ( this.CompareMatrix( this.aAdjGraph1, aTempAnalisysMatrix )) {

				this.aVertexRelationshipMap = aIndexes;
				return true;

			}
		}

		return false;

	}

	// 
	// ChangeMatrixRows - Troca linhas de uma matrix
	private void ChangeMatrixRows( int aMatrix[][], int aIndexes[] ) {

		int aSourceMatrix[][] = this.cloneMatrix( aMatrix);
		for ( int x = 0; x < aMatrix.length; x++ )
			for ( int y = 0; y < aMatrix.length; y++ )
				aMatrix[x][y] = aSourceMatrix[aIndexes[x]][y];


	}

	// 
	// ChangeMatrixCols - Troca colunas de uma matrix
	private void ChangeMatrixCols( int aMatrix[][], int aIndexes[] ) {

		int aSourceMatrix[][] = this.cloneMatrix( aMatrix);
		for ( int y = 0; y < aMatrix.length; y++ )
			for ( int x = 0; x < aMatrix.length; x++ )
				aMatrix[x][y] = aSourceMatrix[x][aIndexes[y]];

	}

	// 
	// CompareMatrix - compara duas matrizes
	private boolean CompareMatrix( int aMatrix1[][], int aMatrix2[][] ) {

		for ( int x = 0; x < aMatrix1.length; x++ ) {
			for ( int y = 0; y < aMatrix2.length; y++ ) {

				if ( aMatrix1[x][y] != aMatrix2[x][y] )
					return false;

			}
		}

		return true;

	}

	//
	// cloneMatrix - Cria nova instância identica a uma matrix fonte.
	private int[][] cloneMatrix( int aMatrix[][] ) {
		
		int aReturn[][] = new int[ aMatrix.length ][ aMatrix.length ];
		for ( int x = 0; x < aMatrix.length; x++ )
			for ( int y = 0; y < aMatrix.length; y++ )
				aReturn[x][y] = aMatrix[x][y];

		return aReturn;

	}
}

