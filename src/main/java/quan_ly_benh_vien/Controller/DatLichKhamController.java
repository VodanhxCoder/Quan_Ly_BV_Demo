<<<<<<< HEAD
package quan_ly_benh_vien.Controller;

import quan_ly_benh_vien.Data_Access_Object.DatLichKhamDao;
import java.util.ArrayList;
import java.util.List;
import quan_ly_benh_vien.Model.bacSiModel;
import quan_ly_benh_vien.Model.DatLichKhamModel;
import quan_ly_benh_vien.Model.BenhNhanKhamModel;

public class DatLichKhamController {

    private final DatLichKhamDao datLichDao;

    public DatLichKhamController() {
        datLichDao = DatLichKhamDao.getInstance();
    }

    public ArrayList<bacSiModel> layDanhSachBacSiTheoChuyenKhoa(String chuyenKhoa) {
        return datLichDao.selectAllByChuyenKhoa(chuyenKhoa);
    }

    public int insertDatLich(DatLichKhamModel datLich) {
        return datLichDao.insert(datLich);
    }

        public ArrayList<BenhNhanKhamModel> layDanhSachDatLich(String mabacSi ) {
        return datLichDao.selectAll(mabacSi);
    }

    public ArrayList<DatLichKhamModel> layDanhSachDatLich2(String tenDangNhap) {
        return datLichDao.selectAll2(tenDangNhap);
    }

    public int xoaLichKhamTheoId(String id) {
        int rowsAffected = datLichDao.deleteById(id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

//    kiểm tra trùng lịch khám
    public boolean kiemTraTrungLich(String selectedDate) {
        return datLichDao.kiemTraTrungLich(selectedDate);
    }

//    kiểm tra trùng chuyên khoa
    public boolean kiemTraChuyenKhoa(String chuyenKhoa) {
        return datLichDao.kiemTraTrungChuyenKhoa(chuyenKhoa);
    }

     public void capNhatTrangThaiThanhToan(List<String> listMaDatLich) {
        datLichDao.updateTrangThaiThanhToan(listMaDatLich);
    }


}
=======
package quan_ly_benh_vien.Controller;

import quan_ly_benh_vien.Data_Access_Object.DatLichKhamDao;
import java.util.ArrayList;
import java.util.List;
import quan_ly_benh_vien.Model.bacSiModel;
import quan_ly_benh_vien.Model.DatLichKhamModel;

public class DatLichKhamController {

    private final DatLichKhamDao datLichDao;

    public DatLichKhamController() {
        datLichDao = DatLichKhamDao.getInstance();
    }

    public ArrayList<bacSiModel> layDanhSachBacSiTheoChuyenKhoa(String chuyenKhoa) {
        return datLichDao.selectAllByChuyenKhoa(chuyenKhoa);
    }

    public int insertDatLich(DatLichKhamModel datLich) {
        return datLichDao.insert(datLich);
    }

    public ArrayList<DatLichKhamModel> layDanhSachDatLich() {
        return datLichDao.selectAll();
    }

    public ArrayList<DatLichKhamModel> layDanhSachDatLich2(String tenDangNhap) {
        return datLichDao.selectAll2(tenDangNhap);
    }

    public int xoaLichKhamTheoId(String id) {
        int rowsAffected = datLichDao.deleteById(id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

//    kiểm tra trùng lịch khám
    public boolean kiemTraTrungLich(String selectedDate) {
        return datLichDao.kiemTraTrungLich(selectedDate);
    }

//    kiểm tra trùng chuyên khoa
    public boolean kiemTraChuyenKhoa(String chuyenKhoa) {
        return datLichDao.kiemTraTrungChuyenKhoa(chuyenKhoa);
    }

     public void capNhatTrangThaiThanhToan(List<String> listMaDatLich) {
        datLichDao.updateTrangThaiThanhToan(listMaDatLich);
    }

}
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
