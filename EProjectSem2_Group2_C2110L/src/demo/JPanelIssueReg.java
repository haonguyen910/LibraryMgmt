package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class JPanelIssueReg extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanelIssueReg() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Issue Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel = new JPanel();
		add(panel);

	}

}
