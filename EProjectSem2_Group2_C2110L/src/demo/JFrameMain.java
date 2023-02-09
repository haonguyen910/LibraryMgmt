package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Employee;

import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class JFrameMain extends JFrame {

	private JPanel contentPane;
	private JPanel jpanelMain;
	private JPanel jpanelRight;
	private JButton jbuttonBookList;
	private JButton jbuttonAuthorList;
	private JButton jbuttonCategory;
	private JButton jbuttonBorrowList;
	private JButton jbuttonCustmList;
	private JButton jbuttonVRecord;
	private JButton jbuttonBorrowedList;
	private Map<String, Object> data;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel;
	private JLabel jlabelWelcome;
	private JButton jbuttonLogOut;

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
		setBounds(100, 100, 1059, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 60));
		panel.setBackground(new Color(102, 102, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 4, 0, 15));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 255));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(12, 6, 274, 48);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel_1.add(lblNewLabel);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 102, 255));
		panel.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 102, 255));
		panel.add(panel_3);
		
		panel_4 = new JPanel();
		panel_4.setForeground(new Color(255, 255, 255));
		panel_4.setBackground(new Color(102, 102, 255));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		jlabelWelcome = new JLabel("Welcome");
		jlabelWelcome.setForeground(new Color(255, 255, 255));
		jlabelWelcome.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/images/male_user_50px.png")));
		jlabelWelcome.setFont(new Font("SansSerif", Font.BOLD, 16));
		jlabelWelcome.setBounds(160, 6, 274, 48);
		panel_4.add(jlabelWelcome);

		jpanelMain = new JPanel();
		contentPane.add(jpanelMain, BorderLayout.WEST);
		jpanelMain.setLayout(new BorderLayout(0, 0));

		JPanel jpanelLeft = new JPanel();
		jpanelLeft.setBackground(new Color(51, 51, 51));
		jpanelMain.add(jpanelLeft, BorderLayout.WEST);

		jbuttonBookList = new JButton("   Book");
		jbuttonBookList.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonBookList.setMaximumSize(new Dimension(200, 60));
		jbuttonBookList.setPreferredSize(new Dimension(100, 50));
		jbuttonBookList.setBorderPainted(false);
		jbuttonBookList.setContentAreaFilled(false);
		jbuttonBookList.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonBookList.setForeground(new Color(192, 192, 192));
		jbuttonBookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBookList_actionPerformed(e);
			}
		});
		jpanelLeft.setLayout(new BoxLayout(jpanelLeft, BoxLayout.Y_AXIS));
		
				JButton jbuttonStatistic = new JButton("   Dash Board");
				jbuttonStatistic.setHorizontalAlignment(SwingConstants.LEFT);
				jbuttonStatistic.setBackground(new Color(255, 51, 51));
				jbuttonStatistic.setMaximumSize(new Dimension(200, 60));
				jbuttonStatistic.setPreferredSize(new Dimension(110, 28));
				jbuttonStatistic.setBorderPainted(false);
				jbuttonStatistic.setFont(new Font("SansSerif", Font.BOLD, 14));
				jbuttonStatistic.setForeground(new Color(255, 255, 255));
				jbuttonStatistic.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jbuttonStatistic_actionPerformed(e);
					}
				});
				jbuttonStatistic.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/images/icons8_Home_26px_2.png")));
				jpanelLeft.add(jbuttonStatistic);
		jbuttonBookList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/images/icons8_Book_26px.png")));
		jpanelLeft.add(jbuttonBookList);

		jbuttonAuthorList = new JButton("   Author");
		jbuttonAuthorList.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonAuthorList.setMaximumSize(new Dimension(200, 60));
		jbuttonAuthorList.setPreferredSize(new Dimension(63, 50));
		jbuttonAuthorList.setBorderPainted(false);
		jbuttonAuthorList.setContentAreaFilled(false);
		jbuttonAuthorList.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonAuthorList.setForeground(new Color(192, 192, 192));
		jbuttonAuthorList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/images/icons8-writer-male-24.png")));
		jbuttonAuthorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAuthorList_actionPerformed(e);
			}
		});
		jpanelLeft.add(jbuttonAuthorList);

		jbuttonCategory = new JButton("   Category");
		jbuttonCategory.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonCategory.setMaximumSize(new Dimension(200, 60));
		jbuttonCategory.setBorderPainted(false);
		jbuttonCategory.setContentAreaFilled(false);
		jbuttonCategory.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonCategory.setForeground(new Color(192, 192, 192));
		jbuttonCategory.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/images/icons8-diversity-24(1).png")));
		jbuttonCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCategory_actionPerformed(e);
			}
		});
		jpanelLeft.add(jbuttonCategory);

		jbuttonBorrowList = new JButton("   Issue Book");
		jbuttonBorrowList.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonBorrowList.setMaximumSize(new Dimension(200, 60));
		jbuttonBorrowList.setMinimumSize(new Dimension(90, 50));
		jbuttonBorrowList.setBorderPainted(false);
		jbuttonBorrowList.setContentAreaFilled(false);
		jbuttonBorrowList.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonBorrowList.setForeground(new Color(192, 192, 192));
		jbuttonBorrowList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBorrowList_actionPerformed(e);
			}
		});
		jbuttonBorrowList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/images/icons8_Sell_26px.png")));
		jpanelLeft.add(jbuttonBorrowList);

		jbuttonBorrowedList = new JButton("   Return Book");
		jbuttonBorrowedList.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonBorrowedList.setMaximumSize(new Dimension(200, 60));
		jbuttonBorrowedList.setBorderPainted(false);
		jbuttonBorrowedList.setContentAreaFilled(false);
		jbuttonBorrowedList.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonBorrowedList.setForeground(new Color(192, 192, 192));
		jbuttonBorrowedList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBorrowedList_actionPerformed(e);
			}
		});
		jbuttonBorrowedList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/images/icons8_Return_Purchase_26px.png")));
		jpanelLeft.add(jbuttonBorrowedList);

		jbuttonVRecord = new JButton("   View Record");
		jbuttonVRecord.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonVRecord.setMaximumSize(new Dimension(200, 60));
		jbuttonVRecord.setBorderPainted(false);
		jbuttonVRecord.setContentAreaFilled(false);
		jbuttonVRecord.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonVRecord.setForeground(new Color(192, 192, 192));
		jbuttonVRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonVRecord_actionPerformed(e);
			}
		});
		jbuttonVRecord.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/images/icons8_View_Details_26px.png")));
		jpanelLeft.add(jbuttonVRecord);

		jbuttonCustmList = new JButton("   Customer");
		jbuttonCustmList.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonCustmList.setMaximumSize(new Dimension(200, 60));
		jbuttonCustmList.setBorderPainted(false);
		jbuttonCustmList.setContentAreaFilled(false);
		jbuttonCustmList.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonCustmList.setForeground(new Color(192, 192, 192));
		jbuttonCustmList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCustmList_actionPerformed(e);
			}
		});
		jbuttonCustmList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/images/icons8_Read_Online_26px.png")));
		jpanelLeft.add(jbuttonCustmList);

		JButton jbuttonEmplList = new JButton("   Employee");
		jbuttonEmplList.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonEmplList.setMaximumSize(new Dimension(200, 60));
		jbuttonEmplList.setBorderPainted(false);
		jbuttonEmplList.setContentAreaFilled(false);
		jbuttonEmplList.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonEmplList.setForeground(new Color(192, 192, 192));
		jbuttonEmplList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEmployeeList_actionPerformed(e);
			}
		});
		jbuttonEmplList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/images/icons8_Conference_26px.png")));
		jpanelLeft.add(jbuttonEmplList);
		
		jbuttonLogOut = new JButton("   Log Out");
		jbuttonLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonLogOut_actionPerformed(e);
			}
		});
		jbuttonLogOut.setBorderPainted(false);
		jbuttonLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonLogOut.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/images/icons8_Exit_26px_2.png")));
		jbuttonLogOut.setBackground(new Color(102, 102, 255));
		jbuttonLogOut.setForeground(new Color(255, 255, 255));
		jbuttonLogOut.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonLogOut.setMaximumSize(new Dimension(200, 60));
		jpanelLeft.add(jbuttonLogOut);

		jpanelRight = new JPanel();
		contentPane.add(jpanelRight, BorderLayout.CENTER);
		jpanelRight.setLayout(new BoxLayout(jpanelRight, BoxLayout.X_AXIS));

	}
	
	public JFrameMain(Map<String, Object> data) {
		this();
		this.data = data;
		
		initJFrame();
	}

