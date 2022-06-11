package Lib;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;

public class home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
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
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JButton btnNewButton_1 = new JButton("Student Data");
		btnNewButton_1.setBackground(UIManager.getColor("CheckBox.light"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new newStudent().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(30, 100, 155, 30);
		
		JButton btnNewButton = new JButton("New Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new newBook().setVisible(true);
			}
		});
		btnNewButton.setBackground(UIManager.getColor("CheckBox.light"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(30, 160, 155, 30);
		
		JButton btnNewButton_2 = new JButton("Return Book");
		btnNewButton_2.setBackground(UIManager.getColor("CheckBox.light"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(30, 280, 155, 30);
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.setBackground(UIManager.getColor("CheckBox.light"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				frame.setVisible(false);
				new login().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(30, 340, 155, 30);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton_1);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("Issue Book");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new issueBook().setVisible(true);
			}
		});
		btnNewButton_4.setBackground(UIManager.getColor("CheckBox.light"));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBounds(30, 220, 155, 30);
		frame.getContentPane().add(btnNewButton_4);
		frame.getContentPane().add(btnNewButton_2);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(158, 20, 238, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("EXIT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(30, 400, 155, 30);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\sk206\\eclipse-workspace\\LibraryManagementSystem\\src\\Lib\\stackedBook.jpg"));
		lblNewLabel_1.setBounds(0, 0, 2000, 1125);
		frame.getContentPane().add(lblNewLabel_1);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}
}
