package nhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
import phanCong.SuaPhanCong;
import phanCong.ThemPhanCong;
import phanCong.TimKiemPhanCong;
import phanCong.XoaPhanCong;
import phongBan.SuaPhongBan;
import phongBan.ThemPhongBan;
import phongBan.TimKiemPhongBan;
import phongBan.XoaPhongBan;




public class XoaNhanVien extends JFrame implements ActionListener{
	private JPanel pnNorth, pnCenter, pnSouth;
	private JLabel lblTitle,lblsoLuongNV, lblmaNV, lblngaySinh, lblgioiTinh, lbldiaChi, lblmaPB, lblmaCT, lbltenNV, lblTimKiem;
	private JTextField txtmaNV, txtngaySinh, txtdiaChi, txttenNV, txtTimKiem;
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
	private JMenuItem itemTrangChu;
	private Container menuTrangChu;
	public XoaNhanVien() throws SQLException {
		// TODO Auto-generated constructor stub
		list = new listNhanVien();
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
		pnNorth.add(lblTitle = new JLabel("XO?? NH??N VI??N"));
		lblTitle.setFont(new Font("ARIAL", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);
		
		pnCenter = new JPanel(new GridBagLayout());
		
		pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		lblmaNV = new JLabel("M?? Nh??n Vi??n:");
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 30, 5, 0);
		c.gridx = 0; 
		c.gridy = 0;
		pnCenter.add(lblmaNV, c);
		
		txtmaNV = new JTextField();
		txtmaNV.setEditable(false);
		c.insets = new Insets(20, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 0;
		pnCenter.add(txtmaNV, c);
		
		lbltenNV = new JLabel("T??n Nh??n Vi??n:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		pnCenter.add(lbltenNV, c);
		
		txttenNV = new JTextField();
		txttenNV.setEditable(false);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 1;
		pnCenter.add(txttenNV, c);
		
		lblngaySinh = new JLabel("Ng??y Sinh:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		pnCenter.add(lblngaySinh, c);
		
		txtngaySinh = new JTextField();
		txtngaySinh.setEditable(false);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 2;
		pnCenter.add(txtngaySinh, c);
		
		lblgioiTinh = new JLabel("Gi???i T??nh:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 3;
		pnCenter.add(lblgioiTinh, c);
		
		cbbGender = new JComboBox();
		cbbModel = new DefaultComboBoxModel();
		cbbModel.addElement("Nam");  
		cbbModel.addElement("N???");  
		cbbGender.setModel(cbbModel);
		cbbGender.setEnabled(false);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 3;
		pnCenter.add(cbbGender, c);
		
		lbldiaChi = new JLabel("?????a Ch???:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 4;
		pnCenter.add(lbldiaChi, c);
		
		txtdiaChi = new JTextField();
		txtdiaChi.setEditable(false);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 4;
		pnCenter.add(txtdiaChi, c);
		
		lblmaPB = new JLabel("M?? Ph??ng Ban:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 5;
		pnCenter.add(lblmaPB, c);

		cbbPhongBan = new JComboBox();
		cbbPhongBan.setEnabled(false);
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 5;
		pnCenter.add(cbbPhongBan, c);
		

		c.weighty = 1;
		c.weightx = 1;
		
		pnCenter.add(new JLabel(""), c);
		
		pnSouth = new JPanel();
		JPanel pnTask = new JPanel();
		pnTask.add(btnXoa = new JButton("Xo??"));
		pnTask.add(lblTimKiem = new JLabel("Nh???p m?? ????? t??m ki???m: "));
		pnTask.add(txtTimKiem = new JTextField(10));
		pnTask.add(btnTimKiem = new JButton("T??m"));
		JPanel pnSoLuong = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnSoLuong.add(lblsoLuongNV = new JLabel());
		
		String[] header = "M?? Nh??n Vi??n,T??n Nh??n Vi??n,Ng??y Sinh, Gi???i T??nh, ?????a Ch???, M?? Ph??ng Ban".split(",");
		tbNhanVienModel = new DefaultTableModel(header,0);
		tbNhanVien = new JTable(tbNhanVienModel);
		JScrollPane scroll = new JScrollPane(tbNhanVien);
		tbNhanVien.setDefaultEditor(Object.class, null); //Kh??ng cho s???a d??? li???u tr??n b???ng
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
		lblsoLuongNV.setText("S??? l?????ng nh??n vi??n: "+ list.getSize());
		
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
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int maNV = Integer.parseInt(txtmaNV.getText());
				int ret=JOptionPane.showConfirmDialog(null,
						"B???n mu???n xo?? nh??n vi??n n??y?", "Xo??",
						JOptionPane.YES_NO_OPTION);
				if(ret==JOptionPane.YES_OPTION) {	
				try {
					list.Remove(maNV);
					JOptionPane.showMessageDialog(null, "Xo?? th??nh c??ng");
					LoadDatabase();
					ClearAll();
					lblsoLuongNV.setText("S??? l?????ng nh??n vi??n: "+ list.getSize());
					
				}catch (Exception ex) {
					// TODO: handle exception
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Kh??ng th??? xo?? Nh??n vi??n n??y v?? c??n l??m vi???c trong c??ng tr??nh");
//					ex.printStackTrace();
					
				}
				
				}
				else {
					return;
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
	
	///////////////////////////////////////////////////////
	public void ClearAll() {
			txtmaNV.setText("");
			txtngaySinh.setText("");
			txtdiaChi.setText("");
			cbbGender.setSelectedItem(("Nam"));
			txttenNV.setText("");
			cbbModelPhongBan.setSelectedItem("...");
	}
	

	public void LoadDatabase() throws SQLException {
		tbNhanVienModel.setRowCount(0);
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
					JOptionPane.showMessageDialog(null, "Kh??ng t??m th???y.");
					return;
				}
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "D??? Li???u Kh??ng H???p L???.");
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
	
	

