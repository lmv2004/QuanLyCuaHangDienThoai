/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.Font;

public class SupplierView extends JPanel {
    private JButton add;
    private JButton update;
    private JButton delete;
    private JButton detail;
    private JButton import_Excel;
    private JButton export_Excel;
    private JButton refresh;
    private JComboBox<String> option;
    private JTextField search;

    public SupplierView() {
        setPreferredSize(new java.awt.Dimension(1200, 724));
        init();
        table();
    }

    public void init() {
        add = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");
        detail = new JButton("Detail");
        import_Excel = new JButton("Import");
        export_Excel = new JButton("Export");
        refresh = new JButton("Refresh");
        search = new JTextField();
        search.setText("Nhập nội dung tìm kiếm");
        option = new JComboBox<>(new String[]{"Tất cả"});

        JPanel jpanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 15, 25);
        jpanel.setLayout(flowLayout);
        jpanel.add(add);
        jpanel.add(update);
        jpanel.add(delete);
        jpanel.add(detail);
        jpanel.add(import_Excel);
        jpanel.add(export_Excel);
        jpanel.add(option);
        jpanel.add(search);
        jpanel.add(refresh);

        add.setIcon(new ImageIcon(getClass().getResource("/img/Add.png")));
        update.setIcon(new ImageIcon(getClass().getResource("/img/edit.png")));
        delete.setIcon(new ImageIcon(getClass().getResource("/img/delete.png")));
        detail.setIcon(new ImageIcon(getClass().getResource("/img/detail.png")));
        import_Excel.setIcon(new ImageIcon(getClass().getResource("/img/import_excel.png")));
        export_Excel.setIcon(new ImageIcon(getClass().getResource("/img/export_excel.png")));
        refresh.setIcon(new ImageIcon(getClass().getResource("/img/refresh.png")));

        this.setLayout(new BorderLayout());
        this.add(new toolBar(), BorderLayout.NORTH);
        this.add(jpanel, BorderLayout.CENTER);
    }

    public void table() {
        String[][] data = {
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}
        };
        String[] column = {"Mã NCC", "Tên nhà cung cấp", "Địa chỉ", "Email", "Số điện thoại"};

        DefaultTableModel model = new DefaultTableModel(data, column);
        JTable table = new JTable(model);

        // Đặt font cho tiêu đề cột (không in đậm)
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.PLAIN, 12));

        // Đặt chiều cao của hàng trong bảng
        table.setRowHeight(25);

        JScrollPane sp = new JScrollPane(table);

        this.add(sp, BorderLayout.CENTER);
    }

  
}
