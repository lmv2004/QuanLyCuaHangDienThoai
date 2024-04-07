/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class PhieuNhapDTO extends PhieuDTO{
    private String NCC;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(String NCC) {
        this.NCC = NCC;
    }

    public PhieuNhapDTO(String NCC, String MaPhieu, String NhanVien, String ThoiGian, int TongTien) {
        super(MaPhieu, NhanVien, ThoiGian, TongTien);
        this.NCC = NCC;
    }

    public String getNCC() {
        return NCC;
    }

    public void setNCC(String NCC) {
        this.NCC = NCC;
    }
    
}
