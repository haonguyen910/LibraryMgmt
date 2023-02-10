package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JTextField;
import entities.Book;
import entities.Borrow;
import entities.BorrowDetail;
import entities.Borrowed;
import entities.Customer;
import entities.Employee;
import models.BookModel;
import models.BorrowDetailModel;
import models.BorrowModel;
import models.BorrowedModel;
import models.CustomerModel;
import models.EmployeeModel;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.UIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import demo.JPanelBorrowedList.HeaderRenderer;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

public class JPanelBorrowedAdd extends JPanel {
	private JPanel jpanelRight;

	private JTextField jtextFieldborrowEmployee;
	private JTextField jtextFieldBorrowCustomer;
	private JTextField jtextFieldBorrowCreated;
	private JTextField jtextFieldBorrowDueDate;
	private JTextField jtextFieldCreated;
	private JTable jtableBorrowBook;
	private JTextField jtextFieldOverdueDay;
	private JTextField jtextFieldBorrowDeposit;
	private JTextField jtextFieldFines;
	private JTextField jtextFieldTotal;
	private JTextField jtextFieldBorrowId;
	private JButton jbuttonCancel;
	private JButton jbuttonSave;
//	Global Variable
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat simpleDateFormatSQL = new SimpleDateFormat("yyyy-MM-dd");
	BorrowDetailModel borrowDetailModel = new BorrowDetailModel();
	EmployeeModel employeeModel = new EmployeeModel();
	CustomerModel customerModel = new CustomerModel();
	BorrowModel borrowModel = new BorrowModel();
	BookModel bookModel = new BookModel();
	BorrowedModel borrowedModel = new BorrowedModel();
	private Employee employee;
	private Customer customer;
	private Borrow borrow;
	private Calendar calendarToday;
	private Date today;
	private List<BorrowDetail> borrowDetailList;
	private List<Book> bookBorrowList;
	private Map<String, Object> data;
	private Borrowed borrowed;
	private int overdueDay;
	private double fines;
	private double total;

