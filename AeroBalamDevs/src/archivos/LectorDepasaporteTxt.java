/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;
import manejadores.ConstructorPasaporte;
import moduloPasajero.Pasaporte;

/**
 *
 * @author dell
 */
public class LectorDepasaporteTxt {
    //File=archivo
    //FileReader necesita a un archivo para poder leerlo
    //BufferedReader lee el texto del archivo
    public ArrayList<Pasaporte> leerFichero(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        ArrayList<Pasaporte> lisPasaporte = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos=separarCampos(linea);
            //pasamos el texto a objeto
            Pasaporte pas = ConstructorPasaporte.construirpasaporte(campos);
            if(pas!=null){
                lisPasaporte.add(pas);
            }
            text.append("\n"+linea);
        }
        fr.close(); 
        return lisPasaporte;
    }

        private String[] separarCampos(String linea) {
        String inicioPasaporte = "Pasaporte(";
        String lineaDeCampos = linea.substring(inicioPasaporte.length(), linea.length() - 2);
        System.out.println(lineaDeCampos);
        String[] campos = lineaDeCampos.split(",");
        return campos;
    }
    
}
