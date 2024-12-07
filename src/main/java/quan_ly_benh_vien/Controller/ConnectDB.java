<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author khue1
 */
public class ConnectDB {

    public ConnectDB() {
    }

    public static Connection getConnection() {
        //khoi tao doi tuong connect
        Connection conn = null;
        try {
            String userName = "sa";
            String password = "123456";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBV;encrypt=true;trustServerCertificate=true";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, userName, password);
            return conn;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver không được tìm thấy. Kết nối CSDL thất bại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến CSDL. Vui lòng kiểm tra URL, tên người dùng hoặc mật khẩu.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return conn; //th ko kn đc tự động trả về null
    }

    public static void closeConnection(Connection conn) {
        try {
            // neu đang có connect thì đóng connect lại 
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author khue1
 */
public class ConnectDB {

    public ConnectDB() {
    }

    public static Connection getConnection() {
        //khoi tao doi tuong connect
        Connection conn = null;
        try {
            String userName = "sa";
            String password = "123456";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBV;encrypt=true;trustServerCertificate=true";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, userName, password);
            return conn;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver không được tìm thấy. Kết nối CSDL thất bại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến CSDL. Vui lòng kiểm tra URL, tên người dùng hoặc mật khẩu.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return conn; //th ko kn đc tự động trả về null
    }

    public static void closeConnection(Connection conn) {
        try {
            // neu đang có connect thì đóng connect lại 
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
