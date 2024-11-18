package quan_ly_benh_vien.View.Login.Component;

import quan_ly_benh_vien.Data_Access_Object.QuanLyTaiKhoanDao;
import java.awt.AlphaComposite;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import quan_ly_benh_vien.View.Main.Main;

import java.io.UnsupportedEncodingException;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.SwingUtilities;
import quan_ly_benh_vien.Controller.TaiKhoanController;

public class Login extends javax.swing.JPanel {
  
    public CardLayout cardLayout;
     
    public Login() {
        initComponents();
        setOpaque(false);

        JpLogin.setVisible(true);
        JpquenMatKhau.setVisible(false);
        JpdangKy.setVisible(false);
        JpThayMatKhau.setVisible(false);
        SetColorlb(lbDangky);
        SetColorlb(lbQuenMatKhau);
        SetColorlb(lbThaydoiMatkhau);
        cardLayout = (CardLayout) JpComponent.getLayout();
    }

    public void SetColorlb(javax.swing.JLabel lb) {
        // đổi màu đăng ký
        lb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lb.setForeground(Color.RED); // Màu chữ khi trỏ vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lb.setForeground(Color.BLUE); // Màu chữ khi trỏ ra
            }
        });
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    private Icon image;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin1 = new quan_ly_benh_vien.View.Login.Component.PanelLogin();
        JpComponent = new javax.swing.JPanel();
        JpLogin = new javax.swing.JPanel();
        txtPassword = new quan_ly_benh_vien.View.Login.subComponent.MyPassword();
        btnDangNhap = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbChuaCoTaiKhoan = new javax.swing.JLabel();
        lbDangky = new javax.swing.JLabel();
        lbQuenMatKhau = new javax.swing.JLabel();
        txtUser = new quan_ly_benh_vien.View.Login.subComponent.MyTextField();
        lbThaydoiMatkhau = new javax.swing.JLabel();
        JpdangKy = new quan_ly_benh_vien.View.Login.Component.DangKy();
        JpquenMatKhau = new quan_ly_benh_vien.View.Login.Component.QuenMatKhau();
        JpThayMatKhau = new quan_ly_benh_vien.View.Login.Component.ThayMatKhau();

        JpComponent.setLayout(new java.awt.CardLayout());

        JpLogin.setBackground(new java.awt.Color(255, 255, 255));

        txtPassword.setHint("Mật Khẩu");
        txtPassword.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Github-Octicons-Lock-24.24.png"))); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnDangNhap.setBackground(new java.awt.Color(255, 0, 51));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Login");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/doctor_img.jpg"))); // NOI18N

        lbChuaCoTaiKhoan.setForeground(new java.awt.Color(102, 153, 255));
        lbChuaCoTaiKhoan.setText("Chưa có tài khoản? ");

        lbDangky.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbDangky.setForeground(new java.awt.Color(102, 153, 255));
        lbDangky.setText("Đăng ký");
        lbDangky.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbDangkyFocusGained(evt);
            }
        });
        lbDangky.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDangkyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDangkyMouseEntered(evt);
            }
        });

        lbQuenMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbQuenMatKhau.setForeground(new java.awt.Color(102, 153, 255));
        lbQuenMatKhau.setText("Quên mật khẩu?");
        lbQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQuenMatKhauMouseClicked(evt);
            }
        });

        txtUser.setHint("Tên Đăng Nhập");
        txtUser.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Colebemis-Feather-User.24.png"))); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        lbThaydoiMatkhau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbThaydoiMatkhau.setForeground(new java.awt.Color(102, 153, 255));
        lbThaydoiMatkhau.setText("Thay đổi mật khẩu");
        lbThaydoiMatkhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbThaydoiMatkhauMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JpLoginLayout = new javax.swing.GroupLayout(JpLogin);
        JpLogin.setLayout(JpLoginLayout);
        JpLoginLayout.setHorizontalGroup(
            JpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbChuaCoTaiKhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDangky)
                .addGap(43, 43, 43))
            .addGroup(JpLoginLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(JpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JpLoginLayout.createSequentialGroup()
                        .addComponent(lbThaydoiMatkhau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbQuenMatKhau))
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        JpLoginLayout.setVerticalGroup(
            JpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbChuaCoTaiKhoan)
                    .addComponent(lbDangky))
                .addGap(18, 18, 18)
                .addGroup(JpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuenMatKhau)
                    .addComponent(lbThaydoiMatkhau))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        JpLoginLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtPassword, txtUser});

        JpComponent.add(JpLogin, "cardLogin");
        JpComponent.add(JpdangKy, "cardDangky");
        JpComponent.add(JpquenMatKhau, "cardQuenMK");
        JpComponent.add(JpThayMatKhau, "cardThayMK");

        javax.swing.GroupLayout panelLogin1Layout = new javax.swing.GroupLayout(panelLogin1);
        panelLogin1.setLayout(panelLogin1Layout);
        panelLogin1Layout.setHorizontalGroup(
            panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogin1Layout.createSequentialGroup()
                .addContainerGap(386, Short.MAX_VALUE)
                .addComponent(JpComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLogin1Layout.setVerticalGroup(
            panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpComponent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Xác thuc dang nhap
    public static String xacNhanDangNhap;
    public static String xacNhanMatKhau;
    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void lbDangkyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangkyMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbDangkyMouseEntered

    private void lbDangkyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangkyMouseClicked
        // TODO add your handling code here:
        //gọi card đăng ký
        cardLayout.show(JpComponent, "cardDangky");

    }//GEN-LAST:event_lbDangkyMouseClicked

    private void lbDangkyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbDangkyFocusGained
        // TODO add your handling code here:
        this.lbDangky.setForeground(Color.red);
    }//GEN-LAST:event_lbDangkyFocusGained

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        String tenDangNhap = txtUser.getText().trim();
        String matKhau = new String(txtPassword.getPassword()).trim();

        if (tenDangNhap.isEmpty() || matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập và mật khẩu không được để trống.");
            return;
        }

// Kiểm tra định dạng tên đăng nhập
        String regexTenDangNhap = "^[a-zA-Z0-9]{4,50}$";// chấp nhận chữ và số 
        if (!tenDangNhap.matches(regexTenDangNhap)) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập chỉ chứa chữ cái, số và có độ dài từ 4-50 ký tự.");
            return;
        }

