/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author ACER
 */
public class PhieuDTO {
    private int MaPhieu;
    private int MNV;
    private Timestamp ThoiGian;
    private long TongTien;
    private int trangthai=1;

    public PhieuDTO() {
    }

    public PhieuDTO(int MaPhieu, int MNV, Timestamp ThoiGian, long TongTien) {
        this.MaPhieu = MaPhieu;
        this.MNV = MNV;
        this.ThoiGian = ThoiGian;
        this.TongTien = TongTien;
    }

    public int getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(int MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public int getMNV() {
        return MNV;
    }

    public void setMNV(int MNV) {
        this.MNV = MNV;
    }

    public Timestamp getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Timestamp ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    @Override
    public String toString() {
        return "\nMaPhieu=" + MaPhieu + ", MNV=" + MNV + ", ThoiGian=" + ThoiGian + ", TongTien=" + TongTien;
    }
    
}
