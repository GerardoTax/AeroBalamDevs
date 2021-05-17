/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloPasajero.manejadores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import moduloAeropuerto.archivosBinarios.EscritorDeAerolineaBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeAeropuertoBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeAvionesBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDePasaporteBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeVueloBinarios;
import moduloAeropuerto.clases.ExcepcionVentana;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;
import moduloAeropuerto.clases.estructuraDeArchivo.Aviones;
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
    private EscritorDeAvionesBinarios escritorDeAvionesBinarios;
    private ArrayList<Aviones> lisAviones;
    
    
    public CargaDeInformacion(ModuloPasajeros moduloPasajeros){
        this.moduloPasajeros=moduloPasajeros;
        this.EscritorDeAerolineaBinarios= new EscritorDeAerolineaBinarios();
        this.EscritorDePasaporteBinarios=new EscritorDePasaporteBinarios();
        this.escritorDeVueloBinarios=new EscritorDeVueloBinarios();
        this.escritorDeAeropuertoBinarios= new EscritorDeAeropuertoBinarios();
        this.escritorDeAvionesBinarios = new EscritorDeAvionesBinarios();
        
    }
    
    public void leerArchivos() {
        try {
            lisPasaporte=this.EscritorDePasaporteBinarios.leerPasaporte();
            lisAerolinea=this.EscritorDeAerolineaBinarios.leerAreolinea();
            lisvuelos= this.escritorDeVueloBinarios.leerVuelos();
            lisAeropuerto=this.escritorDeAeropuertoBinarios.leerAeropuertos();
            lisAviones=this.escritorDeAvionesBinarios.leerAvion();
            
            cargarAerolinea();
            cargarCiudades();
            CargarFecha();
            
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
    
    public void CargarFecha(){
        for(int i=0; i<lisvuelos.size();i++){
            vectoVuelo.add(String.valueOf(lisvuelos.get(i).getFechaDeSalida()));
            this.moduloPasajeros.getjComboBoxfecha().addItem(this.vectoVuelo.get(i));
        }
    }
    
        public void buscarvuelo(int numero) throws ExcepcionVentana{
            String origen= (String) moduloPasajeros.getjComboBoxorigen().getSelectedItem();
            String destino= (String) moduloPasajeros.getjComboBoxDestino().getSelectedItem();
            String fecha= (String) moduloPasajeros.getjComboBoxfecha().getSelectedItem();
            LocalDate fechavuelo=darFormatoAFecha(fecha);
            String aerolinea= (String) moduloPasajeros.getjComboBoxAerolinea().getSelectedItem();
            
            BuscarVuelo tmp= new BuscarVuelo(lisPasaporte,lisAviones,lisvuelos,lisAeropuerto,numero,origen,destino,fechavuelo,aerolinea);
            tmp.verificarExistenciaPasaporte();
            tmp.ciudaOrigen();
            tmp.verificar();
            tmp.buscarAeropuertoOrigen();
            tmp.buscarAeropuertoDestino();
            tmp.buscarCodigoVuelo();
            tmp.buscarAviones();
            moduloPasajeros.dispose();
            
            
        }
        
        public static LocalDate darFormatoAFecha(String fechaCadena){
        String[] fechaDividida=fechaCadena.split("-");
        int anio = Integer.valueOf(fechaDividida[0]);
        int mes = Integer.valueOf(fechaDividida[1]);
        int dia = Integer.valueOf(fechaDividida[2]); 
        return LocalDate.of(anio, mes, dia);
    }

    public ArrayList<Pasaporte> getLisPasaporte() {
        leerArchivos();
        return lisPasaporte;
    }

    public void setLisPasaporte(ArrayList<Pasaporte> lisPasaporte) {
        this.lisPasaporte = lisPasaporte;
    }
     
   
}
