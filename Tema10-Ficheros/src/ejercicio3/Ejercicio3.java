package ejercicio3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		// Guardará los nombres encontrados en el fichero
		String nombre = "";
		// Guardará las edades encontradas en el fichero
		int edad;
		// Guardará la suma de las edades
		int sumaEdades = 0;
		// Guardará las estaturas encontradas en el fichero
		double estatura = 0;
		// Guardará la suma de las estaturas
		double sumaEstaturas = 0;
		// Guardará la media de las edades
		double mediaEdades = 0;
		// Guardará la media de las estaturas
		double mediaEstaturas = 0;
		// Contador de edades y estaturas
		int cont = 0;

		try {

			// Scanner para leer datos del fichero
			Scanner read = new Scanner(new FileReader("src\\ejercicio3\\Alumnos.txt"));
			// Mientras existan datos en el fichero
			while (read.hasNext()) {
				// CReamos un array, donde en el guardamos las palabras de cada una de las
				// lineas del fichero separadas por espacios
				String alumnos[] = read.nextLine().split(" ");
				// Recoge los nombres de cada una de las lineas
				nombre += alumnos[0] + "\n";
				// Recoge las edades de cada una de las lineas
				edad = Integer.parseInt(alumnos[1]);
				// Suma las edades
				sumaEdades += edad;
				// Recoge las estaturas de cada una de las lineas
				estatura = Double.parseDouble(alumnos[2]);
				// Suma de las estaturas
				sumaEstaturas += estatura;
				// Incrementa el contador
				cont++;
			}

			// Si se da la excepcion, mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
			e.getMessage();
		}

		// Calculamos la de media de las edades
		mediaEdades = (double) sumaEdades / cont;
		// Calculamos la de media de las estaturas
		mediaEstaturas = sumaEstaturas / cont;
		// Mostramos los nombres y las medias de edades y estaturas
		System.out.println("Nombres: " + "\n" + nombre + "\n" + "Media edades: " + mediaEdades + "\n"
				+ "Media estaturas: " + mediaEstaturas);
	}
}
