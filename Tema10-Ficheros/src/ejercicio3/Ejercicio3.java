package ejercicio3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		String nombre = "";
		int edad;
		int sumaEdades = 0;
		double estatura = 0;
		double sumaEstaturas = 0;
		double mediaEdades = 0;
		double mediaEstaturas = 0;
		int cont = 0;

		try {
			Scanner read = new Scanner(new FileReader("src\\ejercicio3\\Alumnos.txt"));
			while (read.hasNext()) {
				String alumnos[] = read.nextLine().split(" ");
				nombre += alumnos[0] + "\n";
				edad = Integer.parseInt(alumnos[1]);
				sumaEdades += edad;
				estatura = Double.parseDouble(alumnos[2]);
				sumaEstaturas += estatura;
				cont++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
			e.getMessage();
		}

		mediaEdades = (double) sumaEdades / cont;
		mediaEstaturas = sumaEstaturas / cont;
		System.out.println("Nombres: " + "\n" + nombre + "\n" + "Media edades: " + mediaEdades + "\n"
				+ "Media estaturas: " + mediaEstaturas);
	}
}
