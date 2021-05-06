/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Manejadores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import moduloAeropuerto.archivosBinarios.EscritorDeAerolineaBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeAeropuertoBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeAvionesBinarios;
import moduloAeropuerto.clases.ExcepcionVentana;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;
import moduloAeropuerto.clases.estructuraDeArchivo.Aviones;
import moduloAeropuerto.jFrame.FrameDatos;
import moduloPasajero.Jframe.JframeTarjeta;
import moduloPasajero.Jframe.ModuloPasajeros;
import moduloPasajero.clases.Pasaporte;


/**
 *
 * @author dell
 */
public class ManejadorCargaDatos {
    private FrameDatos frameDatos;
    private EscritorDeAeropuertoBinarios escritorDeAeropuertoBinarios;
    private EscritorDeAerolineaBinarios escritorDeAerolineaBinarios;
    private EscritorDeAvionesBinarios escritorDeAvionesBinarios;

    public ManejadorCargaDatos(FrameDatos frameDatos) {
       this.frameDatos=frameDatos;
       this.escritorDeAeropuertoBinarios= new EscritorDeAeropuertoBinarios();
       this.escritorDeAerolineaBinarios=new EscritorDeAerolineaBinarios();
       this.escritorDeAvionesBinarios=new EscritorDeAvionesBinarios();
    }
    
