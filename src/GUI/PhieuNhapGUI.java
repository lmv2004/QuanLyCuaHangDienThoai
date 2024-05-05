package GUI;

import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import DTO.AccountDTO;
import DTO.NhanVienDTO;
import DTO.NhaCungCapDTO;
import DTO.PhieuNhapDTO;
import GUI.Dialog.ThemPhieuNhapDialog;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PhieuNhapGUI extends javax.swing.JPanel {

    private PhieuNhapBUS PNBUS = new PhieuNhapBUS();
    private NhanVienBUS NVBUS = new NhanVienBUS();
    private NhaCungCapBUS NCCBUS = new NhaCungCapBUS();
    private ArrayList<PhieuNhapDTO> listPN = PNBUS.getAllPhieuNhap();
    private ArrayList<NhaCungCapDTO> listNCC = NCCBUS.getAllNhaCungCap();
    private ArrayList<NhanVienDTO> listNV = NVBUS.getAllNhanVien();
    private ArrayList<PhieuNhapDTO> listPNFilter = new ArrayList<>();
    AccountDTO myAcc;

    public PhieuNhapGUI(AccountDTO myAcc) {
        initComponents();
        this.myAcc = myAcc;
        loadData(listPN);
        loadCbbFilter();
        loadCbbNhanVien();
        loadCbbNhaCungCap();
        setTable();
        setEvent();
    }

    public void loadData(ArrayList<PhieuNhapDTO> listPN) {
        int i = 1;
        DefaultTableModel tblModel = (DefaultTableModel) tblDSPN.getModel();
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        for (PhieuNhapDTO x : listPN) {
            tblModel.addRow(new Object[]{i++, x.getMaPhieu(), NCCBUS.getNameByID(x.getNCC()), NVBUS.getNameByID(x.getMNV()), x.getThoiGian(), decimalFormat.format(x.getTongTien())});
        }
        tblDSPN.setModel(tblModel);
    }

    public void loadCbbFilter() {
        toolBar.getCbbFilter().setModel(new DefaultComboBoxModel(new String[]{
            "Tất cả", "Mã phiếu nhập", "Tên nhà cung cấp", "Tên nhân viên"
        }));
    }

    public void loadCbbNhanVien() {
        for (NhanVienDTO x : listNV) {
            cbbNVN.addItem(x.getHoTen());
        }
    }

    public void loadCbbNhaCungCap() {
        for (NhaCungCapDTO x : listNCC) {
            cbbNCC.addItem(x.getTenNCC());
        }
    }

    public void setTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        TableColumnModel columnModel = tblDSPN.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(2).setPreferredWidth(400);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(200);
        centerRenderer.setHorizontalAlignment(JLabel.LEFT);
        columnModel.getColumn(5).setCellRenderer(centerRenderer);
    }

    public void setEvent() {
        //set event for search buttton 
//        toolBar.getFindBtn().addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                if(function.TextFieldIsEmpty(toolBar.getTfSearch(), "nội dung tìm kiếm","Nhập nội dung tìm kiếm...")) {
//                    return;
//                }
//                PNBUS.pouringData(tblDSPN, PNBUS.search(toolBar.getCbbFilter().getSelectedIndex(), toolBar.getTfSearch().getText().strip()));
//            }
//        });
        toolBar.getAddBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI.Dialog.ThemPhieuNhapDialog(null, true, myAcc).setVisible(true);
            }

        });

        toolBar.getEditBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tblDSPN.getSelectedRow();
                if (index < 0) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn phiếu nhập");
                    return;
                }
                new GUI.Dialog.SuaPhieuNhapDialog(null, true, myAcc,listPN.get(index)).setVisible(true);
                
            }

        });
        toolBar.getDetailBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tblDSPN.getSelectedRow();
                if (index < 0) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn phiếu nhập");
                    return;
                }
                new GUI.Dialog.ChiTietPhieuNhapDialog(null, true, listPN.get(index)).setVisible(true);
            }

        });

        toolBar.getRemoveBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn hủy phiếu?") == 0) {
                    int index = tblDSPN.getSelectedRow();
                    if (index < 0) {
                        JOptionPane.showMessageDialog(null, "Bạn chưa chọn phiếu nhập");
                        return;
                    }
                    PNBUS.delete(listPN.get(tblDSPN.getSelectedRow()));
                    listPN.remove(tblDSPN.getSelectedRow());
                    loadData(listPN);
                    JOptionPane.showMessageDialog(null, "Hủy phiếu nhập thành công!");
                }
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rowConfig = new javax.swing.JPopupMenu();
        edit = new javax.swing.JMenuItem();
        remove = new javax.swing.JMenuItem();
        details = new javax.swing.JMenuItem();
        toolBar = new GUI.toolBar();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSPN = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelNCC = new javax.swing.JLabel();
        cbbNCC = new javax.swing.JComboBox<>();
        labelNV = new javax.swing.JLabel();
        cbbNVN = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jSlider1 = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jSlider2 = new javax.swing.JSlider();
        detroyFilterBtn = new javax.swing.JButton();

        edit.setText("Sửa");
        rowConfig.add(edit);

        remove.setText("Xóa");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        rowConfig.add(remove);

        details.setText("Details");
        rowConfig.add(details);

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1200, 725));
        setLayout(new java.awt.BorderLayout());
        add(toolBar, java.awt.BorderLayout.PAGE_START);

        jPanel3.setOpaque(false);

        tblDSPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu", "Nhà cung cấp", "Nhân viên", "Thời gian", "Tổng tiền (VNĐ)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSPN.setComponentPopupMenu(rowConfig);
        tblDSPN.setOpaque(false);
        tblDSPN.setShowGrid(false);
        jScrollPane1.setViewportView(tblDSPN);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(200, 800));

        jPanel2.setMinimumSize(new java.awt.Dimension(140, 524));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(140, 675));
        jPanel2.setLayout(new java.awt.GridLayout(20, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bộ lọc");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel1);

        labelNCC.setText("Nhà cung cấp");
        jPanel2.add(labelNCC);

        cbbNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cbbNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNCCActionPerformed(evt);
            }
        });
        jPanel2.add(cbbNCC);

        labelNV.setText("Nhân viên nhập");
        jPanel2.add(labelNV);

        cbbNVN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cbbNVN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNVNActionPerformed(evt);
            }
        });
        jPanel2.add(cbbNVN);

        jLabel3.setText("Từ ngày");
        jPanel2.add(jLabel3);
        jPanel2.add(jDateChooser1);

        jLabel4.setText("Đến ngày");
        jPanel2.add(jLabel4);
        jPanel2.add(jDateChooser2);

        jLabel5.setText("Từ số tiền (VNĐ)");
        jPanel2.add(jLabel5);
        jPanel2.add(jTextField4);

        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanel2.add(jSlider1);

        jLabel6.setText("Đến số tiền (VNĐ)");
        jPanel2.add(jLabel6);
        jPanel2.add(jTextField5);

        jSlider2.setValue(0);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });
        jPanel2.add(jSlider2);

        detroyFilterBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        detroyFilterBtn.setForeground(new java.awt.Color(5, 7, 15));
        detroyFilterBtn.setText("Hủy Bộ Lọc");
        detroyFilterBtn.setPreferredSize(new java.awt.Dimension(95, 40));
        jPanel2.add(detroyFilterBtn);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            jTextField4.setText(decimalFormat.format(1000000000 * ((double) jSlider1.getValue() / 100)));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        // TODO add your handling code here:
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            jTextField5.setText(decimalFormat.format(1000000000 * ((double) jSlider2.getValue() / 100)));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jSlider2StateChanged

    private void cbbNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNCCActionPerformed
