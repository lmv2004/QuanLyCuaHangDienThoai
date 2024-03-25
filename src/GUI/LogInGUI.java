/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class LogInGUI extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public LogInGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        btnLogIn = new javax.swing.JButton();
        lbForgetPassword = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập vào hệ thống");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Tên đăng nhập");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 220, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Mật khẩu");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 140, 90));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 360, 50));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 360, 50));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ĐĂNG NHẬP");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 700, 70));

        btnLogIn.setBackground(new java.awt.Color(51, 255, 255));
        btnLogIn.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnLogIn.setForeground(java.awt.Color.white);
        btnLogIn.setText("Đăng nhập");
        btnLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogInMouseEntered(evt);
            }
        });
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 200, 80));

        lbForgetPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbForgetPassword.setForeground(java.awt.Color.white);
        lbForgetPassword.setText("Quên mật khẩu");
        lbForgetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbForgetPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbForgetPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbForgetPasswordMouseExited(evt);
            }
        });
        getContentPane().add(lbForgetPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backGroundLogIn.jpg"))); // NOI18N
        jLabel2.setText("Mật khẩu");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyTyped

    private void lbForgetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbForgetPasswordMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Mật khẩu đã được gửi đến email");
    }//GEN-LAST:event_lbForgetPasswordMouseClicked

    private void lbForgetPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbForgetPasswordMouseEntered
        // TODO add your handling code here:
        lbForgetPassword.setForeground(Color.red);
    }//GEN-LAST:event_lbForgetPasswordMouseEntered

    private void lbForgetPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbForgetPasswordMouseExited
        // TODO add your handling code here:
        lbForgetPassword.setForeground(Color.white);
    }//GEN-LAST:event_lbForgetPasswordMouseExited

    private void btnLogInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogInMouseEntered
        // TODO add your handling code here:
        btnLogIn.requestFocus();
    }//GEN-LAST:event_btnLogInMouseEntered

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new MainMenuGUI().setVisible(true);
    }//GEN-LAST:event_btnLogInActionPerformed

    int i=0;
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
            java.util.logging.Logger.getLogger(LogInGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInGUI().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbForgetPassword;
    // End of variables declaration//GEN-END:variables
}
