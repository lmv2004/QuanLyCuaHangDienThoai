package BUS;

import DTO.AccountDTO;
import GUI.MainMenuGUI;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LogInBUS {

    AccountBUS ACCBUS = new AccountBUS();

    public void LogIn(JFrame jf, boolean rememberMe, String tk, char[] mk) {
        AccountDTO myAcc = ACCBUS.check(tk, mk);
        if (myAcc != null) {
            JOptionPane.showMessageDialog(null, "Chào mừng " + tk, "Đăng nhập thành công", JOptionPane.ERROR_MESSAGE, new FlatSVGIcon("img/correct.svg", 80, 90));
            if (rememberMe) {
                RegisterFile.FileReadWrite.writeFile("src\\RegisterFile\\RememberMe.txt", myAcc.toString());
            } else {
                RegisterFile.FileReadWrite.writeFile("src\\RegisterFile\\RememberMe.txt", "");
            }
            jf.dispose();
            new MainMenuGUI(myAcc).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng", "Đăng nhập không thành công", JOptionPane.ERROR_MESSAGE, new FlatSVGIcon("img/incorrect.svg", 80, 90));
        }
    }
}
