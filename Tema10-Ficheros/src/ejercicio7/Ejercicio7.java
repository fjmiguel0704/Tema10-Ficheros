package ejercicio7;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio7 {

	public static void main(String[] args) {

		int opcion = 0;
		String nombre = null;
		long tlf = 0;
		Scanner read = null;

		BufferedWriter bw = null;

		TreeMap<String, Long> agenda = new TreeMap<String, Long>();
		try {
			read = new Scanner(new FileReader("src\\ejercicio7\\Agenda.txt"));
			while (read.hasNextLine()) {
				String[] contacts;
				contacts = read.nextLine().split(" ");
				agenda.put(contacts[0], Long.valueOf(contacts[1]));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			bw = new BufferedWriter(new FileWriter("src\\ejercicio7\\Agenda.txt", true));
			read = new Scanner(System.in);

			do {

				System.out.println("Seleccione una de las siguientes opciones: ");
				System.out.println("1. Nuevo contacto ");
				System.out.println("2. Buscar por nombre ");
				System.out.println("3. Mostrar todos ");
				System.out.println("4. Salir");
				opcion = read.nextInt();
				read.nextLine();

				switch (opcion) {
				case 1:

					if (agenda.size() < 20) {
						System.out.println("Introduzca el nombre del contacto: ");
						nombre = read.next();
						read.nextLine();
						System.out.println("Introduzca el número de teléfono:");
						tlf = read.nextLong();

						while (nombre.isEmpty() || tlf < 0) {
							System.out.println("Por favor, introduzca de nuevo los datos correctamente");
							System.out.println("Introduzca el nombre del contacto");
							nombre = read.next();
							read.nextLine();
							System.out.println("Introduzca el número de teléfono:");
							tlf = read.nextLong();
						}

						if (!agenda.containsValue(tlf)) {
							agenda.put(nombre, Long.valueOf(tlf));
							System.out.println("Contacto añadido correctamente");
							System.out.println();
						} else {
							System.err.println("El contacto ya se encuentra registrado");
							System.out.println();
						}
					} else {
						System.err.println("La agenda está llena");
						System.out.println();
					}
					break;
				case 2:
					System.out.println("Introduzca el nombre del contacto que desea buscar: ");
					nombre = read.next();
					read.nextLine();

					if (agenda.containsKey(nombre)) {
						System.out.print("El teléfono del contacto " + nombre + " es: ");
						System.out.println(agenda.get(nombre));
						System.out.println();
					} else {
						System.err.println("El contacto no se encuentra");
						System.out.println();
					}

					break;
				case 3:
					System.out.println("LISTA DE CONTACTOS");
					for (Entry<String, Long> values : agenda.entrySet()) {
						System.out.println("- Nombre: " + values.getKey());
						System.out.println("  Número de teléfono: " + values.getValue());
					}
					break;
				case 4:
					for (Entry<String, Long> values : agenda.entrySet()) {
						bw.write(values.getKey() + " " + values.getValue());
						bw.newLine();
					}

					System.out.println("Saliendo del programa...");

					break;
				default:
					System.err.println("ERROR, introduzca una opción válida");
				}

			} while (opcion != 4);

			bw.flush();

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			try {

				bw.close();
				read.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

	}
}