package phanCong;

import congTrinh.CongTrinh;
import nhanVien.NhanVien;

public class PhanCong {
	private CongTrinh congTrinh;
	private NhanVien nhanVien;
	int  slNC;
	String tenNV;
	String ngaybatdau, ngayketthuc, congviec;


	

public PhanCong() {
	// TODO Auto-generated constructor stub
}

	

	public PhanCong(CongTrinh congTrinh, NhanVien nhanVien, int slNC, String tenNV, String ngaybatdau, String ngayketthuc,
		String congviec) {
	super();
	this.congTrinh = congTrinh;
	this.nhanVien = nhanVien;
	this.slNC = slNC;
	this.tenNV = tenNV;
	this.ngaybatdau = ngaybatdau;
	this.ngayketthuc = ngayketthuc;
	this.congviec = congviec;
}



	public PhanCong(CongTrinh congTrinh, NhanVien nhanVien, int slNC, String ngaybatdau, String ngayketthuc,
			String congviec) {
		super();
		this.congTrinh = congTrinh;
		this.nhanVien = nhanVien;
		this.slNC = slNC;
		this.ngaybatdau = ngaybatdau;
		this.ngayketthuc = ngayketthuc;
		this.congviec = congviec;
	}



	public CongTrinh getCongTrinh() {
		return congTrinh;
	}

	public void setCongTrinh(CongTrinh congTrinh) {
		this.congTrinh = congTrinh;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getCongviec() {
		return congviec;
	}

	public void setCongviec(String congviec) {
		this.congviec = congviec;
	}

	public String getNgaybatdau() {
		return ngaybatdau;
	}

	public void setNgaybatdau(String ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}

	public String getNgayketthuc() {
		return ngayketthuc;
	}

	public void setNgayketthuc(String ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}



	public int getSlNC() {
		return slNC;
	}


	public void setSlNC(int slNC) {
		this.slNC = slNC;
	}


	@Override
	public String toString() {
		return String.format("%d;%d;%s;%s;%s;%s;%d", getCongTrinh(), getNhanVien(), getTenNV(), getCongviec(), getNgaybatdau(), getNgayketthuc(), getSlNC());
	}
	
}
