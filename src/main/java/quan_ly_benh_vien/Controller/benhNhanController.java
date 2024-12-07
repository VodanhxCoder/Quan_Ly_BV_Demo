
package quan_ly_benh_vien.Controller;

import quan_ly_benh_vien.Data_Access_Object.QuanLyBenhNhanDAO;
import quan_ly_benh_vien.Controller.*;
import java.util.ArrayList;
import quan_ly_benh_vien.Model.*;

public class benhNhanController {

    private static QuanLyBenhNhanDAO benhNhanCon = null;

    public benhNhanController() {
        benhNhanCon = QuanLyBenhNhanDAO.getInstance();
    }

    public boolean kiemTraMaBenhNhanTrung(String maBenhNhan) {
        return benhNhanCon.maBenhNhanTrung(maBenhNhan);
    }

    public static int themBenhNhan(benhNhanModel benhNhan) {
        int rowsAffected = benhNhanCon.insert(benhNhan);
        if (rowsAffected > 0) {
            System.out.println("Thêm bệnh nhân thành công !");
        } else {
            System.out.println("Thêm bệnh nhân thất bại !");
        }
        return rowsAffected;
    }

    public int capNhatThongTinBenhNhan(benhNhanModel benhNhan, String id) {
        int rowsAffected = benhNhanCon.update(benhNhan, id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

    public ArrayList<benhNhanModel> layDanhSachBenhNhan() {
        return benhNhanCon.selectAll();
    }

//    public ArrayList<benhNhanModel> layDanhSachBenhNhanDuocBacSiKham(String id) {
//        return benhNhanCon.selectBenhNhanDuocBacSiKham(id);
//    }

    public ArrayList<benhNhanModel> timBenhNhanTheo(String danhMuc,String id) {
        return benhNhanCon.selectBy(danhMuc,id);
    }

    public int xoaBenhNhanTheoID(String id) {
        int rowsAffected = benhNhanCon.deleteById(id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

    public int themBenhNhan(hosoBenhAnModel hoSo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String layIDBenhNhan(String tenDangNhap){
      String id= benhNhanCon.getIdBenhNhan(tenDangNhap);
      return id;
    }
    public benhNhanModel layThongTinTaiKhoan(String tenDangNhap){
        return benhNhanCon.layTTtaikhoan(tenDangNhap);
    }

    
}
