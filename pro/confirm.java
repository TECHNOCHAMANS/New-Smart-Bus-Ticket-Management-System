package pro;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class confirm extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					confirm frame = new confirm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	
	Connection connection=null;
	sqliteConnect s2;
	
	@SuppressWarnings("static-access")
	public confirm() {
		setTitle("SMART BUS (CONFIRM)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThankYouFor = new JLabel("THANK YOU FOR BOOKING WITH US");
		lblThankYouFor.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 16));
		lblThankYouFor.setBounds(201, 10, 224, 13);
		contentPane.add(lblThankYouFor);
		
		JLabel lblTicketConfirmed = new JLabel("TICKET CONFIRMED");
		lblTicketConfirmed.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblTicketConfirmed.setBounds(59, 45, 190, 22);
		contentPane.add(lblTicketConfirmed);
		
		String user = personal_info.Name;
		//String bn = personal_info.bn;
		JLabel lblHello = new JLabel("HELLO "+user+",");
		lblHello.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblHello.setBounds(79, 77, 170, 22);
		contentPane.add(lblHello);
		
		JLabel lblYourTicketIs = new JLabel("YOUR TICKET IS CONFIRMED.");
		lblYourTicketIs.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblYourTicketIs.setBounds(79, 109, 228, 22);
		contentPane.add(lblYourTicketIs);
		
		JLabel lblWeWillShortly = new JLabel("WE WILL SHORTLY MAIL YOUR TICKET");
		lblWeWillShortly.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblWeWillShortly.setBounds(79, 136, 291, 22);
		contentPane.add(lblWeWillShortly);
		
		JLabel lblYourTripId = new JLabel("Booking information :");
		lblYourTripId.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblYourTripId.setBounds(79, 168, 455, 22);
		contentPane.add(lblYourTripId);
		
		JLabel lblJustBooked = new JLabel("JUST BOOKED.");
		lblJustBooked.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblJustBooked.setBounds(79, 202, 104, 31);
		contentPane.add(lblJustBooked);
		
		String s = SUR_DESTI.s;
		JLabel label_2 = new JLabel(s);
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(293, 241, 56, 22);
		contentPane.add(label_2);
		
		String d = SUR_DESTI.d;
		JLabel label_3 = new JLabel(d);
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(386, 241, 56, 22);
		contentPane.add(label_3);
		
		String m = SUR_DESTI.bn;
		JLabel label_4 = new JLabel("->");
		label_4.setBounds(359, 245, 22, 16);
		contentPane.add(label_4);
		JLabel lblBusNo = new JLabel("BUS NO :"+m);
		lblBusNo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblBusNo.setBounds(79, 243, 131, 22);
		contentPane.add(lblBusNo);
		
		connection=s2.dbConnector();
		
		Button button = new Button("CONTINUE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				//retrieving data that has been stored in variables
				String m = SUR_DESTI.bn;
				String date_of_journey = SUR_DESTI.j;
				String time_of_departure = OTP.time;
				String src = SUR_DESTI.s;
				String dst = SUR_DESTI.d;
				int ppl= Integer.parseInt(SUR_DESTI.p);
				int p1 = OTP.price_per_ticket;
				int total_amt = ppl*p1;
			    String total_amt1 = Integer.toString(total_amt); 
				
				try {
					//query for the busno that is selected by user
					String query = "select * from adminbus_details where busno=?";
					java.sql.PreparedStatement pstmt = null;
					 pstmt=connection.prepareStatement(query);
					 pstmt.setString(1,m);
					 ResultSet rs =pstmt.executeQuery();
					 
					 while(rs.next()){
				            break;
						}
					 rs.close();
					 pstmt.close();
					 
					 //query to add information into databases
					 Connection conn_1 = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\NIKITA\\Downloads\\bus.sqlite");
					 String query1="insert into bookings_details(user,date_of_journey,time_of_departure,busno,src,dst,amt) values(?,?,?,?,?,?,?)";
					 java.sql.PreparedStatement pstmt1 = null;
					 pstmt1=conn_1.prepareStatement(query1);
					 pstmt1.setString(1,user);
					 pstmt1.setString(2,date_of_journey);
					 pstmt1.setString(3,time_of_departure);
					 pstmt1.setString(4,m);
					 pstmt1.setString(5,src);
					 pstmt1.setString(6,dst);
					 pstmt1.setString(7,total_amt1);
					 @SuppressWarnings("unused")
					 int v=pstmt1.executeUpdate();					 
					 
					 pstmt1.close();
					 }
					 catch(Exception e1)
					 {
					 	JOptionPane.showMessageDialog(null, e1);
						
					 }
				Tic t = new Tic();
				t.setVisible(true);
			}
		});
		
		String ppl = SUR_DESTI.p;
		JLabel lblTotalSeatsnull = new JLabel("TOTAL SEATS :"+ppl);
		lblTotalSeatsnull.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblTotalSeatsnull.setBounds(79, 275, 131, 22);
		contentPane.add(lblTotalSeatsnull);
		
		String Time = OTP.time;
		JLabel lblTime = new JLabel();
		lblTime.setText("TIME : "+Time);
		lblTime.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblTime.setBounds(293, 271, 131, 22);
		contentPane.add(lblTime);
		button.setBounds(430, 299, 104, 31);
		contentPane.add(button);
		
		Button button_1 = new Button("HOME");
		button_1.setBounds(37, 303, 104, 32);
		contentPane.add(button_1);
		
		JLabel label_1 = new JLabel(".");
		label_1.setIcon(new ImageIcon(confirm.class.getResource("/pro/wb (4).jpg")));
		label_1.setBounds(30, 29, 525, 307);
		contentPane.add(label_1);
		
		JLabel label = new JLabel(".");
		label.setIcon(new ImageIcon(confirm.class.getResource("/pro/confirm (2).jpg")));
		label.setBounds(0, 0, 586, 363);
		contentPane.add(label);
		
		
			}
}
