
package DTO.thuocTinhSanPham;

import java.util.Objects;


public class HeDieuHanhDTO {
      private int mahdh;
    private String tenhdh;

    public HeDieuHanhDTO() {
    }

    public HeDieuHanhDTO(String tenhdh) {
        this.tenhdh = tenhdh;
    }

    public HeDieuHanhDTO(int mahdh, String tenhdh) {
        this.mahdh = mahdh;
        this.tenhdh = tenhdh;
    }

    public int getMahdh() {
        return mahdh;
    }

    public void setMahdh(int mahdh) {
        this.mahdh = mahdh;
    }

    public String getTenhdh() {
        return tenhdh;
    }

    public void setTenhdh(String tenhdh) {
        this.tenhdh = tenhdh;
    }
    
    @Override
    public String toString() {
        return "HeDieuHanhDTO{" + "mahdh=" + mahdh + ", tenhdh=" + tenhdh + '}';
    }
    
}
