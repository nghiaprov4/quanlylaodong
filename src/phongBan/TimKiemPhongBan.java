package phongBan;

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

public class TimKiemPhongBan extends JFrame implements ActionListener{
	private JPanel pnNorth, pnCenter, pnSouth;
	private JLabel lblmaPB, lbltenPB,lblTitle, lblTimKiem, lblSoLuong;
	private JTextField txtmaPB, txttenPB, txtTimKiem;
	private JTable tbPhongBan;
	private DefaultTableModel tbPhongBanModel;
	private JButton btnThem, btnXoa, btnSua, btnXoaTrang,btnXemThongTin, btnTimKiem;
	private JMenuBar menubar = new JMenuBar();
	private JMenu menuPhongBan, menuNhanVien, menuCongTrinh, menuPhanCong;
	private JMenuItem itemThemPhongBan, itemXoaPhongBan, itemSuaPhongBan, itemTimKiemPhongBan;
	private JMenuItem itemThemNhanVien, itemXoaNhanVien, itemSuaNhanVien, itemTimKiemNhanVien;
	private JMenuItem itemThemCongTrinh, itemXoaCongTrinh, itemSuaCongTrinh, itemTimKiemCongTrinh;
	private JMenuItem itemThemPhanCong, itemXoaPhanCong, itemSuaPhanCong, itemTimKiemPhanCong;

	public listPhongBan list;
	private JMenu menuTrangChu;
	private JMenuItem itemTrangChu;
	
	 
	public TimKiemPhongBan() throws SQLException {
		list = new listPhongBan();
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
		pnNorth.add(lblTitle = new JLabel("T??M KI???M PH??NG BAN"));
		lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);
		
		pnCenter = new JPanel(new GridBagLayout());
		
		pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		lblmaPB = new JLabel("M?? Ph??ng Ban");
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 0;
		pnCenter.add(lblmaPB, c);
		
		txtmaPB= new JTextField();
		txtmaPB.setEditable(false);
		c.insets = new Insets(20, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 0;
		pnCenter.add(txtmaPB, c);
		
		lbltenPB = new JLabel("T??n Ph??ng Ban");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		pnCenter.add(lbltenPB, c);
		
		txttenPB = new JTextField();
		txttenPB.setEditable(false);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 1;
		pnCenter.add(txttenPB, c);
		
		
		c.weighty = 1;
		c.weightx = 1;
		pnCenter.add(new JLabel(""), c);
		
		pnSouth = new JPanel();
		JPanel pnTask = new JPanel();
		pnTask.add(btnXemThongTin = new JButton("Xem Th??ng Tin"));
//		pnTask.add(lblTimKiem = new JLabel("Nh???p m?? ????? t??m ki???m: "));
		pnTask.add(txtTimKiem = new JTextField(10));
		pnTask.add(btnTimKiem = new JButton("T??m"));
		
		JPanel pnSoLuong = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnSoLuong.add(lblSoLuong = new JLabel());
		
		String[] header = "M?? Ph??ng Ban, T??n Ph??ng Ban".split(",");
		tbPhongBanModel = new DefaultTableModel(header,0);
		tbPhongBan = new JTable(tbPhongBanModel);
		tbPhongBan.setRowHeight(25);
		JScrollPane scroll = new JScrollPane(tbPhongBan);
		tbPhongBan.setDefaultEditor(Object.class, null); //Kh??ng cho s???a d??? li???u tr??n b???ng
		scroll.getViewport().add(tbPhongBan);
		scroll.setPreferredSize(new Dimension(900,390));
		pnTask.setPreferredSize(new Dimension(1000,35));
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
		lblSoLuong.setText("S??? l????ng ph??ng ban: " +list.getSize());	
		
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


		tbPhongBan.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int rowClicked = tbPhongBan.getSelectedRow();
				txtmaPB.setText(tbPhongBanModel.getValueAt(rowClicked, 0).toString());
				txttenPB.setText(tbPhongBanModel.getValueAt(rowClicked, 1).toString());
				
				
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
		
		
		
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Search();
				ClearAll();
			}
		});
		
		btnXemThongTin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new infoPhongBan(txtmaPB.getText()).setVisible(true);
					setVisible(false);
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	}
	
	
	

	public void LoadDatabase() throws SQLException {
		tbPhongBanModel.setRowCount(0);
		list.LoadData();
		for(int i = 0; i < list.getSize(); i++) {
			PhongBan pb = list.getElement(i);
			tbPhongBanModel.addRow(pb.toString().split(","));
		}
		
	}

	
	public void Search() {
		String str = txtTimKiem.getText();
		if(str != null && str.trim().length() > 0) {
			try {
				String id = str;
				PhongBan pb = list.search(id);
				if(pb != null) {
					tbPhongBanModel.setRowCount(0);
					tbPhongBanModel.addRow(pb.toString().split(","));
				}
				else {
					JOptionPane.showMessageDialog(null, "Kh??ng t??m th???y");
					return;
				}
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "D??? Li???u Kh??ng H???p L???");
				txtTimKiem.selectAll();
				txtTimKiem.requestFocus();
			}
		}
	}
	
	public void ClearAll() {
		txtmaPB.setText("");
		txttenPB.setText("");
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

