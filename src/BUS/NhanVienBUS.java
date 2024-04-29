package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

public class NhanVienBUS {
    private ArrayList<NhanVienDTO> DanhSachNV = new ArrayList<>();
    private final NhanVienDAO NVDAO = new NhanVienDAO();
    
    
     public NhanVienBUS () {
         DanhSachNV = NVDAO.selecAll();
     }
     
      public NhanVienBUS getinstance() {
         return new NhanVienBUS();
     }
    public ArrayList<NhanVienDTO> getAllNhanVien() {
        return NVDAO.selecAll();
    }
    
    public NhanVienDTO getByIndex(int Index) {
        return NVDAO.selectByID(Index);
    }
    
    
    public int getByID(int maNV) {
        int vitri = -1;
        int i = 0;
        while (i < this.DanhSachNV.size() && vitri == -1) {
            if (DanhSachNV.get(i).getManv() == maNV) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public boolean add(NhanVienDTO nhanvien) {
        if(NVDAO.insert(nhanvien) != 0) {
            DanhSachNV.add(nhanvien);
            return true;
        }
        return false;
    }

    public boolean delete(NhanVienDTO nhanvien) {
        if (NVDAO.delete(nhanvien) != 0) {
            DanhSachNV.remove(nhanvien);
            return true;
        }
        return false;
    }

    public boolean edit(NhanVienDTO nhanvien) {
        if (NVDAO.update(nhanvien) != 0) {
            for (int i = 0; i < DanhSachNV.size(); i++) {
                if (DanhSachNV.get(i).getManv() == nhanvien.getManv()) {
                    DanhSachNV.set(i, nhanvien);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    public ArrayList<NhanVienDTO> search(String type, String txt) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        txt = txt.toLowerCase();
        switch (type) {
            case "Tất cả":
                for (NhanVienDTO i : DanhSachNV) {
                    if (Integer.toString(i.getManv()).contains(txt) || i.getHoTen().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
                break;

            case "Mã nhân viên":
                for (NhanVienDTO i : DanhSachNV) {
                    if (Integer.toString(i.getManv()).contains(txt)) {
                        result.add(i);
                    }
                }
                break;
            case "Tên nhân viên":
                for (NhanVienDTO i : DanhSachNV) {
                    if (i.getHoTen().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }

        return result;
    }
}
