/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.AccountDAO;
import DTO.AccountDTO;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ACER
 */
public class AccountBUS {
    private AccountDAO ACCDAO = new AccountDAO();
    public ArrayList<AccountDTO> getAll() {
        return ACCDAO.selecAll();
    }
    public AccountDTO check(String tk, char[] mk) {
        for(AccountDTO x : getAll()) {
            System.out.println(tk + " == " + x.getTaiKhoan() +"  &&  "+ String.copyValueOf(mk)+" == "+ String.copyValueOf(x.getMatKhau()));
            if(tk.equals(x.getTaiKhoan()) && String.copyValueOf(mk).equals(String.copyValueOf(x.getMatKhau()))) {
                return x;
            }
        }
        return null;
    }
}
