/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import static GUI.MainMenuGUI.getAllButtons;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author ACER
 */
public class toolBar extends javax.swing.JPanel {

    public toolBar() {
        initComponents();
        function.placeHolder(tfSearch, "Nhập nội dung tìm kiếm...");
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
        jButton7 = new javax.swing.JButton();

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new FlatSVGIcon("img/add.svg",59,59));
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
        exportBtn.setIcon(new FlatSVGIcon("img/importExcel.svg",64,64));
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
        importBtn.setIcon(new FlatSVGIcon("img/exportExcel.svg",64,64));
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

        cbbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbbFilter.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel2.add(cbbFilter);

        tfSearch.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel2.add(tfSearch);

        jButton7.setIcon(new FlatSVGIcon("img/search.svg",40,40));
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton7.setPressedIcon(new FlatSVGIcon("img/search.svg",35,35));
        jPanel2.add(jButton7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JComboBox<String> cbbFilter;
    private javax.swing.JButton detailBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton exportBtn;
    private javax.swing.JButton importBtn;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
