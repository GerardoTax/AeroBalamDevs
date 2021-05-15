/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Manejadores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import moduloAeropuerto.archivosBinarios.EscritorDeAeropuertoBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeAvionesBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeVueloBinarios;
import moduloAeropuerto.clases.ExcepcionVentana;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;
import moduloAeropuerto.clases.estructuraDeArchivo.Aviones;
import moduloAeropuerto.clases.estructuraDeArchivo.Vuelo;
import moduloAeropuerto.jFrame.Vuelos;
import moduloPasajero.manejadores.ManejadorDeUsuario;

/**
 *
 * @author dell
 */
public class ManejadorVuelos {
    private Vuelos vuelo;
    private ManejadorDeUsuario majejadorUsuario;
    private EscritorDeVueloBinarios  escritorDeVueloBinarios ;
    private EscritorDeAeropuertoBinarios escritorDeAeropuertoBinarios;
    private EscritorDeAvionesBinarios  escritorDeAvionesBinarios;
    private Vector<String> vectorAeropuerto = new Vector<>();
    private ArrayList<Aeropuerto> listaAeropuerto;
    private Vector<String> vectorAviones = new Vector<>();
    private ArrayList<Aviones> listaAviones;
    public ManejadorVuelos(Vuelos vuelo){
        this.vuelo=vuelo;
        this.escritorDeVueloBinarios=new EscritorDeVueloBinarios ();
        this.escritorDeAeropuertoBinarios= new EscritorDeAeropuertoBinarios();
        this.escritorDeAvionesBinarios=new EscritorDeAvionesBinarios();
    }
    
    public void cargarIfomarmacion() {
        try {
          this.listaAeropuerto=this.escritorDeAeropuertoBinarios.leerAeropuertos();
          this.listaAviones=this.escritorDeAvionesBinarios.leerAvion();
          
        } catch (IOException ex) {
            Logger.getLogger(ManejadorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void ingresarDatosComobox(){
            cargarIfomarmacion();
            codigo();
        for(int i=0;i<this.listaAeropuerto.size();i++){
            vectorAeropuerto.add(listaAeropuerto.get(i).getNombreAeropuerto());
            vuelo.getjComboBoxOrigen().addItem(vectorAeropuerto.get(i));
            vuelo.getjComboBoxDestino().addItem(vectorAeropuerto.get(i));
        }
 
    }
    public void codigo(){
        for(int i=0; i<this.listaAviones.size();i++){
            vectorAviones.add(String.valueOf(this.listaAviones.get(i).getCodigoAvion()));
            vuelo.getjComboBoxCodigoAvion().addItem(this.vectorAviones.get(i));
        }
    }
  
    
    public static LocalDate darFormatoAFecha(String fechaCadena){
        String[] fechaDividida=fechaCadena.split("/");
        int dia = Integer.valueOf(fechaDividida[0]);
        int mes = Integer.valueOf(fechaDividida[1]);
        int anio = Integer.valueOf(fechaDividida[2]); 
        return LocalDate.of(anio, mes, dia);
    }
    
     public  int  convertir(String campo ,String tipoDato) throws ExcepcionVentana{
        try{
           int resultado=Integer.valueOf(campo);
           if(resultado<1){
            throw new ExcepcionVentana("Error en el campo  "+tipoDato+ " esta intentando ingresar un numero negativo");  
           } else {
           return resultado;
           }
       }catch(NumberFormatException e){
           
           throw new ExcepcionVentana("Error en el campo  "+tipoDato+ "  "); 
       }
        
     }

     public void validarcampo() throws ExcepcionVentana{
        convertir(vuelo.getjTextField1().getText(),"Codigo");
        convertir(vuelo.getjTextField2().getText(),"Precio");
        darFormatoAFecha(vuelo.getjTextField3().getText());
     }
     
     public void guardarVuelos() throws ExcepcionVentana{
         validarcampo();
       //creamos nuestro aerolinea  pasando el vector campos
       Vuelo nuevoVuelo = costruirVulo();
       JOptionPane.showMessageDialog(null, "Aerolinea  Guardado");
        vuelo.getjTextField1().setText("");
        vuelo.getjTextField2().setText("");
        vuelo.getjTextField3().setText("");
       ArrayList<Vuelo> lisvuelo = new ArrayList<>();
       lisvuelo.add(nuevoVuelo);
        try {
            this.escritorDeVueloBinarios.guardarVuelos(lisvuelo);
        } catch (IOException ex) {
            Logger.getLogger(ManejadorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
     public Vuelo costruirVulo(){
         Vuelo nuevoVuelo=null;
         int codigoVuelo=Integer.valueOf(vuelo.getjTextField1().getText());
         String codi= (String) vuelo.getjComboBoxCodigoAvion().getSelectedItem();
         int codigoAvion=Integer.valueOf(codi);
         String origen= (String) vuelo.getjComboBoxOrigen().getSelectedItem();
         String destino= (String) vuelo.getjComboBoxDestino().getSelectedItem();
         int precio=Integer.valueOf(vuelo.getjTextField2().getText());
         LocalDate fecha=darFormatoAFecha(vuelo.getjTextField3().getText());
         nuevoVuelo=new Vuelo(codigoVuelo,codigoAvion,origen,destino,precio,fecha);
        
         return  nuevoVuelo;
      
     }
     
       
    
         
}
   
