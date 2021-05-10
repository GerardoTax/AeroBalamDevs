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
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Pasaporte;
import moduloAeropuerto.clases.estructuraDeArchivo.Personal;

/**
 *
 * @author dell
 */
public class LectorEscrituraBinariosPersonal {
    
      
    public static final File  FILE_PERSONAL= new File("/Users/dell/Desktop/AeroBalamDevs/AeroBalamDevs/personalAeropuerto");
    
    public void guardarPersonal(ArrayList<Personal> lisAeropuerto) throws IOException,FileNotFoundException{
         
        for (Personal personal : lisAeropuerto) {
            // FileOutputStream para escribir flujos de byte
            //ObjectOutputStream  para contruir objetos
          FileOutputStream  fileOutput = new FileOutputStream(FILE_PERSONAL+"/"+personal.getUsuario());
          ObjectOutputStream salida = new ObjectOutputStream(fileOutput);
          salida.writeObject(personal);
          salida.close();
        }
    }

   public ArrayList<Personal> leerPersonal() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Personal> lisPersonal = new ArrayList<>();
        String[]  archivos=this.FILE_PERSONAL.list();
        ObjectInputStream lector;   
        System.out.println("Archivos:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(this.FILE_PERSONAL+"/"+archivo));
            Personal v =(Personal)lector.readObject();
            //System.out.println("Puesto: "+v.getPuesto()+ "  "+v.getUsuario());
            lisPersonal.add(v);
            lector.close();
        }
        return lisPersonal;
   }
}
