/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class SoLuongSPDTO {
    private SanPhamDTO SP;
    private int SL;

    public SoLuongSPDTO() {
    }

    public SoLuongSPDTO(SanPhamDTO SP, int SL) {
        this.SP = SP;
        this.SL = SL;
    }

    public SanPhamDTO getSP() {
        return SP;
    }

    public void setSP(SanPhamDTO SP) {
        this.SP = SP;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    @Override
    public String toString() {
        return "SoLuongSPDTO{" + "SP= " + ", SL=" + SL + '}';
    }
    
    
}
