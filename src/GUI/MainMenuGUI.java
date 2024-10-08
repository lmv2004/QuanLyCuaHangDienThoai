/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.AccountDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class MainMenuGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainMenuGUI
     */
    //my variables
    PhieuNhapGUI phieuNhap;
    PhieuXuatGUI phieuXuat;
    NhanVienGUI nhanVien;
    Account taiKhoan;
    BanHangGUI banHang;
    ThongKe thongKe;
    Warranty baoHanh;
    Permission_Manager phanQuyen;
    ClientView KhachHang;
    SupplierView NCC;
    ProductView SanPham;
    area khuVucKho;
    ArrayList<JButton> buttonList;
    DTO.AccountDTO myAcc;
    
    public MainMenuGUI(DTO.AccountDTO myAcc) {
        initComponents();
        setIconImage(new FlatSVGIcon("img/logo.svg",100,100).getImage());
        
        
        //lấy tất cả button chức năng
        buttonList = getAllButtons(ChucNangPnl);
        for(JButton btn : buttonList) {
            function.HoverBtn(btn, new Color(235,235,235), new Color(255,255,255), new Color(60, 78, 170));
        }
        
        //default
        banHang= new BanHangGUI();
        NoiDungPnl.add(banHang);
        NoiDungPnl.repaint();
        NoiDungPnl.validate();
        BanHangBtn.setBackground(new Color(36, 49, 117));
        function.setBtnBefore(BanHangBtn);
        
        //đỏ dữ liệu
        this.myAcc = myAcc;
        lblName.setText(new BUS.NhanVienBUS().getNameByID(this.myAcc.getMaNV()).toUpperCase());
        lblVitri.setText("ADMIN");
    }

    public AccountDTO getMyAcc() {
        return myAcc;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DashBoard = new javax.swing.JPanel();
        TaiKhoanPnl = new javax.swing.JPanel();
        lblVitri = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        ChucNangPnl = new javax.swing.JPanel();
        BanHangBtn = new javax.swing.JButton();
        SanPhamBtn = new javax.swing.JButton();
        NhanVienBtn = new javax.swing.JButton();
        KhachHangBtn = new javax.swing.JButton();
        BaoHanhBtn = new javax.swing.JButton();
        NCCBtn = new javax.swing.JButton();
        ThongKeBtn = new javax.swing.JButton();
        KVKhoBtn = new javax.swing.JButton();
        PhieuNhapBtn = new javax.swing.JButton();
        PhieuXuatBtn = new javax.swing.JButton();
        PhanQuyenBtn = new javax.swing.JButton();
        TaiKhoanBtn = new javax.swing.JButton();
        DangXuatBtn = new javax.swing.JButton();
        NoiDungPnl = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ CỬA HÀNG ĐIỆN THOẠI");
        setMinimumSize(new java.awt.Dimension(1500, 770));

        DashBoard.setBackground(new java.awt.Color(255, 255, 255));
        DashBoard.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DashBoard.setAlignmentX(0.0F);
        DashBoard.setAlignmentY(0.0F);
        DashBoard.setPreferredSize(new java.awt.Dimension(230, 725));

        TaiKhoanPnl.setBackground(new java.awt.Color(51, 204, 255));

        lblVitri.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        lblVitri.setForeground(new java.awt.Color(5, 7, 15));
        lblVitri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVitri.setText("Vị trí");

        jLabel1.setIcon(new FlatSVGIcon("img/avatar.svg",55,55));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblName.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        lblName.setForeground(new java.awt.Color(5, 7, 15));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("USER");

        javax.swing.GroupLayout TaiKhoanPnlLayout = new javax.swing.GroupLayout(TaiKhoanPnl);
        TaiKhoanPnl.setLayout(TaiKhoanPnlLayout);
        TaiKhoanPnlLayout.setHorizontalGroup(
            TaiKhoanPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaiKhoanPnlLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(TaiKhoanPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVitri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        TaiKhoanPnlLayout.setVerticalGroup(
            TaiKhoanPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaiKhoanPnlLayout.createSequentialGroup()
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblVitri, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ChucNangPnl.setBackground(new java.awt.Color(255, 255, 255));
        ChucNangPnl.setOpaque(false);
        ChucNangPnl.setLayout(new java.awt.GridLayout(13, 10));

        BanHangBtn.setBackground(new java.awt.Color(255, 255, 255));
        BanHangBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BanHangBtn.setForeground(new java.awt.Color(5, 7, 15));
        BanHangBtn.setIcon(new FlatSVGIcon("img/cart.svg",40,40));
        BanHangBtn.setText("BÁN HÀNG");
        BanHangBtn.setBorder(null);
        BanHangBtn.setFocusPainted(false);
        BanHangBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BanHangBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BanHangBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(BanHangBtn);

        SanPhamBtn.setBackground(new java.awt.Color(255, 255, 255));
        SanPhamBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SanPhamBtn.setForeground(new java.awt.Color(5, 7, 15));
        SanPhamBtn.setIcon(new FlatSVGIcon("img/product.svg",40,40));
        SanPhamBtn.setText("SẢN PHẨM");
        SanPhamBtn.setBorder(null);
        SanPhamBtn.setFocusPainted(false);
        SanPhamBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SanPhamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SanPhamBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(SanPhamBtn);

        NhanVienBtn.setBackground(new java.awt.Color(255, 255, 255));
        NhanVienBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NhanVienBtn.setForeground(new java.awt.Color(5, 7, 15));
        NhanVienBtn.setIcon(new FlatSVGIcon("img/staff.svg",40,40));
        NhanVienBtn.setText("NHÂN VIÊN");
        NhanVienBtn.setBorder(null);
        NhanVienBtn.setFocusPainted(false);
        NhanVienBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NhanVienBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhanVienBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(NhanVienBtn);

        KhachHangBtn.setBackground(new java.awt.Color(255, 255, 255));
        KhachHangBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        KhachHangBtn.setForeground(new java.awt.Color(5, 7, 15));
        KhachHangBtn.setIcon(new FlatSVGIcon("img/customer.svg",40,40));
        KhachHangBtn.setText("KHÁCH HÀNG");
        KhachHangBtn.setBorder(null);
        KhachHangBtn.setFocusPainted(false);
        KhachHangBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        KhachHangBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KhachHangBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(KhachHangBtn);

        BaoHanhBtn.setBackground(new java.awt.Color(255, 255, 255));
        BaoHanhBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BaoHanhBtn.setForeground(new java.awt.Color(5, 7, 15));
        BaoHanhBtn.setIcon(new FlatSVGIcon("img/warranty.svg",40,40));
        BaoHanhBtn.setText("BẢO HÀNH");
        BaoHanhBtn.setBorder(null);
        BaoHanhBtn.setFocusPainted(false);
        BaoHanhBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BaoHanhBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaoHanhBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(BaoHanhBtn);

        NCCBtn.setBackground(new java.awt.Color(255, 255, 255));
        NCCBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NCCBtn.setForeground(new java.awt.Color(5, 7, 15));
        NCCBtn.setIcon(new FlatSVGIcon("img/suppiler.svg",40,40));
        NCCBtn.setText("NHÀ CUNG CẤP");
        NCCBtn.setBorder(null);
        NCCBtn.setFocusPainted(false);
        NCCBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NCCBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCCBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(NCCBtn);

        ThongKeBtn.setBackground(new java.awt.Color(255, 255, 255));
        ThongKeBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ThongKeBtn.setForeground(new java.awt.Color(5, 7, 15));
        ThongKeBtn.setIcon(new FlatSVGIcon("img/chart.svg",40,40));
        ThongKeBtn.setText("THỐNG KÊ");
        ThongKeBtn.setBorder(null);
        ThongKeBtn.setFocusPainted(false);
        ThongKeBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ThongKeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKeBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(ThongKeBtn);

        KVKhoBtn.setBackground(new java.awt.Color(255, 255, 255));
        KVKhoBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        KVKhoBtn.setForeground(new java.awt.Color(5, 7, 15));
        KVKhoBtn.setIcon(new FlatSVGIcon("img/area.svg",40,40));
        KVKhoBtn.setText("KHU VỰC KHO");
        KVKhoBtn.setBorder(null);
        KVKhoBtn.setFocusPainted(false);
        KVKhoBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        KVKhoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KVKhoBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(KVKhoBtn);

        PhieuNhapBtn.setBackground(new java.awt.Color(255, 255, 255));
        PhieuNhapBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PhieuNhapBtn.setForeground(new java.awt.Color(5, 7, 15));
        PhieuNhapBtn.setIcon(new FlatSVGIcon("img/import.svg",40,40));
        PhieuNhapBtn.setText("PHIẾU NHẬP");
        PhieuNhapBtn.setBorder(null);
        PhieuNhapBtn.setFocusPainted(false);
        PhieuNhapBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PhieuNhapBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhieuNhapBtnMouseClicked(evt);
            }
        });
        PhieuNhapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhieuNhapBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(PhieuNhapBtn);

        PhieuXuatBtn.setBackground(new java.awt.Color(255, 255, 255));
        PhieuXuatBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PhieuXuatBtn.setForeground(new java.awt.Color(5, 7, 15));
        PhieuXuatBtn.setIcon(new FlatSVGIcon("img/export.svg",40,40));
        PhieuXuatBtn.setText("PHIẾU XUẤT");
        PhieuXuatBtn.setBorder(null);
        PhieuXuatBtn.setFocusPainted(false);
        PhieuXuatBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PhieuXuatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhieuXuatBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(PhieuXuatBtn);

        PhanQuyenBtn.setBackground(new java.awt.Color(255, 255, 255));
        PhanQuyenBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PhanQuyenBtn.setForeground(new java.awt.Color(5, 7, 15));
        PhanQuyenBtn.setIcon(new FlatSVGIcon("img/decentral.svg",40,40));
        PhanQuyenBtn.setText("PHÂN QUYỀN");
        PhanQuyenBtn.setBorder(null);
        PhanQuyenBtn.setFocusPainted(false);
        PhanQuyenBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PhanQuyenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhanQuyenBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(PhanQuyenBtn);

        TaiKhoanBtn.setBackground(new java.awt.Color(255, 255, 255));
        TaiKhoanBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TaiKhoanBtn.setForeground(new java.awt.Color(5, 7, 15));
        TaiKhoanBtn.setIcon(new FlatSVGIcon("img/account.svg",40,40));
        TaiKhoanBtn.setText("TÀI KHOẢN");
        TaiKhoanBtn.setBorder(null);
        TaiKhoanBtn.setFocusPainted(false);
        TaiKhoanBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TaiKhoanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaiKhoanBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(TaiKhoanBtn);

        DangXuatBtn.setBackground(new java.awt.Color(255, 255, 255));
        DangXuatBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DangXuatBtn.setForeground(new java.awt.Color(5, 7, 15));
        DangXuatBtn.setIcon(new FlatSVGIcon("img/logout.svg",40,40));
        DangXuatBtn.setText("ĐĂNG XUẤT");
        DangXuatBtn.setBorder(null);
        DangXuatBtn.setFocusPainted(false);
        DangXuatBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DangXuatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangXuatBtnActionPerformed(evt);
            }
        });
        ChucNangPnl.add(DangXuatBtn);

        javax.swing.GroupLayout DashBoardLayout = new javax.swing.GroupLayout(DashBoard);
        DashBoard.setLayout(DashBoardLayout);
        DashBoardLayout.setHorizontalGroup(
            DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChucNangPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(TaiKhoanPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        DashBoardLayout.setVerticalGroup(
            DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardLayout.createSequentialGroup()
                .addComponent(TaiKhoanPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ChucNangPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        getContentPane().add(DashBoard, java.awt.BorderLayout.LINE_START);

        NoiDungPnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        NoiDungPnl.setPreferredSize(new java.awt.Dimension(1200, 725));
        NoiDungPnl.setLayout(new java.awt.BorderLayout());
        getContentPane().add(NoiDungPnl, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBanHangBtn() {
        return BanHangBtn;
    }
    
    public static ArrayList<JButton> getAllButtons(JPanel panel) {
        ArrayList<JButton> buttonList = new ArrayList<>();
        Component[] components = panel.getComponents();

        for (Component component : components) {
            if (component instanceof javax.swing.JButton) {
                buttonList.add((JButton) component);
            }
        }
        return buttonList;
    }
    
    private void DangXuatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangXuatBtnActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn ĐĂNG XUẤT?", "ĐĂNG XUẤT", JOptionPane.YES_NO_OPTION, 0, new FlatSVGIcon("img/logout.svg", 50, 50))==0) {
            this.dispose();
            new LogInGUI().setVisible(true);
        }
    }//GEN-LAST:event_DangXuatBtnActionPerformed

    private void ThongKeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKeBtnActionPerformed
        // TODO add your handling code here:
        NoiDungPnl.removeAll();
        thongKe= new ThongKe();
        NoiDungPnl.add(thongKe);
        NoiDungPnl.repaint();
        NoiDungPnl.validate();
    }//GEN-LAST:event_ThongKeBtnActionPerformed

    private void PhanQuyenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhanQuyenBtnActionPerformed
        // TODO add your handling code here:
        NoiDungPnl.removeAll();
        phanQuyen= new Permission_Manager();
        NoiDungPnl.add(phanQuyen);
        NoiDungPnl.repaint();
        NoiDungPnl.validate();
    }//GEN-LAST:event_PhanQuyenBtnActionPerformed

    private void BaoHanhBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaoHanhBtnActionPerformed
        // TODO add your handling code here:
        NoiDungPnl.removeAll();
        baoHanh= new Warranty();
        NoiDungPnl.add(baoHanh);
        NoiDungPnl.repaint();
        NoiDungPnl.validate();
    }//GEN-LAST:event_BaoHanhBtnActionPerformed

    private void NhanVienBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhanVienBtnActionPerformed
        NoiDungPnl.removeAll();
        nhanVien=new NhanVienGUI();
        NoiDungPnl.add(nhanVien,BorderLayout.CENTER);
        NoiDungPnl.repaint();
        NoiDungPnl.validate();
    }//GEN-LAST:event_NhanVienBtnActionPerformed

    private void TaiKhoanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaiKhoanBtnActionPerformed
        // TODO add your handling code here:
        NoiDungPnl.removeAll();
        taiKhoan= new Account();
        NoiDungPnl.add(taiKhoan);
        NoiDungPnl.repaint();
        NoiDungPnl.validate();
    }//GEN-LAST:event_TaiKhoanBtnActionPerformed

    private void PhieuNhapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhieuNhapBtnActionPerformed
        // TODO add your handling code here:
        NoiDungPnl.removeAll();
        phieuNhap=new PhieuNhapGUI(myAcc);
        NoiDungPnl.add(phieuNhap,BorderLayout.CENTER);
        NoiDungPnl.revalidate();
    }//GEN-LAST:event_PhieuNhapBtnActionPerformed

    private void PhieuNhapBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhieuNhapBtnMouseClicked

    }//GEN-LAST:event_PhieuNhapBtnMouseClicked

    private void PhieuXuatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhieuXuatBtnActionPerformed
        // TODO add your handling code here:
        NoiDungPnl.removeAll();
        phieuXuat=new PhieuXuatGUI(myAcc);
        NoiDungPnl.add(phieuXuat,BorderLayout.CENTER);
        NoiDungPnl.repaint();
        NoiDungPnl.revalidate();
    }//GEN-LAST:event_PhieuXuatBtnActionPerformed

    private void BanHangBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BanHangBtnActionPerformed
        NoiDungPnl.removeAll();
        banHang= new BanHangGUI();
        NoiDungPnl.add(banHang);
        NoiDungPnl.repaint();
        NoiDungPnl.validate();
    }//GEN-LAST:event_BanHangBtnActionPerformed

    private void KhachHangBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachHangBtnActionPerformed
        // TODO add your handling code here:
        NoiDungPnl.removeAll();
        KhachHang= new ClientView();
        NoiDungPnl.add(KhachHang);
        NoiDungPnl.repaint();
        NoiDungPnl.validate();
    }//GEN-LAST:event_KhachHangBtnActionPerformed

    private void NCCBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCCBtnActionPerformed
        // TODO add your handling code here:
        NoiDungPnl.removeAll();
        NCC= new SupplierView();
        NoiDungPnl.add(NCC);
        NoiDungPnl.repaint();
        NoiDungPnl.validate();
    }//GEN-LAST:event_NCCBtnActionPerformed

    private void SanPhamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SanPhamBtnActionPerformed
        // TODO add your handling code here:
        NoiDungPnl.removeAll();
        SanPham= new ProductView();
        NoiDungPnl.add(SanPham);
        NoiDungPnl.repaint();
        NoiDungPnl.validate();
    }//GEN-LAST:event_SanPhamBtnActionPerformed

    private void KVKhoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KVKhoBtnActionPerformed
        NoiDungPnl.removeAll();
        khuVucKho = new area();
        NoiDungPnl.add(khuVucKho);
        NoiDungPnl.repaint();
        NoiDungPnl.validate();
    }//GEN-LAST:event_KVKhoBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BanHangBtn;
    private javax.swing.JButton BaoHanhBtn;
    private javax.swing.JPanel ChucNangPnl;
    private javax.swing.JButton DangXuatBtn;
    private javax.swing.JPanel DashBoard;
    private javax.swing.JButton KVKhoBtn;
    private javax.swing.JButton KhachHangBtn;
    private javax.swing.JButton NCCBtn;
    private javax.swing.JButton NhanVienBtn;
    private javax.swing.JPanel NoiDungPnl;
    private javax.swing.JButton PhanQuyenBtn;
    private javax.swing.JButton PhieuNhapBtn;
    private javax.swing.JButton PhieuXuatBtn;
    private javax.swing.JButton SanPhamBtn;
    private javax.swing.JButton TaiKhoanBtn;
    private javax.swing.JPanel TaiKhoanPnl;
    private javax.swing.JButton ThongKeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblVitri;
    // End of variables declaration//GEN-END:variables
}
