package serializacionObjetos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AppS38 {
	
	private static String ruta ="src/serializacionObjetos/numeros.dat";


	public static void main(String[] args) {
		
		try( RandomAccessFile fichero = new RandomAccessFile (ruta,"rw") ){
			
			fichero.setLength(0); //borra todo el contenido
			fichero.writeInt(10);
			fichero.writeInt(20);
			fichero.writeInt(30);

//			System.out.println("Posicion del puntero"+fichero.getFilePointer());	//el puntero cuenta bytes: tras 3 int estamos en el byte 12
//			
//			fichero.seek(4);
//			int numero = fichero.readInt(); //lee 4 bytes por que es lo que ocupa un int
//			System.out.println(numero);
//			System.out.println("Posicion despues de leer "+fichero.getFilePointer());
			
			fichero.seek(8); // me posiciono en el tercer int (2 enteros x 4 bytes = byte 8)
			fichero.writeInt(20); // sobrescribo el tercer int (ocupa 4 bytes)
			fichero.seek(8); // vuelvo al inicio del tercer int
			int tercerNumero  = fichero.readInt(); //lee 4 bytes
			System.out.println(tercerNumero);
			
			fichero.seek(0); //puntero al principio del fichero (byte 0)
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
