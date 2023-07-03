package EmployeeDB;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class aa extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			aa dialog = new aa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public aa() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
	}
}
