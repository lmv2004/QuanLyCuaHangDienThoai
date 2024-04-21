package GUI;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class function {
    
//-------------------------------------------------------------------------------------------------------------------------------------------------

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
//-------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    //thiết lập hover khi di chuột vào với 3 tham số là JButton, HoverColor, DefaultColor
    public static void HoverBtn(JButton btn, Color HoverColor, Color DefaultColor) {
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(HoverColor);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(DefaultColor);
            }
        });
    }

    
    
    static JButton btnBefore = null; // lưu button đã chọn trước đó
    public static void setBtnBefore(JButton btn) {
        btnBefore = btn; //thiết lập button trước
    }
    //overloading thêm một tham số ChooseColor giúp đổi màu sau khi chọn JButton
    public static void HoverBtn(JButton btn, Color HoverColor, Color DefaultColor, Color ChooseColor) {
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (btn != btnBefore) {
                    btn.setBackground(HoverColor);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (btn != btnBefore) {
                    btn.setBackground(DefaultColor);
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (btnBefore != null) {
                    btnBefore.setBackground(DefaultColor);
                }
                btn.setBackground(ChooseColor);
                setBtnBefore(btn);
            }
        });
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------

    //kiểm tra JTextField có phải rỗng, nếu rỗng sẽ hiện thông báo nội dung "arlert" và trả về true
    public static boolean TextFieldIsEmpty(JTextField tf, String alert) {
        if (tf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập " + alert);
            tf.requestFocus();
            return true;
        }
        return false;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------
    
    public static boolean TextFieldIsEmpty(JTextField tf, String alert, String holder) {
        if (tf.getText().isEmpty() || tf.getText().equals(holder)) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập " + alert);
            tf.requestFocus();
            return true;
        }
        return false;
    }
    
    
    
}
