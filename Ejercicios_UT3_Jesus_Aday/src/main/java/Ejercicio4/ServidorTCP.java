package Ejercicio4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
  public static void main(String[] args) {
    int puerto = 5000;
    
    try{
      ServerSocket serverSocket = new ServerSocket(5000); // Crear un puerto para el servidor y el cliente escuche por dicho puerto.
      System.out.println("Servidor escuchando por el puerto 5000...");
      
      // Aceptar la conexión del cliente
      Socket clienteSocket = serverSocket.accept();
      System.out.println("Cliente conectado desde " + clienteSocket.getInetAddress());
      
      // Se debe abrir el flujo de entrada del socket dentro de ObjectInputStream
      // Este orden es CRUCIAL en la comunicación de objetos.
      try (ObjectInputStream entradaObjeto = new ObjectInputStream(clienteSocket.getInputStream())) {

        // LEER el objeto
        // El método readObject() devuelve un 'Object', por lo que requiere un casting
        Persona personaRecibida = (Persona) entradaObjeto.readObject();

        // IMPRIMIR los datos
        System.out.println("\n--- Objeto recibido ---");
        System.out.println("Tipo de objeto: " + personaRecibida.getClass().getName());
        System.out.println("Datos de la Persona: " + personaRecibida.toString());
        System.out.println("-------------------------\n");

      } catch (ClassNotFoundException e) {
        System.err.println("Error: Clase Persona no encontrada. Asegúrese de que existe en el servidor.");
      } finally {
        // Cierre del socket del cliente
        clienteSocket.close();
        System.out.println("Conexión cerrada.");
      }
      
    } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
    }

  }
}
