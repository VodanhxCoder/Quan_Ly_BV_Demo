package view;
import controller.bacSiController;
import java.awt.BorderLayout;
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
import model.bacSiModel;
public class bacSiJpanel extends javax.swing.JPanel {  
    
    
    public bacSiJpanel() throws SQLException {
        initComponents();    
    
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
        jtableBacSi.getSelectionModel().addListSelectionListener((ListSelectionEvent e)->{
            if(!e.getValueIsAdjusting()){
                int selectRow = jtableBacSi.getSelectedRow();
                if(selectRow >= 0 && jtableBacSi.isRowSelected(selectRow)){
                    //lay du lieu tu bang;
                    Object value = jtableBacSi.getValueAt(selectRow, 0);
                    if(value !=null){
                           txtTimKiem.setText(jtableBacSi.getValueAt(selectRow, 0).toString());
                        }
                    txtMA.setText(jtableBacSi.getValueAt(selectRow, 0).toString());
                    txtHoVaTen.setText(jtableBacSi.getValueAt(selectRow, 1).toString());
                    txtSDT.setText(jtableBacSi.getValueAt(selectRow, 2).toString());
                    txtEmail.setText(jtableBacSi.getValueAt(selectRow, 3).toString());
                    txtDiaChi.setText(jtableBacSi.getValueAt(selectRow, 4).toString());
                    String gioiTinh = (String) jtableBacSi.getValueAt(selectRow, 5);
                    if (gioiTinh != null) {
                        switch (gioiTinh) {
                            case "Nam" -> {
                                if (!JcheckBoxNam.isSelected()) {
                                    JcheckBoxNam.setSelected(true);
                                    JcheckBoxNam.setSelected(false);
                                }
                            }
                            case "Nữ" -> {
                                if (!jcheckBoxNu.isSelected()) {
                                    jcheckBoxNu.setSelected(false);
                                    jcheckBoxNu.setSelected(true);
                                }
                            }
                            default -> {
                                JcheckBoxNam.setSelected(false);
                                jcheckBoxNu.setSelected(false);
                            }
                        }
                    }
                    String chuyenKhoa = (String) jtableBacSi.getValueAt(selectRow, 6);
                    if (chuyenKhoa != null) {
                        jComBoxChuyenKhoa.setSelectedItem(chuyenKhoa);
                    }

                    txtKinhnghiem.setText((String) jtableBacSi.getValueAt(selectRow, 7));
                    txthocVan.setText((String) jtableBacSi.getValueAt(selectRow, 8));

                    String hinhAnh = (String) jtableBacSi.getValueAt(selectRow, 9);
                    if (hinhAnh != null) {
                        ImageIcon imageIcon = new ImageIcon(hinhAnh);
                        lbTaiAnh.setIcon(imageIcon);
                    }
                }  
            }
        });
        
    }
    private void hienthiDSBacSi(){
        bacSiController bacSiController = new bacSiController();
         ArrayList<bacSiModel> dsBSModel = bacSiController.getAllBacSi(); // Giả sử bạn có phương thức này trong bacSiController
     
      //  ArrayList<bacSiModel> dsBSModel = new ArrayList<>();
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
        
        for(bacSiModel bacSi : dsBSModel ){
            model.addRow(new Object[]{
                bacSi.getMaBacSi(),
                bacSi.getHoVaTen(),
                bacSi.getSoDienThoai(),
                bacSi.getEmail(),
                bacSi.getDiachi(),
                bacSi.getGioiTinh(),
                bacSi.getChuyenKhoa(),
                bacSi.getKinhNgiemLamViec(),
                bacSi.getHocVan(),
                bacSi.getHinhAnh()
            });
        }


        jtableBacSi.setModel(model);
        jtableBacSi.setAutoscrolls(true);
        jtableBacSi.setModel(model);
        jtableBacSi.revalidate(); // Cập nhật lại giao diện
        jtableBacSi.repaint(); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbThongTin = new javax.swing.JLabel();
        jbMa = new javax.swing.JLabel();
        jlHoVaTen = new javax.swing.JLabel();
        jlDiaChi = new javax.swing.JLabel();
        jlSDT = new javax.swing.JLabel();
        jlGioiTinh = new javax.swing.JLabel();
        jlEmail = new javax.swing.JLabel();
        jlChuyenKhoa = new javax.swing.JLabel();
        jlHocVan = new javax.swing.JLabel();
        jlKinhNghiem = new javax.swing.JLabel();
        txtMA = new javax.swing.JTextField();
        txtHoVaTen = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        JcheckBoxNam = new javax.swing.JCheckBox();
        jcheckBoxNu = new javax.swing.JCheckBox();
        txtEmail = new javax.swing.JTextField();
        jComBoxChuyenKhoa = new javax.swing.JComboBox<>();
        txthocVan = new javax.swing.JTextField();
        txtKinhnghiem = new javax.swing.JTextField();
        jbThem = new javax.swing.JButton();
        jbSua = new javax.swing.JButton();
        jbXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableBacSi = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jbTimKiem = new javax.swing.JButton();
        jlTimkiem = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbTaiAnh = new javax.swing.JLabel();
        jbChon = new javax.swing.JButton();
        jbLayDuLieu = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(980, 466));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JbThongTin.setText("Thông tin Bác Sĩ");
        add(JbThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, 28));

        jbMa.setText("Mã : ");
        add(jbMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 43, -1, -1));

        jlHoVaTen.setText("Họ và tên:");
        add(jlHoVaTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 92, -1, -1));

        jlDiaChi.setText("Địa chỉ:");
        add(jlDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 132, -1, -1));

        jlSDT.setText("Số điện thoại:");
        add(jlSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 166, -1, -1));

        jlGioiTinh.setText("Giới tính:");
        add(jlGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 203, -1, -1));

        jlEmail.setText("Email:");
        add(jlEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 244, -1, -1));

        jlChuyenKhoa.setText("Chuyên khoa:");
        add(jlChuyenKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 287, -1, -1));

        jlHocVan.setText("Học vấn:");
        add(jlHocVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 324, -1, -1));

        jlKinhNghiem.setText("Kinh nghiệm:");
        add(jlKinhNghiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 370, -1, -1));
        add(txtMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 40, 182, -1));
        add(txtHoVaTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 86, 182, -1));
        add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 126, 182, -1));
        add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 166, 182, -1));

        JcheckBoxNam.setText("Nam");
        add(JcheckBoxNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 201, -1, -1));

        jcheckBoxNu.setText("Nữ");
        add(jcheckBoxNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 241, 182, -1));

        jComBoxChuyenKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Răng hàm miệng", "Thần kinh", "Phỗ thuật", "Phụ sản", "Nhi khoa" }));
        add(jComBoxChuyenKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 281, 182, -1));
        add(txthocVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 321, 182, -1));
        add(txtKinhnghiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 370, 182, -1));

        jbThem.setText("Thêm");
        jbThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbThemActionPerformed(evt);
            }
        });
        add(jbThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 443, -1, -1));

        jbSua.setText("Sửa");
        jbSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSuaActionPerformed(evt);
            }
        });
        add(jbSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 443, -1, -1));

        jbXoa.setText("Xóa");
        jbXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbXoaActionPerformed(evt);
            }
        });
        add(jbXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 443, -1, -1));

        jtableBacSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtableBacSi.setCellSelectionEnabled(true);
        jtableBacSi.setMaximumSize(new java.awt.Dimension(400, 200));
        jtableBacSi.setMinimumSize(new java.awt.Dimension(135, 200));
        jtableBacSi.setPreferredSize(new java.awt.Dimension(400, 300));
        jtableBacSi.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(jtableBacSi);
        jtableBacSi.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 470, 310));
        add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 309, -1));

        jbTimKiem.setText("Tìm kiếm");
        jbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTimKiemActionPerformed(evt);
            }
        });
        add(jbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, -1, -1));

        jlTimkiem.setText("Tìm kiếm theo mã");
        add(jlTimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, -1, -1));

        jButton1.setText("Tải Ảnh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        lbTaiAnh.setBackground(new java.awt.Color(0, 0, 0));
        add(lbTaiAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 106, 123));

        jbChon.setText("Chọn");
        add(jbChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, -1, -1));

        jbLayDuLieu.setText("Lấy Dữ Liệu");
        jbLayDuLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLayDuLieuActionPerformed(evt);
            }
        });
        add(jbLayDuLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 443, -1, -1));
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

           if (JcheckBoxNam.isSelected()) {
                    gioiTinh = "Nam";
                } else if (jcheckBoxNu.isSelected()) {
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
            if (JcheckBoxNam.isSelected()) {
                    gioiTinh = "Nam";
                } else if (jcheckBoxNu.isSelected()) {
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
                bacSi.getKinhNgiemLamViec(),
                bacSi.getHocVan(),
                bacSi.getHinhAnh()
            });
        }

