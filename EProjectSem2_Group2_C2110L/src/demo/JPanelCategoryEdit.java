package demo;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import entities.Category;
import entities.Employee;
import models.CategoryModel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class JPanelCategoryEdit extends JPanel {
//	JPanel Right Of JFrameMain
	private JPanel jpanelRight;

	private JTextField jtextFieldId;
	private JTextField jtextFieldName;
	private JButton jbuttonSave;
	private JButton jbuttonCancel;

//	Global Variable
	CategoryModel categoryModel = new CategoryModel();
	private Category category;
	private Map<String, Object> data;
	private Map<String, Object> dataPut;
	private Employee employee;

	/**
	 * Create the panel.
	 */
	public JPanelCategoryEdit(JPanel JpanelRight) {
		jpanelRight = JpanelRight;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(52, 52, 52));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(15);
		add(panel);

		JLabel lblNewLabel = new JLabel("Edit Category");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setMaximumSize(new Dimension(50, 30));
		lblNewLabel_1.setPreferredSize(new Dimension(50, 30));
		lblNewLabel_1.setMinimumSize(new Dimension(50, 30));
		panel_1.add(lblNewLabel_1);

		jtextFieldId = new JTextField();
		jtextFieldId.setEditable(false);
		jtextFieldId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldId.setMinimumSize(new Dimension(200, 30));
		jtextFieldId.setPreferredSize(new Dimension(200, 30));
		panel_1.add(jtextFieldId);
		jtextFieldId.setColumns(30);

		JPanel panel_1_1 = new JPanel();
		add(panel_1_1);
		panel_1_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));

		JLabel lblNewLabel_1_2 = new JLabel("Name:");
		lblNewLabel_1_2.setPreferredSize(new Dimension(50, 30));
		lblNewLabel_1_2.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_2.setMaximumSize(new Dimension(50, 30));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1_1.add(lblNewLabel_1_2);

		jtextFieldName = new JTextField();
		jtextFieldName.setPreferredSize(new Dimension(200, 30));
		jtextFieldName.setMinimumSize(new Dimension(200, 30));
		jtextFieldName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtextFieldName.setColumns(30);
		panel_1_1.add(jtextFieldName);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setVgap(10);
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

	/**
	 * @wbp.parser.constructor
	 */
	public JPanelCategoryEdit(JPanel JpanelRight, Map<String, Object> data) {
		this(JpanelRight);
		this.data = data;
		initJFrame();
	}

//	Functions
	private void initJFrame() {
		employee = (Employee) data.get("employee");
		dataPut = new HashMap<String, Object>();
		dataPut.put("employee", employee);

		int id = Integer.parseInt(this.data.get("id").toString());
		category = categoryModel.find(id);

		jtextFieldId.setText(String.valueOf(category.getId()));
		jtextFieldName.setText(category.getName());

	}

	private void jbuttonSave_actionPerformed(ActionEvent e) {
		try {
			category.setName(jtextFieldName.getText());

			if (categoryModel.update(category)) {
				JOptionPane.showMessageDialog(this, "Successful updated category!");
				backJPanelList();
			} else {
				JOptionPane.showMessageDialog(this, "Failed, something went wrong...");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
	}

	private void jbuttonCancel_actionPerformed(ActionEvent e) {
		backJPanelList();
	}

	private void backJPanelList() {
		jpanelRight.removeAll();
		jpanelRight.revalidate();
		JPanelCategoryList jPanelCategoryList = new JPanelCategoryList(jpanelRight, dataPut);
		jpanelRight.add(jPanelCategoryList);
		jPanelCategoryList.setVisible(true);
	}

}
