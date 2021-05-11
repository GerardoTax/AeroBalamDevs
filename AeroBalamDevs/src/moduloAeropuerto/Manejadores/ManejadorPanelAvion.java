/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Manejadores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import moduloAeropuerto.archivosBinarios.EscritorDeAerolineaBinarios;
import moduloAeropuerto.archivosBinarios.EscritorDeAvionesBinarios;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.clases.estructuraDeArchivo.Aeropuerto;
import moduloAeropuerto.jFrame.FrameDatos;

/**
 *
 * @author dell
 */
public class ManejadorPanelAvion {
    private FrameDatos frameDatos;
    private Vector<String> vectorAerolinea = new Vector<>();
    private ArrayList<Aerolinea> listaAerolinea;
    // esta clase tiene un metodo para leer binarios
    private EscritorDeAerolineaBinarios escritorDeAerolineaBinarios;
    
    public ManejadorPanelAvion(FrameDatos frameDatos){
        this.frameDatos=frameDatos;
        this.escritorDeAerolineaBinarios=new EscritorDeAerolineaBinarios();
        
                
    }
    
    public void cargarAerolinea() {
        try {
         this.listaAerolinea= this.escritorDeAerolineaBinarios.leerAreolinea();
        } catch (IOException ex) {
            Logger.getLogger(ManejadorPanelAvion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorPanelAvion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void VerAerolineaDisponibles(){
       cargarAerolinea();
       for(int i=0;i<listaAerolinea.size(); i++){
           vectorAerolinea.add(listaAerolinea.get(i).getNombreAeropuerto());
           frameDatos.getjComboBoxAerolinea().addItem(this.vectorAerolinea.get(i));
       }
   }
}
