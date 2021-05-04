/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Administracion;

import moduloAeropuerto.clases.*;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author dell
 */
public class Asientos extends JButton  implements ActionListener{
     
    public Asientos(int posx, int posy ,int ancho  ,int alto   ){
    super.setBounds(posx, posy, ancho, alto);
    addActionListener(this);
    
    }
    public void posicion(int x,int y){
      //setText((x+1)+"-"+(y+1));
     // setText("O");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setBackground(Color.PINK);
        
    }
   
    
}
