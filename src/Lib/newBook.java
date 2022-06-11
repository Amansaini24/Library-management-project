package Lib;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class newBook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newBook window = new newBook();
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
	public newBook() {
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setBounds(100, 100, 120, 13);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(100, 150, 120, 13);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Publisher");
		lblNewLabel_2.setBounds(100, 200, 120, 13);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(100, 250, 120, 13);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Publisher Year");
		lblNewLabel_5.setBounds(100, 300, 120, 13);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBackground(Color.BLACK);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 245, 238));
		textField.setBounds(290, 95, 200, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 245, 238));
		textField_1.setBounds(290, 145, 200, 25);
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 245, 238));
		textField_2.setBounds(290, 195, 200, 25);
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 245, 238));
		textField_3.setBounds(290, 245, 200, 25);
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 245, 238));
		textField_4.setBounds(290, 295, 200, 25);
		textField_4.setColumns(10);
		frame.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String book_id,name,publisher,price,year;
				book_id=textField.getText();
				name=textField_1.getText();
				publisher=textField_2.getText();
				price=textField_2.getText();
				year=textField_2.getText();
				System.out.println(book_id);
				System.out.println(name);
				System.out.println(publisher);
				System.out.println(price);
				System.out.println(year);
				try
				{
					Class.forName("com.ibm.db2.jcc.DB2Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:db2://localhost:50000/lms", "db2admin", "db2admin");
					PreparedStatement ps = con.prepareStatement("insert into book(bookid, name, publisher, price, year) values(?,?,?,?,?)");
					ps.setString(1, book_id);
					ps.setString(2, name);
					ps.setString(3, publisher);
					ps.setString(4, price);
					ps.setString(5, year);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully Registered!");
					setVisible(false);
					new newBook().setVisible(true);
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
		btnNewButton_1.setBounds(405, 360, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("New Book Data");
		lblNewLabel_4.setBounds(100, 35, 450, 25);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\sk206\\eclipse-workspace\\LibraryManagementSystem\\src\\Lib\\6263.jpg"));
		lblNewLabel_6.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(lblNewLabel_6);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}
}
