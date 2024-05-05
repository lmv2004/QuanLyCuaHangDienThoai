/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import ADDBUS.EditNhacungcap;
import ADDBUS.addNCC;
import BUS.NhaCungCapBUS;
import DTO.NhaCungCapDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    private JButton btnsearch;
    private JTextField search;
    private JTable table;

    public SupplierView() {
        setPreferredSize(new java.awt.Dimension(1200, 724));
        init();
        table();
        updateTableData(); // Gọi phương thức cập nhật dữ liệu sau khi tạo bảng
    }
        public void refreshTable() {
        updateTableData();
}

   
    public void init() {
        add = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");
        detail = new JButton("Detail");

        refresh = new JButton("Refresh");
        search = new JTextField();
        search.setText("Nhập nội dung tìm kiếm");
        Font comboBoxFont = new Font("Arial", Font.PLAIN, 12); // Ví dụ sử dụng font Arial với kích thước 12


         option = new JComboBox<>(new String[]{"Tất cả","Mã nhà cung cấp","Tên nhà cung cấp"});
         option.setFont(comboBoxFont); 
        btnsearch = new JButton("");

        JPanel jpanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 15, 25);
        jpanel.setLayout(flowLayout);
        jpanel.add(add);
        jpanel.add(update);
        jpanel.add(delete);
        jpanel.add(detail);
        jpanel.add(option);
        jpanel.add(search);
         jpanel.add(btnsearch);
        jpanel.add(refresh);
        

        add.setIcon(new ImageIcon(getClass().getResource("/img/Add.png")));
        update.setIcon(new ImageIcon(getClass().getResource("/img/edit.png")));
        delete.setIcon(new ImageIcon(getClass().getResource("/img/delete.png")));
        detail.setIcon(new ImageIcon(getClass().getResource("/img/detail.png")));
        refresh.setIcon(new ImageIcon(getClass().getResource("/img/refresh.png")));
        //btnsearch.setIcon(new ImageIcon(getClass().getResource("/img/search-icon")));
        this.setLayout(new BorderLayout());
        this.add(jpanel, BorderLayout.NORTH);
        
        
         search.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        // Xóa nội dung của ô tìm kiếm khi người dùng bắt đầu nhập liệu
        search.setText("");
        search.setPreferredSize(new Dimension(128, 20)); 
    }

    @Override
    public void focusLost(FocusEvent e) {
        // Không cần xử lý sự kiện này
    }
});
        
        add.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame addNCCFrame = new addNCC();
        addNCCFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addNCCFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable(); // Cập nhật bảng khi cửa sổ con đóng
            }
        });
        addNCCFrame.pack();
        addNCCFrame.setLocationRelativeTo(null);
        addNCCFrame.setVisible(true);
    }
});

        delete.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(SupplierView.this, "Vui lòng chọn mục nhà cung cấp cần xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            // Lấy dữ liệu từ dòng được chọn
            int maNCC = (int) table.getValueAt(selectedRow, 0); // Giả sử cột đầu tiên là mã nhà cung cấp

            // Tạo đối tượng DTO từ mã nhà cung cấp
            NhaCungCapDTO nhaCungCapToDelete = new NhaCungCapDTO();
            nhaCungCapToDelete.setMaNCC(maNCC);

            // Thực hiện xóa từ đối tượng DTO
            boolean success = NhaCungCapBUS.getInstance().delete(nhaCungCapToDelete);
            if (success) {
                // Xóa dòng từ bảng
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(SupplierView.this, "Đã xóa nhà cung cấp thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(SupplierView.this, "Xóa nhà cung cấp không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
});
         detail.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(SupplierView.this, "Vui lòng chọn mục nhà cung cấp cần xem chi tiết.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            // Lấy dữ liệu từ dòng được chọn
            int maNCC = (int) table.getValueAt(selectedRow, 0); // Giả sử cột đầu tiên là mã nhà cung cấp

            // Lấy thông tin chi tiết của nhà cung cấp từ BUS
            NhaCungCapDTO nhaCungCapDetail = NhaCungCapBUS.getInstance().getByIndex(selectedRow);

            // Hiển thị chi tiết trong một cửa sổ hoặc hộp thoại
            String detailMessage = "Thông tin chi tiết nhà cung cấp:\n" +
                    "Mã nhà cung cấp: " + nhaCungCapDetail.getMaNCC() + "\n" +
                    "Tên nhà cung cấp: " + nhaCungCapDetail.getTenNCC() + "\n" +
                    "Địa chỉ: " + nhaCungCapDetail.getDiaChi() + "\n" +
                    "Email: " + nhaCungCapDetail.getEmail() + "\n" +
                    "Số điện thoại: " + nhaCungCapDetail.getSDT();
            JOptionPane.showMessageDialog(SupplierView.this, detailMessage, "Chi tiết nhà cung cấp", JOptionPane.INFORMATION_MESSAGE);
        }
    }
});
     
          update.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(SupplierView.this, "Vui lòng chọn mục nhà cung cấp cần cập nhật.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        else {
            // Lấy thông tin của hàng được chọn từ bảng
            int maNCC = (int) table.getValueAt(selectedRow, 0); // Mã nhà cung cấp
            String tenNCC = (String) table.getValueAt(selectedRow, 1); // Tên nhà cung cấp
            String diaChi = (String) table.getValueAt(selectedRow, 2); // Địa chỉ
            String email = (String) table.getValueAt(selectedRow, 3); // Email
            String sdt = (String) table.getValueAt(selectedRow, 4); // Số điện thoại
          
            
            // Tạo đối tượng NhaCungCapDTO từ dữ liệu hàng được chọn
            NhaCungCapDTO nhaCungCap = new NhaCungCapDTO(maNCC, tenNCC, diaChi, email, sdt,1);
            
            // Tạo cửa sổ chỉnh sửa thông tin nhà cung cấp và truyền đối tượng NhaCungCapDTO vào
            JFrame editNCCFrame = new EditNhacungcap(nhaCungCap);
            
            editNCCFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            editNCCFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshTable(); // Cập nhật bảng khi cửa sổ con đóng
                }
            });
            editNCCFrame.pack();
            editNCCFrame.setLocationRelativeTo(null);
            editNCCFrame.setVisible(true);
        }
    }
});

      refresh.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        updateTableData(); // Cập nhật lại dữ liệu từ BUS
    }
});
      btnsearch.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String searchText = search.getText().trim(); // Lấy nội dung từ ô tìm kiếm
        
         if (searchText.isEmpty()) {
            // Nếu rỗng, cập nhật bảng với dữ liệu rỗng
            updateTableData(new ArrayList<>());
            
         } 
         else {
             // Thực hiện tìm kiếm dữ liệu trong danh sách nhà cung cấp
        ArrayList<NhaCungCapDTO> searchResult = NhaCungCapBUS.getInstance().search("Tất cả", searchText);

        // Cập nhật dữ liệu trên bảng với kết quả tìm kiếm
        updateTableData(searchResult);
         }
        
    }
});



      
    }
    private void updateTableData(ArrayList<NhaCungCapDTO> dataList) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Xóa dữ liệu cũ

    for (NhaCungCapDTO nhaCungCap : dataList) {
        Object[] rowData = {
            nhaCungCap.getMaNCC(),
            nhaCungCap.getTenNCC(),
            nhaCungCap.getDiaChi(),
            nhaCungCap.getEmail(),
            nhaCungCap.getSDT()
        };
        model.addRow(rowData); // Thêm dòng mới vào bảng với dữ liệu từ kết quả tìm kiếm
    }
}

    public void table() {
        // Khởi tạo mảng dữ liệu mẫu và các tiêu đề cột
        String[][] data = {
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}
        };
        String[] column = {"Mã NCC", "Tên nhà cung cấp", "Địa chỉ", "Email", "Số điện thoại"};

        // Tạo DefaultTableModel với dữ liệu mẫu
        DefaultTableModel model = new DefaultTableModel(data, column);
        table = new JTable(model);

        // Đặt font cho tiêu đề cột (không in đậm)
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 10));

        // Đặt chiều cao của hàng trong bảng
        table.setRowHeight(25);

        // Tạo JScrollPane để bảng có thể cuộn khi dữ liệu quá nhiều
        JScrollPane sp = new JScrollPane(table);

        // Thêm JScrollPane chứa bảng vào panel
        this.add(sp, BorderLayout.CENTER);
    }

    private void updateTableData() {
        // Lấy danh sách nhà cung cấp từ BUS
        ArrayList<NhaCungCapDTO> suppliers = NhaCungCapBUS.getInstance().getAllNhaCungCap();

        // Lấy model của bảng để thêm dữ liệu vào
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Xóa toàn bộ dữ liệu cũ trong bảng
        model.setRowCount(0);

        // Duyệt qua từng nhà cung cấp và thêm vào bảng
        for (NhaCungCapDTO supplier : suppliers) {
            Object[] rowData = {
                supplier.getMaNCC(),
                supplier.getTenNCC(),
                supplier.getDiaChi(),
                supplier.getEmail(),
                supplier.getSDT()
            };
            model.addRow(rowData);
        }
    }

//   public static void main(String[] args) {
//       javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//               JFrame frame = new JFrame("Supplier Management System");
//               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//               frame.getContentPane().add(new SupplierView());
//               frame.pack();
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
//           }
//       });
//    }
}

