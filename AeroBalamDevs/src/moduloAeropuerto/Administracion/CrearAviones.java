/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Administracion;

import moduloAeropuerto.clases.*;
import moduloAeropuerto.jFrame.Avion;

/**
 *
 * @author dell
 */
public class CrearAviones   {
    
    private int CANTIDAD_BOTONES=100;
    private int fila;
    private int columna;
    private Asientos [][]botones;
    private Avion avion;
    
    public CrearAviones (Avion avion,int fila, int columna){
         botones=new Asientos[CANTIDAD_BOTONES][CANTIDAD_BOTONES];
         this.avion=avion;
         this.fila=fila;
         this.columna=columna;
    }
    
    public  void crear(){
        for(int i=0;i<columna;i++){
            for(int j=0;j<fila;j++){ 
                 botones[i][j]=new Asientos(50*j,50*i,40,40);
                 botones[i][j].posicion(i, j); 
                 avion.getjPanel1().add(botones[i][j]);
                 avion.getjPanel1().updateUI();  
            }
        }               
    }
}
