/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    public static void placeHolder(javax.swing.JTextField jTextField, String content) {
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

    public static void HoverBtn(javax.swing.JButton btn, ArrayList<JButton> buttonList) {
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            Color ChooseColor = new Color(60, 78, 170);
            Color HoverColor = new Color(30,30,30);
            Color DefaultColor = new Color(5, 7, 15);

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (btn.getBackground() == ChooseColor) {
                    return;
                }
                btn.setBackground(HoverColor);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (btn.getBackground() == ChooseColor) {
                    return;
                }
                btn.setBackground(DefaultColor);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                for (JButton button : buttonList) {
                    button.setBackground(DefaultColor);
                    button.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                }
                btn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                btn.setBackground(ChooseColor);
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
