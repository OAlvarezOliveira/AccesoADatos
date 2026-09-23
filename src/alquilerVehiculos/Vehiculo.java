package alquilerVehiculos;

import java.util.Objects;

public abstract class Vehiculo {
	
	String matricula; 
	String marca;
	double precioDia; 
	TipoCombustible tipoCombustible;
	int diasAlquiler = 1;
	protected static final float IVA = 0.21f; // Constante IVA
	
	//Constructor vacío
	public Vehiculo() {
		super();
	}
	//Constructor Canonico + validacion de VehiculoException
	public Vehiculo(String matricula, String marca, double precioDia, TipoCombustible tipoCombustible, int diasAlquiler) throws VehiculoException {

	    if (precioDia <= 0 || diasAlquiler <= 0) {
	        throw new VehiculoException("El precio por día y los días de alquiler deben ser mayores que cero.");
	    }

	    this.matricula = matricula;
	    this.marca = marca;
	    this.tipoCombustible = tipoCombustible;
	    this.precioDia = precioDia;
	    this.diasAlquiler = diasAlquiler;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecioDia() {
		return precioDia;
	}
	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}
	public TipoCombustible getTipoCombustible() {
		return tipoCombustible;
	}
	public void setTipoCombustible(TipoCombustible tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}
	public int getDiasAlquiler() {
		return diasAlquiler;
	}
	public void setDiasAlquiler(int diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}
	public static float getIva() {
		return IVA;
	}

	public abstract double calcularPrecioFinal();

	public double calcularPrecioConIva() {
		
        return this.diasAlquiler * this.precioDia * IVA;
	}


	public boolean alquilerLargo() {
	        return this.diasAlquiler > 7;
	}
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", precioDia=" + precioDia
				+ ", tipoCombustible=" + tipoCombustible + ", diasAlquiler=" + diasAlquiler + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(diasAlquiler), marca, matricula, Double.valueOf(precioDia),
				tipoCombustible);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return diasAlquiler == other.diasAlquiler && Objects.equals(marca, other.marca)
				&& Objects.equals(matricula, other.matricula)
				&& Double.doubleToLongBits(precioDia) == Double.doubleToLongBits(other.precioDia)
				&& tipoCombustible == other.tipoCombustible;
	}


	
	
}
