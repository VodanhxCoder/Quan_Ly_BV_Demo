/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Model;

/**
 *
 * @author khue1
 */
public class QuanLyTaiKhoanModel {
//khoi tao cac bien trong database

    private String hoVaTen;
    private String tenDangNhap;
    private String matKhau;
    private String email;
    private String gioiTinh;
//Constructor 

    public QuanLyTaiKhoanModel() {
    }

    public QuanLyTaiKhoanModel(String hoVaTen, String tenDangNhap, String matKhau, String email, String gioiTinh) {
        this.hoVaTen = hoVaTen;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.email = email;
        this.gioiTinh = gioiTinh;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getEmail() {
        return email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    //ko co get set mk
    @Override
    public String toString() {
        return "QuanLyTaiKhoanModel{" + "hoVaTen=" + hoVaTen + ", tenDangNhap=" + tenDangNhap + ", email=" + email + ", gioiTinh=" + gioiTinh + '}';
    }

}
