package com.dam2.ejercicios_ut3_jesus_aday.Ejercicio3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorConcurrente {
  
  private static int contadorClientes = 0; // Contador estático para los mensajes
  
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(5000); // Crear un puerto para el servidor y el cliente escuche por dicho puerto.
      System.out.println("Servidor escuchando por el puerto 5000...");
      
      // Bucle principal
      while(true){
      
        // Aceptar la conexión del socket 
        Socket clienteSocket = serverSocket.accept();
        contadorClientes++; //Incrementa el contador de clientes al conectarse.
        
        System.out.println("Cliente " + contadorClientes + " ha sido conectado");
        
        // Crear un hilo para manejar la comunicación entre ellos
        HiloCliente tarea = new HiloCliente(clienteSocket, contadorClientes);
        Thread hilo = new Thread(tarea);
        
        // Ejecutar el hilo en paralelo
        hilo.start();
        
      }
      
      
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
}
