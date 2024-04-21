/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author User
 */
//"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Ngày tham gia"
public class KhachHangDTO {
    
   private int MaKhachHang;
    private String TenKhachHang;
    private String DiaChi;
    private String SDT;
    private int TrangThai;
    private Date NgayThamGia;

    // Constructor
    public KhachHangDTO (){
    }
    public KhachHangDTO(int MaKhachHang, String TenKhachHang, String DiaChi, String SDT, int TrangThai, Date NgayThamGia) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.TrangThai = TrangThai;
        this.NgayThamGia = NgayThamGia;
    }

    // Getter và Setter cho MaKhachHang
    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    // Getter và Setter cho TenKhachHang
    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    // Getter và Setter cho DiaChi
    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    // Getter và Setter cho SDT
    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    // Getter và Setter cho TrangThai
    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    // Getter và Setter cho NgayThamGia
    public Date getNgayThamGia() {
        return NgayThamGia;
    }

    public void setNgayThamGia(Date NgayThamGia) {
        this.NgayThamGia = NgayThamGia;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "KhachHang{" +
                "MaKhachHang=" + MaKhachHang +
                ", TenKhachHang='" + TenKhachHang + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", SDT='" + SDT + '\'' +
                ", TrangThai=" + TrangThai +
                ", NgayThamGia=" + NgayThamGia +
                '}';
    }
    
}
