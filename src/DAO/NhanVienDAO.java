package DAO;

import DTO.NhanVienDTO;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;

public class NhanVienDAO implements DAO_Interface<NhanVienDTO> {

    @Override
    public int insert(NhanVienDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO nhanvien(manv,hoten,gioitinh,ngaysinh,sdt,email,trangthai)"
                    + " VALUES(?,?,?,?,?,?,1)";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getManv());
            psm.setString(2, t.getHoTen());
            psm.setInt(3, t.getGioiTinh());
            Timestamp timestamp = new Timestamp(t.getNgaySinh().getTime());
            psm.setTimestamp(4, timestamp);
            psm.setString(5, t.getSDT());
            psm.setString(6, t.getEmail());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketqua;
    }

    @Override
    public int update(NhanVienDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE nhanvien"
                    + " SET hoten=? , gioitinh=? ,ngaysinh=? ,sdt=? ,email=?"
                    + " WHERE manv=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, t.getHoTen());
            psm.setInt(2, t.getGioiTinh());
            psm.setDate(3, (java.sql.Date) t.getNgaySinh());
            psm.setString(4, t.getSDT());
            psm.setString(5, t.getEmail());
            psm.setInt(6, t.getManv());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketqua;
    }

    @Override
    public int delete(NhanVienDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE nhanvien"
                    + " SET trangthai=0"
                    + " WHERE manv=?";
            PreparedStatement psm = conn.prepareStatement(sql);

            psm.setInt(1, t.getManv());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketqua;
    }

    @Override
    public ArrayList<NhanVienDTO> selecAll() {
        ArrayList<NhanVienDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM nhanvien WHERE trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int manv=rs.getInt("manv");
                String hoten=rs.getString("hoten");
                int gioitinh=rs.getInt("gioitinh");
                Date ngaysinh=rs.getDate("ngaysinh");
                String sdt=rs.getString("sdt");
                String email=rs.getString("email");
                ketqua.add(new NhanVienDTO(manv,hoten,gioitinh,ngaysinh,sdt,email));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    public NhanVienDTO selectByID(int t){
        NhanVienDTO ketqua=null;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM nhanvien WHERE manv=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t);
            ResultSet rs=psm.executeQuery();
             while(rs.next()){
                int manv=rs.getInt("manv");
                String hoten=rs.getString("hoten");
                int gioitinh=rs.getInt("gioitinh");
                Date ngaysinh=rs.getDate("ngaysinh");
                String sdt=rs.getString("sdt");
                String email=rs.getString("email");
                ketqua=new NhanVienDTO(manv,hoten,gioitinh,ngaysinh,sdt,email);
                
            }
             JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    public NhanVienDTO selectByName(String t){
          NhanVienDTO ketqua=null;
          String ten=t.trim();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM nhanvien WHERE hoten=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, ten);
            ResultSet rs=psm.executeQuery();
             while(rs.next()){
                int manv=rs.getInt("manv");
                String hoten=rs.getString("hoten");
                int gioitinh=rs.getInt("gioitinh");
                Date ngaysinh=rs.getDate("ngaysinh");
                String sdt=rs.getString("sdt");
                String email=rs.getString("email");
                ketqua=new NhanVienDTO(manv,hoten,gioitinh,ngaysinh,sdt,email);
                
            }
             JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    @Override
    public NhanVienDTO selectById(NhanVienDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public ArrayList<NhanVienDTO> selectByCondition(String condition) {
           ArrayList<NhanVienDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM nhanvien WHERE "+condition;
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                int manv=rs.getInt("manv");
                String hoten=rs.getString("hoten");
                int gioitinh=rs.getInt("gioitinh");
                Date ngaysinh=rs.getDate("ngaysinh");
                String sdt=rs.getString("sdt");
                String email=rs.getString("email");
                ketqua.add(new NhanVienDTO(manv,hoten,gioitinh,ngaysinh,sdt,email));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

}
