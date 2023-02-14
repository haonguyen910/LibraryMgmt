package demo;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.UIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.mindrot.jbcrypt.BCrypt;

import entities.Borrow;
import entities.Employee;
import models.BorrowModel;
import models.ConnectDB;
import models.EmployeeModel;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import java.awt.Dimension;
import javax.swing.border.EtchedBorder;

public class JPanelEmpList extends JPanel {
	private JButton jbuttonDelete;
	private JButton jbuttonEdit;
	private JButton jbuttonAdd;
	private ImageIcon imageIcon;
	private File file;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JButton jbuttonReset;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JTextField jtextFieldName;
	private JLabel lblNewLabel_1_1;
	private JTextField jtextFieldAddress;
	private JLabel lblNewLabel_1_2;
	private JTextField jtextFieldPhone;
	private JLabel lblNewLabel_1_3;
	private JTextField jtextFieldID;
	private JLabel jlablePhoto;
	private JLabel lblNewLabel_1_3_1;
	private JTextField jtextFieldEmail;
	private JLabel lblNewLabel_1_1_1;
	private JTextField jtextFieldUsername;
	private JLabel lblNewLabel_1_1_1_1;
	private JPasswordField jpasswordFieldPassword;
	private JButton jbuttonBrowse;
	private JLabel lblNewLabel_1_2_1;
	private JDateChooser jdateChooser;
	private JCheckBox jcheckboxAdmin;
	private JLabel lblNewLabel_2;
	private JPanel panel_2;
	private JButton jbuttonGetRecord;
	private JPanel panel_3;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JTable jtableEmp;
	private JTable jtableGetRecord;

	/**
	 * Create the panel.
	 */
	public JPanelEmpList() {

		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_head = new JPanel();
		panel_head.setBackground(new Color(52, 52, 52));
		FlowLayout flowLayout_1 = (FlowLayout) panel_head.getLayout();
		flowLayout_1.setVgap(15);
		add(panel_head);

		JLabel lblNewLabel = new JLabel("  Employee List");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_head.add(lblNewLabel);

		panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(15);
		add(panel_2);

		JPanel panel_body = new JPanel();
		add(panel_body);
		panel_body.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(340, 200));
		panel_body.add(panel, BorderLayout.WEST);
		panel.setLayout(null);

		jlablePhoto = new JLabel("");
		jlablePhoto.setBounds(105, 44, 150, 150);
		panel.add(jlablePhoto);
		jlablePhoto.setIconTextGap(8);
		jlablePhoto.setBorder(new LineBorder(new Color(0, 0, 0)));

