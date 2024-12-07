/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Model;

import java.util.Date;

/**
 *
 * @author khue1
 */
//Sử dụng để chua tt cho frm Bac si Kham
public class BenhNhanKhamModel {
    private String maBenhnhan;
    private String maDatLich;
    public String hoVaTen;
     private String thoiGioiKham; 
    public Date ngaySinh;
    public String gioiTinh;
    
    //Constructor

    public BenhNhanKhamModel() {
    }

    public BenhNhanKhamModel(String maBenhnhan, String maDatLich, String hoVaTen, String thoiGioiKham, Date ngaySinh, String gioiTinh) {
        this.maBenhnhan = maBenhnhan;
        this.maDatLich = maDatLich;
        this.hoVaTen = hoVaTen;
        this.thoiGioiKham = thoiGioiKham;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public String getMaBenhnhan() {
        return maBenhnhan;
    }

    public void setMaBenhnhan(String maBenhnhan) {
        this.maBenhnhan = maBenhnhan;
    }



    public String getMaDatLich() {
        return maDatLich;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public String getThoiGioiKham() {
        return thoiGioiKham;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setMaDatLich(String maDatLich) {
        this.maDatLich = maDatLich;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public void setThoiGioiKham(String thoiGioiKham) {
        this.thoiGioiKham = thoiGioiKham;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "BenhNhanKhamModel{" + "maDatLich=" + maDatLich + ", hoVaTen=" + hoVaTen + ", thoiGioiKham=" + thoiGioiKham + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + '}';
    }

 
    
}
