package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// Guardará las palabras introducidas por el usuario
		String palabras = "";
		// Scanner para leer por teclado
		Scanner read = new Scanner(System.in);
		// Creamos un Buferred writer para escribir en el fichero
		BufferedWriter escribir = null;
		try {
			// Indicamos la ruta del fichero en el que escribir
			escribir = new BufferedWriter(new FileWriter("src\\ejercicio4\\escritura.txt"));
			while (!palabras.equals("fin")) {
				// Mientras las palabras introducidas sean distinta a "fin", las introducirá en
				// el fichero en diferentes lineas
				System.out.println("Introduce palabras: ");
				palabras = read.nextLine();
				if (!palabras.equals("fin")) {
					escribir.write(palabras);
					escribir.newLine();
				}
			}
			// Publicamos los cambios
			escribir.flush();

			// Si se da la excepcion, mostramos un mensaje de error
		} catch (IOException e) {
			System.out.println("No existe el fichero");
			e.getMessage();

			// Finalmente cerramos el fichero y el Scanner
		} finally {
			if (escribir != null) {
				try {
					escribir.close();
					read.close();

					// Si se da alguna excepcion, mostramos el mensaje de error
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}

}
