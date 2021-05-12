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
import moduloAeropuerto.clases.estructuraDeArchivo.Personal;
import moduloAeropuerto.clases.estructuraDeArchivo.Tarjeta;

/**
 *
 * @author dell
 */
public class EscritorDeTarjetaBinarios {
     
    public static final File  FILE_TARJETA= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/GuardarArhivosBinarios/ArchivosBinariosTarjeta");
    
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
    //lector De Archivos Binarios
    public ArrayList<Tarjeta> leerTarjeta() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Tarjeta> lisTarjeta = new ArrayList<>();
        String[]  archivos=this.FILE_TARJETA.list();
        ObjectInputStream lector;   
        System.out.println("Archivos:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(this.FILE_TARJETA+"/"+archivo));
            Tarjeta tar =(Tarjeta)lector.readObject();
            //System.out.println("Puesto: "+v.getPuesto()+ "  "+v.getUsuario());
            lisTarjeta.add(tar);
            lector.close();
        }
        return lisTarjeta;
   }
}
