-- Tạo database
CREATE DATABASE QLBV;
GO
USE QLBV;
GO

-- Bảng tài khoản
CREATE TABLE taikhoan (
    tenDangNhap VARCHAR(255) PRIMARY KEY NOT NULL,
    hoVaTen NVARCHAR(255) NOT NULL,
    email VARCHAR(255  ) NOT NULL UNIQUE,
    matKhau VARCHAR(255) NOT NULL,
    gioiTinh NVARCHAR(255) NOT NULL,
    typeUser VARCHAR(255) NOT NULL
);
GO

-- Bảng thanh toán
CREATE TABLE thanhtoan (
    maThanhToan VARCHAR(255) PRIMARY KEY NOT NULL,
    soTaiKhoan VARCHAR(255) NOT NULL,
    tenTaiKhoan VARCHAR(255) NOT NULL,
    tenNganHang VARCHAR(255) NOT NULL,
    thoiGianThanhToan DATETIME NOT NULL,
    tenDangNhap VARCHAR(255) NOT NULL,
    FOREIGN KEY (tenDangNhap) REFERENCES taikhoan(tenDangNhap) ON DELETE CASCADE
);
GO

-- Bảng bác sĩ
CREATE TABLE bacsi (
    maBacSi INT IDENTITY(1,1)  PRIMARY KEY NOT NULL,
    hoVaTen NVARCHAR(255) NOT NULL,
    soDienThoai VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    ngaySinh DATE,
    gioiTinh NVARCHAR(255) NOT NULL,
    chuyenKhoa NVARCHAR(255) NOT NULL,
    kinhNghiemLamViec NVARCHAR(255),
    hocVan NVARCHAR(255) NOT NULL,
    hinhAnh NVARCHAR(255),
    diaChi NVARCHAR(255) NOT NULL
);
GO


-- Bảng lịch khám
CREATE TABLE lichkham (
    maDatLich VARCHAR(255) PRIMARY KEY NOT NULL,
    giaDichVuKham FLOAT NOT NULL,
    thoiGianKham nVarchar(500) NOT NULL,
    diaChiKham NVARCHAR(255) NOT NULL,
    trangThaiThanhToan NVARCHAR(255) NOT NULL,
    tenDangNhap VARCHAR(255) NOT NULL,
    maBacSi INT NOT NULL,
    FOREIGN KEY (tenDangNhap) REFERENCES taikhoan(tenDangNhap) ON DELETE CASCADE,
    FOREIGN KEY (maBacSi) REFERENCES bacsi(maBacSi) ON DELETE CASCADE
);
GO

-- Bảng bệnh nhân
CREATE TABLE benhnhan (
    maBenhNhan INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    hoVaTen NVARCHAR(255) NOT NULL,
    soDienThoai VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
    diaChi NVARCHAR(255),
    gioiTinh NVARCHAR(255) NOT NULL,
    ngaySinh DATE,
    hinhAnh NVARCHAR(255),
    tenDangNhap VARCHAR(255) NOT NULL,
    FOREIGN KEY (tenDangNhap) REFERENCES taikhoan(tenDangNhap) ON DELETE CASCADE
);
GO

-- Bảng hồ sơ bệnh nhân
CREATE TABLE hosobenhnhan (
    maHoSo INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    tienSuBenhAn NVARCHAR(MAX) NOT NULL,
    trieuChung NVARCHAR(MAX) NOT NULL,
    chuanDoan NVARCHAR(Max) NOT NULL,
    ketLuan NVARCHAR(Max) NOT NULL,
    maBenhNhan INT NOT NULL,
    maBacSi INT   NOT NULL,
    FOREIGN KEY (maBenhNhan) REFERENCES benhnhan(maBenhNhan) ON DELETE CASCADE,
    FOREIGN KEY (maBacSi) REFERENCES bacsi(maBacSi) ON DELETE CASCADE
);
GO
INSERT INTO taikhoan (tenDangNhap, hoVaTen, email, matKhau, gioiTinh, typeUser)
VALUES
(CONVERT(varchar(32), HASHBYTES('MD5', 'nguyenhoaqp123'), 2), N'Nguyễn Thị Hoa', 'nguyenhoa@gmail.com', CONVERT(varchar(32), HASHBYTES('MD5', '@Khueqp123'), 2), N'Nữ', 'user'),
(CONVERT(varchar(32), HASHBYTES('MD5', 'leminhtuanqp123'), 2), N'Lê Minh Tuấn', 'leminhtuan@gmail.com', CONVERT(varchar(32), HASHBYTES('MD5', '@Khueqp123'), 2), N'Nam', 'user'),
(CONVERT(varchar(32), HASHBYTES('MD5', 'hoangnhungqp123'), 2), N'Hoàng Thị Nhung', 'hoangnhung@gmail.com', CONVERT(varchar(32), HASHBYTES('MD5', '@Khueqp123'), 2), N'Nữ', 'user'),
(CONVERT(varchar(32), HASHBYTES('MD5', 'phamvanhungqp123'), 2), N'Phạm Văn Hùng', 'phamvanhung@gmail.com', CONVERT(varchar(32), HASHBYTES('MD5', '@Khueqp123'), 2), N'Nam', 'user'),
(CONVERT(varchar(32), HASHBYTES('MD5', 'tranphuongqp123'), 2), N'Trần Thị Phương', 'tranphuong@gmail.com', CONVERT(varchar(32), HASHBYTES('MD5', '@Khueqp123'), 2), N'Nữ', 'user'),
(CONVERT(varchar(32), HASHBYTES('MD5', 'Khueqp1'), 2), N'Nguyễn Minh Khuê', 'Khueqp2004@gmail.com', CONVERT(varchar(32), HASHBYTES('MD5', '@Khueqp123'), 2), N'Nam', 'admin');

