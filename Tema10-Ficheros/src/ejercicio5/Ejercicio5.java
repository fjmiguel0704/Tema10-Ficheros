package ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		String nombre;
		int edad;

		Scanner read = new Scanner(System.in);

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("src\\ejercicio5\\datos.txt", true));
			System.out.println("Nombre: ");
			nombre = read.next();
			read.nextLine();
			System.out.println("Edad: ");
			edad = read.nextInt();
			read.nextLine();
			bw.write("Nombre: " + nombre + ", Edad: " + edad);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.out.println("No se puede abrir el archivo");
			e.getMessage();
		} finally {
			if (bw != null) {
				try {
					bw.close();
					read.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}

		}

	}

}
