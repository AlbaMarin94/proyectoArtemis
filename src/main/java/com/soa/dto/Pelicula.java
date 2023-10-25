package com.soa.dto;

import com.google.gson.Gson;

public class Pelicula {

    private String nombre;
    private Integer id;
    private Integer tiempo;
    
    @Override // sobre escritura
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;

    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the tiempo
     */
    public Integer getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }
}
