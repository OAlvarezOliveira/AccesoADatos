package serializacionObjetos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AppS38 {
	
	private static String ruta ="C:\\Users\\damdu201\\eclipse-workspace\\AccesoADatos\\src\\serializacionObjetos\\numeros.dat";


	public static void main(String[] args) {
		
		try( RandomAccessFile fichero = new RandomAccessFile (ruta,"rw") ){
			
			fichero.setLength(0); //borra todo el contenido
			fichero.writeInt(10);
			fichero.writeInt(20);
			fichero.writeInt(30);

//			System.out.println("Posicion del puntero"+fichero.getFilePointer());	//lee de nible en nible vamos en 12bits
//			
//			fichero.seek(4);
//			int numero = fichero.readInt(); //lee 4 bytes por que es lo que ocupa un int
//			System.out.println(numero);
//			System.out.println("Posicion despues de leer "+fichero.getFilePointer());
			
			fichero.seek(8); // me posicion en el tercer
			fichero.writeInt(20); // escribo el nible
			fichero.seek(8); //me reposiciono en el tercer nible
			int tercerNumero  = fichero.readInt(); //lee 4 bytes
			System.out.println(tercerNumero);
			
			fichero.seek(0); //puntero a cero
			while(  fichero.getFilePointer() <fichero.length() ) {
				int valorHEX  = fichero.readInt();
				System.out.println("Posicion despues de leer "+fichero.getFilePointer());
				System.out.printf("%-11d %02X %02X %02X %02X%n",
						valorHEX,
						(valorHEX >>> 24) & 0xFF,
						(valorHEX >>> 16) & 0xFF,
						(valorHEX >>> 8) & 0xFF,
						valorHEX & 0xFF);

				
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Error:" + e);
			
		} catch (IOException e) {
			
			System.out.println("Error:" + e);
			
		}
		
	}

}
