/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.archivosBinarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import moduloAeropuerto.clases.estructuraDeArchivo.Pasaporte;

/**
 *
 * @author dell
 */
public class LeerPasaporteBinario {
 
   public ArrayList<Pasaporte> leerVehiculos() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Pasaporte> lisPersonas = new ArrayList<>();
        String[]  archivos=EscritorDePasaporteBinarios.FILE_PASAPORTE.list();
        ObjectInputStream lector;   
        System.out.println("Archivos:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorDePasaporteBinarios.FILE_PASAPORTE+"/"+archivo));
            Pasaporte v =(Pasaporte)lector.readObject();
            System.out.println("Nombre: "+v.getNombre());
            lisPersonas.add(v);
            lector.close();
        }
        return lisPersonas;
    }
    
}
