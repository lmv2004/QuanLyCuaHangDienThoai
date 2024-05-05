
package BUS;

import DAO.CTPhieuXuatDAO;
import DTO.ChiTietPhieuDTO;
import java.util.ArrayList;


public class CTPhieuXuatBUS {
    CTPhieuXuatDAO CTPXDAO=new CTPhieuXuatDAO();

    public CTPhieuXuatBUS() {
    }
    public boolean add(ChiTietPhieuDTO t){
        return CTPXDAO.insert(t)!= 0;
    }
    
    public ArrayList<DTO.ChiTietPhieuDTO> getAllByID(int ID) {
        return CTPXDAO.selecAllByID(ID);
    }

    public boolean delete(ChiTietPhieuDTO CT) {
        if(CTPXDAO.delete(CT)>0) {
            return true;
        }
        return false;
    }
}
