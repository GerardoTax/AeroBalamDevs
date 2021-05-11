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
import java.io.Serializable;
import java.util.ArrayList;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Personal;


/**
 *
 * @author dell
 */
public class EscritorDeAerolineaBinarios implements Serializable{
    
   
    public static final File FILE_AEROLINEA = new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/src/moduloAeropuerto/GuardarArhivosBinarios/ArchivosBianriosAerolinea");
    
    public void guardarAerolinea(ArrayList<Aerolinea> lisAerolinea) throws IOException,FileNotFoundException{
         
        for (Aerolinea aerolineas : lisAerolinea) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_AEROLINEA+"/"+aerolineas.getNombreAeropuerto());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(aerolineas);
          salida.close();
        }
    }
   
     public ArrayList<Aerolinea> leerAreolinea() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Aerolinea> lisAerolinea = new ArrayList<>();
        String[]  archivos=this.FILE_AEROLINEA.list();
        ObjectInputStream lector;   
        System.out.println("Archivos:"+archivos.length+"-------Aerolinea");
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(this.FILE_AEROLINEA+"/"+archivo));
            Aerolinea a =(Aerolinea)lector.readObject();
            lisAerolinea.add(a);
            lector.close();
        }
        return lisAerolinea;
   }
    
}
