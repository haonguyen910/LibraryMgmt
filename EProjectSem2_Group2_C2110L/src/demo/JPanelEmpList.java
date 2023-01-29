package demo;

import javax.swing.JPanel;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.mindrot.jbcrypt.BCrypt;

import entities.Employee;
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
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import java.awt.Dimension;

public class JPanelEmpList extends JPanel {
	private JButton jbuttonDelete;
	private JButton jbuttonEdit;
	private JButton jbuttonAdd;
	private ImageIcon imageIcon;
	private JTable jtableEmp;
	private JTextField jtextFieldName;
	private JTextField jtextFieldAddress;
	private JTextField jtextFieldPhone;
	private JTextField jtextFieldID;
	private JTextField jtextFieldDepartment;
	private JTextField jtextFieldUsername;
	private JPasswordField jpasswordFieldPassword;
	private JButton jbuttonBrowse;
	private File file;
	private JLabel jlablePhoto;
	private JDateChooser jdateChooser;
	private JCheckBox jcheckboxAdmin;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JButton jbuttonReset;

	/**
	 * Create the panel.
	 */
	public JPanelEmpList() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_head = new JPanel();
		panel_head.setBackground(new Color(128, 128, 192));
		FlowLayout flowLayout_1 = (FlowLayout) panel_head.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel_head);

		JLabel lblNewLabel = new JLabel("Employee List");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_head.add(lblNewLabel);

		JPanel panel_body = new JPanel();
		add(panel_body);
		panel_body.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_body.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 850, 250);
		panel.add(scrollPane);

		jtableEmp = new JTable();
		jtableEmp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableEmp_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableEmp);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 272, 850, 250);
		panel.add(panel_5);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(274, 82, 46, 22);
		panel_5.add(lblNewLabel_1);

		jtextFieldName = new JTextField();
		jtextFieldName.setColumns(10);
		jtextFieldName.setBounds(330, 82, 150, 26);
		panel_5.add(jtextFieldName);

		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(258, 115, 62, 22);
		panel_5.add(lblNewLabel_1_1);

		jtextFieldAddress = new JTextField();
		jtextFieldAddress.setColumns(10);
		jtextFieldAddress.setBounds(330, 115, 150, 26);
		panel_5.add(jtextFieldAddress);

		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(274, 152, 46, 22);
		panel_5.add(lblNewLabel_1_2);

		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setColumns(10);
		jtextFieldPhone.setBounds(330, 152, 150, 26);
		panel_5.add(jtextFieldPhone);

		JLabel lblNewLabel_1_5 = new JLabel("ID");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(274, 45, 46, 22);
		panel_5.add(lblNewLabel_1_5);

		jtextFieldID = new JTextField();
		jtextFieldID.setColumns(10);
		jtextFieldID.setBounds(330, 45, 150, 26);
		panel_5.add(jtextFieldID);

		jlablePhoto = new JLabel("");
		jlablePhoto.setIconTextGap(8);
		jlablePhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlablePhoto.setBounds(60, 34, 150, 150);
		panel_5.add(jlablePhoto);

		JLabel lblNewLabel_1_3 = new JLabel("Department");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(529, 45, 86, 22);
		panel_5.add(lblNewLabel_1_3);

		jtextFieldDepartment = new JTextField();
		jtextFieldDepartment.setColumns(10);
		jtextFieldDepartment.setBounds(625, 45, 150, 26);
		panel_5.add(jtextFieldDepartment);

		JLabel lblNewLabel_1_1_1 = new JLabel("Username");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(553, 118, 62, 22);
		panel_5.add(lblNewLabel_1_1_1);

		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setColumns(10);
		jtextFieldUsername.setBounds(625, 118, 150, 26);
		panel_5.add(jtextFieldUsername);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(553, 155, 62, 22);
		panel_5.add(lblNewLabel_1_1_1_1);

		jpasswordFieldPassword = new JPasswordField();
		jpasswordFieldPassword.setBounds(625, 157, 150, 26);
		panel_5.add(jpasswordFieldPassword);

		jbuttonBrowse = new JButton("Browse...");
		jbuttonBrowse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jbuttonBrowse.setPreferredSize(new Dimension(79, 30));
		jbuttonBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBrowse_actionPerformed(e);
			}
		});
		jbuttonBrowse.setBounds(60, 195, 150, 30);
		panel_5.add(jbuttonBrowse);

		JLabel lblNewLabel_1_2_1 = new JLabel("Created");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(559, 82, 56, 22);
		panel_5.add(lblNewLabel_1_2_1);

		jdateChooser = new JDateChooser();
		jdateChooser.setBounds(625, 82, 150, 26);
		panel_5.add(jdateChooser);

		jcheckboxAdmin = new JCheckBox("Admin Authority");
		jcheckboxAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jcheckboxAdmin.setBounds(591, 192, 152, 23);
		panel_5.add(jcheckboxAdmin);

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
		fillDataToJTable(employeeModel.findAll());
		jbuttonDelete.setEnabled(false);
		jbuttonEdit.setEnabled(false);
	}

	public void jtableEmp_mouseClicked(MouseEvent e) {
		jbuttonDelete.setEnabled(true);
		jbuttonEdit.setEnabled(true);

		try {
			int selectedRow = jtableEmp.getSelectedRow();
			String tableClick = jtableEmp.getModel().getValueAt(selectedRow, 0).toString();
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from employee where id = '" + tableClick + "'");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				jtextFieldID.setText(rs.getString("id"));
				jtextFieldName.setText(rs.getString("name"));
				jtextFieldAddress.setText(rs.getString("address"));
				jtextFieldPhone.setText(rs.getString("phone"));
				jtextFieldDepartment.setText(rs.getString("department"));
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

	public void jbuttonAdd_actionPerformed(ActionEvent e) {
		try {
			Employee employee = new Employee();
			employee.setName(jtextFieldName.getText().trim());
			employee.setAddress(jtextFieldAddress.getText());
			employee.setPhone(jtextFieldPhone.getText());
			employee.setDepartment(jtextFieldDepartment.getText());
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
				fillDataToJTable(employeeModel.findAll());
			} else {
				JOptionPane.showMessageDialog(this, "Failed, please try again");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}

	public void jbuttonEdit_actionPerformed(ActionEvent e) {
		String sql = "update employee set name = ?, address = ?, phone = ?, department = ?, username = ?, is_admin = ?, created = ?, photo = ? where id = ?";
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(sql);
			ps.setString(1, jtextFieldName.getText());
			ps.setString(2, jtextFieldAddress.getText());
			ps.setString(3, jtextFieldPhone.getText());
			ps.setString(4, jtextFieldDepartment.getText());
			ps.setString(5, jtextFieldUsername.getText());
			ps.setBoolean(6, jcheckboxAdmin.isSelected());
			ps.setDate(7, new java.sql.Date(jdateChooser.getDate().getTime()));
			ps.setBytes(8, Files.readAllBytes(Paths.get(file.getAbsolutePath())));
			ps.setString(9, jtextFieldID.getText());
			ps.executeUpdate();
			EmployeeModel employeeModel = new EmployeeModel();
			fillDataToJTable(employeeModel.findAll());
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
				fillDataToJTable(employeeModel.findAll());
				jbuttonDelete.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(this, "Please try again");
			}
		}
	}

	public void jbuttonReset_actionPerformed(ActionEvent e) {
		jtextFieldID.setText(null);
		jtextFieldName.setText(null);
		jtextFieldAddress.setText(null);
		jtextFieldPhone.setText(null);
		jtextFieldDepartment.setText(null);
		jtextFieldUsername.setText(null);
		jdateChooser.setDate(null);
		jpasswordFieldPassword.setText(null);
		jlablePhoto.setIcon(null);
		jcheckboxAdmin.setSelected(false);
	}

	private void fillDataToJTable(List<Employee> employees) {

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
		defaultTableModel.addColumn("Department");
		defaultTableModel.addColumn("Username");
		defaultTableModel.addColumn("Password");
		defaultTableModel.addColumn("Created");
		defaultTableModel.addColumn("Role");
		defaultTableModel.addColumn("Photo");
		;
		for (Employee employee : employees) {
			defaultTableModel.addRow(new Object[] { employee.getId(), employee.getName(), employee.getAddress(),
					employee.getPhone(), employee.getDepartment(), employee.getUsername(), employee.getPassword(),
					simpleDateFormat.format(employee.getCreated()), employee.isIs_admin() ? "admin" : "employee", employee.getPhoto() });
			jtableEmp.setModel(defaultTableModel);
			jtableEmp.setRowHeight(40);
			jtableEmp.getTableHeader().setReorderingAllowed(false);
			jtableEmp.getColumnModel().getColumn(9).setCellRenderer(new ImageCellRender());
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
}