/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Dialog;

import Component.InputForm;
import DAO.WarrantyDAO;
import DTO.WarrantyDTO;
import GUI.Warranty;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Danny
 */
public class WarrantyDialog extends javax.swing.JPanel implements ActionListener {

    public WarrantyDTO warranty;

    private JLabel titlePage;

    private Warranty JPWarranty;

    private InputForm maSanPham;
    private InputForm maBaoHanh;
    private InputForm tenKhachHang;
    private InputForm yeuCauBaoHanh;

    private JButton btnadd;
    private JButton btnupdate;

    /**
     * Creates new form WarrantyDialog
     */
    public WarrantyDialog() {
        initComponents();
    }

    public WarrantyDialog(Warranty JPWarranty, java.awt.Frame parent, boolean modal, String title, String type) {
        // super(parent, modal);
        this.JPWarranty = JPWarranty;
        initComponents(title, type);
    }

    public WarrantyDialog(Warranty JPWarranty, java.awt.Frame parent, boolean modal, String title, String type,
            WarrantyDTO warranty) {
        this.JPWarranty = JPWarranty;
        this.warranty = warranty;
        initComponents(title, type);
    }

    public void initComponents(String title, String type) {
        this.setSize(500, 500);
        this.setLayout(new BorderLayout(0, 0));

        // Title
        JPanel JPanelTop = new JPanel();
        titlePage = new JLabel(title.toUpperCase());
        titlePage.setFont(new Font(FlatRobotoFont.FAMILY, 1, 18));
        titlePage.setForeground(new Color(26, 33, 220));

        JPanelTop.setLayout(new FlowLayout());
        JPanelTop.add(titlePage);

        // Input Content
        maSanPham = new InputForm("Mã sản phẩm");
        maBaoHanh = new InputForm("Mã bảo hành");
        tenKhachHang = new InputForm("Tên khách hàng");
        yeuCauBaoHanh = new InputForm("Yêu cầu bảo hành");

        JPanel JPanelCenter = new JPanel();
        JPanelCenter.setLayout(new GridLayout(4, 1, 20, 0));
        JPanelCenter.add(maSanPham);
        JPanelCenter.add(maBaoHanh);
        JPanelCenter.add(tenKhachHang);
        JPanelCenter.add(yeuCauBaoHanh);

        // Button
        JPanel JPanelBottom = new JPanel();
        btnadd = new JButton("Thêm bảo hành");
        btnupdate = new JButton("Cập nhật bảo hành");
        btnadd.addActionListener((ActionListener) this);
        btnupdate.addActionListener((ActionListener) this);

        switch (type) {
            case "add":
                JPanelBottom.add(btnadd);
                break;

            case "update":
                JPanelBottom.add(btnupdate);
                initInfo();
                break;

            case "detail":
                initInfo();
                break;

            default:
                throw new AssertionError();
        }

        this.add(JPanelTop, BorderLayout.NORTH);
        this.add(JPanelCenter, BorderLayout.CENTER);
        this.add(JPanelBottom, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void initInfo() {
        maSanPham.setText(Integer.toString(warranty.getMaSanPham()));
        maBaoHanh.setText(Integer.toString(warranty.getMaBaoHanh()));
        tenKhachHang.setText(warranty.getTenKhachHang());
        yeuCauBaoHanh.setText(warranty.getYeuCauBaoHanh());
    }

    // Validation
    public boolean Validation() {
        if (maSanPham.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được rỗng", "Cảnh báo !",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (maBaoHanh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã bảo hành không được rỗng", "Cảnh báo !",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (tenKhachHang.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên khách hàng không được rỗng", "Cảnh báo !",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (yeuCauBaoHanh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Yêu cầu bảo hành không được rỗng", "Cảnh báo !",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnadd && Validation()) {
            int maSanPham = Integer.parseInt(this.maSanPham.getText());
            int maBaoHanh = Integer.parseInt(this.maBaoHanh.getText());
            String tenKhachHang = this.tenKhachHang.getText();
            String yeuCauBaoHanh = this.yeuCauBaoHanh.getText();

            JPWarranty.loadData(JPWarranty.warrantyBUS.getAll());
            
        } else if (e.getSource() == btnupdate && Validation()) {
            int maSanPham = Integer.parseInt(this.maSanPham.getText());
            int maBaoHanh = Integer.parseInt(this.maBaoHanh.getText());
            String tenKhachHang = this.tenKhachHang.getText();
            String yeuCauBaoHanh = this.yeuCauBaoHanh.getText();

            JPWarranty.loadData(JPWarranty.warrantyBUS.getAll());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
