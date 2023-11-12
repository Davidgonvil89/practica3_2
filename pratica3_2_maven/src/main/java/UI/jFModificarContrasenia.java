/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class jFModificarContrasenia extends javax.swing.JFrame {

    private String user;

    /**
     * Creates new form jFModificarContrasenia
     */
    public jFModificarContrasenia() {
        initComponents();
        Modelo.Metodos.centrarVentanaEnPantalla(this);
    }

    public jFModificarContrasenia(String user) {
        initComponents();
        this.user = user;
        Modelo.Metodos.centrarVentanaEnPantalla(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLNuevaContrasenia = new javax.swing.JLabel();
        jTNewPass = new javax.swing.JTextField();
        jLConfirmarContrasenia = new javax.swing.JLabel();
        jTConfirmarPass = new javax.swing.JTextField();
        jBConfirmarPass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(4, 28, 45));

        jLNuevaContrasenia.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLNuevaContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        jLNuevaContrasenia.setText("Nueva Contraseña:");

        jTNewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNewPassActionPerformed(evt);
            }
        });

        jLConfirmarContrasenia.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLConfirmarContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        jLConfirmarContrasenia.setText("Confirmar Contraseña:");

        jBConfirmarPass.setBackground(new java.awt.Color(0, 235, 255));
        jBConfirmarPass.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jBConfirmarPass.setForeground(new java.awt.Color(0, 51, 102));
        jBConfirmarPass.setText("Confirmar");
        jBConfirmarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfirmarPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLNuevaContrasenia)
                    .addComponent(jTNewPass)
                    .addComponent(jLConfirmarContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTConfirmarPass)
                    .addComponent(jBConfirmarPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLNuevaContrasenia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLConfirmarContrasenia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTConfirmarPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBConfirmarPass)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTNewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNewPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNewPassActionPerformed

    private void jBConfirmarPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfirmarPassActionPerformed
        String nuevaContrasena = jTNewPass.getText();
        String confirmarContrasena = jTConfirmarPass.getText();

        if (nuevaContrasena.equals(confirmarContrasena)) {
            Modelo.BBDD.actualizarContraseña(user, nuevaContrasena);
            JOptionPane.showMessageDialog(this, "Contrasenia modificada con exito.");
            this.dispose(); // Cierra la ventana de cambio de contraseña
        } else {
            JOptionPane.showMessageDialog(this, "Las contrasenias no coinciden. Intentalo de nuevo por favor.");
        }
    }//GEN-LAST:event_jBConfirmarPassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFModificarContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFModificarContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFModificarContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFModificarContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFModificarContrasenia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConfirmarPass;
    private javax.swing.JLabel jLConfirmarContrasenia;
    private javax.swing.JLabel jLNuevaContrasenia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTConfirmarPass;
    private javax.swing.JTextField jTNewPass;
    // End of variables declaration//GEN-END:variables
}
