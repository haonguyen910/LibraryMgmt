package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Book;
import entities.Customer;
import models.BookModel;
import models.ConnectDB;
import models.CustomerModel;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JPanelStatistic extends JPanel {
	private JTable jtableBookDetail;
	private JTable jtableCustDetail;
	private List<Book> books;
	private JLabel jlabelNIssue;
	private JLabel jlabelNBook;
	private JLabel jlabelNCust;
	private JLabel jlabelNDefault;

	/**
	 * Create the panel.
	 */
	public JPanelStatistic() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_head = new JPanel();
		panel_head.setBackground(new Color(255, 128, 0));
		add(panel_head);

		JLabel lblNewLabel = new JLabel("Statistic Report");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_head.add(lblNewLabel);

		JPanel panel_body = new JPanel();
		add(panel_body);
		panel_body.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_body.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		jlabelNBook = new JLabel("");
		jlabelNBook
				.setBorder(new TitledBorder(null, "No. of Books", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jlabelNBook.setBounds(100, 49, 120, 100);
		panel.add(jlabelNBook);

		jlabelNCust = new JLabel("");
		jlabelNCust.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"No. of Customers", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jlabelNCust.setBounds(270, 49, 120, 100);
		panel.add(jlabelNCust);

		jlabelNIssue = new JLabel("");
		jlabelNIssue.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Issued Books", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jlabelNIssue.setBounds(440, 49, 120, 100);
		panel.add(jlabelNIssue);

		jlabelNDefault = new JLabel("");
		jlabelNDefault.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Defaulter List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jlabelNDefault.setBounds(610, 49, 120, 100);
		panel.add(jlabelNDefault);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 206, 395, 250);
		panel.add(scrollPane);

		jtableBookDetail = new JTable();
		scrollPane.setViewportView(jtableBookDetail);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(430, 206, 395, 250);
		panel.add(scrollPane_1);

		jtableCustDetail = new JTable();
		scrollPane_1.setViewportView(jtableCustDetail);

		JLabel lblNewLabel_2 = new JLabel("Customer Details");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(430, 181, 106, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Book Details");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 181, 106, 14);
		panel.add(lblNewLabel_2_1);

		JPanel panel_bottom = new JPanel();
		add(panel_bottom);

		JButton btnNewButton = new JButton("New button");
		panel_bottom.add(btnNewButton);

		initJFrame();
	}

	private void initJFrame() {
		BookModel bookModel = new BookModel();
		fillDataToBookDetail(bookModel.findAll());
		CustomerModel customerModel = new CustomerModel();
		fillDataToCustomerDetail(customerModel.findAll());
		
		fillDataToCards();

	}

	private void fillDataToBookDetail(List<Book> books) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ISBN");
		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Author");
		defaultTableModel.addColumn("Quantity");
		BookModel bookModel = new BookModel();
		for (Book book : books) {
			defaultTableModel
					.addRow(new Object[] { book.getISBN(), book.getTitle(), book.getAuthor(), book.getQuantity() });
			jtableBookDetail.setModel(defaultTableModel);
			jtableBookDetail.getTableHeader().setReorderingAllowed(false);
		}
	}

	private void fillDataToCustomerDetail(List<Customer> customers) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Phone");
		for (Customer customer : customers) {
			defaultTableModel.addRow(
					new Object[] { customer.getId(), customer.getName(), customer.getAddress(), customer.getPhone() });
			jtableCustDetail.setModel(defaultTableModel);
			jtableCustDetail.getTableHeader().setReorderingAllowed(false);
		}
	}
	
	private void fillDataToCards() {
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from book where quantity = ?");
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				jlabelNBook.setText(String.valueOf(resultSet.getRow()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}
