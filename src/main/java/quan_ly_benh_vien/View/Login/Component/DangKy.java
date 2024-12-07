/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quan_ly_benh_vien.View.Login.Component;

import static quan_ly_benh_vien.Data_Access_Object.QuanLyTaiKhoanDao.MD5Encryptor;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import quan_ly_benh_vien.Controller.TaiKhoanController;
<<<<<<< HEAD
import quan_ly_benh_vien.Controller.benhNhanController;
import quan_ly_benh_vien.Model.QuanLyTaiKhoanModel;
import quan_ly_benh_vien.Model.benhNhanModel;
=======
import quan_ly_benh_vien.Model.QuanLyTaiKhoanModel;
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6

/**
 *
 * @author khue1
 */
public class DangKy extends javax.swing.JPanel {

    /**
     * Creates new form DangKy
     */
    private QuenMatKhau quenmk;

    public DangKy() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        txtTenDangNhap = new quan_ly_benh_vien.View.Login.subComponent.MyTextField();
        txtEmail = new quan_ly_benh_vien.View.Login.subComponent.MyTextField();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        checkDieuKhoan = new javax.swing.JCheckBox();
        btnDangKy = new javax.swing.JButton();
        btnTroLai = new javax.swing.JButton();
        txtMatKhau = new quan_ly_benh_vien.View.Login.subComponent.MyPassword();
        txtXacNhanMatKhau = new quan_ly_benh_vien.View.Login.subComponent.MyPassword();
        lbTitle = new javax.swing.JLabel();
        txtHoVaTen = new quan_ly_benh_vien.View.Login.subComponent.MyTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        txtTenDangNhap.setHint("Tên đăng nhập");
        txtTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDangNhapActionPerformed(evt);
            }
        });

        txtEmail.setHint("Email");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        buttonGroup1.add(radNam);
        radNam.setText("Nam");
        radNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(radNu);
        radNu.setText("Nữ");

        checkDieuKhoan.setText("Đồng ý với điều khoản");
        checkDieuKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDieuKhoanActionPerformed(evt);
            }
        });

        btnDangKy.setBackground(new java.awt.Color(255, 102, 102));
        btnDangKy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnDangKy.setText("Đăng ký");
        btnDangKy.setMaximumSize(new java.awt.Dimension(118, 23));
        btnDangKy.setMinimumSize(new java.awt.Dimension(118, 23));
        btnDangKy.setPreferredSize(new java.awt.Dimension(118, 23));
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        btnTroLai.setBackground(new java.awt.Color(255, 102, 102));
        btnTroLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTroLai.setForeground(new java.awt.Color(255, 255, 255));
        btnTroLai.setText("Trở lại");
        btnTroLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroLaiActionPerformed(evt);
            }
        });

        txtMatKhau.setHint("Nhập mật khẩu");
        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });

        txtXacNhanMatKhau.setHint("Nhập lại mật khẩu");
        txtXacNhanMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXacNhanMatKhauActionPerformed(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTitle.setText("Đăng Ký");

        txtHoVaTen.setHint("Họ và Tên");
        txtHoVaTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoVaTenActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(txtTenDangNhap, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(radNam, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(radNu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(checkDieuKhoan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnDangKy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnTroLai, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtMatKhau, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtXacNhanMatKhau, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbTitle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtHoVaTen, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                    .addComponent(radNam)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(radNu)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(checkDieuKhoan))
                                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHoVaTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(lbTitle)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radNu)
                    .addComponent(radNam)
                    .addComponent(checkDieuKhoan))
                .addGap(12, 12, 12)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtEmail, txtMatKhau, txtTenDangNhap, txtXacNhanMatKhau});

        add(jLayeredPane1, "card2");
    }// </editor-fold>//GEN-END:initComponents
<<<<<<< HEAD
//Duoc su dung boi file khac
=======
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6

    public static boolean validateHotenAndEmail(String hoVaTen, String email, String gioiTinh) {
        // Kiểm tra họ và tên
        if (hoVaTen == null || hoVaTen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Họ và tên không được để trống.");
            return false;
        }

        // Kiểm tra email
        if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email không được để trống.");
            return false;
        }

        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!email.matches(regexEmail)) {
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng.");
            return false;
        }

        // Kiểm tra giới tính
        if (gioiTinh == null || gioiTinh.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn giới tính!");
            return false;
        }

        return true; // Tất cả thông tin hợp lệ
    }
<<<<<<< HEAD
//validate cho dang ky 
=======
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6

    public static boolean validateRegistration(String hoVaTen, String tenDangNhap, String matKhau, String email, String gioiTinh) {
        // Regex định dạng tên đăng nhập
        String regexTenDangNhap = "^[a-zA-Z0-9]{4,50}$";

        // Regex định dạng mật khẩu
        String regexMatKhau = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,50}$";
        // Kiểm tra thông tin cơ bản

        if (tenDangNhap == null || tenDangNhap.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống.");
            return false;
        }

        // Kiểm tra định dạng tên đăng nhập
        if (!tenDangNhap.matches(regexTenDangNhap)) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập chỉ chứa chữ cái, số và có độ dài từ 4-50 ký tự.");
            return false;
        }
        if (!DangKy.validateHotenAndEmail(hoVaTen, email, gioiTinh)) {
            return false;
        }
        if (matKhau == null || matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống.");
            return false;
        }

        // Kiểm tra định dạng mật khẩu
        if (!matKhau.matches(regexMatKhau)) {
            JOptionPane.showMessageDialog(null,
                    "Mật khẩu phải chứa ít nhất một chữ cái thường, một chữ cái hoa, một chữ số, một ký tự đặc biệt, và dài từ 8-50 ký tự.");
            return false;
        }

        return true; // Thông tin hợp lệ
    }


    private void txtTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhapActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void radNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNamActionPerformed

    private void checkDieuKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDieuKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkDieuKhoanActionPerformed

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        String hoVaTen = txtHoVaTen.getText();
        String tenDangNhap = txtTenDangNhap.getText();
        String matKhau = new String(txtMatKhau.getPassword());
        String email = txtEmail.getText();
        String reMatKhau = new String(txtXacNhanMatKhau.getPassword());
