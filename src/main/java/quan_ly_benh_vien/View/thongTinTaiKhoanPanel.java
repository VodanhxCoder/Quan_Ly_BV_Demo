/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quan_ly_benh_vien.View;
<<<<<<< HEAD

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import quan_ly_benh_vien.Controller.TaiKhoanController;
import quan_ly_benh_vien.Controller.bacSiController;
=======
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
import quan_ly_benh_vien.Controller.benhNhanController;
import quan_ly_benh_vien.Data_Access_Object.QuanLyBenhAnDAO;
import quan_ly_benh_vien.Model.benhNhanModel;
import quan_ly_benh_vien.View.Login.Component.Login;
import quan_ly_benh_vien.Data_Access_Object.QuanLyTaiKhoanDao;
<<<<<<< HEAD
import quan_ly_benh_vien.Model.bacSiModel;
import quan_ly_benh_vien.Model.nguoiModel;
import quan_ly_benh_vien.View.Login.Component.DangKy;
=======
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6

/**
 *
 * @author khue1
 */
public class thongTinTaiKhoanPanel extends javax.swing.JPanel {

    /**
     * Creates new form thongTinTaiKhoanPanel
     */
<<<<<<< HEAD
    private String checkemail = null;

=======
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
    public thongTinTaiKhoanPanel() {
        initComponents();
        hienThiTaiKhoan();
    }
<<<<<<< HEAD

    //hàm xử lý giới tính 
    private boolean checkGioiTinh(String gioiTinh) {
        if (gioiTinh.equals("Nam")) {
            return true;
        } else {
            return false;
        }
    }

