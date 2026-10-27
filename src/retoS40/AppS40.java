package retoS40;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AppS40 {

	private static String RUTA = "C:\\Users\\damdu201\\eclipse-workspace\\AccesoADatos\\src\\retoS40\\alumnos.dat";
	private static String RUTATXT = "C:\\Users\\damdu201\\eclipse-workspace\\AccesoADatos\\src\\retoS40\\alumnos.txt";

	public static void main(String[] args) {

		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		Scanner sc = new Scanner(System.in);
		int opcion = -1;

		do {

			System.out.println("===== GESTIÓN DE ALUMNOS =====");
			System.out.println("1. Añadir alumno");
			System.out.println("2. Mostrar alumnos");
			System.out.println("3. Guardar alumnos en fichero");
			System.out.println("4. Cargar alumnos desde fichero");
			System.out.println("5. Exportar alumnos a TXT");
			System.out.println("0. Salir");
			System.out.println("Elige una opción:");
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1:
				añadirAlumno(listaAlumnos);
				break;
			case 2:
				mostrarTodosAlumno(listaAlumnos);
				break;
			case 3:
				guardaListaAlumnos(listaAlumnos);
				break;
			case 4:
				cargaListaAlumnos(listaAlumnos);
				break;
			case 5:
				exportaAlumnos(listaAlumnos);
				break;
			case 6:

				break;

			default:
				break;
			}

		} while (opcion != 0);

	}

	private static void añadirAlumno(ArrayList<Alumno> listaAlumnos) {

		Scanner sc = new Scanner(System.in);
		// Alumno(String dni, String nombre, String apellido1, String apellido2, double
		// nota)

		System.out.println("DNI:");
		String dni = sc.nextLine();

		System.out.println("Nombre:");
		String nombre = sc.nextLine();

		System.out.println("Apellido1:");
		String apellido1 = sc.nextLine();

		System.out.println("Apellido2:");
		String apellido2 = sc.nextLine();

		System.out.println("nota:");
		double nota = Double.parseDouble(sc.nextLine());

		listaAlumnos.add(new Alumno(dni, nombre, apellido1, apellido2, nota));

	}

	private static void mostrarTodosAlumno(ArrayList<Alumno> listaAlumnos) {

		if (listaAlumnos.isEmpty()) {

			System.out.println("la lista está vacía");
		} else {

			for (Alumno alumno : listaAlumnos) {
				System.out.println(alumno);
			}
		}

	}

	private static void guardaListaAlumnos(ArrayList<Alumno> listaAlumnos) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA))) {

			for (Alumno alumno : listaAlumnos) {
				oos.writeObject(alumno);
			}

		} catch (IOException e) {

			System.out.println("Error:" + e);
		}

	}

	private static void cargaListaAlumnos(ArrayList<Alumno> listaAlumnos) {

		try (FileInputStream fis = new FileInputStream(RUTA); ObjectInputStream ois = new ObjectInputStream(fis);) {

			while (true) {
				Alumno alumno = (Alumno) ois.readObject();
				listaAlumnos.add(alumno);
			}

		} catch (EOFException e) {

			System.out.println("cargado con exito");
		}

		catch (ClassNotFoundException e) {

			System.out.println("ERROR:" + e);
		} catch (IOException e) {
			System.out.println("Error:" + e);
		}

	}
	
	
	private static void exportaAlumnos(ArrayList<Alumno> listaAlumnos) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTATXT))) {

			for (Alumno a : listaAlumnos) {
				bw.write(String.format("%s;%s;%s;%s%.2f",a.getDni(),a.getNombre(),a.getApellido1(),a.getApellido2(),a.getNota() ));
				bw.newLine();
			}


		} catch (IOException e) {

			System.out.println("Error: " + e.getMessage());

		}

	}
	
	

}