/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietPhieuDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class CTPhieuXuatDAO implements DAO_Interface<ChiTietPhieuDTO>{
    @Override
    public int insert(ChiTietPhieuDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            
            String sql = "INSERT INTO ctphieuxuat VALUES(? , ? , ? , ?);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaPhieu());
            pst.setInt(2, t.getMPBSP());
            pst.setInt(3, t.getSoLuong());
            pst.setLong(4, t.getDonGia());
            pst.setLong(4, t.getDonGia());
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
            String sql = "Update ctphieuxuat"
                    + " Set maphieuxuat=?, soluong=?, dongia=?"
                    + " Where maphieuxuat =? and maphienbansp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, t.getMaPhieu());
            pst.setInt(2, t.getSoLuong());
            pst.setLong(3, t.getDonGia());
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
            String sql = String.format("Delete from ctphieuxuat WHERE maphieuxuat=%s and maphienbansp=%s", t.getMaPhieu(),t.getMPBSP());
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
    public ArrayList<ChiTietPhieuDTO> selecAll() {
        ArrayList<ChiTietPhieuDTO> ketqua = new ArrayList<ChiTietPhieuDTO>();
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM ctphieuxuat";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int MaPhieu = rs.getInt("maphieuxuat");
                int MPBSP = rs.getInt("maphienbansp");
                int SoLuong = rs.getInt("soluong");
                Long DonGia = rs.getLong("dongia");
                ketqua.add(new ChiTietPhieuDTO(MaPhieu, MPBSP, SoLuong, DonGia, 0));
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
            String sql = String.format("SELECT * FROM ctphieuxuat WHERE maphieuxuat=%s and maphienbansp=%s", t.getMaPhieu(),t.getMPBSP());
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int MaPhieu = rs.getInt("maphieuxuat");
            int MPBSP = rs.getInt("maphienbansp");
            int SoLuong = rs.getInt("soluong");
            Long DonGia = rs.getLong("dongia");
                ketqua = new ChiTietPhieuDTO(MaPhieu, MPBSP, SoLuong, DonGia, 0);
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
                int MaPhieu = rs.getInt("maphieuxuat");
            int MPBSP = rs.getInt("maphienbansp");
            int SoLuong = rs.getInt("soluong");
            Long DonGia = rs.getLong("dongia");
            ketqua.add(new ChiTietPhieuDTO(MaPhieu, MPBSP, SoLuong, DonGia, 0));
            }
            JDBCConnection.closeConection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
}
