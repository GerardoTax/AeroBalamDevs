/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import Jframe.JframeTarjeta;

/**
 *
 * @author dell
 */
public class ConstructorDeTarjeta {
    
    private JframeTarjeta jframeTarjeta;
    
    public ConstructorDeTarjeta(JframeTarjeta jframeTarjeta){
        this.jframeTarjeta=jframeTarjeta;
    }
    
     public  static int  convertir(String campo ,String tipoDato) throws ExcepcionModuloPasaporte{
        try{
           int resultado=Integer.valueOf(campo);
           if(resultado<1){
               
            throw new ExcepcionModuloPasaporte("Error en el campo  "+tipoDato+ " esta intentando ingresar un mumero negativo");
               
           } else {
           return resultado;
           }
       }catch(NumberFormatException e){
           
           throw new ExcepcionModuloPasaporte("Error en el campo  "+tipoDato+ "  esta intentado ingresar una letra en ves de un numero");
           
       }
        
     }
     private void validarCampoVacio(String campo, String tipoDato) throws ExcepcionModuloPasaporte{
     if (campo.equals("")){
        throw new ExcepcionModuloPasaporte("Error en el campo  "+tipoDato+ "  esta vacio");
    }
    }
    
     public void validarFormulario() throws ExcepcionModuloPasaporte{
         validarCampoVacio(jframeTarjeta.getNoPasaporteTextField2().getText(),"No Pasaporte");
         validarCampoVacio(jframeTarjeta.getNoTarjetaTextField1().getText(),"No Tarjeta");
         validarCampoVacio(jframeTarjeta.getDineroTextField3().getText(),"Dinero");
         validarCampoVacio(jframeTarjeta.getCodigoCVCTextField4().getText(),"Codigo CVC");
         int pasaporte = convertir(jframeTarjeta.getNoPasaporteTextField2().getText(),"No Pasaporte");
         convertir(jframeTarjeta.getNoTarjetaTextField1().getText(),"No Tarjeta");
         convertir(jframeTarjeta.getDineroTextField3().getText(),"Dinero");
         int codigoCVC=convertir(jframeTarjeta.getCodigoCVCTextField4().getText(),"Codigo CVC");
        if(codigoCVC>=100 && codigoCVC<1000 ){
        }
        else {
             jframeTarjeta.getCodigoCVCTextField4().setText("");
             throw new ExcepcionModuloPasaporte("Error CodivoCVC");
        }
        if(pasaporte>=10000000 && pasaporte<100000000){}
        else {
            jframeTarjeta.getNoPasaporteTextField2().setText("");
             throw new ExcepcionModuloPasaporte("Error Pasaporte");
        }
         
     }
     public void Guardar() throws ExcepcionModuloPasaporte{
         validarFormulario();
     }
}
