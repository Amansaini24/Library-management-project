package Lib;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class deleteStudent {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteStudent window = new deleteStudent();
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
	public deleteStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLocation(new Point(325, 125));
		frame.setUndecorated(true);
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
		
		JLabel lblNewLabel_1 = new JLabel("Delete Student Record:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(100, 35, 450, 25);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n;
				n=textField.getText();
				System.out.println(n);
				try
				{
					Class.forName("com.ibm.db2.jcc.DB2Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:db2://localhost:50000/lms", "db2admin", "db2admin");
					PreparedStatement ps = con.prepareStatement("delete from student where id=(?)");
					ps.setString(1, n);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Deleted Successfully!");
//					setVisible(false);
//					new newStudent().setVisible(true);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Record Not Found!");
					setVisible(false);
					new deleteStudent().setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(265, 188, 100, 21);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBackground(new Color(255, 245, 238));
		textField.setBounds(290, 95, 200, 25);
		textField.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			new newStudent().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(415, 188, 100, 21);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\sk206\\eclipse-workspace\\LibraryManagementSystem\\src\\Lib\\7952.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(lblNewLabel_2);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}
}
