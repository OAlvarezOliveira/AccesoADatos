package alquilerVehiculos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
    
    public static void main(String[] args) throws VehiculoException {
        // === COCHES ===
        listaVehiculos.add(new Coche("1111AAA", "Audi A5", 59.99, TipoCombustible.HIBRIDO, 12, 5));
        listaVehiculos.add(new Coche("2222BBB", "Seat Arona", 49.99, TipoCombustible.ELECTRICO, 15, 5));
        listaVehiculos.add(new Coche("3333CCC", "BMW Serie 1", 51.25, TipoCombustible.GASOLINA, 1, 5));
        listaVehiculos.add(new Coche("4444DDD", "Mercedes C220", 75.50, TipoCombustible.DIESEL, 45, 4));
        listaVehiculos.add(new Coche("5555EEE", "Toyota Yaris", 35.00, TipoCombustible.HIBRIDO, 3, 5));
        listaVehiculos.add(new Coche("6666FFF", "Tesla Model 3", 89.90, TipoCombustible.ELECTRICO, 7, 4));
        listaVehiculos.add(new Coche("7777GGG", "Volkswagen Golf", 45.00, TipoCombustible.GASOLINA, 5, 5));
        listaVehiculos.add(new Coche("8888HHH", "Hyundai Tucson", 55.00, TipoCombustible.HIBRIDO, 10, 5));
        listaVehiculos.add(new Coche("9999JJJ", "Ford Focus", 42.50, TipoCombustible.DIESEL, 2, 5));
        listaVehiculos.add(new Coche("1234KLL", "Kia Sportage", 53.00, TipoCombustible.GASOLINA, 8, 5));
        listaVehiculos.add(new Coche("5678MMN", "Renault Clio", 30.00, TipoCombustible.GASOLINA, 4, 3));
        listaVehiculos.add(new Coche("9012PQR", "Peugeot 3008", 58.00, TipoCombustible.DIESEL, 20, 5));
        listaVehiculos.add(new Coche("3456STU", "Fiat 500e", 38.50, TipoCombustible.ELECTRICO, 6, 3));

        // === MOTOS ===
        listaVehiculos.add(new Moto("0001MTS", "Honda SH 125i", 25.00, TipoCombustible.GASOLINA, 2, 125));
        listaVehiculos.add(new Moto("0002MTS", "Yamaha T-MAX", 45.50, TipoCombustible.GASOLINA, 5, 530));
        listaVehiculos.add(new Moto("0003MTS", "Vespa Primavera", 28.00, TipoCombustible.GASOLINA, 3, 125));
        listaVehiculos.add(new Moto("0004MTS", "BMW R 1250 GS", 85.00, TipoCombustible.GASOLINA, 14, 1250));
        listaVehiculos.add(new Moto("0005MTS", "Kawasaki Z900", 55.00, TipoCombustible.GASOLINA, 7, 948));
        listaVehiculos.add(new Moto("0006MTS", "Ducati Monster", 70.00, TipoCombustible.GASOLINA, 4, 937));
        listaVehiculos.add(new Moto("0007MTS", "Honda CB500F", 38.00, TipoCombustible.GASOLINA, 6, 471));
        listaVehiculos.add(new Moto("0008MTS", "KTM Duke 390", 40.00, TipoCombustible.GASOLINA, 1, 373));
        listaVehiculos.add(new Moto("0009MTS", "Harley-Davidson Iron", 95.00, TipoCombustible.GASOLINA, 10, 883));
        listaVehiculos.add(new Moto("0010MTS", "Suzuki Burgman", 48.00, TipoCombustible.GASOLINA, 8, 400));
        listaVehiculos.add(new Moto("0011MTS", "Yamaha MT-07", 50.00, TipoCombustible.GASOLINA, 12, 689));
        listaVehiculos.add(new Moto("0012MTS", "Triumph Bonneville", 65.00, TipoCombustible.GASOLINA, 3, 1200));
        listaVehiculos.add(new Moto("0013MTS", "Honda Africa Twin", 78.00, TipoCombustible.GASOLINA, 25, 1100));

        menu();
    }

    private static void menu() throws VehiculoException {
        Scanner sc = new Scanner(System.in);
        boolean continua = true;
        int opcion = 0;
        TipoCombustible tipoCombustible2;
        
        while (continua) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Crear Vehiculo");
            System.out.println("2. Mostrar Vehiculo mas caro");
            System.out.println("3. Calcular Facturacion Total");
            System.out.println("4. Contar Vehiculos por Combustible");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            
            try {
                opcion = sc.nextInt();
                sc.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero.");
                sc.nextLine();
                continue;
            }

            try {
                switch (opcion) {
                    case 1:
                        crearVehiculos();
                        break;
                    case 2:
                        Vehiculo masCaro = mostrarVehiculoMasCaro();
                        System.out.println(masCaro != null ? masCaro : "No hay vehículos.");
                        break;
                    case 3:
                        System.out.println("Facturación total: " + calcularFacturacionTotal() + "€");
                        break;
                    case 4:
                        System.out.print("Indica el tipo de combustible (GASOLINA, DIESEL, HIBRIDO, ELECTRICO): ");
                        try {
                            tipoCombustible2 = TipoCombustible.valueOf(sc.nextLine().trim().toUpperCase()); 
                            System.out.println("Total vehículos: " + contarVehiculosPorCombustible(tipoCombustible2));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: Tipo de combustible no válido.");
                        }
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        continua = false;
                        break;
                    default:
                        System.out.println("Opción no disponible. Inténtalo de nuevo.");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Ocurrió un error: " + e.getMessage());
            }
        }
        sc.close();
    }

    private static int contarVehiculosPorCombustible(TipoCombustible tipoCombustible2) {
        int cuentaCombustible = 0;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getTipoCombustible() == tipoCombustible2) {
                cuentaCombustible++;
            }
        } 
        return cuentaCombustible; 
    }

    private static double calcularFacturacionTotal() {
        double facturacionTotal = 0; 
        for (Vehiculo vehiculo : listaVehiculos) {
            facturacionTotal += vehiculo.calcularPrecioFinal();
        } 
        return facturacionTotal; 
    }

    private static Vehiculo mostrarVehiculoMasCaro() {
        if (listaVehiculos == null || listaVehiculos.isEmpty()) {
            return null; 
        }
        Vehiculo masCaro = listaVehiculos.get(0);
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPrecioDia() > masCaro.getPrecioDia()) {
                masCaro = vehiculo; 
            }
        }
        return masCaro;
    }

    private static void crearVehiculos() {
        Scanner sc = new Scanner(System.in);
        String tipoVehiculo, matricula, marca;
        double precioDia;
        int diasAlquiler;
        TipoCombustible tipoCombustible;
        int cilindrada = 0;
        int numeroPuertas = 0;
        
        try {
            System.out.print("Indica el tipo de vehículo a crear (Coche/Moto): ");     
            tipoVehiculo = sc.nextLine().trim().toUpperCase();
            
            System.out.print("Indica la matrícula del vehículo: ");
            matricula = sc.nextLine().trim();
            
            System.out.print("Indica la marca del vehículo: ");
            marca = sc.nextLine().trim();
            
            System.out.print("Añade el Precio por Día: ");
            precioDia = sc.nextDouble(); 
            
            System.out.print("Añade los días de alquiler: "); 
            diasAlquiler = sc.nextInt(); 
            
            if ("MOTO".equals(tipoVehiculo)) {
                System.out.print("Añade la cilindrada de la MOTO: "); 
                cilindrada = sc.nextInt(); 
            } else if ("COCHE".equals(tipoVehiculo)) {
                System.out.print("Añade el número de puertas del COCHE: "); 
                numeroPuertas = sc.nextInt();
            } else {
                System.out.println("Error: Tipo de vehículo inválido.");
                return;
            }
            sc.nextLine(); 
            
            System.out.print("Indica el tipo de combustible (GASOLINA, DIESEL, HIBRIDO, ELECTRICO): ");     
            tipoCombustible = TipoCombustible.valueOf(sc.nextLine().trim().toUpperCase()); 
            
            if ("MOTO".equals(tipoVehiculo)) {
                listaVehiculos.add(new Moto(matricula, marca, precioDia, tipoCombustible, diasAlquiler, cilindrada));
            } else {
                listaVehiculos.add(new Coche(matricula, marca, precioDia, tipoCombustible, diasAlquiler, numeroPuertas));
            }
            System.out.println("¡Vehículo añadido con éxito!");
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Formato de número incorrecto.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Tipo de combustible inexistente.");
        } catch (VehiculoException e) {
            System.out.println("Error al crear vehiculo");
        }
    }
}

