/**
 * 
 */
package com.soa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.soa.dto.Cliente;
import com.soa.dto.Pelicula;
import com.soa.dto.Respuesta;

/**
 * capa de acceso a datos 
 */
@Repository
@Component
public class PeliculaDao {
    
    @Autowired
    private JdbcTemplate  jdbcTemplate;
    
    // secuencia sql para alta  inser into 
    // firma para un alta , usuarios a insertar 
    
    public void insertar(Pelicula peli) {
        
        jdbcTemplate.execute("insert into pelicula(nombre, tiempo) values ('"
                + peli.getNombre() + "','" + peli.getTiempo() + "')" );  
        
     
    }

    /**
     * consulta de usuarios basados en su login 
     * @param usuario ususario objeto qe tiene el login a consultar
     */
    public Respuesta consultarPelicula(String nombre) {
        
        // TODO Auto-generated method stub
        Respuesta respuesta = new Respuesta();
        respuesta.setMessage("OK");
        
        Pelicula pelicula = new Pelicula();
        List<Map<String, Object>>  peliculas = 
        jdbcTemplate.queryForList("SELECT id, nombre, tiempo "
                + " from pelicula where nombre = '"
                + nombre +"' ");
        
        if (peliculas.isEmpty()) {
            respuesta.setMessage("No existen peliculas con el nombre de :" + nombre);
        }else {
            for (Map<String, Object> registro : peliculas) {
                System.out.println("usuario" + registro);
                pelicula.setId((Integer) registro.get("id"));
                pelicula.setNombre((String) registro.get("nombre"));
                pelicula.setTiempo((Integer) registro.get("tiempo"));
            }
            respuesta.setPelicula(pelicula);
        }
        
        return respuesta;
    }

}
