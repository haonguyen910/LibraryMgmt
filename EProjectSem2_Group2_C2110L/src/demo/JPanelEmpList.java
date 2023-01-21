package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entities.Employee;
import models.EmployeeModel;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class JPanelEmpList extends JPanel {
	private JButton jbuttonDelete;
	private JButton jbuttonEdit;
	private JButton jbuttonAdd;
	private ImageIcon imageIcon;
	private JTable jtableEmp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public JPanelEmpList() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel_head = new JPanel();
		panel_head.setBackground(new Color(255, 128, 0));
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
		scrollPane.setBounds(10, 11, 708, 250);
		panel.add(scrollPane);
		
		jtableEmp = new JTable();
		scrollPane.setViewportView(jtableEmp);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 272, 708, 257);
		panel.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(191, 79, 46, 22);
		panel_5.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(247, 79, 150, 26);
		panel_5.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(175, 112, 62, 22);
		panel_5.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(247, 112, 150, 26);
		panel_5.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(191, 149, 46, 22);
		panel_5.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(247, 149, 150, 26);
		panel_5.add(textField_2);
		
		JLabel lblNewLabel_1_5 = new JLabel("ID");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(191, 42, 46, 22);
		panel_5.add(lblNewLabel_1_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(247, 42, 150, 26);
		panel_5.add(textField_5);
		
		JLabel jlablePhoto = new JLabel("");
		jlablePhoto.setBorder(new TitledBorder(null, "Photo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jlablePhoto.setBounds(24, 33, 150, 150);
		panel_5.add(jlablePhoto);
		
		JLabel lblNewLabel_1_3 = new JLabel("Department");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(432, 42, 86, 22);
		panel_5.add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(528, 42, 150, 26);
		panel_5.add(textField_3);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Role");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5_1.setBounds(472, 79, 46, 22);
		panel_5.add(lblNewLabel_1_5_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(528, 79, 76, 22);
		panel_5.add(comboBox);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Username");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(456, 112, 62, 22);
		panel_5.add(lblNewLabel_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(528, 112, 150, 26);
		panel_5.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(456, 149, 62, 22);
		panel_5.add(lblNewLabel_1_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(528, 151, 150, 26);
		panel_5.add(passwordField);
		
		JPanel panel_bottom = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_bottom.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_bottom);
		
		jbuttonAdd = new JButton("Create");
		jbuttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAdd_actionPerformed(e);
			}
		});
		panel_bottom.add(jbuttonAdd);
		
		jbuttonDelete = new JButton("Delete");
		jbuttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDelete_actionPerformed(e);
			}
		});
		panel_bottom.add(jbuttonDelete);
		
		jbuttonEdit = new JButton("Edit");
		jbuttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEdit_actionPerformed(e);
			}
		});
		panel_bottom.add(jbuttonEdit);
		
		JButton jbuttonReset = new JButton("Reset");
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
	
	public void jbuttonAdd_actionPerformed(ActionEvent e) {
		JFrameEmpAdd jframeAddEmp = new JFrameEmpAdd();
		jframeAddEmp.setVisible(true);
	}
	
	public void jbuttonEdit_actionPerformed(ActionEvent e) {
		int selectedRow = jtableEmp.getSelectedRow();
		int id = Integer.parseInt(jtableEmp.getValueAt(selectedRow, 0).toString());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);
		JFrameEmpEdit jframeEditEmp = new JFrameEmpEdit(data);
		jframeEditEmp.setVisible(true);
	}  
	
	public void jbuttonDelete_actionPerformed(ActionEvent e) {
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
		defaultTableModel.addColumn("Photo");;
		for (Employee employee : employees) {
			defaultTableModel.addRow(new Object[] { employee.getId(), employee.getName(), employee.getAddress(),
					employee.getPhone(), employee.getDepartment(), employee.getUsername(), employee.getPassword(),
					employee.getCreated(), employee.isIs_admin() ? "admin" : "employee", employee.getPhoto() });
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
