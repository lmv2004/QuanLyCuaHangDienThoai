
package DTO;

import DTO.thuocTinhSanPham.DungLuongRamDTO;
import DTO.thuocTinhSanPham.DungLuongRomDTO;
import DTO.thuocTinhSanPham.HeDieuHanhDTO;
import DTO.thuocTinhSanPham.MauSacDTO;
import DTO.thuocTinhSanPham.ThuongHieuDTO;
import DTO.thuocTinhSanPham.XuatXuDTO;
import java.util.Objects;

public class SanPhamDTO {
    private int masp;
    private String tensp;
    private String hinhanh;
    private int xuatxu;
    private String chipxuly;
    private int dungluongpin;
    private double kichthuocman;
    private int hedieuhanh;
    private int phienbanhdh;
    private String camerasau;
    private String cameratruoc;
    private int thoigianbaohanh;
    private int thuonghieu;
    private int khuvuckho;
    private int soluongton;
    private PhienBanSanPhamDTO PBSPDTO=new PhienBanSanPhamDTO();
    private DungLuongRamDTO DLRamDTO=new DungLuongRamDTO();
    private DungLuongRomDTO DLRomDTO=new DungLuongRomDTO();
    private HeDieuHanhDTO HDHDTO=new HeDieuHanhDTO();
    private MauSacDTO MSDTO=new MauSacDTO();
    private ThuongHieuDTO THDTO=new ThuongHieuDTO();
    private XuatXuDTO XXDTO=new XuatXuDTO();
    public SanPhamDTO() {
    }

    public SanPhamDTO(int masp,String tensp, String hinhanh, String chipxuly, int dungluongpin, double kichthuocman, int phienbanhdh, String camerasau, String cameratruoc,int soluongton) {
        this.tensp = tensp;
        this.hinhanh = hinhanh;
        this.chipxuly = chipxuly;
        this.dungluongpin = dungluongpin;
        this.kichthuocman = kichthuocman;
        this.phienbanhdh = phienbanhdh;
        this.camerasau = camerasau;
        this.cameratruoc = cameratruoc;
        this.masp=masp;
        this.soluongton=soluongton;
    }

