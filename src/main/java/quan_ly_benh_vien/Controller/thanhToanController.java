<<<<<<< HEAD
package quan_ly_benh_vien.Controller;


import quan_ly_benh_vien.Data_Access_Object.QuanLyThanhToanDAO;
import quan_ly_benh_vien.Model.*;
public class thanhToanController {

    private final QuanLyThanhToanDAO thanhToanDao;

    public thanhToanController() {
        thanhToanDao = QuanLyThanhToanDAO.getInstance();
    }

    public int insertThanhToan(thanhToanModel thanhToan) {
        return thanhToanDao.insert(thanhToan);
    }
    
}
=======
package quan_ly_benh_vien.Controller;


import quan_ly_benh_vien.Data_Access_Object.QuanLyThanhToanDAO;
import quan_ly_benh_vien.Model.*;
public class thanhToanController {

    private final QuanLyThanhToanDAO thanhToanDao;

    public thanhToanController() {
        thanhToanDao = QuanLyThanhToanDAO.getInstance();
    }

    public int insertThanhToan(thanhToanModel thanhToan) {
        return thanhToanDao.insert(thanhToan);
    }
    
}
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
