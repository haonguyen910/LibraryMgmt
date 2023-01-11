package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameHome extends JFrame {

	private JPanel contentPane;
	private JButton jbuttonBook;
	private JPanel jpanelRight;
	private JButton jbuttonSetting;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Theme
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameHome frame = new JFrameHome();
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
	public JFrameHome() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 192));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		jbuttonBook = new JButton("Book");
		jbuttonBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBook_actionPerformed(e);
			}
		});
		panel.add(jbuttonBook);

		JButton btnNewButton_1 = new JButton("Borrow");
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Borrowed");
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Auhtor");
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Category");
		panel.add(btnNewButton_4);

		jbuttonSetting = new JButton("Setting");
		jbuttonSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSetting_actionPerformed(e);
			}
		});
		panel.add(jbuttonSetting);

		jpanelRight = new JPanel();
		contentPane.add(jpanelRight, BorderLayout.CENTER);
		jpanelRight.setLayout(new BoxLayout(jpanelRight, BoxLayout.X_AXIS));
	}

//	Functions
	private void jbuttonBook_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelBookList jPanelBookList = new JPanelBookList();
		jpanelRight.add(jPanelBookList);
		jPanelBookList.setVisible(true);
	}

	private void jbuttonSetting_actionPerformed(ActionEvent e) {
		clearScreen();
	}

	private void clearScreen() {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
	}
}
