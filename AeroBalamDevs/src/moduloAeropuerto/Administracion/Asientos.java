/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Administracion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import moduloAeropuerto.jFrame.VerAsientos;
import moduloPasajero.Jframe.JframeTarjeta;

/**
 *
 * @author dell
 */

   public class Asientos extends JButton  implements ActionListener{
     
    private VerAsientos verAsientos;
    private int posx;
    private int posy;
    private int ancho;
    private int alto;
    public Asientos(int posx, int posy ,int ancho  ,int alto,VerAsientos verAsientos   ){
        this.posx=posx;
        this.posy=posy;
        this.ancho=ancho;
        this.alto=alto;
        super.setBounds(posx, posy, ancho, alto);
        this.verAsientos=verAsientos;
        addActionListener(this);
         setBackground(Color.GREEN);
         
    
    }
    public void posicion(int x,int y){
      //setText((x+1)+"-"+(y+1));
     setText("A");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setBackground(Color.RED);
        Pasillo ocupado = new Pasillo(posx,posy,ancho,alto,this.verAsientos);
        this.verAsientos.getjPanel1().updateUI(); 
        this.verAsientos.acutalizar();
         JframeTarjeta tmp= new JframeTarjeta(verAsientos);
         tmp.setVisible(true);
        // verAsientos.setVisible(false);
        
         
         
         
        
    }
    
}
