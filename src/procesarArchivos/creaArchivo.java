package procesarArchivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class creaArchivo {
		
	public static void main(String[] args) {
		String mensaje = "PROGRAMACION\nBase de datos\nAcceso a datos";
		
		try {
			Files.writeString(Path.of("src/procesarArchivos/mensaje.txt"), mensaje);
			System.out.println("¡Archivo guardado con las tres asignaturas!");
		} catch (IOException e) {
			System.err.println("Error al escribir el archivo: " + e.getMessage());
		}
	}

}
