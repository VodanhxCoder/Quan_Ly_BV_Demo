<<<<<<< HEAD
package quan_ly_benh_vien.Data_Access_Object;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import quan_ly_benh_vien.Model.*;
import quan_ly_benh_vien.Controller.*;
import quan_ly_benh_vien.Model.benhNhanModel;

public class QuanLyBenhNhanDAO implements DaoInterface<benhNhanModel> {

    private static QuanLyBenhNhanDAO instance;

    public QuanLyBenhNhanDAO() {

    }

    public static synchronized QuanLyBenhNhanDAO getInstance() {
        if (instance == null) {
            instance = new QuanLyBenhNhanDAO();
        }
        return instance;
    }

    //    kiểm tra mã bệnh nhân bị trùng // xem có bệnh nhân trong database ko 
    public boolean maBenhNhanTrung(String maBenhNhan) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String checkExistQuery = "SELECT * FROM benhnhan WHERE maBenhNhan=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, maBenhNhan);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
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

    @Override
    public int insert(benhNhanModel t) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;
        try {
            connection = ConnectDB.getConnection();

            String sql = "INSERT INTO benhnhan (hoVaTen, soDienThoai, email, ngaySinh, diaChi, GioiTinh, hinhAnh, tenDangNhap) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, t.getHoVaTen());
            preparedStatement.setString(2, t.getSoDienThoai());
            preparedStatement.setString(3, t.getEmail());

// Kiểm tra giá trị null của ngày sinh và chuyển đổi sang java.sql.Date nếu không null
            if (t.getNgaySinh() != null) {
                preparedStatement.setDate(4, new java.sql.Date(t.getNgaySinh().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            } else {
                preparedStatement.setNull(4, java.sql.Types.DATE);
            }

            preparedStatement.setString(5, t.getDiachi());
            preparedStatement.setString(6, t.getGioiTinh());
            preparedStatement.setString(7, t.getHinhAnh());
            preparedStatement.setString(8, t.getTenDangnhap());

// In thông tin chèn vào để kiểm tra
            System.out.println("Inserting Patient: " + ", " + t.getHoVaTen() + ", " + t.getSoDienThoai() + ", " + t.getEmail() + ", " + t.getDiachi() + ", " + t.getGioiTinh() + ", " + t.getHinhAnh() + ", " + t.getTenDangnhap());

            rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rowsAffected;
    }

    @Override
    public int update(benhNhanModel t, String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {

            java.util.Date ngaySinhUtil = t.getNgaySinh();

// Chuyển đổi từ java.util.Date sang java.sql.Date
            java.sql.Date ngaySinhSql = new java.sql.Date(ngaySinhUtil.getTime());

            String sql = "UPDATE benhnhan SET hoVaTen = ?, soDienThoai = ?, email = ?, ngaySinh = ?, diaChi = ?, GioiTinh = ?, hinhAnh = ? WHERE maBenhNhan = ?";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, t.getHoVaTen());
            preparedStatement.setString(2, t.getSoDienThoai());
            preparedStatement.setString(3, t.getEmail());
            preparedStatement.setDate(4, ngaySinhSql);  // Sử dụng ngày sinh kiểu java.sql.Date
            preparedStatement.setString(5, t.getDiachi());
            preparedStatement.setString(6, t.getGioiTinh());
            preparedStatement.setString(7, t.getHinhAnh());
            preparedStatement.setString(8, id);

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rowsAffected;
    }

    @Override
    public int deleteById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            connection = ConnectDB.getConnection();
            connection.setAutoCommit(false); // Tắt chế độ tự động commit
            String tenDangNhap = null; // Biến để lưu tenDangNhap của bệnh nhân

            //lấy tên đăng nhập để xóa trong tài khoản 
            String getTenDangNhapSql = "SELECT tenDangNhap FROM benhnhan WHERE maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(getTenDangNhapSql);
            preparedStatement.setString(1, id);
            ResultSet resultSet1 = preparedStatement.executeQuery();

            if (resultSet1.next()) {
                tenDangNhap = resultSet1.getString("tenDangNhap");
            }

            if (tenDangNhap == null) {
                System.out.println("Không tìm thấy bệnh nhân với mã " + id);
                return 0; // Dừng lại nếu không tìm thấy bệnh nhân
            }

            //  Xóa bệnh nhân từ bảng benhnhan
            String deleteBenhNhanSql = "DELETE FROM benhnhan WHERE maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(deleteBenhNhanSql);
            preparedStatement.setString(1, id);
            rowsAffected += preparedStatement.executeUpdate();

            // Xóa tài khoản của bệnh nhân từ bảng taikhoan
            String deleteTaiKhoanSql = "DELETE FROM taikhoan WHERE tenDangNhap = ?";
            preparedStatement = connection.prepareStatement(deleteTaiKhoanSql);
            preparedStatement.setString(1, tenDangNhap);
            rowsAffected += preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Đã xóa tài khoản của bệnh nhân có mã: " + id);
            }
            // Commit thay đổi nếu không có lỗi
            connection.commit();
        } catch (SQLException e) {
            // Rollback nếu có lỗi
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Mở lại chế độ tự động commit và đóng kết nối và tài nguyên
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowsAffected;
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<benhNhanModel> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<benhNhanModel> list = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM benhnhan";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                benhNhanModel benhNhan = new benhNhanModel();
                benhNhan.setMaBenhNhan(resultSet.getString("maBenhNhan"));
                benhNhan.setTenDangnhap(resultSet.getString("tenDangNhap"));
                benhNhan.setHoVaTen(resultSet.getString("hoVaTen"));
                benhNhan.setSoDienThoai(resultSet.getString("soDienThoai"));
                benhNhan.setEmail(resultSet.getString("email"));
                benhNhan.setNgaySinh(resultSet.getDate("ngaySinh"));
                benhNhan.setDiachi(resultSet.getString("diaChi"));
                benhNhan.setGioiTinh(resultSet.getString("gioiTinh"));
                benhNhan.setHinhAnh(resultSet.getString("hinhAnh"));
                list.add(benhNhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return list;
    }
//
//    public ArrayList<benhNhanModel> selectBenhNhanDuocBacSiKham(String id) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        ArrayList<benhNhanModel> list = new ArrayList<>();
//        try {
//            connection = ConnectDB.getConnection();
//            String sql = "SELECT * FROM benhnhan JOIN hosobenhnhan ON benhnhan.maBenhNhan = hosobenhnhan.maBenhNhan WHERE hosobenhnhan.maBacSi = ?";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, id);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                benhNhanModel benhNhan = new benhNhanModel();
//                benhNhan.setMaBenhNhan(resultSet.getString("maBenhNhan"));
//                benhNhan.setTenDangnhap(resultSet.getString("tenDangNhap"));
//                benhNhan.setHoVaTen(resultSet.getString("hoVaTen"));
//                benhNhan.setSoDienThoai(resultSet.getString("soDienThoai"));
//                benhNhan.setEmail(resultSet.getString("email"));
//                benhNhan.setNgaySinh(resultSet.getDate("ngaySinh"));
//                benhNhan.setDiachi(resultSet.getString("diaChi"));
//                benhNhan.setGioiTinh(resultSet.getString("gioiTinh"));
//                benhNhan.setHinhAnh(resultSet.getString("hinhAnh"));
//                list.add(benhNhan);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            ConnectDB.closeConnection(connection);
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return list;
//    }

    @Override
    public ArrayList<benhNhanModel> selectBy(String danhMuc, String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<benhNhanModel> list = new ArrayList<>();
        benhNhanModel benhNhan = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM benhnhan WHERE " + danhMuc + " = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                benhNhan = new benhNhanModel(
                        resultSet.getString("maBenhNhan"),
                        resultSet.getString("tenDangNhap"),
                        resultSet.getString("hoVaTen"),
                        resultSet.getString("soDienThoai"),
                        resultSet.getString("email"),
                        resultSet.getDate("ngaySinh"),
                        resultSet.getString("gioiTinh"),
                        resultSet.getString("diaChi"),
                        resultSet.getString("hinhAnh")
                );
                list.add(benhNhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return list;
    }
public String getIdBenhNhan(String tenDangNhap) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    String id = null;

    try {
        connection = ConnectDB.getConnection(); // Kết nối cơ sở dữ liệu

        // Truy vấn 
        String sql = "SELECT maBenhNhan FROM benhnhan WHERE tenDangNhap = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tenDangNhap);
        resultSet = preparedStatement.executeQuery();

     /// lấy id (maBenhNhan)
        if (resultSet.next()) {
            id = resultSet.getString("maBenhNhan");
        } else {
            return null; 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        
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

    return id; 
}

    public benhNhanModel layTTtaikhoan(String tenDangNhap) {
        benhNhanModel model = new benhNhanModel();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem tên đăng nhập có khớp với tài khoản đã đăng ký hay không
            String checkLoginQuery = "SELECT maBenhNhan, hoVaTen, soDienThoai, email,ngaySinh, diaChi, gioiTinh FROM benhnhan WHERE tenDangNhap=?";
            preparedStatement = connection.prepareStatement(checkLoginQuery);
            preparedStatement.setString(1, tenDangNhap);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Gán dữ liệu vào đối tượng model
                model.setMaBenhNhan(resultSet.getString("maBenhNhan"));
                model.setHoVaTen(resultSet.getString("hoVaTen"));
                model.setSoDienThoai(resultSet.getString("soDienThoai"));
                model.setEmail(resultSet.getString("email"));
                model.setNgaySinh(resultSet.getDate("ngaySinh"));
                model.setDiachi(resultSet.getString("diaChi"));
                model.setGioiTinh(resultSet.getString("gioiTinh"));
            } else {
                return null; // Tên đăng nhập không tồn tại trong cơ sở dữ liệu
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Xử lý lỗi nếu có
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

        return model;
    }

}
=======
package quan_ly_benh_vien.Data_Access_Object;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import quan_ly_benh_vien.Model.*;
import quan_ly_benh_vien.Controller.*;
import quan_ly_benh_vien.Model.benhNhanModel;

public class QuanLyBenhNhanDAO implements DaoInterface<benhNhanModel> {

    private static QuanLyBenhNhanDAO instance;

    public QuanLyBenhNhanDAO() {

    }

    public static synchronized QuanLyBenhNhanDAO getInstance() {
        if (instance == null) {
            instance = new QuanLyBenhNhanDAO();
        }
        return instance;
    }

    //    kiểm tra mã bệnh nhân bị trùng
    public boolean maBenhNhanTrung(String maBenhNhan) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String checkExistQuery = "SELECT * FROM benhnhan WHERE maBenhNhan=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, maBenhNhan);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
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

    @Override
    public int insert(benhNhanModel t) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;
        try {
            connection = ConnectDB.getConnection();

            String sql = "INSERT INTO benhnhan (hoVaTen, soDienThoai, email, ngaySinh, diaChi, GioiTinh, hinhAnh, tenDangNhap) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, t.getHoVaTen());
            preparedStatement.setString(2, t.getSoDienThoai());
            preparedStatement.setString(3, t.getEmail());

// Kiểm tra giá trị null của ngày sinh và chuyển đổi sang java.sql.Date nếu không null
            if (t.getNgaySinh() != null) {
                preparedStatement.setDate(4, new java.sql.Date(t.getNgaySinh().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            } else {
                preparedStatement.setNull(4, java.sql.Types.DATE);
            }

            preparedStatement.setString(5, t.getDiachi());
            preparedStatement.setString(6, t.getGioiTinh());
            preparedStatement.setString(7, t.getHinhAnh());
            preparedStatement.setString(8, t.getTenDangnhap());

// In thông tin chèn vào để kiểm tra
            System.out.println("Inserting Patient: " + ", " + t.getHoVaTen() + ", " + t.getSoDienThoai() + ", " + t.getEmail() + ", " + t.getDiachi() + ", " + t.getGioiTinh() + ", " + t.getHinhAnh() + ", " + t.getTenDangnhap());

            rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rowsAffected;
    }

    @Override
    public int update(benhNhanModel t, String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            
            java.util.Date ngaySinhUtil = t.getNgaySinh();

// Chuyển đổi từ java.util.Date sang java.sql.Date
            java.sql.Date ngaySinhSql = new java.sql.Date(ngaySinhUtil.getTime());

            String sql = "UPDATE benhnhan SET hoVaTen = ?, soDienThoai = ?, email = ?, ngaySinh = ?, diaChi = ?, GioiTinh = ?, hinhAnh = ? WHERE maBenhNhan = ?";
            connection = ConnectDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, t.getHoVaTen());
            preparedStatement.setString(2, t.getSoDienThoai());
            preparedStatement.setString(3, t.getEmail());
            preparedStatement.setDate(4, ngaySinhSql);  // Sử dụng ngày sinh kiểu java.sql.Date
            preparedStatement.setString(5, t.getDiachi());
            preparedStatement.setString(6, t.getGioiTinh());
            preparedStatement.setString(7, t.getHinhAnh());
            preparedStatement.setString(8, id);


           rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rowsAffected;
    }

    @Override
    public int deleteById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            connection = ConnectDB.getConnection();
            connection.setAutoCommit(false); // Tắt chế độ tự động commit
            String tenDangNhap = null; // Biến để lưu tenDangNhap của bệnh nhân

            //lấy tên đăng nhập để xóa trong tài khoản 
            String getTenDangNhapSql = "SELECT tenDangNhap FROM benhnhan WHERE maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(getTenDangNhapSql);
            preparedStatement.setString(1, id);
            ResultSet resultSet1 = preparedStatement.executeQuery();

            if (resultSet1.next()) {
                tenDangNhap = resultSet1.getString("tenDangNhap");
            }

            if (tenDangNhap == null) {
                System.out.println("Không tìm thấy bệnh nhân với mã " + id);
                return 0; // Dừng lại nếu không tìm thấy bệnh nhân
            }

            //  Xóa tất cả hồ sơ bệnh án của bệnh nhân
            String deleteHoSoSql = "DELETE FROM hosobenhnhan WHERE maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(deleteHoSoSql);
            preparedStatement.setString(1, id);
            rowsAffected = preparedStatement.executeUpdate();

            //  Xóa bệnh nhân từ bảng benhnhan
            String deleteBenhNhanSql = "DELETE FROM benhnhan WHERE maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(deleteBenhNhanSql);
            preparedStatement.setString(1, id);
            rowsAffected += preparedStatement.executeUpdate();

            //  Kiểm tra xem bệnh nhân có lịch khám hay không
            String checkLichKhamSql = "SELECT COUNT(*) FROM lichkham lk INNER JOIN benhnhan bn ON lk.tenDangNhap = bn.tenDangNhap WHERE bn.maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(checkLichKhamSql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() && resultSet.getInt(1) > 0) {
                // Bệnh nhân có lịch khám, tiến hành xóa
                String deleteLichKhamSql = "DELETE lk FROM lichkham lk INNER JOIN benhnhan bn ON lk.tenDangNhap = bn.tenDangNhap WHERE bn.maBenhNhan = ?";
                preparedStatement = connection.prepareStatement(deleteLichKhamSql);
                preparedStatement.setString(1, id);
                rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Đã xóa lịch khám của bệnh nhân có mã: " + id);
                }
            } else {
                System.out.println("Bệnh nhân không có lịch khám để xóa.");
            }
            // Bước 5: Xóa tài khoản của bệnh nhân từ bảng taikhoan
            String deleteTaiKhoanSql = "DELETE FROM taikhoan WHERE tenDangNhap = ?";
            preparedStatement = connection.prepareStatement(deleteTaiKhoanSql);
            preparedStatement.setString(1, tenDangNhap);
            rowsAffected += preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Đã xóa tài khoản của bệnh nhân có mã: " + id);
            }
            // Commit thay đổi nếu không có lỗi
            connection.commit();
        } catch (SQLException e) {
            // Rollback nếu có lỗi
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Mở lại chế độ tự động commit và đóng kết nối và tài nguyên
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowsAffected;
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<benhNhanModel> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<benhNhanModel> list = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM benhnhan";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                benhNhanModel benhNhan = new benhNhanModel();
                benhNhan.setMaBenhNhan(resultSet.getString("maBenhNhan"));
                benhNhan.setTenDangnhap(resultSet.getString("tenDangNhap"));
                benhNhan.setHoVaTen(resultSet.getString("hoVaTen"));
                benhNhan.setSoDienThoai(resultSet.getString("soDienThoai"));
                benhNhan.setEmail(resultSet.getString("email"));
                benhNhan.setNgaySinh(resultSet.getDate("ngaySinh"));
                benhNhan.setDiachi(resultSet.getString("diaChi"));
                benhNhan.setGioiTinh(resultSet.getString("gioiTinh"));
                benhNhan.setHinhAnh(resultSet.getString("hinhAnh"));
                list.add(benhNhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return list;
    }

    public ArrayList<benhNhanModel> selectBenhNhanDuocBacSiKham(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<benhNhanModel> list = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM benhnhan JOIN hosobenhnhan ON benhnhan.maBenhNhan = hosobenhnhan.maBenhNhan WHERE hosobenhnhan.maBacSi = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                benhNhanModel benhNhan = new benhNhanModel();
                benhNhan.setMaBenhNhan(resultSet.getString("maBenhNhan"));
                benhNhan.setTenDangnhap(resultSet.getString("tenDangNhap"));
                benhNhan.setHoVaTen(resultSet.getString("hoVaTen"));
                benhNhan.setSoDienThoai(resultSet.getString("soDienThoai"));
                benhNhan.setEmail(resultSet.getString("email"));
                benhNhan.setNgaySinh(resultSet.getDate("ngaySinh"));
                benhNhan.setDiachi(resultSet.getString("diaChi"));
                benhNhan.setGioiTinh(resultSet.getString("gioiTinh"));
                benhNhan.setHinhAnh(resultSet.getString("hinhAnh"));
                list.add(benhNhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return list;
    }

   // @Override
    public benhNhanModel selectById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // ArrayList<benhNhanModel> list = new ArrayList<>();
        benhNhanModel benhNhan = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM benhnhan WHERE maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                benhNhan = new benhNhanModel(
                        resultSet.getString("maBenhNhan"),
                        resultSet.getString("tenDangNhap"),
                        resultSet.getString("hoVaTen"),
                        resultSet.getString("soDienThoai"),
                        resultSet.getString("email"),
                        resultSet.getDate("ngaySinh"),
                        resultSet.getString("gioiTinh"),
                        resultSet.getString("diaChi"),
                        resultSet.getString("hinhAnh")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return benhNhan;
    }

    public benhNhanModel laytaikhoan(String tenDangNhap) {
        benhNhanModel model = new benhNhanModel();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem tên đăng nhập có khớp với tài khoản đã đăng ký hay không
            String checkLoginQuery = "SELECT hoVaTen, soDienThoai, email,ngaySinh, diaChi, gioiTinh FROM benhnhan WHERE tenDangNhap=?";
            preparedStatement = connection.prepareStatement(checkLoginQuery);
            preparedStatement.setString(1, tenDangNhap);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Gán dữ liệu vào đối tượng model
                model.setHoVaTen(resultSet.getString("hoVaTen"));
                model.setSoDienThoai(resultSet.getString("soDienThoai"));
                model.setEmail(resultSet.getString("email"));
                model.setNgaySinh(resultSet.getDate("ngaySinh"));
                model.setDiachi(resultSet.getString("diaChi"));
                model.setGioiTinh(resultSet.getString("gioiTinh"));
            } else {
                return null; // Tên đăng nhập không tồn tại trong cơ sở dữ liệu
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Xử lý lỗi nếu có
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

        return model;
    }

    @Override
    public ArrayList<benhNhanModel> selectBy(String danhMuc, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
