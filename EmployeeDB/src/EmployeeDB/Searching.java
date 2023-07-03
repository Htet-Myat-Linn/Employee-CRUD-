package EmployeeDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.ScrollPaneConstants;

public class Searching extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Searching dialog = new Searching();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
           Connection con=null;
           Statement ste=null;
           ResultSet rs=null;
           private JTable tblEmployee;
	/**
	 * Create the dialog.
	 */
	public Searching() {
		setBounds(100, 100, 744, 300);
		getContentPane().setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(586, 227, 89, 23);
		getContentPane().add(btnClose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 703, 199);
		getContentPane().add(scrollPane);
		
		tblEmployee = new JTable();
		scrollPane.setViewportView(tblEmployee);

		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		try
		{
			clsDBConnection c=new clsDBConnection();
			con=c.getConnection();
			fillRecord(); //call fillRrecord
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	public void fillRecord()  //fill data table method
	{
		try
		{
		  DefaultTableModel dtmModel=new DefaultTableModel();	
		  dtmModel.addColumn("Employee ID");
		  dtmModel.addColumn("Employee Name");
		  dtmModel.addColumn("NRC No");
		  dtmModel.addColumn("Gender");
		  dtmModel.addColumn("Employee Address");
		  dtmModel.addColumn("Department");
		  dtmModel.addColumn("Post");
		  dtmModel.addColumn("Qualification");
		  ste=con.createStatement();
		  rs=ste.executeQuery("SELECT * FROM employee ORDER BY EmployeeID");
		  while(rs.next())
		  {
			  Object []dataRow= {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)};
			  dtmModel.addRow(dataRow);
			  
		  }
		  tblEmployee.setModel(dtmModel);
		}
		catch(SQLException e)
		{
			System.out.print(e);
		}
	}
}
