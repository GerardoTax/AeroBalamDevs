/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Administracion;

import java.io.Serializable;
import javax.swing.JTextArea;
import moduloAeropuerto.jFrame.VerAsientos;

/**
 *
 * @author jpmazate
 * @param <T>
 */
public class Lista implements Serializable {
    
    private Nodo inicio;
    private Nodo fin;
    private VerAsientos verAsientos;

    public Lista(VerAsientos verAsientos) {
        this.inicio = null;
        this.fin = null;
        this.verAsientos=verAsientos;
    }
    
    public void agregarAlInicio(Asientos dato){
        inicio = new Nodo(dato, inicio);

        if (fin == null) {
            fin = inicio;
        }
    }
    
    public void mostrarLista(){
        Nodo auxiliar = inicio;
        while (auxiliar != null) { 
            // es tonde lo agrega al text area
             this.verAsientos.getjPanel1().add(auxiliar.getDato());
             this.verAsientos.getjPanel1().updateUI();  
             auxiliar = auxiliar.getSiguiente();
        }
        
    }
    
    
    public boolean estaVacia(){
        return inicio == null;
    }
    
    public void agregarAlFinal(Asientos dato){
        //si el nodo esta vacio  
        if (!estaVacia()) {
            fin.setSiguiente( new Nodo(dato));
            fin = fin.getSiguiente();
            //si la lista esta vacia 
        } else {
            Nodo nuevoNodo = new Nodo(dato);
            inicio = nuevoNodo;
            fin = nuevoNodo;
        }
    }
    
    public void mostrarPrimerDato(){
        this.verAsientos.getjPanel1().add(inicio.getDato());
        this.verAsientos.getjPanel1().updateUI();  
    }
    
    public void mostrarUltimoDato(){
       
       this.verAsientos.getjPanel1().add(fin.getDato());
       this.verAsientos.getjPanel1().updateUI();  
    }


    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }
    
    
    
    
}