go
INSERT INTO bacsi (hoVaTen, soDienThoai, email, ngaySinh, gioiTinh, chuyenKhoa, kinhNghiemLamViec, hocVan, hinhAnh, diaChi)
VALUES
(N'Lê Văn Hải', '0978123456', 'levanhai@gmail.com', '1985-06-12', N'Nam', N'Khoa da liễu', N'10 năm', N'Thạc sĩ Y học', N'levanhai.png', N'123 Trần Hưng Đạo, Hà Nội'),
(N'Trần Thị Mai', '0902345678', 'tranthimai@gmail.com', '1990-03-18', N'Nữ', N'Khoa da liễu', N'8 năm', N'Tiến sĩ Y học', N'tranthimai.png', N'456 Lý Thường Kiệt, TP.HCM'),
(N'Phạm Đức Anh', '0918765432', 'phamducanh@gmail.com', '1988-11-02', N'Nam', N'Khoa da liễu', N'12 năm', N'Thạc sĩ Y học', N'phamducanh.png', N'789 Nguyễn Trãi, Đà Nẵng'),
(N'Hoàng Thị Lan', '0987456123', 'hoangthilan@gmail.com', '1992-07-25', N'Nữ', N'Khoa thần kinh', N'6 năm', N'Cử nhân Y học', N'hoangthilan.png', N'321 Bạch Đằng, Cần Thơ'),
(N'Nguyễn Văn Bình', '0932123456', 'nguyenvanbinh@gmail.com', '1978-05-20', N'Nam', N'Khoa thần kinh', N'20 năm', N'Tiến sĩ Y học', N'nguyenvanbinh.png', N'654 Hai Bà Trưng, Huế');
go
-- Chèn dữ liệu vào bảng bệnh nhân với tên tài khoản là tên + qp123 và mã hóa MD5 cho tên tài khoản và mật khẩu
INSERT INTO benhnhan (hoVaTen, soDienThoai, email, diaChi, gioiTinh, ngaySinh, hinhAnh, tenDangNhap)
VALUES
(N'Nguyễn Thị Hoa', '0912345678', 'nguyenhoa@gmail.com', N'12 Lý Chính Thắng, Hà Nội', N'Nữ', '1995-01-15', N'hoa.png', CONVERT(varchar(32), HASHBYTES('MD5', 'nguyenhoaqp123'), 2)),
(N'Lê Minh Tuấn', '0934567890', 'leminhtuan@gmail.com', N'45 Lê Lợi, TP.HCM', N'Nam', '1990-09-22', N'tuan.png', CONVERT(varchar(32), HASHBYTES('MD5', 'leminhtuanqp123'), 2)),
(N'Hoàng Thị Nhung', '0987654321', 'hoangnhung@gmail.com', N'78 Trần Phú, Đà Nẵng', N'Nữ', '1988-04-10', N'nhung.png', CONVERT(varchar(32), HASHBYTES('MD5', 'hoangnhungqp123'), 2)),
(N'Phạm Văn Hùng', '0976543210', 'phamvanhung@gmail.com', N'90 Nguyễn Văn Cừ, Huế', N'Nam', '1985-12-01', N'hung.png', CONVERT(varchar(32), HASHBYTES('MD5', 'phamvanhungqp123'), 2)),
(N'Trần Thị Phương', '0943214567', 'tranphuong@gmail.com', N'123 Võ Thị Sáu, Cần Thơ', N'Nữ', '1993-07-07', N'phuong.png', CONVERT(varchar(32), HASHBYTES('MD5', 'tranphuongqp123'), 2));
go
