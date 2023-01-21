package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;

import entities.Author;
import entities.Book;
import entities.Book_Author;
import entities.Book_Category;
import entities.Borrow;
import entities.BorrowDetail;
import entities.Category;
import entities.Customer;
import entities.Employee;
import models.AuthorModel;
import models.BookModel;
import models.Book_AuthorModel;
import models.Book_CategoryModel;
import models.BorrowDetailModel;
import models.BorrowModel;
import models.CategoryModel;
import models.CustomerModel;
import models.EmployeeModel;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.ComponentOrientation;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class JPanelBorrowAdd extends JPanel {
	private JPanel jpanelRight;

	private JTextField jtextFieldBorrowEmployee;
	private JTextField jtextFieldBorrowCustomer;
	private JTextField jtextFieldBorrowCreated;
	private JTextField jtextFieldBorrowDueDate;
	private JTextField jtextFieldBorrowDeposit;
	private JTextField jtextFieldEmployee;
	private JTable jtableEmployee;
	private JButton jbuttonClearEmployee;
	private JButton jbuttonSearchEmployee;
	private JTextField jtextFieldCustomer;
	private JTable jtableCustomer;
	private JTextField jtextFieldBook;
	private JTable jtableBook;
	private JTable jtableBorrowBook;
	private JComboBox jcomboBoxEmployee;
	private JComboBox jcomboBoxCustomer;
	private JComboBox jcomboBoxBook;
	private JButton jbuttonSearchCustomer;
	private JButton jbuttonClearCustomer;
	private JButton jbuttonSearchBook;
	private JButton jbuttonClearBook;
	private JButton jbuttonAddBookList;
	private JButton jbuttonRemoveBookList;
	private JButton jbuttonAddCustomer;
//	Global Variable
	EmployeeModel employeeModel = new EmployeeModel();
	CustomerModel customerModel = new CustomerModel();
	BorrowDetailModel borrowDetailModel = new BorrowDetailModel();
	BookModel bookModel = new BookModel();
	private Employee employee;
	private Customer customer;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	BorrowModel borrowModel = new BorrowModel();
	private Borrow borrow;
	private Calendar calendarToday;
	private Calendar calendarDueDate;
	private Date today;
	private Date dueDate;
	private List<BorrowDetail> borrowDetailListTemp;
	private List<Book> bookBorrowList;
	private Book jbuttonAddBookList_actionPerformed;
	private BorrowDetail borrowDetailChangeQuantity;
	private int quantityBookBorrow;

	/**
	 * Create the panel.
	 */
	public JPanelBorrowAdd(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 200));
		panel.setBackground(new Color(128, 128, 192));
		FlowLayout fl_panel = (FlowLayout) panel.getLayout();
		fl_panel.setAlignment(FlowLayout.LEFT);
		add(panel);

		JLabel lblNewLabel = new JLabel("Add Borrow");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel jpanelBorrowTicket = new JPanel();
		jpanelBorrowTicket
				.setBorder(new TitledBorder(null, "Borrow Ticket", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpanelBorrowTicket.setPreferredSize(new Dimension(400, 650));
		jpanelBorrowTicket.setMinimumSize(new Dimension(400, 650));
		panel_1.add(jpanelBorrowTicket, BorderLayout.WEST);
		jpanelBorrowTicket.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Employee:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(35, 60, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Customer:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(35, 100, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_1_1);

		jtextFieldBorrowEmployee = new JTextField();
		jtextFieldBorrowEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowEmployee.setEditable(false);
		jtextFieldBorrowEmployee.setColumns(10);
		jtextFieldBorrowEmployee.setBounds(135, 60, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowEmployee);

		jtextFieldBorrowCustomer = new JTextField();
		jtextFieldBorrowCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowCustomer.setEditable(false);
		jtextFieldBorrowCustomer.setColumns(10);
		jtextFieldBorrowCustomer.setBounds(135, 100, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowCustomer);

		jtextFieldBorrowCreated = new JTextField();
		jtextFieldBorrowCreated.setText("<dynamic>");
		jtextFieldBorrowCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowCreated.setEditable(false);
		jtextFieldBorrowCreated.setColumns(10);
		jtextFieldBorrowCreated.setBounds(135, 169, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowCreated);

		JLabel lblNewLabel_1_2 = new JLabel("Created Date:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(35, 169, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Due Date:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(35, 216, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_3);

		jtextFieldBorrowDueDate = new JTextField();
		jtextFieldBorrowDueDate.setText("<dynamic>");
		jtextFieldBorrowDueDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowDueDate.setEditable(false);
		jtextFieldBorrowDueDate.setColumns(10);
		jtextFieldBorrowDueDate.setBounds(135, 209, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowDueDate);

		jtextFieldBorrowDeposit = new JTextField();
		jtextFieldBorrowDeposit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowDeposit.setEditable(false);
		jtextFieldBorrowDeposit.setColumns(10);
		jtextFieldBorrowDeposit.setBounds(135, 251, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowDeposit);

		JLabel lblNewLabel_1_4 = new JLabel("Deposit:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(35, 254, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_6 = new JLabel("Book List");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_6.setBounds(10, 335, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 360, 380, 250);
		jpanelBorrowTicket.add(scrollPane);

		jtableBorrowBook = new JTable();
		jtableBorrowBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableBorrowBook_mouseClicked(e);
			}
		});
		jtableBorrowBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableBorrowBook.setRowSelectionAllowed(false);
		scrollPane.setViewportView(jtableBorrowBook);

		JButton jbuttonSave = new JButton("Save");
		jbuttonSave.setPreferredSize(new Dimension(100, 30));
		jbuttonSave.setMinimumSize(new Dimension(100, 30));
		jbuttonSave.setMaximumSize(new Dimension(100, 30));
		jbuttonSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonSave.setBounds(10, 632, 100, 30);
		jpanelBorrowTicket.add(jbuttonSave);

		JButton jbuttonCancel = new JButton("Cancel");
		jbuttonCancel.setPreferredSize(new Dimension(100, 30));
		jbuttonCancel.setMinimumSize(new Dimension(100, 30));
		jbuttonCancel.setMaximumSize(new Dimension(100, 30));
		jbuttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonCancel.setBounds(118, 632, 100, 30);
		jpanelBorrowTicket.add(jbuttonCancel);

		JPanel jpanelSearch = new JPanel();
		panel_1.add(jpanelSearch, BorderLayout.CENTER);
		jpanelSearch.setLayout(new BoxLayout(jpanelSearch, BoxLayout.Y_AXIS));

		JPanel jpanelEmployee = new JPanel();
		jpanelEmployee.setFont(new Font("Tahoma", Font.BOLD, 20));
		jpanelEmployee.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Customer Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jpanelSearch.add(jpanelEmployee);
		jpanelEmployee.setLayout(new BoxLayout(jpanelEmployee, BoxLayout.Y_AXIS));

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		jpanelEmployee.add(panel_4);

		JLabel lblNewLabel_1_1_2 = new JLabel("Employee:");
		lblNewLabel_1_1_2.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_2.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_2.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(lblNewLabel_1_1_2);

		jtextFieldEmployee = new JTextField();
		jtextFieldEmployee.setMinimumSize(new Dimension(200, 30));
		jtextFieldEmployee.setPreferredSize(new Dimension(200, 30));
		jtextFieldEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(jtextFieldEmployee);
		jtextFieldEmployee.setColumns(20);

		jcomboBoxEmployee = new JComboBox();
		jcomboBoxEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcomboBoxEmployee.setPreferredSize(new Dimension(100, 30));
		jcomboBoxEmployee.setMinimumSize(new Dimension(100, 30));
		panel_4.add(jcomboBoxEmployee);

		jbuttonSearchEmployee = new JButton("Search");
		jbuttonSearchEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearchEmployee_actionPerformed(e);
			}
		});
		jbuttonSearchEmployee.setPreferredSize(new Dimension(100, 30));
		jbuttonSearchEmployee.setMinimumSize(new Dimension(100, 30));
		jbuttonSearchEmployee.setMaximumSize(new Dimension(100, 30));
		jbuttonSearchEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(jbuttonSearchEmployee);

		jbuttonClearEmployee = new JButton("Clear");
		jbuttonClearEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonClearEmployee_actionPerformed(e);
			}
		});
		jbuttonClearEmployee.setPreferredSize(new Dimension(100, 30));
		jbuttonClearEmployee.setMinimumSize(new Dimension(100, 30));
		jbuttonClearEmployee.setMaximumSize(new Dimension(100, 30));
		jbuttonClearEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(jbuttonClearEmployee);

		JPanel panel_5 = new JPanel();
		jpanelEmployee.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_5.add(scrollPane_1, BorderLayout.CENTER);

		jtableEmployee = new JTable();
		jtableEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableEmployee_mouseClicked(e);
			}
		});
		jtableEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(jtableEmployee);

		JPanel jpanelCustomer = new JPanel();
		jpanelCustomer.setFont(new Font("Tahoma", Font.BOLD, 16));
		jpanelCustomer.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Employee Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jpanelSearch.add(jpanelCustomer);
		jpanelCustomer.setLayout(new BoxLayout(jpanelCustomer, BoxLayout.Y_AXIS));

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		jpanelCustomer.add(panel_6);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Customer:");
		lblNewLabel_1_1_2_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_2_1.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_2_1.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_6.add(lblNewLabel_1_1_2_1);

		jtextFieldCustomer = new JTextField();
		jtextFieldCustomer.setPreferredSize(new Dimension(200, 30));
		jtextFieldCustomer.setMinimumSize(new Dimension(200, 30));
		jtextFieldCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldCustomer.setColumns(20);
		panel_6.add(jtextFieldCustomer);

		jcomboBoxCustomer = new JComboBox();
		jcomboBoxCustomer.setPreferredSize(new Dimension(100, 30));
		jcomboBoxCustomer.setMinimumSize(new Dimension(100, 30));
		jcomboBoxCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_6.add(jcomboBoxCustomer);

		jbuttonSearchCustomer = new JButton("Search");
		jbuttonSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearchCustomer_actionPerformed(e);
			}
		});
		jbuttonSearchCustomer.setPreferredSize(new Dimension(100, 30));
		jbuttonSearchCustomer.setMinimumSize(new Dimension(100, 30));
		jbuttonSearchCustomer.setMaximumSize(new Dimension(100, 30));
		jbuttonSearchCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_6.add(jbuttonSearchCustomer);

		jbuttonClearCustomer = new JButton("Clear");
		jbuttonClearCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonClearCustomer_actionPerformed(e);
			}
		});
		jbuttonClearCustomer.setPreferredSize(new Dimension(100, 30));
		jbuttonClearCustomer.setMinimumSize(new Dimension(100, 30));
		jbuttonClearCustomer.setMaximumSize(new Dimension(100, 30));
		jbuttonClearCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_6.add(jbuttonClearCustomer);

		JPanel panel_7 = new JPanel();
		jpanelCustomer.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_7.add(scrollPane_2, BorderLayout.CENTER);

		jtableCustomer = new JTable();
		jtableCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableCustomer_mouseClicked(e);
			}
		});
		jtableCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(jtableCustomer);

		JPanel jpanelBook = new JPanel();
		jpanelBook.setFont(new Font("Tahoma", Font.BOLD, 16));
		jpanelBook.setBorder(new TitledBorder(null, "Book Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpanelSearch.add(jpanelBook);
		jpanelBook.setLayout(new BoxLayout(jpanelBook, BoxLayout.Y_AXIS));

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_8.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		jpanelBook.add(panel_8);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Book:");
		lblNewLabel_1_1_2_1_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_2_1_1.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_2_1_1.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_8.add(lblNewLabel_1_1_2_1_1);

		jtextFieldBook = new JTextField();
		jtextFieldBook.setPreferredSize(new Dimension(200, 30));
		jtextFieldBook.setMinimumSize(new Dimension(200, 30));
		jtextFieldBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBook.setColumns(20);
		panel_8.add(jtextFieldBook);

		jcomboBoxBook = new JComboBox();
		jcomboBoxBook.setPreferredSize(new Dimension(100, 30));
		jcomboBoxBook.setMinimumSize(new Dimension(100, 30));
		jcomboBoxBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_8.add(jcomboBoxBook);

		jbuttonSearchBook = new JButton("Search");
		jbuttonSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearchBook_actionPerformed(e);
			}
		});
		jbuttonSearchBook.setPreferredSize(new Dimension(100, 30));
		jbuttonSearchBook.setMinimumSize(new Dimension(100, 30));
		jbuttonSearchBook.setMaximumSize(new Dimension(100, 30));
		jbuttonSearchBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_8.add(jbuttonSearchBook);

		jbuttonClearBook = new JButton("Clear");
		jbuttonClearBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonClearBook_actionPerformed(e);
			}
		});
		jbuttonClearBook.setPreferredSize(new Dimension(100, 30));
		jbuttonClearBook.setMinimumSize(new Dimension(100, 30));
		jbuttonClearBook.setMaximumSize(new Dimension(100, 30));
		jbuttonClearBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_8.add(jbuttonClearBook);

		JPanel panel_9 = new JPanel();
		jpanelBook.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		panel_9.add(scrollPane_3, BorderLayout.CENTER);

		jtableBook = new JTable();
		jtableBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(jtableBook);

		JPanel panel_10 = new JPanel();
		jpanelBook.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_11.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_10.add(panel_11);

		jbuttonAddBookList = new JButton("Add Book List");
		jbuttonAddBookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAddBookList_actionPerformed(e);
			}
		});
		panel_11.add(jbuttonAddBookList);
		jbuttonAddBookList.setPreferredSize(new Dimension(120, 30));
		jbuttonAddBookList.setMinimumSize(new Dimension(120, 30));
		jbuttonAddBookList.setMaximumSize(new Dimension(120, 30));
		jbuttonAddBookList.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jbuttonRemoveBookList = new JButton("Remove Book List");
		jbuttonRemoveBookList.setPreferredSize(new Dimension(150, 30));
		jbuttonRemoveBookList.setMinimumSize(new Dimension(150, 30));
		jbuttonRemoveBookList.setMaximumSize(new Dimension(150, 30));
		jbuttonRemoveBookList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_11.add(jbuttonRemoveBookList);

		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_12.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_10.add(panel_12);

		jbuttonAddCustomer = new JButton("Add Customer");
		jbuttonAddCustomer.setPreferredSize(new Dimension(120, 30));
		jbuttonAddCustomer.setMinimumSize(new Dimension(120, 30));
		jbuttonAddCustomer.setMaximumSize(new Dimension(120, 30));
		jbuttonAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_12.add(jbuttonAddCustomer);
