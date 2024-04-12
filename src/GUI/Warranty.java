/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Danny
 */
public class Warranty extends javax.swing.JPanel {

    /**
     * Creates new form Warranty
     */
    public Warranty() {
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

        Button_Function = new javax.swing.JPanel();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Detail = new javax.swing.JButton();
        Import_Excel = new javax.swing.JButton();
        Export_Excel = new javax.swing.JButton();
        Filter = new javax.swing.JComboBox<>();
        Search_Bar = new javax.swing.JTextField();
        Refresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_Warranty = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1200, 720));

        Button_Function.setPreferredSize(new java.awt.Dimension(820, 75));

        Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        Add.setToolTipText("Add");
        Add.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Add.setIconTextGap(8);
        Add.setMargin(new java.awt.Insets(2, 5, 2, 5));
        Add.setPreferredSize(new java.awt.Dimension(70, 50));
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        Update.setToolTipText("Update");
        Update.setIconTextGap(8);
        Update.setMargin(new java.awt.Insets(2, 5, 2, 5));
        Update.setPreferredSize(new java.awt.Dimension(70, 50));
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        Delete.setToolTipText("Delete");
        Delete.setIconTextGap(8);
        Delete.setMargin(new java.awt.Insets(2, 5, 2, 5));
        Delete.setPreferredSize(new java.awt.Dimension(70, 50));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Detail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/detail.png"))); // NOI18N
        Detail.setToolTipText("Detail");
        Detail.setIconTextGap(8);
        Detail.setMargin(new java.awt.Insets(2, 5, 2, 5));
        Detail.setPreferredSize(new java.awt.Dimension(70, 50));
        Detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailActionPerformed(evt);
            }
        });

        Import_Excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/import_excel.png"))); // NOI18N
        Import_Excel.setToolTipText("Import");
        Import_Excel.setIconTextGap(8);
        Import_Excel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        Import_Excel.setPreferredSize(new java.awt.Dimension(70, 50));
        Import_Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Import_ExcelActionPerformed(evt);
            }
        });

        Export_Excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/export_excel.png"))); // NOI18N
        Export_Excel.setToolTipText("Export");
        Export_Excel.setIconTextGap(8);
        Export_Excel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        Export_Excel.setPreferredSize(new java.awt.Dimension(70, 50));
        Export_Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Export_ExcelActionPerformed(evt);
            }
        });

        Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Nhóm Quyền", "Mã Nhân Viên", "Nhóm Quyền", "Trạng Thái" }));
        Filter.setPreferredSize(new java.awt.Dimension(100, 30));
        Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

        Search_Bar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Search_Bar.setText("Nhập Nội Dung Tìm Kiếm");
        Search_Bar.setActionCommand("<Not Set>");
        Search_Bar.setPreferredSize(new java.awt.Dimension(300, 30));
        Search_Bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_BarActionPerformed(evt);
            }
        });

        Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        Refresh.setToolTipText("Refresh");
        Refresh.setIconTextGap(8);
        Refresh.setMargin(new java.awt.Insets(2, 5, 2, 5));
        Refresh.setPreferredSize(new java.awt.Dimension(70, 50));
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Button_FunctionLayout = new javax.swing.GroupLayout(Button_Function);
        Button_Function.setLayout(Button_FunctionLayout);
        Button_FunctionLayout.setHorizontalGroup(
            Button_FunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button_FunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Detail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Import_Excel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Export_Excel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Search_Bar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Button_FunctionLayout.setVerticalGroup(
            Button_FunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Button_FunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Button_FunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search_Bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Export_Excel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Import_Excel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Detail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        List_Warranty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
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
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Button_Function, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Button_Function, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateActionPerformed

    private void DetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DetailActionPerformed

    private void Import_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Import_ExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Import_ExcelActionPerformed

    private void Export_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Export_ExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Export_ExcelActionPerformed

    private void Search_BarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_BarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Search_BarActionPerformed

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilterActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JPanel Button_Function;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Detail;
    private javax.swing.JButton Export_Excel;
    private javax.swing.JComboBox<String> Filter;
    private javax.swing.JButton Import_Excel;
    private javax.swing.JTable List_Warranty;
    private javax.swing.JButton Refresh;
    private javax.swing.JTextField Search_Bar;
    private javax.swing.JButton Update;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
