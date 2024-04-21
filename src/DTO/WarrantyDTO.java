/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Danny
 */
public class WarrantyDTO {
    private int maSanPham;
    private int maBaoHanh;
    private String tenKhachHang;
    private String yeuCauBaoHanh;
    private int trangThai;
    private String ngayBaoHanh;

    
    public WarrantyDTO (int maSanPham, int maBaoHanh, String tenKhachHang, String yeuCauBaoHanh, int trangThai, String ngayBaoHanh) {
        this.maSanPham = maSanPham;
        this.maBaoHanh = maBaoHanh;
        this.tenKhachHang = tenKhachHang;
        this.yeuCauBaoHanh = yeuCauBaoHanh;
        this.trangThai = trangThai;
        this.ngayBaoHanh = ngayBaoHanh;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getMaBaoHanh() {
        return maBaoHanh;
    }

    public void setMaBaoHanh(int maBaoHanh) {
        this.maBaoHanh = maBaoHanh;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getYeuCauBaoHanh() {
        return yeuCauBaoHanh;
    }

    public void setYeuCauBaoHanh(String yeuCauBaoHanh) {
        this.yeuCauBaoHanh = yeuCauBaoHanh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    public String getNgayBaoHanh() {
        return ngayBaoHanh;
    }

    public void setNgayBaoHanh(String ngayBaoHanh) {
        this.ngayBaoHanh = ngayBaoHanh;
    }

    @Override
    public String toString() {
        return "WarrantyDTO{" + "\n" + "maSanPham=" + maSanPham + ", maBaoHanh=" + maBaoHanh + ", tenKhachHang=" + tenKhachHang + ", yeuCauBaoHanh=" + yeuCauBaoHanh + ", trangThai=" + trangThai + ", ngayBaoHanh=" + ngayBaoHanh + "\n" + '}';
    }
    
    

}
