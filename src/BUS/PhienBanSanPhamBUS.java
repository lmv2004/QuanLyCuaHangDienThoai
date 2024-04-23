
package BUS;

import DAO.PhienBanSanPhamDAO;
import DTO.ChiTietSanPhamDTO;
import DTO.PhienBanSanPhamDTO;
import java.util.ArrayList;

public class PhienBanSanPhamBUS {
    private final PhienBanSanPhamDAO pbspDAO=new PhienBanSanPhamDAO();
   private ArrayList<PhienBanSanPhamDTO> listPbsp=new ArrayList<>();
    public PhienBanSanPhamBUS() {
        
    }
    public ArrayList<PhienBanSanPhamDTO> getAll(int masp){
        return pbspDAO.selectAll(masp);
    }
    public boolean add(PhienBanSanPhamDTO pbsp){
        boolean check=pbspDAO.insert(pbsp)!=0;
        if(check){
            this.listPbsp.add(pbsp);
        }
        return check;
    }
     public  boolean checkDup( String name) {
        boolean check = false;
        int i = 0;
        while(i < this.listPbsp.size() && check==true){
            if(listPbsp.get(i).equals(name)){
                check=true;
            }else i++;
        }
        return check;
    }
    public PhienBanSanPhamDTO getByMaPhienBan(int mapb){
        return pbspDAO.selectById(mapb);
    }
    public int getSoLuong(int maphienban){
        return pbspDAO.selectById(maphienban).getSoluongton();
    }
    public boolean checkImeiExist(ArrayList<ChiTietSanPhamDTO> arr){
        return pbspDAO.checkImeiExist(arr);
    }
}
