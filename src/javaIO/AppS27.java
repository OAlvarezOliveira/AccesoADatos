package javaIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppS27 {
	
	public static void main(String[] args) {
		
        File fichero = new File("datos.txt");
        
		System.out.println("Nombre:" + fichero.getName());
		System.out.println("¿Existe?:"+fichero.exists());
		
		
		try {
			boolean creado = fichero.createNewFile();
			System.out.println("¿Se ha creado?:"+ creado); //System.out.println("¿Existe?:"+fichero.exists());

			
		} catch (IOException e) {
			System.out.println("Error a crear archivo");
		}
		
		System.out.println("Ruta Absoluta: " + fichero.getAbsolutePath()); //dame absolute path
		System.out.println("Es un archivo? " + fichero.isFile()); //Es un fichero
		System.out.println("Es un directorio? " + fichero.isDirectory()); // Es un directorio
		
		System.out.printf("Tamaño %d bytes \n" ,fichero.length() );
		
		//Escritura en bloque con FileWriter
		
		try {
			FileWriter escritor = new FileWriter (fichero);
			
			escritor.write("Hola, estamos trabajando con ficheros en Java.");
			escritor.close();
			
		} catch (IOException e) {
			
			System.out.println("Error al escribir en un  archivo");
		}
		
		//Lectura carácter a carácter con FileReader
		
//		try {
//			FileReader lector = new FileReader (fichero);
//			
//			int caracter ;
//			
//			while((caracter = lector.read()) != -1) {
//				
//				
//				System.out.println((char)caracter);
//			}
//
//			
//		} catch (IOException e) {
//			
//			System.out.println("Error al leer en un  archivo");
//		}
		
		// Leer líneas completas con BufferedReader
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fichero));
			String linea;
			int numero=1;
			
			while((linea = br.readLine()) !=null){
				
				System.out.printf("%d + %s",numero,linea);
				numero++;
			}
			
			
			br.close();

			
		} catch (Exception e) {
			
			System.out.println("Error al leer en un  archivo");
		}


		
	}

}
