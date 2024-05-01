/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author User
 */
//"Mã NCC", "Tên nhà cung cấp", "Địa chỉ", "Email", "Số điện thoại"
public class NhaCungCapDTO {
   private int MaNCC;
    private String TenNCC;
    private String DiaChi;
    private String Email;
    private String SDT;
    private int TrangThai;

    // Constructor
    
    public NhaCungCapDTO () {
        
    }
    public NhaCungCapDTO(int MaNCC, String TenNCC, String DiaChi, String Email, String SDT, int TrangThai) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.SDT = SDT;
        this.TrangThai = TrangThai;
    }


    // Getter và Setter cho MaNCC
    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }

    // Getter và Setter cho TenNCC
    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    // Getter và Setter cho DiaChi
    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    // Getter và Setter cho Email
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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

    // Phương thức toString
    @Override
    public String toString() {
        return "NhaCungCapDTO{" +
                "MaNCC=" + MaNCC +
                ", TenNCC='" + TenNCC + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", Email='" + Email + '\'' +
                ", SDT='" + SDT + '\'' +
                ", TrangThai=" + TrangThai +
                '}';
    }
}