// Kiểm tra độ dài mật khẩu
        if (matKhau.length() < 8) {
            JOptionPane.showMessageDialog(null, "Mật khẩu phải có ít nhất 8 ký tự.");
            return;
        }

// Mã hóa tên đăng nhập và mật khẩu
        String enrTenDangNhap = null;
        String enrMatKhau = null;
        try {
            enrTenDangNhap = QuanLyTaiKhoanDao.MD5Encryptor(tenDangNhap);
            enrMatKhau = QuanLyTaiKhoanDao.MD5Encryptor(matKhau);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return; // Dừng lại nếu có lỗi trong quá trình mã hóa
        }

// Kiểm tra thông tin đăng nhập
        TaiKhoanController dangNhapController = new TaiKhoanController();
        boolean dangNhapThanhCong = dangNhapController.kiemTraDangNhap(enrTenDangNhap, enrMatKhau);

        if (dangNhapThanhCong) {
            Login.xacNhanDangNhap = tenDangNhap;
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
            JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(Login.this);
            if (mainFrame != null) {
                mainFrame.dispose();
               Main  main = null;
                try {
                    main = new Main();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            main.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Đăng nhập thất bại! Vui lòng kiểm tra lại tên đăng nhập và mật khẩu.");
        }

    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void lbQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuenMatKhauMouseClicked
        // TODO add your handling code here:
        cardLayout.show(JpComponent, "cardQuenMK");
    }//GEN-LAST:event_lbQuenMatKhauMouseClicked

    private void lbThaydoiMatkhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbThaydoiMatkhauMouseClicked
        // TODO add your handling code here:
        cardLayout.show(JpComponent, "cardThayMK");

    }//GEN-LAST:event_lbThaydoiMatkhauMouseClicked

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        if (image != null) {
            Rectangle size = getAutoSize(image);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(toImage(image), size.getLocation().x, size.getLocation().y, size.getSize().width, size.getSize().height, null);
        }
        int width = getWidth();
        int height = getHeight();
        Area area = new Area(new Rectangle2D.Double(0, 0, width, height));
        Rectangle rec = panelLogin1.getBounds();
        rec.setLocation(rec.x + 10, rec.y + 10);
        rec.setSize(rec.width - 20, rec.height - 20);
        area.subtract(new Area(rec));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g2.setColor(new Color(160, 160, 160));
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    private Rectangle getAutoSize(Icon image) {
        int w = getWidth();
        int h = getHeight();
        if (w > image.getIconWidth()) {
            w = image.getIconWidth();
        }
        if (h > image.getIconHeight()) {
            h = image.getIconHeight();
        }
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        int x = getWidth() / 2 - (width / 2);
        int y = getHeight() / 2 - (height / 2);
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpComponent;
    private javax.swing.JPanel JpLogin;
    private quan_ly_benh_vien.View.Login.Component.ThayMatKhau JpThayMatKhau;
    private quan_ly_benh_vien.View.Login.Component.DangKy JpdangKy;
    private quan_ly_benh_vien.View.Login.Component.QuenMatKhau JpquenMatKhau;
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbChuaCoTaiKhoan;
    private javax.swing.JLabel lbDangky;
    private javax.swing.JLabel lbQuenMatKhau;
    private javax.swing.JLabel lbThaydoiMatkhau;
    private quan_ly_benh_vien.View.Login.Component.PanelLogin panelLogin1;
    private quan_ly_benh_vien.View.Login.subComponent.MyPassword txtPassword;
    private quan_ly_benh_vien.View.Login.subComponent.MyTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
