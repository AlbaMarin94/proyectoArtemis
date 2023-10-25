/**
 * 
 */
package com.soa.dto;

import com.google.gson.Gson;

/**
 * 
 */
public class Request {

    private String operacion;

    private Cliente cliente;

    /**
     * @return the nombreCompleto
     */
    @Override // sobre escritura
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    /**
     * @return the operacion
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
