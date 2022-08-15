package phanCong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import congTrinh.CongTrinh;
import main.Database;
import nhanVien.NhanVien;
import phongBan.PhongBan;

public class listPhanCong {
	Database database = new Database();
	ArrayList<PhanCong> list = new ArrayList<PhanCong>();
	ArrayList<CongTrinh> listCongTrinh = new ArrayList<CongTrinh>();
	ArrayList<NhanVien> listNhanVien = new ArrayList<NhanVien>();
	ArrayList<PhongBan> listPhongBan = new ArrayList<PhongBan>();

//	public void LoadData() throws SQLException{
//		list.clear();
//		Connection con = database.getConnect();
//		Statement stmt = con.createStatement();
//    	ResultSet rs = stmt.executeQuery("SELECT DISTINCT macongtrinh, phancong.manhanvien, tennhanvien, congviec, FORMAT (ngaybatdau, 'dd/MM/yyyy') as ngaybatdau, FORMAT (ngayketthuc, 'dd/MM/yyyy') as ngayketthuc, soluongngaycong FROM phancong JOIN nhanvien ON phancong.manhanvien = nhanvien.manhanvien");
//    	while (rs.next()) {
//    		CongTrinh congTrinh = new CongTrinh(rs.getInt(1));
//    		NhanVien nhanVien = new NhanVien(rs.getInt(2));
//    	    String tenNV = rs.getString(3);
//    	    String congviec = rs.getString(4);
//    	    String ngaybatdau = rs.getString(5);
//    	    String ngayketthuc = rs.getString(6);
//    	    int slNC = rs.getInt(7);
//    	    PhanCong pc = new PhanCong(slNC, tenNV, ngaybatdau, ngayketthuc, congviec, congTrinh, nhanVien);
//    	    list.add(pc);
//    	}
//    	con.close();
//    	
//		}
	
	public List<PhanCong> LoadData() throws SQLException{
		list.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT DISTINCT macongtrinh, phancong.manhanvien, tennhanvien, congviec, FORMAT (ngaybatdau, 'dd/MM/yyyy') as ngaybatdau, FORMAT (ngayketthuc, 'dd/MM/yyyy') as ngayketthuc, soluongngaycong FROM phancong JOIN nhanvien ON phancong.manhanvien = nhanvien.manhanvien");
    	while (rs.next()) {
    		CongTrinh congTrinh = new CongTrinh(rs.getInt(1));
    		NhanVien nhanVien = new NhanVien(rs.getInt(2));
    	    String tenNV = rs.getString(3);
    	    String congviec = rs.getString(4);
    	    String ngaybatdau = rs.getString(5);
    	    String ngayketthuc = rs.getString(6);
    	    int slNC = rs.getInt(7);
    	    PhanCong pc = new PhanCong(congTrinh, nhanVien, slNC, ngaybatdau, ngayketthuc, congviec);
    	    list.add(pc);
    	}
    	con.close();
		return list;
    	
		}
	
    
	
	public boolean addData(PhanCong phanCong) throws SQLException {
		
			Connection con = database.getConnect();
			String sql = "INSERT INTO phancong(macongtrinh, manhanvien, congviec, ngaybatdau, ngayketthuc, soluongngaycong) VALUES(?,?,?,CONVERT(date, ?, 103),CONVERT(date, ?, 103),?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, phanCong.getCongTrinh().getMaCT());
			stmt.setInt(2, phanCong.getNhanVien().getMaNV());
			stmt.setString(3, phanCong.getCongviec());
			stmt.setString(4, phanCong.getNgaybatdau());
			stmt.setString(5, phanCong.getNgayketthuc());
			stmt.setInt(6, phanCong.getSlNC());
			stmt.executeUpdate();
			con.close();
//			PhanCong pc = new PhanCong(getSize(), sql, sql, sql, null, null);
			list.add(phanCong);
		return true;
		
	}
	
	public boolean Remove(int maNV, int maCT) throws SQLException {
				Connection con = database.getConnect();
				String sql = "DELETE FROM phancong WHERE (manhanvien = ? AND macongtrinh = ?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, maNV);
				stmt.setInt(2, maCT);
				stmt.executeUpdate();
				con.close();
				return true;
				
	}
	
