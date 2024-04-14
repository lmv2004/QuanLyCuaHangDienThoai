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
/**
 *
 * @author ACER
 */
public class LogInDAO {
    public static boolean check(AccountDTO acc) {
        boolean ketqua = false;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM taikhoan WHERE tendangnhap=? and matkhau=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, acc.getTaiKhoan());
            pst.setString(2, String.valueOf(acc.getMatKhau()));
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                ketqua=true;
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
    
}
