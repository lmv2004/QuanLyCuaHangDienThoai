package DAO;

import DTO.PhieuNhapDTO;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class PhieuNhapDAO implements DAO_Interface<PhieuNhapDTO, Integer>{


    @Override
    public ArrayList selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(PhieuNhapDTO t) {
        int ketqua = 0;
        try {
            // bước 1 kết nối
            Connection con = JDBCConnection.getJDBCConnection();
            // bước 2,3 tạo đối tượng , tạo câu lệnh thực thi
            String sql1 = String.format("INSERT INTO phieunhap VALUES (%s , '%s' , %s, %s, %s, %s)", t.getMaPhieu(),t.getThoiGian(),t.getNCC(),t.getMNV(),t.getTongTien(),1);
//            String sql = 
//                    "INSERT INTO phieunhap VALUES (? , ? , ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql1);
//            pst.setInt(1, t.getMaPhieu());
//            pst.setTimestamp(2, t.getThoiGian());
//            pst.setInt(3, t.getNCC());
//            pst.setInt(4, t.getMNV());
//            pst.setLong(5, t.getTongTien());
//            pst.setInt(6, 1);
            
            
            ketqua = pst.executeUpdate(sql1);

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
    public int update(PhieuNhapDTO t) {
        int ketqua = 0;
        try {
 
            // bước 1 tạo kết nối
            Connection con = JDBCConnection.getJDBCConnection();
            
            
            // bước 2 tạo đối tượng statement
            String sql = 
                      "Update phieunhap"
                    + "Set thoigian=?,manhacungcap=?,nguoitao=?,tongtien=?,trangthai=?"
                    + "Where maphieunhap =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaPhieu());
            pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            pst.setInt(3, t.getNCC());
            pst.setInt(4, t.getMNV());
            pst.setLong(5, t.getTongTien());
            pst.setInt(6, 1);
            // bước 3 tạo câu lệnh sql
            ketqua = pst.executeUpdate(sql);
            
            // bước 4 
            
            // bước 5 đóng chương trình
            JDBCConnection.closeConection(con);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(PhieuNhapDTO t) {
        int ketqua = 0;
        try {
            // bước 1 kết nối
            Connection con = JDBCConnection.getJDBCConnection();
            // bước 2,3 tạo đối tượng , tạo câu lệnh thực thi
            String sql1 = String.format("DELETE FROM phieunhap WHERE maphieunhap=%s", t.getMaPhieu());
            PreparedStatement pst = con.prepareStatement(sql1);
            ketqua = pst.executeUpdate(sql1);
            System.out.println("bạn đã thực thi");
            System.out.println("có " +ketqua +" dòng được cập nhật");
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;     
    }

    @Override
    public PhieuNhapDTO selectById(Integer ID) {
        PhieuNhapDTO ketqua = null;
        try {
            // bước 1 kết nối
            Connection con = JDBCConnection.getJDBCConnection();
            // bước 2,3 tạo đối tượng , tạo câu lệnh thực thi
            String sql = String.format("SELECT * FROM phieunhap WHERE maphieunhap=%s and trangthai=1",ID);
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                int MaPhieu = rs.getInt("maphieunhap");
                Timestamp ThoiGian = rs.getTimestamp("thoigian");
                int NCC = rs.getInt("manhacungcap");
                int MNV = rs.getInt("nguoitao");
                long TongTien = rs.getLong("tongtien");
                ketqua = new PhieuNhapDTO(NCC, MaPhieu, MNV, ThoiGian, TongTien);
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua; 
    }

    @Override
    public ArrayList<PhieuNhapDTO> selecAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
