/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class function {

    //thiết lập placeHolder cho text field với nội dung là content
    public static void placeHolder(JTextField jTextField, String content) {
        jTextField.setText(content);
        jTextField.setForeground(Color.GRAY);
        jTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (jTextField.getText().trim().equals(content)) {
                    jTextField.setText("");
                    jTextField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (jTextField.getText().trim().equals("") || jTextField.getText().trim().equals(content)) {
                    jTextField.setText(content);
                    jTextField.setForeground(Color.GRAY);
                }
            }
        });
    }

    
    //biến dùng để hover các button
    static Color ChooseColor = new Color(60, 78, 170);
    static Color HoverColor = new Color(30, 30, 30);
    static Color DefaultColor = new Color(5, 7, 15);
    static JButton btnBefore = null;
    //thiết lập button trước
    public static void setBtnBefore(JButton btn) {
        btnBefore=btn;
    }
    public static void HoverBtn(JButton btn, ArrayList<JButton> buttonList) {
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(HoverColor);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(btn!=btnBefore) {
                    btn.setBackground(DefaultColor);
                }
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                btnClicked(btnBefore, btn);
                btnBefore=btn;
            }
        });
    }

    public static void btnClicked(JButton btnBefore, JButton btnClicked) {
        if(btnBefore!=null) {
            btnBefore.setBackground(DefaultColor);
            btnBefore.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        }
        btnClicked.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnClicked.setBackground(ChooseColor);
    }
    
    
    
    
    
    //biến dùng để hover các button
    static Color HoverColor2 = new Color(225,225,225);
    static Color DefaultColor2 = new Color(255,255,255);
    public static void HoverToolBar(JButton btn, ArrayList<JButton> buttonList) {
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(HoverColor2);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(DefaultColor2);
            }
        });
    }
    
    
    
    
    

    public static boolean TextFieldIsEmpty(JTextField tf, String alert) {
        if (tf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập " + alert);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static Icon load(String linkImage, int k, int m) {/*linkImage là tên icon, k kích thước chiều rộng mình muốn,m chiều dài và hàm này trả về giá trị là 1 icon.*/
        try {
            BufferedImage image = ImageIO.read(new File(linkImage));//đọc ảnh dùng BufferedImage

            int x = k;
            int y = m;
            int ix = image.getWidth();
            int iy = image.getHeight();
            int dx = 0, dy = 0;

            if (x / y > ix / iy) {
                dy = y;
                dx = dy * ix / iy;
            } else {
                dx = x;
                dy = dx * iy / ix;
            }

            return new ImageIcon(image.getScaledInstance(dx, dy,
                    image.SCALE_SMOOTH));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
