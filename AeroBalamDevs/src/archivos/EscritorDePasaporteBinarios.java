/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import moduloPasajero.Pasaporte;

/**
 *
 * @author dell
 */
public class EscritorDePasaporteBinarios {
    //donde se guardn los archivos binarios
  
public static final File  FILE_PASAPORTE= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/Objetos");
    
    public void guardarPasaporte(ArrayList<Pasaporte> pasaporte) throws IOException,FileNotFoundException{
         
        for (Pasaporte pasaportes : pasaporte) {
          FileOutputStream  fileOutput = new FileOutputStream(FILE_PASAPORTE+"/"+pasaportes.getNoPasaporte());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(pasaportes);
          salida.close();
        }
    }
    
}
