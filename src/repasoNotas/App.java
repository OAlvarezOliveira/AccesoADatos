package repasoNotas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private static final String RUTA_ENTRADA = "src/repasoNotas/notas.txt";
    private static final String RUTA_SALIDA = "src/repasoNotas/resumen.txt";
    private static final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        File archivoNotas = new File(RUTA_ENTRADA);
        
        if (archivoNotas.exists() && archivoNotas.isFile()) {
            System.out.println("Archivo encontrado correctamente");
            
            try (BufferedReader br = new BufferedReader(new FileReader(archivoNotas))) {
                int cuentalineaDefectuosa = 0;
                int cuentalineaCorrecta = 0;
                String nombreMayorNota = "Ninguno"; // Evita que sea null si el archivo está vacío
                double mayorNota = -1; // Inicializado en -1 para capturar notas de 0 correctamente
                double acumulaNota = 0;
                double media = 0;
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] campos = linea.split(";");
                    
                    if (campos.length == 2) {
                        try {
                            double nota = Double.parseDouble(campos[1]); 
                            
                            if (nota < 0 || nota > 10) {
                                cuentalineaDefectuosa++;
                            } else {
                                if (mayorNota < nota) {
                                    mayorNota = nota;
                                    nombreMayorNota = campos[0];
                                }
                                cuentalineaCorrecta++;

                                acumulaNota += nota; 
                            }
                        } catch (NumberFormatException e) {
                            cuentalineaDefectuosa++;
                        }
                    } else {
                        cuentalineaDefectuosa++;
                    }
                } // fin del while
                
                if (cuentalineaCorrecta > 0) {
                    media = acumulaNota / cuentalineaCorrecta;
                }
                
                System.out.println(String.format(Locale.US, "Lineas Correctas:%d", cuentalineaCorrecta)); 
                System.out.println(String.format(Locale.US, "Lineas Defectuosas:%d", cuentalineaDefectuosa));
                System.out.println(String.format(Locale.US, "Nota Media:%.2f", media));
                System.out.println(String.format(Locale.US, "Mayor Nota:%.2f", mayorNota));
                System.out.println(String.format(Locale.US, "Alumno con mayor nota:%s", nombreMayorNota));
                
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_SALIDA))) {
                    bw.write(String.format(Locale.US, "Lineas Correctas:%d", cuentalineaCorrecta)); 
                    bw.newLine();
                    bw.write(String.format(Locale.US, "Lineas Defectuosas:%d", cuentalineaDefectuosa));
                    bw.newLine();
                    bw.write(String.format(Locale.US, "Nota Media:%.2f", media));
                    bw.newLine();
                    bw.write(String.format(Locale.US, "Mayor Nota:%.2f", mayorNota));
                    bw.newLine();
                    bw.write(String.format(Locale.US, "Alumno con mayor nota:%s", nombreMayorNota));
                    bw.newLine();
                    System.out.println("Resumen guardado correctamente en: " + RUTA_SALIDA);
                }
                
            } catch (FileNotFoundException e) {
                System.out.println("Error: Archivo no encontrado: " + e);
            } catch (IOException e) {
                System.out.println("Error de lectura: " + e);
            }


            System.out.println("¿Deseas añadir otro alumno (s/n) ?");
            String opcion = sc.nextLine().trim();
            
            if (opcion.equalsIgnoreCase("s")) {
                System.out.println("Escribe el nombre del alumno:");
                String nuevoNombre = sc.nextLine();
                System.out.println("Escribe la nota del alumno:");
                double nuevaNota = -1;
				try {
					nuevaNota = Double.parseDouble(sc.nextLine());
				} catch (NumberFormatException e) {
                    System.out.println("Error al escribir la nota: " + e);
				}
                
                try (BufferedWriter bwEntrada = new BufferedWriter(new FileWriter(RUTA_ENTRADA, true))) {
                	
                	if(nuevaNota < 0 || nuevaNota > 10) {
                        System.out.println("La nota proporcionada no es válida , no se añadirá nada");
                		
                	} else {
                        bwEntrada.write(nuevoNombre + ";" + nuevaNota);
                        bwEntrada.newLine();
                        System.out.println("Alumno añadido correctamente. Vuelve a ejecutar para recalcular.");
                	}
                	

                } catch (IOException e) {
                    System.out.println("Error al escribir el nuevo alumno: " + e);
                }
            }

        } else {
            System.out.println("Error: El archivo no existe o no es un fichero válido");
        }
    }
}
