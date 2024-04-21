
import java.sql.Timestamp;
import javax.swing.*;

import DAO.JDBCConnection;

import java.awt.*;
import java.util.Base64;

public class test {
    public static void main(String[] args) {
        // Testing if connection to the db is working
        JDBCConnection j = new JDBCConnection();
        if (j.getJDBCConnection() != null) {
            System.out.println("Database connected successfully!");
            System.out.println("========================================");
        } else {
            System.out.println("Error connecting to the database!");
            System.out.println("========================================");
        }

        // Phiếu Nhập Test
        System.out.println("============ This is Phieunhap test ============");
        // DTO.PhieuNhapDTO pn = new DTO.PhieuNhapDTO(1, 76, 1,new
        // Timestamp(System.currentTimeMillis()), 12000,1);
        DAO.PhieuNhapDAO pnd = new DAO.PhieuNhapDAO();
        System.out.println(pnd.selecAll().toString());
        // System.out.println(pnd.selectById(110).toString());
        // System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println("   ccccVương van vo".contains("Vương"));

        // Warranty Test
        System.out.println("============ This is Warranty test ============");
        DAO.WarrantyDAO wd = new DAO.WarrantyDAO();
        System.out.println(wd.selecAll().toString());
    }
}
