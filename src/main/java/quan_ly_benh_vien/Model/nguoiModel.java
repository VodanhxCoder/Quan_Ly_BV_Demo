<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Model;

import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author LAPTOP
 */
public class nguoiModel {

    public String hoVaTen;
    public String soDienThoai;
    public String email;
    public Date ngaySinh;
    public String gioiTinh;
    public String hinhAnh;
    public String diachi;

    public nguoiModel() {

    }
    // khởi tạo cho đăng ký 
    public nguoiModel(String hoVaTen, String soDienThoai, String email, String gioiTinh, String hinhAnh, String diachi) {
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.hinhAnh = hinhAnh;
        this.diachi = diachi;
    }

    public Icon toIcon() {
        return new ImageIcon(getClass().getClassLoader().getResource("hinhAnh/" + hinhAnh + ".png"));
    }

    public nguoiModel(String hoVaTen, String soDienThoai, String email, Date ngaySinh, String gioiTinh, String hinhAnh, String diachi) {
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.hinhAnh = hinhAnh;
        this.diachi = diachi;
    }

    // Getters and Setters for nguoiModel
    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "NguoiModel{" + "hoVaTen=" + hoVaTen + ", soDienThoai=" + soDienThoai + ", emai=" + email + ", gioiTinh=" + gioiTinh + ", diaChi=" + diachi + '}';
    }

}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Model;

import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author LAPTOP
 */
public class nguoiModel {

    public String hoVaTen;
    public String soDienThoai;
    public String email;
    public Date ngaySinh;
    public String gioiTinh;
    public String hinhAnh;
    public String diachi;

    public nguoiModel() {

    }
    // khởi tạo cho đăng ký 
    public nguoiModel(String hoVaTen, String soDienThoai, String email, String gioiTinh, String hinhAnh, String diachi) {
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.hinhAnh = hinhAnh;
        this.diachi = diachi;
    }

    public Icon toIcon() {
        return new ImageIcon(getClass().getClassLoader().getResource("hinhAnh/" + hinhAnh + ".png"));
    }

    public nguoiModel(String hoVaTen, String soDienThoai, String email, Date ngaySinh, String gioiTinh, String hinhAnh, String diachi) {
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.hinhAnh = hinhAnh;
        this.diachi = diachi;
    }

    // Getters and Setters for nguoiModel
    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "NguoiModel{" + "hoVaTen=" + hoVaTen + ", soDienThoai=" + soDienThoai + ", emai=" + email + ", gioiTinh=" + gioiTinh + ", diaChi=" + diachi + '}';
    }

}
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
