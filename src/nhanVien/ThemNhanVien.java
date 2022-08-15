package nhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.SwingConstants;
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
import phanCong.SuaPhanCong;
import phanCong.ThemPhanCong;
import phanCong.TimKiemPhanCong;
import phanCong.XoaPhanCong;
import phongBan.PhongBan;
import phongBan.SuaPhongBan;
import phongBan.ThemPhongBan;
import phongBan.TimKiemPhongBan;
import phongBan.XoaPhongBan;




public class ThemNhanVien extends JFrame implements ActionListener{
	private JPanel pnNorth, pnCenter, pnSouth;
	private JLabel lblTitle,lblsoLuongNV, lblmaNV, lblngaySinh, lblgioiTinh, lbldiaChi, lblmaPB, lblmaCT, lbltenNV, lblTimKiem;
	private JTextField txtmaNV, txtngaySinh, txtdiaChi, txtmaPB, txttenNV, txtTimKiem;
	private JButton btnThem, btnXoa, btnSua, btnXoaTrang, btnTimKiem;
	private JTable tbNhanVien;
	private DefaultTableModel tbNhanVienModel;
	private JMenuItem itemNhanVien, itemPhongBan, itemCongTrinh, itemNgayCong, itemTKNhanVien, itemTKPhongBan, itemTKCongTrinh;
	public listNhanVien list;
	private JComboBox cbbGender, cbbPhongBan;
	private DefaultComboBoxModel cbbModel;
	private DefaultComboBoxModel<String> cbbModelPhongBan;
	private JMenuBar menubar = new JMenuBar();
	private JMenu menuPhongBan, menuNhanVien, menuCongTrinh, menuPhanCong;
	private JMenuItem itemThemPhongBan, itemXoaPhongBan, itemSuaPhongBan, itemTimKiemPhongBan;
	private JMenuItem itemThemNhanVien, itemXoaNhanVien, itemSuaNhanVien, itemTimKiemNhanVien;
	private JMenuItem itemThemCongTrinh, itemXoaCongTrinh, itemSuaCongTrinh, itemTimKiemCongTrinh;
	private JMenuItem itemThemPhanCong, itemXoaPhanCong, itemSuaPhanCong, itemTimKiemPhanCong;
	private JMenu menuTrangChu;
	private JMenuItem itemTrangChu;
 
	public ThemNhanVien() throws SQLException {
		// TODO Auto-generated constructor stub
		
		list = new listNhanVien();
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
		pnNorth.add(lblTitle = new JLabel("THÊM NHÂN VIÊN"));
		lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);
		
		pnCenter = new JPanel(new GridBagLayout());
		
		pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		lblmaNV = new JLabel("Mã Nhân Viên:");
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 0;
		pnCenter.add(lblmaNV, c);
		
