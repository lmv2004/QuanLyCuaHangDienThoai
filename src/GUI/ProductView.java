package GUI;


import ADDBUS.EditSanPham;
import ADDBUS.addSanPhamm;
import BUS.SanPhamBUS;
import DTO.SanPhamDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ProductView extends JPanel {
    private JButton add;
    private JButton update;
    private JButton delete;
    private JButton detail;
    private JButton import_Excel;
    private JButton export_Excel;
    private JButton refresh;
     private JButton btnsearch;
    private JComboBox<String> option;
    private JTextField search;
       private JTable table; 

    public ProductView() {
        setPreferredSize(new java.awt.Dimension(1200, 724));
        init();
        table();
         updateTableData();
    }

       public void refreshTable() {
         updateTableData();
}
    public void init() {
        add = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");
        detail = new JButton("Detail");
//        import_Excel = new JButton("Import");
//        export_Excel = new JButton("Export");
        refresh = new JButton("Refresh");
        search = new JTextField();
        btnsearch = new JButton("");
        search.setText("Nhập nội dung tìm kiếm");
      Font comboBoxFont = new Font("Arial", Font.PLAIN, 12); // Ví dụ sử dụng font Arial với kích thước 12
        option = new JComboBox<>(new String[]{"Tất cả","Mã sản phẩm ","Tên sản phẩm"});
        option.setFont(comboBoxFont);

        JPanel jpanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 15, 25);
        jpanel.setLayout(flowLayout);
        jpanel.add(add);
        jpanel.add(update);
        jpanel.add(delete);
        jpanel.add(detail);
//        jpanel.add(import_Excel);
//        jpanel.add(export_Excel);
        jpanel.add(option);
        
        jpanel.add(search);
         jpanel.add(btnsearch);
        jpanel.add(refresh);
       

        add.setIcon(new ImageIcon(getClass().getResource("/img/Add.png")));
        update.setIcon(new ImageIcon(getClass().getResource("/img/edit.png")));
        delete.setIcon(new ImageIcon(getClass().getResource("/img/delete.png")));
        detail.setIcon(new ImageIcon(getClass().getResource("/img/detail.png")));
       // import_Excel.setIcon(new ImageIcon(getClass().getResource("/img/import_excel.png")));
       // export_Excel.setIcon(new ImageIcon(getClass().getResource("/img/export_excel.png")));
       // btnsearch.setIcon(new ImageIcon(getClass().getResource("/img/search-icon")));
        refresh.setIcon(new ImageIcon(getClass().getResource("/img/refresh.png")));

        this.setLayout(new BorderLayout());
        this.add(jpanel, BorderLayout.NORTH);
        
        
add.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame addSanPhamFrame = new addSanPhamm(); // Tạo một JFrame mới để thêm sản phẩm
        addSanPhamFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đặt hành động khi cửa sổ đóng
        addSanPhamFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable(); // Cập nhật bảng khi cửa sổ con đóng
            }
        });
        addSanPhamFrame.pack(); // Tự động điều chỉnh kích thước của cửa sổ để phù hợp với nội dung
        addSanPhamFrame.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        addSanPhamFrame.setVisible(true); // Hiển thị cửa sổ thêm sản phẩm
    }
});

    update.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(ProductView.this, "Vui lòng chọn mục sản phẩm cần cập nhật.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            // Lấy thông tin của hàng được chọn từ bảng
            int maSanPham = (int) table.getValueAt(selectedRow, 0); // Mã sản phẩm
            String tenSanPham = (String) table.getValueAt(selectedRow, 1); // Tên sản phẩm
            String hinhanh = (String) table.getValueAt(selectedRow, 2); // Hình ảnh
            int xuatXu =  (int) table.getValueAt(selectedRow, 3); // Xuất xứ
            String chipXuLy = (String) table.getValueAt(selectedRow, 4); // Chip xử lý
            int dungLuongPin = (int) table.getValueAt(selectedRow, 5); // Dung lượng pin
            Double kichThuocMan = (Double) table.getValueAt(selectedRow, 6); // Kích thước màn hình
            int heDieuHanh = (int) table.getValueAt(selectedRow, 7); // Hệ điều hành
            int phienBanHDH = (int) table.getValueAt(selectedRow, 8); // Phiên bản hệ điều hành
            String cameraSau = (String) table.getValueAt(selectedRow, 9); // Camera sau
            String cameraTruoc = (String) table.getValueAt(selectedRow, 10); // Camera trước
            int thoiGianBaoHanh =(int) table.getValueAt(selectedRow, 11); // Thời gian bảo hành
            int thuongHieu = (int) table.getValueAt(selectedRow, 12); // Thương hiệu
            int khuVucKho = (int)  table.getValueAt(selectedRow, 13); // Khu vực kho
            int soLuongTon = (int) table.getValueAt(selectedRow, 14); // Số lượng tồn
            
            // Tạo đối tượng SanPhamDTO từ dữ liệu hàng được chọn
            SanPhamDTO sanPham = new SanPhamDTO();
            sanPham.setMasp(maSanPham);
            sanPham.setTensp(tenSanPham);
            sanPham.setHinhanh(hinhanh);
            sanPham.setXuatxu(xuatXu);
            sanPham.setChipxuly(chipXuLy);
            sanPham.setDungluongpin(dungLuongPin);
            sanPham.setKichthuocman(kichThuocMan);
            sanPham.setHedieuhanh(heDieuHanh);
            sanPham.setPhienbanhdh(phienBanHDH);
            sanPham.setCamerasau(cameraSau);
            sanPham.setCameratruoc(cameraTruoc);
            sanPham.setThoigianbaohanh(thoiGianBaoHanh);
            sanPham.setThuonghieu(thuongHieu);
            sanPham.setKhuvuckho(khuVucKho);
            sanPham.setSoluongton(soLuongTon);
            
            // Tạo cửa sổ chỉnh sửa thông tin sản phẩm và truyền đối tượng SanPhamDTO vào
            JFrame editSanPhamFrame = new EditSanPham(sanPham);
            
            editSanPhamFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            editSanPhamFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshTable(); // Cập nhật bảng khi cửa sổ con đóng
                }
            });
            editSanPhamFrame.pack();
            editSanPhamFrame.setLocationRelativeTo(null);
            editSanPhamFrame.setVisible(true);
        }
    }
});


        
        
        
        
  detail.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(ProductView.this, "Vui lòng chọn mục sản phẩm cần xem chi tiết.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            // Lấy thông tin chi tiết của sản phẩm từ BUS
            SanPhamDTO sanPhamDetail = SanPhamBUS.getInstance().getByIndex(selectedRow);

            // Hiển thị thông tin chi tiết trong một cửa sổ
            String detailMessage = "Thông tin chi tiết sản phẩm:\n" +
                    "Mã sản phẩm: " + sanPhamDetail.getMasp() + "\n" +
                    "Tên sản phẩm: " + sanPhamDetail.getTensp() + "\n" +
                    "Xuất xứ: " + sanPhamDetail.getXuatxu() + "\n" +
                    "Chip xử lý: " + sanPhamDetail.getChipxuly() + "\n" +
                    "Dung lượng pin: " + sanPhamDetail.getDungluongpin() + "\n" +
                    "Kích thước màn hình: " + sanPhamDetail.getKichthuocman() + "\n" +
                    "Hệ điều hành: " + sanPhamDetail.getHedieuhanh() + "\n" +
                    "Phiên bản hệ điều hành: " + sanPhamDetail.getPhienbanhdh() + "\n" +
                    "Camera sau: " + sanPhamDetail.getCamerasau() + "\n" +
                    "Camera trước: " + sanPhamDetail.getCameratruoc() + "\n" +
                    "Thời gian bảo hành: " + sanPhamDetail.getThoigianbaohanh() + "\n" +
                    "Thương hiệu: " + sanPhamDetail.getThuonghieu() + "\n" +
                    "Khu vực kho: " + sanPhamDetail.getKhuvuckho() + "\n" +
                    "Số lượng tồn: " + sanPhamDetail.getSoluongton();
            JOptionPane.showMessageDialog(ProductView.this, detailMessage, "Thông tin chi tiết sản phẩm", JOptionPane.INFORMATION_MESSAGE);
        }
    }
});

     
  
   delete.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(ProductView.this, "Vui lòng chọn mục sản phẩm cần xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            // Lấy dữ liệu từ dòng được chọn
            int maSanPham = (int) table.getValueAt(selectedRow, 0); // Giả sử cột đầu tiên là mã sản phẩm

            // Tạo đối tượng DTO từ mã sản phẩm
            SanPhamDTO sanPhamToDelete = new SanPhamDTO();
            sanPhamToDelete.setMasp(maSanPham);

            // Thực hiện xóa từ đối tượng DTO
            boolean success = SanPhamBUS.getInstance().delete(sanPhamToDelete);
            if (success) {
                // Xóa dòng từ bảng
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(ProductView.this, "Đã xóa sản phẩm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                
                // Cập nhật lại dữ liệu trong bảng
                //updateTableData();
            } else {
                JOptionPane.showMessageDialog(ProductView.this, "Xóa sản phẩm không thành công.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
});


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
    btnsearch.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String searchText = search.getText().trim(); // Lấy nội dung từ ô tìm kiếm

        if (searchText.isEmpty()) {
            // Nếu ô tìm kiếm trống, cập nhật bảng với dữ liệu rỗng
            updateTableData(new ArrayList<>());
        } else {
            // Thực hiện tìm kiếm dữ liệu trong danh sách sản phẩm
            ArrayList<SanPhamDTO> searchResult = SanPhamBUS.getInstance().search("Tất cả", searchText);

            // Cập nhật dữ liệu trên bảng với kết quả tìm kiếm
            updateTableData(searchResult);
        }
    }
});
          refresh.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        updateTableData(); // Cập nhật lại dữ liệu từ BUS
    }
});

    }
    private void updateTableData(ArrayList<SanPhamDTO> products) {
    // Lấy model của bảng để thêm dữ liệu vào
    DefaultTableModel model = (DefaultTableModel) table.getModel();

    // Xóa toàn bộ dữ liệu cũ trong bảng
    model.setRowCount(0);

    // Kiểm tra nếu danh sách sản phẩm không rỗng
    if (!products.isEmpty()) {
        // Duyệt qua từng sản phẩm và thêm vào bảng
        for (SanPhamDTO product : products) {
            Object[] rowData = {
                product.getMasp(),
                product.getTensp(),
                product.getHinhanh(),
                product.getXuatxu(),
                product.getChipxuly(),
                product.getDungluongpin(),
                product.getKichthuocman(),
                product.getHedieuhanh(),
                product.getPhienbanhdh(),
                product.getCamerasau(),
                product.getCameratruoc(),
                product.getThoigianbaohanh(),
                product.getThuonghieu(),
                product.getKhuvuckho(),
                product.getSoluongton(),
            };
            // Thêm dữ liệu vào bảng
            model.addRow(rowData);
        }
    } 
}


