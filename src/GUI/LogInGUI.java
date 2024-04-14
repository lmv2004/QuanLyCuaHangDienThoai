/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.AccountDTO;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

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
        ImageIcon logo = new ImageIcon("src/img/logo.jpg");
        setIconImage(logo.getImage());
        
        function.placeHolder(tk, "Tên tài khoản");
        function.placeHolder(mk, "Mật khẩu");
        this.getContentPane().requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        eyeBtn = new javax.swing.JToggleButton();
        tk = new javax.swing.JTextField();
        mk = new javax.swing.JPasswordField();
        lbForgetPassword = new javax.swing.JLabel();
        btnLogIn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập vào hệ thống");
        setBackground(new java.awt.Color(5, 7, 15));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(5, 7, 15));

        eyeBtn.setBackground(new java.awt.Color(255, 255, 255));
        eyeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eyeHide.png"))); // NOI18N
        eyeBtn.setBorder(null);
        eyeBtn.setBorderPainted(false);
        eyeBtn.setFocusPainted(false);
        eyeBtn.setOpaque(true);
        eyeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyeBtnActionPerformed(evt);
            }
        });

        tk.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        tk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        mk.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        mk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mk.setFocusCycleRoot(true);
        mk.setFocusTraversalPolicyProvider(true);

        lbForgetPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbForgetPassword.setForeground(new java.awt.Color(237, 238, 247));
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

        btnLogIn.setBackground(new java.awt.Color(60, 78, 170));
        btnLogIn.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnLogIn.setForeground(new java.awt.Color(237, 238, 247));
        btnLogIn.setText("Đăng nhập");
        btnLogIn.setFocusPainted(false);
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

        jLabel1.setBackground(new java.awt.Color(5, 7, 15));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile.png"))); // NOI18N
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(btnLogIn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mk, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tk)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbForgetPassword)
                                    .addComponent(eyeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tk, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mk, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eyeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbForgetPassword)
                .addGap(18, 18, 18)
                .addComponent(btnLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );

        eyeBtn.getAccessibleContext().setAccessibleParent(mk);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbForgetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbForgetPasswordMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Mật khẩu đã được gửi đến email");
    }//GEN-LAST:event_lbForgetPasswordMouseClicked

    private void lbForgetPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbForgetPasswordMouseEntered
        // TODO add your handling code here:
        lbForgetPassword.setForeground(new java.awt.Color(40, 58, 149));
    }//GEN-LAST:event_lbForgetPasswordMouseEntered

    private void lbForgetPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbForgetPasswordMouseExited
        // TODO add your handling code here:
        lbForgetPassword.setForeground(new java.awt.Color(237, 238, 247));
    }//GEN-LAST:event_lbForgetPasswordMouseExited

    private void btnLogInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogInMouseEntered
        // TODO add your handling code here:
        btnLogIn.requestFocus();
    }//GEN-LAST:event_btnLogInMouseEntered

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        // TODO add your handling code here:
        if(function.TextFieldIsEmpty(tk, "tài khoản")) {
            return;
        }
        if(function.TextFieldIsEmpty(mk, "mật khẩu")) {
            return;
        }
        BUS.LogInBUS.LogIn(this,tk.getText(), mk.getPassword());
    }//GEN-LAST:event_btnLogInActionPerformed

    private void eyeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyeBtnActionPerformed
        // TODO add your handling code here:
        if(eyeBtn.isSelected()) {
            eyeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eyeShow.png")));
            mk.setEchoChar((char)0);
        }
        else {
            eyeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eyeHide.png")));
            mk.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_eyeBtnActionPerformed

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
                if ("FlatFlat Dark".equals(info.getName())) {
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
    private javax.swing.JToggleButton eyeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbForgetPassword;
    private javax.swing.JPasswordField mk;
    private javax.swing.JTextField tk;
    // End of variables declaration//GEN-END:variables
}
