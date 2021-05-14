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
import moduloAeropuerto.clases.estructuraDeArchivo.Reservacion;
import moduloAeropuerto.clases.estructuraDeArchivo.Vuelo;

/**
 *
 * @author dell
 */
public class LectorEscritorReservacion {
    
    public static final File  FILE_RESERVACION= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/GuardarArhivosBinarios/ArhivosBinariosReservacion");
    
    public void guardarReservacion(ArrayList<Reservacion> lisReservacion) throws IOException,FileNotFoundException{
         
        for (Reservacion reservacion : lisReservacion) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_RESERVACION+"/"+reservacion.getNoPasaporte());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(reservacion);
          salida.close();
        }
    }
}
