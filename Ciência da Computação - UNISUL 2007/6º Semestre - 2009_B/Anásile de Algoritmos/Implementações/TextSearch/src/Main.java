
public class Main {
	
	// Testando o algorítmo
	public static void main(String[] args) {
		String texto = "ACCGTTGACTCGCACGGTTAC";
		String padrao1 = "ACTC";
		String padrao2 = "GTT";
		
		
		System.out.println(KMPmatch(texto, padrao2));
		
		
	}

	public static int KMPmatch(String text, String pattern) {
		int[] fail = computeFailFunction(pattern);
		int i = 0;
		int j = 0;

		while (i < text.length()) {
			if (pattern.charAt(j) == text.charAt(i)) {
				if (j == pattern.length() - 1)
					return i - pattern.length() + 1; // match
					i++;
					j++;
			} 
			else if (j > 0)
				j = fail[j - 1];
			else
				i++;
		} 
		return -1; // no match
	}

	public static int[] computeFailFunction(String pattern) {
		int[] fail = new int[pattern.length()]; 
		fail[0] = 0;
		int j = 0;
		int i = 1;
		while (i < pattern.length()) {
			if (pattern.charAt(j) == pattern.charAt(i)) { // j + 1 characters match
				fail[i] = j + 1;
				i++;
				j++;
			}
			else if (j > 0) // j follows a matching prefix
				j = fail[j - 1];
			else { // no match
				fail[i] = 0;
				i++;
			}
		}
		return fail;
	}


}
