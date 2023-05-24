package ejercicio6;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		// Creamos la coleccion que guardará los numeros enteros ordenados
		// ascendentemente
		ArrayList<Integer> coleccion = new ArrayList<Integer>();

		// Creamos el Buffered Writer para escribir en el fichero
		BufferedWriter bw = null;

		// Creamos el scanner para leer datos del fichero
		Scanner read = null;
		try {

			// Declaramos la ruta del fichero a leer
			read = new Scanner(new FileReader("src\\ejercicio6\\EnterosDesor.txt"));
			// Mientras haya datos en el fichero
			while (read.hasNext()) {
				// Se leerán y se irán añadiendo a la coleccion
				coleccion.add(read.nextInt());

			}

			// Ordenamos los datos de la coleccion de formas ascendente
			Collections.sort(coleccion);

			// Declaramos la ruta del fichero a modificar
			bw = new BufferedWriter(new FileWriter("src\\ejercicio6\\EnterosOrden.txt"));

			// Recorremos la coleccion y guardamos sus valores en una variable
			for (Integer valores : coleccion) {
				// Y escribimos esos valores de la coleccion en el fichero como tipo cadena
				bw.write(String.valueOf(valores));
				// Hacemos un salto de linea
				bw.newLine();
			}

			// Publicamos los cambios
			bw.flush();

			// Si no se encuentra el fichero mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.getMessage();

			// Si no se puede abrir el fichero mostramos un mensaje de error
		} catch (IOException e) {
			System.out.println("El fichero no se puede abrir");
			System.out.println(e.getMessage());

			// Finalmente cerramos el fichero de escritura y el de lectura
		} finally {
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
