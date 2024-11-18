/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author LAPTOP
 */
public class nguoiModel {
   
    public String hoVaTen;
    public String soDienThoai;
    public String email ;
    public String gioiTinh;
    public String hinhAnh;
    public String diachi;
    
      public nguoiModel(){
          
      }
      
      public Icon toIcon(){
             return new ImageIcon(getClass().getClassLoader().getResource("hinhAnh/" + hinhAnh + ".png"));
        }

    public nguoiModel(String hoVaTen, String soDienThoai, String email, String gioiTinh, String hinhAnh, String diachi) {
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
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
