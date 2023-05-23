package ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		int numeros;
		int suma=0;
		double media;
		int cont=0;
		try {
			Scanner read = new Scanner(new FileReader("src\\ejercicio2\\Enteros.txt"));
			while(read.hasNext()) {
				numeros=read.nextInt();
				suma+=numeros;
				cont++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
			e.getMessage();
		}
		
		media=(double)suma/cont;
		System.out.println("Suma de números: " + suma + "\n" + "Media: " + media);

	}

}
