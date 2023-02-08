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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class JPanelStatistic extends JPanel {
	private List<Book> books;
	private JLabel jlabelNBook;
	private JLabel jlabelNCust;
	private JLabel jlabelNIssueBook;
	private JLabel jlabelNDefaulter;
	private JPanel panelPieChart;
	private JTable jtableBookDetail;
	private JTable jtableCustDetail;

	/**
	 * Create the panel.
	 */
	public JPanelStatistic() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_head = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_head.getLayout();
		flowLayout.setVgap(15);
		panel_head.setBackground(new Color(128, 128, 192));
		add(panel_head);

		JLabel lblNewLabel = new JLabel("Statistic Report");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_head.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 6, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(100, 150));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("No. of Books");
		lblNewLabel_1_4.setBounds(39, 11, 120, 14);
		panel_3.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jlabelNBook = new JLabel("");
		jlabelNBook.setBounds(39, 36, 120, 100);
		panel_3.add(jlabelNBook);
		jlabelNBook.setOpaque(true);
		jlabelNBook.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNBook.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNBook.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(255, 128, 0)));
		jlabelNBook.setBackground(Color.WHITE);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("No. of Customers");
		lblNewLabel_1_1_1.setBounds(40, 11, 120, 14);
		panel_4.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jlabelNCust = new JLabel("");
		jlabelNCust.setBounds(40, 36, 120, 100);
		panel_4.add(jlabelNCust);
		jlabelNCust.setOpaque(true);
		jlabelNCust.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNCust.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNCust.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(51, 204, 255)));
		jlabelNCust.setBackground(Color.WHITE);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Issued Books");
		lblNewLabel_1_2_1.setBounds(39, 11, 120, 14);
		panel_5.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jlabelNIssueBook = new JLabel("");
		jlabelNIssueBook.setBounds(39, 36, 120, 100);
		panel_5.add(jlabelNIssueBook);
		jlabelNIssueBook.setOpaque(true);
		jlabelNIssueBook.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNIssueBook.setForeground(Color.BLACK);
		jlabelNIssueBook.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNIssueBook.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(255, 128, 0)));
		jlabelNIssueBook.setBackground(Color.WHITE);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Defaulter List");
		lblNewLabel_1_3_1.setBounds(39, 11, 120, 14);
		panel_6.add(lblNewLabel_1_3_1);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jlabelNDefaulter = new JLabel("");
		jlabelNDefaulter.setBounds(39, 36, 120, 100);
		panel_6.add(jlabelNDefaulter);
		jlabelNDefaulter.setOpaque(true);
		jlabelNDefaulter.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNDefaulter.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNDefaulter.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(51, 204, 255)));
		jlabelNDefaulter.setBackground(Color.WHITE);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_11.getLayout();
		flowLayout_1.setVgap(10);
		add(panel_11);

		JPanel panel_body = new JPanel();
		add(panel_body);
		panel_body.setLayout(new BorderLayout(0, 0));
		
		panelPieChart = new JPanel();
		panelPieChart.setPreferredSize(new Dimension(400, 10));
		panel_body.add(panelPieChart, BorderLayout.WEST);
		panelPieChart.setLayout(null);
		
		JPanel panel = new JPanel();
		panel_body.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_9.add(scrollPane, BorderLayout.CENTER);
		
		jtableBookDetail = new JTable();
		jtableBookDetail.setPreferredScrollableViewportSize(new Dimension(450, 250));
		scrollPane.setViewportView(jtableBookDetail);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_10.add(scrollPane_1, BorderLayout.CENTER);
		
		jtableCustDetail = new JTable();
		jtableCustDetail.setPreferredScrollableViewportSize(new Dimension(450, 250));
		scrollPane_1.setViewportView(jtableCustDetail);

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
			PreparedStatement ps = ConnectDB.connection().prepareStatement(
					"SELECT category.name AS categoryName, COUNT(borrow_detail.id) AS numberOfCheckOut\r\n"
					+ "FROM category LEFT JOIN book_category ON category.id = book_category.id_category\r\n"
					+ "LEFT JOIN borrow_detail ON book_category.id_book = borrow_detail.id_book\r\n"
					+ "GROUP BY categoryName");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pieDataset.setValue(rs.getString("categoryName"), new Double(rs.getDouble("numberOfCheckOut")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JFreeChart pieChart = ChartFactory.createPieChart("Check-out rate by Category", pieDataset, true, true, false);
		PiePlot piePlot = (PiePlot) pieChart.getPlot();
		
		piePlot.setSectionPaint("novel", new Color(236, 107, 86));
		piePlot.setSectionPaint("poem", new Color(255, 193, 84));
		piePlot.setSectionPaint("short story", new Color(71, 179, 156));
		piePlot.setSectionPaint("prose", new Color(253, 103, 135));
		piePlot.setSectionPaint("long story", new Color(255, 244, 76));
		piePlot.setSectionPaint("autobiography", new Color(40, 142, 235));
		piePlot.setBackgroundPaint(Color.white);
		
		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setBounds(0, 0, 385, 512);
		panelPieChart.removeAll();
		panelPieChart.setLayout(null);
		panelPieChart.add(chartPanel);
		chartPanel.setLayout(null);
		panelPieChart.validate();
	}
	
}