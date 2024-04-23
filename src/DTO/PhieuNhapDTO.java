/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author ACER
 */
public class PhieuNhapDTO extends PhieuDTO{
    private int NCC;
    private NhaCungCapDTO NCCDTO = new NhaCungCapDTO();

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(int NCC) {
        this.NCC = NCC;
    }

    public PhieuNhapDTO(int NCC, int MaPhieu, int MNV, Timestamp ThoiGian, long TongTien) {
        super(MaPhieu, MNV, ThoiGian, TongTien);
        this.NCC = NCC;
    }

    public int getNCC() {
        return NCC;
    }

    public void setNCC(int NCC) {
        this.NCC = NCC;
    }

    public NhaCungCapDTO getNCCDTO() {
        return NCCDTO;
    }

    public void setNCCDTO(NhaCungCapDTO NCCDTO) {
        this.NCCDTO = NCCDTO;
    }

    
    @Override
    public String toString() {
        return super.toString() + " " + new DAO.NhaCungCapDAO().selectById(NCC).getTenNCC();
    }
}
