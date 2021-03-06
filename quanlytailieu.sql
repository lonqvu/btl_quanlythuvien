use master
go
drop database QuanLyThuVien
go
Create database QuanLyThuVien
go
use QuanLyThuVien
go

CREATE TABLE [dbo].[TaiLieu](
	[MaTaiLieu] [varchar](10)  primary key NOT NULL,
	[TenTaiLieu] [nvarchar](10) NOT NULL,
)
GO
CREATE TABLE [dbo].[Account_](
	[ID] [varchar](50) NOT NULL primary key,
	[TenTaiKhoan] [varchar](50) NOT NULL,
	[MatKhau] [varchar](50) NULL,
	[HoTen] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[SDT] [int] NULL,
	[VaiTro] [nvarchar](50) NULL,
	[STT] [int] NULL,
)
GO

CREATE TABLE [dbo].[Bao](
	[MaBao] [varchar](10)  primary key NOT NULL,
	[TenBao] [nvarchar](50) NULL,
	[NgayphatHanh] [date] NULL,
	[TenNXB] [nvarchar](50) NULL,
	[SoBan] [int] NULL,
	[MaTaiLieu] [varchar](10) NULL,
	foreign key(MaTaiLieu) references TaiLieu(MaTaiLieu)

)
GO

CREATE TABLE [dbo].[Sach](
	[MaSach] [varchar](10)  primary key NOT NULL,
	[TenSach] [nvarchar](50) NOT NULL,
	[TenTacGia] [nvarchar](50) NOT NULL,
	[SoTrang] [int] NOT NULL,
	[MaTaiLieu] [varchar](10) NULL,
	[SoBan] [int] NULL,
	[TenNXB] [nvarchar](50) NULL,
	foreign key(MaTaiLieu) references TaiLieu(MaTaiLieu)
)
GO



CREATE TABLE [dbo].[Tap_Chi](
	[MaTapChi] [varchar](10) primary key NOT NULL,
	[TenTapChi] [nvarchar](50) NULL,
	[SoPhatHanh] [int] NULL,
	[ThangPhatHanh] [date] NULL,
	[TenNXB] [nvarchar](50) NULL,
	[SoBan] [int] NULL,
	[MaTaiLieu] [varchar](10) NULL,
	foreign key(MaTaiLieu) references TaiLieu(MaTaiLieu)
)
go
INSERT [dbo].[TaiLieu] ([MaTaiLieu], [TenTaiLieu]) VALUES (N'T001', N'Sách')
INSERT [dbo].[TaiLieu] ([MaTaiLieu], [TenTaiLieu]) VALUES (N'T002', N'Tạp Chí')
INSERT [dbo].[TaiLieu] ([MaTaiLieu], [TenTaiLieu]) VALUES (N'T003', N'Báo')

