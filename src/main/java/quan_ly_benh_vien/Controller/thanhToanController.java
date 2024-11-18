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
