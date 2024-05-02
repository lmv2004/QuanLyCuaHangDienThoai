/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DTO.WarrantyDTO;
import BUS.SanPhamBUS;
import BUS.WarrantyBUS;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author Danny
 */
public class Warranty extends javax.swing.JPanel {

    private WarrantyBUS warrantyBUS = new WarrantyBUS();
    private ArrayList<WarrantyDTO> WarrantyList = new ArrayList<>();

    private SanPhamBUS sanPhamBUS = new SanPhamBUS();
    private DefaultTableModel tblModel;


    /**
     * Creates new form Warranty
     */
    public Warranty() {
        initComponents();

        loadData(WarrantyList);
        loadCbbFilter();

    }

    public void loadData(ArrayList<WarrantyDTO> WarrantyList) {
        int i = 1;
        DefaultTableModel tblModel = (DefaultTableModel) List_Warranty.getModel();
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }

        for (WarrantyDTO warranty : WarrantyList) {
            tblModel.addRow(new Object[]{
                i++, 
                warranty.getMaSanPham(),
                warranty.getMaBaoHanh(),
                warranty.getTenKhachHang(),
                warranty.getYeuCauBaoHanh(),
                warranty.getTrangThai(),
                warranty.getNgayBaoHanh(),
            });
        }

        List_Warranty.setModel(tblModel);
    }

    public void loadCbbFilter() {
        toolBar.getCbbFilter().setModel(new DefaultComboBoxModel<>(new String[]{
            "Tất cả", "Mã sản phẩm", "Mã bảo hành", "Tên khách hàng", "Yêu cầu bảo hành", "Trạng thái bảo hành"
        }));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new GUI.toolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_Warranty = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1200, 720));

        List_Warranty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Mã Bảo Hành", "Tên Khách Hàng", "Yêu Cầu Bảo Hành", "Trạng Thái Bảo Hành", "Ngày Bảo Hành"
            }
        ));
        List_Warranty.setRequestFocusEnabled(false);
        List_Warranty.setShowGrid(true);
        jScrollPane1.setViewportView(List_Warranty);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable List_Warranty;
    private javax.swing.JScrollPane jScrollPane1;
    protected GUI.toolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
