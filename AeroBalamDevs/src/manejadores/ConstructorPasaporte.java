/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import java.time.LocalDate;
import java.util.logging.Logger;
import moduloPasajero.Pasaporte;

/**
 *
 * @author dell
 */
public class ConstructorPasaporte {
    
    
    public static Pasaporte construirpasaporte(String[] campos) {
      Pasaporte p=null;
     p=new Pasaporte (convertir(campos[0]),campos[1],darFormatoAFecha(campos[2]),campos[3],campos[4],campos[5],campos[6],campos[7],darFormatoAFecha(campos[8]),darFormatoAFecha(campos[9]),campos[10],convertir(campos[11]));     
      return p;
  
  }
    public static int  convertir(String nopasaporte){
      
     int numeroPasaporte= Integer.valueOf(nopasaporte);
      return numeroPasaporte;
      
  
  }
     public static LocalDate darFormatoAFecha(String fechaCadena){
       String[] fechaDividida=fechaCadena.split("/");
        int dia = Integer.valueOf(fechaDividida[0]);
        int mes = Integer.valueOf(fechaDividida[1]);
        int anio = Integer.valueOf(fechaDividida[2]);
        return LocalDate.of(anio, mes, dia);
    }
     
     public void validarPasport() throws ExcepcionModuloPasaporte{
            validarCampoVacio("","a");
            }
     
    private void validarCampoVacio(String campo, String tipoDato) throws ExcepcionModuloPasaporte{
     if (campo.equals("")){
        throw new ExcepcionModuloPasaporte("Error en el campo  "+tipoDato+ "  esta vacio");
    }
    }
  
}