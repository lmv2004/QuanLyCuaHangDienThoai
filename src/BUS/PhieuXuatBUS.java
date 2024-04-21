/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.PhieuXuatDTO;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class PhieuXuatBUS {
    static ArrayList<PhieuXuatDTO> data;
    
    
    public static void loadPhieuXuat() {
        data = new DAO.PhieuXuatDAO().selecAll();
    }
    
    
    public static void pouringData(JTable tbl) {
        //tbl.removeAll();
        DefaultTableModel model = (DefaultTableModel)tbl.getModel();
        int i=1;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        for(PhieuXuatDTO PX : data) {
            if(PX.getTrangthai()==1) {
                Vector vector = new Vector();//"STT", "Mã phiếu xuất", "Khách hàng", "Nhân viên xuất", "Thời gian", "Tổng tiền (VNĐ)"
                vector.add(i);
                vector.add(PX.getMaPhieu());
                vector.add(PX.getMKH());//new DAO.KhachHangDAO().selectByID(PX.getMKH()).getHoTen()
                vector.add(new DAO.NhanVienDAO().selectByID(PX.getMNV()).getHoTen());
                vector.add(PX.getThoiGian());
                vector.add(decimalFormat.format(PX.getTongTien()));
                i++;
                model.addRow(vector);
            }
        }
        tbl.setModel(model);
    }
}
