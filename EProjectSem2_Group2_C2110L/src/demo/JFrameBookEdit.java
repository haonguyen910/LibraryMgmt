package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;

import org.mindrot.jbcrypt.BCrypt;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import com.toedter.calendar.JDateChooser;

import entities.Author;
import entities.Book;
import entities.Book_Author;
import entities.Book_Category;
import entities.Category;
import models.AuthorModel;
import models.BookModel;
import models.Book_AuthorModel;
import models.Book_CategoryModel;
import models.CategoryModel;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class JFrameBookEdit extends JFrame {

	private JPanel contentPane;
	private JLabel jlabelPhoto;
	private JButton jbuttonBrowser;
	private File file;
	private JLabel lblNewLabel_1;
	private JTextField jtextFieldCallNumber;
	private JTextField jtextFieldISBN;
	private JTextField jtextFieldTitle;
	private JTextField jtextFieldQuantity;
	private JTextField jtextFieldPrice;
	private JButton jbuttonSave;
	private JButton jbuttonCancel;
	private JButton jbuttonAddAuthor;
	private JTextArea jtextAreaDescription;
	private JComboBox jcomboBoxAuthor;
	private JComboBox jcomboBoxCategory;
	private JDateChooser jdateChooserCreated;
	private JCheckBox jcheckBoxStatus;
	private Book book;
	AuthorModel authorModel = new AuthorModel();
	CategoryModel categoryModel = new CategoryModel();
	BookModel bookModel = new BookModel();
	Book_Author book_Author = new Book_Author();
	Book_Category book_Category = new Book_Category();
	Book_AuthorModel book_AuthorModel = new Book_AuthorModel();
	Book_CategoryModel book_CategoryModel = new Book_CategoryModel();
	private Map<String, Object> data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameBookEdit frame = new JFrameBookEdit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameBookEdit() {
		setTitle("Add Book");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Edit Book");
		lblNewLabel.setForeground(new Color(128, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 114, 25);
		contentPane.add(lblNewLabel);

		jlabelPhoto = new JLabel("");
		jlabelPhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlabelPhoto.setBounds(10, 45, 150, 150);
		contentPane.add(jlabelPhoto);

		jbuttonBrowser = new JButton("Browser");
		jbuttonBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBrowser_actionPerformed(e);
			}
		});
		jbuttonBrowser.setBounds(39, 205, 85, 21);
		contentPane.add(jbuttonBrowser);

		lblNewLabel_1 = new JLabel("Call Number:");
		lblNewLabel_1.setBounds(250, 45, 90, 13);
		contentPane.add(lblNewLabel_1);

		jtextFieldCallNumber = new JTextField();
		jtextFieldCallNumber.setBounds(350, 42, 200, 19);
		contentPane.add(jtextFieldCallNumber);
		jtextFieldCallNumber.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("ISBN:");
		lblNewLabel_1_1.setBounds(250, 75, 90, 13);
		contentPane.add(lblNewLabel_1_1);

		jtextFieldISBN = new JTextField();
		jtextFieldISBN.setColumns(10);
		jtextFieldISBN.setBounds(350, 72, 200, 19);
		contentPane.add(jtextFieldISBN);

		JLabel lblNewLabel_1_2 = new JLabel("Title");
		lblNewLabel_1_2.setBounds(250, 105, 90, 13);
		contentPane.add(lblNewLabel_1_2);

		jtextFieldTitle = new JTextField();
		jtextFieldTitle.setColumns(10);
		jtextFieldTitle.setBounds(350, 102, 200, 19);
		contentPane.add(jtextFieldTitle);

		JLabel lblNewLabel_1_3 = new JLabel("Quantity:");
		lblNewLabel_1_3.setBounds(250, 131, 90, 13);
		contentPane.add(lblNewLabel_1_3);

		jtextFieldQuantity = new JTextField();
		jtextFieldQuantity.setColumns(10);
		jtextFieldQuantity.setBounds(350, 128, 200, 19);
		contentPane.add(jtextFieldQuantity);

		JLabel lblNewLabel_1_4 = new JLabel("Price:");
		lblNewLabel_1_4.setBounds(250, 157, 90, 13);
		contentPane.add(lblNewLabel_1_4);

		jtextFieldPrice = new JTextField();
		jtextFieldPrice.setColumns(10);
		jtextFieldPrice.setBounds(350, 154, 200, 19);
		contentPane.add(jtextFieldPrice);

		JLabel lblNewLabel_1_5 = new JLabel("Description:");
		lblNewLabel_1_5.setBounds(250, 183, 90, 13);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_7 = new JLabel("Created:");
		lblNewLabel_1_7.setBounds(250, 310, 90, 13);
		contentPane.add(lblNewLabel_1_7);

		JLabel lblNewLabel_1_8 = new JLabel("Author:");
		lblNewLabel_1_8.setBounds(250, 343, 90, 13);
		contentPane.add(lblNewLabel_1_8);

		JLabel lblNewLabel_1_9 = new JLabel("Category:");
		lblNewLabel_1_9.setBounds(250, 373, 90, 13);
		contentPane.add(lblNewLabel_1_9);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(349, 183, 201, 112);
		contentPane.add(scrollPane);

		jtextAreaDescription = new JTextArea();
		scrollPane.setViewportView(jtextAreaDescription);

		jdateChooserCreated = new JDateChooser();
		jdateChooserCreated.setBounds(350, 310, 200, 19);
		contentPane.add(jdateChooserCreated);

		jcomboBoxAuthor = new JComboBox();
		jcomboBoxAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxAuthor_actionPerformed(e);
			}
		});
		jcomboBoxAuthor.setBounds(350, 339, 200, 21);
		contentPane.add(jcomboBoxAuthor);

		jcomboBoxCategory = new JComboBox();
		jcomboBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxCategory_actionPerformed(e);
			}
		});
		jcomboBoxCategory.setBounds(350, 369, 200, 21);
		contentPane.add(jcomboBoxCategory);

		jbuttonAddAuthor = new JButton("Add Author");
		jbuttonAddAuthor.setBounds(560, 339, 100, 21);
		contentPane.add(jbuttonAddAuthor);

		JButton btnNewButton_1 = new JButton("Add Category");
		btnNewButton_1.setBounds(560, 369, 100, 21);
		contentPane.add(btnNewButton_1);

		jbuttonSave = new JButton("Save");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		jbuttonSave.setBounds(250, 466, 85, 21);
		contentPane.add(jbuttonSave);

		jbuttonCancel = new JButton("Cancel");
		jbuttonCancel.setBounds(350, 466, 85, 21);
		contentPane.add(jbuttonCancel);

		jcheckBoxStatus = new JCheckBox("Issue Status");
		jcheckBoxStatus.setBounds(350, 404, 93, 21);
		contentPane.add(jcheckBoxStatus);

		initJFrame();
	}

	public JFrameBookEdit(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}

