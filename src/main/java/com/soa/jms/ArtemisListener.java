/**
 * 
 */
package com.soa.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.soa.bussines.ClienteBusiness;
import com.soa.dto.Respuesta;
import com.soa.dto.Cliente;

/**
 * crea los clientes 
 */
@Component // genera un objeto de la capa bussines a
public class ArtemisListener {

    @Autowired // inyecta el objeto l
    private ClienteBusiness business;

    @Autowired // inyecta el objeto b
    public JmsSender sender;

    // nombre de la cola de micro sercvicos a
    @Value("${queue.name.out}")
    public String outQueueName;

    @JmsListener(destination = "${queue.name.in}")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s", message));
        // convierte un gson en una objeto
        Gson gson = new Gson();
        Cliente usuarios = gson.fromJson(message, Cliente.class);
        System.out.println(usuarios);
        Respuesta respuesta = business.add(usuarios);
        System.out.println("Resultado de la consulta" + respuesta);
        try {
            sender.sendMessage(respuesta.toString(), outQueueName);
            System.out.println(String.format("Mensaje enviado: %s", message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
