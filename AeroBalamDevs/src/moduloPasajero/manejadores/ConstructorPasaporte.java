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
import moduloAeropuerto.archivosBinarios.EscritorDePasaporteBinarios;
import moduloAeropuerto.clases.ExcepcionVentana;
import moduloAeropuerto.clases.estructuraDeArchivo.Pasaporte;
import moduloPasajero.Jframe.ModuloPasajeros;






/**
 *
 * @author dell
 */
public class ConstructorPasaporte {
    private ModuloPasajeros moduloPasajeros;
    private EscritorDePasaporteBinarios escritorDePasaporteBinarios;
    
    
    public ConstructorPasaporte(ModuloPasajeros moduloPasajeros){
        this.moduloPasajeros=moduloPasajeros;
        this.escritorDePasaporteBinarios=new EscritorDePasaporteBinarios ();
    }
    public  static int  convertir(String campo ,String tipoDato) throws ExcepcionVentana{
        try{
           int resultado=Integer.valueOf(campo);
           if(resultado<1){
               
            throw new ExcepcionVentana("Error en el campo  "+tipoDato+ " esta intentando meter un mumero negativo");
               
           } else {
           return resultado;
           }
       }catch(NumberFormatException e){
           
           throw new ExcepcionVentana("Error en el campo  "+tipoDato+ "  esta intentado meter una letra en ves de un numero");
           
       }
        
     }
    
     public static LocalDate darFormatoAFecha(String fechaCadena){
       String[] fechaDividida=fechaCadena.split("/");
        int dia = Integer.valueOf(fechaDividida[0]);
        int mes = Integer.valueOf(fechaDividida[1]);
        int anio = Integer.valueOf(fechaDividida[2]); 
        return LocalDate.of(anio, mes, dia);
        
       
    }
     
     public void validarFormulario() throws ExcepcionVentana {
           
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
             if(numero<=10000000){
             moduloPasajeros.getNoPasaporteTextField().setText("");
         throw new ExcepcionVentana("Error el pasaporte tine que contener 8 digitos");
             }
             darFormatoAFecha(moduloPasajeros.getFeNacimientoTextField3().getText());
             darFormatoAFecha(moduloPasajeros.getFeVencimientoTextField7().getText());
             darFormatoAFecha(moduloPasajeros.getFeEmisionTextField2().getText());
           
             
 
        }
     
    private void validarCampoVacio(String campo, String tipoDato) throws ExcepcionVentana {
     if (campo.equals("")){
        throw new ExcepcionVentana("Error en el campo  "+tipoDato+ "  esta vacio");
    }
    }
    public void guardarDatos() throws ExcepcionVentana{
        validarFormulario(); 
        Pasaporte nuevoPasaporte = cons();
        JOptionPane.showMessageDialog(null, "Pasapor Guardado");
        limpiarCampos();
        ArrayList<Pasaporte> lispasaporte = new ArrayList<>();
        lispasaporte.add(nuevoPasaporte);
         try {
            //guardar el Pasaporte en un archivo binario
            this.escritorDePasaporteBinarios.guardarPasaporte(lispasaporte);
        } catch (IOException ex) {
            Logger.getLogger(ModuloPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
 
  public static int convertirint(String campo){
      int resultado=Integer.valueOf(campo);
        return resultado;
  
  }
  public   Pasaporte cons(){
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
      p = new Pasaporte(numeroPasaporte," ",fechaNacimiento,nacionalidad,estado,nombre,apellido,sexo,fechaVencimiento,fechaEmision,paisAcutal,millas);
        return p;
  
  }
   public void limpiarCampos(){    
        moduloPasajeros.getNoPasaporteTextField().setText("");
        moduloPasajeros.getFeNacimientoTextField3().setText("");
        moduloPasajeros.getNacionalidadTextField4().setText("");
        moduloPasajeros.getNombreTextField5().setText("");
        moduloPasajeros.getApellidoTextField6().setText("");
        moduloPasajeros.getFeVencimientoTextField7().setText("");
        moduloPasajeros.getFeEmisionTextField2().setText("");
        moduloPasajeros.getPaisAcutalTextField8().setText("");
        moduloPasajeros.getMillasTextField9().setText("");
    }
   
   public static Pasaporte construirpasaporte(String[] campos) {
      Pasaporte p=null;
     p=new Pasaporte (convertirint(campos[0]),campos[1],darFormatoAFecha(campos[2]),campos[3],campos[4],campos[5],campos[6],campos[7],darFormatoAFecha(campos[8]),darFormatoAFecha(campos[9]),campos[10],convertirint(campos[11]));     
      return p;

  }
   
}