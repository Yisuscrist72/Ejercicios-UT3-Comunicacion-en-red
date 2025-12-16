package Ejercicio4;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteTCP {

  public static void main(String[] args) {
    String host = "localhost"; // O la IP del servidor
    int puerto = 5000;

    try (
      // Establecer la conexión con el servidor
      Socket socket = new Socket(host, puerto);
      ) 
    {
      System.out.println("Conectado al servidor en " + host + ":" + puerto);
      
      // Crear el objeto a enviar al servidor
      Persona p = new Persona("María Pérez", 28);
      System.out.println("Objeto a enviar: " + p.toString());
      
      // Abrir el ObjectOutputStream. Este orden es crucial ya que el ObjectOutputStream debe abrirse primero.
      
      try (ObjectOutputStream salidaObjeto = new ObjectOutputStream(socket.getOutputStream())) {

        // Enviar el objeto al servidor
        salidaObjeto.writeObject(p);
        salidaObjeto.flush(); // Asegurar que el objeto se envía inmediatamente

        System.out.println("Objeto enviado con éxito.");
      }

    } catch (IOException e) {
      System.err.println("Error en el cliente: " + e.getMessage());
    }

  }

}
