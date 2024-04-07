/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class PhieuXuatDTO extends PhieuDTO{
    private String KhachHang;

    public PhieuXuatDTO() {
    }

    public PhieuXuatDTO(String KhachHang) {
        this.KhachHang = KhachHang;
    }

    public PhieuXuatDTO(String KhachHang, String MaPhieu, String NhanVien, String ThoiGian, int TongTien) {
        super(MaPhieu, NhanVien, ThoiGian, TongTien);
        this.KhachHang = KhachHang;
    }

    public String getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(String KhachHang) {
        this.KhachHang = KhachHang;
    }
}
