package EmployeeDB;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Searching1 extends JDialog {
	private JTable tblEmployee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Searching1 dialog = new Searching1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Connection con =null;
	Statement ste=null;
	ResultSet rs=null;
	private JComboBox cboSearchData;
	/**
	 * Create the dialog.
	 */
	public Searching1() {
		setBounds(100, 100, 681, 341);
		getContentPane().setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 50, 645, 206);
			getContentPane().add(scrollPane);
			{
				tblEmployee = new JTable();
				scrollPane.setViewportView(tblEmployee);
			}
		}
		{
			JButton btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnClose.setBounds(566, 268, 89, 23);
			getContentPane().add(btnClose);
		}
		
		JLabel lblNewLabel = new JLabel("Search By:");
		lblNewLabel.setBounds(10, 11, 69, 23);
		getContentPane().add(lblNewLabel);
		
		JComboBox cboSearchType = new JComboBox();
		cboSearchType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboSearchType.getSelectedIndex()>0)
				{
				fill_Search_Data("SELECT DISTINCT "+cboSearchType.getSelectedItem().toString()+" FROM employee");
				}
				else
				{
					cboSearchData.addItem(".....Select.....");
				}
			}
		});
		cboSearchType.setModel(new DefaultComboBoxModel(new String[] {".....Select.....", "EmployeeName", "Department", "Post", "Qualification"}));
		cboSearchType.setBounds(72, 11, 114, 22);
		getContentPane().add(cboSearchType);
		
		JLabel lblNewLabel_1 = new JLabel("Select Data:");
		lblNewLabel_1.setBounds(195, 11, 69, 23);
		getContentPane().add(lblNewLabel_1);
		
		cboSearchData = new JComboBox();
		cboSearchData.setModel(new DefaultComboBoxModel(new String[] {".....Select....."}));
		cboSearchData.setBounds(274, 11, 114, 22);
		getContentPane().add(cboSearchData);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboSearchType.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null, "Please choose Search Type");
					cboSearchType.requestFocus();
					return;
				}
				if(cboSearchData.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null, "Please choose Search Data");
					cboSearchData.requestFocus();
					return;
				}
				fillRecord("SELECT * FROM employee WHERE "+cboSearchType.getSelectedItem().toString()+"='"+cboSearchData.getSelectedItem().toString()+"' ");
			}
		});
		btnSearch.setBounds(423, 11, 89, 23);
		getContentPane().add(btnSearch);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillRecord("SELECT * FROM employee ORDER BY EmployeeID");
				cboSearchType.setSelectedIndex(0);
				cboSearchData.addItem(".....Select.....");
			}
		});
		btnShowAll.setBounds(538, 11, 89, 23);
		getContentPane().add(btnShowAll);
		
		try
		{
			clsDBConnection c=new clsDBConnection();
			con=c.getConnection();
			fillRecord("SELECT * FROM employee ORDER BY EmployeeID");
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	public void fillRecord(String sql) //with parameter
	{
		try
		{
			javax.swing.table.DefaultTableModel dtmModel=new DefaultTableModel();
			dtmModel.addColumn("Employee ID");
			  dtmModel.addColumn("Employee Name");
			  dtmModel.addColumn("NRC No");
			  dtmModel.addColumn("Gender");
			  dtmModel.addColumn("Employee Address");
			  dtmModel.addColumn("Department");
			  dtmModel.addColumn("Post");
			  dtmModel.addColumn("Qualification");
			  ste=con.createStatement();
			  rs=ste.executeQuery(sql);
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
	private void fill_Search_Data(String sql)
	{
		if(!sql.equals(""))
		{
			try
			{
				ste=con.createStatement();
				rs=ste.executeQuery(sql);
				cboSearchData.removeAllItems();
				cboSearchData.addItem(".....Select.....");
				while(rs.next())
				{
					cboSearchData.addItem(rs.getString(1));
				}
				
			}
			catch(SQLException e)
			{
				System.out.print(e.toString());
			}
		}
	}
}