//	Functions 
	private void initJFrame() {
		clearScreen();
		Employee employee = (Employee) data.get("employee");
		jlabelWelcome.setText("Welcome, " + employee.getName());
		
		JPanelDashBoard jpanelHome = new JPanelDashBoard();
		jpanelRight.add(jpanelHome);
		jpanelHome.setVisible(true);
	}
	
	public void jbuttonVRecord_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelRecord jpanelVRecord = new JPanelRecord();
		jpanelRight.add(jpanelVRecord);
		jpanelVRecord.setVisible(true);
	}
	
	public void jbuttonStatistic_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelDashBoard jpanelStatistic = new JPanelDashBoard();
		jpanelRight.add(jpanelStatistic);
		jpanelStatistic.setVisible(true);
	}

	public void jbuttonCustmList_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelCustmList jpanelCustmList = new JPanelCustmList();
		jpanelRight.add(jpanelCustmList);
		jpanelCustmList.setVisible(true);
	}

	public void jbuttonEmployeeList_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelEmpList jpanelEmpList = new JPanelEmpList();
		jpanelRight.add(jpanelEmpList);
		jpanelEmpList.setVisible(true);
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
		JPanelBorrowAdd jPanelBorrowAdd = new JPanelBorrowAdd(jpanelRight);
		jpanelRight.add(jPanelBorrowList);
		jPanelBorrowList.setVisible(true);
	}

	public void jbuttonBorrowedList_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelBorrowedList jPanelBorrowedList = new JPanelBorrowedList(jpanelRight);
		JPanelBorrowedAdd jPanelBorrowedAdd = new JPanelBorrowedAdd(jpanelRight);
		jpanelRight.add(jPanelBorrowedList);
		jPanelBorrowedList.setVisible(true);
	}
	
	public void jbuttonLogOut_actionPerformed(ActionEvent e) {
		clearScreen();
		JFrameLogin jframeLogin = new JFrameLogin();
		jframeLogin.setVisible(true);
		this.dispose();
	}

//	Components
	private void clearScreen() {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
	}
}