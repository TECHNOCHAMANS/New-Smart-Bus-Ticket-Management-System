package pro;

import java.awt.Button;

import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;

@SuppressWarnings("serial")
public class personal_info extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	public static String bn;
	public static String userName,Name,phoneno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personal_info frame = new personal_info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	sqliteConnect s2;


	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public personal_info() {
		setTitle("SMART BUS (USER LOGIN)");
		
		conn=s2.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		passwordField.setBounds(246, 342, 173, 33);
		contentPane.add(passwordField);
		
		Button button = new Button("LOGIN");
		button.addKeyListener(new KeyAdapter() {
		});
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\NIKITA\\Downloads\\bus.sqlite");
					 String query="select * from user_details where username=? and pwd=?";
					 PreparedStatement pst = conn.prepareStatement(query);
				     pst.setString(1, textField.getText());
					 pst.setString(2, passwordField.getText());
					 ResultSet rs =pst.executeQuery();
					 
					 int count=0;
					 while(rs.next())
					 {
						 count++;
	       				 Name = rs.getString(3);
	       				 phoneno = rs.getString(4);
					 }
					 if(count==1) {
						 dispose();
						 SUR_DESTI S = new SUR_DESTI();
						 S.setVisible(true);
					 }
					 else if(count>1)
						 JOptionPane.showMessageDialog(null, "Dublicate Username and Password");
					 else
						 JOptionPane.showMessageDialog(null, "Username and Password is incorrect try again....");
					 rs.close();
					 pst.close();
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}
				
			}
			});

		button.setBounds(257, 441, 115, 33);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(243, 286, 176, 33);
		contentPane.add(textField);
		
		Button button_1 = new Button("REGISTER");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				register r1=new register();
				r1.setVisible(true);
			}
		});
		button_1.setBounds(240, 491, 148, 28);
		contentPane.add(button_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(personal_info.class.getResource("/pro/login2.jpg")));
		label_1.setBounds(0, 0, 715, 583);
		contentPane.add(label_1);
	}

}