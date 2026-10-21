package serializacionObjetos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AppS36 {
	
	private static String ruta ="C:\\Users\\damdu201\\eclipse-workspace\\AccesoADatos\\src\\serializacionObjetos\\lista_alumnos.dat";

	private static ArrayList<Alumno> listaAlumno = new ArrayList<Alumno>();

	public static void main(String[] args) {
		
		
		listaAlumno.add(new Alumno("12345678A","Ana","Garcia","Lopez","DAM",1,7,8,9,8));
		listaAlumno.add(new Alumno("23456789A","Luis","Perez","Martin","DAM",1,6,7,8,9));
		listaAlumno.add(new Alumno("34567890A","Marta","Rodriguez","Soto","DAM",1,9,8,10,9));


		
//		System.out.printf("Numero de alumnos : %d\n",listaAlumno.size());
//		for (Alumno a : listaAlumno) {
//			System.out.println("Nombre: " + a.getNombre());
//
//		}
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))){
			
			oos.writeObject(listaAlumno);
			System.out.println("Lista de alumnos guardada correctamente");
		}catch(IOException e ){
			

			System.out.println("Error:" + e);
		}


	}

}
