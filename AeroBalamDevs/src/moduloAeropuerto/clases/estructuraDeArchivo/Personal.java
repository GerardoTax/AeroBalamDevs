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
public class Personal implements Serializable{
    private String usuario;
    private int Contrasella;
    private String puesto;

    public Personal(String usuario, int Contrasella, String puesto) {
        this.usuario = usuario;
        this.Contrasella = Contrasella;
        this.puesto=puesto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getContrasella() {
        return Contrasella;
    }

    public void setContrasella(int Contrasella) {
        this.Contrasella = Contrasella;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
}
