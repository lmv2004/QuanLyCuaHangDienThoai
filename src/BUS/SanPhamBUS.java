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

    public ArrayList<SanPhamDTO> getAll() {
        return this.listSp;
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
    public ArrayList<SanPhamDTO> search(String text){
        ArrayList<SanPhamDTO> ketqua=new ArrayList<>();
        text=text.toLowerCase();
        for(SanPhamDTO sp:listSp){
            if(sp.getTensp().toLowerCase().contains(text)){
                System.out.println(sp);
                ketqua.add(sp);
            }
        }
        return ketqua;
    }
    
}
