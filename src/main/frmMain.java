package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import congTrinh.SuaCongTrinh;
import congTrinh.ThemCongTrinh;
import congTrinh.TimKiemCongTrinh;
import congTrinh.XoaCongTrinh;

import nhanVien.SuaNhanVien;
import nhanVien.ThemNhanVien;
import nhanVien.TimKiemNhanVien;
import nhanVien.XoaNhanVien;

import phanCong.SuaPhanCong;
import phanCong.ThemPhanCong;
import phanCong.TimKiemPhanCong;
import phanCong.XoaPhanCong;

import phongBan.SuaPhongBan;
import phongBan.ThemPhongBan;
import phongBan.TimKiemPhongBan;
import phongBan.XoaPhongBan;


public class frmMain extends JFrame implements ActionListener{
	
	JPanel pnCenter;
	JLabel lblMain, lblInfo;
	private JMenuBar menubar = new JMenuBar();
	private JMenu menuPhongBan, menuNhanVien, menuCongTrinh, menuPhanCong;
	private JMenuItem itemThemPhongBan, itemXoaPhongBan, itemSuaPhongBan, itemTimKiemPhongBan;
	private JMenuItem itemThemNhanVien, itemXoaNhanVien, itemSuaNhanVien, itemTimKiemNhanVien;
	private JMenuItem itemThemCongTrinh, itemXoaCongTrinh, itemSuaCongTrinh, itemTimKiemCongTrinh;
	private JMenuItem itemThemPhanCong, itemXoaPhanCong, itemSuaPhanCong, itemTimKiemPhanCong;
	private JPanel pnNorth;

		
		public frmMain() throws IOException {
		// TODO Auto-generated constructor stub
			
//		Menu
		menuPhongBan = new JMenu("Phòng ban");
		menuPhongBan.add(itemThemPhongBan = new JMenuItem("Thêm"));
		menuPhongBan.add(itemXoaPhongBan = new JMenuItem("Xóa"));
		menuPhongBan.add(itemSuaPhongBan = new JMenuItem("Sửa"));
		menuPhongBan.add(itemTimKiemPhongBan = new JMenuItem("Tìm kiếm và xem thông tin"));		

		
		menuNhanVien = new JMenu("Nhân viên");
		menuNhanVien.add(itemThemNhanVien = new JMenuItem("Thêm"));
		menuNhanVien.add(itemXoaNhanVien = new JMenuItem("Xoá"));
		menuNhanVien.add(itemSuaNhanVien = new JMenuItem("Sửa"));
		menuNhanVien.add(itemTimKiemNhanVien = new JMenuItem("Tìm kiếm và  Xem thông tin"));
		
		menuCongTrinh = new JMenu("Công trình");
		menuCongTrinh.add(itemThemCongTrinh = new JMenuItem("Thêm"));
		menuCongTrinh.add(itemXoaCongTrinh = new JMenuItem("Xóa"));
		menuCongTrinh.add(itemSuaCongTrinh = new JMenuItem("Sủa"));
		menuCongTrinh.add(itemTimKiemCongTrinh = new JMenuItem("Tìm kiếm và xem thông tin"));	
		
		menuPhanCong = new JMenu("Phân công");
		menuPhanCong.add(itemThemPhanCong = new JMenuItem("Thêm"));
		menuPhanCong.add(itemXoaPhanCong = new JMenuItem("Xóa"));
		menuPhanCong.add(itemSuaPhanCong = new JMenuItem("Sửa"));
		menuPhanCong.add(itemTimKiemPhanCong = new JMenuItem("Tìm kiếm và  xem thông tin"));		
		
		
		menubar.add(menuPhongBan);
		menubar.add(menuNhanVien);
		menubar.add(menuCongTrinh);
		menubar.add(menuPhanCong);
		
		setJMenuBar(menubar);
		
		////////////////////////////////////////////////////////////
		
		pnNorth = new JPanel();
		lblMain = new JLabel("Quản lý lao động");
		lblMain.setFont(new Font("ARIAL", Font.BOLD, 30));
		lblMain.setForeground(Color.BLUE);
		pnNorth.add(lblMain);
		pnNorth.setBorder(BorderFactory.createEmptyBorder(80,50, 30, 30));
		add(pnNorth, BorderLayout.NORTH);
		
		pnCenter = new JPanel();
		BufferedImage myPicture = ImageIO.read(new File("image/quanlylaodong2.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		pnCenter.add(picLabel);

		add(pnCenter, BorderLayout.CENTER);
		
		
		this.add(pnCenter,BorderLayout.CENTER);
		setSize(1000,700);
		setTitle("Quản lý lao động");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		itemThemPhongBan.addActionListener(this);
		itemXoaPhongBan.addActionListener(this);
		itemSuaPhongBan.addActionListener(this);
		itemTimKiemPhongBan.addActionListener(this);
		
		itemThemNhanVien.addActionListener(this);
		itemXoaNhanVien.addActionListener(this);
		itemSuaNhanVien.addActionListener(this);
		itemTimKiemNhanVien.addActionListener(this);

		itemThemCongTrinh.addActionListener(this);
		itemXoaCongTrinh.addActionListener(this);
		itemSuaCongTrinh.addActionListener(this);
		itemTimKiemCongTrinh.addActionListener(this);
		
		itemThemPhanCong.addActionListener(this);
		itemXoaPhanCong.addActionListener(this);
		itemSuaPhanCong.addActionListener(this);
		itemTimKiemPhanCong.addActionListener(this);

	}
		
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new frmMain().setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(itemThemPhongBan)) {
			try {
				new ThemPhongBan().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemXoaPhongBan)) {
			try {
				new XoaPhongBan().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemSuaPhongBan)) {
			try {
				new SuaPhongBan().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemTimKiemPhongBan)) {
			try {
				new TimKiemPhongBan().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemThemNhanVien)) {
			try {
				new ThemNhanVien().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemXoaNhanVien)) {
			try {
				new XoaNhanVien().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemSuaNhanVien)) {
			try {
				new SuaNhanVien().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemTimKiemNhanVien)) {
			try {
				new TimKiemNhanVien().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemThemCongTrinh)) {
			try {
				new ThemCongTrinh().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemXoaCongTrinh)) {
			try {
				new XoaCongTrinh().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemSuaCongTrinh)) {
			try {
				new SuaCongTrinh().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemTimKiemCongTrinh)) {
			try {
				new TimKiemCongTrinh().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemThemPhanCong)) {
			try {
				new ThemPhanCong().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemXoaPhanCong)) {
			try {
				new XoaPhanCong().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemSuaPhanCong)) {
			try {
				new SuaPhanCong().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(o.equals(itemTimKiemPhanCong)) {
			try {
				new TimKiemPhanCong().setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	}
	}
	
}
