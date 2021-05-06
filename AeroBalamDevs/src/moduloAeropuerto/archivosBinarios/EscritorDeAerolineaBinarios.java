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
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;


/**
 *
 * @author dell
 */
public class EscritorDeAerolineaBinarios implements Serializable{
    
   
    public static final File FILE_AEROLINEA = new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/src/moduloAeropuerto/GuardarArhivosBinarios/ArchivosBianriosAerolinea");
    
    public void guardarAerolinea(ArrayList<Aerolinea> lisAerolinea) throws IOException,FileNotFoundException{
         
        for (Aerolinea aerolineas : lisAerolinea) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_AEROLINEA+"/"+aerolineas.getNombreAeropuerto());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(aerolineas);
          salida.close();
        }
    }
    
}
