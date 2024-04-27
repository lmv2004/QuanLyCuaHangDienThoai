/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ASUS
 */
public class InputForm extends JPanel{
    private JLabel lblTitle;
    public JTextField txtForm;
    private JPasswordField txtPass;

    public InputForm() {
    }

    public InputForm(String title) {
        this.setLayout(new GridLayout(2, 1));
        this.setBackground(Color.white);
        this.setBorder(new EmptyBorder(0, 10, 5, 10));
        this.setPreferredSize(new Dimension(100, 100));
        lblTitle = new JLabel(title);
        txtForm = new JTextField();
        this.add(lblTitle);
        this.add(txtForm);
    }
    
    public String getText() {
        return txtForm.getText();
    }

    public void setText(String content) {
        txtForm.setText(content);
    }

    
}
