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

  

}
