--thiet ke database (ban tam thoi)
create database quanlylaodong1

use quanlylaodong1


create table phongban
(
	maphongban nvarchar(30) not null primary key,
	tenphongban nvarchar(30)
)

create table nhanvien
(
	manhanvien int primary key not null,
	tennhanvien nvarchar(30),
	ngaysinh date,
	gioitinh nvarchar(4),
	diachi nvarchar(100),
	maphongban nvarchar(30) not null foreign key (maphongban) references phongban(maphongban)
	
)

create table congtrinh
(
	macongtrinh int primary key not null,
	tencongtrinh nvarchar(30),
	diadiem nvarchar(100),
	ngaycapphep date,
	ngaykhoicong date,
	ngayhoanthanh date,
)


create table phancong
(
	macongtrinh int not null foreign key (macongtrinh) references congtrinh(macongtrinh),
	manhanvien int not null foreign key (manhanvien) references nhanvien(manhanvien),
	congviec nvarchar(50),
	ngaybatdau date,
	ngayketthuc date,
	soluongngaycong int
)
	set dateformat dmy
	
	
   ALTER TABLE congtrinh
   ADD CONSTRAINT CK_ct CHECK (ngaycapphep < ngaykhoicong)
   ALTER TABLE congtrinh
   ADD CONSTRAINT CK_ct1 CHECK (ngaykhoicong < ngayhoanthanh)
   ALTER TABLE phancong ADD CONSTRAINT CK_SL CHECK (soluongngaycong <= (datediff(day,ngaybatdau,ngayketthuc) + 1))

   DROP DATABASE quanlylaodong
   

