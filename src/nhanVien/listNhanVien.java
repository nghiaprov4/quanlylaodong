package nhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import main.Database;
import phanCong.PhanCong;
import phongBan.PhongBan;


public class listNhanVien { 
	Database database = new Database();
	ArrayList<NhanVien> list = new ArrayList<NhanVien>();
	ArrayList<PhongBan> listPhongBan = new ArrayList<PhongBan>();
	public void LoadData() throws SQLException{ 
		list.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery(" SELECT manhanvien, tennhanvien, FORMAT (ngaysinh, 'dd/MM/yyyy') as ngaysinh, gioitinh, diachi, maphongban FROM nhanvien");
    	while (rs.next()) {
    		int maNV = rs.getInt(1);
    	    String tenNV = rs.getString(2);
    	    String ngaySinh = rs.getString(3);
    	    String gioiTinh = rs.getString(4);
    	    String diaChi = rs.getString(5);
			PhongBan phongBan = new PhongBan(rs.getString(6));
    	    NhanVien nv =new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, diaChi, phongBan);
    	    list.add(nv);
    	}
    	con.close();
    	
	}
	public List<NhanVien> getAllNhanVien() throws SQLException{
		list.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery(" SELECT manhanvien, tennhanvien, FORMAT (ngaysinh, 'dd/MM/yyyy') as ngaysinh, gioitinh, diachi, maphongban FROM nhanvien");
    	while (rs.next()) {
    		int maNV = rs.getInt(1);
    	    String tenNV = rs.getString(2);
    	    String ngaySinh = rs.getString(3);
    	    String gioiTinh = rs.getString(4);
    	    String diaChi = rs.getString(5);
			PhongBan phongBan = new PhongBan(rs.getString(6));
    	    NhanVien nv =new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, diaChi, phongBan);
    	    list.add(nv);
    	}
    	con.close();
		return list;
    	
	}
    	
    	public boolean addData(NhanVien nv) throws SQLException {
    		
    		
    		Connection con = database.getConnect();
    		String sql = "INSERT INTO nhanvien(manhanvien, tennhanvien, ngaysinh, gioitinh, diachi, maphongban) VALUES(?,?,CONVERT(date, ?, 103),?,?,?)";
        	PreparedStatement stmt = con.prepareStatement(sql);
        	stmt.setInt(1, nv.maNV);
        	stmt.setString(2, nv.tenNV);
        	stmt.setString(3, nv.ngaySinh);
        	stmt.setString(4, nv.gioiTinh);
        	stmt.setString(5, nv.diaChi);
        	stmt.setString(6, nv.getPhongBan().getMaPB());
        	stmt.executeUpdate();
        	list.add(nv);
        	con.close();
        	return true;
    	}
    	
    	public void Remove(int maNV) throws SQLException {
    		Connection con = database.getConnect();
    		String sql = "DELETE FROM nhanvien WHERE manhanvien = ?";
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setInt(1, maNV);
    		stmt.executeUpdate();
    		con.close();
    	}
    	
    	public boolean editElement(int maNV, NhanVien nv) throws SQLException{
    		int index = 0;
    		for(NhanVien i : list){
    			if(maNV == i.getMaNV()){
    				index = list.indexOf(i);
    				list.remove(i);
    				list.add(index, nv);
    				Connection con = database.getConnect();
    				String sql = "UPDATE nhanvien SET  tennhanvien = ?, ngaysinh = CONVERT(date, ?, 103), gioitinh = ?, diachi = ?, maphongban = ? WHERE manhanvien = ?";
    		    	PreparedStatement stmt = con.prepareStatement(sql);
    		    	stmt.setString(1, nv.getTenNV());
    		    	stmt.setString(2, nv.getNgaySinh());
    		    	stmt.setString(3, nv.getGioiTinh());
    		    	stmt.setString(4, nv.getDiaChi());
    		    	stmt.setString(5, nv.getPhongBan().getMaPB());
    		    	stmt.setInt(6, maNV);
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
    	
    	public NhanVien getElement(int index) {
    		if(index < 0 || index >= list.size()) {
    			return null;
    		}
    		return list.get(index);
    	}
    	
    	public NhanVien search(int maNV){
    		for(NhanVien nv : list){
    			if(maNV == nv.getMaNV()){
    				return nv;
    			}
    		}
    		return null;
//    		NhanVien nv = new NhanVien(maNV) ;
//    		if(list.contains(nv)) {
//    			return list.get(list.indexOf(nv));
//    		}
//    		return null;
    	}
    	
    	public void LoadDataPhongBan() throws SQLException{
    		listPhongBan.clear();
    		Connection con = database.getConnect();
    		Statement stmt = con.createStatement();
        	ResultSet rs = stmt.executeQuery("SELECT * FROM phongban");
        	while (rs.next()) {
        		String maPB = rs.getString(1);
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
    	
    	
}
