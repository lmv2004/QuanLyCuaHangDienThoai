/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.KhuVucKhoBUS;
import DTO.KhuVucKhoDTO;
import GUI.Dialog.KhuVucKhoDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class area extends javax.swing.JPanel {

    /**
     * Creates new form area
     */
    public KhuVucKhoBUS kvkBUS = new KhuVucKhoBUS();
    public ArrayList<KhuVucKhoDTO> list = kvkBUS.getAll();
    JFrame owner = (JFrame) SwingUtilities.getWindowAncestor(this);
    public KhuVucKhoDTO kvkDTO ;
    /**
     * Creates new form area
     */
    @SuppressWarnings("empty-statement")
    public area() {
        
        initComponents();
        toolBar1.getCbbFilter().removeAllItems();
        toolBar1.getCbbFilter().setModel(new DefaultComboBoxModel(new String [] {
            "Tất cả","Mã khu vực kho","Tên khu vực kho"
        }));
             
        toolBar1.getFindBtn().addActionListener(new java.awt.event.ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
               if(toolBar1.getTfSearch().getText() != ""){
                   String type =  (String) toolBar1.getCbbFilter().getSelectedItem();
   
                   list =  kvkBUS.search(type,toolBar1.getTfSearch().getText());
                   loadData(list);
               }
            }
        });
        
        
        
        toolBar1.getAddBtn().addActionListener(new java.awt.event.ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                KhuVucKhoDialog kvkDialog = new KhuVucKhoDialog(area.this,owner,true, "Thêm khu vực kho" ,"add");

            }
        
        });
        
        // xử lí update
        
        toolBar1.getEditBtn().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getIndexRow() != -1){
               KhuVucKhoDialog kvkDialog = new KhuVucKhoDialog(area.this , owner , true, "Chỉnh sửa khu vực" , "update",list.get(getIndexRow()));
                } else {
                    JOptionPane.showMessageDialog(area.this, "Vui lòng chọn khu vực kho trong bảng");
                }
            }
        });   
        
        
        // xử lí chi tiết
        toolBar1.getDetailBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(getIndexRow() != -1){
               KhuVucKhoDialog kvkDialog = new KhuVucKhoDialog(area.this , owner , true, "Chi tiết khu vực" , "detail",list.get(getIndexRow()));
                } else {
                    JOptionPane.showMessageDialog(area.this, "Vui lòng chọn khu vực kho trong bảng");
                }
            }
        });
        
        // xử lí xóa
        
        toolBar1.getRemoveBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getIndexRow() != -1) {
                    int index = getIndexRow();
                    int input = JOptionPane.showConfirmDialog(null,
                            "Bạn có chắc chắn muốn xóa khu vực!", "Xóa khu vực kho",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (input == 0) {
                        kvkBUS.delete(list.get(index), index);
                        loadData(list);
                    } else {
                        JOptionPane.showMessageDialog(area.this, "Không thể xóa kho vì vẫn còn sản phẩm trong kho.");
                    }
                } else {
                    JOptionPane.showMessageDialog(area.this, "Vui lòng chọn khu vực bạn muốn xóa");
                }
            }


        });
        
        loadData(list);
    }
    
    
    
     public void loadData(ArrayList<KhuVucKhoDTO> list){
         
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }
        // tblModel.setRowCount(0);
        for(KhuVucKhoDTO result : list){
            tblModel.addRow(new Object [] {result.getMaKhuVuc(), result.getTenKhuVuc(), result.getGhiChu()});
        }    
        jTable1.setModel(tblModel);
        jTable1.repaint();
        jTable1.validate();
    }
     
     public int getIndexRow(){
         int i = jTable1.getSelectedRow();
//         if(i == -1){
//             JOptionPane.showMessageDialog( this, "vui lòng chọn khu vực kho trong bảng");
//         }
//         
           System.out.println(i);
         return i;
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
        toolBar1 = new GUI.toolBar();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1200, 725));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 99));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 100));
        jPanel1.add(toolBar1);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(300, 16));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setMinimumSize(new java.awt.Dimension(200, 80));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setMinimumSize(new java.awt.Dimension(200, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Danh sách sản phẩm có trong khu vực");
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel2.add(jLabel1);

        jPanel5.setPreferredSize(new java.awt.Dimension(300, 100));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 200, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(300, 100));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private GUI.toolBar toolBar1;
    // End of variables declaration//GEN-END:variables
}
