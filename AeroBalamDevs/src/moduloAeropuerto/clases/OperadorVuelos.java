/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.clases;

import moduloAeropuerto.jFrame.FrameOperador;

/**
 *
 * @author dell
 */
public class OperadorVuelos extends Thread{
    private String Usuario;
    private int contrasella;
    private  FrameOperador frameOperador;
    
    public OperadorVuelos(FrameOperador frameOperador){
        
        this.frameOperador=frameOperador;
    
    }
    public void iniciar() throws InterruptedException{
        this.sleep(500);
        frameOperador.getjLabel2().setVisible(true);
        frameOperador.getjLabel7().setVisible(true);
        this.sleep(1000);
        frameOperador.getjLabel9().setVisible(true);
        frameOperador.getjLabel7().setVisible(false);
        this.sleep(1000);
        frameOperador.getjLabel10().setVisible(true);
        frameOperador.getjLabel9().setVisible(false);
        this.sleep(1000);
        frameOperador.getjLabel11().setVisible(true);
        frameOperador.getjLabel10().setVisible(false);
        this.sleep(1000);
        frameOperador.getjLabel5().setVisible(true);
        frameOperador.getjLabel11().setVisible(false);
        frameOperador.getjLabel3().setVisible(true);
        this.sleep(2000);
        frameOperador.getjLabel7().setVisible(false);
        frameOperador.getjLabel9().setVisible(false);
        frameOperador.getjLabel10().setVisible(false);
        frameOperador.getjLabel11().setVisible(false);
        frameOperador.getjLabel5().setVisible(false);
        frameOperador.getjLabel3().setVisible(false);
        frameOperador.getjLabel2().setVisible(false);
  
    }
           
        
    
    public void cancelar(){}
    public void posponerVuelo(){}
    public void observarDistribucion(){}
    
     @Override
    public void run(){
        try{
            iniciar();
        }catch(InterruptedException e){
            System.out.println("error al procesar");
            e.printStackTrace();
        }
    }
}
