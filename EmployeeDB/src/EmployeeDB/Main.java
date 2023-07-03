package EmployeeDB;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle(":.Employee Information.:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);

		JMenu mnuFile = new JMenu("File");
		mnuFile.setMnemonic('F');
		menuBar.add(mnuFile);

		JMenuItem mnuEntry = new JMenuItem("Employee Entry");
		mnuEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entry up = new Entry();
				up.show(true);

			}
		});
		mnuFile.add(mnuEntry);

		JMenuItem mnuUpdate = new JMenuItem("Employee Update");
		mnuUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update u = new Update();
				u.show();
			}
		});
		mnuFile.add(mnuUpdate);

		JMenuItem mnuSearching = new JMenuItem("Employee Searching");
		mnuSearching.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Searching1 s=new Searching1();
				s.show();
			}
		});
		mnuFile.add(mnuSearching);

		JMenuItem mnuEmployeeList = new JMenuItem("Employee List");
		mnuEmployeeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Searching s=new Searching();
				s.show();
			}
		});
		mnuFile.add(mnuEmployeeList);

		JMenuItem mnuClose = new JMenuItem("Close");
		mnuClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JSeparator separator = new JSeparator();
		mnuFile.add(separator);
		mnuFile.add(mnuClose);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
