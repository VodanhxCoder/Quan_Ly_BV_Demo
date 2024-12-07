<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Data_Access_Object;

/**
 *
 * @author khue1
 */

import java.util.ArrayList;

//Quyết định các chức năng chính cho chương trình 
public interface DaoInterface<T> {
    public int insert(T t); //Thêm  

    public int update(T t, String id);//Sửa với id  

    public int deleteById(String id);//Xóa vói id 
    
    public void deleteAll();    //Xóa tất cả    

    public ArrayList<T> selectAll();    //Lấy tất cả 

    public ArrayList<T> selectBy(String danhMuc, String id); // Tìm kiếm bởi id-> chỉnh thành tìm kiếm bằng tùy chọn 
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_benh_vien.Data_Access_Object;

/**
 *
 * @author khue1
 */

import java.util.ArrayList;

//Quyết định các chức năng chính cho chương trình 
public interface DaoInterface<T> {
    public int insert(T t); //Thêm  

    public int update(T t, String id);//Sửa với id  

    public int deleteById(String id);//Xóa vói id 
    
    public void deleteAll();    //Xóa tất cả    

    public ArrayList<T> selectAll();    //Lấy tất cả 

    public ArrayList<T> selectBy(String danhMuc, String id); // Tìm kiếm bởi id-> chỉnh thành tìm kiếm bằng tùy chọn 
}
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
