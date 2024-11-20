package quan_ly_benh_vien.View;

import quan_ly_benh_vien.Controller.bacSiController;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import quan_ly_benh_vien.Model.bacSiModel;

public class bacSiJpanel extends javax.swing.JPanel {

    private String emailCheck, maBacSiCheck, soDienThoaiCheck;
    private DefaultTableModel model;

    public bacSiJpanel() throws SQLException {
        initComponents();

        // Khởi tạo model cho bảng
        model = new DefaultTableModel();
        model.addColumn("Mã Bác Sĩ");
        model.addColumn("Họ và Tên");
        model.addColumn("Số Điện Thoại");
        model.addColumn("Email");
        model.addColumn("Ngày Sinh");
        model.addColumn("Địa Chỉ");
        model.addColumn("Giới Tính");
        model.addColumn("Chuyên Khoa");
        model.addColumn("Kinh Nghiệm Làm Việc");
        model.addColumn("Học Vấn");
        model.addColumn("Hình Ảnh");

        DefaultTableCellRenderer dateRenderer = new DefaultTableCellRenderer();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateRenderer.setText(dateFormat.format(new Date()));  // Định dạng ngày
        jtableBacSi.setModel(model);
        // Áp dụng renderer cho cột ngày sinh (giả sử là cột số 4)
        jtableBacSi.getColumnModel().getColumn(4).setCellRenderer(dateRenderer);

        // Lắng nghe sự kiện chọn dòng trong bảng
        jtableBacSi.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int selectRow = jtableBacSi.getSelectedRow();
                if (selectRow >= 0 && jtableBacSi.isRowSelected(selectRow)) {
                    try {
                        //set laij gia tri cho cac bien check
                        emailCheck = null;
                        maBacSiCheck = null;
                        soDienThoaiCheck = null;

                        // Kiểm tra giá trị trong các cột trước khi lấy
                        txtTimKiem.setText(jtableBacSi.getValueAt(selectRow, 0) != null ? jtableBacSi.getValueAt(selectRow, 0).toString() : "");
                        txtMA.setText(jtableBacSi.getValueAt(selectRow, 0) != null ? jtableBacSi.getValueAt(selectRow, 0).toString() : "");
                        txtHoVaTen.setText(jtableBacSi.getValueAt(selectRow, 1) != null ? jtableBacSi.getValueAt(selectRow, 1).toString() : "");
                        txtSDT.setText(jtableBacSi.getValueAt(selectRow, 2) != null ? jtableBacSi.getValueAt(selectRow, 2).toString() : "");
                        txtEmail.setText(jtableBacSi.getValueAt(selectRow, 3) != null ? jtableBacSi.getValueAt(selectRow, 3).toString() : "");

                        // Lấy giá trị ngày sinh từ cột 4 (cột ngày sinh)
                        Object ngaySinhObj = jtableBacSi.getValueAt(selectRow, 4);
                        if (ngaySinhObj instanceof Date) {
                            jDateNgaySinh.setDate((Date) ngaySinhObj);  // Cập nhật vào JDateChooser
                        }
                        // Kiểm tra giá trị địa chỉ
                        txtDiaChi.setText(jtableBacSi.getValueAt(selectRow, 5) != null ? jtableBacSi.getValueAt(selectRow, 5).toString() : "");
                        // Kiểm tra và xử lý Giới tính
                        String gioiTinh = (String) jtableBacSi.getValueAt(selectRow, 6);
                        if ("Nam".equals(gioiTinh)) {
                            jradNam.setSelected(true);
                            jradNu.setSelected(false);
                        } else if ("Nữ".equals(gioiTinh)) {
                            jradNu.setSelected(true);
                            jradNam.setSelected(false);
                        }

                        // Kiểm tra và xử lý chuyên khoa
                        String chuyenKhoa = (String) jtableBacSi.getValueAt(selectRow, 7);
                        jComBoxChuyenKhoa.setSelectedItem(chuyenKhoa);

                        // Kiểm tra và xử lý Kinh nghiệm và Học vấn
                        txtKinhnghiem.setText((String) jtableBacSi.getValueAt(selectRow, 8));
                        txthocVan.setText((String) jtableBacSi.getValueAt(selectRow, 9));

                        // Kiểm tra và xử lý hình ảnh
                        String hinhAnh = (String) jtableBacSi.getValueAt(selectRow, 10);
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

                        emailCheck = txtEmail.getText();
                        maBacSiCheck = txtMA.getText();
                        soDienThoaiCheck = txtSDT.getText();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi hiển thị dữ liệu: " + ex.getMessage());
                    }
                }
            }
        }
        );

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
                bacSi.getNgaySinh(),
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
        btnRefresh = new javax.swing.JButton();
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
        jLabel1 = new javax.swing.JLabel();
        jDateNgaySinh = new com.toedter.calendar.JDateChooser();

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

        jtableBacSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtableBacSi.setColumnSelectionAllowed(true);
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

        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlChuyenKhoa.setText("Chuyên khoa:");

        buttonGroup1.add(jradNam);
        jradNam.setText("Nam");

        jlGioiTinh.setText("Giới tính:");

        txtMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMAActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Ngày sinh:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlHoVaTen)
                    .addComponent(jlDiaChi)
                    .addComponent(jlSDT)
                    .addComponent(jlGioiTinh)
                    .addComponent(jlEmail)
                    .addComponent(jlChuyenKhoa)
                    .addComponent(jlHocVan)
                    .addComponent(jlKinhNghiem)
                    .addComponent(jLabel1)
                    .addComponent(jbMa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jradNam)
                        .addGap(18, 18, 18)
                        .addComponent(jradNu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMA, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTaiAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComBoxChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthocVan, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTaiAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbMa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlHoVaTen))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlDiaChi))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlSDT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jradNam)
                            .addComponent(jradNu)
                            .addComponent(jlGioiTinh))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlChuyenKhoa)
                    .addComponent(jComBoxChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlHocVan)
                    .addComponent(txthocVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlKinhNghiem)
                        .addGap(60, 60, 60))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbThem)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbSua)
                                        .addGap(26, 26, 26)
                                        .addComponent(jbXoa))
                                    .addComponent(btnRefresh))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JbThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh)
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
                            .addComponent(jbXoa))
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
public boolean validateInput(String maBacSi, String hoVaTen, String soDienThoai, String diaChi,
            String kinhNghiem, String email, Date ngaySinh, String hocVan, String gioiTinh,
            String chuyenKhoa, String hinhAnh) {
        // Kiểm tra các trường bắt buộc
        if (maBacSi == null || maBacSi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã bác sĩ không được để trống.");
            return false;
        }

        if (ngaySinh == null) {
            JOptionPane.showMessageDialog(null, "Ngày chọn không hợp lệ.");
            return false;
        }

        // Kiểm tra xem ngày sinh có phải là một ngày hợp lệ 
        Date currentDate = new Date();

        // Kiểm tra nếu ngày sinh là sau ngày hiện tại
        if (ngaySinh.after(currentDate)) {
            JOptionPane.showMessageDialog(null, "Ngày chọn không hợp lệ.");
            return false; // Ngày sinh không được là ngày trong tương lai
        }

        if (hoVaTen == null || hoVaTen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Họ và tên không được để trống.");
            return false;
        }

        if (soDienThoai == null || soDienThoai.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống.");
            return false;
        } else if (!soDienThoai.matches("^0[3|5|7|8|9][0-9]{8}$")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ.");
            return false;
        }

        if (diaChi == null || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống.");
            return false;
        }

        if (kinhNghiem == null || kinhNghiem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kinh nghiệm không được để trống.");
            return false;
        }

        if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email không được để trống.");
            return false;
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) { // Kiểm tra email có đúng định dạng không
            JOptionPane.showMessageDialog(null, "Email không hợp lệ.");
            return false;
        }

        if (hocVan == null || hocVan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Học vấn không được để trống.");
            return false;
        }

        // Kiểm tra giới tính
        if (gioiTinh == null || gioiTinh.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính.");
            return false;
        }

        return true; // Nếu tất cả các kiểm tra đều hợp lệ
    }

    private void jbSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSuaActionPerformed
        // Lấy ID từ JTextField txtTimKiem
        String idCapNhat = txtMA.getText().trim();

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
            Date ngaySinh = jDateNgaySinh.getDate();
            String hocVan = txthocVan.getText();
            String gioiTinh = "";
            String chuyenKhoa = "";
            String hinhAnh = "";

            //format Ngay sinh de chuyển sang string 
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            if (jradNam.isSelected()) {
                gioiTinh = "Nam";
            } else if (jradNu.isSelected()) {
                gioiTinh = "Nữ";
            }

            if (!validateInput(maBacSi, hoVaTen, soDienThoai, diaChi, kinhNghiem, email, ngaySinh, hocVan, gioiTinh, chuyenKhoa, hinhAnh)) {
                return;
            }
            bacSiController bacSiController = new bacSiController();
            boolean maTonTai = bacSiController.KtraTrungLap("maBacSi", maBacSi);
            boolean emailTonTai = bacSiController.KtraTrungLap("email", email);
            boolean sdtTonTai = bacSiController.KtraTrungLap("soDienThoai", soDienThoai);

            if (maTonTai && !maBacSiCheck.equals(maBacSi)) {
                JOptionPane.showMessageDialog(null, "Mã bác sĩ đã tồn tại!");
            } else if (emailTonTai && !emailCheck.equals(email)) {
                JOptionPane.showMessageDialog(null, "email đã tồn tại!");
            } else if (sdtTonTai && !soDienThoaiCheck.equals(soDienThoai)) {
                JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại!");
            } else {
                Object selectedChuyenKhoa = jComBoxChuyenKhoa.getSelectedItem();
                if (selectedChuyenKhoa != null) {
                    chuyenKhoa = selectedChuyenKhoa.toString();
                }

                // Tạo một đối tượng BacSiModel mới từ thông tin đã nhập
                bacSiModel bacSiMoi = new bacSiModel(maBacSi, hoVaTen, soDienThoai, email, ngaySinh, diaChi, gioiTinh, chuyenKhoa, kinhNghiem, hocVan, hinhAnh);

                // Gọi phương thức cập nhật thông tin từ controller
                int rowsAffected = bacSiController.capNhatThongTinBacSi(bacSiMoi, idCapNhat);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thông tin bác sĩ thành công.");
                    hienthiDSBacSi();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy bác sĩ có ID: " + idCapNhat);
                }
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
        Date ngaySinh = jDateNgaySinh.getDate();
        String hocVan = txthocVan.getText();
        String gioiTinh = "";
        String chuyenKhoa;
        String hinhAnh = null;

        //format Ngay sinh de chuyển sang string 
        if (jradNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (jradNu.isSelected()) {
            gioiTinh = "Nữ";
        }

        //hinhAnh = selectedImagePath;
        //Kiểm tra chuyên khoa
        Object selectedChuyenKhoa = jComBoxChuyenKhoa.getSelectedItem();
        if (selectedChuyenKhoa == null || selectedChuyenKhoa.toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn chuyên khoa!");
        } else {
            chuyenKhoa = selectedChuyenKhoa.toString();
            // Kiểm tra xem mã bác sĩ đã tồn tại
            if (!validateInput(maBacSi, hoVaTen, soDienThoai, diaChi, kinhNghiem, email, ngaySinh, hocVan, gioiTinh, chuyenKhoa, hinhAnh)) {
                return;  // Dừng lại nếu input không hợp lệ
            }
            bacSiController bacSiController = new bacSiController();
            boolean maTonTai = bacSiController.KtraTrungLap("maBacSi", maBacSi);
            boolean emailTonTai = bacSiController.KtraTrungLap("email", email);
            boolean sdtTonTai = bacSiController.KtraTrungLap("soDienThoai", soDienThoai);

            if (maTonTai) {
                JOptionPane.showMessageDialog(null, "Mã bác sĩ đã tồn tại!");
            } else if (emailTonTai) {
                JOptionPane.showMessageDialog(null, "email đã tồn tại!");
            } else if (sdtTonTai) {
                JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại!");
            } else {
               bacSiModel bacSiModel = new bacSiModel(maBacSi, hoVaTen, soDienThoai, email, ngaySinh, diaChi, gioiTinh, chuyenKhoa, kinhNghiem, hocVan, hinhAnh);

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

    }//GEN-LAST:event_jbThemActionPerformed

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
        bacSiModel bacSi = bacSiController.timBacSiTheoID(idTimKiem);
        model.setRowCount(0);
        // Kiểm tra xem có bác sĩ nào được tìm thấy không
        if (bacSi != null) {

            model.addRow(new Object[]{
                bacSi.getMaBacSi(),
                bacSi.getHoVaTen(),
                bacSi.getSoDienThoai(),
                bacSi.getEmail(),
                bacSi.getNgaySinh(),
                bacSi.getDiachi(),
                bacSi.getGioiTinh(),
                bacSi.getChuyenKhoa(),
                bacSi.getKinhNghiemLamViec(),
                bacSi.getHocVan(),
                bacSi.getHinhAnh()
            });

            // Gán customModel vào jTableBacSi để hiển thị kết quả
            jtableBacSi.setModel(model);
        } else {
            // Hiển thị thông báo nếu không tìm thấy bác sĩ
            JOptionPane.showMessageDialog(null, "Không tìm thấy bác sĩ có ID: " + idTimKiem);
        }
        reset();
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

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        reset();
        hienthiDSBacSi();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtHoVaTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoVaTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoVaTenActionPerformed

    private void txtMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMAActionPerformed
    public void reset() {
        txtMA.setText("");
        txtHoVaTen.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        jDateNgaySinh.setDate(null);
        txthocVan.setText("");
        txtKinhnghiem.setText("");
        jComBoxChuyenKhoa.setSelectedIndex(0);
        jradNam.setSelected(false);
        jradNu.setSelected(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JbThongTin;
    private javax.swing.JButton btnRefresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComBoxChuyenKhoa;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
