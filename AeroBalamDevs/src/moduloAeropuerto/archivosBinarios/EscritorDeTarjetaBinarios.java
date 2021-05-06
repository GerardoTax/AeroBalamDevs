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
import moduloAeropuerto.clases.estructuraDeArchivo.Tarjeta;

/**
 *
 * @author dell
 */
public class EscritorDeTarjetaBinarios {
     
    public static final File  FILE_TARJETA= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/src/moduloAeropuerto/GuardarArhivosBinarios/ArchivosBinarioTarjeta");
    
    public void guardarAeropuerto(ArrayList<Tarjeta> lisTarjeta) throws IOException,FileNotFoundException{
         
        for (Tarjeta tarjetas : lisTarjeta) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_TARJETA+"/"+tarjetas.getCodigoTarjeta());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(tarjetas);
          salida.close();
        }
    }
}
