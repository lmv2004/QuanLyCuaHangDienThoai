/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class toolBar extends javax.swing.JPanel {

    public toolBar() {
        initComponents();
        function.placeHolder(tfSearch, "Nhập nội dung tìm kiếm...");
        
//        function.HoverBtn(addBtn, new Color(235,235,235), new Color(255,255,255));
//        function.HoverBtn(editBtn, new Color(235,235,235), new Color(255,255,255));
//        function.HoverBtn(removeBtn, new Color(235,235,235), new Color(255,255,255));
//        function.HoverBtn(detailBtn, new Color(235,235,235), new Color(255,255,255));
//        function.HoverBtn(exportBtn, new Color(235,235,235), new Color(255,255,255));
//        function.HoverBtn(importBtn, new Color(235,235,235), new Color(255,255,255));
//        function.HoverBtn(findBtn, new Color(235,235,235), new Color(255,255,255));
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
        jPanel3 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        detailBtn = new javax.swing.JButton();
        exportBtn = new javax.swing.JButton();
        importBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbbFilter = new javax.swing.JComboBox<>();
        tfSearch = new javax.swing.JTextField();
        findBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new FlatSVGIcon("img/add.svg",59,59));
        addBtn.setToolTipText("Thêm");
        addBtn.setBorder(null);
        addBtn.setBorderPainted(false);
        addBtn.setContentAreaFilled(false);
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addBtn.setPreferredSize(new java.awt.Dimension(59, 59));
        addBtn.setPressedIcon(new FlatSVGIcon("img/add.svg",53,53));
        jPanel3.add(addBtn);

        editBtn.setBackground(new java.awt.Color(255, 255, 255));
        editBtn.setIcon(new FlatSVGIcon("img/edit.svg",64,64));
        editBtn.setToolTipText("Sửa");
        editBtn.setBorder(null);
        editBtn.setBorderPainted(false);
        editBtn.setContentAreaFilled(false);
        editBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editBtn.setPreferredSize(new java.awt.Dimension(64, 64));
        editBtn.setPressedIcon(new FlatSVGIcon("img/edit.svg",58,58));
        jPanel3.add(editBtn);

        removeBtn.setBackground(new java.awt.Color(255, 255, 255));
        removeBtn.setIcon(new FlatSVGIcon("img/remove.svg",64,64));
        removeBtn.setToolTipText("Xóa");
        removeBtn.setBorder(null);
        removeBtn.setBorderPainted(false);
        removeBtn.setContentAreaFilled(false);
        removeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        removeBtn.setPreferredSize(new java.awt.Dimension(64, 64));
        removeBtn.setPressedIcon(new FlatSVGIcon("img/remove.svg",58,58));
        jPanel3.add(removeBtn);

        detailBtn.setBackground(new java.awt.Color(255, 255, 255));
        detailBtn.setIcon(new FlatSVGIcon("img/details.svg",68,68));
        detailBtn.setToolTipText("Chi tiết");
        detailBtn.setBorder(null);
        detailBtn.setBorderPainted(false);
        detailBtn.setContentAreaFilled(false);
        detailBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        detailBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        detailBtn.setPreferredSize(new java.awt.Dimension(68, 68));
        detailBtn.setPressedIcon(new FlatSVGIcon("img/details.svg",62,62));
        jPanel3.add(detailBtn);

        exportBtn.setBackground(new java.awt.Color(255, 255, 255));
        exportBtn.setIcon(new FlatSVGIcon("img/exportExcel.svg",64,64));
        exportBtn.setToolTipText("Xuất Excel");
        exportBtn.setBorder(null);
        exportBtn.setBorderPainted(false);
        exportBtn.setContentAreaFilled(false);
        exportBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        exportBtn.setPreferredSize(new java.awt.Dimension(64, 64));
        exportBtn.setPressedIcon(new FlatSVGIcon("img/exportExcel.svg",58,58));
        jPanel3.add(exportBtn);

        importBtn.setBackground(new java.awt.Color(255, 255, 255));
        importBtn.setIcon(new FlatSVGIcon("img/importExcel.svg",64,64));
        importBtn.setToolTipText("Nhập Excel");
        importBtn.setBorder(null);
        importBtn.setBorderPainted(false);
        importBtn.setContentAreaFilled(false);
        importBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        importBtn.setPreferredSize(new java.awt.Dimension(64, 64));
        importBtn.setPressedIcon(new FlatSVGIcon("img/importExcel.svg",58,58));
        jPanel3.add(importBtn);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0);
        flowLayout1.setAlignOnBaseline(true);
        jPanel2.setLayout(flowLayout1);

        cbbFilter.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel2.add(cbbFilter);

        tfSearch.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel2.add(tfSearch);

        findBtn.setBackground(new java.awt.Color(255, 255, 255));
        findBtn.setIcon(new FlatSVGIcon("img/search.svg",40,40));
        findBtn.setToolTipText("Tìm kiếm");
        findBtn.setBorder(null);
        findBtn.setBorderPainted(false);
        findBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        findBtn.setPreferredSize(new java.awt.Dimension(26, 26));
        findBtn.setPressedIcon(new FlatSVGIcon("img/search.svg",35,35));
        jPanel2.add(findBtn);

        refreshBtn.setIcon(new FlatSVGIcon("img/refresh.svg",30,30));
        refreshBtn.setToolTipText("Làm mới");
        refreshBtn.setBorder(null);
        refreshBtn.setBorderPainted(false);
        refreshBtn.setContentAreaFilled(false);
        refreshBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshBtn.setPreferredSize(new java.awt.Dimension(30, 30));
        refreshBtn.setPressedIcon(new FlatSVGIcon("img/refresh.svg",26,26));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public JButton getAddBtn() {
        return addBtn;
    }

    public void setAddBtn(JButton addBtn) {
        this.addBtn = addBtn;
    }

    public JComboBox<String> getCbbFilter() {
        return cbbFilter;
    }

    public void setCbbFilter(JComboBox<String> cbbFilter) {
        this.cbbFilter = cbbFilter;
    }

    public JButton getDetailBtn() {
        return detailBtn;
    }

    public void setDetailBtn(JButton detailBtn) {
        this.detailBtn = detailBtn;
    }

    public JButton getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(JButton editBtn) {
        this.editBtn = editBtn;
    }

    public JButton getExportBtn() {
        return exportBtn;
    }

    public void setExportBtn(JButton exportBtn) {
        this.exportBtn = exportBtn;
    }

    public JButton getFindBtn() {
        return findBtn;
    }

    public void setFindBtn(JButton findBtn) {
        this.findBtn = findBtn;
    }

    public JButton getImportBtn() {
        return importBtn;
    }

    public void setImportBtn(JButton importBtn) {
        this.importBtn = importBtn;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }

    public void setRemoveBtn(JButton removeBtn) {
        this.removeBtn = removeBtn;
    }

    public JTextField getTfSearch() {
        return tfSearch;
    }

    public void setTfSearch(JTextField tfSearch) {
        this.tfSearch = tfSearch;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JComboBox<String> cbbFilter;
    private javax.swing.JButton detailBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton exportBtn;
    private javax.swing.JButton findBtn;
    private javax.swing.JButton importBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
