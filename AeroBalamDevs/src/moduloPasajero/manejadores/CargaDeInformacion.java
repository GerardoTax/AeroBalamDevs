/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloPasajero.manejadores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import moduloAeropuerto.archivosBinarios.EscritorDeAerolineaBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeAeropuertoBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDePasaporteBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeVueloBinarios;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;
import moduloAeropuerto.clases.estructuraDeArchivo.Pasaporte;
import moduloAeropuerto.clases.estructuraDeArchivo.Vuelo;
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
    private EscritorDeVueloBinarios escritorDeVueloBinarios;
    private ArrayList<Vuelo> lisvuelos;
    private Vector<String> vectoVuelo= new Vector<>();
    private EscritorDeAeropuertoBinarios escritorDeAeropuertoBinarios;
    private ArrayList<Aeropuerto> lisAeropuerto;
    private Vector<String> vectorCiudad= new Vector<>();
    private int indicePasaporte;
    
    private int estado;
    
    public CargaDeInformacion(ModuloPasajeros moduloPasajeros){
        this.moduloPasajeros=moduloPasajeros;
        this.EscritorDeAerolineaBinarios= new EscritorDeAerolineaBinarios();
        this.EscritorDePasaporteBinarios=new EscritorDePasaporteBinarios();
        this.escritorDeVueloBinarios=new EscritorDeVueloBinarios();
        this.escritorDeAeropuertoBinarios= new EscritorDeAeropuertoBinarios();
        
    }
    
    public void leerArchivos() {
        try {
            lisPasaporte=this.EscritorDePasaporteBinarios.leerPasaporte();
            lisAerolinea=this.EscritorDeAerolineaBinarios.leerAreolinea();
            lisvuelos= this.escritorDeVueloBinarios.leerVuelos();
            lisAeropuerto=this.escritorDeAeropuertoBinarios.leerAeropuertos();
            cargarAerolinea();
            cargarCiudades();
            
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
 
    public void cargarCiudades(){
         for(int i=0;i<this.lisAeropuerto.size();i++){
            vectorCiudad.add(this.lisAeropuerto.get(i).getCiudad());
            moduloPasajeros.getjComboBoxorigen().addItem(vectorCiudad.get(i));
            moduloPasajeros.getjComboBoxDestino().addItem(vectorCiudad.get(i));
        }
    }
    
        public void buscarvuelo(int numero){
            BuscarVuelo tmp= new BuscarVuelo(lisPasaporte,lisAerolinea,lisvuelos,lisAeropuerto,numero);
            tmp.verificarExistenciaPasaporte();
            tmp.ciudadesp();
        }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList<Pasaporte> getLisPasaporte() {
        leerArchivos();
        return lisPasaporte;
    }

    public void setLisPasaporte(ArrayList<Pasaporte> lisPasaporte) {
        this.lisPasaporte = lisPasaporte;
    }
     
   
}
