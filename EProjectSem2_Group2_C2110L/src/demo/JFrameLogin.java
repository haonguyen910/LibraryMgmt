package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import entities.Employee;
import models.EmployeeModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JFrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldUsername;
	private JPasswordField jpasswordFieldPassword;

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
		setBounds(100, 100, 1145, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 68, 98));
		panel.setPreferredSize(new Dimension(500, 10));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBackground(new Color(102, 102, 255));
		lblNewLabel.setBounds(195, 82, 122, 46);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1
				.setIcon(new ImageIcon(JFrameLogin.class.getResource("/resources/images/icons8_Account_50px.png")));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(83, 281, 62, 66);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(155, 281, 83, 14);
		panel.add(lblNewLabel_1);

		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setForeground(new Color(255, 255, 255));
		jtextFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtextFieldUsername.setColumns(10);
		jtextFieldUsername.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(255, 255, 255)));
		jtextFieldUsername.setBackground(new Color(70, 68, 98));
		jtextFieldUsername.setBounds(155, 306, 250, 40);
		panel.add(jtextFieldUsername);

		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(
				new ImageIcon(JFrameLogin.class.getResource("/resources/images/icons8_Forgot_Password_50px_4.png")));
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(83, 409, 62, 66);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(155, 409, 83, 14);
		panel.add(lblNewLabel_1_2);

		jpasswordFieldPassword = new JPasswordField();
		jpasswordFieldPassword.setForeground(new Color(255, 255, 255));
		jpasswordFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jpasswordFieldPassword.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(255, 255, 255)));
		jpasswordFieldPassword.setBackground(new Color(70, 68, 98));
		jpasswordFieldPassword.setBounds(155, 435, 250, 40);
		panel.add(jpasswordFieldPassword);

		JButton jbuttonLogin = new JButton("Log-In");
		jbuttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonLogin_actionPerformed(e);
			}
		});
		jbuttonLogin.setForeground(new Color(52, 52, 52));
		jbuttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jbuttonLogin.setBorderPainted(false);
		jbuttonLogin.setBackground(new Color(192, 192, 192));
		jbuttonLogin.setBounds(83, 559, 322, 51);
		panel.add(jbuttonLogin);

		JLabel lblNewLabel_2 = new JLabel("Welcome, Log in to your account");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(124, 140, 260, 40);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_2.setPreferredSize(new Dimension(800, 100));
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("MOHAN LIBRARY MANAGEMENT SYSTEM");
		lblNewLabel_3.setForeground(new Color(70, 68, 98));
		lblNewLabel_3.setPreferredSize(new Dimension(800, 100));
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(JFrameLogin.class.getResource("/resources/images/library-3.png.png")));
		panel_3.add(lblNewLabel_4);
	}

	public void jbuttonLogin_actionPerformed(ActionEvent e) {
		if (validateLogin()) {
			String username = jtextFieldUsername.getText();
			String password = new String(jpasswordFieldPassword.getPassword());
			EmployeeModel employeeModel = new EmployeeModel();
			Employee employee = employeeModel.login(username, password);
			if (employee != null) {
				Map<String, Object> data =  new HashMap<String, Object>();
				data.put("employee", employee);
				JOptionPane.showMessageDialog(this, "Welcome to Mohan Library Management System");
				JFrameMain jfMain = new JFrameMain(data);
				jfMain.setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Incorrect username or password");
			}
		}
	}

	public boolean validateLogin() {
		String username = jtextFieldUsername.getText();
		String password = new String(jpasswordFieldPassword.getPassword());
		if (username.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter username");
			return false;
		}
		if (password.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter password");
			return false;
		}

		return true;
	}
}
