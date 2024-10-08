package BUS;

import DAO.PhieuNhapDAO;
import DTO.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class PhieuNhapBUS {

    private ArrayList<PhieuNhapDTO> data;
    PhieuNhapDAO PNDAO = new PhieuNhapDAO();

    public PhieuNhapBUS() {
        data = PNDAO.selecAll();
    }

    public ArrayList<PhieuNhapDTO> getAllPhieuNhap() {
        return PNDAO.selecAll();
    }
    
    public PhieuNhapDTO getByID(int ID) {
        return PNDAO.selectById(ID);
    }
    
    public int add(PhieuNhapDTO phieuNhap) {
        return PNDAO.insert(phieuNhap);
    }
    
    public boolean delete(PhieuNhapDTO phieuNhap) {
        if(PNDAO.delete(phieuNhap)!=0) {
            return true;
        }
        return false;
    }
    
    public boolean edit(PhieuNhapDTO phieuNhapEdited) {
        if(PNDAO.update(phieuNhapEdited)!=0) {
            return true;
        }
        return false;
    }

    public ArrayList<PhieuNhapDTO> search(int n, String s) {
        ArrayList<DTO.PhieuNhapDTO> myArr = new ArrayList<>();
        s = s.toLowerCase();
        if (n == 0) {
            for (PhieuNhapDTO x : data) {
                if (x.toString().toLowerCase().contains(s)) {
                    myArr.add(x);
                }
            }
            return myArr;
        }
        if (n == 1) {
            for (PhieuNhapDTO x : data) {
                try {
                    if (Integer.parseInt(s)==x.getMaPhieu()) {
                        myArr.add(x);
                    }
                } catch (Exception e) {
                    System.out.println("s không phải số nguyên");
                }
                
            }
            return myArr;
        }
        if(n==2) {
            for(PhieuNhapDTO x : data) {
                if(new DAO.NhaCungCapDAO().selectById(x.getNCC()).getTenNCC().toLowerCase().contains(s)) {
                    myArr.add(x);
                }
            }
            return myArr;
        }
        if (n == 3) {
            for (PhieuNhapDTO x : data) {
                if (new DAO.NhanVienDAO().selectByID(x.getMNV()).getHoTen().toLowerCase().contains(s)) {
                    myArr.add(x);
                }
            }
            return myArr;
        }
        return null;
    }
    
    public void filterByName(String name) {
        
    }
    
    public int getID() {
        return PNDAO.getAutoIncrement();
    }
    
    
}
