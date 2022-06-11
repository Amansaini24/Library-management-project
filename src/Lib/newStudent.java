package Lib;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Point;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class newStudent {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newStudent window = new newStudent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLocation(new Point(325, 125));
		frame.setUndecorated(true);
		frame.setBackground(new Color(255, 255, 255));
		frame.setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(100, 100, 120, 13);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(100, 150, 120, 13);
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Father's Name");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(100, 200, 135, 13);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(100, 250, 120, 13);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Branch");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(100, 300, 120, 13);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBackground(Color.BLACK);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBackground(new Color(255, 245, 238));
		textField.setBounds(290, 95, 200, 25);
		textField.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setBackground(new Color(255, 245, 238));
		textField_1.setBounds(290, 145, 200, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setBackground(new Color(255, 245, 238));
		textField_2.setBounds(290, 195, 200, 25);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBackground(new Color(255, 245, 238));
		comboBox.setBounds(290, 245, 200, 25);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"...", "B.Tech", "M.Tech", "BCA", "MCA", "BBA", "B.Sc", "LLB"}));
		comboBox.setToolTipText("");
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setBackground(new Color(255, 245, 238));
		comboBox_1.setBounds(290, 295, 200, 25);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"...", "CSE", "IT", "MEDICAL", "H.M.", "MECHANICAL", "CIVIL"}));
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,name,fname,course,branch;
				id=textField.getText();
				name=textField_1.getText();
				fname=textField_2.getText();
				course=(String) comboBox.getSelectedItem();
				branch=(String) comboBox_1.getSelectedItem();
				System.out.println(id);
				System.out.println(name);
				System.out.println(fname);
				System.out.println(course);
				System.out.println(branch);
				try
				{
					Class.forName("com.ibm.db2.jcc.DB2Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:db2://localhost:50000/lms", "db2admin", "db2admin");
					PreparedStatement ps = con.prepareStatement("insert into student(studentid, name, fname, course, branch) values(?,?,?,?,?)");
					ps.setString(1, id);
					ps.setString(2, name);
					ps.setString(3, fname);
					ps.setString(4, course);
					ps.setString(5, branch);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully Registered!");
					setVisible(false);
					new newStudent().setVisible(true);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(290, 360, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(405, 360, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("New Student Data");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(100, 35, 450, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnModifyStudentData = new JButton("Update Student Data");
		btnModifyStudentData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			new updateStudent().setVisible(true);
			}
		});
		btnModifyStudentData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModifyStudentData.setBounds(650, 140, 195, 35);
		frame.getContentPane().add(btnModifyStudentData);
		
		JButton btnDeleteStudentData = new JButton("Delete Student Data");
		btnDeleteStudentData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			new deleteStudent().setVisible(true);
			}
		});
		btnDeleteStudentData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteStudentData.setBounds(650, 200, 195, 35);
		frame.getContentPane().add(btnDeleteStudentData);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\sk206\\eclipse-workspace\\LibraryManagementSystem\\src\\Lib\\4826435.jpg"));
		lblNewLabel_6.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(lblNewLabel_6);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}
}
