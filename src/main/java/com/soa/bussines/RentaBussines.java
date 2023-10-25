/**
 * 
 */
package com.soa.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.ClienteDao;
import com.soa.dao.PeliculaDao;
import com.soa.dao.RentaDao;
import com.soa.dto.Renta;
import com.soa.dto.Respuesta;

/**
 * 
 */
@Component
public class RentaBussines {

    @Autowired
    private PeliculaDao peliculaDao;

    @Autowired
    private RentaDao rentaDao;

    public Respuesta add(Renta renta) {
        Respuesta respuesta = new Respuesta();
        try {
            Respuesta respuesta2 = peliculaDao.consultarPelicula(renta.getPelicula());

            if (respuesta2.getPelicula() != null) {
                // se valida el tiempo de la pelicula
                if (respuesta2.getPelicula().getTiempo() == renta.getTiempo()) {
                    // se puede alquilar
                    rentaDao.insertar(renta);
                    respuesta.setMessage("ok");

                } else if (respuesta2.getPelicula().getTiempo() < renta.getTiempo()) {
                    respuesta.setMessage("Error, se esta pagando mas de lo que vale la pelicula");

                } else if (respuesta2.getPelicula().getTiempo() > renta.getTiempo()) {
                    respuesta.setMessage("Error, la pelicula vale mas de lo que se esta pagando, vale :" +
                            respuesta2.getPelicula().getTiempo());
                }
            } else {
                respuesta.setMessage(respuesta2.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error en BD al insertar ");
        }
        return respuesta;
    }

}
