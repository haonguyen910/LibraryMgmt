package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entities.Author;
import entities.Book;
import entities.Book_Author;
import entities.Book_Category;
import entities.Borrow;
import entities.BorrowDetail;
import entities.Borrowed;
import entities.Category;
import models.AuthorModel;
import models.BookModel;
import models.Book_AuthorModel;
import models.Book_CategoryModel;
import models.BorrowDetailModel;
import models.BorrowModel;
import models.BorrowedModel;
import models.CategoryModel;
import models.CustomerModel;
import models.EmployeeModel;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.border.TitledBorder;

public class JPanelBorrowedList extends JPanel {
	private JPanel jpanelRight;

	private JTextField jtextFieldKeyword;
	private JButton jbuttonSearch;
	private JComboBox jcomboBoxSearchType;
	private JButton jbuttonCancelSearch;
	private JPanel panel_4;
	private JDateChooser jdateChooserCreated;
	private JLabel lblNewLabel_2;
	private JPanel panel_6;
	private JLabel lblNewLabel_4;
	private JPanel jpanelDetail;
	private JScrollPane scrollPane;
	private JTable jtableDetails;
	private JPanel jpanelBorrow;
	private JScrollPane scrollPane_1;
	private JTable jtableBorrowed;
//	Global Variable
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	BorrowModel borrowModel = new BorrowModel();
	BorrowDetailModel borrowDetailModel = new BorrowDetailModel();
	BookModel bookModel = new BookModel();
	BorrowedModel borrowedModel = new BorrowedModel();
	EmployeeModel employeeModel = new EmployeeModel();
	CustomerModel customerModel = new CustomerModel();
	private JButton jbuttonCancelByCreated;
	private JButton jbuttonSearchByCreated;
	private JPanel panel_5;
	private JComboBox jcomboBoxSort;
	private JLabel lblNewLabel_3;

