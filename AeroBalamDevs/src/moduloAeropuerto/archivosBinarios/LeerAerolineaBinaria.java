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
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
/**
 *
 * @author dell
 */
public class LeerAerolineaBinaria {
    public ArrayList<Aerolinea> leerVehiculos() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Aerolinea> vehiculos = new ArrayList<>();
        String[]  archivos=EscritorDeAerolineaBinarios.FILE_AEROLINEA.list();
        ObjectInputStream lector;   
        System.out.println("Archivos:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorDeAerolineaBinarios.FILE_AEROLINEA+"/"+archivo));
            Aerolinea v =(Aerolinea)lector.readObject();
            System.out.println( "Nombre  "+v.getNombreAerolinea()+"  Nombre de "+v.getNombreAeropuerto());
            vehiculos.add(v);
            lector.close();
        }
        return vehiculos;
    }
}
