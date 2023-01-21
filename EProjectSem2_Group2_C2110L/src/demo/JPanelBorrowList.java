package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

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

import entities.Author;
import entities.Book;
import entities.Book_Author;
import entities.Book_Category;
import entities.Borrow;
import entities.Category;
import models.AuthorModel;
import models.BookModel;
import models.Book_AuthorModel;
import models.Book_CategoryModel;
import models.BorrowModel;
import models.CategoryModel;

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
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class JPanelBorrowList extends JPanel {
	private JPanel jpanelRight;

	private JTextField jtextFieldKeyword;
	private JButton jbuttonSearch;
	private JTable jtableBorrow;
	private JComboBox jcomboBoxSearchType;
	private JButton jbuttonCancelSearch;
	private JButton jbuttonAdd;
	private JButton jbuttonDelete;
	private JButton jbuttonEdit;
	private JPanel panel_4;
	private JDateChooser jdateChooserCreated;
	private JLabel lblNewLabel_2;
//	Global Variable
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	BorrowModel borrowModel = new BorrowModel();
	private JButton jbuttonCancelByCreated;
	private JButton jbuttonSearchByCreated;
	private JPanel panel_5;
	private JLabel lblNewLabel_3;
	private JPanel panel_6;
	private JLabel lblNewLabel_4;

	/**
	 * Create the panel.
	 */
	public JPanelBorrowList(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 192));
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel);

		JLabel lblNewLabel = new JLabel("Borrow List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Keyword:");
		lblNewLabel_1.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_1.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_1.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_1);

		jtextFieldKeyword = new JTextField();
		jtextFieldKeyword.setPreferredSize(new Dimension(500, 30));
		jtextFieldKeyword.setMinimumSize(new Dimension(500, 30));
		jtextFieldKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(jtextFieldKeyword);
		jtextFieldKeyword.setColumns(20);

		jbuttonSearch = new JButton("Search");
		jbuttonSearch.setMinimumSize(new Dimension(80, 30));
		jbuttonSearch.setPreferredSize(new Dimension(100, 30));
		jbuttonSearch.setMaximumSize(new Dimension(80, 30));
		jbuttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});

		jcomboBoxSearchType = new JComboBox();
		jcomboBoxSearchType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jcomboBoxSearchType.setMinimumSize(new Dimension(150, 30));
		jcomboBoxSearchType.setPreferredSize(new Dimension(150, 30));
		panel_1.add(jcomboBoxSearchType);
		panel_1.add(jbuttonSearch);

		jbuttonCancelSearch = new JButton("Cancel");
		jbuttonCancelSearch.setPreferredSize(new Dimension(100, 30));
		jbuttonCancelSearch.setMinimumSize(new Dimension(100, 30));
		jbuttonCancelSearch.setMaximumSize(new Dimension(100, 30));
		jbuttonCancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonCancelSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancelSearch_actionPerformed(e);
			}
		});
		panel_1.add(jbuttonCancelSearch);

		panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		add(panel_4);

		lblNewLabel_2 = new JLabel("Created:");
		lblNewLabel_2.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_2.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_2.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(lblNewLabel_2);

		jdateChooserCreated = new JDateChooser();
		jdateChooserCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jdateChooserCreated.setPreferredSize(new Dimension(200, 30));
		jdateChooserCreated.setMinimumSize(new Dimension(200, 30));
		panel_4.add(jdateChooserCreated);

		jbuttonSearchByCreated = new JButton("Search");
		jbuttonSearchByCreated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearchByCreated_actionPerformed(e);
			}
		});
		jbuttonSearchByCreated.setPreferredSize(new Dimension(100, 30));
		jbuttonSearchByCreated.setMinimumSize(new Dimension(80, 30));
		jbuttonSearchByCreated.setMaximumSize(new Dimension(80, 30));
		jbuttonSearchByCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(jbuttonSearchByCreated);

		jbuttonCancelByCreated = new JButton("Cancel");
		jbuttonCancelByCreated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancelByCreated_actionPerformed(e);
			}
		});
		jbuttonCancelByCreated.setPreferredSize(new Dimension(100, 30));
		jbuttonCancelByCreated.setMinimumSize(new Dimension(80, 30));
		jbuttonCancelByCreated.setMaximumSize(new Dimension(80, 30));
		jbuttonCancelByCreated.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(jbuttonCancelByCreated);

		panel_5 = new JPanel();
		add(panel_5);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_3.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_3.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_5.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		jtableBorrow = new JTable();
		jtableBorrow.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtableBorrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableBook_mouseClicked(e);
			}
		});
		jtableBorrow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableBorrow);

		panel_6 = new JPanel();
		add(panel_6);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_4.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_4.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_6.add(lblNewLabel_4);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		add(panel_3);

		jbuttonAdd = new JButton("Add");
		jbuttonAdd.setMinimumSize(new Dimension(100, 30));
		jbuttonAdd.setPreferredSize(new Dimension(100, 30));
		jbuttonAdd.setMaximumSize(new Dimension(100, 30));
		jbuttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAdd_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonAdd);

		jbuttonDelete = new JButton("Delete");
		jbuttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonDelete.setPreferredSize(new Dimension(100, 30));
		jbuttonDelete.setMinimumSize(new Dimension(100, 30));
		jbuttonDelete.setMaximumSize(new Dimension(100, 30));
		jbuttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDelete_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonDelete);

		jbuttonEdit = new JButton("Edit");
		jbuttonEdit.setPreferredSize(new Dimension(100, 30));
		jbuttonEdit.setMinimumSize(new Dimension(100, 30));
		jbuttonEdit.setMaximumSize(new Dimension(100, 30));
		jbuttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		fillDataToJTable(borrowModel.findAll());
		fillDataToJComboBox();
		jbuttonCancelSearch.setVisible(false);
		jbuttonCancelByCreated.setVisible(false);
		jbuttonDelete.setEnabled(false);
		jbuttonEdit.setEnabled(false);
	}

	private void jbuttonSearch_actionPerformed(ActionEvent e) {
		String keyword = jtextFieldKeyword.getText().trim();
		String searchType = jcomboBoxSearchType.getSelectedItem().toString();
		if (searchType.equalsIgnoreCase("ID")) {
			int id = Integer.parseInt(keyword);
			fillDataToJTable(borrowModel.findById(id));
		} else if (searchType.equalsIgnoreCase("Employee Name")) {
			fillDataToJTable(borrowModel.findByEmployeeName(keyword));
		} else if (searchType.equalsIgnoreCase("Customer Name")) {
			fillDataToJTable(borrowModel.findByCustomerName(keyword));
		}
		jbuttonCancelSearch.setVisible(true);

	}

	public void jbuttonSearchByCreated_actionPerformed(ActionEvent e) {
		fillDataToJTable(borrowModel.findByCreated(jdateChooserCreated.getDate()));
		jbuttonCancelByCreated.setVisible(true);
	}

	public void jbuttonCancelSearch_actionPerformed(ActionEvent e) {
		fillDataToJTable(borrowModel.findAll());
		jtextFieldKeyword.setText("");
		jbuttonCancelSearch.setVisible(false);
	}

	public void jbuttonCancelByCreated_actionPerformed(ActionEvent e) {
		fillDataToJTable(borrowModel.findAll());
		jdateChooserCreated.setDate(null);
		jbuttonCancelByCreated.setVisible(false);
	}

	public void jbuttonAdd_actionPerformed(ActionEvent e) {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
		JPanelBorrowAdd jPanelBorrowAdd = new JPanelBorrowAdd(jpanelRight);
		jpanelRight.add(jPanelBorrowAdd);
		jPanelBorrowAdd.setVisible(true);
	}

	public void jtableBook_mouseClicked(MouseEvent e) {
		jbuttonEdit.setEnabled(true);
		jbuttonDelete.setEnabled(true);
	}

	public void jbuttonDelete_actionPerformed(ActionEvent e) {
		deleteBook();
		jbuttonEdit.setEnabled(false);
	}

	public void deleteBook() {
		int result = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			int selectedRow = jtableBorrow.getSelectedRow();
			int id = Integer.parseInt(jtableBorrow.getValueAt(selectedRow, 0).toString());

			if (borrowModel.delete(id)) {
				JOptionPane.showMessageDialog(this, "Success");
				fillDataToJTable(borrowModel.findAll());
			} else {
				JOptionPane.showMessageDialog(this, "Failed");
			}
		}
		jbuttonDelete.setEnabled(false);
	}

	public void jbuttonEdit_actionPerformed(ActionEvent e) {
		int selectedRow = jtableBorrow.getSelectedRow();
		String callNumber = jtableBorrow.getValueAt(selectedRow, 0).toString();

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("callNumber", callNumber);

		jpanelRight.removeAll();
		jpanelRight.revalidate();
//		JPanelBookEdit jPanelBookEdit = new JPanelBookEdit(jpanelRight, data);
//		jpanelRight.add(jPanelBookEdit);
//		jPanelBookEdit.setVisible(true);
	}

	// Components
	private void fillDataToJTable(List<Borrow> borrowList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Customer Name");
		defaultTableModel.addColumn("Employee Name");
		defaultTableModel.addColumn("Created");
		defaultTableModel.addColumn("Due Date");
		defaultTableModel.addColumn("Deposit");

		for (Borrow borrow : borrowList) {
			defaultTableModel.addRow(new Object[] { borrow.getId(), borrow.getCustomerName(), borrow.getEmployeeName(),
					simpleDateFormat.format(borrow.getCreated()), simpleDateFormat.format(borrow.getDue_date()),
					borrow.getDeposit() });
		}

		jtableBorrow.setModel(defaultTableModel);
		jtableBorrow.getTableHeader().setReorderingAllowed(false);
		jtableBorrow.setRowHeight(50);
//		jtableBorrow.getColumnModel().getColumn(2).setCellRenderer(new ImageCellRender());
	}

	private void fillDataToJComboBox() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("ID Borrow");
		defaultComboBoxModel.addElement("Employee Name");
		defaultComboBoxModel.addElement("Customer Name");
//		defaultComboBoxModel.addElement("Employee ID");
//		defaultComboBoxModel.addElement("Customer ID");
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
