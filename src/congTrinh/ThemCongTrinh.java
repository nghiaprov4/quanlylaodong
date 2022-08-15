package congTrinh;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import main.frmMain;
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

public class ThemCongTrinh extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnNorth, pnCenter, pnSouth;
	JLabel lblTitle, lblmacongtrinh, lbltimkiem,lblSoLuong, lbltencongtrinh, lbldiadiem, lblngaycapphep, lblngaykhoicong, lblngayhoanthanh;
	JTextField txtmacongtrinh,txttimkiem, txttencongtrinh, txtdiadiem, txtngaycapphep, txtngaykhoicong, txtngayhoanthanh;
	private JTable tbCongTrinh;
	private DefaultTableModel tbCongTrinhModel;
	private JButton btnThem, btnXoaTrang, btnXoa, btnSua, btnXemThongTin, btnTimKiem;
	private JMenuBar menubar = new JMenuBar();
	private JMenu menuPhongBan, menuNhanVien, menuCongTrinh, menuPhanCong;
	private JMenuItem itemThemPhongBan, itemXoaPhongBan, itemSuaPhongBan, itemTimKiemPhongBan;
	private JMenuItem itemThemNhanVien, itemXoaNhanVien, itemSuaNhanVien, itemTimKiemNhanVien;
	private JMenuItem itemThemCongTrinh, itemXoaCongTrinh, itemSuaCongTrinh, itemTimKiemCongTrinh;
	private JMenuItem itemThemPhanCong, itemXoaPhanCong, itemSuaPhanCong, itemTimKiemPhanCong;
	listCongTrinh list = new listCongTrinh();
	private JMenuItem itemTrangChu;
	private Container menuTrangChu;
	public ThemCongTrinh() throws SQLException {
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
		pnNorth.add(lblTitle = new JLabel("THÊM CÔNG TRÌNH"));
		lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);
		
		pnCenter = new JPanel(new GridBagLayout());
		
		pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		lblmacongtrinh = new JLabel("Mã Công Trình:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 0;
		pnCenter.add(lblmacongtrinh, c);
		
		txtmacongtrinh = new JTextField();
		c.insets = new Insets(20, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 0;
		pnCenter.add(txtmacongtrinh, c);
		
		lbltencongtrinh = new JLabel("Tên công trình:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		pnCenter.add(lbltencongtrinh, c);
		
		txttencongtrinh = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 1;
		pnCenter.add(txttencongtrinh, c);
		
		lbldiadiem = new JLabel("Địa điểm:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		pnCenter.add(lbldiadiem, c);
		
		txtdiadiem = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 2;
		pnCenter.add(txtdiadiem, c);
		
		lblngaycapphep = new JLabel("Ngày cấp phép:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 3;
		pnCenter.add(lblngaycapphep, c);
		
		txtngaycapphep = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 3;
		pnCenter.add(txtngaycapphep, c);
		
		lblngaykhoicong = new JLabel("Ngày khởi công:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 4;
		pnCenter.add(lblngaykhoicong, c);
		
		txtngaykhoicong = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 4;
		pnCenter.add(txtngaykhoicong, c);
		
		lblngayhoanthanh = new JLabel("Ngày hoàn thành:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 5;
		pnCenter.add(lblngayhoanthanh, c);
		
		txtngayhoanthanh = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 5;
		pnCenter.add(txtngayhoanthanh, c);
		
		
		

		c.weighty = 1;
		c.weightx = 1;
		pnCenter.add(new JLabel(""), c);
		
		pnSouth = new JPanel();
		JPanel pnTask = new JPanel();
		pnTask.add(btnThem = new JButton("Thêm"));
		pnTask.add(btnXoaTrang = new JButton("Xoá Trắng"));
		pnTask.add(lbltimkiem = new JLabel("Nhập mã để tìm kiếm:"));
		pnTask.add(txttimkiem = new JTextField(10));
		pnTask.add(btnTimKiem = new JButton("Tìm"));
		
		JPanel pnSoLuong = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnSoLuong.add(lblSoLuong = new JLabel());
		
		String[] header = "Mã Công trình, Tên công trình, Địa Điểm, Ngày cấp phép, Ngày khởi công, Ngày hoàn thành".split(",");
		tbCongTrinhModel = new DefaultTableModel(header,0);
		tbCongTrinh = new JTable(tbCongTrinhModel);
		JScrollPane scroll = new JScrollPane(tbCongTrinh);
		tbCongTrinh.setRowHeight(25);
		tbCongTrinh.setDefaultEditor(Object.class, null);
		scroll.getViewport().add(tbCongTrinh);
		scroll.setPreferredSize(new Dimension(900,290));
		pnTask.setPreferredSize(new Dimension(1000,50));
		pnSouth.add(pnTask);
		pnSouth.add(pnSoLuong);
		pnSoLuong.setPreferredSize(new Dimension(900,25));
		pnSouth.add(scroll);
		pnSouth.setBorder(BorderFactory.createEmptyBorder(10,10, 80, 10));
	
		add(pnNorth, BorderLayout.NORTH);
		add(pnCenter, BorderLayout.CENTER);
		add(pnSouth, BorderLayout.SOUTH);
		
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		LoadDatabase();
		lblSoLuong.setText("Sô lượng Công Trình: " + list.getSize());
		
		tbCongTrinh.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int rowClicked = tbCongTrinh.getSelectedRow();
				txtmacongtrinh.setText(tbCongTrinhModel.getValueAt(rowClicked, 0).toString());
				txttencongtrinh.setText(tbCongTrinhModel.getValueAt(rowClicked, 1).toString());
				txtdiadiem.setText(tbCongTrinhModel.getValueAt(rowClicked, 2).toString());
				txtngaycapphep.setText(tbCongTrinhModel.getValueAt(rowClicked, 3).toString());
				txtngaykhoicong.setText(tbCongTrinhModel.getValueAt(rowClicked, 4).toString());
				txtngayhoanthanh.setText(tbCongTrinhModel.getValueAt(rowClicked, 5).toString());
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

		
		txttimkiem.getDocument().addDocumentListener(new DocumentListener() {
			
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(txttimkiem.getText().trim().length() == 0) {
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
				if(txttimkiem.getText().trim().length() == 0) {
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
				if(txttimkiem.getText().trim().length() == 0) {
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
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(validData()) {
				int maCT = Integer.parseInt(txtmacongtrinh.getText());
				String tenCT = txttencongtrinh.getText();
				String diadiem = txtdiadiem.getText();
				String ngayCP = txtngaycapphep.getText();
				String ngayKC = txtngaykhoicong.getText();
				String ngayHT = txtngayhoanthanh.getText();
				
					try {
						if(list.addData(maCT, tenCT, diadiem, ngayCP, ngayKC, ngayHT) == true) {
							LoadDatabase();
							lblSoLuong.setText("Sô lượng Công Trình: " + list.getSize());
						}
						else {
							JOptionPane.showMessageDialog(null, "Trùng mã");
						}
							
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Ngày cấp phép phải nhỏ hơn ngày khởi công, và ngày khởi công phải nhỏ hơn ngày hoàn thành.");
					}
				
					// TODO Auto-generated catch block
				}
				return;
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
	
///////////////////////////////////////////////////////////////////////////////////////////

	public void LoadDatabase() throws SQLException {
		tbCongTrinhModel.setRowCount(0);
		list.LoadData();
		for(int i = 0; i < list.getSize(); i++) {
			CongTrinh ct = list.getElement(i);
			tbCongTrinhModel.addRow(ct.toString().split(";"));
		}
		
	}
	
	public void ClearAll(){
		txtmacongtrinh.setText("");
		txttencongtrinh.setText("");
		txtdiadiem.setText("");
		txtngaycapphep.setText("");
		txtngaykhoicong.setText("");
		txtngayhoanthanh.setText("");
	}
	
	public void Search() {
		String str = txttimkiem.getText();
		if(str != null && str.trim().length() > 0) {
			try {
				int id = Integer.parseInt(str);
				CongTrinh ct = list.search(id);
				if(ct != null) {
					tbCongTrinhModel.setRowCount(0);
					tbCongTrinhModel.addRow(ct.toString().split(";"));
				}
				else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy");
					return;
				}
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Dữ Liệu Không Hợp Lệ");
				txttimkiem.selectAll();
				txttimkiem.requestFocus();
			}
		}
	}
	
	public boolean validData() {
		String maCT = txtmacongtrinh.getText().trim();
		String tenCT = txttencongtrinh.getText().trim();
		String diadiem = txtdiadiem.getText().trim();
		String ngaycapphep = txtngaycapphep.getText().trim();
		String ngaykhoicong = txtngaykhoicong.getText().trim();
		String ngayhoanthanh = txtngayhoanthanh.getText().trim();
		
		if(maCT.length() > 0){
			try {
				if(Integer.parseInt(maCT) <= 0) {
					JOptionPane.showMessageDialog(null, "Mã công trình phải nhập số dương");
					return false;
				}
			}catch (Exception e) {
			// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Mã công trình là một số.");
			}
		}
		
		if(maCT.length() == 0) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập mã công trình.");
			return false;
		}
		
		if(!(tenCT.length() > 0 && tenCT.matches("^([\\w\\/!@#$%^&*()<>+~,-]\\s*)*[\\w\\/!@#$%^&*()<>+~,-]$"))){
			JOptionPane.showMessageDialog(null, "Lỗi tên công trình:");
			return false;
		}
		
		if(!(diadiem.length() > 0 && diadiem.matches("^([a-zA-Z0-9/.,-]\\s*)*[a-zA-Z0-9]$"))){
			JOptionPane.showMessageDialog(this, "Lỗi địa điểm.");
			return false;
		}
		
		if(!(ngaycapphep.length() > 0 && ngaycapphep.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})"))){
			JOptionPane.showMessageDialog(this, "Lỗi ngày cấp phép: Bạn phải nhập theo mẫu: dd/mm/yyyy.");
			return false;
		}
		
		if(!(ngaykhoicong.length() > 0 && ngaykhoicong.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})"))){
			JOptionPane.showMessageDialog(this, "Lỗi ngày khởi công: Bạn phải nhập theo mẫu: dd/mm/yyyy.");
			return false;
		}
		
		if(!(ngayhoanthanh.length() > 0 && ngayhoanthanh.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})"))){
			JOptionPane.showMessageDialog(this, "Lỗi ngày hoàn thành: Bạn phải nhập theo mẫu: dd/mm/yyyy.");
			return false;
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
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

