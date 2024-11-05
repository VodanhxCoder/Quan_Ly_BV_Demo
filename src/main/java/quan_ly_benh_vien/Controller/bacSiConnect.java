/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectSQL;

import model.*;
import ConnectSQL.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LAPTOP
 */



public class bacSiConnect implements InterfaceConnect<bacSiModel> {

    private static bacSiConnect instance;

    public bacSiConnect() {

    }

    // Phương thức để lấy ra instance của QuanLyTaiKhoanDao
    public static synchronized bacSiConnect getInstance() {
        if (instance == null) {
            instance = new bacSiConnect();
        }
        return instance;
    }



//    kiểm tra mã bác sĩ bị trùng
    public boolean maBacSiTrung(String maBacSi) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDatabase.connectSQL();

            // Kiểm tra xem mã bác sĩ đã tồn tại chưa
            String checkExistQuery = "SELECT * FROM bacsi WHERE maBacSi=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, maBacSi);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDatabase.closeConnection(connection);
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
            connection = ConnectDatabase.connectSQL();

            // Chuẩn bị câu truy vấn SQL để chèn dữ liệu
            String sql = "INSERT INTO bacsi (maBacSi, hoVaTen, soDienThoai, email, dichvu, gioiTinh, chuyenKhoa, kinhNghiemLamViec, hocVan, hinhAnh,diaChi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Đặt các tham số cho câu truy vấn SQL từ đối tượng BacSiModel
            preparedStatement.setString(1, bacSi.getMaBacSi());
            preparedStatement.setString(2, bacSi.getHoVaTen());
            preparedStatement.setString(3, bacSi.getSoDienThoai());
            preparedStatement.setString(4, bacSi.getEmail());
            preparedStatement.setString(5, bacSi.getDiachi());
            preparedStatement.setString(6, bacSi.getGioiTinh());
            preparedStatement.setString(7, bacSi.getChuyenKhoa());
            preparedStatement.setString(8, bacSi.getKinhNgiemLamViec());
            preparedStatement.setString(9, bacSi.getHocVan());
            preparedStatement.setString(10, bacSi.getHinhAnh());
            preparedStatement.setString(11, bacSi.getDiachi());
            

            // Thực hiện chèn dữ liệu và lấy số dòng bị ảnh hưởng
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            ConnectDatabase.closeConnection(connection);
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
            connection = ConnectDatabase.connectSQL();

            // Chuẩn bị câu truy vấn SQL để cập nhật dữ liệu
            String sql = "UPDATE bacsi SET maBacSi = ?, hoVaTen = ?, soDienThoai = ?, email = ?, diaChi = ?, gioiTinh = ?, chuyenKhoa = ?, kinhNghiemLamViec = ?, hocVan = ?, hinhAnh = ? WHERE maBacSi = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Đặt các tham số cho câu truy vấn SQL từ đối tượng T
            preparedStatement.setString(1, bacSi.getMaBacSi());
            preparedStatement.setString(2, bacSi.getHoVaTen());
            preparedStatement.setString(3, bacSi.getSoDienThoai());
            preparedStatement.setString(4, bacSi.getEmail());
            preparedStatement.setString(5, bacSi.getDiachi());
            preparedStatement.setString(6, bacSi.getGioiTinh());
            preparedStatement.setString(7, bacSi.getChuyenKhoa());
            preparedStatement.setString(8, bacSi.getKinhNgiemLamViec());
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
            ConnectDatabase.closeConnection(connection);
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
            connection = ConnectDatabase.connectSQL();
            connection.setAutoCommit(false);

//            // Bước 1: Xóa tất cả hồ sơ bệnh án của bệnh nhân liên quan đến bác sĩ
//            String deleteHoSoBenhAnSql = "DELETE FROM hosobenhan WHERE maBacSi = ?";
//            preparedStatement = connection.prepareStatement(deleteHoSoBenhAnSql);
//            preparedStatement.setString(1, id);
//            rowsAffected = preparedStatement.executeUpdate();
//
//            // Bước 2: Xóa tất cả lịch khám của bệnh nhân liên quan đến bác sĩ
//            String deleteLichKhamSql = "DELETE FROM lichKham WHERE maBacSi = ?";
//            preparedStatement = connection.prepareStatement(deleteLichKhamSql);
//            preparedStatement.setString(1, id);
//            rowsAffected += preparedStatement.executeUpdate();
//
//            // Bước 3: Xóa tất cả bệnh nhân liên quan đến bác sĩ
//            String deleteBenhNhanSql = "DELETE FROM benhnhan WHERE tenDangNhap IN (SELECT DISTINCT tenDangNhap FROM lichKham WHERE maBacSi = ?)";
//            preparedStatement = connection.prepareStatement(deleteBenhNhanSql);
//            preparedStatement.setString(1, id);
//            rowsAffected += preparedStatement.executeUpdate();

            // Bước 4: Xóa bác sĩ từ bảng bacsi
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

    @Override
    public void deleteAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDatabase.connectSQL();

            // Chuẩn bị câu truy vấn SQL để xóa tất cả dữ liệu
            String sql = "DELETE FROM bacsi";
            preparedStatement = connection.prepareStatement(sql);

            // Thực hiện xóa dữ liệu
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            ConnectDatabase.closeConnection(connection);
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
    public ArrayList<bacSiModel> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<bacSiModel> list = new ArrayList<>();

        try {
            connection = ConnectDatabase.connectSQL();
            String sql = "SELECT * FROM bacsi";
            preparedStatement = connection.prepareStatement(sql);
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

                list.add(bacSi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDatabase.closeConnection(connection);
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
    public bacSiModel selectById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        bacSiModel bacSi = null;

        try {
            connection = ConnectDatabase.connectSQL();
            String sql = "SELECT * FROM bacsi WHERE maBacSi = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                bacSi = new bacSiModel(
                        resultSet.getString("maBacSi"),
                        resultSet.getString("hoVaTen"),
                        resultSet.getString("soDienThoai"),
                        resultSet.getString("email"),
                        resultSet.getString("gioiTinh"),
                        resultSet.getString("diaChi"),
                        resultSet.getString("chuyenKhoa"),
                        resultSet.getString("kinhNghiemLamViec"),
                        resultSet.getString("hocVan"),
                        resultSet.getString("hinhAnh")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDatabase.closeConnection(connection);
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

        return bacSi;
    }

}
