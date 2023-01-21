package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entities.Employee;
import models.EmployeeModel;

import java.awt.Font;
import java.util.List;
import java.awt.FlowLayout;

import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JPanelEmployee extends JPanel {
	private JTable jtableEmployee;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public JPanelEmployee() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_1);

		JLabel lblNewLabel = new JLabel("Employee List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		jtableEmployee = new JTable();
		panel.add(jtableEmployee);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 11, 311, 206);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(17, 27, 46, 14);
		panel_5.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(110, 23, 191, 26);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(17, 64, 62, 14);
		panel_5.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 60, 191, 26);
		panel_5.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(17, 101, 46, 14);
		panel_5.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(110, 97, 191, 26);
		panel_5.add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Department");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(17, 138, 83, 14);
		panel_5.add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 134, 191, 26);
		panel_5.add(textField_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Name");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(17, 173, 46, 14);
		panel_5.add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(110, 169, 191, 26);
		panel_5.add(textField_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Photo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(331, 11, 309, 197);
		panel_4.add(panel_6);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel_2);
		
		JButton jbuttonAdd = new JButton("Add");
		panel_2.add(jbuttonAdd);
		
		JButton jbuttonDelete = new JButton("Delete");
		panel_2.add(jbuttonDelete);
		
		JButton jbuttonEdit = new JButton("Edit");
		panel_2.add(jbuttonEdit);

		initJFrame();

	}

	private void initJFrame() {
		EmployeeModel employeeModel = new EmployeeModel();
		fillDataToJTable(employeeModel.findAll());
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
		for (Employee employee : employees) {
			defaultTableModel.addRow(new Object[] { employee.getId(), employee.getName(), employee.getAddress(),
					employee.getPhone(), employee.getDepartment(), employee.getUsername(), employee.getPassword(),
					employee.getCreated(), employee.isIs_admin() ? "admin" : "employee", employee.getPhoto() });
			jtableEmployee.setModel(defaultTableModel);
			jtableEmployee.getTableHeader().setReorderingAllowed(false);
		}

	}
}
