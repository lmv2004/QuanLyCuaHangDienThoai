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
    private int MaNV;
    private String TaiKhoan;
    private char[] MatKhau;
    private int MaNQ;
    private int TrangThai;

    public AccountDTO(int MaNV, String TaiKhoan, char[] MatKhau, int MaNQ, int TrangThai) {
        this.MaNV=MaNV;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.MaNQ=MaNQ;
        this.TrangThai=TrangThai;
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

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getMaNQ() {
        return MaNQ;
    }

    public void setMaNQ(int MaNQ) {
        this.MaNQ = MaNQ;
    }
    
    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
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

    @Override
    public String toString() {
        return TaiKhoan + '\n' + String.copyValueOf(MatKhau);
    }
}
