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
import phongBan.SuaPhongBan;
import phongBan.ThemPhongBan;
import phongBan.TimKiemPhongBan;
import phongBan.XoaPhongBan;

public class SuaCongTrinh extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnNorth, pnCenter, pnSouth;
	JLabel lblTitle, lblmacongtrinh, lbltimkiem,lblSoLuong, lbltencongtrinh, lbldiadiem, lblngaycapphep, lblngaykhoicong, lblngayhoanthanh;
	JTextField txtmacongtrinh,txttimkiem, txttencongtrinh, txtdiadiem, txtngaycapphep, txtngaykhoicong, txtngayhoanthanh;
	private JTable tbCongTrinh;
	private DefaultTableModel tbCongTrinhModel;
	private JButton btnXoaTrang, btnSua, btnTimKiem;
	private JMenuBar menubar = new JMenuBar();
	private JMenu menuPhongBan, menuNhanVien, menuCongTrinh, menuPhanCong;
	private JMenuItem itemThemPhongBan, itemXoaPhongBan, itemSuaPhongBan, itemTimKiemPhongBan;
	private JMenuItem itemThemNhanVien, itemXoaNhanVien, itemSuaNhanVien, itemTimKiemNhanVien;
	private JMenuItem itemThemCongTrinh, itemXoaCongTrinh, itemSuaCongTrinh, itemTimKiemCongTrinh;
	private JMenuItem itemThemPhanCong, itemXoaPhanCong, itemSuaPhanCong, itemTimKiemPhanCong;
	listCongTrinh list = new listCongTrinh();
	private Container menuTrangChu;
	private JMenuItem itemTrangChu;
	public SuaCongTrinh() throws SQLException {
		// TODO Auto-generated constructor stub
		menuPhongBan = new JMenu("Ph??ng Ban");
		menuPhongBan.add(itemThemPhongBan = new JMenuItem("Th??m"));
		menuPhongBan.add(itemXoaPhongBan = new JMenuItem("Xo??"));
		menuPhongBan.add(itemSuaPhongBan = new JMenuItem("S???a"));
		menuPhongBan.add(itemTimKiemPhongBan = new JMenuItem("T??m ki???m v?? Xem th??ng tin"));		

		
		menuNhanVien = new JMenu("Nh??n Vi??n");
		menuNhanVien.add(itemThemNhanVien = new JMenuItem("Th??m"));
		menuNhanVien.add(itemXoaNhanVien = new JMenuItem("Xo??"));
		menuNhanVien.add(itemSuaNhanVien = new JMenuItem("S???a"));
		menuNhanVien.add(itemTimKiemNhanVien = new JMenuItem("T??m ki???m v?? Xem th??ng tin"));
		
		menuCongTrinh = new JMenu("C??ng Tr??nh");
		menuCongTrinh.add(itemThemCongTrinh = new JMenuItem("Th??m"));
		menuCongTrinh.add(itemXoaCongTrinh = new JMenuItem("Xo??"));
		menuCongTrinh.add(itemSuaCongTrinh = new JMenuItem("S???a"));
		menuCongTrinh.add(itemTimKiemCongTrinh = new JMenuItem("T??m ki???m v?? Xem th??ng tin"));	
		
		menuPhanCong = new JMenu("Ph??n C??ng");
		menuPhanCong.add(itemThemPhanCong = new JMenuItem("Th??m"));
		menuPhanCong.add(itemXoaPhanCong = new JMenuItem("Xo??"));
		menuPhanCong.add(itemSuaPhanCong = new JMenuItem("S???a"));
		menuPhanCong.add(itemTimKiemPhanCong = new JMenuItem("T??m ki???m v?? Xem th??ng tin"));		
		menuTrangChu = new JMenu("Trang ch???");
		menuTrangChu.add(itemTrangChu = new JMenuItem("Quay v??? trang ch???"));
		
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
		pnNorth.add(lblTitle = new JLabel("S???A C??NG TR??NH"));
		lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);
		
		pnCenter = new JPanel(new GridBagLayout());
		
		pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		lblmacongtrinh = new JLabel("M?? C??ng Tr??nh:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 0;
		pnCenter.add(lblmacongtrinh, c);
		
		txtmacongtrinh = new JTextField();
		txtmacongtrinh.setEditable(false);
		c.insets = new Insets(20, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 0;
		pnCenter.add(txtmacongtrinh, c);
		
		lbltencongtrinh = new JLabel("T??n c??ng tr??nh:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		pnCenter.add(lbltencongtrinh, c);
		
		txttencongtrinh = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 1;
		pnCenter.add(txttencongtrinh, c);
		
		lbldiadiem = new JLabel("?????a ??i???m:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		pnCenter.add(lbldiadiem, c);
		
		txtdiadiem = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 2;
		pnCenter.add(txtdiadiem, c);
		
		lblngaycapphep = new JLabel("Ng??y c???p ph??p:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 3;
		pnCenter.add(lblngaycapphep, c);
		
		txtngaycapphep = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 3;
		pnCenter.add(txtngaycapphep, c);
		
		lblngaykhoicong = new JLabel("Ng??y kh???i c??ng:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 4;
		pnCenter.add(lblngaykhoicong, c);
		
		txtngaykhoicong = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 4;
		pnCenter.add(txtngaykhoicong, c);
		
		lblngayhoanthanh = new JLabel("Ng??y ho??n th??nh:");
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
		pnTask.add(btnSua = new JButton("S???a"));
		pnTask.add(btnXoaTrang = new JButton("Xo?? Tr???ng"));
		pnTask.add(lbltimkiem = new JLabel("Nh???p m?? ????? t??m ki???m:"));
		pnTask.add(txttimkiem = new JTextField(10));
		pnTask.add(btnTimKiem = new JButton("T??m"));
		
		JPanel pnSoLuong = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnSoLuong.add(lblSoLuong = new JLabel());
		
		String[] header = "M?? C??ng tr??nh, T??n c??ng tr??nh, ?????a ??i???m, Ng??y c???p ph??p, Ng??y kh???i c??ng, Ng??y ho??n th??nh".split(",");
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
		lblSoLuong.setText("S?? l?????ng C??ng Tr??nh: " + list.getSize());
		
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
		
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(validData()) {
				int rowClicked = tbCongTrinh.getSelectedRow();
				
				try {
					
					int maCT = Integer.parseInt(txtmacongtrinh.getText());
					String tenCT = txttencongtrinh.getText();
					String diadiem = txtdiadiem.getText();
					String ngayCP = txtngaycapphep.getText();
					String ngayKC = txtngaykhoicong.getText();
					String ngayHT = txtngayhoanthanh.getText();
					CongTrinh ct = new CongTrinh(maCT, tenCT, diadiem, ngayCP, ngayKC, ngayHT);
					if(list.editElement(maCT, ct) == true) {
						JOptionPane.showMessageDialog(null, "S???a th??nh c??ng");
						LoadDatabase();
						tbCongTrinh.setRowSelectionInterval(rowClicked, rowClicked);
					}else {
						JOptionPane.showMessageDialog(null, "Kh??ng ???????c s???a m?? Ph??ng Ban");
						txtmacongtrinh.selectAll();
						txtmacongtrinh.requestFocus();
					}
					return;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Ng??y c???p ph??p ph???i nh??? h??n ng??y kh???i c??ng, v?? ng??y kh???i c??ng ph???i nh??? h??n ng??y ho??n th??nh.");
					
				}
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
					JOptionPane.showMessageDialog(null, "Kh??ng t??m th???y");
					return;
				}
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "D??? Li???u Kh??ng H???p L???");
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
					JOptionPane.showMessageDialog(null, "M?? c??ng tr??nh ph???i nh???p s??? d????ng");
					return false;
				}
			}catch (Exception e) {
			// TODO: handle exception
				JOptionPane.showMessageDialog(null, "M?? c??ng tr??nh l?? m???t s???.");
			}
		}
		
		if(maCT.length() == 0) {
			JOptionPane.showMessageDialog(null, "B???n ph???i nh???p m?? c??ng tr??nh.");
			return false;
		}
		
		if(!(tenCT.length() > 0 && tenCT.matches("^([\\w\\/!@#$%^&*()<>+~,-]\\s*)*[\\w\\/!@#$%^&*()<>+~,-]$"))){
			JOptionPane.showMessageDialog(null, "L???i t??n c??ng tr??nh:");
			return false;
		}
		
		if(!(diadiem.length() > 0 && diadiem.matches("^([a-zA-Z0-9/.,-]\\s*)*[a-zA-Z0-9]$"))){
			JOptionPane.showMessageDialog(this, "L???i ?????a ??i???m.");
			return false;
		}
		
		if(!(ngaycapphep.length() > 0 && ngaycapphep.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})"))){
			JOptionPane.showMessageDialog(this, "L???i ng??y c???p ph??p: B???n ph???i nh???p theo m???u: dd/mm/yyyy.");
			return false;
		}
		
		if(!(ngaykhoicong.length() > 0 && ngaykhoicong.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})"))){
			JOptionPane.showMessageDialog(this, "L???i ng??y kh???i c??ng: B???n ph???i nh???p theo m???u: dd/mm/yyyy.");
			return false;
		}
		
		if(!(ngayhoanthanh.length() > 0 && ngayhoanthanh.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})"))){
			JOptionPane.showMessageDialog(this, "L???i ng??y ho??n th??nh: B???n ph???i nh???p theo m???u: dd/mm/yyyy.");
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

