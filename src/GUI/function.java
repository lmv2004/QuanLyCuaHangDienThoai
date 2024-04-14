/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author ACER
 */
public class function {
    
    //thiết lập placeHolder cho text field với nội dung là content
    public static void placeHolder(javax.swing.JTextField jTextField,String content) {
        jTextField.setText(content);
        jTextField.setForeground(Color.GRAY);
        jTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if(jTextField.getText().trim().equals(content)){
                    jTextField.setText("");
                    jTextField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(jTextField.getText().trim().equals("") || jTextField.getText().trim().equals(content)){
                    jTextField.setText(content);
                    jTextField.setForeground(Color.GRAY);
                }
            }
        });
    }
    
    
    public static void HoverBtn(javax.swing.JButton btn, ArrayList<JButton> buttonList) {
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(btn.getBackground()==Color.CYAN) return;
                btn.setBackground(new java.awt.Color(6, 86, 112));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(btn.getBackground()==Color.CYAN) return;
                btn.setBackground(new java.awt.Color(6, 66, 93));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                for(JButton button : buttonList) {
                    button.setBackground(new java.awt.Color(6, 66, 93));
                }
                btn.setBackground(Color.CYAN);
            }
        });
    }
    
    public static boolean TextFieldIsEmpty(JTextField tf, String alert) {
        if(tf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập "+alert);
            tf.requestFocus();
            return true;
        }
        return false;
    }
}
