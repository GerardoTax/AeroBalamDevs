/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloPasajero.manejadores;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static moduloAeropuerto.Manejadores.ManejadorCargaDatos.con;
import moduloAeropuerto.archivosBinarios.EscritorDePasaporteBinarios;
import moduloAeropuerto.clases.ExcepcionVentana;
import moduloAeropuerto.clases.estructuraDeArchivo.Pasaporte;
import moduloAeropuerto.clases.estructuraDeArchivo.RenovacionPasaporte;
import moduloAeropuerto.clases.estructuraDeArchivo.Reservacion;
import moduloAeropuerto.clases.estructuraDeArchivo.Vuelo;
import moduloPasajero.Jframe.ModuloPasajeros;

/**
 *
 * @author dell
 */
public class ManejadorDeUsuario {
    private ModuloPasajeros moduloPasajeros;
    private EscritorDePasaporteBinarios escritorDePasaporteBinarios;
    
    
    public ManejadorDeUsuario(ModuloPasajeros moduloPasajeros){
        this.moduloPasajeros=moduloPasajeros;
        this.escritorDePasaporteBinarios=new EscritorDePasaporteBinarios();
    }
    
    public void validarCampoVacio(String campo,String tipoDato) throws ExcepcionVentana{
        if(campo.equals("")){
        throw new ExcepcionVentana("Error en el campo  "+tipoDato+ "  esta vacio");
        }
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
      public static LocalDate darFormatoAFecha(String fechaCadena){
        String[] fechaDividida=fechaCadena.split("/");
        int dia = Integer.valueOf(fechaDividida[0]);
        int mes = Integer.valueOf(fechaDividida[1]);
        int anio = Integer.valueOf(fechaDividida[2]); 
        return LocalDate.of(anio, mes, dia);
    }
      public void validarCampoPasaporte() throws ExcepcionVentana{
        validarCampoVacio(moduloPasajeros.getNoPasaporteTextField().getText(),"No Pasaporte");
        validarCampoVacio(moduloPasajeros.getFeNacimientoTextField3().getText(),"Fecha de nacimento");
        validarCampoVacio(moduloPasajeros.getNacionalidadTextField4().getText(),"Nacioalidad");
        validarCampoVacio(moduloPasajeros.getNombreTextField5().getText(),"Nombre");
        validarCampoVacio(moduloPasajeros.getApellidoTextField6().getText(),"Apellido");
        String estado= (String) moduloPasajeros.getEstadoComboBox1().getSelectedItem();
        validarCampoVacio(estado,"Sexo");
        validarCampoVacio(moduloPasajeros.getFeVencimientoTextField7().getText(),"Fecha de vencimiento");
        validarCampoVacio(moduloPasajeros.getFeEmisionTextField2().getText(),"Fecha de Emision");
        validarCampoVacio(moduloPasajeros.getPaisAcutalTextField8().getText(),"Pais acutal");
        validarCampoVacio(moduloPasajeros.getMillasTextField9().getText(),"Millas recoridas");
        int numero=convertir(moduloPasajeros.getNoPasaporteTextField().getText(),"No Pasaporte");
        convertir(moduloPasajeros.getMillasTextField9().getText()," Millas recoridas");
        if( numero<100000000 && numero>=10000000){}
        else {
             moduloPasajeros.getNoPasaporteTextField().setText("");
             throw new ExcepcionVentana("Error el pasaporte tine que contener 8 digitos");
        }
        darFormatoAFecha(moduloPasajeros.getFeNacimientoTextField3().getText());
        darFormatoAFecha(moduloPasajeros.getFeVencimientoTextField7().getText());
        darFormatoAFecha(moduloPasajeros.getFeEmisionTextField2().getText());
      }
      public void GuardarPasaporte() throws ExcepcionVentana{
        validarCampoPasaporte(); 
        Pasaporte nuevoPasaporte = construirPasaporte();
        JOptionPane.showMessageDialog(null, "Pasapor Guardado");
        //limpiar campos
        moduloPasajeros.getNoPasaporteTextField().setText("");
        moduloPasajeros.getFeNacimientoTextField3().setText("");
        moduloPasajeros.getNacionalidadTextField4().setText("");
        moduloPasajeros.getNombreTextField5().setText("");
        moduloPasajeros.getApellidoTextField6().setText("");
        moduloPasajeros.getFeVencimientoTextField7().setText("");
        moduloPasajeros.getFeEmisionTextField2().setText("");
        moduloPasajeros.getPaisAcutalTextField8().setText("");
        moduloPasajeros.getMillasTextField9().setText("");
        ArrayList<Pasaporte> lisPasaporte = new ArrayList<>();
        lisPasaporte.add(nuevoPasaporte);
         try {
            //guardar el Pasaporte en un archivo binario
            this.escritorDePasaporteBinarios.guardarPasaporte(lisPasaporte);
       } catch (IOException ex) {
            Logger.getLogger(ModuloPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public   Pasaporte construirPasaporte(){
         Pasaporte p=null;
         int numeroPasaporte=convertirint(moduloPasajeros.getNoPasaporteTextField().getText());
         LocalDate fechaNacimiento = darFormatoAFecha(moduloPasajeros.getFeNacimientoTextField3().getText());
         String nacionalidad= moduloPasajeros.getNacionalidadTextField4().getText();
         String estado=(String) moduloPasajeros.getEstadoComboBox1().getSelectedItem();
         String nombre=moduloPasajeros.getNombreTextField5().getText();
         String apellido=moduloPasajeros.getApellidoTextField6().getText();
         String sexo=(String) moduloPasajeros.getSexoComboBox2().getSelectedItem();
         LocalDate fechaVencimiento = darFormatoAFecha(moduloPasajeros.getFeVencimientoTextField7().getText());
         LocalDate fechaEmision = darFormatoAFecha(moduloPasajeros.getFeEmisionTextField2().getText());
         String paisAcutal=moduloPasajeros.getPaisAcutalTextField8().getText();
         int millas=convertirint(moduloPasajeros.getMillasTextField9().getText());
         p = new Pasaporte(numeroPasaporte,"  ",fechaNacimiento,nacionalidad,estado,nombre,apellido,sexo,fechaVencimiento,fechaEmision,paisAcutal,millas);
         return p;
    }
    
    //contructor para leer texto
    public static Pasaporte construirpasaporte(String[] campos) {
      Pasaporte p=null;
      p=new Pasaporte (convertirint(campos[0]),campos[1],darFormatoAFecha(campos[2]),campos[3],campos[4],campos[5],campos[6],campos[7],darFormatoAFecha(campos[8]),darFormatoAFecha(campos[9]),campos[10],convertirint(campos[11]));     
      return p;
    }
    
    public static int convertirint(String campo){
        int resultado=Integer.valueOf(campo);
        return resultado;
    }
    public void validarCamposBusquedaVuelos() throws ExcepcionVentana{
        validarCampoVacio(moduloPasajeros.getjTextField20().getText(),"No Pasaporte");
        validarCampoVacio(moduloPasajeros.getjTextField21().getText(),"Ciudad de Origen");
        validarCampoVacio(moduloPasajeros.getjTextField22().getText(),"Ciudad de Destino");
        validarCampoVacio(moduloPasajeros.getjTextField23().getText(),"Fecha de vuelo");
        int numero=convertir(moduloPasajeros.getjTextField20().getText(),"No Pasaporte");
        if(  numero<100000000 && numero>=10000000  ){}
        else{
        JOptionPane.showMessageDialog(null, "El pasaporte tiene que obtener 8 digitos");
            moduloPasajeros.getjTextField20().setText("");
        }
            
        darFormatoAFecha(moduloPasajeros.getjTextField23().getText());
        
        
    }
    
    public int realizarBusqueda() throws ExcepcionVentana{
         validarCamposBusquedaVuelos();
         int numero=convertir(moduloPasajeros.getjTextField20().getText(),"No Pasaporte");
        return numero;
    }
    
   public static Vuelo construirvuelos(String [] campos){
        Vuelo vuelo=null;
        vuelo=new Vuelo(convertirint(campos[0]),convertirint(campos[1]),campos[2],campos[3],convertirint(campos[4]),darFormatoAFecha(campos[5]));  
        return vuelo;
    
    }
   
   public static RenovacionPasaporte contruirRenovacion(String [] campos){
       
       RenovacionPasaporte renovacion= null;
       renovacion = new RenovacionPasaporte(convertirint(campos[0]),darFormatoAFecha(campos[1]));
       return renovacion;
   }
   
   public static Reservacion construirReservacion(String [] campos){
       Reservacion reservacion=null;
       reservacion=new Reservacion(convertirint(campos[0]),convertirint(campos[1]),convertirint(campos[2]),convertirint(campos[3]));
       return reservacion;
   
   }
}
