/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.AccountDTO;
import DTO.PhieuNhapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
/**
 *
 * @author ACER
 */
public class AccountDAO implements DAO_Interface<AccountDTO>{

    @Override
    public int insert(AccountDTO t) {
        int result = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO taikhoan (manhomquyen, tendangnhap, matkhau, manv, trangthai) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, t.getMaNQ());
            pst.setString(2, t.getTaiKhoan());
            pst.setString(3, String.valueOf(t.getMatKhau()));
            pst.setInt(4, t.getMaNV());
            pst.setInt(5, t.getTrangThai());
            
            int kq = pst.executeUpdate();

            System.out.println("Execute Query: " + sql);

            JDBCConnection.closeConection(con);
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }   

        return result;
    }

    @Override
    public int update(AccountDTO t) {
        int result = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE taikhoan SET manhomquyen=?, tendangnhap=?, matkhau=?, manv=?, trangthai=? WHERE manv=?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, t.getMaNQ());
            pst.setString(2, t.getTaiKhoan());
            pst.setString(3, String.valueOf(t.getMatKhau()));
            pst.setInt(4, t.getMaNV());
            pst.setInt(5, t.getTrangThai());
            
            pst.setInt(6, t.getMaNV());
            
            result = pst.executeUpdate();

            System.out.println("Execute Query: " + sql);

            JDBCConnection.closeConection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int delete(AccountDTO t) {
        int result = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            
            // String sql = "DELETE FROM taikhoan WHERE manv=?";
            // this is only for hiding the data
            String sql = "UPDATE taikhoan SET trangthai=0 WHERE manv=?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, t.getMaNV());
            
            result = pst.executeUpdate();

            System.out.println("Execute Query: " + sql);

            JDBCConnection.closeConection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<AccountDTO> selecAll() {
        ArrayList<AccountDTO> ketqua = new ArrayList<AccountDTO>();
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM taikhoan WHERE trangthai=1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaNV = rs.getInt("manhomquyen");
                String TaiKhoan = rs.getString("tendangnhap");
                char[] MatKhau = rs.getString("matkhau").toCharArray();
                int MaNQ = rs.getInt("manv");
                int TrangThai = rs.getInt("trangthai");
                ketqua.add(new AccountDTO(MaNV,TaiKhoan, MatKhau,MaNQ, TrangThai));
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public AccountDTO selectById(AccountDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<AccountDTO> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
