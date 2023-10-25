/**
 * 
 */
package com.soa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.soa.dto.Cliente;

/**
 * capa de acceso a datos 
 */
@Repository
@Component
public class ClienteDao {
    
    @Autowired
    private JdbcTemplate  jdbcTemplate;
    
    // secuencia sql para alta  inser into 
    // firma para un alta , usuarios a insertar 
    
    public void insertar(Cliente cliente) {
        
        jdbcTemplate.execute("insert into cliente(nombre, numero_tarjeta, saldo) values ('"
                + cliente.getNombre() + "','" + cliente.getNumeroTarjeta() + "','" + cliente.getSaldo() + "')" );  
        
     
    }

    /**
     * consulta de usuarios basados en su login 
     * @param usuario ususario objeto qe tiene el login a consultar
     */
    public List<Cliente> qry(Cliente usuario) {
        
        // TODO Auto-generated method stub
        List<Cliente> resp = new ArrayList<>();
//        List<Map<String, Object>> list =
//        jdbcTemplate.queryForList("SELECT id, login, password "
//                + " from usuario where login = '"
//                + usuario.getLogin() +"' ");
//        
//        for (Map<String, Object> registro : list) {
//            System.out.println("usuario" + registro);
//            Cliente usr = new Cliente();
//            usuario.setId((Integer) registro.get("id"));
//            usuario.setLogin((String) registro.get("login"));
//            usuario.setPassword((String) registro.get("password"));
//            resp.add(usr);
//        }
        
        return resp;
    }

}
