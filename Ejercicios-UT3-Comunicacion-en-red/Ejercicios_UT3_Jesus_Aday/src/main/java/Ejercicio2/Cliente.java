package Ejercicio2;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {

    static final String Host = "localhost";
    static final int Puerto = 5000;

    public Cliente() {

        try {
            
            // Conexión del servidor en el puerto designado
            Socket sCliente = new Socket(Host, Puerto);
                    
            // Crear flujos de entrada (recibir) y salida (enviar)
            DataInputStream entrada = new DataInputStream(sCliente.getInputStream()); 
            DataOutputStream salida = new DataOutputStream(sCliente.getOutputStream());
            
            // Enviar mensaje al servidor
            String mensajeEnviar = "Hola";
            System.out.println("Enviando al servidor el mensaje: " + mensajeEnviar);
            salida.writeUTF(mensajeEnviar);
            
            // Recibir el eco 
            String eco = entrada.readUTF();
            System.out.println("El cliente a recibido del servidor: " + eco);
            
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
