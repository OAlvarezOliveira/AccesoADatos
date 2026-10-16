package listaAlumnos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main2 {

	public static void main(String[] args) throws IOException {

		Path ruta = Path.of("alumnos.txt");

		if (Files.exists(ruta)) {
			System.out.println("El fichero existe");
		} else {
			System.out.println("El fichero no existe");
		}

	}

}
