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
    
    public ArrayList<Vuelo> leerVuelos() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Vuelo> listaVuelo= new ArrayList<>();
        String[]  archivos=this.FILE_VUELO.list();
        ObjectInputStream lector;   
        System.out.println("Archivos:"+archivos.length+" ------vuelos");
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(this.FILE_VUELO+"/"+archivo));
            Vuelo v =(Vuelo)lector.readObject();
            listaVuelo.add(v);
            lector.close();
        }
        return listaVuelo;
    }
}
