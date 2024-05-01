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
import javax.swing.JTable;

/**
 *
 * @author Danny
 */
public class WarrantyBUS {
    
    private ArrayList<WarrantyDTO> data;
    WarrantyDAO warrantyDAO = new WarrantyDAO();

    public WarrantyBUS() {
        data = warrantyDAO.selecAll();
    }

    public ArrayList<WarrantyDTO> getAll() {
        return warrantyDAO.selecAll();
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

    public void pouringData(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        int i = 1;
        for (WarrantyDTO warranty : data) {
            Vector vector = new Vector();
            vector.add(i);
            vector.add(warranty.getMaSanPham());
            vector.add(warranty.getMaBaoHanh());
            vector.add(warranty.getTenKhachHang());
            vector.add(warranty.getYeuCauBaoHanh());
            vector.add(warranty.getTrangThai());
            vector.add(warranty.getNgayBaoHanh());
        }

        tbl.setModel(model);
        tbl.repaint();
        tbl.revalidate();
    }

    // TODO: implement search
    // public ArrayList<WarrantyDTO> search(String type, String keyword) {
        
    // }
}
