package ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// Guardará cada uno de los números del fichero
		int numeros;
		// Guardará el resultado de sumar todos los numeros
		int suma = 0;
		// Media de la suma de todos los numeros
		double media;
		// Contadpr de numeros
		int cont = 0;
		try {

			// Creamos el Scanner para leer el fichero
			Scanner read = new Scanner(new FileReader("src\\ejercicio2\\Enteros.txt"));

			// Mientras existan datos en el fichero
			while (read.hasNext()) {
				// Leemos los numeros del fichero
				numeros = read.nextInt();
				// Vamos sumando los numeros
				suma += numeros;
				// Incrementamos el contador
				cont++;
			}

			// Si se da la excepcion, mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
			e.getMessage();
		}

		// Calculamos la media
		media = (double) suma / cont;
		// Mostramos la suma y la media
		System.out.println("Suma de números: " + suma + "\n" + "Media: " + media);

	}

}
