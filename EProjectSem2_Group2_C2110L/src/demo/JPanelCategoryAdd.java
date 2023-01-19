package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import entities.Author;
import entities.Category;
import models.AuthorModel;
import models.CategoryModel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelCategoryAdd extends JPanel {
//	JPanel Right Of JFrameMain
	private JPanel jpanelRight;

	private JTextField jtextFieldName;
	private JButton jbuttonSave;
	private JButton jbuttonCancel;

//	Global Variable
	CategoryModel categoryModel = new CategoryModel();
	private Category category;

	/**
	 * Create the panel.
	 */
	public JPanelCategoryAdd(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 192));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);

		JLabel lblNewLabel = new JLabel("Add Category");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setMaximumSize(new Dimension(50, 30));
		lblNewLabel_1.setPreferredSize(new Dimension(50, 30));
		lblNewLabel_1.setMinimumSize(new Dimension(50, 30));
		panel_1.add(lblNewLabel_1);

		jtextFieldName = new JTextField();
		jtextFieldName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldName.setMinimumSize(new Dimension(200, 30));
		jtextFieldName.setPreferredSize(new Dimension(200, 30));
		panel_1.add(jtextFieldName);
		jtextFieldName.setColumns(10);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel_3);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setPreferredSize(new Dimension(50, 30));
		lblNewLabel_1_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_1.setMaximumSize(new Dimension(50, 30));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(lblNewLabel_1_1);

		jbuttonSave = new JButton("Save");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonSave);
		jbuttonSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jbuttonSave.setPreferredSize(new Dimension(80, 30));
		jbuttonSave.setMinimumSize(new Dimension(80, 30));
		jbuttonSave.setMaximumSize(new Dimension(80, 30));

		jbuttonCancel = new JButton("Cancel");
		jbuttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancel_actionPerformed(e);
			}
		});
		jbuttonCancel.setPreferredSize(new Dimension(80, 30));
		jbuttonCancel.setMinimumSize(new Dimension(80, 30));
		jbuttonCancel.setMaximumSize(new Dimension(80, 30));
		jbuttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(jbuttonCancel);

		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

	}

//	Functions
	private void jbuttonSave_actionPerformed(ActionEvent e) {
		try {
			category = new Category();
			category.setName(jtextFieldName.getText());

			if (categoryModel.create(category)) {
				JOptionPane.showMessageDialog(this, "Success");
				jpanelRight.removeAll();
				jpanelRight.revalidate();
				JPanelCategoryList jPanelCategoryList = new JPanelCategoryList(jpanelRight);
				jpanelRight.add(jPanelCategoryList);
				jPanelCategoryList.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}

	public void jbuttonCancel_actionPerformed(ActionEvent e) {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
		JPanelAuthorList jPanelAuthorList = new JPanelAuthorList(jpanelRight);
		jpanelRight.add(jPanelAuthorList);
		jPanelAuthorList.setVisible(true);
	}

}
