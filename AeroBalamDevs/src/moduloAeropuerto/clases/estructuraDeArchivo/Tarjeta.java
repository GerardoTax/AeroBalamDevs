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
public class Tarjeta implements Serializable {
    private int codigoTarjeta;
    private int noPasaporte;
    private double dineroActual;
    private int codigoCVC;

    public Tarjeta(int codigoTarjeta, int noPasaporte, double dineroActual, int codigoCVC) {
        this.codigoTarjeta = codigoTarjeta;
        this.noPasaporte = noPasaporte;
        this.dineroActual = dineroActual;
        this.codigoCVC = codigoCVC;
    }

    public int getCodigoTarjeta() {
        return codigoTarjeta;
    }

    public void setCodigoTarjeta(int codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }

    public int getNoPasaporte() {
        return noPasaporte;
    }

    public void setNoPasaporte(int noPasaporte) {
        this.noPasaporte = noPasaporte;
    }

    public double getDineroActual() {
        return dineroActual;
    }

    public void setDineroActual(double dineroActual) {
        this.dineroActual = dineroActual;
    }

    public int getCodigoCVC() {
        return codigoCVC;
    }

    public void setCodigoCVC(int codigoCVC) {
        this.codigoCVC = codigoCVC;
    }
     public void restardinero(double cantidad){
         this.dineroActual=this.dineroActual-cantidad;
     }
    
}
