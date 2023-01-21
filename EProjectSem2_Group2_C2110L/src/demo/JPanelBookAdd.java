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
import models.AuthorModel;
import models.BookModel;
import models.Book_AuthorModel;
import models.Book_CategoryModel;
import models.CategoryModel;

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
import java.util.List;
import java.awt.ComponentOrientation;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

public class JPanelBookAdd extends JPanel {
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
	private File file;

	public JPanelBookAdd(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 200));
		panel.setBackground(new Color(128, 128, 192));
		FlowLayout fl_panel = (FlowLayout) panel.getLayout();
		fl_panel.setAlignment(FlowLayout.LEFT);
		add(panel);

		JLabel lblNewLabel = new JLabel("Add Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		jlabelPhoto = new JLabel("");
		jlabelPhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlabelPhoto.setBounds(30, 30, 150, 150);
		panel_2.add(jlabelPhoto);

		jbuttonBrowser = new JButton("Browser");
		jbuttonBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBrowser_actionPerformed(e);
			}
		});
		jbuttonBrowser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonBrowser.setBounds(55, 190, 100, 30);
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
		jcomboBoxCategory.setBounds(351, 434, 200, 30);
		panel_2.add(jcomboBoxCategory);

		jcomboBoxAuthor = new JComboBox();
		jcomboBoxAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcomboBoxAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxAuthor_actionPerformed(e);
			}
		});
		jcomboBoxAuthor.setBounds(351, 394, 200, 30);
		panel_2.add(jcomboBoxAuthor);

		jdateChooserCreated = new JDateChooser();
		jdateChooserCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jdateChooserCreated.setBounds(351, 354, 200, 30);
		panel_2.add(jdateChooserCreated);

		jtextFieldPrice = new JTextField();
		jtextFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldPrice.setColumns(10);
		jtextFieldPrice.setBounds(351, 312, 200, 30);
		panel_2.add(jtextFieldPrice);

		jtextFieldQuantity = new JTextField();
		jtextFieldQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldQuantity.setColumns(10);
		jtextFieldQuantity.setBounds(351, 273, 200, 30);
		panel_2.add(jtextFieldQuantity);

		jtextFieldTitle = new JTextField();
		jtextFieldTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldTitle.setColumns(10);
		jtextFieldTitle.setBounds(351, 111, 200, 30);
		panel_2.add(jtextFieldTitle);

		jtextFieldISBN = new JTextField();
		jtextFieldISBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldISBN.setColumns(10);
		jtextFieldISBN.setBounds(351, 70, 200, 30);
		panel_2.add(jtextFieldISBN);

		jtextFieldCallNumber = new JTextField();
		jtextFieldCallNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldCallNumber.setColumns(10);
		jtextFieldCallNumber.setBounds(351, 30, 200, 30);
		panel_2.add(jtextFieldCallNumber);

		jbuttonAddAuthor = new JButton("Add Author");
		jbuttonAddAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonAddAuthor.setBounds(588, 393, 120, 30);
		panel_2.add(jbuttonAddAuthor);

		jbuttonAddCategory = new JButton("Add Category");
		jbuttonAddCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonAddCategory.setBounds(588, 433, 120, 30);
		panel_2.add(jbuttonAddCategory);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(351, 156, 200, 100);
		panel_2.add(scrollPane);

		jtextAreaDescription = new JTextArea();
		jtextAreaDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(jtextAreaDescription);
//		Function
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

	private void jcomboBoxAuthor_actionPerformed(ActionEvent e) {
		Author author = (Author) jcomboBoxAuthor.getSelectedItem();
	}

	private void jcomboBoxCategory_actionPerformed(ActionEvent e) {
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
				jpanelRight.removeAll();
				jpanelRight.revalidate();
				JPanelBookList jPanelBookList = new JPanelBookList(jpanelRight);
				jpanelRight.add(jPanelBookList);
				jPanelBookList.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}

	private void jbuttonCancel_actionPerformed(ActionEvent e) {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
		JPanelBookList jPanelBookList = new JPanelBookList(jpanelRight);
		jpanelRight.add(jPanelBookList);
		jPanelBookList.setVisible(true);
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
