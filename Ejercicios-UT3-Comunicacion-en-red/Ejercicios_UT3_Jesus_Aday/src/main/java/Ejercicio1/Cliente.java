package Ejercicio1;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {

    static final String Host = "localhost";
    static final int Puerto = 5000;

    public Cliente() {

        try {
            
            // Conexión del servidor en el puerto designado
            Socket sCliente = new Socket(Host, Puerto);
                    
            // DataOutputStream 
            DataInputStream entrada = new DataInputStream(sCliente.getInputStream()); 
            
            // Leer mensaje
            String mensaje = entrada.readUTF();
            
            System.out.println("Mensaje del servidor: " + mensaje);
            
            
            // Cierro del socket 
            sCliente.close();
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Cliente();
    }

}
