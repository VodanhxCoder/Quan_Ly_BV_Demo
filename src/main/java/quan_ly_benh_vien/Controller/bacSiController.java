/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ConnectSQL.ConnectDatabase;
import ConnectSQL.bacSiConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.bacSiModel;

/**
 *
 * @author LAPTOP
 */

public class bacSiController {

    private bacSiConnect bacSiConnect = null;

    public bacSiController() {
        bacSiConnect = bacSiConnect.getInstance();
    }

    public int themBacSi(bacSiModel bacSi) {
        int rowsAffected = bacSiConnect.insert(bacSi);
        if (rowsAffected > 0) {
            System.out.println("Thêm bác sĩ thành công !");
        } else {
            System.out.println("Thêm bác sĩ thất bại !");
        }
        return rowsAffected;
    }

    public boolean kiemTraMaBacSiTrung(String maBacSi) {
        return bacSiConnect.maBacSiTrung(maBacSi);
    }

    public ArrayList<bacSiModel> layDanhSachBacSi() {
        return bacSiConnect.selectAll();
    }

    public int xoaBacSiTheoID(String id) {
        int rowsAffected = bacSiConnect.deleteById(id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

    public bacSiModel timBacSiTheoID(String id) {
        return bacSiConnect.selectById(id);
    }

    public int capNhatThongTinBacSi(bacSiModel bacSi, String id) {
        int rowsAffected = bacSiConnect.update(bacSi, id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }
    public ArrayList<bacSiModel> getAllBacSi() {
    ArrayList<bacSiModel> dsBS = new ArrayList<>();
    // Thực hiện truy vấn SQL để lấy danh sách bác sĩ
    Connection connection = ConnectDatabase.connectSQL();
    String sql = "SELECT * FROM BacSi"; // Thay thế bằng câu truy vấn của bạn
    try (PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            bacSiModel bacSi = new bacSiModel(
                rs.getString("maBacSi"),
                rs.getString("hoVaTen"),
                rs.getString("soDienThoai"),
                rs.getString("email"),
                rs.getString("diaChi"),
                rs.getString("gioiTinh"),
                rs.getString("chuyenKhoa"),
                rs.getString("kinhNgiemLamViec"),
                rs.getString("hocVan"),
                rs.getString("hinhAnh") // Nếu có
            );
            dsBS.add(bacSi);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return dsBS;
}
}

