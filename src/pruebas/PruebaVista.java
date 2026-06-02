package pruebas;

import vista.VistaConsola;

public class PruebaVista {

    public static void main(String[] args) {

        VistaConsola vista = new VistaConsola();

        vista.mostrarMenu();

        int opcion = vista.leerOpcion();

        vista.mostrarMensaje("Elegiste: " + opcion);
    }
}
