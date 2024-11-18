package quan_ly_benh_vien.Data_Access_Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import quan_ly_benh_vien.Model.*;
import quan_ly_benh_vien.Controller.*;

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
            
            String sql = "INSERT INTO benhnhan (maBenhNhan, hoVaTen, soDienThoai, email, diaChi, GioiTinh, hinhAnh, tenDangNhap) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getMaBenhNhan());
            preparedStatement.setString(2, t.getHoVaTen());
            preparedStatement.setString(3, t.getSoDienThoai());
            preparedStatement.setString(4, t.getEmail());
            preparedStatement.setString(5, t.getDiachi());
            preparedStatement.setString(6, t.getGioiTinh());
            preparedStatement.setString(7, t.getHinhAnh());
            preparedStatement.setString(8, t.getTenDangnhap());
            System.out.println("Inserting Patient: " + t.getMaBenhNhan() + ", " + t.getHoVaTen() + ", " + t.getSoDienThoai() + ", " + t.getEmail() + ", " + t.getDiachi() + ", " + t.getGioiTinh() + ", " + t.getHinhAnh() + ", " + t.getTenDangnhap());

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
            connection = ConnectDB.getConnection();
            String sql = "UPDATE benhnhan SET maBenhNhan = ?, hoVaTen = ?, soDienThoai = ?, email = ?, diaChi = ?, GioiTinh = ?, hinhAnh = ?, tenDangNhap = ? WHERE maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getMaBenhNhan());
            preparedStatement.setString(2, t.getHoVaTen());
            preparedStatement.setString(3, t.getSoDienThoai());
            preparedStatement.setString(4, t.getEmail());
            preparedStatement.setString(5, t.getDiachi());
            preparedStatement.setString(6, t.getGioiTinh());
            preparedStatement.setString(7, t.getHinhAnh());
            preparedStatement.setString(8, t.getTenDangnhap());
            preparedStatement.setString(9, id);
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

            // Bước 1: Xóa tất cả hồ sơ bệnh án của bệnh nhân
            String deleteHoSoSql = "DELETE FROM hosobenhnhan WHERE maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(deleteHoSoSql);
            preparedStatement.setString(1, id);
            rowsAffected = preparedStatement.executeUpdate();

            // Bước 2: Xóa bệnh nhân từ bảng benhnhan
            String deleteBenhNhanSql = "DELETE FROM benhnhan WHERE maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(deleteBenhNhanSql);
            preparedStatement.setString(1, id);
            rowsAffected += preparedStatement.executeUpdate();

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

    @Override
    public benhNhanModel selectById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
         ArrayList<benhNhanModel> list = new ArrayList<>();
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

}
