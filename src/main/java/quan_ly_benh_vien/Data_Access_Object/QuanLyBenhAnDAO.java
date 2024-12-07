<<<<<<< HEAD
package quan_ly_benh_vien.Data_Access_Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import quan_ly_benh_vien.Model.*;
import quan_ly_benh_vien.Controller.*;

public class QuanLyBenhAnDAO implements DaoInterface<hosoBenhAnModel> {

    private static QuanLyBenhAnDAO instance;

    public QuanLyBenhAnDAO() {

    }

    public static synchronized QuanLyBenhAnDAO getInstance() {
        if (instance == null) {
            instance = new QuanLyBenhAnDAO();
        }
        return instance;
    }

    //    kiểm tra mã bệnh nhân bị trùng
    public boolean maHoSoTrung(String maHoSo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String checkExistQuery = "SELECT * FROM hosobenhnhan WHERE maHoSo=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, maHoSo);
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
    public int insert(hosoBenhAnModel t) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO hosobenhnhan (tienSuBenhAn, trieuChung, chuanDoan, ketLuan, maBenhNhan, maBacSi) VALUES ( ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, t.getTienSuBenhAn());
            preparedStatement.setString(2, t.getTrieuChung());
            preparedStatement.setString(3, t.getChuanDoan());
            preparedStatement.setString(4, t.getKetLuan());
            preparedStatement.setString(5, t.getMaBenhNhan());
            preparedStatement.setString(6, t.getMaBacSi());
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
    public int update(hosoBenhAnModel t, String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE hosobenhnhan SET  tienSuBenhAn = ?, trieuChung = ?, chuanDoan = ?, ketLuan = ?, maBenhNhan = ?, maBacSi = ? WHERE maHoSo = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getTienSuBenhAn());
            preparedStatement.setString(2, t.getTrieuChung());
            preparedStatement.setString(3, t.getChuanDoan());
            preparedStatement.setString(4, t.getKetLuan());
            preparedStatement.setString(5, t.getMaBenhNhan());
            preparedStatement.setString(6, t.getMaBacSi());
            preparedStatement.setString(7, id);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Xem xét xử lý lỗi chi tiết hơn ở đây
        } finally {
            // Đóng kết nối và tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Xem xét xử lý lỗi chi tiết hơn ở đây
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
            String sql = "DELETE FROM hosobenhnhan WHERE maHoSo = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
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
    public ArrayList<hosoBenhAnModel> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<hosoBenhAnModel> list = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM hosobenhnhan";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                hosoBenhAnModel HoSoBenhAnModel = new hosoBenhAnModel();
                HoSoBenhAnModel.setMaHoSo(resultSet.getString("maHoSo"));
                HoSoBenhAnModel.setMaBacSi(resultSet.getString("maBacSi"));
                HoSoBenhAnModel.setMaBenhNhan(resultSet.getString("maBenhNhan"));
                HoSoBenhAnModel.setTrieuChung(resultSet.getString("trieuChung"));
                HoSoBenhAnModel.setTienSuBenhAn(resultSet.getString("tienSuBenhAn"));
                HoSoBenhAnModel.setChuanDoan(resultSet.getString("chuanDoan"));
                HoSoBenhAnModel.setKetLuan(resultSet.getString("ketLuan"));
                list.add(HoSoBenhAnModel);
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

    public ArrayList<hosoBenhAnModel> selectHoSoBenhAn(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<hosoBenhAnModel> list = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM hosobenhnhan where maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                hosoBenhAnModel HoSoBenhAnModel = new hosoBenhAnModel();
                HoSoBenhAnModel.setMaHoSo(resultSet.getString("maHoSo"));
                HoSoBenhAnModel.setMaBacSi(resultSet.getString("maBacSi"));
                HoSoBenhAnModel.setMaBenhNhan(resultSet.getString("maBenhNhan"));
                HoSoBenhAnModel.setTrieuChung(resultSet.getString("trieuChung"));
                HoSoBenhAnModel.setTienSuBenhAn(resultSet.getString("tienSuBenhAn"));
                HoSoBenhAnModel.setChuanDoan(resultSet.getString("chuanDoan"));
                HoSoBenhAnModel.setKetLuan(resultSet.getString("ketLuan"));
                list.add(HoSoBenhAnModel);
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
    public ArrayList<hosoBenhAnModel> selectBy(String danhMuc, String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        hosoBenhAnModel hoSo = null;
        ArrayList<hosoBenhAnModel> list =new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM hosobenhnhan WHERE " + danhMuc + " = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                hoSo = new hosoBenhAnModel(
                        resultSet.getString("maHoSo"),
                        resultSet.getString("maBacSi"),
                        resultSet.getString("maBenhNhan"),
                        resultSet.getString("trieuChung"),
                        resultSet.getString("tienSuBenhAn"),
                        resultSet.getString("chuanDoan"),
                        resultSet.getString("ketLuan")
                );
                list.add(hoSo);
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

    

}
=======
package quan_ly_benh_vien.Data_Access_Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import quan_ly_benh_vien.Model.*;
import quan_ly_benh_vien.Controller.*;


public class QuanLyBenhAnDAO implements DaoInterface<hosoBenhAnModel> {

    private static QuanLyBenhAnDAO instance;

    public QuanLyBenhAnDAO() {

    }

    public static synchronized QuanLyBenhAnDAO getInstance() {
        if (instance == null) {
            instance = new QuanLyBenhAnDAO();
        }
        return instance;
    }

    //    kiểm tra mã bệnh nhân bị trùng
    public boolean maHoSoTrung(String maHoSo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String checkExistQuery = "SELECT * FROM hosobenhnhan WHERE maHoSo=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, maHoSo);
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
    public int insert(hosoBenhAnModel t) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO hosobenhnhan ( tienSuBenhAn, trieuChung, chuanDoan, ketLuan, maBenhNhan, maBacSi) VALUES ( ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
         
            preparedStatement.setString(1, t.getTienSuBenhAn());
            preparedStatement.setString(2, t.getTrieuChung());
            preparedStatement.setString(3, t.getChuanDoan());
            preparedStatement.setString(4, t.getKetLuan());
            preparedStatement.setString(5, t.getMaBenhNhan());
            preparedStatement.setString(6, t.getMaBacSi());
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
    public int update(hosoBenhAnModel t, String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE hosobenhnhan SET  tienSuBenhAn = ?, trieuChung = ?, chuanDoan = ?, ketLuan = ?, maBenhNhan = ?, maBacSi = ? WHERE maHoSo = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getTienSuBenhAn());
            preparedStatement.setString(2, t.getTrieuChung());
            preparedStatement.setString(3, t.getChuanDoan());
            preparedStatement.setString(4, t.getKetLuan());
            preparedStatement.setString(5, t.getMaBenhNhan());
            preparedStatement.setString(6, t.getMaBacSi());
            preparedStatement.setString(7, id);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Xem xét xử lý lỗi chi tiết hơn ở đây
        } finally {
            // Đóng kết nối và tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Xem xét xử lý lỗi chi tiết hơn ở đây
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
            String sql = "DELETE FROM hosobenhnhan WHERE maHoSo = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
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
    public ArrayList<hosoBenhAnModel> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<hosoBenhAnModel> list = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM hosobenhnhan";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                hosoBenhAnModel HoSoBenhAnModel = new hosoBenhAnModel();
                HoSoBenhAnModel.setMaHoSo(resultSet.getString("maHoSo"));
                HoSoBenhAnModel.setMaBacSi(resultSet.getString("maBacSi"));
                HoSoBenhAnModel.setMaBenhNhan(resultSet.getString("maBenhNhan"));
                HoSoBenhAnModel.setTrieuChung(resultSet.getString("trieuChung"));
                HoSoBenhAnModel.setTienSuBenhAn(resultSet.getString("tienSuBenhAn"));
                HoSoBenhAnModel.setChuanDoan(resultSet.getString("chuanDoan"));
                HoSoBenhAnModel.setKetLuan(resultSet.getString("ketLuan"));
                list.add(HoSoBenhAnModel);
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

    public ArrayList<hosoBenhAnModel> selectHoSoBenhAn(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<hosoBenhAnModel> list = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM hosobenhnhan where maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                hosoBenhAnModel HoSoBenhAnModel = new hosoBenhAnModel();
                HoSoBenhAnModel.setMaHoSo(resultSet.getString("maHoSo"));
                HoSoBenhAnModel.setMaBacSi(resultSet.getString("maBacSi"));
                HoSoBenhAnModel.setMaBenhNhan(resultSet.getString("maBenhNhan"));
                HoSoBenhAnModel.setTrieuChung(resultSet.getString("trieuChung"));
                HoSoBenhAnModel.setTienSuBenhAn(resultSet.getString("tienSuBenhAn"));
                HoSoBenhAnModel.setChuanDoan(resultSet.getString("chuanDoan"));
                HoSoBenhAnModel.setKetLuan(resultSet.getString("ketLuan"));
                list.add(HoSoBenhAnModel);
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

//    @Override
    public hosoBenhAnModel selectById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        hosoBenhAnModel hoSo = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM hosobenhnhan WHERE maHoSo = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                hoSo = new hosoBenhAnModel(
                        resultSet.getString("maHoSo"),
                        resultSet.getString("maBacSi"),
                        resultSet.getString("maBenhNhan"),
                        resultSet.getString("trieuChung"),
                        resultSet.getString("tienSuBenhAn"),
                        resultSet.getString("chuanDoan"),
                        resultSet.getString("ketLuan")
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

        return hoSo;
    }

    @Override
    public ArrayList<hosoBenhAnModel> selectBy(String danhMuc, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
