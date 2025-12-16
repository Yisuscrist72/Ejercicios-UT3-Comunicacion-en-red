package Ejercicio5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EmisorUDP {

    static final int Puerto_destino = 5000;
    static final String Host = "localhost";

    public EmisorUDP() {

        try {
            
            // Crear socket (puerto aleatorio disponible)
            DatagramSocket socket = new DatagramSocket();
            InetAddress direccionDestino = InetAddress.getByName(Host);
            
            // Mensaje a enviar
            String mensaje = "Hola, soy el Emisor";
            byte[] bufferSalida = mensaje.getBytes();
            
            // Crear paquete y enviar
            DatagramPacket paqueteEnvio = new DatagramPacket(
                bufferSalida, 
                bufferSalida.length, 
                direccionDestino, 
                Puerto_destino
            );
            
            socket.send(paqueteEnvio);
            System.out.println("Mensaje enviado al Receptor.");
            
            
            // ESPERAR RESPUESTA DEL RECEPTOR
            
            // Preparar el buffer para respuesta
            byte[] bufferEntrada = new byte[1024];
            DatagramPacket paqueteRespuesta = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            
            // Recibir el mensaje
            socket.receive(paqueteRespuesta);
            
            // Mostrar la respuesta 
            String respuesta = new String (paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength());
            System.out.println("EMISOR RECIBIÓ RESPUESTA: " + respuesta);
            
            // Cerrar
            socket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        new EmisorUDP();
    }

}
