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
public class RenovacionPasaporte implements Serializable  {
 
    private int noPasaporte;
    private LocalDate fechaNueva;

    public RenovacionPasaporte(int noPasaporte, LocalDate fechaNueva) {
        this.noPasaporte = noPasaporte;
        this.fechaNueva = fechaNueva;
    }

    public int getNoPasaporte() {
        return noPasaporte;
    }

    public void setNoPasaporte(int noPasaporte) {
        this.noPasaporte = noPasaporte;
    }

    public LocalDate getFechaNueva() {
        return fechaNueva;
    }

    public void setFechaNueva(LocalDate fechaNueva) {
        this.fechaNueva = fechaNueva;
    }
    
}
