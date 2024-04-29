package DAO;

import DTO.PermissionManagerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class PermissionManagerDAO implements DAO_Interface<PermissionManagerDTO> {

    @Override
    public int insert(PermissionManagerDTO t) {
        int result = 0; // initialize the result variable to 0
        try { // try to execute the following block of code
            Connection con = JDBCConnection.getJDBCConnection(); // get a connection to the database
            String sql = "INSERT INTO `nhomquyen` (manhomquyen, tennhomquyen, trangthai)" 
                    + "VALUES (?, ?, ?)"; // the SQL query to execute
            PreparedStatement pst = con.prepareStatement(sql); // create a prepared statement from the SQL query
            
            pst.setInt(1, t.getMaNhomQuyen()); // set the first parameter of the prepared statement to the value of t.getMaNhomQuyen()
            pst.setString(2, t.getTenNhomQuyen()); // set the second parameter of the prepared statement to the value of t.getTenNhomQuyen()
            pst.setInt(3, t.getTrangThai()); // set the third parameter of the prepared statement to the value of t.getTrangThai()

            result = pst.executeUpdate(); // execute the prepared statement and store the number of affected rows in result

            System.out.println("Insert Successfully! Affected rows: " + result); // print the result to the console

            JDBCConnection.closeConection(con); // close the connection to the database
        
        } catch (SQLException ex) { // if an exception occurs
            ex.printStackTrace(); // print the stack trace to the console
        } // end of catch block

        return result; // return the result to the caller
    }

    @Override
    public int update(PermissionManagerDTO t) {
        int result = 0; // initialize the result variable to 0
        try { // try to execute the following block of code
            Connection con = JDBCConnection.getJDBCConnection(); // get a connection to the database
            String sql = "UPDATE `nhomquyen` SET `tennhomquyen`=?, `trangthai`=? WHERE `manhomquyen`=?"; // the SQL query to execute
            PreparedStatement pst = con.prepareStatement(sql); // create a prepared statement from the SQL query

            pst.setString(1, t.getTenNhomQuyen()); // set the first parameter of the prepared statement to the value of t.getTenNhomQuyen()
            pst.setInt(2, t.getTrangThai()); // set the second parameter of the prepared statement to the value of t.getTrangThai()
            pst.setInt(3, t.getMaNhomQuyen()); // set the third parameter of the prepared statement to the value of t.getMaNhomQuyen()

            result = pst.executeUpdate(); // execute the prepared statement and store the number of affected rows in result

            System.out.println("Updated Successfully! Affected rows: " + result); // print the result to the console

            JDBCConnection.closeConection(con); // close the connection to the database
        
        } catch (SQLException ex) { // if an exception occurs
            ex.printStackTrace(); // print the stack trace to the console
        } // end of catch block
        
        return result; // return the result to the caller
    }

    @Override
    public int delete(PermissionManagerDTO t) {
        int result = 0; // initialize the result variable to 0
        try { // try to execute the following block of code
            Connection con = JDBCConnection.getJDBCConnection(); // get a connection to the database
            String sql = "DELETE FROM `nhomquyen` WHERE `manhomquyen`=?"; // the SQL query to execute
            PreparedStatement pst = con.prepareStatement(sql); // create a prepared statement from the SQL query
            
            pst.setInt(1, t.getMaNhomQuyen()); // set the first parameter of the prepared statement to the value of t.getMaNhomQuyen()

            result = pst.executeUpdate(); // execute the prepared statement and store the number of affected rows in result

            System.out.println("Deleted Successfully! Affected rows: " + result); // print the result to the console

            JDBCConnection.closeConection(con); // close the connection to the database
        
        } catch (SQLException ex) { // if an exception occurs
            ex.printStackTrace(); // print the stack trace to the console
        } // end of catch block
        
        return result; // return the result to the caller
    }

    @Override
    public ArrayList<PermissionManagerDTO> selecAll() {

        ArrayList<PermissionManagerDTO> result = new ArrayList<PermissionManagerDTO>(); // create an empty ArrayList to store the query result

        try {
            Connection con = JDBCConnection.getJDBCConnection(); // get a connection to the database
            String sql = "SELECT * FROM nhomquyen"; // the SQL query to execute
            PreparedStatement pst = con.prepareStatement(sql); // create a prepared statement from the SQL query

            System.out.println("Select All Successfully!"); // print a message to the console

            ResultSet rs = pst.executeQuery(); // execute the prepared statement and store the result in a ResultSet
            while (rs.next()) { // loop through the ResultSet
                int maNhomQuyen = rs.getInt("manhomquyen"); // get the value of the manhomquyen column from the current row
                String tenNhomQuyen = rs.getString("tennhomquyen"); // get the value of the tennhomquyen column from the current row
                int trangThai = rs.getInt("trangthai"); // get the value of the trangthai column from the current row
                result.add(new PermissionManagerDTO(maNhomQuyen, tenNhomQuyen, trangThai)); // create a new PermissionManagerDTO object from the data read from the current row and add it to the ArrayList
            }

            JDBCConnection.closeConection(con); // close the connection to the database

        } catch (SQLException ex) {
            ex.printStackTrace(); // print the stack trace to the console if an exception occurs
        }

        return result; // return the ArrayList of PermissionManagerDTO objects read from the database
    }

    @Override
    public PermissionManagerDTO selectById(PermissionManagerDTO t) {
        PermissionManagerDTO result = null; // initialize the result variable to null
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM `nhomquyen` WHERE `manhomquyen`=?"; // the SQL query to execute
            PreparedStatement pst = con.prepareStatement(sql); // create a prepared statement from the SQL query
            
            pst.setInt(1, t.getMaNhomQuyen()); // set the first parameter of the prepared statement to the value of t.getMaNhomQuyen()

            System.out.println("Select ID" + t.getMaNhomQuyen() + "Successfully!"); // print a message to the console

            ResultSet rs = pst.executeQuery(); // execute the prepared statement and store the result in a ResultSet

            if (rs.next()) { // if there is a record in the ResultSet (i.e., if the query returned a row)
                int maNhomQuyen = rs.getInt("manhomquyen"); // get the value of the manhomquyen column from the current row
                String tenNhomQuyen = rs.getString("tennhomquyen"); // get the value of the tennhomquyen column from the current row
                int trangThai = rs.getInt("trangthai"); // get the value of the trangthai column from the current row
                result = new PermissionManagerDTO(maNhomQuyen, tenNhomQuyen, trangThai); // create a new PermissionManagerDTO object from the data read from the current row and store it in the result variable
            }

            JDBCConnection.closeConection(con); // close the connection to the database
        
        } catch (SQLException ex) {
            ex.printStackTrace(); // print the stack trace to the console if an exception occurs
        }
        
        return result; // return the result to the caller
    }

    // TODO?Is there any condition to be added?
    @Override
    public ArrayList<PermissionManagerDTO> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