<<<<<<< HEAD
        String gioiTinh = null;

=======
        String gioiTinh= null;
        
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
        if (radNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (radNu.isSelected()) {
            gioiTinh = "Nữ";
        }
        if (!validateRegistration(hoVaTen, tenDangNhap, matKhau, email, gioiTinh)) {
            return;
        }
        if (!matKhau.equals(reMatKhau)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại không khớp.");
            return;
        }
<<<<<<< HEAD
        //Kiem tra dieu khoản đã đc chọn hay chưa 
        if (!checkDieuKhoan.isSelected()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa đồng ý với điều khoản!");
            return;
        }
=======
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
        //Tạo mã hóa
        String enrTenDangNhap = null;
        String enrMatKhau = null;
        try {
            // Tạo đối tượng đăng ký và kiểm tra điều khoản"
            enrTenDangNhap = MD5Encryptor(tenDangNhap);
            enrMatKhau = MD5Encryptor(matKhau);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
        }

// Kiểm tra tên đăng nhập và email đã tồn tại
        TaiKhoanController dangKyController = new TaiKhoanController();
<<<<<<< HEAD

=======
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
        boolean tenDaTonTai = dangKyController.kiemTraTenDangNhapTrung(enrTenDangNhap);
        boolean emailDaTonTai = dangKyController.kiemTraEmailTrung(email);

        if (tenDaTonTai) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại!");
        } else if (emailDaTonTai) {
            JOptionPane.showMessageDialog(null, "Email đã tồn tại!");
        } else {
<<<<<<< HEAD
            benhNhanController bnController = new benhNhanController();

            benhNhanModel bnModel = new benhNhanModel(enrTenDangNhap, hoVaTen, null, email, null, gioiTinh, null, null);
            QuanLyTaiKhoanModel dangKy = new QuanLyTaiKhoanModel(hoVaTen, enrTenDangNhap, enrMatKhau, email, gioiTinh);
            

            // Gọi controller để thực hiện đăng ký
            int rowsAffected = dangKyController.dangKyTaiKhoan(dangKy, "user");
            int rowAffected1 =0;
            if (rowsAffected > 0) { //Khi đăng ký thành công sẽ trả về 1 
                  rowAffected1 = benhNhanController.themBenhNhan(bnModel);
            } else {
                JOptionPane.showMessageDialog(null, "Đăng ký tài khoản thất bại!");
            }
            if(rowAffected1>0){
                JOptionPane.showMessageDialog(null, "Đăng ký tài khoản thành công!");
                System.out.println(txtTenDangNhap.getText());
                Login JpLogin = new Login();
                JpLogin.setVisible(true);
                setVisible(false);
            }

=======
            QuanLyTaiKhoanModel dangKy = new QuanLyTaiKhoanModel(hoVaTen, enrTenDangNhap, enrMatKhau, email, gioiTinh);
            //Kiem tra dieu khoản đã đc chọn hay chưa 
            if (!checkDieuKhoan.isSelected()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa đồng ý với điều khoản!");
            } else {
                // Gọi controller để thực hiện đăng ký
                int rowsAffected = dangKyController.dangKyTaiKhoan(dangKy, false);
                if (rowsAffected > 0) { //Khi đăng ký thành công sẽ trả về 1 
                    JOptionPane.showMessageDialog(null, "Đăng ký tài khoản thành công!");
                    System.out.println(txtTenDangNhap.getText());
                    Login JpLogin = new Login();
                    JpLogin.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Đăng ký tài khoản thất bại!");
                }
            }
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
        }


    }//GEN-LAST:event_btnDangKyActionPerformed

    private void btnTroLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroLaiActionPerformed
        // TODO add your handling code here:
        Login JpLogin = new Login();
        JpLogin.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnTroLaiActionPerformed

    private void txtHoVaTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoVaTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoVaTenActionPerformed

    private void txtXacNhanMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXacNhanMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXacNhanMatKhauActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnTroLai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkDieuKhoan;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private quan_ly_benh_vien.View.Login.subComponent.MyTextField txtEmail;
    private quan_ly_benh_vien.View.Login.subComponent.MyTextField txtHoVaTen;
    private quan_ly_benh_vien.View.Login.subComponent.MyPassword txtMatKhau;
    private quan_ly_benh_vien.View.Login.subComponent.MyTextField txtTenDangNhap;
    private quan_ly_benh_vien.View.Login.subComponent.MyPassword txtXacNhanMatKhau;
    // End of variables declaration//GEN-END:variables
}
