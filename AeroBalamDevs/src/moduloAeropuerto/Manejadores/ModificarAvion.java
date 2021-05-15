/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Manejadores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import moduloAeropuerto.archivosBinarios.EscritorDeAvionesBinarios;
import moduloAeropuerto.clases.estructuraDeArchivo.Aviones;
import moduloAeropuerto.jFrame.FrameDatos;

/**
 *
 * @author dell
 */
public class ModificarAvion {
    private FrameDatos framedatos;
    private int codigo;
    private EscritorDeAvionesBinarios escritorDeAvionesBinarios;
    private ArrayList<Aviones> listaAvion;
    private int cont;

    public ModificarAvion(FrameDatos framedatos,int codigo) {
        this.framedatos=framedatos;
        this.codigo=codigo;
        this.escritorDeAvionesBinarios=new EscritorDeAvionesBinarios();
    }
    
    public void cargarIfomacion(){
        try {
            listaAvion=this.escritorDeAvionesBinarios.leerAvion();
            buscarAvion();
        } catch (IOException ex) {
            Logger.getLogger(FrameDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrameDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }
    
    public void buscarAvion(){
        String aerolinea= (String) framedatos.getjComboBox2().getSelectedItem();
        for(int i=0;i<listaAvion.size();i++){
            
            if(listaAvion.get(i).getNombreAerolinea().equals(aerolinea)){
                if(listaAvion.get(i).getCodigoAvion()==this.codigo){
                    System.out.println(" Existe");
                    this.cont=1;
                    System.out.println(" !"+listaAvion.get(i).getCodigoAvion());
                    System.out.println(" !"+listaAvion.get(i).getNombreAerolinea());
                    JOptionPane.showMessageDialog(null,"existe");
                    return;
                 }         
            }
            
            this.cont=0;
        }
       if(this.cont==0){
           JOptionPane.showMessageDialog(null,"No Existe Avion");
           framedatos.getjTextField13().setText("");
       }
    }
}
