package quan_ly_benh_vien.View;

import quan_ly_benh_vien.Controller.bacSiController;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import quan_ly_benh_vien.Model.bacSiModel;

public class bacSiJpanel extends javax.swing.JPanel {

    public bacSiJpanel() throws SQLException {
        initComponents();

        // Khởi tạo model cho bảng
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Bác Sĩ");
        model.addColumn("Họ và Tên");
        model.addColumn("Số Điện Thoại");
        model.addColumn("Email");
        model.addColumn("Địa Chỉ");
        model.addColumn("Giới Tính");
        model.addColumn("Chuyên Khoa");
        model.addColumn("Kinh Nghiệm Làm Việc");
        model.addColumn("Học Vấn");
        model.addColumn("Hình Ảnh");

        jtableBacSi.setModel(model);

        // Lắng nghe sự kiện chọn dòng trong bảng
        jtableBacSi.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int selectRow = jtableBacSi.getSelectedRow();
                if (selectRow >= 0 && jtableBacSi.isRowSelected(selectRow)) {
                    try {
                        // Kiểm tra giá trị trong các cột trước khi lấy
                        txtTimKiem.setText(jtableBacSi.getValueAt(selectRow, 0) != null ? jtableBacSi.getValueAt(selectRow, 0).toString() : "");
                        txtMA.setText(jtableBacSi.getValueAt(selectRow, 0) != null ? jtableBacSi.getValueAt(selectRow, 0).toString() : "");
                        txtHoVaTen.setText(jtableBacSi.getValueAt(selectRow, 1) != null ? jtableBacSi.getValueAt(selectRow, 1).toString() : "");
                        txtSDT.setText(jtableBacSi.getValueAt(selectRow, 2) != null ? jtableBacSi.getValueAt(selectRow, 2).toString() : "");
                        txtEmail.setText(jtableBacSi.getValueAt(selectRow, 3) != null ? jtableBacSi.getValueAt(selectRow, 3).toString() : "");
                        txtDiaChi.setText(jtableBacSi.getValueAt(selectRow, 4) != null ? jtableBacSi.getValueAt(selectRow, 4).toString() : "");

                        // Kiểm tra và xử lý Giới tính
                        String gioiTinh = (String) jtableBacSi.getValueAt(selectRow, 5);
                        if ("Nam".equals(gioiTinh)) {
                            jradNam.setSelected(true);
                            jradNu.setSelected(false);
                        } else if ("Nữ".equals(gioiTinh)) {
                            jradNu.setSelected(true);
                            jradNam.setSelected(false);
                        }

                        // Kiểm tra và xử lý chuyên khoa
                        String chuyenKhoa = (String) jtableBacSi.getValueAt(selectRow, 6);
                        jComBoxChuyenKhoa.setSelectedItem(chuyenKhoa);

                        // Kiểm tra và xử lý Kinh nghiệm và Học vấn
                        txtKinhnghiem.setText((String) jtableBacSi.getValueAt(selectRow, 7));
                        txthocVan.setText((String) jtableBacSi.getValueAt(selectRow, 8));

                        // Kiểm tra và xử lý hình ảnh
                        String hinhAnh = (String) jtableBacSi.getValueAt(selectRow, 9);
                        if (hinhAnh != null && !hinhAnh.isEmpty()) {
                            File imageFile = new File(hinhAnh);
                            if (imageFile.exists()) {
                                ImageIcon imageIcon = new ImageIcon(hinhAnh);
                                Image img = imageIcon.getImage().getScaledInstance(lbTaiAnh.getWidth(), lbTaiAnh.getHeight(), Image.SCALE_SMOOTH);
                                lbTaiAnh.setIcon(new ImageIcon(img));
                            } else {
                                lbTaiAnh.setIcon(null);
                                JOptionPane.showMessageDialog(this, "Hình ảnh không tồn tại: " + hinhAnh);
                            }
                        } else {
                            lbTaiAnh.setIcon(null);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi hiển thị dữ liệu: " + ex.getMessage());
                    }
                }
            }
        });

        hienthiDSBacSi();

    }

    private void hienthiDSBacSi() {
        bacSiController bacSiController = new bacSiController();
        ArrayList<bacSiModel> danhSachBacSi = bacSiController.layDanhSachBacSi();

        // Tạo DefaultTableModel với các cột
        DefaultTableModel model = (DefaultTableModel) jtableBacSi.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ nếu có

        // Thêm dữ liệu vào model
        for (bacSiModel bacSi : danhSachBacSi) {
            model.addRow(new Object[]{
                bacSi.getMaBacSi(),
                bacSi.getHoVaTen(),
                bacSi.getSoDienThoai(),
                bacSi.getEmail(),
                bacSi.getDiachi(),
                bacSi.getGioiTinh(),
                bacSi.getChuyenKhoa(),
                bacSi.getKinhNghiemLamViec(),
                bacSi.getHocVan(),
                bacSi.getHinhAnh()
            });
        }

        jtableBacSi.revalidate();
        jtableBacSi.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        JbThongTin = new javax.swing.JLabel();
        jbThem = new javax.swing.JButton();
        jbSua = new javax.swing.JButton();
        jbXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableBacSi = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jbTimKiem = new javax.swing.JButton();
        jlTimkiem = new javax.swing.JLabel();
        jbChon = new javax.swing.JButton();
        jbLayDuLieu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlChuyenKhoa = new javax.swing.JLabel();
        jradNam = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        jlGioiTinh = new javax.swing.JLabel();
        txtMA = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKinhnghiem = new javax.swing.JTextArea();
        jlHoVaTen = new javax.swing.JLabel();
        jComBoxChuyenKhoa = new javax.swing.JComboBox<>();
        lbTaiAnh = new javax.swing.JLabel();
        jbMa = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jlKinhNghiem = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jradNu = new javax.swing.JRadioButton();
        txtSDT = new javax.swing.JTextField();
        jlHocVan = new javax.swing.JLabel();
        jlSDT = new javax.swing.JLabel();
        jlDiaChi = new javax.swing.JLabel();
        txthocVan = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(960, 465));
        setPreferredSize(new java.awt.Dimension(980, 466));

        JbThongTin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JbThongTin.setText("Thông tin Bác Sĩ");

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

        jbXoa.setText("Xóa");
        jbXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbXoaActionPerformed(evt);
            }
        });

        jtableBacSi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jtableBacSi);
        jtableBacSi.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jbTimKiem.setText("Tìm kiếm");
        jbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTimKiemActionPerformed(evt);
            }
        });

        jlTimkiem.setText("Tìm kiếm theo mã");

        jbChon.setText("Chọn");
        jbChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbChonActionPerformed(evt);
            }
        });

        jbLayDuLieu.setText("Lấy Dữ Liệu");
        jbLayDuLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLayDuLieuActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlChuyenKhoa.setText("Chuyên khoa:");

        buttonGroup1.add(jradNam);
        jradNam.setText("Nam");

        jlGioiTinh.setText("Giới tính:");

        jlEmail.setText("Email:");

        txtKinhnghiem.setColumns(20);
        txtKinhnghiem.setRows(5);
        jScrollPane2.setViewportView(txtKinhnghiem);

        jlHoVaTen.setText("Họ và tên:");

        jComBoxChuyenKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa da liễu", "Khoa thần kinh", "Khoa Tâm lý", "Khoa xương khớp", "Khoa tai - mũi - họng", "Khoa mắt", "Khoa xét nghiệm" }));

        lbTaiAnh.setBackground(new java.awt.Color(0, 0, 0));

        jbMa.setText("Mã : ");

        txtHoVaTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoVaTenActionPerformed(evt);
            }
        });

        jButton1.setText("Tải Ảnh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jlKinhNghiem.setText("Kinh nghiệm:");

        buttonGroup1.add(jradNu);
        jradNu.setText("Nữ");

        jlHocVan.setText("Học vấn:");

        jlSDT.setText("Số điện thoại:");

        jlDiaChi.setText("Địa chỉ:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbMa)
                    .addComponent(jlHoVaTen)
                    .addComponent(jlDiaChi)
                    .addComponent(jlSDT)
                    .addComponent(jlGioiTinh)
                    .addComponent(jlEmail)
                    .addComponent(jlChuyenKhoa)
                    .addComponent(jlHocVan)
                    .addComponent(jlKinhNghiem))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComBoxChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMA, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addComponent(lbTaiAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jradNam)
                                .addGap(18, 18, 18)
                                .addComponent(jradNu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(43, 43, 43))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtHoVaTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthocVan, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jbMa)
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlHoVaTen))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlDiaChi)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlSDT)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(81, 81, 81))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbTaiAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(49, 49, 49)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlChuyenKhoa)
                            .addComponent(jComBoxChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlHocVan)
                            .addComponent(txthocVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jradNam)
                            .addComponent(jradNu)
                            .addComponent(jlGioiTinh))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlKinhNghiem)
                        .addGap(60, 60, 60))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JbThongTin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTimKiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbTimKiem))
                            .addComponent(jlTimkiem))
                        .addGap(103, 103, 103))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbThem)
                                .addGap(18, 18, 18)
                                .addComponent(jbSua)
                                .addGap(26, 26, 26)
                                .addComponent(jbXoa)
                                .addGap(18, 18, 18)
                                .addComponent(jbLayDuLieu))
                            .addComponent(jbChon)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JbThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbChon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlTimkiem)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbTimKiem))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbThem)
                                .addComponent(jbSua))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbXoa)
                                .addComponent(jbLayDuLieu))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSuaActionPerformed
        // Lấy ID từ JTextField txtTimKiem
        String idCapNhat = txtTimKiem.getText().trim();

        // Kiểm tra xem ID có được nhập hay không
        if (idCapNhat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần cập nhật.");
        } else {
            // Đọc thông tin mới từ các trường nhập liệu
            String maBacSi = txtMA.getText();
            String hoVaTen = txtHoVaTen.getText();
            String soDienThoai = txtSDT.getText();
            String diaChi = txtDiaChi.getText();
            String kinhNghiem = txtKinhnghiem.getText();
            String email = txtEmail.getText();
            String hocVan = txthocVan.getText();
            String gioiTinh;
            String chuyenKhoa = "";
            String hinhAnh;

            if (jradNam.isSelected()) {
                gioiTinh = "Nam";
            } else if (jradNu.isSelected()) {
                gioiTinh = "Nữ";
            } else {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn giới tính!");
                return;  // Thoát phương thức nếu chưa chọn giới tính
            }

            Object selectedChuyenKhoa = jComBoxChuyenKhoa.getSelectedItem();
            if (selectedChuyenKhoa != null) {
                chuyenKhoa = selectedChuyenKhoa.toString();
            }
            hinhAnh = null;
            // Tạo một đối tượng BacSiModel mới từ thông tin đã nhập
            bacSiModel bacSiMoi = new bacSiModel(maBacSi, chuyenKhoa, kinhNghiem, hocVan, hoVaTen, soDienThoai, email, gioiTinh, diaChi, hinhAnh);
            // Gọi phương thức cập nhật thông tin từ controller
            bacSiController bacSiController = new bacSiController();
            int rowsAffected = bacSiController.capNhatThongTinBacSi(bacSiMoi, idCapNhat);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin bác sĩ thành công.");
                hienthiDSBacSi();
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy bác sĩ có ID: " + idCapNhat);
            }
        }
    }//GEN-LAST:event_jbSuaActionPerformed

    private void jbThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbThemActionPerformed
        String maBacSi = txtMA.getText();
        String hoVaTen = txtHoVaTen.getText();
        String soDienThoai = txtSDT.getText();
        String diaChi = txtDiaChi.getText();
        String kinhNghiem = txtKinhnghiem.getText();
        String email = txtEmail.getText();
        String hocVan = txthocVan.getText();
        String gioiTinh;
        String chuyenKhoa;
        String hinhAnh = null;

        if (maBacSi.isEmpty() || hoVaTen.isEmpty() || soDienThoai.isEmpty() || diaChi.isEmpty() || kinhNghiem.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!");
        } else {
            if (jradNam.isSelected()) {
                gioiTinh = "Nam";
            } else if (jradNu.isSelected()) {
                gioiTinh = "Nữ";
            } else {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn giới tính!");
                return;  // Thoát phương thức nếu chưa chọn giới tính
            }
            //hinhAnh = selectedImagePath;
            // Kiểm tra chuyên khoa
            Object selectedChuyenKhoa = jComBoxChuyenKhoa.getSelectedItem();
            if (selectedChuyenKhoa == null || selectedChuyenKhoa.toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn chuyên khoa!");
            } else {
                chuyenKhoa = selectedChuyenKhoa.toString();
                // Kiểm tra xem mã bác sĩ đã tồn tại
                bacSiController bacSiController = new bacSiController();
                boolean maTonTai = bacSiController.kiemTraMaBacSiTrung(maBacSi);

                if (maTonTai) {
                    JOptionPane.showMessageDialog(null, "Mã bác sĩ đã tồn tại!");
                } else {
                    bacSiModel bacSiModel = new bacSiModel(maBacSi, chuyenKhoa, kinhNghiem, hocVan, hoVaTen, soDienThoai, email, gioiTinh, diaChi, hinhAnh);
                    int rowsAffected = bacSiController.themBacSi(bacSiModel);

                    // Kiểm tra kết quả và hiển thị thông báo
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công!");
                        hienthiDSBacSi();
                        reset();
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại!");
                    }
                }
            }
        }

    }//GEN-LAST:event_jbThemActionPerformed

    private void jbLayDuLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLayDuLieuActionPerformed
        bacSiController bacSiController = new bacSiController();
        ArrayList<bacSiModel> danhSachBacSi = bacSiController.layDanhSachBacSi();

        // Tạo DefaultTableModel với các cột bạn muốn hiển thị
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Bác Sĩ");
        model.addColumn("Họ và Tên");
        model.addColumn("Số Điện Thoại");
        model.addColumn("Email");
        model.addColumn("Địa Chỉ");
        model.addColumn("Giới Tính");
        model.addColumn("Chuyên Khoa");
        model.addColumn("Kinh Nghiệm Làm Việc");
        model.addColumn("Học Vấn");
        model.addColumn("Ảnh");

        // Thêm dữ liệu từ danh sách bác sĩ vào model
        for (bacSiModel bacSi : danhSachBacSi) {
            model.addRow(new Object[]{
                bacSi.getMaBacSi(),
                bacSi.getHoVaTen(),
                bacSi.getSoDienThoai(),
                bacSi.getEmail(),
                bacSi.getDiachi(),
                bacSi.getGioiTinh(),
                bacSi.getChuyenKhoa(),
                bacSi.getKinhNghiemLamViec(),
                bacSi.getHocVan(),
                bacSi.getHinhAnh()
            });
        }
        jtableBacSi.setModel(model);
        jtableBacSi.setAutoscrolls(true);
    }//GEN-LAST:event_jbLayDuLieuActionPerformed

    private void jbXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbXoaActionPerformed
        String idXoa = txtTimKiem.getText().trim();
        if (idXoa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần xóa.");
        } else {
            int choice = JOptionPane.showConfirmDialog(
                    null,
                    "Nếu xóa bác sĩ này, hệ thống sẽ xóa lịch khám và bệnh nhân liên quan đến bác sĩ đó.\nBạn có chắc chắn muốn xóa?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION
            );
            if (choice == JOptionPane.YES_OPTION) {
                bacSiController bacSiController = new bacSiController();
                int rowsAffected = bacSiController.xoaBacSiTheoID(idXoa);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Xóa bác sĩ thành công.");
                    hienthiDSBacSi();
                } else if (rowsAffected == -1) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy bác sĩ có ID: " + idXoa);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa bác sĩ thất bại.");
                }
            }
        }
    }//GEN-LAST:event_jbXoaActionPerformed

    private void jbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTimKiemActionPerformed
        String idTimKiem = txtTimKiem.getText().trim();

        // Kiểm tra xem ID có được nhập hay không
        if (idTimKiem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần tìm kiếm.");
            return;
        }

        // Gọi phương thức tìm kiếm bác sĩ theo ID từ controller
        bacSiController bacSiController = new bacSiController();
        bacSiModel bacSiTimKiem = bacSiController.timBacSiTheoID(idTimKiem);

        // Kiểm tra xem có bác sĩ nào được tìm thấy không
        if (bacSiTimKiem != null) {
            // Tạo một custom DefaultTableModel để hiển thị kết quả tìm kiếm
            DefaultTableModel customModel = new DefaultTableModel();
            customModel.addColumn("Mã Bác Sĩ");
            customModel.addColumn("Họ và Tên");
            customModel.addColumn("Số Điện Thoại");
            customModel.addColumn("Email");
            customModel.addColumn("Địa Chỉ");
            customModel.addColumn("Giới Tính");
            customModel.addColumn("Chuyên Khoa");
            customModel.addColumn("Kinh Nghiệm Làm Việc");
            customModel.addColumn("Học Vấn");
            customModel.addColumn("Hình ảnh");

            // Thêm thông tin của bác sĩ được tìm thấy vào customModel
            customModel.addRow(new Object[]{
                bacSiTimKiem.getMaBacSi(),
                bacSiTimKiem.getHoVaTen(),
                bacSiTimKiem.getSoDienThoai(),
                bacSiTimKiem.getEmail(),
                bacSiTimKiem.getDiachi(),
                bacSiTimKiem.getGioiTinh(),
                bacSiTimKiem.getChuyenKhoa(),
                bacSiTimKiem.getKinhNghiemLamViec(),
                bacSiTimKiem.getHocVan(),
                bacSiTimKiem.getHinhAnh()
            }
            );

            // Gán customModel vào jTableBacSi để hiển thị kết quả
            jtableBacSi.setModel(customModel);
        } else {
            // Hiển thị thông báo nếu không tìm thấy bác sĩ
            JOptionPane.showMessageDialog(null, "Không tìm thấy bác sĩ có ID: " + idTimKiem);
        }
    }//GEN-LAST:event_jbTimKiemActionPerformed
    private String selectedImagePath;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Tạo một đối tượng JFileChooser
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbChonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbChonActionPerformed

    private void txtHoVaTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoVaTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoVaTenActionPerformed
    public void reset() {
        txtMA.setText("");
        txtHoVaTen.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txthocVan.setText("");
        txtKinhnghiem.setText("");
        jComBoxChuyenKhoa.setSelectedIndex(0);
        jradNam.setSelected(false);
        jradNu.setSelected(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JbThongTin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComBoxChuyenKhoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbChon;
    private javax.swing.JButton jbLayDuLieu;
    private javax.swing.JLabel jbMa;
    private javax.swing.JButton jbSua;
    private javax.swing.JButton jbThem;
    private javax.swing.JButton jbTimKiem;
    private javax.swing.JButton jbXoa;
    private javax.swing.JLabel jlChuyenKhoa;
    private javax.swing.JLabel jlDiaChi;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlGioiTinh;
    private javax.swing.JLabel jlHoVaTen;
    private javax.swing.JLabel jlHocVan;
    private javax.swing.JLabel jlKinhNghiem;
    private javax.swing.JLabel jlSDT;
    private javax.swing.JLabel jlTimkiem;
    private javax.swing.JRadioButton jradNam;
    private javax.swing.JRadioButton jradNu;
    private javax.swing.JTable jtableBacSi;
    private javax.swing.JLabel lbTaiAnh;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextArea txtKinhnghiem;
    private javax.swing.JTextField txtMA;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txthocVan;
    // End of variables declaration//GEN-END:variables

}
