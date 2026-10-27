package serializacionObjetos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AppS37 {
	
	private static String ruta ="src/serializacionObjetos/lista_alumnos.dat";

	private static ArrayList<Alumno> listaAlumno = new ArrayList<Alumno>();
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		boolean encontrado = false;
		Scanner sc = new Scanner (System.in);
		
		try(ObjectInputStream entrada = new ObjectInputStream (new FileInputStream(ruta))){
			

			listaAlumno = (ArrayList<Alumno>) entrada.readObject();
			
			System.out.println("Lista de alumnos recuperada correctamente");
			
			for (Alumno a : listaAlumno) {
				
				System.out.println(a);

			}
			
			System.out.println("Introduce el DNI a buscar:");
			String dniBuscado = sc.nextLine();
			
			for (Alumno a : listaAlumno) {
				
				if(a.getDni().equalsIgnoreCase(dniBuscado)) { 
					
					System.out.println("Alumno encontrado:");
					System.out.println("DNI:"+a.getDni());
					System.out.println("Nombre:"+a.getNombre());
					System.out.println("Nota final:"+a.getNotaFinal());
					encontrado = true;
					break;
				}

			}
			
			if(!encontrado) {
				System.out.println("No existe ningún alumno con ese DNI");

				
			}
			
		}catch(IOException | ClassNotFoundException e ){
			
			System.out.println("Error:" + e);
		}

		sc.close();
	}

}
