package com.dam2.ejercicios_ut3_jesus_aday.Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Cliente {
  public static void main(String[] args) {
    String host = "localhost"; // O la IP del servidor
    int puerto = 5000;
    
    try(
      // Intentar establecer la conexión
      Socket socket = new Socket(host, puerto);
      
      // Flujos de E/S
      PrintWriter salida = new PrintWriter(socket.getOutputStream(), true); 
      BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
    ){
      String mensaje = "Soy un nuevo cliente";
      
      // Enviar el mensaje
      salida.println(mensaje);
      System.out.println("Cliente ha enviado un mensaje: " + mensaje);

      // Recibir la respuesta del servidor
      String respuesta = entrada.readLine();
      System.out.println("Servidor dice: " + respuesta);
            
     } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
    }
    
  }
}
