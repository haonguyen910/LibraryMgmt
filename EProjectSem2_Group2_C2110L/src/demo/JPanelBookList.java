package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;

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

import entities.Book;
import models.BookModel;

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

public class JPanelBookList extends JPanel {
	private JTextField jtextFieldKeyword;
	private JButton jbuttonSearch;
	private JTable jtableBook;
	BookModel bookModel = new BookModel();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JComboBox jcomboBoxSearchType;
	private JButton jbuttonCancelSearch;
	private JButton jbuttonAdd;
	private JButton jbuttonDelete;
	private JButton jbuttonEdit;

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

		jcomboBoxSearchType = new JComboBox();
		panel_1.add(jcomboBoxSearchType);
		panel_1.add(jbuttonSearch);

		jbuttonCancelSearch = new JButton("Cancel");
		jbuttonCancelSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancelSearch_actionPerformed(e);
			}
		});
		panel_1.add(jbuttonCancelSearch);

		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		jtableBook = new JTable();
		jtableBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableBook_mouseClicked(e);
			}
		});
		jtableBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableBook);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		add(panel_3);

		jbuttonAdd = new JButton("Add");
		jbuttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAdd_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonAdd);

		jbuttonDelete = new JButton("Delete");
		jbuttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDelete_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonDelete);

		jbuttonEdit = new JButton("Edit");
		jbuttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEdit_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonEdit);

		initJFrame();

	}

	// Functions
	private void initJFrame() {
		fillDataToJTable(bookModel.findAll());
		fillDataToJComboBox();
		jbuttonCancelSearch.setVisible(false);
		jbuttonDelete.setVisible(false);
		jbuttonEdit.setVisible(false);
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

	}

	public void jbuttonCancelSearch_actionPerformed(ActionEvent e) {
		fillDataToJTable(bookModel.findAll());
		jtextFieldKeyword.setText("");
		jbuttonCancelSearch.setVisible(false);
	}

	public void jbuttonAdd_actionPerformed(ActionEvent e) {
		JFrameBookAdd jFrameBookAdd = new JFrameBookAdd();
		jFrameBookAdd.setVisible(true);
	}

	public void jtableBook_mouseClicked(MouseEvent e) {

	}

	public void jbuttonDelete_actionPerformed(ActionEvent e) {

	}

	public void jbuttonEdit_actionPerformed(ActionEvent e) {
		int selectedRow = jtableBook.getSelectedRow();
		String callNumber = jtableBook.getValueAt(selectedRow, 0).toString();

		Map<String, Object> data = new HashMap<>();
		data.put("callNumber", callNumber);

		JFrameBookEdit jFrameBookEdit = new JFrameBookEdit(data);
		jFrameBookEdit.setVisible(true);

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
		defaultTableModel.addColumn("Description");
		defaultTableModel.addColumn("Category");
		defaultTableModel.addColumn("Quantity");
		defaultTableModel.addColumn("Price");
		defaultTableModel.addColumn("Issue Status");

		for (Book book : bookList) {
			defaultTableModel.addRow(new Object[] { book.getCallNumber(), book.getISBN(), book.getPhoto(),
					book.getTitle(), book.getAuthor(), book.getDescription(), book.getCategory().toUpperCase(),
					book.getQuantity(), book.getPrice(), book.isStatus() ? "In Library" : "Out of Stock" });
		}

		jtableBook.setModel(defaultTableModel);
		jtableBook.getTableHeader().setReorderingAllowed(false);
		jtableBook.setRowHeight(50);
		jtableBook.getColumnModel().getColumn(2).setCellRenderer(new ImageCellRender());
	}

	private void fillDataToJComboBox() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("Call Number");
		defaultComboBoxModel.addElement("ISBN");
		defaultComboBoxModel.addElement("Title");
		defaultComboBoxModel.addElement("Author");
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

}
