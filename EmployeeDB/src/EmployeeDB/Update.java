package EmployeeDB;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import java.sql.*;

public class Update extends JFrame {

	private JPanel contentPane;
	Connection con = null;
	Statement ste = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("EmployeeID:");
		lblNewLabel.setBounds(28, 11, 76, 20);
		contentPane.add(lblNewLabel);

		JLabel lbl = new JLabel("Employee Name:");
		lbl.setBounds(10, 42, 94, 20);
		contentPane.add(lbl);

		JLabel lblNrcNo = new JLabel("NRC NO:");
		lblNrcNo.setBounds(44, 84, 66, 20);
		contentPane.add(lblNrcNo);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(44, 156, 76, 20);
		contentPane.add(lblAddress);

		JLabel lblPost = new JLabel("Post:");
		lblPost.setBounds(60, 252, 42, 20);
		contentPane.add(lblPost);

		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(20, 201, 76, 20);
		contentPane.add(lblDepartment);

		JLabel lblQualification = new JLabel("Qualification:");
		lblQualification.setBounds(10, 296, 76, 20);
		contentPane.add(lblQualification);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboEmployeeID.getSelectedIndex() > 0)
					checkData();
				else
					javax.swing.JOptionPane.showMessageDialog(contentPane, this, "Please choose EmployeeID for Update!",
							getState());
			}
		});
		btnUpdate.setBounds(10, 341, 76, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboEmployeeID.getSelectedIndex() > 0) {
					if(JOptionPane.showConfirmDialog(null,"Do you want really want to delete?","Delete Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					delete();
				} else {
					cboEmployeeID.requestFocus(true);
				}
			}
		});
		btnDelete.setBounds(96, 341, 76, 23);
		contentPane.add(btnDelete);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearData();
			}
		});
		btnCancel.setBounds(195, 341, 83, 23);
		contentPane.add(btnCancel);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		btnClose.setBounds(288, 341, 76, 23);
		contentPane.add(btnClose);

		cboEmployeeID = new JComboBox();
		cboEmployeeID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboEmployeeID.getSelectedIndex() > 0) {
					fill();
				}
			}
		});
		cboEmployeeID.setModel(new DefaultComboBoxModel(new String[] { ".....Select....." }));
		cboEmployeeID.setBounds(114, 10, 154, 22);
		contentPane.add(cboEmployeeID);

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
		cboDepartment.setBounds(100, 200, 154, 22);
		contentPane.add(cboDepartment);

		cboPost = new JComboBox();
		cboPost.setModel(new DefaultComboBoxModel(new String[] { ".....Select....." }));
		cboPost.setBounds(96, 251, 158, 22);
		contentPane.add(cboPost);

		Border blackline = BorderFactory.createLineBorder(Color.black);
		lblEmployeeName = new JLabel("");
		lblEmployeeName.setBounds(110, 42, 158, 20);
		lblEmployeeName.setBorder(blackline);
		contentPane.add(lblEmployeeName);

		lblNRC = new JLabel("");
		lblNRC.setBounds(110, 81, 158, 23);
		lblNRC.setBorder(blackline);
		contentPane.add(lblNRC);

		JLabel lnn = new JLabel("Gender:");
		lnn.setBounds(54, 115, 76, 20);
		contentPane.add(lnn);

		lblGender = new JLabel("");
		lblGender.setBounds(110, 115, 158, 23);
		lblGender.setBorder(blackline);
		contentPane.add(lblGender);

		txtAddress = new JTextField();
		txtAddress.setBounds(110, 156, 158, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		txtQua = new JTextField();
		txtQua.setColumns(10);
		txtQua.setBounds(96, 296, 158, 20);
		contentPane.add(txtQua);

		try {
			clsDBConnection con1 = new clsDBConnection();
			con = con1.getConnection();
			getEmployeeID();

		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public void getEmployeeID() {
		try {
			ste = con.createStatement();
			cboEmployeeID.removeAllItems();
			cboEmployeeID.addItem(".....Select.....");
			rs = ste.executeQuery("SELECT EmployeeID FROM employee ORDER BY EmployeeID");
			while (rs.next()) {
				cboEmployeeID.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.print(e);
		}
	}

	public void fill() {
		try {
			ste = con.createStatement();
			rs = ste.executeQuery(
					"SELECT * FROM employee WHERE EmployeeID=" + cboEmployeeID.getSelectedItem().toString().trim());
			if (rs.next()) {
				lblEmployeeName.setText(rs.getString(2));
				lblNRC.setText(rs.getString(3));
				lblGender.setText(rs.getString(4));
				txtAddress.setText(rs.getString(5));
				cboDepartment.setSelectedItem(rs.getObject(6));
				cboPost.setSelectedItem(rs.getObject(7));
				txtQua.setText(rs.getString(8));
				txtAddress.requestFocus();
			}
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public void update() {
		String ad = txtAddress.getText().trim();
		String dep = cboDepartment.getSelectedItem().toString().trim();
		String pos = cboPost.getSelectedItem().toString().trim();
		String qua = txtQua.getText().trim().toString();
		try {
			if (cboEmployeeID.getSelectedIndex() > 0) {
				ste = con.createStatement();
				String sql = "UPDATE employee SET Address='" + ad + "',Department='" + dep + "',Post='" + pos
						+ "',Qualification= '" + qua + "' WHERE EmployeeID="
						+ cboEmployeeID.getSelectedItem().toString().trim() + "";
				int result = ste.executeUpdate(sql);
				if (result == 1) {
					JOptionPane.showMessageDialog(this, "This Record is successfully update!");
					clearData();
				}
			}
		} catch (SQLException e) {
			System.out.print(e);
			JOptionPane.showMessageDialog(this, "This Record can't  update!");
		} catch (Exception e1) {
			System.out.print(e1);
		}
	}

	public void clearData() {
		cboEmployeeID.setSelectedIndex(0);
		lblEmployeeName.setText("");
		lblNRC.setText("");
		lblGender.setText("");
		txtAddress.setText("");
		txtQua.setText("");
		cboDepartment.setSelectedIndex(0);
		cboPost.setSelectedIndex(0);
	}

	public void delete() {
		try {
			if (cboEmployeeID.getSelectedIndex() > 0) {
				ste = con.createStatement();
				String sql = "DELETE  FROM employee WHERE EmployeeID="
						+ cboEmployeeID.getSelectedItem().toString().trim() + "";
				int r = ste.executeUpdate(sql);
				if (r == 1) {
					JOptionPane.showMessageDialog(this, "This record is successfully deleted!");
					clearData();
					getEmployeeID();
				}
			}
		} catch (SQLException sqle) {
			System.out.print(sqle);
			JOptionPane.showMessageDialog(this, "This record can not be deleted!");
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public void checkData() {
		if (cboEmployeeID.getSelectedIndex() <= 0) {
			JOptionPane.showMessageDialog(this, "you must choose Employee ID!");
			cboEmployeeID.requestFocus(true);
		} else if (txtAddress.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "you must enter Address!");
			txtAddress.requestFocus(true);
		} else if (cboDepartment.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "you must choose Department!");
			cboDepartment.requestFocus(true);
		} else if (cboPost.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "you must choose Post!");
			cboPost.requestFocus(true);
		} else if (txtQua.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "you must enter Qualification!");
			txtQua.requestFocus(true);
		} else {
			update();
		}
	}

	Entry up = new Entry();
	private JTextField txtAddress;
	private JTextField txtQua;
	private JComboBox cboEmployeeID;
	private JComboBox cboDepartment;
	private JComboBox cboPost;
	private JLabel lblEmployeeName;
	private JLabel lblNRC;
	private JLabel lblGender;
}
