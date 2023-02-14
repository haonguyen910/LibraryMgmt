package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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
import javax.swing.plaf.UIResource;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.border.LineBorder;

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
	private JButton jbuttonLast;
	private JButton jbuttonPrint;
	private BorrowModel borrowModel = new BorrowModel();
	Integer page = 1;
	Integer rowCountPerPage = 5;
	Integer totalPage = 1;
	Integer totalData = 0;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel_5;
	
	
	

	/**
	 * Create the panel.
	 */
	public JPanelRecord() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setVgap(15);
		panel_1.setBackground(new Color(52, 52, 52));
		add(panel_1);

		JLabel lblNewLabel = new JLabel("  Issue Register ");
		lblNewLabel.setBackground(new Color(51, 51, 51));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(25);
		add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("Start Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_1);

		jdateChooserStart = new JDateChooser();
		jdateChooserStart.setOpaque(false);
		jdateChooserStart.setDateFormatString("yyyy-MM-dd");
		jdateChooserStart.setToolTipText("select");
		jdateChooserStart.setPreferredSize(new Dimension(150, 30));
		panel_2.add(jdateChooserStart);

		JLabel lblNewLabel_2 = new JLabel("     ");
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("End Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_3);

		jdateChooserEnd = new JDateChooser();
		jdateChooserEnd.setOpaque(false);
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
		jbuttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(jbuttonSearch);

		JLabel lblNewLabel_4_1 = new JLabel("        ");
		panel_2.add(lblNewLabel_4_1);

		jcomboBoxStatus = new JComboBox();
		jcomboBoxStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxStatus_actionPerformed(e);
			}
		});
		
		lblNewLabel_5 = new JLabel("Status ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_5);
		jcomboBoxStatus.setPreferredSize(new Dimension(150, 30));
		panel_2.add(jcomboBoxStatus);

		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setVgap(15);
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

		panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		panel_3.add(scrollPane, BorderLayout.CENTER);

		jtableRecord = new JTable();
		jtableRecord.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(jtableRecord);
		
		panel_4 = new JPanel();
		add(panel_4);
		
		jbuttonPrint = new JButton("Print");
		panel_4.add(jbuttonPrint);
		jbuttonPrint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbuttonPrint.setPreferredSize(new Dimension(80, 30));
		jbuttonPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonPrint_actionPerformed(e);
			}
		});

		initJPanel();

	}
	
	public void jbuttonPrint_actionPerformed(ActionEvent e) {
		PrinterJob job =  PrinterJob.getPrinterJob();
			job.setJobName("Print Data");
			
			job.setPrintable(new Printable() {
				
				@Override
				public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
					pageFormat.setOrientation(PageFormat.PORTRAIT);
					if(pageIndex > 0) {
						return Printable.NO_SUCH_PAGE;
					}
					
					Graphics2D g2 =  (Graphics2D) graphics;
					g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
					g2.scale(0.47, 0.47);
					
					panel_3.print(g2);
					
					return Printable.PAGE_EXISTS;
				}
			});
			
			boolean ok = job.printDialog();
			if(ok) {
				try {
					job.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
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
					sdf.format(borrow.getCreated()),sdf.format(borrow.getDue_date()), borrow.isStatus() ? "Returned" : "Pending" });

			jtableRecord.setModel(defaultTableModel);
			jtableRecord.setRowHeight(30);
			jtableRecord.getTableHeader().setReorderingAllowed(false);
		}
		HeaderRenderer header = new HeaderRenderer(jtableRecord.getTableHeader().getDefaultRenderer());
		for (int i = 0; i < jtableRecord.getModel().getColumnCount(); i++) {
			jtableRecord.getColumnModel().getColumn(i).setHeaderRenderer(header);
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

	private void initPagination() {
		borrowModel = new BorrowModel();
		totalData = borrowModel.count();
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
			comp.setForeground(new Color(70, 68, 98));
			return comp;
		}
	}
}
