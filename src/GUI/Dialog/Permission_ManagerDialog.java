/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Dialog;

import Component.InputForm;
import DAO.PermissionManagerDAO;
import DTO.PermissionManagerDTO;
import DTO.WarrantyDTO;
import GUI.Permission_Manager;
import GUI.Permission_Manager;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.mysql.cj.xdevapi.Schema.Validation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.SwingUtilities;


/**
 *
 * @author Danny
 */
public class Permission_ManagerDialog extends javax.swing.JPanel {

    private JLabel titlePage;
    private Permission_Manager jpper;
    private InputForm maNhomQuyen;
    private InputForm tenDangNhap;
    private JButton btnadd;
    private JButton btnupdate;

    private PermissionManagerDTO PMD;


    /**
     * Creates new form PermissionDialog
     */
    public Permission_ManagerDialog() {
        initComponents();
    }
     public Permission_ManagerDialog(String title,String text) {
        initComponents(title,text);
        
    }
     public Permission_ManagerDialog(String title,String text,PermissionManagerDTO PM) {
        initComponents(title,text);
         //System.out.println(PM);
        this.PMD = PM;
         System.out.println(PMD);
        initInfo();
    }
    public void initInfo() {
        maNhomQuyen.setText(this.PMD.getMaNhomQuyen()+"");
        tenDangNhap.setText(this.PMD.getTenNhomQuyen());
        
    }

    public void disabledText() {
        maNhomQuyen.txtForm.setEnabled(false);
        tenDangNhap.txtForm.setEnabled(false);
    }

    public void initComponents(String title, String type) {
        JPanel PanelPhanQUyen=new JPanel(new BorderLayout());
        PanelPhanQUyen.setPreferredSize(new Dimension(500,350));
        // title
        JPanel titlePanel = new JPanel();
        titlePage = new JLabel(title.toUpperCase());
        titlePage.setFont(new Font(FlatRobotoFont.FAMILY, 1 ,18));
        titlePage.setForeground(new Color(26,33,220));
        titlePanel.add(titlePage);

        // form
        maNhomQuyen = new InputForm("Mã nhóm quyền");
        tenDangNhap = new InputForm("Tên đăng nhập");

        JPanel JPanelCenter = new JPanel();
        JPanelCenter.setLayout(new GridLayout(2,1,0,10));
        JPanelCenter.setBorder(new EmptyBorder(10,10,10,10));
        JPanelCenter.add(maNhomQuyen);
        JPanelCenter.add(tenDangNhap);

        // button
        JPanel JPanelBottom = new JPanel();
        JPanelBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnadd = new JButton("Thêm");
        designBtn(btnadd);
        btnupdate = new JButton("Cập nhật");
        designBtn(btnupdate);
        switch (type) {
            case "add" -> JPanelBottom.add(btnadd);
            case "update" -> JPanelBottom.add(btnupdate);
                     
                    
            case "detail" -> {
                initInfo();
                disabledText();
            }
        
            default -> throw new AssertionError();
        }

        PanelPhanQUyen.add(titlePanel, BorderLayout.NORTH);
        PanelPhanQUyen.add(JPanelCenter, BorderLayout.CENTER);
        PanelPhanQUyen.add(JPanelBottom, BorderLayout.SOUTH);
        PanelPhanQUyen.setVisible(true);
        JDialog popupDialog=new JDialog();
        popupDialog.setModal(true);
        popupDialog.setContentPane(PanelPhanQUyen);
        popupDialog.pack();
        popupDialog.setLocationRelativeTo(null);
        popupDialog.setVisible(true);
    }
    public void designBtn(JButton button) {
        button.setPreferredSize(new Dimension(100, 40));
        button.setBackground(new Color(0, 153, 153));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(new Color(255, 255, 255));
    }
    public void Validation() {
        if (maNhomQuyen.txtForm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mã nhóm quyền không được để trống");
            return;
        }
        if (tenDangNhap.txtForm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống");
            return;
        }
    }

    // public void actionPerformed(ActionEvent e) {
    //     if (e.getSource() == btnadd && Validation()) {
    //         int maNhomQuyen = per.getMaNhomQuyen();
    //         String tenNhomQuyen = tenDangNhap.txtForm.getText();
    //         jpper.perBUS.add(new PermissionManagerDTO(maNhomQuyen, tenNhomQuyen));
    //         jpper.loadData(jpper.list);
    //     }

    //     if (e.getSource() == btnupdate && Validation()) {
    //         int maNhomQuyen = per.getMaNhomQuyen();
    //         String tenNhomQuyen = tenDangNhap.txtForm.getText();
    //         jpper.perBUS.update(new PermissionManagerDTO(maNhomQuyen, tenNhomQuyen));
    //         jpper.loadData(jpper.list);
    //     }
    // }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
