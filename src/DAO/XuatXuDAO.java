
package DAO;
import DTO.thuocTinhSanPham.XuatXuDTO;
import java.sql.*;
import java.util.ArrayList;

public class XuatXuDAO implements DAO_Interface<XuatXuDTO>{
public static XuatXuDAO getInstance(){
    return new XuatXuDAO();
}
    @Override
    public int insert(XuatXuDTO t) {
         int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "INSERT TO xuatxu(maxuatxu,tenxuatxu,trangthai)"
                    + " VALUES(?,?,1)";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMaxuatxu());
            psm.setString(2, t.getTenxuatxu());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(XuatXuDTO t) {
         int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE xuatxu"
                    + " SET tenxuatxu=? WHERE maxuatxu=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, t.getTenxuatxu());
            psm.setInt(2, t.getMaxuatxu());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(XuatXuDTO t) {
           int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE xuatxu"
                    + " SET trangthai=0 WHERE maxuatxu=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMaxuatxu());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<XuatXuDTO> selecAll() {
        ArrayList<XuatXuDTO> ketqua=new ArrayList<>();
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql ="SELECT * FROM xuatxu WHERE trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int maxuatxu=rs.getInt("maxuatxu");
                String tenxuatxu=rs.getString("tenxuatxu");
                ketqua.add(new XuatXuDTO(maxuatxu,tenxuatxu));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    public XuatXuDTO selectByID(int t){
        XuatXuDTO ketqua=null;
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM xuatxu WHERE maxuatxu=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
               int maxuatxu=rs.getInt("maxuatxu");
                String tenxuatxu=rs.getString("tenxuatxu");
                ketqua=new XuatXuDTO(maxuatxu, tenxuatxu);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
     public XuatXuDTO selectByTenXuatXu(String t){
        XuatXuDTO ketqua=null;
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM xuatxu WHERE tenxuatxu=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, t);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int maxuatxu=rs.getInt("maxuatxu");
                String tenxuatxu=rs.getString("tenxuatxu");
                ketqua=new XuatXuDTO(maxuatxu, tenxuatxu);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    @Override
    public XuatXuDTO selectById(XuatXuDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<XuatXuDTO> selectByCondition(String condition) {
        ArrayList<XuatXuDTO> ketqua=new ArrayList<>();
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql ="SELECT * FROM xuatxu WHERE "+condition;
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int maxuatxu=rs.getInt("maxuatxu");
                String tenxuatxu=rs.getString("tenxuatxu");
                ketqua.add(new XuatXuDTO(maxuatxu,tenxuatxu));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    
}
