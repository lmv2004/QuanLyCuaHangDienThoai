/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;

public class PhieuXuatDTO extends PhieuDTO{
    private int MKH;

    public PhieuXuatDTO() {
    }

    public PhieuXuatDTO(int MKH) {
        this.MKH = MKH;
    }

    public PhieuXuatDTO(int MKH, int MaPhieu, int MNV, Timestamp ThoiGian, long TongTien) {
        super(MaPhieu, MNV, ThoiGian, TongTien);
        this.MKH = MKH;
    }

    public int getMKH() {
        return MKH;
    }

    public void setMKH(int MKH) {
        this.MKH = MKH;
    }

    @Override
    public String toString() {
        return super.toString();// + " " + new DAO.KhachHangDAO().selectByID(MKH).getHoTen();
    }

    
}
