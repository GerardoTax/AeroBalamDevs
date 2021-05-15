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
import moduloAeropuerto.clases.estructuraDeArchivo.Aviones;

/**
 *
 * @author dell
 */
public class EscritorDeAvionesBinarios {
     
    public static final File  FILE_AVIONES= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/GuardarArhivosBinarios/ArchivosBinariosAviones");
    
    public void guardarAeropuerto(ArrayList<Aviones> lisAviones) throws IOException,FileNotFoundException{
         
        for (Aviones avioness : lisAviones) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_AVIONES+"/"+avioness.getCodigoAvion());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(avioness);
          salida.close();
        }
    }
     public ArrayList<Aviones> leerAvion() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Aviones> lisAviones = new ArrayList<>();
        String[] archivos=this.FILE_AVIONES.list();
        ObjectInputStream lector;   
        System.out.println("Archivos:"+archivos.length+"--------Aviones   *****");
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(this.FILE_AVIONES+"/"+archivo));
            Aviones a =(Aviones)lector.readObject();
            System.out.println(a.getCodigoAvion());
            lisAviones.add(a);
            lector.close();
        }
        return lisAviones;
    }
    
}
