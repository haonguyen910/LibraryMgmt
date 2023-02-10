package demo;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import demo.JPanelRecord.HeaderRenderer;
import entities.Author;
import entities.Book;
import entities.Book_Author;
import entities.Book_Category;
import entities.Category;
import models.AuthorModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.plaf.UIResource;

public class JPanelAuthorList extends JPanel {
//	JPanel Right Of JFrameMain
	private JPanel jpanelRight;

	private JTextField jtextFieldSearch;
	private JButton jbuttonSearch;
	private JButton jbuttonAdd;
	private JButton jbuttonDelete;
	private JButton jbuttonEdit;
	private JTable jtableAuthor;
	private JButton jbuttonCancelSearch;

//	Global Variable
	AuthorModel authorModel = new AuthorModel();

	/**
	 * Create the panel.
	 */
	public JPanelAuthorList(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		add(panel);

		JLabel lblNewLabel = new JLabel(" Author List");
		lblNewLabel.setIcon(new ImageIcon(JPanelAuthorList.class.getResource("/resources/images/icons8-writer-male-52.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(255, 51, 51));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setVgap(15);
		add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Keyword:");
		panel_1.add(lblNewLabel_1);

		jtextFieldSearch = new JTextField();
		jtextFieldSearch.setPreferredSize(new Dimension(200, 30));
		jtextFieldSearch.setMinimumSize(new Dimension(200, 30));
		jtextFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(jtextFieldSearch);
		jtextFieldSearch.setColumns(20);

		jbuttonSearch = new JButton("Search");
		jbuttonSearch.setPreferredSize(new Dimension(80, 30));
		jbuttonSearch.setMinimumSize(new Dimension(80, 30));
		jbuttonSearch.setMaximumSize(new Dimension(80, 30));
		jbuttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});
		panel_1.add(jbuttonSearch);

		jbuttonCancelSearch = new JButton("Cancel");
		jbuttonCancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonCancelSearch.setMinimumSize(new Dimension(80, 30));
		jbuttonCancelSearch.setMaximumSize(new Dimension(80, 30));
		jbuttonCancelSearch.setPreferredSize(new Dimension(80, 30));
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
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 1, true));
		panel_2.add(scrollPane, BorderLayout.CENTER);

		jtableAuthor = new JTable();
		jtableAuthor.setSelectionBackground(new Color(255, 51, 51));
		jtableAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtableAuthor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableAuthor_mouseClicked(e);
			}
		});
		jtableAuthor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableAuthor);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(10);
		add(panel_3);

		jbuttonAdd = new JButton("Add");
		jbuttonAdd.setPreferredSize(new Dimension(100, 30));
		jbuttonAdd.setMinimumSize(new Dimension(100, 30));
		jbuttonAdd.setMaximumSize(new Dimension(100, 30));
		jbuttonAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAdd_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonAdd);

		jbuttonDelete = new JButton("Delete");
		jbuttonDelete.setPreferredSize(new Dimension(100, 30));
		jbuttonDelete.setMaximumSize(new Dimension(100, 30));
		jbuttonDelete.setMinimumSize(new Dimension(100, 30));
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

		initJFrame();

	}

//	Functions
	private void initJFrame() {
		fillDataToJTable(authorModel.findAll());
		jbuttonCancelSearch.setVisible(false);
		jbuttonDelete.setEnabled(false);
		jbuttonEdit.setEnabled(false);
	}

	private void jbuttonSearch_actionPerformed(ActionEvent e) {
		String keyword = jtextFieldSearch.getText();
		fillDataToJTable(authorModel.findByKeyword(keyword));
		jbuttonCancelSearch.setVisible(true);
	}

	private void jbuttonCancelSearch_actionPerformed(ActionEvent e) {
		fillDataToJTable(authorModel.findAll());
		jtextFieldSearch.setText("");
		jbuttonCancelSearch.setVisible(false);
	}

	private void jbuttonAdd_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelAuthorAdd jPanelAuthorAdd = new JPanelAuthorAdd(jpanelRight);
		jpanelRight.add(jPanelAuthorAdd);
		jPanelAuthorAdd.setVisible(true);
	}

	private void jtableAuthor_mouseClicked(MouseEvent e) {
		jbuttonEdit.setEnabled(true);
		jbuttonDelete.setEnabled(true);
	}

	private void jbuttonEdit_actionPerformed(ActionEvent e) {
		int selectedRow = jtableAuthor.getSelectedRow();
		int id = Integer.parseInt(jtableAuthor.getValueAt(selectedRow, 0).toString());

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);

		clearScreen();
		JPanelAuthorEdit jPanelAuthorEdit = new JPanelAuthorEdit(jpanelRight, data);
		jpanelRight.add(jPanelAuthorEdit);
		jPanelAuthorEdit.setVisible(true);
	}

	private void jbuttonDelete_actionPerformed(ActionEvent e) {
		deleteBook();
		jbuttonEdit.setEnabled(false);
	}

	private void deleteBook() {
		int result = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			int selectedRow = jtableAuthor.getSelectedRow();
			int id = Integer.parseInt(jtableAuthor.getValueAt(selectedRow, 0).toString());

			if (authorModel.delete(id)) {
				JOptionPane.showMessageDialog(this, "Success");
				fillDataToJTable(authorModel.findAll());
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
	private void fillDataToJTable(List<Author> authorList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");

		for (Author author : authorList) {
			defaultTableModel.addRow(new Object[] { author.getId(), author.getName() });
		}

		jtableAuthor.setModel(defaultTableModel);
		jtableAuthor.getTableHeader().setReorderingAllowed(false);
		jtableAuthor.setRowHeight(30);
		
		HeaderRenderer header = new HeaderRenderer(jtableAuthor.getTableHeader().getDefaultRenderer());
		for (int i = 0; i < jtableAuthor.getModel().getColumnCount(); i++) {
			jtableAuthor.getColumnModel().getColumn(i).setHeaderRenderer(header);
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
