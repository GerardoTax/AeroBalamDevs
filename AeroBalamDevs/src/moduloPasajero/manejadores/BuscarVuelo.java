/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloPasajero.manejadores;

import moduloPasajero.Jframe.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;
import moduloAeropuerto.clases.estructuraDeArchivo.Pasaporte;
import moduloAeropuerto.clases.estructuraDeArchivo.Vuelo;

/**
 *
 * @author dell
 */
public class BuscarVuelo {
    
    private ArrayList<Pasaporte> lispasaporte;
    private ArrayList<Aeropuerto> lisAeropuerto;
    private ArrayList<Vuelo> lisvuelos;
    private ArrayList<Aerolinea> lisAeroliea;
    private int numeroPasaporte;
    private int estado;
    private String pais;
    
    public BuscarVuelo(ArrayList<Pasaporte> lispasaporte,ArrayList<Aerolinea> lisAeroliea,ArrayList<Vuelo> lisvuelos,ArrayList<Aeropuerto> lisAeropuerto, int numero){
        this.lispasaporte=lispasaporte;
        this.lisAeroliea=lisAeroliea;
        this.lisvuelos=lisvuelos;
        this.lisAeropuerto=lisAeropuerto;
        this.numeroPasaporte=numero;
    }
    
    public void verificarExistenciaPasaporte(){
        for(int i=0;i<lispasaporte.size();i++){
            if(numeroPasaporte==lispasaporte.get(i).getNoPasaporte()){
                System.out.println("Existe");
                this.pais=this.lispasaporte.get(i).getPaisActual();
                return;
            }
            this.setEstado(0);
        }
        if(this.getEstado()==0){
             JOptionPane.showMessageDialog(null,"EL pasaporte no Existe");   
        }   
        
    }
    
    public void ciudadesp(){
        for(int i=0;i<this.lisAeropuerto.size();i++){
            
            if(this.lisAeropuerto.get(i).getPais().equals(this.pais)){
                System.out.println(this.pais+"       "+lisAeropuerto.get(i).getCiudad());
            }
        }
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
