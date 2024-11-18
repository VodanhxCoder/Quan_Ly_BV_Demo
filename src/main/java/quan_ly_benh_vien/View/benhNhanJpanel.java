/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quan_ly_benh_vien.View;

import quan_ly_benh_vien.Controller.*;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import quan_ly_benh_vien.Model.*;
import quan_ly_benh_vien.View.Login.Component.Login;
import static quan_ly_benh_vien.View.Login.Component.Login.xacNhanDangNhap;

/**
 *
 * @author LAPTOP
 */
public class benhNhanJpanel extends javax.swing.JPanel {

    public benhNhanJpanel()throws SQLException {
        initComponents();
    }
    private boolean isBenhNhanSelected = true;
    
       public void loadBenhNhan() {
        isBenhNhanSelected = true;
        // Thiết lập sự kiện cho JTable khi dòng được chọn
        jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting() && isBenhNhanSelected) {
                // Thực hiện chỉ khi bệnh nhân được chọn
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow >= 0 && jTable1.isRowSelected(selectedRow)) {
                    txtMaBN.setText(jTable1.getValueAt(selectedRow, 0).toString());
                    txtHoVaTen.setText(jTable1.getValueAt(selectedRow, 1).toString());
                    txtSDT.setText(jTable1.getValueAt(selectedRow, 2).toString());
                    txtEmail.setText(jTable1.getValueAt(selectedRow, 3).toString());
                    txtDiaChi.setText(jTable1.getValueAt(selectedRow, 4).toString());
                    
                    String gioiTinh = (String) jTable1.getValueAt(selectedRow, 5);
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
                    String hinhAnh = (String) jTable1.getValueAt(selectedRow, 6);
                    if (hinhAnh != null) {
                        ImageIcon imageIcon = new ImageIcon(hinhAnh);
                        lbTaiAnh.setIcon(imageIcon);
                    }
                    txtTimKiem.setText(txtMaBN.getText());
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
                        txtMaBenhAn.setText(jTable1.getValueAt(selectedRow, 0).toString());
                        txtMaBacSi.setText(jTable1.getValueAt(selectedRow, 1).toString());
                        txtMaBNBA.setText(jTable1.getValueAt(selectedRow, 2).toString());
                        txtTrieuChung.setText(jTable1.getValueAt(selectedRow, 3).toString());
                        txtTieuSu.setText(jTable1.getValueAt(selectedRow, 4).toString());
                        txtChuanDoan.setText(jTable1.getValueAt(selectedRow, 5).toString());
                        txtKetLuan.setText(jTable1.getValueAt(selectedRow, 6).toString());
                        txtTimKiem.setText(txtMaBenhAn.getText());
                        txtHoVaTen.setText("");
                        txtSDT.setText("");
                        txtDiaChi.setText("");
                        txtMaBN.setText("");
                        // buttonGroup2.clearSelection();
                        lbTaiAnh.setIcon(null);
                        txtEmail.setText("");
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
        jPanel1 = new javax.swing.JPanel();
        jCheckBoxBenhNhan = new javax.swing.JRadioButton();
        jCheckBoxBenhAn = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        txtDangNhap = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jradNu = new javax.swing.JRadioButton();
        jradNam = new javax.swing.JRadioButton();

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

        jLabel10.setText("Mã Bệnh Án:");

        jLabel11.setText("Mã Bác Sĩ:");

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup2.add(jCheckBoxBenhNhan);
        jCheckBoxBenhNhan.setText("Bệnh Nhân");

        buttonGroup2.add(jCheckBoxBenhAn);
        jCheckBoxBenhAn.setText("Bệnh Án");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jCheckBoxBenhNhan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jCheckBoxBenhAn)
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxBenhNhan)
                    .addComponent(jCheckBoxBenhAn)))
        );

        jLabel18.setText("Tên Đăng Nhập");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(jradNu);
        jradNu.setText("Nữ");

        buttonGroup1.add(jradNam);
        jradNam.setText("Nam");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jradNam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jradNu)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jradNu)
                    .addComponent(jradNam)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTrieuChung)
                                            .addComponent(txtMaBNBA, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
                                    .addComponent(txtTieuSu)
                                    .addComponent(txtChuanDoan)
                                    .addComponent(txtKetLuan)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel18))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                            .addComponent(txtEmail)
                                            .addComponent(txtMaBN)
                                            .addComponent(txtHoVaTen)
                                            .addComponent(txtSDT)
                                            .addComponent(txtDangNhap)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jbTaiAnh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTaiAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbThem)
                                .addGap(38, 38, 38)
                                .addComponent(jbSua)
                                .addGap(40, 40, 40)
                                .addComponent(jbXem)
                                .addGap(18, 18, 18)
                                .addComponent(jbXoa)))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbTimKiem)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbThem)
                            .addComponent(jbSua)
                            .addComponent(jbXem)
                            .addComponent(jbXoa))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChuanDoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbTimKiem)
                            .addComponent(jLabel15)
                            .addComponent(txtKetLuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTaiAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbTaiAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtMaBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrieuChung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(txtMaBenhAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMaBacSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txtMaBNBA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtTieuSu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84))))
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
        if(idTimKiem.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập id bác sĩ để tìm kiếm bệnh nhân: ");
        }
        if(jCheckBoxBenhNhan.isSelected()){
             ArrayList<benhNhanModel> danhSachBenhNhan;
               bacSiController bsController = new bacSiController();
                  if(bsController.kiemTraMaBacSiTrung(idTimKiem)||"".equals(idTimKiem)){
              benhNhanController benhNhanController = new benhNhanController();
              danhSachBenhNhan = benhNhanController.layDanhSachBenhNhanDuocBacSiKham(idTimKiem);
              
              
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã Bênh Nhân");
            model.addColumn("Họ Và Tên");
            model.addColumn("Số Điện Thoại");
            model.addColumn("Email");
            model.addColumn("Địa Chỉ");
            model.addColumn("Giới Tính");
            model.addColumn("Hình Ảnh");
            
            for(benhNhanModel benhnhan : danhSachBenhNhan){
                model.addRow(new Object[]{
                    benhnhan.getMaBenhNhan(),
                    benhnhan.getHoVaTen(),
                    benhnhan.getSoDienThoai(),
                    benhnhan.getEmail(),
                    benhnhan.getDiachi(),
                    benhnhan.getGioiTinh(),
                    benhnhan.getHinhAnh()
                });
            }
            jTable1.setModel(model);
            jTable1.setAutoscrolls(true);
            loadBenhNhan();
        }else{
            JOptionPane.showMessageDialog(null, "bác sĩ bạn tìm không tồn tại");
            }
        }else if(jCheckBoxBenhAn.isSelected()){
            ArrayList<hosoBenhAnModel> danhsachsoso;
            bacSiController bsController = new bacSiController();
            benhNhanController benhNhanController = new benhNhanController();
             if(benhNhanController.kiemTraMaBenhNhanTrung(idTimKiem)||"".equals(idTimKiem)){
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
            
            for(hosoBenhAnModel hoso : danhsachsoso){
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
        }
        else{
            JOptionPane.showMessageDialog(null, "Hãy chọn bệnh án hoặc bênh nhân để hiển thị");
        }
    }//GEN-LAST:event_jbTimKiemActionPerformed

    private void jbThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbThemActionPerformed
          if (jCheckBoxBenhAn.isSelected()) {
                    themHoSo();
                    hienthiDanhSachHoSo();
         } else if (jCheckBoxBenhNhan.isSelected()) {
                    themBenhNhan();
                    hienthiDanhSachBenhNhan();
         } else {
                    JOptionPane.showMessageDialog(null, "chọn bệnh án hoặc bệnh nhân không được để trống ");
                }
    }//GEN-LAST:event_jbThemActionPerformed

    private void jbSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSuaActionPerformed
        if(jCheckBoxBenhAn.isSelected()){
            suaHoSo();
        }
        else if(jCheckBoxBenhNhan.isSelected()){
            suaBenhNhan();
        }
        else{
                 JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân hoặc bệnh án !"); 
        }
    }//GEN-LAST:event_jbSuaActionPerformed

    private void jbXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbXemActionPerformed
         if(jCheckBoxBenhAn.isSelected()){
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
                
            for(hosoBenhAnModel hs : dshs){
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
        }
       else if(jCheckBoxBenhNhan.isSelected()){
            benhNhanController benhNhanController = new benhNhanController();
            ArrayList<benhNhanModel> dsbn = benhNhanController.layDanhSachBenhNhan();
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã Bênh Nhân");
            model.addColumn("Họ Và Tên");
            model.addColumn("Số Điện Thoại");
            model.addColumn("Email");
            model.addColumn("Địa Chỉ");
            model.addColumn("Giới Tính");
            model.addColumn("Hình Ảnh");
            model.addColumn("Tên tài khoản");
                for(benhNhanModel benhnhan : dsbn){
                model.addRow(new Object[]{
                    benhnhan.getMaBenhNhan(),
                    benhnhan.getHoVaTen(),
                    benhnhan.getSoDienThoai(),
                    benhnhan.getEmail(),
                    benhnhan.getDiachi(),
                    benhnhan.getGioiTinh(),
                    benhnhan.getHinhAnh(),
                    benhnhan.getTenDangnhap()
                });
            }
            jTable1.setModel(model);
            jTable1.setAutoscrolls(true);
            loadBenhNhan();    
            }
      
        else{
               JOptionPane.showMessageDialog(null, "Vui lòng chon bệnh án hoặc bệnh nhân.");
        }
    }//GEN-LAST:event_jbXemActionPerformed

    private void jbXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbXoaActionPerformed
        if(jCheckBoxBenhNhan.isSelected()){
            String idXoa = txtTimKiem.getText().trim();
            if(idXoa.isEmpty()){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập Id bệnh nhân để xóa");
            }
            else{
                int choice = JOptionPane.showConfirmDialog(null,
                        "Nếu xóa bệnh nhân này, hệ thống sẽ xóa lịch khám liên quan đến bệnh nhân đó.\nBạn có chắc chắn muốn xóa?",
                         "Xác nhận",
                         JOptionPane.YES_NO_OPTION
                        );
                if(choice == JOptionPane.YES_OPTION){
                     benhNhanController benhnhanController = new benhNhanController();
                     int rowsAffected = benhnhanController.xoaBenhNhanTheoID(idXoa);
                     
                     if(rowsAffected > 0){
                         JOptionPane.showMessageDialog(null, "Xóa  Thành Công");
                         hienthiDanhSachBenhNhan();
                         reset();
                     }
                     else if(rowsAffected  == -1){
                              JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân có ID: " + idXoa);
                        } else {
                            JOptionPane.showMessageDialog(null, "Xóa bệnh nhân thất bại.");
                        }
                }
            }
        }
        else if(jCheckBoxBenhAn.isSelected()){
            String idXoa = txtTimKiem.getText().trim();
            if(idXoa.isEmpty()){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần xóa.");
            }else{
                benhAnController benhAnController = new benhAnController();
                
                int rowsAffected = benhAnController.xoaHoSoTheoId(idXoa);
                 if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Xóa bệnh nhân thành công.");
                            hienthiDanhSachHoSo();
                            reset();

                        } else if (rowsAffected == -1) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân có ID: " + idXoa);
                        } else {
                            JOptionPane.showMessageDialog(null, "Xóa bệnh nhân thất bại.");
                        }
                    }
                }
        else{
             JOptionPane.showMessageDialog(null, "Chọn Bệnh Án hoặc Bệnh Nhân để xóa");
            }
    }//GEN-LAST:event_jbXoaActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
       String idTimKiem = txtTimKiem.getText().trim();
       if(idTimKiem.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần tìm kiếm.");
       }
       
       if(jCheckBoxBenhNhan.isSelected()){
           timBenhNhanTheoId(idTimKiem);
           loadBenhNhan();
       }
       else if(jCheckBoxBenhAn.isSelected()){
           timHoSoTheoId(idTimKiem);
           loadHoSo();
       }
       else{
              JOptionPane.showMessageDialog(null, "Vui chọn để tìm.");
       }
    }//GEN-LAST:event_txtTimKiemActionPerformed


