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
		panel.setBackground(new Color(102, 102, 255));
		panel.setPreferredSize(new Dimension(400, 10));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBackground(new Color(102, 102, 255));
		lblNewLabel.setBounds(150, 84, 122, 46);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1
				.setIcon(new ImageIcon(JFrameLogin.class.getResource("/resources/images/icons8_Account_50px.png")));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(38, 283, 62, 66);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(110, 283, 83, 14);
		panel.add(lblNewLabel_1);

		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtextFieldUsername.setColumns(10);
		jtextFieldUsername.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(255, 255, 255)));
		jtextFieldUsername.setBackground(new Color(102, 102, 255));
		jtextFieldUsername.setBounds(110, 308, 250, 40);
		panel.add(jtextFieldUsername);

		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(
				new ImageIcon(JFrameLogin.class.getResource("/resources/images/icons8_Forgot_Password_50px_4.png")));
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(38, 411, 62, 66);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(110, 411, 83, 14);
		panel.add(lblNewLabel_1_2);

		jpasswordFieldPassword = new JPasswordField();
		jpasswordFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jpasswordFieldPassword.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(255, 255, 255)));
		jpasswordFieldPassword.setBackground(new Color(102, 102, 255));
		jpasswordFieldPassword.setBounds(110, 437, 250, 40);
		panel.add(jpasswordFieldPassword);

		JButton jbuttonLogin = new JButton("Log-In");
		jbuttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonLogin_actionPerformed(e);
			}
		});
		jbuttonLogin.setForeground(Color.WHITE);
		jbuttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jbuttonLogin.setBorderPainted(false);
		jbuttonLogin.setBackground(new Color(255, 51, 51));
		jbuttonLogin.setBounds(79, 561, 260, 51);
		panel.add(jbuttonLogin);

		JLabel lblNewLabel_2 = new JLabel("Welcome, Log in to your account");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(79, 142, 260, 40);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-25, 111, 738, 616);
		lblNewLabel_3.setIcon(new ImageIcon(JFrameLogin.class.getResource("/resources/images/library-3.png.png")));
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("H&A LIBRARY MANAGEMENT SYSTEM");
		lblNewLabel_4.setForeground(new Color(255, 51, 51));
		lblNewLabel_4.setFont(new Font("Source Code Pro Medium", Font.BOLD, 30));
		lblNewLabel_4.setBounds(91, 55, 561, 44);
		panel_1.add(lblNewLabel_4);
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
				JOptionPane.showMessageDialog(this, "Welcome to H&A Library Management System");
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
