package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Borrow;
import entities.Customer;
import models.BookModel;
import models.BorrowModel;
import models.ConnectDB;
import models.CustomerModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class JPanelCustmList extends JPanel {
	private JPanel panel_body;
	private JTable jtableCust;
	private JTextField jtextFieldSearch;
	private JTable jtableIGetHistory;
	private JTextField jtextFieldID;
	private JTextField jtextFieldAddress;
	private JTextField jtextFieldPhone;
	private JButton jbuttonDelete;
	private JButton jbuttonEdit;
	private JButton jbuttonReset;
	private JButton jbuttonAdd;
	private JDateChooser jdateChooser;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField jtextFieldName;
	private JButton jbuttonSearch;

	/**
	 * Create the panel.
	 */
	public JPanelCustmList() {

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
		FlowLayout flowLayout_1 = (FlowLayout) panel_head_2.getLayout();
		flowLayout_1.setHgap(15);
		add(panel_head_2);

		jtextFieldSearch = new JTextField();
		jtextFieldSearch.setPreferredSize(new Dimension(250, 30));
		jtextFieldSearch.setColumns(20);
		panel_head_2.add(jtextFieldSearch);

		jbuttonSearch = new JButton("Find by Name");
		jbuttonSearch.setPreferredSize(new Dimension(120, 30));
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});
		jbuttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_head_2.add(jbuttonSearch);

		panel_body = new JPanel();
		add(panel_body);
		panel_body.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_body.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 850, 250);
		panel.add(scrollPane);

		jtableCust = new JTable();
		jtableCust.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableCustList_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableCust);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(null, "History", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_1.setBounds(430, 272, 430, 183);
		panel.add(scrollPane_1);

		jtableIGetHistory = new JTable();
		scrollPane_1.setViewportView(jtableIGetHistory);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 272, 410, 183);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(27, 28, 36, 25);
		panel_2.add(lblNewLabel_1);

		jtextFieldID = new JTextField();
		jtextFieldID.setBounds(73, 28, 120, 25);
		panel_2.add(jtextFieldID);
		jtextFieldID.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 119, 53, 25);
		panel_2.add(lblNewLabel_1_1);

		jtextFieldAddress = new JTextField();
		jtextFieldAddress.setColumns(10);
		jtextFieldAddress.setBounds(73, 119, 120, 25);
		panel_2.add(jtextFieldAddress);

		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(213, 28, 46, 25);
		panel_2.add(lblNewLabel_1_2);

		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setColumns(10);
		jtextFieldPhone.setBounds(269, 30, 125, 25);
		panel_2.add(jtextFieldPhone);

		JLabel lblNewLabel_1_2_1 = new JLabel("Created");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(203, 75, 57, 25);
		panel_2.add(lblNewLabel_1_2_1);

		jdateChooser = new JDateChooser();
		jdateChooser.setBounds(269, 75, 125, 25);
		panel_2.add(jdateChooser);

		JLabel lblNewLabel_1_3 = new JLabel("Name");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(27, 75, 36, 25);
		panel_2.add(lblNewLabel_1_3);

		jtextFieldName = new JTextField();
		jtextFieldName.setColumns(10);
		jtextFieldName.setBounds(73, 75, 120, 25);
		panel_2.add(jtextFieldName);

		JButton jbuttonGetHistory = new JButton("Get History");
		jbuttonGetHistory.setPreferredSize(new Dimension(80, 25));
		jbuttonGetHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonGetHistory_actionPerformed(e);
			}
		});
		jbuttonGetHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonGetHistory.setBounds(232, 126, 149, 35);
		panel_2.add(jbuttonGetHistory);

		JPanel panel_bottom = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_bottom.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(20);
		add(panel_bottom);

		jbuttonAdd = new JButton("Add");
		jbuttonAdd.setPreferredSize(new Dimension(80, 30));
		jbuttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAdd_actionPerformed(e);
			}
		});
		jbuttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_bottom.add(jbuttonAdd);

		jbuttonDelete = new JButton("Delete");
		jbuttonDelete.setPreferredSize(new Dimension(80, 30));
		jbuttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDelete_actionPerformed(e);
			}
		});
		jbuttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonDelete.setEnabled(false);
		panel_bottom.add(jbuttonDelete);

		jbuttonEdit = new JButton("Edit");
		jbuttonEdit.setPreferredSize(new Dimension(80, 30));
		jbuttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEdit_actionPerformed(e);
			}
		});
		jbuttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonEdit.setEnabled(false);
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
		CustomerModel customerModel = new CustomerModel();
		setDataToTableCust(customerModel.findAll());
	}

	public void jtableCustList_mouseClicked(MouseEvent e) {
		jbuttonDelete.setEnabled(true);
		jbuttonEdit.setEnabled(true);

		try {
			int selectedRow = jtableCust.getSelectedRow();
			String id = jtableCust.getValueAt(selectedRow, 0).toString();
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("select * from customer where id = '" + id + "'");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				jtextFieldID.setText(rs.getString("id"));
				jtextFieldName.setText(rs.getString("name"));
				jtextFieldAddress.setText(rs.getString("address"));
				jtextFieldPhone.setText(rs.getString("phone"));
				jdateChooser.setDate(rs.getDate("created"));
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public void jbuttonSearch_actionPerformed(ActionEvent e) {
		String search = jtextFieldSearch.getText().trim();
		CustomerModel customerModel = new CustomerModel();
		setDataToTableCust(customerModel.findByName(search));
	}

	public void jbuttonAdd_actionPerformed(ActionEvent e) {
		try {
			Customer customer = new Customer();
			customer.setName(jtextFieldID.getText().trim());
			customer.setAddress(jtextFieldAddress.getText());
			customer.setPhone(jtextFieldPhone.getText());
			customer.setCreated(jdateChooser.getDate());
			CustomerModel customerModel = new CustomerModel();
			if (customerModel.create(customer)) {
				JOptionPane.showMessageDialog(this, "Created");
				setDataToTableCust(customerModel.findAll());
			} else {
				JOptionPane.showMessageDialog(this, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}

	public void jbuttonDelete_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(this, "Do you want to delete?", "Confirm",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			int selectedRow = jtableCust.getSelectedRow();
			int id = Integer.parseInt(jtableCust.getValueAt(selectedRow, 0).toString());
			try {
				PreparedStatement ps = ConnectDB.connection()
						.prepareStatement("delete from customer where id = '" + id + "'");
				ps.executeUpdate();
				CustomerModel customerModel = new CustomerModel();
				setDataToTableCust(customerModel.findAll());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please try again");
		}

	}

	public void jbuttonEdit_actionPerformed(ActionEvent e) {
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("update customer set name = ?, address = ?, phone = ?, created = ? where id = ?");
			ps.setString(1, jtextFieldName.getText());
			ps.setString(2, jtextFieldAddress.getText());
			ps.setString(3, jtextFieldPhone.getText());
			ps.setDate(4, new java.sql.Date(jdateChooser.getDate().getTime()));
			ps.setString(5, jtextFieldID.getText());
			ps.executeUpdate();
			CustomerModel customerModel = new CustomerModel();
			setDataToTableCust(customerModel.findAll());
			JOptionPane.showMessageDialog(this, "UPDATED");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public void jbuttonReset_actionPerformed(ActionEvent e) {
		jtextFieldAddress.setText(null);
		jtextFieldID.setText(null);
		jtextFieldName.setText(null);
		jtextFieldPhone.setText(null);
		jdateChooser.setDate(null);
	}

	public void jbuttonGetHistory_actionPerformed(ActionEvent e) {
		int customerId = Integer.parseInt(jtextFieldID.getText());
		BorrowModel borrowModel = new BorrowModel();
		setDataToTableGetHistory(borrowModel.findByCustomerIdForHistory(customerId));
	}

	private void setDataToTableCust(List<Customer> customers) {
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
					customer.getPhone(), simpleDateFormat.format(customer.getCreated()) });
			jtableCust.setModel(defaultTableModel);
			jtableCust.setRowHeight(40);
			jtableCust.getTableHeader().setReorderingAllowed(false);
			;
		}
	}

	private void setDataToTableGetHistory(List<Borrow> borrowList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		defaultTableModel.addColumn("Call Number");
		defaultTableModel.addColumn("Issue Date");
		defaultTableModel.addColumn("Due Date");
		defaultTableModel.addColumn("Status");
		for (Borrow borrow : borrowList) {
			defaultTableModel.addRow(new Object[] { borrow.getCallNumber(), borrow.getCreated(), borrow.getDue_date(),
					borrow.isStatus() ? "Pending" : "Returned" });
			jtableIGetHistory.setModel(defaultTableModel);
			jtableIGetHistory.getTableHeader().setReorderingAllowed(false);
		}
	}
}