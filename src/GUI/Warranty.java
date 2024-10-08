/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DTO.WarrantyDTO;
import GUI.Dialog.WarrantyDialog;
import BUS.PermissionManagerBUS;
import BUS.SanPhamBUS;
import BUS.WarrantyBUS;

import java.text.DecimalFormat;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Danny
 */
public class Warranty extends javax.swing.JPanel {

    public final WarrantyBUS warrantyBUS = new WarrantyBUS();
    public ArrayList<WarrantyDTO> WarrantyList = warrantyBUS.getAll();
    public WarrantyDTO warranty;
    JFrame owner = (JFrame) SwingUtilities.getWindowAncestor(this);

    /**
     * Creates new form Warranty
     */
    public Warranty() {
        initComponents();

        loadData(WarrantyList);
        loadCbbFilter();
        loadSearchFilter();

        loadAdd();
        loadUpdate();
        loadDelete();
        loadDetail();
        loadRefresh();
    }

    // Load data into table
    public void loadData(ArrayList<WarrantyDTO> WarrantyList) {
        int i = 1;
        DefaultTableModel tblModel = (DefaultTableModel) List_Warranty.getModel();
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }

        for (WarrantyDTO warranty : WarrantyList) {
            tblModel.addRow(new Object[] {
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
        toolBar.getCbbFilter().setModel(new DefaultComboBoxModel<>(new String[] {
                "Tất cả", "Mã sản phẩm", "Mã bảo hành", "Tên khách hàng", "Yêu cầu bảo hành", "Trạng thái bảo hành"
        }));
    }

    // Load search filter
    public void loadSearchFilter() {
        // Toolbar search button event
        toolBar.getFindBtn().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Combobox filter search function
                if (toolBar.getTfSearch().getText() != "") {
                    String type = (String) toolBar.getCbbFilter().getSelectedItem();

                    WarrantyList = warrantyBUS.search(type, toolBar.getTfSearch().getText());
                    loadData(WarrantyList);
                } else {
                    WarrantyList = warrantyBUS.getAll();
                    loadData(WarrantyList);
                }
            }
        });
    }

    // Load add function
    public void loadAdd() {
        toolBar.getAddBtn().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // WarrantyDialog(Warranty JPWarranty, java.awt.Frame parent, boolean modal,
                // String title, String type)
                WarrantyDialog dialog = new WarrantyDialog(Warranty.this, owner, true, "Thêm bảo hành", "add");
                System.out.println("Hello");
            }
        });
    }

    // Load update function
    public void loadUpdate() {
        toolBar.getEditBtn().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (getIndexRow() != -1) {
                    WarrantyDialog dialog = new WarrantyDialog(Warranty.this, owner, true, "Thêm bảo hành", "update",
                            WarrantyList.get(getIndexRow()));
                } else {
                    JOptionPane.showMessageDialog(Warranty.this, "VUi lòng chọn dỏng trong bảng");
                }

            }
        });
    }

    // Load delete function
    public void loadDelete() {
        toolBar.getRemoveBtn().addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = getIndexRow();
                if (selectedIndex != -1) {
                    int input = JOptionPane.showConfirmDialog(
                        null, 
                        "Bạn có chắc chắn muốn xóa không?", 
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        WarrantyDTO selectedWarranty = WarrantyList.get(selectedIndex);
                        boolean canDelete = true;
                        for (WarrantyDTO warranty : WarrantyList) {
                            if (warranty.getMaSanPham() == selectedWarranty.getMaBaoHanh()) {
                                canDelete = false;
                                break;
                            }
                        }
                        if (canDelete) {
                            warrantyBUS.delete(WarrantyList.get(selectedIndex), selectedIndex);
                            loadData(WarrantyList);
                            JOptionPane.showMessageDialog(null, "Xóa bảo hành thành công");
                        } else {
                            JOptionPane.showMessageDialog(null, "Không thể xóa bảo hành này");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa");
                }
            }
        });

        loadData(WarrantyList);
    }

    // Load detail function
    public void loadDetail() {
        toolBar.getDetailBtn().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (getIndexRow() != -1) {
                    WarrantyDialog dialog = new WarrantyDialog(Warranty.this, owner, true, "Thêm bảo hành", "detail",
                            WarrantyList.get(getIndexRow()));

                } else {
                    JOptionPane.showMessageDialog(Warranty.this, "VUi lòng chọn dỏng trong bảng");
                }

            }
        });
    }

    public void loadRefresh() {
        toolBar.getRefreshBtn().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WarrantyList = warrantyBUS.getAll();
                loadData(WarrantyList);
            }
        });
    }

    public int getIndexRow() {
        int i = List_Warranty.getSelectedRow();
        return i;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new GUI.toolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_Warranty = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1200, 720));

        List_Warranty.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Mã Sản Phẩm", "Mã Bảo Hành", "Tên Khách Hàng", "Yêu Cầu Bảo Hành", "Trạng Thái Bảo Hành",
                        "Ngày Bảo Hành"
                }));
        List_Warranty.setRequestFocusEnabled(false);
        List_Warranty.setShowGrid(true);
        jScrollPane1.setViewportView(List_Warranty);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 88,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626,
                                        Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable List_Warranty;
    private javax.swing.JScrollPane jScrollPane1;
    protected GUI.toolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
