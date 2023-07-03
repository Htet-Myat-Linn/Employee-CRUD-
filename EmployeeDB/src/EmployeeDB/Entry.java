package EmployeeDB;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Entry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtNRC;
	private JTextField txtQualification;
	private JTextField txtAddress;
	Connection con = null;
	Statement ste = null;
	ResultSet rs = null;
	String gender = null;
	// private AbstractButton lblEmplooyeeID;
	private JLabel lblEmployeeID;
	private JComboBox cboPost;
	private JComboBox cboDepartment;
	private JRadioButton rdoMale;
	private JRadioButton rdoFemale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Entry dialog = new Entry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Entry() {    //open of constructor
		setBounds(100, 100, 285, 384);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("EmployeeID:");
		lblNewLabel.setBounds(39, 11, 69, 22);
		contentPanel.add(lblNewLabel);

		txtName = new JTextField();
		txtName.setBounds(118, 44, 123, 20);
		contentPanel.add(txtName);
		txtName.setColumns(10);

		Border blackline = BorderFactory.createLineBorder(Color.black);// border
		lblEmployeeID = new JLabel(" ");
		lblEmployeeID.setBounds(118, 11, 123, 22);
		lblEmployeeID.setBorder(blackline);// border
		contentPanel.add(lblEmployeeID);

		JLabel lblNewLabel_1 = new JLabel("Employee Name:");
		lblNewLabel_1.setBounds(23, 47, 99, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("NRC No:");
		lblNewLabel_2.setBounds(62, 82, 46, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setBounds(62, 118, 46, 14);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Address:");
		lblNewLabel_4.setBounds(62, 158, 58, 14);
		contentPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Department:");
		lblNewLabel_5.setBounds(39, 196, 72, 14);
		contentPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Post:");
		lblNewLabel_6.setBounds(76, 237, 46, 14);
		contentPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Qualification:");
		lblNewLabel_7.setBounds(39, 274, 78, 14);
		contentPanel.add(lblNewLabel_7);

		cboPost = new JComboBox();
		cboPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		cboPost.setModel(new DefaultComboBoxModel(new String[] { ".....Select....." }));
		cboPost.setBounds(118, 233, 123, 22);
		contentPanel.add(cboPost);

		cboDepartment = new JComboBox();
		cboDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboDepartment.getSelectedIndex() == 1 || cboDepartment.getSelectedIndex() == 2
						|| cboDepartment.getSelectedIndex() == 3) {
					cboPost.removeAllItems();
					cboPost.addItem(".....Select.....");
					cboPost.addItem("Instructor");
					cboPost.addItem("Demonstructor");
					cboPost.addItem("Senior Instructor");
					cboPost.addItem("Incharge");
					cboPost.addItem("Lecturer");
					cboPost.addItem("Senior Lecturer");
					cboPost.addItem("Asst: Training Manager");
					cboPost.addItem("Training Manager");
					return;
				}

				if (cboDepartment.getSelectedIndex() == 4) {
					cboPost.removeAllItems();
					cboPost.addItem(".....Select.....");
					cboPost.addItem("Instructor");
					cboPost.addItem("Senior Instructor");
					cboPost.addItem("Incharge");
					cboPost.addItem("Lecturer");
					cboPost.addItem("Senior Lecturer");
					cboPost.addItem("Asst: Training Manager");
					cboPost.addItem("Training Manager");
					return;
				}

				if (cboDepartment.getSelectedIndex() == 0) {
					cboPost.removeAllItems();
					cboPost.addItem(".....Select.....");
				}
			}
		});
		cboDepartment
				.setModel(new DefaultComboBoxModel(new String[] { ".....Select.....", "NCC", "SE", "NE", "Training" }));
		cboDepartment.setBounds(118, 196, 123, 22);
		contentPanel.add(cboDepartment);

		txtNRC = new JTextField();
		txtNRC.setColumns(10);
		txtNRC.setBounds(118, 79, 123, 20);
		contentPanel.add(txtNRC);

		txtQualification = new JTextField();
		txtQualification.setColumns(10);
		txtQualification.setBounds(118, 271, 123, 20);
		contentPanel.add(txtQualification);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(118, 155, 123, 20);
		contentPanel.add(txtAddress);

		rdoMale = new JRadioButton("Male");
		rdoMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdoMale.isSelected()) {
					rdoFemale.setSelected(false);
				}
				gender = "Male";
			}
		});
		rdoMale.setBounds(115, 114, 52, 23);
		contentPanel.add(rdoMale);

		rdoFemale = new JRadioButton("Female");
		rdoFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdoFemale.isSelected()) {
					rdoMale.setSelected(false);
				}
				gender = "Female";
			}
		});
		rdoFemale.setBounds(189, 114, 72, 23);
		contentPanel.add(rdoFemale);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkData();
			}

		});
		btnSave.setBounds(10, 313, 69, 23);
		contentPanel.add(btnSave);

		JButton btnCancle = new JButton("Cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearData();
			}
		});
		btnCancle.setBounds(89, 313, 78, 23);
		contentPanel.add(btnCancle);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(181, 313, 78, 23);
		contentPanel.add(btnExit);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(210, 313, 78, 23);
		//contentPanel.e.add(panel);

		JLabel lblNewLabel_8 = new JLabel("aaaaa");
		//panel.add(lblNewLabel_8);

		try {
			clsDBConnection c = new clsDBConnection();
			con = c.getConnection();
		} catch (Exception e) {
			System.out.print(e);
		}
		AutoID();
	}   //end of Constructor

	public void AutoID() {
		try {
			ste = con.createStatement();
			int id = 0;
			rs = ste.executeQuery("SELECT * FROM employee ORDER BY EmployeeID Desc");

			if (rs.next()) {
				id = rs.getInt(1);
			}
			if (id == 0) {
				lblEmployeeID.setText("1");
			} else {
				lblEmployeeID.setText("" + (id + 1));
			}
		} catch (SQLException e) {
			System.out.print(e);
		}
	}

	public void clearData() {
		txtName.setText("");
		txtNRC.setText("");
		txtAddress.setText("");
		txtQualification.setText("");
		cboDepartment.setSelectedIndex(0);
		cboPost.setSelectedIndex(0);
		rdoFemale.setSelected(false);
		rdoMale.setSelected(false);
	}

	public void checkData() {
		if (txtName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "You must enter Employee Name");
			txtName.requestFocus();
		} else if (txtNRC.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "You must enter NRC Number!");
			txtNRC.requestFocus();
		} else if (gender == null || gender.equals("")) {
			JOptionPane.showMessageDialog(this, "you must choose gender!");
		} else if (txtAddress.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "you must enter Address!");
			txtAddress.requestFocus(true);
		} else if (cboDepartment.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "you must choose Department!");
			cboDepartment.requestFocus(true);
		} else if (cboPost.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "you must choose Post!");
			cboPost.requestFocus(true);
		} else if (txtQualification.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "you must enter Qualification!");
			txtQualification.requestFocus(true);
		} else if (lblEmployeeID.getText().trim().equals("")) {
			AutoID();
		} else {
			saveRecord();
		}
	}

	public void saveRecord() {
		String name = txtName.getText().trim().toString();
		String nrc = txtNRC.getText().trim().toString();
		String address = txtAddress.getText().trim().toString();
		String department = cboDepartment.getSelectedItem().toString();
		String post = cboPost.getSelectedItem().toString();
		String qua = txtQualification.getText().trim().toString();
		try {
			ste = con.createStatement();
			String sql = "SELECT * FROM employee WHERE EmployeeName='" + name + "' and NRC='" + nrc + "'";
			rs = ste.executeQuery(sql);
			if (rs.next()) {
				JOptionPane.showMessageDialog(this, "This Record is Already Exist!");
				txtName.requestFocus(true);
				txtName.selectAll();
				return;
			}

			sql = "INSERT INTO employee VALUES (" + lblEmployeeID.getText().trim() + ",'" + name + "','" + nrc + "','"
					+ gender + "','" + address + "','" + department + "','" + post + "','" + qua + "')";
			int result = ste.executeUpdate(sql);
			if (result == 1) {
				AutoID();
				clearData();
				JOptionPane.showMessageDialog(this, "This employee record is successfully saved!");

			}
		} catch (SQLException sqle) {
			System.out.print(sqle);
			JOptionPane.showMessageDialog(this, "Save process fail");
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
