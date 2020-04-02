package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import java.awt.Button;
import java.awt.Color;

@SuppressWarnings("serial")
public class admin_bus extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_bus frame = new admin_bus();
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
	private JTextField textField_7;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public admin_bus() {
		setTitle("SMART BUS (ADMIN BUS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("SMART BUSES ");
		label_1.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 26));
		label_1.setBounds(373, 40, 201, 45);
		contentPane.add(label_1);
		
		Button button_1 = new Button("ADD");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.BLACK);
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				//query to add information into databases
				try {
					Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\NIKITA\\Downloads\\bus.sqlite");
					 String query="insert into adminbus_details(busno,src,dst,time_of_departure,time_of_reaching,price_per_ticket,date_of_journey) values(?,?,?,?,?,?,?)";
					 java.sql.PreparedStatement pstmt = null;
					 pstmt=conn.prepareStatement(query);
					 pstmt.setString(1,textField_7.getText());
					 pstmt.setString(2,textField.getText().toLowerCase());
					 pstmt.setString(3,textField_1.getText().toLowerCase());
					 pstmt.setString(4,textField_2.getText());
					 pstmt.setString(5,textField_3.getText());
					 pstmt.setString(6,textField_4.getText());
					 pstmt.setString(7,textField_6.getText());
					 
					 String busno = textField_7.getText();
					 
						String date = textField_6.getText();
						if(date.equals("Everyday"))
						{
							JOptionPane.showMessageDialog(null, "Bus No "+busno+ " Added Successfully");
						}
						else
						{
						String day = date.substring(0, 2);
						int Day =Integer.parseInt(day);
						String month = date.substring(3,5);
						int Month =Integer.parseInt(month);
						String year = date.substring(6, 10);
						int Year =Integer.parseInt(year);
						
						if(Day > 31 || Month > 12 || Year < 2020) {
							JOptionPane.showMessageDialog(null, "Invalid");
						}
						else {
							 JOptionPane.showMessageDialog(null, "Bus No "+busno+ " Added Successfully");
						}
						}
					 int i=pstmt.executeUpdate();
					 pstmt.close();
					// int j=pstmt1.executeUpdate();
					// pstmt1.close();
				}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.setBounds(88, 469, 85, 21);
		contentPane.add(button_1);
		
		Button button_2 = new Button("CANCEL");
		button_2.setBackground(Color.BLACK);
		button_2.setForeground(Color.WHITE);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_lg add = new admin_lg();
				add.setVisible(true);
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 14));
		button_2.setBounds(365, 469, 85, 21);
		contentPane.add(button_2);
		
		Button button_3 = new Button("DONE");
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(Color.BLACK);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_lg add = new admin_lg();
				add.setVisible(true);
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 14));
		button_3.setBounds(489, 469, 85, 21);
		contentPane.add(button_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(admin_bus.class.getResource("/pro/PHOTO-2019-08-11-22-39-55.jpg")));
		lblNewLabel.setBounds(128, 0, 224, 120);
		contentPane.add(lblNewLabel);
		
		Button btnAddMore = new Button("ADD 1 MORE");
		btnAddMore.setForeground(Color.WHITE);
		btnAddMore.setBackground(Color.BLACK);
		btnAddMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_bus a = new admin_bus();
				a.setVisible(true);
			}
		});
		btnAddMore.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAddMore.setBounds(207, 469, 120, 21);
		contentPane.add(btnAddMore);
		
		JLabel label = new JLabel("SOURCE :");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(33, 181, 318, 26);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("DESTINATION:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 18));
		label_2.setBounds(33, 220, 318, 26);
		contentPane.add(label_2);
		
		JLabel lblTimeOfDeparture = new JLabel("TIME OF DEPARTURE :");
		lblTimeOfDeparture.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTimeOfDeparture.setBounds(33, 256, 306, 36);
		contentPane.add(lblTimeOfDeparture);
		
		JLabel lblTimeOfReaching = new JLabel("TIME OF REACHING :");
		lblTimeOfReaching.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTimeOfReaching.setBounds(33, 302, 265, 26);
		contentPane.add(lblTimeOfReaching);
		
		JLabel lblPricePerTicket = new JLabel("PRICE PER TICKET :");
		lblPricePerTicket.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPricePerTicket.setBounds(33, 341, 221, 26);
		contentPane.add(lblPricePerTicket);
		
		JLabel lblDiscount = new JLabel("SEATS :");
		lblDiscount.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDiscount.setBounds(33, 380, 133, 26);
		contentPane.add(lblDiscount);
		
		JLabel lblDateOfJourney = new JLabel("DATE OF JOURNEY :");
		lblDateOfJourney.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDateOfJourney.setBounds(33, 419, 221, 26);
		contentPane.add(lblDateOfJourney);
		
		JLabel label_3 = new JLabel("dd-mm-yyyy");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(373, 450, 108, 13);
		contentPane.add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("24 Hr*");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_1.setBounds(406, 325, 46, 10);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblHr = new JLabel("24 Hr*");
		lblHr.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblHr.setBounds(404, 284, 46, 10);
		contentPane.add(lblHr);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_7.setColumns(10);
		textField_7.setBounds(349, 128, 225, 32);
		contentPane.add(textField_7);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(349, 169, 225, 32);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(349, 214, 225, 32);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(349, 255, 225, 32);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(349, 296, 225, 32);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(349, 335, 225, 32);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(349, 374, 225, 32);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(349, 418, 225, 32);
		contentPane.add(textField_6);
		
		JLabel lblBusNo = new JLabel("BUS NO :");
		lblBusNo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblBusNo.setBounds(33, 140, 318, 26);
		contentPane.add(lblBusNo);
		
		JLabel label_15 = new JLabel(".");
		label_15.setIcon(new ImageIcon(admin_bus.class.getResource("/pro/busback8.PNG")));
		label_15.setBounds(0, 0, 636, 513);
		contentPane.add(label_15);
	}
	}

