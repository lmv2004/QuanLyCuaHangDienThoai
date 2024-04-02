/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;

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
    
}
