# 📡 Ejercicios de Sockets en Java (TCP y UDP)

Este repositorio contiene una colección de ejercicios prácticos sobre programación de redes en Java. Se implementa la arquitectura Cliente-Servidor utilizando tanto el protocolo **TCP** (orientado a conexión) como **UDP** (no orientado a conexión), abarcando desde conexiones simples hasta concurrencia y serialización de objetos.

## 📋 Contenido de los Ejercicios

### Ejercicio 1 – Cliente y Servidor TCP Simples
**Objetivo:** Establecer una conexión básica.
* **Servidor:** Escucha en el puerto `5000`. Al aceptar un cliente, envía el mensaje *"Conexión establecida con el servidor"* y cierra la conexión.
* **Cliente:** Se conecta, recibe el mensaje y lo muestra por consola.

### Ejercicio 2 – Eco TCP (Bidireccional)
**Objetivo:** Implementar un servicio de respuesta tipo "Eco".
* **Flujo:** El cliente envía la cadena "Hola". El servidor recibe el mensaje y lo devuelve exactamente igual al cliente.

### Ejercicio 3 – Servidor TCP Concurrente (Multihilo)
**Objetivo:** Manejar múltiples clientes simultáneamente sin bloquear el servidor.
* **Detalle:** Se utilizan `Threads` para gestionar cada conexión. El servidor responde a cada cliente con un identificador único: *"Hola <número_cliente>"*.

### Ejercicio 4 – Envío de Objetos por TCP (Serialización)
**Objetivo:** Transmitir objetos complejos en lugar de texto plano.
* **Clase:** `Persona` (atributos: nombre, edad). Implementa la interfaz `Serializable`.
* **Flujo:** El cliente envía un objeto `Persona` a través de `ObjectOutputStream`. El servidor lo reconstruye y muestra los datos.

### Ejercicio 5 – Comunicación UDP (Sin conexión)
**Objetivo:** Envío de datagramas (paquetes) sin establecer una conexión permanente.
* **Clases:**
    * `ReceptorUDP`: Escucha datagramas entrantes y responde al remitente.
    * `EmisorUDP`: Envía un mensaje y espera la confirmación.
* **Respuesta:** El receptor contesta con *"Mensaje recibido"*.

---

## 🚀 Instrucciones de Instalación y Ejecución

### Prerrequisitos
* **Java JDK** instalado (versión 8 o superior).

### Compilación
Abre una terminal en la carpeta raíz del proyecto y compila todos los archivos:

```bash
javac Ejercicio1/*.java Ejercicio2/*.java Ejercicio3/*.java Ejercicio4/*.java Ejercicio5/*.java
