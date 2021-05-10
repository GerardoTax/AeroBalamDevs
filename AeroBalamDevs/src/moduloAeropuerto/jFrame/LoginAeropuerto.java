/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloAeropuerto.jFrame;


import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import moduloAeropuerto.Manejadores.ManejadorLogin;
import moduloAeropuerto.archivosBinarios.LectorEscrituraBinariosPersonal;
import moduloAeropuerto.clases.ExcepcionVentana;
import moduloAeropuerto.clases.estructuraDeArchivo.Personal;
import moduloPasajero.Jframe.Principal;

/**
 *
 * @author dell
 */
public class LoginAeropuerto extends javax.swing.JFrame {
    private ManejadorLogin manejadorLogin;
    private  LectorEscrituraBinariosPersonal lectorEscrituraBinariosPersonal;
    private ArrayList<Personal>  lispersona;
    public LoginAeropuerto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.lectorEscrituraBinariosPersonal=new  LectorEscrituraBinariosPersonal();
        cargar();
        this.manejadorLogin=new ManejadorLogin(this,this.lispersona);
         
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuarioTextField1 = new javax.swing.JTextField();
        passwordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 240, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Contraseña");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));
        getContentPane().add(usuarioTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 130, -1));
        getContentPane().add(passwordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 130, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tipo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administracion", "Gerencia", "Operador" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\dell\\Downloads\\a.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 371));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        try {
            this.manejadorLogin.Cargarventana();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        Principal principal = new Principal();
        principal.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JTextField usuarioTextField1;
    // End of variables declaration//GEN-END:variables

    public JButton getjButton1() {
        return jButton1;
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public JTextField getUsuarioTextField1() {
        return usuarioTextField1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public void setPasswordField1(JPasswordField passwordField1) {
        this.passwordField1 = passwordField1;
    }

    public void setUsuarioTextField1(JTextField usuarioTextField1) {
        this.usuarioTextField1 = usuarioTextField1;
    }
    public void cargar(){
    
         try {
            lispersona= this.lectorEscrituraBinariosPersonal.leerPersonal();
           System.out.println("*********");
           for(int i=0;i<lispersona.size();i++){
            System.out.println(lispersona.get(i).getUsuario()+"   "+lispersona.get(i).getPuesto()+"   "+lispersona.get(i).getContrasella()); 
                
           }
         } catch (IOException ex) {
             Logger.getLogger(FrameAdministrador.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(FrameAdministrador.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
}
