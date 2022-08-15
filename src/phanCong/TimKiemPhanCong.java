package phanCong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import congTrinh.SuaCongTrinh;
import congTrinh.ThemCongTrinh;
import congTrinh.TimKiemCongTrinh;
import congTrinh.XoaCongTrinh;
import main.frmMain;
import nhanVien.SuaNhanVien;
import nhanVien.ThemNhanVien;
import nhanVien.TimKiemNhanVien;
import nhanVien.XoaNhanVien;
import phongBan.SuaPhongBan;
import phongBan.ThemPhongBan;
import phongBan.TimKiemPhongBan;
import phongBan.XoaPhongBan;

public class TimKiemPhanCong extends JFrame implements ActionListener {
	private JPanel pnNorth, pnCenter, pnSouth;
	private JLabel lblmaCT, lblmaNV, lblSLNC, lblTitle, lblTimKiem, lblCongViec, lblNgayBD, lblNgayKT;
	private JTextField txtmaCT, txtmaNV, txtSLNC, txtTimKiem, txtNgayBD, txtNgayKT, txtCongViec;
	private JTable tbPhanCong;
	private DefaultTableModel tbPhanCongModel;
	private JButton btnThem, btnXoa, btnSua, btnXoaTrang, btnTimKiem;
	private JComboBox cbbNhanVien, cbbCongTrinh;
	private DefaultComboBoxModel cbbNhanVienModel;
	private DefaultComboBoxModel cbbCongTrinhModel;
	private listPhanCong list = new listPhanCong();
	private JMenuBar menubar = new JMenuBar();
	private JMenu menuPhongBan, menuNhanVien, menuCongTrinh, menuPhanCong;
	private JMenuItem itemThemPhongBan, itemXoaPhongBan, itemSuaPhongBan, itemTimKiemPhongBan;
	private JMenuItem itemThemNhanVien, itemXoaNhanVien, itemSuaNhanVien, itemTimKiemNhanVien;
	private JMenuItem itemThemCongTrinh, itemXoaCongTrinh, itemSuaCongTrinh, itemTimKiemCongTrinh;
	private JMenuItem itemThemPhanCong, itemXoaPhanCong, itemSuaPhanCong, itemTimKiemPhanCong;
	private JMenu menuTrangChu;
	private JMenuItem itemTrangChu;
	public TimKiemPhanCong() throws SQLException {
		// TODO Auto-generated constructor stub
		menuPhongBan = new JMenu("Phòng Ban");
		menuPhongBan.add(itemThemPhongBan = new JMenuItem("Thêm"));
		menuPhongBan.add(itemXoaPhongBan = new JMenuItem("Xoá"));
		menuPhongBan.add(itemSuaPhongBan = new JMenuItem("Sửa"));
		menuPhongBan.add(itemTimKiemPhongBan = new JMenuItem("Tìm kiếm và Xem thông tin"));		

		
		menuNhanVien = new JMenu("Nhân Viên");
		menuNhanVien.add(itemThemNhanVien = new JMenuItem("Thêm"));
		menuNhanVien.add(itemXoaNhanVien = new JMenuItem("Xoá"));
		menuNhanVien.add(itemSuaNhanVien = new JMenuItem("Sửa"));
		menuNhanVien.add(itemTimKiemNhanVien = new JMenuItem("Tìm kiếm và Xem thông tin"));
		
		menuCongTrinh = new JMenu("Công Trình");
		menuCongTrinh.add(itemThemCongTrinh = new JMenuItem("Thêm"));
		menuCongTrinh.add(itemXoaCongTrinh = new JMenuItem("Xoá"));
		menuCongTrinh.add(itemSuaCongTrinh = new JMenuItem("Sửa"));
		menuCongTrinh.add(itemTimKiemCongTrinh = new JMenuItem("Tìm kiếm và Xem thông tin"));	
		
		menuPhanCong = new JMenu("Phân Công");
		menuPhanCong.add(itemThemPhanCong = new JMenuItem("Thêm"));
		menuPhanCong.add(itemXoaPhanCong = new JMenuItem("Xoá"));
		menuPhanCong.add(itemSuaPhanCong = new JMenuItem("Sửa"));
		menuPhanCong.add(itemTimKiemPhanCong = new JMenuItem("Tìm kiếm và Xem thông tin"));		
		menuTrangChu = new JMenu("Trang chủ");
		menuTrangChu.add(itemTrangChu = new JMenuItem("Quay về trang chủ"));
		
		menubar.add(menuPhongBan);
		menubar.add(menuNhanVien);
		menubar.add(menuCongTrinh);
		menubar.add(menuPhanCong);
		menubar.add(menuTrangChu);
		setJMenuBar(menubar);

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


		itemTrangChu.addActionListener(this);
		pnNorth = new JPanel();
		pnNorth.add(lblTitle = new JLabel("TÌM KIẾM PHÂN CÔNG"));
		lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);
		
