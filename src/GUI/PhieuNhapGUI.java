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
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    AccountDTO myAcc;
    int priceB, priceE;

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
        toolBar.getFindBtn().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(function.TextFieldIsEmpty(toolBar.getTfSearch(), "nội dung tìm kiếm","Nhập nội dung tìm kiếm...")) {
                    return;
                }
                loadData(PNBUS.search(toolBar.getCbbFilter().getSelectedIndex(), toolBar.getTfSearch().getText()));
            }
        });
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
                new GUI.Dialog.SuaPhieuNhapDialog(null, true, myAcc, listPN.get(index)).setVisible(true);

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
        toolBar.getRefreshBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventRefresh();
            }

        });
        toolBar.getTfSearch().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(function.TextFieldIsEmpty(toolBar.getTfSearch(), "nội dung tìm kiếm","Nhập nội dung tìm kiếm...")) {
                    return;
                }
                loadData(PNBUS.search(toolBar.getCbbFilter().getSelectedIndex(), toolBar.getTfSearch().getText()));
            }
            
        });
        
        jSlider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    eventFilter();
                }
            }
        });
        jSlider2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    eventFilter();
                }
            }
        });
    }

    public void eventRefresh() {
        removeAll();
        add(new PhieuNhapGUI(myAcc));
        loadData(listPN);
        repaint();
        revalidate();
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

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        jPanel2.add(jDateChooser1);

        jLabel4.setText("Đến ngày");
        jPanel2.add(jLabel4);

        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });
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
        detroyFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detroyFilterBtnActionPerformed(evt);
            }
        });
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
            priceB = (int) (1000000000 * ((double) jSlider1.getValue() / 100));
            jTextField4.setText(decimalFormat.format(priceB));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        // TODO add your handling code here:
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            priceE = (int) (1000000000 * ((double) jSlider2.getValue() / 100));
            jTextField5.setText(decimalFormat.format(priceE));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jSlider2StateChanged

    private void cbbNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNCCActionPerformed
        eventFilter();
    }//GEN-LAST:event_cbbNCCActionPerformed

    private void cbbNVNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNVNActionPerformed
        eventFilter();
    }//GEN-LAST:event_cbbNVNActionPerformed

    private void detroyFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detroyFilterBtnActionPerformed
        // TODO add your handling code here:
        cbbNCC.setSelectedIndex(0);
        cbbNVN.setSelectedIndex(0);
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jSlider1.setValue(0);
        jSlider2.setValue(0);
        jTextField4.setText("");
        jTextField5.setText("");
        loadData(listPN);
    }//GEN-LAST:event_detroyFilterBtnActionPerformed

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        // TODO add your handling code here:
        eventFilter();
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
        eventFilter();
    }//GEN-LAST:event_jDateChooser1PropertyChange

    ArrayList<PhieuNhapDTO> listPNFilter;
    Iterator<PhieuNhapDTO> iterator;

    public void eventFilter() {
        listPNFilter = new ArrayList<>(listPN);
        iterator = listPNFilter.iterator();
        int NCC = cbbNCC.getSelectedIndex();
        int MNV = cbbNVN.getSelectedIndex();

        if (NCC != 0) {
            while (iterator.hasNext()) {
                PhieuNhapDTO PN = iterator.next();
                if (listNCC.get(NCC - 1).getMaNCC() != PN.getNCC()) {
                    iterator.remove();
                }
            }
        }
        if (MNV != 0) {
            Iterator<PhieuNhapDTO> iterator2 = listPNFilter.iterator();
            while (iterator2.hasNext()) {
                PhieuNhapDTO PN = iterator2.next();
                if (listNV.get(MNV - 1).getManv() != PN.getMNV()) {
                    iterator2.remove();
                }
            }
        }
        if (filterByDate() == false) {
            return;
        }
        filterByPrice();
        //final
        loadData(listPNFilter);
    }

    public boolean filterByDate() {
        Iterator<PhieuNhapDTO> iterator3 = listPNFilter.iterator();
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
                PhieuNhapDTO PN = iterator3.next();
                //date1.compareto(date2) > 0   ->   date1 > date2
                if (PN.getThoiGian().compareTo(begin) < 0 || PN.getThoiGian().compareTo(end) > 0) {
                    iterator3.remove();
                }
            }
        }
        return true;
    }

    public void filterByPrice() {
        Iterator<PhieuNhapDTO> iterator4 = listPNFilter.iterator();
        if (jTextField4.getText().isEmpty() || jTextField5.getText().isEmpty()) {
            return;
        }
        while (iterator4.hasNext()) {
            PhieuNhapDTO PN = iterator4.next();
            if (PN.getTongTien() < priceB || PN.getTongTien() > priceE) {
                iterator4.remove();
            }
        }
    }
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
