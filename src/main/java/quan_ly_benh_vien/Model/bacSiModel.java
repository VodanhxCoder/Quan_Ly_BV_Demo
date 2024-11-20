package quan_ly_benh_vien.Model;

import java.util.Date;

public class bacSiModel extends nguoiModel {

    private String ma;
    private String chuyenKhoa;
    private String kinhNghiemLamViec;
    private String hocVan;

    public bacSiModel() {
    }

    public bacSiModel(String ma, String chuyenKhoa, String kinhNghiemLamViec, String hocVan) {
        this.ma = ma;
        this.chuyenKhoa = chuyenKhoa;
        this.kinhNghiemLamViec = kinhNghiemLamViec;
        this.hocVan = hocVan;
    }

    public bacSiModel(String ma, String hoVaTen, String soDienThoai, String email, Date ngaySinh,
            String diaChi, String gioiTinh, String chuyenKhoa, String kinhNghiemLamViec,
            String hocVan, String hinhAnh) {
        super(hoVaTen, soDienThoai, email, ngaySinh, gioiTinh, hinhAnh, diaChi);
        this.ma = ma;
        this.chuyenKhoa = chuyenKhoa;
        this.kinhNghiemLamViec = kinhNghiemLamViec;
        this.hocVan = hocVan;
    }

    public String getMaBacSi() {
        return ma;
    }

    public void setMaBacSi(String ma) {
        this.ma = ma;
    }

    public String getChuyenKhoa() {
        return chuyenKhoa;
    }

    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }

    public String getKinhNghiemLamViec() {
        return kinhNghiemLamViec;
    }

    public void setKinhNgiemLamViec(String kinhNghiemLamViec) {
        this.kinhNghiemLamViec = kinhNghiemLamViec;
    }

    public String getHocVan() {
        return hocVan;
    }

    public void setHocVan(String hocVan) {
        this.hocVan = hocVan;
    }
}
