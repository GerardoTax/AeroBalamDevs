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
import java.util.ArrayList;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;
import moduloAeropuerto.clases.estructuraDeArchivo.Pasaporte;


/**
 *
 * @author dell
 */
public class EscritorDePasaporteBinarios {
     
    public static final File  FILE_PASAPORTE= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/src/moduloAeropuerto/GuardarArhivosBinarios/ArchivosBinariosPasaporte");
    
    public void guardarPasaporte(ArrayList<Pasaporte> pasaporte) throws IOException,FileNotFoundException{
         
        for (Pasaporte pasaportes : pasaporte) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_PASAPORTE+"/"+pasaportes.getNoPasaporte());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(pasaportes);
          salida.close();
        }
    }
    
     public ArrayList<Pasaporte> leerPasaporte() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Pasaporte> listaPasaporte= new ArrayList<>();
        String[]  archivos=this.FILE_PASAPORTE.list();
        ObjectInputStream lector;   
        System.out.println("Archivos:"+archivos.length+" ------pasaporte");
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(this.FILE_PASAPORTE+"/"+archivo));
            Pasaporte pasa =(Pasaporte)lector.readObject();
            System.out.println( "Nombre  "+pasa.getNombre());
            listaPasaporte.add(pasa);
            lector.close();
        }
        return listaPasaporte;
    }
}
