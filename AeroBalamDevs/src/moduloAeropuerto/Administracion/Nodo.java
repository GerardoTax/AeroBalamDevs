/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Administracion;

/**
 *
 * @author jpmazate
 */
import java.io.Serializable;

/**
 *
 * @author jpmazate
 * @param <T>
 */
public class Nodo implements Serializable {
    
    private  Asientos dato;
    private Nodo siguiente;

    public Nodo(Asientos dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Nodo(Asientos dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Asientos getDato() {
        return dato;
    }

    public void setDato(Asientos dato) {
        this.dato = dato;
    }

   

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
   

    
    
 
}