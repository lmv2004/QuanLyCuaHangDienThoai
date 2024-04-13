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
public class PhieuNhapDTO extends PhieuDTO{
    private int NCC;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(int NCC) {
        this.NCC = NCC;
    }

    public PhieuNhapDTO(int NCC, int MaPhieu, int MNV, Timestamp ThoiGian, long TongTien, int trangthai) {
        super(MaPhieu, MNV, ThoiGian, TongTien,trangthai);
        this.NCC = NCC;
    }

    public int getNCC() {
        return NCC;
    }

    public void setNCC(int NCC) {
        this.NCC = NCC;
    }

    @Override
    public String toString() {
        return super.toString() + ", NCC=" + NCC;
    }
}
