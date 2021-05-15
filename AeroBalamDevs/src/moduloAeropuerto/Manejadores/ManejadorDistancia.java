/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Manejadores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import moduloAeropuerto.archivosBinarios.EscritorDeAeropuertoBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeDistanciaBinarios;
import moduloAeropuerto.clases.ExcepcionVentana;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;
import moduloAeropuerto.clases.estructuraDeArchivo.Distancia;
import moduloAeropuerto.jFrame.Distancias;

/**
 *
 * @author dell
 */
public class ManejadorDistancia {
    private Distancias distancia;
    private EscritorDeAeropuertoBinarios  escritorDeAeropuertoBinarios;
    private ArrayList<Aeropuerto> listaAeropuerto;
    private Vector<String> vectorAeropuerto = new Vector<>();
    private EscritorDeDistanciaBinarios  escritorDeDistanciaBinarios;
    
    public ManejadorDistancia(Distancias distancia){
        this.distancia=distancia;
        this.escritorDeAeropuertoBinarios= new EscritorDeAeropuertoBinarios();
        this.escritorDeDistanciaBinarios = new EscritorDeDistanciaBinarios();
    }
    
    public void cargarInformacion(){
        try {
           this.listaAeropuerto= this.escritorDeAeropuertoBinarios.leerAeropuertos();
        } catch (IOException ex) {
            Logger.getLogger(ManejadorDistancia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorDistancia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ingresarDatosComobox(){
            cargarInformacion();
            
        for(int i=0;i<this.listaAeropuerto.size();i++){
            vectorAeropuerto.add(listaAeropuerto.get(i).getNombreAeropuerto());
            distancia.getjComboBox1().addItem(vectorAeropuerto.get(i));
            distancia.getjComboBox2().addItem(vectorAeropuerto.get(i));
            
        }
 
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

     
    public void guardarDistancia() throws ExcepcionVentana{
        convertir(distancia.getjTextField1().getText(),"Millas");
        Distancia nuevoDistancia = costruirDistancia();
        JOptionPane.showMessageDialog(null, "Distancia Guardada");
        distancia.getjTextField1().setText("");
     
        ArrayList<Distancia> lisdistancia = new ArrayList<>();
        lisdistancia.add(nuevoDistancia);
        try {
           this.escritorDeDistanciaBinarios.guardarDistancia(lisdistancia);
        } catch (IOException ex) {
            Logger.getLogger(ManejadorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Distancia costruirDistancia(){
         Distancia nuevoDistancia=null;
         String origen= (String) distancia.getjComboBox1().getSelectedItem();
         String destino= (String) distancia.getjComboBox2().getSelectedItem();
         int millas=Integer.valueOf(distancia.getjTextField1().getText());
         nuevoDistancia=new Distancia(origen,destino,millas);
         return  nuevoDistancia;
     }
    
    
}
