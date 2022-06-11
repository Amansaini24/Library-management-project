package Lib;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class showData {

	private JFrame frame;
	private static JTable my_table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showData window = new showData();
					window.frame.setVisible(true);
					try {
						update_table();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public showData() {
		initialize();
	}
	
	public static void update_table() {
		try	{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:db2://localhost:50000/lms", "db2admin", "db2admin");

			ResultSet rs=null;
			PreparedStatement ps = con.prepareStatement("select * from admin");
			rs = ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			
			my_table.setModel( new DefaultTableModel());
			DefaultTableModel model=(DefaultTableModel) my_table.getModel();
			
			int No_columns=rsmd.getColumnCount();
			String[] column_name=new String[No_columns];
			for(int i=0;i<No_columns;i++) {
				column_name[i]=rsmd.getColumnName(i+1);
			}
			
			model.setColumnIdentifiers(column_name);
			
			
			while (rs.next()) {
			String[] data=new String[No_columns];
			for(int i=0;i<No_columns;i++) {
				data[i]=rs.getString(column_name[i]);
			}
			model.addRow(data);  
		}}
		catch(Exception e) {}
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					update_table();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(38, 10, 143, 26);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 69, 374, 184);
		frame.getContentPane().add(scrollPane);
		
		my_table = new JTable();
		scrollPane.setViewportView(my_table);
		my_table.setCellSelectionEnabled(true);
		my_table.setColumnSelectionAllowed(true);
	}
}
