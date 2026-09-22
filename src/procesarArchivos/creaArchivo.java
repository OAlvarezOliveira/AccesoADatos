package procesarArchivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class creaArchivo {
		
	public static void main(String[] args) throws IOException {
		Files.writeString(Path.of("mensaje.txt"), "Mi mensaje");
	}

}
