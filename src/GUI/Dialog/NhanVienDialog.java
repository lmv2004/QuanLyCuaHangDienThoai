package GUI.Dialog;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import GUI.NhanVienGUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Timestamp;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Date;

public class NhanVienDialog extends javax.swing.JPanel {

    private JButton BtnAdd;
    private JButton BtnUpdate;
    private NhanVienDTO NVDTO;
    private NhanVienBUS NVBUS = new NhanVienBUS();
    private NhanVienGUI NVGUI = new NhanVienGUI();

    public NhanVienDialog(String type) {
        initComponents(type);
        eventBtn();
    }

    public NhanVienDialog(String type, NhanVienDTO NV) {
        initComponents(type);
        this.NVDTO = NV;
        eventBtn();
    }

    private void initComponents(String type) {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        PanelBottom = new javax.swing.JPanel();
        PanelCenter = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        MaNV_TF = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        TenNV_TF = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        GioiTinh_TF = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        SDT_TF = new javax.swing.JTextField();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        Email_Tf = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÍ NHÂN VIÊN");
        jPanel1.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        PanelBottom.setBackground(new java.awt.Color(255, 255, 255));
        PanelBottom.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel1.add(PanelBottom, java.awt.BorderLayout.PAGE_END);

        PanelCenter.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("MÃ NV");

        MaNV_TF.setPreferredSize(new java.awt.Dimension(64, 27));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên NV");

        TenNV_TF.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Giới tính");

        GioiTinh_TF.setMinimumSize(new java.awt.Dimension(64, 27));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Ngày sinh");

        jDateChooser1.setPreferredSize(new java.awt.Dimension(88, 27));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("SĐT");

        SDT_TF.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Email");

        Email_Tf.setPreferredSize(new java.awt.Dimension(64, 30));

        javax.swing.GroupLayout PanelCenterLayout = new javax.swing.GroupLayout(PanelCenter);
        PanelCenter.setLayout(PanelCenterLayout);
        PanelCenterLayout.setHorizontalGroup(
                PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelCenterLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelCenterLayout.createSequentialGroup()
                                                .addGroup(PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(PanelCenterLayout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(MaNV_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(152, 152, 152))
                                                        .addGroup(PanelCenterLayout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(TenNV_TF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(42, 42, 42)))
                                                .addGroup(PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(PanelCenterLayout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(GioiTinh_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(PanelCenterLayout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(PanelCenterLayout.createSequentialGroup()
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(SDT_TF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelCenterLayout.createSequentialGroup()
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(Email_Tf, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        PanelCenterLayout.setVerticalGroup(
                PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelCenterLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(MaNV_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(GioiTinh_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(TenNV_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(SDT_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Email_Tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(PanelCenter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BtnAdd = new JButton("THÊM");
        designBtn(BtnAdd);
        BtnUpdate = new JButton("UPDATE");
        designBtn(BtnUpdate);
        switch (type) {
            case "add":
                PanelBottom.add(BtnAdd);
                break;
            case "update":
                PanelBottom.add(BtnUpdate);
                break;
            default:
                throw new AssertionError();
        }

    }

    public void designBtn(JButton button) {
        button.setPreferredSize(new Dimension(100, 40));
        button.setBackground(new Color(0, 153, 153));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(new Color(255, 255, 255));
    }

    public void eventBtn() {
        BtnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int manv = Integer.parseInt(MaNV_TF.getText());
                String tenNV = TenNV_TF.getText();
                String sdt = SDT_TF.getText();
                String email = Email_Tf.getText();
                java.util.Date NgaySinh = jDateChooser1.getDate();
                System.out.println(NgaySinh);
                int GioiTinh = "nam".equals(GioiTinh_TF.getText().trim().toLowerCase()) ? 1 : 0;
                if (NVBUS.add(new NhanVienDTO(manv, tenNV, GioiTinh, NgaySinh, sdt, email)) == true) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    NVGUI.loadData(NVBUS.getAllNhanVien());
                }
            }

        });
    }
    private javax.swing.JTextField Email_Tf;
    private javax.swing.JTextField GioiTinh_TF;
    private javax.swing.JTextField MaNV_TF;
    private javax.swing.JPanel PanelBottom;
    private javax.swing.JPanel PanelCenter;
    private javax.swing.JTextField SDT_TF;
    private javax.swing.JTextField TenNV_TF;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JPanel jPanel1;

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
