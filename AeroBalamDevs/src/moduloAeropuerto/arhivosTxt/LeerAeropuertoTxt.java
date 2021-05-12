/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.arhivosTxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;
import moduloAeropuerto.Manejadores.ManejadorCargaDatos;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;

/**
 *
 * @author dell
 */
public class LeerAeropuertoTxt {
    
    public ArrayList<Aeropuerto> leerFichero(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<Aeropuerto> lisAeropuerto = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea,"AEROPUERTO");
            //pasamos el texto a objeto
            Aeropuerto aeropuerto=ManejadorCargaDatos.construirAeropuerto(campos);
            if(aeropuerto!=null){
                lisAeropuerto.add(aeropuerto);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisAeropuerto;
    }
         //metodo Generico para separar campos
        private String[] separarCampos(String linea,String tipo) {
        String inicioVehiculo = tipo+"(";
        String lineaDeCampos = linea.substring(inicioVehiculo.length(), linea.length() - 2);
        System.out.println(lineaDeCampos);
        String[] campos = lineaDeCampos.split(",");
        return campos;
    }
    
    //metodo para leer Aerolinea
         public ArrayList<Aerolinea> leerFicheroAerolinea(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<Aerolinea> lisAerolinea = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea,"AEROLINEA");
            //pasamos el texto a objeto
            Aerolinea aerolinea=ManejadorCargaDatos.construirAerolinea(campos);
            if(aerolinea!=null){
                lisAerolinea.add(aerolinea);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisAerolinea;
    }
}
