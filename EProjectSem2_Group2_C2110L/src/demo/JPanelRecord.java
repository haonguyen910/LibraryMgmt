package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entities.Borrow;
import models.BorrowModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JPanelRecord extends JPanel {
	private JDateChooser jdateChooserStart;
	private JTable jtableRecord;
	private JDateChooser jdateChooserEnd;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JComboBox jcomboBoxStatus;
	private JButton jbuttonSearch;
	private JComboBox jcomboBoxItem;
	private JButton jbuttonFirst;
	private JButton jbuttonPrevious;
	private JButton jbuttonNext;
	private BorrowModel borrowModel = new BorrowModel();
	Integer page = 1;
	Integer rowCountPerPage = 5;
	Integer totalPage = 1;
	Integer totalData = 0;
	private JButton jbuttonLast;

	/**
	 * Create the panel.
	 */
	public JPanelRecord() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 192));
		add(panel_1);

		JLabel lblNewLabel = new JLabel("Issue Register ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(30);
		add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("Start Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_1);

		jdateChooserStart = new JDateChooser();
		jdateChooserStart.setDateFormatString("yyyy-MM-dd");
		jdateChooserStart.setToolTipText("select");
		jdateChooserStart.setPreferredSize(new Dimension(150, 30));
		panel_2.add(jdateChooserStart);

		JLabel lblNewLabel_2 = new JLabel("     ");
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("End Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_3);

		jdateChooserEnd = new JDateChooser();
		jdateChooserEnd.setDateFormatString("yyyy-MM-dd");
		jdateChooserEnd.setPreferredSize(new Dimension(150, 30));
		panel_2.add(jdateChooserEnd);

		JLabel lblNewLabel_4 = new JLabel("     ");
		panel_2.add(lblNewLabel_4);

		jbuttonSearch = new JButton("Search");
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});
		jbuttonSearch.setPreferredSize(new Dimension(120, 30));
		jbuttonSearch.setMargin(new Insets(5, 20, 5, 20));
		jbuttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(jbuttonSearch);

		JLabel lblNewLabel_4_1 = new JLabel("        ");
		panel_2.add(lblNewLabel_4_1);

		jcomboBoxStatus = new JComboBox();
		jcomboBoxStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxStatus_actionPerformed(e);
			}
		});
		jcomboBoxStatus.setPreferredSize(new Dimension(150, 30));
		panel_2.add(jcomboBoxStatus);

		JPanel panel = new JPanel();
		add(panel);

		jbuttonFirst = new JButton("First");
		jbuttonFirst.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jbuttonFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonFirst_actionPerformed(e);
			}
		});
		panel.add(jbuttonFirst);

		jbuttonPrevious = new JButton("Previous");
		jbuttonPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonPrevious_actionPerformed(e);
			}
		});
		jbuttonPrevious.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(jbuttonPrevious);

		jcomboBoxItem = new JComboBox();
		jcomboBoxItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxItem_actionPerformed(e);
			}
		});
		jcomboBoxItem.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				jcomboBoxItem_itemStateChanged(e);
			}
		});
