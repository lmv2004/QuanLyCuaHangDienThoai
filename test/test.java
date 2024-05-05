
import java.sql.Timestamp;
import javax.swing.*;

import DAO.JDBCConnection;

import java.awt.*;
import java.util.ArrayList;
import java.util.Base64;

public class test {
    public static void main(String[] args) {
        // Testing if connection to the db is working
//        JDBCConnection j = new JDBCConnection();
//        if (j.getJDBCConnection() != null) {
//            System.out.println("Database connected successfully!");
//            System.out.println("========================================");
//        } else {
//            System.out.println("Error connecting to the database!");
//            System.out.println("========================================");
//        }
//
//        // Phiếu Nhập Test
//        System.out.println("============ This is Phieunhap test ============");
        // DTO.PhieuNhapDTO pn = new DTO.PhieuNhapDTO(1, 76, 1,new
        // Timestamp(System.currentTimeMillis()), 12000,1);
        // DAO.PhieuNhapDAO pnd = new DAO.PhieuNhapDAO();
        // System.out.println(pnd.selecAll().toString());
        // System.out.println(pnd.selectById(110).toString());
        // System.out.println(new Timestamp(System.currentTimeMillis()));
        // System.out.println(" ccccVương van vo".contains("Vương"));

        // // Warranty Test
        // System.out.println("============ This is Warranty test ============");
        // DAO.WarrantyDAO wd = new DAO.WarrantyDAO();

        // System.out.println("Insert Test");
        // // DTO.WarrantyDTO W_Test_1 = new DTO.WarrantyDTO(2, 2, "Danh Tiến", "Hư Màn
        // // Hình", 1, null);
        // DTO.WarrantyDTO W_Test_2 = new DTO.WarrantyDTO(2, 3, "Danh Tiến", "Lỗ Cắm",
        // 0, null);
        // DTO.WarrantyDTO W_Test_3 = new DTO.WarrantyDTO(2, 4, "Danh Tiến", "Ko có cảm
        // ứng", 1, null);

        // // insert value into the `baohanh` table
        // // wd.insert(W_Test_1);
        // wd.insert(W_Test_2);
        // wd.insert(W_Test_3);
        // System.out.println(wd.selecAll().toString());

        // System.out.println("Delete Test");
        // wd.delete(W_Test_2);

        // System.out.println(wd.selecAll().toString());

        // // Permission Test
        // System.out.println("============ This is Permission test ============");
        // DAO.PermissionManagerDAO pd = new DAO.PermissionManagerDAO();

        // System.out.println("Insert Test");
        // DTO.PermissionManagerDTO P_Test_1 = new DTO.PermissionManagerDTO(11, "Danh
        // Tiến", 1);
        // pd.insert(P_Test_1);
        // System.out.println(pd.selecAll().toString());

        // System.out.println("Delete Test");
        // pd.delete(P_Test_1);
        // System.out.println(pd.selecAll().toString());

        // Account Test
//        System.out.println("============ This is Account test ============");
//        DAO.AccountDAO ad = new DAO.AccountDAO();
//        System.out.println("Insert Test");
//        DTO.AccountDTO A_Test_1 = new DTO.AccountDTO(6, "test", "test".toCharArray(), 1);
//        ad.insert(A_Test_1);
//
//        System.out.println(ad.selecAll().toString());

    }
}
