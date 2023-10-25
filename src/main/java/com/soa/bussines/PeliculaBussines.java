/**
 * 
 */
package com.soa.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.PeliculaDao;
import com.soa.dto.Pelicula;
import com.soa.dto.Respuesta;


/**
 * 
 */
@Component
public class PeliculaBussines {
    
    // objeto se acceso a los datos
    @Autowired
    private PeliculaDao peliculaDao ;
    
    public Respuesta add(Pelicula pelicula) {
        Respuesta respuesta = new Respuesta();
        // excepción, es una clase de las cuales se generan intancias,
        // las nochec y chec no nos obligan a verlas
        try {
            peliculaDao.insertar(pelicula);
            respuesta.setMessage("ok");
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error en BD al insertar la pelicula ");
        }
        return respuesta;
    }

    /**
     * consulta usuarios opor el login
     * 
     * @param usuario
     * @return
     */
    public Respuesta consultarPelicula(String nombre) {
        Respuesta respuesta = new Respuesta();
        try {
            Respuesta respuestapelicula = peliculaDao.consultarPelicula(nombre);
            
            if (respuestapelicula.getPelicula() != null && respuestapelicula.getPelicula().getId() != null){
                respuesta.setMessage("ok");
                respuesta.setPelicula(respuestapelicula.getPelicula());     
                respuesta.setExiste(true);
            }
            else {
                respuesta.setMessage("Pelicula no existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error en BD al consultar la pelicula con nombre: " +
                    nombre);
        }
        return respuesta;
    }

}
