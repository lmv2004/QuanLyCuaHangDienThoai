package BUS;

import DTO.NhaCungCapDTO;
import DAO.NhaCungCapDAO;
import java.awt.AWTEventMulticaster;
import java.util.ArrayList;

public class NhaCungCapBUS {
    
    private ArrayList<NhaCungCapDTO> DanhSachNCC = new ArrayList<>();
    private final NhaCungCapDAO NCCDAO = new NhaCungCapDAO();
    
    public static NhaCungCapBUS getInstance() {
        return new NhaCungCapBUS();
    }
    
    public NhaCungCapBUS () {
        DanhSachNCC = NCCDAO.selecAll();
    }
    
    public ArrayList<NhaCungCapDTO> getAllNhaCungCap() {
        return DanhSachNCC;
    }
    
    public NhaCungCapDTO getByIndex(int index) {
        return this.DanhSachNCC.get(index);
    }
    
    
    public String getNameByID(int ID) {
        for(NhaCungCapDTO x : DanhSachNCC) {
            if(x.getMaNCC()==ID) {
                return x.getTenNCC();
            }
        }
        return null;
    }
    
    public int getByID(int maNCC) {
        int vitri = -1;
        for (int i = 0; i < DanhSachNCC.size(); i++) {
            if (DanhSachNCC.get(i).getMaNCC() == maNCC) {
                vitri = i;
                break;
            }
        }
        return vitri;
    }
    
    public boolean add(NhaCungCapDTO nhacungcap) {
        if (NCCDAO.insert(nhacungcap) != 0) {
            DanhSachNCC.add(nhacungcap);
            return true;
        }
        return false;
    }
    
    public boolean delete(NhaCungCapDTO nhacungcap) {
        if (NCCDAO.delete(nhacungcap) != 0) {
            DanhSachNCC.remove(nhacungcap);
            return true;
        }
        return false;
    }
    
    public boolean edit(NhaCungCapDTO nhacungcap) {
        if (NCCDAO.update(nhacungcap) != 0) {
            for (int i = 0; i < DanhSachNCC.size(); i++) {
                if (DanhSachNCC.get(i).getMaNCC() == nhacungcap.getMaNCC()) {
                    DanhSachNCC.set(i, nhacungcap);
                    return true;
                }
            }
        }
        return false;
    }
    
    public ArrayList<NhaCungCapDTO> search(String type, String txt) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        txt = txt.toLowerCase();
        switch (type) {
            case "Tất cả":
                for (NhaCungCapDTO i : DanhSachNCC) {
                    if (Integer.toString(i.getMaNCC()).contains(txt) || i.getTenNCC().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
                break;

            case "Mã nhà cung cấp":
                for (NhaCungCapDTO i : DanhSachNCC) {
                    if (Integer.toString(i.getMaNCC()).contains(txt)) {
                        result.add(i);
                    }
                }
                break;
            case "Tên nhà cung cấp":
                for (NhaCungCapDTO i : DanhSachNCC) {
                    if (i.getTenNCC().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
        return result;
    }
    
    
    public ArrayList<NhaCungCapDTO> filterByName(String name) {
        ArrayList<NhaCungCapDTO> l = new ArrayList<>();
        for(NhaCungCapDTO x : getAllNhaCungCap()) {
            if(x.getTenNCC().equals(name)) {
                l.add(x);
            }
        }
        return l;
    }
}
