package alquilerInstrumentosMusicales;

import java.io.IOException;
import java.util.InputMismatchException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	private static ArrayList<Instrumento> stockInstrumetos = new ArrayList<Instrumento>();
	public static boolean continuar = true;
	public static boolean acumulaInstrumentos = true;
	static Scanner sc = new Scanner(System.in) ;
	public static Path instrumentosPercusion = Path.of("src/alquilerInstrumentosMusicales/instrumentosPercusion.txt");
	public static Path instrumentosOtros = Path.of("src/alquilerInstrumentosMusicales/instrumentosOtros.txt");



	public static void main(String[] args) throws IOException {


		menu();
		sc.close();
	}

	private static void menu() throws IOException {

		String nombre ;
		String marca;
		String añadirSiNO;
		int anioFabricacion = 0;
		double precio = 0;
		TipoInstrumento tipoInstrumento;
		TipoUbicacion tipoUbicacion;

		//(String nombre, String marca, int anioFabricacion, double precio, TipoInstrumento tipoInstrumento,TipoUbicacion tipoUbicacion) 
		while(acumulaInstrumentos) {		
			System.out.print("nombre: ");
			nombre = sc.nextLine();

			System.out.print("marca: ");
			marca= sc.nextLine();

			System.out.print("Tipo Instrumento (CUERDA, VIENTO, PERCUSION, TECLADO): ");
			tipoInstrumento  = TipoInstrumento.valueOf(sc.nextLine().trim().toUpperCase());

			System.out.print("Ubicacion (TIENDA, ALMACEN, TALLER): ");
			tipoUbicacion = TipoUbicacion.valueOf(sc.nextLine().trim().toUpperCase());

			try {
				System.out.print("anioFabricacion: ");
				anioFabricacion = sc.nextInt();

				System.out.print("precio: ");
				precio = sc.nextDouble();
				sc.nextLine();
			} catch (NumberFormatException | InputMismatchException e) {
				
			    System.out.println("Error: El formato de entrada no es un número válido.");
			}


			stockInstrumetos.add(new Instrumento(nombre,marca,anioFabricacion,precio,tipoInstrumento,tipoUbicacion));

			System.out.print("Deseas Añadir mas instrumentos (Si,No)");
			añadirSiNO = (sc.nextLine().trim().toUpperCase());

			if (añadirSiNO.equals("NO")) {acumulaInstrumentos= false;break;}

		}

		while(continuar) {	
			System.out.println("\nMODO GUARDADO:");
			System.out.println("1 - Crear archivo con la lista completa (CREATE)");
			System.out.println("2 - Añadir un registro al final del archivo (APPEND)");
			System.out.println("3 - Sobrescribir el archivo dejando solo el último videojuego (CREATE + TRUNCATE)");
			System.out.println("4 - Listar Stock");
			System.out.println("5 - Salir");
			System.out.print("Opción: ");
			int opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				for (Instrumento elementoArray : stockInstrumetos) {

					if (elementoArray.getTipoInstrumento() == TipoInstrumento.PERCUSION) {

						Files.writeString(instrumentosPercusion, creaFiltrados(), StandardOpenOption.CREATE);

					} else { 

						Files.writeString(instrumentosOtros, creaNoFiltraos(), StandardOpenOption.CREATE);

					}

				}

				break;
			case 2:
				for (Instrumento elementoArray : stockInstrumetos) {

					if (elementoArray.getTipoInstrumento() == TipoInstrumento.PERCUSION) {

						Files.writeString(instrumentosPercusion, creaLinea(elementoArray),StandardOpenOption.APPEND);

					} else { 

						Files.writeString(instrumentosOtros, creaLinea(elementoArray), StandardOpenOption.APPEND);

					}

				}

				break;
			case 3:
				for (Instrumento elementoArray : stockInstrumetos) {

					if (elementoArray.getTipoInstrumento() == TipoInstrumento.PERCUSION) {

						Files.writeString(instrumentosPercusion, creaLinea(elementoArray),StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);

					} else { 

						Files.writeString(instrumentosOtros, creaLinea(elementoArray), StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);

					}

				}

				break;
			case 4:
				for (Instrumento elementoArray : stockInstrumetos) {

					System.out.println(elementoArray);

				}

				break;	
			case 5:
				continuar = false;
				break;	

			default:
				break;
			}

		}
	}

	private static StringBuilder creaFiltrados() {
        StringBuilder filtrados = new StringBuilder();
        
        for (Instrumento elementoArray : stockInstrumetos) {


            if (elementoArray.getTipoInstrumento() == TipoInstrumento.PERCUSION) {
            	filtrados.append(creaLinea(elementoArray));
            } 
        }
        
		return filtrados;
	}

	private static StringBuilder creaNoFiltraos() {
		

        StringBuilder noFiltraos = new StringBuilder();
        
        for (Instrumento elementoArray : stockInstrumetos) {

            if (elementoArray.getTipoInstrumento() != TipoInstrumento.PERCUSION) {
            	noFiltraos.append(creaLinea(elementoArray));
            } 
        }
		return noFiltraos;
	}

	private static String creaLinea(Instrumento elementoArray) {
		String linea = "";
		//(String nombre, String marca, int anioFabricacion, double precio, TipoInstrumento tipoInstrumento,TipoUbicacion tipoUbicacion) 
		linea =  elementoArray.getNombre()+";"+ elementoArray.getMarca()+";"+ elementoArray.getAnioFabricacion()+";"+   
				elementoArray.getPrecio() +";"+  elementoArray.getTipoInstrumento()+";"+ elementoArray.getTipoUbicacion()+"	\n"; 
		return linea;

	}

}
