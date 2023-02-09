package demo;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entities.Borrow;
import entities.Customer;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.border.EtchedBorder;

public class JPanelCustmList extends JPanel {
	private JPanel panel_body;
	private JTextField jtextFieldSearch;
	private JButton jbuttonDelete;
	private JButton jbuttonEdit;
	private JButton jbuttonReset;
	private JButton jbuttonAdd;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JButton jbuttonSearch;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField jtextFieldID;
	private JTable jtableCust;
	private JTable jtableGetHistory;
	private JDateChooser jdateChooser;
	private JTextField jtextFieldName;
	private JTextField jtextFieldAddress;
	private JTextField jtextFieldPhone;
	private JLabel lblNewLabel_2;

	/**
	 * Create the panel.
	 */
	public JPanelCustmList() {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_head_1 = new JPanel();
		panel_head_1.setBackground(new Color(51, 51, 51));
		FlowLayout fl_panel_head_1 = (FlowLayout) panel_head_1.getLayout();
		add(panel_head_1);

		JLabel lblNewLabel = new JLabel("Customer List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_head_1.add(lblNewLabel);

		JPanel panel_head_2 = new JPanel();
		panel_head_2.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_1 = (FlowLayout) panel_head_2.getLayout();
		flowLayout_1.setVgap(30);
		flowLayout_1.setHgap(15);
		add(panel_head_2);

		jtextFieldSearch = new JTextField();
		jtextFieldSearch.setPreferredSize(new Dimension(250, 35));
		jtextFieldSearch.setColumns(20);
		panel_head_2.add(jtextFieldSearch);

		jbuttonSearch = new JButton("Enter Name");
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

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setPreferredSize(new Dimension(340, 220));
		panel.setMinimumSize(new Dimension(500, 500));
		panel_body.add(panel, BorderLayout.WEST);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(65, 46, 36, 25);
		panel.add(lblNewLabel_1);

		jtextFieldID = new JTextField();
		jtextFieldID.setMinimumSize(new Dimension(10, 20));
		jtextFieldID.setPreferredSize(new Dimension(10, 40));
		jtextFieldID.setColumns(10);
		jtextFieldID.setBounds(128, 43, 150, 35);
		panel.add(jtextFieldID);

		JLabel lblNewLabel_1_3 = new JLabel("Name");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(65, 102, 36, 25);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(65, 158, 53, 25);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(65, 216, 46, 25);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Created");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(65, 274, 57, 25);
		panel.add(lblNewLabel_1_2_1);

		jdateChooser = new JDateChooser();
		jdateChooser.setOpaque(false);
		jdateChooser.setPreferredSize(new Dimension(7, 40));
		jdateChooser.setBounds(128, 271, 150, 35);
		panel.add(jdateChooser);

		JButton jbuttonGetHistory = new JButton("Get History");
		jbuttonGetHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonGetHistory_actionPerformed(e);
			}
		});
		jbuttonGetHistory.setPreferredSize(new Dimension(80, 25));
		jbuttonGetHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonGetHistory.setBounds(95, 337, 157, 35);
		panel.add(jbuttonGetHistory);
		
		jtextFieldName = new JTextField();
		jtextFieldName.setPreferredSize(new Dimension(10, 40));
		jtextFieldName.setMinimumSize(new Dimension(10, 20));
		jtextFieldName.setColumns(10);
		jtextFieldName.setBounds(128, 99, 150, 35);
		panel.add(jtextFieldName);
		
		jtextFieldAddress = new JTextField();
		jtextFieldAddress.setPreferredSize(new Dimension(10, 40));
		jtextFieldAddress.setMinimumSize(new Dimension(10, 20));
		jtextFieldAddress.setColumns(10);
		jtextFieldAddress.setBounds(128, 155, 150, 35);
		panel.add(jtextFieldAddress);
		
		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setPreferredSize(new Dimension(10, 40));
		jtextFieldPhone.setMinimumSize(new Dimension(10, 20));
		jtextFieldPhone.setColumns(10);
		jtextFieldPhone.setBounds(128, 213, 150, 35);
		panel.add(jtextFieldPhone);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new TitledBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_2.setBounds(10, 0, 320, 403);
		panel.add(lblNewLabel_2);

		panel_1 = new JPanel();
		panel_body.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createTitledBorder ("Customer List"));
		panel_2.add(scrollPane, BorderLayout.CENTER);

		jtableCust = new JTable();
		jtableCust.setSelectionBackground(new Color(255, 51, 51));
		jtableCust.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableCustList_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableCust);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(BorderFactory.createTitledBorder ("Issue History"));
		scrollPane_1.setBackground(new Color(255, 255, 255));
		panel_3.add(scrollPane_1, BorderLayout.CENTER);

		jtableGetHistory = new JTable();
		jtableGetHistory.setSelectionBackground(new Color(255, 51, 51));
		scrollPane_1.setViewportView(jtableGetHistory);

		JPanel panel_bottom = new JPanel();
		panel_bottom.setBackground(new Color(255, 255, 255));
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
	
	public void jbuttonGetHistory_actionPerformed(ActionEvent e) {
		int customerId = Integer.parseInt(jtextFieldID.getText());
		BorrowModel borrowModel = new BorrowModel();
		setDataToTableGetHistory(borrowModel.findByCustomerIdForHistory(customerId));
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
		jtextFieldSearch.setText(null);
		jtextFieldAddress.setText(null);
		jtextFieldID.setText(null);
		jtextFieldName.setText(null);
		jtextFieldPhone.setText(null);
		jdateChooser.setDate(null);
		DefaultTableModel defaultTableModel = (DefaultTableModel) jtableGetHistory.getModel();
		defaultTableModel.setRowCount(0);
	}

// SET DATA

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
		}
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(102, 102, 255));
		headerRenderer.setForeground(new Color(255, 255, 255));

		for (int i = 0; i < jtableCust.getModel().getColumnCount(); i++) {
			jtableCust.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		}
	}

	private void setDataToTableGetHistory(List<Borrow> borrowList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		defaultTableModel.addColumn("Issue ID");
		defaultTableModel.addColumn("Book Title");
		defaultTableModel.addColumn("Issue Date");
		defaultTableModel.addColumn("Due Date");
		defaultTableModel.addColumn("Status");
		for (Borrow borrow : borrowList) {
			defaultTableModel.addRow(new Object[] { borrow.getId(), borrow.getBookTitle(), borrow.getCreated(), borrow.getDue_date(),
					borrow.isStatus() ? "Returned" : "Pending" });
			jtableGetHistory.setModel(defaultTableModel);
			jtableGetHistory.setRowHeight(40);
			jtableGetHistory.getTableHeader().setReorderingAllowed(false);
		}
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(102, 102, 255));
		headerRenderer.setForeground(new Color(255, 255, 255));

		for (int i = 0; i < jtableGetHistory.getModel().getColumnCount(); i++) {
			jtableGetHistory.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		}
	}
}