//		Function
		initJFrame();
	}

// Logic Functions
	private void createBorrowDetail(int id_borrow, String id_book, int quantity, double price) {
		BorrowDetail borrowDetail = fillDataBorrowDetail(id_borrow, id_book, quantity, price);
		borrowDetailModel.create(borrowDetail);
	}

	private BorrowDetail fillDataBorrowDetail(int id_borrow, String id_book, int quantity, double price) {
		try {
			BorrowDetail borrowDetail = new BorrowDetail();
			borrowDetail.setId_book(id_book);
			borrowDetail.setId_borrow(id_borrow);
			borrowDetail.setQuantity(quantity);
			borrowDetail.setQuantity(quantity);
			return borrowDetail;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private BorrowDetail fillDataBorrowDetailTemp(String id_book, int quantity, double price) {
		try {
			BorrowDetail borrowDetail = new BorrowDetail();
			borrowDetail.setId_book(id_book);
			borrowDetail.setQuantity(quantity);
			borrowDetail.setPrice(price);
			return borrowDetail;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	Event Functions
	private void initJFrame() {

		calendarToday = Calendar.getInstance();
		calendarDueDate = Calendar.getInstance();
		calendarDueDate.add(Calendar.DAY_OF_MONTH, 5);
		today = calendarToday.getTime();
		dueDate = calendarDueDate.getTime();

		jtextFieldBorrowCreated.setText(String.valueOf(simpleDateFormat.format(today)));
		jtextFieldBorrowDueDate.setText(String.valueOf(simpleDateFormat.format(dueDate)));
		fillDataToJTableCustomer(customerModel.findAll());
		fillDataToJTableEmployee(employeeModel.findAll());
		fillDataToJTableBook(bookModel.findAll());
		fillDataToJComboBoxCustomer();
		fillDataToJComboBoxEmployee();
		fillDataToJComboBoxBook();
		fillDataToJTableBorrowBookInit();

		jbuttonClearEmployee.setVisible(false);
		jbuttonClearCustomer.setVisible(false);
		jbuttonClearBook.setVisible(false);

		borrowDetailListTemp = new ArrayList<BorrowDetail>();
		bookBorrowList = new ArrayList<Book>();

	}

	private void jbuttonAddBookList_actionPerformed(ActionEvent e) {

		int selectedRow = jtableBook.getSelectedRow();
		String callNumber = jtableBook.getValueAt(selectedRow, 0).toString();
		Book book = bookModel.find(callNumber);

		BorrowDetail borrowDetail = fillDataBorrowDetailTemp(book.getCallNumber(), 1, book.getPrice());
		borrowDetailListTemp.add(borrowDetail);
//		book.setQuantity(borrowDetail.getQuantity());
		bookBorrowList.add(book);

		System.out.println("557 Add:" + bookBorrowList.toString());
		System.out.println("558 Add:" + borrowDetailListTemp.toString());
		fillDataToJTableBorrowBook(bookBorrowList);
	}

	public void jtableBorrowBook_mouseClicked(MouseEvent e) {

	}

//	private void setDataBookList() {
//		borrowDetailListTemp = new ArrayList<BorrowDetail>();
//		bookBorrowList = new ArrayList<Book>();
//
//		Book book = jbuttonAddBookList_actionPerformed(ActionEvent);
//
//		for (int i = 0; i < 5; i++) {
//
//			BorrowDetail borrowDetail = fillDataBorrowDetailTemp(book.getCallNumber(), 1, book.getPrice());
//			borrowDetailListTemp.add(i, borrowDetail);
//			bookBorrowList.add(i, book);
//		}
//		System.out.println(borrowDetailListTemp.toString());
//		fillDataToJTableBorrowBook(bookBorrowList);
//	}

	private void jtableEmployee_mouseClicked(MouseEvent e) {
		int selectedRow = jtableEmployee.getSelectedRow();
		int id = Integer.parseInt(jtableEmployee.getValueAt(selectedRow, 0).toString());
		employee = employeeModel.find(id);
		jtextFieldBorrowEmployee.setText(employee.getName());
	}

	private void jtableCustomer_mouseClicked(MouseEvent e) {
		int selectedRow = jtableCustomer.getSelectedRow();
		int id = Integer.parseInt(jtableCustomer.getValueAt(selectedRow, 0).toString());
		customer = customerModel.find(id);
		jtextFieldBorrowCustomer.setText(customer.getName());
	}

	private void jbuttonSearchEmployee_actionPerformed(ActionEvent e) {
		String keyword = jtextFieldEmployee.getText().trim();
		String searchType = jcomboBoxEmployee.getSelectedItem().toString();
		if (searchType.equalsIgnoreCase("ID")) {
			int id = Integer.parseInt(keyword);
			fillDataToJTableEmployee(employeeModel.findById(id));
		} else {
			fillDataToJTableEmployee(employeeModel.findByName(keyword));
		}
		jbuttonClearEmployee.setVisible(true);
	}

	private void jbuttonSearchCustomer_actionPerformed(ActionEvent e) {
		String keyword = jtextFieldCustomer.getText().trim();
		String searchType = jcomboBoxCustomer.getSelectedItem().toString();
		if (searchType.equalsIgnoreCase("ID")) {
			int id = Integer.parseInt(keyword);
			fillDataToJTableCustomer(customerModel.findById(id));
		} else {
			fillDataToJTableCustomer(customerModel.findByName(keyword));
		}
		jbuttonClearCustomer.setVisible(true);
	}

	private void jbuttonSearchBook_actionPerformed(ActionEvent e) {
		String keyword = jtextFieldBook.getText().trim();
		String searchType = jcomboBoxBook.getSelectedItem().toString();
		if (searchType.equalsIgnoreCase("ISBN")) {
			fillDataToJTableBook(bookModel.findByISBN(keyword));
		} else if (searchType.equalsIgnoreCase("Title")) {
			fillDataToJTableBook(bookModel.findByTitle(keyword));
		} else if (searchType.equalsIgnoreCase("Author")) {
			fillDataToJTableBook(bookModel.findByAuthor(keyword));
		} else {
			fillDataToJTableBook(bookModel.findByCallNumber(keyword));
		}
		jbuttonClearBook.setVisible(true);
	}

	private void jbuttonClearEmployee_actionPerformed(ActionEvent e) {
		fillDataToJTableEmployee(employeeModel.findAll());
		jtextFieldEmployee.setText("");
		jbuttonClearEmployee.setVisible(false);
	}

	private void jbuttonClearCustomer_actionPerformed(ActionEvent e) {
		fillDataToJTableCustomer(customerModel.findAll());
		jtextFieldCustomer.setText("");
		jbuttonClearCustomer.setVisible(false);
	}

	private void jbuttonClearBook_actionPerformed(ActionEvent e) {
		fillDataToJTableBook(bookModel.findAll());
		jtextFieldBook.setText("");
		jbuttonClearBook.setVisible(false);
	}

	// Components
	private void fillDataToJTableBorrowBook(List<Book> bookList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (2 == column) {
					return true;
				}
				return false;
			}

			@Override
			public void setValueAt(Object aValue, int row, int column) {
				super.setValueAt(aValue, row, column);
				Book book = bookList.get(row);

				if (2 == column) {
					String quantityString = aValue.toString();
					int quantityInt = Integer.parseInt(quantityString);
					book.setQuantity(quantityInt);
					for (Book bookBorrow : bookBorrowList) {
						if (bookBorrow.getCallNumber() == book.getCallNumber()) {
							bookBorrow.setQuantity(quantityInt);
							book.setQuantity(quantityInt);

							System.out.println("708 Change: " + bookBorrowList.toString());
						}
					}
					for (BorrowDetail borrowDetail : borrowDetailListTemp) {
						if (borrowDetail.getId_book() == book.getCallNumber()) {
							borrowDetail.setQuantity(quantityInt);
							System.out.println("714 Change: " + borrowDetailListTemp.toString());
						}
					}
				}
			}
		};
//			public void setValueAt(int aValue, int rowIndex, int columnIndex) {
//				Book book = bookList.get(rowIndex);
//				if (2 == columnIndex) {
//					book.setQuantity(aValue);
//					for (Book bookBorrow : bookBorrowList) {
//						if (bookBorrow.getCallNumber() == book.getCallNumber()) {
//							bookBorrow.setQuantity(aValue);
//							fillDataToJTableBorrowBook(bookBorrowList);
//						}
//					}
//					for (BorrowDetail borrowDetail : borrowDetailListTemp) {
//						if (borrowDetail.getId_book() == book.getCallNumber()) {
//							borrowDetail.setQuantity(aValue);
//							System.out.println(borrowDetailListTemp.toString());
//						}
//					}
//				}
//			}

		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Author");
		defaultTableModel.addColumn("Quantity");
		defaultTableModel.addColumn("Price");

		for (Book book : bookList) {
			defaultTableModel.addRow(new Object[] { book.getTitle(), book.getAuthor(), 1, book.getPrice() });
		}

		jtableBorrowBook.setModel(defaultTableModel);
		jtableBorrowBook.getTableHeader().setReorderingAllowed(false);
		jtableBorrowBook.setRowHeight(50);
	}

	private void fillDataToJTableBorrowBookInit() {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Author");
		defaultTableModel.addColumn("Quantity");
		defaultTableModel.addColumn("Price");

		jtableBorrowBook.setModel(defaultTableModel);
		jtableBorrowBook.getTableHeader().setReorderingAllowed(false);
		jtableBorrowBook.setRowHeight(50);
	}

//	public class BorrowBookTableModel extends AbstractTableModel {

	private void fillDataToJTableCustomer(List<Customer> customerList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Photo");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Phone");
		defaultTableModel.addColumn("Address");

		for (Customer customer : customerList) {
			defaultTableModel.addRow(new Object[] { customer.getId(), customer.getPhoto(), customer.getName(),
					customer.getPhone(), customer.getAddress() });
		}

		jtableCustomer.setModel(defaultTableModel);
		jtableCustomer.getTableHeader().setReorderingAllowed(false);
		jtableCustomer.setRowHeight(50);
		jtableCustomer.getColumnModel().getColumn(1).setCellRenderer(new ImageCellRender());
	}

	private void fillDataToJTableEmployee(List<Employee> employeeList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Photo");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Department");

		for (Employee employee : employeeList) {
			defaultTableModel.addRow(new Object[] { employee.getId(), employee.getPhoto(), employee.getName(),
					employee.getDepartment() });
		}

		jtableEmployee.setModel(defaultTableModel);
		jtableEmployee.getTableHeader().setReorderingAllowed(false);
		jtableEmployee.setRowHeight(50);
		jtableEmployee.getColumnModel().getColumn(1).setCellRenderer(new ImageCellRender());
	}

	private void fillDataToJTableBook(List<Book> bookList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("Call Number");
		defaultTableModel.addColumn("ISBN");
		defaultTableModel.addColumn("Photo");
		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Author");
		defaultTableModel.addColumn("Category");
		defaultTableModel.addColumn("Quantity");
		defaultTableModel.addColumn("Price");
		defaultTableModel.addColumn("Issue Status");

		for (Book book : bookList) {
			defaultTableModel.addRow(new Object[] { book.getCallNumber(), book.getISBN(), book.getPhoto(),
					book.getTitle(), book.getAuthor(), book.getCategory().toUpperCase(), book.getQuantity(),
					book.getPrice(), book.isStatus() ? "In Library" : "Out of Stock", });
		}

		jtableBook.setModel(defaultTableModel);
		jtableBook.getTableHeader().setReorderingAllowed(false);
		jtableBook.setRowHeight(50);
		jtableBook.getColumnModel().getColumn(2).setCellRenderer(new ImageCellRender());
	}

	private void fillDataToJComboBoxCustomer() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("ID");
		defaultComboBoxModel.addElement("Name");
		jcomboBoxCustomer.setModel(defaultComboBoxModel);
	}

	private void fillDataToJComboBoxEmployee() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("ID");
		defaultComboBoxModel.addElement("Name");
		jcomboBoxEmployee.setModel(defaultComboBoxModel);
	}

	private void fillDataToJComboBoxBook() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("Call Number");
		defaultComboBoxModel.addElement("ISBN");
		defaultComboBoxModel.addElement("Title");
		defaultComboBoxModel.addElement("Author");
		jcomboBoxBook.setModel(defaultComboBoxModel);
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
