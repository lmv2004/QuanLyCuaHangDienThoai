/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;
import java.util.Date;

public class PhieuXuatDTO extends PhieuDTO{
    private int MKH;
    private KhachHangDTO KHDTO = new KhachHangDTO();

    public PhieuXuatDTO() {
    }

    public PhieuXuatDTO(int MKH) {
        this.MKH = MKH;
    }
    
    public PhieuXuatDTO(int MKH, int MaPhieu, int MNV, Date ThoiGian, long TongTien) {
        super(MaPhieu, MNV, ThoiGian, TongTien);
        this.MKH = MKH;
    }

    public PhieuXuatDTO(int MKH, int MaPhieu, int MNV, Date ThoiGian, long TongTien, ChiTietPhieuDTO ChiTiet) {
        super(MaPhieu, MNV, ThoiGian, TongTien, ChiTiet);
        this.MKH = MKH;
    }

    public int getMKH() {
        return MKH;
    }

    public void setMKH(int MKH) {
        this.MKH = MKH;
    }

    public KhachHangDTO getKHDTO() {
        return KHDTO;
    }

    public void setKHDTO(KhachHangDTO KHDTO) {
        this.KHDTO = KHDTO;
    }
    
    
    @Override
    public String toString() {
        return super.toString() + " " + new DAO.KhachHangDAO().selectById(MKH).getTenKhachHang();
    }
}