		txtmaNV = new JTextField();
		c.insets = new Insets(20, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 0;
		pnCenter.add(txtmaNV, c);
		
		lbltenNV = new JLabel("Tên Nhân Viên:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		pnCenter.add(lbltenNV, c);
		
		txttenNV = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 1;
		pnCenter.add(txttenNV, c);
		
		lblngaySinh = new JLabel("Ngày Sinh:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		pnCenter.add(lblngaySinh, c);
		
		txtngaySinh = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 2;
		pnCenter.add(txtngaySinh, c);
		
		lblgioiTinh = new JLabel("Giới Tính:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 3;
		pnCenter.add(lblgioiTinh, c);
		
		cbbGender = new JComboBox();
		cbbModel = new DefaultComboBoxModel();
		cbbModel.addElement("Nam");  
		cbbModel.addElement("Nữ");  
		cbbGender.setModel(cbbModel);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 3;
		pnCenter.add(cbbGender, c);
		
		lbldiaChi = new JLabel("Địa Chỉ:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 4;
		pnCenter.add(lbldiaChi, c);
		
		txtdiaChi = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 4;
		pnCenter.add(txtdiaChi, c);
		
		lblmaPB = new JLabel("Mã Phòng Ban:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 5;
		pnCenter.add(lblmaPB, c);

		cbbPhongBan = new JComboBox();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 5;
		pnCenter.add(cbbPhongBan, c);
		

		c.weighty = 1;
		c.weightx = 1;
		
		pnCenter.add(new JLabel(""), c);
		
		pnSouth = new JPanel();
		JPanel pnTask = new JPanel();
		pnTask.add(btnThem = new JButton("Thêm"));
		pnTask.add(btnXoaTrang = new JButton("Xoá Trắng"));
		pnTask.add(lblTimKiem = new JLabel("Nhập mã để tìm kiếm: "));
		pnTask.add(txtTimKiem = new JTextField(10));
		pnTask.add(btnTimKiem = new JButton("Tìm"));
		JPanel pnSoLuong = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnSoLuong.add(lblsoLuongNV = new JLabel());
		
		String[] header = "Mã Nhân Viên,Tên Nhân Viên,Ngày Sinh, Giới Tính, Địa Chỉ, Mã Phòng Ban".split(",");
		tbNhanVienModel = new DefaultTableModel(header,0);
		tbNhanVien = new JTable(tbNhanVienModel);
		JScrollPane scroll = new JScrollPane(tbNhanVien);
		tbNhanVien.setDefaultEditor(Object.class, null); //Không cho sửa dữ liẹu trên bảng
		tbNhanVien.setRowHeight(25);
		scroll.getViewport().add(tbNhanVien);
		scroll.setPreferredSize(new Dimension(900,250));
		pnTask.setPreferredSize(new Dimension(1000,35));
		pnSouth.add(pnTask);
		pnSoLuong.setPreferredSize(new Dimension(900,25));
		pnSouth.add(pnSoLuong);
		pnSouth.add(scroll);
		pnSouth.setBorder(BorderFactory.createEmptyBorder(10,10, 80, 10));
		
		add(pnNorth, BorderLayout.NORTH);
		add(pnCenter, BorderLayout.CENTER);
		add(pnSouth, BorderLayout.SOUTH);
		
		
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		LoadDatabase();
		reloadComboBox();
		lblsoLuongNV.setText("Số lượng nhân viên: "+ list.getSize());
		
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
		
		
		tbNhanVien.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int rowClicked = tbNhanVien.getSelectedRow();
				txtmaNV.setText(tbNhanVienModel.getValueAt(rowClicked, 0).toString());
				txttenNV.setText(tbNhanVienModel.getValueAt(rowClicked, 1).toString());
				txtngaySinh.setText(tbNhanVienModel.getValueAt(rowClicked, 2).toString());
				Object gender = tbNhanVienModel.getValueAt(rowClicked, 3).toString();
				cbbGender.setSelectedItem(gender);
				txtdiaChi.setText(tbNhanVienModel.getValueAt(rowClicked, 4).toString());
				String maPBTemp = tbNhanVienModel.getValueAt(rowClicked, 5).toString();
				Object maPB;
				for(int i = 0; i < list.getSizeDataMaPhongBan(); i++) {
					if(maPBTemp == list.getPhongBanElement(i).getMaPB()) {
						maPB = maPBTemp + " - " + list.getPhongBanElement(i).getTenPB();
						cbbModelPhongBan.setSelectedItem(maPB);
					}
				}
				
				
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
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubf
			
			if(validData() == true) {
				int maNV = Integer.parseInt(txtmaNV.getText());
	    	    String tenNV = txttenNV.getText();
	    	    String ngaySinh = txtngaySinh.getText();
	    	    String gioiTinh = cbbModel.getSelectedItem().toString();
	    	    String diaChi = txtdiaChi.getText();
	    	    String maPBtemp[] = cbbModelPhongBan.getSelectedItem().toString().split("-");
	    	    String phongBan = maPBtemp[0].trim();
				NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, diaChi, new PhongBan(phongBan));
	    	    try {
					if(list.addData(nhanVien) == true) {
						tbNhanVienModel.addRow(new Object[]{ nhanVien.getMaNV(), nhanVien.getTenNV(), nhanVien.getNgaySinh(), nhanVien.getGioiTinh(), nhanVien.getDiaChi(), nhanVien.getPhongBan().getMaPB() });

						lblsoLuongNV.setText("Số lượng nhân viên: "+ list.getSize());	
						reloadComboBox();
					}
					else {
						JOptionPane.showMessageDialog(null, "Trùng mã nhân viên");
					}
	    	    } catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Phòng ban không tồn tại");
					}
				
					// TODO Auto-generated catch block
				}else {
					return;
				}
				
			}
		});
		
		
		btnXoaTrang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ClearAll();
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
	
	///////////////////////////////////////////////////////
	public void ClearAll() {
			txtmaNV.setText("");
			txtngaySinh.setText("");
			txtdiaChi.setText("");
			cbbGender.setSelectedItem(("Nam"));
			txttenNV.setText("");
			cbbPhongBan.setSelectedItem("...");
	}
	

	public void LoadDatabase() throws SQLException {
//		tbNhanVienModel.setRowCount(0);
//		list.LoadData();
//		for(int i = 0; i < list.getSize(); i++) {
//			NhanVien nv = list.getElement(i);
//			tbNhanVienModel.addRow(nv.toString().split(";"));
//		}
		list = new listNhanVien();
		for( NhanVien nhanVien : list.getAllNhanVien()) {
			Object[] rowData = { nhanVien.getMaNV(), nhanVien.getTenNV(), nhanVien.getNgaySinh(), nhanVien.getGioiTinh(), nhanVien.getDiaChi(), nhanVien.getPhongBan().getMaPB() };
			tbNhanVienModel.addRow(rowData);
 
		}
	}
	
	private void reloadComboBox() throws SQLException {
		list.LoadDataPhongBan();
		cbbModelPhongBan = new DefaultComboBoxModel();
		String maPB;
		String tenPB;
		cbbModelPhongBan.addElement("...");
	    for(int i = 0; i < list.getSizeDataMaPhongBan(); i++) {
	    	 maPB = list.getPhongBanElement(i).getMaPB();
	    	 tenPB = list.getPhongBanElement(i).getTenPB();
	    	 cbbModelPhongBan.addElement(maPB + " - " + tenPB);    
	     }
         cbbPhongBan.setModel(cbbModelPhongBan);
	 }
	
	public boolean validData() {
		String maNV = txtmaNV.getText().trim();
		String tenNV = txttenNV.getText().trim();
		String ngaysinh = txtngaySinh.getText().trim();
		String diachi = txtdiaChi.getText().trim();
		
		if(maNV.length() > 0){
			try {
				int x = Integer.parseInt(maNV);
				if(x <= 0) {
					JOptionPane.showMessageDialog(null, "Mã nhân viên phải là số dương.");
					return false;
				}
			}catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Mã nhân viên là một số.");
				return false;
			}
		}
		
		if(maNV.length() == 0) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập mã nhân viên.");
			return false;
		}
		
//		if(!(tenNV.length() > 0 && tenNV.matches("[^&%$#@!~_'\\\\.?();]*"))){
//
//
//			JOptionPane.showMessageDialog(this, "Lỗi tên nhân viên.");
//			return false;
//		}
		if(!(tenNV.length() > 0 )){
			JOptionPane.showMessageDialog(this, "Phải nhập tên nhân viên.");
			return false;
		}

		
		
