package listaAlumnos;

public class Alumno {
	

	private String nombre;
	private float nota;
	private Estado estado; 


	public Alumno(String nombre, float nota, Estado estado) {
		super();
		this.nombre = nombre;
		this.nota = nota;
		this.estado = estado;
	}
	
	public Alumno(String nombre, float nota) {
		super();
		this.nombre = nombre;
		this.nota = nota;
	}
	

	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {

		this.estado = estado; 
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getNota() {
		return nota;
	}
	
	public void setNota(float nota) {
		this.nota = nota;
	}
}
