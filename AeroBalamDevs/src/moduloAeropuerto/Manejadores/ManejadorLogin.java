/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Manejadores;

import javax.swing.JOptionPane;
import moduloAeropuerto.jFrame.Avion;
import moduloAeropuerto.jFrame.FrameGerencia;
import moduloAeropuerto.jFrame.FrameOperador;
import moduloAeropuerto.jFrame.LoginAeropuerto;

/**
 *
 * @author dell
 */
public class ManejadorLogin {
    private int contrasella;
    private String usurio;
    private LoginAeropuerto loginAeropuerto;
    
    public ManejadorLogin(LoginAeropuerto loginAeropuerto){
        this.loginAeropuerto=loginAeropuerto;
    }
    
    public void verificadorUsuario(){
        if(loginAeropuerto.getUsuarioTextField1().getText().equals("mama") && loginAeropuerto.getPasswordField1().getText().equals("1234") && loginAeropuerto. getjComboBox1().getSelectedItem().equals("Administracion")){
            Avion avion=new Avion();
            avion.setVisible(true);
            loginAeropuerto.setVisible(false);
         
        }
        else if (loginAeropuerto.getUsuarioTextField1().getText().equals("papa") && loginAeropuerto.getPasswordField1().getText().equals("789") && loginAeropuerto. getjComboBox1().getSelectedItem().equals("Gerencia")){
            FrameGerencia gerencia=new FrameGerencia();
            gerencia.setVisible(true);
            loginAeropuerto.setVisible(false);
        }
        else if(loginAeropuerto.getUsuarioTextField1().getText().equals("popo") && loginAeropuerto.getPasswordField1().getText().equals("456") && loginAeropuerto. getjComboBox1().getSelectedItem().equals("Operador")){
            FrameOperador operador=new FrameOperador();
            operador.setVisible(true);
            loginAeropuerto.setVisible(false);
            
        }
        else{
        JOptionPane.showMessageDialog(null, "Contraseña o Usuario incorrecto");
        }
        
    }
    
}
