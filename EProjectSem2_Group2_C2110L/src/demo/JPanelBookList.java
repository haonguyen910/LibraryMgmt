package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import entities.Author;
import entities.Book;
import entities.Book_Author;
import entities.Book_Category;
import entities.Category;
import entities.Employee;
import models.AuthorModel;
import models.BookModel;
import models.Book_AuthorModel;
import models.Book_CategoryModel;
import models.BorrowDetailModel;
import models.CategoryModel;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.UIResource;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

public class JPanelBookList extends JPanel {
	private JPanel jpanelRight;

	private JTextField jtextFieldKeyword;
	private JButton jbuttonSearch;
	private JComboBox jcomboBoxSearchType;
	private JButton jbuttonCancelSearch;
	private JButton jbuttonAdd;
	private JButton jbuttonDelete;
	private JButton jbuttonEdit;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JScrollPane scrollPane_1;
	private JTable jtableBook;
	private JTextField jtextFieldDetailCallNumber;
	private JTextField jtextFieldDetailISBN;
	private JTextField jtextFieldDetailTitle;
	private JTextField jtextFieldDetailAuthor;
	private JTextField jtextFieldDetailCategory;
	private JTextField jtextFieldDetailQuantity;
	private JTextField jtextFieldDetailPrice;
	private JTextField jtextFieldDetailCreated;
	private JTextField jtextFieldDetailStatus;
	private JLabel jlabelPhoto;
	private JTextArea jtextAreaDetailDescription;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	BookModel bookModel = new BookModel();
	AuthorModel authorModel = new AuthorModel();
	CategoryModel categoryModel = new CategoryModel();
	Book_AuthorModel book_AuthorModel = new Book_AuthorModel();
	Book_CategoryModel book_CategoryModel = new Book_CategoryModel();
	BorrowDetailModel borrowDetailModel = new BorrowDetailModel();
	private Map<String, Object> data;
	private Map<String, Object> dataPut;
	private Employee employee;

	/**
	 * Create the panel.
	 */
	public JPanelBookList(JPanel JpanelRight) {
		setBackground(new Color(240, 240, 240));
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(52, 52, 52));
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setVgap(15);
		add(panel);

