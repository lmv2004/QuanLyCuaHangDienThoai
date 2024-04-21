/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.*;
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
    
    static ArrayList<PhieuNhapDTO> data;
    
    
    public static void loadPhieuNhap() {
        data = new DAO.PhieuNhapDAO().selecAll();
    }
    
    
    public static void pouringData(JTable tbl) {
        //tbl.removeAll();
        DefaultTableModel model = (DefaultTableModel)tbl.getModel();
        int i=1;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        for(PhieuNhapDTO PN : data) {
            if(PN.getTrangthai()==1) {
                Vector vector = new Vector();
                vector.add(i);
                vector.add(PN.getMaPhieu());
                vector.add(PN.getNCC());
                vector.add(new DAO.NhanVienDAO().selectByID(PN.getMNV()).getHoTen());
                vector.add(PN.getThoiGian());
                vector.add(decimalFormat.format(PN.getTongTien()));
                i++;
                model.addRow(vector);
            }
        }
        tbl.setModel(model);
    }
}
