package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import org.mindrot.jbcrypt.BCrypt;

import entities.Employee;
import models.EmployeeModel;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

public class JFrameEmpAdd extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldName;
	private JTextField jtextFieldAddress;
	private JTextField jtextFieldPhone;
	private JTextField jtextFieldDepartment;
	private JTextField jtextFieldUsername;
	private JPasswordField jpasswordFieldPassword;
	private JButton jbuttonUpload;
	private JButton jbuttonCancel;
	private JButton jbuttonClear;
	private JButton jbuttonSave;
	private JLabel jlablePhoto;
	private JDateChooser jdateChooser;
	private JCheckBox jcheckboxAdmin;
	private File file;

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
					JFrameEmpAdd frame = new JFrameEmpAdd();
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
	public JFrameEmpAdd() {
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(286, 41, 86, 23);
		panel_2.add(lblNewLabel_1);
		
		jtextFieldName = new JTextField();
		jtextFieldName.setBounds(385, 37, 218, 27);
		panel_2.add(jtextFieldName);
		jtextFieldName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(286, 79, 86, 23);
		panel_2.add(lblNewLabel_1_1);
		
		jtextFieldAddress = new JTextField();
		jtextFieldAddress.setColumns(10);
		jtextFieldAddress.setBounds(385, 75, 218, 27);
		panel_2.add(jtextFieldAddress);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(286, 117, 86, 23);
		panel_2.add(lblNewLabel_1_2);
		
		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setColumns(10);
		jtextFieldPhone.setBounds(385, 113, 218, 27);
		panel_2.add(jtextFieldPhone);
		
		JLabel lblNewLabel_1_3 = new JLabel("Department");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(286, 155, 86, 23);
		panel_2.add(lblNewLabel_1_3);
		
		jtextFieldDepartment = new JTextField();
		jtextFieldDepartment.setColumns(10);
		jtextFieldDepartment.setBounds(385, 151, 218, 27);
		panel_2.add(jtextFieldDepartment);
		
		JLabel lblNewLabel_1_4 = new JLabel("Username");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(286, 193, 86, 23);
		panel_2.add(lblNewLabel_1_4);
		
		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setColumns(10);
		jtextFieldUsername.setBounds(385, 189, 218, 27);
		panel_2.add(jtextFieldUsername);
		
		JLabel lblNewLabel_1_5 = new JLabel("Password");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(286, 231, 86, 23);
		panel_2.add(lblNewLabel_1_5);
		
		jpasswordFieldPassword = new JPasswordField();
		jpasswordFieldPassword.setBounds(385, 227, 218, 27);
		panel_2.add(jpasswordFieldPassword);
		
		jlablePhoto = new JLabel("");
		jlablePhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		jlablePhoto.setBounds(31, 44, 218, 173);
		panel_2.add(jlablePhoto);
		
		jbuttonUpload = new JButton("Upload Photo");
		jbuttonUpload.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jbuttonUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonUpload_actionPerformed(e);
			}
		});
		jbuttonUpload.setBounds(31, 230, 218, 33);
		panel_2.add(jbuttonUpload);
		
		jbuttonSave = new JButton("Save");
		jbuttonSave.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		jbuttonSave.setBounds(179, 357, 89, 33);
		panel_2.add(jbuttonSave);
		
		jbuttonCancel = new JButton("Cancel");
		jbuttonCancel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jbuttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancel_actionPerformed(e);
			}
		});
		jbuttonCancel.setBounds(280, 357, 89, 33);
		panel_2.add(jbuttonCancel);
		
		jbuttonClear = new JButton("Clear");
		jbuttonClear.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jbuttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonClear_actionPerformed(e);
			}
		});
		jbuttonClear.setBounds(379, 357, 89, 33);
		panel_2.add(jbuttonClear);
		
		jcheckboxAdmin = new JCheckBox("Admin ");
		jcheckboxAdmin.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jcheckboxAdmin.setBounds(385, 306, 104, 39);
		panel_2.add(jcheckboxAdmin);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Created");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4_1.setBounds(286, 266, 86, 28);
		panel_2.add(lblNewLabel_1_4_1);
		
		jdateChooser = new JDateChooser();
		jdateChooser.setBounds(384, 266, 219, 28);
		panel_2.add(jdateChooser);
		
		initJFrame();
	}
	
	private void initJFrame() {
		
	}
	
	private void jbuttonUpload_actionPerformed(ActionEvent e) {
		JFileChooser jfileChooser = new JFileChooser("C:\\Users\\admin\\Desktop\\Image");
		jfileChooser.setDialogTitle("Select a Photo");
		jfileChooser.setMultiSelectionEnabled(false);
		int result = jfileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = jfileChooser.getSelectedFile();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(jlablePhoto.getWidth(), jlablePhoto.getHeight(), Image.SCALE_DEFAULT));
			jlablePhoto.setIcon(imageIcon);
		}
	}
	 
	private void jbuttonSave_actionPerformed(ActionEvent e) {
		try {
			Employee employee = new Employee();
			employee.setName(jtextFieldName.getText().trim());
			employee.setAddress(jtextFieldPhone.getText());
			employee.setPhone(jtextFieldPhone.getText());
			employee.setDepartment(jtextFieldDepartment.getText());
			employee.setUsername(jtextFieldUsername.getText());
			String password = new String(jpasswordFieldPassword.getPassword());
			employee.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
			employee.setCreated(jdateChooser.getDate());
			employee.setIs_admin(jcheckboxAdmin.isSelected());
			employee.setPhoto(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
			EmployeeModel employeeModel = new EmployeeModel();
			if(employeeModel.create(employee)) {
				JOptionPane.showMessageDialog(this, "Sucessfully Created");
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}
	
	private void jbuttonCancel_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
	
	private void jbuttonClear_actionPerformed(ActionEvent e) {
		jtextFieldAddress.setText("");
		jtextFieldDepartment.setText("");
		jtextFieldName.setText("");
		jtextFieldPhone.setText("");
		jtextFieldUsername.setText("");
		jpasswordFieldPassword.setText("");
	}
}
