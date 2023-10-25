/**
 * 
 */
package com.soa.dto;

/**
 * 
 */
public class Renta {

    private int id;
    private String pelicula;
    private int tiempo;
    private Long idCliente;
    private String numeroTarjeta;
    /**
     * @return the numeroTarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    /**
     * @return the tiempo
     */
    public int getTiempo() {
        return tiempo;
    }
    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    /**
     * @return the pelicula
     */
    public String getPelicula() {
        return pelicula;
    }
    /**
     * @param pelicula the pelicula to set
     */
    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }
    /**
     * @return the idCliente
     */
    public Long getIdCliente() {
        return idCliente;
    }
    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
   
}
