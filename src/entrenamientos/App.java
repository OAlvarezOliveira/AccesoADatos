package entrenamientos;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
        GestorEntrenamientos ge = new GestorEntrenamientos();
        ge.leerFichero("src/entrenamientos/entrenamientos.txt");
        ge.mostrarMedias();
        ge.deportistaMayorMedia();
        ge.mediaGeneral();

	}

}
