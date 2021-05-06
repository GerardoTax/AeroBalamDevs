/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.clases.estructuraDeArchivo;

import moduloAeropuerto.jFrame.Avion;

/**
 *
 * @author dell
 */
public class Aviones extends Aerolinea{
    
    private int codigoAvion;
    //maximo 50 filas 
    //asiento asiento pasillo asiento asiento
    private int capacidadPasajeros;
    private int capacidadGasolina;
    private int consumoPorMillas;
    //private int filas;
    //private int columnas;
    
    public Aviones(String nombreAerolinea, String nombreAeropuerto,int codigoAvion, int capacidadPasajeros ,int capacidadGasolina, int consumoPorMillas) {
        super(nombreAerolinea, nombreAeropuerto);
        this.codigoAvion=codigoAvion;
        this.capacidadPasajeros=capacidadPasajeros;
        this.capacidadGasolina=capacidadGasolina;
        this.consumoPorMillas=consumoPorMillas;
        //this.filas=fila;
        //this.columnas=columna;
        
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

  
    
    
}