//         Gắn model vào JTable.
        jtableBacSi.setModel(model);

//        tự động chỉnh độ rộng cột với thanh cuộn ngang.
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
                bacSiTimKiem.getKinhNgiemLamViec(),
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
    public void reset(){
       txtMA.setText("");
       txtHoVaTen.setText("");
       txtDiaChi.setText("");
       txtSDT.setText("");
       txtEmail.setText("");
       txthocVan.setText("");
       txtKinhnghiem.setText("");
       jComBoxChuyenKhoa.setSelectedIndex(0);
       JcheckBoxNam.setSelected(false);
       jcheckBoxNu.setSelected(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JbThongTin;
    private javax.swing.JCheckBox JcheckBoxNam;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComBoxChuyenKhoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbChon;
    private javax.swing.JButton jbLayDuLieu;
    private javax.swing.JLabel jbMa;
    private javax.swing.JButton jbSua;
    private javax.swing.JButton jbThem;
    private javax.swing.JButton jbTimKiem;
    private javax.swing.JButton jbXoa;
    private javax.swing.JCheckBox jcheckBoxNu;
    private javax.swing.JLabel jlChuyenKhoa;
    private javax.swing.JLabel jlDiaChi;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlGioiTinh;
    private javax.swing.JLabel jlHoVaTen;
    private javax.swing.JLabel jlHocVan;
    private javax.swing.JLabel jlKinhNghiem;
    private javax.swing.JLabel jlSDT;
    private javax.swing.JLabel jlTimkiem;
    private javax.swing.JTable jtableBacSi;
    private javax.swing.JLabel lbTaiAnh;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtKinhnghiem;
    private javax.swing.JTextField txtMA;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txthocVan;
    // End of variables declaration//GEN-END:variables

}
