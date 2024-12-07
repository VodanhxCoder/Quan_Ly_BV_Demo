<<<<<<< HEAD
package quan_ly_benh_vien.Controller;



import quan_ly_benh_vien.Data_Access_Object.QuanLyBenhAnDAO;
import quan_ly_benh_vien.Controller.*;
import java.util.ArrayList;
import quan_ly_benh_vien.Model.*;

public class benhAnController {

    private final QuanLyBenhAnDAO hoSoDao;

    public benhAnController() {
        hoSoDao = QuanLyBenhAnDAO.getInstance();
    }

    public boolean kiemTraMaHoSoTrung(String maHoSo) {
        return hoSoDao.maHoSoTrung(maHoSo);
    }

    public int themHoSo(hosoBenhAnModel hoSo) {
        int rowsAffected = hoSoDao.insert(hoSo);
        if (rowsAffected > 0) {
            System.out.println("Thêm hồ sơ thành công !");
        } else {
            System.out.println("Thêm hồ sơ thất bại !");
        }
        return rowsAffected;
    }

    public int capNhatThongTinHoSo(hosoBenhAnModel hoSo, String id) {
        int rowsAffected = hoSoDao.update(hoSo, id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

    public ArrayList<hosoBenhAnModel> layDanhSachHoSo() {
        return hoSoDao.selectAll();
    }
    
      public ArrayList<hosoBenhAnModel> layDanhSachHoSoTheoBenhNhan(String id) {
        return hoSoDao.selectHoSoBenhAn(id);
    }

    public ArrayList<hosoBenhAnModel> timHoSoTheo(String danhMuc,String id) {
        return hoSoDao.selectBy(danhMuc,id);
    }

    public int xoaHoSoTheoId(String id) {
        int rowsAffected = hoSoDao.deleteById(id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }
}
=======
package quan_ly_benh_vien.Controller;



import quan_ly_benh_vien.Data_Access_Object.QuanLyBenhAnDAO;
import quan_ly_benh_vien.Controller.*;
import java.util.ArrayList;
import quan_ly_benh_vien.Model.*;

public class benhAnController {

    private final QuanLyBenhAnDAO hoSoDao;

    public benhAnController() {
        hoSoDao = QuanLyBenhAnDAO.getInstance();
    }

    public boolean kiemTraMaHoSoTrung(String maHoSo) {
        return hoSoDao.maHoSoTrung(maHoSo);
    }

    public int themHoSo(hosoBenhAnModel hoSo) {
        int rowsAffected = hoSoDao.insert(hoSo);
        if (rowsAffected > 0) {
            System.out.println("Thêm hồ sơ thành công !");
        } else {
            System.out.println("Thêm hồ sơ thất bại !");
        }
        return rowsAffected;
    }

    public int capNhatThongTinHoSo(hosoBenhAnModel hoSo, String id) {
        int rowsAffected = hoSoDao.update(hoSo, id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

    public ArrayList<hosoBenhAnModel> layDanhSachHoSo() {
        return hoSoDao.selectAll();
    }
    
      public ArrayList<hosoBenhAnModel> layDanhSachHoSoTheoBenhNhan(String id) {
        return hoSoDao.selectHoSoBenhAn(id);
    }

    public hosoBenhAnModel timHoSoTheoID(String id) {
        return hoSoDao.selectById(id);
    }

    public int xoaHoSoTheoId(String id) {
        int rowsAffected = hoSoDao.deleteById(id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }
}
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
