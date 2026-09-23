package videojuegosAlquiler;

import java.time.LocalDate;


public class Videojuego {
	
	String nombre;
	String desarrollador;
	int anioLanzamiento;
	double precio;
	TipoVideojuego tipoVideojuego;
	TipoPlataforma tipoPlataforma;
	
	public Videojuego(String nombre, String desarrollador, int anioLanzamiento, double precio,
			TipoVideojuego tipoVideojuego, TipoPlataforma tipoPlataforma) throws VideojuegoExcepcion {

	    if (anioLanzamiento > LocalDate.now().getYear())  {
	        throw new VideojuegoExcepcion ("La fecha de lanzamiento debe ser anterior a hoy");
	    }

		this.nombre = nombre;
		this.desarrollador = desarrollador;
		this.anioLanzamiento = anioLanzamiento;
		this.precio = precio;
		this.tipoVideojuego = tipoVideojuego;
		this.tipoPlataforma = tipoPlataforma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}

	public int getAnioLanzamiento() {
		return anioLanzamiento;
	}

	public void setAnioLanzamiento(int anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public TipoVideojuego getTipoVideojuego() {
		return tipoVideojuego;
	}

	public void setTipoVideojuego(TipoVideojuego tipoVideojuego) {
		this.tipoVideojuego = tipoVideojuego;
	}

	public TipoPlataforma getTipoPlataforma() {
		return tipoPlataforma;
	}

	public void setTipoPlataforma(TipoPlataforma tipoPlataforma) {
		this.tipoPlataforma = tipoPlataforma;
	}


	@Override
	public String toString() {
	    return String.format(
	            "Videojuego:\n" +
	            "\tNombre: %s\n" +
	            "\tDesarrollador: %s\n" +
	            "\tAño de Lanzamiento: %d\n" +
	            "\tPrecio: %.2f€\n" +
	            "\tTipo: %s\n" +
	            "\tPlataforma: %s",
	            nombre, desarrollador, anioLanzamiento, precio, tipoVideojuego, tipoPlataforma);
	}


}
