package retoS40;

import java.io.Serializable;

public class Alumno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private double nota;
	
	
	public Alumno(String dni, String nombre, String apellido1, String apellido2, double nota) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nota = nota;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public double getNota() {
		return nota;
	}


	public void setNota(double nota) {
		this.nota = nota;
	}


	@Override
	public String toString() {
		return String.format("Alumno: "
				+ "dni=%s, "
				+ "nombre=%s, "
				+ "apellido1=%s, "
				+ "apellido2=%s, "
				+ "nota=%.2f]", dni, nombre, apellido1,
				apellido2, nota);
	}
	
	

	
	

}
