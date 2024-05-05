package BUS;

import DTO.NhaCungCapDTO;
import DAO.NhaCungCapDAO;
import java.util.ArrayList;

public class NhaCungCapBUS {
    
    private ArrayList<NhaCungCapDTO> DanhSachNCC = new ArrayList<>();
    private final NhaCungCapDAO NCCDAO = new NhaCungCapDAO();
    
    public static NhaCungCapBUS getInstance() {
        return new NhaCungCapBUS();
    }
    
    public NhaCungCapBUS () {
        DanhSachNCC = NCCDAO.selecAll();
    }
    
    public ArrayList<NhaCungCapDTO> getAllNhaCungCap() {
        return DanhSachNCC;
    }
    
    public NhaCungCapDTO getByIndex(int index) {
        return this.DanhSachNCC.get(index);
    }
    
    
    public String getNameByID(int ID) {
        for(NhaCungCapDTO x : DanhSachNCC) {
            if(x.getMaNCC()==ID) {
                return x.getTenNCC();
            }
        }
        return null;
    }
    
    public int getByID(int maNCC) {
        int vitri = -1;
        for (int i = 0; i < DanhSachNCC.size(); i++) {
            if (DanhSachNCC.get(i).getMaNCC() == maNCC) {
                vitri = i;
                break;
            }
        }
        return vitri;
    }
    
    public boolean add(NhaCungCapDTO nhacungcap) {
        if (NCCDAO.insert(nhacungcap) != 0) {
            DanhSachNCC.add(nhacungcap);
            return true;
        }
        return false;
    }
    
    public boolean delete(NhaCungCapDTO nhacungcap) {
        if (NCCDAO.delete(nhacungcap) != 0) {
            DanhSachNCC.remove(nhacungcap);
            return true;
        }
        return false;
    }
    
    public boolean edit(NhaCungCapDTO nhaCungCap) {
        // Gọi hàm update từ DAO để cập nhật dữ liệu trong CSDL
        if (NCCDAO.update(nhaCungCap) != 0) {
            // Cập nhật lại danh sách nhà cung cấp trong bộ nhớ
            for (int i = 0; i < DanhSachNCC.size(); i++) {
                if (DanhSachNCC.get(i).getMaNCC() == nhaCungCap.getMaNCC()) {
                    DanhSachNCC.set(i, nhaCungCap);
                    return true; // Trả về true chỉ khi danh sách được cập nhật thành công
                }
            }
        }
        return false; // Trả về false nếu cập nhật không thành công
    }
    
  public ArrayList<NhaCungCapDTO> search(String type, String txt) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        txt = txt.toLowerCase();
        switch (type) {
            case "Tất cả":
                for (NhaCungCapDTO i : DanhSachNCC) {
                    if (Integer.toString(i.getMaNCC()).contains(txt) || i.getTenNCC().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
                break;

            case "Mã khách hàng":
                for (NhaCungCapDTO i : DanhSachNCC) {
                    if (Integer.toString(i.getMaNCC()).contains(txt)) {
                        result.add(i);
                    }
                }
                break;
            case "Tên khách hàng":
                for (NhaCungCapDTO i : DanhSachNCC) {
                    if (i.getTenNCC().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
        return result;
    }
    // Code main để kiểm tra phương thức edit được bỏ đi
//       public static void main(String[] args) {
//    // Lấy một đối tượng NhaCungCapBUS
//    NhaCungCapBUS nccBUS = NhaCungCapBUS.getInstance();
//
//    // Lấy mã số của nhà cung cấp cần chỉnh sửa thông tin
//    int maNCC = 686; // Ví dụ: chỉnh sửa nhà cung cấp có mã số 686
//
//    // Lấy chỉ số của nhà cung cấp trong danh sách dựa trên mã số
//    int index = nccBUS.getByID(maNCC);
//
//    // Kiểm tra nếu chỉ số hợp lệ
//    if (index != -1) {
//        // Lấy đối tượng nhà cung cấp cần chỉnh sửa thông tin
//        NhaCungCapDTO nccToEdit = nccBUS.getByIndex(index);
//
//        // Chỉnh sửa thông tin nhà cung cấp
//        nccToEdit.setTenNCC("Công ty ABC"); // Đổi tên nhà cung cấp thành "Công ty ABC"
//        nccToEdit.setDiaChi("123 Đường XYZ"); // Đổi địa chỉ nhà cung cấp thành "123 Đường XYZ"
//
//        // Thực hiện chỉnh sửa thông tin nhà cung cấp
//        boolean editResult = nccBUS.edit(nccToEdit);
//
//        // Hiển thị kết quả chỉnh sửa
//        if (editResult) {
//            System.out.println("Dữ liệu đã được cập nhật thành công!");
//        } else {
//            System.out.println("Không có dữ liệu nào được cập nhật.");
//        }
//    } else {
//        // Hiển thị thông báo nếu không tìm thấy mã số nhà cung cấp trong danh sách
//        System.out.println("Không tìm thấy nhà cung cấp có mã số " + maNCC);
//    }
//}

}
