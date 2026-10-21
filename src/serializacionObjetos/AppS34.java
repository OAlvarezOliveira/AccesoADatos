package serializacionObjetos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AppS34 {
	private static String ruta ="C:\\Users\\damdu201\\eclipse-workspace\\AccesoADatos\\src\\serializacionObjetos\\alumnos.dat";

	public static void main(String[] args) {
		
		
		Alumno alumno = new Alumno ("12345678A","Ana","Garcia","Lopez","DAM",1,7,8,9,8);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))){ 
			
			oos.writeObject(alumno);
					 
				}catch(IOException e ){
					
					System.out.println("Error:" + e);
				}

	}

}
