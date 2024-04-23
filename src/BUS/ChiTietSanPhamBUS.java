
package BUS;

import DAO.ChiTietSanPhamDAO;
import DTO.ChiTietSanPhamDTO;
import DTO.PhienBanSanPhamDTO;
import java.util.ArrayList;


public class ChiTietSanPhamBUS {
    private final ChiTietSanPhamDAO ctspDao=new ChiTietSanPhamDAO();
    public PhienBanSanPhamBUS pbspbus = new PhienBanSanPhamBUS();
    public ArrayList<PhienBanSanPhamDTO> listpbsp;
    public ArrayList<ChiTietSanPhamDTO> listctsp = new ArrayList<>();

    public ChiTietSanPhamBUS() {
        
    }
    public ArrayList<ChiTietSanPhamDTO> getAllByPBSP(int pbsp){
        listctsp=ctspDao.selectAllbyPb(pbsp);
        return listctsp;
    }
    public ArrayList<ChiTietSanPhamDTO> getAll(){
        return this.listctsp;
    }
      public ChiTietSanPhamDTO getByIndex(int index) {
        return this.listctsp.get(index);
    }
    public ArrayList<ChiTietSanPhamDTO> getAllCTSPbyMasp(int masp) {
        ArrayList<ChiTietSanPhamDTO> list2 = new ArrayList<>();
        ArrayList<PhienBanSanPhamDTO> list = pbspbus.getAll(masp);
        for (PhienBanSanPhamDTO i : list) {
            ArrayList<ChiTietSanPhamDTO> ctsptemp = this.getAllByPBSP(i.getMaphienbansp());
            list2.addAll(ctsptemp);
        }
        return list2;
    }
}
