/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author User
 */
public class ClientView extends JPanel{
    private JButton add;
    private JButton update;
    private JButton delete;
    private JButton detail;
    private JButton import_Excel;
    private JButton export_Excel;
    private JButton refresh;
    private JComboBox<String> option;
    private JTextField search;

     public ClientView() {
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
        refresh.setIcon(new ImageIcon(getClass().getResource("/img/refresh (2).png")));

        this.setLayout(new BorderLayout());
        this.add(jpanel, BorderLayout.NORTH);
    }

    public void table() {
        String[][] data = {
                { " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " "},
                { " ", " ", " ", " ", " "}
        };
        String[] column = {"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Ngày tham gia"};

        DefaultTableModel model = new DefaultTableModel(data, column);
        JTable table = new JTable(model);

        // Đặt font in đậm cho tiêu đề cột
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12));

        // Đặt chiều cao của hàng trong bảng
        table.setRowHeight(25);

        JScrollPane sp = new JScrollPane(table);

        this.add(sp, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ClientView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 725);
        ClientView clientView= new ClientView();
        frame.getContentPane().add(clientView);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
