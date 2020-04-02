package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Tic extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tic frame = new Tic();
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
	Connection connection=null;
	sqliteConnect s2;
	
	public Tic() {
		setTitle("SMART BUS (TICKET)\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("BUS TICKET");
		label.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(184, 40, 131, 26);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("BUS TICKET");
		label_1.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(520, 10, 120, 26);
		contentPane.add(label_1);
		
		JLabel lblDate = new JLabel("DATE      :");
		lblDate.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblDate.setBounds(128, 76, 76, 26);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("TIME      :");
		lblTime.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblTime.setBounds(128, 112, 76, 26);
		contentPane.add(lblTime);
		
		JLabel lblSrc = new JLabel("SRC        :");
		lblSrc.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblSrc.setBounds(128, 148, 76, 26);
		contentPane.add(lblSrc);
		
		JLabel lblDst = new JLabel("DST        :");
		lblDst.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblDst.setBounds(128, 184, 76, 18);
		contentPane.add(lblDst);
		
		JLabel lblDate_1 = new JLabel("DATE :");
		lblDate_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblDate_1.setBounds(455, 76, 59, 26);
		contentPane.add(lblDate_1);
		
		JLabel lblTime_1 = new JLabel("TIME :");
		lblTime_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblTime_1.setBounds(455, 112, 59, 26);
		contentPane.add(lblTime_1);
		
		JLabel lblSrc_1 = new JLabel("SRC :");
		lblSrc_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblSrc_1.setBounds(455, 148, 46, 26);
		contentPane.add(lblSrc_1);
		
		JLabel lblDst_1 = new JLabel("DST :");
		lblDst_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblDst_1.setBounds(455, 184, 46, 18);
		contentPane.add(lblDst_1);
		
		JLabel label_10 = new JLabel(".");
		label_10.setIcon(new ImageIcon(Tic.class.getResource("/pro/B1.jpg")));
		label_10.setBounds(47, 63, 60, 185);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(Tic.class.getResource("/pro/B2.jpg")));
		label_11.setBounds(439, 212, 160, 60);
		contentPane.add(label_11);
		
		JLabel lblPpl = new JLabel("AMOUNT :");
		lblPpl.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblPpl.setBounds(128, 212, 76, 18);
		contentPane.add(lblPpl);
		
		JLabel lblBusNo = new JLabel("BUS NO   :");
		lblBusNo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblBusNo.setBounds(128, 243, 76, 18);
		contentPane.add(lblBusNo);
		
		String j = SUR_DESTI.j;
		JLabel label_2 = new JLabel(j);
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_2.setBounds(231, 76, 120, 26);
		contentPane.add(label_2);
		
		String time = OTP.time;
		JLabel label_3 = new JLabel(time);
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_3.setBounds(231, 112, 120, 26);
		contentPane.add(label_3);
		
		String s = SUR_DESTI.s;
		JLabel label_4 = new JLabel(s);
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_4.setBounds(231, 148, 120, 26);
		contentPane.add(label_4);
		
		String d = SUR_DESTI.d;
		JLabel label_5 = new JLabel(d);
		label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_5.setBounds(231, 184, 120, 18);
		contentPane.add(label_5);
		
		String m = SUR_DESTI.bn;
		int ppl= Integer.parseInt(SUR_DESTI.p);
		int p1 = OTP.price_per_ticket;
		
		int mul = ppl*p1;
		String mul1 = Integer.toString(mul);
		JLabel label_6 = new JLabel(mul1);
		label_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_6.setBounds(231, 212, 120, 18);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel(m);
		label_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_7.setBounds(231, 243, 120, 18);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel(j);
		label_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_8.setBounds(509, 76, 120, 26);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel(time);
		label_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_9.setBounds(509, 112, 120, 26);
		contentPane.add(label_9);
		
		JLabel label_12 = new JLabel(s);
		label_12.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_12.setBounds(509, 148, 120, 26);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel(d);
		label_13.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_13.setBounds(509, 184, 120, 18);
		contentPane.add(label_13);
		
		JLabel lblNewLabel = new JLabel("SMART BUSES");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblNewLabel.setBounds(142, 8, 209, 33);
		contentPane.add(lblNewLabel);
		
		JLabel label_121 = new JLabel("");
		label_121.setIcon(new ImageIcon(Tic.class.getResource("/pro/B4.jpg")));
		label_121.setBounds(418, 0, 230, 300);
		contentPane.add(label_121);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(Tic.class.getResource("/pro/bw.jpg")));
		label_14.setBounds(0, 0, 416, 300);
		contentPane.add(label_14);
	}
}
