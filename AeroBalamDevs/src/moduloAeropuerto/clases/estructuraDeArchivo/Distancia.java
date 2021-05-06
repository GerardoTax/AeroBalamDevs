/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.clases.estructuraDeArchivo;

import java.io.Serializable;

/**
 *
 * @author dell
 */
public class Distancia implements Serializable{
    private String nombreAeropuertoOrigen;
    private String nombreAeropuertoDestino;
    private int cantidadMillas;

    public Distancia(String nombreAeropuertoOrigen, String nombreAeropuertoDestino, int cantidadMillas) {
        this.nombreAeropuertoOrigen = nombreAeropuertoOrigen;
        this.nombreAeropuertoDestino = nombreAeropuertoDestino;
        this.cantidadMillas = cantidadMillas;
    }

    public String getNombreAeropuertoOrigen() {
        return nombreAeropuertoOrigen;
    }

    public void setNombreAeropuertoOrigen(String nombreAeropuertoOrigen) {
        this.nombreAeropuertoOrigen = nombreAeropuertoOrigen;
    }

    public String getNombreAeropuertoDestino() {
        return nombreAeropuertoDestino;
    }

    public void setNombreAeropuertoDestino(String nombreAeropuertoDestino) {
        this.nombreAeropuertoDestino = nombreAeropuertoDestino;
    }

    public int getCantidadMillas() {
        return cantidadMillas;
    }

    public void setCantidadMillas(int cantidadMillas) {
        this.cantidadMillas = cantidadMillas;
    }
    public void sumarmillasVuelo(int cantidad){
        this.cantidadMillas=this.cantidadMillas+cantidad;
    }
    
}
