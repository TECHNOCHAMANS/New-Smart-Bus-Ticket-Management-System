package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Color;

@SuppressWarnings("serial")
public class admin_lg extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_lg frame = new admin_lg();
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
	public admin_lg() {
		setTitle("SMART BUS (ADMIN_FUNCTIONS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("SMART BUSES");
		lblAdmin.setFont(new Font("Palatino Linotype", Font.BOLD, 26));
		lblAdmin.setBounds(320, 39, 231, 85);
		contentPane.add(lblAdmin);
		
		JLabel label = new JLabel(".");
		label.setIcon(new ImageIcon(admin_lg.class.getResource("/pro/PHOTO-2019-08-11-22-39-55.jpg")));
		label.setBounds(58, 29, 246, 124);
		contentPane.add(label);
		
		Button button_4 = new Button("MANAGE BUS ");
		button_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		button_4.setForeground(Color.WHITE);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_bus ad = new admin_bus();
				ad.setVisible(true);
			}
		});
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(59, 226, 200, 50);
		contentPane.add(button_4);
		
		Button button_5 = new Button("MANAGE ADMIN LOGIN");
		button_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		button_5.setForeground(Color.WHITE);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				addAdmin add = new addAdmin();
				add.setVisible(true);
			}
		});
		button_5.setBackground(Color.BLACK);
		button_5.setBounds(351, 226, 200, 50);
		contentPane.add(button_5);
		
		Button button_6 = new Button("DONE");
		button_6.setFont(new Font("Dialog", Font.PLAIN, 14));
		button_6.setForeground(Color.WHITE);
		button_6.setBackground(Color.BLACK);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_6.setBounds(437, 377, 114, 38);
		contentPane.add(button_6);
		
		Button button = new Button("MAIN MENU");
		button.setFont(new Font("Dialog", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				front_page f = new front_page();
				f.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.setBounds(84, 377, 114, 38);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel(".");
		label_1.setLabelFor(this);
		label_1.setIcon(new ImageIcon(admin_lg.class.getResource("/pro/busback8.PNG")));
		label_1.setBounds(0, 0, 593, 433);
		contentPane.add(label_1);
	}
}
