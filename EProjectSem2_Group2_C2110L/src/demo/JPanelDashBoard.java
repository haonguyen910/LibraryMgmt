package demo;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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
import javax.swing.plaf.UIResource;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class JPanelDashBoard extends JPanel {
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
	public JPanelDashBoard() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_head = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_head.getLayout();
		flowLayout.setVgap(15);
		panel_head.setBackground(new Color(255, 255, 255));
		add(panel_head);

		JLabel lblNewLabel = new JLabel("  Dash Board");
		lblNewLabel.setIcon(new ImageIcon(JPanelDashBoard.class.getResource("/resources/images/icons8-dashboard-layout-54.png")));
		lblNewLabel.setForeground(new Color(255, 51, 51));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_head.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 6, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setPreferredSize(new Dimension(100, 150));
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1_4 = new JLabel("No. of Books");
		lblNewLabel_1_4.setBounds(39, 11, 120, 14);
		panel_3.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));

		jlabelNBook = new JLabel("");
		jlabelNBook.setForeground(new Color(102, 102, 102));
		jlabelNBook
				.setIcon(new ImageIcon(JPanelDashBoard.class.getResource("/resources/images/icons8_Book_Shelf_50px.png")));
		jlabelNBook.setBounds(0, 36, 166, 100);
		panel_3.add(jlabelNBook);
		jlabelNBook.setOpaque(true);
		jlabelNBook.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNBook.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNBook.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(255, 51, 51)));
		jlabelNBook.setBackground(new Color(240, 240, 240));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("No. of Customers");
		lblNewLabel_1_1_1.setBounds(40, 11, 120, 14);
		panel_4.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		jlabelNCust = new JLabel("");
		jlabelNCust.setForeground(new Color(102, 102, 102));
		jlabelNCust.setIcon(new ImageIcon(JPanelDashBoard.class.getResource("/resources/images/icons8_People_50px.png")));
		jlabelNCust.setBounds(0, 36, 166, 100);
		panel_4.add(jlabelNCust);
		jlabelNCust.setOpaque(true);
		jlabelNCust.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNCust.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNCust.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(102, 102, 255)));
		jlabelNCust.setBackground(new Color(240, 240, 240));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_1_2_1 = new JLabel("Issued Books");
		lblNewLabel_1_2_1.setBounds(39, 11, 120, 14);
		panel_5.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		jlabelNIssueBook = new JLabel("");
		jlabelNIssueBook.setIcon(new ImageIcon(JPanelDashBoard.class.getResource("/resources/images/icons8_Sell_50px.png")));
		jlabelNIssueBook.setBounds(0, 36, 166, 100);
		panel_5.add(jlabelNIssueBook);
		jlabelNIssueBook.setOpaque(true);
		jlabelNIssueBook.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNIssueBook.setForeground(new Color(102, 102, 102));
		jlabelNIssueBook.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNIssueBook.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(255, 51, 51)));
		jlabelNIssueBook.setBackground(new Color(240, 240, 240));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_1_3_1 = new JLabel("No. of Defaulter");
		lblNewLabel_1_3_1.setBounds(39, 11, 120, 14);
		panel_6.add(lblNewLabel_1_3_1);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		jlabelNDefaulter = new JLabel("");
		jlabelNDefaulter.setForeground(new Color(102, 102, 102));
		jlabelNDefaulter.setIcon(
				new ImageIcon(JPanelDashBoard.class.getResource("/resources/images/icons8_List_of_Thumbnails_50px.png")));
		jlabelNDefaulter.setBounds(0, 36, 166, 100);
		panel_6.add(jlabelNDefaulter);
		jlabelNDefaulter.setOpaque(true);
		jlabelNDefaulter.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNDefaulter.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlabelNDefaulter.setBorder(new MatteBorder(15, 0, 0, 0, (Color) new Color(102, 102, 255)));
		jlabelNDefaulter.setBackground(new Color(240, 240, 240));

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_7);
		panel_7.setLayout(null);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_1 = (FlowLayout) panel_11.getLayout();
		flowLayout_1.setVgap(10);
		add(panel_11);

		JPanel panel_body = new JPanel();
		add(panel_body);
		panel_body.setLayout(new BorderLayout(0, 0));

		panelPieChart = new JPanel();
		panelPieChart.setBackground(new Color(255, 255, 255));
		panelPieChart.setPreferredSize(new Dimension(400, 10));
		panel_body.add(panelPieChart, BorderLayout.WEST);
		panelPieChart.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel_body.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createTitledBorder("Book Details"));
		panel_9.add(scrollPane, BorderLayout.CENTER);

		jtableBookDetail = new JTable();
		jtableBookDetail.setSelectionBackground(new Color(255, 51, 51));
		jtableBookDetail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtableBookDetail.setPreferredScrollableViewportSize(new Dimension(450, 250));
		scrollPane.setViewportView(jtableBookDetail);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(BorderFactory.createTitledBorder("Customer Details"));
		panel_10.add(scrollPane_1, BorderLayout.CENTER);

		jtableCustDetail = new JTable();
		jtableCustDetail.setSelectionBackground(new Color(255, 51, 51));
		jtableCustDetail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtableCustDetail.getTableHeader().setOpaque(false);
		jtableCustDetail.setPreferredScrollableViewportSize(new Dimension(450, 250));
		scrollPane_1.setViewportView(jtableCustDetail);

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
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		defaultTableModel.addColumn("ISBN");
		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Author");
		defaultTableModel.addColumn("Quantity");
		BookModel bookModel = new BookModel();
		for (Book book : books) {
			defaultTableModel
					.addRow(new Object[] { book.getISBN(), book.getTitle(), book.getAuthor(), book.getQuantity() });
			jtableBookDetail.setModel(defaultTableModel);
			jtableBookDetail.setRowHeight(25);
			jtableBookDetail.getTableHeader().setReorderingAllowed(false);
			jtableBookDetail.getTableHeader().setBackground(Color.BLUE);
		}
		HeaderRenderer header = new HeaderRenderer(jtableBookDetail.getTableHeader().getDefaultRenderer());
		for (int i = 0; i < jtableBookDetail.getModel().getColumnCount(); i++) {
			jtableBookDetail.getColumnModel().getColumn(i).setHeaderRenderer(header);
		}
	}

	private void fillDataToCustomerDetail(List<Customer> customers) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Phone");
		for (Customer customer : customers) {
			defaultTableModel.addRow(
					new Object[] { customer.getId(), customer.getName(), customer.getAddress(), customer.getPhone() });
			jtableCustDetail.setModel(defaultTableModel);
			jtableCustDetail.setRowHeight(25);
			jtableCustDetail.getTableHeader().setReorderingAllowed(false);
		}
		
		HeaderRenderer header = new HeaderRenderer(jtableCustDetail.getTableHeader().getDefaultRenderer());
		for (int i = 0; i < jtableCustDetail.getModel().getColumnCount(); i++) {
			jtableCustDetail.getColumnModel().getColumn(i).setHeaderRenderer(header);
		}
	}

	private void fillDataToCards() {
		try {
			PreparedStatement ps1 = ConnectDB.connection()
					.prepareStatement("select sum(quantity) as sum_quantity from book");
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()) {
				String sum1 = rs1.getString("sum_quantity");
				jlabelNBook.setText(" " + sum1);
			}

			PreparedStatement ps2 = ConnectDB.connection()
					.prepareStatement("select count(id) as count_id from customer");
			ResultSet rs2 = ps2.executeQuery();
			if (rs2.next()) {
				String sum2 = rs2.getString("count_id");
				jlabelNCust.setText(" " + sum2);
			}

			PreparedStatement ps3 = ConnectDB.connection()
					.prepareStatement("select sum(quantity) as sum_quantity from borrow_detail");
			ResultSet rs3 = ps3.executeQuery();
			if (rs3.next()) {
				String sum3 = rs3.getString("sum_quantity");
				jlabelNIssueBook.setText(" " + sum3);
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
				jlabelNDefaulter.setText(" " + sum4);
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
			while (rs.next()) {
				pieDataset.setValue(rs.getString("categoryName"), new Double(rs.getDouble("numberOfCheckOut")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JFreeChart pieChart = ChartFactory.createPieChart("Issue Chart By Category", pieDataset, true, true, false);
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