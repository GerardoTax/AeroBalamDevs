/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloPasajero;

/**
 *
 * @author dell
 */
public class Tarjeta {
    private int numeroTarjeta;
    private int dineroActual;
    private int codigoCVC;
    private int  pasaporte;
    
    public Tarjeta(int  pasaporte, int numeroTarjeta, int dineroActual, int codigoCVC){
        
        this.numeroTarjeta=numeroTarjeta;
        this.dineroActual=dineroActual;
        this.codigoCVC=codigoCVC;
        this.pasaporte=pasaporte;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public int getDineroActual() {
        return dineroActual;
    }

    public int getCodigoCVC() {
        return codigoCVC;
    }

   

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setDineroActual(int dineroActual) {
        this.dineroActual = dineroActual;
    }

    public void setCodigoCVC(int codigoCVC) {
        this.codigoCVC = codigoCVC;
    }

    
    
}