		jbuttonBrowse = new JButton("Browse...");
		jbuttonBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBrowse_actionPerformed(e);
			}
		});
		jbuttonBrowse.setBounds(105, 205, 150, 30);
		panel.add(jbuttonBrowse);
		jbuttonBrowse.setPreferredSize(new Dimension(79, 30));
		jbuttonBrowse.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblNewLabel_1_3 = new JLabel("ID");
		lblNewLabel_1_3.setBounds(47, 279, 46, 22);
		panel.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtextFieldID = new JTextField();
		jtextFieldID.setBounds(131, 275, 150, 35);
		panel.add(jtextFieldID);
		jtextFieldID.setColumns(10);

		jtextFieldName = new JTextField();
		jtextFieldName.setBounds(131, 326, 150, 35);
		panel.add(jtextFieldName);
		jtextFieldName.setColumns(10);

		lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(47, 330, 46, 22);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setBounds(47, 384, 62, 22);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtextFieldAddress = new JTextField();
		jtextFieldAddress.setBounds(131, 380, 150, 35);
		panel.add(jtextFieldAddress);
		jtextFieldAddress.setColumns(10);

		lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setBounds(47, 440, 46, 22);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setBounds(131, 436, 150, 35);
		panel.add(jtextFieldPhone);
		jtextFieldPhone.setPreferredSize(new Dimension(7, 35));
		jtextFieldPhone.setColumns(10);

		lblNewLabel_1_3_1 = new JLabel("Email");
		lblNewLabel_1_3_1.setBounds(47, 492, 74, 22);
		panel.add(lblNewLabel_1_3_1);
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtextFieldEmail = new JTextField();
		jtextFieldEmail.setBounds(131, 488, 150, 35);
		panel.add(jtextFieldEmail);
		jtextFieldEmail.setColumns(10);

		lblNewLabel_1_2_1 = new JLabel("Created");
		lblNewLabel_1_2_1.setBounds(47, 541, 56, 22);
		panel.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jdateChooser = new JDateChooser();
		jdateChooser.setOpaque(false);
		jdateChooser.setBounds(131, 539, 150, 35);
		panel.add(jdateChooser);

		lblNewLabel_1_1_1 = new JLabel("Username");
		lblNewLabel_1_1_1.setBounds(47, 597, 62, 22);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setBounds(131, 593, 150, 35);
		panel.add(jtextFieldUsername);
		jtextFieldUsername.setColumns(10);

		lblNewLabel_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1.setBounds(47, 653, 62, 22);
		panel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jpasswordFieldPassword = new JPasswordField();
		jpasswordFieldPassword.setBounds(131, 649, 150, 35);
		panel.add(jpasswordFieldPassword);

		jcheckboxAdmin = new JCheckBox("Admin Authority");
		jcheckboxAdmin.setSize(new Dimension(10, 10));
		jcheckboxAdmin.setBounds(105, 701, 150, 40);
		panel.add(jcheckboxAdmin);
		jcheckboxAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_2.setBounds(10, 0, 320, 825);
		panel.add(lblNewLabel_2);

		jbuttonGetRecord = new JButton("Pending Record");
		jbuttonGetRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonGetRecord_actionPerformed(e);
			}
		});
		jbuttonGetRecord.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonGetRecord.setPreferredSize(new Dimension(89, 25));
		jbuttonGetRecord.setBounds(105, 761, 150, 35);
		panel.add(jbuttonGetRecord);

		panel_1 = new JPanel();
		panel_body.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createTitledBorder("Employee List"));
		panel_3.add(scrollPane, BorderLayout.CENTER);

		jtableEmp = new JTable();
		jtableEmp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtableEmp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableEmp_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableEmp);

		panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(BorderFactory.createTitledBorder("Pending Issue"));
		panel_4.add(scrollPane_1, BorderLayout.CENTER);

		jtableGetRecord = new JTable();
		jtableGetRecord.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_1.setViewportView(jtableGetRecord);

		JPanel panel_bottom = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_bottom.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(20);
		add(panel_bottom);

		jbuttonAdd = new JButton("Add");
		jbuttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonAdd.setPreferredSize(new Dimension(80, 30));
		jbuttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAdd_actionPerformed(e);
			}
		});
		panel_bottom.add(jbuttonAdd);

		jbuttonDelete = new JButton("Delete");
		jbuttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonDelete.setPreferredSize(new Dimension(80, 30));
		jbuttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDelete_actionPerformed(e);
			}
		});
		panel_bottom.add(jbuttonDelete);

		jbuttonEdit = new JButton("Edit");
		jbuttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonEdit.setPreferredSize(new Dimension(80, 30));
		jbuttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEdit_actionPerformed(e);
			}
		});
		panel_bottom.add(jbuttonEdit);

		jbuttonReset = new JButton("Reset");
		jbuttonReset.setPreferredSize(new Dimension(80, 30));
		jbuttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonReset_actionPerformed(e);
			}
		});
		jbuttonReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_bottom.add(jbuttonReset);

		initJFrame();

	}

	private void initJFrame() {
		EmployeeModel employeeModel = new EmployeeModel();
		setDataToTableEmp(employeeModel.findAll());
		jbuttonDelete.setEnabled(false);
		jbuttonEdit.setEnabled(false);
	}

	public void jtableEmp_mouseClicked(MouseEvent e) {
		jbuttonDelete.setEnabled(true);
		jbuttonEdit.setEnabled(true);

		try {
			int selectedRow = jtableEmp.getSelectedRow();
			String tableClick = jtableEmp.getModel().getValueAt(selectedRow, 0).toString();
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("select * from employee where id = '" + tableClick + "'");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				jtextFieldID.setText(rs.getString("id"));
				jtextFieldName.setText(rs.getString("name"));
				jtextFieldAddress.setText(rs.getString("address"));
				jtextFieldPhone.setText(rs.getString("phone"));
				jtextFieldEmail.setText(rs.getString("email"));
				jdateChooser.setDate(rs.getDate("created"));
				jtextFieldUsername.setText(rs.getString("username"));
				jcheckboxAdmin.setSelected(rs.getBoolean("is_admin"));
				jpasswordFieldPassword.setText(rs.getString("password"));
				byte[] imageData = rs.getBytes("photo");
				ImageIcon photo = new ImageIcon(new ImageIcon(imageData).getImage()
						.getScaledInstance(jlablePhoto.getWidth(), jlablePhoto.getHeight(), Image.SCALE_DEFAULT));
				jlablePhoto.setIcon(photo);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void jbuttonAdd_actionPerformed(ActionEvent e) {
		try {
			Employee employee = new Employee();
			employee.setName(jtextFieldName.getText().trim());
			employee.setAddress(jtextFieldAddress.getText());
			employee.setPhone(jtextFieldPhone.getText());
			employee.setEmail(jtextFieldEmail.getText());
			employee.setUsername(jtextFieldUsername.getText());
			String password = new String(jpasswordFieldPassword.getPassword());
			employee.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
			employee.setCreated(jdateChooser.getDate());
			employee.setIs_admin(jcheckboxAdmin.isSelected());
			if (file != null) {
				employee.setPhoto(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
			}
			EmployeeModel employeeModel = new EmployeeModel();
			if (employeeModel.create(employee)) {
				JOptionPane.showMessageDialog(this, "Saved");
				setDataToTableEmp(employeeModel.findAll());
			} else {
				JOptionPane.showMessageDialog(this, "Failed, please try again");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}

	public void jbuttonEdit_actionPerformed(ActionEvent e) {
		String sql = "update employee set name = ?, address = ?, phone = ?, email = ?, username = ?, is_admin = ?, created = ?, photo = ? where id = ?";
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(sql);
			ps.setString(1, jtextFieldName.getText());
			ps.setString(2, jtextFieldAddress.getText());
			ps.setString(3, jtextFieldPhone.getText());
			ps.setString(4, jtextFieldEmail.getText());
			ps.setString(5, jtextFieldUsername.getText());
			ps.setBoolean(6, jcheckboxAdmin.isSelected());
			ps.setDate(7, new java.sql.Date(jdateChooser.getDate().getTime()));
			ps.setBytes(8, Files.readAllBytes(Paths.get(file.getAbsolutePath())));
			ps.setString(9, jtextFieldID.getText());
			ps.executeUpdate();
			EmployeeModel employeeModel = new EmployeeModel();
			setDataToTableEmp(employeeModel.findAll());
			JOptionPane.showMessageDialog(this, "Updated");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}

	public void jbuttonDelete_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			int selectedRow = jtableEmp.getSelectedRow();
			int id = Integer.parseInt(jtableEmp.getValueAt(selectedRow, 0).toString());
			EmployeeModel employeeModel = new EmployeeModel();
			if (employeeModel.delete(id)) {
				setDataToTableEmp(employeeModel.findAll());
				jbuttonDelete.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(this, "Can not delete, please check issue history");
			}
		}
	}

	public void jbuttonReset_actionPerformed(ActionEvent e) {
		jtextFieldID.setText(null);
		jtextFieldName.setText(null);
		jtextFieldAddress.setText(null);
		jtextFieldPhone.setText(null);
		jtextFieldEmail.setText(null);
		jtextFieldUsername.setText(null);
		jdateChooser.setDate(null);
		jpasswordFieldPassword.setText(null);
		jlablePhoto.setIcon(null);
		jcheckboxAdmin.setSelected(false);
	}

	public void jbuttonBrowse_actionPerformed(ActionEvent e) {
		JFileChooser jfileChooser = new JFileChooser("C:\\Users\\admin\\Desktop\\Image");
		jfileChooser.setDialogTitle("Select a Photo");
		jfileChooser.setMultiSelectionEnabled(false);
		int result = jfileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = jfileChooser.getSelectedFile();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage()
					.getScaledInstance(jlablePhoto.getWidth(), jlablePhoto.getHeight(), Image.SCALE_DEFAULT));
			jlablePhoto.setIcon(imageIcon);
		}
	}

	public void jbuttonGetRecord_actionPerformed(ActionEvent e) {
		int employeeID = Integer.parseInt(jtextFieldID.getText());
		BorrowModel borrowModel = new BorrowModel();
		setDataToTableRecord(borrowModel.findByEmpIdForRecord(employeeID));
	}

// SET DATA
	private void setDataToTableEmp(List<Employee> employees) {

		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Phone");
		defaultTableModel.addColumn("Email");
		defaultTableModel.addColumn("Username");
		defaultTableModel.addColumn("Password");
		defaultTableModel.addColumn("Created");
		defaultTableModel.addColumn("Role");
		defaultTableModel.addColumn("Photo");
		;
		for (Employee employee : employees) {
			defaultTableModel.addRow(new Object[] { employee.getId(), employee.getName(), employee.getAddress(),
					employee.getPhone(), employee.getEmail(), employee.getUsername(), employee.getPassword(),
					simpleDateFormat.format(employee.getCreated()), employee.isIs_admin() ? "admin" : "employee",
					employee.getPhoto() });
			jtableEmp.setModel(defaultTableModel);
			jtableEmp.setRowHeight(30);
			jtableEmp.getTableHeader().setReorderingAllowed(false);
			jtableEmp.getColumnModel().getColumn(9).setCellRenderer(new ImageCellRender());
		}
		
		HeaderRenderer header = new HeaderRenderer(jtableEmp.getTableHeader().getDefaultRenderer());
		for (int i = 0; i < jtableEmp.getModel().getColumnCount(); i++) {
			jtableEmp.getColumnModel().getColumn(i).setHeaderRenderer(header);
		}
	}

	private class ImageCellRender extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JLabel jlabel = new JLabel();
			byte[] bytes = (byte[]) value;
			imageIcon = new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			jlabel.setIcon(imageIcon);
			return jlabel;
		}
	}

	private void setDataToTableRecord(List<Borrow> borrowList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		defaultTableModel.addColumn("Issue ID");
		defaultTableModel.addColumn("Book Title");
		defaultTableModel.addColumn("Issue Day");
		defaultTableModel.addColumn("Due Date");
		defaultTableModel.addColumn("Customer ID");
		defaultTableModel.addColumn("Deposit");
		defaultTableModel.addColumn("Status");
		;
		for (Borrow borrow : borrowList) {
			defaultTableModel.addRow(
					new Object[] { borrow.getId(), borrow.getBookTitle(), borrow.getCreated(), borrow.getDue_date(),
							borrow.getId_customer(), borrow.getDeposit(), borrow.isStatus() ? "Returned" : "Pending" });
			jtableGetRecord.setModel(defaultTableModel);
			jtableGetRecord.setRowHeight(30);
			jtableGetRecord.getTableHeader().setReorderingAllowed(false);
		}

		HeaderRenderer header = new HeaderRenderer(jtableGetRecord.getTableHeader().getDefaultRenderer());
		for (int i = 0; i < jtableGetRecord.getModel().getColumnCount(); i++) {
			jtableGetRecord.getColumnModel().getColumn(i).setHeaderRenderer(header);
		}
	}

	public class HeaderRenderer implements UIResource, TableCellRenderer {
		private TableCellRenderer original;
		
		public HeaderRenderer(TableCellRenderer original) {
			this.original = original;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component comp = original.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			comp.setFont(comp.getFont().deriveFont(Font.BOLD, 15));
			comp.setForeground(new Color(70, 68, 98));
			return comp;
		}
	}
}