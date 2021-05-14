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
import moduloAeropuerto.clases.estructuraDeArchivo.RenovacionPasaporte;
import moduloAeropuerto.clases.estructuraDeArchivo.Vuelo;

/**
 *
 * @author dell
 */
public class LectorEscritorRenovacion {
    
    public static final File  FILE_RENOVACION= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/GuardarArhivosBinarios/ArchivosBinariosRenovacion");
    
    public void guardarRenovacion(ArrayList<RenovacionPasaporte> lisRenovacion) throws IOException,FileNotFoundException{
         
        for (RenovacionPasaporte renovacion : lisRenovacion) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_RENOVACION+"/"+renovacion.getFechaNueva());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(renovacion);
          salida.close();
        }
    }
}
