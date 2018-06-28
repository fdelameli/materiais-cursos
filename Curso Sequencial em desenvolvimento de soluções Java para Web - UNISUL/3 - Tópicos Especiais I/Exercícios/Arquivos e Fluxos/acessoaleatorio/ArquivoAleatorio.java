package acessoaleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArquivoAleatorio {

	public static void main(String[] args) {
		File file = new File("arquivo.dat");
		System.out.println("Tamanho Inicial: " + file.length());
		try {
			RandomAccessFile random = new RandomAccessFile(file, "rw");
			random.writeDouble(39.3);
			random.writeBoolean(true);
			random.writeInt(10000);
			random.seek(0);
			double d = random.readDouble();
			System.out.println(d);
			System.out.println("Posição " + random.getFilePointer());
			random.seek(9);
			int i = random.readInt();
			System.out.println(i);
			random.seek(50);
			random.writeInt(10);
			random.seek(100);
			int x = random.readInt();
			random.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		System.out.println("Tamanho Final: " + file.length());
	}
}
