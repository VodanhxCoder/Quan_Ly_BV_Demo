/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quan_ly_benh_vien.View.Main;

<<<<<<< HEAD
=======

>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
import quan_ly_benh_vien.View.bacSiJpanel;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
<<<<<<< HEAD
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import quan_ly_benh_vien.View.Main.Component.EventMenuSelected;
import quan_ly_benh_vien.View.benhNhanJpanel;
import quan_ly_benh_vien.View.DatLichKhampanel;
import quan_ly_benh_vien.View.BacSiKham;
import quan_ly_benh_vien.View.Login.Component.Login;
import quan_ly_benh_vien.View.thanhToanJpanel;
import quan_ly_benh_vien.View.thongTinTaiKhoanPanel;

=======
import quan_ly_benh_vien.View.Main.Component.EventMenuSelected;
import quan_ly_benh_vien.View.benhNhanJpanel;
import quan_ly_benh_vien.View.DatLichKhampanel;
import quan_ly_benh_vien.View.thanhToanJpanel;
import quan_ly_benh_vien.View.thongTinTaiKhoanPanel;


>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
/**
 *
 * @author khue1
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private DatLichKhampanel jpDatLich;
    private bacSiJpanel jpBacSi;
    private benhNhanJpanel jpBenhNhan;
    private thongTinTaiKhoanPanel jpThongTin;
<<<<<<< HEAD
    private BacSiKham jpBacSiKham;

    public Main() throws SQLException {
        initComponents();
        jpDatLich = new DatLichKhampanel(this);
        jpBacSi = new bacSiJpanel();
        jpBenhNhan = new benhNhanJpanel();
        jpThongTin = new thongTinTaiKhoanPanel();
        jpBacSiKham = new BacSiKham(this);
=======

    public Main() throws SQLException {
        initComponents();
        jpDatLich = new DatLichKhampanel();
        jpBacSi = new bacSiJpanel();
        jpBenhNhan = new benhNhanJpanel();
        jpThongTin = new thongTinTaiKhoanPanel();
       

>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
        menu1.initMoving(Main.this);
        menu1.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                System.out.println("Index= " + index);
                if (index == 0) {
<<<<<<< HEAD
                    setForm(new DatLichKhampanel(Main.this));
                } else if (index == 1) {
                    setForm(new BacSiKham(Main.this));
                } else if (index == 2) {
                    try {
                        setForm(new benhNhanJpanel());
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (index == 3) {
                    try {
                        setForm(new bacSiJpanel());
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (index == 6) {
                    setForm(jpThongTin);
                } else if (index == 8) {
                    DangXuat();
=======
                    setForm(jpDatLich);
                } else if (index == 1) {
                    setForm(jpBacSi);
                } else if (index == 2) {
                    setForm(jpBenhNhan);
                } else if (index == 3) {
                    setForm(jpBacSi);
                }
                else if (index ==6 ) {
                    setForm(jpThongTin);
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
                }
            }
        });
        //  set when system open start with home form
<<<<<<< HEAD
        setForm(new DatLichKhampanel(this));

    }

    public void setThanhToan() {
        setForm(new thanhToanJpanel());
    }

    public void KhamBenhNhan(String maBenhNhan) throws SQLException {

        benhNhanJpanel panel = new benhNhanJpanel();
        setForm(panel);

        // Thực thi lệnh sau khi panel đã được thêm vào
        SwingUtilities.invokeLater(() -> {
            System.out.println("Panel bệnh nhân đã được hiển thị!");
            panel.TimKiemVaChonBenhNhan(maBenhNhan);
        });
    }

    private void setForm(JComponent com) {
        if (com != null) {
            mainPanel.remove(com);  // Loại bỏ panel cũ
        }
=======
        setForm(new DatLichKhampanel());
       
    }
    public void setThanhToan(){
        setForm(new thanhToanJpanel());
    }
    private void setForm(JComponent com) {
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBackgroud = new javax.swing.JPanel();
        menu1 = new quan_ly_benh_vien.View.Main.Component.Menu();
        mainPanel = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpBackgroud.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGap(0, 629, Short.MAX_VALUE)
=======
            .addGap(0, 590, Short.MAX_VALUE)
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
        );

        mainPanel.add(jLayeredPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jpBackgroudLayout = new javax.swing.GroupLayout(jpBackgroud);
        jpBackgroud.setLayout(jpBackgroudLayout);
        jpBackgroudLayout.setHorizontalGroup(
            jpBackgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBackgroudLayout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBackgroudLayout.setVerticalGroup(
            jpBackgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
<<<<<<< HEAD
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
=======
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
<<<<<<< HEAD
private void DangXuat() {
        int option = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn đăng xuất?",
                "Xác nhận đăng xuất",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            // Nếu người dùng chọn "Đồng ý", thực hiện đăng xuất
            logout();
        } else {
            // Nếu người dùng chọn "Hủy", không làm gì cả
            System.out.println("Đã hủy đăng xuất");
        }
    }

    private void logout() {

        System.out.println("Đã đăng xuất!");

        this.dispose();
        quan_ly_benh_vien.View.Login.Main.Main loginFrame = new quan_ly_benh_vien.View.Login.Main.Main();
        loginFrame.setVisible(true);
    }
=======
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jpBackgroud;
    private javax.swing.JPanel mainPanel;
    private quan_ly_benh_vien.View.Main.Component.Menu menu1;
    // End of variables declaration//GEN-END:variables
}
