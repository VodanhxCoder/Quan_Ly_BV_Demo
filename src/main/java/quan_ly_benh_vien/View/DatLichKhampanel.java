/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quan_ly_benh_vien.View;

import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import quan_ly_benh_vien.Controller.DatLichKhamController;
import quan_ly_benh_vien.Model.DatLichKhamModel;
import quan_ly_benh_vien.Model.bacSiModel;

import quan_ly_benh_vien.View.Login.Component.Login;
import quan_ly_benh_vien.View.Main.Main;
import quan_ly_benh_vien.Data_Access_Object.QuanLyTaiKhoanDao;

/**
 *
 * @author khue1
 */
public class DatLichKhampanel extends javax.swing.JPanel {

    /**
     * Creates new form jpDatLichKham
     */
    private Main main;
    public DatLichKhampanel() {
        initComponents();
        timBacSiTheoChuyenKhoa();
        //ko lay mac dinh chuyen khoa: 
        cbbChuyenKhoa.setSelectedIndex(-1);
        refreshListView(Login.xacNhanDangNhap);
        //tao default model
        DefaultTableModel model = new DefaultTableModel();
        //Thêm cột vào model
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
        jTableBacSi.setModel(model);
        //tạo default cho Jlist
        jList.setModel(listModel);
        //Thưc hiện hanh đông khi chọn dòng trên jtableBácsi
        jTableBacSi.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {

            int selectedRow = jTableBacSi.getSelectedRow();
            //neu dòng đc chọn > 0 và bảng đã đươcj chọn 
            if (selectedRow >= 0 && jTableBacSi.isRowSelected(selectedRow)) {
                //Lấy giá trị hình ảnh của bác sĩ 
                String hinhAnh = (String) jTableBacSi.getValueAt(selectedRow, 9);
                if (hinhAnh != null) {
                    ImageIcon imageIcon = new ImageIcon(hinhAnh);
                    lblAnh.setIcon(imageIcon);  //Set icon của bác sĩ 
                }

            }
        }
        );
    }
    
     private void timBacSiTheoChuyenKhoa() {
        DatLichKhamController datLichKhamController = new DatLichKhamController();
        cbbChuyenKhoa.addActionListener((ActionEvent e) -> {
            //lay lua chon trong combobox 
            int selectedIndex = cbbChuyenKhoa.getSelectedIndex();
            if (selectedIndex >= 0) { //Nêú đã chọn 
                //lấy chuyên khoa
                String selectedChuyenKhoa = (String) cbbChuyenKhoa.getItemAt(selectedIndex);
                System.out.println("Đã chọn chuyên khoa: " + selectedChuyenKhoa);
               //Lấy danh sach bac sĩ và đưa vào model
                ArrayList<bacSiModel> danhSachBacSi = datLichKhamController.layDanhSachBacSiTheoChuyenKhoa(selectedChuyenKhoa);
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
                //hiển thị lên bảng
                jTableBacSi.setModel(model);

            } else {
                System.out.println("Chưa chọn chuyên khoa");
            }
        });
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBacSi = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jLabel18 = new javax.swing.JLabel();
        btnHuyLich = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        lblPhongKham = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        btnDatLich = new javax.swing.JButton();
        cbbChuyenKhoa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lblAnh = new javax.swing.JLabel();
        jpDatLich = new javax.swing.JPanel();
        cbbNgay = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblCaKham13 = new javax.swing.JLabel();
        lblCaKham7 = new javax.swing.JLabel();
        lblCaKham5 = new javax.swing.JLabel();
        lblCaKham2 = new javax.swing.JLabel();
        lblCaKham1 = new javax.swing.JLabel();
        lblCaKham10 = new javax.swing.JLabel();
        lblCaKham8 = new javax.swing.JLabel();
        lblCaKham11 = new javax.swing.JLabel();
        lblCaKham9 = new javax.swing.JLabel();
        lblCaKham4 = new javax.swing.JLabel();
        lblCaKham15 = new javax.swing.JLabel();
        lblCaKham6 = new javax.swing.JLabel();
        lblCaKham12 = new javax.swing.JLabel();
        lblCaKham3 = new javax.swing.JLabel();
        lblCaKham14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        jTableBacSi.setForeground(new java.awt.Color(0, 102, 102));
        jTableBacSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableBacSi.setAutoResizeMode(0);
        jTableBacSi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableBacSi.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jScrollPane3.setViewportView(jTableBacSi);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("Xem thông tin bác sĩ điều trị theo chuyên khoa");

        jScrollPane2.setViewportView(jList);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("Lịch sử đặt lịch khám / hủy lịch");

        btnHuyLich.setBackground(new java.awt.Color(0, 204, 204));
        btnHuyLich.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuyLich.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyLich.setText("Hủy lịch");
        btnHuyLich.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuyLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyLichActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("ĐỊA CHỈ KHÁM");

        lblPhongKham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhongKham.setForeground(new java.awt.Color(0, 102, 102));
        lblPhongKham.setText("Bệnh viện E:");

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblDiaChi.setForeground(new java.awt.Color(255, 102, 102));
        lblDiaChi.setText("89 Trần Cung - Nghĩa Tân - Cầu Giấy - Hà Nội");

        btnDatLich.setBackground(new java.awt.Color(0, 204, 204));
        btnDatLich.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatLich.setForeground(new java.awt.Color(255, 255, 255));
        btnDatLich.setText("Đặt lịch");
        btnDatLich.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDatLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLichActionPerformed(evt);
            }
        });

        cbbChuyenKhoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbChuyenKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa da liễu", "Khoa thần kinh", "Khoa Tâm lý", "Khoa xương khớp", "Khoa tai - mũi - họng", "Khoa mắt", "Khoa xét nghiệm" }));
        cbbChuyenKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChuyenKhoaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Chọn chuyên khoa");

        lblAnh.setText("Hình Ảnh");

        jpDatLich.setBackground(new java.awt.Color(255, 255, 255));

        cbbNgay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7" }));

        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Chọn ngày");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Đặt lịch khám");

        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Icon");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setText("Chọn và đặt lịch ");

        lblGia.setBackground(new java.awt.Color(255, 255, 255));
        lblGia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGia.setForeground(new java.awt.Color(0, 102, 102));
        lblGia.setText("Giá:");
        lblGia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblGia.setOpaque(true);

        lblCaKham13.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham13.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham13.setText("17:00 - 17:30");
        lblCaKham13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham13.setOpaque(true);
        lblCaKham13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham13MouseClicked(evt);
            }
        });

        lblCaKham7.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham7.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham7.setText("11:00 - 11:30");
        lblCaKham7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham7.setOpaque(true);
        lblCaKham7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham7MouseClicked(evt);
            }
        });

        lblCaKham5.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham5.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham5.setText("10:00 - 10:30");
        lblCaKham5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham5.setOpaque(true);
        lblCaKham5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham5MouseClicked(evt);
            }
        });

        lblCaKham2.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham2.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham2.setText("08:30 - 09:00");
        lblCaKham2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham2.setOpaque(true);
        lblCaKham2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham2MouseClicked(evt);
            }
        });

        lblCaKham1.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham1.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham1.setText("08:00 - 08:30");
        lblCaKham1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham1.setOpaque(true);
        lblCaKham1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham1MouseClicked(evt);
            }
        });

        lblCaKham10.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham10.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham10.setText("14:00 - 14:30");
        lblCaKham10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham10.setOpaque(true);
        lblCaKham10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham10MouseClicked(evt);
            }
        });

        lblCaKham8.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham8.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham8.setText("15:00 - 15:30");
        lblCaKham8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham8.setOpaque(true);
        lblCaKham8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham8MouseClicked(evt);
            }
        });

        lblCaKham11.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham11.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham11.setText("14:30 - 15:00");
        lblCaKham11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham11.setOpaque(true);
        lblCaKham11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham11MouseClicked(evt);
            }
        });

        lblCaKham9.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham9.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham9.setText("13:30 - 14:00");
        lblCaKham9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham9.setOpaque(true);
        lblCaKham9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham9MouseClicked(evt);
            }
        });

        lblCaKham4.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham4.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham4.setText("16:30 - 17:00");
        lblCaKham4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham4.setOpaque(true);
        lblCaKham4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham4MouseClicked(evt);
            }
        });

        lblCaKham15.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham15.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham15.setText("16:00 - 16:30");
        lblCaKham15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham15.setOpaque(true);
        lblCaKham15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham15MouseClicked(evt);
            }
        });

        lblCaKham6.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham6.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham6.setText("10:30 - 11:00");
        lblCaKham6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham6.setOpaque(true);
        lblCaKham6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham6MouseClicked(evt);
            }
        });

        lblCaKham12.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham12.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham12.setText("17:30 - 18:00");
        lblCaKham12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham12.setOpaque(true);
        lblCaKham12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham12MouseClicked(evt);
            }
        });

        lblCaKham3.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham3.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham3.setText("09:00 - 09:30");
        lblCaKham3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham3.setOpaque(true);
        lblCaKham3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham3MouseClicked(evt);
            }
        });

        lblCaKham14.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham14.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham14.setText("15:30 - 16:00");
        lblCaKham14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham14.setOpaque(true);
        lblCaKham14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham14MouseClicked(evt);
            }
        });

        jLayeredPane1.setLayer(lblCaKham13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lblCaKham9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lblCaKham5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lblCaKham13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lblCaKham1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaKham1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaKham5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaKham9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaKham14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpDatLichLayout = new javax.swing.GroupLayout(jpDatLich);
        jpDatLich.setLayout(jpDatLichLayout);
        jpDatLichLayout.setHorizontalGroup(
            jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatLichLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpDatLichLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpDatLichLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jpDatLichLayout.setVerticalGroup(
            jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatLichLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpDatLichLayout.createSequentialGroup()
                        .addGroup(jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(btnDatLich)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHuyLich))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPhongKham)
                                    .addComponent(lblDiaChi)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblAnh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(cbbChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuyLich)
                            .addComponent(btnDatLich))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPhongKham, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDiaChi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
   //    tạo 1 hàm random ra mã đặt lịch
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 5;
    private static final SecureRandom random = new SecureRandom();
    
    
    //Tạo ra 1 mã với độ dài là 5, với số và chữ cái viết hoa
    public static String generateRandomCode() {
        StringBuilder code = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            code.append(randomChar);
        }
        return code.toString().toUpperCase(); 
    }
    
    //    random mã bác sĩ theo chuyên khoa
    public static String getRandomMaBacSi(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        if (model.getRowCount() > 0) {
            int randomRowIndex = new Random().nextInt(model.getRowCount());
            Object maBacSi = model.getValueAt(randomRowIndex, 0);

            if (maBacSi != null) {
                return maBacSi.toString();
            }
        }
        return null;
    }

    private void refreshListView(String tenDangNhap) {
        DatLichKhamController datLichKhamController = new DatLichKhamController();
        ArrayList<DatLichKhamModel> danhSachDatLich = datLichKhamController.layDanhSachDatLich2(tenDangNhap);
        listModel.clear();
        for (DatLichKhamModel datLichKham : danhSachDatLich) {
            String thongTinDatLich = "Mã đặt lịch: " + datLichKham.getMaDatLich()
                    + ", trạng thái: " + datLichKham.getTrangThaiThanhToan()
                    + ", " + datLichKham.getThoiGioiKham()
                    + ", " + datLichKham.getChuyenKhoa()
                    + ", mã bác sĩ: " + datLichKham.getMaBacSi();
            listModel.addElement(thongTinDatLich);
        }
    }

    //    đặt lịch và lưu trữ
    DefaultListModel<String> listModel = new DefaultListModel<>();
    Map<String, Set<String>> selectedDates = new HashMap<>();
    String maDatLich;
    // Đặt lịch
    public void datLich(String selectedLabel, String selectedDate, String selectChuyenKhoa) {
        //lấy ngày và ca khám khi ấn  vào các ca khám 
        String thoiGianKham = "Ca khám: [" + selectedDate + ", " + selectedLabel + "]";
        //Lấy chuyên khoa 
        String chuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        //Tạo 1 luồng đặt lịch cho khachs hang 
        DatLichKhamController datLichController = new DatLichKhamController();

        // Lấy ra ca khám đã chọn 
        // nếu không có thì tạo mới ca khám 
        Set<String> selectedCaKham = selectedDates.get(thoiGianKham);
        if (selectedCaKham == null) {
            selectedCaKham = new HashSet<>();//Tạo một danh sách (Set) mới nếu chưa tồn tại
        }

        selectedCaKham.add(selectedLabel); // Thêm thời gian khám vào 
        selectedDates.put(selectedDate, selectedCaKham); 

        // Tạo nội dung hiển thị trên jList
        float giaDichVu = 300000.0f;
        lblGia.setText("Giá: " + giaDichVu + "đ");
        lblPhongKham.setText("Bệnh Viện E");
        lblDiaChi.setText("89 Trần Cung - Nghĩa Tân - Cầu Giấy - Hà Nội");

        maDatLich = generateRandomCode(); //tạo ra 1 mã đặt lịch 
        //gộp địa chỉ 
        String diaChi = lblPhongKham.getText() + lblDiaChi.getText();
        //Tạo ra 1 mã bác sĩ theo chuyên khoa 
        String maBacSi = getRandomMaBacSi(jTableBacSi);
        String tenDangNhap=null;
        try {
            tenDangNhap = QuanLyTaiKhoanDao.MD5Encryptor(Login.xacNhanDangNhap);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DatLichKhampanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DatLichKhampanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //kiểm tra xem có bị trùng lịch hay bị trùng bác sĩ ko
        boolean trungLich = datLichController.kiemTraTrungLich(thoiGianKham);
        boolean trungKhoa = datLichController.kiemTraChuyenKhoa(chuyenKhoa);
        if (chuyenKhoa == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chuyên khoa trước khi đặt lịch !");
        } else {
            if (trungLich && trungKhoa) {
                JOptionPane.showMessageDialog(this, "Bạn không được chọn trùng chuyên khoa hoặc ngày\ntrong cùng 1 ca !", "Lỗi chọn trùng ca", JOptionPane.ERROR_MESSAGE);
            } else {
                String trangThaiThanhToan = "Chưa thanh toán";
                //đặt lịch trong tạng thái chưa thanh toán
                DatLichKhamModel datLich = new DatLichKhamModel(maDatLich, giaDichVu, thoiGianKham, diaChi, tenDangNhap, trangThaiThanhToan, maBacSi, selectChuyenKhoa);
                int result = datLichController.insertDatLich(datLich);
                // Kiểm tra kết quả lưu vào CSDL
                if (result > 0) {
                    refreshListView(tenDangNhap);
                    JOptionPane.showMessageDialog(this, "Đặt lịch thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Đặt lịch thất bại!");
                }
            }

        }
    }
    
    
    
    private void lblCaKham14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham14MouseClicked
        String selectedLabel = lblCaKham14.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham14MouseClicked

    private void lblCaKham8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham8MouseClicked
        String selectedLabel = lblCaKham8.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham8MouseClicked

    private void lblCaKham4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham4MouseClicked
        String selectedLabel = lblCaKham4.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham4MouseClicked

    private void lblCaKham13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham13MouseClicked
        String selectedLabel = lblCaKham13.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham13MouseClicked

    private void lblCaKham7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham7MouseClicked
        String selectedLabel = lblCaKham7.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham7MouseClicked

    private void lblCaKham12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham12MouseClicked
        String selectedLabel = lblCaKham12.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham12MouseClicked

    private void lblCaKham3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham3MouseClicked
        String selectedLabel = lblCaKham3.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham3MouseClicked

    private void lblCaKham1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham1MouseClicked
        String selectedLabel = lblCaKham1.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham1MouseClicked

    private void lblCaKham6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham6MouseClicked
        String selectedLabel = lblCaKham6.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham6MouseClicked

    private void lblCaKham11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham11MouseClicked
        String selectedLabel = lblCaKham11.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham11MouseClicked

    private void lblCaKham9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham9MouseClicked
        String selectedLabel = lblCaKham9.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham9MouseClicked

    private void lblCaKham2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham2MouseClicked
        String selectedLabel = lblCaKham2.getText();;
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham2MouseClicked

    private void lblCaKham5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham5MouseClicked
        String selectedLabel = lblCaKham5.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham5MouseClicked

    private void lblCaKham10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham10MouseClicked
        String selectedLabel = lblCaKham10.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham10MouseClicked

    private void lblCaKham15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham15MouseClicked
        String selectedLabel = lblCaKham15.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham15MouseClicked

    private void btnHuyLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyLichActionPerformed
        // Lấy chỉ số dòng được chọn trong JList
        int selectedIndex = jList.getSelectedIndex(); // lấy dòng index 
        if (selectedIndex == -1) { // Th hợp ko chọn dòng
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một lịch khám để xóa.");
        }
        if (selectedIndex != -1) { // Dã chọn 
            // Lấy dòng được chọn từ JList
            Object selectedObject = jList.getModel().getElementAt(selectedIndex);
            String selectedText = selectedObject.toString();
            int startIndex = selectedText.indexOf("Mã đặt lịch: "); //đặt start index khi thấy mã đặt lịch
            if (startIndex != -1) { //Nếu lấy index thành công 
                startIndex += "Mã đặt lịch: ".length(); // đặt index đằng sau ma dat lịch -> lấy được mã đặt lịch
                int commaIndex = selectedText.indexOf(",", startIndex); // tìm từ dtartínex đến dấu ,-> lấy mã lịch 
                if (commaIndex != -1) {
                    String maHuyLich = selectedText.substring(startIndex, commaIndex); //lấy mã hủy lịch 
                    listModel.remove(selectedIndex);  // xóa ra khỏi list lịch 
                    System.out.println("chọn được đặt lịch: " + maHuyLich);

                    // Sử dụng maDatLich để xóa dữ liệu tương ứng trong CSDL
                    int result = xoaLichKhamTrongCSDL(maHuyLich);
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "Xóa lịch khám thành công!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa lịch khám thất bại!");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnHuyLichActionPerformed
//dung DatLichKhamController
    private int xoaLichKhamTrongCSDL(String maDatLich) {
        // Sử dụng maDatLich để thực hiện xóa dữ liệu trong CSDL
        DatLichKhamController datLichController = new DatLichKhamController();
        return datLichController.xoaLichKhamTheoId(maDatLich);
    }

//    đăng ký lịch đưa ra số lượng đăng ký, danh sách mã đặt lịch
    static int soLuongLichDat;
    static List<String> maDatLichList = new ArrayList<>();
    private void btnDatLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLichActionPerformed
        Object[] selectedItems = jList.getSelectedValues();
        int itemCount = selectedItems.length;

        if (itemCount == 0) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn ít nhất một lịch trước khi thanh toán.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
//
//        // Lặp qua danh sách các lịch đã chọn và kiểm tra nếu có lịch đã thanh toán
        for (Object selectedItem : selectedItems) {
            String selectedData = selectedItem.toString();
            String maDatLichItem = extractMaDatLich(selectedData);

            // Kiểm tra nếu chuỗi "Đã thanh toán" xuất hiện trong selectedItem
            if (selectedData.contains("Đã thanh toán")) {
                // Hiển thị mã đặt lịch trong thông báo
                JOptionPane.showMessageDialog(this, "Mã đặt lịch: " + maDatLichItem +"đã thanh toán\nvui lòng chọn lịch khác để tiếp tục thanh toán !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return; // Dừng vòng lặp nếu tìm thấy lịch đã thanh toán
            }

            maDatLichList.add(maDatLichItem);
        }

        soLuongLichDat = itemCount;
        try {
            main = new Main();
        } catch (SQLException ex) {
            Logger.getLogger(DatLichKhampanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.setThanhToan();
        }

        //    tìm mã đặt lịch
        private String extractMaDatLich(String data) {
            int startIndex = data.indexOf("Mã đặt lịch:") + "Mã đặt lịch:".length();
            int endIndex = data.indexOf(",", startIndex);
            if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
                String maLich = data.substring(startIndex, endIndex).trim();
                return maLich;
            }
            return "";
    }//GEN-LAST:event_btnDatLichActionPerformed

    private void cbbChuyenKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChuyenKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbChuyenKhoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLich;
    private javax.swing.JButton btnHuyLich;
    private javax.swing.JComboBox<String> cbbChuyenKhoa;
    private javax.swing.JComboBox<String> cbbNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList<String> jList;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableBacSi;
    private javax.swing.JPanel jpDatLich;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblCaKham1;
    private javax.swing.JLabel lblCaKham10;
    private javax.swing.JLabel lblCaKham11;
    private javax.swing.JLabel lblCaKham12;
    private javax.swing.JLabel lblCaKham13;
    private javax.swing.JLabel lblCaKham14;
    private javax.swing.JLabel lblCaKham15;
    private javax.swing.JLabel lblCaKham2;
    private javax.swing.JLabel lblCaKham3;
    private javax.swing.JLabel lblCaKham4;
    private javax.swing.JLabel lblCaKham5;
    private javax.swing.JLabel lblCaKham6;
    private javax.swing.JLabel lblCaKham7;
    private javax.swing.JLabel lblCaKham8;
    private javax.swing.JLabel lblCaKham9;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblPhongKham;
    // End of variables declaration//GEN-END:variables
}
