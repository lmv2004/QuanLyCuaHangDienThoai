/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.JDBCConnection.getJDBCConnection;
import DTO.KhuVucKhoDTO;
import com.mysql.cj.jdbc.JdbcConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class KhuVucKhoDAO implements DAO_Interface<KhuVucKhoDTO>{

   public static KhuVucKhoDAO getInstance() {
        return new KhuVucKhoDAO();
    }

    
   @Override
    public int insert(KhuVucKhoDTO t) {
        int ketqua = 0;
        try {
            // bước 1 kết nối
            Connection con = JDBCConnection.getJDBCConnection();
            // bước 2,3 tạo đối tượng , tạo câu lệnh thực thi
            String sql = "INSERT INTO `khuvuckho` (`makhuvuc`, `tenkhuvuc`, `ghichu`, `trangthai`) VALUES (?, ?, ?, 1)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaKhuVuc());
            pst.setString(2, t.getTenKhuVuc());
            pst.setString(3, t.getGhiChu());
            
            
            ketqua = pst.executeUpdate();
            // bước 4:
            System.out.println("bạn đã thực thi");
            System.out.println("có " +ketqua +" dòng được cập nhật");
            // bước 5:
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return ketqua;
    }

    @Override
    public int update(KhuVucKhoDTO t) {
        int ketqua = 0;
        try {
 
            // bước 1 tạo kết nối
            Connection con = JDBCConnection.getJDBCConnection();
            
            
            // bước 2 tạo đối tượng statement
           String sql = "UPDATE `khuvuckho` SET `tenkhuvuc`=?,`ghichu`=? WHERE `makhuvuc`=?";

            PreparedStatement pst = con.prepareStatement(sql);
            
            
            pst.setString(1, t.getTenKhuVuc());
            pst.setString(2, t.getGhiChu());
            pst.setInt(3, t.getMaKhuVuc());
            // bước 3 tạo câu lệnh sql
            ketqua = pst.executeUpdate();
            
            // bước 4 
            
            // bước 5 đóng chương trình
            JDBCConnection.closeConection(con);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(KhuVucKhoDTO t) {
        int ketqua = 0 ;
        try {
            
            
            // bước 1 tạo kết nối
           Connection con = JDBCConnection.getJDBCConnection();
            
            // tạo đối tượng statement
            
            String sql = "UPDATE `khuvuckho` SET `trangthai` = 0 WHERE `makhuvuc`=?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, t.getMaKhuVuc());
            // bước 3 thực hiện câu lệnh sql
            
            ketqua = pst.executeUpdate();
            
            // bước 4
                System.out.println("Bạn đã thực hiện câu lệnh " + sql);
                System.out.println("có " +ketqua +" dòng được cập nhật");
            // bước 5 đóng kết nối
            
            JDBCConnection.closeConection(con);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<KhuVucKhoDTO> selecAll() {
        ArrayList<KhuVucKhoDTO> ketqua = new ArrayList<KhuVucKhoDTO>();
        try {
            
            
            // bước 1 tạo kết nối
            Connection con = JDBCConnection.getJDBCConnection();
            
            // bước 2
            
            String sql = "Select * "
                    + " from khuvuckho";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            // bước 3: tạo câu lệnh thực thi
            
            System.out.println("bạn đã thực thi: "+ sql);
            // trả về số dòng thay đổi
            ResultSet rs = pst.executeQuery(sql);
            // bước 4:
            while (rs.next()) {
                int maKhuVuc = rs.getInt("makhuvuc");
                String tenKhuVuc = rs.getString("tenkhuvuc");
                String ghiChu = rs.getString("ghichu");
                int trangThai = rs.getInt("trangthai");
                
                KhuVucKhoDTO khuvuckho = new KhuVucKhoDTO(maKhuVuc, tenKhuVuc, ghiChu);
                ketqua.add(khuvuckho);
            }
            // bước 5:
            JDBCConnection.closeConection(con);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public KhuVucKhoDTO selectById(KhuVucKhoDTO t) {
        KhuVucKhoDTO ketqua = null;
		try {
			// bước 1 tạo connection
			Connection con = JDBCConnection.getJDBCConnection();
			
			
			// bước 2: tạo đối tượng Statement
			
			String sql = "Select * From User Where makhuvuc=?" ;
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1 , t.getMaKhuVuc());
			
			// bước 3: tạo câu lệnh thực thi

			 
			
			System.out.println("bạn đã thực thi: "+ sql);
			// trả về số dòng thay đổi 	
			ResultSet rs = pst.executeQuery();
			
			// bước 4:
			while(rs.next()) {
				int maKhuVuc = rs.getInt("makhuvuc");
				String tenKhuVuc = rs.getString("tenKhuVuc");
				String ghiChu = rs.getString("ghichu");
				int trangThai = rs.getInt("trangthai");
				ketqua = new KhuVucKhoDTO(maKhuVuc, tenKhuVuc, ghiChu);
				
			
			}			
			// bước 5:
			JDBCConnection.closeConection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ketqua;
    }
    
     public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBCConnection.getJDBCConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'qlchdienthoai' AND   TABLE_NAME   = 'khuvuckho'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery();
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");

                }
            }
            
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhuVucKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    @Override
    public ArrayList<KhuVucKhoDTO> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
