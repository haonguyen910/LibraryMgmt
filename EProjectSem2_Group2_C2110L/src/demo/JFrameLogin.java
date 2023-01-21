package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JFrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
					JFrameLogin frame = new JFrameLogin();
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
	public JFrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton jbuttonBookSearch = new JButton("BOOK SEARCH");
		jbuttonBookSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBookSearch_actionPerformed(e);
			}
		});
		jbuttonBookSearch.setForeground(new Color(255, 255, 255));
		jbuttonBookSearch.setBackground(new Color(128, 128, 192));
		jbuttonBookSearch.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonBookSearch.setBounds(220, 54, 156, 36);
		jbuttonBookSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		jbuttonBookSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(jbuttonBookSearch);
		
		JPanel jpanelLogin = new JPanel();
		jpanelLogin.setBounds(140, 130, 323, 199);
		jpanelLogin.setBorder(new TitledBorder(null, "ACCOUNT LOGIN", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		contentPane.add(jpanelLogin);
		jpanelLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setBounds(31, 54, 71, 16);
		jpanelLogin.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(114, 45, 184, 35);
		jpanelLogin.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPassword.setBounds(31, 100, 71, 16);
		jpanelLogin.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(114, 91, 184, 35);
		jpanelLogin.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_1.setBounds(48, 145, 90, 28);
		jpanelLogin.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Cancel");
		btnNewButton_1_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(175, 145, 90, 28);
		jpanelLogin.add(btnNewButton_1_1);
	}
	
	private void initJframe() {
		

	}
	
	public void jbuttonBookSearch_actionPerformed(ActionEvent e) {
		JFrameSearch jframeSearch = new JFrameSearch();
		jframeSearch.setVisible(true);
		this.setVisible(false);
	}
}
