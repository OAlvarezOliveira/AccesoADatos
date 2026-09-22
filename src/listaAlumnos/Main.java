package listaAlumnos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList; 

public class Main {
		
	public static void main(String[] args) {
		String rutaAprobados = "src/listaAlumnos/alumnosAprobados.txt";
		String rutaSuspensos = "src/listaAlumnos/alumnosSuspensos.txt";
		int  aprobados = 0;
		int  suspensos = 0;
		
		Alumno alumno1 = new Alumno("sofia", 10);
		Alumno alumno2 = new Alumno("lucas", 10);
		Alumno alumno3 = new Alumno("Mateo", 5);
		Alumno alumno4 = new Alumno("Iago", 3);

		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		listaAlumnos.add(alumno1);
		listaAlumnos.add(alumno2);
		listaAlumnos.add(alumno3);
		listaAlumnos.add(alumno4);

		String mensajeAprobados = "";
		String mensajeSuspensos = "";

		for (Alumno alumno : listaAlumnos) {
			if (alumno.getNota() < 5) {
				alumno.setEstado(Estado.SUSPENSO);
				aprobados++;
				mensajeSuspensos += alumno.getNombre() + " - " + alumno.getNota() + "\n";
			} else {
				alumno.setEstado(Estado.APROBADO);
				suspensos++;
				mensajeAprobados += alumno.getNombre() + " - " + alumno.getNota() 	+ alumno.getEstado() + "\n";
			}
		}
		

		try {
			Files.writeString(Path.of(rutaSuspensos), mensajeSuspensos);
			System.out.println("¡Archivo de alumnos suspensos guardado correctamente!");
	
			Files.writeString(Path.of(rutaAprobados), mensajeAprobados);
			System.out.println("¡Archivo de alumnos aprobados guardado correctamente!");
			
			System.out.println("¡SUSPENSOS!");
			System.out.printf("Han suspendido d% /n",suspensos);
			System.out.println(Files.readString(Path.of(rutaSuspensos)));
			
			System.out.println("¡APROBADOS !");
			System.out.printf("Han aprobado d% /n",aprobados);
			System.out.println(Files.readString(Path.of(rutaAprobados)));
			
		} catch (IOException e) {
			System.err.println("Error al escribir los archivos: " + e.getMessage());
		}
	}
}
