
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;


public class SanPhamBUS {
  private final SanPhamDAO SPDAO=new SanPhamDAO();
  private PhienBanSanPhamBUS pbspBUS=new PhienBanSanPhamBUS();
  private ArrayList<SanPhamDTO> listSp=new ArrayList<>();

    public SanPhamBUS() {
        listSp=SPDAO.selecAll();
    }
    public ArrayList<SanPhamDTO> getAll(){
        return this.listSp;
    }
    public ArrayList<SanPhamDTO> getAllSanPhamAttibute(){
        return SPDAO.getAllSanPhamFullThongTin();
    }
  
}
