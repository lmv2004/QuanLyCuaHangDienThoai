/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import com.mysql.cj.jdbc.JdbcConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class NhaCungCapDAO implements DAO_Interface<NhaCungCapDTO> {

    @Override
    public int insert(NhaCungCapDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO nhacungcap (manhacungcap, tennhacungcap, diachi, email, sdt, trangthai ) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement psm = con.prepareStatement(sql);
            psm.setInt(1, t.getMaNCC());
            psm.setString(2, t.getTenNCC());
            psm.setString(3, t.getDiaChi());
            psm.setString(4, t.getEmail());
            psm.setString(5, t.getSDT());
            psm.setInt(6, t.getTrangThai());

            ketqua = psm.executeUpdate();

            System.out.println("bạn đã thực thi");
            System.out.println("có " + ketqua + " dòng được cập nhật");

            JDBCConnection.closeConection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(NhaCungCapDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE nhacungcap"
                    + " SET tennhacungcap=? ,  diachi=? , email=? , sdt=? ,  trangthai=?"
                    + " WHERE manhacungcap=?";
            PreparedStatement psm = con.prepareStatement(sql);

            psm.setString(1, t.getTenNCC());
            psm.setString(2, t.getDiaChi());
            psm.setString(3, t.getEmail());
            psm.setString(4, t.getSDT());
            psm.setInt(5, t.getTrangThai());
            psm.setInt(6, t.getMaNCC());

            ketqua = psm.executeUpdate();

            System.out.println("bạn đã thực thi");
            System.out.println("có " + ketqua + " dòng được cập nhật");

            JDBCConnection.closeConection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(NhaCungCapDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE nhacungcap"
                    + " SET trangthai=0"
                    + " WHERE manhacungcap=?";
            PreparedStatement psm = con.prepareStatement(sql);

            psm.setInt(1, t.getMaNCC());

            ketqua = psm.executeUpdate();

            System.out.println("bạn đã thực thi");
            System.out.println("có " + ketqua + " dòng được cập nhật");

            JDBCConnection.closeConection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<NhaCungCapDTO> selecAll() {
        ArrayList<NhaCungCapDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM nhacungcap WHERE trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int MaNCC = rs.getInt("manhacungcap");
                String TenNCC = rs.getString("tennhacungcap");
                String DiaChi = rs.getString("diachi");
                String Email = rs.getString("email");
                String SDT = rs.getString("sdt");
                int TrangThai = rs.getInt("trangthai");
                ketqua.add(new NhaCungCapDTO(MaNCC, TenNCC, DiaChi, Email, SDT, TrangThai));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public NhaCungCapDTO selectById(NhaCungCapDTO t) {
        NhaCungCapDTO ketqua = null;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM nhacungcap WHERE manhacungcap=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMaNCC());
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int MaNCC = rs.getInt("manhacungcap");
                String TenNCC = rs.getString("tennhacungcap");
                String DiaChi = rs.getString("diachi");
                String Email = rs.getString("email");
                String SDT = rs.getString("sdt");
                int TrangThai = rs.getInt("trangthai");
                ketqua = new NhaCungCapDTO(MaNCC, TenNCC, DiaChi, Email, SDT, TrangThai);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    
    public NhaCungCapDTO selectById(int ID) {
        NhaCungCapDTO ketqua = null;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM nhacungcap WHERE manhacungcap=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, ID);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int MaNCC = rs.getInt("manhacungcap");
                String TenNCC = rs.getString("tennhacungcap");
                String DiaChi = rs.getString("diachi");
                String Email = rs.getString("email");
                String SDT = rs.getString("sdt");
                int TrangThai = rs.getInt("trangthai");
                ketqua = new NhaCungCapDTO(MaNCC, TenNCC, DiaChi, Email, SDT, TrangThai);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<NhaCungCapDTO> selectByCondition(String condition) {
        ArrayList<NhaCungCapDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM nhacungcap WHERE " + condition;
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int MaNCC = rs.getInt("manhacungcap");
                String TenNCC = rs.getString("tennhacungcap");
                String DiaChi = rs.getString("diachi");
                String Email = rs.getString("email");
                String SDT = rs.getString("sdt");
                int TrangThai = rs.getInt("trangthai");
                ketqua.add(new NhaCungCapDTO(MaNCC, TenNCC, DiaChi, Email, SDT, TrangThai));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

}
