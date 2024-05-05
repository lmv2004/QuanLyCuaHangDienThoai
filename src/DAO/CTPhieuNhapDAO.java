
package DAO;

import DTO.ChiTietPhieuDTO;
import DTO.PhienBanSanPhamDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CTPhieuNhapDAO implements DAO_Interface<ChiTietPhieuDTO>{
    
    @Override
    public int insert(ChiTietPhieuDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            
            String sql = "INSERT INTO ctphieunhap VALUES(? , ? , ? , ?, ?);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaPhieu());
            pst.setInt(2, t.getMPBSP());
            pst.setInt(3, t.getSoLuong());
            pst.setLong(4, t.getDonGia());
            pst.setLong(4, t.getDonGia());
            pst.setInt(5, t.getHinhthuc());
            ketqua = pst.executeUpdate();

            System.out.println("success! Affected rows: "+ketqua);
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(ChiTietPhieuDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "Update ctphieunhap"
                    + " Set maphieunhap=?, soluong=?, dongia=?, hinhthucnhap=?"
                    + " Where maphieunhap =? and maphienbansp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, t.getMaPhieu());
            pst.setInt(2, t.getSoLuong());
            pst.setLong(3, t.getDonGia());
            pst.setInt(4, t.getHinhthuc());
            pst.setInt(5, t.getMaPhieu());
            pst.setInt(6, t.getMPBSP());
            ketqua = pst.executeUpdate();
            System.out.println("success! Affected rows: "+ketqua);
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(ChiTietPhieuDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "Delete from ctphieunhap WHERE maphieunhap=? and maphienbansp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaPhieu());
            pst.setInt(2, t.getMPBSP());
            ketqua = pst.executeUpdate();
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<ChiTietPhieuDTO> selecAll() {
        ArrayList<ChiTietPhieuDTO> ketqua = new ArrayList<ChiTietPhieuDTO>();
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM ctphieunhap";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaPhieu = rs.getInt("maphieunhap");
                int MPBSP = rs.getInt("maphienbansp");
                int SoLuong = rs.getInt("soluong");
                Long DonGia = rs.getLong("dongia");
                int HT = rs.getInt("hinhthucnhap");
                ketqua.add(new ChiTietPhieuDTO(MaPhieu, MPBSP, SoLuong, DonGia, HT));
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
    
    public ArrayList<ChiTietPhieuDTO> selecAllByID(int ID) {
        ArrayList<ChiTietPhieuDTO> ketqua = new ArrayList<ChiTietPhieuDTO>();
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM phieunhap PN,ctphieunhap CT WHERE PN.maphieunhap=CT.maphieunhap AND PN.maphieunhap="+ID;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaPhieu = rs.getInt("maphieunhap");
                int MPBSP = rs.getInt("maphienbansp");
                int SoLuong = rs.getInt("soluong");
                Long DonGia = rs.getLong("dongia");
                int HT = rs.getInt("hinhthucnhap");
                ketqua.add(new ChiTietPhieuDTO(MaPhieu, MPBSP, SoLuong, DonGia, HT));
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ChiTietPhieuDTO selectById(ChiTietPhieuDTO t) {
        ChiTietPhieuDTO ketqua = null;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = String.format("SELECT * FROM ctphieunhap WHERE maphieunhap=%s and maphienbansp=%s", t.getMaPhieu(),t.getMPBSP());
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int MaPhieu = rs.getInt("maphieunhap");
            int MPBSP = rs.getInt("maphienbansp");
            int SoLuong = rs.getInt("soluong");
            Long DonGia = rs.getLong("dongia");
            int HT = rs.getInt("hinhthucnhap");
                ketqua = new ChiTietPhieuDTO(MaPhieu, MPBSP, SoLuong, DonGia, HT);
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<ChiTietPhieuDTO> selectByCondition(String condition) {
        ArrayList<ChiTietPhieuDTO> ketqua = new ArrayList<>();
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                int MaPhieu = rs.getInt("maphieunhap");
            int MPBSP = rs.getInt("maphienbansp");
            int SoLuong = rs.getInt("soluong");
            Long DonGia = rs.getLong("dongia");
            int HT = rs.getInt("hinhthucnhap");
            ketqua.add(new ChiTietPhieuDTO(MaPhieu, MPBSP, SoLuong, DonGia, HT));
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
    
}
