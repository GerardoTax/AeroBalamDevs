/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.archivosBinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;


/**
 *
 * @author dell
 */
public class EscritorDeAeropuertoBinarios implements Serializable{
    
    
    
    
    
    public static final File  FILE_AEROPUERTO= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/GuardarArhivosBinarios/ArchivosBinarioAeropuertos");
    
    public void guardarAeropuerto(ArrayList<Aeropuerto> lisAeropuerto) throws IOException,FileNotFoundException{
         
        for (Aeropuerto aeropuertos : lisAeropuerto) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_AEROPUERTO+"/"+aeropuertos.getNombreAeropuerto());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(aeropuertos);
          salida.close();
        }
    }
    public ArrayList<Aeropuerto> leerAeropuertos() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Aeropuerto> listaAeropuerto= new ArrayList<>();
        String[]  archivos=this.FILE_AEROPUERTO.list();
        ObjectInputStream lector;   
        System.out.println("Archivos:"+archivos.length+" ------Aeropuerto");
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(this.FILE_AEROPUERTO+"/"+archivo));
            Aeropuerto v =(Aeropuerto)lector.readObject();
             //System.out.println( "Pais  "+v.getCiudad());
            listaAeropuerto.add(v);
            lector.close();
        }
        return listaAeropuerto;
    }
}
