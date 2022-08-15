package phongBan;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


import main.Database;

import nhanVien.NhanVien;

import nhanVien.listNhanVien;


public class infoPhongBan extends JFrame implements ActionListener {
	private JTable tbThongTinNV;
	private DefaultTableModel tbThongTinNVModel;
	private JMenuBar menubar = new JMenuBar();
	private JMenu menuDanhMuc;
	private JMenuItem itemNhanVien, itemPhongBan, itemCongTrinh, itemNgayCong;
	private Database database = new Database();
	private JButton btnQuayLai, btnTimKiem;
	private JLabel lblSoLuongNV;
	private JTextField txtTimKiem;
	ArrayList<NhanVien> list = new ArrayList<NhanVien>();
	private String maPB;
	 public infoPhongBan(String maPB) throws SQLException { 
		// TODO Auto-generated constructor stub 
		 	this.maPB = maPB;
			JPanel pnNorth = new JPanel();
			String[] header = "Mã Nhân Viên,Tên Nhân Viên,Ngày Sinh,Giới Tính,Địa Chỉ".split(",");
			tbThongTinNVModel = new DefaultTableModel(header,0);
			tbThongTinNV = new JTable(tbThongTinNVModel); 
			tbThongTinNV.setRowHeight(25);
			JScrollPane scroll = new JScrollPane(tbThongTinNV);
			tbThongTinNV.setDefaultEditor(Object.class, null); //Không cho sửa dữ liẹu trên bảng
			scroll.getViewport().add(tbThongTinNV);
			scroll.setPreferredSize(new Dimension(900,550));
			pnNorth.setBorder(new EmptyBorder(0, 50, 50, 50));
			pnNorth.add(scroll);
			
			Box b = Box.createHorizontalBox();
			b.add(Box.createVerticalStrut(50));
			b.add(btnQuayLai = new JButton("Quay Lại"));
			b.add(lblSoLuongNV = new JLabel());
			b.add(Box.createHorizontalStrut(250));
			b.add(txtTimKiem = new JTextField(300));
			txtTimKiem.setMaximumSize(new Dimension(0,28));
			b.add(btnTimKiem = new JButton("Tìm"));
			b.setBorder(new EmptyBorder(0, 45, 0, 45));
			
			add(pnNorth, BorderLayout.SOUTH);
			add(b,BorderLayout.NORTH);
			
			btnQuayLai.addActionListener(this);
			btnTimKiem.addActionListener(this);
			LoadDatabase();
			lblSoLuongNV.setText("Số lượng nhân viên trong Phòng Ban " +maPB +": " +list.size());
			setSize(1000, 700);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					if(txtTimKiem.getText().trim().length() == 0) {
						try { 
							LoadDatabase();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}	
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					if(txtTimKiem.getText().trim().length() == 0) {
						try {
							LoadDatabase();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					if(txtTimKiem.getText().trim().length() == 0) {
						try {
							LoadDatabase();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
	}
	
	 public void LoadDataFromDatabase(String maPB) throws SQLException {
		 	list.clear();
		 	Connection con = database.getConnect();
			Statement stmt = con.createStatement();
	    	ResultSet rs = stmt.executeQuery("SELECT nhanvien.manhanvien, nhanvien.tennhanvien, FORMAT (nhanvien.ngaysinh, 'dd/MM/yyyy') as ngaysinh , nhanvien.gioitinh, nhanvien.diachi FROM nhanvien WHERE maphongban = '" + maPB +"'");
			while (rs.next()) {
	    		int maNV = rs.getInt(1);
	    	    String tenNV = rs.getString(2);
	    	    String ngaySinh = rs.getString(3);
	    	    String gioiTinh = rs.getString(4);
	    	    String diaChi = rs.getString(5);
	    	    NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, diaChi, new PhongBan(maPB));
	    	    list.add(nv);
	    	}
	    	con.close();
	    
	 }
	 

	 
	public void LoadDatabase() throws SQLException {
			tbThongTinNVModel.setRowCount(0);
			LoadDataFromDatabase(maPB);
			for(int i = 0; i < list.size(); i++) {
				NhanVien nv = list.get(i);
				tbThongTinNVModel.addRow(nv.toString().split(";"));
			}
	}
	
	public NhanVien search(int id){
		for(NhanVien nv : list){
			if(id == nv.getMaNV()){
				return nv;
			}
		}
		return null;
	}
	
	
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				Object o = e.getSource();
				
				if(o.equals(btnQuayLai)) {
					try {
						new TimKiemPhongBan().setVisible(true);
						setVisible(false);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				if(o.equals(btnTimKiem)) {
					String str = txtTimKiem.getText();
					if(str != null && str.trim().length() > 0) {
						try {
							int id = Integer.parseInt(str);
							NhanVien nv = search(id);
							if(nv != null) {
								tbThongTinNVModel.setRowCount(0);
								tbThongTinNVModel.addRow(nv.toString().split(";"));
							}
							else {
								JOptionPane.showMessageDialog(null, "Không tìm thấy");
								return;
							}
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Dữ Liệu Không Hợp Lệ");
							txtTimKiem.selectAll();
							txtTimKiem.requestFocus();
						}
					}
				}
	}
}
