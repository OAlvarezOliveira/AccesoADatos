package videojuegosAlquiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Videojuego> listaVideojuego = new ArrayList<>();
    public static boolean continuar = true;
    public static Path rutaGeneral = Path.of("videojuegos.txt");
    public static Path rutaRPG = Path.of("videojuegosRPG.txt");

    public static void main(String[] args) {
        try {
            menu();
        } catch (VideojuegoExcepcion e) {
            System.out.println("Error de videojuego: " + e.getMessage());
        }
    }

    private static void menu() throws VideojuegoExcepcion {
        Scanner sc = new Scanner(System.in);
        String linea = "";


        while (continuar) {
            System.out.print("Indica el nombre del videojuego: ");
            String nombre = sc.nextLine();

            System.out.print("Indica el desarrollador del videojuego: ");
            String desarrollador = sc.nextLine();

            System.out.print("Añade el anioLanzamiento: ");
            int anioLanzamiento = sc.nextInt();

            System.out.print("Añade el Precio: ");
            double precio = sc.nextDouble();
            sc.nextLine();

            TipoVideojuego tipoVideojuego;
            try {
                System.out.print("Indica el tipo de TipoVideojuego (SHOOTER, RPG, INDIE, ESTRATEGIA): ");
                tipoVideojuego = TipoVideojuego.valueOf(sc.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo no válido, se asignará INDIE por defecto.");
                tipoVideojuego = TipoVideojuego.INDIE;
            }

            TipoPlataforma tipoPlataforma;
            try {
                System.out.print("Indica la plataforma a la que pertenece (PC, PLAYSTATION5, SWITCH2): ");
                tipoPlataforma = TipoPlataforma.valueOf(sc.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Plataforma no válida, se asignará PC por defecto.");
                tipoPlataforma = TipoPlataforma.PC;
            }

            listaVideojuego.add(new Videojuego(nombre, desarrollador, anioLanzamiento, precio, tipoVideojuego, tipoPlataforma));

            linea = nombre + ";" + desarrollador + ";" + anioLanzamiento + ";" + precio + ";" + tipoVideojuego + ";" + tipoPlataforma + "\n";

            System.out.print("\n¿Quieres añadir otro videojuego? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            continuar = respuesta.equals("s");
        }

        System.out.println("\nElige una opción:");
        System.out.println("1 - Añadir al final del archivo (APPEND)");
        System.out.println("2 - Crear o sobrescribir archivo completo (CREATE)");
        System.out.println("3 - Borrar/Truncar archivo guardando solo esta línea");
        System.out.println("4 - Listar Coleccion de Videojuegos");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();
        
        try {
            switch (opcion) {
                case 1:
                    añadeNuevo(linea);        
                    break;
                case 2: 
                    iniciarArchivo(linea);
                    break;
                case 3:
                    borrarLista(linea);
                    break; 
                case 4:
                	listarVideojuego(); 
                    break;    
                default:
                    System.out.println("Opción no válida");
            }
        } catch (IOException e) {
            System.out.println("Error al gestionar el archivo: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static void listarVideojuego() {
        System.out.println("La lista actual de videojuegos es ");
        for (Videojuego videojuego : listaVideojuego) {
            System.out.println(videojuego);

		}
    }

    private static void borrarLista(String linea) throws IOException {

    	if (linea.contains("RPG")) {
            Files.writeString(rutaRPG, linea , StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Archivo limpiado y línea guardada.");
    		
    	}else {
            Files.writeString(rutaGeneral, linea , StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Archivo limpiado y línea guardada.");
    	}

    }

    private static void iniciarArchivo(String linea) throws IOException {
    	if (linea.contains("RPG")) {
            Files.writeString(rutaRPG, linea , StandardOpenOption.CREATE);
            System.out.println("Archivo limpiado y línea guardada.");
    		
    	}else {
            Files.writeString(rutaGeneral, linea , StandardOpenOption.CREATE);
            System.out.println("Archivo limpiado y línea guardada.");
    	}
    }

    private static void añadeNuevo(String linea) throws IOException {
        Files.writeString(rutaGeneral, linea, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        System.out.printf("Línea añadida con éxito: %s", linea);
    }
}
