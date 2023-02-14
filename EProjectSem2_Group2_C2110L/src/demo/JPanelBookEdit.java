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
import entities.Category;
import entities.Employee;
import models.AuthorModel;
import models.BookModel;
import models.Book_AuthorModel;
import models.Book_CategoryModel;
import models.CategoryModel;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

public class JPanelBookEdit extends JPanel {
//	JPanel Right Of JFrameMain
	private JPanel jpanelRight;

	private JTextField jtextFieldPrice;
	private JTextField jtextFieldQuantity;
	private JTextField jtextFieldTitle;
	private JTextField jtextFieldISBN;
	private JTextField jtextFieldCallNumber;
	private JLabel jlabelPhoto;
	private JButton jbuttonBrowser;
	private JComboBox jcomboBoxAuthor;
	private JComboBox jcomboBoxCategory;
	private JButton jbuttonAddAuthor;
	private JButton jbuttonAddCategory;
	private JButton jbuttonSave;
	private JButton jbuttonCancel;
	private JCheckBox jcheckBoxStatus;
	private JDateChooser jdateChooserCreated;
	private JTextArea jtextAreaDescription;

//	Global Variable
	AuthorModel authorModel = new AuthorModel();
	CategoryModel categoryModel = new CategoryModel();
	BookModel bookModel = new BookModel();
	Book_AuthorModel book_AuthorModel = new Book_AuthorModel();
	Book_CategoryModel book_CategoryModel = new Book_CategoryModel();
	private Book book;
	private Author author;
	private Category category;
	private Book_Author book_Author;
	private Book_Category book_Category;
	private Map<String, Object> data;
	private File file;
	private JScrollPane scrollPane_1;
	private JTextArea txtrIsbnNnnnnnn;
	private JLabel lblNewLabel_2;
	private JTextField jtextFieldAuthor;
	private JTextField jtextFieldCategory;
	private Map<String, Object> dataPut;
	private Employee employee;

