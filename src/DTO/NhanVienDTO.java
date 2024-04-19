
package DTO;
 import java.sql.Date;
import java.util.Objects;

public class NhanVienDTO {
    private int manv;
    private String hoTen;
    private int gioiTinh;
    private Date ngaySinh;
    private String SDT;
    private String Email;

    public NhanVienDTO() {
    }

    public NhanVienDTO(int manv, String hoTen, int gioiTinh, Date ngaySinh, String SDT) {
        this.manv = manv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
    }

    public NhanVienDTO(int manv, String hoTen, int gioiTinh, Date ngaySinh, String SDT, String Email) {
        this.manv = manv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
        this.Email = Email;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.manv;
        hash = 97 * hash + Objects.hashCode(this.hoTen);
        hash = 97 * hash + this.gioiTinh;
        hash = 97 * hash + Objects.hashCode(this.ngaySinh);
        hash = 97 * hash + Objects.hashCode(this.SDT);
        hash = 97 * hash + Objects.hashCode(this.Email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NhanVienDTO other = (NhanVienDTO) obj;
        if (this.manv != other.manv) {
            return false;
        }
        if (this.gioiTinh != other.gioiTinh) {
            return false;
        }
        if (!Objects.equals(this.hoTen, other.hoTen)) {
            return false;
        }
        if (!Objects.equals(this.SDT, other.SDT)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        return Objects.equals(this.ngaySinh, other.ngaySinh);
    }

    @Override
    public String toString() {
        return "NhanVienDTO{" + "manv=" + manv + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", SDT=" + SDT + ", Email=" + Email + '}';
    }
    
}
