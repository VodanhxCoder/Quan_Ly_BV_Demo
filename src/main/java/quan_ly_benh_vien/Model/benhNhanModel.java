/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Model;

import java.util.Date;

/**
 *
 * @author LAPTOP
 */
public class benhNhanModel extends nguoiModel{
   
    private String maBenhNhan;
    private String tenDangnhap;
    public benhNhanModel(String maBenhNhan,String tenDangnhap ) {
        this.maBenhNhan = maBenhNhan;
        this.tenDangnhap = tenDangnhap;
    }
    
    public benhNhanModel( String tenDangnhap,String hoVaTen, String soDienThoai, String email,Date ngaySinh, String gioiTinh, String diachi, String hinhAnh) {
        super(hoVaTen, soDienThoai, email,ngaySinh, gioiTinh, hinhAnh, diachi);
        this.maBenhNhan = maBenhNhan;
        this.tenDangnhap = tenDangnhap;
    }
    public benhNhanModel( String maBenhNhan, String tenDangnhap,String hoVaTen, String soDienThoai, String email,Date ngaySinh, String gioiTinh, String diachi, String hinhAnh) {
        super(hoVaTen, soDienThoai, email,ngaySinh, gioiTinh, hinhAnh, diachi);
        this.maBenhNhan = maBenhNhan;
        this.tenDangnhap = tenDangnhap;
    }
     public benhNhanModel( String tenDangnhap,String hoVaTen, String soDienThoai, String email, String gioiTinh, String diachi, String hinhAnh) {
        super(hoVaTen, soDienThoai, email, gioiTinh, hinhAnh, diachi);
        this.maBenhNhan = maBenhNhan;
        this.tenDangnhap = tenDangnhap;
    }
     

    

    public benhNhanModel() {
        
    }

   

    // Getters and Setters for benhNhanModel-specific attributes
    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

   

    public String getTenDangnhap() {
        return tenDangnhap;
    }

    public void setTenDangnhap(String tenDangnhap) {
        this.tenDangnhap = tenDangnhap;
    }
}
