package persistencia;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GestorArchivos {

    public void guardarPartida(Object objeto, String nombreArchivo) {

        try (ObjectOutputStream salida =
                new ObjectOutputStream(
                        new FileOutputStream(nombreArchivo))) {

            salida.writeObject(objeto);

        } catch (IOException e) {

            System.out.println("Error al guardar la partida: "
                    + e.getMessage());

        }
    }
 public Object cargarPartida(String nombreArchivo) {
    try (ObjectInputStream entrada =
            new ObjectInputStream(
                    new FileInputStream(nombreArchivo))) {

        Object objeto = entrada.readObject();
        
        return objeto;

    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al cargar la partida: " + e.getMessage());
        return null;
    }
}
}