package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class JPanelAddReader extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public JPanelAddReader() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 192));
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("CREATE NEW USER ACCOUNT");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Keyword");
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		panel_1.add(btnNewButton);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

	}

}
