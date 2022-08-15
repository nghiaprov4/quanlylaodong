package nhanVien;

import phongBan.PhongBan;

public class NhanVien {
	int maNV, soLuongNgayCong;
	String tenNV, ngaySinh, gioiTinh, diaChi;
	private PhongBan phongBan;

	public NhanVien(){
		
	} 
	

	public NhanVien(int maNV, int soLuongNgayCong, String tenNV, String ngaySinh, String gioiTinh, String diaChi,
			PhongBan phongBan) {
		super();
		this.maNV = maNV;
		this.soLuongNgayCong = soLuongNgayCong;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.phongBan = phongBan;
	}


	public NhanVien(int maNV, String tenNV, String ngaySinh, String gioiTinh, String diaChi, PhongBan phongBan) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.phongBan = phongBan;
	}






	public NhanVien(int maNV) {
		super();
		this.maNV = maNV;
	}






	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getSoLuongNgayCong() {
		return soLuongNgayCong;
	}
	public void setSoLuongNgayCong(int soLuongNgayCong) {
		this.soLuongNgayCong = soLuongNgayCong;
	}
	public PhongBan getPhongBan() {
		return phongBan;
	}



	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	@Override
	public String toString() {
		return String.format("%d;%s;%s;%s;%s;%d", getMaNV(), getTenNV(), getNgaySinh(), getGioiTinh(), getDiaChi(), getPhongBan());
	}
	
	public String toString1() {
		return String.format("%d;%s;%s;%s;%s;%d;%d", getMaNV(), getTenNV(), getNgaySinh(), getGioiTinh(), getDiaChi(), getPhongBan(), getSoLuongNgayCong());
	}
	
	
}
