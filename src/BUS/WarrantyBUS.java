/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.WarrantyDAO;
import DTO.WarrantyDTO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import javax.swing.JTable;

/**
 *
 * @author Danny
 */
public class WarrantyBUS {

    private final WarrantyDAO warrantyDAO = new WarrantyDAO();
    private ArrayList<WarrantyDTO> ListWarrantyDAO = new ArrayList<>();

    public WarrantyBUS getInstance() {
        return new WarrantyBUS();
    }

    public WarrantyBUS() {
        ListWarrantyDAO = warrantyDAO.selecAll();
    }

    public ArrayList<WarrantyDTO> getAll() {
        return ListWarrantyDAO;
    }

    public WarrantyDTO getByIndex(int index) {
        return this.ListWarrantyDAO.get(index);
    }

    public int getByMaBH(int mabaohanh) {
        int vitri = -1;
        int i = 0;
        while (i < this.ListWarrantyDAO.size() && vitri == -1) {
            if (ListWarrantyDAO.get(i).getMaBaoHanh() == mabaohanh) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public int getByMaSP(int masanpham) {
        int vitri = -1;
        int i = 0;
        while (i < this.ListWarrantyDAO.size() && vitri == -1) {
            if (ListWarrantyDAO.get(i).getMaSanPham() == masanpham) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public boolean add(WarrantyDTO warranty) {
        if (warrantyDAO.insert(warranty) != 0) {
            return true;
        }
        return false;
    }

    public boolean delete(WarrantyDTO warranty) {
        if (warrantyDAO.delete(warranty) != 0) {
            return true;
        }
        return false;
    }

    public boolean edit(WarrantyDTO warrantyEdited) {
        if (warrantyDAO.update(warrantyEdited) != 0) {
            return true;
        }
        return false;
    }

    public ArrayList<WarrantyDTO> search(String type, String txt) {
        ArrayList<WarrantyDTO> result = new ArrayList<>();
        txt = txt.toLowerCase();
        switch (type) {
            case "Tất cả":
                for (WarrantyDTO i : ListWarrantyDAO) {
                    if (Integer.toString(i.getMaBaoHanh()).contains(txt) || 
                        i.getTenKhachHang().toLowerCase().contains(txt) || 
                        i.getYeuCauBaoHanh().toLowerCase().contains(txt) || 
                        i.getNgayBaoHanh().contains(txt)) {
                        result.add(i);
                    }
                }
                
                break;
            case "Mã sản phẩm" :
                for (WarrantyDTO i : ListWarrantyDAO) {
                    if(Integer.toString(i.getMaSanPham()).contains(txt)){
                        result.add(i);
                    }
                }
                break;

            case "Mã bảo hành" :
                for (WarrantyDTO i : ListWarrantyDAO) {
                    if(Integer.toString(i.getMaBaoHanh()).contains(txt)){
                        result.add(i);
                    }
                }
                break;

            case "Tên khách hàng" :
                for (WarrantyDTO i : ListWarrantyDAO) {
                    if(i.getTenKhachHang().toLowerCase().contains(txt)){
                        result.add(i);
                    }
                }
                break;

            case "Yêu cầu bảo hành" :
                for (WarrantyDTO i : ListWarrantyDAO) {
                    if(i.getYeuCauBaoHanh().toLowerCase().contains(txt)){
                        result.add(i);
                    }
                }
                break;

            case "Trạng thái bảo hành" :
                for (WarrantyDTO i : ListWarrantyDAO) {
                    if(Integer.toString(i.getTrangThai()).contains(txt)){
                        result.add(i);
                    }
                }
                break;

            default:
                throw new AssertionError();
        }
        return result;
    }
}

