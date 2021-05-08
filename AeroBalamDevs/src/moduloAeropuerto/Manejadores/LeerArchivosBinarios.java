/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Manejadores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import moduloAeropuerto.archivosBinarios.EscritorDeAvionesBinarios;
import moduloAeropuerto.clases.estructuraDeArchivo.Aviones;


/**
 *
 * @author dell
 */
public class LeerArchivosBinarios {
    public ArrayList<Aviones> leerPasaporte() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Aviones> lisAviones = new ArrayList<>();
        String[] archivos=EscritorDeAvionesBinarios.FILE_AVIONES.list();
        ObjectInputStream lector;   
        System.out.println("Archivos:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorDeAvionesBinarios.FILE_AVIONES+"/"+archivo));
            Aviones a =(Aviones)lector.readObject();
            System.out.println(a);
            lector.close();
        }
        return lisAviones;
    }
}
