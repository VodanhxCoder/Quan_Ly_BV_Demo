
package quan_ly_benh_vien.Controller;

import quan_ly_benh_vien.Controller.ConnectDB;
import quan_ly_benh_vien.Data_Access_Object.QuanLyBacSiDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import quan_ly_benh_vien.Model.bacSiModel;


public class bacSiController {

    private QuanLyBacSiDAO bacSiConnect = null;

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
    Connection connection = ConnectDB.getConnection();
    String sql = "SELECT * FROM bacsi";
    try (PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            // In ra dữ liệu từng cột
            System.out.println("maBacSi: " + rs.getString("maBacSi"));
            System.out.println("hoVaTen: " + rs.getString("hoVaTen"));
            System.out.println("soDienThoai: " + rs.getString("soDienThoai"));
            System.out.println("email: " + rs.getString("email"));
            System.out.println("diaChi: " + rs.getString("diaChi"));
            System.out.println("gioiTinh: " + rs.getString("gioiTinh"));
            System.out.println("chuyenKhoa: " + rs.getString("chuyenKhoa"));
            System.out.println("kinhNghiemLamViec: " + rs.getString("kinhNghiemLamViec"));
            System.out.println("hocvan: " + rs.getString("hocvan"));
            System.out.println("hinhAnh: " + rs.getString("hinhAnh"));

            bacSiModel bacSi = new bacSiModel(
                rs.getString("maBacSi"),
                rs.getString("hoVaTen"),
                rs.getString("soDienThoai"),
                rs.getString("email"),
                rs.getString("diaChi"),
                rs.getString("gioiTinh"),
                rs.getString("chuyenKhoa"),
                rs.getString("kinhNghiemLamViec"),
                rs.getString("hocvan"),
                rs.getString("hinhAnh")
            );
            dsBS.add(bacSi);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return dsBS;
}

}

