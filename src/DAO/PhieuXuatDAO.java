package DAO;

import DTO.PhieuXuatDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class PhieuXuatDAO implements DAO_Interface<PhieuXuatDTO> {
    @Override
    public ArrayList selectByCondition(String condition) {
        ArrayList<PhieuXuatDTO> ketqua = new ArrayList<PhieuXuatDTO>();
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM phieuxuat WHERE trangthai=1 and"+ condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaPhieu = rs.getInt("maphieuxuat");
                Timestamp ThoiGian = rs.getTimestamp("thoigian");
                long TongTien = rs.getLong("tongtien");
                int MNV = rs.getInt("manv");
                int MaKH = rs.getInt("makh");
                ketqua.add(new PhieuXuatDTO(MaKH, MaPhieu, MNV, ThoiGian, TongTien));
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int insert(PhieuXuatDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            
            String sql = "INSERT INTO phieuxuat VALUES(? , ? , ? , ? , ? , 1);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaPhieu());
            pst.setDate(2, (java.sql.Date) t.getThoiGian());
            pst.setLong(3, t.getTongTien());
            pst.setInt(4, t.getMNV());
            pst.setInt(5, t.getMKH());
            ketqua = pst.executeUpdate();

            System.out.println("success! Affected rows: "+ketqua);
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(PhieuXuatDTO t) {
        int ketqua = 0;
        try {

            // bước 1 tạo kết nối
            Connection con = JDBCConnection.getJDBCConnection();

            // bước 2 tạo đối tượng statement
            String sql = "Update phieuxuat"
                    + " SET makh=?, manv=?, thoigian=?, tongtien=?"
                    + " Where maphieuxuat =?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, t.getMKH());
            pst.setInt(2, t.getMNV());
            pst.setDate(3, (java.sql.Date) t.getThoiGian());
            pst.setLong(4, t.getTongTien());
            pst.setInt(5, t.getMaPhieu());
            ketqua = pst.executeUpdate();
            System.out.println("success! Affected rows: "+ketqua);
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(PhieuXuatDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = String.format("UPDATE phieuxuat SET trangthai=0 WHERE maphieuxuat=%s", t.getMaPhieu());
            PreparedStatement pst = con.prepareStatement(sql);
            ketqua = pst.executeUpdate();
            System.out.println("success! Affected rows: "+ketqua);
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public PhieuXuatDTO selectById(PhieuXuatDTO t) {
        PhieuXuatDTO ketqua = null;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = String.format("SELECT * FROM phieuxuat WHERE maphieuxuat=%s and trangthai=1", t.getMaPhieu());
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaPhieu = rs.getInt("maphieuxuat");
                Date ThoiGian = rs.getDate("thoigian");
                long TongTien = rs.getLong("tongtien");
                int MNV = rs.getInt("manv");
                int MaKH = rs.getInt("makh");
                ketqua = new PhieuXuatDTO(MaKH, MaPhieu, MNV, ThoiGian, TongTien);
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<PhieuXuatDTO> selecAll() {
        ArrayList<PhieuXuatDTO> ketqua = new ArrayList<PhieuXuatDTO>();
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM phieuxuat WHERE trangthai=1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaPhieu = rs.getInt("maphieuxuat");
                Date ThoiGian = rs.getDate("thoigian");
                long TongTien = rs.getLong("tongtien");
                int MNV = rs.getInt("manv");
                int MaKH = rs.getInt("makh");
                ketqua.add(new PhieuXuatDTO(MaKH, MaPhieu, MNV, ThoiGian, TongTien));
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    
    public PhieuXuatDTO selectById(int ID) {
        PhieuXuatDTO ketqua = null;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = String.format("SELECT * FROM phieuxuat WHERE maphieuxuat=%s and trangthai=1", ID);
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaPhieu = rs.getInt("maphieuxuat");
                Date ThoiGian = rs.getDate("thoigian");
                long TongTien = rs.getLong("tongtien");
                int MNV = rs.getInt("manv");
                int MaKH = rs.getInt("makh");
                ketqua = new PhieuXuatDTO(MaKH, MaPhieu, MNV, ThoiGian, TongTien);
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
}
