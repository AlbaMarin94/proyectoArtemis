/**
 * 
 */
package com.soa.bussines;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dto.Cliente;
import com.soa.dao.ClienteDao;
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
//            respuesta.setMessage(e.getMessage());
//            if (e instanceof SQLException) {
//                respuesta.setMessage("Error " );   
//            }
        }
        return respuesta;
    }

    /**
     * consulta usuarios opor el login
     * 
     * @param usuario
     * @return
     */
    public Respuesta qry(Cliente usuario) {
        Respuesta respuesta = new Respuesta();
//        try {
//            List<Cliente> usuarioList = usuariosDao.qry(usuario);
//            respuesta.setMessage("ok");
//            respuesta.setUsuarios(usuarioList);
//        } catch (Exception e) {
//            e.printStackTrace();
//            respuesta.setMessage("Error en BD al consultar login: " +
//                    usuario.getLogin());
//        }
        return respuesta;
    }


}
