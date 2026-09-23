package listaAlumnos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class Main3 {
public static void main(String[] args) throws IOException {

	
	Path ruta = Path.of("alumnos.txt");
	
	String linea = "Carlos - 6.5";
	
	
	Files.writeString(ruta, linea,
			StandardOpenOption.CREATE,
			StandardOpenOption.APPEND);

	String contenido = Files.readString(ruta);
	System.out.println(contenido);


	}
}

