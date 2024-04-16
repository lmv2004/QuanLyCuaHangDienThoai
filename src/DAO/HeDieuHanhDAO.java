package DAO;

import DTO.thuocTinhSanPham.HeDieuHanhDTO;
import java.util.ArrayList;
import java.sql.*;

public class HeDieuHanhDAO implements DAO_Interface<HeDieuHanhDTO> {
    public static HeDieuHanhDAO getInstance(){
        return new HeDieuHanhDAO();
    }
    @Override
    public int insert(HeDieuHanhDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "INSERT TO hedieuhanh(mahedieuhanh,tenhedieuhanh,trangthai)"
                    + " VALUES(?,?,1)";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMahdh());
            psm.setString(2, t.getTenhdh());
            ketqua = psm.executeUpdate();

            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(HeDieuHanhDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE hedieuhanh"
                    + " SET tenhedieuhanh=? WHERE mahedieuhanh=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, t.getTenhdh());
            psm.setInt(2, t.getMahdh());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(HeDieuHanhDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE hedieuhanh"
                    + " SET trangthai=0 WHERE mahedieuhanh=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMahdh());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<HeDieuHanhDTO> selecAll() {
        ArrayList<HeDieuHanhDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM hedieuhanh WHERE trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int mahdh = rs.getInt("mahedieuhanh");
                String tenhdh = rs.getString("tenhedieuhanh");
                ketqua.add(new HeDieuHanhDTO(mahdh, tenhdh));
            }

            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public HeDieuHanhDTO selectById(int t) {
        HeDieuHanhDTO ketqua = null;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM hedieuhanh WHERE mahedieuhanh=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int mahdh = rs.getInt("mahedieuhanh");
                String tenhdh = rs.getString("tenhedieuhanh");
                ketqua = new HeDieuHanhDTO(mahdh, tenhdh);
            }

            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public HeDieuHanhDTO selectByTenHDH(String t) {
        HeDieuHanhDTO ketqua = null;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM hedieuhanh WHERE tenhedieuhanh=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, t);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int mahdh = rs.getInt("mahedieuhanh");
                String tenhdh = rs.getString("tenhedieuhanh");
                ketqua = new HeDieuHanhDTO(mahdh, tenhdh);
            }

            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public HeDieuHanhDTO selectById(HeDieuHanhDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HeDieuHanhDTO> selectByCondition(String condition) {
         ArrayList<HeDieuHanhDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM hedieuhanh WHERE "+condition;
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int mahdh = rs.getInt("mahedieuhanh");
                String tenhdh = rs.getString("tenhedieuhanh");
                ketqua.add(new HeDieuHanhDTO(mahdh, tenhdh));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

}