		if(!(ngaysinh.length() > 0 && ngaysinh.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})"))){
			JOptionPane.showMessageDialog(this, "Lỗi: Bạn phải nhập theo mẫu : dd/mm/yyyy.");
			return false;
		}
//		if(!(diachi.length() > 0 && diachi.matches("[^&%$#@!~_'\\\\\\\\.?();]*"))){
//			JOptionPane.showMessageDialog(this, "Lỗi địa chỉ.");
//			return false;
//		}
		if(!(diachi.length() > 0 )){
			JOptionPane.showMessageDialog(this, "Bạn phhải nhập địa chỉ.");
			return false;
		}
		
		
		if(cbbModelPhongBan.getSelectedItem().toString().equalsIgnoreCase("...")) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn Mã Phòng Ban.");
			return false;
		}
		
		return true;
	}
	
	
	public void Search() {
		String str = txtTimKiem.getText();
		if(str != null && str.trim().length() > 0) {
			try {
				int id = Integer.parseInt(str);
				NhanVien nv = list.search(id);
				if(nv != null) {
					tbNhanVienModel.setRowCount(0);
					tbNhanVienModel.addRow(nv.toString().split(";"));
				}
				else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy.");
					return;
				}
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Dữ Liệu Không Hợp Lệ.");
				txtTimKiem.selectAll();
				txtTimKiem.requestFocus();
			}
		}
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
	
	

