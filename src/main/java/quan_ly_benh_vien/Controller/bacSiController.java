<<<<<<< HEAD
package quan_ly_benh_vien.Controller;

import quan_ly_benh_vien.Controller.ConnectDB;
import quan_ly_benh_vien.Data_Access_Object.QuanLyBacSiDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import quan_ly_benh_vien.Model.bacSiModel;
import java.sql.Date;

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

    public boolean KtraTrungLap(String thuocTinhKtra, String giaTriKtra) {
        return bacSiConnect.KtraTrungLap(thuocTinhKtra, giaTriKtra);
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

    public ArrayList<bacSiModel> timBacSiTheo(String danhMuc,String id) {
        return bacSiConnect.selectBy(danhMuc,id);
    }

    public int capNhatThongTinBacSi(bacSiModel bacSi, String id) {
        int rowsAffected = bacSiConnect.update(bacSi, id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }
    public int bacSiTuCapNhat(bacSiModel bacSi, String id){
          int rowsAffected = bacSiConnect.updateBacSiCoBan(bacSi, id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }
    public String LayIdBacSi(String tenDangNhap){
        String id = bacSiConnect.getid(tenDangNhap);
        return id;
    }
    
    public bacSiModel LayTTTaiKhoan(String tenDangNhap){
        bacSiModel bacsi = bacSiConnect.layTTTaiKhoan(tenDangNhap);
        return bacsi;
    }

  

}
=======
package quan_ly_benh_vien.Controller;

import quan_ly_benh_vien.Controller.ConnectDB;
import quan_ly_benh_vien.Data_Access_Object.QuanLyBacSiDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import quan_ly_benh_vien.Model.bacSiModel;
import java.sql.Date;

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

    public boolean KtraTrungLap(String thuocTinhKtra, String giaTriKtra) {
        return bacSiConnect.KtraTrungLap(thuocTinhKtra, giaTriKtra);
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

    public ArrayList<bacSiModel> timBacSiTheo(String danhMuc,String id) {
        return bacSiConnect.selectBy(danhMuc,id);
    }

    public int capNhatThongTinBacSi(bacSiModel bacSi, String id) {
        int rowsAffected = bacSiConnect.update(bacSi, id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

  

}
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
