package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

public class SanPhamBUS {
    private final SanPhamDAO SPDAO = new SanPhamDAO();
    private final PhienBanSanPhamBUS pbspBUS = new PhienBanSanPhamBUS();
    private ArrayList<SanPhamDTO> listSp = new ArrayList<>();

    public SanPhamBUS() {
        listSp = SPDAO.selecAll();
    }
    public SanPhamDTO getByIndex(int index) {
        return this.listSp.get(index);
    }

    public ArrayList<SanPhamDTO> getAll() {
        return this.listSp;
    }
     public static SanPhamBUS getInstance() {
        return new SanPhamBUS();
    }

    public ArrayList<SanPhamDTO> getAllSanPhamAttribute() {
        return SPDAO.getAllSanPhamFullThongTin();
    }
    
    public SanPhamDTO getByID(int maSP) {
        for (SanPhamDTO sp : listSp) {
            if (sp.getMasp() == maSP) {
                return sp;
            }
        }
        return null;
    }
    
    public boolean add(SanPhamDTO sanPham) {
        if (SPDAO.insert(sanPham) != 0) {
            listSp.add(sanPham);
            return true;
        }
        return false;
    }
    
   public boolean delete(SanPhamDTO sanpham) {
    if (SPDAO.delete(sanpham) != 0) {
        listSp.removeIf(sp -> sp.getMasp() == sanpham.getMasp());
        return true;
    }
    return false;
}

    
    public boolean update(SanPhamDTO sanPham) {
        if (SPDAO.update(sanPham) != 0) {
            for (int i = 0; i < listSp.size(); i++) {
                if (listSp.get(i).getMasp() == sanPham.getMasp()) {
                    listSp.set(i, sanPham);
                    return true;
                }
            }
        }
        return false;
    }
    
    public ArrayList<SanPhamDTO> getByMKV(int makv){
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        for (SanPhamDTO i : this.listSp) {
            if (i.getKhuvuckho() == makv) {
                result.add(i);
            }
        }
        
        return result;
    }

    public ArrayList<SanPhamDTO> search(String type, String txt) {
    ArrayList<SanPhamDTO> result = new ArrayList<>();
    txt = txt.toLowerCase();
    switch (type) {
        case "Tất cả":
            for (SanPhamDTO i : listSp) {
                if (Integer.toString(i.getMasp()).contains(txt) ||
                    i.getTensp().toLowerCase().contains(txt) ||
                     Integer.toString(i.getXuatxu()).contains(txt) ||
                    i.getChipxuly().toLowerCase().contains(txt) ||
                    Integer.toString(i.getDungluongpin()).contains(txt) ||
                    Double.toString(i.getKichthuocman()).contains(txt) ||
                    Integer.toString(i.getHedieuhanh()).contains(txt) ||
                    Integer.toString(i.getPhienbanhdh()).contains(txt) ||
                    i.getCamerasau().toLowerCase().contains(txt) ||
                    i.getCameratruoc().toLowerCase().contains(txt) ||
                    Integer.toString(i.getThoigianbaohanh()).toLowerCase().contains(txt) ||

                  Integer.toString(i.getThuonghieu()).contains(txt) ||
                  Integer.toString(i.getKhuvuckho()).contains(txt) ||
                    Integer.toString(i.getSoluongton()).contains(txt)) {
                    result.add(i);
                }
            }
            break;

        case "Mã sản phẩm":
            for (SanPhamDTO i : listSp) {
                if (Integer.toString(i.getMasp()).contains(txt)) {
                    result.add(i);
                }
            }
            break;

        case "Tên sản phẩm":
            for (SanPhamDTO i : listSp) {
                if (i.getTensp().toLowerCase().contains(txt)) {
                    result.add(i);
                }
            }
            break;

        // Thêm các trường tìm kiếm khác nếu cần

        default:
            throw new AssertionError();
    }
    return result;
}

    public ArrayList<SanPhamDTO> search(String text){
        ArrayList<SanPhamDTO> ketqua=new ArrayList<>();
        text=text.toLowerCase();
        for(SanPhamDTO sp:SPDAO.getAllSanPhamFullThongTin()){
            if(sp.getTensp().toLowerCase().contains(text)){
                //System.out.println(sp);
                ketqua.add(sp);
            }
        }
        return ketqua;
    }
}
