package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
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

import entities.Author;
import entities.Category;
import models.CategoryModel;

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
	private JPanel panel_4;
	private JLabel lblNewLabel_2;
	private JPanel panel_5;
	private JLabel lblNewLabel_3;

	/**
	 * Create the panel.
	 */
	public JPanelCategoryList(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 192));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);

		JLabel lblNewLabel = new JLabel("Category List");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
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
		
		panel_4 = new JPanel();
		add(panel_4);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_2.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_2.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_4.add(lblNewLabel_2);

		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		jtableCategory = new JTable();
		jtableCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtableCategory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableCategory_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableCategory);
		
		panel_5 = new JPanel();
		add(panel_5);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setPreferredSize(new Dimension(60, 30));
		lblNewLabel_3.setMinimumSize(new Dimension(60, 30));
		lblNewLabel_3.setMaximumSize(new Dimension(60, 30));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_5.add(lblNewLabel_3);

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
		jbuttonEdit.setEnabled(true);
		jbuttonDelete.setEnabled(true);
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
	}

}
