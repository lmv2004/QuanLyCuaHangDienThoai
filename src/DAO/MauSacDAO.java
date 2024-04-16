
package DAO;
import DTO.thuocTinhSanPham.MauSacDTO;
import java.sql.*;
import java.util.ArrayList;

public class MauSacDAO implements DAO_Interface<MauSacDTO>{
    public static MauSacDAO getInstance(){
        return new MauSacDAO();
    }
    @Override
    public int insert(MauSacDTO t) {
       int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "INSERT TO mausac(mamau,tenmau,trangthai)"
                    + " VALUES(?,?,1)";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMamau());
            psm.setString(2, t.getTenmau());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(MauSacDTO t) {
         int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE mausac"
                    + " SET tenmau=? WHERE mamau=?";
            PreparedStatement psm = conn.prepareStatement(sql);           
            psm.setString(1, t.getTenmau());
            psm.setInt(2, t.getMamau());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(MauSacDTO t) {
         int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE mausac"
                    + " SET trangthai=0 WHERE mamau=?";
            PreparedStatement psm = conn.prepareStatement(sql);           
            psm.setInt(1, t.getMamau());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<MauSacDTO> selecAll() {
        ArrayList<MauSacDTO> ketqua=new ArrayList<>();
          try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql ="SELECT * FROM mausac WHERE trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int mamau=rs.getInt("mamau");
                String tenmau=rs.getString("tenmau");
                ketqua.add(new MauSacDTO(mamau,tenmau));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
     public MauSacDTO selectByID(int t){
        MauSacDTO ketqua=null;
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM mausac WHERE mamau=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
               int mamau=rs.getInt("mamau");
                String tenmau=rs.getString("tenmau");
                ketqua=new MauSacDTO(mamau, tenmau);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
     public MauSacDTO selectByTenMau(String t){
        MauSacDTO ketqua=null;
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM mausac WHERE tenmau=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, t);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int mamau=rs.getInt("mamau");
                String tenmau=rs.getString("tenmau");
                ketqua=new MauSacDTO(mamau, tenmau);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    @Override
    public MauSacDTO selectById(MauSacDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<MauSacDTO> selectByCondition(String condition) {
         ArrayList<MauSacDTO> ketqua=new ArrayList<>();
          try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql ="SELECT * FROM mausac WHERE "+condition;
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int mamau=rs.getInt("mamau");
                String tenmau=rs.getString("tenmau");
                ketqua.add(new MauSacDTO(mamau,tenmau));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    
}
