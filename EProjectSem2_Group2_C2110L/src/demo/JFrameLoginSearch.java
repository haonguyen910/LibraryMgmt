package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entities.Book;
import models.BookModel;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class JFrameLoginSearch extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldSearchTitle;
	private JTable jtableSearch;
	private JButton jbuttonSearchTitle;
	private JTextField jtextFieldSearchAuthor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameLoginSearch frame = new JFrameLoginSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameLoginSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 547);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JButton jbuttonLogin = new JButton("Login");
		jbuttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonLogin_actionPerformed(e);
			}
		});
		menuBar.add(jbuttonLogin);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel jpanelSearch = new JPanel();
		contentPane.add(jpanelSearch);
		jpanelSearch.setLayout(null);
		
		jtextFieldSearchTitle = new JTextField();
		jtextFieldSearchTitle.setBounds(46, 24, 271, 33);
		jpanelSearch.add(jtextFieldSearchTitle);
		jtextFieldSearchTitle.setColumns(10);
		
		jbuttonSearchTitle = new JButton("Search by Title");
		jbuttonSearchTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});
		jbuttonSearchTitle.setBounds(329, 26, 129, 28);
		jpanelSearch.add(jbuttonSearchTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 97, 1046, 330);
		jpanelSearch.add(scrollPane);
		
		jtableSearch = new JTable();
		scrollPane.setViewportView(jtableSearch);
		
		jtextFieldSearchAuthor = new JTextField();
		jtextFieldSearchAuthor.setColumns(10);
		jtextFieldSearchAuthor.setBounds(556, 24, 271, 33);
		jpanelSearch.add(jtextFieldSearchAuthor);
		
		JButton jbuttonSearchAuthor = new JButton("Search by Author");
		jbuttonSearchAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearchAuthor_actionPerformed(e);
			}
		});
		jbuttonSearchAuthor.setBounds(839, 26, 129, 28);
		jpanelSearch.add(jbuttonSearchAuthor);
		
		initJFrame();
	}
	
	private void initJFrame() {
		BookModel bookModel = new BookModel();
		fillDataToJTable(bookModel.findAll());
	}
	
	private void fillDataToJTable(List<Book> books) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		defaultTableModel.addColumn("Call Number");
		defaultTableModel.addColumn("ISBN");
		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Author");
		defaultTableModel.addColumn("Category");
		defaultTableModel.addColumn("Photo");
		defaultTableModel.addColumn("Status");
		for(Book book: books) {
			defaultTableModel.addRow(new Object[] {
					book.getCallNumber(),
					book.getISBN(),
					book.getTitle(),
					book.getAuthor(),
					book.getCategory(),
					book.getPhoto(),
					book.isStatus() ? "available" : "unavailable"
			});
		}
		jtableSearch.setModel(defaultTableModel);
		jtableSearch.getTableHeader().setReorderingAllowed(false);
	}
	
	public void jbuttonLogin_actionPerformed(ActionEvent e) {
		JFrameLogin jframeLogin = new JFrameLogin();
		jframeLogin.setVisible(true);
		this.setVisible(false);
	}
	
	public void jbuttonSearch_actionPerformed(ActionEvent e) {
		String keywordTitle = jtextFieldSearchTitle.getText().trim();
		BookModel bookModel = new BookModel(); 
		fillDataToJTable(bookModel.findByTitle(keywordTitle));
	}
	
	public void jbuttonSearchAuthor_actionPerformed(ActionEvent e) {
		String keywordAuthor = jtextFieldSearchAuthor.getText().trim();
		BookModel bookModel = new BookModel(); 
		fillDataToJTable(bookModel.findByAuthor(keywordAuthor));
	}
}
