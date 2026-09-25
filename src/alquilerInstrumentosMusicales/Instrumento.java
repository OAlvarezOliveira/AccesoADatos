package alquilerInstrumentosMusicales;

public class Instrumento {

	String nombre;
	String marca;
	int anioFabricacion;
	double precio;
	
	TipoInstrumento tipoInstrumento;
	TipoUbicacion   tipoUbicacion;
	
	
	public Instrumento(String nombre, String marca, int anioFabricacion, double precio, TipoInstrumento tipoInstrumento,
			TipoUbicacion tipoUbicacion) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.anioFabricacion = anioFabricacion;
		this.precio = precio;
		this.tipoInstrumento = tipoInstrumento;
		this.tipoUbicacion = tipoUbicacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getAnioFabricacion() {
		return anioFabricacion;
	}


	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public TipoInstrumento getTipoInstrumento() {
		return tipoInstrumento;
	}


	public void setTipoInstrumento(TipoInstrumento tipoInstrumento) {
		this.tipoInstrumento = tipoInstrumento;
	}


	public TipoUbicacion getTipoUbicacion() {
		return tipoUbicacion;
	}


	public void setTipoUbicacion(TipoUbicacion tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}


	@Override
	public String toString() {
		return String.format(
				"nombre=%s \n"
				+ "marca=%s \n"
				+ "anioFabricacion=%d \n"
				+ "precio=%.2f \n"
				+ "tipoInstrumento=%s \n"
				+ "tipoUbicacion=%s \n",
			
				nombre, marca, anioFabricacion, precio, tipoInstrumento, tipoUbicacion);
	}
	
	
}
