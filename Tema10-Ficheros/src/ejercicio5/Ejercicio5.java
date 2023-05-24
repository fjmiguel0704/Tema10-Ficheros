package ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// Guardará los nombres introducidos por el usuario
		String nombre;
		// Guardará las edades introducidas por el usuario
		int edad;

		// Scanner para leer por teclado
		Scanner read = new Scanner(System.in);

		// Creamos el Buffered Writer para poder escribir en el fichero
		BufferedWriter bw = null;

		try {
			// Declaramos la ruta en la que se encuentra el fichero a modificar
			bw = new BufferedWriter(new FileWriter("src\\ejercicio5\\datos.txt", true));
			// Pedimos el nombre y lo recogemos
			System.out.println("Nombre: ");
			nombre = read.next();
			read.nextLine();
			// Pedimos la edad y la recogemos
			System.out.println("Edad: ");
			edad = read.nextInt();
			read.nextLine();
			// Los ecribimos en el fichero
			bw.write("Nombre: " + nombre + ", Edad: " + edad);
			// Salto de linea
			bw.newLine();
			// Publicamos los cambios
			bw.flush();

			// Si se da la excepcion, mostramos un mensaje de error
		} catch (IOException e) {
			System.out.println("No se puede abrir el archivo");
			e.getMessage();

			// Finalmente cerramos el fichero y el Scanner
		} finally {
			if (bw != null) {
				try {
					bw.close();
					read.close();

					// Y si se da la excepcion, mostramos el mensaje de error
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}

		}

	}

}
