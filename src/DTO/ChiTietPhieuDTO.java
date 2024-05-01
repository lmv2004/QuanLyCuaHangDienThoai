/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class ChiTietPhieuDTO {
    private int MaPhieu;
    private int MPBSP;
    private int SoLuong;
    private long DonGia;
    private int hinhthuc;
    
    public ChiTietPhieuDTO() {
    }

    public ChiTietPhieuDTO(int MaPhieu, int MPBSP, int SoLuong, long DonGia, int hinhthuc) {
        this.MaPhieu = MaPhieu;
        this.MPBSP = MPBSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.hinhthuc = hinhthuc;
    }

    

    public int getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(int MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public int getMPBSP() {
        return MPBSP;
    }

    public void setMPBSP(int MPBSP) {
        this.MPBSP = MPBSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public long getDonGia() {
        return DonGia;
    }

    public void setDonGia(long DonGia) {
        this.DonGia = DonGia;
    }

    public int getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(int hinhthuc) {
        this.hinhthuc = hinhthuc;
    }
    
}
