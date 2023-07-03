package EmployeeDB;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

public class EmployeeEntrynew extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EmployeeEntrynew dialog = new EmployeeEntrynew();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EmployeeEntrynew() {
		setBounds(100, 100, 465, 504);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 429, 326);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("EmployeeID:");
				lblNewLabel.setBounds(30, 28, 96, 28);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblEmployeeID = new JLabel("");
				lblEmployeeID.setBounds(136, 35, 160, 17);
				panel.add(lblEmployeeID);
			}
		}
	}

}
