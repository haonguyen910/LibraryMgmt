package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class JFrameTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameTest frame = new JFrameTest();
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
	public JFrameTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(25, 369, 850, 250);
		contentPane.add(panel_5);
		
		JLabel lblNewLabel_1_4 = new JLabel("Name");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(274, 82, 46, 22);
		panel_5.add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(330, 82, 150, 26);
		panel_5.add(textField_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(258, 115, 62, 22);
		panel_5.add(lblNewLabel_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(330, 115, 150, 26);
		panel_5.add(textField_5);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Phone");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(274, 152, 46, 22);
		panel_5.add(lblNewLabel_1_2_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(330, 152, 150, 26);
		panel_5.add(textField_6);
		
		JLabel lblNewLabel_1_5 = new JLabel("ID");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(274, 45, 46, 22);
		panel_5.add(lblNewLabel_1_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(330, 45, 150, 26);
		panel_5.add(textField_7);
		
		JLabel jlablePhoto = new JLabel("");
		jlablePhoto.setIconTextGap(8);
		jlablePhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlablePhoto.setBounds(60, 34, 150, 150);
		panel_5.add(jlablePhoto);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Department");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(529, 45, 86, 22);
		panel_5.add(lblNewLabel_1_3_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(625, 45, 150, 26);
		panel_5.add(textField_8);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Username");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(553, 118, 62, 22);
		panel_5.add(lblNewLabel_1_1_1_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(625, 118, 150, 26);
		panel_5.add(textField_9);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(553, 155, 62, 22);
		panel_5.add(lblNewLabel_1_1_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(625, 157, 150, 26);
		panel_5.add(passwordField);
		
		JButton jbuttonBrowse = new JButton("Browse...");
		jbuttonBrowse.setPreferredSize(new Dimension(79, 30));
		jbuttonBrowse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jbuttonBrowse.setBounds(60, 195, 150, 30);
		panel_5.add(jbuttonBrowse);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Created");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(559, 82, 56, 22);
		panel_5.add(lblNewLabel_1_2_1_1);
		
		JDateChooser jdateChooser_1 = new JDateChooser();
		jdateChooser_1.setBounds(625, 82, 150, 26);
		panel_5.add(jdateChooser_1);
		
		JCheckBox jcheckboxAdmin = new JCheckBox("Admin Authority");
		jcheckboxAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jcheckboxAdmin.setBounds(591, 192, 152, 23);
		panel_5.add(jcheckboxAdmin);
		
		JLabel lblNewLabel_2_1 = new JLabel("Book Details");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 39, 106, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 442, 127);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Details");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 206, 132, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 231, 442, 127);
		contentPane.add(scrollPane_1);
	}
}
