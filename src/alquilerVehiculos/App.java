package alquilerVehiculos;

import java.util.ArrayList;

import listaAlumnos.Alumno;

public class App {
	public static ArrayList<Vehiculo> listaVehiculos;
	
	public static void main(String[] args) throws VehiculoException {
		
		    listaVehiculos = new ArrayList<Vehiculo>();

		 // === 13 COCHES ===
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


		    // === 13 MOTOS ===
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



			crearVehiculos(); 
			System.out.println(mostrarVehiculoMasCaro());
			calcularFacturacionTotal();
			contarVehiculosPorCombustible();
		    
		
	}

	private static void contarVehiculosPorCombustible() {
		// TODO Auto-generated method stub
		
	}

	private static void calcularFacturacionTotal() {
		// TODO Auto-generated method stub
		
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
		
		
		
	}

}
