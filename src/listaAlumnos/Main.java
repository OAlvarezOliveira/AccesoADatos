package listaAlumnos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class Main {
		
	public static void main(String[] args) throws IOException {
		String rutaAprobados = "src/listaAlumnos/alumnosAprobados.txt";
		String rutaSuspensos = "src/listaAlumnos/alumnosSuspensos.txt";
		List<String> lineas;

		String estado;
		int  aprobados = 0;
		int  suspensos = 0;
		Path ruta = Path.of("alumnos.txt");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nombre del alumno: ");
		String nombre = sc.nextLine();
		
		System.out.print("Nota: ");
		double nota = sc.nextDouble();
		sc.nextLine();
		
		if(nota < 5) {estado = "Suspenso";}else {estado = "Aprobado";}
		
		String linea = nombre + ";" + nota  + estado + "\n";
		System.out.println("Elige una opción:"); 
		System.out.println("1 Añadir Linea(crea archivo y añade linea )");
		System.out.println("2- Crea el archivo y añade linea");
		System.out.println("2- Si el archivo no existe lo crea , si no existe lo crea y añade linea");
		int opcion = sc.nextInt();

		switch (opcion) {
		
		
		
		case 1: Files.writeString(ruta, linea,
				StandardOpenOption.CREATE,
				StandardOpenOption.APPEND);
		System.out.printf("Linea añadida %s",linea);
		break;
		case 2: Files.writeString(ruta, linea,StandardOpenOption.CREATE);
		System.out.printf("Se ha creado el archivo %s",linea);
		break;
		case 3:
		Files.writeString(ruta, linea,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
		break; 
		default:
			System.out.println("Opción no válida");
		}

		sc.close();

	   lineas = Files.readAllLines(ruta);
	   
	   for (String elemento : lineas) {
		   if (elemento.contains("SUSPENSO")) {
		   System.out.println(elemento);
		   suspensos++;
		   }

	
	   }		
		
//		Alumno alumno1 = new Alumno("sofia", 10);
//		Alumno alumno2 = new Alumno("lucas", 10);
//		Alumno alumno3 = new Alumno("Mateo", 5);
//		Alumno alumno4 = new Alumno("Iago", 3);
//
//		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
//		listaAlumnos.add(alumno1);
//		listaAlumnos.add(alumno2);
//		listaAlumnos.add(alumno3);
//		listaAlumnos.add(alumno4);
//
//		String mensajeAprobados = "";
//		String mensajeSuspensos = "";
//
//		for (Alumno alumno : listaAlumnos) {
//			if (alumno.getNota() < 5) {
//				alumno.setEstado(Estado.SUSPENSO);
//				aprobados++;
//				mensajeSuspensos += alumno.getNombre() + " - " + alumno.getNota() + "\n";
//			} else {
//				alumno.setEstado(Estado.APROBADO);
//				suspensos++;
//				mensajeAprobados += alumno.getNombre() + " - " + alumno.getNota() 	+ alumno.getEstado() + "\n";
//			}
//		}
//		
//
//		try {
//			Files.writeString(Path.of(rutaSuspensos), mensajeSuspensos);
//			System.out.println("¡Archivo de alumnos suspensos guardado correctamente!");
//	
//			Files.writeString(Path.of(rutaAprobados), mensajeAprobados);
//			System.out.println("¡Archivo de alumnos aprobados guardado correctamente!");
//			
//			System.out.println("¡SUSPENSOS!");
//			System.out.printf("Han suspendido d% /n",suspensos);
//			System.out.println(Files.readString(Path.of(rutaSuspensos)));
//			
//			System.out.println("¡APROBADOS !");
//			System.out.printf("Han aprobado d% /n",aprobados);
//			System.out.println(Files.readString(Path.of(rutaAprobados)));
//			
//		} catch (IOException e) {
//			System.err.println("Error al escribir los archivos: " + e.getMessage());
//		}

	}
	
	
	
	
}

