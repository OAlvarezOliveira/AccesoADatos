package entrenamientos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class GestorEntrenamientos {

	private static HashMap<String, ArrayList<Integer>> listaEntrenamientos = new HashMap<>();

	void leerFichero(String fichero) throws IOException {
		Scanner sc = new Scanner(new File(fichero));
		int numeroLinea = 0;

		while (sc.hasNextLine()) {
			String linea = sc.nextLine().trim();
			numeroLinea++;

			if (linea.isEmpty()) {
				System.out.println("Error línea Vacía / Línea afectada: " + numeroLinea);
				continue;
			}

			String[] arrayElementos = linea.split(";");

			if (arrayElementos.length != 2) {
				System.out.println("Línea malformada (Falta ';' o datos) / Línea afectada: " + numeroLinea);
				continue;
			}

			try {
				String nombre = arrayElementos[0].trim();
				int marca = Integer.parseInt(arrayElementos[1].trim());

				if (marca < 0) {
					System.out.println("Línea negativa / Línea afectada: " + numeroLinea);
				} else {

					if (listaEntrenamientos.containsKey(nombre)) {
						listaEntrenamientos.get(nombre).add(marca);
					} else {
						ArrayList<Integer> tiempos = new ArrayList<>();
						tiempos.add(marca);
						listaEntrenamientos.put(nombre, tiempos);
					}
				}

			} catch (NumberFormatException e) {
				System.out.println("Tipo de Dato incorrecto / Línea afectada: " + numeroLinea);
			}
		}

		System.out.println("Total líneas leídas: " + numeroLinea);
		sc.close();
	}

	void mostrarMedias() {

		for (Entry<String, ArrayList<Integer>> entry : listaEntrenamientos.entrySet()) {
			double suma = 0;
			String key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();

			for (int marca : val) {
				suma += marca;
			}

			if (val.size() > 0) {
				double media = suma / val.size();
				System.out.println(key + ": " + media);
			} else {
				System.out.println("No hay marcas disponibles para calcular media");
			}
		}
	}

	void deportistaMayorMedia() {

		double mediaMayor = 0;
		ArrayList<String> ganadores = new ArrayList<>();

		for (Entry<String, ArrayList<Integer>> entry : listaEntrenamientos.entrySet()) {
			double suma = 0;
			double media = 0;
			String key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();

			for (int marca : val) {
				suma += marca;
			}

			if (val.size() > 0) {
				media = suma / val.size();
			} else {
				System.out.println("No hay marcas disponibles para calcular media");
			}
			if (media > mediaMayor) {
			    ganadores.clear();
			    ganadores.add(key);
			    mediaMayor = media;
			} else if (media == mediaMayor) {
			    ganadores.add(key);
			}

		}

		System.out.println("Mayor media: " + ganadores + " (" + mediaMayor + ")");
	}

	void mediaGeneral() {

		double sumaTotal = 0;
		int totalMarcas = 0;

		for (Entry<String, ArrayList<Integer>> entry : listaEntrenamientos.entrySet()) {

			ArrayList<Integer> val = entry.getValue();

			for (int marca : val) {
				totalMarcas++;
				sumaTotal += marca;
			}
		}

		if (totalMarcas > 0) {
			System.out.println("Media general: " + sumaTotal / totalMarcas);
		} else {
			System.out.println("No hay marcas disponibles");
		}

	}
}
