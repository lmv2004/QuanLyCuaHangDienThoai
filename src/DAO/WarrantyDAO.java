/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.WarrantyDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

/**
 *
 * @author Danny
 */
public class WarrantyDAO implements DAO_Interface<WarrantyDTO> {

    @Override
    public int insert(WarrantyDTO t) {
        int result = 0; // this will be the return value
        try {
            Connection con = JDBCConnection.getJDBCConnection(); // get database connection

            String sql = "INSERT INTO `baohanh` (`masanpham`, `mabaohanh`, `tenkhachhang`, `yeucaubaohanh`, `trangthai`, `ngaybaohanh`) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql); // create a prepared statement
            
            pst.setInt(1, t.getMaSanPham()); // set the values for the ? in sql
            pst.setInt(2, t.getMaBaoHanh());
            pst.setString(3, t.getTenKhachHang());
            pst.setString(4, t.getYeuCauBaoHanh());
            pst.setString(5, t.getNgayBaoHanh());

            result = pst.executeUpdate(sql); // execute the query, get the number of affected rows

            System.out.println("Insert Successfully! Affected rows: " + result); // print the affected rows

            JDBCConnection.closeConection(con); // close the database connection

        } catch (SQLException ex) { // if something goes wrong
            ex.printStackTrace(); // print the error
        }

        return result; // return the number of affected rows
    }

    @Override
    public int update(WarrantyDTO t) {
        int result = 0; // this will be the return value
        try {
            Connection con = JDBCConnection.getJDBCConnection(); // get database connection

            String sql = "UPDATE `baohanh` SET `masanpham`=?, `mabaohanh`=?, `tenkhachhang`=?, `yeucaubaohanh`=?, `trangthai`=?, `ngaybaohanh`=? WHERE `mabaohanh`=?"; // the SQL query
            PreparedStatement pst = con.prepareStatement(sql); // create a prepared statement

            pst.setInt(1, t.getMaSanPham()); // set the values for the ? in sql
            pst.setInt(2, t.getMaBaoHanh());
            pst.setString(3, t.getTenKhachHang());
            pst.setString(4, t.getYeuCauBaoHanh());
            pst.setString(5, t.getNgayBaoHanh());

            result = pst.executeUpdate(sql); // execute the query, get the number of affected rows

            System.out.println("Updated Successfully! Affected rows: " + result); // print the affected rows

            JDBCConnection.closeConection(con); // close the database connection
            
        } catch (SQLException ex) { // if something goes wrong
            ex.printStackTrace(); // print the error
        }

        return result; // return the number of affected rows
    }

    @Override
    public int delete(WarrantyDTO t) {
        int result = 0; // this will be the return value
        try {
            Connection con = JDBCConnection.getJDBCConnection(); // get database connection

            String sql = "DELETE FROM `baohanh` WHERE `mabaohanh`=?"; // the SQL query
            PreparedStatement pst = con.prepareStatement(sql); // create a prepared statement

            pst.setInt(1, t.getMaBaoHanh()); // set the value for the ? in sql

            result = pst.executeUpdate(sql); // execute the query, get the number of affected rows

            System.out.println("Deleted Successfully! Affected rows: " + result); // print the affected rows

            JDBCConnection.closeConection(con); // close the database connection

        } catch (SQLException ex) { // if something goes wrong
            ex.printStackTrace(); // print the error
        }

        return result; // return the number of affected rows
    }

    @Override
    public ArrayList<WarrantyDTO> selecAll() {

        ArrayList<WarrantyDTO> result = new ArrayList<WarrantyDTO>();

        try {
            Connection con = JDBCConnection.getJDBCConnection(); // get database connection
            String sql = "SELECT * FROM `baohanh`"; // the SQL query
            PreparedStatement pst = con.prepareStatement(sql); // create a prepared statement

            System.out.println("Select All Successfully!"); // print a message to indicate that the process is successful

            ResultSet rs = pst.executeQuery(); // execute the query

            while (rs.next()) { // loop through the result set
                int MaSanPham = rs.getInt("masanpham"); // get the values from the result set
                int MaBaoHanh = rs.getInt("mabaohanh");
                String TenKhachHang = rs.getString("tenkhachhang");
                String YeuCauBaoHanh = rs.getString("yeucaubaohanh");
                String NgayBaoHanh = rs.getString("ngaybaohanh");

                WarrantyDTO warranty = new WarrantyDTO(MaSanPham, MaBaoHanh, TenKhachHang, YeuCauBaoHanh, MaBaoHanh, NgayBaoHanh); // create a new WarrantyDTO object from the values
                result.add(warranty); // add it to the result list
            }

            JDBCConnection.closeConection(con); // close the database connection

        } catch (SQLException ex) {
            ex.printStackTrace(); // if something goes wrong, print the error
        }

        // return the list of WarrantyDTO objects that are selected from the database
        return result;
    }

    @Override
    public WarrantyDTO selectById(WarrantyDTO t) {

        // Select a warranty record by its ID
        // Return the selected record if it exists, otherwise return null
        WarrantyDTO result = null; // The result of the query

        try {
            Connection con = JDBCConnection.getJDBCConnection(); // get database connection

            String sql = "SELECT * FROM `baohanh` WHERE `mabaohanh`=?"; // The SQL query
            PreparedStatement pst = con.prepareStatement(sql); // Create a prepared statement
            pst.setInt(1, t.getMaBaoHanh()); // Bind the input parameter

            System.out.println("Select ID" + t.getMaBaoHanh() + "Successfully!"); // Print a message to indicate the process is successful

            ResultSet rs = pst.executeQuery(); // Execute the query

            if (rs.next()) { // If there is at least one record that satisfies the condition
                int MaSanPham = rs.getInt("masanpham"); // Get the values from the result set
                int MaBaoHanh = rs.getInt("mabaohanh");
                String TenKhachHang = rs.getString("tenkhachhang");
                String YeuCauBaoHanh = rs.getString("yeucaubaohanh");
                String NgayBaoHanh = rs.getString("ngaybaohanh");

                result = new WarrantyDTO(MaSanPham, MaBaoHanh, TenKhachHang, YeuCauBaoHanh, MaBaoHanh, NgayBaoHanh); // Create a new WarrantyDTO object from the values
            }

            JDBCConnection.closeConection(con); // Close the database connection
        } catch (SQLException ex) {
            ex.printStackTrace(); // If something goes wrong, print the error
        }

        return result; // Return the selected record if it exists, otherwise return null
    }

    // TODO?Is there any condition to be added?

    @Override
    public ArrayList<WarrantyDTO> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
