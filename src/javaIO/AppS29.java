package javaIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class AppS29 {
	final static File fichero = new File("texto_s29.txt");

	public static void main(String[] args) {

		try {
			FileWriter escritor = new FileWriter(fichero);

			escritor.write("Primera línea del archivo.\n");
			escritor.write("Texto con tildes: á é í ó ú.\n");
			escritor.write("Otros caracteres: ñ ü €.");

			escritor.close();
			System.out.println("Texto escrito correctamente");

		} catch (Exception e) {

			System.out.println("Error al escribir en un  archivo");
		}

		try {
			FileReader lector = new FileReader("texto_s29.txt");
			int caracter;
			int contadorVocales = 0;
			int contadorCaracteres = 0;

			while ((caracter = lector.read()) != -1) {
				System.out.print((char) caracter);
				contadorCaracteres++;

				if ("aeiouáéíóúüAEIOUÁÉÍÓÚÜ".indexOf((char) caracter) >= 0) {
					contadorVocales++;
				}

			}
			System.out.printf("\nNúmero de caracteres: %d. \n", contadorCaracteres);
			System.out.printf("Tamaño del fichero: %d bytes \n", fichero.length());
			System.out.printf("Número de vocales: %d. \n", contadorVocales);
			lector.close();

		} catch (Exception e) {
			System.out.println("Error al leer en un  archivo");

		}

	}

}
