/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class KhuVucKhoDTO {
     private int maKhuVuc;
    private String tenKhuVuc;
    private String ghiChu;
    private int trangThai;

    public KhuVucKhoDTO(int maKhuVuc, String tenKhuVuc, String ghiChu, int trangThai) {
        this.maKhuVuc = maKhuVuc;
        this.tenKhuVuc = tenKhuVuc;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public int getMaKhuVuc() {
        return maKhuVuc;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setMaKhuVuc(int maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "DTOKhuVucKho{" + "maKhuVuc=" + maKhuVuc + ", tenKhuVuc=" + tenKhuVuc + ", ghiChu=" + ghiChu + ", trangThai=" + trangThai + '}';
    }
}
