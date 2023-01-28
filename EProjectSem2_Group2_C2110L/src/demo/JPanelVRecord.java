package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entities.Book;
import entities.Borrow;
import models.BorrowModel;
import models.ConnectDB;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class JPanelVRecord extends JPanel {
	private JDateChooser jdateChooserIssue;
	private JTable jtableVRecord;
	private JDateChooser jdateChooserDue;

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

		JLabel lblNewLabel_1 = new JLabel("Issue Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_1);

		jdateChooserIssue = new JDateChooser();
		jdateChooserIssue.setToolTipText("select");
		jdateChooserIssue.setPreferredSize(new Dimension(200, 30));
		panel_2.add(jdateChooserIssue);

		JLabel lblNewLabel_2 = new JLabel("           ");
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Due Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_3);

		jdateChooserDue = new JDateChooser();
		jdateChooserDue.setPreferredSize(new Dimension(200, 30));
		panel_2.add(jdateChooserDue);

		JLabel lblNewLabel_4 = new JLabel("              ");
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

	}

	public void jbuttonSearch_actionPerformed(ActionEvent e) {
		Date issueDate = jdateChooserIssue.getDate();
		Date endDate = jdateChooserDue.getDate();
		BorrowModel borrowModel = new BorrowModel();
		fillDataToJTableVRecord(borrowModel.findByDates(issueDate, endDate));
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
//		defaultTableModel.addColumn("Status");
//		for (Borrow borrow : borrowList) {
//			defaultTableModel.addRow(new Object[] { borrow.getId(), borrow.getCallNumber(), borrow.getCustomerName(),
//					borrow.getCreated(), borrow.getDue_date() });

		jtableVRecord.setModel(defaultTableModel);
		jtableVRecord.getTableHeader().setReorderingAllowed(false);
	}
}
