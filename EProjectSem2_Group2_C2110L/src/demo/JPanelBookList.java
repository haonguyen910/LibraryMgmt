package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.Book;
import models.BookModel;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelBookList extends JPanel {
	private JTextField jtextFieldKeyword;
	private JButton jbuttonSearch;
	private JTable jtableBook;
	BookModel bookModel = new BookModel();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Create the panel.
	 */
	public JPanelBookList() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 192));
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel);

		JLabel lblNewLabel = new JLabel("Book List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Keyword:");
		panel_1.add(lblNewLabel_1);

		jtextFieldKeyword = new JTextField();
		panel_1.add(jtextFieldKeyword);
		jtextFieldKeyword.setColumns(10);

		jbuttonSearch = new JButton("Search");
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});
		panel_1.add(jbuttonSearch);

		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		jtableBook = new JTable();
		scrollPane.setViewportView(jtableBook);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		add(panel_3);

		JButton btnNewButton = new JButton("Add");
		panel_3.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Delete");
		panel_3.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Edit");
		panel_3.add(btnNewButton_2);

		initJFrame();

	}

	// Functions
	private void initJFrame() {
		fillDataToJTable(bookModel.findAll());
	}

	private void jbuttonSearch_actionPerformed(ActionEvent e) {
		String keyword = jtextFieldKeyword.getText().trim();
		fillDataToJTable(bookModel.findByKeyword(keyword));
	}

	// Components
	private void fillDataToJTable(List<Book> bookList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("callNumber");
		defaultTableModel.addColumn("ISBN");
//			defaultTableModel.addColumn("");
		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Author");
		defaultTableModel.addColumn("Description");
		defaultTableModel.addColumn("Category");
		defaultTableModel.addColumn("Quantity");
		defaultTableModel.addColumn("Price");
		defaultTableModel.addColumn("Status");

		for (Book book : bookList) {
			defaultTableModel.addRow(new Object[] { book.getCallNumber(), book.getISBN(), book.getTitle(),
					book.getAuthor(), book.getDescription(), book.getCategory(), book.getQuantity(), book.getPrice(),
					book.isStatus() ? "In Library" : "Out of Stock" });
		}

		jtableBook.setModel(defaultTableModel);
		jtableBook.getTableHeader().setReorderingAllowed(false);
		jtableBook.setRowHeight(50);
	}

}
