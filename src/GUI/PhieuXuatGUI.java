/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.PhieuXuatBUS;
import DTO.AccountDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.PhieuDTO;
import DTO.PhieuNhapDTO;
import DTO.PhieuXuatDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class PhieuXuatGUI extends PhieuNhapGUI {

    private PhieuXuatBUS PXBUS = new PhieuXuatBUS();
    private NhanVienBUS NVBUS = new NhanVienBUS();
    private KhachHangBUS KHBUS = new KhachHangBUS();
    private ArrayList<PhieuXuatDTO> listPX = PXBUS.getAll();
    private ArrayList<NhanVienDTO> listNV = NVBUS.getAllNhanVien();

    public PhieuXuatGUI(AccountDTO myAcc) {
        super(myAcc);
        toolBar.getAddBtn().setVisible(false);
        repaint();
        revalidate();

        labelNCC.setText("Khách hàng");
        labelNV.setText("Nhân viên xuất");
        tblDSPN.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Mã phiếu", "Khách hàng", "Nhân viên", "Thời gian", "Tổng tiền (VNĐ)"
                }));
        loadDataPX(listPX);
    }

    @Override
    public void loadCbbNhaCungCap() {
        for (KhachHangDTO x : listKH) {
            cbbNCC.addItem(x.getTenKhachHang());
        }
    }

    @Override
    public void loadData(ArrayList<PhieuNhapDTO> listPN) {
    }

    @Override
    public void eventRefresh() {
        removeAll();
        add(new PhieuXuatGUI(myAcc));
        loadDataPX(listPX);
        repaint();
        revalidate();
    }

    public void loadDataPX(ArrayList<PhieuXuatDTO> listPX) {
        int i = 1;
        DefaultTableModel tblModel = (DefaultTableModel) tblDSPN.getModel();
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        for (PhieuXuatDTO x : listPX) {
            x = (PhieuXuatDTO) x;
            tblModel.addRow(new Object[]{i++, x.getMaPhieu(), KHBUS.getNameByID(x.getMKH()), NVBUS.getNameByID(x.getMNV()), x.getThoiGian(), decimalFormat.format(x.getTongTien())});
        }
        System.out.println();
        tblDSPN.setModel(tblModel);
    }

    @Override
    public void loadCbbFilter() {
        toolBar.getCbbFilter().setModel(new DefaultComboBoxModel(new String[]{
            "Tất cả", "Mã phiếu", "Tên khách hàng", "Tên nhân viên"
        }));
    }


    @Override
    public void loadCbbNhanVien() {
        super.loadCbbNhanVien();
    }

    @Override
    public void setEvent() {
        super.setEvent();
        ActionListener[] actionListeners = toolBar.getDetailBtn().getActionListeners();
        for (ActionListener listener : actionListeners) {
            toolBar.getDetailBtn().removeActionListener(listener);
        }
        toolBar.getDetailBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tblDSPN.getSelectedRow();
                if (index < 0) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn phiếu xuất");
                    return;
                }
                new GUI.Dialog.ChiTietPhieuXuatDialog(null, true, listPX.get(index)).setVisible(true);
            }

        });
        
        
        
        ActionListener[] actionListeners2 = toolBar.getRemoveBtn().getActionListeners();
        for (ActionListener listener : actionListeners2) {
            toolBar.getRemoveBtn().removeActionListener(listener);
        }
        toolBar.getRemoveBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn hủy phiếu?") == 0) {
                    int index = tblDSPN.getSelectedRow();
                    if (index < 0) {
                        JOptionPane.showMessageDialog(null, "Bạn chưa chọn phiếu xuất");
                        return;
                    }
                    PXBUS.delete(listPX.get(tblDSPN.getSelectedRow()));
                    listPX.remove(tblDSPN.getSelectedRow());
                    loadDataPX(listPX);
                    JOptionPane.showMessageDialog(null, "Hủy phiếu xuất thành công!");
                }
            }

        });
        
        ActionListener[] actionListeners3 = toolBar.getEditBtn().getActionListeners();
        for (ActionListener listener : actionListeners3) {
            toolBar.getEditBtn().removeActionListener(listener);
        }
        toolBar.getEditBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tblDSPN.getSelectedRow();
                if (index < 0) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn phiếu xuất");
                    return;
                }
                new GUI.Dialog.SuaPhieuXuatDialog(null, true, myAcc, listPX.get(index)).setVisible(true);
            }
        });
    }
    
    ArrayList<PhieuXuatDTO> listPXFilter;
    Iterator<PhieuXuatDTO> iterator10;
    @Override
    public void eventFilter() {
        listPXFilter = new ArrayList<>(listPX);
        iterator10 = listPXFilter.iterator();
        int KH = cbbNCC.getSelectedIndex();
        int MNV = cbbNVN.getSelectedIndex();

        if (KH != 0) {
            while (iterator10.hasNext()) {
                PhieuXuatDTO PX = iterator10.next();
                if (listKH.get(KH - 1).getMaKhachHang() != PX.getMKH()) {
                    iterator10.remove();
                }
            }
        }
        if (MNV != 0) {
            Iterator<PhieuXuatDTO> iterator2 = listPXFilter.iterator();
            while (iterator2.hasNext()) {
                PhieuXuatDTO PX = iterator2.next();
                if (listNV.get(MNV - 1).getManv() != PX.getMNV()) {
                    iterator2.remove();
                }
            }
        }
        if (filterByDate() == false) {
            return;
        }
        filterByPrice();
        //final
        loadDataPX(listPXFilter);
    }

    @Override
    public boolean filterByDate() {
        Iterator<PhieuXuatDTO> iterator3 = listPXFilter.iterator();
        Date begin = jDateChooser1.getDate();
        Date end = jDateChooser2.getDate();
        if (begin != null && end != null) {
            if (begin.compareTo(end) >= 0) {
                JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải trước ngày kết thúc");
                jDateChooser1.setDate(null);
                jDateChooser2.setDate(null);
                return false;
            }
            while (iterator3.hasNext()) {
                PhieuXuatDTO PX = iterator3.next();
                //date1.compareto(date2) > 0   ->   date1 > date2
                if (PX.getThoiGian().compareTo(begin) < 0 || PX.getThoiGian().compareTo(end) > 0) {
                    iterator3.remove();
                }
            }
        }
        return true;
    }

    @Override
    public void filterByPrice() {
        Iterator<PhieuXuatDTO> iterator4 = listPXFilter.iterator();
        if (jTextField4.getText().isEmpty() || jTextField5.getText().isEmpty()) {
            return;
        }
        while (iterator4.hasNext()) {
            PhieuXuatDTO PX = iterator4.next();
            if (PX.getTongTien() < priceB || PX.getTongTien() > priceE) {
                iterator4.remove();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
