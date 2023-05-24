package ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Guardará cada uno de los números del fichero
		int numero;
		// Guardará el resultado de sumar todos los numeros
		int suma = 0;
		// Contadpr de numeros
		int cont = 0;
		// Media de la suma de todos los numeros
		double media;

		try {
			// Creamos el Scanner para leer el fichero
			Scanner read = new Scanner(new FileReader("src\\ejercicio1\\NumerosReales.txt"));
			do {
				// Leemos los numeros del fichero
				numero = read.nextInt();
				// Vamos sumando los numeros
				suma += numero;
				// Incrementamos el contador
				cont++;
			} while (read.hasNext()); // Todo mientraas existan datos a leer

			// Si se da la excepcion, mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no se encuentra");
			e.getMessage();
		}

		// Calculamos la media
		media = suma / cont;
		// Mostramos la suma y la media
		System.out.println("Suma números: " + suma + "\n" + "Media: " + media);

	}

}
