/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Controller;

import quan_ly_benh_vien.Data_Access_Object.QuanLyTaiKhoanDao;
import quan_ly_benh_vien.Model.QuanLyTaiKhoanModel;

/**
 * S
 *
 * @author khue1
 */
public class TaiKhoanController {

    private final QuanLyTaiKhoanDao dangKyDao;

    public TaiKhoanController() {
        dangKyDao = QuanLyTaiKhoanDao.getInstance();
    }

    public int dangKyTaiKhoan(QuanLyTaiKhoanModel dangKy, boolean check) {
        // Gọi phương thức insert của QuanLyTaiKhoanDao để thêm dữ liệu vào cơ sở dữ liệu
        int rowsAffected = dangKyDao.insertBenhNhan(dangKy,check);

        if (rowsAffected > 0) {
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Đăng ký thất bại!");
        }
        return rowsAffected;
    }

    public boolean kiemTraTenDangNhapTrung(String tenDangNhap) {
        return dangKyDao.tenDangNhapDaTonTai(tenDangNhap);
    }

    public boolean kiemTraEmailTrung(String email) {
        QuanLyTaiKhoanDao dangKyDao = new QuanLyTaiKhoanDao();
        return dangKyDao.kiemTraEmailTrung(email);
    }

    public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
        QuanLyTaiKhoanDao dangKyDao = new QuanLyTaiKhoanDao();
        return dangKyDao.kiemTraDangNhap(tenDangNhap, matKhau);
    }

    public boolean doiMatKhau(String tenDangNhap, String matKhauCu, String matKhauMoi) {
        QuanLyTaiKhoanDao doiMatKhauDao = new QuanLyTaiKhoanDao();
        return doiMatKhauDao.doiMatKhau(tenDangNhap, matKhauCu, matKhauMoi);
    }

    public String layMatKhauMoi(String tenDangNhap, String email) {
        QuanLyTaiKhoanDao layMatKhauMoiDao = new QuanLyTaiKhoanDao();
        return layMatKhauMoiDao.layMatKhauMoi(tenDangNhap, email);
    }
    
    public String ktraTypeUser(String tenDangNhap){
        return dangKyDao.ktraUser(tenDangNhap);
    }

}
