/**
 * 
 */
package com.soa.dto;

import java.util.List;

import com.google.gson.Gson;

/**
 * 
 */
/**
 * 
 */
public class Respuesta  {
 
     private String message;
     
     private List<Cliente> usuarios;
     
     private boolean existe;
     
     private Pelicula pelicula;
     
    /**
     * @return the nombreCompleto
     */
    @Override // sobre escritura 
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json ; 
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the usuarios
     */
    public List<Cliente> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Cliente> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the existe
     */
    public boolean isExiste() {
        return existe;
    }

    /**
     * @param existe the existe to set
     */
    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    /**
     * @return the pelicula
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * @param pelicula the pelicula to set
     */
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }



}
