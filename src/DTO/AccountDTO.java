/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class AccountDTO {
    private String TaiKhoan;
    private char[] MatKhau;

    public AccountDTO(String TaiKhoan, char[] MatKhau) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
    }

    public AccountDTO() {
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public char[] getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(char[] MatKhau) {
        this.MatKhau = MatKhau;
    }
    
    
}
