package Lib;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import com.ibm.db2.jcc.am.ResultSet;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class login {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	private final JButton btnNewButton_1 = new JButton("Close");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JLabel lblNewLabel = new JLabel("UserID");
		lblNewLabel.setBounds(70, 78, 94, 22);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(70, 131, 100, 22);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(226, 131, 120, 25);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setBounds(226, 186, 100, 33);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String id,pass;
				id=textField.getText();
				pass=passwordField.getText();
				System.out.println(id);
				System.out.println(pass);
				if(id.equals("admin") && pass.equals("admin")) {
					frame.setVisible(false);
					new home().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Username/Password Incorrect");
					setVisible(false);
					new login().setVisible(true);
				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lblNewLabel_2.setBounds(50, 10, 500, 35);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(226, 78, 120, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(390, 186, 100, 33);
		frame.getContentPane().add(btnNewButton_1);
		
//		JButton btnAdmin = new JButton("ADMIN");
//		btnAdmin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnAdmin.setFont(new Font("Arial", Font.BOLD, 16));
//		btnAdmin.setBounds(64, 325, 100, 33);
//		frame.getContentPane().add(btnAdmin);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\sk206\\eclipse-workspace\\LibraryManagementSystem\\src\\Lib\\admin.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1930, 1506);
		frame.getContentPane().add(lblNewLabel_3);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}
}
