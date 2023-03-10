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
import javax.swing.JFrame;

import com.toedter.calendar.JDateChooser;

import demo.JPanelBorrowedAdd.HeaderRenderer;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.ComponentOrientation;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.UIResource;
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
	private JTextField jtextFieldCustomer;
	private JTable jtableCustomer;
	private JTextField jtextFieldBook;
	private JTable jtableBook;
	private JTable jtableBorrowBook;
	private JComboBox jcomboBoxCustomer;
	private JComboBox jcomboBoxBook;
	private JButton jbuttonSearchCustomer;
	private JButton jbuttonClearCustomer;
	private JButton jbuttonSearchBook;
	private JButton jbuttonClearBook;
	private JButton jbuttonAddBookList;
	private JButton jbuttonRemoveBookList;
	private JButton jbuttonSave;
//	Global Variable
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	BorrowDetailModel borrowDetailModel = new BorrowDetailModel();
	EmployeeModel employeeModel = new EmployeeModel();
	CustomerModel customerModel = new CustomerModel();
	BorrowModel borrowModel = new BorrowModel();
	BookModel bookModel = new BookModel();
	private Employee employee;
	private Customer customer;
	private Borrow borrow;
	private Calendar calendarToday;
	private Calendar calendarDueDate;
	private Date today;
	private Date dueDate;
	private List<BorrowDetail> borrowDetailListTemp;
	private List<Book> bookBorrowList;
	private JButton jbuttonCancel;
	private Map<String, Object> data;
	private Map<String, Object> dataPut;

	/**
	 * Create the panel.
	 */
	public JPanelBorrowAdd(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 200));
		panel.setBackground(new Color(52, 52, 52));
		FlowLayout fl_panel = (FlowLayout) panel.getLayout();
		fl_panel.setVgap(15);
		add(panel);

		JLabel lblNewLabel = new JLabel("Add Borrow");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel jpanelBorrowTicket = new JPanel();
		jpanelBorrowTicket
				.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Borrow Ticket", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 68, 98)));
		jpanelBorrowTicket.setPreferredSize(new Dimension(400, 650));
		jpanelBorrowTicket.setMinimumSize(new Dimension(400, 650));
		panel_1.add(jpanelBorrowTicket, BorderLayout.WEST);
		jpanelBorrowTicket.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Employee:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(35, 35, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Customer:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(35, 75, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_1_1);

		jtextFieldBorrowEmployee = new JTextField();
		jtextFieldBorrowEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowEmployee.setEditable(false);
		jtextFieldBorrowEmployee.setColumns(10);
		jtextFieldBorrowEmployee.setBounds(135, 35, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowEmployee);

		jtextFieldBorrowCustomer = new JTextField();
		jtextFieldBorrowCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowCustomer.setEditable(false);
		jtextFieldBorrowCustomer.setColumns(10);
		jtextFieldBorrowCustomer.setBounds(135, 75, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowCustomer);

		jtextFieldBorrowCreated = new JTextField();
		jtextFieldBorrowCreated.setText("<dynamic>");
		jtextFieldBorrowCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowCreated.setEditable(false);
		jtextFieldBorrowCreated.setColumns(10);
		jtextFieldBorrowCreated.setBounds(135, 144, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowCreated);

		JLabel lblNewLabel_1_2 = new JLabel("Created Date:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(35, 144, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Due Date:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(35, 191, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_3);

		jtextFieldBorrowDueDate = new JTextField();
		jtextFieldBorrowDueDate.setText("<dynamic>");
		jtextFieldBorrowDueDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowDueDate.setEditable(false);
		jtextFieldBorrowDueDate.setColumns(10);
		jtextFieldBorrowDueDate.setBounds(135, 184, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowDueDate);

		jtextFieldBorrowDeposit = new JTextField();
		jtextFieldBorrowDeposit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowDeposit.setEditable(false);
		jtextFieldBorrowDeposit.setColumns(10);
		jtextFieldBorrowDeposit.setBounds(135, 226, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowDeposit);

		JLabel lblNewLabel_1_4 = new JLabel("Deposit:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(35, 229, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Book List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 68, 98)));
		scrollPane.setBounds(10, 295, 380, 270);
		jpanelBorrowTicket.add(scrollPane);

		jtableBorrowBook = new JTable();
		jtableBorrowBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableBorrowBook_mouseClicked(e);
			}
		});
		jtableBorrowBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableBorrowBook);

		jbuttonSave = new JButton("Save");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		jbuttonSave.setPreferredSize(new Dimension(100, 30));
		jbuttonSave.setMinimumSize(new Dimension(100, 30));
		jbuttonSave.setMaximumSize(new Dimension(100, 30));
		jbuttonSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonSave.setBounds(10, 625, 100, 30);
		jpanelBorrowTicket.add(jbuttonSave);

		jbuttonCancel = new JButton("Cancel");
		jbuttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancel_actionPerformed(e);
			}
		});
		jbuttonCancel.setPreferredSize(new Dimension(100, 30));
		jbuttonCancel.setMinimumSize(new Dimension(100, 30));
		jbuttonCancel.setMaximumSize(new Dimension(100, 30));
		jbuttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonCancel.setBounds(118, 625, 100, 30);
		jpanelBorrowTicket.add(jbuttonCancel);

		jbuttonRemoveBookList = new JButton("Remove Book List");
		jbuttonRemoveBookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRemoveBookList_actionPerformed(e);
			}
		});
		jbuttonRemoveBookList.setBounds(240, 576, 150, 30);
		jpanelBorrowTicket.add(jbuttonRemoveBookList);
		jbuttonRemoveBookList.setPreferredSize(new Dimension(150, 30));
		jbuttonRemoveBookList.setMinimumSize(new Dimension(150, 30));
		jbuttonRemoveBookList.setMaximumSize(new Dimension(150, 30));
		jbuttonRemoveBookList.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JPanel jpanelSearch = new JPanel();
		panel_1.add(jpanelSearch, BorderLayout.CENTER);
		jpanelSearch.setLayout(new BoxLayout(jpanelSearch, BoxLayout.Y_AXIS));

		JPanel jpanelCustomer = new JPanel();
		jpanelCustomer.setFont(new Font("Tahoma", Font.BOLD, 16));
		jpanelCustomer.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 68, 98)));
		jpanelSearch.add(jpanelCustomer);
		jpanelCustomer.setLayout(new BoxLayout(jpanelCustomer, BoxLayout.Y_AXIS));

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setVgap(20);
		flowLayout_4.setHgap(10);
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
		jtextFieldCustomer.setColumns(30);
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

		jbuttonClearCustomer = new JButton("Cancel");
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
		jpanelBook.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Book Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 68, 98)));
		jpanelSearch.add(jpanelBook);
		jpanelBook.setLayout(new BoxLayout(jpanelBook, BoxLayout.Y_AXIS));

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_8.getLayout();
		flowLayout_3.setVgap(20);
		flowLayout_3.setHgap(10);
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
		jtextFieldBook.setColumns(30);
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

		jbuttonClearBook = new JButton("Cancel");
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
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
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
	}

