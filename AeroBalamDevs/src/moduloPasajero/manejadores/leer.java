/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloPasajero.manejadores;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import moduloAeropuerto.archivosBinarios.EscritorDePasaporteBinarios;
import moduloAeropuerto.clases.estructuraDeArchivo.Pasaporte;

/**
 *
 * @author dell
 */
public class leer {
    
    public void buscar(){
        File archivo= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/src/moduloAeropuerto/GuardarArhivosBinarios/ArchivosBinariosPasaporte/88888888");
        
        try{
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ios;
            
            while(fis.available()>0){
            
                ios=new ObjectInputStream(fis);
                Pasaporte pasaporte =(Pasaporte) ios.readObject();
                System.out.println(pasaporte);
            }
        }
        
        catch(Exception e){
            System.out.println("Error");
            e.printStackTrace();
        
        }
    }
}
