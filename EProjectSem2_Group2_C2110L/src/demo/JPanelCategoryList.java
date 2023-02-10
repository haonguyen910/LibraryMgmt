package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import demo.JPanelAuthorList.HeaderRenderer;
import entities.Category;
import models.Book_CategoryModel;
import models.CategoryModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.plaf.UIResource;

public class JPanelCategoryList extends JPanel {
//	JPanel Right Of JFrameMain
	private JPanel jpanelRight;

	private JTextField jtextFieldKeyword;
	private JButton jbuttonSearch;
	private JButton jbuttonCancel;
	private JTable jtableCategory;
	private JButton jbuttonAdd;
	private JButton jbuttonDelete;
	private JButton jbuttonEdit;

//	Global Variable
	CategoryModel categoryModel = new CategoryModel();
	Book_CategoryModel book_CategoryModel = new Book_CategoryModel();

	/**
	 * Create the panel.
	 */
	public JPanelCategoryList(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		add(panel);

		JLabel lblNewLabel = new JLabel(" Category List");
		lblNewLabel.setIcon(
				new ImageIcon(JPanelCategoryList.class.getResource("/resources/images/icons8-diversity-52.png")));
		lblNewLabel.setForeground(new Color(255, 51, 51));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(15);
		flowLayout_1.setHgap(10);
		add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Keyword:");
		lblNewLabel_1.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_1.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_1.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_1);

		jtextFieldKeyword = new JTextField();
		jtextFieldKeyword.setPreferredSize(new Dimension(200, 30));
		jtextFieldKeyword.setMinimumSize(new Dimension(200, 30));
		jtextFieldKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(jtextFieldKeyword);
		jtextFieldKeyword.setColumns(20);

		jbuttonSearch = new JButton("Search");
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});
		jbuttonSearch.setPreferredSize(new Dimension(100, 30));
		jbuttonSearch.setMinimumSize(new Dimension(100, 30));
		jbuttonSearch.setMaximumSize(new Dimension(100, 30));
		jbuttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(jbuttonSearch);

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
		panel_1.add(jbuttonCancel);

		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		panel_2.add(scrollPane, BorderLayout.CENTER);

		jtableCategory = new JTable();
		jtableCategory.setSelectionBackground(new Color(255, 51, 51));
		jtableCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtableCategory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableCategory_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableCategory);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(10);
		add(panel_3);

		jbuttonAdd = new JButton("Add");
		jbuttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAdd_actionPerformed(e);
			}
		});
		jbuttonAdd.setPreferredSize(new Dimension(100, 30));
		jbuttonAdd.setMinimumSize(new Dimension(100, 30));
		jbuttonAdd.setMaximumSize(new Dimension(100, 30));
		jbuttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(jbuttonAdd);

		jbuttonDelete = new JButton("Delete");
		jbuttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDelete_actionPerformed(e);
			}
		});
		jbuttonDelete.setPreferredSize(new Dimension(100, 30));
		jbuttonDelete.setMinimumSize(new Dimension(100, 30));
		jbuttonDelete.setMaximumSize(new Dimension(100, 30));
		jbuttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(jbuttonDelete);

		jbuttonEdit = new JButton("Edit");
		jbuttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEdit_actionPerformed(e);
			}
		});
		jbuttonEdit.setPreferredSize(new Dimension(100, 30));
		jbuttonEdit.setMinimumSize(new Dimension(100, 30));
		jbuttonEdit.setMaximumSize(new Dimension(100, 30));
		jbuttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(jbuttonEdit);

		initJFrame();

	}

//	Functions
	private void initJFrame() {
		fillDataToJTable(categoryModel.findAll());
		jbuttonCancel.setVisible(false);
		jbuttonDelete.setEnabled(false);
		jbuttonEdit.setEnabled(false);
	}

	private void jbuttonSearch_actionPerformed(ActionEvent e) {
		String keyword = jtextFieldKeyword.getText();
		fillDataToJTable(categoryModel.findByKeyword(keyword));
		jbuttonCancel.setVisible(true);
	}

	private void jbuttonCancel_actionPerformed(ActionEvent e) {
		fillDataToJTable(categoryModel.findAll());
		jtextFieldKeyword.setText("");
		jbuttonCancel.setVisible(false);
	}

	private void jtableCategory_mouseClicked(MouseEvent e) {
		int selectedRow = jtableCategory.getSelectedRow();
		int id = Integer.parseInt(jtableCategory.getValueAt(selectedRow, 0).toString());
		jbuttonEdit.setEnabled(true);

		if (book_CategoryModel.findByCategoryId(id) != null) {
			jbuttonDelete.setEnabled(false);
		} else {
			jbuttonDelete.setEnabled(true);
		}
	}

	private void jbuttonAdd_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelCategoryAdd jPanelCategoryAdd = new JPanelCategoryAdd(jpanelRight);
		jpanelRight.add(jPanelCategoryAdd);
		jPanelCategoryAdd.setVisible(true);
	}

	private void jbuttonEdit_actionPerformed(ActionEvent e) {
		int selectedRow = jtableCategory.getSelectedRow();
		int id = Integer.parseInt(jtableCategory.getValueAt(selectedRow, 0).toString());

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);

		clearScreen();
		JPanelCategoryEdit jPanelCategoryEdit = new JPanelCategoryEdit(jpanelRight, data);
		jpanelRight.add(jPanelCategoryEdit);
		jPanelCategoryEdit.setVisible(true);
	}

	private void jbuttonDelete_actionPerformed(ActionEvent e) {
		deleteBook();
		jbuttonEdit.setEnabled(false);
	}

	private void deleteBook() {
		int result = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			int selectedRow = jtableCategory.getSelectedRow();
			int id = Integer.parseInt(jtableCategory.getValueAt(selectedRow, 0).toString());

			if (categoryModel.delete(id)) {
				JOptionPane.showMessageDialog(this, "Success");
				fillDataToJTable(categoryModel.findAll());
			} else {
				JOptionPane.showMessageDialog(this, "Failed");
			}
		}
		jbuttonDelete.setEnabled(false);
	}

	private void clearScreen() {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
	}

	// Components
	private void fillDataToJTable(List<Category> categoryList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");

		for (Category category : categoryList) {
			defaultTableModel.addRow(new Object[] { category.getId(), category.getName() });
		}

		jtableCategory.setModel(defaultTableModel);
		jtableCategory.getTableHeader().setReorderingAllowed(false);
		jtableCategory.setRowHeight(30);

		HeaderRenderer header = new HeaderRenderer(jtableCategory.getTableHeader().getDefaultRenderer());
		for (int i = 0; i < jtableCategory.getModel().getColumnCount(); i++) {
			jtableCategory.getColumnModel().getColumn(i).setHeaderRenderer(header);
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
