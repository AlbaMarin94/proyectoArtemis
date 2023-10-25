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
 * 
 */
@Component  // genera un objeto de la capa bussines 
public class ArtemisListenerQuery {
    @Autowired  // inyecta el objeto 
    private ClienteBusiness business;
    
    @Autowired  // inyecta el objeto 
    public JmsSender sender;
    @Value("${qry.queue.name.out}")
    public String outQueueName;  //nombre de la cola de micro sercvicos 
    
    @JmsListener(destination = "${qry.queue.name.in}")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s",message));
        // convierte un gson en una objeto
        Gson gson = new Gson();
        Cliente usuario   = gson.fromJson(message, Cliente.class);
        System.out.println( usuario );
        Respuesta respuesta =  business.qry(usuario);
        System.out.println(respuesta);
        try {
            sender.sendMessage(respuesta.toString(), outQueueName);
            System.out.println(String.format("Mensaje enviado: %s",message));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
