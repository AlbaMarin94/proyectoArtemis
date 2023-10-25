/**
 * 
 */
package com.soa.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.ClienteDao;
import com.soa.dto.Cliente;
import com.soa.dto.Respuesta;


/**
 * 
 */
@Component
public class ClienteBusiness {
    
    // objeto se acceso a los datos
    @Autowired
    private ClienteDao usuariosDao;

    public Respuesta add(Cliente usuario) {
        Respuesta respuesta = new Respuesta();
        // excepción, es una clase de las cuales se generan intancias,
        // las nochec y chec no nos obligan a verlas
        try {
            usuariosDao.insertar(usuario);
            respuesta.setMessage("ok");
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error en BD al insertar ");
        }
        return respuesta;
    }

}