    public void hienThiTT(nguoiModel nguoiModel) {

        //khoi tao
        String gioiTinh = null;

        // Kiểm tra nếu model không null trước khi lấy dữ liệu
        if (nguoiModel != null) {

            // Set giá trị vào các JTextField
            txtHoVaTen.setText(nguoiModel.getHoVaTen());
            txtSoDienThoai.setText(nguoiModel.getSoDienThoai());
            txtEmail.setText(nguoiModel.getEmail());
            txtDiaChi.setText(nguoiModel.getDiachi());
            //Xu ly gioi tinh
            gioiTinh = nguoiModel.getGioiTinh();
            if (checkGioiTinh(gioiTinh)) {
                radNam.setSelected(true);
            } else {
                radNu.setSelected(true);
            }
            //Xu ly Ngay thang

            Object ngaySinhObj = nguoiModel.getNgaySinh();
            if (ngaySinhObj instanceof Date) {
                dtNgaySinh.setDate((Date) ngaySinhObj);  // Cập nhật vào JDateChooser
            }

            //để check email có bị thay đổi hay ko 
            checkemail = txtEmail.getText();
            System.out.println(gioiTinh);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin tài khoản !", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void hienThiTaiKhoan() {
        String tenDangNhap = null;
        try {
            tenDangNhap = QuanLyTaiKhoanDao.MD5Encryptor(Login.xacNhanDangNhap);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(thongTinTaiKhoanPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(thongTinTaiKhoanPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (Login.xacNhanUser.equals("user")) {
            nguoiModel benhnhan = new nguoiModel();
            benhNhanController benhNhanCon = new benhNhanController();
            benhnhan = benhNhanCon.layThongTinTaiKhoan(tenDangNhap);
            hienThiTT(benhnhan);
        } else if (Login.xacNhanUser.equals("doctor")) {
            nguoiModel bacsiModel = new nguoiModel();
            bacSiController bacSiCon = new bacSiController();
            bacsiModel = bacSiCon.LayTTTaiKhoan(tenDangNhap);
            hienThiTT(bacsiModel);
        } else if (Login.xacNhanUser.equals("admin")) {

            txtHoVaTen.setEnabled(false);
            txtSoDienThoai.setEnabled(false);
            txtEmail.setEnabled(false);
            txtDiaChi.setEnabled(false);
            radNam.setEnabled(false);
            radNu.setEnabled(false);
            btnSua.setEnabled(false);
            btnAnh.setEnabled(false);
            dtNgaySinh.setEnabled(false);
        }
    }

=======
    public void hienThiTaiKhoan() {
    String tenDangNhap = null;
    try {
        tenDangNhap = QuanLyTaiKhoanDao.MD5Encryptor(Login.xacNhanDangNhap);
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(thongTinTaiKhoanPanel.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedEncodingException ex) {
        Logger.getLogger(thongTinTaiKhoanPanel.class.getName()).log(Level.SEVERE, null, ex);
    }

    if (Login.xacNhanUser.equals("user")) {
        benhNhanModel benhnhanModel = new benhNhanModel();
        benhNhanController benhNhanCon = new benhNhanController();
        benhnhanModel = benhNhanCon.layThongTinTaiKhoan(tenDangNhap);

        // Kiểm tra nếu model không null trước khi lấy dữ liệu
        if (benhnhanModel != null) {
            // Set giá trị vào các JTextField
            txtHoVaTen.setText(benhnhanModel.getHoVaTen());
            txtSoDienThoai.setText(benhnhanModel.getSoDienThoai());
            txtEmail.setText(benhnhanModel.getEmail());
            txtDiaChi.setText(benhnhanModel.getDiachi());
            txtGioiTinh.setText(benhnhanModel.getGioiTinh());
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin tài khoản bệnh nhân!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }else if(Login.xacNhanUser.equals("admin")){
        JOptionPane.showMessageDialog(null, "Xin Chào ADMIN");
         txtHoVaTen.setEnabled(false);
            txtSoDienThoai.setEnabled(false);
            txtEmail.setEnabled(false);
            txtDiaChi.setEnabled(false);
            txtGioiTinh.setEnabled(false);
            btnSua.setEnabled(false);
            btnXoaTaiKhoan.setEnabled(false);
            btnAnh.setEnabled(false);
    }
}
        
        
    
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<< HEAD
        buttonGroup1 = new javax.swing.ButtonGroup();
=======
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
        jLabel1 = new javax.swing.JLabel();
        btnAnh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
<<<<<<< HEAD
=======
        btnXoaTaiKhoan = new javax.swing.JButton();
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
        txtHoVaTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
<<<<<<< HEAD
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        lbNgaySinh = new javax.swing.JLabel();
        dtNgaySinh = new com.toedter.calendar.JDateChooser();
=======
        txtGioiTinh = new javax.swing.JTextField();
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6

        jLabel1.setText("Hình Ảnh");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnAnh.setText("tải ảnh");

<<<<<<< HEAD
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Họ và tên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Số điện thoại:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Địa chỉ:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Giới tính:");

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        buttonGroup1.add(radNam);
        radNam.setText("Nam");

        buttonGroup1.add(radNu);
        radNu.setText("Nữ");

        lbNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNgaySinh.setForeground(new java.awt.Color(0, 102, 102));
        lbNgaySinh.setText("Ngày Sinh:");
=======
        jLabel2.setText("Họ và tên:");

        jLabel3.setText("Số điện thoại:");

        jLabel4.setText("Email:");

        jLabel5.setText("Địa chỉ:");

        jLabel6.setText("Giới tính:");

        btnSua.setText("Sửa");

        btnXoaTaiKhoan.setText("Xóa tài khoản");
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(lbNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(dtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radNam)
                        .addGap(46, 46, 46)
                        .addComponent(radNu)))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dtNgaySinh, txtDiaChi, txtEmail, txtHoVaTen, txtSoDienThoai});
=======
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(46, 46, 46)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(btnSua)
                .addGap(112, 112, 112)
                .addComponent(btnXoaTaiKhoan)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDiaChi, txtEmail, txtGioiTinh, txtHoVaTen, txtSoDienThoai});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAnh, jLabel1});
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnAnh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
=======
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnh)
                .addGap(18, 18, 18)
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
<<<<<<< HEAD
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
=======
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
<<<<<<< HEAD
                    .addComponent(radNam)
                    .addComponent(radNu))
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dtNgaySinh, txtEmail, txtSoDienThoai});

    }// </editor-fold>//GEN-END:initComponents

    public void suaBenhNhan() {

        String hoVaTen = txtHoVaTen.getText();
        String soDienThoai = txtSoDienThoai.getText();
        String email = txtEmail.getText();
        Date ngaySinh = dtNgaySinh.getDate();
        String gioiTinh = null;
        String diaChi = txtDiaChi.getText();
        String hinhAnh = null;
        String tenDangNhap = null;

        if (radNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (radNu.isSelected()) {
            gioiTinh = "Nữ";
        }
        if (ngaySinh == null) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống.");
            System.out.println("Ngày sinh không được để trống");
            return;
        }
        // Kiểm tra ngày sinh: Nếu ngày sinh là trong tương lai thì không hợp lệ
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new java.util.Date());

        if (ngaySinh.after(java.sql.Date.valueOf(today))) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không thể là ngày trong tương lai");
            System.out.println("Ngày sinh không thể là ngày trong tương lai");
            return;
        }

        //ktra xem định dạng email ho ten và giới tính 
        if (!DangKy.validateHotenAndEmail(hoVaTen, email, gioiTinh)) {
            return;
        }
        //check email dã tồn tại 
        TaiKhoanController checkEmail = new TaiKhoanController();
        boolean emailDaTonTai = checkEmail.kiemTraEmailTrung(email);
        System.out.println(checkemail);
        if (!checkemail.equals(email)) {
            if (emailDaTonTai) {
                JOptionPane.showMessageDialog(null, "Email đã tồn tại");
                return;
            }
        }
        int rowsAffected = 0;

        if (Login.xacNhanUser.equals("user")) {
            benhNhanModel bnModel = new benhNhanModel(tenDangNhap, hoVaTen, soDienThoai, email, ngaySinh, gioiTinh, diaChi, hinhAnh);
            benhNhanController benhNhanController = new benhNhanController();
            rowsAffected = benhNhanController.capNhatThongTinBenhNhan(bnModel, Login.id);
        }else if(Login.xacNhanUser.equals("doctor")){
//            String hoVaTen, String soDienThoai, String email, Date ngaySinh,
//            String diaChi, String gioiTinh, String chuyenKhoa, String kinhNghiemLamViec,
//            String hocVan, String hinhAnh, String tenDangNhap
            bacSiModel bsModel = new bacSiModel(hoVaTen, soDienThoai, email, ngaySinh, diaChi, gioiTinh,null, null, null, hinhAnh, tenDangNhap);
            bacSiController bacsiController = new bacSiController();
            rowsAffected = bacsiController.bacSiTuCapNhat(bsModel, Login.id);
            System.out.println(Login.id);
        }

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin bệnh nhân thành công.");
            hienThiTaiKhoan();
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân");
        }

    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        suaBenhNhan();
    }//GEN-LAST:event_btnSuaActionPerformed

=======
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaTaiKhoan)
                    .addComponent(btnSua)))
        );
    }// </editor-fold>//GEN-END:initComponents

>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnh;
    private javax.swing.JButton btnSua;
<<<<<<< HEAD
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dtNgaySinh;
=======
    private javax.swing.JButton btnXoaTaiKhoan;
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
<<<<<<< HEAD
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
=======
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGioiTinh;
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