//	Functions
	private void initJFrame() {
		String callNumber = this.data.get("id").toString();
//		book = bookModel.findByCallNumber(callNumber);
		
		
		
		fillDataToJComboBoxAuthor(authorModel.findAll());
		fillDataToJComboBoxCategory(categoryModel.findAll());
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

	public void jcomboBoxAuthor_actionPerformed(ActionEvent e) {
		Author author = (Author) jcomboBoxAuthor.getSelectedItem();
	}

	public void jcomboBoxCategory_actionPerformed(ActionEvent e) {
		Category category = (Category) jcomboBoxCategory.getSelectedItem();
	}

	private void jbuttonSave_actionPerformed(ActionEvent e) {
		try {
			Book book = new Book();
			book.setCallNumber(jtextFieldCallNumber.getText());
			book.setISBN(jtextFieldISBN.getText());
			book.setTitle(jtextFieldTitle.getText());
			book.setDescription(jtextAreaDescription.getText());

			book.setQuantity(Integer.parseInt(jtextFieldQuantity.getText()));
			book.setPrice(Double.parseDouble(jtextFieldPrice.getText()));

			book.setCreated(jdateChooserCreated.getDate());
			book.setStatus(jcheckBoxStatus.isSelected());
			book.setPhoto(Files.readAllBytes(Paths.get(file.getAbsolutePath())));

			Author author = (Author) jcomboBoxAuthor.getSelectedItem();
			Book_Author book_Author = new Book_Author();
			book_Author.setId_book(jtextFieldCallNumber.getText());
			book_Author.setId_author(author.getId());

			Category category = (Category) jcomboBoxCategory.getSelectedItem();
			Book_Category book_Category = new Book_Category();
			book_Category.setId_book(jtextFieldCallNumber.getText());
			book_Category.setId_category(category.getId());

			if (bookModel.create(book) && book_AuthorModel.create(book_Author)
					&& book_CategoryModel.create(book_Category)) {
				JOptionPane.showMessageDialog(this, "Success");
				JFrameMain jFrameMain = new JFrameMain();
				jFrameMain.setVisible(true);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
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
