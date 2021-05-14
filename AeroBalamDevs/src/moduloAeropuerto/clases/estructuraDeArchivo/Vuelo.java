/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.clases.estructuraDeArchivo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author dell
 */
public class Vuelo implements Serializable{
    private int codigoVuelo;
    private int codigoAvion;
    private String nombreAerpurtoOrigen;
    private String nombreAerpurtoDestino;
    private int precioBoleto;
    private LocalDate fechaDeSalida;

    public Vuelo(int codigoVuelo, int codigoAvion, String  nombreAerpurtoOrigen, String nombreAerpurtoDestino, int precioBoleto, LocalDate fechaDeSalida) {
        this.codigoVuelo = codigoVuelo;
        this.codigoAvion = codigoAvion;
        this.nombreAerpurtoOrigen = nombreAerpurtoOrigen;
        this.nombreAerpurtoDestino = nombreAerpurtoDestino;
        this.precioBoleto = precioBoleto;
        this.fechaDeSalida = fechaDeSalida;
    }

    public int getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(int codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public int getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(int codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public String  getNombreAerpurtoOrigen() {
        return nombreAerpurtoOrigen;
    }

    public void setNombreAerpurtoOrigen(String nombreAerpurtoOrigen) {
        this.nombreAerpurtoOrigen = nombreAerpurtoOrigen;
    }

    public String getNombreAerpurtoDestino() {
        return nombreAerpurtoDestino;
    }

    public void setNombreAerpurtoDestino(String nombreAerpurtoDestino) {
        this.nombreAerpurtoDestino = nombreAerpurtoDestino;
    }

    public int getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(int precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public LocalDate getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(LocalDate fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }
    
    
}