	public boolean editElement(int maCT, int maNV, PhanCong pc) throws SQLException{
		int index = 0;
		for(PhanCong i : list){
			if((maCT == i.getCongTrinh().getMaCT()) && (maNV == i.getNhanVien().getMaNV())){
				index = list.indexOf(i);
				list.remove(index);
				list.add(index, pc);
				Connection con = database.getConnect();
				String sql = "UPDATE phancong SET macongtrinh = ?, manhanvien = ?, congviec = ?, ngaybatdau = CONVERT(date, ?, 103), ngayketthuc = CONVERT(date, ?, 103), soluongngaycong =? WHERE macongtrinh = ? AND manhanvien = ?";
		    	PreparedStatement stmt = con.prepareStatement(sql);
		    	stmt.setInt(1, maCT);
		    	stmt.setInt(2, maNV);
		    	stmt.setString(3, pc.getCongviec());
		    	stmt.setString(4, pc.getNgaybatdau());
		    	stmt.setString(5, pc.getNgayketthuc());
		    	stmt.setInt(6, pc.getSlNC());
		    	stmt.setInt(7, maCT);
		    	stmt.setInt(8, maNV);
		    	stmt.executeUpdate();
		    	con.close();
				return true;
			}
		}
		return false;	
	}
	
	public int getSize() {
		return list.size();
	}
	
	public PhanCong getElement(int index) {
		if(index < 0 || index >= list.size()) {
			return null;
		}
		return list.get(index);
	}
	
//	public void search(int id) throws SQLException{
//		list.clear();
//		Connection con = database.getConnect();
//		Statement stmt = con.createStatement();
//    	ResultSet rs = stmt.executeQuery("SELECT DISTINCT macongtrinh, phancong.manhanvien, tennhanvien, congviec, FORMAT (ngaybatdau, 'dd/MM/yyyy') as ngaybatdau, FORMAT (ngayketthuc, 'dd/MM/yyyy') as ngayketthuc, soluongngaycong FROM phancong JOIN nhanvien ON phancong.manhanvien = nhanvien.manhanvien where phancong.manhanvien = '" + id + "'");
//    	while (rs.next()) {
//    		int maCT = rs.getInt(1);
//    		int maNV = rs.getInt(2);
//    	    String tenNV = rs.getString(3);
//    	    String congviec = rs.getString(4);
//    	    String ngaybatdau = rs.getString(5);
//    	    String ngayketthuc = rs.getString(6);
//    	    int slNC = rs.getInt(7);
//    	    PhanCong pc = new PhanCong(maCT, maNV, tenNV, congviec, ngaybatdau, ngayketthuc, slNC);
//    	    list.add(pc);
//    	}
//    	con.close();
//	}
	public PhanCong search(int maCT, int maNV ){
		for(PhanCong pc : list){
			if((maCT == pc.getCongTrinh().getMaCT()) && (maNV == pc.getNhanVien().getMaNV())){
				return pc;
			}
		}
		return null;
	}
	public void LoadDataCongTrinh() throws SQLException{
		listCongTrinh.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM congtrinh");
    	while (rs.next()) {
    		int maCT = rs.getInt(1);
    	    String tenCT = rs.getString(2);
    	    String diadiem = rs.getString(3);
    	    String ngayCP = rs.getString(4);
    	    String ngayKC = rs.getString(5);
    	    String ngayHT = rs.getString(6);
    	    CongTrinh ct = new CongTrinh(maCT, tenCT, diadiem, ngayCP, ngayKC, ngayHT);
    	    listCongTrinh.add(ct);
    	}

    	con.close();
    	
	}

	
	public int getSizeDataCongTrinh() {
		return listCongTrinh.size();
	}
	
	public CongTrinh getCongTrinhElement(int index) {
		if(index < 0 || index >= listCongTrinh.size()) {
			return null;
		}
		return listCongTrinh.get(index);
	}
	
	
	public void LoadDataNhanVien() throws SQLException{
		listNhanVien.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM nhanvien");
    	while (rs.next()) {
    		int maNV = rs.getInt(1);
    	    String tenNV = rs.getString(2);
    	    String ngaySinh = rs.getString(3);
    	    String gioiTinh = rs.getString(4);
    	    String diaChi = rs.getString(5);
    	    PhongBan phongBan = new PhongBan(rs.getInt(6));
    	    
    	    NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, diaChi, phongBan);
    	    listNhanVien.add(nv);
    	}

    	con.close();
    	
	}
	public void LoadDataPhongBan() throws SQLException{
		listPhongBan.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT * FROM phongban");
    	while (rs.next()) {
    		int maPB = rs.getInt(1);
    	    String tenPB = rs.getString(2);
    	    PhongBan pb = new PhongBan(maPB, tenPB);
    	    listPhongBan.add(pb);
    	}

    	con.close();
    	
	}

	
	public int getSizeDataMaPhongBan() {
		return listPhongBan.size();
	}
	
	public PhongBan getPhongBanElement(int index) {
		if(index < 0 || index >= listPhongBan.size()) {
			return null;
		}
		return listPhongBan.get(index);
	}
	
	
	public int getSizeDataNhanVien() {
		return listNhanVien.size();
	}
	
	public NhanVien getNhanVienElement(int index) {
		if(index < 0 || index >= listNhanVien.size()) {
			return null;
		}
		return listNhanVien.get(index);
	}
}
