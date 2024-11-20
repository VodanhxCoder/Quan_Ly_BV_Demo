/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Data_Access_Object;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import quan_ly_benh_vien.Controller.ConnectDB;
import quan_ly_benh_vien.Model.QuanLyTaiKhoanModel;

/**
 *
 * @author khue1
 */
public class QuanLyTaiKhoanDao implements DaoInterface<QuanLyTaiKhoanModel> {

    //tạo đôi tuong Singleton để đảm bảo rằng chỉ có một instance
    private static QuanLyTaiKhoanDao instance;

    public QuanLyTaiKhoanDao() {
    }

    //Mã hóa thông tin khi đưa vào database 
    public static String MD5Encryptor(String srcText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //khởi tạo enrText lấy mã đầu cuối 
        String enrText;
        // Sử dụng lớp MessageDigest trong java.security để mã hóa 
        MessageDigest msd = MessageDigest.getInstance("MD5");
        //chuyển srcText thành mảng các byte với tham số UTF-8 để đocj đc chữ unicode 
        byte[] srcTextBytes = srcText.getBytes("UTF-8");
        byte[] enrTextBytes = msd.digest(srcTextBytes);
        BigInteger bigInt = new BigInteger(1, enrTextBytes);
        enrText = bigInt.toString(16);
        return enrText;
    }

    // Phương thức để lấy ra instance của QuanLyTaiKhoanDao
    //dung synchronized để tránh nhiều luồng truy cập cùng lucs
    public static synchronized QuanLyTaiKhoanDao getInstance() {
        if (instance == null) { //kiem tra xen có ai đang su dung ko 
            instance = new QuanLyTaiKhoanDao();
        }
        return instance;
    }
//    kiểm tra tài khoản bị trùng

    public boolean tenDangNhapDaTonTai(String tenDangNhap) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            connection = ConnectDB.getConnection();

