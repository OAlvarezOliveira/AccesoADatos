package alquilerVehiculos;

import java.util.Objects;

public class Moto extends Vehiculo implements Comparable<Moto>{
	
	private int cilindrada;
	
	
	public Moto() {
		super();
		// TODO Auto-generated constructor stub
	}








	public Moto(String matricula, String marca, double precioDia, TipoCombustible tipoCombustible, int diasAlquiler,int cilindrada)
			throws VehiculoException {
		super(matricula, marca, precioDia, tipoCombustible, diasAlquiler);
		this.cilindrada = cilindrada;
	}








	public int getCilindrada() {
		return cilindrada;
	}



	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
		

@Override
	public double calcularPrecioFinal() {
		return (this.diasAlquiler * this.precioDia + calcularPrecioConIva() + (this.cilindrada * 0.01)) ;
		}
	
	public  boolean esGranCilindrada() {
		
		boolean esGranCilindrada = false;
		
		if (this.cilindrada <= 400)  {esGranCilindrada = false;} else { esGranCilindrada = true;}
		return esGranCilindrada;
		
		
	}








	@Override
	public String toString() {
		return String.format(
				"marca:%s \n"
				+ "cilindrada:%s \n"
				+ "matricula:%s \n"
				+ "precioDia:%s \n"
				+ "tipoCombustible:%s \n"
				+ "diasAlquiler:%s \n",
				marca,cilindrada, matricula, precioDia, tipoCombustible, diasAlquiler);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cilindrada);
		return result;
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
		Moto other = (Moto) obj;
		return cilindrada == other.cilindrada;
	}








	@Override
	public int compareTo(Moto o) {
		// TODO Auto-generated method stub
		return 0;
	}





}
