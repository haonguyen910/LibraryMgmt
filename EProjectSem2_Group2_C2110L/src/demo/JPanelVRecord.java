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

public class JPanelVRecord extends JPanel {
	private JDateChooser jdateChooserStart;
	private JTable jtableVRecord;
	private JDateChooser jdateChooserEnd;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JComboBox jcomboBoxStatus;

	/**
	 * Create the panel.
	 */
	public JPanelVRecord() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		add(panel_1);

		JLabel lblNewLabel = new JLabel("Issue Register ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
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

		JButton jbuttonSearch = new JButton("Search");
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

		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);

		jtableVRecord = new JTable();
		scrollPane.setViewportView(jtableVRecord);

		initJPanel();

	}

	private void initJPanel() {
		BorrowModel borrowModel = new BorrowModel();
		fillDataToJTableVRecord(borrowModel.findAllForHistory());

		fillDataToJCombobox();

	}

	public void jcomboBoxStatus_actionPerformed(ActionEvent e) {
		String status = jcomboBoxStatus.getSelectedItem().toString();
		BorrowModel borrowModel = new BorrowModel();
		if (status.equalsIgnoreCase("all")) {
			fillDataToJTableVRecord(borrowModel.findAllForHistory());
		} else {
			fillDataToJTableVRecord(borrowModel.findByStatusForHistory(status.equalsIgnoreCase("pending")));
		}
	}

	public void jbuttonSearch_actionPerformed(ActionEvent e) {
		Date startDate = jdateChooserStart.getDate();
		Date endDate = jdateChooserEnd.getDate();
		BorrowModel borrowModel = new BorrowModel();
		fillDataToJTableVRecord(borrowModel.findByDates(startDate, endDate));
	}

	private void fillDataToJTableVRecord(List<Borrow> borrowList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		defaultTableModel.addColumn("Issue ID");
		defaultTableModel.addColumn("Call Number");
		defaultTableModel.addColumn("Customer's Name");
		defaultTableModel.addColumn("Issue Date");
		defaultTableModel.addColumn("Due Date");
		defaultTableModel.addColumn("Status");
		for (Borrow borrow : borrowList) {
			defaultTableModel.addRow(new Object[] { borrow.getId(), borrow.getCallNumber(), borrow.getCustomerName(),
					borrow.getCreated(), borrow.getDue_date(), borrow.isStatus() ? "Pending" : "Returned" });

			jtableVRecord.setModel(defaultTableModel);
			jtableVRecord.getTableHeader().setReorderingAllowed(false);
		}
	}

	private void fillDataToJCombobox() {
		DefaultComboBoxModel<String> dfcm = new DefaultComboBoxModel<>();
		dfcm.addElement("All");
		dfcm.addElement("Pending");
		dfcm.addElement("Returned");
		jcomboBoxStatus.setModel(dfcm);
	}
}
