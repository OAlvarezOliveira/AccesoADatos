package serializacionObjetos;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;


public class AppS35 {
	private static String ruta ="C:\\Users\\damdu201\\eclipse-workspace\\AccesoADatos\\src\\serializacionObjetos\\alumnos.dat";


	public static void main(String[] args) {
		
		try (FileInputStream fis = new FileInputStream (ruta);
				ObjectInputStream ois = new ObjectInputStream (fis);
				){
			
			Alumno alumno = (Alumno) ois.readObject();
			
			System.out.println("Alumno recuperado correctamente");
			System.out.println("DNI: " + alumno.getDni());
			System.out.println("Nombre: " + alumno.getNombre());
			System.out.println("Primer Apellido: " + alumno.getApellido1());
			System.out.println("Segundo Apellido: " + alumno.getApellido2());
			System.out.println("Ciclo: " + alumno.getCiclo());
			System.out.println("Curso: " + alumno.getCurso());
			System.out.println("Evaluacion1: " + alumno.getEva1());
			System.out.println("Evaluacion2: " + alumno.getEva2());
			System.out.println("Evaluacion3: " + alumno.getEva3());
			System.out.println("NotaFinal " + alumno.getNotaFinal());

			
		}catch(IOException e){
					
			System.out.println("ERROR:"+ e);
		}
	
		catch(ClassNotFoundException e){
					
			System.out.println("ERROR:"+ e);
				}

	
	}
}
