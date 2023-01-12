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

public class JFrameBookAdd extends JFrame {

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
	BookModel bookModel = new BookModel();
	AuthorModel authorModel = new AuthorModel();
	CategoryModel categoryModel = new CategoryModel();
	Book_AuthorModel book_AuthorModel = new Book_AuthorModel();
	Book_CategoryModel book_CategoryModel = new Book_CategoryModel();
	private Book book;
	private Author author;
	private Category category;
	private Book_Author book_Author;
	private Book_Category book_Category;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameBookAdd frame = new JFrameBookAdd();
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
	public JFrameBookAdd() {
		setTitle("Add Book");
		setBounds(100, 100, 800, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add Book");
		lblNewLabel.setForeground(new Color(128, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 114, 25);
		contentPane.add(lblNewLabel);

		jlabelPhoto = new JLabel("");
		jlabelPhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlabelPhoto.setBounds(51, 63, 150, 150);
		contentPane.add(jlabelPhoto);

		jbuttonBrowser = new JButton("Browser");
		jbuttonBrowser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBrowser_actionPerformed(e);
			}
		});
		jbuttonBrowser.setBounds(76, 223, 100, 30);
		contentPane.add(jbuttonBrowser);

		lblNewLabel_1 = new JLabel("Call Number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(250, 63, 90, 13);
		contentPane.add(lblNewLabel_1);

		jtextFieldCallNumber = new JTextField();
		jtextFieldCallNumber.setBounds(350, 60, 200, 30);
		contentPane.add(jtextFieldCallNumber);
		jtextFieldCallNumber.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("ISBN:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(250, 98, 90, 13);
		contentPane.add(lblNewLabel_1_1);

		jtextFieldISBN = new JTextField();
		jtextFieldISBN.setColumns(10);
		jtextFieldISBN.setBounds(350, 95, 200, 30);
		contentPane.add(jtextFieldISBN);

		JLabel lblNewLabel_1_2 = new JLabel("Title");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(250, 139, 90, 13);
		contentPane.add(lblNewLabel_1_2);

		jtextFieldTitle = new JTextField();
		jtextFieldTitle.setColumns(10);
		jtextFieldTitle.setBounds(350, 136, 200, 30);
		contentPane.add(jtextFieldTitle);

		JLabel lblNewLabel_1_3 = new JLabel("Quantity:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(250, 174, 90, 13);
		contentPane.add(lblNewLabel_1_3);

		jtextFieldQuantity = new JTextField();
		jtextFieldQuantity.setColumns(10);
		jtextFieldQuantity.setBounds(350, 171, 200, 30);
		contentPane.add(jtextFieldQuantity);

		JLabel lblNewLabel_1_4 = new JLabel("Price:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(250, 209, 90, 13);
		contentPane.add(lblNewLabel_1_4);

		jtextFieldPrice = new JTextField();
		jtextFieldPrice.setColumns(10);
		jtextFieldPrice.setBounds(350, 206, 200, 30);
		contentPane.add(jtextFieldPrice);

		JLabel lblNewLabel_1_5 = new JLabel("Description:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(250, 241, 90, 13);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_7 = new JLabel("Created:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_7.setBounds(250, 363, 90, 13);
		contentPane.add(lblNewLabel_1_7);

		JLabel lblNewLabel_1_8 = new JLabel("Author:");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_8.setBounds(250, 404, 90, 13);
		contentPane.add(lblNewLabel_1_8);

		JLabel lblNewLabel_1_9 = new JLabel("Category:");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_9.setBounds(250, 444, 90, 13);
		contentPane.add(lblNewLabel_1_9);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(349, 241, 201, 112);
		contentPane.add(scrollPane);

		jtextAreaDescription = new JTextArea();
		scrollPane.setViewportView(jtextAreaDescription);

		jdateChooserCreated = new JDateChooser();
		jdateChooserCreated.setBounds(350, 363, 200, 30);
		contentPane.add(jdateChooserCreated);

		jcomboBoxAuthor = new JComboBox();
		jcomboBoxAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxAuthor_actionPerformed(e);
			}
		});
		jcomboBoxAuthor.setBounds(350, 400, 200, 30);
		contentPane.add(jcomboBoxAuthor);

		jcomboBoxCategory = new JComboBox();
		jcomboBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxCategory_actionPerformed(e);
			}
		});
		jcomboBoxCategory.setBounds(350, 440, 200, 30);
		contentPane.add(jcomboBoxCategory);

		jbuttonAddAuthor = new JButton("Add Author");
		jbuttonAddAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonAddAuthor.setBounds(560, 400, 120, 30);
		contentPane.add(jbuttonAddAuthor);

		JButton btnNewButton_1 = new JButton("Add Category");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(560, 440, 120, 30);
		contentPane.add(btnNewButton_1);

		jbuttonSave = new JButton("Save");
		jbuttonSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		jbuttonSave.setBounds(250, 528, 100, 30);
		contentPane.add(jbuttonSave);

		jbuttonCancel = new JButton("Cancel");
		jbuttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancel_actionPerformed(e);
			}
		});
		jbuttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonCancel.setBounds(365, 528, 100, 30);
		contentPane.add(jbuttonCancel);

		jcheckBoxStatus = new JCheckBox("Issue Status");
		jcheckBoxStatus.setSelected(true);
		jcheckBoxStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcheckBoxStatus.setBounds(350, 475, 93, 30);
		contentPane.add(jcheckBoxStatus);

		initJFrame();
	}

//	Functions
	private void initJFrame() {
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
			book = new Book();
			book.setCallNumber(jtextFieldCallNumber.getText());
			book.setISBN(jtextFieldISBN.getText());
			book.setTitle(jtextFieldTitle.getText());
			book.setDescription(jtextAreaDescription.getText());

			book.setQuantity(Integer.parseInt(jtextFieldQuantity.getText()));
			book.setPrice(Double.parseDouble(jtextFieldPrice.getText()));

			book.setCreated(jdateChooserCreated.getDate());
			book.setStatus(jcheckBoxStatus.isSelected());
			if (file != null) {
				book.setPhoto(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
			}

			author = (Author) jcomboBoxAuthor.getSelectedItem();
			book_Author = new Book_Author();
			book_Author.setId_book(jtextFieldCallNumber.getText());
			book_Author.setId_author(author.getId());

			category = (Category) jcomboBoxCategory.getSelectedItem();
			book_Category = new Book_Category();
			book_Category.setId_book(jtextFieldCallNumber.getText());
			book_Category.setId_category(category.getId());

			if (bookModel.create(book) && book_AuthorModel.create(book_Author)
					&& book_CategoryModel.create(book_Category)) {
				JOptionPane.showMessageDialog(this, "Success");
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}

	public void jbuttonCancel_actionPerformed(ActionEvent e) {
		this.setVisible(false);
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
