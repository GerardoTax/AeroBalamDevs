/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.clases.estructuraDeArchivo;

import java.io.Serializable;
import moduloAeropuerto.jFrame.Avion;

/**
 *
 * @author dell
 */
public class Aviones  implements Serializable{
    
    private int codigoAvion;
    private String nombreAerolinea;
    private String nombreAeropuerto;
    private int capacidadPasajeros;
    private int capacidadGasolina;
    private int consumoPorMillas;
    private int filas;
    private int columnas;
   
    
    public Aviones(String nombreAerolinea, String nombreAeropuerto,int codigoAvion, int capacidadPasajeros ,int capacidadGasolina, int consumoPorMillas, int filas,int columnas) {
        this.nombreAerolinea=nombreAerolinea;
        this.nombreAeropuerto=nombreAeropuerto;
        this.codigoAvion=codigoAvion;
        this.capacidadPasajeros=capacidadPasajeros;
        this.capacidadGasolina=capacidadGasolina;
        this.consumoPorMillas=consumoPorMillas;
        this.filas=filas;
        this.columnas=columnas;
    }

    public int getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(int codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getCapacidadGasolina() {
        return capacidadGasolina;
    }

    public void setCapacidadGasolina(int capacidadGasolina) {
        this.capacidadGasolina = capacidadGasolina;
    }

    public int getConsumoPorMillas() {
        return consumoPorMillas;
    }

    public void setConsumoPorMillas(int consumoPorMillas) {
        this.consumoPorMillas = consumoPorMillas;
    }

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    public String getNombreAeropuerto() {
        return nombreAeropuerto;
    }

    public void setNombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
   

}
