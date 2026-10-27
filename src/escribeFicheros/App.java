package escribeFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class App {
	
	private static  String ruta = "//home//oscardev//Estudios//2DAM/AD//AccesoADatos//src//escribeFicheros//productos.txt";
	private static  String rutaResumen = "//home//oscardev//Estudios//2DAM/AD//AccesoADatos//src//escribeFicheros//resumen.txt";
	private static  File archivo = new File(ruta);
	private static  File archivoResumen = new File(rutaResumen);
	private static 	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int cuentaLinea = 0;
		int cuentaLineaMala = 0;
		int cuentaProductosCaros = 0;
		int cuentaProductosBaratos = 0;
		double precioProducto = 0;
		double sumaPrecios = 0;
		double precioMedioProducos = 0;
		String linea = null;
		String lineaExtra = "Impresora;59.99";

		if (archivo.exists() && archivo.isFile()) {

			System.out.println("El archivo existe");
		} else {

			System.out.println("El archivo No existe");
			return;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(archivo));
				BufferedWriter bw = new BufferedWriter(new FileWriter(archivoResumen))) {

			while ((linea = br.readLine()) != null) {

				String[] campos;
				try {
					campos = linea.split(";");
					if (campos.length != 2) {
						// linea mal formada saltarla
						cuentaLineaMala++;
					} else {
						precioProducto = Double.parseDouble(campos[1]);
						cuentaLinea++;
						sumaPrecios += precioProducto;
						if (precioProducto < 20) {
							cuentaProductosBaratos++;
						} else {
							cuentaProductosCaros++;
						}

					}

				}catch (NumberFormatException e) {
					System.out.println("Error:" + e);
					cuentaLineaMala++;
				}

			} // fin while

			if(cuentaLinea >0) {
				precioMedioProducos = sumaPrecios / cuentaLinea;
			}else {
				System.out.println("El archivo no contenía productos válidos para procesar");
			}

			
			//Salidas
			System.out.print(String.format(Locale.US,"PRECIO MEDIO:%.2f\n",precioMedioProducos));
			System.out.print(String.format(Locale.US,"LINEAS CORRECTAS:%d\n",cuentaLinea));
			System.out.print(String.format(Locale.US,"LINEAS SALTADAS:%d\n",cuentaLineaMala));
			System.out.print(String.format(Locale.US,"PRODUCTOS CAROS:%d\n",cuentaProductosCaros));
			System.out.print(String.format(Locale.US,"PRODUCTOS BARATOS:%d\n",cuentaProductosBaratos));

			
			bw.write(String.format(Locale.US,"PRECIO MEDIO:%.2f",precioMedioProducos));
			bw.newLine();
			bw.write(String.format(Locale.US,"LINEAS CORRECTAS:%d",cuentaLinea));
			bw.newLine();
			bw.write(String.format(Locale.US,"LINEAS SALTADAS:%d",cuentaLineaMala));
			bw.newLine();
			bw.write(String.format(Locale.US,"PRODUCTOS CAROS:%d",cuentaProductosCaros));
			bw.newLine();
			bw.write(String.format(Locale.US,"PRODUCTOS BARATOS:%d",cuentaProductosBaratos));
			
			//añadir un producto extra
			System.out.println("¿Deseas añadir el producto extra?"
					+ "(si ya lo has hecho antes se duplicará) "
					+ "Pulsa S/N según desees");
		
			String opcion = sc.nextLine().toLowerCase().trim();
			
			if(opcion.equals("s")) {
				anadirProducto(lineaExtra);
			}else {
				System.out.println("Ok, no se añaden mas productos");
			}

		} catch (IOException e) {
			System.out.println("Error:" + e);

		}

	}
	
	public static void anadirProducto(String lineaExtra) {
		
		try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ruta,true))) {
			
			bw.write(String.format(Locale.US,"\n%s",lineaExtra));
			System.out.println("Linea Añadida:"+lineaExtra);
		
	} catch (IOException e) {
		System.out.println("Error:" + e);
	}

}
	
}
