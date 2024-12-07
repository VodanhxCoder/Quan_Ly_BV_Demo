/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quan_ly_benh_vien.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import quan_ly_benh_vien.Controller.DatLichKhamController;
import quan_ly_benh_vien.Model.BenhNhanKhamModel;
import quan_ly_benh_vien.View.Login.Component.Login;

/**
 *
 * @author khue1
 */
public class BacSiKham extends javax.swing.JPanel {

    /**
     * Creates new form BacSiKham
     */
    // Mảng chứa các JLabel
    private List<JLabel> slots;
    private DefaultTableModel model;

    public BacSiKham() {
        initComponents();
        initializeSlots();
        themSuKienChoLabels();

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa
            }
        };
        model.addColumn("Mã Bệnh Nhân");
        model.addColumn("Họ và Tên");
        model.addColumn("Mã Đặt Lịch");
        model.addColumn("Thời Giờ Khám");
        model.addColumn("Ngày Sinh");
        model.addColumn("Giới Tính");
        jTableBenhNhan.setModel(model);
        hienThiDanhSachBN(Login.id);
    }

    private void initializeSlots() {
        // Khởi tạo nội dung cho các ca khám
        String[] timeSlots = {
            "08:00 - 08:30", "08:30 - 09:00", "09:00 - 09:30", "09:30 - 10:00",
            "10:00 - 10:30", "10:30 - 11:00", "11:00 - 11:30", "11:30 - 12:00",
            "13:30 - 14:00", "14:00 - 14:30", "14:30 - 15:00", "15:00 - 15:30",
            "15:30 - 16:00", "16:00 - 16:30"
        };
        // Lưu tất cả các JLabel vào mảng
        slots = new ArrayList<>();
        slots.add(lblCaKham1);
        slots.add(lblCaKham2);
        slots.add(lblCaKham3);
        slots.add(lblCaKham4);
        slots.add(lblCaKham5);
        slots.add(lblCaKham6);
        slots.add(lblCaKham7);
        slots.add(lblCaKham8);
        slots.add(lblCaKham9);
        slots.add(lblCaKham10);
        slots.add(lblCaKham11);
        slots.add(lblCaKham12);
        slots.add(lblCaKham13);
        slots.add(lblCaKham14);

    }

    private void hienThiDanhSachBN(String maBacSi) {
        DatLichKhamController datLichController = new DatLichKhamController();
        ArrayList<BenhNhanKhamModel> benhNhans = datLichController.layDanhSachDatLich(maBacSi);

        model.setRowCount(0);

      //  model.addColumn("Mã Bệnh Nhân");
//        model.addColumn("Mã Đặt Lịch");
//        model.addColumn("Họ và Tên");
//        model.addColumn("Thời Giờ Khám");
//        model.addColumn("Ngày Sinh");
//        model.addColumn("Giới Tính");

        for (BenhNhanKhamModel benhNhan : benhNhans) {
            model.addRow(new Object[]{
                
                benhNhan.getMaBenhnhan(),
                benhNhan.getHoVaTen(),
                benhNhan.getMaDatLich(),
                benhNhan.getThoiGioiKham(),
                benhNhan.getNgaySinh(),
                benhNhan.getGioiTinh()
            });
        }
    }

    public void themSuKienChoLabels() {
        for (JLabel label : slots) {
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Đổi màu nền khi người dùng click vào JLabel
                    Resetcolor();
                    label.setBackground(new Color(0, 255, 0));  // Màu nền xanh lá
                    label.setOpaque(true);  // Để màu nền hiển thị
                }
            });
        }
    }
    // Danh sách giờ tương ứng
    private static String[] timeSlots = {
        "08:00 - 08:30", "08:30 - 09:00", "09:00 - 09:30", "09:30 - 10:00",
        "10:00 - 10:30", "10:30 - 11:00", "11:00 - 11:30",
        "14:00 - 14:30", "14:30 - 15:00", "15:00 - 15:30",
        "15:30 - 16:00", "16:00 - 16:30", "16:30 - 17:00", "17:00 - 17:30"
    };

    //lấy ca hiện tại để chọn
    private static int findCurrentSlotIndex(LocalTime now) {
        // Giờ bắt đầu và kết thúc của từng ca
        LocalTime[] startTimes = {
            LocalTime.of(8, 0), LocalTime.of(8, 30), LocalTime.of(9, 0), LocalTime.of(9, 30),
            LocalTime.of(10, 0), LocalTime.of(10, 30), LocalTime.of(11, 0), LocalTime.of(11, 30),
            LocalTime.of(13, 30), LocalTime.of(14, 0), LocalTime.of(14, 30), LocalTime.of(15, 0),
            LocalTime.of(15, 30), LocalTime.of(16, 0), LocalTime.of(16, 30), LocalTime.of(17, 0)
        };
        LocalTime[] endTimes = {
            LocalTime.of(8, 30), LocalTime.of(9, 0), LocalTime.of(9, 30), LocalTime.of(10, 0),
            LocalTime.of(10, 30), LocalTime.of(11, 0), LocalTime.of(11, 30), LocalTime.of(12, 0),
            LocalTime.of(14, 0), LocalTime.of(14, 30), LocalTime.of(15, 0), LocalTime.of(15, 30),
            LocalTime.of(16, 0), LocalTime.of(16, 30), LocalTime.of(17, 0), LocalTime.of(17, 30)
        };

        // Duyệt qua tất cả các ca để kiểm tra thời gian hiện tại
        for (int i = 0; i < startTimes.length; i++) {
            if (!now.isBefore(startTimes[i]) && now.isBefore(endTimes[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jpDatLich = new javax.swing.JPanel();
        cbbNgay = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCaHienTai = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblCaKham14 = new javax.swing.JLabel();
        lblCaKham7 = new javax.swing.JLabel();
        lblCaKham5 = new javax.swing.JLabel();
        lblCaKham2 = new javax.swing.JLabel();
        lblCaKham1 = new javax.swing.JLabel();
        lblCaKham8 = new javax.swing.JLabel();
        lblCaKham10 = new javax.swing.JLabel();
        lblCaKham9 = new javax.swing.JLabel();
        lblCaKham13 = new javax.swing.JLabel();
        lblCaKham12 = new javax.swing.JLabel();
        lblCaKham6 = new javax.swing.JLabel();
        lblCaKham3 = new javax.swing.JLabel();
        lblCaKham11 = new javax.swing.JLabel();
        lblCaKham4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCaKham = new javax.swing.JTextField();
        txtTenBenhNhan = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnKham = new javax.swing.JLabel();
        txtMaBenhNhan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBenhNhan = new javax.swing.JTable();

        jRadioButton1.setText("jRadioButton1");

        setBackground(new java.awt.Color(255, 255, 255));

        jpDatLich.setBackground(new java.awt.Color(255, 255, 255));

        cbbNgay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7" }));

        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Chọn ngày");

        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Icon");

        btnCaHienTai.setBackground(new java.awt.Color(0, 204, 204));
        btnCaHienTai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCaHienTai.setForeground(new java.awt.Color(255, 255, 255));
        btnCaHienTai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCaHienTai.setText("Ca hiện tại");
        btnCaHienTai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCaHienTai.setOpaque(true);
        btnCaHienTai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCaHienTaiMouseClicked(evt);
            }
        });

        lblCaKham14.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham14.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham14.setText("17:00 - 17:30");
        lblCaKham14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham14.setOpaque(true);
        lblCaKham14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham14MouseClicked(evt);
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

        lblCaKham8.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham8.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham8.setText("14:00 - 14:30");
        lblCaKham8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham8.setOpaque(true);
        lblCaKham8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham8MouseClicked(evt);
            }
        });

        lblCaKham10.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham10.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham10.setText("15:00 - 15:30");
        lblCaKham10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham10.setOpaque(true);
        lblCaKham10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham10MouseClicked(evt);
            }
        });

        lblCaKham9.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham9.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham9.setText("14:30 - 15:00");
        lblCaKham9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham9.setOpaque(true);
        lblCaKham9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham9MouseClicked(evt);
            }
        });

        lblCaKham13.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham13.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham13.setText("16:30 - 17:00");
        lblCaKham13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham13.setOpaque(true);
        lblCaKham13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham13MouseClicked(evt);
            }
        });

        lblCaKham12.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham12.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham12.setText("16:00 - 16:30");
        lblCaKham12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham12.setOpaque(true);
        lblCaKham12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham12MouseClicked(evt);
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

        lblCaKham11.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham11.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham11.setText("15:30 - 16:00");
        lblCaKham11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham11.setOpaque(true);
        lblCaKham11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham11MouseClicked(evt);
            }
        });

        lblCaKham4.setBackground(new java.awt.Color(0, 204, 204));
        lblCaKham4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham4.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham4.setText("09:30 - 10:00");
        lblCaKham4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham4.setOpaque(true);
        lblCaKham4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham4MouseClicked(evt);
            }
        });

        jLayeredPane1.setLayer(lblCaKham14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCaKham4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lblCaKham1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(lblCaKham8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(lblCaKham5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lblCaKham12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCaKham14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(lblCaKham6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaKham8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaKham12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaKham14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(jpDatLichLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addGroup(jpDatLichLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpDatLichLayout.createSequentialGroup()
                                .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(btnCaHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jpDatLichLayout.setVerticalGroup(
            jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatLichLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpDatLichLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpDatLichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCaHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        btnCaHienTai.getAccessibleContext().setAccessibleName("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Ca khám");

        jLabel3.setText("Giới Tính");

        txtCaKham.setEditable(false);
        txtCaKham.setEnabled(false);
        txtCaKham.setMaximumSize(new java.awt.Dimension(300, 22));

        txtTenBenhNhan.setEditable(false);
        txtTenBenhNhan.setEnabled(false);
        txtTenBenhNhan.setMaximumSize(new java.awt.Dimension(300, 22));

        txtGioiTinh.setEditable(false);
        txtGioiTinh.setEnabled(false);
        txtGioiTinh.setMaximumSize(new java.awt.Dimension(300, 22));

        jLabel7.setText("Tuổi");

        txtTuoi.setEditable(false);
        txtTuoi.setEnabled(false);
        txtTuoi.setMaximumSize(new java.awt.Dimension(300, 22));

        jLabel8.setText("Tên Bệnh Nhân");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Thông Tin Sơ Bộ");

        btnKham.setBackground(new java.awt.Color(0, 204, 204));
        btnKham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKham.setForeground(new java.awt.Color(255, 255, 255));
        btnKham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnKham.setText("Khám Bệnh");
        btnKham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKham.setOpaque(true);
        btnKham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKhamMouseClicked(evt);
            }
        });

        txtMaBenhNhan.setEditable(false);
        txtMaBenhNhan.setEnabled(false);
        txtMaBenhNhan.setMaximumSize(new java.awt.Dimension(300, 22));

        jLabel9.setText("Mã bệnh nhân");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(71, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCaKham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addComponent(txtTenBenhNhan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTuoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGioiTinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 83, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnKham, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCaKham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(btnKham, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        jTableBenhNhan.setForeground(new java.awt.Color(0, 102, 102));
        jTableBenhNhan.setColumnSelectionAllowed(true);
        jTableBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableBenhNhan.setRowHeight(25);
        jTableBenhNhan.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jTableBenhNhan.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableBenhNhan);
        jTableBenhNhan.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jpDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents
private void Resetcolor() {
        for (JLabel slot : slots) {
            slot.setBackground(new Color(0, 204, 204)); // Reset màu
        }
    }
    private void btnCaHienTaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaHienTaiMouseClicked
        // TODO add your handling code here:
        // Xác định ca hiện tại
        LocalTime now = LocalTime.of(8, 30);
        int index = findCurrentSlotIndex(now);

        if (index != -1) {

            Resetcolor();
            slots.get(index).setBackground(Color.green); // Đánh dấu ca hiện tại
            JOptionPane.showMessageDialog(this, "Ca hiện tại: " + timeSlots[index]);
        } else {
            JOptionPane.showMessageDialog(this, "Không có ca nào phù hợp với thời gian hiện tại!");
        }
    }//GEN-LAST:event_btnCaHienTaiMouseClicked

    private void btnKhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKhamMouseClicked

    private void lblCaKham14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham14MouseClicked
//        String selectedLabel = lblCaKham14.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham14MouseClicked

    private void lblCaKham7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham7MouseClicked
//        String selectedLabel = lblCaKham7.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham7MouseClicked

    private void lblCaKham5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham5MouseClicked
//        String selectedLabel = lblCaKham5.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham5MouseClicked

    private void lblCaKham2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham2MouseClicked
//        String selectedLabel = lblCaKham2.getText();;
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham2MouseClicked

    private void lblCaKham1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham1MouseClicked
//        String selectedLabel = lblCaKham1.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham1MouseClicked

    private void lblCaKham8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham8MouseClicked
//        String selectedLabel = lblCaKham8.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham8MouseClicked

    private void lblCaKham10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham10MouseClicked
//        String selectedLabel = lblCaKham10.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham10MouseClicked

    private void lblCaKham9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham9MouseClicked
//        String selectedLabel = lblCaKham9.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham9MouseClicked

    private void lblCaKham13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham13MouseClicked
//        String selectedLabel = lblCaKham13.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham13MouseClicked

    private void lblCaKham12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham12MouseClicked
//        String selectedLabel = lblCaKham12.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham12MouseClicked

    private void lblCaKham6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham6MouseClicked
//        String selectedLabel = lblCaKham6.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham6MouseClicked

    private void lblCaKham3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham3MouseClicked
//        String selectedLabel = lblCaKham3.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham3MouseClicked

    private void lblCaKham11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham11MouseClicked
//        String selectedLabel = lblCaKham11.getText();
//        String selectedDate = (String) cbbNgay.getSelectedItem();


    }//GEN-LAST:event_lblCaKham11MouseClicked

    private void lblCaKham4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCaKham4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCaHienTai;
    private javax.swing.JLabel btnKham;
    private javax.swing.JComboBox<String> cbbNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableBenhNhan;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JPanel jpDatLich;
    private javax.swing.JLabel lblCaKham1;
    private javax.swing.JLabel lblCaKham10;
    private javax.swing.JLabel lblCaKham11;
    private javax.swing.JLabel lblCaKham12;
    private javax.swing.JLabel lblCaKham13;
    private javax.swing.JLabel lblCaKham14;
    private javax.swing.JLabel lblCaKham2;
    private javax.swing.JLabel lblCaKham3;
    private javax.swing.JLabel lblCaKham4;
    private javax.swing.JLabel lblCaKham5;
    private javax.swing.JLabel lblCaKham6;
    private javax.swing.JLabel lblCaKham7;
    private javax.swing.JLabel lblCaKham8;
    private javax.swing.JLabel lblCaKham9;
    private javax.swing.JTextField txtCaKham;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtMaBenhNhan;
    private javax.swing.JTextField txtTenBenhNhan;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables

}
