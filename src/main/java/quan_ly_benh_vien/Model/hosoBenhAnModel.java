
package quan_ly_benh_vien.Model;

public class hosoBenhAnModel {
    private String maHoSo;
    private String tienSuBenhAn;
    private String trieuChung;
    private String chuanDoan;
    private String ketLuan;
    private String maBenhNhan;
    private String maBacSi;

    public hosoBenhAnModel(String maHoSo, String tienSuBenhAn, String trieuChung, String chuanDoan, String ketLuan, String maBenhNhan, String maBacSi) {
        this.maHoSo = maHoSo;
        this.tienSuBenhAn = tienSuBenhAn;
        this.trieuChung = trieuChung;
        this.chuanDoan = chuanDoan;
        this.ketLuan = ketLuan;
        this.maBenhNhan = maBenhNhan;
        this.maBacSi = maBacSi;
    }
    
    public hosoBenhAnModel() {}

    public String getMaHoSo() {
        return maHoSo;
    }

    public String getTienSuBenhAn() {
        return tienSuBenhAn;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public String getChuanDoan() {
        return chuanDoan;
    }

    public String getKetLuan() {
        return ketLuan;
    }

    public void setMaHoSo(String maHoSo) {
        this.maHoSo = maHoSo;
    }

    public void setTienSuBenhAn(String tienSuBenhAn) {
        this.tienSuBenhAn = tienSuBenhAn;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public void setKetLuan(String ketLuan) {
        this.ketLuan = ketLuan;
    }
    

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public String getMaBacSi() {
        return maBacSi;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public void setMaBacSi(String maBacSi) {
        this.maBacSi = maBacSi;
    }

  
    
}
