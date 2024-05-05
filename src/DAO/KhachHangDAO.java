
package DAO;

import DAO.JDBCConnection;
import DTO.KhachHangDTO;
import DTO.NhaCungCapDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;


public class KhachHangDAO implements DAO_Interface<KhachHangDTO> {

    @Override
    public int insert(KhachHangDTO t) {
        int kq = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO khachhang (makh, tenkhachhang, diachi, sdt, trangthai, ngaythamgia ) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaKhachHang());
            pst.setString(2, t.getTenKhachHang());
            pst.setString(3, t.getDiaChi());
            pst.setString(4, t.getSDT());
            pst.setInt(5, t.getTrangThai());
            java.util.Date utilDate = t.getNgayThamGia();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pst.setDate(6, sqlDate);

            // Thực thi câu lệnh SQL
            kq = pst.executeUpdate();

            System.out.println("bạn đã thực thi");
            System.out.println("có " + kq + " dòng được cập nhật");

            JDBCConnection.closeConection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int update(KhachHangDTO t) {
        int kq = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE khachhang"
                    + " tenkhachhang=? , diachi=? , sdt=? , trangthai=? ,  ngaythamgia=?"
                    + " WHERE makh=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenKhachHang());
            pst.setString(2, t.getDiaChi());
            pst.setString(3, t.getSDT());
            pst.setInt(4, t.getTrangThai());
            java.util.Date utilDate = t.getNgayThamGia();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pst.setDate(5, sqlDate);
            pst.setInt(6, t.getMaKhachHang());

            // Thực thi câu lệnh SQL
            kq = pst.executeUpdate();

            System.out.println("bạn đã thực thi");
            System.out.println("có " + kq + " dòng được cập nhật");

            JDBCConnection.closeConection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int delete(KhachHangDTO t) {
        int ketqua = 0;
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE khachhang"
                    + " SET trangthai=0"
                    + " WHERE makh=?";
            PreparedStatement psm = con.prepareStatement(sql);

            psm.setInt(1, t.getMaKhachHang());

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
    public ArrayList<KhachHangDTO> selecAll() {
        ArrayList<KhachHangDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM khachhang WHERE trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int MaKhachHang = rs.getInt("makh");
                String TenKhachHang = rs.getString("tenkhachhang");
                String DiaChi = rs.getString("diachi");
                String SDT = rs.getString("sdt");
                int TrangThai = rs.getInt("trangthai");
                Date NgayThamGia = rs.getDate("ngaythamgia"); // Sử dụng getDate() để lấy giá trị ngày tham gia
                ketqua.add(new KhachHangDTO(MaKhachHang, TenKhachHang, DiaChi, SDT, TrangThai, NgayThamGia));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public KhachHangDTO selectById(KhachHangDTO t) {
        KhachHangDTO ketqua = null;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM khachhang WHERE makh=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMaKhachHang());
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {

                int MaKhachHang = rs.getInt("makh");
                String TenKhachHang = rs.getString("tenkhachhang");
                String DiaChi = rs.getString("diachi");
                String SDT = rs.getString("sdt");
                int TrangThai = rs.getInt("trangthai");
                Date NgayThamGia = rs.getDate("ngaythamgia"); // Sử dụng getDate() để lấy giá trị ngày tham gia
                ketqua = new KhachHangDTO(MaKhachHang, TenKhachHang, DiaChi, SDT, TrangThai, NgayThamGia);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public KhachHangDTO selectById(int ID) {
        KhachHangDTO ketqua = null;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM khachhang WHERE makh=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, ID);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {

                int MaKhachHang = rs.getInt("makh");
                String TenKhachHang = rs.getString("tenkhachhang");
                String DiaChi = rs.getString("diachi");
                String SDT = rs.getString("sdt");
                int TrangThai = rs.getInt("trangthai");
                Date NgayThamGia = rs.getDate("ngaythamgia"); // Sử dụng getDate() để lấy giá trị ngày tham gia
                ketqua = new KhachHangDTO(MaKhachHang, TenKhachHang, DiaChi, SDT, TrangThai, NgayThamGia);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    public KhachHangDTO SelectBySDT(String sdt){
       KhachHangDTO ketqua = null;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM khachhang WHERE sdt=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, sdt);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {

                int MaKhachHang = rs.getInt("makh");
                String TenKhachHang = rs.getString("tenkhachhang");
                String DiaChi = rs.getString("diachi");
                String SDT = rs.getString("sdt");
                int TrangThai = rs.getInt("trangthai");
                Date NgayThamGia = rs.getDate("ngaythamgia"); // Sử dụng getDate() để lấy giá trị ngày tham gia
                ketqua = new KhachHangDTO(MaKhachHang, TenKhachHang, DiaChi, SDT, TrangThai, NgayThamGia);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua; 
    }
    @Override
    public ArrayList<KhachHangDTO> selectByCondition(String condition) {
        ArrayList<KhachHangDTO> ketqua = new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM khachhang WHERE " + condition;
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int MaKhachHang = rs.getInt("makh");
                String TenKhachHang = rs.getString("tenkhachhang");
                String DiaChi = rs.getString("diachi");
                String SDT = rs.getString("sdt");
                int TrangThai = rs.getInt("trangthai");
                Date NgayThamGia = rs.getDate("ngaythamgia"); // Sử dụng getDate() để lấy giá trị ngày tham gia
                ketqua.add(new KhachHangDTO(MaKhachHang, TenKhachHang, DiaChi, SDT, TrangThai, NgayThamGia));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
}
