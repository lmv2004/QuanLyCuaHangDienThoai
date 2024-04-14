/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.AccountDTO;
import GUI.MainMenuGUI;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class LogInBUS {
    public static void LogIn(JFrame jf,String tk, char[] mk) {
        DTO.AccountDTO myAcc = new AccountDTO(tk, mk);
        ArrayList<AccountDTO> accList = new DAO.AccountDAO().selecAll();
        for(AccountDTO acc : accList) {
            if(acc.equals(myAcc)) {
                jf.dispose();
                new MainMenuGUI().setVisible(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
    }
}