		JLabel lblNewLabel = new JLabel("Book List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Keyword:");
		lblNewLabel_1.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_1.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_1.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_1);

		jtextFieldKeyword = new JTextField();
		jtextFieldKeyword.setMinimumSize(new Dimension(200, 30));
		jtextFieldKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldKeyword.setPreferredSize(new Dimension(200, 30));
		panel_1.add(jtextFieldKeyword);
		jtextFieldKeyword.setColumns(30);

		jbuttonSearch = new JButton("Search");
		jbuttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonSearch.setPreferredSize(new Dimension(80, 30));
		jbuttonSearch.setMaximumSize(new Dimension(80, 30));
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});

		jcomboBoxSearchType = new JComboBox();
		jcomboBoxSearchType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcomboBoxSearchType.setPreferredSize(new Dimension(150, 30));
		jcomboBoxSearchType.setMinimumSize(new Dimension(150, 30));
		panel_1.add(jcomboBoxSearchType);
		panel_1.add(jbuttonSearch);

		jbuttonCancelSearch = new JButton("Cancel");
		jbuttonCancelSearch.setPreferredSize(new Dimension(80, 30));
		jbuttonCancelSearch.setMinimumSize(new Dimension(80, 30));
		jbuttonCancelSearch.setMaximumSize(new Dimension(80, 30));
		jbuttonCancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonCancelSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancelSearch_actionPerformed(e);
			}
		});
		panel_1.add(jbuttonCancelSearch);

		panel_6 = new JPanel();
		add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Book Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(70, 68, 98)));
		panel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_7.setMinimumSize(new Dimension(400, 400));
		panel_7.setPreferredSize(new Dimension(400, 400));
		panel_6.add(panel_7, BorderLayout.WEST);
		panel_7.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Call Number:");
		lblNewLabel_1_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(172, 24, 100, 30);
		panel_7.add(lblNewLabel_1_1);

		jtextFieldDetailCallNumber = new JTextField();
		jtextFieldDetailCallNumber.setEditable(false);
		jtextFieldDetailCallNumber.setPreferredSize(new Dimension(200, 30));
		jtextFieldDetailCallNumber.setMinimumSize(new Dimension(200, 30));
		jtextFieldDetailCallNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldDetailCallNumber.setColumns(20);
		jtextFieldDetailCallNumber.setBounds(172, 54, 206, 30);
		panel_7.add(jtextFieldDetailCallNumber);

		JLabel lblNewLabel_1_1_1 = new JLabel("ISBN:");
		lblNewLabel_1_1_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_1.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_1.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(172, 84, 100, 30);
		panel_7.add(lblNewLabel_1_1_1);

		jtextFieldDetailISBN = new JTextField();
		jtextFieldDetailISBN.setEditable(false);
		jtextFieldDetailISBN.setPreferredSize(new Dimension(200, 30));
		jtextFieldDetailISBN.setMinimumSize(new Dimension(200, 30));
		jtextFieldDetailISBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldDetailISBN.setColumns(20);
		jtextFieldDetailISBN.setBounds(172, 113, 206, 30);
		panel_7.add(jtextFieldDetailISBN);

		JLabel lblNewLabel_1_1_2 = new JLabel("Title:");
		lblNewLabel_1_1_2.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_2.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_2.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_2.setBounds(172, 143, 100, 30);
		panel_7.add(lblNewLabel_1_1_2);

		jtextFieldDetailTitle = new JTextField();
		jtextFieldDetailTitle.setEditable(false);
		jtextFieldDetailTitle.setPreferredSize(new Dimension(200, 30));
		jtextFieldDetailTitle.setMinimumSize(new Dimension(200, 30));
		jtextFieldDetailTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldDetailTitle.setColumns(20);
		jtextFieldDetailTitle.setBounds(172, 173, 206, 30);
		panel_7.add(jtextFieldDetailTitle);

		JLabel lblNewLabel_1_1_3 = new JLabel("Author:");
		lblNewLabel_1_1_3.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_3.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_3.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_3.setBounds(172, 198, 100, 30);
		panel_7.add(lblNewLabel_1_1_3);

		jtextFieldDetailAuthor = new JTextField();
		jtextFieldDetailAuthor.setEditable(false);
		jtextFieldDetailAuthor.setPreferredSize(new Dimension(200, 30));
		jtextFieldDetailAuthor.setMinimumSize(new Dimension(200, 30));
		jtextFieldDetailAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldDetailAuthor.setColumns(20);
		jtextFieldDetailAuthor.setBounds(172, 228, 206, 30);
		panel_7.add(jtextFieldDetailAuthor);

		JLabel lblNewLabel_1_1_4 = new JLabel("Category:");
		lblNewLabel_1_1_4.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_4.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_4.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_4.setBounds(172, 258, 100, 30);
		panel_7.add(lblNewLabel_1_1_4);

		jtextFieldDetailCategory = new JTextField();
		jtextFieldDetailCategory.setEditable(false);
		jtextFieldDetailCategory.setPreferredSize(new Dimension(200, 30));
		jtextFieldDetailCategory.setMinimumSize(new Dimension(200, 30));
		jtextFieldDetailCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldDetailCategory.setColumns(20);
		jtextFieldDetailCategory.setBounds(172, 287, 206, 30);
		panel_7.add(jtextFieldDetailCategory);

		JLabel lblNewLabel_1_1_5 = new JLabel("Quantity:");
		lblNewLabel_1_1_5.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_5.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_5.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_5.setBounds(10, 258, 100, 30);
		panel_7.add(lblNewLabel_1_1_5);

		jtextFieldDetailQuantity = new JTextField();
		jtextFieldDetailQuantity.setEditable(false);
		jtextFieldDetailQuantity.setPreferredSize(new Dimension(200, 30));
		jtextFieldDetailQuantity.setMinimumSize(new Dimension(200, 30));
		jtextFieldDetailQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldDetailQuantity.setColumns(20);
		jtextFieldDetailQuantity.setBounds(10, 288, 140, 30);
		panel_7.add(jtextFieldDetailQuantity);

		JLabel lblNewLabel_1_1_6 = new JLabel("Price:");
		lblNewLabel_1_1_6.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_6.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_6.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_6.setBounds(10, 321, 100, 30);
		panel_7.add(lblNewLabel_1_1_6);

		jtextFieldDetailPrice = new JTextField();
		jtextFieldDetailPrice.setEditable(false);
		jtextFieldDetailPrice.setPreferredSize(new Dimension(200, 30));
		jtextFieldDetailPrice.setMinimumSize(new Dimension(200, 30));
		jtextFieldDetailPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldDetailPrice.setColumns(20);
		jtextFieldDetailPrice.setBounds(10, 350, 140, 30);
		panel_7.add(jtextFieldDetailPrice);

		JLabel lblNewLabel_1_1_7 = new JLabel("Created:");
		lblNewLabel_1_1_7.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_7.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_7.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_7.setBounds(172, 320, 100, 30);
		panel_7.add(lblNewLabel_1_1_7);

		jtextFieldDetailCreated = new JTextField();
		jtextFieldDetailCreated.setEditable(false);
		jtextFieldDetailCreated.setPreferredSize(new Dimension(200, 30));
		jtextFieldDetailCreated.setMinimumSize(new Dimension(200, 30));
		jtextFieldDetailCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldDetailCreated.setColumns(20);
		jtextFieldDetailCreated.setBounds(172, 349, 206, 30);
		panel_7.add(jtextFieldDetailCreated);

		JLabel lblNewLabel_1_1_8 = new JLabel("Issue Status:");
		lblNewLabel_1_1_8.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_8.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_8.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_8.setBounds(10, 380, 100, 30);
		panel_7.add(lblNewLabel_1_1_8);

		jtextFieldDetailStatus = new JTextField();
		jtextFieldDetailStatus.setEditable(false);
		jtextFieldDetailStatus.setPreferredSize(new Dimension(200, 30));
		jtextFieldDetailStatus.setMinimumSize(new Dimension(200, 30));
		jtextFieldDetailStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldDetailStatus.setColumns(20);
		jtextFieldDetailStatus.setBounds(10, 410, 140, 30);
		panel_7.add(jtextFieldDetailStatus);

		JLabel lblNewLabel_1_1_9 = new JLabel("Description:");
		lblNewLabel_1_1_9.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1_9.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1_9.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_9.setBounds(172, 380, 100, 30);
		panel_7.add(lblNewLabel_1_1_9);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 410, 206, 160);
		panel_7.add(scrollPane);

		jtextAreaDetailDescription = new JTextArea();
		jtextAreaDetailDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextAreaDetailDescription.setEditable(false);
		scrollPane.setViewportView(jtextAreaDetailDescription);

		jlabelPhoto = new JLabel("");
		jlabelPhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlabelPhoto.setBounds(10, 24, 140, 200);
		panel_7.add(jlabelPhoto);

		panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144), 1, true));
		panel_8.add(scrollPane_1, BorderLayout.CENTER);

		jtableBook = new JTable();
		jtableBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtableBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableBook_mouseClicked(e);
			}
		});
		scrollPane_1.setViewportView(jtableBook);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		flowLayout_2.setVgap(20);
		add(panel_3);

		jbuttonAdd = new JButton("Add");
		jbuttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonAdd.setMinimumSize(new Dimension(100, 30));
		jbuttonAdd.setMaximumSize(new Dimension(100, 30));
		jbuttonAdd.setPreferredSize(new Dimension(100, 30));
		jbuttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAdd_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonAdd);

		jbuttonDelete = new JButton("Delete");
		jbuttonDelete.setPreferredSize(new Dimension(100, 30));
		jbuttonDelete.setMinimumSize(new Dimension(100, 30));
		jbuttonDelete.setMaximumSize(new Dimension(100, 30));
		jbuttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDelete_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonDelete);

		jbuttonEdit = new JButton("Edit");
		jbuttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonEdit.setMinimumSize(new Dimension(100, 30));
		jbuttonEdit.setMaximumSize(new Dimension(100, 30));
		jbuttonEdit.setPreferredSize(new Dimension(100, 30));
		jbuttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEdit_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonEdit);

	}

	/**
	 * @wbp.parser.constructor
	 */
	public JPanelBookList(JPanel JpanelRight, Map<String, Object> data) {
		this(JpanelRight);
		this.data = data;
		initJFrame();
	}

	// Functions
	private void initJFrame() {
		employee = (Employee) data.get("employee");
		dataPut = new HashMap<String, Object>();
		dataPut.put("employee", employee);
		fillDataToJTable(bookModel.findAll());
		fillDataToJComboBox();

		if (employee.isIs_admin() == true) {
			jbuttonDelete.setEnabled(false);
			jbuttonEdit.setEnabled(false);
		} else {
			jbuttonDelete.setVisible(false);
			jbuttonEdit.setVisible(false);
			jbuttonAdd.setVisible(false);
		}
		jbuttonCancelSearch.setVisible(false);

	}

	private void jbuttonSearch_actionPerformed(ActionEvent e) {
		String keyword = jtextFieldKeyword.getText().trim();
		String searchType = jcomboBoxSearchType.getSelectedItem().toString();
		if (searchType.equalsIgnoreCase("ISBN")) {
			fillDataToJTable(bookModel.findByISBN(keyword));
		} else if (searchType.equalsIgnoreCase("Title")) {
			fillDataToJTable(bookModel.findByTitle(keyword));
		} else if (searchType.equalsIgnoreCase("Author")) {
			fillDataToJTable(bookModel.findByAuthor(keyword));
		} else {
			fillDataToJTable(bookModel.findByCallNumber(keyword));
		}
		jbuttonCancelSearch.setVisible(true);
		jbuttonDelete.setEnabled(false);
		jbuttonEdit.setEnabled(false);
		clearDetail();

	}

	private void jbuttonCancelSearch_actionPerformed(ActionEvent e) {
		fillDataToJTable(bookModel.findAll());
		jtextFieldKeyword.setText("");
		jbuttonCancelSearch.setVisible(false);
		clearDetail();
	}

	private void jbuttonAdd_actionPerformed(ActionEvent e) {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
		JPanelBookAdd jPanelBookAdd = new JPanelBookAdd(jpanelRight, dataPut);
		jpanelRight.add(jPanelBookAdd);
		jPanelBookAdd.setVisible(true);
	}

	private void jtableBook_mouseClicked(MouseEvent e) {

		int selectedRow = jtableBook.getSelectedRow();
		String callNumber = jtableBook.getValueAt(selectedRow, 0).toString();

		Book book = bookModel.find(callNumber);
		String status = book.isStatus() ? "In Library" : "Out Of Stock";
		jtextFieldDetailCallNumber.setText(book.getCallNumber());
		jtextFieldDetailISBN.setText(book.getISBN());
		jtextFieldDetailAuthor.setText(book.getAuthor());
		jtextFieldDetailCategory.setText(book.getCategory());
		jtextFieldDetailQuantity.setText(String.valueOf(book.getQuantity()));
		jtextFieldDetailPrice.setText(String.valueOf(book.getPrice()));
		jtextFieldDetailStatus.setText(status);
		jtextFieldDetailTitle.setText(book.getTitle());
		jtextFieldDetailCreated.setText(simpleDateFormat.format(book.getCreated()));
		jtextAreaDetailDescription.setText(book.getDescription());
		byte[] imageData = book.getPhoto();
		ImageIcon photo = new ImageIcon(new ImageIcon(imageData).getImage().getScaledInstance(jlabelPhoto.getWidth(),
				jlabelPhoto.getHeight(), Image.SCALE_DEFAULT));
		jlabelPhoto.setIcon(photo);

		if (borrowDetailModel.findOneByBookId(callNumber) != null) {
			jbuttonDelete.setEnabled(false);
		} else {
			jbuttonDelete.setEnabled(true);
		}
		jbuttonEdit.setEnabled(true);

	}

	private void jbuttonDelete_actionPerformed(ActionEvent e) {
		deleteBook();
		jbuttonEdit.setEnabled(false);
	}

	private void deleteBook() {
		int result = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			int selectedRow = jtableBook.getSelectedRow();
			String callNumber = jtableBook.getValueAt(selectedRow, 0).toString();

			Book book = bookModel.find(callNumber);
			Author author = authorModel.findOneByName(book.getAuthor());
			Category category = categoryModel.findOneByName(book.getCategory());
			Book_Author book_Author = book_AuthorModel.find(callNumber, author.getId());
			Book_Category book_Category = book_CategoryModel.find(callNumber, category.getId());

			if (book_AuthorModel.delete(book_Author.getId()) && book_CategoryModel.delete(book_Category.getId())
					&& bookModel.delete(callNumber)) {
				JOptionPane.showMessageDialog(this, "Book has been deleted...");
				fillDataToJTable(bookModel.findAll());
			} else {
				JOptionPane.showMessageDialog(this, "Failed, something went wrong...");
			}
		}
		jbuttonDelete.setEnabled(false);
	}

	private void jbuttonEdit_actionPerformed(ActionEvent e) {
		int selectedRow = jtableBook.getSelectedRow();
		String callNumber = jtableBook.getValueAt(selectedRow, 0).toString();

		dataPut.put("callNumber", callNumber);

		jpanelRight.removeAll();
		jpanelRight.revalidate();
		JPanelBookEdit jPanelBookEdit = new JPanelBookEdit(jpanelRight, dataPut);
		jpanelRight.add(jPanelBookEdit);
		jPanelBookEdit.setVisible(true);
	}

	private void clearDetail() {
		jtextFieldDetailCallNumber.setText(null);
		jtextFieldDetailISBN.setText(null);
		jtextFieldDetailAuthor.setText(null);
		jtextFieldDetailCategory.setText(null);
		jtextFieldDetailQuantity.setText(null);
		jtextFieldDetailPrice.setText(null);
		jtextFieldDetailStatus.setText(null);
		jtextFieldDetailTitle.setText(null);
		jtextFieldDetailCreated.setText(null);
		jtextAreaDetailDescription.setText(null);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("D:\\photo\\no-image.png").getImage()
				.getScaledInstance(jlabelPhoto.getWidth(), jlabelPhoto.getHeight(), Image.SCALE_DEFAULT));
		jlabelPhoto.setIcon(imageIcon);

	}

	// Components
	private void fillDataToJTable(List<Book> bookList) {
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
					book.getPrice(), book.isStatus() ? "In Library" : "Out of Stock" });
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

	private void fillDataToJComboBox() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("Title");
		defaultComboBoxModel.addElement("Author");
		defaultComboBoxModel.addElement("Call Number");
		defaultComboBoxModel.addElement("ISBN");
		jcomboBoxSearchType.setModel(defaultComboBoxModel);
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
