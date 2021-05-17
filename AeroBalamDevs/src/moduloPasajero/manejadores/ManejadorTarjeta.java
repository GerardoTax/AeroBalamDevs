/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloPasajero.manejadores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import moduloAeropuerto.archivosBinarios.EscritorDePasaporteBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeTarjetaBinarios;
import moduloAeropuerto.clases.ExcepcionVentana;
import moduloAeropuerto.clases.estructuraDeArchivo.Pasaporte;
import moduloAeropuerto.clases.estructuraDeArchivo.Tarjeta;
import moduloPasajero.Jframe.JframeTarjeta;
import moduloPasajero.Jframe.ModuloPasajeros;

/**
 *
 * @author dell
 */
public class ManejadorTarjeta {
    
    private JframeTarjeta  frameTarjeta;
    private EscritorDeTarjetaBinarios  EscritorDeTarjetaBinarios;
    private EscritorDePasaporteBinarios  escritorDePasaporteBinarios;
    private ArrayList<Pasaporte> lisPasaporte;
    
    public ManejadorTarjeta(JframeTarjeta  frameTarjeta){
        this.frameTarjeta=frameTarjeta;
        this.EscritorDeTarjetaBinarios=new EscritorDeTarjetaBinarios ();
        this.escritorDePasaporteBinarios= new EscritorDePasaporteBinarios();
    }
    
    public void ValidarCampoVacio(String campo, String tipo) throws ExcepcionVentana{
        if(campo.equals("")){
             throw new ExcepcionVentana("Error en el campo  "+tipo+ "  esta vacio");
        }
    }
     public  int  convertir(String campo ,String tipo) throws ExcepcionVentana{
        try{
            int resultado=Integer.valueOf(campo);
               if(resultado<1){
                     throw new ExcepcionVentana("Error en el campo  "+tipo+ " esta intentando ingresar un mumero negativo");  
                } 
               else {
                    return resultado;
                }
       }
        catch(NumberFormatException e){
           
           throw new ExcepcionVentana("Error en el campo  "+tipo+ "  esta intentado ingresar una letra en ves de un numero"); 
         }
        
     }
     public static int convertirInt(String campo){
         int numero=Integer.valueOf(campo);
         return numero;
    }
     
     public static Tarjeta construirTrajeta(String [] campos){
         Tarjeta tarjeta=null;
         tarjeta= new Tarjeta(convertirInt(campos[0]),convertirInt(campos[1]),convertirInt(campos[2]),convertirInt(campos[3]));
        return tarjeta;
     }
     public void validarcampoTarjeta() throws ExcepcionVentana{
         ValidarCampoVacio(frameTarjeta.getNoTarjetaTextField1().getText(),"No. Tarjeta");
         ValidarCampoVacio(frameTarjeta.getNoPasaporteTextField2().getText(),"No. Pasaporte");
         ValidarCampoVacio(frameTarjeta.getDineroTextField3().getText(),"Dienero");
         ValidarCampoVacio(frameTarjeta.getCodigoCVCTextField4().getText(),"No. Codigo");
       int tarjeta=  convertir(frameTarjeta.getNoTarjetaTextField1().getText(),"No. Tarjeta");
        int noPasa= convertir(frameTarjeta.getNoPasaporteTextField2().getText(),"No. Pasaporte");
         convertir(frameTarjeta.getDineroTextField3().getText(),"Dienero");
         int codigo=convertir(frameTarjeta.getCodigoCVCTextField4().getText(),"No. Codigo");
         if(codigo<1000 && codigo>=100){ }
         else {
             JOptionPane.showMessageDialog(null, "El codidgo tiene que tener 3 digitos");
             frameTarjeta.getCodigoCVCTextField4().setText("");
         }
         
        if( tarjeta<100000000 && tarjeta>=10000000){}
        else {
             frameTarjeta.getNoTarjetaTextField1().setText("");
             throw new ExcepcionVentana("Error tiene que tener 8 digitos la tarfeta");
        }
          if( noPasa<100000000 && noPasa>=10000000){
              verificarPasaporteExiste(noPasa);
          }
        else {
             frameTarjeta.getNoPasaporteTextField2().setText("");
             throw new ExcepcionVentana("Error no existe este Pasaporte");
        }
        
        
          
         
         
     }
   
     public Tarjeta construirTarjeta() throws ExcepcionVentana{
         Tarjeta tarjeta=null;
        int noTarjeta= convertir(frameTarjeta.getNoTarjetaTextField1().getText(),"No. Tarjeta");
        int noPasaporte =convertir(frameTarjeta.getNoPasaporteTextField2().getText(),"No. Pasaporte");
        int Dinero=convertir(frameTarjeta.getDineroTextField3().getText(),"Dienero");
        int codigo=convertir(frameTarjeta.getCodigoCVCTextField4().getText(),"No. Codigo");
        tarjeta=new Tarjeta(noTarjeta,noPasaporte,Dinero,codigo);
        return tarjeta;
     
     }
     
       
     public void guardarTarjeta() throws ExcepcionVentana{
         cargarPAsaorte();
         validarcampoTarjeta();
         Tarjeta nuevaTarjeta=construirTarjeta();
        // JOptionPane.showMessageDialog(null, "Tarjeta Guardado");
         ArrayList<Tarjeta> lisTarjeta = new ArrayList<>();
        lisTarjeta.add(nuevaTarjeta);
         try {
            //guardar el Tarjeta en un archivo binario
            this.EscritorDeTarjetaBinarios.guardarAeropuerto(lisTarjeta);
       } catch (IOException ex) {
            Logger.getLogger(ModuloPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     public void cargarPAsaorte(){
        try {
          this.lisPasaporte=  this.escritorDePasaporteBinarios.leerPasaporte();
        } catch (IOException ex) {
            Logger.getLogger(ManejadorTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void verificarPasaporteExiste(int campo) throws ExcepcionVentana{
         for(int i=0;i<this.lisPasaporte.size();i++){
         
             if(this.lisPasaporte.get(i).getNoPasaporte()==campo){
                System.out.println(lisPasaporte.get(i).getContrasella());
                int contrasena = (int)(Math.random()*(50000-1000+1)+1000);
                String cont= String.valueOf(contrasena);
                lisPasaporte.get(i).setContrasella(cont);
                 try {
                     this.escritorDePasaporteBinarios.guardarPasaporte(lisPasaporte);
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                 }
                 
                JOptionPane.showMessageDialog(null, "su contraseña es: "+contrasena);
                    ModuloPasajeros tmp=new ModuloPasajeros();
                    tmp.setVisible(true);
                    frameTarjeta.dispose();
                  
             }
            
         }
     }
}
