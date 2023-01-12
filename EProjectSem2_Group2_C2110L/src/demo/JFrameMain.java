package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
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
import javax.swing.SwingConstants;

public class JFrameMain extends JFrame {

	private JPanel contentPane;
	private JPanel jpanelMain;

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
		setBounds(100, 100, 900, 500);
		
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
		mnNewMenu.setHorizontalAlignment(SwingConstants.TRAILING);
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
		
		JPanel panel = new JPanel();
		jpanelMain.add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton jbuttonBookList = new JButton("Book List");
		jbuttonBookList.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/book_color.png")));
		panel.add(jbuttonBookList);
		
		JButton btnNewButton_3 = new JButton("Issue Register");
		btnNewButton_3.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/sign.png")));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Statistic Report");
		btnNewButton_4.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/report.png")));
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Reader List");
		btnNewButton_5.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/user.png")));
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Employee List");
		btnNewButton_6.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/employee.png")));
		panel.add(btnNewButton_6);
	}
	
	public void jmenuItemAddReader_actionPerformed(ActionEvent e) {
		JPanelAddReader jpanelAddReader = new JPanelAddReader();
		jpanelMain.add(jpanelAddReader);
		jpanelAddReader.setVisible(true);
	}
}
