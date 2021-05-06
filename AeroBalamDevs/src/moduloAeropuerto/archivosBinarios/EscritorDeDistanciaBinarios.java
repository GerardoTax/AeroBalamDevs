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
import moduloAeropuerto.clases.estructuraDeArchivo.Distancia;

/**
 *
 * @author dell
 */
public class EscritorDeDistanciaBinarios {
     
    public static final File  FILE_DISTANCIA= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/src/moduloAeropuerto/GuardarArhivosBinarios/ArchivosBinarioDistancia");
    
    public void guardarAeropuerto(ArrayList<Distancia> lisDistancia) throws IOException,FileNotFoundException{
         
        for (Distancia distancias : lisDistancia) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_DISTANCIA+"/"+distancias.getNombreAeropuertoOrigen());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(distancias);
          salida.close();
        }
    }
}
