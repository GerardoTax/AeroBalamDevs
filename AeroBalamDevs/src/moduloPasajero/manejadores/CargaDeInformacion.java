/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloPasajero.manejadores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import moduloAeropuerto.archivosBinarios.EscritorDeAerolineaBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDePasaporteBinarios;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Pasaporte;
import moduloAeropuerto.enumm.Verificacion;
import moduloAeropuerto.jFrame.LoginAeropuerto;
import moduloPasajero.Jframe.ModuloPasajeros;

/**
 *
 * @author dell
 */
public class CargaDeInformacion {
    private EscritorDeAerolineaBinarios  EscritorDeAerolineaBinarios ;
    private ArrayList<Aerolinea> lisAerolinea;
    private Vector<String> vectorAerolinea= new Vector<>();
    private ModuloPasajeros moduloPasajeros;
    private EscritorDePasaporteBinarios EscritorDePasaporteBinarios;
    private ArrayList<Pasaporte> lisPasaporte;
    private int estado;
    
    public CargaDeInformacion(ModuloPasajeros moduloPasajeros){
        this.moduloPasajeros=moduloPasajeros;
        this.EscritorDeAerolineaBinarios= new EscritorDeAerolineaBinarios();
        this.EscritorDePasaporteBinarios=new EscritorDePasaporteBinarios();
        
    }
    
    public void leerAerolinea() {
        try {
            lisAerolinea=this.EscritorDeAerolineaBinarios.leerAreolinea();
            cargarAerolinea();
            //System.out.println(lisAerolinea.get(0).getNombreAerolinea());
        } catch (IOException ex) {
                 Logger.getLogger(LoginAeropuerto.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(LoginAeropuerto.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    public void cargarAerolinea() {
        for(int i=0;i<this.lisAerolinea.size();i++){
            vectorAerolinea.add(this.lisAerolinea.get(i).getNombreAeropuerto());
            this.moduloPasajeros.getjComboBoxAerolinea().addItem(vectorAerolinea.get(i)); 
        }
    }
    
    public void leerPasaporte(){
        try {
            this.lisPasaporte=this.EscritorDePasaporteBinarios.leerPasaporte();
        } catch (IOException ex) {
            Logger.getLogger(CargaDeInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaDeInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
     public void verificarExistenciaPasaporte(int nuemeroPasaporte){
          leerPasaporte();
        for(int i=0;i<this.lisPasaporte.size();i++){
            if(nuemeroPasaporte==this.lisPasaporte.get(i).getNoPasaporte()){
                    System.out.println("Existe");
                    System.out.println(lisPasaporte.get(i).getFechaEmision());
                    this.setEstado(1);
                    return;
            }
             
            this.setEstado(0);
             
        }
        if(this.getEstado()==0){
             JOptionPane.showMessageDialog(null,"EL pasaporte no Existe");
        }
             
    }
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList<Pasaporte> getLisPasaporte() {
        leerPasaporte();
        return lisPasaporte;
    }

    public void setLisPasaporte(ArrayList<Pasaporte> lisPasaporte) {
        this.lisPasaporte = lisPasaporte;
    }
     
   
}
