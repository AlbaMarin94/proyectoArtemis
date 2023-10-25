/**
 * 
 */
package com.soa.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.soa.dto.Cliente;
import com.soa.dto.Renta;

/**
 * capa de acceso a datos 
 */
@Repository
@Component
public class RentaDao {
    
    @Autowired
    private JdbcTemplate  jdbcTemplate;
    
    // secuencia sql para alta  inser into 
    // firma para un alta , usuarios a insertar 
    
    public void insertar(Renta renta) {
        
        jdbcTemplate.execute("insert into renta(numero_tarjeta, tiempo, pelicular, id_cliente) values ('"
                + renta.getNumeroTarjeta() + "','" + renta.getTiempo() + "','" + renta.getPelicula() 
                + "','" + renta.getIdCliente() + "')" );  
        
    }

}
