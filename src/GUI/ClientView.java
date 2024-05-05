package GUI;

import ADDBUS.addKH;
import ADDBUS.EditKh;
import BUS.KhachHangBUS;
import DTO.KhachHangDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
 

public class ClientView extends JPanel {

    private JButton add;
    private JButton update;
    private JButton delete;
    private JButton detail;
    private JButton importExcel;
    private JButton exportExcel;
    private JButton refresh;
    private JComboBox<String> option;
    private JButton btnsearch;
    private JTextField search;
    private JTable table;

    public ClientView() {

        setPreferredSize(new Dimension(1200, 724));
        init();
        createTable();
        updateTableData(); // Gọi hàm update dữ liệu từ constructor
    }

    public void refreshTable() {
        updateTableData();
    }

    private void init() {
        add = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");
        detail = new JButton("Detail");
    
        refresh = new JButton("Refresh");
        search = new JTextField("Nhập nội dung tìm kiếm");
        Font comboBoxFont = new Font("Arial", Font.PLAIN, 12); // Ví dụ sử dụng font Arial với kích thước 12
        option = new JComboBox<>(new String[]{"Tất cả", "Mã khách hàng", "Tên khách hàng"});
        option.setFont(comboBoxFont);
        btnsearch = new JButton("");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 25));
        buttonPanel.add(add);
        buttonPanel.add(update);
        buttonPanel.add(delete);
        buttonPanel.add(detail);
       
        buttonPanel.add(option);
        buttonPanel.add(search);
        buttonPanel.add(btnsearch);
        buttonPanel.add(refresh);

        add.setIcon(new ImageIcon(getClass().getResource("/img/Add.png")));
        update.setIcon(new ImageIcon(getClass().getResource("/img/edit.png")));
        delete.setIcon(new ImageIcon(getClass().getResource("/img/delete.png")));
        detail.setIcon(new ImageIcon(getClass().getResource("/img/detail.png")));
        
        //btnsearch.setIcon(new ImageIcon(getClass().getResource("/img/search-icon")));
        refresh.setIcon(new ImageIcon(getClass().getResource("/img/refresh.png")));
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        //this.add(new toolBar(), BorderLayout.NORTH);
       // this.add(buttonPanel, BorderLayout.CENTER);

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

        // Trong phương thức actionPerformed của nút Add
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addKH addKhachHangFrame = new addKH();
                addKhachHangFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addKhachHangFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        refreshTable(); // Cập nhật bảng khi cửa sổ con đóng
                    }
                });
                addKhachHangFrame.pack();
                addKhachHangFrame.setLocationRelativeTo(null);
                addKhachHangFrame.setVisible(true);
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(ClientView.this, "Vui lòng chọn mục khách hàng cần cập nhật.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Lấy thông tin của hàng được chọn từ bảng
                    int maKhachHang = (int) table.getValueAt(selectedRow, 0); // Mã khách hàng
                    String tenKhachHang = (String) table.getValueAt(selectedRow, 1); // Tên khách hàng
                    String diaChi = (String) table.getValueAt(selectedRow, 2); // Địa chỉ
                    String sdt = (String) table.getValueAt(selectedRow, 3); // Số điện thoại
                    Date ngayThamGia = (Date) table.getValueAt(selectedRow, 4); // Ngày tham gia

                    // Tạo đối tượng KhachHangDTO từ dữ liệu hàng được chọn
                    KhachHangDTO khachHang = new KhachHangDTO(maKhachHang, tenKhachHang, diaChi, sdt, 1, ngayThamGia);

                    // Tạo cửa sổ chỉnh sửa thông tin khách hàng và truyền đối tượng KhachHangDTO vào
                    JFrame editkhachhang = new EditKh(khachHang);

                    editkhachhang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    editkhachhang.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            refreshTable(); // Cập nhật bảng khi cửa sổ con đóng
                        }
                    });
                    editkhachhang.pack();
                    editkhachhang.setLocationRelativeTo(null);
                    editkhachhang.setVisible(true);
                }
            }
        });
