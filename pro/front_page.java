package pro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class front_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					front_page frame = new front_page();
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
	public front_page() {
		setTitle("SMART BUS (Front Page)");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		 
		 JButton btnAdmin = new JButton("ADMIN");
		 btnAdmin.setFont(new Font("Dialog", Font.PLAIN, 14));
		 btnAdmin.setBackground(Color.BLACK);
         btnAdmin.setForeground(Color.WHITE);
		 btnAdmin.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		dispose();
		 		admin_lg a = new admin_lg();
		 		a.setVisible(true);
		 	}
		 });
		 btnAdmin.setBounds(585, 32, 119, 34);
		 contentPane.add(btnAdmin);
		 
		 JButton btnUser = new JButton("USER");
		 btnUser.setFont(new Font("Dialog", Font.PLAIN, 14));
		 btnUser.setBackground(Color.BLACK);
         btnUser.setForeground(Color.WHITE);
		 btnUser.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		dispose();
		 		personal_info p = new personal_info();
		 		p.setVisible(true);
		 	}
		 });
		 btnUser.setBounds(762, 32, 119, 34);
		 contentPane.add(btnUser);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon(front_page.class.getResource("/pro/AA.PNG")));
		 lblNewLabel.setBounds(40, 142, 517, 148);
		 contentPane.add(lblNewLabel);
		 
		 JLabel lblNewLabel_1 = new JLabel("");
		 lblNewLabel_1.setIcon(new ImageIcon(front_page.class.getResource("/pro/B.PNG")));
		 lblNewLabel_1.setBounds(404, 290, 477, 98);
		 contentPane.add(lblNewLabel_1);
		 
		 JLabel label_3 = new JLabel("");
		 label_3.setIcon(new ImageIcon(front_page.class.getResource("/pro/E.PNG")));
		 label_3.setBounds(40, 593, 464, 84);
		 contentPane.add(label_3);
		 
		 JLabel label_2 = new JLabel("");
		 label_2.setIcon(new ImageIcon(front_page.class.getResource("/pro/C.PNG")));
		 label_2.setBounds(448, 504, 433, 79);
		 contentPane.add(label_2);
		 
		 JLabel label_1 = new JLabel("");
		 label_1.setIcon(new ImageIcon(front_page.class.getResource("/pro/B.PNG")));
		 label_1.setBounds(40, 396, 431, 98);
		 contentPane.add(label_1);
		
		 JLabel label = new JLabel("");
         label.setBounds(0, -31, 251, 163);
         label.setIcon(new ImageIcon(front_page.class.getResource("/pro/PHOTO-2019-08-11-22-39-55.jpg")));
         contentPane.add(label);
         
         JLabel lblSmartBus = new JLabel("SMART BUS");
         lblSmartBus.setBounds(286, 32, 271, 49);
         lblSmartBus.setFont(new Font("Palatino Linotype", Font.BOLD, 32));
         contentPane.add(lblSmartBus);
         
         JLabel lblCnv = new JLabel("cnv");
         lblCnv.setBounds(5, 5, 919, 677);
         lblCnv.setIcon(new ImageIcon(front_page.class.getResource("/pro/FRONT.jpg")));
         contentPane.add(lblCnv);
	}
}
