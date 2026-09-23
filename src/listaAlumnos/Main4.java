package listaAlumnos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main4 {
	
	public static void main(String[] args)  {

		
		Path ruta = Path.of("notas.txt\"");
		
		

		String contenido;
		try {
			contenido = Files.readString(ruta);
			System.out.println(contenido);
		} catch (IOException e) {
			
			System.out.println("No se ha podido leer el fichero");
		}
		


		}

}
