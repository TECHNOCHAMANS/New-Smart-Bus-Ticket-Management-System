package pro;

import java.awt.EventQueue;	

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class OTP extends JFrame {

	private JPanel contentPane;
    public static int price_per_ticket;
	private JTextField textField;
	public static String bn;
	public static String time;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OTP frame = new OTP();
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
	public OTP() {
		setTitle("SMART BUS (OTP)");
		
		conn=s2.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 318, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(78, 174, 148, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("VERIFY");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                bn = SUR_DESTI.bn;
                try {
                	//query for retrieving the time and price according to selected busno
                  	Connection conn =DriverManager.getConnection("jdbc:sqlite:c:\\Users\\NIKITA\\Downloads\\bus.sqlite");
                  	String query ="select * from Adminbus_details";
                  	java.sql.Statement statement = conn.createStatement();
                  	ResultSet rs =statement.executeQuery(query);
       				 while(rs.next())
       				 {
       					 String asif =rs.getString(1);
       					 if(asif.equals(bn)) {
       						 time = rs.getString(5);
       						price_per_ticket = rs.getInt(7);
       					 }
       				 } 
                  	
                  }catch(Exception e1) {
                  }
                

				JOptionPane.showMessageDialog(null, "PAYMENT SUCCESSFULL"); 
                dispose();
                confirm c = new confirm();
                c.setVisible(true);
                    
		}
		});
		btnNewButton.setBounds(55, 275, 97, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				payment p = new payment();
				p.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(164, 275, 97, 53);
		contentPane.add(btnNewButton_1);
		
		JButton btnResendOtp = new JButton("RESEND OTP");
		btnResendOtp.setForeground(Color.WHITE);
		btnResendOtp.setBackground(Color.BLACK);
		btnResendOtp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OTP des = new OTP();
				des.setVisible(true);
			}
		});
		
		
		String phone = personal_info.phoneno;
		JLabel lblNewLabel = new JLabel(phone);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(92, 102, 134, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("label");
		lblNewLabel_1.setIcon(new ImageIcon(OTP.class.getResource("/pro/blank.PNG")));
		lblNewLabel_1.setBounds(78, 102, 148, 19);
		contentPane.add(lblNewLabel_1);
		btnResendOtp.setBounds(88, 237, 118, 25);
		contentPane.add(btnResendOtp);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label.setIcon(new ImageIcon(OTP.class.getResource("/pro/otp.PNG")));
		label.setBounds(0, 0, 294, 354);
		contentPane.add(label);
	}
}
