package Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Servidor {

    static final int puerto = 5000;

    public Servidor() {
        try {
            // Inicio de escucha del puerto del servidor
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Escuha por el puerto " + puerto);

            // Espera que se conecte un cliente y crea un nuevo socket para el cliente
            Socket sCliente = serverSocket.accept();

            // Crear flujos de entrada (recibir) y salida (enviar)
            DataOutputStream salida = new DataOutputStream(sCliente.getOutputStream()); 
            DataInputStream entrada = new DataInputStream(sCliente.getInputStream());
            
            // Leer lo que envía el cliente
            String mensajeRecibido = entrada.readUTF();
            System.out.println("Servidor ha recibido del cliente: " + mensajeRecibido);
                        
            // Mensaje
            salida.writeUTF(mensajeRecibido);
            
            // Cierre del socket
            sCliente.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }
}