    public void validarCamposVacios(String campo, String tipoDato) throws ExcepcionVentana{
        if (campo.equals("")){
            throw new ExcepcionVentana("Error en el campo  "+tipoDato+ "  esta vacio");
        }
    
    }
   public void guardarAeropuerto() throws ExcepcionVentana{
       ValidarAeropuerto();
       String nombre=frameDatos.getNameAeropuerto().getText() ;
       String ciudad=frameDatos.getCiudad().getText();
       String pais=frameDatos.getPais().getText();
       String campos[] = {nombre, ciudad, pais};
      
       //creamos nuestro aeropuerto  pasando el vector campos
       Aeropuerto nuevoaeropuerto = construirAeropuerto(campos);
       JOptionPane.showMessageDialog(null, "Aeropuerto Guardado");
       limbiarCampos();
       ArrayList<Aeropuerto> lisaeropuerto = new ArrayList<>();
       lisaeropuerto.add(nuevoaeropuerto);
       try {
            //guardar el Pasaporte en un archivo binario
            this.escritorDeAeropuertoBinarios.guardarAeropuerto(lisaeropuerto);
        } catch (IOException ex) {
            Logger.getLogger(ModuloPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void ValidarAeropuerto() throws ExcepcionVentana {
       //comprovar si el compo esta vacio
       validarCamposVacios(frameDatos.getNameAeropuerto().getText(),"Nombre de Aerolinea");
       validarCamposVacios(frameDatos.getCiudad().getText(),"Nombre de Ciudad");
       validarCamposVacios(frameDatos.getPais().getText(),"Nombre de Pais ");
   }
   
   public static Aeropuerto construirAeropuerto(String[] campos) {
       //vamos a contruir un Aerpuerto y retornar Aeropuerto
        Aeropuerto aeropuerto=null;
        aeropuerto=new Aeropuerto(campos[0],campos[1],campos[0]);   
        return aeropuerto ;
    }
   
    public void limbiarCampos(){
        frameDatos.getNameAeropuerto().setText("");
        frameDatos.getCiudad().setText("");
        frameDatos.getPais().setText("");
    }
    
    
    
    public static Aerolinea construirAerolinea(String [] campos){
        Aerolinea aerolinea=null;
        aerolinea=new Aerolinea(campos[0],campos[1]);   
        return aerolinea;
    
    }
    public void guardarAerolinea() throws ExcepcionVentana{
        ValidarAerlinea();
        String nombreAeropuerto=frameDatos.getNombreAeropuerto().getText();
        String nombreAerolinea=frameDatos.getNombreAerolinea().getText();
         String campos[] = {nombreAeropuerto, nombreAeropuerto};
      
       //creamos nuestro aerolinea  pasando el vector campos
       Aerolinea nuevaAerolinea = construirAerolinea(campos);
       JOptionPane.showMessageDialog(null, "Aerolinea guardada Guardado");
        frameDatos.getNombreAeropuerto().setText("");
        frameDatos.getNombreAerolinea().setText("");
       ArrayList<Aerolinea> lisaerolinea = new ArrayList<>();
       lisaerolinea.add(nuevaAerolinea);
       try {
            //guardar el Pasaporte en un archivo binario
            this.escritorDeAerolineaBinarios.guardarAerolinea(lisaerolinea);
        } catch (IOException ex) {
            Logger.getLogger(ModuloPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    public void ValidarAerlinea() throws ExcepcionVentana{
       validarCamposVacios(frameDatos.getNombreAeropuerto().getText(),"Aeropuerto");
       validarCamposVacios(frameDatos.getNombreAerolinea().getText(),"Aerolinea");
    }
    
    public void GuardarAviones() throws ExcepcionVentana{
        ValidarAviones();
        String aerolinea= frameDatos.getjTextField3().getText();
        String aeropuertoActual=frameDatos.getjTextField7().getText();
        String codigoAvion= frameDatos.getjTextField8().getText();
        String capasidadPasajeros=frameDatos.getjTextField9().getText();
        String capasidadGasolina=frameDatos.getjTextField10().getText();
        String consumomillas=frameDatos.getjTextField11().getText();
        String campos[] = {aerolinea, aeropuertoActual,codigoAvion,capasidadPasajeros,capasidadGasolina, consumomillas};
      
       //creamos nuestro aerolinea  pasando el vector campos
       Aviones nuevoAviones = construirAviones(campos);
       JOptionPane.showMessageDialog(null, "Aerolinea guardada Guardado");
        frameDatos.getjTextField3().setText("");
        frameDatos.getjTextField7().setText("");
        frameDatos.getjTextField8().setText("");
        frameDatos.getjTextField9().setText("");
        frameDatos.getjTextField10().setText("");
        frameDatos.getjTextField11().setText("");
       ArrayList<Aviones> lisaviones = new ArrayList<>();
       lisaviones.add(nuevoAviones);
       try {
            //guardar el Pasaporte en un archivo binario
            this.escritorDeAvionesBinarios.guardarAeropuerto(lisaviones);
        } catch (IOException ex) {
            Logger.getLogger(ModuloPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void ValidarAviones() throws ExcepcionVentana{
       validarCamposVacios(frameDatos.getjTextField3().getText(),"Aeropuerto");
       validarCamposVacios(frameDatos.getjTextField7().getText(),"Aeropuerto Actual");
       validarCamposVacios(frameDatos.getjTextField8().getText(),"Codigo Avion");
       validarCamposVacios(frameDatos.getjTextField9().getText(),"Capasidad Pasajeros");
       validarCamposVacios(frameDatos.getjTextField10().getText(),"Capasidad de Gasolina");
       validarCamposVacios(frameDatos.getjTextField11().getText(),"Consumo de millas");
       convertir(frameDatos.getjTextField8().getText(),"Codigo Avion");
       convertir(frameDatos.getjTextField9().getText(),"Capasidad Pasajeros");
       convertir(frameDatos.getjTextField10().getText(),"Capacidad de Gasolina");
       convertir(frameDatos.getjTextField11().getText(),"Consumo de millas");
 
    }
    
     public  int  convertir(String campo ,String tipoDato) throws ExcepcionVentana{
        try{
           int resultado=Integer.valueOf(campo);
           if(resultado<1){
               
            throw new ExcepcionVentana("Error en el campo  "+tipoDato+ " esta intentando ingresar un mumero negativo");
               
           } else {
           return resultado;
           }
       }catch(NumberFormatException e){
           
           throw new ExcepcionVentana("Error en el campo  "+tipoDato+ "  esta intentado ingresar una letra en ves de un numero");
           
       }
        
     }
      public static Aviones construirAviones(String [] campos){
        Aviones aviones=null;
        aviones=new Aviones(campos[0],campos[1],con(campos[2]),con(campos[3]),con(campos[4]),con(campos[5]));  
         
        return aviones;
    
    }
    public static int con(String campo){
        int resultado;
        resultado = Integer.valueOf(campo);
        return resultado;
        
    }
}

