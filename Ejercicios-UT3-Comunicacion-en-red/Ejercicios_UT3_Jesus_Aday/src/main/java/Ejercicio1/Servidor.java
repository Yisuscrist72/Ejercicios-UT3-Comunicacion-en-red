package Ejercicio1;

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

            // DataOutputStream 
            DataOutputStream salida = new DataOutputStream(sCliente.getOutputStream()); 
            
            // Mensaje
            salida.writeUTF("Conexión establecida con el servidor");
            
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
