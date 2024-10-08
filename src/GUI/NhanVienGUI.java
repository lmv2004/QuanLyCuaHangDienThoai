package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import GUI.Dialog.NhanVienDialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NhanVienGUI extends javax.swing.JPanel {

    private NhanVienBUS NVBUS = new NhanVienBUS();
    private ArrayList<NhanVienDTO> listNV = NVBUS.getAllNhanVien();

    public NhanVienGUI() {
        initComponents();
        loadData(listNV);
        loadCbb();
        addEvent();
        toolBar.getDetailBtn().setVisible(false);
    }

    public int getIndexRow() {
        int row = NhanVienTable.getSelectedRow();
        return row;
    }

    public void loadData(ArrayList<NhanVienDTO> listNV) {
        DefaultTableModel tblModel = (DefaultTableModel) NhanVienTable.getModel();
        //remove all row
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }
        for (NhanVienDTO x : listNV) {
            tblModel.addRow(new Object[]{
                x.getManv(),
                x.getHoTen(),
                x.getGioiTinh() == 1 ? "Nam" : "Nữ",
                x.getNgaySinh(),
                x.getSDT(),
                x.getEmail()
            });
        }
        NhanVienTable.setModel(tblModel);
        NhanVienTable.repaint();
        NhanVienTable.validate();
    }

    public void loadCbb() {
        toolBar.getCbbFilter().setModel(new DefaultComboBoxModel(new String[]{
            "Tất cả", "Mã NV", "Họ tên", "Giới tính", "SĐT", "Email"
        }));
    }

    public void addEvent() {
        toolBar.getFindBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData(NVBUS.Search((String) toolBar.getCbbFilter().getSelectedItem(), toolBar.getTfSearch().getText()));
            }
        });
        toolBar.getTfSearch().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loadData(NVBUS.Search((String) toolBar.getCbbFilter().getSelectedItem(), toolBar.getTfSearch().getText()));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
        toolBar.getRefreshBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData(NVBUS.getAllNhanVien());
            }

        });
        toolBar.getAddBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhanVienDialog PanelDialog = new NhanVienDialog("add");
            }
        });
        toolBar.getEditBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getIndexRow() >= 0) {
                    NhanVienDialog PanelDialog = new NhanVienDialog("update", listNV.get(getIndexRow()));
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên có trong bảng!");
                }
            }
        });
        toolBar.getRemoveBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = getIndexRow();
                if (index >= 0) {
                    int input = JOptionPane.showConfirmDialog(null,
                            "Bạn có chắc chắn muốn xóa Nhân Viên này?", "Xóa Nhân Viên",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (input == 0) {
                        int manv = Integer.parseInt(NhanVienTable.getValueAt(index, 0).toString());
                        for (NhanVienDTO nv : listNV) {
                            if (nv.getManv() == manv) {
                                if (NVBUS.delete(nv)) {
                                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                                    loadData(NVBUS.getAllNhanVien());
                                }
                            }
                        }

                    }
                }
            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelControl = new javax.swing.JPanel();
        PanelControlLeft = new javax.swing.JPanel();
        AddBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        RemoveBtn = new javax.swing.JButton();
        DetailBtn = new javax.swing.JButton();
        ImportExcelBtn = new javax.swing.JButton();
        ExportExcelBtn = new javax.swing.JButton();
        PanelControlRight = new javax.swing.JPanel();
        SearchTF = new javax.swing.JTextField();
        RefeshBtn = new javax.swing.JButton();
        CatogoryCBB = new javax.swing.JComboBox<>();
        PanelNhanVIen = new javax.swing.JPanel();
        toolBar = new GUI.toolBar();
        PanelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NhanVienTable = new javax.swing.JTable();

        PanelControl.setBackground(new java.awt.Color(64, 103, 146));
        PanelControl.setOpaque(false);
        PanelControl.setPreferredSize(new java.awt.Dimension(1200, 70));
        PanelControl.setLayout(new java.awt.BorderLayout());

        PanelControlLeft.setBackground(new java.awt.Color(255, 255, 255));

        AddBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        AddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        AddBtn.setText("Thêm");
        AddBtn.setBorder(null);
        AddBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddBtn.setIconTextGap(0);
        AddBtn.setMaximumSize(new java.awt.Dimension(40, 50));
        AddBtn.setMinimumSize(new java.awt.Dimension(40, 50));
        AddBtn.setPreferredSize(new java.awt.Dimension(40, 50));
        AddBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        EditBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        EditBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        EditBtn.setText("Sửa");
        EditBtn.setBorder(null);
        EditBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditBtn.setIconTextGap(0);
        EditBtn.setMaximumSize(new java.awt.Dimension(40, 55));
        EditBtn.setMinimumSize(new java.awt.Dimension(40, 55));
        EditBtn.setPreferredSize(new java.awt.Dimension(40, 55));
        EditBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        RemoveBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        RemoveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        RemoveBtn.setText("Xóa");
        RemoveBtn.setBorder(null);
        RemoveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RemoveBtn.setIconTextGap(0);
        RemoveBtn.setMaximumSize(new java.awt.Dimension(40, 60));
        RemoveBtn.setMinimumSize(new java.awt.Dimension(40, 60));
        RemoveBtn.setPreferredSize(new java.awt.Dimension(40, 60));
        RemoveBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        DetailBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        DetailBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/detail.png"))); // NOI18N
        DetailBtn.setText("Chi tiết");
        DetailBtn.setBorder(null);
        DetailBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DetailBtn.setIconTextGap(0);
        DetailBtn.setMaximumSize(new java.awt.Dimension(50, 60));
        DetailBtn.setMinimumSize(new java.awt.Dimension(50, 60));
        DetailBtn.setPreferredSize(new java.awt.Dimension(50, 60));
        DetailBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        ImportExcelBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        ImportExcelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/import_excel.png"))); // NOI18N
        ImportExcelBtn.setText("Nhập Excel");
        ImportExcelBtn.setBorder(null);
        ImportExcelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImportExcelBtn.setIconTextGap(0);
        ImportExcelBtn.setMaximumSize(new java.awt.Dimension(78, 60));
        ImportExcelBtn.setMinimumSize(new java.awt.Dimension(78, 60));
        ImportExcelBtn.setPreferredSize(new java.awt.Dimension(78, 60));
        ImportExcelBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        ExportExcelBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        ExportExcelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/export_excel.png"))); // NOI18N
        ExportExcelBtn.setText("Xuất Excel");
        ExportExcelBtn.setBorder(null);
        ExportExcelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ExportExcelBtn.setIconTextGap(0);
        ExportExcelBtn.setMaximumSize(new java.awt.Dimension(103, 60));
        ExportExcelBtn.setMinimumSize(new java.awt.Dimension(103, 60));
        ExportExcelBtn.setPreferredSize(new java.awt.Dimension(103, 60));
        ExportExcelBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout PanelControlLeftLayout = new javax.swing.GroupLayout(PanelControlLeft);
        PanelControlLeft.setLayout(PanelControlLeftLayout);
        PanelControlLeftLayout.setHorizontalGroup(
            PanelControlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelControlLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RemoveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DetailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ImportExcelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExportExcelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        PanelControlLeftLayout.setVerticalGroup(
            PanelControlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelControlLeftLayout.createSequentialGroup()
                .addGroup(PanelControlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EditBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelControlLeftLayout.createSequentialGroup()
                .addGroup(PanelControlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RemoveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DetailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImportExcelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExportExcelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelControl.add(PanelControlLeft, java.awt.BorderLayout.CENTER);

        PanelControlRight.setBackground(new java.awt.Color(255, 255, 255));
        PanelControlRight.setPreferredSize(new java.awt.Dimension(530, 70));

        SearchTF.setForeground(new java.awt.Color(153, 153, 153));
        SearchTF.setText("Tìm Kiếm...");
        SearchTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchTFFocusLost(evt);
            }
        });

        RefeshBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        RefeshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        RefeshBtn.setText("Làm mới");

        CatogoryCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả" }));
        CatogoryCBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatogoryCBBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelControlRightLayout = new javax.swing.GroupLayout(PanelControlRight);
        PanelControlRight.setLayout(PanelControlRightLayout);
        PanelControlRightLayout.setHorizontalGroup(
            PanelControlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelControlRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CatogoryCBB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(SearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RefeshBtn)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        PanelControlRightLayout.setVerticalGroup(
            PanelControlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelControlRightLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PanelControlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CatogoryCBB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RefeshBtn))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        PanelControl.add(PanelControlRight, java.awt.BorderLayout.LINE_END);

        setPreferredSize(new java.awt.Dimension(1200, 725));

        PanelNhanVIen.setLayout(new java.awt.BorderLayout());
        PanelNhanVIen.add(toolBar, java.awt.BorderLayout.PAGE_START);

        NhanVienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MNV", "Họ tên", "Giới tính", "Ngày sinh", "SĐT", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        NhanVienTable.setRowHeight(25);
        jScrollPane1.setViewportView(NhanVienTable);

        javax.swing.GroupLayout PanelTableLayout = new javax.swing.GroupLayout(PanelTable);
        PanelTable.setLayout(PanelTableLayout);
        PanelTableLayout.setHorizontalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
            .addGroup(PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE))
        );
        PanelTableLayout.setVerticalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
            .addGroup(PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE))
        );

        PanelNhanVIen.add(PanelTable, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelNhanVIen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelNhanVIen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed

    }//GEN-LAST:event_EditBtnActionPerformed

    private void CatogoryCBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatogoryCBBActionPerformed

    }//GEN-LAST:event_CatogoryCBBActionPerformed

    private void SearchTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTFFocusGained
        if (SearchTF.getText().equals("Tìm Kiếm...")) {
            SearchTF.setText("");
            SearchTF.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_SearchTFFocusGained

    private void SearchTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTFFocusLost
        if (SearchTF.getText().equals("")) {
            SearchTF.setText("Tìm Kiếm...");
            SearchTF.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_SearchTFFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JComboBox<String> CatogoryCBB;
    private javax.swing.JButton DetailBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JButton ExportExcelBtn;
    private javax.swing.JButton ImportExcelBtn;
    private javax.swing.JTable NhanVienTable;
    private javax.swing.JPanel PanelControl;
    private javax.swing.JPanel PanelControlLeft;
    private javax.swing.JPanel PanelControlRight;
    private javax.swing.JPanel PanelNhanVIen;
    private javax.swing.JPanel PanelTable;
    private javax.swing.JButton RefeshBtn;
    private javax.swing.JButton RemoveBtn;
    private javax.swing.JTextField SearchTF;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.toolBar toolBar;
    // End of variables declaration//GEN-END:variables

}