//		jcomboBoxItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				jcomboBoxItem_actionPerformed(e);
//			}
//		});
		jcomboBoxItem.setPreferredSize(new Dimension(100, 22));
		panel.add(jcomboBoxItem);

		jbuttonNext = new JButton("Next");
		jbuttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonNext_actionPerformed(e);
			}
		});
		jbuttonNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(jbuttonNext);

		jbuttonLast = new JButton("Last");
		jbuttonLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonLast_actionPerformed(e);
			}
		});
		jbuttonLast.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(jbuttonLast);

		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);

		jtableRecord = new JTable();
		scrollPane.setViewportView(jtableRecord);

		initJPanel();

	}

	private void initJPanel() {
//		BorrowModel borrowModel = new BorrowModel();
//		fillDataToJTableRecord(borrowModel.findAllForRecord());

		initPagination();
		fillDataToJCombobox();
		fillDataToComboboxItem();
	}

	public void jcomboBoxStatus_actionPerformed(ActionEvent e) {
		String status = jcomboBoxStatus.getSelectedItem().toString();
		borrowModel = new BorrowModel();

		if (status.equalsIgnoreCase("all")) {
			fillDataToJTableRecord(borrowModel.findAllForRecord());
		} else if (status.equalsIgnoreCase("pending")) {
			fillDataToJTableRecord(borrowModel.findByStatusForHistory(false));
		} else if (status.equalsIgnoreCase("returned")) {
			fillDataToJTableRecord(borrowModel.findByStatusForHistory(true));
		}
	}

	public void jbuttonSearch_actionPerformed(ActionEvent e) {
		Date startDate = jdateChooserStart.getDate();
		Date endDate = jdateChooserEnd.getDate();
		BorrowModel borrowModel = new BorrowModel();
		fillDataToJTableRecord(borrowModel.findByDates(startDate, endDate));
	}

	private void fillDataToJTableRecord(List<Borrow> borrowList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Book Title");
		defaultTableModel.addColumn("Customer's Name");
		defaultTableModel.addColumn("Issue Date");
		defaultTableModel.addColumn("Due Date");
		defaultTableModel.addColumn("Status");
		for (Borrow borrow : borrowList) {
			defaultTableModel.addRow(new Object[] { borrow.getId(), borrow.getBookTitle(), borrow.getCustomerName(),
					borrow.getCreated(), borrow.getDue_date(), borrow.isStatus() ? "Returned" : "Pending" });

			jtableRecord.setModel(defaultTableModel);
			jtableRecord.getTableHeader().setReorderingAllowed(false);
		}
	}

	private void fillDataToJCombobox() {
		DefaultComboBoxModel<String> dfcm = new DefaultComboBoxModel<>();
		dfcm.addElement("All");
		dfcm.addElement("Pending");
		dfcm.addElement("Returned");
		jcomboBoxStatus.setModel(dfcm);
	}

	private void fillDataToComboboxItem() {
		DefaultComboBoxModel<String> dfcm = new DefaultComboBoxModel<>();
		dfcm.addElement("5");
		dfcm.addElement("15");
		dfcm.addElement("30");
		dfcm.addElement("50");
		dfcm.addElement("100");
		jcomboBoxItem.setModel(dfcm);
	}

	public void jbuttonFirst_actionPerformed(ActionEvent e) {
		page = 1;
		initPagination();
	}

	public void jbuttonPrevious_actionPerformed(ActionEvent e) {
		if (page > 1) {
			page--;
			initPagination();
		}
	}

	public void jbuttonNext_actionPerformed(ActionEvent e) {
		if (page < totalPage) {
			page++;
			initPagination();
		}
	}

	public void jbuttonLast_actionPerformed(ActionEvent e) {
		page = totalPage;
		initPagination();
	}

	public void jcomboBoxItem_actionPerformed(ActionEvent e) {
		rowCountPerPage = Integer.parseInt(jcomboBoxItem.getSelectedItem().toString());
		initPagination();
	}

	public void jcomboBoxItem_itemStateChanged(ItemEvent e) {
		initPagination();
	}

	private void initPagination() {
		borrowModel = new BorrowModel();
		totalData = borrowModel.count();
//		rowCountPerPage = Integer.parseInt(jcomboBoxItem.getSelectedItem().toString());
		Double totalPageD = Math.ceil(totalData.doubleValue() / rowCountPerPage.doubleValue());
		totalPage = totalPageD.intValue();

		if (page.equals(1)) {
			jbuttonFirst.setEnabled(false);
			jbuttonPrevious.setEnabled(false);
		} else {
			jbuttonFirst.setEnabled(true);
			jbuttonPrevious.setEnabled(true);
		}

		if (page.equals(totalPage)) {
			jbuttonNext.setEnabled(false);
			jbuttonLast.setEnabled(false);
		} else {
			jbuttonNext.setEnabled(true);
			jbuttonLast.setEnabled(true);
		}

		if (page > totalPage) {
			page = 1;
		}

		fillDataToJTableRecord(borrowModel.findAllPagination(page, rowCountPerPage));

	}
}