            // Kiểm tra xem tên đăng nhập đã tồn tại chưa
            String checkExistQuery = "SELECT * FROM taikhoan WHERE tenDangNhap=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, tenDangNhap);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    kiểm tra email trùng
    public boolean kiemTraEmailTrung(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem email đã tồn tại chưa
            String checkExistQuery = "SELECT * FROM taikhoan WHERE email=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // Trả về true nếu email đã tồn tại, ngược lại trả về false
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //    đăng nhập
    public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem tên đăng nhập và mật khẩu có khớp với tài khoản đã đăng ký hay không
            String checkLoginQuery = "SELECT * FROM taikhoan WHERE tenDangNhap=? AND matKhau=?";
            preparedStatement = connection.prepareStatement(checkLoginQuery);
            preparedStatement.setString(1, tenDangNhap);
            preparedStatement.setString(2, matKhau);
            resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // Trả về true nếu đăng nhập thành công, ngược lại trả về false
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //----------------------------------------------------------
//    đổi mật khẩu
    public boolean doiMatKhau(String tenDangNhap, String matKhauCu, String matKhauMoi) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem tên đăng nhập và mật khẩu cũ có khớp với tài khoản đã đăng ký hay không
            String checkLoginQuery = "SELECT * FROM Taikhoan WHERE tenDangNhap=? AND matKhau=?";
            preparedStatement = connection.prepareStatement(checkLoginQuery);
            preparedStatement.setString(1, tenDangNhap);
            preparedStatement.setString(2, matKhauCu);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Tên đăng nhập và mật khẩu cũ đúng, cập nhật mật khẩu mới
                String updatePasswordQuery = "UPDATE TaiKhoan SET matKhau=? WHERE tenDangNhap=?";
                preparedStatement = connection.prepareStatement(updatePasswordQuery);
                preparedStatement.setString(1, matKhauMoi);
                preparedStatement.setString(2, tenDangNhap);
                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0; // Trả về true nếu cập nhật thành công, ngược lại trả về false
            } else {
                return false; // Tên đăng nhập hoặc mật khẩu cũ không khớp
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //----------------------------------------------------------
//    quên mật khẩu

    public String layMatKhauMoi(String tenDangNhap, String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem tên đăng nhập và email có khớp với tài khoản đã đăng ký hay không
            String checkLoginQuery = "SELECT matKhau FROM Taikhoan WHERE tenDangNhap=? AND email=?";
            preparedStatement = connection.prepareStatement(checkLoginQuery);
            preparedStatement.setString(1, tenDangNhap);
            preparedStatement.setString(2, email);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Tên đăng nhập và email đúng, trả về mật khẩu mới
                return resultSet.getString("matKhau");
            } else {
                return null; // Tên đăng nhập hoặc email không khớp
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //----------------------------------------------------------


    public int insertBenhNhan(QuanLyTaiKhoanModel t,boolean check) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDB.getConnection();
            // Chuẩn bị câu truy vấn SQL để chèn dữ liệu
            String sql = "INSERT INTO TaiKhoan (hoVaTen, tenDangNhap, matKhau, email, GioiTinh,typeUser) VALUES (?, ?, ?, ?, ?,?)";
            preparedStatement = connection.prepareStatement(sql);

            // Đặt các tham số cho câu truy vấn SQL từ đối tượng DangKy
            preparedStatement.setString(1, t.getHoVaTen());
            preparedStatement.setString(2, t.getTenDangNhap());
            preparedStatement.setString(3, t.getMatKhau());
            preparedStatement.setString(4, t.getEmail());
            preparedStatement.setString(5, t.getGioiTinh());
            preparedStatement.setString(6, "user");

            // Thực hiện chèn dữ liệu và lấy số dòng bị ảnh hưởng
            rowsAffected = preparedStatement.executeUpdate();

            // Nếu việc chèn tài khoản thành công, tiếp tục chèn dữ liệu vào bảng BenhNhan
            if (rowsAffected > 0&&!check) {
                String sqlBenhNhan = "INSERT INTO BenhNhan (hovaTen, gioiTinh, diaChi, soDienThoai, email, tenDangNhap) VALUES (?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sqlBenhNhan);

                // Đặt các tham số cho câu truy vấn SQL từ đối tượng DangKy
                preparedStatement.setString(1, t.getHoVaTen());  // Giả sử tên bệnh nhân là tên người đăng ký
                preparedStatement.setString(2, t.getGioiTinh());
                preparedStatement.setString(3, null);  // Giả sử bạn có địa chỉ từ form đăng ký
                preparedStatement.setString(4, null);  // Số điện thoại từ form đăng ký
                preparedStatement.setString(5, t.getEmail());  // Email từ form đăng ký
                preparedStatement.setString(6, t.getTenDangNhap());  // Lấy tên đăng nhập từ tài khoản đã đăng ký

                // Thực hiện chèn dữ liệu vào bảng BenhNhan
                rowsAffected = preparedStatement.executeUpdate();
            }

            // Kiểm tra số dòng bị ảnh hưởng và thông báo
            if (rowsAffected > 0) {
                System.out.println("Đăng ký và chèn dữ liệu thành công!");
            } else {
                System.out.println("Đăng ký thất bại!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi trong quá trình đăng ký hoặc thêm bệnh nhân.");
        } finally {
            // Đảm bảo đóng tài nguyên
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowsAffected;
    }

    public String ktraUser(String tenDangNhap) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectDB.getConnection();

            String checkLoginQuery = "SELECT typeUser FROM taikhoan WHERE tenDangNhap=?";
            preparedStatement = connection.prepareStatement(checkLoginQuery);
            preparedStatement.setString(1, tenDangNhap);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println(resultSet.getString("typeUser"));
                return resultSet.getString("typeUser");

            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public int update(QuanLyTaiKhoanModel t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<QuanLyTaiKhoanModel> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public QuanLyTaiKhoanModel selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(QuanLyTaiKhoanModel t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
