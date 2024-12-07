package quan_ly_benh_vien.Data_Access_Object;

import quan_ly_benh_vien.Model.bacSiModel;
import quan_ly_benh_vien.Model.nguoiModel;
import quan_ly_benh_vien.Controller.ConnectDB;
import quan_ly_benh_vien.Data_Access_Object.DaoInterface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuanLyBacSiDAO implements DaoInterface<bacSiModel> {

    private static QuanLyBacSiDAO instance;

    public QuanLyBacSiDAO() {

    }

    // Phương thức để lấy ra instance của QuanLyTaiKhoanDao
    public static synchronized QuanLyBacSiDAO getInstance() {
        if (instance == null) {
            instance = new QuanLyBacSiDAO();
        }
        return instance;
    }

//    kiểm tra mã bác sĩ bị trùng
    public boolean KtraTrungLap(String thuocTinhKtra, String giaTriKtra) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem mã bác sĩ đã tồn tại chưa
            String checkExistQuery = "SELECT * FROM bacsi WHERE " + thuocTinhKtra + "=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, giaTriKtra);
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

    @Override
    public int insert(bacSiModel bacSi) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;
        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDB.getConnection();
            java.sql.Date sqlDate = null;
            // Kiểm tra nếu ngày không null
            if (bacSi.getNgaySinh() != null) {
                // Chuyển đổi từ java.util.Date sang java.sql.Date
                sqlDate = new java.sql.Date(bacSi.getNgaySinh().getTime());
                // Sử dụng sqlDate trong câu lệnh SQL
                System.out.println("Ngày đã chuyển đổi thành java.sql.Date: " + sqlDate);
            }

            // Chuẩn bị câu truy vấn SQL để chèn dữ liệu
            String sql = "INSERT INTO bacsi ( hoVaTen, soDienThoai, email,ngaySinh,diaChi, gioiTinh, chuyenKhoa, kinhNghiemLamViec, hocVan, hinhAnh,tenDangNhap) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Đặt các tham số cho câu truy vấn SQL từ đối tượng BacSiModel
            preparedStatement.setString(1, bacSi.getHoVaTen());
            preparedStatement.setString(2, bacSi.getSoDienThoai());
            preparedStatement.setString(3, bacSi.getEmail());
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setString(5, bacSi.getDiachi());
            preparedStatement.setString(6, bacSi.getGioiTinh());
            preparedStatement.setString(7, bacSi.getChuyenKhoa());
            preparedStatement.setString(8, bacSi.getKinhNghiemLamViec());
            preparedStatement.setString(9, bacSi.getHocVan());
            preparedStatement.setString(10, bacSi.getHinhAnh());
            preparedStatement.setString(11, bacSi.getTenDangNhap());

            // Thực hiện chèn dữ liệu và lấy số dòng bị ảnh hưởng
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
    public int update(bacSiModel bacSi, String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDB.getConnection();

            connection = ConnectDB.getConnection();
            java.sql.Date sqlDate = null;
            // Kiểm tra nếu ngày không null
            if (bacSi.getNgaySinh() != null) {
                // Chuyển đổi từ java.util.Date sang java.sql.Date
                sqlDate = new java.sql.Date(bacSi.getNgaySinh().getTime());
                // Sử dụng sqlDate trong câu lệnh SQL
                System.out.println("Ngày đã chuyển đổi thành java.sql.Date: " + sqlDate);
            }

            // Chuẩn bị câu truy vấn SQL để cập nhật dữ liệu
            String sql = "UPDATE bacsi SET  hoVaTen = ?, soDienThoai = ?, email = ?,ngaySinh=?, diaChi = ?, gioiTinh = ?, chuyenKhoa = ?, kinhNghiemLamViec = ?, hocVan = ?, hinhAnh = ? WHERE maBacSi = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Đặt các tham số cho câu truy vấn SQL từ đối tượng T
            preparedStatement.setString(1, bacSi.getHoVaTen());
            preparedStatement.setString(2, bacSi.getSoDienThoai());
            preparedStatement.setString(3, bacSi.getEmail());
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setString(5, bacSi.getDiachi());
            preparedStatement.setString(6, bacSi.getGioiTinh());
            preparedStatement.setString(7, bacSi.getChuyenKhoa());
            preparedStatement.setString(8, bacSi.getKinhNghiemLamViec());
            preparedStatement.setString(9, bacSi.getHocVan());
            preparedStatement.setString(10, bacSi.getHinhAnh());

            // Đặt tham số cho WHERE clause (maBacSi)
            preparedStatement.setString(11, id);

            // Thực hiện cập nhật dữ liệu và lấy số dòng bị ảnh hưởng
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
    
    
    public int updateBacSiCoBan(bacSiModel bacSi, String id) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    int rowsAffected = 0;

    try {
   
        connection = ConnectDB.getConnection();

        java.sql.Date sqlDate = null;
        if (bacSi.getNgaySinh() != null) {
            sqlDate = new java.sql.Date(bacSi.getNgaySinh().getTime());
        }

        
        String sql = "UPDATE bacsi SET hoVaTen = ?, soDienThoai = ?, email = ?, ngaySinh = ?, diaChi = ?, gioiTinh = ?, hinhAnh = ? WHERE maBacSi = ?";
        preparedStatement = connection.prepareStatement(sql);

    
        preparedStatement.setString(1, bacSi.getHoVaTen());
        preparedStatement.setString(2, bacSi.getSoDienThoai());
        preparedStatement.setString(3, bacSi.getEmail());
        preparedStatement.setDate(4, sqlDate);
        preparedStatement.setString(5, bacSi.getDiachi());
        preparedStatement.setString(6, bacSi.getGioiTinh());
        preparedStatement.setString(7, bacSi.getHinhAnh());

        
        preparedStatement.setString(8, id);

    
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
    public int deleteById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            connection = ConnectDB.getConnection();
            connection.setAutoCommit(false);
            //tự động xóa các trg liên quan 
            String deleteBacSiSql = "DELETE FROM bacsi WHERE maBacSi = ?";
            preparedStatement = connection.prepareStatement(deleteBacSiSql);
            preparedStatement.setString(1, id);
            rowsAffected += preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
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

    @Override //Chưa dùng
    public void deleteAll() {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            // Lấy kết nối tới cơ sở dữ liệu
//            connection = ConnectDB.getConnection();
//
//            // Chuẩn bị câu truy vấn SQL để xóa tất cả dữ liệu
//            String sql = "DELETE FROM bacsi";
//            preparedStatement = connection.prepareStatement(sql);
//
//            // Thực hiện xóa dữ liệu
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // Đóng kết nối và tài nguyên
//            ConnectDB.closeConnection(connection);
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    @Override
    public ArrayList<bacSiModel> selectAll() {
        ArrayList<bacSiModel> dsBS = new ArrayList<>();

        // Tạo câu lệnh SQL cụ thể
        String sql = "SELECT * FROM bacsi";

        // Sử dụng try-with-resources để tự động đóng tài nguyên
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            if (connection == null) {
                System.err.println("Kết nối cơ sở dữ liệu thất bại.");
                return dsBS; // Trả về danh sách rỗng
            }

            // Duyệt qua từng dòng dữ liệu
            while (rs.next()) {
                // Tạo đối tượng bacSiModel
                bacSiModel bacSi = new bacSiModel(
                        rs.getString("maBacSi"),
                        rs.getString("hoVaTen"),
                        rs.getString("soDienThoai"),
                        rs.getString("email"),
                        rs.getDate("ngaySinh"),
                        rs.getString("diaChi"),
                        rs.getString("gioiTinh"),
                        rs.getString("chuyenKhoa"),
                        rs.getString("kinhNghiemLamViec"),
                        rs.getString("hocvan"),
                        rs.getString("hinhAnh")
                );

                // Thêm vào danh sách
                dsBS.add(bacSi);
            }
        } catch (Exception e) {
            // In log chi tiết nếu gặp lỗi
            System.err.println("Lỗi khi truy vấn dữ liệu từ bảng bacsi: " + e.getMessage());
            e.printStackTrace();
        }

        return dsBS; // Trả về danh sách bác sĩ
    }

    @Override
    public ArrayList<bacSiModel> selectBy(String danhMuc, String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<bacSiModel> list = new ArrayList<>();
        bacSiModel bacSi = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM bacsi WHERE " + danhMuc + " = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                bacSi = new bacSiModel(
                        resultSet.getString("maBacSi"),
                        resultSet.getString("hoVaTen"),
                        resultSet.getString("soDienThoai"),
                        resultSet.getString("email"),
                        resultSet.getDate("ngaySinh"),
                        resultSet.getString("diaChi"),
                        resultSet.getString("gioiTinh"),
                        resultSet.getString("chuyenKhoa"),
                        resultSet.getString("kinhNghiemLamViec"),
                        resultSet.getString("hocVan"),
                        resultSet.getString("hinhAnh")
                );
                list.add(bacSi);
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

    public String getid(String tenDangNhap) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String id = null;
        bacSiModel bacSi = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT maBacSi FROM bacsi WHERE tenDangNhap = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenDangNhap);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getString("maBacSi");
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

    public bacSiModel layTTTaiKhoan(String tenDangNhap) {
        bacSiModel model = new bacSiModel(); // Đổi sang model của bác sĩ
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem tên đăng nhập có khớp với tài khoản bác sĩ đã đăng ký hay không
            String checkLoginQuery = "SELECT maBacSi, hoVaTen, soDienThoai, email, ngaySinh, diaChi, gioiTinh FROM bacsi WHERE tenDangNhap=?";
            preparedStatement = connection.prepareStatement(checkLoginQuery);
            preparedStatement.setString(1, tenDangNhap);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Gán dữ liệu vào đối tượng model
                model.setMaBacSi(resultSet.getString("maBacSi"));
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
