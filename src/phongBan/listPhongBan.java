package phongBan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.Database;
import nhanVien.NhanVien;






public class listPhongBan { 
	/* Database database = new Database(); */
	Database database = new Database();
	ArrayList<PhongBan> list = new ArrayList<PhongBan>();
	
	public void LoadData() throws SQLException{
		list.clear();
		Connection con = database.getConnect();
		Statement stmt = con.createStatement(); 
    	ResultSet rs = stmt.executeQuery("SELECT * FROM phongban");
    	while (rs.next()) {
    		String maPB = rs.getString(1);
    	    String tenPB = rs.getString(2);
    	    PhongBan pb = new PhongBan(maPB, tenPB);
    	    list.add(pb);
    	}
    	con.close();
    	 
	}
	
	public void addData(String maPB, String tenPB) throws SQLException {
		PhongBan pb = new PhongBan(maPB, tenPB);
		Connection con = database.getConnect();
		String sql = "INSERT INTO phongban(maphongban, tenphongban) VALUES(?,?)";
    	PreparedStatement stmt = con.prepareStatement(sql);
    	stmt.setString(1, maPB);
    	stmt.setString(2, tenPB);
    	stmt.executeUpdate();
    	list.add(pb);
    	con.close();
	}
	
	public void Remove(int maPB) throws SQLException {		
				Connection con = database.getConnect();
				String sql = "DELETE FROM phongban WHERE maphongban = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, maPB);
				stmt.executeUpdate();
				con.close();
				
	}
	
	public boolean editElement(String maPB, PhongBan pb) throws SQLException{
		int index = 0;
		for(PhongBan i : list){
			if(maPB == i.getMaPB()){
				index = list.indexOf(i);
				list.remove(index);
				list.add(index, pb);
				Connection con = database.getConnect();
				String sql = "UPDATE phongban SET tenphongban = ? WHERE maphongban =?";
		    	PreparedStatement stmt = con.prepareStatement(sql);
		    	stmt.setString(1, pb.getTenPB());
		    	stmt.setString(2, pb.getMaPB());
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
	
	public PhongBan getElement(int index) {
		if(index < 0 || index >= list.size()) {
			return null;
		}
		return list.get(index);
	}
	
	public PhongBan search(String id){
		for(PhongBan pb : list){
			if(id == pb.getMaPB()){
				return pb;
			}
		}
		return null;
	}
}
