/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class PhieuDTO {
    private String MaPhieu;
    private String NhanVien;
    private String ThoiGian;
    private int TongTien;

    public PhieuDTO() {
    }

    public PhieuDTO(String MaPhieu, String NhanVien, String ThoiGian, int TongTien) {
        this.MaPhieu = MaPhieu;
        this.NhanVien = NhanVien;
        this.ThoiGian = ThoiGian;
        this.TongTien = TongTien;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public String getNhanVien() {
        return NhanVien;
    }

    public void setNhanVien(String NhanVien) {
        this.NhanVien = NhanVien;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
}
