/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Administracion;

import java.awt.Color;
import java.awt.event.ActionEvent;

/**
 *
 * @author dell
 */
public class Pasillo extends Asientos{
    
    public Pasillo(int posx, int posy, int ancho, int alto) {
        super(posx, posy, ancho, alto);
        setBackground(Color.GRAY);
    }
    
     public void posicion(int x,int y){
      //setText((x+1)+"-"+(y+1));
     setText("P");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // setBackground(Color.RED);
        
    }
}
