package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JRadioButton;

import java.awt.Button;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	sqliteConnect s2;
	private JTextField textField_5;
	private JTextField textField_8;


	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public register() {
		setTitle("SMART BUS (REGISTER)");
		conn=s2.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1314, 755);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 16));
		lblName.setBounds(12, 196, 66, 37);
		contentPane.add(lblName);
		
		JLabel lblContactInfo = new JLabel("CONTACT INFO:");
		lblContactInfo.setForeground(new Color(0, 0, 0));
		lblContactInfo.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		lblContactInfo.setBounds(12, 347, 187, 51);
		contentPane.add(lblContactInfo);
		
		JLabel lblAddress = new JLabel("ADDRESS:");
		lblAddress.setForeground(new Color(0, 0, 0));
		lblAddress.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		lblAddress.setBounds(12, 263, 142, 46);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setBackground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		lblEmail.setBounds(672, 467, 197, 69);
		contentPane.add(lblEmail);
		
		JLabel lblGender = new JLabel("GENDER:");
		lblGender.setForeground(new Color(0, 0, 0));
		lblGender.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		lblGender.setBounds(12, 478, 93, 46);
		contentPane.add(lblGender);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setBackground(new Color(0, 0, 0));
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		lblUsername.setBounds(672, 263, 131, 46);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		lblPassword.setBounds(672, 364, 131, 16);
		contentPane.add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("RE-TYPE PASSWORD:");
		lblRetypePassword.setForeground(new Color(0, 0, 0));
		lblRetypePassword.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		lblRetypePassword.setBounds(672, 393, 207, 69);
		contentPane.add(lblRetypePassword);
		
		JLabel lblAge = new JLabel("AGE:");
		lblAge.setForeground(new Color(0, 0, 0));
		lblAge.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		lblAge.setBounds(12, 596, 71, 46);
		contentPane.add(lblAge);
		
		Button btnRegister = new Button("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					//query to add information into databases
					Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\NIKITA\\Downloads\\bus.sqlite");
					 String query="insert into user_details(name,username,pwd,phoneno,age,mail_id) values(?,?,?,?,?,?)";
					 java.sql.PreparedStatement pstmt = null;
					 pstmt=conn.prepareStatement(query);
					 pstmt.setString(1,textField.getText());
					 pstmt.setString(2,textField_7.getText());
					 pstmt.setString(3,passwordField.getText());
					 pstmt.setString(4,textField_4.getText());
					 pstmt.setString(5,textField_3.getText());
					 pstmt.setString(6,textField_2.getText());
					 
					@SuppressWarnings("unused")
					int i=pstmt.executeUpdate();
					 pstmt.close();
				}
			catch(Exception e1)
			{
				//JOptionPane.showMessageDialog(null, e1);
			}
				 JOptionPane.showMessageDialog(null, "Registration Done Successfully");
				 dispose();
				 personal_info p = new personal_info();
					 p.setVisible(true);
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		btnRegister.setBounds(437, 614, 250, 73);
		contentPane.add(btnRegister);
		
		JLabel lblAlreadyHaveAn = new JLabel("ALREADY HAVE AN ACCOUNT :");
		lblAlreadyHaveAn.setForeground(new Color(0, 0, 0));
		lblAlreadyHaveAn.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		lblAlreadyHaveAn.setBounds(818, 625, 318, 57);
		contentPane.add(lblAlreadyHaveAn);
		
		Button btnLogIn = new Button("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				personal_info per = new personal_info();
				per.setVisible(true);
			}
		});
		btnLogIn.setBackground(Color.BLACK);
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		btnLogIn.setBounds(1137, 625, 131, 73);
		contentPane.add(btnLogIn);
		
		JRadioButton r1 = new JRadioButton("MALE");
		r1.setBounds(173, 454, 127, 25);
		contentPane.add(r1);
		
		JRadioButton r2 = new JRadioButton("FEMALE");
		r2.setBounds(173, 491, 127, 25);
		contentPane.add(r2);
		
		JRadioButton r3 = new JRadioButton("OTHER");
		r3.setBounds(173, 535, 127, 25);
		contentPane.add(r3);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textField.setBounds(173, 208, 381, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textField_2.setBounds(894, 491, 374, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		passwordField.setBounds(894, 359, 242, 32);
		contentPane.add(passwordField);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textField_3.setBounds(173, 604, 71, 37);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textField_4.setBounds(174, 358, 218, 32);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
			
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(register.class.getResource("/pro/PHOTO-2019-08-11-22-39-55.jpg")));
		label_2.setBounds( 221, 0, 280, 180);
		contentPane.add(label_2);
		
		JLabel lblBirthDate = new JLabel("BIRTH DATE:");
		lblBirthDate.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		lblBirthDate.setBounds(672, 208, 126, 25);
		contentPane.add(lblBirthDate);
		
		JLabel lblSmartBus = new JLabel("SMART BUS");
		lblSmartBus.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
		lblSmartBus.setBounds(525, 31, 388, 90);
		contentPane.add(lblSmartBus);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textField_6.setBounds(894, 201, 242, 32);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textField_8.setColumns(10);
		textField_8.setBounds(173, 305, 381, 32);
		contentPane.add(textField_8);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(173, 263, 381, 32);
		contentPane.add(textField_5);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		textField_7.setColumns(10);
		textField_7.setBounds(894, 273, 242, 32);
		contentPane.add(textField_7);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		passwordField_1.setBounds(894, 421, 242, 32);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("dd-mm-yyyy");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(914, 240, 120, 16);
		contentPane.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(register.class.getResource("/pro/Untitled (2).jpg")));
		label_3.setBounds(0, 0, 1300, 718);
		contentPane.add(label_3);
	}
}
