package DAO;

import java.sql.*;

public class JBDCConnection {
    
    private final static String url = "jdbc:mysql://localhost:3306/QuanLyCuaHangDienThoai";
    private final static String user = "root";
    private final static String password = "vuongledz123";
    
    public static Connection getJDBCConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
  public static void closeConection(Connection c) {
		try {
			if(c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection cn = getJDBCConnection();
        if(cn!=null) {
            System.out.println("Thanh cong");
        }
        else {
            System.out.println("That bai");
        }
    }
}
