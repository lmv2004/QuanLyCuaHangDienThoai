/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.AccountBUS;
import BUS.CTPhieuNhapBUS;
import BUS.NhaCungCapBUS;
import BUS.PhienBanSanPhamBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamBUS;
import DTO.AccountDTO;
import DTO.ChiTietPhieuDTO;
import DTO.NhaCungCapDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import DTO.SoLuongSPDTO;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author ACER
 */
public class ThemPhieuNhapDialog extends javax.swing.JDialog {

    /**
     * Creates new form ThemPhieuNhapDialog
     */
    protected SanPhamBUS SPBUS = new SanPhamBUS(); 
    protected NhaCungCapBUS NCCBUS = new NhaCungCapBUS();
    protected PhieuNhapBUS PNBUS = new PhieuNhapBUS();
    protected ArrayList<SanPhamDTO> listSP = SPBUS.getAllSanPhamAttribute();
    protected ArrayList<NhaCungCapDTO> listNCC = NCCBUS.getAllNhaCungCap();
    protected ArrayList<SoLuongSPDTO> listSPPN = new ArrayList<>();
    protected DefaultTableModel model;
    protected DecimalFormat decimalFormat = new DecimalFormat("#,###");
    protected AccountDTO myAcc;
    protected CTPhieuNhapBUS CTPNBUS = new CTPhieuNhapBUS();
    protected long TongTien;

    public ThemPhieuNhapDialog(java.awt.Frame parent, boolean modal, AccountDTO myAcc) {
        super(parent, modal);
        initComponents();
        this.myAcc = myAcc;
        loadData(listSP);
        model = (DefaultTableModel) CTTbl.getModel();
        
        setEvent();
    }