		pnCenter = new JPanel(new GridBagLayout());
		
		pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		lblmaCT = new JLabel("Mã Công Trình");
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 0;
		pnCenter.add(lblmaCT, c);
		
		cbbCongTrinh = new JComboBox();
		cbbCongTrinh.setEnabled(false);
		c.insets = new Insets(20, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 0;
		pnCenter.add(cbbCongTrinh, c);
		
		lblmaNV = new JLabel("Mã Nhân Viên");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		pnCenter.add(lblmaNV, c);
		
		cbbNhanVien = new JComboBox();
		cbbNhanVien.setEnabled(false);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 1;
		pnCenter.add(cbbNhanVien, c);
		
		lblCongViec = new JLabel("Công Việc");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		pnCenter.add(lblCongViec, c);
		
		txtCongViec = new JTextField();
		txtCongViec.setEditable(false);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 2;
		pnCenter.add(txtCongViec, c);
		
		lblNgayBD = new JLabel("Ngày Bắt Đầu");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 3;
		pnCenter.add(lblNgayBD, c);
		
		txtNgayBD = new JTextField();
		txtNgayBD.setEditable(false);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 3;
		pnCenter.add(txtNgayBD, c);
		
		lblNgayKT = new JLabel("Ngày Kết Thúc");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 4;
		pnCenter.add(lblNgayKT, c);
		
		txtNgayKT = new JTextField();
		txtNgayKT.setEditable(false);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 4;
		pnCenter.add(txtNgayKT, c);
		
		lblSLNC = new JLabel("Số Lượng Ngày Công");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 5;
		pnCenter.add(lblSLNC, c);
		
		txtSLNC = new JTextField();
		txtSLNC.setEditable(false);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 5;
		pnCenter.add(txtSLNC, c);

		c.weighty = 1;
		c.weightx = 1;
		pnCenter.add(new JLabel(""), c);
		
		pnSouth = new JPanel();
		JPanel pnTask = new JPanel();
		pnTask.add(lblTimKiem = new JLabel("Nhập mã nhân viên để tìm kiếm:"));
		pnTask.add(txtTimKiem = new JTextField(10));
		pnTask.add(btnTimKiem = new JButton("Tìm"));
		
		String[] header = "Mã công trình,Mã nhân viên,Tên nhân viên,Công việc,Ngày bắt đầu,Ngày kết thúc,Số ngày công".split(",");
		tbPhanCongModel = new DefaultTableModel(header,0);
		tbPhanCong = new JTable(tbPhanCongModel);
		JScrollPane scroll = new JScrollPane(tbPhanCong);
		tbPhanCong.setRowHeight(25);
		tbPhanCong.setDefaultEditor(Object.class, null); //Không cho sửa dữ liẹu trên bảng
		scroll.getViewport().add(tbPhanCong);
		scroll.setPreferredSize(new Dimension(900,250));
		pnTask.setPreferredSize(new Dimension(1000,50));
		pnSouth.add(pnTask);
		pnSouth.add(scroll);
		pnSouth.setBorder(BorderFactory.createEmptyBorder(10,10, 80, 10));
		
		add(pnNorth, BorderLayout.NORTH);
		add(pnCenter, BorderLayout.CENTER);
		add(pnSouth, BorderLayout.SOUTH);
		
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
		LoadDatabase();
		reloadCongTrinh();
		reloadNhanVien();
		tbPhanCong.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int rowClicked = tbPhanCong.getSelectedRow();
				int maCTTemp = Integer.parseInt(tbPhanCongModel.getValueAt(rowClicked, 0).toString());
				Object maCT;
				for(int i = 0; i < list.getSizeDataCongTrinh(); i++) {
					if(maCTTemp == list.getCongTrinhElement(i).getMaCT()) {
						maCT = maCTTemp + " - " + list.getCongTrinhElement(i).getTenCT();
						cbbCongTrinhModel.setSelectedItem(maCT);
					}
				}
				
				int maNVTemp = Integer.parseInt(tbPhanCongModel.getValueAt(rowClicked, 1).toString());
				Object maNV;
				for(int i = 0; i < list.getSizeDataNhanVien(); i++) {
					if(maNVTemp == list.getNhanVienElement(i).getMaNV()) {
						maNV = maNVTemp + " - " + list.getNhanVienElement(i).getTenNV();
						cbbNhanVienModel.setSelectedItem(maNV);
					}
				}
				
			
				txtCongViec.setText(tbPhanCongModel.getValueAt(rowClicked, 3).toString());
				txtNgayBD.setText(tbPhanCongModel.getValueAt(rowClicked, 4).toString());
				txtNgayKT.setText(tbPhanCongModel.getValueAt(rowClicked, 5).toString());
				
				
				
				txtSLNC.setText(tbPhanCongModel.getValueAt(rowClicked, 6).toString());
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(txtTimKiem.getText().trim().length() == 0) {
					try {
						LoadDatabase();
						ClearAll();
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
						ClearAll();
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
						ClearAll();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
	
		
		
		
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Search();
				ClearAll();
			}
		});
		
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////

	
	
