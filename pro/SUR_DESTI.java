package pro;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class SUR_DESTI extends JFrame {

	public static String bn,s,d,j,p;
	public static int Avail_seats,ppl,put,booked;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SUR_DESTI frame = new SUR_DESTI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	sqliteConnect s2;
	private JTable table;
	public static JTextField textField_4;
	

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public SUR_DESTI() {
		setTitle("SMART BUS (SOURCE-DESTINATION)");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLetsStartThe = new JLabel("LET'S START THE JOURNEY!!!!!!");
		lblLetsStartThe.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 25));
		lblLetsStartThe.setBounds(109, 125, 440, 103);
		contentPane.add(lblLetsStartThe);
		
		JLabel lblSource = new JLabel("SOURCE:");
		lblSource.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 18));
		lblSource.setBounds(67, 233, 141, 16);
		contentPane.add(lblSource);
		
		JLabel lblDestination = new JLabel("DESTINATION:");
		lblDestination.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 18));
		lblDestination.setBounds(67, 279, 167, 37);
		contentPane.add(lblDestination);
		
		JLabel lblDateOfJourney = new JLabel("DATE OF JOURNEY:");
		lblDateOfJourney.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 18));
		lblDateOfJourney.setBounds(67, 335, 231, 42);
		contentPane.add(lblDateOfJourney);
		
		JLabel lblNoOfPeople = new JLabel("NO OF PEOPLE TRAVELLING:");
		lblNoOfPeople.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 18));
		lblNoOfPeople.setBounds(67, 394, 306, 37);
		contentPane.add(lblNoOfPeople);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField.setBounds(405, 232, 189, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d = textField_1.getText();			}
		});
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_1.setBounds(405, 288, 189, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_2.setBounds(405, 344, 189, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p = textField_3.getText();
			}
		});
		textField_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_3.setBounds(405, 394, 189, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSmartBus = new JLabel("SMART BUS");
		lblSmartBus.setFont(new Font("Palatino Linotype", Font.BOLD, 26));
		lblSmartBus.setBounds(327, 47, 222, 68);
		contentPane.add(lblSmartBus);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SUR_DESTI.class.getResource("/pro/PHOTO-2019-08-11-22-39-55.jpg")));
		label.setBounds(0, 0, 248, 128);
		contentPane.add(label);
		
		connection = s2.dbConnector();
		Button btnContinue = new Button("SEARCH BUSES");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//query to add information into databases
				String query="select * from adminbus_details where src=? and dst=?";
				 java.sql.PreparedStatement pstmt = null;
				 pstmt=connection.prepareStatement(query);
				 pstmt.setString(1,textField.getText().toLowerCase());
				 pstmt.setString(2,textField_1.getText().toLowerCase());
				 ResultSet rs =pstmt.executeQuery();
				 table.setModel(DbUtils.resultSetToTableModel(rs));
				
				 p = textField_3.getText();
				 j = textField_2.getText();
				 d = textField_1.getText();
				 s = textField.getText();
					
				 rs.close();
				 pstmt.close();
				 
				 String date = textField_2.getText();
					String day = date.substring(0, 2);
					int Day =Integer.parseInt(day);
					String month = date.substring(3,5);
					int Month =Integer.parseInt(month);
					String year = date.substring(6, 10);
					int Year =Integer.parseInt(year);
					if(Day > 31 || Month > 12 || Year < 2020) {
						if(Day>31) 
							JOptionPane.showMessageDialog(null, "Invalid Day");
						else if(Month>12) 
							JOptionPane.showMessageDialog(null, "Invalid Month");
						else if(Year < 2020) 
							JOptionPane.showMessageDialog(null, "Invalid Year");
					}
					
			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e);
				
			}

			}});
		btnContinue.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 17));
		btnContinue.setBackground(Color.BLACK);
		btnContinue.setForeground(Color.WHITE);
		btnContinue.setBounds(375, 461, 231, 37);
		contentPane.add(btnContinue);
	
		table = new JTable();
		table.setBounds(684, 37, 649, 340);
		contentPane.add(table);
		
		JLabel lblBusno = new JLabel("BUS NO");
		lblBusno.setFont(new Font("Complex", Font.BOLD, 10));
		lblBusno.setBounds(686, 14, 84, 28);
		contentPane.add(lblBusno);
		
		JLabel lblEnterBusNo = new JLabel("ENTER BUS NO :");
		lblEnterBusNo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEnterBusNo.setBounds(707, 417, 167, 37);
		contentPane.add(lblEnterBusNo);
		
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(898, 423, 128, 28);
		contentPane.add(textField_4);
	
		Button button = new Button("SELECT SEATS    ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bn = textField_4.getText();
				dispose();
				busSeats b = new busSeats();
				b.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 17));
		button.setBackground(Color.BLACK);
		button.setBounds(942, 461, 203, 37);
		contentPane.add(button);
		
		JLabel lblSource_1 = new JLabel("SOURCE");
		lblSource_1.setFont(new Font("Complex", Font.BOLD, 10));
		lblSource_1.setBounds(761, 22, 59, 13);
		contentPane.add(lblSource_1);
		
		JLabel lblNewLabel = new JLabel("dd-mm-yyyy");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(405, 377, 108, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblDestination_1 = new JLabel("DESTI");
		lblDestination_1.setFont(new Font("Complex", Font.BOLD, 10));
		lblDestination_1.setBounds(866, 22, 46, 13);
		contentPane.add(lblDestination_1);
		
		JLabel lblDate = new JLabel("DOJ");
		lblDate.setFont(new Font("Complex", Font.BOLD, 10));
		lblDate.setBounds(966, 22, 46, 13);
		contentPane.add(lblDate);
		
		JLabel lblTod = new JLabel("TOD");
		lblTod.setFont(new Font("Complex", Font.BOLD, 10));
		lblTod.setBounds(1054, 22, 46, 13);
		contentPane.add(lblTod);
		
		JLabel lblTor = new JLabel("TOR");
		lblTor.setFont(new Font("Complex", Font.BOLD, 10));
		lblTor.setBounds(1150, 22, 46, 13);
		contentPane.add(lblTor);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(SUR_DESTI.class.getResource("/pro/busback8.PNG")));
		lblNewLabel_1.setBounds(0, 0, 674, 515);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Complex", Font.BOLD, 10));
		lblPrice.setBounds(1243, 22, 46, 13);
		contentPane.add(lblPrice);
	}
}