    public void loadData(ArrayList<SanPhamDTO> listSP) {
        //data thông tin
        loadCbbNhaCungCap();
        nv.setText(new BUS.NhanVienBUS().getNameByID(myAcc.getMaNV()));

        //data table sản phẩm
        DefaultTableModel tblModel = (DefaultTableModel) DSSPTbl.getModel();
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }
        for (SanPhamDTO x : listSP) {
            tblModel.addRow(new Object[]{x.getMasp(), x.getTensp(), x.getPBSPDTO().getMaphienbansp(), x.getPBSPDTO().getSoluongton(), decimalFormat.format(x.getPBSPDTO().getGianhap())});
        }
        DSSPTbl.setModel(tblModel);
    }

    public void loadCbbNhaCungCap() {
        for (NhaCungCapDTO x : listNCC) {
            cbbNCC.addItem(x.getTenNCC());
        }
    }

    public void reloadSPPN() {
        DefaultTableModel tblModel = (DefaultTableModel) CTTbl.getModel();
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        TongTien = 0;
        int i = 0;
        try {
            for (SoLuongSPDTO x : listSPPN) {
                long ThanhTien =(long)x.getSP().getPBSPDTO().getGianhap() * x.getSL();
                TongTien += (long)ThanhTien;
                tblModel.addRow(new Object[]{x.getSP().getMasp(), x.getSP().getTensp(), x.getSP().getPBSPDTO().getMaphienbansp(), x.getSL(), decimalFormat.format(x.getSP().getPBSPDTO().getGianhap()), decimalFormat.format(ThanhTien), "Xóa SP"});
                i++;
            }
            CTTbl.setModel(tblModel);
            TongTienLbl.setText(decimalFormat.format(TongTien)+" (VNĐ) ");
        } catch (Exception e) {
            System.out.println("loi cho nay");
        }
    }
    
    public void setEvent() {
        //nhập số lượng nhập hàng
        CTTbl.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int selectedRow = CTTbl.getSelectedRow();
                    if (selectedRow >= 0) {
                        Object temp = CTTbl.getValueAt(CTTbl.getSelectedRow(), 3);
                        if (temp != null) {
                            try {
                                int temp2 = Integer.parseInt(temp.toString());
                                if (temp2 <= 0) {
                                    JOptionPane.showMessageDialog(null, "Số lượng nhập không hợp lệ");
                                    CTTbl.changeSelection(selectedRow, 3, false, false);
                                    CTTbl.setValueAt(listSPPN.get(selectedRow).getSL(), selectedRow, 3);
                                    return;
                                }
                                listSPPN.get(selectedRow).setSL(temp2);
                                reloadSPPN();
                            } catch (Exception ev) {
                                JOptionPane.showMessageDialog(null, "Số lượng nhập không hợp lệ");
                                CTTbl.changeSelection(selectedRow, 3, false, false);
                                CTTbl.setValueAt(listSPPN.get(selectedRow).getSL(), selectedRow, 3);
                            }

                        }
                    }
                }
            }
        });
        
        //thời gian
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                tg.setText(sdf.format(new Date()));
            }
        });
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nv = new javax.swing.JLabel();
        tg = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbNCC = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DSSPTbl = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CTTbl = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        TongTienLbl = new javax.swing.JLabel();
        CancelBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(0, 0, 255));
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("Thêm phiếu nhập");

        jLabel2.setText("Nhân viên nhập:");

        jLabel3.setText("Thời gian:");

        jLabel6.setText("Nhà cung cấp:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Danh sách mặt hàng");

        DSSPTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Mã PBSP", "Số lượng tồn", "Giá nhập (VNĐ)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DSSPTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DSSPTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DSSPTbl);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Chi tiết phiếu nhập");

        CTTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Mã PBSP", "Số lượng nhập", "Giá nhập", "Thành tiền (VNĐ)", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CTTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CTTblMouseClicked(evt);
            }
        });
        CTTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CTTblKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(CTTbl);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tổng tiền:");
        jPanel3.add(jLabel7);

        TongTienLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TongTienLbl.setText("0 (VNĐ)");
        jPanel3.add(TongTienLbl);

        CancelBtn.setBackground(new java.awt.Color(255, 51, 51));
        CancelBtn.setText("Hủy");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
        jPanel3.add(CancelBtn);

        AddBtn.setBackground(java.awt.Color.blue);
        AddBtn.setText("Thêm");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        jPanel3.add(AddBtn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tg, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                            .addComponent(nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(104, 808, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 39, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLbl)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nv, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn hủy?") == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void DSSPTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DSSPTblMouseClicked
        // TODO add your handling code here:
        int index = DSSPTbl.getSelectedRow();
        if (index >= 0) {
            for (SoLuongSPDTO x : listSPPN) {
                if (listSP.get(index).equals(x.getSP())) {
                    JOptionPane.showMessageDialog(null, "Bạn đã thêm sản phẩm này rồi");
                    return;
                }
            }
            listSPPN.add(new SoLuongSPDTO(listSP.get(index), 1));
            reloadSPPN();
        }
    }//GEN-LAST:event_DSSPTblMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm phiếu nhập?") == 0) {
            //check data
            if(listSPPN.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Phiếu nhập rỗng!");
                return;
            }
            //insert vào database
            
            int MaNCC = listNCC.get(cbbNCC.getSelectedIndex()).getMaNCC();
            int MaNV = myAcc.getMaNV();
            
            
            int ID = PNBUS.add(new PhieuNhapDTO(MaNCC, 0, MaNV, new Date(), TongTien));
            if(ID==0) {
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!!!");
                return;
            }
            for(SoLuongSPDTO x : listSPPN) {
                if(CTPNBUS.add(new ChiTietPhieuDTO(ID, x.getSP().getPBSPDTO().getMaphienbansp(), x.getSL(), x.getSP().getPBSPDTO().getGianhap(), 1))==false
                        || new PhienBanSanPhamBUS().nhapHang(x.getSP().getPBSPDTO().getMaphienbansp(), x.getSL())==false) {
                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!!!");
                    return;
                }
            }
            //mỗi sp sẽ có các phiên bản khác nhau, tổng số lượng các phiên bản sẽ là số lượng tồn của sản phẩm
            
            JOptionPane.showMessageDialog(null, "Thêm thành công", "Thành công", JOptionPane.OK_OPTION);
            this.dispose();
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void CTTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CTTblMouseClicked
        // TODO add your handling code here:
        if (CTTbl.getSelectedColumn() == CTTbl.getColumnCount() - 1) {
            listSPPN.remove(CTTbl.getSelectedRow());
            reloadSPPN();
        }
    }//GEN-LAST:event_CTTblMouseClicked

    private void CTTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CTTblKeyPressed
        // TODO add your handling code here:
        int selectedRow = CTTbl.getSelectedRow();
        System.out.println("selected row = " + selectedRow);
        if (selectedRow >= 0 && selectedRow < CTTbl.getRowCount()) {
            Object temp = CTTbl.getValueAt(CTTbl.getSelectedRow(), 3);
            if (temp != null) {
                int temp2 = Integer.parseInt(temp.toString());
                if (temp2 <= 0) {
                    JOptionPane.showMessageDialog(null, "Số lượng nhập không hợp lệ");
                    CTTbl.setValueAt(listSPPN.get(selectedRow).getSL(), selectedRow, 3);
                    return;
                }
                listSPPN.get(selectedRow).setSL(temp2);
                System.out.println(listSPPN.toString());
                reloadSPPN();
            }
        }
    }//GEN-LAST:event_CTTblKeyPressed

    
    /**
     * @param args the command line arguments
     */

    public JButton getAddBtn() {
        return AddBtn;
    }

    public void setAddBtn(JButton AddBtn) {
        this.AddBtn = AddBtn;
    }

    public JLabel getTitleLbl() {
        return titleLbl;
    }

    public void setTitleLbl(JLabel titleLbl) {
        this.titleLbl = titleLbl;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTable CTTbl;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JTable DSSPTbl;
    private javax.swing.JLabel TongTienLbl;
    private javax.swing.JComboBox<String> cbbNCC;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nv;
    private javax.swing.JLabel tg;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}
