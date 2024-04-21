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
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        int i = 1;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        for (PhieuNhapDTO PN : data) {
            if (PN.getTrangthai() == 1) {
                Vector vector = new Vector();
                vector.add(i);
                vector.add(PN.getMaPhieu());
                vector.add(new DAO.NhaCungCapDAO().selectById(PN.getNCC()).getTenNCC());
                vector.add(new DAO.NhanVienDAO().selectByID(PN.getMNV()).getHoTen());
                vector.add(PN.getThoiGian());
                vector.add(decimalFormat.format(PN.getTongTien()));
                i++;
                model.addRow(vector);
            }
        }
        tbl.setModel(model);
        tbl.repaint();
        tbl.revalidate();
    }

    public static void pouringData(JTable tbl, ArrayList<PhieuNhapDTO> myArr) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        int i = 1;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        for (PhieuNhapDTO PN : myArr) {
            if (PN.getTrangthai() == 1) {
                Vector vector = new Vector();
                vector.add(i);
                vector.add(PN.getMaPhieu());
                vector.add(new DAO.NhaCungCapDAO().selectById(PN.getNCC()).getTenNCC());
                vector.add(new DAO.NhanVienDAO().selectByID(PN.getMNV()).getHoTen());
                vector.add(PN.getThoiGian());
                vector.add(decimalFormat.format(PN.getTongTien()));
                i++;
                model.addRow(vector);
            }
        }
        tbl.setModel(model);
    }

    public static ArrayList<PhieuNhapDTO> search(int n, String s) {
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
}