	/**
	 * Create the panel.
	 */
	public JPanelBorrowedList(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 192));
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel);

		JLabel lblNewLabel = new JLabel("Borrowed List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Keyword:");
		lblNewLabel_1.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_1.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_1.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_1);

		jtextFieldKeyword = new JTextField();
		jtextFieldKeyword.setPreferredSize(new Dimension(500, 30));
		jtextFieldKeyword.setMinimumSize(new Dimension(500, 30));
		jtextFieldKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(jtextFieldKeyword);
		jtextFieldKeyword.setColumns(20);

		jbuttonSearch = new JButton("Search");
		jbuttonSearch.setMinimumSize(new Dimension(80, 30));
		jbuttonSearch.setPreferredSize(new Dimension(100, 30));
		jbuttonSearch.setMaximumSize(new Dimension(80, 30));
		jbuttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});

		jcomboBoxSearchType = new JComboBox();
		jcomboBoxSearchType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcomboBoxSearchType.setMinimumSize(new Dimension(150, 30));
		jcomboBoxSearchType.setPreferredSize(new Dimension(150, 30));
		panel_1.add(jcomboBoxSearchType);
		panel_1.add(jbuttonSearch);

		jbuttonCancelSearch = new JButton("Cancel");
		jbuttonCancelSearch.setPreferredSize(new Dimension(100, 30));
		jbuttonCancelSearch.setMinimumSize(new Dimension(100, 30));
		jbuttonCancelSearch.setMaximumSize(new Dimension(100, 30));
		jbuttonCancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonCancelSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancelSearch_actionPerformed(e);
			}
		});
		panel_1.add(jbuttonCancelSearch);

		panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		add(panel_4);

		lblNewLabel_2 = new JLabel("Created:");
		lblNewLabel_2.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_2.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_2.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(lblNewLabel_2);

		jdateChooserCreated = new JDateChooser();
		jdateChooserCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jdateChooserCreated.setPreferredSize(new Dimension(200, 30));
		jdateChooserCreated.setMinimumSize(new Dimension(200, 30));
		panel_4.add(jdateChooserCreated);

		jbuttonSearchByCreated = new JButton("Search");
		jbuttonSearchByCreated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearchByCreated_actionPerformed(e);
			}
		});
		jbuttonSearchByCreated.setPreferredSize(new Dimension(100, 30));
		jbuttonSearchByCreated.setMinimumSize(new Dimension(80, 30));
		jbuttonSearchByCreated.setMaximumSize(new Dimension(80, 30));
		jbuttonSearchByCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(jbuttonSearchByCreated);

		jbuttonCancelByCreated = new JButton("Cancel");
		jbuttonCancelByCreated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancelByCreated_actionPerformed(e);
			}
		});
		jbuttonCancelByCreated.setPreferredSize(new Dimension(100, 30));
		jbuttonCancelByCreated.setMinimumSize(new Dimension(80, 30));
		jbuttonCancelByCreated.setMaximumSize(new Dimension(80, 30));
		jbuttonCancelByCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(jbuttonCancelByCreated);

		panel_5 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_5.getLayout();
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		add(panel_5);

		lblNewLabel_3 = new JLabel("Sort by:");
		lblNewLabel_3.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_3.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_3.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_5.add(lblNewLabel_3);

		jcomboBoxSort = new JComboBox();
		jcomboBoxSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxSort_actionPerformed(e);
			}
		});
		jcomboBoxSort.setPreferredSize(new Dimension(150, 30));
		jcomboBoxSort.setMinimumSize(new Dimension(150, 30));
		jcomboBoxSort.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_5.add(jcomboBoxSort);

		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		jpanelDetail = new JPanel();
		jpanelDetail.setBorder(
				new TitledBorder(null, "Borrow Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpanelDetail.setMinimumSize(new Dimension(400, 400));
		jpanelDetail.setPreferredSize(new Dimension(400, 400));
		panel_2.add(jpanelDetail, BorderLayout.WEST);
		jpanelDetail.setLayout(new BoxLayout(jpanelDetail, BoxLayout.X_AXIS));

		scrollPane = new JScrollPane();
		jpanelDetail.add(scrollPane);

		jtableDetails = new JTable();
		scrollPane.setViewportView(jtableDetails);

		jpanelBorrow = new JPanel();
		panel_2.add(jpanelBorrow, BorderLayout.CENTER);
		jpanelBorrow.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		jpanelBorrow.add(scrollPane_1, BorderLayout.CENTER);

		jtableBorrowed = new JTable();
		jtableBorrowed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableBorrow_mouseClicked(e);
			}
		});
		scrollPane_1.setViewportView(jtableBorrowed);

		panel_6 = new JPanel();
		add(panel_6);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_4.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_4.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_6.add(lblNewLabel_4);

		initJFrame();

	}

	// Functions
	private void initJFrame() {
		fillDataToJTableBorrowed(borrowedModel.findAll());
		fillDataToJComboBox();
		jbuttonCancelSearch.setVisible(false);
		jbuttonCancelByCreated.setVisible(false);
		fillDataToJTableDetailsInit();
		fillDataToJComboBoxSort();

	}

	private void jtableBorrow_mouseClicked(MouseEvent e) {
		int selectedRow = jtableBorrowed.getSelectedRow();
		int id = Integer.parseInt(jtableBorrowed.getValueAt(selectedRow, 1).toString());
		fillDataToJTableDetails(borrowDetailModel.findByBorrowId(id));
//		jbuttonDelete.setEnabled(true);
//		jbuttonEdit.setEnabled(true);
	}

	private void jcomboBoxSort_actionPerformed(ActionEvent e) {
		String status = jcomboBoxSort.getSelectedItem().toString();

		if (status.equalsIgnoreCase("created ascending")) {
			fillDataToJTableBorrowed(borrowedModel.findByCreatedASC());
		} else if (status.equalsIgnoreCase("created descending")) {
			fillDataToJTableBorrowed(borrowedModel.findByCreatedDESC());
		}
		fillDataToJTableDetailsInit();
	}

	private void jbuttonSearch_actionPerformed(ActionEvent e) {
		String keyword = jtextFieldKeyword.getText().trim();
		String searchType = jcomboBoxSearchType.getSelectedItem().toString();
		if (searchType.equalsIgnoreCase("id")) {
			int id = Integer.parseInt(keyword);
			fillDataToJTableBorrowed(borrowedModel.findById(id));
		} else if (searchType.equalsIgnoreCase("id borrow")) {
			int idBorrow = Integer.parseInt(keyword);
			fillDataToJTableBorrowed(borrowedModel.findByBorrowId(idBorrow));
		} else if (searchType.equalsIgnoreCase("employee name")) {
			fillDataToJTableBorrowed(borrowedModel.findByEmployeeName(keyword));
		} else if (searchType.equalsIgnoreCase("customer name")) {
			fillDataToJTableBorrowed(borrowedModel.findByCustomerName(keyword));
		}
		jbuttonCancelSearch.setVisible(true);
		fillDataToJTableDetailsInit();

	}

	private void jbuttonSearchByCreated_actionPerformed(ActionEvent e) {
		fillDataToJTableBorrowed(borrowedModel.findByCreated(jdateChooserCreated.getDate()));
		jbuttonCancelByCreated.setVisible(true);
		fillDataToJTableDetailsInit();
	}

	private void jbuttonCancelSearch_actionPerformed(ActionEvent e) {
		fillDataToJTableBorrowed(borrowedModel.findAll());
		jtextFieldKeyword.setText("");
		jbuttonCancelSearch.setVisible(false);
		fillDataToJTableDetailsInit();
	}

	private void jbuttonCancelByCreated_actionPerformed(ActionEvent e) {
		fillDataToJTableBorrowed(borrowedModel.findAll());
		jdateChooserCreated.setDate(null);
		jbuttonCancelByCreated.setVisible(false);
		fillDataToJTableDetailsInit();
	}

	// Components
	private void fillDataToJTableBorrowed(List<Borrowed> borrowedList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("ID Borrow");
		defaultTableModel.addColumn("Employee");
		defaultTableModel.addColumn("Customer");
		defaultTableModel.addColumn("Borrow Created");
		defaultTableModel.addColumn("Borrow Due Date");
		defaultTableModel.addColumn("Created");
		defaultTableModel.addColumn("Overdue Date");
		defaultTableModel.addColumn("Deposit");
		defaultTableModel.addColumn("Fines");
		defaultTableModel.addColumn("Total");

		for (Borrowed borrowed : borrowedList) {
			defaultTableModel.addRow(new Object[] { borrowed.getId(), borrowed.getId_borrow(),
					employeeModel.find(borrowed.getEmployeeId()).getName(),
					customerModel.find(borrowed.getCustomerId()).getName(),
					simpleDateFormat.format(borrowed.getCreated_borrow()),
					simpleDateFormat.format(borrowed.getDue_date_borrow()),
					simpleDateFormat.format(borrowed.getCreated()), borrowed.getOverdue_day(),
					borrowed.getDeposit_borrow(), borrowed.getFines(), borrowed.getTotal() });
		}
		jtableBorrowed.setModel(defaultTableModel);
		jtableBorrowed.getTableHeader().setReorderingAllowed(false);
		jtableBorrowed.setRowHeight(50);
	}

	private void fillDataToJTableDetails(List<BorrowDetail> borrowDetailList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("ID Borrow");
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Quantity");
		defaultTableModel.addColumn("Price");

		for (BorrowDetail borrowDetail : borrowDetailList) {
			defaultTableModel.addRow(new Object[] { borrowDetail.getId_borrow(), borrowDetail.getId(),
					bookModel.find(borrowDetail.getId_book()).getTitle(), borrowDetail.getQuantity(),
					borrowDetail.getPrice() });
		}

		jtableDetails.setModel(defaultTableModel);
		jtableDetails.getTableHeader().setReorderingAllowed(false);
		jtableDetails.setRowHeight(50);
	}

	private void fillDataToJTableDetailsInit() {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("ID Borrow");
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Quantity");
		defaultTableModel.addColumn("Price");

		jtableDetails.setModel(defaultTableModel);
		jtableDetails.getTableHeader().setReorderingAllowed(false);
		jtableDetails.setRowHeight(50);
	}

	private void fillDataToJComboBox() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("Customer Name");
		defaultComboBoxModel.addElement("ID Borrow");
		defaultComboBoxModel.addElement("ID");
		defaultComboBoxModel.addElement("Employee Name");
		jcomboBoxSearchType.setModel(defaultComboBoxModel);
	}

	private void fillDataToJComboBoxSort() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("Created Ascending");
		defaultComboBoxModel.addElement("Created Descending");
		jcomboBoxSort.setModel(defaultComboBoxModel);
	}

	private class ImageCellRender extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JLabel jlabel = new JLabel();
			byte[] bytes = (byte[]) value;

			ImageIcon imageIcon = new ImageIcon(
					new ImageIcon(bytes).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			jlabel.setIcon(imageIcon);
			jlabel.setHorizontalAlignment(jlabel.CENTER);
			return jlabel;
		}
	}

}
