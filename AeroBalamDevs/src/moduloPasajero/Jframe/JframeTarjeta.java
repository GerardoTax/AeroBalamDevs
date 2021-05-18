/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloPasajero.Jframe;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import moduloAeropuerto.clases.ExcepcionVentana;
import moduloAeropuerto.jFrame.VerAsientos;
import moduloPasajero.manejadores.ManejadorTarjeta;


/**
 *
 * @author dell
 */
public class JframeTarjeta extends javax.swing.JFrame {

    private ManejadorTarjeta manejadorTarjeta;
     private VerAsientos verAsientos;
    public JframeTarjeta(VerAsientos verAsientos) {
        initComponents();
        this.verAsientos=verAsientos;
        this.setLocationRelativeTo(null);
        this.manejadorTarjeta=new ManejadorTarjeta(this);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        noTarjetaTextField1 = new javax.swing.JTextField();
        noPasaporteTextField2 = new javax.swing.JTextField();
        DineroTextField3 = new javax.swing.JTextField();
        codigoCVCTextField4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tarjeta ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 29, 83, 40));

        jButton1.setText("Pagar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 239, -1));

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("No.Tarjeta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("No.Pasaporte");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 138, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Dinero");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 176, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Codigo CVC");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 214, -1, -1));
        getContentPane().add(noTarjetaTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 98, 136, -1));
        getContentPane().add(noPasaporteTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 136, 139, -1));
        getContentPane().add(DineroTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 174, 139, -1));
        getContentPane().add(codigoCVCTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 212, 139, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ModuloPasajeros tmp= new ModuloPasajeros();
        tmp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.manejadorTarjeta.guardarTarjeta();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
         
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DineroTextField3;
    private javax.swing.JTextField codigoCVCTextField4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField noPasaporteTextField2;
    private javax.swing.JTextField noTarjetaTextField1;
    // End of variables declaration//GEN-END:variables

    public JTextField getDineroTextField3() {
        return DineroTextField3;
    }

    public JTextField getCodigoCVCTextField4() {
        return codigoCVCTextField4;
    }

    public JTextField getNoPasaporteTextField2() {
        return noPasaporteTextField2;
    }

    public JTextField getNoTarjetaTextField1() {
        return noTarjetaTextField1;
    }

    public void setDineroTextField3(JTextField DineroTextField3) {
        this.DineroTextField3 = DineroTextField3;
    }

    public void setCodigoCVCTextField4(JTextField codigoCVCTextField4) {
        this.codigoCVCTextField4 = codigoCVCTextField4;
    }

    public void setNoPasaporteTextField2(JTextField noPasaporteTextField2) {
        this.noPasaporteTextField2 = noPasaporteTextField2;
    }

    public void setNoTarjetaTextField1(JTextField noTarjetaTextField1) {
        this.noTarjetaTextField1 = noTarjetaTextField1;
    }
    

}
