/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Administracion;

/**
 *
 * @author dell
 */
public class Avion {
    private String nombreAeroliena;
    private String nombreAeropuertoAcutal;
    private int codigoAvion;
    private int capasidadPasajeros;
    private int capasidadGasolina;
    private int consumoPormilla;
    private CrearAviones crearAviones;
    
    public Avion(CrearAviones crearAviones){
        this.crearAviones=crearAviones;
    
    }
    
    
}
