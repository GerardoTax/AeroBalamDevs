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
import java.util.ArrayList;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;
import moduloAeropuerto.clases.estructuraDeArchivo.Vuelo;

/**
 *
 * @author dell
 */
public class EscritorDeVueloBinarios {
     
    public static final File  FILE_VUELO= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/GuardarArhivosBinarios/ArchivosBinariosVuelos");
    
    public void guardarVuelos(ArrayList<Vuelo> lisVuelo) throws IOException,FileNotFoundException{
         
        for (Vuelo vuelos : lisVuelo) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_VUELO+"/"+vuelos.getCodigoVuelo());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(vuelos);
          salida.close();
        }
    }
}
