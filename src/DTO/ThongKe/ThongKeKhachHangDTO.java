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
public class ThongKeKhachHangDTO {
    int makh;
    String tenkh;
    int soluongphieu;
    Long tongtien;

    public ThongKeKhachHangDTO(int makh, String tenkh, int soluongphieu, Long tongtien) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.soluongphieu = soluongphieu;
        this.tongtien = tongtien;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public int getSoluongphieu() {
        return soluongphieu;
    }

    public void setSoluongphieu(int soluongphieu) {
        this.soluongphieu = soluongphieu;
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
        hash = 37 * hash + this.makh;
        hash = 37 * hash + Objects.hashCode(this.tenkh);
        hash = 37 * hash + this.soluongphieu;
        hash = 37 * hash + Objects.hashCode(this.tongtien);
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
        final ThongKeKhachHangDTO other = (ThongKeKhachHangDTO) obj;
        if (this.makh != other.makh) {
            return false;
        }
        if (this.soluongphieu != other.soluongphieu) {
            return false;
        }
        if (!Objects.equals(this.tenkh, other.tenkh)) {
            return false;
        }
        return Objects.equals(this.tongtien, other.tongtien);
    }

    @Override
    public String toString() {
        return "ThongKeKhachHangDTO{" + "makh=" + makh + ", tenkh=" + tenkh + ", soluongphieu=" + soluongphieu + ", tongtien=" + tongtien + '}';
    }
    
    
}