	/**
	 * Create the panel.
	 */
	public JPanelBookEdit(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 200));
		panel.setBackground(new Color(52, 52, 52));
		FlowLayout fl_panel = (FlowLayout) panel.getLayout();
		fl_panel.setHgap(15);
		fl_panel.setVgap(15);
		add(panel);

		JLabel lblNewLabel = new JLabel("Edit Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		jlabelPhoto = new JLabel("");
		jlabelPhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlabelPhoto.setBounds(30, 30, 150, 200);
		panel_2.add(jlabelPhoto);

		jbuttonBrowser = new JButton("Browser");
		jbuttonBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBrowser_actionPerformed(e);
			}
		});
		jbuttonBrowser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonBrowser.setBounds(60, 240, 100, 30);
		panel_2.add(jbuttonBrowser);

		JLabel lblNewLabel_1 = new JLabel("Call Number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(251, 30, 90, 13);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("ISBN:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(251, 70, 90, 13);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Title");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(251, 111, 90, 13);
		panel_2.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Quantity:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(251, 280, 90, 13);
		panel_2.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Price:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(251, 315, 90, 13);
		panel_2.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Description:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(251, 156, 90, 13);
		panel_2.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_7 = new JLabel("Created:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_7.setBounds(251, 354, 90, 13);
		panel_2.add(lblNewLabel_1_7);

		JLabel lblNewLabel_1_8 = new JLabel("Author:");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_8.setBounds(251, 402, 90, 13);
		panel_2.add(lblNewLabel_1_8);

		JLabel lblNewLabel_1_9 = new JLabel("Category:");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_9.setBounds(251, 442, 90, 13);
		panel_2.add(lblNewLabel_1_9);

		jbuttonSave = new JButton("Save");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		jbuttonSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonSave.setBounds(251, 524, 100, 30);
		panel_2.add(jbuttonSave);

		jbuttonCancel = new JButton("Cancel");
		jbuttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancel_actionPerformed(e);
			}
		});
		jbuttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonCancel.setBounds(366, 524, 100, 30);
		panel_2.add(jbuttonCancel);

		jcheckBoxStatus = new JCheckBox("Issue Status");
		jcheckBoxStatus.setSelected(true);
		jcheckBoxStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcheckBoxStatus.setBounds(351, 475, 93, 30);
		panel_2.add(jcheckBoxStatus);

		jcomboBoxCategory = new JComboBox();
		jcomboBoxCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcomboBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxCategory_actionPerformed(e);
			}
		});
		jcomboBoxCategory.setBounds(632, 435, 200, 30);
		panel_2.add(jcomboBoxCategory);

		jcomboBoxAuthor = new JComboBox();
		jcomboBoxAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcomboBoxAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxAuthor_actionPerformed(e);
			}
		});
		jcomboBoxAuthor.setBounds(632, 395, 200, 30);
		panel_2.add(jcomboBoxAuthor);

		jdateChooserCreated = new JDateChooser();
		jdateChooserCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jdateChooserCreated.setBounds(351, 354, 243, 30);
		panel_2.add(jdateChooserCreated);

		jtextFieldPrice = new JTextField();
		jtextFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldPrice.setColumns(25);
		jtextFieldPrice.setBounds(351, 312, 243, 30);
		panel_2.add(jtextFieldPrice);

		jtextFieldQuantity = new JTextField();
		jtextFieldQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldQuantity.setColumns(25);
		jtextFieldQuantity.setBounds(351, 273, 243, 30);
		panel_2.add(jtextFieldQuantity);

		jtextFieldTitle = new JTextField();
		jtextFieldTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldTitle.setColumns(25);
		jtextFieldTitle.setBounds(351, 111, 243, 30);
		panel_2.add(jtextFieldTitle);

		jtextFieldISBN = new JTextField();
		jtextFieldISBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldISBN.setColumns(25);
		jtextFieldISBN.setBounds(351, 70, 243, 30);
		panel_2.add(jtextFieldISBN);

		jtextFieldCallNumber = new JTextField();
		jtextFieldCallNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldCallNumber.setEditable(false);
		jtextFieldCallNumber.setColumns(25);
		jtextFieldCallNumber.setBounds(351, 30, 243, 30);
		panel_2.add(jtextFieldCallNumber);

		jbuttonAddAuthor = new JButton("Add Author");
		jbuttonAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAddAuthor_actionPerformed(e);
			}
		});
		jbuttonAddAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonAddAuthor.setBounds(869, 394, 120, 30);
		panel_2.add(jbuttonAddAuthor);

		jbuttonAddCategory = new JButton("Add Category");
		jbuttonAddCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAddCategory_actionPerformed(e);
			}
		});
		jbuttonAddCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonAddCategory.setBounds(869, 434, 120, 30);
		panel_2.add(jbuttonAddCategory);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(351, 156, 243, 100);
		panel_2.add(scrollPane);

		jtextAreaDescription = new JTextArea();
		jtextAreaDescription.setColumns(25);
		jtextAreaDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(jtextAreaDescription);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(626, 28, 398, 111);
		panel_2.add(scrollPane_1);

		txtrIsbnNnnnnnn = new JTextArea();
		txtrIsbnNnnnnnn.setEditable(false);
		txtrIsbnNnnnnnn.setText(
				"*) ISBN: NNN-NNNN\r\n- 3 characters is ORDINAL NUMBER of the CATEGORY\r\n- 4 characters is ORDINAL NUMBER of the BOOK");
		scrollPane_1.setViewportView(txtrIsbnNnnnnnn);

		lblNewLabel_2 = new JLabel("NOTE:");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane_1.setColumnHeaderView(lblNewLabel_2);

		jtextFieldAuthor = new JTextField();
		jtextFieldAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldAuthor.setColumns(25);
		jtextFieldAuthor.setBounds(351, 394, 243, 30);
		panel_2.add(jtextFieldAuthor);

		jtextFieldCategory = new JTextField();
		jtextFieldCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldCategory.setColumns(25);
		jtextFieldCategory.setBounds(351, 435, 243, 30);
		panel_2.add(jtextFieldCategory);
	}

//	Dynamic Data
	/**
	 * @wbp.parser.constructor
	 */
	public JPanelBookEdit(JPanel JpanelRight, Map<String, Object> data) {
		this(JpanelRight);
		this.data = data;
		initJFrame();
	}

