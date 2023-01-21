package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Customer;
import models.CustomerModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class JPanelCustList extends JPanel {
	private JPanel panel_body;
	private JTable jtableCustList;
	private JTextField textField;
	private JTable jtableIssueHistory;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public JPanelCustList() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_head_1 = new JPanel();
		panel_head_1.setBackground(new Color(255, 128, 0));
		FlowLayout fl_panel_head_1 = (FlowLayout) panel_head_1.getLayout();
		fl_panel_head_1.setAlignment(FlowLayout.LEFT);
		add(panel_head_1);

		JLabel lblNewLabel = new JLabel("Customer List");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_head_1.add(lblNewLabel);
		
		JPanel panel_head_2 = new JPanel();
		add(panel_head_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_head_2.add(textField);
		
		JButton jbuttonSearch = new JButton("Find by Name");
		jbuttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_head_2.add(jbuttonSearch);

		panel_body = new JPanel();
		add(panel_body);
		panel_body.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_body.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 768, 194);
		panel.add(scrollPane);

		jtableCustList = new JTable();
		scrollPane.setViewportView(jtableCustList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(null, "History", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_1.setBounds(307, 216, 471, 183);
		panel.add(scrollPane_1);
		
		jtableIssueHistory = new JTable();
		scrollPane_1.setViewportView(jtableIssueHistory);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 216, 287, 183);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(27, 26, 46, 25);
		panel_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(93, 28, 170, 25);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 60, 63, 25);
		panel_2.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(93, 62, 170, 25);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(27, 98, 46, 25);
		panel_2.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(93, 100, 170, 25);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Created");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(17, 134, 57, 25);
		panel_2.add(lblNewLabel_1_2_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(93, 134, 170, 25);
		panel_2.add(dateChooser);

		JPanel panel_bottom = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_bottom.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_bottom);

		JButton jbuttonCreate = new JButton("Create");
		jbuttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCreate_actionPerformed(e);
			}
		});
		jbuttonCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_bottom.add(jbuttonCreate);

		JButton jbuttonDelete = new JButton("Delete");
		jbuttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDelete_actionPerformed(e);
			}
		});
		jbuttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonDelete.setEnabled(false);
		panel_bottom.add(jbuttonDelete);

		JButton jbuttonEdit = new JButton("Edit");
		jbuttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEdit_actionPerformed(e);
			}
		});
		jbuttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonEdit.setEnabled(false);
		panel_bottom.add(jbuttonEdit);

		JButton jbuttonReset = new JButton("Reset");
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
		CustomerModel customerModel = new CustomerModel();
		fillDataToJTable(customerModel.findAll());
	}

	public void jbuttonCreate_actionPerformed(ActionEvent e) {
	}

	public void jbuttonDelete_actionPerformed(ActionEvent e) {
	}

	public void jbuttonEdit_actionPerformed(ActionEvent e) {
	}

	public void jbuttonReset_actionPerformed(ActionEvent e) {
	}

	private void fillDataToJTable(List<Customer> customers) {
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
		defaultTableModel.addColumn("Created");
		for (Customer customer : customers) {
			defaultTableModel.addRow(new Object[] { customer.getId(), customer.getName(), customer.getAddress(),
					customer.getPhone(), customer.getCreated()});
			jtableCustList.setModel(defaultTableModel);
			jtableCustList.setRowHeight(40);
			jtableCustList.getTableHeader().setReorderingAllowed(false);
			;
		}

	}
}
