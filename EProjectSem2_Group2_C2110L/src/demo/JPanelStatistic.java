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
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class JPanelStatistic extends JPanel {
	private JTable jtableBookDetail;
	private JTable jtableCustDetail;
	private List<Book> books;
	private JLabel jlabelNBook;
	private JLabel jlabelNCust;

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
		jlabelNBook.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNBook.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNBook.setBackground(new Color(255, 255, 255));
		jlabelNBook.setOpaque(true);
		jlabelNBook.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(255, 128, 0)));
		jlabelNBook.setBounds(142, 54, 120, 100);
		panel.add(jlabelNBook);

		jlabelNCust = new JLabel("");
		jlabelNCust.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNCust.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNCust.setBackground(new Color(255, 255, 255));
		jlabelNCust.setOpaque(true);
		jlabelNCust.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(51, 204, 255)));
		jlabelNCust.setBounds(312, 54, 120, 100);
		panel.add(jlabelNCust);

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

		JLabel lblNewLabel_1 = new JLabel("No. of Books");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(142, 29, 120, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("No. of Customers");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(312, 29, 120, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Issued Books");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(482, 29, 120, 14);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Defaulter List");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(652, 29, 120, 14);
		panel.add(lblNewLabel_1_3);

		JLabel jlabelNBook_1 = new JLabel("");
		jlabelNBook_1.setOpaque(true);
		jlabelNBook_1.setForeground(Color.WHITE);
		jlabelNBook_1.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(255, 128, 0)));
		jlabelNBook_1.setBackground(Color.WHITE);
		jlabelNBook_1.setBounds(482, 54, 120, 100);
		panel.add(jlabelNBook_1);

		JLabel jlabelNCust_1 = new JLabel("");
		jlabelNCust_1.setOpaque(true);
		jlabelNCust_1.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(51, 204, 255)));
		jlabelNCust_1.setBackground(Color.WHITE);
		jlabelNCust_1.setBounds(652, 54, 120, 100);
		panel.add(jlabelNCust_1);

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
			PreparedStatement ps1 = ConnectDB.connection()
					.prepareStatement("select sum(quantity) as sum_quantity from book");
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()) {
				String sum1 = rs1.getString("sum_quantity");
				jlabelNBook.setText(sum1);
				
			PreparedStatement ps2 = ConnectDB.connection().prepareStatement("select count(id) as count_id from customer");
			ResultSet rs2 = ps2.executeQuery();
			if(rs2.next()) {
				String sum2 = rs2.getString("count_id");
				jlabelNCust.setText(sum2);
			}
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}