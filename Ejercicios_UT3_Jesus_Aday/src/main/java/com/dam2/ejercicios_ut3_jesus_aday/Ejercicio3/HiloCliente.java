package com.dam2.ejercicios_ut3_jesus_aday.Ejercicio3;

import java.io.*;
import java.net.Socket;

public class HiloCliente implements Runnable {
    
    private final Socket clienteSocket; // El Socket específico para este cliente.
    private final int numCliente; // Identificador único para distinguir los logs de cada cliente.

    // Constructor que recibe el socket del cliente aceptado y su número de identificación.
    public HiloCliente(Socket socket, int num) {
        this.clienteSocket = socket;
        this.numCliente = num;
    }

    /**
     * Método run(): Contiene toda la lógica de ejecución del hilo.
     * Cuando se llama a thread.start(), este método se ejecuta en paralelo.
     */
    @Override
    public void run() {
        try (
            // Abrir los flujos de comunicacicación
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
          ) {
            // Entrada del mesanje del cliente
            String mensajeCliente = entrada.readLine();
            System.out.println("Cliente " + numCliente + " dice: " + mensajeCliente);
            
            // Responder al cliente
            String respuesta = "Hola cliente numero " + numCliente;
            salida.println(respuesta);
            System.out.println("Respuesta enviada a Cliente " + numCliente);

        } catch (IOException e) {
            // Manejar errores de E/S o desconexión
            System.err.println("Error en la comunicación con Cliente " + numCliente + ": " + e.getMessage());
        } finally {
            try {
                // Cerrar el socket individual del cliente
                clienteSocket.close(); 
                System.out.println("Conexión cerrada con Cliente " + numCliente);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
