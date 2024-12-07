<<<<<<< HEAD
package quan_ly_benh_vien.Data_Access_Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quan_ly_benh_vien.Model.bacSiModel;
import quan_ly_benh_vien.Model.DatLichKhamModel;
import quan_ly_benh_vien.Controller.ConnectDB;
import quan_ly_benh_vien.Model.BenhNhanKhamModel;
import quan_ly_benh_vien.Model.nguoiModel;

public class DatLichKhamDao implements DaoInterface<DatLichKhamModel> {

    private static DatLichKhamDao instance;

    public DatLichKhamDao() {

    }

    // Phương thức để lấy ra instance của DatLichKhamDao
    public static synchronized DatLichKhamDao getInstance() {
        if (instance == null) {
            instance = new DatLichKhamDao();
        }
        return instance;
    }

//    tìm tất cả bác sĩ thuộc chuyên khoa
    public ArrayList<bacSiModel> selectAllByChuyenKhoa(String chuyenKhoa) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<bacSiModel> list = new ArrayList<>();

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM bacsi where chuyenKhoa = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, chuyenKhoa);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                bacSiModel bacSi = new bacSiModel();
                bacSi.setMaBacSi(resultSet.getString("maBacSi"));
                bacSi.setHoVaTen(resultSet.getString("hoVaTen"));
                bacSi.setSoDienThoai(resultSet.getString("soDienThoai"));
                bacSi.setEmail(resultSet.getString("email"));
                bacSi.setDiachi(resultSet.getString("diaChi"));
                bacSi.setGioiTinh(resultSet.getString("gioiTinh"));
                bacSi.setChuyenKhoa(resultSet.getString("chuyenKhoa"));
                bacSi.setKinhNgiemLamViec(resultSet.getString("kinhNghiemLamViec"));
                bacSi.setHocVan(resultSet.getString("hocVan"));
                bacSi.setHinhAnh(resultSet.getString("hinhAnh"));

