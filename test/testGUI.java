
import BUS.SanPhamBUS;
import DTO.SanPhamDTO;
import GUI.BanHangGUI;
import java.util.ArrayList;


public class testGUI {
    public static void main(String[] args) {
        SanPhamBUS spbus=new SanPhamBUS();
        ArrayList<SanPhamDTO> listsp=spbus.getAllSanPhamAttibute();
        for(SanPhamDTO sanpham:listsp){
            System.out.println(sanpham+"\n");
        }
    }
}