// Dòng này là dấu đóng ngoặc cuối cho addActionListener

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(ClientView.this, "Vui lòng chọn mục khách hàng cần xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Lấy dữ liệu từ dòng được chọn
                    int maKhachHang = (int) table.getValueAt(selectedRow, 0); // Giả sử cột đầu tiên là mã khách hàng

                    // Tạo đối tượng DTO từ mã khách hàng
                    KhachHangDTO khachHangToDelete = new KhachHangDTO();
                    khachHangToDelete.setMaKhachHang(maKhachHang);

                    // Thực hiện xóa từ đối tượng DTO
                    boolean success = KhachHangBUS.getInstance().delete(khachHangToDelete);
                    if (success) {
                        // Xóa dòng từ bảng
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(ClientView.this, "Đã xóa khách hàng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(ClientView.this, "Xóa khách hàng không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTableData(); // Cập nhật lại dữ liệu từ BUS
            }
        });
        detail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(ClientView.this, "Vui lòng chọn mục khách hàng cần xem chi tiết.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Lấy dữ liệu từ dòng được chọn
                    int maKhachHang = (int) table.getValueAt(selectedRow, 0); // Giả sử cột đầu tiên là mã khách hàng

                    // Lấy thông tin chi tiết của khách hàng từ BUS
                    KhachHangDTO khachHangDetail = KhachHangBUS.getInstance().getByIndex(selectedRow);

                    // Hiển thị chi tiết trong một cửa sổ hoặc hộp thoại
                    String detailMessage = "Thông tin chi tiết khách hàng:\n"
                            + "Mã khách hàng: " + khachHangDetail.getMaKhachHang() + "\n"
                            + "Tên khách hàng: " + khachHangDetail.getTenKhachHang() + "\n"
                            + "Địa chỉ: " + khachHangDetail.getDiaChi() + "\n"
                            + "Số điện thoại: " + khachHangDetail.getSDT() + "\n"
                            + "Ngày tham gia: " + khachHangDetail.getNgayThamGia();
                    JOptionPane.showMessageDialog(ClientView.this, detailMessage, "Chi tiết khách hàng", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = search.getText().trim(); // Lấy nội dung từ ô tìm kiếm

                if (searchText.isEmpty()) {
                    // Nếu rỗng, cập nhật bảng với dữ liệu rỗng
                    updateTableData(new ArrayList<>());

                } else {
                    // Thực hiện tìm kiếm dữ liệu trong danh sách khách hàng
                    ArrayList<KhachHangDTO> searchResult = KhachHangBUS.getInstance().search("Tất cả", searchText);

                    // Cập nhật dữ liệu trên bảng với kết quả tìm kiếm
                    updateTableData(searchResult);
                }

            }
        });

    }

    private void updateTableData(ArrayList<KhachHangDTO> dataList) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        for (KhachHangDTO khachHang : dataList) {
            Object[] rowData = {
                khachHang.getMaKhachHang(),
                khachHang.getTenKhachHang(),
                khachHang.getDiaChi(),
                khachHang.getSDT(),
                khachHang.getNgayThamGia()
            };
            model.addRow(rowData); // Thêm dòng mới vào bảng với dữ liệu từ kết quả tìm kiếm
        }
    }

    private void createTable() {
        String[] columnNames = {"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Ngày tham gia"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12));

        table.setRowHeight(25);

        JScrollPane sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);
    }

    private void updateTableData() {
        ArrayList<KhachHangDTO> khachHangList = KhachHangBUS.getInstance().getAllKhachHang();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (KhachHangDTO khachHang : khachHangList) {
            Object[] rowData = {
                khachHang.getMaKhachHang(),
                khachHang.getTenKhachHang(),
                khachHang.getDiaChi(),
                khachHang.getSDT(),
                khachHang.getNgayThamGia()
            };
            model.addRow(rowData);
        }
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                JFrame frame = new JFrame("Client Management System");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.getContentPane().add(new ClientView());
//                frame.pack();
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
//            }
//        });
//    }
}
