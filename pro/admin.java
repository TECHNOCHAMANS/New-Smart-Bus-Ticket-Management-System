package pro;

import java.awt.Button;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	Connection conn =null;
	public admin() {
		setTitle("SMART BUS (ADMIN LOGIN)");
			initialize();
			conn=sqliteConnect.dbConnector();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textField.setBounds(238, 277, 173, 41);
		contentPane.add(textField);			
		textField.setColumns(10);
		
		Button btnLogin = new Button("LOGIN");
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\NIKITA\\Downloads\\bus.sqlite");
					String query="SELECT * FROM admin_details where username=? and pwd=? ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, textField.getText().toString());
					pst.setString(2, passwordField.getText().toString());
					ResultSet rs = pst.executeQuery();

					
					int count=0;
					while(rs.next()) {
						count++;
					}
					if(count==1)
					{
						dispose();
						admin_lg des = new admin_lg();
						des.setVisible(true);
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else
						JOptionPane.showMessageDialog(null, "Wrong Username and Password");
					rs.close();
					pst.close();
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);	
				}
			}
		});

		btnLogin.setBounds(268, 434, 97, 41);
		contentPane.add(btnLogin);
		
		JLabel lblAdmin = new JLabel("ADMIN ");
		lblAdmin.setFont(new Font("Dialog", Font.BOLD, 35));
		lblAdmin.setBounds(257, 42, 154, 73);
		contentPane.add(lblAdmin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(238, 339, 173, 36);
		contentPane.add(passwordField);
		
		Button button = new Button("NOT ADMIN");
		button.setFont(new Font("Dialog", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				front_page fp = new front_page();
				fp.setVisible(true);
			}
		});
		button.setBounds(268, 498, 97, 41);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(admin.class.getResource("/pro/login2.jpg")));
		label_2.setBounds(0, 0, 616, 577);
		contentPane.add(label_2);
	}
}
