/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quan_ly_benh_vien.View;

import quan_ly_benh_vien.Controller.*;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import quan_ly_benh_vien.Model.*;
import quan_ly_benh_vien.Data_Access_Object.QuanLyTaiKhoanDao;
import quan_ly_benh_vien.View.Login.Component.DangKy;

/**
 *
 * @author LAPTOP
 */
public class benhNhanJpanel extends javax.swing.JPanel {

    private DefaultTableModel modelBenhNhan;

    public benhNhanJpanel() throws SQLException {
        modelBenhNhan = new DefaultTableModel();
        modelBenhNhan.addColumn("Mã Bênh Nhân");
        modelBenhNhan.addColumn("Họ Và Tên");
        modelBenhNhan.addColumn("Số Điện Thoại");
        modelBenhNhan.addColumn("Email");
        modelBenhNhan.addColumn("Ngày Sinh");
        modelBenhNhan.addColumn("Địa Chỉ");
        modelBenhNhan.addColumn("Giới Tính");
        modelBenhNhan.addColumn("Hình Ảnh");
        initComponents();
        loadBenhNhan();

    }
    private boolean isBenhNhanSelected = true;
    private String checkemail = "";

    public void loadBenhNhan() {
        checkemail = "";
        isBenhNhanSelected = true;
        // Thiết lập sự kiện cho JTable khi dòng được chọn
        jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting() && isBenhNhanSelected) {
                // Thực hiện chỉ khi bệnh nhân được chọn
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow >= 0 && jTable1.isRowSelected(selectedRow)) {
                    txtTenDangNhap.setEnabled(false);
                    txtMatKhau.setEnabled(false);

                    // Kiểm tra và gán giá trị từ JTable vào các biến tương ứng
                    String maBN = (jTable1.getValueAt(selectedRow, 0) != null) ? jTable1.getValueAt(selectedRow, 0).toString() : "";
                    String hoTen = (jTable1.getValueAt(selectedRow, 1) != null) ? jTable1.getValueAt(selectedRow, 1).toString() : "";
                    String soDienThoai = (jTable1.getValueAt(selectedRow, 2) != null) ? jTable1.getValueAt(selectedRow, 2).toString() : "";
                    String email = (jTable1.getValueAt(selectedRow, 3) != null) ? jTable1.getValueAt(selectedRow, 3).toString() : "";

                    // Kiểm tra null trước khi ép kiểu sang Date
                    Date ngaySinh = (jTable1.getValueAt(selectedRow, 4) != null) ? (Date) jTable1.getValueAt(selectedRow, 4) : null;

                    String diaChi = (jTable1.getValueAt(selectedRow, 5) != null) ? jTable1.getValueAt(selectedRow, 5).toString() : "";
                    String gioiTinh = (jTable1.getValueAt(selectedRow, 6) != null) ? jTable1.getValueAt(selectedRow, 6).toString() : "";
                    String hinhAnh = (jTable1.getValueAt(selectedRow, 7) != null) ? jTable1.getValueAt(selectedRow, 7).toString() : "";

                    // Gán giá trị vào các trường tương ứng
                    txtMaBN.setText(maBN);
                    txtHoVaTen.setText(hoTen);
                    txtSDT.setText(soDienThoai);
                    txtEmail.setText(email);
                    jDateBenhNhan.setDate(ngaySinh);
                    txtDiaChi.setText(diaChi);
                    //gán giá trị cho check email
                    checkemail = email;

                    // Xử lý giới tính
                    if (gioiTinh != null) {
                        switch (gioiTinh) {
                            case "Nam" -> {
                                if (!jradNam.isSelected()) {
                                    jradNam.setSelected(true);
                                    jradNu.setSelected(false);
                                }
                            }
                            case "Nữ" -> {
                                if (!jradNu.isSelected()) {
                                    jradNam.setSelected(false);
                                    jradNu.setSelected(true);
                                }
                            }
                            default -> {
                                jradNam.setSelected(false);
                                jradNu.setSelected(false);
                            }
                        }
                    }

                    // Hiển thị hình ảnh
                    if (hinhAnh != null && !hinhAnh.isEmpty()) {
                        ImageIcon imageIcon = new ImageIcon(hinhAnh);
                        lbTaiAnh.setIcon(imageIcon);
                    }

                    // Đặt giá trị cho ô tìm kiếm và các trường khác
                    txtTimKiem.setText(maBN);
                    txtTieuSu.setText("");
                    txtTrieuChung.setText("");
                    txtChuanDoan.setText("");
                    txtKetLuan.setText("");
                    txtMaBacSi.setText("");
                    txtMaBNBA.setText("");
                    txtMaBenhAn.setText("");
                }
            }
        });
    }

    public void loadHoSo() {
        isBenhNhanSelected = false;
        // Thiết lập sự kiện cho JTable khi dòng được chọn
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && !isBenhNhanSelected) {
                    // Thực hiện chỉ khi hồ sơ được chọn
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow >= 0 && jTable1.isRowSelected(selectedRow)) {
                        if (radBenhAn.isSelected()) {
                            // Kiểm tra nếu giá trị trong ô không phải null
                            String maBenhAn = jTable1.getValueAt(selectedRow, 0) != null ? jTable1.getValueAt(selectedRow, 0).toString() : "";
                            String maBacSi = jTable1.getValueAt(selectedRow, 1) != null ? jTable1.getValueAt(selectedRow, 1).toString() : "";
                            String maBNBA = jTable1.getValueAt(selectedRow, 2) != null ? jTable1.getValueAt(selectedRow, 2).toString() : "";
                            String trieuChung = jTable1.getValueAt(selectedRow, 3) != null ? jTable1.getValueAt(selectedRow, 3).toString() : "";
                            String tieuSu = jTable1.getValueAt(selectedRow, 4) != null ? jTable1.getValueAt(selectedRow, 4).toString() : "";
                            String chuanDoan = jTable1.getValueAt(selectedRow, 5) != null ? jTable1.getValueAt(selectedRow, 5).toString() : "";
                            String ketLuan = jTable1.getValueAt(selectedRow, 6) != null ? jTable1.getValueAt(selectedRow, 6).toString() : "";

                            txtMaBenhAn.setText(maBenhAn);
                            txtMaBacSi.setText(maBacSi);
                            txtMaBNBA.setText(maBNBA);
                            txtTrieuChung.setText(trieuChung);
                            txtTieuSu.setText(tieuSu);
                            txtChuanDoan.setText(chuanDoan);
                            txtKetLuan.setText(ketLuan);
                            txtTimKiem.setText(maBenhAn); // Tự động điền mã bệnh án vào ô tìm kiếm
                        }
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaBN = new javax.swing.JTextField();
        txtHoVaTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaBenhAn = new javax.swing.JTextField();
        txtMaBacSi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lbTaiAnh = new javax.swing.JLabel();
        jbTaiAnh = new javax.swing.JButton();
        txtTrieuChung = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTieuSu = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtChuanDoan = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtKetLuan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbThem = new javax.swing.JButton();
        jbSua = new javax.swing.JButton();
        jbXem = new javax.swing.JButton();
        jbXoa = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jbTimKiem = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtMaBNBA = new javax.swing.JTextField();
        jradNam = new javax.swing.JRadioButton();
        jradNu = new javax.swing.JRadioButton();
        radBenhNhan = new javax.swing.JRadioButton();
        radBenhAn = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jLabel20 = new javax.swing.JLabel();
        jDateBenhNhan = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(960, 465));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Thông tin bệnh nhân");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Danh Sách Bệnh Nhân & Bệnh Án");

        jLabel3.setText("Mã Bệnh Nhân:");

        jLabel4.setText("Họ Và Tên:");

        jLabel5.setText("SDT:");

        jLabel6.setText("Địa Chỉ:");

        jLabel7.setText("Giới Tính");

        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Thông Tin Bệnh Án");

        txtMaBN.setEnabled(false);

        jLabel10.setText("Mã Bệnh Án:");

        jLabel11.setText("Mã Bác Sĩ:");

        txtMaBenhAn.setEnabled(false);

        jLabel12.setText("Triệu Chứng : ");

        lbTaiAnh.setBackground(new java.awt.Color(102, 102, 102));
        lbTaiAnh.setText("Tải ảnh ở đây");
        lbTaiAnh.setOpaque(true);

        jbTaiAnh.setText("Tải Ảnh");
        jbTaiAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTaiAnhActionPerformed(evt);
            }
        });

        txtTrieuChung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrieuChungActionPerformed(evt);
            }
        });

        jLabel13.setText("Tiểu Sử:");

        jLabel14.setText("Chuẩn Đoán:");

        jLabel15.setText("Kết Luận:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jbThem.setText("Thêm");
        jbThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbThemActionPerformed(evt);
            }
        });

        jbSua.setText("Sửa");
        jbSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSuaActionPerformed(evt);
            }
        });

        jbXem.setText("Xem");
        jbXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbXemActionPerformed(evt);
            }
        });

        jbXoa.setText("Xóa");
        jbXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbXoaActionPerformed(evt);
            }
        });

        jLabel16.setText("Tìm Kiếm Theo Mã ");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jbTimKiem.setText("Tìm Kiếm");
        jbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTimKiemActionPerformed(evt);
            }
        });

        jLabel17.setText("Mã Bệnh Nhân:");

        txtMaBNBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaBNBAActionPerformed(evt);
            }
        });

        buttonGroup1.add(jradNam);
        jradNam.setText("Nam");

        buttonGroup1.add(jradNu);
        jradNu.setText("Nữ");

        buttonGroup2.add(radBenhNhan);
        radBenhNhan.setText("Bệnh Nhân");

        buttonGroup2.add(radBenhAn);
        radBenhAn.setText("Bệnh Án");

        jLabel18.setText("Tên đăng nhập:");

        jLabel19.setText("Mật Khẩu:");

        jLabel20.setText("Ngày Sinh: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jradNam)
                                                .addGap(18, 18, 18)
                                                .addComponent(jradNu)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jDateBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtHoVaTen)
                                            .addComponent(txtSDT)
                                            .addComponent(txtDiaChi)
                                            .addComponent(txtMaBN)
                                            .addComponent(txtEmail))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(lbTaiAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbTaiAnh)
                                                .addGap(20, 20, 20))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                        .addComponent(txtTenDangNhap, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaBenhAn)
                                            .addComponent(txtMaBacSi, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMaBNBA, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTieuSu)
                                    .addComponent(txtChuanDoan)
                                    .addComponent(txtKetLuan)
                                    .addComponent(txtTrieuChung)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(60, 60, 60)
                                            .addComponent(radBenhNhan)
                                            .addGap(63, 63, 63)
                                            .addComponent(radBenhAn))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jbThem)
                                            .addGap(38, 38, 38)
                                            .addComponent(jbSua)
                                            .addGap(40, 40, 40)
                                            .addComponent(jbXem)))
                                    .addGap(18, 18, 18)
                                    .addComponent(jbXoa)))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbTimKiem))
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radBenhNhan)
                            .addComponent(radBenhAn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbThem)
                            .addComponent(jbSua)
                            .addComponent(jbXem)
                            .addComponent(jbXoa))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbTimKiem)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTaiAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbTaiAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtMaBN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jradNam)
                                        .addComponent(jradNu)
                                        .addComponent(jLabel7)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtMaBenhAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMaBacSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txtMaBNBA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTrieuChung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtTieuSu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txtChuanDoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKetLuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(23, 23, 23))))
        );
    }// </editor-fold>//GEN-END:initComponents
    private String selectedImagePath;

    private void jbTaiAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTaiAnhActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        // Đặt bộ lọc để chỉ cho phép chọn các tệp hình ảnh
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Hình ảnh", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        // Hiển thị hộp thoại chọn tệp
        int result = fileChooser.showOpenDialog(this);

        // Kiểm tra xem người dùng đã chọn tệp hay chưa
        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn đến tệp hình ảnh được chọn
            File selectedFile = fileChooser.getSelectedFile();
            selectedImagePath = selectedFile.getAbsolutePath();

            // Hiển thị hình ảnh trên JLabel
            ImageIcon imageIcon = new ImageIcon(selectedImagePath);
            lbTaiAnh.setIcon(imageIcon);
        }

    }//GEN-LAST:event_jbTaiAnhActionPerformed

    private void jbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTimKiemActionPerformed
        String idTimKiem = txtTimKiem.getText().trim();
        if (idTimKiem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập id bác sĩ để tìm kiếm bệnh nhân: ");
        }
        if (radBenhNhan.isSelected()) {
            //ArrayList<benhNhanModel> danhSachBenhNhan;
            benhNhanModel benhnhan = new benhNhanModel();
            //    bacSiController bsControlcler = new bacSiController();
            benhNhanController benhnhanctroller = new benhNhanController();
            modelBenhNhan.setRowCount(0);
            if (benhnhanctroller.kiemTraMaBenhNhanTrung(idTimKiem) ) {
                //  benhNhanController benhNhanController = new benhNhanController();
                benhnhan = benhnhanctroller.timBenhNhanTheoID(idTimKiem);

                modelBenhNhan.addRow(new Object[]{
                    benhnhan.getMaBenhNhan(),
                    benhnhan.getHoVaTen(),
                    benhnhan.getSoDienThoai(),
                    benhnhan.getEmail(),
                    benhnhan.getNgaySinh(),
                    benhnhan.getDiachi(),
                    benhnhan.getGioiTinh(),
                    benhnhan.getHinhAnh()
                });

                jTable1.setModel(modelBenhNhan);
                jTable1.setAutoscrolls(true);
                loadBenhNhan();
            } else {
                JOptionPane.showMessageDialog(null, "bệnh nhân bạn tìm không tồn tại");
            }
        } else if (radBenhAn.isSelected()) {
            ArrayList<hosoBenhAnModel> danhsachsoso;
            bacSiController bsController = new bacSiController();
            benhNhanController benhNhanController = new benhNhanController();
            if (benhNhanController.kiemTraMaBenhNhanTrung(idTimKiem) || "".equals(idTimKiem)) {
                benhAnController benhAnController = new benhAnController();
                danhsachsoso = benhAnController.layDanhSachHoSoTheoBenhNhan(idTimKiem);
                DefaultTableModel customModel = new DefaultTableModel();
                customModel.addColumn("Mã hồ sơ");
                customModel.addColumn("Mã bác sĩ");
                customModel.addColumn("Mã bệnh nhân");
                customModel.addColumn("Triệu chứng");
                customModel.addColumn("Tiền sử bệnh án");
                customModel.addColumn("Chuẩn đoán");
                customModel.addColumn("Kết luận");

                for (hosoBenhAnModel hoso : danhsachsoso) {
                    customModel.addRow(new Object[]{
                        hoso.getMaHoSo(),
                        hoso.getMaBacSi(),
                        hoso.getMaBenhNhan(),
                        hoso.getTrieuChung(),
                        hoso.getTienSuBenhAn(),
                        hoso.getChuanDoan(),
                        hoso.getKetLuan()
                    });
                }
                jTable1.setModel(customModel);
                jTable1.setAutoscrolls(true);
                loadHoSo();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn bệnh án hoặc bênh nhân để hiển thị");
        }
    }//GEN-LAST:event_jbTimKiemActionPerformed

    private void jbThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbThemActionPerformed
        if (radBenhAn.isSelected()) {
            themHoSo();
            hienthiDanhSachHoSo();
        } else if (radBenhNhan.isSelected()) {
            themBenhNhan();
            hienthiDanhSachBenhNhan();
        } else {
            JOptionPane.showMessageDialog(null, "chọn bệnh án hoặc bệnh nhân không được để trống ");
        }
    }//GEN-LAST:event_jbThemActionPerformed

    private void txtTrieuChungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrieuChungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrieuChungActionPerformed

    private void jbSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSuaActionPerformed
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Không có đối tượng được chọn trong bảng");
            return;
        }
        if (radBenhAn.isSelected()) {
            suaHoSo();
        } else if (radBenhNhan.isSelected()) {
            suaBenhNhan();
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân hoặc bệnh án !");
        }
    }//GEN-LAST:event_jbSuaActionPerformed

    private void jbXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbXemActionPerformed
        txtTenDangNhap.setEnabled(true);
        txtMatKhau.setEnabled(true);
        reset();
        if (radBenhAn.isSelected()) {
            benhAnController benhAnController = new benhAnController();
            ArrayList<hosoBenhAnModel> dshs = benhAnController.layDanhSachHoSo();

            DefaultTableModel customModel = new DefaultTableModel();
            customModel.addColumn("Mã hồ sơ");
            customModel.addColumn("Mã bác sĩ");
            customModel.addColumn("Mã bệnh nhân");
            customModel.addColumn("Triệu chứng");
            customModel.addColumn("Tiền sử bệnh án");
            customModel.addColumn("Chuẩn đoán");
            customModel.addColumn("Kết luận");

            for (hosoBenhAnModel hs : dshs) {
                customModel.addRow(new Object[]{
                    hs.getMaHoSo(),
                    hs.getMaBacSi(),
                    hs.getMaBenhNhan(),
                    hs.getTrieuChung(),
                    hs.getTienSuBenhAn(),
                    hs.getChuanDoan(),
                    hs.getKetLuan()
                });
            }
            jTable1.setModel(customModel);
            jTable1.setAutoscrolls(true);
            loadHoSo();
        } else if (radBenhNhan.isSelected()) {
            benhNhanController benhNhanController = new benhNhanController();
            ArrayList<benhNhanModel> dsbn = benhNhanController.layDanhSachBenhNhan();
            modelBenhNhan.setRowCount(0);
            for (benhNhanModel benhnhan : dsbn) {
                modelBenhNhan.addRow(new Object[]{
                    benhnhan.getMaBenhNhan(),
                    benhnhan.getHoVaTen(),
                    benhnhan.getSoDienThoai(),
                    benhnhan.getEmail(),
                    benhnhan.getNgaySinh(),
                    benhnhan.getDiachi(),
                    benhnhan.getGioiTinh(),
                    benhnhan.getHinhAnh()
                });
            }
            jTable1.setModel(modelBenhNhan);
            jTable1.setAutoscrolls(true);
            loadBenhNhan();
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chon bệnh án hoặc bệnh nhân.");
        }
    }//GEN-LAST:event_jbXemActionPerformed

    private void jbXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbXoaActionPerformed

        if (radBenhNhan.isSelected()) {
            String idXoa = txtMaBN.getText().trim();
            if (idXoa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập Id bệnh nhân để xóa");
            } else {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Nếu xóa bệnh nhân này, hệ thống sẽ xóa lịch khám liên quan đến bệnh nhân đó.\nBạn có chắc chắn muốn xóa?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION
                );
                if (choice == JOptionPane.YES_OPTION) {
                    benhNhanController benhnhanController = new benhNhanController();
                    int rowsAffected = benhnhanController.xoaBenhNhanTheoID(idXoa);
                    System.out.println("So cot du lieu thay doi: " + rowsAffected);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Xóa  Thành Công");
                        hienthiDanhSachBenhNhan();
                        reset();
                    } else if (rowsAffected == -1) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân có ID: " + idXoa);
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa bệnh nhân thất bại.");
                    }
                }
            }
        } else if (radBenhAn.isSelected()) {
            String idXoa = txtMaBenhAn.getText().trim();
            if (idXoa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần xóa.");
            } else {
                benhAnController benhAnController = new benhAnController();

                int rowsAffected = benhAnController.xoaHoSoTheoId(idXoa);
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Xóa bệnh án thành công.");
                    hienthiDanhSachHoSo();
                    reset();

                } else if (rowsAffected == -1) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh án có ID: " + idXoa);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa bệnh án thất bại.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chọn Bệnh Án hoặc Bệnh Nhân để xóa");
        }
    }//GEN-LAST:event_jbXoaActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        String idTimKiem = txtTimKiem.getText().trim();
        if (idTimKiem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần tìm kiếm.");
        }

        if (radBenhNhan.isSelected()) {
            timBenhNhanTheoId(idTimKiem);
            loadBenhNhan();
        } else if (radBenhAn.isSelected()) {
            timHoSoTheoId(idTimKiem);
            loadHoSo();
        } else {
            JOptionPane.showMessageDialog(null, "Vui chọn để tìm.");
        }
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtMaBNBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaBNBAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaBNBAActionPerformed

    public void timBenhNhanTheoId(String idTimKiem) {
        benhNhanController benhNhanController = new benhNhanController();
        benhNhanModel benhNhanTimKiem = benhNhanController.timBenhNhanTheoID(idTimKiem);

        modelBenhNhan.setRowCount(0);
        if (benhNhanTimKiem != null) {

            modelBenhNhan.addRow(new Object[]{
                benhNhanTimKiem.getMaBenhNhan(),
                benhNhanTimKiem.getHoVaTen(),
                benhNhanTimKiem.getSoDienThoai(),
                benhNhanTimKiem.getEmail(),
                benhNhanTimKiem.getNgaySinh(),
                benhNhanTimKiem.getDiachi(),
                benhNhanTimKiem.getGioiTinh(),
                benhNhanTimKiem.getHinhAnh()}
            );

            jTable1.setModel(modelBenhNhan);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân có ID: " + idTimKiem);
        }
    }

    public void timHoSoTheoId(String idTimKiem) {
        benhAnController hoSoBenhAnController = new benhAnController();
        hosoBenhAnModel hoSoTimKiem = hoSoBenhAnController.timHoSoTheoID(idTimKiem);

        if (hoSoTimKiem != null) {
            DefaultTableModel customModel = new DefaultTableModel();
            customModel.addColumn("Mã hồ sơ");
            customModel.addColumn("Mã bác sĩ");
            customModel.addColumn("Mã bệnh nhân");
            customModel.addColumn("Triệu chứng");
            customModel.addColumn("Tiền sử bệnh án");
            customModel.addColumn("Chuẩn đoán");
            customModel.addColumn("Kết luận");

            customModel.addRow(new Object[]{
                hoSoTimKiem.getMaHoSo(),
                hoSoTimKiem.getMaBacSi(),
                hoSoTimKiem.getMaBenhNhan(),
                hoSoTimKiem.getTrieuChung(),
                hoSoTimKiem.getTienSuBenhAn(),
                hoSoTimKiem.getChuanDoan(),
                hoSoTimKiem.getKetLuan()}
            );

            jTable1.setModel(customModel);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy hồ sơ có ID: " + idTimKiem);
        }
    }

    private void reset() {
        txtMaBN.setText("");
        txtMaBNBA.setText("");
        txtMaBenhAn.setText("");
        txtHoVaTen.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        txtMaBacSi.setText("");
        jDateBenhNhan.setDate(null);
//        buttonGroup1.clearSelection();
//        buttonGroup2.clearSelection();
        txtTrieuChung.setText("");
        txtChuanDoan.setText("");
        txtKetLuan.setText("");
        txtTieuSu.setText("");
        // xóa icon ảnh
        lbTaiAnh.setIcon(null);
        txtTimKiem.setText("");

        txtTenDangNhap.setText("");
        txtMatKhau.setText("");
    }

    public void themBenhNhan() {
        String hoTen = txtHoVaTen.getText();
        String soDienThoai = txtSDT.getText();
        String email = txtEmail.getText();
        Date ngaySinh = jDateBenhNhan.getDate();
        String gioiTinh;
        String diaChi = txtDiaChi.getText();
        String hinhAnh;
        String tenDangNhap = txtTenDangNhap.getText();
        String MatKhau = txtMatKhau.getText();
        if (jradNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (jradNu.isSelected()) {
            gioiTinh = "Nữ";
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn giới tính!");
            System.out.println("loi gioi Tinh");
            return;  // Thoát phương thức nếu chưa chọn giới tính
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

        if (!DangKy.validateRegistration(hoTen, tenDangNhap, MatKhau, email, gioiTinh)) {
            System.out.println("Loi validate");
            return;
        }

        try {
            tenDangNhap = QuanLyTaiKhoanDao.MD5Encryptor(txtTenDangNhap.getText());
            MatKhau = QuanLyTaiKhoanDao.MD5Encryptor(txtMatKhau.getText());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(benhNhanJpanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(benhNhanJpanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        TaiKhoanController dangKyController = new TaiKhoanController();
        boolean tenDaTonTai = dangKyController.kiemTraTenDangNhapTrung(tenDangNhap);
        boolean emailDaTonTai = dangKyController.kiemTraEmailTrung(email);

        if (tenDaTonTai) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại!");
        } else if (emailDaTonTai) {
            JOptionPane.showMessageDialog(null, "Email đã tồn tại!");
        } else {

            hinhAnh = null;
            benhNhanController bncontroller = new benhNhanController();
            TaiKhoanController tkcontroller = new TaiKhoanController();

            benhNhanModel bnModel = new benhNhanModel(tenDangNhap, hoTen, soDienThoai, email, ngaySinh, gioiTinh, diaChi, hinhAnh);
            QuanLyTaiKhoanModel taikhoan = new QuanLyTaiKhoanModel(hoTen, tenDangNhap, MatKhau, email, gioiTinh);
            int rowAffected1 = tkcontroller.dangKyTaiKhoan(taikhoan, true);
            int rowAffected = benhNhanController.themBenhNhan(bnModel);

            if (rowAffected > 0 && rowAffected1 > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại");

            }

        }
    }

    public void themHoSo() {
        String maHoSo = txtMaBenhAn.getText();
        String maBenhNhan = txtMaBNBA.getText();
        String maBacSi = txtMaBacSi.getText();
        String trieuChung = txtTrieuChung.getText();
        String tieuSuBenhAn = txtTieuSu.getText();
        String chuanDoan = txtChuanDoan.getText();
        String ketLuan = txtKetLuan.getText();

        if (maBenhNhan.isEmpty() || maBacSi.isEmpty() || trieuChung.isEmpty() || tieuSuBenhAn.isEmpty() || chuanDoan.isEmpty() || ketLuan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "moi nhap du thong tin");
        } else {
            benhAnController baController = new benhAnController();
            bacSiController bsController = new bacSiController();
            benhNhanController bnController = new benhNhanController();

            boolean maTonTai = baController.kiemTraMaHoSoTrung(maHoSo);
            boolean maBacSiNULL = bsController.KtraTrungLap("maBacSi", maBacSi);
            boolean maBenhNhanNULL = bnController.kiemTraMaBenhNhanTrung(maBenhNhan);

            if (maTonTai) {
                JOptionPane.showMessageDialog(null, "Mã Hồ Sơ Tồn Tại");
                return;
            }
            if (!maBacSiNULL) {
                JOptionPane.showMessageDialog(null, "Mã bác sĩ không tồn tạo trong cơ sở dữ liệu");
                return;
            }
            if (!maBenhNhanNULL) {
                JOptionPane.showMessageDialog(null, "Mã bệnh nhân không tồn tạo trong cơ sở dữ liệu");
                return;
            }
            try {
                hosoBenhAnModel hoSo = new hosoBenhAnModel(maHoSo, tieuSuBenhAn, trieuChung, chuanDoan, ketLuan, maBenhNhan, maBacSi);
                int rowsAffected = baController.themHoSo(hoSo);
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Thêm Thành Công");
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi: " + e.getMessage());
                e.printStackTrace(); // In ra console để dễ debug
            }

        }
    }

    private void hienthiDanhSachBenhNhan() {
        benhNhanController benhNhanController = new benhNhanController();
        ArrayList<benhNhanModel> danhsachBenhNhan = benhNhanController.layDanhSachBenhNhan();

        modelBenhNhan.setRowCount(0);
        for (benhNhanModel benhNhan : danhsachBenhNhan) {
            modelBenhNhan.addRow(new Object[]{
                benhNhan.getMaBenhNhan(),
                benhNhan.getHoVaTen(),
                benhNhan.getSoDienThoai(),
                benhNhan.getEmail(),
                benhNhan.getNgaySinh(),
                benhNhan.getDiachi(),
                benhNhan.getGioiTinh(),
                benhNhan.getHinhAnh()
            });
        }
        jTable1.setModel(modelBenhNhan);
        jTable1.setAutoscrolls(true);
    }

    private void hienthiDanhSachHoSo() {
        benhAnController benhAnController = new benhAnController();
        ArrayList<hosoBenhAnModel> danhsachHoSo = benhAnController.layDanhSachHoSo();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã hồ sơ");
        model.addColumn("Mã bác sĩ");
        model.addColumn("Mã bệnh nhân");
        model.addColumn("Triệu chứng");
        model.addColumn("Tiền sử bệnh án");
        model.addColumn("Chuẩn đoán");
        model.addColumn("Kết luận");

        for (hosoBenhAnModel hoso : danhsachHoSo) {
            model.addRow(new Object[]{
                hoso.getMaHoSo(),
                hoso.getMaBacSi(),
                hoso.getMaBenhNhan(),
                hoso.getTrieuChung(),
                hoso.getTienSuBenhAn(),
                hoso.getChuanDoan(),
                hoso.getKetLuan()
            });
        }
        jTable1.setModel(model);
        jTable1.setAutoscrolls(true);
    }

    public void suaBenhNhan() {

        String hoVaTen = txtHoVaTen.getText();
        String maBenhNhan = txtMaBN.getText();
        String soDienThoai = txtSDT.getText();
        String email = txtEmail.getText();
        Date ngaySinh = jDateBenhNhan.getDate();
        String gioiTinh = null;
        String diaChi = txtDiaChi.getText();
        String hinhAnh = null;
        String tenDangNhap = null;

        if (jradNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (jradNu.isSelected()) {
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

        benhNhanModel bnModel = new benhNhanModel(tenDangNhap, hoVaTen, soDienThoai, email, ngaySinh, gioiTinh, diaChi, hinhAnh);
        benhNhanController benhNhanController = new benhNhanController();
        int rowsAffected = benhNhanController.capNhatThongTinBenhNhan(bnModel, maBenhNhan);

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin bệnh nhân thành công.");
            hienthiDanhSachBenhNhan();
            reset();
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân có ID: " + maBenhNhan);
        }

    }

    private boolean validateInputBenhAn(String maBenhNhan, String maBacSi, String trieuChung, String tieuSuBenhAn, String chuanDoan, String ketLuan) {

        // Kiểm tra các trường bắt buộc không được bỏ trống
        if (maBenhNhan.isEmpty() || maBacSi.isEmpty()
                || trieuChung.isEmpty() || tieuSuBenhAn.isEmpty() || chuanDoan.isEmpty() || ketLuan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!maBenhNhan.matches("^[a-zA-Z0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Mã bệnh nhân không hợp lệ. Chỉ chứa chữ cái và số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!maBacSi.matches("^[a-zA-Z0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Mã bác sĩ không hợp lệ. Chỉ chứa chữ cái và số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Nếu tất cả các kiểm tra đều hợp lệ
        return true;
    }

    public void suaHoSo() {
        String maHoSo = txtMaBenhAn.getText();
        String maBenhNhan = txtMaBNBA.getText();
        String maBacSi = txtMaBacSi.getText();
        String trieuChung = txtTrieuChung.getText();
        String tieuSuBenhAn = txtTieuSu.getText();
        String chuanDoan = txtChuanDoan.getText();
        String ketLuan = txtKetLuan.getText();
        if (!validateInputBenhAn(maBenhNhan, maBacSi, trieuChung, tieuSuBenhAn, chuanDoan, ketLuan)) {
            return;
        }

        bacSiController bsController = new bacSiController();
        benhNhanController bnController = new benhNhanController();

        boolean maBacSiNULL = bsController.KtraTrungLap("maBacSi", maBacSi);
        boolean maBenhNhanNULL = bnController.kiemTraMaBenhNhanTrung(maBenhNhan);

        if (!maBacSiNULL) {
            JOptionPane.showMessageDialog(null, "Mã bác sĩ không tồn tạo trong cơ sở dữ liệu");
            return;
        }
        if (!maBenhNhanNULL) {
            JOptionPane.showMessageDialog(null, "Mã bệnh nhân không tồn tạo trong cơ sở dữ liệu");
            return;
        }
        hosoBenhAnModel hoSo = new hosoBenhAnModel(maHoSo, tieuSuBenhAn, trieuChung, chuanDoan, ketLuan, maBenhNhan, maBacSi);
        benhAnController benhAnController = new benhAnController();

        int rowsAffected = benhAnController.capNhatThongTinHoSo(hoSo, maHoSo);

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin hồ sơ thành công.");
            hienthiDanhSachHoSo();
            reset();
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy hồ sơ có ID: " + maHoSo);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.Box.Filler filler1;
    private com.toedter.calendar.JDateChooser jDateBenhNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbSua;
    private javax.swing.JButton jbTaiAnh;
    private javax.swing.JButton jbThem;
    private javax.swing.JButton jbTimKiem;
    private javax.swing.JButton jbXem;
    private javax.swing.JButton jbXoa;
    private javax.swing.JRadioButton jradNam;
    private javax.swing.JRadioButton jradNu;
    private javax.swing.JLabel lbTaiAnh;
    private javax.swing.JRadioButton radBenhAn;
    private javax.swing.JRadioButton radBenhNhan;
    private javax.swing.JTextField txtChuanDoan;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtKetLuan;
    private javax.swing.JTextField txtMaBN;
    private javax.swing.JTextField txtMaBNBA;
    private javax.swing.JTextField txtMaBacSi;
    private javax.swing.JTextField txtMaBenhAn;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTieuSu;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTrieuChung;
    // End of variables declaration//GEN-END:variables

}
