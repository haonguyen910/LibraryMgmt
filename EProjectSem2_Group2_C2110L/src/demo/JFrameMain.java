package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class JFrameMain extends JFrame {

	private JPanel contentPane;
	private JPanel jpanelMain;
	private JPanel jpanelRight;
	private JButton jbuttonBookList;
	private JButton jbuttonAuthorList;
	private JButton jbuttonCategory;
	private JButton jbuttonBorrowList;

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
					JFrameMain frame = new JFrameMain();
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
	public JFrameMain() {
		setBounds(100, 100, 1002, 701);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu_1 = new JMenu("Add");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Book");
		mnNewMenu_1.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Employee");
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem jmenuItemAddReader = new JMenuItem("Reader");
		jmenuItemAddReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmenuItemAddReader_actionPerformed(e);
			}
		});
		mnNewMenu_1.add(jmenuItemAddReader);

		JMenu mnNewMenu = new JMenu("Account");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Profile");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Log-out");
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("Check-in");
		toolBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Check-out");
		toolBar.add(btnNewButton_1);

		jpanelMain = new JPanel();
		contentPane.add(jpanelMain, BorderLayout.WEST);
		jpanelMain.setLayout(new BorderLayout(0, 0));

		JPanel jpanelLeft = new JPanel();
		jpanelLeft.setBackground(new Color(128, 128, 192));
		jpanelMain.add(jpanelLeft, BorderLayout.WEST);
		jpanelLeft.setLayout(new BoxLayout(jpanelLeft, BoxLayout.Y_AXIS));

		jbuttonBookList = new JButton("Book List");
		jbuttonBookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBookList_actionPerformed(e);
			}
		});
		jbuttonBookList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/book.png")));
		jpanelLeft.add(jbuttonBookList);

		jbuttonAuthorList = new JButton("Author");
		jbuttonAuthorList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/author.png")));
		jbuttonAuthorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAuthorList_actionPerformed(e);
			}
		});
		jpanelLeft.add(jbuttonAuthorList);

		jbuttonCategory = new JButton("Category");
		jbuttonCategory.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/category.png")));
		jbuttonCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCategory_actionPerformed(e);
			}
		});
		jpanelLeft.add(jbuttonCategory);

		jbuttonBorrowList = new JButton("Borrow List");
		jbuttonBorrowList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBorrowList_actionPerformed(e);
			}
		});
		jbuttonBorrowList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/borrow.png")));
		jpanelLeft.add(jbuttonBorrowList);

		JButton jbuttonBorrowedList = new JButton("Borrowed List");
		jbuttonBorrowedList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/borrowed.png")));
		jpanelLeft.add(jbuttonBorrowedList);

		JButton btnNewButton_3 = new JButton("Issue Register");
		btnNewButton_3.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/issue.png")));
		jpanelLeft.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Statistic Report");
		btnNewButton_4.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/reportStatic.png")));
		jpanelLeft.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Reader List");
		btnNewButton_5.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/reader.png")));
		jpanelLeft.add(btnNewButton_5);

		JButton jbuttonEmployeeList = new JButton("Employee List");
		jbuttonEmployeeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEmployeeList_actionPerformed(e);
			}
		});
		jbuttonEmployeeList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/employees.png")));
		jpanelLeft.add(jbuttonEmployeeList);

		jpanelRight = new JPanel();
		contentPane.add(jpanelRight, BorderLayout.CENTER);
		jpanelRight.setLayout(new BoxLayout(jpanelRight, BoxLayout.X_AXIS));

		initJFrame();
	}

//	Functions
	private void initJFrame() {
		clearScreen();
		JPanelBookList jPanelBookList = new JPanelBookList(jpanelRight);
		jpanelRight.add(jPanelBookList);
		jPanelBookList.setVisible(true);
	}

	private void jmenuItemAddReader_actionPerformed(ActionEvent e) {
		JPanelAddReader jpanelAddReader = new JPanelAddReader();
		jpanelMain.add(jpanelAddReader);
		jpanelAddReader.setVisible(true);
	}

	public void jbuttonEmployeeList_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelEmployee jpanelEmployee = new JPanelEmployee();
		jpanelRight.add(jpanelEmployee);
		jpanelEmployee.setVisible(true);
	}

//Ai
	private void jbuttonBookList_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelBookList jPanelBookList = new JPanelBookList(jpanelRight);
		JPanelBookAdd jPanelBookAdd = new JPanelBookAdd(jpanelRight);

		jpanelRight.add(jPanelBookList);
		jPanelBookList.setVisible(true);
	}

	public void jbuttonAuthorList_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelAuthorList jPanelAuthorList = new JPanelAuthorList(jpanelRight);
		JPanelAuthorAdd jPanelAuthorAdd = new JPanelAuthorAdd(jpanelRight);
		jpanelRight.add(jPanelAuthorList);
		jPanelAuthorList.setVisible(true);
	}

	public void jbuttonCategory_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelCategoryList jPanelCategoryList = new JPanelCategoryList(jpanelRight);
		jpanelRight.add(jPanelCategoryList);
		jPanelCategoryList.setVisible(true);
	}

	public void jbuttonBorrowList_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelBorrowList jPanelBorrowList = new JPanelBorrowList(jpanelRight);
		jpanelRight.add(jPanelBorrowList);
		jPanelBorrowList.setVisible(true);
	}

//	Components
	private void clearScreen() {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
	}
}