//	Functions
	private void initJFrame() {
		employee = (Employee) data.get("employee");
		dataPut = new HashMap<String, Object>();
		dataPut.put("employee", employee);

		String callNumber = this.data.get("callNumber").toString();
		book = bookModel.find(callNumber);

		jtextFieldCallNumber.setText(book.getCallNumber());
		jtextFieldISBN.setText(book.getISBN());
		jtextFieldTitle.setText(book.getTitle());
		jtextAreaDescription.setText(book.getDescription());

		jtextFieldQuantity.setText(String.valueOf(book.getQuantity()));
		jtextFieldPrice.setText(String.valueOf(book.getPrice()));

		jdateChooserCreated.setDate(book.getCreated());
		jcheckBoxStatus.setSelected(book.isStatus());

		byte[] imageData = book.getPhoto();
		ImageIcon photo = new ImageIcon(new ImageIcon(imageData).getImage().getScaledInstance(jlabelPhoto.getWidth(),
				jlabelPhoto.getHeight(), Image.SCALE_DEFAULT));
		jlabelPhoto.setIcon(photo);

		jtextFieldAuthor.setText(book.getAuthor());
		author = authorModel.findOneByName(book.getAuthor());
		jtextFieldCategory.setText(book.getCategory());
		category = categoryModel.findOneByName(book.getCategory());

		fillDataToJComboBoxAuthor(authorModel.findAll());
		fillDataToJComboBoxCategory(categoryModel.findAll());

		int authorId = authorModel.findOneByName(book.getAuthor()).getId();
		book_Author = book_AuthorModel.find(book.getCallNumber(), authorId);

		int categoryId = categoryModel.findOneByName(book.getCategory()).getId();
		book_Category = book_CategoryModel.find(book.getCallNumber(), categoryId);
	}

	private void jbuttonBrowser_actionPerformed(ActionEvent e) {
		JFileChooser jfileChooser = new JFileChooser("D:\\photo");
		jfileChooser.setDialogTitle("Select a Photo");
		jfileChooser.setMultiSelectionEnabled(false);
		int result = jfileChooser.showOpenDialog(this);
		if (result == jfileChooser.APPROVE_OPTION) {
			file = jfileChooser.getSelectedFile();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage()
					.getScaledInstance(jlabelPhoto.getWidth(), jlabelPhoto.getHeight(), Image.SCALE_DEFAULT));
			jlabelPhoto.setIcon(imageIcon);
		}
	}

	private void jcomboBoxAuthor_actionPerformed(ActionEvent e) {
		author = (Author) jcomboBoxAuthor.getSelectedItem();
		jtextFieldAuthor.setText(author.getName());
	}

	private void jcomboBoxCategory_actionPerformed(ActionEvent e) {
		category = (Category) jcomboBoxCategory.getSelectedItem();
		jtextFieldCategory.setText(category.getName());
	}

	private void jbuttonSave_actionPerformed(ActionEvent e) {
		try {
			book.setISBN(jtextFieldISBN.getText());
			book.setTitle(jtextFieldTitle.getText());
			book.setDescription(jtextAreaDescription.getText());

			book.setQuantity(Integer.parseInt(jtextFieldQuantity.getText()));
			book.setPrice(Double.parseDouble(jtextFieldPrice.getText()));

			book.setCreated(jdateChooserCreated.getDate());
			book.setStatus(jcheckBoxStatus.isSelected());

			if (file != null) {
				book.setPhoto(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
			} else {
				book.setPhoto(book.getPhoto());
			}

			book_Author.setId_book(book.getCallNumber());
			book_Author.setId_author(author.getId());

			book_Category.setId_book(book.getCallNumber());
			book_Category.setId_category(category.getId());

			if (bookModel.update(book) && book_AuthorModel.update(book_Author)
					&& book_CategoryModel.update(book_Category)) {
				JOptionPane.showMessageDialog(this, "Successful updated book!");
				jpanelRight.removeAll();
				jpanelRight.revalidate();
				JPanelBookList jPanelBookList = new JPanelBookList(jpanelRight, dataPut);
				jpanelRight.add(jPanelBookList);
				jPanelBookList.setVisible(true);
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
		JPanelBookList jPanelBookList = new JPanelBookList(jpanelRight, dataPut);
		jpanelRight.add(jPanelBookList);
		jPanelBookList.setVisible(true);
	}

	public void jbuttonAddAuthor_actionPerformed(ActionEvent e) {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
		JPanelAuthorAdd jPanelAuthorAdd = new JPanelAuthorAdd(jpanelRight, dataPut);
		jpanelRight.add(jPanelAuthorAdd);
		jPanelAuthorAdd.setVisible(true);
	}

	public void jbuttonAddCategory_actionPerformed(ActionEvent e) {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
		JPanelCategoryAdd jPanelCategoryAdd = new JPanelCategoryAdd(jpanelRight, dataPut);
		jpanelRight.add(jPanelCategoryAdd);
		jPanelCategoryAdd.setVisible(true);
	}

//	Components
	private void fillDataToJComboBoxAuthor(List<Author> authorList) {
		DefaultComboBoxModel<Author> defaultComboBoxModel = new DefaultComboBoxModel<Author>();

		for (Author author : authorList) {
			defaultComboBoxModel.addElement(author);
		}
		jcomboBoxAuthor.setModel(defaultComboBoxModel);
		jcomboBoxAuthor.setRenderer(new AuthorCellRender());
	}

	private void fillDataToJComboBoxCategory(List<Category> categoryList) {
		DefaultComboBoxModel<Category> defaultComboBoxModel = new DefaultComboBoxModel<Category>();

		for (Category category : categoryList) {
			defaultComboBoxModel.addElement(category);
		}
		jcomboBoxCategory.setModel(defaultComboBoxModel);
		jcomboBoxCategory.setRenderer(new CategoryCellRender());
	}

	private class AuthorCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Author author = (Author) value;
			String s = author.getId() + " - " + author.getName();
			return super.getListCellRendererComponent(list, s, index, isSelected, cellHasFocus);
		}
	}

	private class CategoryCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Category category = (Category) value;
			String s = category.getId() + " - " + category.getName();
			return super.getListCellRendererComponent(list, s.toUpperCase(), index, isSelected, cellHasFocus);
		}
	}
}