public void table() {
    String[][] data = {
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "," "," "," "," "} // Thêm một cột để phản ánh các thuộc tính mới
    };
    String[] column = {"Mã sản phẩm",
        "Tên sản phẩm", "Hình ảnh",
        "Xuất xứ", "Chip xử lý", 
         "Dung lượng pin",
        "Kích cỡ màn hình", 
         "Hệ điều hành", 
        "Phiên bản hệ điều hành", 
         "Camera sau", "Camera trước", 
         "Thời gian bảo hành", "Thương hiệu",
        "Khu vực kho", "Số lượng tồn"};
        
       
       
        
      

    DefaultTableModel model = new DefaultTableModel(data, column);
    table = new JTable(model);

    // Đặt font in đậm cho tiêu đề cột
    JTableHeader header = table.getTableHeader();
    header.setFont(new Font("Arial", Font.BOLD, 9)); // Chỉnh kích thước font thành 10

    // Đặt chiều cao của hàng trong bảng
    table.setRowHeight(25);

    JScrollPane sp = new JScrollPane(table);

    this.add(sp, BorderLayout.CENTER);
}

private void updateTableData() {
    // Lấy danh sách sản phẩm từ BUS
    ArrayList<SanPhamDTO> products = SanPhamBUS.getInstance().getAll();

    // Lấy model của bảng để thêm dữ liệu vào
    DefaultTableModel model = (DefaultTableModel) table.getModel();

    // Xóa toàn bộ dữ liệu cũ trong bảng
    model.setRowCount(0);

    // Kiểm tra nếu danh sách sản phẩm không rỗng
    if (!products.isEmpty()) {
        // Duyệt qua từng sản phẩm và thêm vào bảng
        for (SanPhamDTO product : products) {
            Object[] rowData = {
                product.getMasp(),
                product.getTensp(),
                product.getHinhanh(),
                product.getXuatxu(),
                product.getChipxuly(),
                product.getDungluongpin(),
                product.getKichthuocman(),
                product.getHedieuhanh(),
                product.getPhienbanhdh(),
                product.getCamerasau(),
                product.getCameratruoc(),
                product.getThoigianbaohanh(),
                product.getThuonghieu(),
                product.getKhuvuckho(),
                product.getSoluongton(),
            };
            // Thêm dữ liệu vào bảng
            model.addRow(rowData);
        }
    } else {
        // Hiển thị thông báo nếu không có sản phẩm nào
        JOptionPane.showMessageDialog(this, "Không có sản phẩm nào để hiển thị.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    
   
}


//      public static void main(String[] args) {
//        JFrame frame = new JFrame("Product Management System");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new ProductView());
//        frame.pack();
//        frame.setLocationRelativeTo(null); // Đặt vị trí của cửa sổ ở giữa màn hình
//        frame.setVisible(true);
//    }

}
