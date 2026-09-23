package alquilerVehiculos;

import java.util.Objects;

public class Coche extends Vehiculo implements Comparable<Coche>{
	
	private int numeroPuertas;

	public Coche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coche(String matricula, String marca, double precioDia, TipoCombustible tipoCombustible, int diasAlquiler,int numeroPuertas)
			throws VehiculoException {
		super(matricula, marca, precioDia, tipoCombustible, diasAlquiler);
		this.numeroPuertas = numeroPuertas;
	}

	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}
	
	@Override
	public double calcularPrecioFinal() {
		
		return this.diasAlquiler * this.precioDia + calcularPrecioConIva();
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroPuertas);
		return result;
	}




	@Override
	public String toString() {
		return String.format(
				"marca:%s \n"
				+ "numeroPuertas:%s \n"
				+ "matricula:%s \n"
				+ "precioDia:%s \n"
				+ "tipoCombustible:%s \n"
				+ "diasAlquiler:%s \n",
				marca,numeroPuertas, matricula, precioDia, tipoCombustible, diasAlquiler);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return numeroPuertas == other.numeroPuertas;
	}

	@Override
	public int compareTo(Coche o) {
		// TODO Auto-generated method stub
		return 0;
	}


}

