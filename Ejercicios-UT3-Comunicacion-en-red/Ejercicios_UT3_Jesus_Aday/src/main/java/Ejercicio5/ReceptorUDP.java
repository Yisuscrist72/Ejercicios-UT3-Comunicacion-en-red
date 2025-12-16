package Ejercicio5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceptorUDP {

    static final int Puerto = 5000;

    public ReceptorUDP() {
        try {
            // Crear el socket del puerto
            DatagramSocket socket = new DatagramSocket(Puerto);
            System.out.println("Receptor esperando datagramas en puerto " + Puerto);
            
            // Buffer para recibir el contenedor vacio
            byte[] bufferEntrada = new byte[1024];
            DatagramPacket paqueteRecibido = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            
            // Recibir el paquete
            socket.receive(paqueteRecibido);
            
            // Leer el mensaje
            String mensaje = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
            System.out.println("RECEPTOR RECEPCIONÓ: " + mensaje);
            
            // RESPONDER AL EMISOR
            
            // Obtener quién envió el paquete (IP y Puerto)
            InetAddress ipEmisor = paqueteRecibido.getAddress();
            int PuertoEmisor = paqueteRecibido.getPort();
            
            // Crear el mensaje
            String respuesta = "Mensaje recibido correctamente";
            byte[] bufferSalida = respuesta.getBytes();
            
            // Empaquetar y Enviar respuesta al emisor
            DatagramPacket paqueteRespuesta = new DatagramPacket(
                bufferSalida, 
                bufferSalida.length, 
                ipEmisor, 
                PuertoEmisor
            );
            
            socket.send(paqueteRespuesta);
            System.out.println("Respuesta enviada.");
            
            // Cerrar
            socket.close();
                        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new ReceptorUDP();
    }
}