GO
INSERT [dbo].[Account_] ([ID], [TenTaiKhoan], [MatKhau], [HoTen], [NgaySinh], [SDT], [VaiTro], [STT]) VALUES (N'U01', N'long', N'123', N'vũ Xuân Long', CAST(N'2000-10-27' AS Date), 92392933, N'ADMIN', NULL)
INSERT [dbo].[Account_] ([ID], [TenTaiKhoan], [MatKhau], [HoTen], [NgaySinh], [SDT], [VaiTro], [STT]) VALUES (N'U02', N'linh', N'123', N'Vương Thị Linh', CAST(N'2000-10-27' AS Date), 92392933, N'ADMIN', NULL)
INSERT [dbo].[Account_] ([ID], [TenTaiKhoan], [MatKhau], [HoTen], [NgaySinh], [SDT], [VaiTro], [STT]) VALUES (N'U03', N'ylinh', N'123', N'Phạm Yến linh', CAST(N'2000-10-27' AS Date), 92392933, N'MEMBER', NULL)
INSERT [dbo].[Account_] ([ID], [TenTaiKhoan], [MatKhau], [HoTen], [NgaySinh], [SDT], [VaiTro], [STT]) VALUES (N'U04', N'lan', N'123', N'Nguyễn Phương Lan', CAST(N'2000-10-27' AS Date), 92392933, N'ADMIN', NULL)
GO
INSERT [dbo].[Bao] ([MaBao], [TenBao], [NgayphatHanh], [TenNXB], [SoBan], [MaTaiLieu]) VALUES (N'B001', N'Báo lao động', CAST(N'2000-09-02' AS Date), N'Linh', 23, N'T003')
INSERT [dbo].[Bao] ([MaBao], [TenBao], [NgayphatHanh], [TenNXB], [SoBan], [MaTaiLieu]) VALUES (N'B002', N'Báo lao thanh niên', CAST(N'2000-02-09' AS Date), N'Long', 233, N'T003')
INSERT [dbo].[Bao] ([MaBao], [TenBao], [NgayphatHanh], [TenNXB], [SoBan], [MaTaiLieu]) VALUES (N'B003', N'Báo lao Thiếu nhi', CAST(N'2000-02-09' AS Date), N'Linh', 88, N'T003')
INSERT [dbo].[Bao] ([MaBao], [TenBao], [NgayphatHanh], [TenNXB], [SoBan], [MaTaiLieu]) VALUES (N'B004', N'Báo Du Lịch', CAST(N'2021-05-18' AS Date), N'DLVN', 23, N'T003')
INSERT [dbo].[Bao] ([MaBao], [TenBao], [NgayphatHanh], [TenNXB], [SoBan], [MaTaiLieu]) VALUES (N'B005', N'Báo lịch sử', CAST(N'2021-05-27' AS Date), N'Báo Việt', 1, N'T003')
GO
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TenTacGia], [SoTrang], [MaTaiLieu], [SoBan], [TenNXB]) VALUES (N'S001', N'Những món ăn ngon', N'Vũ Xuân Long', 239, N'T001', 606, N'Hãng film Phuong Nam')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TenTacGia], [SoTrang], [MaTaiLieu], [SoBan], [TenNXB]) VALUES (N'S002', N'Gia đình hạnh phúc', N'Vương Thị Linh', 390, N'T001', 60, N'Hãng film Phương Nam')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TenTacGia], [SoTrang], [MaTaiLieu], [SoBan], [TenNXB]) VALUES (N'S003', N'Doremon', N'Siêu nhân xanh', 300, N'T001', 299, N'Kim Đồng')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TenTacGia], [SoTrang], [MaTaiLieu], [SoBan], [TenNXB]) VALUES (N'S004', N'Lập trình Java', N'Hà Mạnh Đào', 300, N'T001', 299, N'HaUI')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TenTacGia], [SoTrang], [MaTaiLieu], [SoBan], [TenNXB]) VALUES (N'S005', N'Lập trình Android', N'Hà Mạnh Đào', 3002, N'T001', 299, N'HaUI')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TenTacGia], [SoTrang], [MaTaiLieu], [SoBan], [TenNXB]) VALUES (N'S006', N'Biệt đội siêu nhân', N'Phạm Yến Linh', 3903, N'T001', 60, N'Hãng film Phương Nam')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TenTacGia], [SoTrang], [MaTaiLieu], [SoBan], [TenNXB]) VALUES (N'S007', N'Nấu ăn ngon', N'Phạm Yến Linh', 3903, N'T001', 220, N'Nhà sách Trí Tuệ')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [TenTacGia], [SoTrang], [MaTaiLieu], [SoBan], [TenNXB]) VALUES (N'S008', N'Sách giáo khoa', N'Vũ Xuân Linh', 2000, N'T001', 120, N'Sở giáo dục')
GO

INSERT [dbo].[Tap_Chi] ([MaTapChi], [TenTapChi], [SoPhatHanh], [ThangPhatHanh], [TenNXB], [SoBan], [MaTaiLieu]) VALUES (N'H001', N'Tạp chí thời trang', 222, CAST(N'2021-10-30' AS Date), N'Long', 2, N'T002')
INSERT [dbo].[Tap_Chi] ([MaTapChi], [TenTapChi], [SoPhatHanh], [ThangPhatHanh], [TenNXB], [SoBan], [MaTaiLieu]) VALUES (N'H002', N'Tạp chí thiếu nhi', 100, CAST(N'2021-10-13' AS Date), N'Kim đồng', 200, N'T002')
INSERT [dbo].[Tap_Chi] ([MaTapChi], [TenTapChi], [SoPhatHanh], [ThangPhatHanh], [TenNXB], [SoBan], [MaTaiLieu]) VALUES (N'H003', N'Tạp chí gia đình', 220, CAST(N'2016-10-20' AS Date), N'Kim đồng', 201, N'T002')
INSERT [dbo].[Tap_Chi] ([MaTapChi], [TenTapChi], [SoPhatHanh], [ThangPhatHanh], [TenNXB], [SoBan], [MaTaiLieu]) VALUES (N'H004', N'Tạp chí thế giới', 288, CAST(N'2016-10-20' AS Date), N'Linh', 202, N'T002')
INSERT [dbo].[Tap_Chi] ([MaTapChi], [TenTapChi], [SoPhatHanh], [ThangPhatHanh], [TenNXB], [SoBan], [MaTaiLieu]) VALUES (N'H005', N'Tạp chí Việt Nam', 1258, CAST(N'2016-10-20' AS Date), N'Linh', 48, N'T002')
INSERT [dbo].[Tap_Chi] ([MaTapChi], [TenTapChi], [SoPhatHanh], [ThangPhatHanh], [TenNXB], [SoBan], [MaTaiLieu]) VALUES (N'H006', N'Tạp chí du lịch', 267, CAST(N'2016-10-20' AS Date), N'DLVN', 23, N'T002')
GO

ALTER TABLE [dbo].[Account_] ADD  CONSTRAINT [unique_TenTaiKhoan] UNIQUE NONCLUSTERED 
(
	[TenTaiKhoan] ASC
)
ALTER TABLE [dbo].[TaiLieu]  WITH CHECK ADD CHECK  (([TenTaiLieu]=N'Sách' OR [TenTaiLieu]=N'Tạp chí' OR [TenTaiLieu]=N'Báo'))
GO

