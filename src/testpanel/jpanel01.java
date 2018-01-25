package testpanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jpanel01 extends JPanel {
	private JTextField textField;
	private JTextField textField_2;
	private DefaultListModel listModel;
	/**
	 * Create the panel.
	 */
	public jpanel01() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(14, 10, 46, 27);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(78, 13, 113, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Note");
		lblNewLabel_1.setBounds(14, 206, 54, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile");
		lblNewLabel_2.setBounds(14, 51, 54, 15);
		add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(78, 48, 113, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(14, 411, 219, 25);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(396, 286, 207, 194);
		add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(78, 137, 113, 23);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(78, 104, 113, 23);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(78, 170, 113, 23);
		add(comboBox_2);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(14, 108, 54, 15);
		add(lblDay);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(14, 141, 54, 15);
		add(lblTime);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(14, 174, 54, 15);
		add(lblStatus);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 231, 219, 113);
		add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(14, 369, 219, 25);
		add(btnClear);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(260, 10, 394, 269);
		add(tabbedPane);
		
		
		
	    listModel = new DefaultListModel();
	    listModel.addElement("Jane Doe");
	    listModel.addElement("John Smith");
	    listModel.addElement("Kathy Green");
		
		

	}
}
