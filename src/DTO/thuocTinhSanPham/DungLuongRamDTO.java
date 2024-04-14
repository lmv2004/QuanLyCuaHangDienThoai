
package DTO.thuocTinhSanPham;


public class DungLuongRamDTO {
     private int madlram;
    private int dungluongram;

    public DungLuongRamDTO() {
    }

    public DungLuongRamDTO(int madlram, int dungluongram) {
        this.madlram = madlram;
        this.dungluongram = dungluongram;
    }

    public int getMadlram() {
        return madlram;
    }

    public void setMadlram(int madlram) {
        this.madlram = madlram;
    }

    public int getDungluongram() {
        return dungluongram;
    }

    public void setDungluongram(int dungluongram) {
        this.dungluongram = dungluongram;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.madlram;
        hash = 59 * hash + this.dungluongram;
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
        final DungLuongRamDTO other = (DungLuongRamDTO) obj;
        if (this.madlram != other.madlram) {
            return false;
        }
        return this.dungluongram == other.dungluongram;
    }

    @Override
    public String toString() {
        return "DungLuongRamDTO{" + "madlram=" + madlram + ", dungluongram=" + dungluongram + '}';
    }
    
}
