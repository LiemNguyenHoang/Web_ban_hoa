USE [BANHOA]
GO
/****** Object:  Table [dbo].[ChiTietDonHang]    Script Date: 11/26/2019 10:04:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDonHang](
	[id_chi_tiet_don_hang] [int] IDENTITY(1,1) NOT NULL,
	[id_don_hang] [int] NOT NULL,
	[so_luong_sp] [int] NULL,
	[gia] [int] NULL,
	[id_san_pham] [int] NULL,
 CONSTRAINT [PK_DonHang_SanPham] PRIMARY KEY CLUSTERED 
(
	[id_chi_tiet_don_hang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 11/26/2019 10:04:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[id_don_hang] [int] IDENTITY(1,1) NOT NULL,
	[ten_dang_nhap] [nchar](30) NULL,
	[tinh_trang] [bit] NULL,
	[ngay_mua] [nvarchar](50) NULL,
	[ten_nguoi_mua] [nvarchar](50) NULL,
	[sdt] [nchar](15) NULL,
	[dia_chi] [nvarchar](100) NULL,
	[ghi_chu] [nvarchar](1000) NULL,
 CONSTRAINT [PK_DonHang] PRIMARY KEY CLUSTERED 
(
	[id_don_hang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 11/26/2019 10:04:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[id_loai_sp] [int] IDENTITY(1,1) NOT NULL,
	[ten_loai_sp] [nvarchar](50) NULL,
 CONSTRAINT [PK_LoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[id_loai_sp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/26/2019 10:04:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[id_sp] [int] IDENTITY(1,1) NOT NULL,
	[id_loai_sp] [int] NOT NULL,
	[id_chi_tiet_don_hang] [int] NULL,
	[ten_sp] [nvarchar](50) NULL,
	[gia] [int] NULL,
	[hinh_anh] [nchar](100) NULL,
	[mo_ta] [nvarchar](500) NULL,
 CONSTRAINT [PK_SanPham_1] PRIMARY KEY CLUSTERED 
(
	[id_sp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserP]    Script Date: 11/26/2019 10:04:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserP](
	[ten_dang_nhap] [nchar](30) NOT NULL,
	[mat_khau] [nchar](30) NOT NULL,
	[ho_ten] [nvarchar](50) NULL,
	[hinh_anh] [nchar](500) NULL,
	[dia_chi] [nvarchar](200) NULL,
	[email] [nchar](50) NULL,
	[sdt] [nchar](15) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[ten_dang_nhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[ChiTietDonHang] ON 

INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (18, 27, 1, 1400000, 1)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (19, 28, 1, 1400000, 48)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (20, 28, 8, 1500000, 3)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (21, 28, 6, 550000, 3)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (29, 49, 1, 1500000, 1)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (30, 49, 3, 1650000, 3)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (31, 49, 1, 123, 48)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (32, 50, 1, 23, 43)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (33, 50, 1, 1400000, 4)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (34, 50, 1, 550000, 3)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (35, 51, 1, 550000, 3)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (36, 51, 2, 2800000, 4)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (37, 64, 1, 23, 43)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (38, 64, 1, 1400000, 4)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (39, 72, 1, 23, 43)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (40, 73, 1, 1500000, 1)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (41, 73, 1, 550000, 3)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (42, 73, 1, 1400000, 4)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (43, 74, 1, 1400000, 4)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (44, 75, 1, 23, 43)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (50, 81, 1, 1400000, 4)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (51, 82, 1, 23, 43)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (52, 83, 2, 2800000, 4)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (53, 83, 1, 23, 43)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (54, 84, 1, 1234645123, 51)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (55, 85, 1, 123, 48)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (56, 86, 4, 3680000, 96)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (57, 87, 1, 940000, 95)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (58, 88, 1, 400000, 98)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (59, 89, 3, 2010000, 93)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (60, 89, 1, 650000, 94)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (61, 90, 4, 3760000, 95)
INSERT [dbo].[ChiTietDonHang] ([id_chi_tiet_don_hang], [id_don_hang], [so_luong_sp], [gia], [id_san_pham]) VALUES (62, 91, 4, 3760000, 95)
SET IDENTITY_INSERT [dbo].[ChiTietDonHang] OFF
SET IDENTITY_INSERT [dbo].[DonHang] ON 

INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (27, NULL, 1, N'2019-11-12', N'', N'               ', N'', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (28, NULL, 1, N'2019-11-12', N'', N'               ', N'', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (32, N'hoang_ky                      ', 1, N'2019/11/15 17:28:17', N'hòng kỳ', N'2123           ', N'sfsdt', N'453')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (33, N'hoang_ky                      ', 1, N'2019/11/15 17:30:09', N'hoàng k', N'123re          ', N'5gdf', N'34534')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (34, N'tran_ky                       ', 1, N'2019/11/15 18:26:38', N'Trần Kỳ ___', N'123234         ', N'gfgteryerty', N'45634 rtyn')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (35, N'trong_binh                    ', 1, N'2019/11/15 20:08:38', N'trọng bình', N'2131           ', N'qwee', N'asdw23')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (38, N'trong_binh                    ', 0, N'2019/11/15 20:12:53', N'', N'               ', N'', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (45, N'trong_binh                    ', 0, N'2019/11/15 20:38:49', N'', N'               ', N'', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (46, N'trong_binh                    ', 0, N'2019/11/15 20:39:56', N'', N'               ', N'', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (49, N'ddd                           ', 1, N'2019/11/16 18:33:34', N'Chính d', N'12             ', N'wqe', N'sdfsdf')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (50, N'zzz                           ', 1, N'2019/11/17 13:11:23', N'Z or Z', N'12345          ', N'dsad', N'we213')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (51, N'zzz                           ', 0, N'2019/11/17 13:14:58', N'', N'               ', N'', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (64, N'ddd                           ', 0, N'2019/11/17 17:34:36', N'', N'               ', N'', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (72, N'noname                        ', 0, N'2019/11/17 17:47:12', N'', N'               ', N'', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (73, N'noname                        ', 0, N'2019/11/17 17:47:37', N'', N'               ', N'', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (74, N'noname                        ', 0, N'2019/11/17 17:49:08', N'không tẹn', N'123            ', N'dasd', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (75, N'noname                        ', 0, N'2019/11/17 17:51:52', N's', N'er             ', N'tre', N'gd')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (81, N'noname                        ', 0, N'2019/11/17 19:45:55', N'hads', N'123            ', N'adsdwq', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (82, N'noname                        ', 0, N'2019/11/17 20:08:47', N'Nguyễn Hoàng', N'123            ', N'asdDNDa asldasd', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (83, N'ddd                           ', 0, N'2019/11/17 20:15:00', N'a', N'121            ', N'Adsds', N'dada')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (84, N'noname                        ', 0, N'2019/11/24 20:35:57', N'dsa', N'21             ', N'wqasda', N'dqwe')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (85, N'noname                        ', 0, N'2019/11/24 20:45:12', N'Liem Hoàng', N'123            ', N'asd À', N'sa')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (86, N'noname                        ', 0, N'2019/11/25 19:54:50', N'Nguyễn Văn', N'0123456789     ', N'qw', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (87, N'noname                        ', 0, N'2019/11/25 20:00:33', N'', N'               ', N'qwasd', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (88, N'noname                        ', 0, N'2019/11/25 20:09:01', N'Nguyễn Hoàng', N'12345          ', N'Quận 9, Sài Thành', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (89, N'noname                        ', 0, N'2019/11/25 22:01:55', N'Nguyễn Hoàng', N'0123456789     ', N'Quận 9, HCM', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (90, N'noname                        ', 0, N'2019/11/26 09:43:53', N'NGuy', N'123            ', N'A', N'')
INSERT [dbo].[DonHang] ([id_don_hang], [ten_dang_nhap], [tinh_trang], [ngay_mua], [ten_nguoi_mua], [sdt], [dia_chi], [ghi_chu]) VALUES (91, N'noname                        ', 0, N'2019/11/26 09:46:09', N'Ng', N'23             ', N'sadad', N'')
SET IDENTITY_INSERT [dbo].[DonHang] OFF
SET IDENTITY_INSERT [dbo].[LoaiSanPham] ON 

INSERT [dbo].[LoaiSanPham] ([id_loai_sp], [ten_loai_sp]) VALUES (1, N'Hoa sinh nhật')
INSERT [dbo].[LoaiSanPham] ([id_loai_sp], [ten_loai_sp]) VALUES (2, N'Hoa chúc mừng')
INSERT [dbo].[LoaiSanPham] ([id_loai_sp], [ten_loai_sp]) VALUES (3, N'Hoa chia buồn')
INSERT [dbo].[LoaiSanPham] ([id_loai_sp], [ten_loai_sp]) VALUES (4, N'Hoa sự kiện ')
INSERT [dbo].[LoaiSanPham] ([id_loai_sp], [ten_loai_sp]) VALUES (5, N'Hoa tình yêu')
INSERT [dbo].[LoaiSanPham] ([id_loai_sp], [ten_loai_sp]) VALUES (6, N'Lan Hồ Điệp')
SET IDENTITY_INSERT [dbo].[LoaiSanPham] OFF
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (1, 4, NULL, N'Khai trương hồng phát', 2500000, N'sp_1.jpg                                                                                            ', N'Kệ hoa Khai trương Hồng phát 
là sự kết hợp giữa những đóa hồng môn đỏ, lan mokara vàng và đỏ hòa quyện cùng hương 
thơm ngát của những nhánh hoa ly vàng mang đến sự may mắn và thành công cho người nhận.')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (3, 5, NULL, N'Thơ ngây', 550000, N'sp_3.jpg                                                                                            ', N'Giỏ hoa Thơ ngây là thiết kế dành cho những cô nàng 
có phong cách hiện đại và thơ ngây. Mẫu hoa với sự kết hợp của hồng đỏ rực rỡ, hồng da tươi 
thắm hòa quyện cùng màu vàng tươi mới của lan vũ nữ.')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (4, 5, NULL, N'Kẻ mộng mơ', 14000, N'sp_4.jpg                                                                                            ', N'Hộp hoa Kẻ mộng mơ HSG250 chính là món quà tuyệt 
diệu với sự kết hợp của 56 đóa hoa hồng trắng tinh khôi và bông hồng xanh phun sơn dịu dàng. 
Bó hoa của những màu sắc dịu dàng đặc biệt cuốn hút làm say đắm lòng người.')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (43, 2, NULL, N'sayaaa', 23, N'sdad.jpg                                                                                            ', N'eqweqw')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (48, 1, NULL, N'rwea', 123, N'sdad.jpg                                                                                            ', N'7iyuhkdasdas')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (49, 1, NULL, N'sdadqe', 2341, N'index.jpg                                                                                           ', N'esdfsdf')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (50, 1, NULL, N'adas', 1231, N'sdad.jpg                                                                                            ', N'dasd')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (51, 1, NULL, N'ttALOKDtt', 1234645123, N'imageds.jpg                                                                                         ', N'daaASD@ertert')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (52, 1, NULL, N'ASDQWE', 2213, N'infdsfdex.jpg                                                                                       ', N'werwer')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (53, 1, NULL, N'DDDDDD', 1231, N'sdad.jpg                                                                                            ', N'dqwe')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (54, 1, NULL, N'Thời gian', 920000, N'orchid06-600x600.jpg                                                                                ', N'Với tông chủ đạo là màu tím từ hoa lan Hồ Điệp quý phái và phần đệm tông là sắc hồng dịu dàng từ hồng dâu, lẵng hoa này sẽ là món quà chúc mừng đầy ý nghĩa toát lên nét đẹp mặn mà không phai mờ cùng thời gian gửi gắm những lời chúc chân thành và da diết nhất khiến bất cứ ai nào cũng phải trầm trồ và rung động')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (55, 6, NULL, N'Hoa Lan chúc mừng', 1500000, N'orchid02-600x600.jpg                                                                                ', N'Mang nét đẹp của sự sang trọng, kiều diễm, hoa lan luôn là món quà chúc mừng thích hợp để gửi tặng đến cấp trên, đối tác hay đấng sinh thành của mình. Còn chần chừ gì mà không đặt ngay chậu lan quý phái, lộng lẫy này để gửi gắm lời chúc tốt đẹp và chân thành nhất đến người bạn quan tâm. Nó có thể giúp bạn ghi điểm lớn trong mắt đối phương đấy')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (56, 6, NULL, N'Phồn Vinh', 1400000, N'orchid03-600x600.jpg                                                                                ', N'Sắc vàng của sự thịnh vương và phồn vinh sẽ đem lại đến may mắn cho gia chủ cả về tiền tài lẫn sức khỏe. Không còn gì thích hợp hơn chậu hoa lan hồ điệp vàng này để làm quà tặng chúc phúc cho những người mà bạn luôn quan tâm và kính trọng vạn sự như ý')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (57, 6, NULL, N'Ánh dương', 2000000, N'orchid04-600x600.jpg                                                                                ', N'Rực rỡ và lộng lẫy như ánh dương quang, lan Hồ Điệp vàng sẽ là linh vật may mắn đem lại sự thịnh vượng và phồn vinh cho người nhận. Cùng với con số 7 may mắn, chậu hoa không chỉ trở nên hoành tráng mà còn như khiến vận may trở nên bội phần hơn')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (58, 1, NULL, N'Hồn nhiên', 360000, N'carnation_15.jpg                                                                                    ', N'Sự chuyển biến trong sắc hồng của cẩm chướng khiến cho bó hoa thêm nét nữ tính, dịu dàng và đáng yêu. Hãy để đối phương biết được sự quan tâm, chu đáo mà bạn luôn dành cho họ. Hãy để họ biết bạn thương họ biết nhường nào. Với thông điệp mà bạn muốn nhắn gửi đằng sau bó hoa này, tin rằng người ấy sẽ cảm động thôi')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (59, 1, NULL, N'Kính thương', 370000, N'sunflower_10.jpg                                                                                    ', N'Tặng gì cho người lớn nhân ngày sinh nhật nhỉ? Không cần phải băn khoăn nữa đâu khi bó hoa này chính là món quà thích hợp nhất rồi. Không mang nét lãng mạn, lộng lẫy của hoa hồng, cũng không mang nét đằm thắm mặn mà và có mùi hương có thể gây dị ứng với một số người như hoa ly, hoa hướng dương lại mang một nét đẹp rất riêng và đặc biết ẩn chứa nhiều lời chúc tốt đẹp mà chúng ta luôn muốn gửi gắm đến người ấy. Hãy gửi đến người quan trọng trong cuộc sống của bạn một món quà tuyệt vời nhất nhé')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (60, 1, NULL, N'Ân Tình', 380000, N'carnation_5.jpg                                                                                     ', N'Một lẵng hoa xinh xắn cùng cẩm chướng hồng, bi trắng và hồng pastel sẽ khiến cho ngày quan trọng của người mẹ kính yêu của bạn thêm muôn phần đáng nhớ với hương sắc của hoa và những kỷ niệm tươi đẹp. Hãy để người được tận hưởng ngày của mình thật trọn vẹn và đầy cảm xúc nhé')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (61, 1, NULL, N'Sức Sống', 380000, N'carnation_8.jpg                                                                                     ', N'Đáng yêu và tràn đầy sức sống như những đóa cẩm chướng hồng, bó hoa này sẽ là một món quà thích hợp dành tặng cho người bạn quan tâm và yêu thương nhất. Một bó hoa gửi gắm lời chúc tốt đẹp nhất và khiến họ nhớ đến quãng thời gian thanh xuân tươi đẹp và thật đáng nhớ của mình')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (62, 1, NULL, N'Nơi Bắt Đầu', 380000, N'sunflower_17.jpg                                                                                    ', N'Với ý nghĩa " Hãy cùng nhau tỏa sáng", bó hoa 5 bông hướng dương xinh xắn sẽ giúp bạn cổ vũ tinh thần của những đứa bạn thân thương của mình. Đôi khi không thể lúc nào cũng có mặt vì nhau, giúp đỡ lẫn nhau trong cuộc sống nhưng lúc nào cũng sẽ nghĩ về nhau, quan tâm nhau và sẵn sàng giúp đỡ lẫn nhau. Một bó hoa để bày tỏ tình cảm khó nói mà giữa những người bạn không thể nào thổ lộ hết được')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (63, 1, NULL, N'Lời Cảm Ơn', 390000, N'carnation_11.jpg                                                                                    ', N'Một bó hoa chứa đựng những điều dễ thương nhất, những bông hoa cẩm chướng xúng xính khoe sắc cùng baby trắng tinh khôi đáng yêu khiến cho bó hoa trở thành một món quà không thể thiếu trong bất kỳ dịp lễ sinh nhật nào. Thích hợp với mọi đối tượng ở mọi độ tuổi, bó hoa này sẽ góp phần nhân đôi niềm vui và nét rực rỡ trên gương mặt người ấy đấy')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (64, 1, NULL, N'Khởi Đầu', 400000, N'sunflower_4.jpg                                                                                     ', N'Không lộng lẫy như hoa hồng, không sang chảnh như tulip nhưng hoa hướng dương luôn mang một nét đẹp mộc mạc và đầy chân thành, nhiệt huyết. Một bó hoa hướng dương 11 bông sẽ giúp bạn bày tỏ được tình cảm sâu sắc của mình với ý nghĩa "Anh sẽ luôn hướng về em, em là tình yêu nhỏ bé của anh"

')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (65, 1, NULL, N'Tự Tin', 400000, N'arrangement_44-500x500.jpg                                                                          ', N'Đỏ rực như son môi đầy huyền bí và quyến rũ của người phụ nữ, một lẵng hoa hồng đỏ với hoa lá phụ xinh xắn sẽ là một món quà đáng yêu cho một người phụ nữ trưởng thành, tự tin và giỏi giang. Còn chần chờ gì mà không đặt ngay lẵng hoa này để tặng người con gái đầy tôn kính và xinh đẹp ấy')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (66, 1, NULL, N'Sang Trọng', 415000, N'carnation_13.jpg                                                                                    ', N'Sang trọng nhưng không kém phần dễ thương, một bó hoa cẩm chướng hồng cùng hồng trắng và bi trắng sẽ khiến cho ngày quan trọng của đối phương thêm phần ngọt ngào. Đây sẽ là một món quà bất ngờ đầy thú vị và đáng yêu mà không một ai nỡ chối từ và ngừng ngắm nhìn.')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (67, 2, NULL, N'Tinh khôi', 550000, N'lotus04.jpg                                                                                         ', N'Cánh Sen lấy cảm hứng từ sắc sen trắng yêu kiều e thẹn nhưng không kém phần kiêu kì cao quý. Bó hoa chắc chắn sẽ là một điểm nhấn cho một góc nhà, hay văn phòng của bạn, lá nét chấm phá tươi mới cho một ngày xanh mướt.')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (68, 2, NULL, N'Ước Mơ', 580000, N'gebe10.jpg                                                                                          ', N'Ngập tràn ánh đỏ của sự thành công và huy hoàng, một lẵng hoa chúc lý tưởng dành tặng cho đối tác quan trọng, bạn bè hay người thân của bạn. Hãy để ngày vui của họ càng thêm nhiều niềm vui và để họ biết được bạn quan tâm cũng như mong mọi điều tốt đẹp đều đến bên họ biết nhường nào')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (69, 1, NULL, N'Tinh Khiết', 600000, N'lotus07.jpg                                                                                         ', N'Từ lâu hoa sen với vẻ đẹp thanh tao dịu dàng của nó đã được mệnh danh là quốc hoa của Việt Nam. Lẵng sen Tinh Khiết với cảm hứng từ hoa sen là một món quà thích hợp dành tặng cho mẹ, cho chị, bạn bè hay đồng nghiệp của bạn trong bất kì dịp nào.')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (70, 2, NULL, N'Chu Đáo', 620000, N'arrangement_54.jpg                                                                                  ', N'Sắc vàng rực rỡ như nắng đầu hạ được kết tinh trong lẵng hoa dưới bàn tay đầy nghệ thuật của thợ hoa chuyên nghiệp lan tỏa mọi cảm xúc tích cực và cổ vũ tinh thần của người nhận. Một lẵng hoa nho nhỏ nhưng lại là "linh vật" đáng yêu giúp đối phương cảm nhận được tấm lòng cùng sự chu đáo của bạn')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (71, 2, NULL, N'Ngày Tươi Vui', 650000, N'arrangement_36.jpg                                                                                  ', N'Một lẵng hoa xinh đẹp có thể vực dậy mọi tâm trạng ủ ê, có thể cỗ vũ mọi tinh thần chán chường. Hãy gửi tặng lẵng hoa này đến người mà bạn quan tâm, yêu thương nhất để họ biết rằng họ không một mình và cỗ vũ họ qua khoảng thời gian đầy mệt mỏi, khó khăn này trong cuộc sống nhé')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (72, 2, NULL, N'Ngày Mới', 670000, N'arrangement_31.jpg                                                                                  ', N'Một lẵng hoa đầy xuân sắc như thổi một làn gió mới vào cuộc sống đầy tẻ nhạt. Hãy biến một ngày của người mà bạn luôn quan tâm thêm mới mẻ và thú vị hơn, hãy xua đi sự uể oải, buồn chán bằng lẵng hoa tươi thắm này nhé')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (73, 2, NULL, N'Lời Chúc Tốt Đẹp', 88000, N'arrangement_21.jpg                                                                                  ', N'Sắc xanh, vàng đi cùng với nhau luôn tạo ra một nguồn cảm hứng vô tận, một nguồn năng lượng dồi dào. Cũng chính vì thế mà giỏ hoa này đã ra đời như một lời chúc tốt đẹp nhất đến người nhận. Hãy để lại ấn tượng tốt với cấp trên, đồng nghiệp hay những người mà bạn yêu thương bằng cách tặng họ giỏ hoa này nhé

')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (74, 2, NULL, N'Kỉ Niệm Đẹp', 890000, N'arrangement_40.jpg                                                                                  ', N'Một lẵng hoa ngọt ngào như chiếc kẹo ngọt ta được cho ăn thời bé sẽ là một món quà đầy ý nghĩa và chu đáo mà bạn dành tặng cho đối phương đấy. Ký ức là những gì mà ai ai cũng trân quý và muốn lưu giữ nhất. Hãy khiến mỗi khoảng khắc trọng đại của đối phương đều thật đáng nhớ với sự góp sức và góp mặt của lẵng hoa đáng yêu này nhé

')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (75, 2, NULL, N'Ngày Ngọt Ngào', 1100000, N'arrangement_13.jpg                                                                                  ', N'Nếu ngọt ngào là nét ấn tượng đầu tiên mà bạn cảm thấy ở đối phương vậy lẵng hoa này ắt hẳn chính là món quà lý tưởng bạn nên dành tặng cho người ấy nhân dịp sinh nhật hay trong ngày trọng đại của người ấy')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (76, 2, NULL, N'Xuân Sang', 700000, N'gebe7.jpg                                                                                           ', N'Rực rỡ, đáng yêu nhưng không hề chói lòa gâu cảm giác khó chịu chính là lẵng hoa đồng tiền tinh khôi này đây. Hãy dành tặng chúng cho những người mà bạn yêu quý và quan tâm. Hãy ghi thật nhiều điểm tốt của mình trong mắt đối phương nhé')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (77, 3, NULL, N'Hoa Chia Buồn Phân Ưu', 620000, N'condo08.jpg                                                                                         ', N'Một chiếc vòng tang truyền thống với những cành lan trắng tím kết hợp với hồ điệp trang trọng sẽ là lời phân ưu thành kính nhất dành cho gia đình của người đáng kính')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (78, 3, NULL, N'Hoa Chia Buồn An Yên', 650000, N'condo17.jpg                                                                                         ', N'Giờ phút chia ly là chuyện không thể tránh được, kiếp người nào rồi cũng kết thúc, dẫu biết thế, nhưng mỗi lần mất đi người thân yêu đều để lại trong lòng người ở lại một nỗi đau khó vơi. Trong những giai đoạn này, một lời an ủi, sẻ chia dù nhỏ nhất, như một vòng hoa chia buồn, cũng sẽ mang một ý nghĩa to lớn.

')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (79, 3, NULL, N'Hoa Chia Buồn Niệm Khúc Cuối', 650000, N'condo05.jpg                                                                                         ', N'Mọi sự bắt đầu ắt hẳn sẽ có điểm kết thúc tiếp nối. Đời người cũng như thế. Vòng hoa truyền thống với cúc trắng và hoa ly như cất lên khúc nhạc niệm cuối cùng, tiễn đưa người đến nơi thanh thản, vô ưu.')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (80, 3, NULL, N'Hoa Chia Buồn Thiên Thu', 700000, N'condo04.jpg                                                                                         ', N'Kệ hoa Thiên Thu với vô số cành lan trắng tinh khiết lan tỏa như một khởi điểm mới ở cõi xa dành cho người vừa khuất. Kính tặng kệ này để gửi lời chia buồn cùng những người thân của họ, va cũng gửi lời chúc phúc để họ tiếp tục bước đến nơi tốt đẹp hơn')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (81, 3, NULL, N'Hoa Chia Buồn Dĩ Vãng', 900000, N'condo19.jpg                                                                                         ', N'Giây phút chia lìa hẳn cần lắm một lời động viên, an ủi chân thành nhất từ những người quan trọng.Kệ hoa tạo nên từ tú cầu và lan với dáng tròn truyền thống chắc chắn sẽ thay bạn gửi đi những lời động viên ấy đấy.')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (82, 5, NULL, N'Món Qùa Chúc Mừng', 710000, N'arrangement_5.jpg                                                                                   ', N'Sự pha trộn hài hoa giữa hương sắc nơi thời điểm giao mùa từ xuân sang hè đều đã hội tụ nơi đây, ngay trong lẵng hoa lộng lẫy này. Ai có thể nỡ từ chối một món quà chúc mừng xinh đẹp như một khu vườn nhỏ nhắn xinh xắn này được nhỉ')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (83, 5, NULL, N'Món Qùa Chúc Mừng', 710000, N'arrangement_5.jpg                                                                                   ', N'Sự pha trộn hài hoa giữa hương sắc nơi thời điểm giao mùa từ xuân sang hè đều đã hội tụ nơi đây, ngay trong lẵng hoa lộng lẫy này. Ai có thể nỡ từ chối một món quà chúc mừng xinh đẹp như một khu vườn nhỏ nhắn xinh xắn này được nhỉ')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (84, 5, NULL, N'Tỏ Tình', 620000, N'arrangement_50.jpg                                                                                  ', N'Một lẵng hoa tình yêu với hồng đỏ là tâm điểm cùng baby trắng là hoa phụ giúp bật tông sẽ khiến người ấy rung động và biết đâu lời tỏ tình mà bạn hằng ấp ủ sẽ chạm đến được trái tim của người ấy. Hoa hồng đỏ được biết đến là nữ hoàng của các loài hoa. Với lời chúc phúc của loài hoa này tin chắc tỷ lệ thành công sẽ rất cao')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (85, 5, NULL, N'Chu Đáo', 620000, N'arrangement_54 (1).jpg                                                                              ', N'Sắc vàng rực rỡ như nắng đầu hạ được kết tinh trong lẵng hoa dưới bàn tay đầy nghệ thuật của thợ hoa chuyên nghiệp lan tỏa mọi cảm xúc tích cực và cổ vũ tinh thần của người nhận. Một lẵng hoa nho nhỏ nhưng lại là "linh vật" đáng yêu giúp đối phương cảm nhận được tấm lòng cùng sự chu đáo của bạn

')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (86, 5, NULL, N'Tươi Đẹp', 600000, N'arrangement_41.jpg                                                                                  ', N'Đáng yêu như đôi má hồng hây hây mỗi khi ai đó thẹn thùng. Giỏ hoa này sẽ là một món quà dễ thương chất chứa đầy tâm ý cũng như tình cảm của bạn dành cho người ấy của mình. Một giỏ hoa thích hợp cho nhiều sự kiện như sinh nhật của nàng, lễ kỷ niệm yêu nhau của 2 người hay lễ tình nhân mỗi năm chỉ có 1 lần,...

')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (87, 5, NULL, N'Bình Yên', 550000, N'arrangement_46.jpg                                                                                  ', N'Như một cánh đồng hoa hướng dương thu nhỏ, sắc trắng, xanh của hoa lá phụ đan xen cùng sắc vàng tươi của hoa hướng dương biến lẵng hoa thành một món quà rực rỡ và đáng yêu dành tặng cho đồng nghiệp, bạn bè, người yêu hay người thân của bạn

')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (88, 5, NULL, N'Xinh tươi', 500000, N'roses20_13.jpg                                                                                      ', N'Mẫu hoa thiết kế này với 20 đóa hoa hồng trắng tinh khôi lãng mạn như được tạo ra là để minh chứng cho khoảnh khắc hai người bên nhau, như là để thay lời yêu thương mà bạn mong muốn truyền tải đến người thân, bạn bè của mình.')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (89, 5, NULL, N'Ấm Áp', 520000, N'roses20_60.jpg                                                                                      ', N'"Sống chậm lại và yêu thương nhiều hơn", một thông điệp dễ thương mà nhiều khi chúng ta vì những bộn bề khó khăn mà quên mất. Hãy dừng lại một chút và gửi đi những yêu thương với bó hoa hồng đỏ đầy ngọt ngào này bạn nhé.')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (90, 5, NULL, N'Tự Tin', 400000, N'arrangement_44-500x500 (1).jpg                                                                      ', N'Đỏ rực như son môi đầy huyền bí và quyến rũ của người phụ nữ, một lẵng hoa hồng đỏ với hoa lá phụ xinh xắn sẽ là một món quà đáng yêu cho một người phụ nữ trưởng thành, tự tin và giỏi giang. Còn chần chờ gì mà không đặt ngay lẵng hoa này để tặng người con gái đầy tôn kính và xinh đẹp ấy')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (91, 5, NULL, N'Khởi Đầu', 400000, N'sunflower_4 (1).jpg                                                                                 ', N'Không lộng lẫy như hoa hồng, không sang chảnh như tulip nhưng hoa hướng dương luôn mang một nét đẹp mộc mạc và đầy chân thành, nhiệt huyết. Một bó hoa hướng dương 11 bông sẽ giúp bạn bày tỏ được tình cảm sâu sắc của mình với ý nghĩa "Anh sẽ luôn hướng về em, em là tình yêu nhỏ bé của anh"')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (92, 5, NULL, N'Qúy Phái', 400000, N'arrangement_18.jpg                                                                                  ', N'Một hộp hoa tối giản, nhỏ nhắn nhưng không kém phần sang trọng, quý phái sẽ là một món quà đặc biệt để tặng nàng nhân dịp sinh nhật cũng như ghi điểm trong mắt nàng. Một mũi tên trúng 2 con chim. Một hộp hoa nhỏ mà có võ. Sao còn không nhanh tay bỏ chiếc hộp hoa này vào giỏ hàng của bạn!?')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (93, 4, NULL, N'Ngày Mới', 670000, N'arrangement_31 (1).jpg                                                                              ', N'Một lẵng hoa đầy xuân sắc như thổi một làn gió mới vào cuộc sống đầy tẻ nhạt. Hãy biến một ngày của người mà bạn luôn quan tâm thêm mới mẻ và thú vị hơn, hãy xua đi sự uể oải, buồn chán bằng lẵng hoa tươi thắm này nhé')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (94, 4, NULL, N'Tinh Hoa', 650000, N'lotus06.jpg                                                                                         ', N'Tinh Hoa đượckết hợp giữa những bông hoa sen và hoa hồng pastel cùng những loại hoa nhỏ khác khiến người ta không thể ngừng ngắm nhìn nét mộc mạc chân phương nhưng đầy cao quý của sen- loài hoa được mệnh danh là Quốc hoa của Việt nam. Sen sẽ luôn là món quà tuyệt vời cho bất kì ai yêu quý nét đẹp mộc mạc nhưng thanh cao của nó.')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (95, 4, NULL, N'Điều Ước', 940000, N'arrangement_52.jpg                                                                                  ', N'Ngập tràn hương sắc mùa xuân, một lẵng hoa chứa đựng sự kết hợp hài hòa giữa sắc hồng từ hoa hồng xinh đẹp với sắc trắng từ những hoa lá phụ khiến lẵng hoa rực rỡ và tràn đầy sức sống hơn bao giờ hết. Đây sẽ là một món quà tuyệt vời để dành tặng bất cứ ai bất cứ dịp đặc biệt nàơ')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (96, 4, NULL, N'Sắc Hoa', 920000, N'arrangement_43.jpg                                                                                  ', N'Sự đan xen trong màu sắc giữa đỏ, xanh và trắng của các loài hoa khiến lẵng hoa nổi bật và lộng lẫy giữa vô vàn những lẵng hoa khác. Một lẵng hoa không thể không ngắm nhìn này xứng đáng là lựa chọn ưu tiên để làm món quà mà bạn muốn dành cho người quan trọng của mình')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (97, 6, NULL, N'Trang Trọng', 760000, N'orchid10.jpg                                                                                        ', N'Bình hoa nhẹ nhàng và tinh tế tạo nên từ những cánh lan sang trọng chắc chắn sẽ là một món quà ý nghĩa cho những dịp quan trọng nhất. Bình hoa có thể được tặng trong những kịp kỉ niệm, sinh nhật, hay khai trương chúc mừng')
INSERT [dbo].[SanPham] ([id_sp], [id_loai_sp], [id_chi_tiet_don_hang], [ten_sp], [gia], [hinh_anh], [mo_ta]) VALUES (98, 1, NULL, N'Lời Cảm Ơn', 400000, N'orchid01.jpg                                                                                        ', N'Thuộc phong cách đơn giản nhưng vẫn giữ được nét đẹp trang trọng và quý phái, với chậu hoa một nhành lan tím này bạn đã có thể truyền đạt và gửi gắm đến người nhận được hết những lời hỏi thăm đầy tâm tình cùng với tấm lòng chân thành của mình .')
SET IDENTITY_INSERT [dbo].[SanPham] OFF
INSERT [dbo].[UserP] ([ten_dang_nhap], [mat_khau], [ho_ten], [hinh_anh], [dia_chi], [email], [sdt]) VALUES (N'admin                         ', N'12345                         ', N'admin', NULL, NULL, NULL, NULL)
INSERT [dbo].[UserP] ([ten_dang_nhap], [mat_khau], [ho_ten], [hinh_anh], [dia_chi], [email], [sdt]) VALUES (N'caohoang                      ', N'12345                         ', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[UserP] ([ten_dang_nhap], [mat_khau], [ho_ten], [hinh_anh], [dia_chi], [email], [sdt]) VALUES (N'ddd                           ', N'12345                         ', N'Hoàng Liêm', NULL, N'Sài Thành', NULL, N'1234           ')
INSERT [dbo].[UserP] ([ten_dang_nhap], [mat_khau], [ho_ten], [hinh_anh], [dia_chi], [email], [sdt]) VALUES (N'dsa                           ', N'1                             ', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[UserP] ([ten_dang_nhap], [mat_khau], [ho_ten], [hinh_anh], [dia_chi], [email], [sdt]) VALUES (N'hoang_ky                      ', N'12345                         ', N'Hoàng Kỳ Demacia', N'c                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ', N'Quận Cam', N'f                                                 ', N'4              ')
INSERT [dbo].[UserP] ([ten_dang_nhap], [mat_khau], [ho_ten], [hinh_anh], [dia_chi], [email], [sdt]) VALUES (N'hoang_ky_1                    ', N'12345                         ', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[UserP] ([ten_dang_nhap], [mat_khau], [ho_ten], [hinh_anh], [dia_chi], [email], [sdt]) VALUES (N'noname                        ', N'12345                         ', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[UserP] ([ten_dang_nhap], [mat_khau], [ho_ten], [hinh_anh], [dia_chi], [email], [sdt]) VALUES (N'tran_ky                       ', N'12345                         ', N'Cao Trọng Kỳ', N'a                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ', N'Quận 4', N's                                                 ', N'2              ')
INSERT [dbo].[UserP] ([ten_dang_nhap], [mat_khau], [ho_ten], [hinh_anh], [dia_chi], [email], [sdt]) VALUES (N'trong_binh                    ', N'12345                         ', N'Trần Trọng Bình', N'b                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ', N'Lộc Hưng, Lộc Ninh, Bình Phước', N'd                                                 ', N'3              ')
INSERT [dbo].[UserP] ([ten_dang_nhap], [mat_khau], [ho_ten], [hinh_anh], [dia_chi], [email], [sdt]) VALUES (N'zzz                           ', N'123                           ', NULL, NULL, NULL, NULL, NULL)
ALTER TABLE [dbo].[ChiTietDonHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonHang_DonHang] FOREIGN KEY([id_don_hang])
REFERENCES [dbo].[DonHang] ([id_don_hang])
GO
ALTER TABLE [dbo].[ChiTietDonHang] CHECK CONSTRAINT [FK_ChiTietDonHang_DonHang]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_UserP] FOREIGN KEY([ten_dang_nhap])
REFERENCES [dbo].[UserP] ([ten_dang_nhap])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_UserP]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSanPham] FOREIGN KEY([id_loai_sp])
REFERENCES [dbo].[LoaiSanPham] ([id_loai_sp])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSanPham]
GO
