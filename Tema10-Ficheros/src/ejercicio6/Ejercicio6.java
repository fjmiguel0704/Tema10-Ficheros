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
		ArrayList<Integer> coleccion = new ArrayList<Integer>();
		try {
			Scanner read = new Scanner(new FileReader("src\\ejercicio6\\EnterosDesor.txt"));
			while (read.hasNext()) {
				coleccion.add(read.nextInt());
				Collections.sort(coleccion);
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio6\\EnterosOrden.txt"));
					bw.write(coleccion);
					bw.flush();
				} catch (IOException e) {
					System.out.println("No existe el fichero");
					e.getMessage();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.getMessage();
		}
	}
}
