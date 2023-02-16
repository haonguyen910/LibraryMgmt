package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;

import org.mindrot.jbcrypt.BCrypt;

import entities.Employee;
import models.ConnectDB;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;

public class JPanelProfile extends JPanel {
	private JTextField jtextFieldName;
	private JTextField jtextFieldAddress;
	private JTextField jtextFieldPhone;
	private JTextField jtextFieldEmail;
	private JTextField jtextFieldUsername;
	private JPasswordField jpasswordFieldPassword;
	private Map<String, Object> data;
	private Employee employee;
	private JLabel jlablePhoto;
	private JTextField jtextFieldID;
	private File file;
	private JButton jbuttonBrowse;

	/**
	 * Create the panel.
	 */
	public JPanelProfile() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		panel.setBackground(new Color(52, 52, 52));
		add(panel);

		JLabel lblNewLabel = new JLabel("Profile Setting");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Information", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_3.setBounds(26, 39, 342, 768);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		jlablePhoto = new JLabel("");
		jlablePhoto.setBounds(94, 29, 150, 150);
		panel_3.add(jlablePhoto);
		jlablePhoto.setIconTextGap(8);
		jlablePhoto.setBorder(new LineBorder(new Color(0, 0, 0)));

		jbuttonBrowse = new JButton("Browse...");
		jbuttonBrowse.setBounds(94, 190, 150, 30);
		panel_3.add(jbuttonBrowse);
		jbuttonBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBrowse_actionPerformed(e);
			}
		});
		jbuttonBrowse.setPreferredSize(new Dimension(79, 30));
		jbuttonBrowse.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_1_3 = new JLabel("ID");
		lblNewLabel_1_3.setBounds(50, 256, 46, 22);
		panel_3.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtextFieldID = new JTextField();
		jtextFieldID.setBounds(134, 252, 150, 35);
		panel_3.add(jtextFieldID);
		jtextFieldID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(50, 317, 46, 22);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtextFieldName = new JTextField();
		jtextFieldName.setBounds(134, 313, 150, 35);
		panel_3.add(jtextFieldName);
		jtextFieldName.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setBounds(50, 371, 62, 22);
		panel_3.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtextFieldAddress = new JTextField();
		jtextFieldAddress.setBounds(134, 367, 150, 35);
		panel_3.add(jtextFieldAddress);
		jtextFieldAddress.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setBounds(50, 427, 46, 22);
		panel_3.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setBounds(134, 423, 150, 35);
		panel_3.add(jtextFieldPhone);
		jtextFieldPhone.setPreferredSize(new Dimension(7, 35));
		jtextFieldPhone.setColumns(10);

		JLabel lblNewLabel_1_3_1 = new JLabel("Email");
		lblNewLabel_1_3_1.setBounds(50, 479, 74, 22);
		panel_3.add(lblNewLabel_1_3_1);
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtextFieldEmail = new JTextField();
		jtextFieldEmail.setBounds(134, 475, 150, 35);
		panel_3.add(jtextFieldEmail);
		jtextFieldEmail.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Username");
		lblNewLabel_1_1_1.setBounds(50, 565, 62, 22);
		panel_3.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setBounds(134, 561, 150, 35);
		panel_3.add(jtextFieldUsername);
		jtextFieldUsername.setColumns(10);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1.setBounds(50, 621, 62, 22);
		panel_3.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jpasswordFieldPassword = new JPasswordField();
		jpasswordFieldPassword.setBounds(134, 617, 150, 35);
		panel_3.add(jpasswordFieldPassword);

		JButton jbuttonEdit = new JButton("Edit");
		jbuttonEdit.setBounds(94, 690, 150, 35);
		panel_3.add(jbuttonEdit);
		jbuttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEdit_actionPerformed(e);
			}
		});
		jbuttonEdit.setPreferredSize(new Dimension(89, 25));
		jbuttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));

	}

	public JPanelProfile(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}

	private void initJFrame() {
		employee = (Employee) data.get("employee");
		int id = employee.getId();
		try {
			PreparedStatement ps = ConnectDB.connection()
					.prepareStatement("select * from employee where id = '" + id + "'");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				jtextFieldID.setText(rs.getString("id"));
				jtextFieldName.setText(rs.getString("name"));
				jtextFieldAddress.setText(rs.getString("address"));
				jtextFieldPhone.setText(rs.getString("phone"));
				jtextFieldEmail.setText(rs.getString("email"));
				jtextFieldUsername.setText(rs.getString("username"));
				jpasswordFieldPassword.setText(rs.getString("password"));
				byte[] imageData = rs.getBytes("photo");
				ImageIcon photo = new ImageIcon(new ImageIcon(imageData).getImage()
						.getScaledInstance(jlablePhoto.getWidth(), jlablePhoto.getHeight(), Image.SCALE_DEFAULT));
				jlablePhoto.setIcon(photo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jbuttonEdit_actionPerformed(ActionEvent e) {

		String sql = "update employee set name = ?, address = ?, phone = ?, email = ?, username = ?, password = ?, photo = ? where id = ?";
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(sql);
			ps.setString(1, jtextFieldName.getText());
			ps.setString(2, jtextFieldAddress.getText());
			ps.setString(3, jtextFieldPhone.getText());
			ps.setString(4, jtextFieldEmail.getText());
			ps.setString(5, jtextFieldUsername.getText());
			ps.setString(6, BCrypt.hashpw(new String(jpasswordFieldPassword.getPassword()), BCrypt.gensalt()));
			ps.setBytes(7, Files.readAllBytes(Paths.get(file.getAbsolutePath())));
			ps.setString(8, jtextFieldID.getText());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(this, "Updated");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}

	public void jbuttonBrowse_actionPerformed(ActionEvent e) {
		JFileChooser jfileChooser = new JFileChooser("C:\\Users\\admin\\Desktop\\Image");
		jfileChooser.setDialogTitle("Select a Photo");
		jfileChooser.setMultiSelectionEnabled(false);
		int result = jfileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = jfileChooser.getSelectedFile();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage()
					.getScaledInstance(jlablePhoto.getWidth(), jlablePhoto.getHeight(), Image.SCALE_DEFAULT));
			jlablePhoto.setIcon(imageIcon);
		}
	}
}
