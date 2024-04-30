package GUI;

import BUS.SanPhamBUS;
import DTO.SanPhamDTO;
import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.*;

public class BanHangGUI extends javax.swing.JPanel {
    
    DefaultTableModel modelSPBan, modelGiohang;
    SanPhamBUS SPBUS = new SanPhamBUS();
    ArrayList<SanPhamDTO> ListSP = SPBUS.getAllSanPhamAttribute();
    DecimalFormat dfThapPhan = new DecimalFormat("0.00");
    DecimalFormat dfGiaTien = new DecimalFormat("###,###,### VNĐ");
    ArrayList<Integer> ClickCounts;
    
    public BanHangGUI() {
        initComponents();
        //function.placeHolder(SearchTf, "Tìm kiếm...");
        modelSPBan = (DefaultTableModel) SPBanTable.getModel();
        modelGiohang = (DefaultTableModel) GioHangTable.getModel();
        loaddata();
        designColumsTabelSPBan(SPBanTable);
        designColumsTabelSPBan(GioHangTable);
        
    }

    // tải data len table
    public void loaddata() {
        for (SanPhamDTO sp : ListSP) {
            modelSPBan.addRow(new Object[]{
                sp.getMasp(),
                sp.getTensp(),
                sp.getSoluongton(),
                sp.getPBSPDTO().getGiaxuat(),
                sp.getMSDTO().getTenmau(),
                "Xem chi tiết"
            });
        }
        
        SPBanTable.setModel(modelSPBan);
        ClickCounts = new ArrayList<>(SPBanTable.getRowCount());
        for (int i = 0; i < SPBanTable.getRowCount(); i++) {
            ClickCounts.add(0);
        }
    }

