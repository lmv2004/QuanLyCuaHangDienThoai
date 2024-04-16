package DAO;

import DTO.thuocTinhSanPham.DungLuongRamDTO;
import java.util.ArrayList;
import java.sql.*;

public class DungLuongRamDAO implements DAO_Interface<DungLuongRamDTO> {
    public static DungLuongRamDAO getInstance(){
        return new DungLuongRamDAO();
    }
    @Override
    public int insert(DungLuongRamDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "INSERT TO dungluongram(madlram,kichthuocram,trangthai)"
                    + " VALUES(?,?,1)";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMadlram());
            psm.setInt(2, t.getDungluongram());
            ketqua = psm.executeUpdate();

            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(DungLuongRamDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE dungluongram"
                    + " SET kichthuocram=? WHERE madlram=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getDungluongram());
            psm.setInt(2, t.getMadlram());
            ketqua = psm.executeUpdate();

            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(DungLuongRamDTO t) {
          int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE dungluongram"
                    + " SET trangthai=0 WHERE madlram=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMadlram());
            ketqua = psm.executeUpdate();

            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<DungLuongRamDTO> selecAll() {
        ArrayList<DungLuongRamDTO> ketqua=new ArrayList<DungLuongRamDTO>();
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM dungluongram WHERE trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int madlram=rs.getInt("madlram");
                int kichthuocram=rs.getInt("kichthuocram");
                ketqua.add(new DungLuongRamDTO(madlram,kichthuocram));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }


    public DungLuongRamDTO selectById(int t) {
         DungLuongRamDTO ketqua=null;
         try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM dungluongram WHERE madlram=? and trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int madlram=rs.getInt("madlram");
                int kichthuocram=rs.getInt("kichthuocram");
                ketqua=new DungLuongRamDTO(madlram,kichthuocram);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<DungLuongRamDTO> selectByCondition(String condition) {
       ArrayList<DungLuongRamDTO> ketqua=new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM dungluongram WHERE "+condition;
            PreparedStatement psm = conn.prepareStatement(sql);
            
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int madlram=rs.getInt("madlram");
                int kichthuocram=rs.getInt("kichthuocram");
                ketqua.add(new DungLuongRamDTO(madlram,kichthuocram));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return ketqua;
    }

    @Override
    public DungLuongRamDTO selectById(DungLuongRamDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
