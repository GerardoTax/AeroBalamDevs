/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloPasajero.manejadores;

import java.time.LocalDate;
import moduloPasajero.Jframe.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import moduloAeropuerto.clases.ExcepcionVentana;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;
import moduloAeropuerto.clases.estructuraDeArchivo.Aviones;
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
    private ArrayList<Aviones> lisAviones;
    private int numeroPasaporte;
    private int estado;
    private String pais;
    private String nombreAerpuertoOrigen;
    private String nombreAerpuertoDestino;
    private String ciudadcOrigen;
    private String ciudadDestino;
    private String origen;
    private Vector<String> vectorCiudad= new Vector<>();
    private LocalDate fechaSalida;
    private int codigoAvion;
    private String nombreAerolinea;
    private String aerolinea;
    
    public BuscarVuelo(ArrayList<Pasaporte> lispasaporte,ArrayList<Aviones> lisAviones,ArrayList<Vuelo> lisvuelos,ArrayList<Aeropuerto> lisAeropuerto, int numero,String origen,String destino,LocalDate fecha, String aerolinea){
        this.lispasaporte=lispasaporte;
        this.lisAviones=lisAviones;
        this.lisvuelos=lisvuelos;
        this.lisAeropuerto=lisAeropuerto;
        this.numeroPasaporte=numero;
        this.ciudadcOrigen=origen;
        this.ciudadDestino=destino;
        this.fechaSalida=fecha;
        this.aerolinea=aerolinea;
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
    
    public void ciudaOrigen(){
        for(int i=0;i<this.lisAeropuerto.size();i++){
            if(this.lisAeropuerto.get(i).getPais().equals(this.pais)){
               System.out.println(this.pais+"       "+lisAeropuerto.get(i).getCiudad()+"  "+lisAeropuerto.get(i).getNombreAeropuerto());
                this.vectorCiudad.add(lisAeropuerto.get(i).getCiudad());
                
            }
        }
    }
    public void verificar()throws ExcepcionVentana{
        for(int i=0;i<vectorCiudad.size();i++){
             try{
                if(vectorCiudad.get(i).equals(this.ciudadcOrigen)){
                    //JOptionPane.showMessageDialog(null, "Bien");
                    origen=vectorCiudad.get(i);
                    return;
                }
                else throw new ExcepcionVentana("Error en ciudad de origen "); 
             }catch(NumberFormatException e){
                 throw new ExcepcionVentana("Error en ciudad de origen"); 
         }
        }
  
    }
    
    public void buscarAeropuertoOrigen(){
        for(int i=0;i<this.lisAeropuerto.size();i++){
            
            if(lisAeropuerto.get(i).getCiudad().equals(origen)){
                this.nombreAerpuertoOrigen=lisAeropuerto.get(i).getNombreAeropuerto();
              System.out.println(" Orige de aeropuerto"+lisAeropuerto.get(i).getNombreAeropuerto());
            }
        }
    
    } 
       public void buscarAeropuertoDestino(){
            for(int i=0;i<this.lisAeropuerto.size();i++){
                if(lisAeropuerto.get(i).getCiudad().equals(this.ciudadDestino)){
                    this.nombreAerpuertoDestino=lisAeropuerto.get(i).getNombreAeropuerto();
                    System.out.println(" destino "+lisAeropuerto.get(i).getNombreAeropuerto());
                 }
            }
       }
       
    public void buscarCodigoVuelo() throws ExcepcionVentana{
        for(int i=0;i<this.lisvuelos.size();i++){
              
            try{    
                if(lisvuelos.get(i).getNombreAerpurtoOrigen().equals(nombreAerpuertoOrigen)){
                   if(lisvuelos.get(i).getNombreAerpurtoDestino().equals(nombreAerpuertoDestino)){
                       if(lisvuelos.get(i).getFechaDeSalida().equals(fechaSalida)){
                            
                            codigoAvion=lisvuelos.get(i).getCodigoAvion();
                            System.out.println(lisvuelos.get(i).getCodigoAvion());
                            
                       }
                      else throw new ExcepcionVentana("No existe Vuelo Para esa fecha");
                           //JOptionPane.showMessageDialog(null,"No Existe vuelo para esa fecha");
                   
                   }
                   else throw new ExcepcionVentana("No existe vuelo pra este Destino");
                       //JOptionPane.showMessageDialog(null,"No Existe vuelo para este Destino");
                   
                    return;
                }
                
                }catch(NumberFormatException e){
           
                throw new ExcepcionVentana("No existe vuelo para este origen"); 
            }
                
           
        }
    }     
       
       public void buscarAviones() throws ExcepcionVentana{
           for(int i=0;i<this.lisAviones.size();i++){
               
               if(lisAviones.get(i).getCodigoAvion()==this.codigoAvion){
                   this.nombreAerolinea=lisAviones.get(i).getNombreAerolinea();
                   System.out.println(lisAviones.get(i).getNombreAerolinea());
                   
                        buscarAerolinea();
               }
               
           }
           
       }
       public void buscarAerolinea()throws ExcepcionVentana{
          try{  
          if(this.nombreAerolinea.equals(this.aerolinea)){
              JOptionPane.showMessageDialog(null,"Feliz viaje");
              InformacionVuelo tmp= new InformacionVuelo(codigoAvion,nombreAerpuertoOrigen,nombreAerpuertoDestino);
              tmp.setVisible(true);
              return;
            }
          else throw new ExcepcionVentana("No existeel vuelo en esta aerolinea"); 
            }catch(NumberFormatException e){
           
                throw new ExcepcionVentana("No existeel vuelo en esta aerolinea"); 
            }
        
       }
            
    public String getNombreAerpuertoOrigen() {
        return nombreAerpuertoOrigen;
    }

    public void setNombreAerpuertoOrigen(String nombreAerpuertoOrigen) {
        this.nombreAerpuertoOrigen = nombreAerpuertoOrigen;
    }
    
  
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
