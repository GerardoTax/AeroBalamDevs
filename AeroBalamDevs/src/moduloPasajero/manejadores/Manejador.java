/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloPasajero.manejadores;

import moduloAeropuerto.clases.ExcepcionVentana;

/**
 *
 * @author dell
 */
public class Manejador {
 
    
    public Manejador(){}
    
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
     
      public int convertirAnumero(String campo, String tipo) throws ExcepcionVentana{   
          validarCampoVacio(campo,tipo);
           int numero=convertir(campo,tipo);
          return numero;
        
        }
}
