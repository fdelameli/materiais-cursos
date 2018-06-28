
public class Data implements Comparable{

	private int ano;
	private int mes;
	private int dia;
	
	public Data() {
		this(2007,1,1);
	}
	public Data(int dia, int mes, int ano) {
		this.ano = ano;
		this.mes = (mes < 1 || mes > 12) ? 1 : mes;
		this.dia = (dia < 1 || dia > 31) ? 1 : dia;
	}

	public int compareTo(Comparable obj) {
		Data data = (Data) obj;
		if(data.ano < this.ano)
			return 1;
		else if(data.ano > this.ano)
			return -1;
		else if(data.mes < this.mes)
			return 1;
		else if(data.mes > this.mes)
			return -1;
		else if(data.dia < this.dia)
			return 1;
		else if(data.dia > this.dia)
			return -1;
		
		return 0;
	}
	
	public String toString(){
		return dia+" "+mes+" "+ano;
	}

}
