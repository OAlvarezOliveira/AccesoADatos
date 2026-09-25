package videojuegosAlquiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();
    public static boolean continuar = true;
    public static Path rutaOtros = Path.of("src/videojuegosAlquiler/videojuegos.txt");
    public static Path rutaRPG = Path.of("src/videojuegosAlquiler/videojuegosRPG.txt");

    public static void main(String[] args) {
        try {
            menu();
        } catch (VideojuegoExcepcion e) {
            System.out.println("Error de videojuego: " + e.getMessage());
        }
    }

    private static void menu() throws VideojuegoExcepcion {
        Scanner sc = new Scanner(System.in);

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

            listaVideojuegos.add(new Videojuego(nombre, desarrollador, anioLanzamiento, precio, tipoVideojuego, tipoPlataforma));

            System.out.print("\n¿Quieres añadir otro videojuego? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            continuar = respuesta.equals("s");
        }

        System.out.println("\nElige una opción:");
        System.out.println("1 - Crear archivo con la lista completa (CREATE)");
        System.out.println("2 - Añadir un registro al final del archivo (APPEND)");
        System.out.println("3 - Sobrescribir el archivo dejando solo el último videojuego (CREATE + TRUNCATE)");
        System.out.println("4 - Listar Coleccion de Videojuegos");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        try {
            switch (opcion) {
                case 1:
                    crearArchivoCompleto();
                    break;
                case 2:
                    añadirAlFinal();
                    break;
                case 3:
                    sobrescribirConUltimo();
                    break;
                case 4:
                	listarVideojuegos();
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

    private static void listarVideojuegos() {
        System.out.println("La lista actual de videojuegos es ");
        for (Videojuego videojuego : listaVideojuegos) {
            System.out.println(videojuego);

		}
    }

    private static void sobrescribirConUltimo() throws IOException {
        for (Videojuego v : listaVideojuegos) {
            String lineaVideojuego = v.getNombre() + ";" + v.getDesarrollador() + ";"
                + v.getAnioLanzamiento() + ";" + v.getPrecio() + ";"
                + v.getTipoVideojuego() + ";" + v.getTipoPlataforma() + "\n";

            if (v.getTipoVideojuego() == TipoVideojuego.RPG) {
                Files.writeString(rutaRPG, lineaVideojuego , StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                Files.writeString(rutaOtros, lineaVideojuego , StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
        }

        System.out.println("Archivo limpiado y línea guardada.");
    }

    private static void crearArchivoCompleto() throws IOException {
        StringBuilder rpgTexto = new StringBuilder();
        StringBuilder otrosTexto = new StringBuilder();

        for (Videojuego v : listaVideojuegos) {
            String lineaVideojuego = v.getNombre() + ";" + v.getDesarrollador() + ";"
                + v.getAnioLanzamiento() + ";" + v.getPrecio() + ";"
                + v.getTipoVideojuego() + ";" + v.getTipoPlataforma() + "\n";

            if (v.getTipoVideojuego() == TipoVideojuego.RPG) {
                rpgTexto.append(lineaVideojuego);
            } else {
                otrosTexto.append(lineaVideojuego);
            }
        }

        Files.writeString(rutaRPG, rpgTexto.toString(), StandardOpenOption.CREATE);
        Files.writeString(rutaOtros, otrosTexto.toString(), StandardOpenOption.CREATE);
        System.out.println("Archivo creado con la lista completa.");
    }

    private static void añadirAlFinal() throws IOException {
        for (Videojuego v : listaVideojuegos) {
            String lineaVideojuego = v.getNombre() + ";" + v.getDesarrollador() + ";"
                + v.getAnioLanzamiento() + ";" + v.getPrecio() + ";"
                + v.getTipoVideojuego() + ";" + v.getTipoPlataforma() + "\n";

            if (v.getTipoVideojuego() == TipoVideojuego.RPG) {
                Files.writeString(rutaRPG, lineaVideojuego , StandardOpenOption.APPEND);
                System.out.println("Línea añadida al final del archivo.");
            } else {
                Files.writeString(rutaOtros, lineaVideojuego , StandardOpenOption.APPEND);
                System.out.println("Línea añadida al final del archivo.");
            }
        };
    }
}
