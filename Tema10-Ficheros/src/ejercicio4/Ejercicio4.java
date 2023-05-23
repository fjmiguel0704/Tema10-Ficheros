package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		String palabras = "";
		Scanner read = new Scanner(System.in);
		try {
			BufferedWriter escribir = new BufferedWriter(new FileWriter("src\\ejercicio4\\escritura.txt"));
			while (!palabras.equals("fin")) {
				System.out.println("Introduce palabras: ");
				palabras = read.nextLine();
				if (!palabras.equals("fin")) {
					escribir.write(palabras);
					escribir.newLine();
				}
			}
			escribir.flush();
			escribir.close();
		} catch (IOException e) {
			System.out.println("No existe el fichero");
			e.getMessage();
		}

	}

}
