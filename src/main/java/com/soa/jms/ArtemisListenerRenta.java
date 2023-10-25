/**
 * 
 */
package com.soa.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.soa.bussines.PeliculaBussines;
import com.soa.bussines.RentaBussines;
import com.soa.dto.Pelicula;
import com.soa.dto.Renta;
import com.soa.dto.Respuesta;

/**
 * 
 */
@Component // genera un objeto de la capa bussines
public class ArtemisListenerRenta {

    @Autowired // inyecta el objeto
    private RentaBussines business;

    @Autowired // inyecta el objeto
    public JmsSender sender;

    // nombre de la cola de micro sercvicos
    @Value("${renta.queue.name.out}")
    public String outQueueName;

    @JmsListener(destination = "${renta.queue.name.in}")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s", message));
        // convierte un gson en una objeto
        Gson gson = new Gson();
        Renta renta = gson.fromJson(message, Renta.class);
        Respuesta respuesta = business.add(renta);
        System.out.println("Resultado de la consulta" + respuesta);
        try {
            sender.sendMessage(respuesta.toString(), outQueueName);
            System.out.println(String.format("Mensaje enviado: %s", message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
