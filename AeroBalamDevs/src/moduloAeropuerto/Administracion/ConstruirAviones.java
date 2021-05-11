/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Administracion;

import java.util.ArrayList;
import moduloAeropuerto.clases.estructuraDeArchivo.Aerolinea;
import moduloAeropuerto.enumm.TiposSuelos;
import moduloAeropuerto.jFrame.Avion;

/**
 *
 * @author dell
 */
public class ConstruirAviones {
    private int CANTIDAD_BOTONES=10;
    private int fila;
    private int columna;
    private Asientos [][]botones;
    private Avion avion;
    private TiposSuelos e;
    
    public ConstruirAviones(Avion avion,int fila, int columna){
         botones=new Asientos[CANTIDAD_BOTONES][CANTIDAD_BOTONES];
         this.avion=avion;
         this.fila=fila;
         this.columna=columna;
         
         
    }
    
    public  void crearasientos(int sumar,int numeroGrupo){
        for(int i=0;i<numeroGrupo;i++){
            for(int j=0;j<sumar;j++){   
                
                     if(avion.getEstado().equals(this.e.ASIENTO)){
                            botones[i][j]=new Asientos(60*j,60*i,50,50);
                            botones[i][j].posicion(i, j); 
                            avion.getjPanel1().add(botones[i][j]);
                            avion.getjPanel1().updateUI();  
                            
                           
                        }
                  else if (avion.getEstado().equals(this.e.PASILLO)){
                            botones[i][j]=new Pasillo(60*j,60*i,50,50);
                            botones[i][j].posicion(i, j); 
                            avion.getjPanel1().add(botones[i][j]);
                            avion.getjPanel1().updateUI();  
                         }      
            }               
        }
    }
}
