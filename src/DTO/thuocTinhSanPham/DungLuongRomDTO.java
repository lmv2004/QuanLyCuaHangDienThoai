
package DTO.thuocTinhSanPham;


public class DungLuongRomDTO {
     private int madungluongrom;
    private int dungluongrom;

    public DungLuongRomDTO() {
    }

    public DungLuongRomDTO(int dungluongrom) {
        this.dungluongrom = dungluongrom;
    }

    public DungLuongRomDTO(int madungluongrom, int dungluongrom) {
        this.madungluongrom = madungluongrom;
        this.dungluongrom = dungluongrom;
    }

    public int getMadungluongrom() {
        return madungluongrom;
    }

    public void setMadungluongrom(int madungluongrom) {
        this.madungluongrom = madungluongrom;
    }

    public int getDungluongrom() {
        return dungluongrom;
    }

    public void setDungluongrom(int dungluongrom) {
        this.dungluongrom = dungluongrom;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.madungluongrom;
        hash = 89 * hash + this.dungluongrom;
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
        final DungLuongRomDTO other = (DungLuongRomDTO) obj;
        if (this.madungluongrom != other.madungluongrom) {
            return false;
        }
        return this.dungluongrom == other.dungluongrom;
    }

    @Override
    public String toString() {
        return "DungLuongRomDTO{" + "madungluongrom=" + madungluongrom + ", dungluongrom=" + dungluongrom + '}';
    }
    
}
