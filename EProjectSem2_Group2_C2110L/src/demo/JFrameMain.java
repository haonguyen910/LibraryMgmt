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

public class JFrameMain extends JFrame {

	private JPanel contentPane;
	private JPanel jpanelMain;
	private JPanel jpanelRight;
	private JButton jbuttonBookList;
	private JButton jbuttonStatistic;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 720);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu_1 = new JMenu("Add");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Book");
		mnNewMenu_1.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Employee");
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuItem jmenuItemAddReader = new JMenuItem("Reader");
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
		jpanelMain.add(jpanelLeft, BorderLayout.WEST);
		jpanelLeft.setLayout(new BoxLayout(jpanelLeft, BoxLayout.Y_AXIS));
		
		jbuttonBookList = new JButton("Book List");
		jbuttonBookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBookList_actionPerformed(e);
			}
		});
		
		JButton jbuttonHomePage = new JButton("Home Page");
		jpanelLeft.add(jbuttonHomePage);
		jbuttonBookList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/book_color.png")));
		jpanelLeft.add(jbuttonBookList);
		
		JButton btnNewButton_3 = new JButton("Issue Register");
		btnNewButton_3.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/sign.png")));
		jpanelLeft.add(btnNewButton_3);

		jbuttonStatistic = new JButton("Statistic Report");
		jbuttonStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonStatistic_actionPerformed(e);
			}
		});
		jbuttonStatistic.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/report.png")));
		jpanelLeft.add(jbuttonStatistic);

		JButton jbuttonCustList = new JButton("Customer List");
		jbuttonCustList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCustList_actionPerformed(e);
			}
		});
		jbuttonCustList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/user.png")));
		jpanelLeft.add(jbuttonCustList);

		JButton jbuttonEmployeeList = new JButton("Employee List");
		jbuttonEmployeeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEmployeeList_actionPerformed(e);
			}
		});
		jbuttonEmployeeList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/employee.png")));
		jpanelLeft.add(jbuttonEmployeeList);

		jpanelRight = new JPanel();
		contentPane.add(jpanelRight, BorderLayout.CENTER);
		jpanelRight.setLayout(new BoxLayout(jpanelRight, BoxLayout.X_AXIS));
	}

//	Functions

	private void jbuttonBookList_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelBookList jPanelBookList = new JPanelBookList();
		jpanelRight.add(jPanelBookList);
		jPanelBookList.setVisible(true);
	}
	
	public void jbuttonStatistic_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelStatistic jpanelStatistic = new JPanelStatistic();
		jpanelRight.add(jpanelStatistic);
		jpanelStatistic.setVisible(true);
	}
	
	public void jbuttonEmployeeList_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelEmpList jpanelEmpList = new JPanelEmpList();
		jpanelRight.add(jpanelEmpList);
		jpanelEmpList.setVisible(true);
	}
	
	public void jbuttonCustList_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelCustList jpanelCustList = new JPanelCustList();
		jpanelRight.add(jpanelCustList);
		jpanelCustList.setVisible(true);
	}

//	Components
	private void clearScreen() {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
	}
}
