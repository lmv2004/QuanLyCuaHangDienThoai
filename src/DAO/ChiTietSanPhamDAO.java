package DAO;

import DTO.ChiTietSanPhamDTO;
import java.util.ArrayList;
import java.sql.*;

public class ChiTietSanPhamDAO implements DAO_Interface<ChiTietSanPhamDTO> {
    public static ChiTietSanPhamDAO getInstance(){
        return new ChiTietSanPhamDAO();
    }
    @Override
    public int insert(ChiTietSanPhamDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "INSERT TO ctsanpham(maimei,maphienbansp,maphieunhap,maphieuxuat,tinhtrang)"
                    + " VALUES(? ,? ,? ,? ,?)";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, t.getImei());
            psm.setInt(2, t.getMaphienbansp());
            psm.setInt(3, t.getMaphieunhap());
            psm.setInt(4, t.getMaphieuxuat());
            psm.setInt(5, t.getTinhtrang());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(ChiTietSanPhamDTO t) {
        int ketqua = 0;
        try {

            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE sanpham"
                    + " SET maphienbansp=? ,maphieunhap=? ,maphieuxuat=? ,trangthai=?"
                    + " WHERE maimei=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMaphienbansp());
            psm.setInt(2, t.getMaphieunhap());
            psm.setInt(3, t.getMaphieuxuat());
            psm.setInt(4, t.getTinhtrang());
            psm.setString(5, t.getImei());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketqua;
    }

    public int updateXuat(ChiTietSanPhamDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE ctsanpham SET maphieuxuat=?,tinhtrang=1 WHERE maimei=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMaphieuxuat());
            psm.setString(2, t.getImei());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(ChiTietSanPhamDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE ctsanpham"
                    + " SET trangthai=0"
                    + " WHERE maimei=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, t.getImei());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<ChiTietSanPhamDTO> selecAll() {
        ArrayList<ChiTietSanPhamDTO> ketqua = new ArrayList<ChiTietSanPhamDTO>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM ctsanpham ";
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                String imei = rs.getString("maimei");
                int maphienbansp = rs.getInt("maphienbansp");
                int maphieunhap = rs.getInt("maphieunhap");
                int maphieuxuat = rs.getInt("maphieuxuat");
                int tinhtrang=rs.getInt("tinhtrang");
                ketqua.add(new ChiTietSanPhamDTO(imei,maphienbansp,maphieunhap,maphieuxuat,tinhtrang));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    public ArrayList<ChiTietSanPhamDTO> selectAllbyPb(int mapbsp) {
        ArrayList<ChiTietSanPhamDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM ctsanpham where maphienbansp = ? and tinhtrang = 1";
            PreparedStatement psm = (PreparedStatement) conn.prepareStatement(sql);
            psm.setInt(1, mapbsp);
            ResultSet rs = (ResultSet) psm.executeQuery();
            while (rs.next()) {
                String imei = rs.getString("maimei");
                int maphienban = rs.getInt("maphienbansp");
                int maphieunhap = rs.getInt("maphieunhap");
                int maphieuxuat = rs.getInt("maphieuxuat");
                int tinhtrang = rs.getInt("tinhtrang");
   
                ketqua.add(new ChiTietSanPhamDTO(imei, maphienban, maphieunhap, maphieuxuat, tinhtrang));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
     public ArrayList<ChiTietSanPhamDTO> selectbyPb(int mapbsp) {
        ArrayList<ChiTietSanPhamDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM ctsanpham where maphienbansp = ?";
            PreparedStatement psm =  conn.prepareStatement(sql);
            psm.setInt(1, mapbsp);
            ResultSet rs =  psm.executeQuery();
            while (rs.next()) {
                String imei = rs.getString("maimei");
                int maphienban = rs.getInt("maphienbansp");
                int maphieunhap = rs.getInt("maphieunhap");
                int maphieuxuat = rs.getInt("maphieuxuat");
                int tinhtrang = rs.getInt("tinhtrang");
                ketqua.add(new ChiTietSanPhamDTO(imei, maphienban, maphieunhap, maphieuxuat, tinhtrang));
            }
           JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    public ArrayList<ChiTietSanPhamDTO> selectPBvaTT(int mapbsp,int tt) {
        ArrayList<ChiTietSanPhamDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM ctsanpham where maphienbansp = ? and tinhtrang = ?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, mapbsp);
            psm.setInt(2,tt);
            ResultSet rs =  psm.executeQuery();
            while (rs.next()) {
                String imei = rs.getString("maimei");
                int maphienban = rs.getInt("maphienbansp");
                int maphieunhap = rs.getInt("maphieunhap");
                int maphieuxuat = rs.getInt("maphieuxuat");
                int tinhtrang = rs.getInt("tinhtrang");
                ketqua.add(new ChiTietSanPhamDTO(imei, maphienban, maphieunhap, maphieuxuat, tinhtrang));
            }
          JDBCConnection.closeConection(conn);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return ketqua;
    }
    @Override
    public ChiTietSanPhamDTO selectById(ChiTietSanPhamDTO t) {
         throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<ChiTietSanPhamDTO> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 public ArrayList<Integer> getMaPhienBanSPOfPhieu(int maphieu) {
        ArrayList<Integer> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM ctsanpham where maphieunhap = ?";
            PreparedStatement psm = (PreparedStatement) conn.prepareStatement(sql);
            psm.setInt(1, maphieu);
            ResultSet rs = (ResultSet) psm.executeQuery();
            while (rs.next()) {
                int maphienban = rs.getInt("maphienbansp");
                ketqua.add(maphienban);
            }
            JDBCConnection.closeConection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    
    public ArrayList<ChiTietSanPhamDTO> selectAllByMaPhieuNhap(int maphieunhap) {
        ArrayList<ChiTietSanPhamDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM ctsanpham where maphieunhap = ?";
            PreparedStatement psm =  conn.prepareStatement(sql);
            psm.setInt(1, maphieunhap);
            ResultSet rs =  psm.executeQuery();
            while (rs.next()) {
                String imei = rs.getString("maimei");
                int maphienban = rs.getInt("maphienbansp");
                int mapn = rs.getInt("maphieunhap");
                int maphieuxuat = rs.getInt("maphieuxuat");
                int tinhtrang = rs.getInt("tinhtrang");

                ketqua.add(new ChiTietSanPhamDTO(imei, maphienban, mapn, maphieuxuat, tinhtrang));
            }
            JDBCConnection.closeConection(conn);
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return ketqua;
    }
    
    public ArrayList<ChiTietSanPhamDTO> selectAllByMaPhieuXuat(int maphieunhap) {
        ArrayList<ChiTietSanPhamDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM ctsanpham where maphieuxuat = ?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, maphieunhap);
            ResultSet rs =  psm.executeQuery();
            while (rs.next()) {
                String imei = rs.getString("maimei");
                int maphienban = rs.getInt("maphienbansp");
                int mapn = rs.getInt("maphieunhap");
                int maphieuxuat = rs.getInt("maphieuxuat");
                int tinhtrang = rs.getInt("tinhtrang");

                ketqua.add(new ChiTietSanPhamDTO(imei, maphienban, mapn, maphieuxuat, tinhtrang));
            }
            JDBCConnection.closeConection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }
}