//	Dynamic Data
	/**
	 * @wbp.parser.constructor
	 */
	public JPanelBorrowAdd(JPanel JpanelRight, Map<String, Object> data) {
		this(JpanelRight);
		this.data = data;
		initJFrame();
	}

// Logic Functions
	private boolean createBorrowDetail(int id_borrow, String id_book, int quantity, double price) {
		BorrowDetail borrowDetail = setValueBorrowDetail(id_borrow, id_book, quantity, price);
		return borrowDetailModel.create(borrowDetail);
	}

	private boolean createBorrow(int id_customer, int id_employee, double deposit) {
		borrow = setValueBorrow(id_customer, id_employee, deposit);
		return borrowModel.create(borrow);
	}

	private Borrow setValueBorrow(int id_customer, int id_employee, double deposit) {
		try {
			borrow = new Borrow();
			borrow.setId_customer(id_customer);
			borrow.setId_employee(id_employee);
			borrow.setDeposit(deposit);
			return borrow;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private BorrowDetail setValueBorrowDetail(int id_borrow, String id_book, int quantity, double price) {
		try {
			BorrowDetail borrowDetail = new BorrowDetail();
			borrowDetail.setId_borrow(id_borrow);
			borrowDetail.setId_book(id_book);
			borrowDetail.setQuantity(quantity);
			borrowDetail.setPrice(price);
			return borrowDetail;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private BorrowDetail setValueBorrowDetailTemp(String id_book, int quantity, double price, double total) {
		try {
			BorrowDetail borrowDetail = new BorrowDetail();
			borrowDetail.setId_book(id_book);
			borrowDetail.setQuantity(quantity);
			borrowDetail.setPrice(price);
			borrowDetail.setTotal(total);
			return borrowDetail;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private double setValueDeposit(List<BorrowDetail> borrowDetailList) {
		double total = 0;
		for (BorrowDetail borrowDetail : borrowDetailList) {
			total += borrowDetail.getTotal();
		}
		return total;
	}

//	Event Functions
	private void initJFrame() {
		employee = (Employee) data.get("employee");
		dataPut = new HashMap<String, Object>();
		dataPut.put("employee", employee);
		jtextFieldBorrowEmployee.setText(employee.getName());

		calendarToday = Calendar.getInstance();
		calendarDueDate = Calendar.getInstance();
		calendarDueDate.add(Calendar.DAY_OF_MONTH, 5);
		today = calendarToday.getTime();
		dueDate = calendarDueDate.getTime();

		jtextFieldBorrowCreated.setText(String.valueOf(simpleDateFormat.format(today)));
		jtextFieldBorrowDueDate.setText(String.valueOf(simpleDateFormat.format(dueDate)));
		fillDataToJTableCustomer(customerModel.findAll());
		fillDataToJTableBook(bookModel.findAll());
		fillDataToJComboBoxCustomer();
		fillDataToJComboBoxBook();
		fillDataToJTableBorrowBookInit();

		jbuttonClearCustomer.setVisible(false);
		jbuttonClearBook.setVisible(false);
		jbuttonRemoveBookList.setEnabled(false);

		borrowDetailListTemp = new ArrayList<BorrowDetail>();
		bookBorrowList = new ArrayList<Book>();

	}

	private void jbuttonAddBookList_actionPerformed(ActionEvent e) {

		int selectedRow = jtableBook.getSelectedRow();
		String callNumber = jtableBook.getValueAt(selectedRow, 0).toString();
		Book bookSelected = bookModel.find(callNumber);

		if (bookSelected.getQuantity() > 0 && bookSelected.isStatus() == true) {
			BorrowDetail borrowDetail = setValueBorrowDetailTemp(bookSelected.getCallNumber(), 1,
					bookSelected.getPrice(), bookSelected.getPrice() * 1);
			borrowDetailListTemp.add(borrowDetail);

			Book bookBorrow = new Book();
			bookBorrow.setCallNumber(borrowDetail.getId_book());
			bookBorrow.setAuthor(bookSelected.getAuthor());
			bookBorrow.setTitle(bookSelected.getTitle());
			bookBorrow.setQuantity(borrowDetail.getQuantity());
			bookBorrow.setPrice(bookSelected.getPrice());
			bookBorrowList.add(bookBorrow);

			fillDataToJTableBorrowBook(bookBorrowList);
		} else {
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Book Invalid");
		}

	}

	private void jbuttonRemoveBookList_actionPerformed(ActionEvent e) {
		int selectedRow = jtableBorrowBook.getSelectedRow();
		String callNumber = jtableBorrowBook.getValueAt(selectedRow, 0).toString();

		for (int i = 0; i < bookBorrowList.size(); i++) {
			if (bookBorrowList.get(i).getCallNumber() == callNumber) {

				if (bookBorrowList.remove(bookBorrowList.get(i))) {

					fillDataToJTableBorrowBook(bookBorrowList);
				}
			}
		}
		for (int i = 0; i < borrowDetailListTemp.size(); i++) {
			if (borrowDetailListTemp.get(i).getId_book() == callNumber) {

				if (borrowDetailListTemp.remove(borrowDetailListTemp.get(i))) {

					jtextFieldBorrowDeposit.setText(String.valueOf(setValueDeposit(borrowDetailListTemp)));
				}
			}
		}

		jbuttonRemoveBookList.setEnabled(false);
	}

	private void jbuttonSave_actionPerformed(ActionEvent e) {

		try {
			if (createBorrow(customer.getId(), employee.getId(), setValueDeposit(borrowDetailListTemp))) {
//				JOptionPane.showMessageDialog(this, "Success Borrow");

				List<BorrowDetail> borrowDetailList = new ArrayList<BorrowDetail>();
				int borrowCreatedId = borrowModel.findOneByCustomerID(customer.getId()).getId();

				for (BorrowDetail bdT : borrowDetailListTemp) {

					BorrowDetail borrowDetail = setValueBorrowDetail(borrowCreatedId, bdT.getId_book(),
							bdT.getQuantity(), bdT.getPrice());
					borrowDetailList.add(borrowDetail);
				}

				for (BorrowDetail bd : borrowDetailList) {
					Book bookInLibrary = bookModel.find(bd.getId_book());
					if (borrowDetailModel.create(bd) == false) {
						JOptionPane.showMessageDialog(this, "Failed Borrow Detail");
					}
					if (bookModel.updateQuantity(bookInLibrary,
							bookInLibrary.getQuantity() - bd.getQuantity()) == false) {
						JOptionPane.showMessageDialog(this, "Failed Update Quantity");
					}
					if (bookInLibrary.getQuantity() == bd.getQuantity()) {
						if (bookModel.updateStatus(bookInLibrary, false) == false) {
							JOptionPane.showMessageDialog(this, "Failed Update Status");
						}
					}

				}
				JOptionPane.showMessageDialog(this, "Successful created borrow!");
				jpanelRight.removeAll();
				jpanelRight.revalidate();
				JPanelBorrowList jPanelBorrowList = new JPanelBorrowList(jpanelRight, dataPut);
				jpanelRight.add(jPanelBorrowList);
				jPanelBorrowList.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(this, "Failed, something went wrong...");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}

	private void jbuttonCancel_actionPerformed(ActionEvent e) {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
		JPanelBorrowList jPanelBorrowList = new JPanelBorrowList(jpanelRight, dataPut);
		jpanelRight.add(jPanelBorrowList);
		jPanelBorrowList.setVisible(true);
	}

	private void jtableBorrowBook_mouseClicked(MouseEvent e) {
		jbuttonRemoveBookList.setEnabled(true);
	}

	private void jtableCustomer_mouseClicked(MouseEvent e) {
		int selectedRow = jtableCustomer.getSelectedRow();
		int id = Integer.parseInt(jtableCustomer.getValueAt(selectedRow, 0).toString());
		customer = customerModel.find(id);
		jtextFieldBorrowCustomer.setText(customer.getName());
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
				Book bookSelected = bookList.get(row);

				if (2 == column) {
					String quantityString = aValue.toString();
					int quantityInt = Integer.parseInt(quantityString);
					bookSelected.setQuantity(quantityInt);
					Book bookInLibrary = bookModel.find(bookSelected.getCallNumber());

					for (Book bookBorrow : bookBorrowList) {
						if (bookBorrow.getCallNumber() == bookSelected.getCallNumber()) {
							if (bookInLibrary.getQuantity() >= quantityInt) {
								bookBorrow.setQuantity(quantityInt);
								bookSelected.setQuantity(quantityInt);
								fillDataToJTableBorrowBook(bookBorrowList);
								jbuttonRemoveBookList.setEnabled(false);

							} else {
								JFrame f = new JFrame();
								JOptionPane.showMessageDialog(f,
										"The quantity of books selected is MORE THAN the quantity of books available in library");
								bookBorrow.setQuantity(1);
								bookSelected.setQuantity(1);
								fillDataToJTableBorrowBook(bookBorrowList);
							}
						}
					}

					for (BorrowDetail borrowDetail : borrowDetailListTemp) {
						if (borrowDetail.getId_book() == bookSelected.getCallNumber()) {
							if (bookInLibrary.getQuantity() >= quantityInt) {
								borrowDetail.setQuantity(quantityInt);
								borrowDetail.setTotal(borrowDetail.getQuantity() * borrowDetail.getPrice());
							} else {
								borrowDetail.setQuantity(1);
								borrowDetail.setTotal(borrowDetail.getQuantity() * borrowDetail.getPrice());
							}

						}
					}

					jtextFieldBorrowDeposit.setText(String.valueOf(setValueDeposit(borrowDetailListTemp)));
				}
			}
		};

		defaultTableModel.addColumn("Call Number");
		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Quantity");
		defaultTableModel.addColumn("Price");
		defaultTableModel.addColumn("Total");

		for (Book bookBorrow : bookList) {
			defaultTableModel
					.addRow(new Object[] { bookBorrow.getCallNumber(), bookBorrow.getTitle(), bookBorrow.getQuantity(),
							bookBorrow.getPrice(), bookBorrow.getQuantity() * bookBorrow.getPrice() });
		}

		jtableBorrowBook.setModel(defaultTableModel);
		jtableBorrowBook.getTableHeader().setReorderingAllowed(false);
		jtableBorrowBook.setRowHeight(50);

		jtextFieldBorrowDeposit.setText(String.valueOf(setValueDeposit(borrowDetailListTemp)));
	}

	private void fillDataToJTableBorrowBookInit() {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("Call Number");
		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Quantity");
		defaultTableModel.addColumn("Price");
		defaultTableModel.addColumn("Total");

		jtableBorrowBook.setModel(defaultTableModel);
		jtableBorrowBook.getTableHeader().setReorderingAllowed(false);
		jtableBorrowBook.setRowHeight(50);
		
		HeaderRenderer header = new HeaderRenderer(jtableBorrowBook.getTableHeader().getDefaultRenderer());
		for (int i = 0; i < jtableBorrowBook.getModel().getColumnCount(); i++) {
			jtableBorrowBook.getColumnModel().getColumn(i).setHeaderRenderer(header);
		}
	}

	private void fillDataToJTableCustomer(List<Customer> customerList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Phone");
		defaultTableModel.addColumn("Address");

		for (Customer customer : customerList) {
			defaultTableModel.addRow(
					new Object[] { customer.getId(), customer.getName(), customer.getPhone(), customer.getAddress() });
		}

		jtableCustomer.setModel(defaultTableModel);
		jtableCustomer.getTableHeader().setReorderingAllowed(false);
		jtableCustomer.setRowHeight(50);
		
		HeaderRenderer header = new HeaderRenderer(jtableCustomer.getTableHeader().getDefaultRenderer());
		for (int i = 0; i < jtableCustomer.getModel().getColumnCount(); i++) {
			jtableCustomer.getColumnModel().getColumn(i).setHeaderRenderer(header);
		}

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
					book.getTitle(), book.getAuthor(), book.getCategory(), book.getQuantity(), book.getPrice(),
					book.isStatus() ? "In Library" : "Out of Stock", });
		}

		jtableBook.setModel(defaultTableModel);
		jtableBook.getTableHeader().setReorderingAllowed(false);
		jtableBook.setRowHeight(50);
		jtableBook.getColumnModel().getColumn(2).setCellRenderer(new ImageCellRender());
		
		HeaderRenderer header = new HeaderRenderer(jtableBook.getTableHeader().getDefaultRenderer());
		for (int i = 0; i < jtableBook.getModel().getColumnCount(); i++) {
			jtableBook.getColumnModel().getColumn(i).setHeaderRenderer(header);
		}
	}

	private void fillDataToJComboBoxCustomer() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("Name");
		defaultComboBoxModel.addElement("ID");
		jcomboBoxCustomer.setModel(defaultComboBoxModel);
	}

	private void fillDataToJComboBoxBook() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("Title");
		defaultComboBoxModel.addElement("Author");
		defaultComboBoxModel.addElement("Call Number");
		defaultComboBoxModel.addElement("ISBN");
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
			comp.setForeground(new Color(70, 67, 98));
			return comp;
		}
	}
}