	/**
	 * Create the panel.
	 */
	public JPanelBorrowedAdd(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 200));
		panel.setBackground(new Color(255, 255, 255));
		FlowLayout fl_panel = (FlowLayout) panel.getLayout();
		fl_panel.setVgap(15);
		fl_panel.setAlignment(FlowLayout.LEFT);
		add(panel);

		JLabel lblNewLabel = new JLabel("Add Borrowed");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 51, 51));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel jpanelBorrowTicket = new JPanel();
		jpanelBorrowTicket.setBackground(new Color(255, 255, 255));
		jpanelBorrowTicket
				.setBorder(new TitledBorder(null, "Borrow Ticket", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpanelBorrowTicket.setPreferredSize(new Dimension(800, 650));
		jpanelBorrowTicket.setMinimumSize(new Dimension(800, 650));
		panel_1.add(jpanelBorrowTicket);
		jpanelBorrowTicket.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Employee:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(45, 89, 110, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Customer:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(45, 129, 110, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_1_1);

		jtextFieldborrowEmployee = new JTextField();
		jtextFieldborrowEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldborrowEmployee.setEditable(false);
		jtextFieldborrowEmployee.setColumns(10);
		jtextFieldborrowEmployee.setBounds(165, 95, 200, 30);
		jpanelBorrowTicket.add(jtextFieldborrowEmployee);

		jtextFieldBorrowCustomer = new JTextField();
		jtextFieldBorrowCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowCustomer.setEditable(false);
		jtextFieldBorrowCustomer.setColumns(10);
		jtextFieldBorrowCustomer.setBounds(165, 135, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowCustomer);

		jtextFieldBorrowCreated = new JTextField();
		jtextFieldBorrowCreated.setText("<dynamic>");
		jtextFieldBorrowCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowCreated.setEditable(false);
		jtextFieldBorrowCreated.setColumns(10);
		jtextFieldBorrowCreated.setBounds(165, 175, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowCreated);

		JLabel lblNewLabel_1_2 = new JLabel("Borrow Created:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(45, 183, 110, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Borrow Due Date:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(45, 216, 110, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_3);

		jtextFieldBorrowDueDate = new JTextField();
		jtextFieldBorrowDueDate.setText("<dynamic>");
		jtextFieldBorrowDueDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowDueDate.setEditable(false);
		jtextFieldBorrowDueDate.setColumns(10);
		jtextFieldBorrowDueDate.setBounds(165, 215, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowDueDate);

		jtextFieldCreated = new JTextField();
		jtextFieldCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldCreated.setEditable(false);
		jtextFieldCreated.setColumns(10);
		jtextFieldCreated.setBounds(165, 257, 200, 30);
		jpanelBorrowTicket.add(jtextFieldCreated);

		JLabel lblNewLabel_1_4 = new JLabel("Created:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(45, 254, 110, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_6 = new JLabel("Book List");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_6.setBounds(397, 55, 90, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane.setBounds(400, 95, 424, 352);
		jpanelBorrowTicket.add(scrollPane);

		jtableBorrowBook = new JTable();
		jtableBorrowBook.setBackground(new Color(255, 255, 255));
		jtableBorrowBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableBorrowBook);

		JLabel lblNewLabel_1_4_1 = new JLabel("Overdue Days:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_1.setBounds(45, 297, 110, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_4_1);

		jtextFieldOverdueDay = new JTextField();
		jtextFieldOverdueDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldOverdueDay.setEditable(false);
		jtextFieldOverdueDay.setColumns(10);
		jtextFieldOverdueDay.setBounds(165, 297, 200, 30);
		jpanelBorrowTicket.add(jtextFieldOverdueDay);

		JLabel lblNewLabel_1_4_2 = new JLabel("Deposit:");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4_2.setBounds(45, 337, 110, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_4_2);

		jtextFieldBorrowDeposit = new JTextField();
		jtextFieldBorrowDeposit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowDeposit.setEditable(false);
		jtextFieldBorrowDeposit.setColumns(10);
		jtextFieldBorrowDeposit.setBounds(165, 337, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowDeposit);

		JLabel lblNewLabel_1_4_3 = new JLabel("Fines:");
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4_3.setBounds(45, 377, 110, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_4_3);

		jtextFieldFines = new JTextField();
		jtextFieldFines.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldFines.setEditable(false);
		jtextFieldFines.setColumns(10);
		jtextFieldFines.setBounds(165, 377, 200, 30);
		jpanelBorrowTicket.add(jtextFieldFines);

		JLabel lblNewLabel_1_4_4 = new JLabel("Total:");
		lblNewLabel_1_4_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4_4.setBounds(45, 417, 110, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_4_4);

		jtextFieldTotal = new JTextField();
		jtextFieldTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldTotal.setEditable(false);
		jtextFieldTotal.setColumns(10);
		jtextFieldTotal.setBounds(165, 417, 200, 30);
		jpanelBorrowTicket.add(jtextFieldTotal);

		JLabel lblNewLabel_1_4_5 = new JLabel("ID Borrow:");
		lblNewLabel_1_4_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4_5.setBounds(45, 55, 110, 13);
		jpanelBorrowTicket.add(lblNewLabel_1_4_5);

		jtextFieldBorrowId = new JTextField();
		jtextFieldBorrowId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldBorrowId.setEditable(false);
		jtextFieldBorrowId.setColumns(10);
		jtextFieldBorrowId.setBounds(165, 55, 200, 30);
		jpanelBorrowTicket.add(jtextFieldBorrowId);

		jbuttonSave = new JButton("Save");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		jbuttonSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonSave.setBounds(45, 505, 100, 30);
		jpanelBorrowTicket.add(jbuttonSave);

		jbuttonCancel = new JButton("Cancel");
		jbuttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancel_actionPerformed(e);
			}
		});
		jbuttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonCancel.setBounds(156, 505, 100, 30);
		jpanelBorrowTicket.add(jbuttonCancel);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public JPanelBorrowedAdd(JPanel JpanelRight, Map<String, Object> data) {
		this(JpanelRight);
		this.data = data;
		initJFrame();
	}

// Logic Functions
	private boolean createBorrowed(int id_borrow, Date created_borrow, Date due_date_borrow, Date created,
			int overdue_day, double deposit, double fines, double total) {
		borrowed = setValueBorrowed(id_borrow, created_borrow, due_date_borrow, created, overdue_day, deposit, fines,
				total);
		return borrowedModel.create(borrowed);
	}

	private Borrowed setValueBorrowed(int id_borrow, Date created_borrow, Date due_date_borrow, Date created,
			int overdue_day, double deposit, double fines, double total) {
		try {
			borrowed = new Borrowed();
			borrowed.setId_borrow(id_borrow);
			borrowed.setCreated_borrow(created_borrow);
			borrowed.setDue_date_borrow(due_date_borrow);
			borrowed.setCreated(created);
			borrowed.setOverdue_day(overdue_day);
			borrowed.setDeposit_borrow(deposit);
			borrowed.setFines(fines);
			borrowed.setTotal(total);

			return borrowed;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	Event Functions
	private void initJFrame() {

		calendarToday = Calendar.getInstance();
		today = calendarToday.getTime();

		int idBorrow = Integer.parseInt(this.data.get("idBorrow").toString());
		borrow = borrowModel.find(idBorrow);

		borrowDetailList = borrowDetailModel.findByBorrowId(idBorrow);

		fillDataToJTableBorrowBook(borrowDetailModel.findByBorrowId(idBorrow));

		jtextFieldBorrowId.setText(String.valueOf(borrow.getId()));
		jtextFieldborrowEmployee.setText(employeeModel.find(borrow.getId_employee()).getName());
		jtextFieldBorrowCustomer.setText(customerModel.find(borrow.getId_customer()).getName());
		jtextFieldBorrowCreated.setText(simpleDateFormat.format(borrow.getCreated()));
		jtextFieldBorrowDueDate.setText(simpleDateFormat.format(borrow.getDue_date()));
		jtextFieldBorrowDeposit.setText(String.valueOf(borrow.getDeposit()));

		jtextFieldCreated.setText(simpleDateFormat.format(today));
//		Overdue Days
		LocalDate borrowDueDate = LocalDate.parse(simpleDateFormatSQL.format(borrow.getDue_date()),
				DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate todayDate = LocalDate.parse(simpleDateFormatSQL.format(today), DateTimeFormatter.ISO_LOCAL_DATE);
		Duration diff = Duration.between(borrowDueDate.atStartOfDay(), todayDate.atStartOfDay());
		long diffDays = diff.toDays();
		Integer diffDaysInt = (int) (long) diffDays;
		overdueDay = diffDaysInt;
		fines = diffDaysInt * 10;
		total = fines;
//		System.out.println(overdueDays.toString());
//========================================================
		if (overdueDay > 0) {
			jtextFieldOverdueDay.setText(String.valueOf(overdueDay));
			jtextFieldFines.setText(String.valueOf(fines));
			jtextFieldTotal.setText(String.valueOf(total));

		} else {
			fines = 0;
			total = 0;
			overdueDay = 0;
			jtextFieldOverdueDay.setText(String.valueOf(overdueDay));
			jtextFieldFines.setText(String.valueOf(fines));
			jtextFieldTotal.setText(String.valueOf(total));
		}

	}

	private void jbuttonSave_actionPerformed(ActionEvent e) {
		try {
			if (createBorrowed(borrow.getId(), borrow.getCreated(), borrow.getDue_date(), today, overdueDay,
					borrow.getDeposit(), fines, total) && updateBookInLibrary()
					&& borrowModel.updateStatus(borrow, true)) {
				JOptionPane.showMessageDialog(this, "Success Borrowed");

				jpanelRight.removeAll();
				jpanelRight.revalidate();
				JPanelBorrowedList jPanelBorrowedList = new JPanelBorrowedList(jpanelRight);
				jpanelRight.add(jPanelBorrowedList);
				jPanelBorrowedList.setVisible(true);

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}

	private void jbuttonCancel_actionPerformed(ActionEvent e) {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
		JPanelBorrowedList jPanelBorrowedList = new JPanelBorrowedList(jpanelRight);
		jpanelRight.add(jPanelBorrowedList);
		jPanelBorrowedList.setVisible(true);
	}

	private boolean updateBookInLibrary() {
		for (BorrowDetail bd : borrowDetailList) {
			Book bookInLibrary = bookModel.find(bd.getId_book());

			if (bookModel.updateQuantity(bookInLibrary, bookInLibrary.getQuantity() + bd.getQuantity()) == false) {
				JOptionPane.showMessageDialog(this, "Failed Update Quantity");
				return false;
			}
			if (bookInLibrary.getQuantity() == 0) {
				if (bookModel.updateStatus(bookInLibrary, true) == false) {
					JOptionPane.showMessageDialog(this, "Failed Update Status");
					return false;
				}
			}
		}

		JOptionPane.showMessageDialog(this, "Success");
		return true;
	}

	// Components
	private void fillDataToJTableBorrowBook(List<BorrowDetail> borrowDetailList) {
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

		jtableBorrowBook.setModel(defaultTableModel);
		jtableBorrowBook.getTableHeader().setReorderingAllowed(false);
		jtableBorrowBook.setRowHeight(50);
		
		HeaderRenderer header = new HeaderRenderer(jtableBorrowBook.getTableHeader().getDefaultRenderer());
		for (int i = 0; i < jtableBorrowBook.getModel().getColumnCount(); i++) {
			jtableBorrowBook.getColumnModel().getColumn(i).setHeaderRenderer(header);
		}
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
			comp.setForeground(new Color(102, 102, 255));
			return comp;
		}
	}
}
