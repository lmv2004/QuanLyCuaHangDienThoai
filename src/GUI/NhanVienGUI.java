/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Vuong
 */
public class NhanVienGUI extends javax.swing.JPanel {

    /**
     * Creates new form NhanVienGUI
     */
    public NhanVienGUI() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AddBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        ImportExcelBtn = new javax.swing.JButton();
        DetailBtn = new javax.swing.JButton();
        ExportExcelBtn = new javax.swing.JButton();
        CatogoryCBB = new javax.swing.JComboBox<>();
        SearchTF = new javax.swing.JTextField();
        RefreshBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableNhanVien = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        AddBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        AddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hopstarter-Button-Button-Add.32.png"))); // NOI18N
        AddBtn.setText("Thêm");
        AddBtn.setBorder(null);
        AddBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddBtn.setIconTextGap(0);
        AddBtn.setInheritsPopupMenu(true);
        AddBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        AddBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        AddBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        EditBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        EditBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        EditBtn.setText("Sửa");
        EditBtn.setBorder(null);
        EditBtn.setFocusable(false);
        EditBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditBtn.setIconTextGap(0);
        EditBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        EditBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        EditBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        DeleteBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        DeleteBtn.setText("Xóa");
        DeleteBtn.setBorder(null);
        DeleteBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DeleteBtn.setIconTextGap(0);
        DeleteBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        ImportExcelBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        ImportExcelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/import_excel.png"))); // NOI18N
        ImportExcelBtn.setText("Nhập Excel");
        ImportExcelBtn.setBorder(null);
        ImportExcelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImportExcelBtn.setIconTextGap(0);
        ImportExcelBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        DetailBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        DetailBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/detail.png"))); // NOI18N
        DetailBtn.setText("Chi tiết");
        DetailBtn.setBorder(null);
        DetailBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DetailBtn.setIconTextGap(0);
        DetailBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        ExportExcelBtn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        ExportExcelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/export_excel.png"))); // NOI18N
        ExportExcelBtn.setText("Xuất Excel");
        ExportExcelBtn.setBorder(null);
        ExportExcelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ExportExcelBtn.setIconTextGap(0);
        ExportExcelBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        CatogoryCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        SearchTF.setText("Nhập nội dung tìm kiếm..");
        SearchTF.setToolTipText("");

        RefreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        RefreshBtn.setText("Làm mới");
        RefreshBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        RefreshBtn.setIconTextGap(2);
        RefreshBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(AddBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DetailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImportExcelBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExportExcelBtn)
                .addGap(40, 40, 40)
                .addComponent(CatogoryCBB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RefreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ExportExcelBtn)
                            .addComponent(ImportExcelBtn)
                            .addComponent(DetailBtn)
                            .addComponent(DeleteBtn)
                            .addComponent(EditBtn)
                            .addComponent(AddBtn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CatogoryCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefreshBtn))
                        .addGap(13, 13, 13)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        TableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MNV", "Họ Tên", "Giới tính", "Ngày sinh", "SĐT", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableNhanVien.setShowGrid(false);
        jScrollPane1.setViewportView(TableNhanVien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JComboBox<String> CatogoryCBB;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton DetailBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JButton ExportExcelBtn;
    private javax.swing.JButton ImportExcelBtn;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JTextField SearchTF;
    private javax.swing.JTable TableNhanVien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}


