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
public class Aeropuerto implements Serializable{
    private String nombreAeropuerto;
    private String Ciudad;
    private String Pais;

    public Aeropuerto(String nombreAeropuerto, String Ciudad, String Pais) {
        this.nombreAeropuerto = nombreAeropuerto;
        this.Ciudad = Ciudad;
        this.Pais = Pais;
    }

    public String getNombreAeropuerto() {
        return nombreAeropuerto;
    }

    public void setNombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }
    
    
}
