package DTO;

public class PermissionManagerDTO {
    private int maNhomQuyen;
    private String tenNhomQuyen;
    private int trangThai;

    public PermissionManagerDTO(int maNhomQuyen, String tenDangNhap, int trangThai) {
        this.maNhomQuyen = maNhomQuyen;
        this.tenNhomQuyen = tenDangNhap;
        this.trangThai = trangThai;
    }

    public int getMaNhomQuyen() {
        return maNhomQuyen;
    }

    public void setMaNhomQuyen(int maNhomQuyen) {
        this.maNhomQuyen = maNhomQuyen;
    }

    public String getTenNhomQuyen() {
        return tenNhomQuyen;
    }

    public void setTenNhomQuyen(String tenNhomQuyen) {
        this.tenNhomQuyen = tenNhomQuyen;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PermissionManagerDTO{" + "maNhomQuyen=" + maNhomQuyen + ", tenNhomQuyen=" + tenNhomQuyen
                + ", trangThai=" + trangThai + '}';
    }

}
