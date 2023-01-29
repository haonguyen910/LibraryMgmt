package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import entities.Book;
import entities.Customer;
import models.BookModel;
import models.ConnectDB;
import models.CustomerModel;

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
	private JLabel jlabelNIssueBook;
	private JLabel jlabelNDefaulter;
	private JPanel panelPieChart;

	/**
	 * Create the panel.
	 */
	public JPanelStatistic() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_head = new JPanel();
		panel_head.setBackground(new Color(128, 128, 192));
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
		scrollPane.setBounds(20, 206, 442, 127);
		panel.add(scrollPane);

		jtableBookDetail = new JTable();
		scrollPane.setViewportView(jtableBookDetail);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 373, 442, 127);
		panel.add(scrollPane_1);

		jtableCustDetail = new JTable();
		scrollPane_1.setViewportView(jtableCustDetail);

		JLabel lblNewLabel_2 = new JLabel("Customer Details");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(20, 348, 132, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Book Details");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(20, 181, 106, 14);
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

		jlabelNIssueBook = new JLabel("");
		jlabelNIssueBook.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNIssueBook.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNIssueBook.setOpaque(true);
		jlabelNIssueBook.setForeground(new Color(0, 0, 0));
		jlabelNIssueBook.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(255, 128, 0)));
		jlabelNIssueBook.setBackground(Color.WHITE);
		jlabelNIssueBook.setBounds(482, 54, 120, 100);
		panel.add(jlabelNIssueBook);

		jlabelNDefaulter = new JLabel("");
		jlabelNDefaulter.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNDefaulter.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNDefaulter.setOpaque(true);
		jlabelNDefaulter.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(51, 204, 255)));
		jlabelNDefaulter.setBackground(Color.WHITE);
		jlabelNDefaulter.setBounds(652, 54, 120, 100);
		panel.add(jlabelNDefaulter);

		panelPieChart = new JPanel();
		panelPieChart.setBounds(495, 206, 395, 294);
		panel.add(panelPieChart);

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
		
		showPieChart();

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
			}

			PreparedStatement ps2 = ConnectDB.connection()
					.prepareStatement("select count(id) as count_id from customer");
			ResultSet rs2 = ps2.executeQuery();
			if (rs2.next()) {
				String sum2 = rs2.getString("count_id");
				jlabelNCust.setText(sum2);
			}

			PreparedStatement ps3 = ConnectDB.connection()
					.prepareStatement("select sum(quantity) as sum_quantity from borrow_detail");
			ResultSet rs3 = ps3.executeQuery();
			if (rs3.next()) {
				String sum3 = rs3.getString("sum_quantity");
				jlabelNIssueBook.setText(sum3);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			String today = sdf.format(cal.getTime());
			PreparedStatement ps4 = ConnectDB.connection()
					.prepareStatement("select count(due_date) as count_due_date from borrow where due_date > ?");
			ps4.setString(1, today);
			ResultSet rs4 = ps4.executeQuery();
			if (rs4.next()) {
				String sum4 = rs4.getString("count_due_date");
				jlabelNDefaulter.setText(sum4);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showPieChart() {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("SELECT book_category.id_category, COUNT(borrow_detail.id) as NumberOfCheckOut FROM borrow_detail LEFT JOIN book_category ON borrow_detail.id_book = book_category.id_book GROUP BY id_category");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pieDataset.setValue(rs.getString("id_category"), new Double(rs.getDouble("NumberOfCheckOut")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JFreeChart pieChart = ChartFactory.createPieChart("Category Detail", pieDataset, true, true, false);
		PiePlot piePlot = (PiePlot) pieChart.getPlot();
		
		piePlot.setSectionPaint("novel", new Color(255, 255, 102));
		piePlot.setSectionPaint("poem", new Color(102, 255, 102));
		piePlot.setSectionPaint("short story", new Color(255, 102, 153));
		piePlot.setSectionPaint("prose", new Color(0, 204, 204));
		piePlot.setSectionPaint("long story", new Color(255, 255, 102));
		piePlot.setSectionPaint("autobiography", new Color(102, 255, 102));
		piePlot.setBackgroundPaint(Color.white);
		
		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setBounds(0, 0, 385, 294);
		panelPieChart.removeAll();
		panelPieChart.setLayout(null);
		panelPieChart.add(chartPanel);
		chartPanel.setLayout(null);
		panelPieChart.validate();
	}
}