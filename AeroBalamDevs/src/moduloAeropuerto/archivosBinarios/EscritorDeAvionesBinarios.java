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
import moduloAeropuerto.clases.estructuraDeArchivo.Aviones;

/**
 *
 * @author dell
 */
public class EscritorDeAvionesBinarios {
     
    public static final File  FILE_AVIONES= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/src/moduloAeropuerto/GuardarArhivosBinarios/ArchivosBinariosAviones");
    
    public void guardarAeropuerto(ArrayList<Aviones> lisAviones) throws IOException,FileNotFoundException{
         
        for (Aviones avioness : lisAviones) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_AVIONES+"/"+avioness.getNombreAerolinea());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(avioness);
          salida.close();
        }
    }
    
}
