import java.util.ArrayList;


public class Teste2 {

	
	// Testando o algorítmo
	public static void main(String[] args) {
		String texto = "ACCGTTGACTCGCACGGTTAC";
		String padrao1 = "ACTC";
		String padrao2 = "GTT";
		
		
		System.out.println(kmp_matcher(texto, padrao1));
		
		
	}
	
	
	public static int kmp_matcher(String T, String P) {
		
		int n = T.length();
		int m = P.length();
		int[] pi = compute_prefix_function(P);
		int q = 0;
		
		for (int i = 0; i < T.length(); i++) {
			
			while (q > 0 && (P.charAt(q+1) != T.charAt(i)) ) {
				q = pi[q];
			}
			
			if (P.charAt(q+1) == T.charAt(i)) {
				q++;
			}
			
			if (q == m) {
				System.out.println("Padrão ocorre com deslocamento" + (i-m));
				q = pi[q];
			}
			
		}
		
		return 0;
	}
	
	
	public static int[] compute_prefix_function(String padrao) {
		int m = padrao.length();

//		ArrayList<Integer> pi = new ArrayList<Integer>();
//		pi.add(1, 0);
		
		int pi[] = new int[25];
		pi[0] = 0;
		
		int k = 0;
		
		for (int q = 2; q < m; q++) {
			
			while(k > 0 && (padrao.charAt(k+1) != padrao.charAt(q) )) {
				k = pi[k];
			}
			
			if (padrao.charAt(k+1) == padrao.charAt(q)) {
				k++;
			}
			
			pi[q] = k;
			
		}
		
		return pi;
	}
	
	
}