//        int index = cbbNCC.getSelectedIndex();
//        listPNFilter.clear();
//        listPNFilter.addAll(listPN);
//        if (index == 0) {
//            if (cbbNVN.getSelectedIndex() != 0) {
//                cbbNVNActionPerformed(null);
//            } else {
//                loadData(listPNFilter);
//            }
//            return;
//        }
//        int ID = listNCC.get(index - 1).getMaNCC();
//        Iterator<PhieuNhapDTO> iterator = listPNFilter.iterator();
//        while (iterator.hasNext()) {
//            PhieuNhapDTO x = iterator.next();
//            if (x.getNCC() != ID) {
//                iterator.remove(); // Sử dụng Iterator.remove() để loại bỏ phần tử
//            }
//        }
//        loadData(listPNFilter);
    }//GEN-LAST:event_cbbNCCActionPerformed

    private void cbbNVNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNVNActionPerformed
//        int index = cbbNVN.getSelectedIndex();
//        listPNFilter.clear();
//        listPNFilter.addAll(listPN);
//        if (index == 0) {
//            if (cbbNVN.getSelectedIndex() != 0) {
//                cbbNCCActionPerformed(null);
//            } else {
//                loadData(listPNFilter);
//            }
//            return;
//        }
//        int ID = listNV.get(index - 1).getManv();
//        Iterator<PhieuNhapDTO> iterator = listPNFilter.iterator();
//        while (iterator.hasNext()) {
//            PhieuNhapDTO x = iterator.next();
//            if (x.getMNV() != ID) {
//                iterator.remove();
//            }
//        }
//        loadData(listPNFilter);
    }//GEN-LAST:event_cbbNVNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JComboBox<String> cbbNCC;
    protected javax.swing.JComboBox<String> cbbNVN;
    private javax.swing.JMenuItem details;
    private javax.swing.JButton detroyFilterBtn;
    private javax.swing.JMenuItem edit;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    protected javax.swing.JLabel labelNCC;
    protected javax.swing.JLabel labelNV;
    private javax.swing.JMenuItem remove;
    private javax.swing.JPopupMenu rowConfig;
    protected javax.swing.JTable tblDSPN;
    protected GUI.toolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