	public void LoadDatabase() throws SQLException {
		tbPhanCongModel.setRowCount(0);
		list.LoadData();
		for(int i = 0; i < list.getSize(); i++) {
			PhanCong pc = list.getElement(i);
			tbPhanCongModel.addRow(pc.toString().split(";"));
		}
		
	}
	
	public void dataSearch() throws SQLException {
		tbPhanCongModel.setRowCount(0);
		for(int i = 0; i < list.getSize(); i++) {
			PhanCong pc = list.getElement(i);
			tbPhanCongModel.addRow(pc.toString().split(";"));
		}
		
	}
	
	
	public void Search() {
		String str = txtTimKiem.getText();
		if(str != null && str.trim().length() > 0) {
			try {
				int id = Integer.parseInt(str);
				list.search(id);
				dataSearch();
				if(list.getSize() == 0) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy");
					txtTimKiem.selectAll();
					txtTimKiem.requestFocus();
				}
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ");
			}
		}
	}
	
	
	public void ClearAll() {
		cbbCongTrinhModel.setSelectedItem("...");
		cbbNhanVienModel.setSelectedItem("...");
		txtCongViec.setText("");
		txtNgayBD.setText("");
		txtNgayKT.setText("");
		txtSLNC.setText("");
	}
	
	

	private void reloadNhanVien() throws SQLException {
		list.LoadDataNhanVien();
		cbbNhanVienModel = new DefaultComboBoxModel();
		int maNV;
		String tenNV;
		cbbNhanVienModel.addElement("...");
	    for(int i = 0; i < list.getSizeDataNhanVien(); i++) {
	    	 maNV = list.getNhanVienElement(i).getMaNV();
	    	 tenNV = list.getNhanVienElement(i).getTenNV();
	    	 cbbNhanVienModel.addElement(maNV + " - " + tenNV);    
	     }
         cbbNhanVien.setModel(cbbNhanVienModel);
	 }
	

	private void reloadCongTrinh() throws SQLException {
		list.LoadDataCongTrinh();
		cbbCongTrinhModel = new DefaultComboBoxModel();
		int maCT;
		String tenCT;
		cbbCongTrinhModel.addElement("...");
	    for(int i = 0; i < list.getSizeDataCongTrinh(); i++) {
	    	 maCT = list.getCongTrinhElement(i).getMaCT();
	    	 tenCT = list.getCongTrinhElement(i).getTenCT();
	    	 cbbCongTrinhModel.addElement(maCT + " - " + tenCT);    
	     }
         cbbCongTrinh.setModel(cbbCongTrinhModel);
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
		if(o.equals(itemTrangChu)) {
			try {
				new frmMain().setVisible(true);
				setVisible(false);
			} catch ( IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
}
