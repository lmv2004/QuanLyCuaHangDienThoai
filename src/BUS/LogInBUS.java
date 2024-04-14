/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.AccountDTO;
import GUI.MainMenuGUI;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class LogInBUS {
    public static void LogIn(JFrame jf,String tk, char[] mk) {
        DTO.AccountDTO acc = new AccountDTO(tk, mk);
        if(DAO.LogInDAO.check(acc)) {
            jf.dispose();
            new MainMenuGUI().setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
        }
    }
}
