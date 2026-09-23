package listaAlumnos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class Main2 {
		
	public static void main(String[] args) throws IOException {
		List<String> lineas;
		String estado;
		Path ruta = Path.of("alumnos.txt");
		
		if (Files.exists(ruta)) {
			System.out.println("El fichero existe");
			} else {
			System.out.println("El fichero no existe");
			}
	
	   }		
		
}
	
	
	
