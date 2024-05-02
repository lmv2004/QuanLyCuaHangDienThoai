package DAO;

import DTO.PhieuNhapDTO;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PhieuNhapDAO implements DAO_Interface<PhieuNhapDTO> {
    @Override
    public ArrayList selectByCondition(String condition) {
        ArrayList<PhieuNhapDTO> ketqua = new ArrayList<PhieuNhapDTO>();
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM phieunhap WHERE trangthai=1 and"+ condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaPhieu = rs.getInt("maphieunhap");
                Timestamp ThoiGian = rs.getTimestamp("thoigian");
                int NCC = rs.getInt("manhacungcap");
                int MNV = rs.getInt("nguoitao");
                long TongTien = rs.getLong("tongtien");
                ketqua.add(new PhieuNhapDTO(NCC, MaPhieu, MNV, ThoiGian, TongTien));
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int insert(PhieuNhapDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            
            String sql = "INSERT INTO phieunhap VALUES(? , ? , ? , ? , ? , 1);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaPhieu());
            pst.setDate(2, (java.sql.Date) t.getThoiGian());
            pst.setInt(3, t.getNCC());
            pst.setInt(4, t.getMNV());
            pst.setLong(5, t.getTongTien());
            ketqua = pst.executeUpdate();

            System.out.println("success! Affected rows: "+ketqua);
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
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "Update phieunhap"
                    + " Set thoigian=? ,manhacungcap=? ,nguoitao=? ,tongtien=?"
                    + " Where maphieunhap =?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setDate(1, (java.sql.Date) t.getThoiGian());
            pst.setInt(2, t.getNCC());
            pst.setInt(3, t.getMNV());
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
    public int delete(PhieuNhapDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = String.format("UPDATE phieunhap SET trangthai=0 WHERE maphieunhap=%s", t.getMaPhieu());
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
    public PhieuNhapDTO selectById(PhieuNhapDTO t) {
        PhieuNhapDTO ketqua = null;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = String.format("SELECT * FROM phieunhap WHERE maphieunhap=%s and trangthai=1", t.getMaPhieu());
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaPhieu = rs.getInt("maphieunhap");
                Date ThoiGian = rs.getDate("thoigian");
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
    
    public PhieuNhapDTO selectById(int ID) {
        PhieuNhapDTO ketqua = null;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = String.format("SELECT * FROM phieunhap WHERE maphieunhap=%s and trangthai=1", ID);
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
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
        ArrayList<PhieuNhapDTO> ketqua = new ArrayList<PhieuNhapDTO>();
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM phieunhap WHERE trangthai=1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaPhieu = rs.getInt("maphieunhap");
                Date ThoiGian = rs.getDate("thoigian");
                int NCC = rs.getInt("manhacungcap");
                int MNV = rs.getInt("nguoitao");
                long TongTien = rs.getLong("tongtien");
                ketqua.add(new PhieuNhapDTO(NCC, MaPhieu, MNV, ThoiGian, TongTien));
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    

}