    public SanPhamDTO(int masp, String tensp, String hinhanh, int xuatxu, String chipxuly, int dungluongpin, double kichthuocman, int hedieuhanh, int phienbanhdh, String camerasau, String cameratruoc, int thoigianbaohanh, int thuonghieu, int khuvuckho, int soluongton) {
        this.masp = masp;
        this.tensp = tensp;
        this.hinhanh = hinhanh;
        this.xuatxu = xuatxu;
        this.chipxuly = chipxuly;
        this.dungluongpin = dungluongpin;
        this.kichthuocman = kichthuocman;
        this.hedieuhanh = hedieuhanh;
        this.phienbanhdh = phienbanhdh;
        this.camerasau = camerasau;
        this.cameratruoc = cameratruoc;
        this.thoigianbaohanh = thoigianbaohanh;
        this.thuonghieu = thuonghieu;
        this.khuvuckho = khuvuckho;
        this.soluongton = soluongton;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(int xuatxu) {
        this.xuatxu = xuatxu;
    }

    public String getChipxuly() {
        return chipxuly;
    }

    public void setChipxuly(String chipxuly) {
        this.chipxuly = chipxuly;
    }

    public int getDungluongpin() {
        return dungluongpin;
    }

    public void setDungluongpin(int dungluongpin) {
        this.dungluongpin = dungluongpin;
    }

    public double getKichthuocman() {
        return kichthuocman;
    }

    public void setKichthuocman(double kichthuocman) {
        this.kichthuocman = kichthuocman;
    }

    public int getHedieuhanh() {
        return hedieuhanh;
    }

    public void setHedieuhanh(int hedieuhanh) {
        this.hedieuhanh = hedieuhanh;
    }

    public int getPhienbanhdh() {
        return phienbanhdh;
    }

    public void setPhienbanhdh(int phienbanhdh) {
        this.phienbanhdh = phienbanhdh;
    }

    public String getCamerasau() {
        return camerasau;
    }

    public void setCamerasau(String camerasau) {
        this.camerasau = camerasau;
    }

    public String getCameratruoc() {
        return cameratruoc;
    }

    public void setCameratruoc(String cameratruoc) {
        this.cameratruoc = cameratruoc;
    }

    public int getThoigianbaohanh() {
        return thoigianbaohanh;
    }

    public void setThoigianbaohanh(int thoigianbaohanh) {
        this.thoigianbaohanh = thoigianbaohanh;
    }

    public int getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(int thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public int getKhuvuckho() {
        return khuvuckho;
    }

    public void setKhuvuckho(int khuvuckho) {
        this.khuvuckho = khuvuckho;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public PhienBanSanPhamDTO getPBSPDTO() {
        return PBSPDTO;
    }

    public void setPBSPDTO(PhienBanSanPhamDTO PBSPDTO) {
        this.PBSPDTO = PBSPDTO;
    }

    public DungLuongRamDTO getDLRamDTO() {
        return DLRamDTO;
    }

    public void setDLRamDTO(DungLuongRamDTO DLRamDTO) {
        this.DLRamDTO = DLRamDTO;
    }

    public DungLuongRomDTO getDLRomDTO() {
        return DLRomDTO;
    }

    public void setDLRomDTO(DungLuongRomDTO DLRomDTO) {
        this.DLRomDTO = DLRomDTO;
    }

    public HeDieuHanhDTO getHDHDTO() {
        return HDHDTO;
    }

    public void setHDHDTO(HeDieuHanhDTO HDHDTO) {
        this.HDHDTO = HDHDTO;
    }

    public MauSacDTO getMSDTO() {
        return MSDTO;
    }

    public void setMSDTO(MauSacDTO MSDTO) {
        this.MSDTO = MSDTO;
    }

    public ThuongHieuDTO getTHDTO() {
        return THDTO;
    }

    public void setTHDTO(ThuongHieuDTO THDTO) {
        this.THDTO = THDTO;
    }

    public XuatXuDTO getXXDTO() {
        return XXDTO;
    }

    public void setXXDTO(XuatXuDTO XXDTO) {
        this.XXDTO = XXDTO;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.masp;
        hash = 71 * hash + Objects.hashCode(this.tensp);
        hash = 71 * hash + Objects.hashCode(this.hinhanh);
        hash = 71 * hash + this.xuatxu;
        hash = 71 * hash + Objects.hashCode(this.chipxuly);
        hash = 71 * hash + this.dungluongpin;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.kichthuocman) ^ (Double.doubleToLongBits(this.kichthuocman) >>> 32));
        hash = 71 * hash + this.hedieuhanh;
        hash = 71 * hash + this.phienbanhdh;
        hash = 71 * hash + Objects.hashCode(this.camerasau);
        hash = 71 * hash + Objects.hashCode(this.cameratruoc);
        hash = 71 * hash + this.thoigianbaohanh;
        hash = 71 * hash + this.thuonghieu;
        hash = 71 * hash + this.khuvuckho;
        hash = 71 * hash + this.soluongton;
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
        final SanPhamDTO other = (SanPhamDTO) obj;
        if (this.masp != other.masp) {
            return false;
        }
        if (this.xuatxu != other.xuatxu) {
            return false;
        }
        if (this.dungluongpin != other.dungluongpin) {
            return false;
        }
        if (Double.doubleToLongBits(this.kichthuocman) != Double.doubleToLongBits(other.kichthuocman)) {
            return false;
        }
        if (this.hedieuhanh != other.hedieuhanh) {
            return false;
        }
        if (this.phienbanhdh != other.phienbanhdh) {
            return false;
        }
        if (this.thoigianbaohanh != other.thoigianbaohanh) {
            return false;
        }
        if (this.thuonghieu != other.thuonghieu) {
            return false;
        }
        if (this.khuvuckho != other.khuvuckho) {
            return false;
        }
        if (this.soluongton != other.soluongton) {
            return false;
        }
        if (!Objects.equals(this.tensp, other.tensp)) {
            return false;
        }
        if (!Objects.equals(this.hinhanh, other.hinhanh)) {
            return false;
        }
        if (!Objects.equals(this.chipxuly, other.chipxuly)) {
            return false;
        }
        if (!Objects.equals(this.camerasau, other.camerasau)) {
            return false;
        }
        return Objects.equals(this.cameratruoc, other.cameratruoc);
    }

    @Override
    public String toString() {
        return "SanPhamDTO{" + "tensp=" + tensp + ", hinhanh=" + hinhanh + ", chipxuly=" + chipxuly + ", dungluongpin=" + dungluongpin + ", kichthuocman=" + kichthuocman + ", phienbanhdh=" + phienbanhdh + ", camerasau=" + camerasau + ", cameratruoc=" + cameratruoc + ", thoigianbaohanh=" + thoigianbaohanh + ", PBSPDTO=" + PBSPDTO + ", DLRamDTO=" + DLRamDTO + ", DLRomDTO=" + DLRomDTO + ", HDHDTO=" + HDHDTO + ", MSDTO=" + MSDTO + ", THDTO=" + THDTO + ", XXDTO=" + XXDTO + '}';
    }

  

    
    
}
