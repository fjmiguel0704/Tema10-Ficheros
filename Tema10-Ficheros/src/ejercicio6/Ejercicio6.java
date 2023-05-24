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
		int numero;
		ArrayList<Integer> coleccion = new ArrayList<Integer>();
		BufferedWriter bw = null;
		Scanner read = null;
		try {
			read = new Scanner(new FileReader("src\\ejercicio6\\EnterosDesor.txt"));
			while (read.hasNext()) {
				coleccion.add(read.nextInt());

			}

			Collections.sort(coleccion);

			bw = new BufferedWriter(new FileWriter("src\\ejercicio6\\EnterosOrden.txt"));

			for (Integer valores : coleccion) {
				bw.write(String.valueOf(valores));
				bw.newLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.getMessage();
		} catch (IOException e) {
			System.out.println("El fichero no se puede abrir");
			System.out.println(e.getMessage());
		} finally {
			try {
				bw.flush();
				bw.close();
				read.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
