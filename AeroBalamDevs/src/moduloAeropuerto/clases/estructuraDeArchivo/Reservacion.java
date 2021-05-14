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
public class Reservacion implements Serializable  {
    private int noPasaporte;
    private int codigoVuelo;
    private int numeroTarjeta;
    private int numeroAsiento;

    public Reservacion(int noPasaporte, int codigoVuelo, int numeroTarjeta, int numeroAsiento) {
        this.noPasaporte = noPasaporte;
        this.codigoVuelo = codigoVuelo;
        this.numeroTarjeta = numeroTarjeta;
        this.numeroAsiento = numeroAsiento;
    }

    public int getNoPasaporte() {
        return noPasaporte;
    }

    public void setNoPasaporte(int noPasaporte) {
        this.noPasaporte = noPasaporte;
    }

    public int getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(int codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }
    
    
}
