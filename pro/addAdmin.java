package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class addAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addAdmin frame = new addAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn =null;
	private JPasswordField passwordField;
	/**
	 * Create the frame.
	 */
	public addAdmin() {
		setTitle("SMART BUS (ADD ADMIN)");
		conn=sqliteConnect.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(".");
		label.setIcon(new ImageIcon(addAdmin.class.getResource("/pro/PHOTO-2019-08-11-22-39-55.jpg")));
		label.setBounds(51, 20, 240, 129);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("SMART BUSES");
		label_1.setFont(new Font("Palatino Linotype", Font.BOLD, 26));
		label_1.setBounds(302, 49, 204, 63);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(206, 185, 240, 25);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(206, 241, 240, 25);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("PASSWORD : ");
		label_2.setFont(new Font("Dialog", Font.BOLD, 18));
		label_2.setBounds(51, 305, 126, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("USERNAME : ");
		label_3.setFont(new Font("Dialog", Font.BOLD, 18));
		label_3.setBounds(51, 241, 126, 30);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("NAME : ");
		label_4.setFont(new Font("Dialog", Font.BOLD, 18));
		label_4.setBounds(51, 180, 126, 30);
		contentPane.add(label_4);
		
		Button btnAddMore = new Button("ADD 1 MORE");
		btnAddMore.setForeground(Color.WHITE);
		btnAddMore.setBackground(Color.BLACK);
		btnAddMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				addAdmin a = new addAdmin();
				a.setVisible(true);
			}
		});
		btnAddMore.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAddMore.setBounds(30, 385, 128, 34);
		contentPane.add(btnAddMore);
		
		Button button_1 = new Button("ADD");
		button_1.setBackground(Color.BLACK);
		button_1.setForeground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//query to add in db
				try {
					Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\NIKITA\\Downloads\\bus.sqlite");
					 String query="insert into admin_details(name,username,pwd) values(?,?,?)";
					 java.sql.PreparedStatement pstmt = null;
					 pstmt=conn.prepareStatement(query);
					 pstmt.setString(1,textField.getText());
					 pstmt.setString(2,textField_1.getText());
					 pstmt.setString(3,passwordField.getText());
					
					 
					 @SuppressWarnings("unused")
					int i=pstmt.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Registration Done Successfully");
					 pstmt.close();
				}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		passwordField.setBounds(206, 302, 240, 25);
		contentPane.add(passwordField);
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.setBounds(203, 385, 85, 34);
		contentPane.add(button_1);
		
		Button button_2 = new Button("CANCEL");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(0, 0, 0));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_lg ad = new admin_lg();
				ad.setVisible(true);
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 14));
		button_2.setBounds(329, 385, 85, 34);
		contentPane.add(button_2);
		
		Button button_3 = new Button("DONE");
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(Color.BLACK);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_lg ad = new admin_lg();
				ad.setVisible(true);
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 14));
		button_3.setBounds(462, 385, 85, 34);
		contentPane.add(button_3);
		
		JLabel label_5 = new JLabel(".");
		label_5.setIcon(new ImageIcon(addAdmin.class.getResource("/pro/busback8.PNG")));
		label_5.setBounds(0, 0, 590, 460);
		contentPane.add(label_5);
	}
}
