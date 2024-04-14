/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccountDTO other = (AccountDTO) obj;
        if (!Objects.equals(this.TaiKhoan, other.TaiKhoan)) {
            return false;
        }
        return Arrays.equals(this.MatKhau, other.MatKhau);
    }
    
    
}
