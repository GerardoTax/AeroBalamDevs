/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.Manejadores;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import moduloAeropuerto.clases.ExcepcionVentana;
import moduloAeropuerto.clases.estructuraDeArchivo.Personal;
import moduloAeropuerto.jFrame.Avion;
import moduloAeropuerto.jFrame.FrameAdministrador;
import moduloAeropuerto.jFrame.FrameDatos;
import moduloAeropuerto.jFrame.FrameGerencia;
import moduloAeropuerto.jFrame.FrameOperador;
import moduloAeropuerto.jFrame.LoginAeropuerto;

/**
 *
 * @author dell
 */
public class ManejadorLogin {
    private LoginAeropuerto loginAeropuerto;
    private ArrayList<Personal>  lispersona;
    
    public ManejadorLogin(LoginAeropuerto loginAeropuerto, ArrayList<Personal>  lispersona ){
        this.loginAeropuerto=loginAeropuerto;
        this.lispersona=lispersona;
    }
    
    public void validarCampoVacio(String campo, String tipo) throws ExcepcionVentana{
      if(campo.equals("")){
          throw new ExcepcionVentana("Error en el campo  "+tipo+ "  esta vacio");
      }
    }
    public int convertir(String campo, String tipoDato) throws ExcepcionVentana{
         try{
           int resultado=Integer.valueOf(campo);
           if(resultado<1){
               
            throw new ExcepcionVentana("Error en el campo  "+tipoDato+ " esta intentando ingresar un mumero negativo");
               
           } else {
           return resultado;
           }
       }catch(NumberFormatException e){
           
           throw new ExcepcionVentana("Error en el campo  "+tipoDato+ "  esta intentado ingresar una letra en ves de un numero");
           
       }
    }
    
    public void validarLogin() throws ExcepcionVentana{
        validarCampoVacio(loginAeropuerto.getUsuarioTextField1().getText(),"Usuario");
        validarCampoVacio(loginAeropuerto.getPasswordField1().getText(),"Contraseña");
        convertir(loginAeropuerto.getPasswordField1().getText(),"Contraseña");      
    }
    
    public void Cargarventana() throws ExcepcionVentana{
        validarLogin();
        String usuario=loginAeropuerto.getUsuarioTextField1().getText();
        String contraseña=loginAeropuerto.getPasswordField1().getText();
        String area= (String )this.loginAeropuerto.getjComboBox1().getSelectedItem();
        for(int i=0; i<lispersona.size();i++){
        
                String cont= String.valueOf(lispersona.get(i).getContrasella());
                String usu=lispersona.get(i).getUsuario();
                String areaa=lispersona.get(i).getPuesto();
            if(usu.equals(usuario)){  
                
                if(cont.equals(contraseña)){
                    
                    if(areaa.equals(area)){
                         if(area.equals("Administracion")){
                             FrameDatos frameDatos=new FrameDatos();
                             frameDatos.setVisible(true);
                             loginAeropuerto.dispose();
                         }
                         else if(area.equals("Operador")){
                            FrameOperador frameOperador=new FrameOperador();
                            frameOperador.setVisible(true);
                            loginAeropuerto.dispose();
                         }
                         else if(area.equals("Gerencia")){
                              FrameGerencia frameGerencia =new FrameGerencia();
                              frameGerencia.setVisible(true);
                              loginAeropuerto.dispose();
                            }
                    }else JOptionPane.showMessageDialog(null, "Error en el area");
                    
                }else {
                        JOptionPane.showMessageDialog(null, "contraseña incorecta");
                        this.loginAeropuerto.getPasswordField1().setText("");
                    }
    
            
            }
            
            
        }
    
    }
    
}
