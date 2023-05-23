package ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		int numero;
		int suma = 0;
		int cont = 0;
		double media;

		try {
			Scanner read = new Scanner(new FileReader("src\\ejercicios\\NumerosReales.txt"));
			do {
				numero = read.nextInt();
				suma += numero;
				cont++;
			} while (read.hasNext());
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no se encuentra");
			e.getMessage();
		}

		media = suma / cont;
		System.out.println("Suma números: " + suma + "\n" + "Media: " + media);

	}

}
