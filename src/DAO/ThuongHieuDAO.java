
package DAO;
import DTO.thuocTinhSanPham.ThuongHieuDTO;
import java.sql.*;
import java.util.ArrayList;

public class ThuongHieuDAO implements DAO_Interface<ThuongHieuDTO>{
    public static ThuongHieuDAO getInstance(){
        return new ThuongHieuDAO();
    }
    @Override
    public int insert(ThuongHieuDTO t) {
         int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "INSERT TO thuonghieu(mathuonghieu,tenthuonghieu,trangthai)"
                    + " VALUES(?,?,1)";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMathuonghieu());
            psm.setString(2, t.getTenthuonghieu());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(ThuongHieuDTO t) {
         int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE thuonghieu"
                    + " SET tenthuonghieu=? WHERE mathuonghieu=?";
            PreparedStatement psm = conn.prepareStatement(sql);
              psm.setString(1, t.getTenthuonghieu());
            psm.setInt(2, t.getMathuonghieu());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(ThuongHieuDTO t) {
         int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE thuonghieu"
                    + " SET trangthai=0 WHERE mathuonghieu=?";
            PreparedStatement psm = conn.prepareStatement(sql);        
            psm.setInt(1, t.getMathuonghieu());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<ThuongHieuDTO> selecAll() {
        ArrayList<ThuongHieuDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM thuonghieu WHERE trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int mathuonghieu = rs.getInt("mathuonghieu");
                String tenthuonghieu = rs.getString("tenthuonghieu");
                ketqua.add(new ThuongHieuDTO(mathuonghieu, tenthuonghieu));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    public ThuongHieuDTO selectByID(int t){
        ThuongHieuDTO ketqua=null;
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM thuonghieu WHERE mathuonghieu=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int mathuonghieu = rs.getInt("mathuonghieu");
                String tenthuonghieu = rs.getString("tenthuonghieu");
                ketqua=new ThuongHieuDTO(mathuonghieu, tenthuonghieu);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
     public ThuongHieuDTO selectByTenThuongHieu(String t){
        ThuongHieuDTO ketqua=null;
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM thuonghieu WHERE tenthuonghieu=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, t);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int mathuonghieu = rs.getInt("mathuonghieu");
                String tenthuonghieu = rs.getString("tenthuonghieu");
                ketqua=new ThuongHieuDTO(mathuonghieu, tenthuonghieu);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    @Override
    public ThuongHieuDTO selectById(ThuongHieuDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ThuongHieuDTO> selectByCondition(String condition) {
         ArrayList<ThuongHieuDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM thuonghieu WHERE "+condition;
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int mathuonghieu = rs.getInt("mathuonghieu");
                String tenthuonghieu = rs.getString("tenthuonghieu");
                ketqua.add(new ThuongHieuDTO(mathuonghieu, tenthuonghieu));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    
}
