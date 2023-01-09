package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
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
		
		JButton btnNewButton = new JButton("BOOK SEARCH");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(220, 54, 156, 36);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(btnNewButton);
		
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
}