public void timBenhNhanTheoId(String idTimKiem) {
        benhNhanController benhNhanController = new benhNhanController();
        benhNhanModel benhNhanTimKiem = benhNhanController.timBenhNhanTheoID(idTimKiem);

        if (benhNhanTimKiem != null) {
            DefaultTableModel customModel = new DefaultTableModel();
            customModel.addColumn("Mã bệnh nhân");
            customModel.addColumn("Họ và Tên");
            customModel.addColumn("Số Điện Thoại");
            customModel.addColumn("Email");
            customModel.addColumn("Địa Chỉ");
            customModel.addColumn("Giới Tính");
            customModel.addColumn("Hình ảnh");

            customModel.addRow(new Object[]{
                benhNhanTimKiem.getMaBenhNhan(),
                benhNhanTimKiem.getHoVaTen(),
                benhNhanTimKiem.getSoDienThoai(),
                benhNhanTimKiem.getEmail(),
                benhNhanTimKiem.getDiachi(),
                benhNhanTimKiem.getGioiTinh(),
                benhNhanTimKiem.getHinhAnh()}
            );

            jTable1.setModel(customModel);
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
//        buttonGroup1.clearSelection();
//        buttonGroup2.clearSelection();
        txtTrieuChung.setText("");
        txtChuanDoan.setText("");
        txtKetLuan.setText("");
        txtTieuSu.setText("");
        // xóa icon ảnh
        lbTaiAnh.setIcon(null);
        txtTimKiem.setText("");
        txtDangNhap.setText("");
    }
public void themBenhNhan(){
    String hoTen = txtHoVaTen.getText();
    String maBenhNhan = txtMaBN.getText();
    String soDienThoai = txtSDT.getText();
    String email = txtEmail.getText();
    String gioiTinh;
    String diaChi = txtDiaChi.getText();
    String hinhAnh;
  // String tenDangNhap = Login.xacNhanDangNhap;
    String tenDangNhap = txtDangNhap.getText();
    
    if(hoTen.isEmpty()||maBenhNhan.isEmpty() ||soDienThoai.isEmpty() ||email.isEmpty() ||diaChi.isEmpty() ){
        JOptionPane.showMessageDialog(null, "Bạn hãy nhâp đủ thông tin");
    }
    else{
        if (jradNam.isSelected()) {
                    gioiTinh = "Nam";
                } else if (jradNu.isSelected()) {
                    gioiTinh = "Nữ";
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn giới tính!");
                    return;  // Thoát phương thức nếu chưa chọn giới tính
                }
        hinhAnh = null;
        benhNhanController bncontroller = new benhNhanController();
        boolean maTonTai = bncontroller.kiemTraMaBenhNhanTrung(maBenhNhan);
        
        if(maTonTai){
            JOptionPane.showMessageDialog(null, "ma benh nhan ton tai");
        }
        else{
            benhNhanModel bnModel = new benhNhanModel(maBenhNhan,tenDangNhap, hoTen, soDienThoai, email, gioiTinh, diaChi, hinhAnh);
            int rowAffected = benhNhanController.themBenhNhan(bnModel);
            if(rowAffected > 0){
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                reset();
            }else{
                 JOptionPane.showMessageDialog(null, "Thêm thất bại");
            }
        }
    }
}
public void themHoSo(){
    String maHoSo = txtMaBenhAn.getText();
    String maBenhNhan = txtMaBNBA.getText();
    String maBacSi = txtMaBacSi.getText();
    String trieuChung = txtTrieuChung.getText();
    String tieuSuBenhAn = txtTieuSu.getText();
    String chuanDoan = txtChuanDoan.getText();
    String ketLuan  = txtKetLuan.getText();
    
    if(maHoSo.isEmpty() ||maBenhNhan.isEmpty() ||maBacSi.isEmpty() ||trieuChung.isEmpty() ||tieuSuBenhAn.isEmpty() ||chuanDoan.isEmpty() ||ketLuan.isEmpty() ){
        JOptionPane.showMessageDialog(null, "moi nhap du thong tin");
    }else{
        benhAnController baController = new benhAnController();
        boolean maTonTai = baController.kiemTraMaHoSoTrung(maHoSo);
 
        if(maTonTai){
            JOptionPane.showMessageDialog(null, "Mã Hồ Sơ Tồn Tại");
        }else{
            try{
            hosoBenhAnModel hoSo = new  hosoBenhAnModel(maHoSo, tieuSuBenhAn, trieuChung, chuanDoan, ketLuan, maBenhNhan, maBacSi);
            int rowsAffected = baController.themHoSo(hoSo);
            if(rowsAffected >0){
                JOptionPane.showMessageDialog(null, "Thêm Thành Công");
                reset();
            }
            else{
                   JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
                }
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi: " + e.getMessage());
                 e.printStackTrace(); // In ra console để dễ debug
            }
        }
    }
}
private void hienthiDanhSachBenhNhan(){
    benhNhanController  benhNhanController = new benhNhanController();
    ArrayList<benhNhanModel> danhsachBenhNhan = benhNhanController.layDanhSachBenhNhan();
    
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Mã Bệnh nhân");
    model.addColumn("Họ Và Tên");
    model.addColumn("Số Điện Thoại");
    model.addColumn("Email");
    model.addColumn("Địa Chỉ");
    model.addColumn("Giới tính");
    model.addColumn("Hình Ảnh");
    model.addColumn("Tài Khoản");
    
    for(benhNhanModel benhNhan : danhsachBenhNhan){
        model.addRow(new Object[]{
        benhNhan.getMaBenhNhan(),
        benhNhan.getHoVaTen(),
        benhNhan.getSoDienThoai(),
        benhNhan.getEmail(),
        benhNhan.getDiachi(),
        benhNhan.getGioiTinh(),
        benhNhan.getHinhAnh(),
        benhNhan.getTenDangnhap()
        });
    }
    jTable1.setModel(model);
    jTable1.setAutoscrolls(true);
}
private void hienthiDanhSachHoSo(){
    benhAnController  benhAnController = new benhAnController();
    ArrayList<hosoBenhAnModel> danhsachHoSo = benhAnController.layDanhSachHoSo();
    
    DefaultTableModel model = new DefaultTableModel();
      model.addColumn("Mã hồ sơ");
      model.addColumn("Mã bác sĩ");
      model.addColumn("Mã bệnh nhân");
      model.addColumn("Triệu chứng");
      model.addColumn("Tiền sử bệnh án");
      model.addColumn("Chuẩn đoán");
      model.addColumn("Kết luận");
   
   for(hosoBenhAnModel hoso : danhsachHoSo){
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
public void suaBenhNhan(){
    String idCapNhap = txtTimKiem.getText().trim();
    
    if(idCapNhap.isEmpty()){
        JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần để cập nhập");
    }else{
         String hoTen = txtHoVaTen.getText();
         String maBenhNhan = txtMaBN.getText();
         String soDienThoai = txtSDT.getText();
         String email = txtEmail.getText();
        String gioiTinh = null;
        String diaChi = txtDiaChi.getText();
        String hinhAnh = null;
        String tenDangNhap = txtDangNhap.getText();
        if(hoTen.isEmpty()||maBenhNhan.isEmpty() ||soDienThoai.isEmpty() ||email.isEmpty() ||diaChi.isEmpty() ){
        JOptionPane.showMessageDialog(null, "Bạn hãy nhâp đủ thông tin");
            }
        else{
                if (jradNam.isSelected()) {
                    gioiTinh = "Nam";
                } else if (jradNu.isSelected()) {
                    gioiTinh = "Nữ";
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn giới tính!");
                    return; 
            }
        }
         benhNhanModel bnModel = new benhNhanModel(maBenhNhan,tenDangNhap, hoTen, soDienThoai, email, gioiTinh, diaChi, hinhAnh);
         benhNhanController benhNhanController = new benhNhanController();
         
         int rowsAffected = benhNhanController.capNhatThongTinBenhNhan(bnModel, idCapNhap);
         if(rowsAffected > 0){
              JOptionPane.showMessageDialog(null, "Cập nhật thông tin bệnh nhân thành công.");
              hienthiDanhSachBenhNhan();
                reset();
         }else{
              JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân có ID: " + idCapNhap); 
         }
    }
}
public void suaHoSo(){
    String idCapNhap = txtTimKiem.getText().trim();
    
    if(idCapNhap.isEmpty()){
          JOptionPane.showMessageDialog(null, "Vui lòng nhập ID hồ sơ cần cập nhật.");
    }
    else{
         String maHoSo = txtMaBenhAn.getText();
         String maBenhNhan = txtMaBNBA.getText();
         String maBacSi = txtMaBacSi.getText();
         String trieuChung = txtTrieuChung.getText();
         String tieuSuBenhAn = txtTieuSu.getText();
         String chuanDoan = txtChuanDoan.getText();
         String ketLuan  = txtKetLuan.getText();
         
        hosoBenhAnModel hoSo = new  hosoBenhAnModel(maHoSo, tieuSuBenhAn, trieuChung, chuanDoan, ketLuan, maBenhNhan, maBacSi);
         benhAnController benhAnController = new benhAnController();
         
         int rowsAffected = benhAnController.capNhatThongTinHoSo(hoSo, idCapNhap);
         
          if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin hồ sơ thành công.");
                hienthiDanhSachHoSo();
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy hồ sơ có ID: " + idCapNhap);
        }
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton jCheckBoxBenhAn;
    private javax.swing.JRadioButton jCheckBoxBenhNhan;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JTextField txtChuanDoan;
    private javax.swing.JTextField txtDangNhap;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtKetLuan;
    private javax.swing.JTextField txtMaBN;
    private javax.swing.JTextField txtMaBNBA;
    private javax.swing.JTextField txtMaBacSi;
    private javax.swing.JTextField txtMaBenhAn;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTieuSu;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTrieuChung;
    // End of variables declaration//GEN-END:variables

    
}
