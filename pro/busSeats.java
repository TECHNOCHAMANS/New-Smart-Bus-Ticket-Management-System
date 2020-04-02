package pro;

import java.awt.Button;
import pro.SUR_DESTI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class busSeats extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @return 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					busSeats frame = new busSeats();
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
	
	Connection conn=null;
	sqliteConnect s2;
	
	@SuppressWarnings("static-access")
	public busSeats() {
		setTitle("SMART BUS (SEATS SELECTION)");
		conn=s2.dbConnector();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("SMART BUS");
		label.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
		label.setBounds(419, 31, 216, 43);
		contentPane.add(label);
		
		String m = SUR_DESTI.bn;
		JLabel lblNewLabel_1 = new JLabel("BUS NO : "+m);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(55, 121, 157, 30);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox checkBox = new JCheckBox("HANDICAPPED RESERVED\r\n");
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox.setBounds(36, 536, 193, 21);
		contentPane.add(checkBox);
	
		JCheckBox checkBox_1 = new JCheckBox("1");
		checkBox_1.setBounds(167, 158, 40, 21);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("2");
		checkBox_2.setBounds(167, 182, 40, 21);
		contentPane.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("3");
		checkBox_3.setBounds(167, 470, 40, 21);
		contentPane.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("4");
		checkBox_4.setBounds(167, 493, 40, 21);
		contentPane.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("5");
		checkBox_5.setBounds(211, 158, 40, 21);
		contentPane.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("6");
		checkBox_6.setBounds(209, 182, 40, 21);
		contentPane.add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("7");
		checkBox_7.setBounds(215, 470, 40, 21);
		contentPane.add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("8");
		checkBox_8.setBounds(215, 493, 40, 21);
		contentPane.add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("9");
		checkBox_9.setBounds(261, 158, 40, 21);
		contentPane.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("10");
		checkBox_10.setBounds(261, 182, 40, 21);
		contentPane.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("11");
		checkBox_11.setBounds(261, 470, 40, 21);
		contentPane.add(checkBox_11);
		
		JCheckBox checkBox_12 = new JCheckBox("12");
		checkBox_12.setBounds(261, 493, 40, 21);
		contentPane.add(checkBox_12);
		
		JCheckBox checkBox_13 = new JCheckBox("13");
		checkBox_13.setBounds(313, 160, 40, 21);
		contentPane.add(checkBox_13);
		
		JCheckBox checkBox_15 = new JCheckBox("15");
		checkBox_15.setBounds(313, 470, 40, 21);
		contentPane.add(checkBox_15);
		
		JCheckBox checkBox_14 = new JCheckBox("14");
		checkBox_14.setBounds(313, 182, 40, 21);
		contentPane.add(checkBox_14);
		
		JCheckBox checkBox_16 = new JCheckBox("16");
		checkBox_16.setBounds(313, 493, 40, 21);
		contentPane.add(checkBox_16);
		
		JCheckBox checkBox_17 = new JCheckBox("17");
		checkBox_17.setBounds(366, 160, 40, 21);
		contentPane.add(checkBox_17);
		
		JCheckBox checkBox_18 = new JCheckBox("18");
		checkBox_18.setBounds(366, 182, 40, 21);
		contentPane.add(checkBox_18);
		
		JCheckBox checkBox_19 = new JCheckBox("19");
		checkBox_19.setBounds(366, 470, 40, 21);
		contentPane.add(checkBox_19);
		
		JCheckBox checkBox_20 = new JCheckBox("20");
		checkBox_20.setBounds(366, 493, 40, 21);
		contentPane.add(checkBox_20);
		
		JCheckBox checkBox_21 = new JCheckBox("21");
		checkBox_21.setBounds(418, 160, 40, 21);
		contentPane.add(checkBox_21);
		
		JCheckBox checkBox_22 = new JCheckBox("22");
		checkBox_22.setBounds(418, 182, 40, 21);
		contentPane.add(checkBox_22);
		
		JCheckBox checkBox_23 = new JCheckBox("23");
		checkBox_23.setBounds(418, 470, 40, 21);
		contentPane.add(checkBox_23);
		
		JCheckBox checkBox_24 = new JCheckBox("24");
		checkBox_24.setBounds(418, 493, 40, 21);
		contentPane.add(checkBox_24);
		
		JCheckBox checkBox_25 = new JCheckBox("25");
		checkBox_25.setBounds(470, 160, 40, 21);
		contentPane.add(checkBox_25);
		
		JCheckBox checkBox_26 = new JCheckBox("26");
		checkBox_26.setBounds(470, 182, 40, 21);
		contentPane.add(checkBox_26);
		
		JCheckBox checkBox_27 = new JCheckBox("27");
		checkBox_27.setBounds(470, 470, 40, 21);
		contentPane.add(checkBox_27);
		
		JCheckBox checkBox_28 = new JCheckBox("28");
		checkBox_28.setBounds(470, 493, 40, 21);
		contentPane.add(checkBox_28);
		
		JCheckBox checkBox_29 = new JCheckBox("29");
		checkBox_29.setBounds(519, 160, 40, 21);
		contentPane.add(checkBox_29);
		
		JCheckBox checkBox_30 = new JCheckBox("30");
		checkBox_30.setBounds(519, 182, 40, 21);
		contentPane.add(checkBox_30);
		
		JCheckBox checkBox_31 = new JCheckBox("31");
		checkBox_31.setBounds(519, 470, 40, 21);
		contentPane.add(checkBox_31);
		
		JCheckBox checkBox_32 = new JCheckBox("32");
		checkBox_32.setBounds(519, 493, 40, 21);
		contentPane.add(checkBox_32);
		
		JCheckBox checkBox_33 = new JCheckBox("33");
		checkBox_33.setBounds(572, 160, 40, 21);
		contentPane.add(checkBox_33);
		
		JCheckBox checkBox_34 = new JCheckBox("34");
		checkBox_34.setBounds(572, 182, 40, 21);
		contentPane.add(checkBox_34);
		
		JCheckBox checkBox_35 = new JCheckBox("35");
		checkBox_35.setBounds(572, 470, 40, 21);
		contentPane.add(checkBox_35);
		
		JCheckBox checkBox_36 = new JCheckBox("36");
		checkBox_36.setBounds(572, 493, 40, 21);
		contentPane.add(checkBox_36);
		
		JCheckBox checkBox_37 = new JCheckBox("37");
		checkBox_37.setBounds(622, 160, 40, 21);
		contentPane.add(checkBox_37);
		
		JCheckBox checkBox_38 = new JCheckBox("38");
		checkBox_38.setBounds(622, 182, 40, 21);
		contentPane.add(checkBox_38);
		
		
		JCheckBox checkBox_39 = new JCheckBox("39");
		checkBox_39.setBounds(673, 321, 40, 21);
		contentPane.add(checkBox_39);
		
		JCheckBox checkBox_40 = new JCheckBox("40");
		checkBox_40.setBounds(622, 470, 40, 21);
		contentPane.add(checkBox_40);

		JCheckBox checkBox_41 = new JCheckBox("41");
		checkBox_41.setBounds(622, 493, 40, 21);
		contentPane.add(checkBox_41);
		
		Button button = new Button("CANCEL");
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		button.setBounds(494, 532, 109, 30);
		contentPane.add(button);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setIcon(new ImageIcon(busSeats.class.getResource("/pro/bus3.PNG")));
		label_3.setBounds(115, 209, 552, 245);
		contentPane.add(label_3);
		
		Button button_1 = new Button("DONE");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.BLACK);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				payment py = new payment();
				py.setVisible(true);
				
				}
		});
		button_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		button_1.setBounds(622, 533, 90, 30);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(busSeats.class.getResource("/pro/PHOTO-2019-08-11-22-39-55.jpg")));
		lblNewLabel.setBounds(151, -5, 256, 119);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(busSeats.class.getResource("/pro/busback8.PNG")));
		label_1.setBounds(0, 0, 786, 562);
		contentPane.add(label_1);
	}
}