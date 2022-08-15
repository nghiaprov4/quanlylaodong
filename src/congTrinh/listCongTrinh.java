package congTrinh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.Database;
import nhanVien.NhanVien;



public class listCongTrinh {
	Database database = new Database();
	ArrayList<CongTrinh> list = new ArrayList<CongTrinh>();
	public void LoadData() throws SQLException{
		list.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery("SELECT macongtrinh, tencongtrinh, diadiem, FORMAT (ngaycapphep, 'dd/MM/yyyy') as ngaycapphep, FORMAT (ngaykhoicong, 'dd/MM/yyyy') as ngaykhoicong,FORMAT (ngayhoanthanh, 'dd/MM/yyyy') as ngayhoanthanh FROM congtrinh");
    	while (rs.next()) {
    		int maCT = rs.getInt(1);
    	    String tenCT = rs.getString(2);
    	    String diadiem = rs.getString(3);
    	    String ngayCP = rs.getString(4);
    	    String ngayKC = rs.getString(5);
    	    String ngayHT = rs.getString(6);
    	    
    	    CongTrinh ct = new CongTrinh(maCT, tenCT, diadiem, ngayCP, ngayKC, ngayHT);
    	    list.add(ct);
    	}
    	con.close();
    	
		}
	
   	
    
	
	public boolean addData(int maCT, String tenCT, String diadiem, String ngayCP, String ngayKC, String ngayHT) throws SQLException {
		for(CongTrinh i : list){
			if(maCT == i.getMaCT()){
				return false;
			}
		}
		CongTrinh ct = new CongTrinh(maCT, tenCT, diadiem, ngayCP, ngayKC, ngayHT);
		Connection con = database.getConnect();
		String sql = "INSERT INTO congtrinh(macongtrinh, tencongtrinh, diadiem, ngaycapphep, ngaykhoicong, ngayhoanthanh) VALUES(?,?,?,CONVERT(date, ?, 103),CONVERT(date, ?, 103),CONVERT(date, ?, 103))";
    	PreparedStatement stmt = con.prepareStatement(sql);
    	stmt.setInt(1, maCT);
    	stmt.setString(2, tenCT);
    	stmt.setString(3, diadiem);
    	stmt.setString(4, ngayCP);
    	stmt.setString(5, ngayKC);
    	stmt.setString(6, ngayHT);
    	stmt.executeUpdate();
    	list.add(ct);
    	con.close();
    	return true;
    	
	}
	
	public void Remove(int maCT) throws SQLException {
				Connection con = database.getConnect();
				String sql = "DELETE FROM congtrinh WHERE macongtrinh = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, maCT);
				stmt.executeUpdate();
				con.close();
				
	}
	
	public boolean editElement(int maCT, CongTrinh ct) throws SQLException{
		int index = 0;
		for(CongTrinh i : list){
			if(maCT == i.getMaCT()){
				index = list.indexOf(i);
				list.remove(index);
				list.add(index, ct);
				Connection con = database.getConnect();
				String sql = "UPDATE congtrinh SET  tencongtrinh = ?, diadiem = ?, ngaycapphep = ?, ngaykhoicong = ?, ngayhoanthanh = ? WHERE macongtrinh = ?";
		    	PreparedStatement stmt = con.prepareStatement(sql);
		    	stmt.setString(1, ct.getTenCT());
		    	stmt.setString(2, ct.getDiadiem());
		    	stmt.setString(3, ct.getNgayCP());
		    	stmt.setString(4, ct.getNgayKC());
		    	stmt.setString(5, ct.getNgayHT());
		    	stmt.setInt(6, maCT);
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
	
	public CongTrinh getElement(int index) {
		if(index < 0 || index >= list.size()) {
			return null;
		}
		return list.get(index);
	}
	
	public CongTrinh search(int id){
		for(CongTrinh nv : list){
			if(id == nv.getMaCT()){
				return nv;
			}
		}
		return null;
	}
	
}