    // chỉnh kích cỡ của cột table SP Bán
    public void designColumsTabelSPBan(JTable table) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
            centerRender.setHorizontalAlignment(SwingConstants.CENTER);
            column.setCellRenderer(centerRender);
        }
        TableColumnModel TCM = table.getColumnModel();
        TCM.getColumn(0).setPreferredWidth(30);
        TCM.getColumn(1).setPreferredWidth(100);
        TCM.getColumn(2).setPreferredWidth(30);
        TCM.getColumn(3).setPreferredWidth(100);
        TCM.getColumn(4).setPreferredWidth(100);
        TCM.getColumn(5).setPreferredWidth(30);
        table.setShowHorizontalLines(true);
        table.setGridColor(new Color(230, 230, 230));
        table.getTableHeader().setReorderingAllowed(false);
    }

    //Design chung cho table
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBanHang = new javax.swing.JPanel();
        TinhTienPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        searchMaSP_TF = new javax.swing.JTextField();
        SPBanPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        SPBanTable = new javax.swing.JTable();
        GiohangPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        GioHangTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        MaHD_TF = new javax.swing.JTextField();
        PanelThanhToan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SDT_TF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TenKH_TF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        DisplayTongTienLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        KhachDua_TF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TraLai_TF = new javax.swing.JTextField();
        TaoHD_Btn = new javax.swing.JButton();
        HuyBtn = new javax.swing.JButton();
        ThanhToanBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(142, 212, 237));
        setMinimumSize(new java.awt.Dimension(1120, 725));
        setPreferredSize(new java.awt.Dimension(1120, 725));

        PanelBanHang.setBackground(new java.awt.Color(255, 255, 255));
        PanelBanHang.setPreferredSize(new java.awt.Dimension(1120, 724));

        TinhTienPanel2.setPreferredSize(new java.awt.Dimension(1120, 725));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("MaSP:");

        SPBanPanel.setBackground(new java.awt.Color(255, 255, 255));
        SPBanPanel.setOpaque(false);
        SPBanPanel.setPreferredSize(new java.awt.Dimension(900, 564));

        jLabel14.setBackground(new java.awt.Color(0, 102, 102));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Danh Sách Sản Phẩm Đang Bán");
        jLabel14.setOpaque(true);

        jScrollPane5.setPreferredSize(new java.awt.Dimension(400, 402));

        SPBanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Giá Bán", "Màu sắc", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SPBanTable.setGridColor(new java.awt.Color(0, 0, 0));
        SPBanTable.setRowHeight(100);
        SPBanTable.setSelectionBackground(new java.awt.Color(0, 204, 204));
        SPBanTable.setShowGrid(false);
        SPBanTable.setShowHorizontalLines(true);
        SPBanTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SPBanTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(SPBanTable);

        javax.swing.GroupLayout SPBanPanelLayout = new javax.swing.GroupLayout(SPBanPanel);
        SPBanPanel.setLayout(SPBanPanelLayout);
        SPBanPanelLayout.setHorizontalGroup(
            SPBanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        SPBanPanelLayout.setVerticalGroup(
            SPBanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SPBanPanelLayout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        GiohangPanel.setPreferredSize(new java.awt.Dimension(900, 260));

        GioHangTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "SL", "Đơn Giá", "Màu Sắc", "Tổng tiền", "Xóa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GioHangTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GioHangTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(GioHangTable);

        javax.swing.GroupLayout GiohangPanelLayout = new javax.swing.GroupLayout(GiohangPanel);
        GiohangPanel.setLayout(GiohangPanelLayout);
        GiohangPanelLayout.setHorizontalGroup(
            GiohangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GiohangPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
        );
        GiohangPanelLayout.setVerticalGroup(
            GiohangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GiohangPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setText("Mã HĐ");

        PanelThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        PanelThanhToan.setPreferredSize(new java.awt.Dimension(200, 702));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("SĐT KH");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên KH");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tổng Tiền");

        DisplayTongTienLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DisplayTongTienLabel.setForeground(new java.awt.Color(51, 102, 255));
        DisplayTongTienLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DisplayTongTienLabel.setAlignmentX(0.5F);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Khách Đưa");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Trả Lại");

        TaoHD_Btn.setBackground(new java.awt.Color(0, 102, 102));
        TaoHD_Btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TaoHD_Btn.setForeground(new java.awt.Color(255, 255, 255));
        TaoHD_Btn.setText("Tạo HĐ");
        TaoHD_Btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        TaoHD_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoHD_BtnActionPerformed(evt);
            }
        });

        HuyBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        HuyBtn.setForeground(new java.awt.Color(204, 204, 204));
        HuyBtn.setText("Hủy");
        HuyBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 48, 55), 2));
        HuyBtn.setEnabled(false);
        HuyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HuyBtnActionPerformed(evt);
            }
        });

        ThanhToanBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ThanhToanBtn.setForeground(new java.awt.Color(204, 204, 204));
        ThanhToanBtn.setText("Thanh Toán");
        ThanhToanBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        ThanhToanBtn.setEnabled(false);
        ThanhToanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThanhToanBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelThanhToanLayout = new javax.swing.GroupLayout(PanelThanhToan);
        PanelThanhToan.setLayout(PanelThanhToanLayout);
        PanelThanhToanLayout.setHorizontalGroup(
            PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DisplayTongTienLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelThanhToanLayout.createSequentialGroup()
                        .addGroup(PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TenKH_TF)
                            .addComponent(SDT_TF)))
                    .addGroup(PanelThanhToanLayout.createSequentialGroup()
                        .addGroup(PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TaoHD_Btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelThanhToanLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(KhachDua_TF)
                                    .addComponent(TraLai_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                            .addGroup(PanelThanhToanLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(HuyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(PanelThanhToanLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(ThanhToanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelThanhToanLayout.setVerticalGroup(
            PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThanhToanLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(SDT_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TenKH_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DisplayTongTienLabel)
                .addGap(65, 65, 65)
                .addGroup(PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(KhachDua_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TraLai_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(PanelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TaoHD_Btn)
                    .addComponent(HuyBtn))
                .addGap(27, 27, 27)
                .addComponent(ThanhToanBtn)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TinhTienPanel2Layout = new javax.swing.GroupLayout(TinhTienPanel2);
        TinhTienPanel2.setLayout(TinhTienPanel2Layout);
        TinhTienPanel2Layout.setHorizontalGroup(
            TinhTienPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TinhTienPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchMaSP_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(539, 539, 539)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MaHD_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(TinhTienPanel2Layout.createSequentialGroup()
                .addGroup(TinhTienPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SPBanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GiohangPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TinhTienPanel2Layout.setVerticalGroup(
            TinhTienPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TinhTienPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TinhTienPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TinhTienPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(searchMaSP_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TinhTienPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(MaHD_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TinhTienPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TinhTienPanel2Layout.createSequentialGroup()
                        .addComponent(GiohangPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SPBanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelBanHangLayout = new javax.swing.GroupLayout(PanelBanHang);
        PanelBanHang.setLayout(PanelBanHangLayout);
        PanelBanHangLayout.setHorizontalGroup(
            PanelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TinhTienPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        PanelBanHangLayout.setVerticalGroup(
            PanelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBanHangLayout.createSequentialGroup()
                .addComponent(TinhTienPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBanHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // xử lí sự kiện cho table Bán Sản Phẩm
    private void SPBanTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SPBanTableMouseClicked
        
        int row = SPBanTable.getSelectedRow();
        if (row >= 0) {
            int col = SPBanTable.columnAtPoint(evt.getPoint());
            // kiểm tra xem có phải là cột xem chi tiết không
            if (col == 5) {
                TableModel TM = SPBanTable.getModel();
                Object[] rowData = new Object[TM.getColumnCount()];
                for (int column = 0; column < TM.getColumnCount(); column++) {
                    rowData[column] = TM.getValueAt(row, column);
                }
                updateDetailPanel(rowData);
            } // thực hiện  chức năng mua hàng
            else if (col < 5) {
                // khi nào tạo hóa đơn thì mới được mua hàng
                if (TaoHD_Btn.isEnabled() == false) {
                    int clickCount = ClickCounts.get(row);
                    clickCount++;
                    ClickCounts.set(row, clickCount);
                    int Updatevalue = (int) SPBanTable.getModel().getValueAt(row, 2);
                    
                    if (Updatevalue > 0) {
                        SPBanTable.setValueAt((Updatevalue - 1), row, 2);
                        int masp = (int) SPBanTable.getModel().getValueAt(row, 0);
                        String tenSp = (String) SPBanTable.getModel().getValueAt(row, 1);
                        int giaban = (int) SPBanTable.getModel().getValueAt(row, 3);
                        String mausac=(String) SPBanTable.getModel().getValueAt(row, 4);
                        int rowIndex = findRowIntable(GioHangTable,masp, tenSp, giaban,mausac);
                        // cập nhật số lượng  đã mua khi nhấn nhiều lần vào 1 dòng cảu table bán Sản phẩm
                        if (rowIndex != -1) {
                            int ClickCount2 = (int) GioHangTable.getModel().getValueAt(rowIndex, 2) + 1;
                            GioHangTable.setValueAt(ClickCount2, rowIndex, 2);
                            int countSP = (int) GioHangTable.getModel().getValueAt(rowIndex, 2);
                            int donGia = (int) GioHangTable.getModel().getValueAt(rowIndex, 3);
                            GioHangTable.setValueAt(countSP * donGia, rowIndex, 5);
                        } // Lấy sản phẩm mới của table bán Sản Phẩm đem vào giỏ hàng
                        else {
                            int colCount=SPBanTable.getColumnCount();
                            Object[] rowData = new Object[colCount];
                            for (int column = 0; column < colCount ; column++) {
                                rowData[column] = SPBanTable.getValueAt(row, column);
                            }
                            if(colCount>2){
                                rowData[2] = clickCount;
                            }
                           
                            CheckGiohang(rowData);
                        }
                        PrintTongtien();
                    } else {
                        JOptionPane.showMessageDialog(null, "Mặt hàng hiện tại đã hết!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa tạo hóa đơn nên không thể mua hàng!");
                }
                
            }
            
        }
    }//GEN-LAST:event_SPBanTableMouseClicked

    private void TaoHD_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoHD_BtnActionPerformed
        TaoHD_Btn.setBackground(new Color(255, 255, 255));
        TaoHD_Btn.setForeground(new Color(204, 204, 204));
        HuyBtn.setBackground(new Color(239, 48, 55));
        ThanhToanBtn.setBackground(new Color(0, 102, 102));
        TaoHD_Btn.setEnabled(false);
        HuyBtn.setEnabled(true);
        ThanhToanBtn.setEnabled(true);
        

    }//GEN-LAST:event_TaoHD_BtnActionPerformed

    private void ThanhToanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThanhToanBtnActionPerformed
        
        TraLaiTien();
    }//GEN-LAST:event_ThanhToanBtnActionPerformed

    private void HuyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuyBtnActionPerformed
        //design cho các button 
        TaoHD_Btn.setBackground(new Color(0, 102, 102));
        TaoHD_Btn.setForeground(new Color(255, 255, 255));
        HuyBtn.setBackground(new Color(255, 255, 255));
        ThanhToanBtn.setBackground(new Color(255, 255, 255));
        TaoHD_Btn.setEnabled(true);
        HuyBtn.setEnabled(false);
        ThanhToanBtn.setEnabled(false);
        // xóa dữ liệu của table giỏ hàng
        int rowCount = GioHangTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modelGiohang.removeRow(i);
        }
        GioHangTable.setModel(modelGiohang);
        DisplayTongTienLabel.setText("");
        KhachDua_TF.setText("");
        TraLai_TF.setText("");
        MaHD_TF.setText("");
        SDT_TF.setText("");
        TenKH_TF.setText("");

    }//GEN-LAST:event_HuyBtnActionPerformed
    // xử lí sự kiện cho Table Giỏ Hàng
    private void GioHangTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GioHangTableMouseClicked
       int rowSelect =GioHangTable.getSelectedRow();
       if(rowSelect>=0){
           int columnSelect=GioHangTable.columnAtPoint(evt.getPoint());
           if(columnSelect==6){
               int masp=(int) GioHangTable.getModel().getValueAt(rowSelect, 0);
               String tenSp=(String)GioHangTable.getModel().getValueAt(rowSelect, 1);
               int giaban=(int)GioHangTable.getModel().getValueAt(rowSelect, 3);
               String mausac=(String)GioHangTable.getModel().getValueAt(rowSelect, 4);
               int rowIndex=findRowIntable(SPBanTable, masp, tenSp, giaban, mausac);
               
               if(rowIndex!=-1){
                   int soLuongMua=(int) GioHangTable.getModel().getValueAt(rowSelect, 2);
                   int soLuongCon=(int) SPBanTable.getModel().getValueAt(rowIndex, 2);
                  
                   SPBanTable.setValueAt(soLuongCon+soLuongMua, rowIndex, 2);
               }
               
           }
           modelGiohang.removeRow(rowSelect);
           PrintTongtien();
           
       }
       GioHangTable.setModel(modelGiohang);
       
    }//GEN-LAST:event_GioHangTableMouseClicked

    //Kiểm tra value có giống trong ArrayList không để đưa vào Panel chi tiết Sản phẩm
    private void updateDetailPanel(Object[] rowData) {
        int masp = Integer.parseInt(rowData[0].toString());
        String mauSac = rowData[4].toString();
        int giaban = Integer.parseInt(rowData[3].toString());
        for (SanPhamDTO sp : ListSP) {
            if (sp.getMasp() == masp && sp.getPBSPDTO().getGiaxuat() == giaban && sp.getMSDTO().getTenmau() == mauSac) {
                displayAdditionalDetails(sp);
                
                break;
            }
        }
    }

    // Nơi hiển thị Dialog chi tiết sản phẩm
    private void displayAdditionalDetails(SanPhamDTO sp) {
        //Panel chính
        JPanel displayPanelDetail = new JPanel(new BorderLayout());
        displayPanelDetail.setPreferredSize(new Dimension(600, 600));
        // panel cho image Sản phẩm
        JPanel ImgPanel = new JPanel();
        ImgPanel.setPreferredSize(new Dimension(600, 350));
        String LinkImg = "src\\img_product\\" + sp.getHinhanh();
        ImageIcon Img = new ImageIcon(LinkImg);
        JLabel imgLabel = new JLabel(Img);
        ImgPanel.add(imgLabel);
        displayPanelDetail.add(ImgPanel, BorderLayout.NORTH);
        // Panel cho thông tin Sản phẩm
        JPanel PanelInfor = new JPanel(new BorderLayout());
        PanelInfor.setPreferredSize(new Dimension(600, 250));
        JLabel TenSPLabel = new JLabel(sp.getTensp());
        TenSPLabel.setVerticalAlignment(SwingConstants.CENTER);
        TenSPLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TenSPLabel.setFont(new Font("Soego UI", Font.BOLD, 20));
        PanelInfor.add(TenSPLabel, BorderLayout.NORTH);
        JLabel GiaSPLabel = new JLabel(dfGiaTien.format(sp.getPBSPDTO().getGiaxuat()) + "");
        GiaSPLabel.setVerticalAlignment(SwingConstants.CENTER);
        GiaSPLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GiaSPLabel.setFont(new Font("Soego UI", Font.BOLD, 18));
        PanelInfor.add(GiaSPLabel, BorderLayout.SOUTH);
        // Tạo dữ liệu cho bảng
        Object[][] data = {
            {"Kích thước màn hình", dfThapPhan.format(sp.getKichthuocman())},
            {"Chíp xử lí", sp.getChipxuly()},
            {"Dung Lượng Ram", sp.getDLRamDTO().getDungluongram()},
            {"Dung Lượng Rom", sp.getDLRomDTO().getDungluongrom()},
            {"Camera sau", sp.getCamerasau()},
            {"Camera trước", sp.getCameratruoc()},
            {"Hệ điều hành", sp.getHDHDTO().getTenhdh()},
            {"Phiên bản hệ điều hành", sp.getPhienbanhdh()},
            {"Dung lượng pin", sp.getDungluongpin()},
            {"Màu sắc", sp.getMSDTO().getTenmau()},
            {"Thương hiệu", sp.getTHDTO().getTenthuonghieu()},
            {"Xuất xứ", sp.getXXDTO().getTenxuatxu()},};
        
        String[] columnNames = {"Thông số", "Giá trị"};
        DefaultTableModel modelDetail = new DefaultTableModel(data, columnNames);
        JTable ThongSoTable = new JTable(modelDetail);
        ThongSoTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        JScrollPane scrollPane = new JScrollPane(ThongSoTable);
        PanelInfor.add(scrollPane, BorderLayout.CENTER);
        displayPanelDetail.add(PanelInfor, BorderLayout.SOUTH);
        JDialog popupDialog = new JDialog();
        popupDialog.getContentPane().add(displayPanelDetail);
        popupDialog.pack();
        popupDialog.setLocationRelativeTo(null);
        popupDialog.setVisible(true);
    }

    // Kiểm tra value trước khi đưa vào bảng Giỏ hàng
    private void CheckGiohang(Object[] rowdata) {
        int masp = Integer.parseInt(rowdata[0].toString());
        String mauSac = rowdata[4].toString();
        int giaban = Integer.parseInt(rowdata[3].toString());
        int count = Integer.parseInt(rowdata[2].toString());
        for (SanPhamDTO sp : ListSP) {
            if (sp.getMasp() == masp && sp.getPBSPDTO().getGiaxuat() == giaban && sp.getMSDTO().getTenmau() == mauSac) {
                addGiohang(sp, count);              
                break;
            }
        }
    }

    // thêm sản phẩm vừa chọn ở Table Sản Phẩm bán lên Table Giỏ Hàng
    private void addGiohang(SanPhamDTO sp, int count) {
        int Tongtien = count * sp.getPBSPDTO().getGiaxuat();
        modelGiohang.addRow(new Object[]{
            sp.getMasp(),
            sp.getTensp(),
            count,
            sp.getPBSPDTO().getGiaxuat(),
            sp.getMSDTO().getTenmau(), 
            Tongtien,
            "❌"
        });
        GioHangTable.setModel(modelGiohang);
    }

    // tìm value trong bảng Giỏ hàng có tồn tại hay không để cập nhập số lượng
    private int findRowIntable(JTable table,int masp, String tensp, int giaban,String mausac) {
        for (int i = 0; i < table.getModel().getRowCount(); i++) {
            int MaSP = (int) table.getModel().getValueAt(i, 0);
            String TenSP = (String) table.getModel().getValueAt(i, 1);
            int GiaBan = (int) table.getModel().getValueAt(i, 3);
            String MauSac=(String) table.getModel().getValueAt(i, 4);
            if (MaSP == masp && TenSP.equals(tensp) && GiaBan == giaban &&MauSac.equals(mausac)) {
                return i;
            }
        }
        return -1;
    }

    // In tổng tiền bên Hóa đơn
    private void PrintTongtien() {
        int TongTienSP = 0;
        for (int i = 0; i < GioHangTable.getModel().getRowCount(); i++) {
            int tongTien = (int) GioHangTable.getModel().getValueAt(i, 5);
            TongTienSP += tongTien;
            DisplayTongTienLabel.setText(dfGiaTien.format(TongTienSP));
        }
        int rowCount=GioHangTable.getModel().getRowCount();
        if(rowCount==0){
            DisplayTongTienLabel.setText("0 VNĐ");
        }
    }
    
    private void TraLaiTien() {
        
        if (KhachDua_TF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa nhập số tiền khách đưa!");
            KhachDua_TF.requestFocus();
            return;
        } else {
            String tongTienStr = DisplayTongTienLabel.getText().replaceAll("[,VNĐ]", "").trim();
            try {
                int tienKhachDua = Integer.parseInt(KhachDua_TF.getText().trim());
                int tongTienSP = Integer.parseInt(tongTienStr);
                int tienThoiLai = tienKhachDua - tongTienSP;
                if (tienThoiLai < 0) {
                    JOptionPane.showMessageDialog(null, "Số tiền khách đưa chưa đủ!");
                    KhachDua_TF.requestFocus();
                } else {
                    
                    TraLai_TF.setText(tienThoiLai + "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DisplayTongTienLabel;
    private javax.swing.JTable GioHangTable;
    private javax.swing.JPanel GiohangPanel;
    private javax.swing.JButton HuyBtn;
    private javax.swing.JTextField KhachDua_TF;
    private javax.swing.JTextField MaHD_TF;
    private javax.swing.JPanel PanelBanHang;
    private javax.swing.JPanel PanelThanhToan;
    private javax.swing.JTextField SDT_TF;
    private javax.swing.JPanel SPBanPanel;
    private javax.swing.JTable SPBanTable;
    private javax.swing.JButton TaoHD_Btn;
    private javax.swing.JTextField TenKH_TF;
    private javax.swing.JButton ThanhToanBtn;
    private javax.swing.JPanel TinhTienPanel2;
    private javax.swing.JTextField TraLai_TF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField searchMaSP_TF;
    // End of variables declaration//GEN-END:variables
}
