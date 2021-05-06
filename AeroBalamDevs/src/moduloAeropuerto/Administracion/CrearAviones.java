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
    private String estado;
    
    public CrearAviones (Avion avion,int fila, int columna){
         botones=new Asientos[CANTIDAD_BOTONES][CANTIDAD_BOTONES];
         this.avion=avion;
         this.fila=fila;
         this.columna=columna;
         
         
    }
    
    public  void crearasientos(){
        for(int i=0;i<fila;i++){
            for(int j=0;j<columna;j++){ 
                      
                     botones[i][j]=new Asientos(50*j,50*i,40,40);
                     botones[i][j].posicion(i, j); 
                     avion.getjPanel1().add(botones[i][j]);
                     avion.getjPanel1().updateUI();  
            }
        }               
    }
    
    public  void crearPasillos(){
        for(int i=fila;i<filanueva(fila);i++){
            for(int j=columna;j<columnaNueva(columna);j++){ 
                      
                     botones[i][j]=new Pasillo(50*j,50*i,40,40);
                     botones[i][j].posicion(i, j); 
                     avion.getjPanel1().add(botones[i][j]);
                     avion.getjPanel1().updateUI();  
                      
                    
            }
        }               
    }
    public void sumarfilaColumnas(int fila , int columna){
        this.fila=this.fila+fila;
        this.columna=this.columna+columna;
    }
    
    public int filanueva(int fila){
        int resultado=this.fila+fila;
        return resultado;
    
    }
    public int columnaNueva(int columna){
     int resultado=this.columna+columna;
        return resultado;
    }
}
