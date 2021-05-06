/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.archivosBinarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;


/**
 *
 * @author dell
 */
public class EscritorDeAeropuertoBinarios implements Serializable{
    
    
    
    
    
    public static final File  FILE_AEROPUERTO= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/src/moduloAeropuerto/GuardarArhivosBinarios/ArchivosBinarioAeropuertos");
    
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
    
}