//                // Sử dụng System.out.println() để kiểm tra dữ liệu
//                System.out.println("Mã Bác Sĩ: " + bacSi.getMaBacSi());
//                System.out.println("Họ và Tên: " + bacSi.getHoVaTen());
//                System.out.println("Số Điện Thoại: " + bacSi.getSoDienThoai());
//                System.out.println("Email: " + bacSi.getEmail());
//                System.out.println("Địa Chỉ: " + bacSi.getDiachi());
//                System.out.println("Giới Tính: " + bacSi.getGioiTinh());
//                System.out.println("Chuyên Khoa: " + bacSi.getChuyenKhoa());
//                System.out.println("Kinh Nghiệm Làm Việc: " + bacSi.getKinhNghiemLamViec());
//                System.out.println("Học Vấn: " + bacSi.getHocVan());
//                System.out.println("Hình Ảnh: " + bacSi.getHinhAnh());
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

    @Override
    public int insert(DatLichKhamModel datLich) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectDB.getConnection();
            String insertQuery = "INSERT INTO lichkham  (MaDatLich, GiaDichVuKham, ThoiGianKham, DiaChiKham, TenDangNhap, trangThaiThanhToan, MaBacSi) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, datLich.getMaDatLich());
            preparedStatement.setFloat(2, datLich.getGiaDichVuKham());
            preparedStatement.setString(3, datLich.getThoiGioiKham());
            preparedStatement.setString(4, datLich.getDiaChiKham());
            preparedStatement.setString(5, datLich.getTenDangNhap());
            preparedStatement.setString(6, datLich.getTrangThaiThanhToan());
            preparedStatement.setString(7, datLich.getMaBacSi());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
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
    public int update(DatLichKhamModel t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDB.getConnection();

            // Chuẩn bị câu truy vấn SQL để xóa dữ liệu
            String sql = "DELETE FROM lichkham WHERE maDatLich = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Đặt tham số cho câu truy vấn SQL
            preparedStatement.setString(1, id);

            // Thực hiện xóa dữ liệu và lấy số dòng bị ảnh hưởng
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
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    lấy thông tin đặt lịch theo từng tên đăng nhập
    public ArrayList<DatLichKhamModel> selectAll2(String tenDangNhap) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<DatLichKhamModel> list = new ArrayList<>();

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT lichkham.*, bacsi.ChuyenKhoa "
                    + "FROM lichkham "
                    + "JOIN bacsi ON lichkham.maBacSi = bacsi.maBacSi "
                    + "WHERE lichkham.tenDangNhap = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenDangNhap);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DatLichKhamModel lichKhamModel = new DatLichKhamModel();
                lichKhamModel.setMaDatLich(resultSet.getString("maDatLich"));
                lichKhamModel.setGiaDichVuKham(resultSet.getFloat("giaDichVuKham"));
                lichKhamModel.setThoiGioiKham(resultSet.getString("thoiGianKham"));
                lichKhamModel.setDiaChiKham(resultSet.getString("diaChiKham"));
                lichKhamModel.setTenDangNhap(resultSet.getString("tenDangNhap"));
                lichKhamModel.setTrangThaiThanhToan(resultSet.getString("trangThaiThanhToan"));
                lichKhamModel.setMaBacSi(resultSet.getString("maBacSi"));
                lichKhamModel.setChuyenKhoa(resultSet.getString("ChuyenKhoa"));

                list.add(lichKhamModel);
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

    // Kiểm tra trùng lịch dựa trên thời gian khám
    public boolean kiemTraTrungLich(String selectedDate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM lichkham WHERE thoiGianKham = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, selectedDate);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Nếu resultSet có dữ liệu, có lịch trùng.
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Xử lý lỗi và trả về false nếu có lỗi
        } finally {
            // Đảm bảo đóng kết nối và tài nguyên
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Kiểm tra trùng chuyên khoa dựa trên lựa chọn chuyên khoa
    public boolean kiemTraTrungChuyenKhoa(String chuyenKhoa) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT lichkham.* FROM lichKham JOIN bacsi ON lichKham.maBacSi ="
                    + " bacsi.maBacSi WHERE bacsi.chuyenKhoa = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, chuyenKhoa);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    cập nhật trạng thái thanh toán
    public void updateTrangThaiThanhToan(List<String> maDatLichList) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectDB.getConnection();
            StringBuilder sql = new StringBuilder("UPDATE lichKham SET trangThaiThanhToan = 'Đã thanh toán' WHERE maDatLich IN (");

            // Tạo danh sách tham số "?" cho maDatLich
            for (int i = 0; i < maDatLichList.size(); i++) {
                sql.append("?");
                if (i < maDatLichList.size() - 1) {
                    sql.append(", ");
                }
            }
            sql.append(")");

            preparedStatement = connection.prepareStatement(sql.toString());

            // Đặt giá trị cho các tham số
            for (int i = 0; i < maDatLichList.size(); i++) {
                preparedStatement.setString(i + 1, maDatLichList.get(i));
            }

            preparedStatement.executeUpdate();
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
    }

    @Override
    public ArrayList<DatLichKhamModel> selectBy(String danhMuc, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DatLichKhamModel> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   public ArrayList<BenhNhanKhamModel> selectAll(String maBacSi) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet1 = null;  // Kết quả cho truy vấn 1
    ResultSet resultSet2 = null;  // Kết quả cho truy vấn 2
    ArrayList<BenhNhanKhamModel> list = new ArrayList<>();

    try {
        connection = ConnectDB.getConnection();

        // Truy vấn 1: Lấy thông tin từ bảng lichkham và taikhoan
        String sql1 = "SELECT lichkham.maDatLich, lichkham.thoiGianKham, taikhoan.hoVaTen, taikhoan.gioiTinh "
                + "FROM lichkham "
                + "JOIN taikhoan ON lichkham.tenDangNhap = taikhoan.tenDangNhap "
                + "WHERE lichkham.maBacSi = ? AND trangThaiThanhToan = 'Ðã thanh toán'";
        
        preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setString(1, maBacSi);
        resultSet1 = preparedStatement.executeQuery();

        // Truy vấn 2: Lấy thông tin từ bảng benhnhan
        String sql2 = "SELECT benhnhan.maBenhNhan, benhnhan.ngaySinh "
                + "FROM lichkham "
                + "JOIN benhnhan ON lichkham.tenDangNhap = benhnhan.tenDangNhap "
                + "WHERE lichkham.maBacSi = ? AND trangThaiThanhToan = 'Ðã thanh toán'";

        preparedStatement = connection.prepareStatement(sql2);
        preparedStatement.setString(1, maBacSi);
        resultSet2 = preparedStatement.executeQuery();

        // Duyệt qua kết quả từ resultSet1 và resultSet2
        while (resultSet1.next() && resultSet2.next()) {
            BenhNhanKhamModel benhNhanKham = new BenhNhanKhamModel();
            
            // Lấy thông tin từ resultSet1 (lichkham, taikhoan)
            benhNhanKham.setMaDatLich(resultSet1.getString("maDatLich"));
            benhNhanKham.setThoiGioiKham(resultSet1.getString("thoiGianKham"));
            benhNhanKham.setHoVaTen(resultSet1.getString("hoVaTen"));
            benhNhanKham.setGioiTinh(resultSet1.getString("gioiTinh"));

            // Lấy thông tin từ resultSet2 (benhnhan)
            benhNhanKham.setMaBenhnhan(resultSet2.getString("maBenhNhan"));
            benhNhanKham.setNgaySinh(resultSet2.getDate("ngaySinh"));

            // Thêm vào danh sách
            list.add(benhNhanKham);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Đảm bảo đóng kết nối và các tài nguyên
        ConnectDB.closeConnection(connection);
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (resultSet1 != null) resultSet1.close();
            if (resultSet2 != null) resultSet2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return list;
}


}
=======
package quan_ly_benh_vien.Data_Access_Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quan_ly_benh_vien.Model.bacSiModel;
import quan_ly_benh_vien.Model.DatLichKhamModel;
import quan_ly_benh_vien.Controller.ConnectDB;
import quan_ly_benh_vien.Model.nguoiModel;

public class DatLichKhamDao implements DaoInterface<DatLichKhamModel> {

    private static DatLichKhamDao instance;

    public DatLichKhamDao() {

    }

    // Phương thức để lấy ra instance của DatLichKhamDao
    public static synchronized DatLichKhamDao getInstance() {
        if (instance == null) {
            instance = new DatLichKhamDao();
        }
        return instance;
    }

//    tìm tất cả bác sĩ thuộc chuyên khoa
    public ArrayList<bacSiModel> selectAllByChuyenKhoa(String chuyenKhoa) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<bacSiModel> list = new ArrayList<>();

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM bacsi where chuyenKhoa = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, chuyenKhoa);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                bacSiModel bacSi = new bacSiModel();
                bacSi.setMaBacSi(resultSet.getString("maBacSi"));
                bacSi.setHoVaTen(resultSet.getString("hoVaTen"));
                bacSi.setSoDienThoai(resultSet.getString("soDienThoai"));
                bacSi.setEmail(resultSet.getString("email"));
                bacSi.setDiachi(resultSet.getString("diaChi"));
                bacSi.setGioiTinh(resultSet.getString("gioiTinh"));
                bacSi.setChuyenKhoa(resultSet.getString("chuyenKhoa"));
                bacSi.setKinhNgiemLamViec(resultSet.getString("kinhNghiemLamViec"));
                bacSi.setHocVan(resultSet.getString("hocVan"));
                bacSi.setHinhAnh(resultSet.getString("hinhAnh"));

//                // Sử dụng System.out.println() để kiểm tra dữ liệu
//                System.out.println("Mã Bác Sĩ: " + bacSi.getMaBacSi());
//                System.out.println("Họ và Tên: " + bacSi.getHoVaTen());
//                System.out.println("Số Điện Thoại: " + bacSi.getSoDienThoai());
//                System.out.println("Email: " + bacSi.getEmail());
//                System.out.println("Địa Chỉ: " + bacSi.getDiachi());
//                System.out.println("Giới Tính: " + bacSi.getGioiTinh());
//                System.out.println("Chuyên Khoa: " + bacSi.getChuyenKhoa());
//                System.out.println("Kinh Nghiệm Làm Việc: " + bacSi.getKinhNghiemLamViec());
//                System.out.println("Học Vấn: " + bacSi.getHocVan());
//                System.out.println("Hình Ảnh: " + bacSi.getHinhAnh());

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

    @Override
    public int insert(DatLichKhamModel datLich) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectDB.getConnection();
            String insertQuery = "INSERT INTO lichkham  (MaDatLich, GiaDichVuKham, ThoiGianKham, DiaChiKham, TenDangNhap, trangThaiThanhToan, MaBacSi) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, datLich.getMaDatLich());
            preparedStatement.setFloat(2, datLich.getGiaDichVuKham());
            preparedStatement.setString(3, datLich.getThoiGioiKham());
            preparedStatement.setString(4, datLich.getDiaChiKham());
            preparedStatement.setString(5, datLich.getTenDangNhap());
            preparedStatement.setString(6, datLich.getTrangThaiThanhToan());
            preparedStatement.setString(7, datLich.getMaBacSi());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
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
    public int update(DatLichKhamModel t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDB.getConnection();

            // Chuẩn bị câu truy vấn SQL để xóa dữ liệu
            String sql = "DELETE FROM lichkham WHERE maDatLich = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Đặt tham số cho câu truy vấn SQL
            preparedStatement.setString(1, id);

            // Thực hiện xóa dữ liệu và lấy số dòng bị ảnh hưởng
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
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DatLichKhamModel> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<DatLichKhamModel> list = new ArrayList<>();

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT lichkham.*, bacsi.ChuyenKhoa "
                    + "FROM lichkham "
                    + "JOIN bacsi ON lichkham.maBacSi = bacsi.maBacSi";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DatLichKhamModel lichKhamModel = new DatLichKhamModel();
                lichKhamModel.setMaDatLich(resultSet.getString("maDatLich"));
                lichKhamModel.setGiaDichVuKham(resultSet.getFloat("giaDichVuKham"));
                lichKhamModel.setThoiGioiKham(resultSet.getString("thoiGianKham"));
                lichKhamModel.setDiaChiKham(resultSet.getString("diaChiKham"));
                lichKhamModel.setTenDangNhap(resultSet.getString("tenDangNhap"));
                lichKhamModel.setMaBacSi(resultSet.getString("maBacSi"));
                lichKhamModel.setChuyenKhoa(resultSet.getString("ChuyenKhoa"));

                list.add(lichKhamModel);
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

//    lấy thông tin đặt lịch theo từng tên đăng nhập
    public ArrayList<DatLichKhamModel> selectAll2(String tenDangNhap) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<DatLichKhamModel> list = new ArrayList<>();

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT lichkham.*, bacsi.ChuyenKhoa "
                    + "FROM lichkham "
                    + "JOIN bacsi ON lichkham.maBacSi = bacsi.maBacSi "
                    + "WHERE lichkham.tenDangNhap = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenDangNhap);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DatLichKhamModel lichKhamModel = new DatLichKhamModel();
                lichKhamModel.setMaDatLich(resultSet.getString("maDatLich"));
                lichKhamModel.setGiaDichVuKham(resultSet.getFloat("giaDichVuKham"));
                lichKhamModel.setThoiGioiKham(resultSet.getString("thoiGianKham"));
                lichKhamModel.setDiaChiKham(resultSet.getString("diaChiKham"));
                lichKhamModel.setTenDangNhap(resultSet.getString("tenDangNhap"));
                lichKhamModel.setTrangThaiThanhToan(resultSet.getString("trangThaiThanhToan"));
                lichKhamModel.setMaBacSi(resultSet.getString("maBacSi"));
                lichKhamModel.setChuyenKhoa(resultSet.getString("ChuyenKhoa"));

                list.add(lichKhamModel);
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

    // Kiểm tra trùng lịch dựa trên thời gian khám
    public boolean kiemTraTrungLich(String selectedDate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM lichkham WHERE thoiGianKham = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, selectedDate);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Nếu resultSet có dữ liệu, có lịch trùng.
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Xử lý lỗi và trả về false nếu có lỗi
        } finally {
            // Đảm bảo đóng kết nối và tài nguyên
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Kiểm tra trùng chuyên khoa dựa trên lựa chọn chuyên khoa
    public boolean kiemTraTrungChuyenKhoa(String chuyenKhoa) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT lichkham.* FROM lichKham JOIN bacsi ON lichKham.maBacSi ="
                    + " bacsi.maBacSi WHERE bacsi.chuyenKhoa = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, chuyenKhoa);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    cập nhật trạng thái thanh toán
    public void updateTrangThaiThanhToan(List<String> maDatLichList) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectDB.getConnection();
            StringBuilder sql = new StringBuilder("UPDATE lichKham SET trangThaiThanhToan = 'Đã thanh toán' WHERE maDatLich IN (");

            // Tạo danh sách tham số "?" cho maDatLich
            for (int i = 0; i < maDatLichList.size(); i++) {
                sql.append("?");
                if (i < maDatLichList.size() - 1) {
                    sql.append(", ");
                }
            }
            sql.append(")");

            preparedStatement = connection.prepareStatement(sql.toString());

            // Đặt giá trị cho các tham số
            for (int i = 0; i < maDatLichList.size(); i++) {
                preparedStatement.setString(i + 1, maDatLichList.get(i));
            }

            preparedStatement.executeUpdate();
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
    }

    @Override
    public ArrayList<DatLichKhamModel> selectBy(String danhMuc, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
