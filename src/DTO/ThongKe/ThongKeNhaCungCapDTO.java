/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.ThongKe;

import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class ThongKeNhaCungCapDTO {
    int mancc;
    String tenncc;
    int soluongnhap;
    Long tongtien;

    public ThongKeNhaCungCapDTO(int mancc, String tenncc, int soluongnhap, Long tongtien) {
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.soluongnhap = soluongnhap;
        this.tongtien = tongtien;
    }

    public int getMancc() {
        return mancc;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public int getSoluongnhap() {
        return soluongnhap;
    }

    public void setSoluongnhap(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public Long getTongtien() {
        return tongtien;
    }

    public void setTongtien(Long tongtien) {
        this.tongtien = tongtien;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.mancc;
        hash = 89 * hash + Objects.hashCode(this.tenncc);
        hash = 89 * hash + this.soluongnhap;
        hash = 89 * hash + Objects.hashCode(this.tongtien);
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
        final ThongKeNhaCungCapDTO other = (ThongKeNhaCungCapDTO) obj;
        if (this.mancc != other.mancc) {
            return false;
        }
        if (this.soluongnhap != other.soluongnhap) {
            return false;
        }
        if (!Objects.equals(this.tenncc, other.tenncc)) {
            return false;
        }
        return Objects.equals(this.tongtien, other.tongtien);
    }

    @Override
    public String toString() {
        return "ThongKeNhaCungCapDTO{" + "mancc=" + mancc + ", tenncc=" + tenncc + ", soluongnhap=" + soluongnhap + ", tongtien=" + tongtien + '}';
    }
    
    
}
