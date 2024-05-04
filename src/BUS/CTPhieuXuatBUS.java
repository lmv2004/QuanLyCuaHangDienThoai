
package BUS;

import DAO.CTPhieuXuatDAO;
import DTO.ChiTietPhieuDTO;


public class CTPhieuXuatBUS {
    CTPhieuXuatDAO CTPXDAO=new CTPhieuXuatDAO();

    public CTPhieuXuatBUS() {
    }
    public boolean add(ChiTietPhieuDTO t){
        return CTPXDAO.insert(t)!= 0;
    }
}
