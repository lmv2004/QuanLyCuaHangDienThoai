
package DAO;

import DTO.thuocTinhSanPham.DungLuongRomDTO;
import java.util.ArrayList;
import java.sql.*;

public class DungLuongRomDAO implements DAO_Interface<DungLuongRomDTO>{
    public static DungLuongRamDAO getInstance(){
        return new DungLuongRamDAO();
    }
    @Override
    public int insert(DungLuongRomDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "INSERT TO dungluongrom(madlrom,kichthuocrom,trangthai)"
                    + " VALUES(?,?,1)";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMadungluongrom());
            psm.setInt(2, t.getDungluongrom());
            ketqua = psm.executeUpdate();

            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(DungLuongRomDTO t) {
         int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE dungluongrom"
                    + " SET kichthuocrom=? WHERE madlrom=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getDungluongrom());
            psm.setInt(2, t.getMadungluongrom());
            ketqua = psm.executeUpdate();

            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(DungLuongRomDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE dungluongrom"
                    + " SET trangthai=0 WHERE madlrom=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMadungluongrom());
            ketqua = psm.executeUpdate();

            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<DungLuongRomDTO> selecAll() {
        ArrayList<DungLuongRomDTO> ketqua=new ArrayList<DungLuongRomDTO>();
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM dungluongrom WHERE trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int madlrom=rs.getInt("madlrom");
                int kichthuocrom=rs.getInt("kichthuocrom");
                ketqua.add(new DungLuongRomDTO(madlrom,kichthuocrom));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
     public DungLuongRomDTO selectById(int t) {
         DungLuongRomDTO ketqua=null;
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM dungluongrom WHERE madlrom=? and trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int madlrom=rs.getInt("madlrom");
                int kichthuocrom=rs.getInt("kichthuocrom");
                ketqua=new DungLuongRomDTO(madlrom,kichthuocrom);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    @Override
    public DungLuongRomDTO selectById(DungLuongRomDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DungLuongRomDTO> selectByCondition(String condition) {
        ArrayList<DungLuongRomDTO> ketqua=new ArrayList<DungLuongRomDTO>();
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM dungluongrom WHERE "+condition;
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int madlrom=rs.getInt("madlrom");
                int kichthuocrom=rs.getInt("kichthuocrom");
                ketqua.add(new DungLuongRomDTO(madlrom,kichthuocrom));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    
}
