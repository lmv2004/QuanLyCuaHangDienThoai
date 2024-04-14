/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.AccountDTO;
import GUI.MainMenuGUI;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class LogInBUS {
    public static void LogIn(JFrame jf, boolean rememberMe,String tk, char[] mk) {
        DTO.AccountDTO myAcc = new AccountDTO(tk, mk);
        ArrayList<AccountDTO> accList = new DAO.AccountDAO().selecAll();
        for(AccountDTO acc : accList) {
            if(acc.equals(myAcc)) {
                ImageIcon success = new ImageIcon("src/img/passwordSuccess.png");
                JOptionPane.showMessageDialog(null, "Chào mừng "+tk, "Đăng nhập thành công", JOptionPane.ERROR_MESSAGE, success);
                if(rememberMe) {
                    RegisterFile.FileReadWrite.writeFile("\\D:\\Java\\QuanLyCuaHangDienThoai\\src\\RegisterFile\\RememberMe.txt", myAcc.toString());
                }
                else {
                    RegisterFile.FileReadWrite.writeFile("\\D:\\Java\\QuanLyCuaHangDienThoai\\src\\RegisterFile\\RememberMe.txt", "");
                }
                jf.dispose();
                new MainMenuGUI(myAcc).setVisible(true);
                return;
            }
        }
        ImageIcon error = new ImageIcon("src/img/passwordError.png");
        JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng", "Đăng nhập không thành công", JOptionPane.ERROR_MESSAGE, error);
    }
}
