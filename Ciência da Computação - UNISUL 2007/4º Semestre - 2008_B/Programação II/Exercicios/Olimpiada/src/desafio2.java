import java.util.StringTokenizer;

import javax.swing.JOptionPane;


public class desafio2 {

	public static void main(String[] args) {
		String entra = JOptionPane.showInputDialog("informe a expressão");
//		System.out.println(calcula(entra));
		entra = entra.replace(" ","");
		
	
		metodo(entra);
		
		
		String characters = "-+";
		for (int j = 0; j < characters.length(); j++) {
			entra = entra.replace(""+characters.charAt(j)," "+ characters.charAt(j)+ " " );
		}
		
		StringTokenizer s = new StringTokenizer(entra);
		String str = "";
		while (s.hasMoreElements()) {
			String object = (String) s.nextElement();
			
			if(object.equals("-")){
				str += "-";
			}else if(object.equals("+")){
				str += "+";
			}if(object.contains("(")){
				str+=object;
				System.out.println(str);
			}else if(object.contains(")")){
				str+=object;
				System.out.println(") "+str);
			}else{
				str += calcula(object);
			}
		}
		System.out.println(str);
		System.err.println(calcula(str));
		
	}
	
	public static int metodo(String entra){
		String characters = "()";
		for (int j = 0; j < characters.length(); j++) {
			entra = entra.replace(""+characters.charAt(j)," "+ characters.charAt(j)+ " " );
		}
		
		StringTokenizer s = new StringTokenizer(entra);
		String str = "";
		while (s.hasMoreElements()) {
			String object = (String) s.nextElement();
			
			if(object.equals("-")){
				str += "-";
			}else if(object.equals("+")){
				str += "+";
			}if(object.contains("(")){
				str+=object;
				System.out.println(str);
			}else if(object.contains(")")){
				str+=object;
				System.out.println(") "+str);
			}else{
				str += calcula(object);
			}
		}
		System.out.println(str);
		return (calcula(str));
	}
	
	public static int calcula(String entra){
		
		
		int cal = 0;
		int calTemp = 0;
		
		char c = 0;
		
		String temp = "";
		String characters = "-+/*()";
		for (int j = 0; j < characters.length(); j++) {
			entra = entra.replace(""+characters.charAt(j)," "+ characters.charAt(j)+ " " );
		}
		
		StringTokenizer s = new StringTokenizer(entra);
		while (s.hasMoreElements()) {
			String str = (String) s.nextElement();
			
			if("(".equalsIgnoreCase(str)){
				temp += " ";
				
			}else if(")".equalsIgnoreCase(str)){
				if(temp.length()>0){
					calTemp = calcula(temp);
					temp = "";
					if(c == '+'){
						cal += calTemp;
						c = 0;
					}else if(c == '-'){
						cal -= calTemp;
						c = 0;
					}else if(c == '*'){
						cal *= calTemp;
						c = 0;
					}else if (c == '/'){
						cal /= calTemp;
						c = 0;
					}else{
						cal = calTemp;
					}
				}
			}else if("+".equalsIgnoreCase(str)){
				if(temp.length()>0){
					temp += "+";
				}else{
					c = '+';
				}
				
			}else if("-".equalsIgnoreCase(str)){
				if(temp.length()>0){
					temp += "-";
				}else{
					c = '-';
				}
				
			}else if("*".equalsIgnoreCase(str)){
				if(temp.length()>0){
					temp += "*";
				}
				else{
					c = '*';
				}
				
			}else if("/".equalsIgnoreCase(str)){
				if(temp.length()>0){
					temp += "/";
				}else{
					c = '/';
				}
				
			}else{
				if(temp.length()>0){
					temp += str;
				}else if(c == '+'){
					cal += Integer.parseInt(str);
					c = 0;
				}else if(c == '-'){
					cal -= Integer.parseInt(str);
					c = 0;
				}else if(c == '*'){
					cal *= Integer.parseInt(str);
					c = 0;
				}else if (c == '/'){
					cal /= Integer.parseInt(str);
					c = 0;
				}else{
					cal = Integer.parseInt(str);
				}
				
			}
		}
		return cal;
	}

}
